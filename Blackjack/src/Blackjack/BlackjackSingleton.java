package Blackjack;

import java.util.*;

//Holds the engine of the game
public class BlackjackSingleton {
	private Dealer dealer;
	private ArrayList<Player> players;
	private Deck deck;
	
	private int playerNum = 0;
	private int pot = 0;
	
	private static BlackjackSingleton instance;
	
	
	
	private BlackjackSingleton() {
		dealer = new Dealer();
		deck = new Deck();
	}
	
	public BlackjackSingleton getInstance() {
		if(instance == null) {
			instance = new BlackjackSingleton();
		}
		
		return instance;
	}
	
	public void addPlayer(Player newPlayer) {
		players.add(newPlayer);
		playerNum += 1;
	}
	
	public Dealer getDealer() {
		return dealer;
	}
	/********************************************/
	//facade
	public void Round() {
		//players turn
		for(int i = 0; i < playerNum; i++) {
			players.get(i).placeBet();
			while(players.get(i).doesPlayerHit()) {
				players.get(i).addtoHand(deck.draw());
			}
		}
		
		//dealers turn
		while(dealer.doesPlayerHit()) {
			dealer.addtoHand(deck.draw());
		}
		
		endRound();
	}
	
	public void endRound() {
		if(dealer.getScore() == 21) {
			for(Player player : players) {
				player.bust();
			}
		} else if (dealer.getScore() > 21) {
			for(Player player : players) {
				player.win();
			}
		} else {
			for(Player player : players) {
				if(player.getScore() <= 21 &&  player.getScore() > dealer.getScore()) {
					player.win();
				} else {
					player.bust();
				}
			}
		}
		
		
	}
	
}
