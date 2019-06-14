package Blackjack;

public interface Player {	
	/**
	 * Template interface for user-created players
	 * User needs to implement the following variables:
	 * int wallet;
	 * int score;
	 * int bet;
	 * if playing with character hands, needs an ArrayList<Character> hand
	 * 
	 * WARNING: using a 'char' for the cards breaks when at card value '10'. Use value 0 or value 1 to represent this instead
	 * 
	 * @return nothing I guess? uncertain. perhaps should return score so winning player ends the game immediately? 
	 * 
	 * these notes brought to you by mary
	 */
	void placeBet();  //your logic for how much and when to bet
	int getWallet(); //how much money you have.
	void addWinnings(); //add bet to the wallet.
	boolean doesPlayerHit(); //when do you hit? 
	void getCardValue(Character card); //sorting out card values I guess?
	int getScore(); //returns player score
	void addtoHand(Character card); //adds cards to the players hand
	void displayCards(); // displays all the cards in the player's hand, to be used at the end of the game.
}

