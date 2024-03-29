package Blackjack;

import java.util.ArrayList;

public class AmariPlayer implements Player {

			 ArrayList<Character> hand;
	          int wallet;
	          int score;
	          int bet;
	           private int count = 1;
			
	  
	        public AmariPlayer(){
	 
	                   hand = new ArrayList<Character>();
	                    wallet = 100;
	                   score = 0;
	 
	          }
	 
	 
	           @Override
	           public void placeBet() {
	                       //while(wallet != 0){ <- creates an infinite loop
	                                 if(wallet >= 150){
	                                         bet = 30;
	                                  }
	                                 else if(wallet < 150 && wallet >= 100){
	                                         bet = 20;
	                                 }
	 
	                                  else{
	                                        bet = 10;
	                                 }
	                                 System.out.println("Amari bets " + bet);
	                         //}
	          }
	 
	         @Override
	         public int getWallet() {
	                return wallet;
	         }
	 
	        @Override
	        public boolean doesPlayerHit() {
	                  if(wallet >= 50){
	                          if(score < 16){
	                                  return true;
	                          }
	                  }
	                  else{
	                        if(score <= 10){
	                                return true;
	                        }
	                         if(score <= 15){
	                                return true;
	                         }
	                         if(score == 19 || score == 20){
	                                 return false;
	                         }
	                  }
	                        	
	                    return false;
	          }
	        
	        @Override
	    	public void getCardValue(Character card) {
	    			if (card == 'A') {
	    				
	    				for(Character c : hand) {
	    					if(c.equals('A')) {
	    						count++;
	    					}
	    				}
	    				if (count == 1) { 
	    					score+=11;
	    				}
	    				 else if (count > 1) {
	    					score+=1;
	    				 }
	    			}
	    			 else if (card == 'J' || card == '0' || card == 'Q' || card == 'K')   //use 0 to make 10 a single char
	    				score+=10;
	    			 else if(card == '2')
	    				 score += 2;
	    			 else if(card == '3')
	    				 score +=3;
	    			 else if(card == '4')
	    				 score += 4;
	    			 else if(card == '5')
	    				 score +=5;
	    			 else if(card == '6')
	    				 score += 6;
	    			 else if(card == '7')
	    				 score +=7;
	    			 else if(card == '8')
	    				 score += 8;
	    			 else if(card == '9')
	    				 score +=9;
	    	}
	        @Override
	    	public int getScore() {
	    		return score;
	    		
	    	}
	    	
	    	@Override
	    	public void addtoHand(Character card) {
	    				hand.add(card);
	    				getCardValue(card);
	    	}
	    	
	    	@Override
	    	public void displayCards(){
	    		System.out.print("Amari's hand: ");
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
	    	public void win() {
	    		wallet += bet;
	    		System.out.println("Amari won " + bet);
	    		System.out.println("Amari currently has " + wallet);
	    		bet = 0;
	    		clear();
	    	}


	    	@Override
	    	public void bust() {
	    		wallet -= bet;
	    		System.out.println("Amari lost " + bet);
	    		System.out.println("Amari currently has " + wallet);
	    		bet = 0;
	    		clear();
	    	}


			@Override
			public boolean stand() {
				if(wallet >= 500 || wallet == 0) {
					System.out.println("Amari leaves the table with " + wallet);
					return true;
					
				}
				return false;
			}
			
			private void clear() {
				hand.clear();
				score = 0;
				count = 0;
			}
	    }
	    	



