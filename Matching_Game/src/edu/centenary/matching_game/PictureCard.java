package edu.centenary.matching_game;

public class PictureCard {

	//Data Members
	private boolean flipped;
	private int shape;
	private boolean matched;
	
	public static final int BOMB = 0;
	public static final int SPHERE = 1;
	public static final int CUBE = 2;
	public static final int DODECAHEDRON = 3;
	public static final int PYRAMID = 4;
	public static final int CONE = 5;
	public static final int CYLINDER = 6;
	public static final int CUBOID = 7;
	public static final int FOURSTAR = 8;
	public static final int GLOSSYSTAR = 9;
	public static final int GREENSTAR = 10;
	public static final int ORANGESTAR = 11;
	public static final int PURPLESTAR = 12;
	public static final int BACK = 13;
	
	
	// Constructor
	public PictureCard(int shape){
		flipped = false;
		this.shape = shape;
		matched = false;
	}
	
	
	
	// Other Methods
	public void flip() {
		flipped = !flipped;
	}
	
	public boolean isFlipped() {
		return flipped;
	}
	
	public int getShape() {
		return shape;
	}
	
	public boolean isBomb() {
		return shape == BOMB;
	}
	
	public void setMatch(boolean m){
		matched = m;
	}
	
	public boolean isMatched(){
		return matched;
	}
}
