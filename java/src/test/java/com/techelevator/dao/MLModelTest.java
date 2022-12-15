package com.techelevator.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.techelevator.exceptions.ServersideOpException;
import com.techelevator.model.ModelClasses.Azure.*;
import com.techelevator.services.MLModelHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MLModelTest {

    private MLModelHelper mlModelHelper;

    @Before
    public void setup() {
        this.mlModelHelper = new MLModelHelper();
    }

    @Test
    public void testPrediction() throws JsonProcessingException, ServersideOpException {

        UserInfoObject userInfoObject = new UserInfoObject();
        Inputs inputs = new Inputs();
        data data = new data();
        data.setInsulin(5);
        data.setBMI(30.0);
        data.setAge(37);
        data.setOutcome(1);
        data[] dataArr = new data[]{data};
        inputs.setData(dataArr);
        userInfoObject.setInputs(inputs);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(userInfoObject);
        Assert.assertNotEquals(null, jsonString);

        BLOB blob = new BLOB();
        blob.setDoseUnits(5);
        blob.setUserAge(37);
        blob.setBmi(30.0);
        blob.setDiabetesType(1);

        Assert.assertNotNull(mlModelHelper.returnUserBloodSugarPredictionFromAzure(blob));
    }
}
