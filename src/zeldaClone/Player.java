package zeldaClone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.List;
import java.util.ArrayList;

public class Player extends Rectangle {

	public int spd = 4;
	public boolean left,down,up,right,shoot,sword;
	public int trueOrFalse1,trueOrFalse2,trueOrFalse3,trueOrFalse4,trueOrFalse5,trueOrFalse6; 
	
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	
	public static List<Bullet> bullets = new ArrayList<Bullet>();
	
	public int dir = 0;
	
	public Player(int x, int y) {
		super((x-16),(y-16),64,64);
	}
	
	public void tick() {
		
		boolean moved = false;
		if(left && World.isFree(x-spd, y)) {
			trueOrFalse1 = 1;
		}else {
			trueOrFalse1 = 0;
		}
		
		if(right && World.isFree(x+spd, y)) {
			trueOrFalse2 = 1;
		}else {
			trueOrFalse2 = 0;
		}
		
		if(up && World.isFree(x, y-spd)) {
			trueOrFalse3 = 1;
		}else {
			trueOrFalse3 = 0;
		}
		
		if(down && World.isFree(x, y+spd) ) {
			trueOrFalse4 = 1;
		}else {
			trueOrFalse4 = 0;
		}
		
		if(shoot) {
			trueOrFalse5 = 1;
		}else {
			trueOrFalse5 = 0;
		}
		
		if(sword) {
			trueOrFalse6 = 1;
		}else {
			trueOrFalse6 = 0;
		}
		
		switch(trueOrFalse1) {
		case 1 : if(left) {
			x-=spd;
			moved = true;
			dir = -1;
		}
		break;
		case 0 : break;
		}
		
		switch(trueOrFalse2) {
		case 1 : if(right) {
			x+=spd;
			moved = true;
			dir = 1; 
		}
		break;
		case 0 : break;
		}		
		
		switch(trueOrFalse3) {
		case 1 : y-=spd;
				 moved = true;
		case 0 : break;
		}
		
		switch(trueOrFalse4) {
		case 1 : y+=spd;
				 moved = true;
		case 0 : break;
		}		
		
		switch(trueOrFalse5) {
		case 1: if(shoot) {
					shoot = false;
					bullets.add(new Bullet(x,y,dir));
				}
		case 0: break;
		}
		
		switch(trueOrFalse6) {
		case 1: if(sword) {
					sword = false;
				}
		case 0: break;
		}
		
		if(moved) {
			curFrames++;
			if(curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.player_front.length) {
					curAnimation = 0;
				}
				
			}	
		}
		
		if(shoot) {
			shoot = false;
			bullets.add(new Bullet(x, y, dir));
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
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
		g.drawImage(Spritesheet.player_front[curAnimation], x, y, 64, 64, null);
	
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}		
	}
	
}
