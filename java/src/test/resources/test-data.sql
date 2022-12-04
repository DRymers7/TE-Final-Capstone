BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, user_data, insulin, insulin_user_data_join, meals, meals_user_join, blood_sugar, blood_sugar_user_data_join CASCADE;
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
-- bmi (weight/height)**2 calc on server

   CONSTRAINT FK_user_data_user FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE insulin (
     insulin_id int DEFAULT nextval('seq_insulin_id'::regclass) NOT NULL unique,
     base_level decimal(10,3),
     avg_level decimal(10,3),
     time_last_dose TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
     insulin_type varchar(32) NOT NULL,
     insulin_strength varchar(32),
     half_life int, --minutes
     onset int, --display information for when to check blood sugar
     peak int,
     insulin_ration decimal(3,2) NOT NULL,
     duration int
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


INSERT INTO users (username,password_hash,role) VALUES ('user1','user1','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user2','user2','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('user3','user3','ROLE_USER');

INSERT INTO user_data (user_id, a1c, fasting_glucose, diabetes_type, user_age, last_updated, weight, height, activity_level)
VALUES (1, 7.50, 99, 1, 47, '2022/12/12', 120, 500, 'Active');

INSERT INTO user_data (user_id, a1c, fasting_glucose, diabetes_type, user_age, last_updated, weight, height, activity_level)
VALUES (2, 8.50, 100, 2, 48, '2022/12/12', 121, 501, 'Active');

INSERT INTO insulin (base_level, avg_level, insulin_type, insulin_strength, half_life, onset, peak, insulin_ration, duration)
VALUES (10, 10, 'Fast acting', 'Strong', 10, 10, 10, 0.45, 20);
INSERT INTO insulin (base_level, avg_level, insulin_type, insulin_strength, half_life, onset, peak, insulin_ration, duration)
VALUES (10, 10, 'Fast acting', 'Strong', 10, 10, 10, 0.45, 20);
INSERT INTO insulin (base_level, avg_level, insulin_type, insulin_strength, half_life, onset, peak, insulin_ration, duration)
VALUES (10, 10, 'Slow acting', 'Strong', 10, 10, 10, 0.35, 20);

INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (1, 1);
INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (2, 2);
INSERT INTO insulin_user_data_join (user_id, insulin_id) VALUES (1, 3);

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

COMMIT TRANSACTION;