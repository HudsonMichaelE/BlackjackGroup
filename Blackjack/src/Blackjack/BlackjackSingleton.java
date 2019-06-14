package Blackjack;

import java.util.*;
import java.util.concurrent.TimeUnit;

//Holds the engine of the game
public class BlackjackSingleton {
	private Dealer dealer;
	private ArrayList<Player> players;
	private Deck deck;
	
	private int playerNum = 0;
	
	private static BlackjackSingleton instance;
	
	
	
	private BlackjackSingleton() {
		dealer = new Dealer();
		deck = new Deck();
		players = new ArrayList<Player>();
	}
	
	public static BlackjackSingleton getInstance() {
		if(instance == null) {
			instance = new BlackjackSingleton();
		}
		
		return instance;
	}
	
	public boolean addPlayer(String name) {
		Player newPlayer;
		try {
			newPlayer = (Player) Class.forName("Blackjack." + name + "Player").newInstance();
		} catch (InstantiationException e) {
			return false;
		} catch (IllegalAccessException e) {
			return false;
		} catch (ClassNotFoundException e) {
			return false;
		}
		players.add(newPlayer);
		playerNum += 1;
		return true;
	}
	
	public Dealer getDealer() {
		return dealer;
	}
	/**
	 * @throws InterruptedException ******************************************/
	//facade
	public void Round() throws InterruptedException {
		System.out.println("New Round");
		//players turn
		for(int i = 0; i < playerNum; i++) {
			players.get(i).placeBet();
			TimeUnit.SECONDS.sleep(1);
			players.get(i).addtoHand(deck.draw());
			players.get(i).addtoHand(deck.draw());
			players.get(i).displayCards();
			TimeUnit.SECONDS.sleep(1);
		}
		
		for(int i = 0; i < playerNum; i++) {
			while(players.get(i).doesPlayerHit()) {
				players.get(i).addtoHand(deck.draw());
				players.get(i).displayCards();
				TimeUnit.SECONDS.sleep(1);
			}
		}
		
		dealer.addtoHand(deck.draw());
		dealer.addtoHand(deck.draw());
		dealer.displayCards();
		TimeUnit.SECONDS.sleep(1);
		//dealers turn
		while(dealer.doesPlayerHit()) {
			dealer.addtoHand(deck.draw());
			dealer.displayCards();
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
