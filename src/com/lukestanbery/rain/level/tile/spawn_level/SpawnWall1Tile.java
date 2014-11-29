package com.lukestanbery.rain.level.tile.spawn_level;

import com.lukestanbery.rain.graphics.Screen;
import com.lukestanbery.rain.graphics.Sprite;
import com.lukestanbery.rain.level.tile.Tile;

public class SpawnWall1Tile extends Tile {

	public SpawnWall1Tile(Sprite sprite) {
		super(sprite);
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this); // "<< 4" = divide by 16
	}
}
