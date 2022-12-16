BEGIN TRANSACTION;

DROP TABLE IF EXISTS dose, dose_user_data_join, blood_sugar, blood_sugar_user_data_join, insulin, insulin_data, insulin_information, insulin_data_join, insulin_user_data_join, meals, meals_user_join, user_data, users CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id, seq_insulin_id, seq_meal_id, seq_blood_sugar_id, seq_dose_id CASCADE;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
CREATE SEQUENCE seq_insulin_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
CREATE SEQUENCE seq_meal_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
CREATE SEQUENCE seq_blood_sugar_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
CREATE SEQUENCE seq_dose_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
CREATE TABLE users (
user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
username varchar(255) NOT NULL UNIQUE,
password_hash varchar(200) NOT NULL,
role varchar(50) NOT NULL,

CONSTRAINT PK_user PRIMARY KEY (user_id)
);
-- insulin type
-- a1c (measure of how much blood cells coated with sugar (percentage to tenths))
-- sugar remains on blood cells for three months measure of average blood sugar (user input)
CREATE TABLE user_data (
user_id int NOT NULL PRIMARY KEY,
a1c decimal(4, 2),
fasting_glucose int,
diabetes_type int,
user_age int,
last_updated TIMESTAMP DEFAULT CURRENT_DATE,
weight int,
height int,
activity_level varchar(16),
emergency_contact_1 varchar(32),
emergency_contact_2 varchar(32),
profile_pic BYTEA,
-- bmi (weight/height)**2 calc on server

CONSTRAINT FK_user_data_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);
CREATE TABLE insulin_information (
insulin_brand_name varchar(32) NOT NULL PRIMARY KEY,
insulin_type varchar(32) NOT NULL,
half_life int, --minutes
onset_low int, --display information for when to check blood sugar
onset_high int,
peak int,
duration int
);
CREATE TABLE insulin (
insulin_id int DEFAULT nextval('seq_insulin_id'::regclass) NOT NULL unique,
base_level decimal(10,3),
avg_level decimal(10,3),
time_last_dose TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
insulin_brand_name varchar(32),
insulin_strength varchar(32),
insulin_ratio decimal(3,2) NOT NULL,

CONSTRAINT FK_insulin_insulin_information FOREIGN KEY (insulin_brand_name) REFERENCES insulin_information(insulin_brand_name)
);
CREATE TABLE insulin_user_data_join (
user_id int,
insulin_id int,

CONSTRAINT PK_insulin_user_data_join PRIMARY KEY (user_id, insulin_id),
CONSTRAINT FK_insulin_user_data_join_insulin FOREIGN KEY (insulin_id) REFERENCES insulin(insulin_id),
CONSTRAINT FK_insulin_user_data_join_user_data FOREIGN KEY (user_id) REFERENCES user_data(user_id)
);
CREATE TABLE meals (
meal_id int DEFAULT nextval('seq_meal_id'::regclass) NOT NULL unique,
carbs int NOT NULL,
food varchar (32),
glycemic_index int, --FDA API
meal_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE meals_user_join (
meal_id int NOT NULL,
user_id int NOT NULL,

CONSTRAINT PK_meals_user_join PRIMARY KEY (meal_id, user_id),
CONSTRAINT FK_meals_user_join_user_data FOREIGN KEY (user_id) REFERENCES user_data(user_id),
CONSTRAINT FK_meals_user_join_meals FOREIGN KEY (meal_id) REFERENCES meals(meal_id)
);
CREATE TABLE blood_sugar (
blood_sugar_id int DEFAULT nextval('seq_blood_sugar_id'::regclass) NOT NULL unique,
target_low int NOT NULL,
target_high int NOT NULL,
input_level int NOT NULL,
last_measurement TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE blood_sugar_user_data_join (
blood_sugar_id int NOT NULL,
user_id int NOT NULL,

CONSTRAINT PK_blood_sugar_user_data_join PRIMARY KEY (blood_sugar_id, user_id),
CONSTRAINT FK_blood_sugar_user_data_join_user_data FOREIGN KEY (user_id) REFERENCES user_data(user_id),
CONSTRAINT FK_blood_sugar_user_data_join_blood_sugar FOREIGN KEY (blood_sugar_id) REFERENCES blood_sugar(blood_sugar_id)
);
CREATE TABLE dose (
input_level int,
type_of_dose int,
dose_units int,
dose_id int DEFAULT nextval('seq_dose_id'::regclass) NOT NULL unique,
time_of_dose TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE dose_user_data_join (
dose_id int NOT NULL,
user_id int NOT NULL,

CONSTRAINT PK_dose_user_data_join PRIMARY KEY (dose_id, user_id),
CONSTRAINT FK_dose_user_data_join_user_data FOREIGN KEY (user_id) REFERENCES user_data(user_id),
CONSTRAINT FK_dose_user_data_join_dose FOREIGN KEY (dose_id) REFERENCES dose(dose_id)
);
INSERT INTO users (username,password_hash,role) VALUES ('user@example.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES ('rymersd@gmail.com','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO user_data (user_id, a1c, fasting_glucose, diabetes_type, user_age, last_updated, weight, height, activity_level, profile_pic)
VALUES (1, 7.50, 99, 1, 47, '2022/12/12', 120, 500, 'Active', 'Picture.jpeg');
INSERT INTO user_data (user_id, a1c, fasting_glucose, diabetes_type, user_age, last_updated, weight, height, activity_level, profile_pic)
VALUES (2, 8.50, 100, 2, 48, '2022/12/12', 121, 501, 'Active', 'Hi.jpeg');
INSERT INTO user_data (user_id, a1c, fasting_glucose, diabetes_type, user_age, last_updated, weight, height, activity_level, emergency_contact_1, emergency_contact_2, profile_pic)
VALUES (3, 8.50, 100, 2, 48, '2022/12/12', 121, 501, 'Active', 'rymersd@gmail.com', 'mdelafay497@gmail.com', 'capstone.jpeg');
INSERT INTO meals (carbs, food, glycemic_index, meal_time)
VALUES (50, 'test food', 300, '2022/12/12 13:10:11');
INSERT INTO meals (carbs, food, glycemic_index, meal_time)
VALUES (51, 'test food', 300, '2022/12/12 13:11:11');
INSERT INTO meals (carbs, food, glycemic_index, meal_time)
VALUES (52, 'test food', 300, '2022/12/12 13:12:11');
INSERT INTO meals (carbs, food, glycemic_index, meal_time)
VALUES (21, 'Salad', 301, '2022/11/11 13:13:11');
INSERT INTO meals_user_join (meal_id, user_id) VALUES (1, 1);
INSERT INTO meals_user_join (meal_id, user_id) VALUES (2, 1);
INSERT INTO meals_user_join (meal_id, user_id) VALUES (3, 1);
INSERT INTO meals_user_join (meal_id, user_id) VALUES (4, 3);
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (50, 200, 130, '2022/11/16 08:12:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 90, '2022/11/17 11:11:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 260, '2022/11/17 17:29:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 120, '2022/11/18 09:34:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 40, '2022/11/18 17:40:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 68, '2022/11/19 09:34:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 99, '2022/11/19 19:44:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 57, '2022/11/20 08:05:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 184, '2022/11/20 17:05:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 53, '2022/11/21 08:05:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 160, '2022/11/21 17:05:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 64, '2022/11/22 08:25:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 90, '2022/11/22 18:25:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 48, '2022/11/23 09:25:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 110, '2022/11/23 17:25:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 55, '2022/11/24 08:30:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 190, '2022/11/24 19:35:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 85, '2022/11/25 08:30:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 230, '2022/11/25 19:35:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 72, '2022/11/26 07:40:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 198, '2022/11/26 17:25:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 59, '2022/11/27 07:30:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 168, '2022/11/27 17:15:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 39, '2022/11/28 09:30:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 245, '2022/11/28 19:35:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 83, '2022/11/29 08:30:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 211, '2022/11/29 18:35:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 49, '2022/11/30 07:30:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 175, '2022/11/30 18:15:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 69, '2022/12/01 08:10:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 269, '2022/12/01 17:15:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 200, '2022/12/02 09:10:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 150, '2022/12/02 15:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 190, '2022/12/03 07:30:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 170, '2022/12/03 14:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 230, '2022/12/04 09:10:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 155, '2022/12/04 19:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 145, '2022/12/05 08:07:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 270, '2022/12/05 14:14:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 70, '2022/12/06 07:56:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 190, '2022/12/06 17:32:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 208, '2022/12/07 07:00:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 176, '2022/12/07 13:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 67, '2022/12/08 06:44:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 140, '2022/12/08 18:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 90, '2022/12/09 08:45:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 200, '2022/12/09 14:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 110, '2022/12/10 08:00:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 200, '2022/12/10 16:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 78, '2022/12/11 09:00:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 170, '2022/12/11 17:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 48, '2022/12/12 07:00:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 140, '2022/12/12 18:32:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 85, '2022/12/13 08:00:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 240, '2022/12/13 16:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 66, '2022/12/14 08:30:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 149, '2022/12/14 16:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 89, '2022/12/15 09:00:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 222, '2022/12/15 18:12:18');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 110, '2022/11/11 08:00:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 200, '2022/12/15 16:12:18');

INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (1, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (2, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (3, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (4, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (5, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (6, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (7, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (8, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (9, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (10, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (11, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (12, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (13, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (14, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (15, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (16, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (17, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (18, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (19, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (20, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (21, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (22, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (23, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (24, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (25, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (26, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (27, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (28, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (29, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (30, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (31, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (32, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (33, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (34, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (35, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (36, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (37, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (38, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (39, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (40, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (41, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (42, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (43, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (44, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (45, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (46, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (47, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (48, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (49, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (50, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (51, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (52, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (53, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (54, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (55, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (56, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (57, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (58, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (59, 3);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (60, 3);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, peak, duration)
VALUES ('Admelog', 'Rapid-Acting', 51, 15, 15, 60, 180);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, peak, duration)
VALUES ('Apidra', 'Rapid-Acting', 42, 15, 15, 60, 180);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, peak, duration)
VALUES ('Fiasp', 'Rapid-Acting', 57, 15, 15, 60, 180);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, peak, duration)
VALUES ('Humalog', 'Rapid-Acting', 60, 15, 15, 60, 180);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, peak, duration)
VALUES ('Novolog', 'Rapid-Acting', 81, 15, 15, 60, 180);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, peak, duration)
VALUES ('Humulin R', 'Short-Acting', 90, 30, 30, 150, 270);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, peak, duration)
VALUES ('Novolin R', 'Short-Acting', 90, 30, 30, 150, 270);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, peak, duration)
VALUES ('Humulin N', 'Intermediate-Acting', 264, 180, 180, 1080, 900);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, peak, duration)
VALUES ('Novolin N', 'Intermediate-Acting', 264, 180, 180, 1080, 900);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, duration)
VALUES ('Basaglar KwikPen', 'Long-Acting', 720, 180, 180, 1440);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, duration)
VALUES ('Lantus', 'Long-Acting', 810, 180, 180, 1440);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, duration)
VALUES ('Levemir', 'Long-Acting', 720, 180, 180, 1440);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, duration)
VALUES ('Toujeo', 'Long-Acting', 1110, 180, 180, 1440);
INSERT INTO insulin_information (insulin_brand_name, insulin_type, half_life, onset_low, onset_high, duration)
VALUES ('TresibaFlexTouch', 'Long-Acting', 810, 180, 180, 1440);
INSERT INTO insulin (base_level, avg_level, time_last_dose, insulin_brand_name, insulin_strength, insulin_ratio)
VALUES (10.0, 10.0, '2022/12/12 00:00:00', 'Admelog', 'Strong', 0.14);
INSERT INTO insulin (base_level, avg_level, time_last_dose, insulin_brand_name, insulin_strength, insulin_ratio)
VALUES (10.0, 10.0, '2022/12/12 00:00:00', 'Apidra', 'Strong', 0.14);
INSERT INTO insulin (base_level, avg_level, time_last_dose, insulin_brand_name, insulin_strength, insulin_ratio)
VALUES (10.0, 10.0, '2022/12/12 00:00:00', 'Fiasp', 'Strong', 0.14);
INSERT INTO insulin (base_level, avg_level, time_last_dose, insulin_brand_name, insulin_strength, insulin_ratio)
VALUES (10.0, 10.0, '2022/11/11 00:00:00', 'Fiasp', 'Strong', 0.14);
INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (1, 1);
INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (1, 2);
INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (2, 3);
INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (3, 4);
INSERT INTO dose (dose_units, time_of_dose, type_of_dose, input_level)
VALUES (10, '2022/12/06 13:12:11', 0, 130);
INSERT INTO dose (dose_units, time_of_dose, type_of_dose, input_level)
VALUES (15, '2022/11/06 13:12:11', 0, 130);
INSERT INTO dose (dose_units, time_of_dose, type_of_dose, input_level)
VALUES (20, '2022/11/26 13:12:11', 1, 130);
INSERT INTO dose (dose_units, time_of_dose, type_of_dose, input_level)
VALUES (21, '2022/11/11 13:13:11', 1, 130);
INSERT INTO dose_user_data_join (dose_id, user_id) VALUES (1, 1);
INSERT INTO dose_user_data_join (dose_id, user_id) VALUES (2, 1);
INSERT INTO dose_user_data_join (dose_id, user_id) VALUES (3, 1);
INSERT INTO dose_user_data_join (dose_id, user_id) VALUES (4, 3);
COMMIT TRANSACTION;