package Blackjack;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Dealer implements Player {
	private ArrayList<Character> hand;
	private int score;
	private int wallet;
	private int count;
	private int bet;
	
	
		
	public Dealer() {
		hand = new ArrayList<Character>();
		score = 0;
		wallet = 0;
		bet = 0;
			
			 
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
			if (card == 'A') {
				
				for(Character c : hand) {
					if(c.equals('A')) {
						count++;
					}
				}
				if (count == 1) { 
					score+=11;
				}
				 else if (count > 1) {
					score+=1;
				 }
			}
			 else if (card == 'J' || card == '0' || card == 'Q' || card == 'K')   //use 0 to make 10 a single char
				score+=10;
			 else if(card == '2')
				 score += 2;
			 else if(card == '3')
				 score +=3;
			 else if(card == '4')
				 score += 4;
			 else if(card == '5')
				 score +=5;
			 else if(card == '6')
				 score += 6;
			 else if(card == '7')
				 score +=7;
			 else if(card == '8')
				 score += 8;
			 else if(card == '9')
				 score +=9;
	}
	

	@Override
	public int getScore() {
		return score;
		
	}
	
	@Override
	public void addtoHand(Character card) {
				hand.add(card);
				getCardValue(card);
	}
	
	@Override
	public void displayCards(){
		System.out.print("Dealer's hand: ");
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
	public void placeBet() {
		bet = 0;
	}


	@Override
	public int getWallet() {
		return 0;
	}

	@Override
	public void win() {
		wallet += bet;
		bet = 0;
	}


	@Override
	public void bust() {
		wallet -= bet;
		bet = 0;
		
	}

	@Override
	public boolean stand() {
		clear();
		return false;
	}
	
	private void clear() {
		hand.clear();
		score = 0;
	}
}
	


