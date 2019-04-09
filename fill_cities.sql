INSERT INTO cities (name, countryId) VALUES ('Vashington', SELECT id FROM countries WHERE name='USA');
INSERT INTO cities (name, countryId) VALUES ('New-York', SELECT id FROM countries WHERE name='USA');
INSERT INTO cities (name, countryId) VALUES ('Los-Angeles', SELECT id FROM countries WHERE name='USA');
INSERT INTO cities (name, countryId) VALUES ('Chicago', SELECT id FROM countries WHERE name='USA');
INSERT INTO cities (name, countryId) VALUES ('Livov', SELECT id FROM countries WHERE name='Ukraine');
INSERT INTO cities (name, countryId) VALUES ('Kiev', SELECT id FROM countries WHERE name='Ukraine');
INSERT INTO cities (name, countryId) VALUES ('Odessa', SELECT id FROM countries WHERE name='Ukraine');
INSERT INTO cities (name, countryId) VALUES ('Moscow', SELECT id FROM countries WHERE name='Russia');
INSERT INTO cities (name, countryId) VALUES ('Novosibirsk', SELECT id FROM countries WHERE name='Russia');
INSERT INTO cities (name, countryId) VALUES ('Omsk', SELECT id FROM countries WHERE name='Russia');
INSERT INTO cities (name, countryId) VALUES ('Spb', SELECT id FROM countries WHERE name='Russia');

