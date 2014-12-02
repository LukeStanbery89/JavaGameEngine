package com.lukestanbery.rain.level;

import java.util.ArrayList;
import java.util.List;

import com.lukestanbery.rain.entity.Entity;
import com.lukestanbery.rain.graphics.Screen;
import com.lukestanbery.rain.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	protected int[] tiles;

	private List<Entity> entities = new ArrayList<Entity>();

	public static Level spawn = new SpawnLevel("/textures/levels/spawn.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void generateLevel() {

	}

	protected void loadLevel(String path) {

	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4; // bitwise divide by 16
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
	}

	public void add(Entity e) {
		entities.add(e);
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height) {
			return Tile.voidTile;
		}
		if (tiles[x + y * width] == Tile.COL_SPAWN_FLOOR)
			return Tile.spawnFloorTile;
		if (tiles[x + y * width] == Tile.COL_SPAWN_GRASS)
			return Tile.spawnGrassTile;
		if (tiles[x + y * width] == Tile.COL_SPAWN_HEDGE)
			return Tile.spawnHedgeTile;
		if (tiles[x + y * width] == Tile.COL_SPAWN_WALL1)
			return Tile.spawnWall1Tile;
		if (tiles[x + y * width] == Tile.COL_SPAWN_WALL2)
			return Tile.spawnWall2Tile;
		if (tiles[x + y * width] == Tile.COL_SPAWN_WATER)
			return Tile.spawnWaterTile;
		return Tile.voidTile;
	}
}
