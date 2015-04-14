
DROP DATABASE if exists UserDB;

CREATE DATABASE UserDB;
SET time_zone='-08:00';
USE UserDB;

CREATE TABLE users (
  userID int(10) primary key not null auto_increment,
  studentID varchar(10) not null,
  fname varchar(30) not null,
  lname varchar(20) not null,
  nickname varchar(20) not null,
  pw varchar(32) not null,
  major varchar(30) not null,
  yearOf int(4) not null,
  uscName varchar(10) not null
);

INSERT INTO users (studentID, fname, lname, nickname, pw, major, yearOf, uscName) VALUES (8998927235, 'Calvin', 'Leung', 'Calvin',1234, 'Computer Science', 2017, 'yuikwanl');
INSERT INTO users (studentID, fname, lname, nickname, pw, major, yearOf, uscName) VALUES (1234567890, 'Jeffrey', 'Miller', 'Miller', 1234, 'Computer Science', 2000, 'jmiller');

CREATE TABLE org (
  orgID int(5) primary key not null auto_increment,
  orgName varchar(20) not null,
  des varchar(100) not null,
  meetingTimes varchar(10),
  contact varchar(20),
  memberNo int(4),
  dues int (4),
  audience varchar(2)
);

INSERT INTO org (orgName, des, meetingTimes, contact, memberNo, dues, audience) VALUES ('ACM', 'You''re a CS student you should know! ', 'TTh 1-4pm', 'Jeffrey Miller', 100, 80, 'B');
INSERT INTO org (orgName, des, meetingTimes, contact, memberNo, dues, audience) VALUES ('IEEE', 'You''re an EE student you should know! ', 'TTh 1-4pm', 'Redekopp', 100, 80, 'B');

CREATE TABLE Stu_Org (
  userID int(10) not null,
  orgID int(5) not null,
  FOREIGN KEY fk1(userID) REFERENCES users(userID),
  FOREIGN KEY fk2(orgID) REFERENCES org(orgID)
);

INSERT INTO Stu_Org (userID, orgID) VALUES (1, 1);
INSERT INTO Stu_Org (userID, orgID) VALUES (1, 2);

CREATE TABLE announcements(
	announcementID int(10) primary key not null auto_increment,
    date_posted TIMESTAMP,
    userID int(10) not null,
	orgID int(5) not null,
    an_text varchar(500) not null,
	FOREIGN KEY fk1(userID) REFERENCES users(userID),
	FOREIGN KEY fk2(orgID) REFERENCES org(orgID)
);

INSERT INTO announcements(date_posted, userID, orgID, an_text) VALUES (NOW(), 1, 1, 'test announcements');

CREATE TABLE comments(
	commentID int(10) primary key not null auto_increment,
    date_posted TIMESTAMP,
    userID int(10) not null,
	orgID int(5) not null,
    com_text varchar(100) not null,
	FOREIGN KEY fk1(userID) REFERENCES users(userID),
	FOREIGN KEY fk2(orgID) REFERENCES org(orgID)
);

INSERT INTO comments(date_posted, userID, orgID, com_text) VALUES (NOW(), 1, 1, 'test announcements');
