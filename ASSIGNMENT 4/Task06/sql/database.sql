CREATE DATABASE IF NOT EXISTS campus_events;
USE campus_events;
CREATE TABLE IF NOT EXISTS registrations (
 id INT PRIMARY KEY AUTO_INCREMENT,
 student_id VARCHAR(30) NOT NULL,
 student_name VARCHAR(100) NOT NULL,
 event_name VARCHAR(100) NOT NULL,
 department VARCHAR(100) NOT NULL,
 UNIQUE KEY unique_registration (student_id,event_name)
);
INSERT INTO registrations(student_id,student_name,event_name,department) VALUES
('192425115','Nalipi Reddy Rohith','Tech Fest','CSE'),
('192425116','Sample Student','Sports Meet','ECE');
