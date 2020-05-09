//(c) A+ Computer Science
//www.apluscompsci.com
//Name - Junaid Ahmad
package Winter_Scene;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SnowMan extends AbstractShape
{
   public SnowMan(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 0, 0);
   }

   public void draw(Graphics window)
   {
	   window.drawOval(getXPos(), getYPos(), getWidth(), getHeight());
	   window.drawOval(getXPos()-(((int)(2*getWidth())-getWidth())/2),getYPos()+getHeight(), (int)(2*getWidth()),(int)(2*getHeight()));
	   window.drawOval(getXPos()-(((int)(3*getWidth())-getWidth())/2),getYPos()+getHeight()+(int)(2*getHeight()), (int)(3*getWidth()),(int)(3*getHeight()));
   }

   public void moveAndDraw(Graphics window)
   {
      draw(window);   
   }
}