package Unit7;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFiveRunner
{
   public static void main(String args[])
   {
	   TriangleFive triangle = new TriangleFive();
	   System.out.println(triangle);
	   
	   triangle = new TriangleFive('C',4);
	   System.out.println(triangle);
	   
	   triangle = new TriangleFive('A',5);
	   System.out.println(triangle);
	   
	   triangle = new TriangleFive('B',7);
	   System.out.println(triangle);
	   

	   triangle = new TriangleFive('X',6);
	   System.out.println(triangle);
	}
}
