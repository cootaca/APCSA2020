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
		if( getFaceValue() == 1 )
			return 11;
		if( getFaceValue() >= 10 )
			return 10;
		return getFaceValue();
	}

  	//toString
  	public String toString()
  	{
  		return super.toString() + " " + getValue();
  	}
 }
