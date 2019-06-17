package Blackjack;

import java.util.ArrayList;

public class NeilPlayer implements Player {

    private ArrayList<Character> hand;
    private int wallet;
    private int score;
    private int bet;

    public NeilPlayer( ) {
       hand = new ArrayList<Character>();
        wallet=100;
        score=0;
    }

    @Override
    public void placeBet() {
        bet=10;
        if (bet>wallet)
            bet=wallet;
        System.out.println("Neil bets " + bet);
    }

    @Override
    public int getWallet() {
        return wallet;
    }

    @Override
    public void win() {
        wallet += bet;
        System.out.println("Neil won " + bet);
		System.out.println("Neil currently has " + wallet);
        bet = 0;
        clear();
    }

    @Override
    public void bust() {
        wallet -= bet;
        System.out.println("Neil lost " + bet);
		System.out.println("Neil currently has " + wallet);
        bet = 0;
        clear();
    }

    @Override
    public boolean doesPlayerHit() {
        if(score<16)
            return true;
        return false;
    }

    @Override
    public void getCardValue(Character card) {
        if(card=='A'){
            if (score==10)
                score+=11;
            else
                score+=1;

        }
        else if(card=='J'||card=='K'||card=='Q'||card=='0')
            score+=10;
        else
            score+=Character.getNumericValue(card);

    }

    @Override
    public int getScore() {
        return score;
    }

    @Override
    public void addtoHand(Character card) {
    	getCardValue(card);
        hand.add(card);
    }

    @Override
    public void displayCards() {
        System.out.print("Neil's hand: ");
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
	public boolean stand() {
		if(wallet < 50 || wallet > 300) {
			System.out.println("Neil leave the table with " + wallet);
			return true;
		}
		return false;
	}
	
	private void clear() {
		hand.clear();
		score = 0;
	}
	
}
