INSERT INTO tiridb.trailer_type ( id_trailer_type,name,version ) VALUES ( 1,'podkontenerowa',1 );
INSERT INTO tiridb.trailer_type ( id_trailer_type,name,version ) VALUES ( 2,'chłodnia',1 );
INSERT INTO tiridb.trailer_type ( id_trailer_type,name,version ) VALUES ( 3,'firanka',1 );
INSERT INTO tiridb.trailer_type ( id_trailer_type,name,version ) VALUES ( 4,'izoterma',1 );
INSERT INTO tiridb.trailer_type ( id_trailer_type,name,version ) VALUES ( 5,'plandeka',1 );
INSERT INTO tiridb.trailer_type ( id_trailer_type,name,version ) VALUES ( 6,'walking-floor',1 );

INSERT INTO tiridb.truck (ID_TRUCK, ACTIVE, EURO_STANDARD, CREATION_DATE, HORSE_POWER, MODEL, PRODUCER, PRODUCTION_YEAR, REGISTRATION_NUMBER, VERSION) VALUES (1, 1, 'EURO5', NOW(), 440, 'Magnum', 'Renault', 2014, 'WSC45AE', 1);
INSERT INTO tiridb.truck (ID_TRUCK, ACTIVE, EURO_STANDARD, CREATION_DATE, HORSE_POWER, MODEL, PRODUCER, PRODUCTION_YEAR, REGISTRATION_NUMBER, VERSION) VALUES (2, 1, 'EURO5', NOW(), 420, 'C5', 'Volvo', 2014, 'WE23433', 1);
INSERT INTO tiridb.truck (ID_TRUCK, ACTIVE, EURO_STANDARD, CREATION_DATE, HORSE_POWER, MODEL, PRODUCER, PRODUCTION_YEAR, REGISTRATION_NUMBER, VERSION) VALUES (3, 0, 'EURO3', NOW(), 420, 'ASD', 'Scania', 2009, 'WP25145', 1);
INSERT INTO tiridb.truck (ID_TRUCK, ACTIVE, EURO_STANDARD, CREATION_DATE, HORSE_POWER, MODEL, PRODUCER, PRODUCTION_YEAR, REGISTRATION_NUMBER, VERSION) VALUES (4, 1, 'EURO4', NOW(), 440, 'Magnum', 'Renault', 2016, 'WSC87SD', 1);
INSERT INTO tiridb.truck (ID_TRUCK, ACTIVE, EURO_STANDARD, CREATION_DATE, HORSE_POWER, MODEL, PRODUCER, PRODUCTION_YEAR, REGISTRATION_NUMBER, VERSION) VALUES (5, 1, 'EURO4', NOW(), 450, 'Premium', 'Renault', 2015, 'WSC23SD', 1);

INSERT INTO tiridb.role (id_role, name, version) VALUES (1, 'user', 1);
INSERT INTO tiridb.role (id_role, name, version) VALUES (2, 'admin', 1);
INSERT INTO tiridb.role (id_role, name, version) VALUES (3, 'driver', 1);

INSERT INTO tiridb.trailer (ID_TRAILER, ACTIVE, MODEL, PRODUCER, PRODUCTION_YEAR, CREATION_DATE, REGISTRATION_NUMBER, VERSION, ID_TRAILER_TYPE) VALUES (1, 1, '234', 'Wielton', 2009, NOW(), 'WE223RE', 1, 1);
INSERT INTO tiridb.trailer (ID_TRAILER, ACTIVE, MODEL, PRODUCER, PRODUCTION_YEAR, CREATION_DATE, REGISTRATION_NUMBER, VERSION, ID_TRAILER_TYPE) VALUES (2, 1, 'R-40', 'Schmidt', 2015, NOW(), 'WSC23DS', 1, 2);
INSERT INTO tiridb.trailer (ID_TRAILER, ACTIVE, MODEL, PRODUCER, PRODUCTION_YEAR, CREATION_DATE, REGISTRATION_NUMBER, VERSION, ID_TRAILER_TYPE) VALUES (3, 1, '234', 'Wielton', 2016, NOW(), 'WOT2341', 1, 3);
INSERT INTO tiridb.trailer (ID_TRAILER, ACTIVE, MODEL, PRODUCER, PRODUCTION_YEAR, CREATION_DATE, REGISTRATION_NUMBER, VERSION, ID_TRAILER_TYPE) VALUES (4, 0, '234', 'Wielton', 2016, NOW(), 'WE234ER', 1, 3);

