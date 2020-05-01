package Pong_Game;


import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
public class InvisibleBall extends Ball{
	//(c) A+ Computer Science
	//www.apluscompsci.com
	//Name -

		private int num =0;
		private int count =0;
		
		public InvisibleBall()
		{
			super(200,200);
		}

	   public InvisibleBall(int x, int y, int wid, int ht)
	   {
		   super(x,y, wid, ht);
		   setXSpeed(-4);
		   setXSpeed(2);

	   }

	   public InvisibleBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
	   {
		   super(x,y, wid, ht);
		   setXSpeed(xSpd);
		   setYSpeed(ySpd);


	   }

	   public InvisibleBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
	   {
		   super(x,y, wid, ht, col);
			  
		   setXSpeed(xSpd);
		   setYSpeed(ySpd);

	   }

	   public void moveAndDraw(Graphics window)
	   {
		   
		   if(count==3&&num<300) {
			   super.setColor(Color.white);
			   super.moveAndDraw(window);
			   num++;
		   }
		   else {
			   num=0;
			   super.setColor(Color.black);
			   super.moveAndDraw(window);
			   count=(int)(Math.random()*400);
	   }
		  
	}
	   public int collisionProcessor(Integer countLeft, Integer countRight, Paddle leftPaddle, Paddle rightPaddle, Graphics graphToBack) {
		   
		   
		   if (this.didCollideBottom(leftPaddle)) {
				this.setYSpeed(-this.getYSpeed());
			} else if (this.didCollideTop(leftPaddle)) {
				this.setYSpeed(-this.getYSpeed());
			}

			if (this.didCollideLeft(leftPaddle)) {
				if (this.getY() >= leftPaddle.getY() - this.getHeight()
						&& this.getY() < leftPaddle.getY() + leftPaddle.getHeight() - this.getHeight()) {
					this.setXSpeed(-this.getXSpeed());
				} else {
					// this.moveAndDraw(graphToBack);
					graphToBack.clearRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
					this.setXSpeed(-this.getXSpeed());
					this.setX(200);
					this.setY(200);
					count=0;
					num=0;
					return 2;
					
				}
			}
			if (this.didCollideRight(rightPaddle)) {
				if (rightPaddle.getY() <= this.getY() && this.getY() <= rightPaddle.getY() + rightPaddle.getHeight()) {
					this.setXSpeed(-this.getXSpeed());
				} else {
					// this.moveAndDraw(graphToBack);
					graphToBack.clearRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
					this.setXSpeed(-this.getXSpeed());
					this.setX(200);
					this.setY(200);
					count=0;
					num=0;
					return 1;
				}
			}
			 return 0;
	   }
	  
}
