package com.tkyleb.tictactoe.model;

public class WinResult {
    private boolean isWinner;
    private Player winner;

    private WinResult(boolean isWinner, Player winner) {
        this.isWinner = isWinner;
        this.winner = winner;
    }

    public static WinResult yes(Player winner) {
        return new WinResult(true, winner);
    }
    public static WinResult no() {
        return new WinResult(false, null);
    }

    public boolean isWinner() {
        return isWinner;
    }

    public Player getWinner() {
        return winner;
    }
}
