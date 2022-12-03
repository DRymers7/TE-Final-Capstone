START TRANSACTION

select * from insulin
select * from users
select * from user_data
select * from insulin_data
select * from meals
select * from blood_sugar

INSERT INTO user_data (user_id, a1c, fasting_glucose, diabetes_type) 
VALUES (1, 7.50, 99, 1);

INSERT INTO insulin_data_join (user_id, insulin_id) VALUES (1, 1);

INSERT INTO insulin (user_id, insulin_type, base_level, avg_level, date_updated)
VALUES (1, 'test type', 50.55, 50.55, '2022/12/12');

INSERT INTO insulin_data (insulin_type, insulin_strength, half_life, onset, peak, duration)
VALUES ('fast acting', 'test strength', 20, 20, 200, 400);

INSERT INTO meals (user_id, carbs, food, glycemic_index, date_updated)
VALUES (1, 100, 'test food', 100, '2022/12/12');

INSERT INTO blood_sugar (user_id, target_low, target_high, input_level, date_updated)
VALUES (1, 50, 50, 50, '2022/12/12');

ROLLBACK
