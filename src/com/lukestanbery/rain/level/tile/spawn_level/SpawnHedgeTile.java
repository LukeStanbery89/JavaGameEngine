package com.lukestanbery.rain.level.tile.spawn_level;

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

}
