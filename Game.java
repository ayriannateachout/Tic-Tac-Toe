/*
 * Programmer:Ayrianna Teachout
 * Date:11/12/23
 * Purpose:Creates a game and players
 */

public class Game {
    Player[] players;

    public Game(Player player1, Player player2) {
        players = new Player[]{player1, player2};
    }
}
