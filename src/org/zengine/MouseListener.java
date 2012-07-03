package org.zengine;

import java.awt.event.MouseEvent;

/**
 * 
 * @author Troy
 *
 */
public interface MouseListener {
	public void mouseClicked(MouseEvent e);
	public void mouseEntered(MouseEvent e);
	public void mouseExited(MouseEvent e);
	public void mousePressed(MouseEvent e);
	public void mouseReleased(MouseEvent e);
}
