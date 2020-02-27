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
		 
		 
		Card one = new Card("SPADES", 9);
		out.println(one.getCardSuit());
		out.println(one.getFaceValue());

		Card two = new Card("one","DIAMONDS", 1);
		out.println(two);
		two.setFace(3);
		out.println(two);

		Card three = new Card("four","CLUBS", 4);
		out.println(three);

		Card four = new Card("twelve","SPADES", 12);
		out.println(four);

		Card five = new Card("twelve","HEARTS", 12);
		out.println(five);
		
	}
}