//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -
package GraphicsUnit2;
import java.awt.Color; 
import java.awt.Graphics;

public class Shape
{
   //instance variables
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	private Color color;
	private int xSpeed;
	private int ySpeed;

   /*
    *The constructor is used to initialize all instance variables.
    *The constructor makes the object.
    */
   public Shape(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
		xPos = x;
		//finish this constructor
		yPos = y;
		
		width = wid;
		height = ht;
		color = col;
		xSpeed = xSpd;
		ySpeed = ySpd;
   }

      /*
    *The draw method draws the shape on the screen.
    */
   public void draw(Graphics window)
   {
      window.setColor(color);
      window.fillRect(xPos, yPos, width, height);
      System.out.println("hello");
      window.setColor(Color.cyan);
      window.fillArc(xPos, yPos, width, height, 0, 360);
      //draw whatever you want
      //    ^
      //  [ :: ]
      //    ()

   }

   /*
    *This draw method will be used to erase the shape.
    */
   public void draw(Graphics window, Color col)
   {
      window.setColor(col);
      window.fillRect(xPos, yPos, width, height);
   }

   public void moveAndDraw(Graphics window)
   {
    	//not needed yet
   }

   //add in set and get methods for xPos, yPos, xSpeed, and ySpeed
   public int getX()
   {
   	return this.xPos;
   }
   
   public int getY()
   {
   	return this.yPos;
   }
   
   public int xSpeed()
   {
   	return this.xSpeed;
   }
   
   public int ySpeed() {
	   return this.ySpeed;
   }


   public void setX( int x )
   {
   	xPos = x;
   }
   
   public void sety( int y )
   {
   	yPos = y;
   }
   
   public void setXSpeed( int xSpeed )
   {
   	this.xSpeed = xSpeed;
   }

   public void setYSpeed( int ySpeed )
   {
   	this.ySpeed = ySpeed;
   }
   public String toString()
   {
   	return xPos+" "+yPos+" "+width+" "+height+" "+color+" "+xSpeed+" "+ySpeed;
   }
}