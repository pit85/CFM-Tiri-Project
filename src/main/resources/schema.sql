
CREATE TABLE role (
  id_role bigint(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  version bigint(11) DEFAULT NULL,
  PRIMARY KEY (id_role)
) ;

CREATE TABLE squad (
  id_squad bigint(11) NOT NULL AUTO_INCREMENT,
  active bit(1) DEFAULT NULL,
  creation_date datetime DEFAULT NULL,
  version bigint(11) DEFAULT NULL,
  id_trailer bigint(11) NOT NULL,
  id_truck bigint(11) NOT NULL,
  id_user bigint(11) NOT NULL,
  PRIMARY KEY (id_squad)
) ;

CREATE TABLE tiri_user (
  id_user bigint(11) NOT NULL AUTO_INCREMENT,
  active bit(1) NOT NULL,
  creation_date datetime DEFAULT NULL,
  email varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  first_name varchar(50) COLLATE utf8_polish_ci NOT NULL,
  last_name varchar(100) COLLATE utf8_polish_ci NOT NULL,
  login varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  mobile_phone varchar(20) COLLATE utf8_polish_ci NOT NULL,
  password varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  version bigint(11) DEFAULT NULL,
  id_role bigint(11) DEFAULT NULL,
  PRIMARY KEY (id_user)
) ;

CREATE TABLE trailer (
  id_trailer bigint(11) NOT NULL AUTO_INCREMENT,
  active bit(1) NOT NULL,
  creation_date datetime DEFAULT NULL,
  model varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  producer varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  production_year bigint(11) NOT NULL,
  registration_number varchar(15) COLLATE utf8_polish_ci NOT NULL,
  version bigint(11) DEFAULT NULL,
  id_trailer_type bigint(11) DEFAULT NULL,
  PRIMARY KEY (id_trailer)
) ;

CREATE TABLE trailer_type (
  id_trailer_type bigint(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  version bigint(11) DEFAULT NULL,
  PRIMARY KEY (id_trailer_type)
) ;

CREATE TABLE truck (
  id_truck bigint(11) NOT NULL AUTO_INCREMENT,
  active bit(1) NOT NULL,
  creation_date datetime DEFAULT NULL,
  euro_standard varchar(10) COLLATE utf8_polish_ci NOT NULL,
  horse_power bigint(11) NOT NULL,
  model varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  producer varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  production_year int(11) NOT NULL,
  registration_number varchar(15) COLLATE utf8_polish_ci NOT NULL,
  version bigint(11) DEFAULT NULL,
  PRIMARY KEY (id_truck)
) ;

CREATE TABLE route_status (
  id_route_status bigint(11) NOT NULL AUTO_INCREMENT,
  name varchar(255) COLLATE utf8_polish_ci DEFAULT NULL,
  version bigint(11) DEFAULT NULL,
  PRIMARY KEY (id_route_status)
) ;

CREATE TABLE route (
id_route bigint(20) NOT NULL,
amount_of_fuel int(11) DEFAULT NULL,
weight_of_cargo int(11) DEFAULT NULL,
odometer int(11) NOT NULL,
route_date datetime NOT NULL,
id_squad bigint(20) NOT NULL,
id_route_status bigint(20) NOT NULL,
PRIMARY KEY (id_route)
) ;

