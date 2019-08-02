package com.cmb.TaxiDriver;

public class Taxi {

    public static final int INIT_METER = 2;
    public static final double INIT_PRICE = 6.0;
    public static final double PRICE_PER_METER = 0.8;
    public static final int FAR_METER = 8;
    public static final double WAIT_TIME_RATE = 0.25;

    public double calculate(double meter, double waitTime) {
        return distancePrice(meter) + waitTimePrice(waitTime);
    }

    private double waitTimePrice(double waitTime) {
        return waitTime * WAIT_TIME_RATE;
    }

    private double distancePrice(double meter) {
        return INIT_PRICE + distanceFee(meter) + farFee(meter);
    }

    private double farFee(double meter) {
        return Math.max((meter - FAR_METER), 0) * 0.5 * PRICE_PER_METER;
    }

    private double distanceFee(double meter) {
        return Math.max((meter - INIT_METER), 0) * PRICE_PER_METER;
    }
}
