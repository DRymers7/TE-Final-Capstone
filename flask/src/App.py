from flask import Flask, render_template, request, redirect, url_for, flash, jsonify
from flask_restful import Resource, Api
import numpy as np
import src.Model as model


app = Flask(__name__)
api = Api(app)

# parser for the payload data
parser = reqparse.RequestParser()
parser.add_argument('data', type=list, help='Data to be predicted')

class Predictions(Resource):
    def get(self):
        return jsonify({'prediction': 'Hello World'})

    def post(self):
        args = parser.parse_args()
        x = np.array([args['data']])
        prediction = model.predict(x)
        return jsonify(prediction.tolist())

api.add_resource(Predictions, '/predictions')

# if __name__ == '__main__':
#     with open()