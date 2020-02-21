package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RPSRunner
{
	public static void main(String args[])
	{
		run();
	}
	public static void run() {
		Scanner keyboard = new Scanner(System.in);
		
		char response;
		
		//add in a do while loop after you get the basics up and running
		
			String player = "";
		
			out.print("\ntype in your prompt [R,P,S] :: ");
			
			//read in the player value
		
			RockPaperScissors game = new RockPaperScissors(keyboard.nextLine());	
			System.out.println(game);
			
			System.out.print("\nDo you want to play again?[y/n] :: ");
			if(keyboard.nextLine().toLowerCase().equals("y"))
				run();
	}
	
}



