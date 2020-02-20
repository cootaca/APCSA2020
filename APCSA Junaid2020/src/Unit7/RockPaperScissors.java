package Unit7;
//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Scanner;
import static java.lang.System.*;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;

	public RockPaperScissors()
	{
		playChoice = "";
		compChoice = "";
	}

	public RockPaperScissors(String player)
	{
		playChoice = player;
	}

	public void setPlayers(String player)
	{
		playChoice = player;
	}

	public String determineWinner()
	{
		String winner="";
		int num = (int)Math.random()*3;
		if (num == 0) {
			compChoice = "r";
			
		}
		else if(num==1)
			compChoice = "p";
		else
			compChoice = "s";
		
		if (playChoice.toLowerCase().equals(compChoice))
			winner="!Draw game!";
		else if(playChoice.toLowerCase().equals("r")&&num==1) 
			winner = "!Computer wins <<Paper Covers Rock>>!";
		else if(playChoice.toLowerCase().equals("p")&&num==2) 
			winner = "!Computer wins <<Scissors cuts Paper>>!";
		else if(playChoice.toLowerCase().equals("s")&&num==0) 
			winner = "!Computer wins <<Rock breaks Scissors>>!";
		else if(playChoice.toLowerCase().equals("p")&&num==0) 
			winner = "!Player wins <<Paper Covers Rock>>!";
		else if(playChoice.toLowerCase().equals("s")&&num==1) 
			winner = "!Player wins <<Scissors cuts Paper>>!";
		else 
			winner = "!Player wins <<Rock breaks Scissors>>!";
		
		return winner;
	}

	public String toString()
	{
		String winner = determineWinner();
		String output="player had "+playChoice +"\ncomputer had "+compChoice.toUpperCase()+"\n"+winner;
		return output;
	}
}