# spring-boot-app
phone-book
---
Simple spring-boot application
---
User can register and crete phone contacts. He can also edit and delete them.
----
Technologies: Spring MVC, Spring Boot, jsp, Hibernate, JPA, JUnit, Mockito, Bootstrap

SQL script for MySql database
-
```

CREATE TABLE contacts
(
	contact_id  INTEGER auto_increment,
	user_id  INTEGER NOT NULL,
	name  CHAR(18) NOT NULL,
	surname  CHAR(18) NULL,
	middlename  CHAR(18) NULL,
	homephone  CHAR(18) NULL,
	mobilephone  CHAR(18) NOT NULL,
	workphone  CHAR(18) NULL,
	address  CHAR(40) NULL,
	PRIMARY KEY (contact_id)
)
;



CREATE TABLE users
(
	user_id  INTEGER auto_increment,
	name  TEXT NOT NULL,
	surname  CHAR(18) NULL,
	middlename  CHAR(18) NULL,
	phone  CHAR(12) NOT NULL,
	homephone  CHAR(18) NULL,
	email  CHAR(18) NULL,
	login  VARCHAR(30) NOT NULL,
	password  VARCHAR(50) NOT NULL,
	address  CHAR(18) NULL,
	PRIMARY KEY (user_id)
	
)
;



ALTER TABLE contacts
	ADD FOREIGN KEY R_1 (user_id) REFERENCES users(user_id)
;




```
