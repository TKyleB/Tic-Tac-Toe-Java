package com.tkyleb.tictactoe.model;

public class Game {
    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private Player currentTurn;
    private int turn;

    public Game(Player playerOne, Player playerTwo) {
        this.board = new Board();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentTurn = playerOne;
        this.turn = 1;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public Board getBoard() {
        return board;
    }

    public void switchTurns() {
        turn ++;
        if (currentTurn == playerOne) currentTurn = playerTwo;
        else currentTurn = playerOne;
    }

    public WinResult checkWin() {
        WinResult result;
        for (int i = 0; i < board.getSize(); i++) {
            //Row
            result = handleWin(checkSection(board.getBoardRow(i)));
            if (result.isWinner()) return result;
            //Columns
            result = handleWin(checkSection(board.getBoardColumn(i)));
            if (result.isWinner()) return result;
            //Left Diagonal
            result = handleWin(checkSection(board.getBoardLeftDiagonal()));
            if (result.isWinner()) return result;
            //Right Diagonal
            result = handleWin((checkSection(board.getBoardRightDiagonal())));
            if (result.isWinner()) return result;

        }
        if (turn == 10) return WinResult.yes(new Player(Symbol.Empty));
        return WinResult.no();
    }

    private Player getPlayerSymbol(Symbol symbol) {
        // Returns the player that matches the symbol
        if (playerOne.getSymbol() == symbol) return playerOne;
        else return playerTwo;
    }

    private Symbol checkSection(Cell[] section) {
        var first = section[0].getState();
        if (first == Symbol.Empty) return null;
        else {
            for (int i = 1; i <section.length; i++) {
                if (first != section[i].getState()) return null;
            }
        }
        return first;
    }
    private WinResult handleWin(Symbol winnerSymbol) {
        if (winnerSymbol != null) {
            var winningPlayer = getPlayerSymbol(winnerSymbol);
            return WinResult.yes(winningPlayer);
        }
        return WinResult.no();
    }

    public UpdateResult makeMove(int row, int col) {
        var updateResult = board.updateCell(row, col, getCurrentTurn().getSymbol());
        if (updateResult.isSuccess()) {
            switchTurns();
        }
        return updateResult;
    }


}
