package Unit6;
//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import static java.lang.System.*;

public class Perfect
{
   private int number;

	//add constructors
   public Perfect() {
	   number = 496;
   }
   public Perfect(int num) {
	   number = num;
   }
	//add a set method
   
   public void setPerfect(int num) {
	   number = num;
   }
	public boolean isPerfect()
	{
		int i = 1;
		int count=0;
		while (i <=number/2) {
			if(number%i==0) {
				count+=i;
			}
			i++;
		}
		if(count ==number) {
			return true;
		}
		else{
			return false;
		}
	}

	public String toString() {
		if(isPerfect()) {
			return number +" is perfect";
		}
		else {
			return number +" is not perfect";
		}
	}
	
}