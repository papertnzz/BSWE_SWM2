-- user
CREATE TABLE USERS (
	id varchar(255) PRIMARY KEY,
	username varchar(255) not null UNIQUE
);

INSERT INTO USERS (id, username) VALUES ('81150016-8501-4b97-9168-01113e21d8a5', 'User 001');
INSERT INTO USERS (id, username) VALUES ('d891323f-a3ad-4a95-b340-2e1c8aa8d1bd', 'User 002');
