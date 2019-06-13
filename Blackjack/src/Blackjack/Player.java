package src.Blackjack;

import java.util.ArrayList;

public interface Player {	
	/**
	 * Template interface for user-created players
	 * User needs to implement the following variables:
	 * int wallet;
	 * int score;
	 * if playing with character hands, needs an ArrayList<Character> hand
	 * 
	 * WARNING: using a 'char' for the cards breaks when at card value '10'. Use value 0 or value 1 to represent this instead
	 * 
	 * @return nothing I guess? uncertain. perhaps should return score so winning player ends the game immediately? 
	 * 
	 * these notes brought to you by mary
	 */
	int placeBet();  //your logic for how much and when to bet
	int getWallet(); //how much money you have.
	boolean doesPlayerHit(); //when do you hit? 
	void getCardValue(char card); //sorting out card values I guess?
	int getScore(); //returns player score
	public void addtoHand(char card); //adds cards to the players hand
	public ArrayList<char> displayCards(); // returns all the cards n the player's hand
}
