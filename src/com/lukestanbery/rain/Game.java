package com.lukestanbery.rain;

import javax.swing.JFrame;

import com.lukestanbery.rain.graphics.Screen;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;

	// Constants
	final int FRAMES_PER_SECOND = 60;
	
	// Declare/initialize variables
	public static int width = 300,
					  height = width / 16 * 9,
					  scale = 3;
	
	public static String title = "Rain";
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	private Screen screen;
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();
	
	public Game(){
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		screen = new Screen(width, height);
		
		frame = new JFrame();
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Display");
		thread.start();									// This is where the run() method is called
	}

	public synchronized void stop(){
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		long lastTime = System.nanoTime(),
			 timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / (double)FRAMES_PER_SECOND;
		double delta = 0;
		int frames = 0,		// Used for counting frames/updates per second
			updates = 0;
		
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1){
				update();
				updates++;
				delta--;
			}
			render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				frame.setTitle(title + " | " + updates + " ups, " + frames + " fps");
				updates = frames = 0;
			}
		}
		stop();
	}
	
	public void update(){
		// TODO: Write the update() method
	}
	
	public void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}

		screen.clear();
		screen.render();
		
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = screen.pixels[i];
		}
		
		Graphics g = bs.getDrawGraphics();			// Create graphics
		/** Handle Graphics here - MUST STAY IN THIS ORDER **/
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		/** Done with graphics **/
		g.dispose();								// Dispose of graphics after we're done with them
		bs.show();									// Shows the buffer strategy
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.frame.setResizable(false);								// Window cannot be resized
		game.frame.setTitle(Game.title);							// Sets title of the window
		game.frame.add(game);										// Adds the game object to the window
		game.frame.pack();											// Sets window size to preferred size
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Close application when the window is closed
		game.frame.setLocationRelativeTo(null);						// Sets window to center of the screen
		game.frame.setVisible(true); 								// Makes game window visible
		
		game.start();	// Starts the game!
	}
}
