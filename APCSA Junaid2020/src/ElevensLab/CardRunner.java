package ElevensLab;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;
import java.awt.Color;

public class CardRunner
{
	public static void main( String args[] )
	{
		Card one = new Card("4", "SPADES", 6);
		out.println(one.getSuit());
		out.println(one.getRank());

		Card two = new Card("7", "Hearts", 1);
		out.println(two);
		two.setRank("2");
		out.println(two);

		Card three = new Card("4", "Spades", 6);
		out.print(three.match(two));
		
	}
}
