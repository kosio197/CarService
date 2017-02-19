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

INSERT INTO users VALUES (1, 'kosio', 'cz', 'ADMIN', 'Konstantin', 'Petrov', 'kosio197@abv.bg', NULL, '0895 60 66 20', 10);

CREATE TABLE pictures
(
id INT AUTO_INCREMENT PRIMARY KEY,
picture LONGBLOB
);

CREATE TABLE parts
(
id INT AUTO_INCREMENT PRIMARY KEY,
article VARCHAR(255),
mark VARCHAR(255),
cat_number varchar(255),
pieces INT,
price DOUBLE
);

CREATE TABLE repairs
(
id INT AUTO_INCREMENT PRIMARY KEY,
repair_date DATE,
milage INT,
description TEXT,
recomendet_upcoming_repairs TEXT
); 

CREATE TABLE repairs_parts
(
repair_id INT,
part_id INT
);

CREATE TABLE repairs_pictures
(
repair_id INT,
picture_id INT
);

CREATE TABLE car_fluids
(
id INT AUTO_INCREMENT PRIMARY KEY,
change_date DATE,
milage INT,
fluid_type VARCHAR(100)
);

CREATE TABLE car_belts
(
id INT AUTO_INCREMENT PRIMARY KEY,
change_date DATE,
milage INT,
belt_type VARCHAR(100)
);

CREATE TABLE cars
(
id INT AUTO_INCREMENT PRIMARY KEY,
owner_id INT,
pictures_id INT,
registration_plate VARCHAR(12)  UNIQUE,
marka VARCHAR(30),
model VARCHAR(30),
year_manufacture DATE,
engine_type VARCHAR(100),
current_milage INT,

road_taxis_end_date DATE,
annual_check_end_date DATE,
liability_insurances_end_date DATE,
full_insurances_end_date DATE,
vinettes__end_date DATE,

engine_oil_id INT,
transmision_oil_id INT,
differential_oil_id INT,
hidravlic_oil_id INT,
break_fluid_id INT,
antifreeze_id INT,
refrigerant_id INT,

timing_belt_id INT,

CONSTRAINT fk_owner_id_users FOREIGN KEY (owner_id) REFERENCES users (id),

CONSTRAINT fk_engine_oil_id_car_fluids FOREIGN KEY (engine_oil_id) REFERENCES car_fluids (id),
CONSTRAINT fk_transmision_oil_id_car_fluids FOREIGN KEY (transmision_oil_id) REFERENCES car_fluids (id),
CONSTRAINT fk_differential_oil_id_car_fluids FOREIGN KEY (differential_oil_id) REFERENCES car_fluids (id),
CONSTRAINT fk_hidravlic_oil_id_car_fluids FOREIGN KEY (hidravlic_oil_id) REFERENCES car_fluids (id),
CONSTRAINT fk_break_fluid_id_car_fluids FOREIGN KEY (break_fluid_id) REFERENCES car_fluids (id),
CONSTRAINT fk_antifreeze_id_car_fluids FOREIGN KEY (antifreeze_id) REFERENCES car_fluids (id),
CONSTRAINT fk_refrigerant_id_car_fluids FOREIGN KEY (refrigerant_id) REFERENCES car_fluids (id),

CONSTRAINT fk_timing_belt_id_car_belts FOREIGN KEY (timing_belt_id) REFERENCES car_belts (id)
);

CREATE TABLE cars_car_belts
(
car_id INT,
car_belts_id INT
);

CREATE TABLE cars_repairs
(
car_id INT,
repair_id INT
);

