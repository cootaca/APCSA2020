//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
package Winter_Scene;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

//extend the AbstractShape class to make a FancySnowFlake class
public class FancySnowFlake extends AbstractShape{
	public FancySnowFlake(int x, int y, int wid, int ht) {
		super( x,  y,  wid,  ht, Color.white);
	}
	public FancySnowFlake(int x, int y, int wid, int ht, int ySpd) {
		super( x,  y,  wid,  ht, Color.white, 0, ySpd);
	}
	
	public void draw(Graphics window) {
		
		window.setColor(getColor());
		int x = getXPos();
		int y = getYPos();
		int w = getWidth();
		int h = getHeight();
		window.drawLine(x, y, x + w, y + h);
		window.drawLine(x, y + h, x + w, y);
		window.drawLine(x, y + h / 2, x + w, y + h / 2);
		window.drawLine(x + w / 2, y, x + w / 2, y + h);
	}

	public void moveAndDraw(Graphics window) {
		if(getYPos()+getYSpeed()<=800)
			setYPos(getYPos() + getYSpeed());
		else
			setYPos(0);
		setXPos(getXPos());
		draw(window);
		
		
	}
	
	
}



