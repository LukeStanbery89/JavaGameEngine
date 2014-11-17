package com.lukestanbery.rain.graphics;

import java.util.Random;

public class Screen {

	private final int TILE_SIZE = 16,
					  TILE_MASK = (int)Math.sqrt(TILE_SIZE),
					  MAP_SIZE = 64,
					  MAP_SIZE_MASK = MAP_SIZE - 1;
	
	private int width, 
			    height;
	public int[] pixels,
				 tiles = new int[MAP_SIZE * MAP_SIZE];
	
	private Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width * height];
		
		for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++){
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clear(){
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0x000000;
		}
	}
	
	public void render(int xOffset, int yOffset){
		for(int y = 0; y < height; y++){
			int yp = y + yOffset;
			if(yp < 0 || yp >= height) continue;
			for(int x = 0; x < width; x++){
				int xp = x + xOffset;
				if(xp < 0 || xp >= width) continue;
				pixels[xp + yp * width] = Sprite.grass.pixels[(x & 15) + (y & 15) * Sprite.grass.SIZE];
			}
		}
	}
}