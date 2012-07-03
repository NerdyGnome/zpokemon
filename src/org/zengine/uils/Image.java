package org.zengine.uils;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

/**
 * 
 * @author Troy
 *
 */
public class Image {
	private static final Image instance = new Image();
	
	/**
	 * Load a image.
	 * 
	 * @param ref
	 * @return BufferedImage
	 */
	public static BufferedImage loadImage(String ref){
		BufferedImage bimg = null;
		try{
			bimg = ImageIO.read(instance.getClass().getClassLoader().getResource(ref));
		}catch(Exception e){e.printStackTrace();}
		return bimg;
	}
	
	/**
	 * Load a image array.
	 * 
	 * @param img
	 * @param cols
	 * @param rows
	 * @return BufferedImage[]
	 */
    public static BufferedImage[] splitImage(BufferedImage img, int cols, int rows) { 	
    	int w = img.getWidth()/cols;
        int h = img.getHeight()/rows;
        int num = 0;
		int imageType = img.getType();
		if(imageType == 0) imageType = 5;
        BufferedImage imgs[] = new BufferedImage[w*h];
        for(int y = 0; y < rows; y++) {
            for(int x = 0; x < cols; x++) {
                imgs[num] = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g = imgs[num].createGraphics();
                g.setComposite(AlphaComposite.Src);  
                g.drawImage(img, 0, 0, w, h, w*x, h*y, w*x+w, h*y+h, null);
                g.dispose();
                num++;
            }
        }
        return imgs;
    }
	
	/**
	 * Make's a certain colour transparent.
	 * @param source
	 * @param color
	 * @return BufferedImage
	 */
    public static BufferedImage makeColorTransparent(String ref, Color color) {
    	BufferedImage image = loadImage(ref);
        BufferedImage dimg = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);  
        Graphics2D g = dimg.createGraphics();  
        g.setComposite(AlphaComposite.Src);  
        g.drawImage(image, null, 0, 0);  
        g.dispose();  
        for(int i = 0; i < dimg.getHeight(); i++) {  
            for(int j = 0; j < dimg.getWidth(); j++) {  
                if(dimg.getRGB(j, i) == color.getRGB()) {  
                dimg.setRGB(j, i, 0x8F1C1C);  
                }  
            }  
        }  
        return dimg;  
    }
	
	/**
	 * Flips a given image horizontally.
	 * @param source The source image.
	 * @return BufferedImage
	 */
	public static BufferedImage flipHorizontally(BufferedImage source) {  
		int w = source.getWidth();  
		int h = source.getHeight();  
		BufferedImage image = new BufferedImage(w, h, source.getType());  
		Graphics2D g = image.createGraphics();  
		g.drawImage(source, 0, 0, w, h, w, 0, 0, h, null);  
		g.dispose();  
		return image;  
	}  

	/**
	 * Flips a given image vertically.
	 * @param source The source image.
	 * @return BufferedImage
	 */
	public static BufferedImage flipVertically(BufferedImage source) {  
		int w = source.getWidth();  
		int h = source.getHeight();  
		BufferedImage image = new BufferedImage(w, h, source.getType());  
		Graphics2D g = image.createGraphics();  
		g.drawImage(source, 0, 0, w, h, 0, h, w, 0, null);  
		g.dispose();  
		return image;  
	}  

	/**
	 * Rotates a given image to a given angle.
	 * @param source The source image.
	 * @param angle The angle to rotate by (in degrees).
	 * @return BufferedImage
	 */
	public static BufferedImage rotate(BufferedImage source, int angle) {  
		int w = source.getWidth();  
		int h = source.getHeight();  
		BufferedImage image = new BufferedImage(w, h, source.getType());  
		Graphics2D g = image.createGraphics();  
		g.rotate(Math.toRadians(angle), w / 2, h / 2);  
		g.drawImage(source, null, 0, 0);  
		return image;  
	}  

	/**
	 * Resizes a given image to a given width and height.
	 * @param source The source image.
	 * @param width The new width.
	 * @param height The new height.
	 * @return BufferedImage
	 */
	public static BufferedImage resize(BufferedImage source, int width, int height) {  
		int w = source.getWidth();  
		int h = source.getHeight();  
		BufferedImage image = new BufferedImage(width, height, source.getType());  
		Graphics2D g = image.createGraphics();  
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);  
		g.drawImage(source, 0, 0, width, height, 0, 0, w, h, null);  
		g.dispose();  
		return image;  
	}  
	
}