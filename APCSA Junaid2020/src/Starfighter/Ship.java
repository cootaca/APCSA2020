//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
package Starfighter;

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Ship extends MovingThing {
	private int speed;
	private Image image;

	public Ship() {
		this(10, 10, 10, 10, 10);
	}

	public Ship(int x, int y) {
		super(x, y);
	}

	public Ship(int x, int y, int s) {
		setPos(x, y);
		speed = s;
	}

	public Ship(int x, int y, int w, int h, int s) {
		super(x, y, w, h);
		speed = s;
		try {
			URL url = getClass().getResource("spaceShooter1.png");
			image = ImageIO.read(url);

		} catch (Exception e) {
			System.out.println("Error in getting the ship image");
		}
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void move(String direction) {
		if (getX() >= 5 && direction.equals("LEFT")) {
			setX(getX() - speed);
		} else if (getX() <= 795 - getWidth() && direction.equals("RIGHT")) {
			setX(getX() + speed);
		} else if (getY() >= 5 && direction.equals("UP")) {
			setY(getY() - speed);
		} else if (getY() <= 595 - getHeight() * 1.2 && direction.equals("DOWN")) {
			setY(getY() + speed);
		} else if (direction.equals("SPACE")) {

		}

	}

	public int collisionDetector(AlienHorde horde) {
		for (Alien alien : horde.getHorde()) {
			if (this.getX() + this.getWidth() >= alien.getX() + AlienHorde.length / 4
					&& this.getX() <= alien.getX() + alien.getWidth() - AlienHorde.length / 4
					&& this.getY() <= alien.getY() + alien.getHeight() - AlienHorde.length / 4
					&& this.getY() + this.getHeight() >= alien.getY() + AlienHorde.length / 4) {
				return horde.getHorde().indexOf(alien);
			}
		}
		return -1;
	}

	public void draw(Graphics window) {
		window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}

	public String toString() {
		return super.toString() + getSpeed();
	}
}
