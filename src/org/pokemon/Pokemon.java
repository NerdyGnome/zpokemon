package org.pokemon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import org.zengine.Constants;
import org.zengine.Game;
import org.zengine.GameFrame;
import org.zengine.TileMap;
import org.zengine.uils.Image;

/**
 * 
 * @author Troy
 *
 */
public class Pokemon extends Game{
	private final int UPDATE_RATE = 60;
	private final long UPDATE_PERIOD = 1000L / UPDATE_RATE;
	private long beginTime, timeTaken, timeLeft;
	
	public static TileMap tileMap;
	private Player player;
	public static BufferedImage[] tileTextures;
	public static BufferedImage[] playerImages;

	@Override
	public void draw(Graphics g) {	
		tileMap.draw(g);
		player.draw(g);
		
		g.setColor(Color.WHITE);
		g.drawString("FPS: " + Constants.getRender().getFps(), 10, 20);
		g.drawString("Mouse XY: " + Constants.getGameCanvas().getMouseXY().x + "," + Constants.getGameCanvas().getMouseXY().y, 10, 35);
	}

	@Override
	public void onStart() {
		System.out.println("Loading Pokemon.");
		tileTextures = Image.splitImage(Image.makeColorTransparent("resources/sprites/textures/pokemonTextures.gif", new Color(255,0,255)), 15, 15);
		playerImages = Image.splitImage(Image.makeColorTransparent("resources/sprites/players/pokemonPlayer.gif", new Color(255,0,255)), 12, 4);
	}

	@Override
	public void start() {
		/**
		 * Init variables etc...
		 */
		new GameFrame("Pokemon",this);
		tileMap = new TileMap((short)150,(short)150,(short)20,(short)20,tileTextures);
		player = new Player((short)0, (short)0, (short)35, (short)35, (short)0, (short)0, playerImages);
		
		/**
		 * Start the game loop
		 */
		System.out.println("Starting game.");
		gameLoop();
	}
	
	public void gameLoop(){
		while(true){
			try{
				beginTime = System.currentTimeMillis();
					
				/**
				 * Perform and update / moves etc...
				 */
				update();
					
				timeTaken = System.currentTimeMillis() - beginTime;
				timeLeft = (UPDATE_PERIOD - timeTaken);
		
				if(timeLeft < 10) timeLeft = 10;
				
				try {
					Thread.sleep(timeLeft);
				}catch(InterruptedException ex){break;}
			}catch(Exception e){}
		}
	}
	
	/**
	 * Perform game updates and checks in here.
	 */
	public void update(){
		// TODO Fill me in.
	}

	@Override
	public void onEnd() {
		System.out.println("Ending.");
	}

	/**
	 * Key pressed
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_W:
			//if(tileMap.getCurrentY() -1 > -1){
				tileMap.setCurrentY((short) (tileMap.getCurrentY() +1));
				tileMap.setyOffSet((short) (tileMap.getyOffSet() +1));
				player.setY((short) (player.getY()+1));
			//}else{
				//System.out.println("TileY > TileMap Rows");
			//}
			break;
		case KeyEvent.VK_S:
			//if(tileMap.getCurrentY() +31 < tileMap.getTileRows()){
				tileMap.setCurrentY((short) (tileMap.getCurrentY() -1));
				tileMap.setyOffSet((short) (tileMap.getyOffSet() -1));
				player.setY((short) (player.getY()-1));
			//}else{
				//System.out.println("TileY can't go below 0");
			//}
			break;
		case KeyEvent.VK_D:
			//if(tileMap.getCurrentX() +41 < tileMap.getTileCols()){
				tileMap.setCurrentX((short) (tileMap.getCurrentX() +1));
				tileMap.setxOffSet((short) (tileMap.getxOffSet() -1));
				player.setX((short) (player.getX()+1));
			//}else{
				//System.out.println("TileX can't go below 0");
			//}
			break;
		case KeyEvent.VK_A:
			//if(tileMap.getCurrentX() -1 > -1){
				tileMap.setCurrentX((short) (tileMap.getCurrentX() -1));
				tileMap.setxOffSet((short) (tileMap.getxOffSet() +1));
				player.setX((short) (player.getX()-1));
			//}else{
				//System.out.println("TileX > TileMap Cols");
			//}
			break;
		}
		
		//System.out.println("XY: " + tileMap.getCurrentX() + "," + tileMap.getCurrentY());
		//System.out.println("Player XY: " + player.getX() + "," + player.getY());
	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {}

	/**
	 * These event's will most likely be forwarded
	 * onto another class to deal with them appropriately.
	 */
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseMoved(MouseEvent e) {}
	public void mouseDragged(MouseEvent e) {}

}