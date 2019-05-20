package com.cmb.TaxiDriver;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DriverTest extends TestBase {
	@Mock
	private Taxi taxi;

	private Driver driver;

	@Before
	public void setup() {
		driver = new Driver(taxi);
	}

	@Test
	public void should_charge_2_yuan_when_taxi_calculate_is_2_4() {
		when(taxi.calculate(anyDouble(), anyDouble())).thenReturn(2.4);
		assertEquals(driver.charge(1, 3), 2.0, DELTA);
	}
}
