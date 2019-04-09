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
