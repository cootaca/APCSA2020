package Pong_Game;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

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

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.event.ActionListener;

public class Pong extends Canvas implements KeyListener, Runnable {
	private SpeedUpBall ball;
	//private InvisibleBall ball;
	//private BlinkyBall ball;
	private Paddle leftPaddle;
	private Paddle rightPaddle;
	private boolean[] keys;
	private BufferedImage back;
	private Integer countLeft = 0;
	private Integer countRight = 0;
	private Wall wallTop;
	private Wall wallBottom;
	private int ogx;
	private int ogy;

	public Pong() {
		ball = new SpeedUpBall(200, 200, 10, 10,2,2);
		//ball = new InvisibleBall(200, 200, 10, 10,4,4);
		//ball = new BlinkyBall(200, 200, 10, 10,4,2);
		leftPaddle = new Paddle(10, 100, 10, 200, 6);

		rightPaddle = new Paddle(780, 100, 10, 200, Color.black, 6);

		keys = new boolean[4];
		wallTop = new Wall(leftPaddle.getX(),0,rightPaddle.getX()-leftPaddle.getX()+rightPaddle.getWidth());
		wallBottom = new Wall(leftPaddle.getX(),570,rightPaddle.getX()-leftPaddle.getX()+rightPaddle.getWidth());
		setBackground(Color.WHITE);
		setVisible(true);

		new Thread(this).start();
		addKeyListener(this); // starts the key thread to log key strokes
	}

	public void update(Graphics window) {
		paint(window);
	}

	public void paint(Graphics window) {
		// set up the double buffering to make the game animation nice and smooth
		Graphics2D twoDGraph = (Graphics2D) window;

		// take a snap shop of the current screen and save it as an image
		// that is the exact same width and height as the current screen
		if (back == null)
			back = (BufferedImage) (createImage(getWidth(), getHeight()));

		// create a graphics reference to the back ground image
		// we will draw all changes on the background image
		Graphics graphToBack = back.createGraphics();
		
		scoreUpdater(graphToBack);
		wallBottom.draw(graphToBack);
		wallTop.draw(graphToBack);
		ball.moveAndDraw(graphToBack);
		leftPaddle.draw(graphToBack);
		rightPaddle.draw(graphToBack);

		int x =ball.collisionProcessor(countLeft,countRight,leftPaddle,rightPaddle,graphToBack,wallTop,wallBottom);
		if(x==1)
			countLeft++;
		else if(x==2) {
			countRight++;
		}
		
		if (keys[0] == true) {
			// move left paddle up and draw it on the window

			leftPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[1] == true) {
			leftPaddle.moveDownAndDraw(graphToBack);

		}
		if (keys[2] == true) {
			rightPaddle.moveUpAndDraw(graphToBack);
		}
		if (keys[3] == true) {
			rightPaddle.moveDownAndDraw(graphToBack);
		}

		twoDGraph.drawImage(back, null, 0, 0);
	}

	public void keyPressed(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = true;
			break;
		case 'S':
			keys[1] = true;
			break;
		case 'I':
			keys[2] = true;
			break;
		case 'M':
			keys[3] = true;
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
		switch (toUpperCase(e.getKeyChar())) {
		case 'W':
			keys[0] = false;
			break;
		case 'S':
			keys[1] = false;
			break;
		case 'I':
			keys[2] = false;
			break;
		case 'M':
			keys[3] = false;
			break;
		}
	}

	public void keyTyped(KeyEvent e) {

	}
	
	public void scoreUpdater(Graphics graphToBack) {
		Font f = new Font("Arial", Font.PLAIN, 20);
		graphToBack.setFont(f);
		graphToBack.clearRect(50, 450, 800, 500);
		graphToBack.setColor(Color.blue);
		graphToBack.drawString(String.format("Left Player Score: %s", countLeft), 50, 500);
		graphToBack.drawString(String.format("Right Player Score: %s", countRight), 500, 500);
		graphToBack.setColor(Color.black);
	}

	public void run() {
		try {
			while (true) {
				Thread.currentThread();
				Thread.sleep(8);
				repaint();
			}
		} catch (Exception e) {
		}
	}
}