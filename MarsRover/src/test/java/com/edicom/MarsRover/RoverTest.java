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
			{ new Rover(1, 0, 'N'), 0, 0 }, 
			{ new Rover(1, 2, 'E'), 1, 3 }, 
			{ new Rover(2, 0, 'S'), 3, 0 }, 
			{ new Rover(2, 2, 'W'), 2, 1 } 
		};
	}	
	
	
	@DataProvider
	public static Object[][] dataRoverProviderForBackward() {

		return new Object[][] { 
			{ new Rover(1, 0, 'N'), 2, 0 }, 
			{ new Rover(1, 2, 'E'), 1, 1 }, 
			{ new Rover(2, 0, 'S'), 1, 0 }, 
			{ new Rover(2, 2, 'W'), 2, 3 } 
		};
	}
	
	@Test
	@UseDataProvider("dataRoverProviderForForward")
	public void testForward(Rover rover, int expectedPosX, int expectedPosY) {
		
		Rover newRover = Game.goForward(rover);
		
		//int [] expected = { expectedPosX, expectedPosY };
		
		Assert.assertEquals(expectedPosX, newRover.getX());
		Assert.assertEquals(expectedPosY, newRover.getY());
		
	}
	
	@Test
	@UseDataProvider("dataRoverProviderForBackward")
	public void testBackward(Rover rover, int expectedPosX, int expectedPosY) {
		
		Rover newRover = Game.goBackward(rover);
		
		//int [] expected = { expectedPosX, expectedPosY };
		
		Assert.assertEquals(expectedPosX, newRover.getX());
		Assert.assertEquals(expectedPosY, newRover.getY());
		
	}
}
