package Blackjack;

import java.util.ArrayList;

public class MaryPlayer implements Player{
	
	Player mary;
	ArrayList<Character> hand;
	int wallet;
	public int bet;
	int score;
	
	private void MaryPlayer() {
		
	}
	
	public MaryPlayer getInstance() {
		if (mary == null) 
			mary = new MaryPlayer();
		return (MaryPlayer) mary;
	}

	@Override
	public int placeBet() {
		if (wallet >= 10)
			bet = wallet/2;
		else if (wallet < 10)
			bet = wallet;
		return bet;
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
	public void getCardValue(char card) {
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
				score+=11;
			 else if (card == 'K') 
				 score +=12;
			 else if (Character.getNumericValue(card) > 1)
				 score +=card;
			
		}
	}

	@Override
	public int getScore() {
		return score;
	}

}