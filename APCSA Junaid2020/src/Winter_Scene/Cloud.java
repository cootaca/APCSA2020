package Winter_Scene;

import java.awt.Color;
import java.awt.Graphics;

public class Cloud extends AbstractShape{
	public Cloud(int x, int y, int wid, int ht,int xSpd) {
		super(x, y, wid, ht);
		setXSpeed(xSpd);
	}

	@Override
	public void draw(Graphics window) {
		window.setColor(Color.white);
		int x = getXPos();
		int y = getYPos();
		int w = getWidth();
		int h = getHeight();
		window.fillOval(x,y,h,w);
		window.fillOval(x+w/2,y+h/3,h,w);
		window.fillOval(x+w/2,y-h/3,h,w);
		window.fillOval(x+w,y-h/3,h,w);
		window.fillOval(x+w,y+h/3,h,w);;
		window.fillOval(x+(int)(w*1.5),y-h/3,h,w);
		window.fillOval(x+(int)(w*1.5),y+h/3,h,w);;
		window.fillOval(x+(int)(w*2),y-h/3,h,w);
		window.fillOval(x+(int)(w*2),y+h/3,h,w);
		window.fillOval(x+(int)(w*2.5),y,h,w);
		
	}

	@Override
	public void moveAndDraw(Graphics window) {
		if(getXPos()+getXSpeed()<=800) {
			setXPos(getXPos()+getXSpeed());
			draw(window);
		}
		else {
			setXPos(-(int)(getWidth()*3));
			draw(window);
		}
	}
}
