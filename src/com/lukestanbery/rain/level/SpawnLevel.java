package com.lukestanbery.rain.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.lukestanbery.rain.level.tile.Tile;

public class SpawnLevel extends Level {

	private int[] levelPixels;

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			System.out.println("Opening file.");
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			System.out.println("Setting height and width.");
			int w = image.getWidth();
			int h = image.getHeight();
			tiles = new Tile[w * h];
			levelPixels = new int[w * h];
			System.out.println("Setting levelPixels.");
			image.getRGB(0, 0, w, h, levelPixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load file!");
		}
	}

	// Grass = 0xff00ff00
	// Flower = 0xffff00
	// Rock = 0X7f7f00
	protected void generateLevel() {
		for (int i = 0; i < levelPixels.length; i++) {
			if (levelPixels[i] == 0xff00ff00) {
				tiles[i] = Tile.grass;
			} else if (levelPixels[i] == 0xffffff00) {
				tiles[i] = Tile.flower;
			} else if (levelPixels[i] == 0xff7f7f00) {
				tiles[i] = Tile.rock;
			}
		}
	}
}
