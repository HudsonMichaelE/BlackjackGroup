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
	public void placeBet() {
		if (wallet >= 10)
			bet = wallet/2;
		else if (wallet < 10)
			bet = wallet;
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

	@Override
	public void win() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bust() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addtoHand(Character card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayCards() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean stand() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeCards() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setScore(int i) {
		// TODO Auto-generated method stub
		
	}

}
