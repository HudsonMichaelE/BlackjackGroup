package Blackjack;

public interface Player {

	int placeBet();
	
	Boolean doesPlayerHit();
	
	void Hit(char Card);
	
	int getScore();
	
	
}
