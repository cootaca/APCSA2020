package ElevensLab;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class BlackJackCard extends Card
{
  	//constructors
  	public BlackJackCard( String str, int num)
  	{
  		super( str, num );
  	}

  	//accessors
	public int getValue()
	{
		if( getFace() == 1 )
			return 11;
		if( getFace() >= 10 )
			return 10;
		return getFace();
	}

  	//toString
  	public String toString()
  	{
  		return super.toString() + " " + getValue();
  	}
 }
