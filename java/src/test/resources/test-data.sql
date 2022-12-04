BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, user_data, insulin, insulin_data, insulin_data_join, meals, meals_user_join, blood_sugar CASCADE;
DROP SEQUENCE IF EXISTS seq_user_id, seq_insulin_id, seq_meal_id CASCADE;

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
 user_id int NOT NULL PRIMARY KEY,
 target_low int NOT NULL,
 target_high int NOT NULL,
 input_level int NOT NULL,
 last_measurement TIMESTAMP DEFAULT CURRENT_DATE,

 CONSTRAINT FK_blood_sugar_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO user_data (user_id, a1c, fasting_glucose, diabetes_type, user_age, last_updated, weight, height)
VALUES (1, 7.50, 99, 1, 47, '2022/12/12', 120, 500);

INSERT INTO insulin (user_id, base_level, avg_level, time_last_dose)
VALUES (1, 50.500, 50.500, '2022/12/12');

INSERT INTO insulin_data (insulin_id, insulin_type, insulin_strength, half_life, onset, peak, duration)
VALUES (1, 'fast-acting', 'test strength', 4, 4, 5, 6);

INSERT INTO meals (meal_id, carbs, food, glycemic_index, meal_time)
VALUES (1, 50, 'test food', 300, '2022/12/12 13:10:11');

INSERT INTO insulin_data_join (user_id, insulin_id) VALUES (1, 1);
INSERT INTO meals_user_join (meal_id, user_id) VALUES (1, 1);

INSERT INTO blood_sugar (user_id, target_low, target_high, input_level, last_measurement)
VALUES (1, 50, 200, 130, '2022/12/12');

COMMIT TRANSACTION;