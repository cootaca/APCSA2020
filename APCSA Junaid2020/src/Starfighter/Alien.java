//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
package Starfighter;

import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
	private int speed;
	private Image image;

	public Alien()
	{
		this(0,0,30,30,0);
	}

	public Alien(int x, int y)
	{
		super(x,y);
		speed = 5;
		try
		{
			URL url = getClass().getResource("UFO.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Error in retrieving the alien image");
		}
		
	}

	public Alien(int x, int y, int s)
	{
		super(x,y);
		speed = s;
		try
		{
			URL url = getClass().getResource("UFO.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Error in retrieving the alien image");
		}
	}

	public Alien(int x, int y, int w, int h, int s)
	{
		super(x, y, w,h);
		speed=s;
		try
		{
			URL url = getClass().getResource("UFO.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			System.out.println("Error in retrieving the alien image");
		}
	}

	public void setSpeed(int s)
	{
	   speed=s;	
	   }

	public int getSpeed()
	{
	   return speed;
	}

   public void move(String direction)
	{	
	   if(getX()>=0&&getX()<=800-getWidth()&&getY()>=0&&getY()<=600-getHeight()) {
		   int num = (int)(Math.random()*4);
		   if(num==0) {
			   setX(getX()-speed);
		   }
		   else if(num==1) {
			   setX(getX()+speed);
		   }
		   else if(num==2) {
			   setY(getY()+speed);
		   }
		   else if(num==3) {
			   setY(getY()-speed);
		   }
	   }
	   else if(getX()<0) {
		   setX(getX()+speed*3);
	   }
	   else if(getX()>800-getWidth()) {
		   setX(getX()-speed*3);
	   }
	   else if(getY()<0) {
		   setY(getY()+speed*3);
	   }
	   else {
		   setY(getY()-speed*3);
	   }
	}
   public Image getImage() {
	   return image;
   }

	public void draw( Graphics window )
	{
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}

	public String toString()
	{
		return image.toString();
	}
}
