create schema if not exists kombined;

create table kombined.question(
  id 					IDENTITY 			NOT NULL PRIMARY KEY,
  question_type 		varchar(255) 		NOT NULL,
  question 				varchar(4000) 		NOT NULL,
  
);