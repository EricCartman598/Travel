DROP TABLE IF EXISTS users;
CREATE TABLE users
(
	id 					INT PRIMARY KEY AUTO_INCREMENT, 
	firstName 			VARCHAR(255) NOT NULL, 
	lastName			VARCHAR(255) NOT NULL,
	passportSerial		VARCHAR(255) NOT NULL,
    passportNumber		VARCHAR(255) NOT NULL,
	orderId				ARRAY,
	allIncluded			BOOLEAN NOT NULL DEFAULT FALSE,
	UserType 			ENUM('SIMPLE_USER', 'VIP_USER'),
	PhoneNumber			VARCHAR(255) NOT NULL,
	--FOREIGN KEY(orderId) REFERENCES orders(id)
);   