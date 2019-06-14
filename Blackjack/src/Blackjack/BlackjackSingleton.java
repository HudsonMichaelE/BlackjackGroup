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
			pot += players.get(i).placeBet();
			while(players.get(i).doesPlayerHit()) {
				players.get(i).addtoHand(deck.draw());
			}
		}
		
		//dealers turn
		while(dealer.doesPlayerHit()) {
			dealer.addtoHand(deck.draw());
		}
	}
	
}
