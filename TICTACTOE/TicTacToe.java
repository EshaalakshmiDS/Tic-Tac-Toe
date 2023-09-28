import java.util.Scanner;

public class TicTacToe {
    // Function to display the Tic-Tac-Toe board
    static void displayBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < 2) System.out.print("|");
            }
            System.out.println();
            if (i < 2) System.out.println("-----------");
        }
    }

    // Function to check if a player has won
    static boolean checkWin(char[][] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
        int playerTurn = 1;
        int totalMoves = 0;

        Scanner scanner = new Scanner(System.in);

        while (totalMoves < 9) {
            displayBoard(board);

            int row, col;
            if (playerTurn == 1) {
                System.out.print("Player 1 (X), enter row and column (1-3): ");
            } else {
                System.out.print("Player 2 (O), enter row and column (1-3): ");
            }

            row = scanner.nextInt();
            col = scanner.nextInt();

            if (row < 1 || row > 3 || col < 1 || col > 3 || board[row - 1][col - 1] == 'X' || board[row - 1][col - 1] == 'O') {
                System.out.println("Invalid move. Try again.");
                continue;
            }

            if (playerTurn == 1) {
                board[row - 1][col - 1] = 'X';
            } else {
                board[row - 1][col - 1] = 'O';
            }

            if (checkWin(board, 'X')) {
                displayBoard(board);
                System.out.println("Player 1 (X) wins!");
                break;
            } else if (checkWin(board, 'O')) {
                displayBoard(board);
                System.out.println("Player 2 (O) wins!");
                break;
            }

            playerTurn = 3 - playerTurn;  // Switch players (1 to 2, and 2 to 1)
            totalMoves++;
        }

        if (totalMoves == 9) {
            displayBoard(board);
            System.out.println("It's a draw!");
        }

        scanner.close();
    }
}
