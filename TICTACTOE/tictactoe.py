def display_board(board):
    for i in range(3):
        for j in range(3):
            print(f" {board[i][j]} ", end="")
            if j < 2:
                print("|", end="")
        print()
        if i < 2:
            print("-----------")

def check_win(board, player):
    for i in range(3):
        if all(board[i][j] == player for j in range(3)):
            return True
        if all(board[j][i] == player for j in range(3)):
            return True
    if all(board[i][i] == player for i in range(3)):
        return True
    if all(board[i][2 - i] == player for i in range(3)):
        return True
    return False

def main():
    board = [['1', '2', '3'], ['4', '5', '6'], ['7', '8', '9']]
    player_turn = 1
    total_moves = 0

    while total_moves < 9:
        display_board(board)

        if player_turn == 1:
            print("Player 1 (X), enter row and column (1-3): ")
        else:
            print("Player 2 (O), enter row and column (1-3): ")

        row, col = map(int, input().split())

        if row < 1 or row > 3 or col < 1 or col > 3 or board[row - 1][col - 1] == 'X' or board[row - 1][col - 1] == 'O':
            print("Invalid move. Try again.")
            continue

        if player_turn == 1:
            board[row - 1][col - 1] = 'X'
        else:
            board[row - 1][col - 1] = 'O'

        if check_win(board, 'X'):
            display_board(board)
            print("Player 1 (X) wins!")
            break
        elif check_win(board, 'O'):
            display_board(board)
            print("Player 2 (O) wins!")
            break

        player_turn = 3 - player_turn  # Switch players (1 to 2, and 2 to 1)
        total_moves += 1

    if total_moves == 9:
        display_board(board)
        print("It's a draw!")

if __name__ == "__main__":
    main()
