package org.jointheleague;

import java.util.ArrayList;

public class ScoringWarmUp {
	
	   int totalScore;
	public int scoreIndividualGuess( String guess, String answer) {
		if(guess.equalsIgnoreCase(answer)) {
			return 2;
		}
		else if(guess.toLowerCase().contains(answer.toLowerCase())) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	public int scoreAllGuesses( ArrayList<String> listOfGuesses, String answer) {
		for(int i=0; i < listOfGuesses.size(); i++) {
			//scoreIndividualGuess(listOfGuesses.get(i), answer);
			totalScore = totalScore + scoreIndividualGuess(listOfGuesses.get(i), answer);
			//System.out.println(totalScore + " this is just syso's number"); 
		}
		return totalScore;
	}
	
	public static void main(String[] args) {
		
		ScoringWarmUp warmUp = new ScoringWarmUp();
		String answer = "Candy";
		ArrayList<String> listOfGuesses = new ArrayList<String>();
		listOfGuesses.add("candy");
		listOfGuesses.add("sugar");
		listOfGuesses.add("sweet candy");
		System.out.println("Your score should be 3, it actually is: "+ warmUp.scoreAllGuesses(listOfGuesses, answer));
		//System.out.println( warmUp.scoreIndividualGuess("testing", "testing"));
		//System.out.println(warmUp.scoreIndividualGuess("testingStuff", "Testing"));
		//System.out.println(warmUp.scoreIndividualGuess("asdfghjkl", "testing"));
		
	}
	
}

