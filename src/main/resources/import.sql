INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME) VALUES (1, 'linda', 'linda123', 'Linda', 'Szasz');
INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME)
VALUES (2, 'linda_p', 'linda123', 'Linda', 'Szasz');

INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME) VALUES (3, 'dan', 'dan123', 'Daniel', 'Albulescu');
INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME)
VALUES (4, 'dan_p', 'dan123', 'Daniel', 'Albulescu');

INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME)
VALUES (5, 'emilia', 'emilia123', 'Emilia', 'Oancea');
INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME)
VALUES (6, 'emilia_p', 'emilia123', 'Emilia', 'Oancea');

INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME) VALUES (7, 'alin', 'alin123', 'Alin', 'Popa');
INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME) VALUES (8, 'alin_p', 'alin123', 'Alin', 'Popa');

INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME)
VALUES (9, 'monica', 'monica123', 'Monica', 'Valcu');
INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME)
VALUES (10, 'monica_p', 'monica123', 'Monica', 'Valcu');

INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME)
VALUES (11, 'raluca', 'raluca123', 'Raluca', 'Mihalcea');
INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME)
VALUES (12, 'raluca_p', 'raluca123', 'Raluca', 'Mihalcea');

INSERT INTO T_USER (ID, USERNAME, `PASSWORD`, FIRST_NAME, LAST_NAME) VALUES (13, 'tomita', 'tomita123', 'Toma', 'Toma');

INSERT INTO T_SPOT (ID, SPOT_NUMBER, FLOOR) VALUES (1, 1, 0);
INSERT INTO T_ASSIGNMENT (ID, USER_ID, SPOT_ID) VALUES (1, 2, 1);

INSERT INTO T_SPOT (ID, SPOT_NUMBER, FLOOR) VALUES (2, 2, 0);
INSERT INTO T_ASSIGNMENT (ID, USER_ID, SPOT_ID) VALUES (2, 4, 2);

INSERT INTO T_SPOT (ID, SPOT_NUMBER, FLOOR) VALUES (3, 3, 0);
INSERT INTO T_ASSIGNMENT (ID, USER_ID, SPOT_ID) VALUES (3, 6, 3);

INSERT INTO T_SPOT (ID, SPOT_NUMBER, FLOOR) VALUES (4, 4, 0);
INSERT INTO T_ASSIGNMENT (ID, USER_ID, SPOT_ID) VALUES (4, 8, 4);

INSERT INTO T_SPOT (ID, SPOT_NUMBER, FLOOR) VALUES (5, 5, 0);
INSERT INTO T_ASSIGNMENT (ID, USER_ID, SPOT_ID) VALUES (5, 10, 5);

INSERT INTO T_SPOT (ID, SPOT_NUMBER, FLOOR) VALUES (6, 6, 0);
INSERT INTO T_ASSIGNMENT (ID, USER_ID, SPOT_ID) VALUES (6, 12, 6);

INSERT INTO T_SPOT (ID, SPOT_NUMBER, FLOOR) VALUES (7, 7, 0);
INSERT INTO T_ASSIGNMENT (ID, USER_ID, SPOT_ID) VALUES (7, 13, 7);