package Unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -
import java.io.File;

import java.util.Arrays;
import java.util.Scanner;
import static java.lang.System.*;

public class WordSortTwo
{
	private String[] wordRay;
	
	
	public WordSortTwo(String sentence)
	{
		wordRay = sentence.split(" ");
	}

	public void sort()
	{
		/*for(int i =1; i<wordRay.length;i++) {
			String temp = wordRay[i];
			int possibleIndex = 0;
		}*/
		Arrays.sort(wordRay);
		
	}

	public String toString()
	{
		String output="";
		for(String str: wordRay) {
			output+=str+"\n";
		}
		return output+"\n\n";
	}
}