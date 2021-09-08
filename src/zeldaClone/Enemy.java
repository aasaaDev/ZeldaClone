package zeldaClone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;

public class Enemy extends Rectangle {

	public int spd = 2;
	public int left=0,down=0,up=0,right=1,shoot=1,sword=0;
	
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	
	public static List<Bullet> bullets = new ArrayList<Bullet>();
	
	public int dir = 0;
	
	public Enemy(int x, int y) {
		super((x-16),(y-16),64,64);
	}
	
	public void tick() {
		
		boolean moved = false;
		if(right == 1 && World.isFree(x+spd, y)) {
			x++;
			moved = true;
		}
		
		
		if(moved) {
			curFrames++;
			if(curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.enemy_front.length) {
					curAnimation = 0;
				}
				
			}	
		}
		
		
		/*
		if(right && World.isFree(x+spd, y)) {
			x+=spd;
		}else if(left && World.isFree(x-spd, y)) {
			x-=spd;
		} else;
		
		if(up && World.isFree(x, y-spd)) {
			y-=spd;
		}else if(down && World.isFree(x, y+spd)) {
			y+=spd;
		}else;
		*/
	}
	
	public void render(Graphics g) {
		//g.setColor(Color.red);
		//g.fillRect(x, y, width, height);
		g.drawImage(Spritesheet.enemy_front[curAnimation], x, y, 64, 64, null);
	}
	
}
