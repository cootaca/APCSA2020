package Unit7;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class TriangleFive
{
   private char letter;
   private int amount;

	public TriangleFive()
	{
		letter = 'z';
		amount = 4;
	}

	public TriangleFive(char c, int amt)
	{
		letter = c;
		amount = amt;
	}

	public void setLetter(char c)
	{
		letter = c;
	}

	public void setAmount(int amt)
	{
		amount = amt;
	}

	public String toString()
	{
		int num = letter;
		if(num+amount+1<=90) {
			for(int i=0; i<amount;i++,num++) {
				for (int y=0;y<amount-i;y++) {
					
				}
				System.out.println("");
			}
		}
		String output="";
		return output;
	}
}