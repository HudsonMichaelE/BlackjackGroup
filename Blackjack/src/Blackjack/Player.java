package Blackjack;

public interface Player {

	int placeBet();
	
	boolean doesPlayerHit();
	
	void Hit(char Card);
	
	int getScore();
	
	int getShowingScore();
	
}
