DROP DATABASE example_springdata;
CREATE DATABASE example_springdata;
USE example_springdata;

CREATE TABLE employers(
     id INT PRIMARY KEY AUTO_INCREMENT,
     name VARCHAR(255) NOT NULL
);

CREATE TABLE employees(
	id INT PRIMARY KEY AUTO_INCREMENT,
    first VARCHAR(255) NOT NULL,
    last VARCHAR(255) NOT NULL,
	age INT NOT NULL,
	level INT,
	salary NUMERIC,
	employer_id INT REFERENCES employers(id) ON UPDATE SET NULL,
    UNIQUE(first, last)
);

INSERT INTO employers(id, name) VALUES
(1, 'Objectway'),
(2, 'Google');

INSERT INTO employees(age, first, last, level, salary, employer_id) VALUES
    (18, 'John',  'Smith', 8, 8000, 1),
    (25, 'David',  'Fatma', 5, 12000, 2),
    (30, 'Brian',  'Khan', null, null, null),
    (28, 'Jeff', 'Mittal', 1, 1000, 2);

