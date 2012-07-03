package org.zengine;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import org.zengine.graphics.Paintable;

/**
 * 
 * @author Troy
 *
 */
public class TileMap implements Paintable{
	private short currentX;
	private short currentY;
	private short xOffSet;
	private short yOffSet;
	private short tileCols;
	private short tileRows;
	private short tileWidth;
	private short tileCount;
	private short tileHeight;
	private Rectangle viewport;
	private Tile[][] tiles;
	private BufferedImage[] images;
	
	/**
	 * Create a new TileMap.
	 * 
	 * @param tileCols
	 * @param tileRows
	 * @param tileWidth
	 * @param tileHeight
	 * @param images
	 */
	public TileMap(short tileCols, short tileRows, short tileWidth, short tileHeight, BufferedImage[] images){
		this.tileCols = tileCols;
		this.tileRows = tileRows;
		this.tileWidth = tileWidth;
		this.tileHeight = tileHeight;
		this.images = images;
		this.xOffSet = 10;
		this.yOffSet = 10;
		
		this.currentX = 0;
		this.currentY = 0;
		
		tileCount = (short) (tileCols * tileRows);
		tiles = new Tile[tileCols][tileRows];
		
		for(short a = 0; a < tileRows; a++){
			for(short b = 0; b < tileCols; b++){
				tiles[b][a] = new Tile(b, a, 0, 0, 0);	
			}
		}
		
		viewport = new Rectangle(0, 
				0, 
				Constants.getWidth(), 
				Constants.getHeight());
		
		System.out.println(viewport.getX() + "," + viewport.getY() + "," + viewport.getWidth() + "," + viewport.getHeight());
		
		//Set some water in the top left hand corner.
		tiles[0][0].setImage(134);
		tiles[1][0].setImage(134);
		tiles[2][0].setImage(134);
		tiles[3][0].setImage(134);
		tiles[4][0].setImage(134);
		tiles[5][0].setImage(134);
		
		//And add in some fences at the corners of the map.
		tiles[tileCols-1][0].setImage(3);
		tiles[0][tileRows-1].setImage(4);
		tiles[tileCols-1][tileRows-1].setImage(5);
	}

	public short getCurrentX() {
		return currentX;
	}

	public short getCurrentY() {
		return currentY;
	}

	public void setCurrentX(short currentX) {
		this.currentX = currentX;
	}

	public void setCurrentY(short currentY) {
		this.currentY = currentY;
	}

	public Rectangle getViewport() {
		return viewport;
	}

	public void setViewport(Rectangle viewport) {
		this.viewport = viewport;
	}

	public short getxOffSet() {
		return xOffSet;
	}

	public short getyOffSet() {
		return yOffSet;
	}

	public void setxOffSet(short xOffSet) {
		this.xOffSet = xOffSet;
	}

	public void setyOffSet(short yOffSet) {
		this.yOffSet = yOffSet;
	}

	public short getTileWidth() {
		return tileWidth;
	}

	public short getTileHeight() {
		return tileHeight;
	}

	public void setTileWidth(short tileWidth) {
		this.tileWidth = tileWidth;
	}

	public void setTileHeight(short tileHeight) {
		this.tileHeight = tileHeight;
	}

	public short getTileCols() {
		return tileCols;
	}

	public short getTileRows() {
		return tileRows;
	}

	public short getTileCount() {
		return tileCount;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public void setTileCols(short tileCols) {
		this.tileCols = tileCols;
	}

	public void setTileRows(short tileRows) {
		this.tileRows = tileRows;
	}

	public void setTileCount(short tileCount) {
		this.tileCount = tileCount;
	}

	public void setTiles(Tile[][] tiles) {
		this.tiles = tiles;
	}

	public BufferedImage[] getImages() {
		return images;
	}


	public void setImages(BufferedImage[] images) {
		this.images = images;
	}


	@Override
	public void draw(Graphics g) {
		if(Constants.getWidth() > viewport.getWidth()){
			System.out.println("Updating viewport.");
			viewport = new Rectangle(0, 
					0, 
					Constants.getWidth(), 
					Constants.getHeight());
		}
		
		g.setColor(Color.WHITE);
		
		/**
		 * Draw the map.
		 */
		
		try{
			
		
		for(short a = 0; a < tileRows; a++){
			for(short b = 0; b < tileCols; b++){
				if(viewport.contains(new Point((tiles[b][a].getX() * tileWidth) + (xOffSet * tileWidth), 
												(tiles[b][a].getY() * tileHeight) + (yOffSet * tileHeight)))){
					g.drawImage(images[tiles[b][a].getImage()], 
							(tiles[b][a].getX() * tileWidth) + (xOffSet * tileWidth), 
							(tiles[b][a].getY() * tileHeight) + (yOffSet * tileHeight), 
							tileWidth, 
							tileHeight, 
							null);
				}
			}
		}
		
		}catch(Exception e){
			e.printStackTrace();
			System.exit(-1);
		}
	}

}