package Blackjack;
import java.util.*;
import java.util.concurrent.TimeUnit;

//main Class
public class Blackjack {
	public static void main(String[] args) throws InterruptedException {
		Scanner scnr = new Scanner(System.in);
		int playerNum = 0;
		BlackjackSingleton instance = BlackjackSingleton.getInstance();
		
		//intro
		System.out.println("PipeWorks™ Presents:");
		System.out.println("2019 World Series: Blackjack\n\n");
		
		//Game setup: player number
		do {
			System.out.print("How many players?(1-4): ");
			playerNum = scnr.nextInt();
			scnr.nextLine();	
		} while(playerNum > 4 || playerNum < 1);
		
		//Game setup: player names
		boolean playerAdded = false;
		for(int i = 0; i < playerNum; i++) {
			do {
				System.out.println("Enter name for player " + (i+1) + ":");
				String name = scnr.nextLine();
				
				if(instance.addPlayer(name)) {
					playerAdded = true;
				} else {
					System.out.println("Player Class not located, please try again.");
				}
			} while(!playerAdded);
				playerAdded = false;
		}
		
		//Game starting
		System.out.println("Let's get ready to blackjack!");
		System.out.print("Shuffling deck");
		for(int i = 0; i < 5; i++) {
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println();
		System.out.print("Dealing cards");
		for(int i = 0; i < 5; i++) {
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println();
		
		//Round Loop
		while(!instance.isGameOver()) {
			instance.Round();
		}
		
		//Game end
		System.out.print("All players have left the table");
		for(int i = 0; i < 3; i++) {
			System.out.print(".");
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println();
		System.out.println("Game Over, come back with more money!");
		TimeUnit.SECONDS.sleep(1);
		System.out.println("PipeWorks™ Interactive.\nTrademark 1962");
	}
}
