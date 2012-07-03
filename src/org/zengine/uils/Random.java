package org.zengine.uils;

/**
 * 
 * @author Troy
 *
 */
public class Random {
	private java.util.Random r = new java.util.Random();
	
	public int random(int min, int max) throws InterruptedException{
		if(min > max)
			throw new IllegalArgumentException("Maximun is less then minimun.");
		else if(min == max)
			return min;
		else
			return min + r.nextInt(max - min);
	}

	public boolean nextBoolean() throws InterruptedException{
		return r.nextBoolean();
	}
	
	public void nextBytes(byte[] bytes) throws InterruptedException{
		r.nextBytes(bytes);
	}
	
	public double nextDouble() throws InterruptedException{
		return r.nextDouble();
	}
	
	public float nextFloat() throws InterruptedException{
		return r.nextFloat();
	}
	
	public double nextGaussian() throws InterruptedException{
		return r.nextGaussian();
	}
	
	public int nextInt() throws InterruptedException{
		return r.nextInt();
	}
	
	public int nextInt(int i) throws InterruptedException{
		return r.nextInt(i);
	}
}