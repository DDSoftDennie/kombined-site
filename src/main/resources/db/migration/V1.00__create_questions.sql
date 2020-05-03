create schema if not exists kombined;

create table kombined.question(
  id 					bigint 				UNSIGNED 					NOT NULL AUTO_INCREMENT,
  question_type 		varchar(255) 									NOT NULL,
  question 				varchar(4000) 									NOT NULL,
  
  primary key(id)
);