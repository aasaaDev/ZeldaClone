package zeldaClone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage spritesheet;
	
	public static BufferedImage[] player_front;
	public static BufferedImage[] enemy_front;
	public static BufferedImage tile_wall;
	public static BufferedImage powaaaah;
	
	public Spritesheet () {
		try {
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player_front = new BufferedImage[2];
		enemy_front = new BufferedImage[2];
		
		player_front[0] = Spritesheet.getSprite(1, 11, 16, 16);
		player_front[1] = Spritesheet.getSprite(17, 11, 16, 16);
		
		
		enemy_front[0] = Spritesheet.getSprite(35, 215, 16, 16);
		enemy_front[1] = Spritesheet.getSprite(35, 215+16, 16, 16);
		
		powaaaah = Spritesheet.getSprite(10, 185, 16, 16);
		tile_wall = Spritesheet.getSprite(280, 221, 16, 16);
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
	}
	
}
