package org.zengine.graphics;

import org.zengine.Constants;

/**
 * 
 * @author Troy
 * 
 * Rendering at more then 30 FPS seems to cause some issues with
 * moving up or to the left where it will cause minor flickering
 * on the tile map.
 * 
 * For now, we are fine using 30 FPS though because nothing in
 * the game will need to render faster then that.
 *
 */
public class Render {
	private Thread renderThread;
	
	private final int UPDATE_RATE = 30;
	private final long UPDATE_PERIOD = 1000L / UPDATE_RATE;
	private long beginTime, timeTaken, timeLeft;
	
	private int fps = 0;
	private int frames = 0;
	private long totalTime = 0;
	private long curTime = System.currentTimeMillis();
	private long lastTime = curTime;
	
	public Render(){
	    renderThread = new Thread() {
			@Override
			public void run(){
				loop();
			}
		};
		renderThread.start();
	}
	
	/**
	 * The rendering loop.
	 */
	private void loop(){
		while(true){
			try{
				lastTime = curTime;
				curTime = System.currentTimeMillis();
				totalTime += curTime - lastTime;
				if(totalTime > 1000){
					totalTime -= 1000;
					fps = frames;
					frames = 0;
				} 
				++frames;
			        
				beginTime = System.currentTimeMillis();

				//Draw the buffer.
				Constants.getGameCanvas().draw();			
					
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
	 * This will destroy the rendered disabling all graphics.
	 */
	public void destroy(){
		while(!renderThread.isInterrupted())
			renderThread.interrupt();
		
		System.out.println("The Render thread has been destroyed.");
	}
	
	public int getFps(){
		return this.fps;
	}

}