package Blackjack;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class Dealer implements Player {
	private ArrayList<Character> hand;
	//private static ArrayList<Character> cards;
	private int score;
	
		
	public Dealer() {
		hand = new ArrayList<Character>();
		score = 0;
				/*char[] card = {'A','A','A','A', 'J','J','J','J','Q','Q','Q','Q','K','K','K','K','2','2','2','2','3','3','3',
			    		 '3','4','4','4','4','5','5','5','5','6','6','6','6','7','7','7','7','8','8','8','8','9','9','9','9','0','0','0','0'};
		        Character[] newArray = new Character[card.length];
		        int i = 0;
		        for (char value : card) {
		            newArray[i++] = Character.valueOf(value);
		        }
		        cards = new ArrayList<Character>(Arrays.asList(newArray));*/     
	}
		
		
		/*public void deal(Player p) {
				
			 
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
			  
		}*/
		
		
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
			System.out.print(card + " ");
		}
		System.out.println("\nTotal score: " + score + "\n");
	}

	@Override
	public void placeBet() {
	}


	@Override
	public int getWallet() {
		return 0;
	}

	@Override
	public void win() {
		
	}


	@Override
	public void bust() {
		
	}
}
	


