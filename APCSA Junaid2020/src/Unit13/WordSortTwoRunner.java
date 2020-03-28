package Unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class WordSortTwoRunner
{
	public static void main( String args[] ) throws IOException
	{
		
		Scanner file = new Scanner(new File("/Users/junaidahmad/eclipse-workspace/Tester2Project/src/Unit13/wordsorttwo.dat"));
		
		file.nextLine();
		while(file.hasNextLine())
		{
			WordSortTwo sent =  new WordSortTwo(file.nextLine());
			sent.sort();
			System.out.println(sent);
		}
	}
}