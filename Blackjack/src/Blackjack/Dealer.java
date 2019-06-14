package src.Blackjack;
import java.util.Random;

public class Dealer implements Player {
	private static ArrayList<Character> hand;
	private static ArrayList<Character> cards;
	private static char[] card;
	private int n;
	private int score;
	import java.util.ArrayList;
	import java.util.Arrays;
	import java.util.Collections;

		
		public Dealer() {
				char[] card = {'A','A','A','A', 'J','J','J','J','Q','Q','Q','Q','K','K','K','K','2','2','2','2','3','3','3',
			    		 '3','4','4','4','4','5','5','5','5','6','6','6','6','7','7','7','7','8','8','8','8','9','9','9','9','0','0','0','0'};
		        Character[] newArray = new Character[card.length];
		        int i = 0;
		        for (char value : card) {
		            newArray[i++] = Character.valueOf(value);
		        }
		        cards = new ArrayList<Character>(Arrays.asList(newArray));
		       
			}
		
		
		public void deal(Player p) {
				
			 
			if(cards.size() == 52) {
			 
					Character c1 = cards.get(0);
					p.addtoHand(c1);
					cards.remove(0);
					Character c2 = cards.get(0);
					p.addtoHand(c2);
					cards.remove(0);
				
			}
			
			else {
				
				Character c3 = cards.get(0);
				p.addtoHand(c3);
				cards.remove(0);
			
			}
			
		}

		

		
		public static void shuffle() {
			  Collections.shuffle(cards); 
			  
		}
		
		
	@Override
	boolean doesPlayerHit() {
		if (score < = 17)
			return true;
		else
			return false;
	}
	
	@Override
	void getCardValue(Character card) {
		while (doesPlayerHit() == true) {
			if (card == 'A') {
				if (score > 11) 
					score+=11;
				 else if (score <= 11)
					score+=1;
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
	}
	}
	

	@Override
	int getScore() {
		return score;
		
	}
	
	@Override
	public void addtoHand(Character card) {
				getCardValue(card);
				hand.add(card);
	}
	
	@Override
	public Character displayCards(){
		Character c;
		for (Character p : hand)
				c = p
		return c;
	}
	
	
	


}
