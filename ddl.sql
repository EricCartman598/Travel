DROP TABLE IF EXISTS countries;
CREATE TABLE countries
(
	id 				INT PRIMARY KEY AUTO_INCREMENT, 
	name 			VARCHAR(255) NOT NULL, 
	language		VARCHAR(255),
	discriminator 	ENUM('HOT_COUNTRY', 'COLD_COUNTRY'),	
	isPolarNight	BOOLEAN,
	telephoneCode	VARCHAR(255),
	hotestMonth		VARCHAR(255),
	averageTemperature	DOUBLE	
);

DROP TABLE IF EXISTS cities;
CREATE TABLE cities
(
	id 			INT PRIMARY KEY AUTO_INCREMENT, 
	name 		VARCHAR(255) NOT NULL, 
	isCapital	BOOLEAN NOT NULL DEFAULT FALSE,
	population	INT,
	countryId	INT NOT NULL,
	FOREIGN KEY(countryId) REFERENCES countries(id)
);

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
	id 					INT PRIMARY KEY AUTO_INCREMENT, 
	firstName 			VARCHAR(255) NOT NULL, 
	lastName			VARCHAR(255) NOT NULL,
	passportSerial		VARCHAR(255) NOT NULL,
    passportNumber		VARCHAR(255) NOT NULL,	
	allIncluded			BOOLEAN NOT NULL DEFAULT FALSE,
	UserType 			ENUM('SIMPLE_USER', 'VIP_USER'),
	PhoneNumber			VARCHAR(255) NOT NULL	
);   

DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
	id 					INT PRIMARY KEY AUTO_INCREMENT,
	userId 				INT NOT NULL,
	price				DOUBLE,
	countryID			INT NOT NULL,	
	FOREIGN KEY(userId) REFERENCES users(id),
	FOREIGN KEY(countryID) REFERENCES countries(id)
);   