package com.edicom.MarsRover;

public class Game {
	

	public static Rover goForward(Rover rover) {
		
		switch(rover.getDirection()) {
			case 'N' : rover.setX(rover.getX()-1); break;
			case 'S' : rover.setX(rover.getX()+1); break;
			case 'W' : rover.setY(rover.getY()-1); break;
			case 'E' : rover.setY(rover.getY()+1); break;
			default : ;
		}
		
		return rover;

	}
	
	public static Rover goBackward(Rover rover) {
		
		switch(rover.getDirection()) {
			case 'N' : rover.setX(rover.getX()+1); break;
			case 'S' : rover.setX(rover.getX()-1); break;
			case 'W' : rover.setY(rover.getY()+1); break;
			case 'E' : rover.setY(rover.getY()-1); break;
			default : ;
		}
		
		return rover;

	}
	

}
