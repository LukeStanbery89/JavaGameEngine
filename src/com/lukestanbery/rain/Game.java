package com.lukestanbery.rain;

import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
	
	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = width / 16 * 9;
	public static int scale = 3;
	
	private Thread thread;
	private JFrame frame;
	private boolean running = false;
	
	public Game(){
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size);
		
		frame = new JFrame();
	}
	
	public synchronized void start(){
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
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
		while(running){
			update();
			render();
		}
	}
	
	public void update(){
		// TODO: Write the update() method
	}
	
	public void render(){
		// TODO: Finish the render() method
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			return;
		}
	}
	
	public static void main(String[] args){
		Game game = new Game();
		game.frame.setResizable(false);								// Window cannot be resized
		game.frame.setTitle("Rain");								// Sets title of the window
		game.frame.add(game);										// Adds the game object to the window
		game.frame.pack();											// Sets window size to preferred size
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// Close application when the window is closed
		game.frame.setLocationRelativeTo(null);						// Sets window to center of the screen
		game.frame.setVisible(true); 								// Makes game window visible
		
		game.start();	// Starts the game!
	}
}
