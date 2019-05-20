package com.cmb.TaxiDriver;

public class Driver {

	private Taxi taxi;

	public Driver(Taxi taxi) {
		this.taxi = taxi;
	}

	public double charge(double meter, double waitTime) {
		return Math.round(taxi.calculate(meter, waitTime));
	}
}
