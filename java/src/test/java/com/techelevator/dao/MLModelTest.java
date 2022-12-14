package com.techelevator.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public void testPrediction() throws JsonProcessingException {

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

//        dataTest dataTest = new dataTest();
//        valuesTest valuesTest = new valuesTest();
//        valuesTest.setInsulin(5);
//        valuesTest.setBMI(30.0);
//        valuesTest.setAge(38);
//        valuesTest.setOutcome(1);
//        valuesTest[] valuesTestsArr = new valuesTest[]{valuesTest};
//        dataTest.setValuesTest(valuesTestsArr);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        String jsonString = objectMapper.writeValueAsString(dataTest);

        mlModelHelper.returnUserBloodSugarPredictionFromAzure(userInfoObject);
    }
}
