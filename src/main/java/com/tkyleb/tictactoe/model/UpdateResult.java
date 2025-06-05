package com.tkyleb.tictactoe.model;

public class UpdateResult {
    private final boolean success;
    private final String errorMessage;

    private UpdateResult(boolean success, String message) {
        this.success = success;
        this.errorMessage = message;
    }

    public static UpdateResult success() {
        return new UpdateResult(true, null);
    }
    public static UpdateResult failure(String message) {
        return new UpdateResult(false, message);
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
