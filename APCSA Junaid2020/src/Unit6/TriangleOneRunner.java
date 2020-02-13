package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class TriangleOneRunner
{
	public static void main ( String[] args )
	{
		TriangleOne triangle = new TriangleOne("hippo");
		triangle.print();
		triangle = new TriangleOne("abcd");
		triangle.print();
		triangle = new TriangleOne("it");
		triangle.print();
		triangle = new TriangleOne("a");
		triangle.print();
		triangle = new TriangleOne("chicken");
		triangle.print();
	}
}