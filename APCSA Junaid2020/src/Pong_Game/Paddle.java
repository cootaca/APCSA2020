package Pong_Game;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Paddle extends Block
{
   //instance variables
   private int speed;

   //Paddle constructors
   public Paddle()
   {
	  super(10,10);
      speed =2;
   }
   public Paddle(int x, int y) {
	   super(x,y);
	   speed=2;
   }
   
   public Paddle(int x,int y, int speed) {
	   super(x,y);
	   this.speed=speed;
   }
   
   public Paddle(int x, int y, int width, int height, int speed) {
	   super(x,y,width,height);
	   this.speed=speed;
   }
  
   public Paddle(int x, int y, int width, int height, Color col, int speed) {
	   super(x,y,width,height,col);
	   this.speed=speed;
   }


   

   public void moveUpAndDraw(Graphics window)
   {
	   super.draw(window,Color.white);
	   if(this.getY()<=10) 
		   this.setY(10);
	   else
		   this.setY(this.getY()-speed);
	   super.draw(window);
   }

   public void moveDownAndDraw(Graphics window)
   {
	   super.draw(window,Color.white);
	   if(this.getY()+this.getHeight()+speed>=570) 
		   this.setY(570-this.getHeight());
	   else
		   this.setY(this.getY()+speed);
	   super.draw(window);
   }

   public int getSpeed() {
	   return this.speed;
   }
   
   
   public String toString() {
	   return super.toString()+" "+getSpeed();
   }
}