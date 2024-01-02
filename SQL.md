CREATE DATABASE Humans_friends;

USE Humans_friends;

CREATE TABLE Animals(
	id INT AUTO_INCREMENT PRIMARY KEY,
    class VARCHAR(20)
);

INSERT INTO Animals (Class)
VALUES
('Pets'),
('Pack animals');

CREATE TABLE Pets(
	id INT AUTO_INCREMENT PRIMARY KEY,
    species VARCHAR (20),
    class_id INT,
    FOREIGN KEY (Class_id) REFERENCES Animals (id) ON DELETE CASCADE
);

INSERT INTO Pets (species, class_id)
VALUES
('Dogs', 1),
('Cats', 1),  
('Hamsters', 1);

CREATE TABLE Pack_animals(
	id INT AUTO_INCREMENT PRIMARY KEY,
    species VARCHAR (20),
    class_id INT,
    FOREIGN KEY (Class_id) REFERENCES Animals (id) ON DELETE CASCADE
);

INSERT INTO Pack_animals (species, class_id)
VALUES
('Horses', 2),
('Donkeys', 2),  
('Camels', 2);

CREATE TABLE Dogs(
	id INT AUTO_INCREMENT PRIMARY KEY,
    names VARCHAR (20),
    actions VARCHAR (20),
    birthdate DATE,
    species_id INT,
    FOREIGN KEY (Species_id) REFERENCES Pets (id) ON DELETE CASCADE
);

INSERT INTO Dogs (names, actions, birthdate, species_id)
VALUES
('Uchiha Itachi', "Amaterasu", "2004-01-20", 1),
('Uchiha Shisui', "Susano", "2004-02-01", 1),  
('Hatake Kakashi', "Raikiri", "2004-02-23", 1);

CREATE TABLE Cats(
	id INT AUTO_INCREMENT PRIMARY KEY,
    names VARCHAR (20),
    actions VARCHAR (20),
    birthdate DATE,
    species_id INT,
    FOREIGN KEY (Species_id) REFERENCES Pets (id) ON DELETE CASCADE
);

INSERT INTO Cats(names, actions, birthdate, species_id)
VALUES
('Tengen Uzui', "Breath of sound", "2003-01-20", 2),
('Douma', "Blood magic", "2003-02-01", 2), 
('Hashibira Inoske', "Breath of beast", "2003-02-23", 2);

CREATE TABLE Hamsters(
	id INT AUTO_INCREMENT PRIMARY KEY,
    names VARCHAR (20),
    actions VARCHAR (20),
    birthdate DATE,
    species_id INT,
    FOREIGN KEY (Species_id) REFERENCES Pets (id) ON DELETE CASCADE
);

INSERT INTO Hamsters(names, actions, birthdate, species_id)
VALUES
('Mitsuya Takashi', "action1", "2005-01-20", 3),
('Matsuno Chifuyi', "action2", "2005-02-01", 3), 
('Senju Kawaragi', "action3", "2005-02-23", 3);

CREATE TABLE Horses(
	id INT AUTO_INCREMENT PRIMARY KEY,
    names VARCHAR (20),
    actions VARCHAR (20),
    birthdate DATE,
    species_id INT,
    FOREIGN KEY (Species_id) REFERENCES Pack_animals (id) ON DELETE CASCADE
);

INSERT INTO Horses(names, actions, birthdate, species_id)
VALUES
('Zenin Toji', "taijutsu", "2002-01-20", 1),
('Zenin Maki', "cursed weapons", "2002-02-01", 1), 
('Gojo Satoru', "purple", "2002-02-23", 1);


CREATE TABLE Donkeys(
	id INT AUTO_INCREMENT PRIMARY KEY,
    names VARCHAR (20),
    actions VARCHAR (40),
    birthdate DATE,
    species_id INT,
    FOREIGN KEY (Species_id) REFERENCES Pack_animals (id) ON DELETE CASCADE
);


INSERT INTO Donkeys(names, actions, birthdate, species_id)
VALUES
('Yoruichi Shihoin', "instant step", "2001-01-20", 2),
('Kurosaki Ichigo', "tensa zangetsu", "2001-02-01", 2), 
('Urahara Kisuke', "kannonbiraki benihime aratame", "2001-02-23", 2);

CREATE TABLE Camels(
	id INT AUTO_INCREMENT PRIMARY KEY,
    names VARCHAR (20),
    actions VARCHAR (40),
    birthdate DATE,
    species_id INT,
    FOREIGN KEY (Species_id) REFERENCES Pack_animals (id) ON DELETE CASCADE
);


INSERT INTO Camels(names, actions, birthdate, species_id)
VALUES
('Camel1', "action1", "2000-01-01", 3),
('Camel2', "action2", "2000-02-02", 3), 
('Camel3', "action3", "2000-03-03", 3);

SET SQL_SAFE_UPDATES = 0;
DELETE FROM Pack_animals WHERE species = 'Camels';
DROP TABLE Camels;

SELECT names, actions, birthdate, species_id FROM Horses
UNION SELECT names, actions, birthdate, species_id FROM Donkeys;

CREATE TEMPORARY TABLE animals AS 
SELECT *, 'Dogs' as species FROM dogs
UNION SELECT *, 'Cats' AS species FROM cats
UNION SELECT *, 'Hamsters' AS species FROM Hamsters
UNION SELECT *, 'Horses' AS species FROM Horses
UNION SELECT *, 'Donkeys' AS species FROM Donkeys;
CREATE TABLE Young_animals AS
SELECT names, actions, birthdate, species, TIMESTAMPDIFF(MONTH, birthdate, CURDATE()) AS age
FROM Animals WHERE birthdate BETWEEN ADDDATE(curdate(), INTERVAL -3 YEAR) AND ADDDATE(CURDATE(), INTERVAL -1 YEAR);
SELECT * FROM Young_animals;