package Pong_Game;

import java.awt.Color;
import java.awt.Graphics;

public class Wall extends Block{
	public Wall(int xPos, int yPos, int width) {
		super(xPos, yPos);
		setWidth(width);
	}
	public void draw(Graphics window) {
		window.setColor(new Color(15, 234, 224 ));
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
