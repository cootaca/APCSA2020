package Unit11;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*; 

class Rational implements Comparable<Rational>
{
	//add two instance variables
	private int newNum;
	private int newDenom;
	//write two constructors
	public Rational(){
		newNum = 1;
		newDenom=1;
	}
	
	
	public Rational(int num,int denom){
		newNum = num;
		newDenom=denom;
	}
	//ACCESSORS

		//write get methods for newNum and newDenom
	public int newNum() {
		return newNum;
	}
	
	public int newDenom() {
		return newDenom;
	}
	//write a setRational method
	public void setRational (int num, int denom) {
		newNum = num;
		newDenom = denom;
	}

	//write  a set method for newNum and newDenom
	public void setNum(int num) {
		newNum = num;
	}
	public void setDenom(int denom) {
		newDenom = denom;
	}
	
	public void add(Rational  other)
	{
		//num1/den1 + num2/den2 
		//new newNum = (num1 * den2 + num2 * den1)
		//new newDenom = (den1 * den2)
		Rational retAdd = new Rational(0, 0);
		if(this.newDenom == other.newDenom) {
			retAdd.newNum = this.newNum + other.newNum;
			retAdd.newDenom = this.newDenom;
			newNum = retAdd.newNum();
			newDenom = retAdd.newDenom();
		} else {
			retAdd.newNum = this.newNum * other.newDenom;
			retAdd.newDenom = this.newDenom * other.newDenom;
			
			other.newNum = other.newNum * this.newDenom;
			other.newDenom = other.newDenom * this.newDenom;
			
			retAdd.newNum += other.newNum;
			
			int remain, num1, num2;
			num1 = retAdd.newNum;
			num2 = retAdd.newDenom;
			remain = num1 % num2;
			while(remain != 0) {
				remain = num1 % num2 ;
				num1 = num2;
				num2 = remain;
			}
			int GCD = num1;
			
			this.newNum = retAdd.newNum/gcd(retAdd.newNum(),retAdd.newDenom());
			this.newDenom = retAdd.newDenom/gcd(retAdd.newNum(),retAdd.newDenom());
			
			
		}
		reduce();
	}
		


		
	

	private void reduce()
	{
		
		this.newNum = this.newNum/gcd(newNum,newDenom);
		this.newDenom = this.newDenom/gcd(newNum,newDenom);


	}

	private int gcd(int numOne, int numTwo)
	{
		int remain, num1, num2;
		num1 = numOne;
		num2 = numTwo;
		remain = num1 % num2;
		while(remain != 0) {
			remain = num1 % num2 ;
			num1 = num2;
			num2 = remain;
		}
		int GCD = num1;

		return GCD;
	}

	public Object clone ()
	{
		Rational rat = new Rational(newNum,newDenom);
		return rat;
	}


	
	
	
	public boolean equals( Rational obj)
	{
		this.reduce();
		obj.reduce();

		if(this.newNum==obj.newNum&&this.newDenom==obj.newDenom) {
			return true;
		}
		return false;
	}

	public int compareTo(Rational other)
	{
		int x = -1;
		double dec1 = (double)this.newNum/this.newDenom;
		double dec2 = (double)other.newNum/other.newDenom;
		if(dec1>dec2) {
			x=1;
		}
		else if(dec1==dec2) {
			x=0;
		}
		return x;
	}



	
	public  String toString() {
		return newNum+"/"+newDenom;
	}
	
	
}
