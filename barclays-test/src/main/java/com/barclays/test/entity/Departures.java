package com.barclays.test.entity;

/**
 * Created by sjain203 on 1/21/18.
 */
public class Departures {

    private String flightId = "";
    private String flightGate = "";
    private String flightDestination = "";
    private String flightTime = "";

    public Departures(String flightId, String flightGate, String flightDestination, String flightTime) {
        this.flightId = flightId;
        this.flightGate = flightGate;
        this.flightDestination = flightDestination;
        this.flightTime = flightTime;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getFlightGate() {
        return flightGate;
    }

    public void setFlightGate(String flightGate) {
        this.flightGate = flightGate;
    }

    public String getFlightDestination() {
        return flightDestination;
    }

    public void setFlightDestination(String flightDestination) {
        this.flightDestination = flightDestination;
    }

    public String getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(String flightTime) {
        this.flightTime = flightTime;
    }
}
