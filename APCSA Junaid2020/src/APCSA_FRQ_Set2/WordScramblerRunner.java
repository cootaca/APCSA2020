package APCSA_FRQ_Set2;

public class WordScramblerRunner {

	public static void main(String[] args) {
		String[] strs = {"apple", "pear", "this", "cat"};
		WordScrambler scrambler = new WordScrambler(strs);
		System.out.println(scrambler);
	}

}
