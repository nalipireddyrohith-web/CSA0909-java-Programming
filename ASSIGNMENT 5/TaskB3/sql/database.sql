CREATE DATABASE IF NOT EXISTS csa09_assignment5;
USE csa09_assignment5;

DROP TABLE IF EXISTS bus_pass;

CREATE TABLE bus_pass (
    pass_id VARCHAR(30) PRIMARY KEY,
    reg_no VARCHAR(30) NOT NULL,
    name VARCHAR(100) NOT NULL,
    route_no INT NOT NULL,
    amount DECIMAL(10,2) NOT NULL
);
