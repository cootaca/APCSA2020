package Unit13;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.util.Arrays; 
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import static java.lang.System.*;

public class NumberSorter
{
	//instance variables and other methods not shown

	private static int getNumDigits(int number)
	{
		int count = 1;
		while(number!=number%10) {
			number/=10;
			count++;
			
		}
		return count;
	}

	public static int[] getSortedDigitArray(int number)
	{
		int num = number;
		int[] sorted = new int[getNumDigits(number)];
		
		for(int i = 0; i<sorted.length;i++) {
			sorted[i] = num%10;
			num/=10;
		}
		Arrays.sort(sorted);
		return sorted;
	}
}