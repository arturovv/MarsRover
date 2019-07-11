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
	
	@DataProvider
	public static Object[][] dataRoverProviderForRight() {

		return new Object[][] { 
			{ new Rover(1, 0, 'N'), 'E'}, 
			{ new Rover(1, 2, 'E'), 'S' }, 
			{ new Rover(2, 0, 'S'), 'W' }, 
			{ new Rover(2, 2, 'W'), 'N' } 
		};
	}
	
	@DataProvider
	public static Object[][] dataRoverProviderForLeft() {

		return new Object[][] { 
			{ new Rover(1, 0, 'N'), 'W' }, 
			{ new Rover(1, 2, 'E'), 'N' }, 
			{ new Rover(2, 0, 'S'), 'E' }, 
			{ new Rover(2, 2, 'W'), 'S' } 
		};
	}
	
	@Test
	@UseDataProvider("dataRoverProviderForForward")
	public void testForward(Rover rover, int expectedPosX, int expectedPosY) {
		
		Rover newRover = Game.goForward(rover);
				
		Assert.assertEquals(expectedPosX, newRover.getX());
		Assert.assertEquals(expectedPosY, newRover.getY());
		
	}
	
	@Test
	@UseDataProvider("dataRoverProviderForBackward")
	public void testBackward(Rover rover, int expectedPosX, int expectedPosY) {
		
		Rover newRover = Game.goBackward(rover);
				
		Assert.assertEquals(expectedPosX, newRover.getX());
		Assert.assertEquals(expectedPosY, newRover.getY());
		
	}
	
	@Test
	@UseDataProvider("dataRoverProviderForRight")
	public void testRight(Rover rover, char expected) {
		
		Rover newRover = Game.turnRight(rover);
	
		Assert.assertEquals(expected, newRover.getDirection());
		
	}
	
	@Test
	@UseDataProvider("dataRoverProviderForLeft")
	public void testLeft(Rover rover, char expected) {
		
		Rover newRover = Game.turnLeft(rover);
	
		Assert.assertEquals(expected, newRover.getDirection());
		
	}
	
}
