package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class LetterRemover
{
   private String sentence;
   private char lookFor;

	public LetterRemover()
	{
		sentence = "I am Sam I am   a";
		lookFor = 'a';
	}

	//add in second constructor
	public LetterRemover(String s, char rem) {
		sentence = s;
		lookFor = rem;
	}
	
	public void setRemover(String s, char rem)
	{
		sentence = s;
		lookFor = rem;
	}

	public String removeLetters()
	{
		String cleaned="";
		int i = 0;
		while(i<sentence.length()) {
			if(sentence.charAt(i)!=lookFor) {
				cleaned += sentence.charAt(i);
			}
			i++;
		}
		return cleaned;
	}

	public String toString()
	{
		return sentence + " - letter to remove " + lookFor+"\n"+removeLetters()+"\n\n";
	}
}