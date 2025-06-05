package com.tkyleb.tictactoe.model;

public record Player(Symbol symbol) {

    @Override
    public String toString() {
        return symbol.toString();
    }
}
