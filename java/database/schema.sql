BEGIN TRANSACTION;

DROP TABLE IF EXISTS blood_sugar, blood_sugar_user_data_join, insulin, insulin_data, insulin_information, insulin_data_join, insulin_user_data_join, meals, meals_user_join, user_data, users CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id, seq_insulin_id, seq_meal_id, seq_blood_sugar_id CASCADE;

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
  
CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL UNIQUE,
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
	emergency_contact_1 varchar(32),
	emergency_contact_2 varchar(32),
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
	insulin_brand_name varchar(32),
	insulin_strength varchar(32),
	insulin_ratio decimal(3,2) NOT NULL,
	
	CONSTRAINT FK_insulin_insulin_information FOREIGN KEY (insulin_brand_name) REFERENCES insulin_information(insulin_brand_name)
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

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO user_data (user_id, a1c, fasting_glucose, diabetes_type, user_age, last_updated, weight, height, activity_level)
VALUES (1, 7.50, 99, 1, 47, '2022/12/12', 120, 500, 'Active');
INSERT INTO user_data (user_id, a1c, fasting_glucose, diabetes_type, user_age, last_updated, weight, height, activity_level)
VALUES (2, 8.50, 100, 2, 48, '2022/12/12', 121, 501, 'Active');
INSERT INTO meals (carbs, food, glycemic_index, meal_time) 
VALUES (50, 'test food', 300, '2022/12/12 13:10:11');
INSERT INTO meals (carbs, food, glycemic_index, meal_time)
VALUES (51, 'test food', 300, '2022/12/12 13:11:11');
INSERT INTO meals (carbs, food, glycemic_index, meal_time)
VALUES (52, 'test food', 300, '2022/12/12 13:12:11');
INSERT INTO meals_user_join (meal_id, user_id) VALUES (1, 1);
INSERT INTO meals_user_join (meal_id, user_id) VALUES (2, 1);
INSERT INTO meals_user_join (meal_id, user_id) VALUES (3, 1);
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (50, 200, 130, '2022/12/12 13:12:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (51, 200, 130, '2022/12/12 13:11:11');
INSERT INTO blood_sugar (target_low, target_high, input_level, last_measurement)
VALUES (52, 200, 130, '2022/12/12 13:13:11');
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (1, 1);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (2, 1);
INSERT INTO blood_sugar_user_data_join (blood_sugar_id, user_id) VALUES (3, 1);
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
INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (1, 1);
INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (1, 2);
INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (2, 3);

COMMIT TRANSACTION;