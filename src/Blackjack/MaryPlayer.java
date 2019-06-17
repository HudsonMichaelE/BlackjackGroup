package Blackjack;

import java.util.ArrayList;

public class MaryPlayer implements Player{
	ArrayList<Character> hand;
	int wallet;
	public int bet;
	int score;
	
	public MaryPlayer() {
		hand = new ArrayList<Character>();
		wallet = 100;
		bet = 0;
		score = 0;
	}

	@Override
	public void placeBet() {
		if (wallet >= 10)
			bet = wallet/2;
		else if (wallet < 10)
			bet = wallet;
		System.out.println("Mary bets " + bet);
	}

	@Override
	public int getWallet() {
		return wallet;
	}

	@Override
	public boolean doesPlayerHit() {
		if (score <= 17)
			return true;
		else
			return false;
	}
	
	@Override
	public void addtoHand(Character card) {
		hand.add(card);
		getCardValue(card);
		
	}

	@Override
	public void getCardValue(Character card) {
		while (doesPlayerHit() == true) {
			if (card == 'A') {
				if (score > 11) 
					score+=11;
				 else if (score <= 11)
					score+=1;
			}
			 else if (card == 'J' || card == '0')   //use 0 to make 10 a single char
				score+=10;
			 else if (card == 'Q') 
				score+=10;
			 else if (card == 'K') 
				 score +=10;
			 else
				 score += Character.getNumericValue(card);
			
		}
	}
	
	@Override
	public void displayCards() {
		System.out.print("Mary's hand: ");
		for(Character card : hand) {
			if(card.equals('0')) {
				System.out.print("10 ");
			} else {
				System.out.print(card + " ");
			}
		}
		System.out.println("\nTotal score: " + score + "\n");
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public void win() {
		wallet += bet;
		System.out.println("Mary won " + bet);
		System.out.println("Mary currently has " + wallet);
		bet = 0;
		clear();
	}

	@Override
	public void bust() {
		wallet -= bet;
		System.out.println("Mary lost " + bet);
		System.out.println("Mary currently has " + wallet);
		bet = 0;
		clear();
	}


	@Override
	public boolean stand() {
		if(wallet >= 500 || wallet == 0) {
			System.out.println("Mary leaves the table with $" + wallet);
			return true;
		}
		return false;
	}
	
	private void clear() {
		hand.clear();
		score = 0;
	}
}
