package Pong_Game;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

class SpeedUpBall extends Ball
{

	private int ogX =0;
    private int ogY =0;
	   

   public SpeedUpBall()
   {
	   super(200,200);
	   ogX=this.getXSpeed();
	   ogY=this.getYSpeed();

   }

   public SpeedUpBall(int x, int y)
   {
	   super(x,y);
	   setXSpeed(-4);
	   setXSpeed(2);
	   ogX=this.getXSpeed();
	   ogY=this.getYSpeed();
   }


   public SpeedUpBall(int x, int y, int xSpd, int ySpd)
   {
	   super(x,y);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);
	   ogX=this.getXSpeed();
	   ogY=this.getYSpeed();

   }

   public SpeedUpBall(int x, int y, int wid, int ht, int xSpd, int ySpd)
   {

	   super(x,y, wid, ht);
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);
	   ogX=this.getXSpeed();
	   ogY=this.getYSpeed();
   }


   public SpeedUpBall(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {

	   super(x,y, wid, ht, col);
		  
	   setXSpeed(xSpd);
	   setYSpeed(ySpd);
	   ogX=this.getXSpeed();
	   ogY=this.getYSpeed();


   }

   public void setXSpeed( int xSpd )
   {
	   super.setXSpeed(xSpd);



   }

   public void setYSpeed( int ySpd )
   {

	   super.setYSpeed(ySpd);


   }
   
   public int collisionProcessor(Integer countLeft, Integer countRight, Paddle leftPaddle, Paddle rightPaddle, Graphics graphToBack, Wall wallTop, Wall wallBottom) {
	   
	   
	   if (this.didCollideBottom(wallBottom)) {
			int temp = this.getYSpeed()>=0?this.getYSpeed()+1:this.getYSpeed()-1;
			this.setYSpeed(-temp);
		} else if (this.didCollideTop(wallTop)) {
			int temp = this.getYSpeed()>=0?this.getYSpeed()+1:this.getYSpeed()-1;
			this.setYSpeed(-temp);
		}

		if (this.didCollideLeft(leftPaddle)) {
			if (this.getY() >= leftPaddle.getY() - this.getHeight()
					&& this.getY() < leftPaddle.getY() + leftPaddle.getHeight() - this.getHeight()) {
				int temp = this.getXSpeed()>=0?this.getXSpeed()+1:this.getXSpeed()-1;
				this.setXSpeed(-temp);
			} else {
				// this.moveAndDraw(graphToBack);
				graphToBack.clearRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
				this.setXSpeed(ogX);
				this.setYSpeed(ogY);
				this.setX(200);
				this.setY(200);
				return 2;
			}
		}
		if (this.didCollideRight(rightPaddle)) {
			if (rightPaddle.getY() <= this.getY() && this.getY() <= rightPaddle.getY() + rightPaddle.getHeight()) {
				int temp = this.getXSpeed()>=0?this.getXSpeed()+1:this.getXSpeed()-1;
				this.setXSpeed(-temp);
			} else {
				this.setXSpeed(ogX);
				this.setYSpeed(ogY);
				graphToBack.clearRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
				this.setX(200);
				this.setY(200);
				return 1;
			}
		}
		return 0;
   }
}

