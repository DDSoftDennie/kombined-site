create table kombined.getting_to_know_question(
  id 					IDENTITY 			NOT NULL PRIMARY KEY,
  question 				varchar(4000) 		NOT NULL,
);

insert into kombined.getting_to_know_question(question)
SELECT  question
FROM    kombined.question
WHERE   question_type = 'GETTING_TO_KNOW';

create table kombined.starting_player_question(
  id 					IDENTITY 			NOT NULL PRIMARY KEY,
  question 				varchar(4000) 		NOT NULL,
);

insert into kombined.starting_player_question(question)
SELECT  question
FROM    kombined.question
WHERE   question_type = 'STARTING_PLAYER';

drop table kombined.question;