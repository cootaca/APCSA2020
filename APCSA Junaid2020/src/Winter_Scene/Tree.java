package Winter_Scene;

import java.awt.Graphics;
import java.awt.*;
public class Tree extends AbstractShape{

	public Tree(int x, int y, int wid, int ht) {
		super(x, y, wid, ht);
	}


	public void draw(Graphics window) {
		//Color col = window.getColor();
		
		window.setColor(new Color(168, 98, 50));
		window.fillRect(getXPos(),getYPos(),getWidth(),getHeight());
		int x = getXPos();
		int y = getYPos();
		int width = getWidth();
		int height = getHeight();
		int xar[]= {x+width+100,x+width+40,x+width+100,x+width/2,
					x-100,x-40,x-100,x+100};
		int yar[] = {y,y-80,y-80,y-250,y-80,y-80,y,y};
		window.setColor(new Color(28, 217, 38));
		window.fillPolygon(xar, yar, xar.length);
	}

	public void moveAndDraw(Graphics window) {
		draw(window);
		
	}

}
