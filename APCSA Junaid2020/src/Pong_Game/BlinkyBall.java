package Pong_Game;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class BlinkyBall extends Ball
{

	
	//private Color[] colors = {new Color(0,0,0),new Color(255,0,0), new Color(0,255,0), new Color(0,0,255), new Color(221,0,225), new Color(255,208,0),new Color(108, 235, 161),new Color(219, 22, 137),new Color(0, 255, 247),new Color(163, 109, 23)};
	
	public BlinkyBall()
	{
		super(200,200);
	}

   public BlinkyBall(int x, int y, int wid, int ht)
   {
	   super(x,y, wid, ht);
	   setXSpeed(-4);
	   setXSpeed(2);

   }

   public BlinkyBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {
	   super(x,y, wid, ht);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);


   }

   public BlinkyBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
	   super(x,y, wid, ht, col);
		  
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);

   }

   public Color randomColor()
   {
   		int r = (int)(Math.random()*256);		//use Math.random()
 		int g = (int)(Math.random()*256);
 		int b = (int)(Math.random()*256);
 		return new Color(r,g,b);
   }

   public void moveAndDraw(Graphics window)
   {
	   super.setColor(randomColor());
	   super.moveAndDraw(window);

   }
}