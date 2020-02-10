package Unit4;
//(c) A+ Computer Science
//www.apluscompsci.com

//Name - 
//Date -
//Class -
//Lab  -

import static java.lang.System.*;
import java.util.Scanner;

public class DiscountRunner
{
	public static void main( String args[] )
	{
		Scanner keyboard = new Scanner(System.in);
		
		//Test 500 
		out.print("Enter the original bill amount :: ");
		double amt = keyboard.nextDouble();
		amt = Discount.getDiscountedBill(amt);
		out.printf("Bill after discount: %.2f \n",amt);
		
		//Test 2500 
		out.print("Enter the original bill amount :: ");
		amt = keyboard.nextDouble();
		amt = Discount.getDiscountedBill(amt);
		out.printf("Bill after discount: %.2f \n",amt);
		
		//Test 4000 
		out.print("Enter the original bill amount :: ");
		amt = keyboard.nextDouble();
		amt = Discount.getDiscountedBill(amt);
		out.printf("Bill after discount: %.2f \n",amt);
		
		//Test 333.333 
		out.print("Enter the original bill amount :: ");
		amt = keyboard.nextDouble();
		amt = Discount.getDiscountedBill(amt);
		out.printf("Bill after discount: %.2f \n",amt);
		
		//Test 95874.2145
		out.print("Enter the original bill amount :: ");
		amt = keyboard.nextDouble();
		amt = Discount.getDiscountedBill(amt);
		out.printf("Bill after discount: %.2f \n",amt);

	}
}