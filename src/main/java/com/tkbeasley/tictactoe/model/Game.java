package com.tkbeasley.tictactoe.model;

public class Game {
    private Board board;
    private Player playerOne;
    private Player playerTwo;
    private Player currentTurn;

    public Game(Player playerOne, Player playerTwo) {
        this.board = new Board();
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentTurn = playerOne;
    }

    public Player getCurrentTurn() {
        return currentTurn;
    }

    public Board getBoard() {
        return board;
    }
}
