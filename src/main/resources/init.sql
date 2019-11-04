CREATE DATABASE example_springdata;
USE example_springdata;

CREATE TABLE employees(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first VARCHAR(255) NOT NULL,
    last VARCHAR(255) NOT NULL,
	age INT NOT NULL,
    UNIQUE(first, last)
);

INSERT INTO employees(age, first, last) VALUES
    (18, 'John',  'Smith'),
    (25, 'David',  'Fatma'),
    (30, 'Brian',  'Khan'),
    (28, 'Jeff', 'Mittal');
