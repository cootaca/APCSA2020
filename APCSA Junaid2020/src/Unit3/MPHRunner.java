package Unit3;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import java.util.Scanner; 
import static java.lang.System.*;
import static java.lang.Math.*;

public class MPHRunner
{
	public static void main( String[] args )
	{
		Scanner keyboard = new Scanner(in);
		//test 45 0 32 from default constructor
		MilesPerHour test = new MilesPerHour();
		test.calcMPH();
		test.print();
		
		
		//add more test cases
		//test 96 1 43 from default constructor
		out.print("Enter the distance :: ");
		int dist = keyboard.nextInt();

		out.print("Enter the hours :: ");
		int hrs = keyboard.nextInt();

		out.print("Enter the minutes :: ");
		int mins = keyboard.nextInt();

		MilesPerHour test1 = new MilesPerHour(dist, hrs, mins);
		test1.calcMPH();
		test1.print();
		//test 100 2 25 from default constructor
		out.print("Enter the distance :: ");
		 dist = keyboard.nextInt();

		out.print("Enter the hours :: ");
		 hrs = keyboard.nextInt();

		out.print("Enter the minutes :: ");
		 mins = keyboard.nextInt();

		MilesPerHour test2 = new MilesPerHour(dist, hrs, mins);
		test2.calcMPH();
		test2.print();
	
	}
}