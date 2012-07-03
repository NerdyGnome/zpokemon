package org.zengine;

/**
 * 
 * @author Troy
 *
 */
public class Tile {
	private int x;
	private int y;
	private int state;
	private int interactive;
	private int image;
	
	/**
	 * Create a new tile.
	 * 
	 * @param x
	 * @param y
	 * @param state
	 * @param img
	 * @param interactive
	 */
	public Tile(int x, int y, int state, int img, int interactive){
		this.x = x;
		this.y = y;
		this.state = state;
		this.interactive = interactive;
		this.image = img;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getState() {
		return state;
	}

	public int getInteractive() {
		return interactive;
	}

	public int getImage() {
		return image;
	}

	public void setState(int state) {
		this.state = state;
	}

	public void setInteractive(int interactive) {
		this.interactive = interactive;
	}

	public void setImage(int image) {
		this.image = image;
	}

}
