#include <stdio.h>

// Function to display the Tic-Tac-Toe board
void display_board(char board[3][3]) {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            printf(" %c ", board[i][j]);
            if (j < 2) printf("|");
        }
        printf("\n");
        if (i < 2) printf("-----------\n");
    }
}

// Function to check if a player has won
int check_win(char board[3][3], char player) {
    for (int i = 0; i < 3; i++) {
        if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return 1;
        if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return 1;
    }
    if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return 1;
    if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return 1;
    return 0;
}

int main() {
    char board[3][3] = {{'1', '2', '3'}, {'4', '5', '6'}, {'7', '8', '9'}};
    int player_turn = 1;
    int total_moves = 0;
while (total_moves < 9) {
        display_board(board);

       

 int row, col;
        if (player_turn == 1) {
            printf("Player 1 (X), enter row and column (1-3): ");
        } else {
            printf("Player 2 (O), enter row and column (1-3): ");
        }
        scanf("%d %d", &row, &col);

        if (row < 1 || row > 3 || col < 1 || col > 3 || board[row - 1][col - 1] == 'X' || board[row - 1][col - 1] == 'O') {
            printf("Invalid move. Try again.\n");
            continue;
        }

        if (player_turn == 1) {
            board[row - 1][col - 1] = 'X';
        } else {
            board[row - 1][col - 1] = 'O';
        }

        if (check_win(board, 'X')) {
            display_board(board);
            printf("Player 1 (X) wins!\n");
            break;
        } else if (check_win(board, 'O')) {
            display_board(board);
            printf("Player 2 (O) wins!\n");
            break;
        }

        player_turn = 3 - player_turn;  // Switch players (1 to 2, and 2 to 1)
        total_moves++;
    }


    if (total_moves == 9) {
        display_board(board);
        printf("It's a draw!\n");
    }

    return 0;
}

