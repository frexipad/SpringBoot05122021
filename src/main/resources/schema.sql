DROP TABLE IF EXISTS USER;
CREATE TABLE USER(
  ID BIGINT NOT NULL AUTO_INCREMENT,
  FIRST_NAME VARCHAR(255) NOT NULL,
  LAST_NAME VARCHAR(255) NOT NULL ,
  EMAIL VARCHAR(255) NOT NULL ,
  AGE INTEGER NOT NULL,
  PRIMARY KEY (ID)
);