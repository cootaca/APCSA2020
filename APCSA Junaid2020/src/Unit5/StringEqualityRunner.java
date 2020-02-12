package Unit5;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  - 

import static java.lang.System.*;

public class StringEqualityRunner
{
	public static void main( String args[] )
	{
		StringEquality checker  = new StringEquality();
		System.out.println(checker.toString());
		
		 checker  = new StringEquality("one","two");
		System.out.println(checker.toString());
		
		checker  = new StringEquality("three","four");
		System.out.println(checker.toString());
		
		checker  = new StringEquality("ABC","ABC");
		System.out.println(checker.toString());
		
		checker  = new StringEquality("ABC","CBA");
		System.out.println(checker.toString());
	}
}