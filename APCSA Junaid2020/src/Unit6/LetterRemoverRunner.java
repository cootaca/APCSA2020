package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemoverRunner
{
	public static void main( String args[] )
	{
		LetterRemover sentence = new LetterRemover();
		System.out.println(sentence);	
		sentence = new LetterRemover("ssssssssxssssesssssesss",'s');
		System.out.println(sentence);	
		sentence = new LetterRemover("qwertyqwertyqwerty",'a');
		System.out.println(sentence);	
		sentence = new LetterRemover("abababababa",'b');
		System.out.println(sentence);	
		sentence = new LetterRemover("abaababababa",'x');
		System.out.println(sentence);	
																		
	}
}
