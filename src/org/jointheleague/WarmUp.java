package org.jointheleague;

import java.util.ArrayList;

public class WarmUp {
	
	// ArrayList<String> listOfGuesses;

	public int score(String keyWord, ArrayList listOfGuesses) {
		int score = 0;
		for (int i = 0; i < listOfGuesses.size(); i++) {
			if (listOfGuesses.get(i).equals(keyWord)) {
				score = score + 1;
			}
		}
		//System.out.println(score);
		return score;
		

	}

	public static void main(String[] args) {
		WarmUp warmUp = new WarmUp();
		ArrayList<String> listOfGuesses = new ArrayList<String>();
		listOfGuesses.add("abc");
		listOfGuesses.add("juice");
		listOfGuesses.add("people");
		listOfGuesses.add("five");
		listOfGuesses.add("people");
		System.out.println("score for peoplpe should be 2, it actually is "+warmUp.score("people", listOfGuesses));
		System.out.println("score for juice should be 1, it actually is "+warmUp.score("juice", listOfGuesses));
		System.out.println("score for fghjk should be 0, it actually is "+warmUp.score("fghjk", listOfGuesses));



	}
}
