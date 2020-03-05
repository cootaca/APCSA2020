package Unit10;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class ToyRunner
{
	public static void main(String[] args)
	{
		Toy toy1 = new Toy("sorry");
		out.println(toy1);
		toy1 = new Toy("gi joe",5);
		out.println(toy1);
	}
}