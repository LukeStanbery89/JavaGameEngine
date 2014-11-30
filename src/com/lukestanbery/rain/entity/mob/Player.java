package com.lukestanbery.rain.entity.mob;

import com.lukestanbery.rain.Game;
import com.lukestanbery.rain.graphics.Screen;
import com.lukestanbery.rain.graphics.Sprite;
import com.lukestanbery.rain.input.Keyboard;
import com.lukestanbery.rain.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;
	private int anim = 0;
	private boolean walking = false;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_forward;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_forward;
	}

	public void update() {
		int xa = 0, ya = 0;

		if (anim < 7500) {
			anim++;
		} else {
			anim = 0;
		}

		// Handle keyboard events
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;

		// Move
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}

		// Mouse events
		updateShooting();
	}

	private void updateShooting() {
		if (Mouse.getB() == 1) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);

			shoot(x, y, dir);
		}
	}

	public void render(Screen screen) {
		boolean xFlip = false, yFlip = false;

		if (dir == 0) {
			sprite = Sprite.player_forward;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_forward_1;
				} else {
					sprite = Sprite.player_forward_2;
				}
			}
		}
		if (dir == 1 || dir == 3) {
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		if (dir == 2) {
			sprite = Sprite.player_back;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_back_1;
				} else {
					sprite = Sprite.player_back_2;
				}
			}
		}
		if (dir == 3) {
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
			xFlip = true;
		}

		screen.renderPlayer(x - (sprite.SIZE / 2), y - (sprite.SIZE / 2), sprite, xFlip, yFlip);
	}
}
