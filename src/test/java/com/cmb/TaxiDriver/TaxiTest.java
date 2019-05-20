package com.cmb.TaxiDriver;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

//      不大于2公里时只收起步价6元
//		超过2公里时每公里0.8元
//		超过8公里则每公里加收50%长途费
//		停车等待时加收每分钟0.25元

public class TaxiTest extends TestBase {

	private Taxi taxi;

	@Before
	public void setUp() throws Exception {
		taxi = new Taxi();
	}

	@Test
	public void calculate当小于两公里时应该只收6元() {
		verifyCalculate(1, 6.0);
	}

	@Test
	public void caluculate超过两公里时每公里收费0点8元() {
		verifyCalculate(3, 6.8);
	}

	@Test
	public void caluculate超过8公里则每公里加收百分之50长途费() {
		verifyCalculate(10, 13.2);
		verifyCalculate(9, 12);
	}

	@Test
	public void calculate停车等待时加收每分钟0点25元() {
		double meter = 1;
		double waitTime = 1;
		double expectedPrice = 6.25;
		assertEquals(taxi.calculate(1, 1), expectedPrice, DELTA);
	}

	private void verifyCalculate(int meter, double expectedPrice) {
		verifyCalculate(meter, 0, expectedPrice);
	}

	private void verifyCalculate(int meter, double waitTime, double expectedPrice) {
		final double result = taxi.calculate(meter, waitTime);
		assertEquals(result, expectedPrice, DELTA);
	}
}