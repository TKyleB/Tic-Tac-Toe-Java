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

    public Cell[] getBoardRow(int row) {
        return board[row];
    }
    public Cell[] getBoardColumn(int col) {
        Cell[] columns = new Cell[3];
        for (int row = 0; row < board.length; row++) {
             columns[row] = board[row][col];
        }
        return columns;
    }
    public Cell[] getBoardLeftDiagonal() {
        return new Cell[] {board[0][0], board[1][1], board[2][2]};
    }
    public Cell[] getBoardRightDiagonal() {
        return new Cell[] {board[0][2], board[1][1], board[2][0]};
    }

    public UpdateResult updateCell(int row, int col, Symbol newSymbol) {
        Cell cell;
        try {
            cell = getCell(row, col);
        } catch (ArrayIndexOutOfBoundsException e) {
            return UpdateResult.failure("Invalid position");
        }
        if (cell.getState() == Symbol.Empty) {
            cell.setState(newSymbol);
            return UpdateResult.success();
        }
        return UpdateResult.failure("Cell is not empty");
    }


}
