package Blackjack;
import java.util.*;

public class Deck {
	Character[] cards = {'A','A','A','A', 'J','J','J','J','Q','Q','Q','Q','K','K','K','K','2','2','2','2','3','3','3',
   		 '3','4','4','4','4','5','5','5','5','6','6','6','6','7','7','7','7','8','8','8','8','9','9','9','9','0','0','0','0'};
	ArrayList<Character> currentDeck;
	int currentSize;
	
	public Deck() {
		currentDeck = new ArrayList<Character>();
		Collections.addAll(currentDeck, cards);
		currentSize = 52;
	}
	
	public char draw() {
		Random rnd = new Random();
		
		int selection = rnd.nextInt(currentSize);
		char card = currentDeck.get(selection);
		
		currentDeck.remove(selection);
		currentSize -= 1;
		
		return card;
	}
	
	public void reshuffle() {
		currentDeck.clear();
		Collections.addAll(currentDeck, cards);
		currentSize = 52;
	}
}