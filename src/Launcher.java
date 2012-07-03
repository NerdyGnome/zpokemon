import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

import org.zengine.Constants;
import org.zengine.Game;


/**
 * 
 * @author Troy
 *
 */
public class Launcher {

	public Launcher(String gameName){
		try{
			 URLClassLoader scriptLoader = new URLClassLoader(new URL[] {new URL("file://" + new File("").getAbsolutePath() + "/") });
			 final Game game = (Game)scriptLoader.loadClass(gameName).newInstance();
			 
			 if(game != null){
				 game.onStart();
				 game.start();
				 game.onEnd();
				 
				 if(Constants.getGameFrame().isVisible()){
					 Constants.getGameFrame().dispose();
					 Constants.getRender().destroy();
				 }
			 }else{
				 System.out.println("Failed to load your game.");
			 }
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Failed to load your game.");
			System.exit(-1);
		}
		
		System.exit(0);
	}
	
	public static void main(String[] args){
		if(args.length < 1){
			System.out.println("Correct usage: java -jar zgame.jar YourGameClass");
			System.exit(0);
		}
		
		new Launcher(args[0]);
	}

}