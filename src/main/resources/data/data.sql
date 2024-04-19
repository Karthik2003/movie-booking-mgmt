CREATE TABLE IF NOT EXISTS screen (id INT NOT NULL, name VARCHAR(255), area VARCHAR(255), city VARCHAR(255), rows INT, columns INT, capacity INT, PRIMARY KEY (id));
CREATE SEQUENCE "BOOKING_SEQ" MINVALUE 1 MAXVALUE 999999999 INCREMENT BY 1 START WITH 90001 NOCACHE NOCYCLE;
CREATE TABLE IF NOT EXISTS booking (id BIGINT NOT NULL DEFAULT NEXT VALUE FOR BOOKING_SEQ, screenId INT NOT NULL, date DATE, seatsBooked INT NOT NULL, active BOOLEAN, PRIMARY KEY (id), FOREIGN KEY (screenId) REFERENCES screen(id));
INSERT INTO `screen` (`id`,`name`,`area`,`city`,`rows`,`columns`,`capacity`)
VALUES
(50001,'PVR','T Nagar','Chennai',8,10,80),
(50002,'AGS','KK Nagar','Chennai',10,10,100),
(50003,'PVR','Haralur','Bengaluru',7,10,70),
(50004,'Sathyam Cinemas','T Nagar','Chennai',10,9,90),
(50005,'AGS','KK Nagar','Chennai',10,6,60),
(50006,'Urvashi Cinemas','Coxtown','Bengaluru',10,6,60),
(50007,'Lido','Ulsoor','Bengaluru',8,8,64),
(50008,'Lido','Ulsoor','Bengaluru',9,9,81),
(50009,'Lido','Ulsoor','Bengaluru',10,10,100),
(50010,'Lido','Ulsoor','Bengaluru',9,10,90),
(50011,'Sangam Cinemas','Nungambakkam','Chennai',7,10,70),
(50012,'Sangam Cinemas','Nungambakkam','Chennai',8,10,80),
(50013,'Sangam Cinemas','Nungambakkam','Chennai',10,9,90),
(50014,'Sangam Cinemas','Nungambakkam','Chennai',8,10,80),
(50015,'Gopalan Cinemas','Brookfields','Bengaluru',9,10,90);
INSERT INTO `booking` (`screenId`,`date`,`seatsBooked`,`active`)
VALUES
('50001','2024-04-14',8,true),
('50001','2024-04-14',10,true),
('50001','2024-04-14',22,true),
('50001','2024-04-14',8,false),
('50001','2024-04-14',8,true),
('50001','2024-04-14',10,true);