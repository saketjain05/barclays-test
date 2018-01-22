package com.barclays.test.entity;

/**
 * Created by sjain203 on 1/21/18.
 */
public class Bags {

    private String bagNumber = "";
    private String bagEntryPoint = "";
    private String bagDestinationFlightId = "";

    public Bags(String bagNumber, String bagEntryPoint, String bagDestinationFlightId) {
        this.bagNumber = bagNumber;
        this.bagEntryPoint = bagEntryPoint;
        this.bagDestinationFlightId = bagDestinationFlightId;
    }

    public String getBagNumber() {
        return bagNumber;
    }

    public void setBagNumber(String bagNumber) {
        this.bagNumber = bagNumber;
    }

    public String getBagEntryPoint() {
        return bagEntryPoint;
    }

    public void setBagEntryPoint(String bagEntryPoint) {
        this.bagEntryPoint = bagEntryPoint;
    }

    public String getBagDestinationFlightId() {
        return bagDestinationFlightId;
    }

    public void setBagDestinationFlightId(String bagDestinationFlightId) {
        this.bagDestinationFlightId = bagDestinationFlightId;
    }
}
