package com.lukestanbery.rain.level.tile;

import com.lukestanbery.rain.graphics.Screen;
import com.lukestanbery.rain.graphics.Sprite;

public class FlowerTile extends Tile {

	public FlowerTile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen){
		screen.renderTile(x << 4, y << 4, this.sprite); // "<< 4" = divide by 16
	}

}
