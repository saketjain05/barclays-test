package com.barclays.test.utility;

/**
 * Created by sjain203 on 1/21/18.
 */
public enum GateNameToNodeConversion {

    CONCOURSE_A_TICKETING(0),
    A1(1),
    A2(2),
    A3(3),
    A4(4),
    A5(5),
    A6(6),
    A7(7),
    A8(8),
    A9(9),
    A10(10),
    BAGGAGE_CLAIM(11);

    private int gateName;

    GateNameToNodeConversion(int gateName) {
        this.gateName = gateName;
    }

    public int gateName() {
        return gateName;
    }

    public static String getgateByNodeName(int code){
        for(GateNameToNodeConversion e : GateNameToNodeConversion.values()){
            if(code == e.gateName) return e.name();
        }
        return null;
    }
}
