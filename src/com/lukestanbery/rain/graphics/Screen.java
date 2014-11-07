package com.lukestanbery.rain.graphics;

import java.util.Random;

public class Screen {

	private final int TILE_SIZE = 16,
					  MAP_SIZE = 64;
	
	private int width, 
			    height;
	public int[] pixels,
				 tiles = new int[MAP_SIZE * MAP_SIZE];
	
	private Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < 64*64; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0x000000;
		}
	}
	
	public void render(){
		for(int y = 0; y < height; y++){
			int yy = y;
			if(yy < 0 || yy >= height) break;
			for(int x = 0; x < width; x++){
				int xx = x;
				if(xx < 0 || xx >= width) break;
				int tileIndex = (xx >> (int)Math.sqrt(TILE_SIZE)) + (yy >> (int)Math.sqrt(TILE_SIZE)) * MAP_SIZE;	// Used bitwise operators for performance boost
				pixels[x + (y * width)] = tiles[tileIndex];		// Draw tile color
			}
		}
	}
}
