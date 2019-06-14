package Blackjack;
import java.util.*;

public class MichaelPlayer implements Player{
	ArrayList<Character> hand;
	int wallet;
	int score;
	int bet;
	
	public MichaelPlayer() {
		hand = new ArrayList<Character>();
		wallet = 100;
		score = 0;
	}
	
	@Override
	public int getWallet() {
		return wallet;
	}
	
	@Override
	public int getScore() {
		return score;
	}
	
	@Override
	public boolean doesPlayerHit() {
		if(wallet > 50) {
			if(score < 16) {
				return true;
			}
		} else {
			if(score < 12) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public void addtoHand(Character card) {
		//Michael has a couple of Aces up his sleeve!
		if(score == 10) {
			card = 'A';
		}
		hand.add(card);
		
		switch(card) {
			case 'A':	score += 11;
						break;
			case 'K':
			case 'Q':
			case 'J':
			case '0':	score += 10;
						break;
			case '9':	score += 9;
						break;
			case '8':	score += 8;
						break;
			case '7':	score += 7;
						break;
			case '6':	score += 6;
						break;
			case '5':	score += 5;
						break;
			case '4':	score += 4;
						break;
			case '3':	score += 3;
						break;
			case '2':	score += 2;
						break;
		}
	}
	
	@Override
	public void addWinnings() {
		wallet += (2*bet);
	}

	@Override
	public void placeBet() {
		if(wallet > 100) {
			bet = 50;
		} else {
			bet = 10;
		}
	}

	@Override
	public void getCardValue(Character card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String displayCards() {
		// TODO Auto-generated method stub
		return "BUTTS";
	}

	@Override
	public Character displayFirstCard() {
		// TODO Auto-generated method stub
		return null;
	}
}