INSERT INTO tiridb.tiri_user (ID_USER, ACTIVE, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, CREATION_DATE, MOBILE_PHONE, PASSWORD, VERSION, ID_ROLE) VALUES (1, 1, 'sierocinskipiotr@mail.com', 'Piotr', 'Sierociński', 'psierocinski', NOW(), '604908678', 'password', 1, 2);
INSERT INTO tiridb.tiri_user (ID_USER, ACTIVE, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, CREATION_DATE, MOBILE_PHONE, PASSWORD, VERSION, ID_ROLE) VALUES (2, 0, 'akowalski@mail.com', 'Adam', 'Kowalski', 'akowalski', NOW(), '132123123', 'password', 1, 1);
INSERT INTO tiridb.tiri_user (ID_USER, ACTIVE, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, CREATION_DATE, MOBILE_PHONE, PASSWORD, VERSION, ID_ROLE) VALUES (3, 1, 'jannowak@mail.com', 'Jan', 'Nowak', 'jnowak', NOW(), '132123123', 'password', 1, 3);
INSERT INTO tiridb.tiri_user (ID_USER, ACTIVE, EMAIL, FIRST_NAME, LAST_NAME, LOGIN, CREATION_DATE, MOBILE_PHONE, PASSWORD, VERSION, ID_ROLE) VALUES (4, 1, 'jaroslawnowicki@mail.com', 'Jarosław', 'Nowicki', 'jnowicki', NOW(), '132123123', 'password', 1, 3);

INSERT INTO tiridb.squad (ID_SQUAD, ACTIVE, CREATION_DATE, VERSION, ID_TRUCK, ID_TRAILER, ID_USER) VALUES (1, 1, NOW(), 1, 3, 2, 3);
INSERT INTO tiridb.squad (ID_SQUAD, ACTIVE, CREATION_DATE, VERSION, ID_TRUCK, ID_TRAILER, ID_USER) VALUES (2, 0, NOW(), 1, 2, 2, 3);
INSERT INTO tiridb.squad (ID_SQUAD, ACTIVE, CREATION_DATE, VERSION, ID_TRUCK, ID_TRAILER, ID_USER) VALUES (3, 1, NOW(), 1, 1, 2, 4);
INSERT INTO tiridb.squad (ID_SQUAD, ACTIVE, CREATION_DATE, VERSION, ID_TRUCK, ID_TRAILER, ID_USER) VALUES (4, 0, NOW(), 1, 5, 3, 3);


INSERT INTO tiridb.route_status (id_route_status, name) VALUES (1, 'tankowanie');
INSERT INTO tiridb.route_status (id_route_status, name) VALUES (2, 'załadunek');
INSERT INTO tiridb.route_status (id_route_status, name) VALUES (3, 'rozładunek');
INSERT INTO tiridb.route_status (id_route_status, name) VALUES (4, 'inny');

INSERT INTO tiridb.route (id_route, weight_of_cargo, AMOUNT_OF_FUEL, ODOMETER, ROUTE_DATE, ID_SQUAD, ID_ROUTE_STATUS) values (1, 0, 900, 5000, '2017-01-01 00:00:00', 3, 1);
INSERT INTO tiridb.route (id_route, weight_of_cargo, AMOUNT_OF_FUEL, ODOMETER, ROUTE_DATE, ID_SQUAD, ID_ROUTE_STATUS) values (2, 0, 950, 7000, '2017-01-14 00:00:00', 3, 1);
INSERT INTO tiridb.route (id_route, weight_of_cargo, AMOUNT_OF_FUEL, ODOMETER, ROUTE_DATE, ID_SQUAD, ID_ROUTE_STATUS) values (3, 0, 800, 9000, '2017-01-21 00:00:00', 3, 1);
INSERT INTO tiridb.route (id_route, weight_of_cargo, AMOUNT_OF_FUEL, ODOMETER, ROUTE_DATE, ID_SQUAD, ID_ROUTE_STATUS) values (4, 0, 800, 11500, '2017-02-01 00:00:00', 3, 1);
INSERT INTO tiridb.route (id_route, weight_of_cargo, AMOUNT_OF_FUEL, ODOMETER, ROUTE_DATE, ID_SQUAD, ID_ROUTE_STATUS) values (5, 0, 850, 13000, '2017-02-07 00:00:00', 3, 1);
INSERT INTO tiridb.route (id_route, weight_of_cargo, AMOUNT_OF_FUEL, ODOMETER, ROUTE_DATE, ID_SQUAD, ID_ROUTE_STATUS) values (6, 0, 770, 15200, '2017-02-09 00:00:00', 3, 1);
INSERT INTO tiridb.route (id_route, weight_of_cargo, AMOUNT_OF_FUEL, ODOMETER, ROUTE_DATE, ID_SQUAD, ID_ROUTE_STATUS) values (7, 0, 820, 17000, '2017-02-21 00:00:00', 3, 1);
INSERT INTO tiridb.route (id_route, weight_of_cargo, AMOUNT_OF_FUEL, ODOMETER, ROUTE_DATE, ID_SQUAD, ID_ROUTE_STATUS) values (8, 0, 0, 15205, '2017-02-09 00:00:00', 1, 2);
INSERT INTO tiridb.route (id_route, weight_of_cargo, AMOUNT_OF_FUEL, ODOMETER, ROUTE_DATE, ID_SQUAD, ID_ROUTE_STATUS) values (9, 0, 0, 17007, '2017-02-21 00:00:00', 1, 3);






