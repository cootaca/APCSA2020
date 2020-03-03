package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.*;
import static java.lang.System.*;

public class TriangleWordRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		do {
			out.print("Enter a word:: ");
			TriangleWord.printTriangle(keyboard.next());
			out.print("Do you want to enter more input?  ");
		}while(keyboard.next().toLowerCase().equals("y"));
	}
}