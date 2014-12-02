package com.lukestanbery.rain.entity.mob;

import com.lukestanbery.rain.entity.Entity;
import com.lukestanbery.rain.entity.projectile.Projectile;
import com.lukestanbery.rain.entity.projectile.WizardProjectile;
import com.lukestanbery.rain.graphics.Sprite;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 0;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	public void update() {

	}

	protected void shoot(int x, int y, double dir) {
		// dir = Math.toDegrees(dir);
		Projectile p = new WizardProjectile(x, y, (int) dir);
	}

	private boolean collision(int xa, int ya) {
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 14 - 7) / 16;
			int yt = ((y + ya) + c / 2 * 12 + 3) / 16;
			if (level.getTile(xt, yt).solid())
				return true;
		}
		if (level.getTile((x + xa) / 16, (y + ya) / 16).solid()) {
			return true;
		} else {
			return false;
		}
	}
}
