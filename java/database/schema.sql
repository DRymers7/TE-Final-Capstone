BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, user_data, insulin, insulin_data, insulin_data_join, meals, meals_user_join, blood_sugar CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id, seq_insulin_id, meal_id CASCADE;

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
	age int,
	weight int,
	height int,
	-- bmi (weight/height)**2 calc on server
	
	CONSTRAINT FK_user_data_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE insulin (
	user_id int NOT NULL PRIMARY KEY,
	base_level decimal(10,3),
	avg_level decimal(10,3),
	time_last_dose TIMESTAMP,
	
	CONSTRAINT FK_insulin_user FOREIGN KEY (user_id) REFERENCES user_data(user_id)
);

CREATE TABLE insulin_data (
	insulin_id int DEFAULT nextval('seq_insulin_id'::regclass) NOT NULL UNIQUE,
	insulin_type varchar(32) NOT NULL UNIQUE,
	insulin_strength varchar(32),
	half_life int, --minutes
	onset int, --display information for when to check blood sugar
	peak int,
	duration int
);

CREATE TABLE insulin_data_join (
	user_id int,
	insulin_id int,
	
	CONSTRAINT PK_insulin_data_join PRIMARY KEY (user_id, insulin_id),
	CONSTRAINT FK_insulin_data_join_insulin FOREIGN KEY (user_id) REFERENCES insulin(user_id),
	CONSTRAINT FK_insulin_data_join_insulin_data FOREIGN KEY (insulin_id) REFERENCES insulin_data(insulin_id)
);

CREATE TABLE meals (
	meal_id int DEFAULT nextval('seq_meal_id'::regclass) NOT NULL unique,
	carbs int NOT NULL,
	food varchar (32),
	glycemic_index int, --FDA API
	meal_time TIMESTAMP DEFAULT CURRENT_DATE
);

CREATE TABLE meals_user_join (
	meal_id int NOT NULL,
	user_id int NOT NULL,
	
	CONSTRAINT PK_meals_user_join PRIMARY KEY (meal_id, user_id),
	CONSTRAINT FK_meals_user_join_user_data FOREIGN KEY (user_id) REFERENCES user_data(user_id),
	CONSTRAINT FK_meals_user_join_meals FOREIGN KEY (meal_id) REFERENCES meals(meal_id)
);

CREATE TABLE blood_sugar (
	user_id int NOT NULL PRIMARY KEY,
	target_low int NOT NULL,
	target_high int NOT NULL,
	input_level int NOT NULL,
	last_measurement TIMESTAMP DEFAULT CURRENT_DATE,
	
	CONSTRAINT FK_blood_sugar_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;