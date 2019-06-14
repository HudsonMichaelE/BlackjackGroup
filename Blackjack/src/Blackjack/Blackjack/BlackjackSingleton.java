package Blackjack;

import java.util.*;

//Holds the engine of the game
public class BlackjackSingleton {
	private Dealer dealer;
	private ArrayList<Player> players;
	private int playerNum = 0;
	private int pot = 0;
	
	private static BlackjackSingleton instance;
	
	
	
	private BlackjackSingleton() {
		dealer = new Dealer();
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
		for(int i = 0; i < players.size(); i++) {
			pot += players(i).placeBet();
			while(players(i).doesPlayerHit()) {
				
			}
		}
	}
	
}
