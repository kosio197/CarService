DROP DATABASE my_garage_db; DROP USER 'kosio'; flush privileges;

CREATE DATABASE my_garage_db
DEFAULT CHARACTER SET utf8
DEFAULT COLLATE utf8_general_ci;

USE my_garage_db;

CREATE USER 'kosio' IDENTIFIED BY 'k0510';
GRANT ALL PRIVILEGES ON my_garage_db.* TO 'kosio';

CREATE TABLE users
(
id INT AUTO_INCREMENT PRIMARY KEY,
username VARCHAR(50) NOT NULL UNIQUE,
password VARCHAR(50) NOT NULL,
role ENUM ('USER', 'SUPER_USER', 'ADMIN') DEFAULT 'USER',
first_name VARCHAR(20),
last_name VARCHAR(20),
email VARCHAR(50) UNIQUE,
last_visit_date DATE,
telephone VARCHAR(30),
days_to_event INT DEFAULT 10
);

INSERT INTO users VALUES (1, 'kosio', 'cz', 'ADMIN', 'Konstantin', 'Petrov', 'kosio197@abv.bg', 20170221, '0895 60 66 20', 10);

CREATE TABLE cars
(
id INT AUTO_INCREMENT PRIMARY KEY,
owner_id INT,
registration_plate VARCHAR(12)  UNIQUE,
marka VARCHAR(30),
model VARCHAR(30),
year_manufacture DATE,
vin VARCHAR(20),
engine_type VARCHAR(100),
current_milage INT,
last_visit_date DATE,
road_taxis_end_date DATE,
annual_check_end_date DATE,
liability_insurances_end_date DATE,
full_insurances_end_date DATE,
vinettes__end_date DATE,

CONSTRAINT fk_owner_users FOREIGN KEY (owner_id) REFERENCES users (id)
);

INSERT INTO cars VALUES (1, 1, 'C 9918 HA', 'OPEL', 'ASTRA', 20050605, 'WOL######7890987',
 '17 CDTI', 158422, 20170221,NULL,NULL,NULL,NULL,NULL);

CREATE TABLE repairs
(
id INT AUTO_INCREMENT PRIMARY KEY,
car_id INT,
repair_date DATE,
milage INT,
description TEXT,
recomendet_upcoming_repairs TEXT,

CONSTRAINT fk_repair_car FOREIGN KEY (car_id) REFERENCES cars (id)
); 
