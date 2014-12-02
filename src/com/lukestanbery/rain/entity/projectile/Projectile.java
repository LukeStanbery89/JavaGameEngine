package com.lukestanbery.rain.entity.projectile;

import com.lukestanbery.rain.entity.Entity;
import com.lukestanbery.rain.graphics.Sprite;

public abstract class Projectile extends Entity {

	protected final int xOrigin, yOrigin;
	protected double angle, nx, ny, speed, rateOfFire, range, damage;
	protected Sprite sprite;

	public Projectile(int x, int y, double dir) {
		xOrigin = x;
		yOrigin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

	protected void move() {

	}
}
