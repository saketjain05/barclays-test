package com.barclays.test;

import com.barclays.test.entity.Bags;
import com.barclays.test.entity.Departures;
import com.barclays.test.services.ShortestPathService;
import com.barclays.test.utility.GateNameToNodeConversion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sjain203 on 1/21/18.
 */
public class ComputeShortestPath {

    static Departures d1 = new Departures("UA10", "A1", "MIA", "08:00");
    static Departures d2 = new Departures("UA11", "A1", "LAX", "09:00");
    static Departures d3 = new Departures("UA12", "A1", "JFK", "09:45");
    static Departures d4 = new Departures("UA13", "A2", "JFK", "08:30");
    static Departures d5 = new Departures("UA14", "A2", "JFK", "09:45");
    static Departures d6 = new Departures("UA15", "A2", "JFK", "10:00");
    static Departures d7 = new Departures("UA16", "A3", "JFK", "09:00");
    static Departures d8 = new Departures("UA17", "A4", "MHT", "09:15");
    static Departures d9 = new Departures("UA18", "A5", "LAX", "10:15");

    static Bags b1 = new Bags("0001", "Concourse_A_Ticketing", "UA12");
    static Bags b2 = new Bags("0002", "A5", "UA17");
    static Bags b3 = new Bags("0003", "A2", "UA10");
    static Bags b4 = new Bags("0004", "A8", "UA18");
    static Bags b5 = new Bags("0005", "A7", "Baggage_Claim");

    public static void main(String args[]) {
        Map<String, Departures> departuresMap = new HashMap<String, Departures>();
        departuresMap.put(d1.getFlightId(), d1);
        departuresMap.put(d2.getFlightId(), d2);
        departuresMap.put(d3.getFlightId(), d3);
        departuresMap.put(d4.getFlightId(), d4);
        departuresMap.put(d5.getFlightId(), d5);
        departuresMap.put(d6.getFlightId(), d6);
        departuresMap.put(d7.getFlightId(), d7);
        departuresMap.put(d8.getFlightId(), d8);
        departuresMap.put(d9.getFlightId(), d9);

        List<Bags> bagsList = new ArrayList<Bags>();
        bagsList.add(b1);
        bagsList.add(b2);
        bagsList.add(b3);
        bagsList.add(b4);
        bagsList.add(b5);

        for(Bags bag : bagsList) {
            try {
                int source = GateNameToNodeConversion.valueOf(bag.getBagEntryPoint().toUpperCase()).gateName();
                String departuregate = bag.getBagDestinationFlightId().equalsIgnoreCase("Baggage_Claim") ?
                        "BAGGAGE_CLAIM" : departuresMap.get(bag.getBagDestinationFlightId()).getFlightGate();
                int destination =  GateNameToNodeConversion.valueOf(departuregate).gateName();
                List result = ShortestPathService.getShortestPath(source, destination);
                System.out.println(bag.getBagNumber() + " " + result.get(1).toString().trim() + " : " + result.get(0));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
