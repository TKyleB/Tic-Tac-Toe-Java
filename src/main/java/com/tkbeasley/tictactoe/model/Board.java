package com.tkbeasley.tictactoe.model;

public class Board {
    private Cell[][] board;
    private final int size = 3;

    public Board() {
        this.board = new Cell[size][size];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = new Cell();
            }
        }
    }
    public Cell getCell(int row, int col) {
        return board[row][col];
    }

    public int getSize() {
        return size;
    }

    public MoveResult makeMove(int row, int col, Symbol newSymbol) {
        Cell cell;
        try {
            cell = getCell(row, col);
        } catch (ArrayIndexOutOfBoundsException e) {
            return MoveResult.failure("Invalid position");
        }
        if (cell.getState() == Symbol.Empty) {
            cell.setState(newSymbol);
            return MoveResult.success();
        }
        return MoveResult.failure("Cell is not empty");
    }


}
