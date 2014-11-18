package com.lukestanbery.rain.entity;

import java.util.Random;

import com.lukestanbery.rain.graphics.Screen;
import com.lukestanbery.rain.level.Level;

public class Entity {

	public int x, y;
	private boolean removed = false;
	protected Level level;
	protected Random random;
	
	public void update(){
		
	}
	
	public void render(Screen screen){
		
	}
	
	public void remove(){
		// Remove from level
		removed = true;
	}
	
	public boolean isRemoved(){
		return removed;
	}
}
