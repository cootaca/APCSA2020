package ElevensLab;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

public class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	//instance variables
		private String suit;
		private String rank;
		
		private int face;
		private int pointValue;
		public Card() {
			
		}
  	//constructors
		public Card(String cardSuit, int faceValue){
			suit = cardSuit;
			face = faceValue;
		}
		public Card(String rank, String suit, int pointValue) {
			this.rank = rank;
			this.suit = suit;
			this.pointValue = pointValue;
			face = pointValue;
		}

	// modifiers
		public void setCard(String cardSuit, int faceValue){
			suit = cardSuit;
			face = faceValue;
		}
		public void setSuit(String Suit) {
			suit = Suit;
		}
		public void setFace(int face) {
			this.face = face;
		}
		public void setRank(String rank) {
			this.rank = rank;
		}
		public void setPointValue(int pointValue) {
			this.pointValue = pointValue;
		}
		//get methods
		public String getCardSuit() {
			return suit;
		}
		public String getRank() {
			return rank;
		}
		public int getFaceValue() {
			return face;
		}
		public int getPointValue() {
			return pointValue;
		}
		 public boolean matches(Card card2) {
			    if(card2.getCardSuit().equals(this.getCardSuit()) && card2.getRank().equals(this.getRank()) && card2.getPointValue() == this.getPointValue())
			      return true;
			    else
			      return false;
		 }
		 
		//toString
		 public String toString() {
			 rank = FACES[pointValue];
			 return  rank + " of " + suit + " (point value = " + pointValue + ")";
		 }
  


  	

 }