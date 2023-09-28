<div align="center">
    <br>
    <img src="https://img.freepik.com/free-vector/hands-holding-pencils-play-tic-tac-toe-people-drawing-crosses-noughts-simple-game-children-flat-vector-illustration-strategy-concept-banner-website-design-landing-web-page_74855-24786.jpg"/>
    <br>
    <h1>TIC-TAC-TOE</h1>
    <p>
The project centered around creating a classic game of Tic-Tac-Toe using C.
</p>
</div>
    
## Project Overview:
The project centered around creating a classic game of Tic-Tac-Toe using C. Tic-Tac-Toe is a two-player game where players take turns marking 'X' or 'O' on a 3x3 grid. The objective is to form a line of three of their marks either horizontally, vertically, or diagonally.

## Design:
The game will be designed with the following components:<br>
•	A 3x3 grid to represent the game board.<br>
•	Two players, each represented by 'X' and 'O' characters.<br>
•	Functions to display the game board, check for a win or draw condition, and handle player input.

## Implementation:
Displaying the Game Board (display_board function): <br>
•	The game board will be displayed using ASCII characters to create a grid.<br>
•	The function will iterate through the 3x3 array and print each cell's content.<br>
•	Vertical lines will separate columns, and horizontal lines will separate rows to create a visual grid.

Checking for a Win (check_win function):<br>
•	The function will iterate through rows, columns, and diagonals to check for a winning condition.<br>
•	If three identical characters ('X' or 'O') are found in a row, column, or diagonal, the game will be considered won.

Player Input and Turn Handling:<br>
•	The game will alternate between two players, Player 1 ('X') and Player 2 ('O').<br>
•	Players will be prompted to enter the row and column they want to mark.<br>
•	Input validation will be performed to ensure the chosen cell is within the valid range and not already marked.

Game Loop:<br>
•	The game will continue until a winning condition is met or the game ends in a draw (after 9 moves).<br>
•	The loop will display the current state of the board, prompt the active player for input, and update the board.


