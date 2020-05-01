package Pong_Game;
//(c) A+ Computer Science

//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Block implements Locatable {
	private int xPos;
	private int yPos;
	private int width;
	private int height;

	private Color color;

	public Block() {

	}

	// add other Block constructors - x , y , width, height, color
	public Block(int xpos, int ypos) {
		xPos = xpos;
		yPos = ypos;
		width = 10;
		height = 10;
		color = new Color(0, 0, 0);

	}
	
	public Block(int x,int y, Color col) {
		xPos=x;
		yPos=y;
		color=col;
		width = 10;
		height = 10;
	}

	public Block(int xpos, int ypos, int width, int height) {
		this.xPos = xpos;
		this.yPos = ypos;
		this.width = width;
		this.height = height;
		color = new Color(0, 0, 0);

	}

	public Block(int xpos, int ypos, int width, int height, Color color) {
		this.xPos = xpos;
		this.yPos = ypos;
		this.width = width;
		this.height = height;
		this.color = color;

	}

	// add the other set methods

	public void setColor(Color col) {
		this.color = col;

	}

	public void draw(Graphics window) {
		window.setColor(color);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public void draw(Graphics window, Color col) {
		window.setColor(col);
		window.fillRect(getX(), getY(), getWidth(), getHeight());
	}

	public boolean equals(Object obj) {
		Block blok = (Block)obj;
		return this.getX()==blok.getX()&&this.getY()==blok.getY()&&this.getWidth()==blok.getWidth()&&this.getHeight()==blok.getHeight()&&this.getColor()==blok.getColor();
	}

	@Override
	public void setPos(int x, int y) {
		xPos = x;
		yPos = y;

	}

	@Override
	public void setX(int x) {
		xPos = x;

	}

	@Override
	public void setY(int y) {
		yPos = y;

	}

	@Override
	public int getX() {
		return xPos;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return yPos;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	public Color getColor() {
		return color;
	}

	// add a toString() method - x , y , width, height, color
	public String toString() {
		String str="";
		str=String.format("%1$s %2$s %3$s %4$s %5$s",getX(),getY(), getWidth(), getHeight(), getColor());
		return str;
	}
}