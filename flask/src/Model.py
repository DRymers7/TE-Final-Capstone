import pandas as pd
import numpy as np
import sklearn 
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression
from sklearn.linear_model import LogisticRegression
from sklearn.preprocessing import StandardScaler
from sklearn.metrics import classification_report
from sklearn.metrics import mean_squared_error
from sklearn.metrics import mean_absolute_error
from math import sqrt
import pickle

class Model:
   
    #generic constructor
    def __init__(self):
        pass
        
    def logModel(self):
        # Read diabetes.csv into a pandas DataFrame
        df = pd.read_csv('src\diabetes.csv', sep=',', header=0)
        y = df["Outcome"]
        X = df.drop(["Pregnancies", "BloodPressure", "SkinThickness", "Insulin", "DiabetesPedigreeFunction", "Age", "Outcome"], axis=1)
        log_model = LogisticRegression().fit(X, y)
        y_pred = log_model.predict(X)
        #save model
        pickle.dump(log_model, open('src\log_model.pkl', 'wb'))

    def linearModel(self):
        df = pd.read_csv('src\diabetes.csv', sep=',', header=0)
        y = df["Glucose"]
        X = df.drop(["Pregnancies", "BloodPressure", "SkinThickness", "DiabetesPedigreeFunction"], axis=1)
        X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=123)
        scaler = StandardScaler()
        train_scaled = scaler.fit_transform(X_train)
        test_scaled = scaler.transform(X_test)
        model = LinearRegression().fit(train_scaled, y_train)
        mse = mean_squared_error(y_train, model.predict(train_scaled))
        mae = mean_absolute_error(y_train, model.predict(train_scaled))
        # print("mse = ",mse," & mae = ",mae," & rmse = ", sqrt(mse))
        #save model
        pickle.dump(model, open('src\lin_model.pkl', 'wb'))


    #get model from pickle and predict
    def predict(self, x):
        #load model
        log_model = pickle.load(open('src\lin_model.pkl', 'rb'))
        #predict
        y_pred = log_model.predict(x)
        return y_pred

   

# model = Model()
# model.linearModel()
# print(model.predict(np.array([[100, 148, 32, 40, 0]])))

