/*
 * Programmer:Ayrianna Teachout
 * Date:11/12/23
 * Purpose:Creates player 1 and player 2 and instantiates a game of TicTacToe
 */

public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Player 1", 1);
        Player player2 = new Player("Player 2", 1);

        TicTacToe ticTacToeGame = new TicTacToe(player1, player2); 
        ticTacToeGame.playGame(); //starts game
    }
}
