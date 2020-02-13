package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

public class PerfectRunner
{
	public static void main( String args[] )
	{
		Perfect num = new Perfect();
		System.out.println(num.toString());
		
		num = new Perfect(45);
		System.out.println(num.toString());
		
		num = new Perfect(6);
		System.out.println(num.toString());
		
		num = new Perfect(14);
		System.out.println(num.toString());
		
		num = new Perfect(8128);
		System.out.println(num.toString());													
	}
}