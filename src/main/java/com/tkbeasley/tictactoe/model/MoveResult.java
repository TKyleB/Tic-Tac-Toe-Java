package com.tkbeasley.tictactoe.model;

public class MoveResult {
    private final boolean success;
    private final String errorMessage;

    private MoveResult(boolean success, String message) {
        this.success = true;
        this.errorMessage = message;
    }

    public static MoveResult success() {
        return new MoveResult(true, null);
    }
    public static MoveResult failure(String message) {
        return new MoveResult(false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
