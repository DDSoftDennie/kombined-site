create table kombined.getting_to_know_question(
  id 					bigint 				UNSIGNED 					NOT NULL AUTO_INCREMENT,
  question 				varchar(4000) 									NOT NULL,
  
  primary key(id)
);

insert into kombined.getting_to_know_question(question)
SELECT  question
FROM    kombined.question
WHERE   question_type = 'GETTING_TO_KNOW';

create table kombined.starting_player_question(
  id 					bigint 				UNSIGNED 					NOT NULL AUTO_INCREMENT,
  question 				varchar(4000) 									NOT NULL,
  
  primary key(id)
);

insert into kombined.starting_player_question(question)
SELECT  question
FROM    kombined.question
WHERE   question_type = 'STARTING_PLAYER';

drop table kombined.question;