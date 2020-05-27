package Starfighter;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde {
	private static List<Alien> aliens;
	public static final int length = 70;
	public static final int speed = 10;

	public AlienHorde(int size) {
		aliens = new ArrayList<Alien>();
		for (int i = 0; i < size; i++) {
			aliens.add(new Alien(60 + 50 * ((i) % 14), 170 * (i / 14), length, length, speed));
		}

	}

	public void add(Alien al) {
		aliens.add(al);
	}

	public void drawEmAll(Graphics window) {
		for (Alien alien : aliens) {
			alien.draw(window);
		}
	}

	public List<Alien> getHorde() {
		return aliens;
	}

	public void moveEmAll() {
		for (Alien alien : aliens) {
			alien.move("RANDOM");
		}
	}

	public void removeTemp(int index) {
		if (index >= 0)
			aliens.remove(index);
	}

	public ArrayList<Integer> removeDeadOnes(List<Ammo> shots) {
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for (Ammo bull : shots) {
			int num = bull.collisionDetector(this);
			removeTemp(num);
			if (num >= 0) {
				indexes.add(shots.indexOf(bull));
			}
		}
		return indexes;
	}

	public void clearHorde() {
		aliens.removeAll(aliens);
	}

	public String toString() {
		return aliens.toString();
	}
}
