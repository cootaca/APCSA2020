package Unit5;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name -
//Date -
//Class -
//Lab  -

import static java.lang.System.*;

public class WordsCompareRunner
{
   public static void main( String args[] )
   {
		WordsCompare word =  new WordsCompare("abe","ape");
		word.compare();
		System.out.println(word.toString());
		WordsCompare word1 =  new WordsCompare("giraffe","gorilla");
		word1.compare();
		System.out.println(word1.toString());
	}
}