BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, insulin, user_insulin, meals, user_meals, blood_sugar, user_blood_sugar CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id;

CREATE SEQUENCE seq_user_id
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


CREATE TABLE insulin (
	user_insulin_id int NOT NULL PRIMARY KEY,
	insulin_type varchar(32),
	base_level decimal(10,3),
	insulin_strength varchar(16),
	avg_level decimal(10,3),
	date_updated TIMESTAMP DEFAULT CURRENT_DATE
	
);

CREATE TABLE user_insulin (
	user_id int NOT NULL,
	user_insulin_id int NOT NULL,
	
	CONSTRAINT PK_user_insulin PRIMARY KEY (user_id, user_insulin_id),
	CONSTRAINT fk_user_insulin_insulin FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT fk_user_insulin_user FOREIGN KEY (user_insulin_id) 
		REFERENCES insulin(user_insulin_id)
	
);

CREATE TABLE meals (
	meals_id int NOT NULL PRIMARY KEY,
	carbs int NOT NULL,
	food varchar (32),
	date_updated TIMESTAMP DEFAULT CURRENT_DATE

);

CREATE TABLE user_meals (
	user_id int NOT NULL,
	user_meals_id int NOT NULL,
	
	CONSTRAINT PK_user_meals PRIMARY KEY (user_id, user_meals_id),
	CONSTRAINT fk_user_meals_meals FOREIGN KEY (user_meals_id) REFERENCES meals(meals_id),
	CONSTRAINT fk_user_meals_user FOREIGN KEY (user_id) REFERENCES users(user_id)
	
	

);

CREATE TABLE blood_sugar (
	user_id_bs int NOT NULL PRIMARY KEY,
	target_low int NOT NULL,
	target_high int NOT NULL,
	input_level int NOT NULL,
	date_updated TIMESTAMP DEFAULT CURRENT_DATE
	
);

CREATE TABLE user_blood_sugar (
	user_id int NOT NULL,
	user_id_bs int NOT NULL,
	
	CONSTRAINT PK_user_blood_sugar PRIMARY KEY (user_id, user_id_bs),
	CONSTRAINT fk_user_blood_sugar_user FOREIGN KEY (user_id) REFERENCES users(user_id),
	CONSTRAINT fk_user_blood_sugar_blood_sugar FOREIGN KEY (user_id_bs) 
		REFERENCES blood_sugar(user_id_bs)
	
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

COMMIT TRANSACTION;