package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name

import static java.lang.System.*;

public class WordRunner
{
	public static void main ( String[] args )
	{
		//add test cases	
		Word word = new Word();
		System.out.println(word);
		
		 word = new Word("World");
		System.out.println(word);
		
		word = new Word("JukeBox");
		System.out.println(word);
		
		word = new Word("TCEA");
		System.out.println(word);
		
		word = new Word("UIL");
		System.out.println(word);
	}
}