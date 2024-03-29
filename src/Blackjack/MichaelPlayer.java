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
		//System.out.println("Michael Hits");
		if(score == 10) {
			card = 'A';
		}
		hand.add(card);
		getCardValue(card);
		
	}
	
	@Override
	public void win() {
		wallet += bet;
		System.out.println("Michael won " + bet);
		System.out.println("Michael currently has " + wallet);
		bet = 0;
		clear();
	}

	@Override
	public void placeBet() {
		if(wallet > 100) {
			bet = 50;
		} else {
			bet = 10;
		}
		System.out.println("Michael bets " + bet);
	}

	@Override
	public void getCardValue(Character card) {
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
	public void displayCards() {
		System.out.print("Michael's hand: ");
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
	public void bust() {
		wallet -= bet;
		System.out.println("Michael lost " + bet);
		System.out.println("Michael currently has " + wallet);
		bet = 0;
		clear();
	}

	@Override
	public boolean stand() {
		if(wallet < 10 || wallet > 500) {
			System.out.println("Michael leave the table with " + wallet);
			return true;
		}
		return false;
	}
	
	private void clear() {
		hand.clear();
		score = 0;
	}
}
