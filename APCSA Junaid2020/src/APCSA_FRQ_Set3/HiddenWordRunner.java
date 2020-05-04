package APCSA_FRQ_Set3;

import java.util.*;

public class HiddenWordRunner {

	public static void main(String[] args) {
		String print = "";
		HiddenWord hWord = new HiddenWord();
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a guess with " + hWord.getLength() + " letters: ");
		String guess = scan.next();
		print = hWord.getHint(guess );
		System.out.println("Hint: "+print + "\n");
		while (print.equals(hWord.getWord()) == false) {
			System.out.println("Enter another guess with " + hWord.getLength() + " letters: ");
			guess = scan.next();
			print = hWord.getHint(guess);
			System.out.println("Hint: "+print+"\n");
		}
		System.out.println("You win!");

	}

}
