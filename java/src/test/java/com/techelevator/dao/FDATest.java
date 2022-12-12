package com.techelevator.dao;

import com.techelevator.model.ModelClasses.edamam.NutritionInfo;
import com.techelevator.services.FDAHelper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class FDATest {

    private FDAHelper fdaHelper;

    @Before
    public void setup() {
        this.fdaHelper = new FDAHelper();
    }

    @Test
    public void test_get_call() {
        NutritionInfo test = fdaHelper.returnSearchedMealObject("cheese pizza");
        Assert.assertNotNull(test);
    }


}
