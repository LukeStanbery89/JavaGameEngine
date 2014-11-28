package com.lukestanbery.rain.level.tile;

import com.lukestanbery.rain.graphics.Screen;
import com.lukestanbery.rain.graphics.Sprite;
import com.lukestanbery.rain.level.tile.spawn_level.SpawnFloorTile;
import com.lukestanbery.rain.level.tile.spawn_level.SpawnGrassTile;
import com.lukestanbery.rain.level.tile.spawn_level.SpawnHedgeTile;
import com.lukestanbery.rain.level.tile.spawn_level.SpawnWall1Tile;
import com.lukestanbery.rain.level.tile.spawn_level.SpawnWall2Tile;
import com.lukestanbery.rain.level.tile.spawn_level.SpawnWaterTile;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public static Tile spawnGrassTile = new SpawnGrassTile(Sprite.spawnGrass);
	public static Tile spawnHedgeTile = new SpawnHedgeTile(Sprite.spawnHedge);
	public static Tile spawnWaterTile = new SpawnWaterTile(Sprite.spawnWater);
	public static Tile spawnWall1Tile = new SpawnWall1Tile(Sprite.spawnWall1);
	public static Tile spawnWall2Tile = new SpawnWall2Tile(Sprite.spawnWall2);
	public static Tile spawnFloorTile = new SpawnFloorTile(Sprite.spawnFloor);

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}

}
