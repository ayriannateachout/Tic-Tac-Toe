/*
 * Programmer:Ayrianna Teachout
 * Date:11/12/23
 * Purpose:Specific implementation of the game TicTacToe inherits from Game
 */

import java.util.Scanner;

class TicTacToe extends Game {
    char[][] board;

    public TicTacToe(Player player1, Player player2) {
        super(player1, player2);
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() { //creates tictactoe board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void printBoard() { //prints the board in console
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    private boolean playMove(Player player, int row, int col) { //logic for players move
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = (player == players[0]) ? 'X' : 'O';
            player.numMoves++;
            printBoard();
            return true;
        } else {
            System.out.println("Invalid move. Try again.");
            return false;
        }
    }

    private boolean checkWinner() {
        // check rows, columns, and diagonals for a winner
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != ' ') {
                return true;
            }
            if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != ' ') {
                return true;
            }
        }
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != ' ') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != ' ') {
            return true;
        }
        return false;
    }

    private boolean isBoardFull() { //logic for cats game
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public void playGame() { //game display for console
        Scanner oScan = new Scanner(System.in);
        System.out.println("Let's play Tic-Tac-Toe!");
        printBoard();

        while (true) {
            for (Player player : players) {
                System.out.println(player.name + "'s turn (" + (player == players[0] ? 'X' : 'O') + ")");
                System.out.print("Enter the row (0, 1, or 2): ");
                int row = oScan.nextInt();
                System.out.print("Enter the column (0, 1, or 2): ");
                int col = oScan.nextInt();

                while (!playMove(player, row, col)) {
                    System.out.print("Enter the row (0, 1, or 2): ");
                    row = oScan.nextInt();
                    System.out.print("Enter the column (0, 1, or 2): ");
                    col = oScan.nextInt();
                }

                if (checkWinner()) {
                    System.out.println("Congratulations, " + player.name + "! You won!");
                    player.numTimesPlayed++;
                    return;
                } else if (isBoardFull()) {
                    System.out.println("It's a tie!");
                    return;
                }
            }
        }
    }
}
