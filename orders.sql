DROP TABLE IF EXISTS orders;
CREATE TABLE orders
(
	id 					INT PRIMARY KEY AUTO_INCREMENT,
	userId 				INT NOT NULL,
	price				DOUBLE,
	countriesID			ARRAY,	
	FOREIGN KEY(userId) REFERENCES users(id)
);   