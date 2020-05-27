//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
package Starfighter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;

public class Ammo extends MovingThing {
	private int speed;
	final static int length = 25;
	private Image image;

	public Ammo() {
		this(0, 0, 0);
	}

	public Ammo(int x, int y) {
		this(x, y, 1);
	}

	public Ammo(int x, int y, int s) {
		super(x, y, length, length);
		speed = s;
		try {
			URL url = getClass().getResource("ammo2.png");
			image = ImageIO.read(url);

		} catch (Exception e) {
			System.out.println("Error in getting the ammo image");
		}
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public int getSpeed() {
		return speed;
	}

	public void draw(Graphics window) {
		window.setColor(Color.yellow);
		window.drawImage(image, getX(), getY(), length, length, null);

	}

	public void move(String direction) {
		if (direction.equals("UP")) {
			setY(getY() - speed);
		}
	}

	public boolean collisionDetector(Alien alienone, Alien alientwo) {
		if (this.getY() <= 0) {
			return true;
		} else if (this.getX() >= alienone.getX() - length && this.getX() <= alienone.getX() + alienone.getWidth()
				&& this.getY() <= alienone.getY() + alienone.getHeight()) {
			return true;
		} else if (this.getX() >= alientwo.getX() - length && this.getX() <= alientwo.getX() + alientwo.getWidth()
				&& this.getY() <= alientwo.getY() + alientwo.getHeight()) {
			return true;
		}

		return false;
	}

	public int collisionDetector(AlienHorde horde) {
		for (Alien alien : horde.getHorde()) {
			if (this.getX() >= alien.getX() + AlienHorde.length / 7
					&& this.getX() <= alien.getX() + alien.getWidth() - AlienHorde.length / 7
					&& this.getY() <= alien.getY() + alien.getHeight() - AlienHorde.length / 3
					&& this.getY() >= alien.getY() + AlienHorde.length / 3) {
				return horde.getHorde().indexOf(alien);
			}
		}
		return -1;
	}

	public String toString() {
		return "Length: " + length + " Speed: " + speed;
	}
}
