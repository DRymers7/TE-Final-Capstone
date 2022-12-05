package com.techelevator.helperclasses;

import com.techelevator.services.FDAService;

public class InsulinCalculator {

    private String baseApiUrl = "https://api.nal.usda.gov/fdc/v1/food";

    private FDAService fdaService = new FDAService(baseApiUrl);

    public InsulinCalculator() {};


}
