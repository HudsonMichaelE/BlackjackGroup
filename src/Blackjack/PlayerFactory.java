package Blackjack;

public class PlayerFactory {

    public Player createPlayer(String name){
        Player newPlayer=null;
        try {
            newPlayer = (Player) Class.forName("Blackjack." + name + "Player").newInstance();
        } catch (InstantiationException e) {
            return null;
        } catch (IllegalAccessException e) {
            return null;
        } catch (ClassNotFoundException e) {
            return null;
        }
        return newPlayer;
    }
}
