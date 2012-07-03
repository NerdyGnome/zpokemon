package org.zengine;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JFrame;

import org.zengine.graphics.GameCanvas;
import org.zengine.graphics.Render;

/**
 * 
 * @author Troy
 *
 */
public class GameFrame extends JFrame implements ComponentListener{
	private static final long serialVersionUID = -2508508456984008132L;
	
	/**
	 * Construct a new gameframe.
	 * 
	 * @param title
	 * @param game
	 */
	public GameFrame(String title, Game game){
		this.setTitle(title);
		this.setSize(Constants.getWidth(), Constants.getHeight());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		Constants.setScreenWidth((int)dim.getWidth());
		Constants.setScreenHeight((int)dim.getHeight());
		
		GameCanvas canvas = new GameCanvas();
		
		Constants.setGameFrame(this);
		Constants.setGameCanvas(canvas);
		Constants.setRender(new Render());
		Constants.setGame(game);
		
		this.addComponentListener(this);
		this.add(canvas);
		this.setVisible(true);
		
		canvas.init();
	}
	
	/**
	 * Set the gameframe to fullscreen or normal.
	 * 
	 * @param fullscreen
	 */
	public void setFullscreen(boolean fullscreen){
		this.dispose();
		
		if(fullscreen){
			this.setSize(Constants.getScreenWidth(), Constants.getScreenHeight());
			this.setLocation(0, 0);
		}else{
			this.setSize(Constants.getPreferedWidth(), Constants.getPreferedHeight());
			this.setLocationRelativeTo(null);
		}
		
		System.out.println(Constants.getWidth());
			
		this.setUndecorated(fullscreen);
		this.setVisible(true);
	}

	@Override
	public void componentResized(ComponentEvent e) {
		Constants.setWidth(getWidth());
		Constants.setHeight(getHeight());
	}

	public void componentHidden(ComponentEvent arg0) {}
	public void componentMoved(ComponentEvent arg0) {}
	public void componentShown(ComponentEvent arg0) {}

}
