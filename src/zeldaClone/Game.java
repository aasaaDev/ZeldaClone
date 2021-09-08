package zeldaClone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener{
	
	public static int WIDTH = 1280, HEIGHT = 720;
	public static int SCALE = 3;
	public Player player;
	
	public World world;
	public List<Enemy> enemies = new ArrayList<Enemy>();
	
	
	public Game() {
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
		
		new Spritesheet();

		world = new World();
		player = new Player(240,240);

		enemies.add(new Enemy(360,180));
		enemies.add(new Enemy(320,160));
		enemies.add(new Enemy(240,480));
		enemies.add(new Enemy(120,680));
		

		
	}
	
	public void tick() {
		player.tick();
		
		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).tick();
		}
	}
	
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
 		Graphics g = bs.getDrawGraphics();
 		
 		g.setColor(Color.black);
 		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
 		
 		player.render(g);
 		for(int i = 0; i < enemies.size(); i++) {
			enemies.get(i).render(g);
		}
 		
 		world.render(g);
 		

 		
 		bs.show();
	}
	

	
	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		
		frame.add(game);
		frame.setTitle("The Legend of Tanner: Runky's Adventure");
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		frame.setVisible(true);
	
		new Thread(game).start();
		
	}

	
	
	@Override
	public void run() {		
		while(true) {
			tick();
			render();
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()) {	
			case KeyEvent.VK_S: player.down = true; break;
	
			case KeyEvent.VK_DOWN: player.down = true; break;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getKeyCode()) {
			case KeyEvent.VK_D: player.right = true; break;
			
			case KeyEvent.VK_RIGHT: player.right = true; break;
			
			case KeyEvent.VK_A: player.left = true; break;
			
			case KeyEvent.VK_LEFT: player.left = true; break;
			
			case KeyEvent.VK_W: player.up = true; break;
			
			case KeyEvent.VK_UP: player.up = true; break;
			
			case KeyEvent.VK_S: player.down = true; break;
			
			case KeyEvent.VK_DOWN: player.down = true; break;
			
			case KeyEvent.VK_SPACE: player.shoot = true; break;
			
			case KeyEvent.VK_SHIFT: player.sword = true; break;
			
			default: break;
			
		/*V1 keylistener for movement
		if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			player.up= true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}
		*/
		}
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
		switch(e.getKeyCode()) {
		case KeyEvent.VK_D: player.right = false; break;
		
		case KeyEvent.VK_RIGHT: player.right = false; break;
		
		case KeyEvent.VK_A: player.left = false; break;
		
		case KeyEvent.VK_LEFT: player.left = false; break;
		
		case KeyEvent.VK_W: player.up = false; break;
		
		case KeyEvent.VK_UP: player.up = false; break;
		
		case KeyEvent.VK_S: player.down = false; break;
		
		case KeyEvent.VK_DOWN: player.down = false; break;
	
		default: break;
		
		/*V1 keylistener for movement
		if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP) {
			player.up= false;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}
		
		*/
		}
	
	}
}