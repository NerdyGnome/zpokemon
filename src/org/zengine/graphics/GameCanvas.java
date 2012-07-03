package org.zengine.graphics;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferStrategy;

import org.zengine.Constants;

/**
 * 
 * @author Troy
 *
 */
public class GameCanvas extends Canvas implements MouseListener, MouseMotionListener, KeyListener{
	private static final long serialVersionUID = 7086780417047334597L;
	
	private BufferStrategy buffer;
	private Point mouseXY = new Point(0,0);
	
	public GameCanvas(){
		super();
		this.setBackground(Color.BLACK);
		this.setIgnoreRepaint(true);
		
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addKeyListener(this);
	}
	
	/**
	 * Initlise variables.
	 */
	public void init(){
		//Create two buffer strategy's for double buffering.
		this.createBufferStrategy(2);
		buffer = getBufferStrategy();
	}
	
	/**
	 * The render method, this will be called by Render to display the graphics.
	 * 
	 * @param g
	 * @param backBuffer
	 */
	public void draw(){	
		Graphics g = buffer.getDrawGraphics();  
		g.clearRect(0, 0, getWidth(), getHeight());
		g.setClip(0, 0, Constants.getWidth(), Constants.getHeight());
		 
		//Draw the game's graphics.
		Constants.getGame().draw(g);
		 
		//Dispose of the graphics.
		g.dispose();
		 
		// flip/draw the backbuffer to the canvas component.
		if(!buffer.contentsLost())
			buffer.show();
		 
		//Synchronise with the display refresh rate.
		Toolkit.getDefaultToolkit().sync();
	}

	public Point getMouseXY() {
		return mouseXY;
	}

	public void setMouseXY(Point mouseXY) {
		this.mouseXY = mouseXY;
	}

	/**
	 * MouseListener
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		Constants.getGame().mouseClicked(e);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Constants.getGame().mouseEntered(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Constants.getGame().mouseExited(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Constants.getGame().mousePressed(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Constants.getGame().mouseReleased(e);
	}

	/**
	 * MouseMotionListener
	 */
	@Override
	public void mouseMoved(MouseEvent e) {
		mouseXY = new Point(e.getX(),e.getY());
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		Constants.getGame().mouseDragged(e);
	}
	
	/**
	 * KeyListener
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_ESCAPE:
			if(Constants.isFullscreen()){
				Constants.setFullscreen(false);
				Constants.getGameFrame().setFullscreen(false);
			}else{
				Constants.setFullscreen(true);
				Constants.getGameFrame().setFullscreen(true);
			}
			break;
		}
		
		Constants.getGame().keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		Constants.getGame().keyReleased(e);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		Constants.getGame().keyTyped(e);
	}
}