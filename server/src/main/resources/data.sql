insert into Agency (name)  VALUES ('Apside TOP');
insert into Agency (name)  VALUES ('Apside Bordeaux');

insert into Person (firstName, lastName, email, agency_id) values ('John', 'Doe', 'john.doe@apside.fr', 1);
insert into Person (firstName, lastName, email, agency_id) values ('Jane', 'Doe', 'jane.doe@apside.fr', 2);
insert into Person (firstName, lastName, email, agency_id) values ('Christophe', 'Jollivet', 'jollivet@apside.fr', 1);
insert into Person (firstName, lastName, email, agency_id) values ('Mickael', 'Debonnaire', 'debonnaire@apside.fr', 1);
insert into Person (firstName, lastName, email, agency_id) values ('DELETE_ME', 'DELETE_ME', 'DELETE_ME@apside.fr', 1);

insert into Training(name, description, repositoryUrl, level) values ('Angular JS', '3 days training to AngularJS', 'http://repo.apside.fr/angularjs', 'BEGINNER');
insert into Training(name, description, repositoryUrl, level) values ('Java', '5 days basic training to Java for beginner', 'http://repo.apside.fr/javaBeginner', 'BEGINNER');
insert into Training(name, description, repositoryUrl, level) values ('Unit Test', '1 day training about unit Test in Java', 'http://repo.apside.fr/unitTest', 'INTERMEDIATE');

INSERT INTO Training_Agency (Agency_ID, Training_ID) VALUES (1, 1);
INSERT INTO Training_Agency (Agency_ID, Training_ID) VALUES (1, 2);
INSERT INTO Training_Agency (Agency_ID, Training_ID) VALUES (2, 3);

INSERT INTO Session(training_id, date, location) values(1, NOW(), 'Tours');
INSERT INTO Session(training_id, date, location) values(1, NOW(), 'Rennes');

INSERT INTO Session_Coach (Session_ID, Coach_ID) VALUES (1, 1);
INSERT INTO Session_Coach (Session_ID, Coach_ID) VALUES (2, 2);

INSERT INTO Session_Attendee (Session_ID, Attendee_ID) VALUES (1, 3);
INSERT INTO Session_Attendee (Session_ID, Attendee_ID) VALUES (2, 4);
