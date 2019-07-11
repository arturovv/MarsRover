package com.edicom.MarsRover;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class RoverTest {
	
	@DataProvider
	public static Object[][] dataRoverProviderForForward() {

		return new Object[][] { 
			{ new Rover(0, 0, "W"), 0, 0 }, 
			{ new Rover(1, 2, "E"), 1, 3 }, 
			{ new Rover(2, 0, "S"), 3, 0 } 
		};
	}
	
	@Test
	@UseDataProvider("dataRoverProviderForForward")
	public void testForward(Rover rover, int expectedPosX, int expectedPosY) {
		
		rover.goForward();
		int [] expected = { expectedPosX, expectedPosY };
		Assert.assertEquals(expected, rover.getPos());
		
	}
}
