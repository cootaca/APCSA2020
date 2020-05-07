package Pong_Game;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;

public class Ball extends Block implements Collidable
{
	private int xSpeed;
	private int ySpeed;

	public Ball()
	{
		super(200,200);
		xSpeed = 3;
		ySpeed = 1;
	}

	public Ball(Color col)
	  {
		  super(200,200, col);
		  
		  xSpeed = -10;
		  ySpeed = -1;
	  }
	  
	  public Ball(int x, int y)
	  {
		  super(x,y);
		  
		  xSpeed = 2;
		    ySpeed = 2;
	  }
	  
	  public Ball(int x, int y, int width, int height)
	  {
		  super(x,y, width, height);
		  
		  xSpeed = 4;
		  ySpeed = 2;
	  }
	  
	  public Ball(int x, int y, int width, int height, Color col)
	  {
		  super(x,y, width, height, col);
		  
		  xSpeed = 2;
		    ySpeed = 2;
	  }
	  
	  public Ball(int x, int y, int width, int height, Color col, int xSped, int ySped)
	  {
		  super(x,y, width, height, col);
		  
		  xSpeed = xSped;
		  
		  ySpeed = ySped;
	  }

	  public void setXSpeed(int x)
	  {
		  xSpeed = x;
	  }
	  
	  public void setYSpeed(int y)
	  {
		  ySpeed = y;
	  }

	  public int getXSpeed()
	  {
		  return xSpeed;
	  }
	  
	  public int getYSpeed()
	  {
		  return ySpeed;
	  }   
   

   public void moveAndDraw(Graphics window)
   {
   	//draw a white ball at old ball location
	   draw(window,Color.white);


      setX(getX()+xSpeed);
	  setY(getY()+ySpeed);

	 draw(window,getColor());
   }
   
	public boolean equals(Object obj)
	{
		Ball s = (Ball) obj;

		  if( s.getXSpeed() != xSpeed)
		  {
				return false;
		  }
			
		  else if(s.getYSpeed() != ySpeed)
		  {
			  return false;
		  }
			
		  else
		  {
			  return true;
		  }
	}   

   

	 public String toString()
	  {
		  return super.toString() + " " + xSpeed + " " + ySpeed;
	  }

	@Override
	public boolean didCollideLeft(Object obj) {
		// TODO Auto-generated method stub
		Paddle leftPaddle = (Paddle)obj;
		if(!(this.getX()>=leftPaddle.getX()))
		{
			return true;
		}
		
		else if(this.getX()<=leftPaddle.getX()+leftPaddle.getWidth()-this.getWidth()/2&&(this.getY()>=leftPaddle.getY()-this.getHeight()&&this.getY()<leftPaddle.getY()+leftPaddle.getHeight()-this.getHeight())) {
			return true;	
	}
		return false;
	}

	@Override
	public boolean didCollideRight(Object obj) {
		// TODO Auto-generated method stub
		Paddle rightPaddle = (Paddle)obj;
		if(!(this.getX()<=rightPaddle.getX()))
		{
			return true;
		}
		
		
		else if (this.getX() > rightPaddle.getX()-5 && rightPaddle.getY() <= this.getY() && this.getY() <= rightPaddle.getY() + rightPaddle.getHeight())
        {
        	return true;
        }
		return false;

	}

	@Override
	public boolean didCollideTop(Object obj) {
		Wall wallTop = (Wall)obj;
		if(this.getY()<=wallTop.getY()+wallTop.getHeight()) {
			return true;
		}
		return false;
	}

	@Override
	public boolean didCollideBottom(Object obj) {
		Wall wallBottom = (Wall)obj;
		if(this.getY()+this.getHeight()>=wallBottom.getY()) {
			return true;
		}
		return false;
	}
	 public int collisionProcessor(Integer countLeft, Integer countRight, Paddle leftPaddle, Paddle rightPaddle, Graphics graphToBack, Wall wallTop, Wall wallBottom) {
		   
		   
		   if (this.didCollideBottom(wallBottom)) {
				this.setYSpeed(-this.getYSpeed());
			} else if (this.didCollideTop(wallTop)) {
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
					countLeft++;
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
					countRight++;
					return 1;
				}
			}
			 return 0;
	   }
}