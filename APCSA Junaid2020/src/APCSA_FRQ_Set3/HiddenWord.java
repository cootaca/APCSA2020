package APCSA_FRQ_Set3;

public class HiddenWord {
	private String hiddenWord;
	public HiddenWord() {
		hiddenWord = "HARPS";
	}
	public HiddenWord(String str) {
		hiddenWord = str;
	}
	public String getHint(String input) {
		String output = "";
		String guess = input.toUpperCase();
		for(int i=0;i<guess.length();i++) {
			if(guess.charAt(i)==hiddenWord.charAt(i))
				output+=guess.substring(i,i+1);
			else if(hiddenWord.contains(guess.substring(i,i+1)))
				output+= "+";
			else
				output += "*";
		}
		return output;
	}
	public int getLength() {
		return hiddenWord.length();
	}
	public String getWord() {
		return this.hiddenWord;
	}
}
