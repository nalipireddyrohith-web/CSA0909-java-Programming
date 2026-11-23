CREATE DATABASE IF NOT EXISTS csa09_assignment5_security;
USE csa09_assignment5_security;

DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id VARCHAR(50) PRIMARY KEY,
    pwd VARCHAR(100) NOT NULL
);

INSERT INTO users(id, pwd) VALUES
('student1', 'java123'),
('student2', 'pass456');
