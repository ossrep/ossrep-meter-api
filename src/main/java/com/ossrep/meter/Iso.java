package com.ossrep.meter;

public enum Iso {

    CAISO("California Independent System Operator"),
    ERCOT("Electric Reliability Council of Texas"),
    ISONE("ISO New England"),
    MISO("Midcontinent Independent System Operator"),
    NYISO("New York Independent System Operator"),
    PJM("PJM Interconnection"),
    SPP("Southwest Power Pool");

    private final String name;

    Iso(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}