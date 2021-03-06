package com.lukestanbery.rain.level.tile.spawn_level;

import com.lukestanbery.rain.graphics.Screen;
import com.lukestanbery.rain.graphics.Sprite;
import com.lukestanbery.rain.level.tile.Tile;

public class SpawnHedgeTile extends Tile {

	public SpawnHedgeTile(Sprite sprite) {
		super(sprite);
	}

	public boolean solid() {
		return true;
	}

	public boolean breakable() {
		return true;
	}

	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this.sprite); // "<< 4" = divide by 16
	}
}
