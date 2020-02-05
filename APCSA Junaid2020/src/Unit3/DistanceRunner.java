package Unit3;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;

import java.io.InputStream;

import static java.lang.Math.*;

public class DistanceRunner
{
	public static void main( String[] args )
	{
		//Test input  1 1 2 1
		Distance dist1 = new Distance();
		dist1.calcDistance();
		dist1.print();
		Scanner keyboard = new Scanner(System.in);
		
		
		//Test input  1 1 -2 2
		
		System.out.print("Enter X1 :: ");
		int x1 = keyboard.nextInt();
		
		System.out.print("Enter Y1 :: ");
		int y1 = keyboard.nextInt();
		
		System.out.print("Enter X2 :: ");
		int x2 = keyboard.nextInt();
		
		System.out.print("Enter Y2 :: ");
		int y2 = keyboard.nextInt();
		
		Distance dist2 = new Distance(x1,y1,x2,y2);
		dist2.calcDistance();
		System.out.println(dist2.toString());
		
		//Test input  1 1 0 0
		
		System.out.print("Enter X1 :: ");
		 x1 = keyboard.nextInt();
				
		System.out.print("Enter Y1 :: ");
		 y1 = keyboard.nextInt();
		
		System.out.print("Enter X2 :: ");
		 x2 = keyboard.nextInt();
				
		System.out.print("Enter Y2 :: ");
		 y2 = keyboard.nextInt();
			
		Distance dist3 = new Distance(x1,y1,x2,y2);
		dist3.calcDistance();
		dist3.print();
		
		
	}
}