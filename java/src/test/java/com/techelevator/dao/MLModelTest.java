package com.techelevator.dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.techelevator.model.ModelClasses.Azure.Inputs;
import com.techelevator.model.ModelClasses.Azure.UserInfoPrediction;
import com.techelevator.model.ModelClasses.Azure.data;
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

//        UserInfoPrediction testInfo = new UserInfoPrediction();
//        Inputs inputs = new Inputs();
//        data data = new data();
//        data.setInsulin(5);
//        data.setBMI(30.0);
//        data.setAge(37);
//        data.setOutcome(1);
//        data[] dataArr = new data[]{data};
//        inputs.setData(dataArr);
//        testInfo.setInputs(inputs);
        data data = new data();
        data.setInsulin(5);
        data.setBMI(30.0);
        data.setAge(37);
        data.setOutcome(1);

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(data);

        String jsonStringNew = objectMapper.writeValueAsString(data);

        mlModelHelper.returnUserBloodSugarPredictionFromAzure(data);
    }
}
