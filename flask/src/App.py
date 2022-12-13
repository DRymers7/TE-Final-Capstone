from flask import Flask, render_template, request, redirect, url_for, flash, jsonify
from flask_restful import Resource, Api, reqparse
import numpy as np
import Model as model

model = model.Model()
app = Flask(__name__)
api = Api(app)

# parser for the payload data
parser = reqparse.RequestParser()
parser.add_argument('Glucose', type=int, help='Glucose level')
parser.add_argument('Insulin', type=int, help='Most recent insulin dose (if applicable)')
parser.add_argument('BMI', type=float, help='BMI')
parser.add_argument('Age', type=int, help='Age')
parser.add_argument('Diabetes', type=int, help='Diabetes(y/n)')

@app.route('/test', methods=['GET'])
def test():
    if request.method == 'GET':
        return jsonify({"response": "Get request called"})


@app.route('/predict', methods=['POST'])
def predict():
    if request.method == 'POST':
        req_Json = request.json
        glucose = req_Json['Glucose']
        insulin = req_Json['Insulin']
        bmi = req_Json['BMI']
        age = req_Json['Age']
        diabetes = req_Json['Diabetes']
        prediction = model.predict(np.array([[glucose, insulin, bmi, age, diabetes]]))
        return jsonify({'prediction': prediction.tolist()})
    
if __name__ == '__main__':
    app.run(debug=True)