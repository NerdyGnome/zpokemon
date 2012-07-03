package org.pokemon;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import org.zengine.Constants;
import org.zengine.graphics.Paintable;


/**
 * 
 * @author Fsig, NerdyGnome
 * 
 * The player class, all player details to be stored
 *
 */
public class Player extends Character implements Paintable {
	private short goalX;
	private short goalY;
	private int coins;	
	private boolean isOnBike;
	private BufferedImage[] images; 
	
	/**
	 * Construct a new player.
	 * 
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param delta
	 * @param startcoins
	 */
	public Player(short x, short y, short width, short height, short delta, int startCoins, BufferedImage[] images){
		super(x,y,width,height,delta);
		this.coins = startCoins;
		this.images = images;
	}
	
	/*
	 * Getters and setters for short and int values
	 */
	public short getGoalX() {
		return goalX;
	}
	
	public short getGoalY() {
		return goalY;
	}
	
	public int getCoins() {
		return coins;
	}
	
	public void setGoalX(short goalX) {
		this.goalX = goalX;
	}
	
	public void setGoalY(short goalY) {
		this.goalY = goalY;
	}
	
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	/*
	 * Getters and setters for boolean and image values
	 */
	
	public boolean isOnBike() {
		return isOnBike;	
	}
	
	public void setOnBike(boolean isOnBike) {
		this.isOnBike = isOnBike;
	}
	
	public BufferedImage[] getImages() {
		return images;
	}
	
	public void setImages(BufferedImage[] images) {
		this.images = images;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(images[super.getAnimation()], (Constants.getWidth()/2) +10, (Constants.getHeight()/2) +10, super.getWidth(), super.getHeight(), null);
	}

}
