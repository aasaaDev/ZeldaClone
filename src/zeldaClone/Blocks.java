package zeldaClone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Blocks extends Rectangle {
	
	public Blocks(int x, int y) {
		super(x,y,64,64);
	}
	
	
	public void render(Graphics g) {
		//g.setColor(Color.yellow);
		//g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.tile_wall, x, y, 64, 64, null);
	}
	
}
