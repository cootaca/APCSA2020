package APCSA_FRQ_Set2;

import java.util.*;

public class WordScrambler {
	private String[] scrambledWords;
	public WordScrambler(String[] wordArr) {
		scrambledWords = mixedWords(wordArr);
	}
	public String toString() {
		return Arrays.toString(scrambledWords);
	}
	//Part a
	private String recombine(String word1, String word2) {		
		return word1.substring(0,word1.length()/2)+word2.substring(word2.length()/2);
	}
	//Part b
	private String[] mixedWords(String[] words) {
		String strs[] = new String[words.length];
		for(int i=0;i<words.length;i++) {
			if(i%2==0) {
				strs[i]=recombine(words[i],words[i+1]);
			}
			else
				strs[i]=recombine(words[i],words[i-1]);
		}
		return strs;
	}
}
