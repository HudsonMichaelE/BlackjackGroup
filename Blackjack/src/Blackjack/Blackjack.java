package Blackjack;
import java.util.*;

//main Class
public class Blackjack {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		Player newPlayer;
		BlackjackSingleton instance = BlackjackSingleton.getInstance();
		
		System.out.println("PipeWorks™ Presents:");
		System.out.println("2019 World Series: Blackjack\n\n\n");
		
		System.out.print("How many players?: ");
		int playerNum = scnr.nextInt();
		
		boolean playerAdded = false;
		for(int i = 0; i < playerNum; i++) {
			do {
				System.out.println("Enter name for player " + (i+1) + ":");
				String name = scnr.nextLine();
				try {
					newPlayer = (Player) Class.forName(name + "Player").newInstance();
					instance.addPlayer(newPlayer);
					playerAdded = true;
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					System.out.println("Player Class not located, please try again.");
				}
			} while(!playerAdded);
				playerAdded = false;
		}
		
		System.out.println("Done.");
	}
}
