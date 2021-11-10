CREATE DATABASE if not exists AMVDB CHARACTER SET utf8 COLLATE utf8_general_ci;

USE AMVDB;

create table if not exists USER(
    USER_ID int UNIQUE auto_increment not NULL,
    Fname varchar(255) not NULL,
    Lname varchar(255) not NULL,
	Phone varchar(255),
	Username varchar (255) UNIQUE not NULL,
    Password varchar(255) not NULL,
    IsActive boolean,
    PRIMARY KEY (USER_ID)
    );
	

create table if not exists TOOL(
	TOOL_ID int UNIQUE auto_increment,
	Tool_Name varchar(255),
	Tool_Info varchar(255),
	Price int not NULL,
	IsActive boolean,
	PRIMARY KEY (TOOL_ID)
	);

create table if not exists BOOKING(
	BOOKING_ID int UNIQUE auto_increment not NULL,
	StartDate DATE not NULL,
	EndDate DATE not NULL,
	Cmnt varchar(255),
	IsDelivered boolean,
	TotalPrice int,
	USER_ID int not NULL,
	TOOL_ID int not NULL,
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
	USER_ID int not NULL,
	COURSE_ID int not NULL,
	Expiry_Date DATE,
	PRIMARY KEY (USER_ID, COURSE_ID),
	FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID),
	FOREIGN KEY (COURSE_ID) REFERENCES COURSE(COURSE_ID)
	);
	
create table if not exists UNION_MEMBER(
	USER_ID int not NULL,
	PRIMARY KEY (USER_ID),
	FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)
	);
	
create table if not exists ADMIN(	
	USER_ID int not NULL,
	PRIMARY KEY (USER_ID),
	FOREIGN KEY (USER_ID) REFERENCES USER(USER_ID)
	);

create table if not exists  FILE(
    FILE_ID int UNIQUE auto_increment not NULL,
    File_Name varchar (255) not null,
    File_Content LONGBLOB not null,
    ContentType varchar (255) not null,
    TOOL_ID int not null,
    PRIMARY KEY (FILE_ID),
    FOREIGN KEY (TOOL_ID) REFERENCES TOOL(TOOL_ID)
);

create table if not exists ROLE (
                                    Rolename varchar (255) UNIQUE not null,
                                    PRIMARY KEY (Rolename)
);

create table if not exists USER_ROLE(
                                        Username varchar (255) not null,
                                        Rolename varchar (255) not null,
                                        PRIMARY KEY (Username, Rolename),
                                        FOREIGN KEY (Username) REFERENCES USER(Username),
                                        FOREIGN KEY (Rolename) REFERENCES ROLE(Rolename)
);



