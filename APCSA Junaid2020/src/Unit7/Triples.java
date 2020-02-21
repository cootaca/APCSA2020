package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class Triples
{
   private int number;

	public Triples()
	{
		this(0);
	}

	public Triples(int num)
	{

		number = num;
	}

	public void setNum(int num)
	{
				
		number = num;
	}
	
	private int greatestCommonFactor(int a, int b, int c)
	{
		int max = 1;
		int i =1;
		while (i<=(Math.max(c, Math.max(a, b))/2)) {
			if(a%i==0&&b%i==0&&c%i==0) {
				max = i;
			}
			i++;
		}


		return max;
	}

	public String toString()
	{
		String output="";
		//int a,b,c;
		for(int a = 1; a<= number; a++) {
			for(int b =1; b<=number;b++) {
				for(int c = 1; c<=number;c++) {
					if(Math.pow(a,2)+Math.pow(b,2)==Math.pow(c, 2)&&((a%2==0&&b%2==1)||(a%2==1&&b%2==0))&&c%2==1&&greatestCommonFactor(a,b,c)==1) {
						output += String.format("%1$s %2$s %3$s\n",a,b,c);
					}
				}
			}
		}




		return output+"\n";
	}
}