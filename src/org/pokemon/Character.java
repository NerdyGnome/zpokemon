package org.pokemon;

/**
 * 
 * @author NerdyGnome
 * 
 * The character class, which is a superclass for
 * the Player- and NPC-class. 
 *
 */
public abstract class Character {
	private short id;
	private short x;
	private short y;
	private short width;
	private short height;
	private short delta;
	private short animation;
	private short characterDelayCount;
	private boolean inGrass;
	private boolean drawGrass;
	private boolean isMoving;
	
	/**
	 * Construct a new character.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param delta
	 */
	public Character(short x, short y, short width, short height, short delta) {	
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.delta = delta;		
	}
	
	/*
	 * Getters and setters for short values
	 */
	public short getId() {
		return id;
	}
	
	public short getX() {
		return x;
	}
	
	public short getY() {
		return y;
	}
	
	public short getWidth() {
		return width;
	}
	
	public short getHeight() {
		return height;
	}
	
	public short getDelta() {
		return delta;
	}
	
	public short getAnimation() {
		return animation;
	}
	
	public short getCharacterDelayCount() {
		return characterDelayCount;
	}
	
	public void setId(short id) {
		this.id = id;
	}
	
	public void setX(short x) {
		this.x = x;
	}
	
	public void setY(short y) {
		this.y = y;
	}
	
	public void setWidth(short width) {
		this.width = width;
	}
	
	public void setHeight(short height) {
		this.height = height;
	}
	
	public void setDelta(short delta) {
		this.delta = delta;
	}
	
	public void setAnimation(short animation) {
		this.animation = animation;
	}
	
	public void setCharacterDelayCount(short characterDelayCount) {
		this.characterDelayCount = characterDelayCount;
	}
	
	/*
	 * Getters and setters for boolean values
	 */
	public boolean isInGrass() {
		return inGrass;
	}
	
	public void setInGrass(boolean inGrass) {
		this.inGrass = inGrass;
	}
	
	public boolean isDrawGrass() {
		return drawGrass;
	}
	
	public void setDrawGrass(boolean drawGrass) {
		this.drawGrass = drawGrass;
	}
	
	public boolean isMoving() {
		return isMoving;
	}
	
	public void setMoving(boolean isMoving) {
		this.isMoving = isMoving;
	}

}