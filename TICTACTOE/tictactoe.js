//To run it, make sure you have Node.js installed, save the code in a .js file (e.g., ticTacToe.js), and execute it using the Node.js runtime.
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

function displayBoard(board) {
    for (let i = 0; i < 3; i++) {
        for (let j = 0; j < 3; j++) {
            process.stdout.write(` ${board[i][j]} `);
            if (j < 2) process.stdout.write('|');
        }
        console.log();
        if (i < 2) console.log('-----------');
    }
}

function checkWin(board, player) {
    for (let i = 0; i < 3; i++) {
        if (board[i][0] === player && board[i][1] === player && board[i][2] === player) return true;
        if (board[0][i] === player && board[1][i] === player && board[2][i] === player) return true;
    }
    if (board[0][0] === player && board[1][1] === player && board[2][2] === player) return true;
    if (board[0][2] === player && board[1][1] === player && board[2][0] === player) return true;
    return false;
}

function main() {
    const board = [['1', '2', '3'], ['4', '5', '6'], ['7', '8', '9']];
    let playerTurn = 1;
    let totalMoves = 0;

    function getInput() {
        rl.question(`Player ${playerTurn} (X), enter row and column (1-3): `, (input) => {
            const [row, col] = input.split(' ').map(Number);

            if (row < 1 || row > 3 || col < 1 || col > 3 || board[row - 1][col - 1] === 'X' || board[row - 1][col - 1] === 'O') {
                console.log('Invalid move. Try again.');
                getInput();
                return;
            }

            if (playerTurn === 1) {
                board[row - 1][col - 1] = 'X';
            } else {
                board[row - 1][col - 1] = 'O';
            }

            if (checkWin(board, 'X')) {
                displayBoard(board);
                console.log('Player 1 (X) wins!');
                rl.close();
            } else if (checkWin(board, 'O')) {
                displayBoard(board);
                console.log('Player 2 (O) wins!');
                rl.close();
            } else {
                playerTurn = 3 - playerTurn; // Switch players (1 to 2, and 2 to 1)
                totalMoves++;

                if (totalMoves === 9) {
                    displayBoard(board);
                    console.log("It's a draw!");
                    rl.close();
                } else {
                    displayBoard(board);
                    getInput();
                }
            }
        });
    }

    displayBoard(board);
    getInput();
}

main();
