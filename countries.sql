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
	averageTemperature	DOUBLE,
	ordersID		ARRAY
);