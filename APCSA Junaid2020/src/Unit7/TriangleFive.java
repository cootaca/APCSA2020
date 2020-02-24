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
		letter = 'Z';
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
		String output="";
		for(int i =0;i<amount;i++) {
			for(int j = 0;j<amount-i;j++) {
				for(int k = j; k<amount;k++) {
					char chr = (char)(letter+j);
					if(chr>90) {
						chr = (char)(chr-26);
					}
					output+=chr;
				}
				output+=" ";
			}
			output+="\n";
		}
		
		return output;
	}
}
