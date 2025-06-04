package com.tkbeasley.tictactoe.model;

public class Cell {
    private Symbol state;

    public Cell() {
        this.state = Symbol.Empty;
    }
    public Symbol getState() {
        return state;
    }

    public void setState(Symbol state) {
        this.state = state;
    }

    @Override
    public String toString() {
        if (state == Symbol.Empty) return "";
        else return state.toString();
    }
}
