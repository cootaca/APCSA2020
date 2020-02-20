package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import static java.lang.System.*;

public class BiggestDouble
{
	private double one,two,three,four;

	public BiggestDouble()
	{
		this(4.5,6.7,7.8,9.0);
	}

	public BiggestDouble(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
	}

	public void setDoubles(double a, double b, double c, double d)
	{
		one = a;
		two = b;
		three = c;
		four = d;
	}

	public double getBiggest()
	{
		double placeH = 0;
		if(one>two) {
			placeH = one;
		}
		else {
			placeH = two;
		}
		if(placeH<three) {
			placeH = three;
		}
		if(placeH<four)
			placeH = four;
		return placeH;
	}

	public String toString()
	{
	   return String.format("%1$s %2$s %3$s %4$s",one,two,three,four);
	}
}