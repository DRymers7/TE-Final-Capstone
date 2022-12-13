package com.techelevator.dao;

import com.techelevator.model.ModelClasses.UserInfoPrediction;
import com.techelevator.services.FDAHelper;
import com.techelevator.services.MLModelHelper;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MLModelTest {

    private MLModelHelper mlModelHelper;

    @Before
    public void setup() {
        this.mlModelHelper = new MLModelHelper();
    }

    @Test
    public void testPrediction() {
        UserInfoPrediction testInfo = new UserInfoPrediction();
        testInfo.setGlucose(100);
        testInfo.setInsulin(100);
        testInfo.setBMI(100);
        testInfo.setAge(100);
        testInfo.setDiabetes(1);
        System.out.println("placeholder");

        double prediction = mlModelHelper.returnUserDataPrediction(testInfo);
    }
}
