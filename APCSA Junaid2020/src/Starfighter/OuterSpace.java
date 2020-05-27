//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
package Starfighter;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class OuterSpace extends Canvas implements KeyListener, Runnable {
	private Ship ship;
	private Alien alienOne;
	private Alien alienTwo;
	private int frame;
	private int count;
	private boolean lose = false;
	private Ammo amm;
	private AlienHorde horde;
	private Bullets shots;
	private int hordeNum;
	private int reloadSec;

	private boolean[] keys;
	private BufferedImage back;

	public OuterSpace() {
		setBackground(Color.black);
		count = 0;
		keys = new boolean[6];
		frame = 10;
		// instantiate other instance variables
		ship = new Ship(350, 490, 100, 100, 5);
		alienOne = new Alien(40, 40, 30, 30, 2);
		alienTwo = new Alien(90, 40, 30, 30, 2);
		hordeNum = 28;
		horde = new AlienHorde(hordeNum);
		shots = new Bullets();
		reloadSec = 3;
		this.addKeyListener(this);
		new Thread(this).start();

		setVisible(true);
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		// set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shop of the current screen and same it as an image
		// that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();

		graphToBack.setColor(Color.BLUE);
		graphToBack.drawString("StarFighter ", 25, 50);
		graphToBack.setColor(new Color(49, 176, 212));
		graphToBack.fillRect(0, 0, 800, 650);

		if (keys[0] == true) {
			ship.move("LEFT");
		}
		if (keys[1] == true) {
			ship.move("RIGHT");
		}
		if (keys[2] == true) {
			ship.move("UP");
		}
		if (keys[3] == true) {
			ship.move("DOWN");
		}
		if (keys[4] == true) {
			if (frame >= reloadSec * 24) {
				shots.add(new Ammo(ship.getX() + ship.getWidth() / 2 - Ammo.length / 2, ship.getY(), 5));
				frame = 0;
			}
		}

		// add code to move Ship, Alien, etc.

		ship.draw(graphToBack);
		horde.drawEmAll(graphToBack);
		shots.drawEmAll(graphToBack);
		shots.moveEmAll();
		frame++;
		if (amm != null) {
			amm.move("UP");
			amm.draw(graphToBack);
		}
		horde.moveEmAll();
		count += shots.cleanEmUp(horde);
		scoreUpdater(graphToBack);

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_R) {
			keys[5] = true;
		}
		repaint();
	}

	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_R) {
			keys[5] = false;
		}
		repaint();
	}

	public void keyTyped(KeyEvent e) {
		// no code needed here
	}

	public void scoreUpdater(Graphics graphToBack) {

		Font f = new Font("Arial", Font.PLAIN, 30);
		graphToBack.setFont(f);
		graphToBack.setColor(new Color(255, 81, 23));
		if (lose == true) {
			horde.clearHorde();

			graphToBack.drawString(String.format("YOU LOSE! FINAL SCORE: %s (Press R To Try Again)", count), 40, 610);
			if (keys[5] == true) {
				horde = new AlienHorde(hordeNum);
				count = 0;
				lose = false;
				shots.clearBullets();
				ship = new Ship(350, 490, 100, 100, 5);
			}
		} else if (horde.getHorde().size() == 0) {
			graphToBack.drawString(String.format("YOU WIN! FINAL SCORE: %s (Press R To Play Again)", count), 40, 600);
			if (keys[5] == true) {
				horde = new AlienHorde(hordeNum);
				count = 0;
				shots.clearBullets();
				ship = new Ship(350, 490, 100, 100, 5);
			}
		} else if (ship.collisionDetector(horde) >= 0) {
			lose = true;
		}

		else
			graphToBack.drawString(String.format("Score: %s", count), 350, 600);
		graphToBack.setColor(Color.black);
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread().sleep(5);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}
