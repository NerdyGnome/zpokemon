package org.pokemon;

/**
 * 
 * @author NerdyGnome
 * 
 * The Npc class, all Npc details to be stored
 *
 */
public class Npc extends Character{
	private short startX;
	private short startY;
	private short zoneSize;
	private boolean isChatting;

	/**
	 * Construct a new Npc.
	 * 
	 * @param id
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param delta
	 * @param zoneSize
	 */
	public Npc(short id, short x, short y, short width, short height, short delta, short zoneSize) {	
		super(x,y,width,height,delta);
		this.startX = x;
		this.startY = y;
		this.zoneSize = zoneSize;		
	}
	
	/*
	 * Getters and setters for short values
	 */
	public short getStartX() {
		return startX;
	}
	
	public short getStartY() {
		return startY;
	}
	
	public short getZoneSize() {
		return zoneSize;
	}
	
	public void setStartX(short startX) {
		this.startX = startX;
	}
	
	public void setStartY(short startY) {
		this.startY = startY;
	}
	
	public void setZoneSize(short zoneSize) {
		this.zoneSize = zoneSize;
	}
	
	/*
	 * Getters and setters for boolean values
	 */
	
	public boolean isChatting() {
		return isChatting;
	}
	
	public void setChatting(boolean isChatting) {
		this.isChatting = isChatting;
	}
	
	/*
	 * Checkzone, distance etc. needs to be added.
	 */
}
