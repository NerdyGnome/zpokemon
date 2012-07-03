package org.zengine;

import java.awt.event.KeyEvent;

/**
 * 
 * @author Troy
 *
 */
public interface KeyListener {
	public void keyPressed(KeyEvent e);
	public void keyReleased(KeyEvent e);
	public void keyTyped(KeyEvent e);
}
