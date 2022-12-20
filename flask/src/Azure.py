URI = "http://b9b9e03c-8cd6-4bd8-b114-80fe8fba5269.eastus2.azurecontainer.io/score"

# Request data goes here
data = {
    "data": [
        [0.00632, 18.0, 2.31, 0, 0.538, 6.575, 65.2, 4.09, 1, 296.0, 15.3, 396.9, 4.98]
    ]
}

# Convert to JSON string
input_data = json.dumps(data)

# Set the content type
headers = {"Content-Type": "application/json"}

# Make the request and display the response
resp = requests.post(URI, input_data, headers=headers)
print(resp.json())

# Output:
# [24.969999999999999]

