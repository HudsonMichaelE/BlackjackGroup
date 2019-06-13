package Blackjack;
import java.util.Random;

public class Dealer implements Player {
	ArrayList<char> hand;
	private static char[] cards;
	private int n;
	public Dealer() {
		     char[] suits = {'A','A','A','A', 'J','J','J','J','Q','Q','Q','Q','K','K','K','K'};
		     char[] numbers = {'2','2','2','2','3','3','3','3','4','4','4','4','5','5','5','5','6','6','6','6','7','7','7','7','8','8','8','8','9','9','9','9','0','0','0','0'};
		     cards = concat(suits,numbers);
		
	}
	
	@Override
	boolean doesPlayerHit() {
		if (score < = 17)
			return true;
		else
			return false;
	}
	
	@Override
	void getCardValue(char card) {
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
	
	public static void shuffle() {
		 int index;
		    Random random = new Random();
		    for (int i = cards.length - 1; i > 0; i--)
		    {
		        index = random.nextInt(i + 1);
		        if (index != i)
		        {
		            cards[index] ^= cards[i];
		            cards[i] ^= cards[index];
		            cards[index] ^= cards[i];
		        }
		    }
			
		
		
	}
	
	public deal(Player p) {
		if(cards.length() == 52) {
				shuffle();
			for(int i = 0; i < 2; i++)
				char c = cards[n];
					p.addtoHand(n);
					n++;
		}
		
		else {
			for(int i = 0; i < 1; i++)
				char c = cards[n];
				p.addtoHand(n);
				n++;
			
		
		}
		
	}
	
	public void addtoHand(char card) {
				hand.add(card);
	}
	
	public ArrayList<char> displayCards(){
		
					return hand;
	}
	
	
	 static char[] concat(char[] a, char[] b) {
		   char[] c= new char[a.length+b.length];
		   System.arraycopy(a, 0, c, 0, a.length);
		   System.arraycopy(b, 0, c, a.length, b.length);
		   return c;
		}
	}


}
