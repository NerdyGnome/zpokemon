package org.zengine;

import org.zengine.graphics.Paintable;


/**
 * 
 * @author Troy
 *
 */
public abstract class Game implements Paintable, MouseListener, MouseMotionListener, KeyListener{
	public abstract void onStart();
	public abstract void start();
	public abstract void onEnd();
}
