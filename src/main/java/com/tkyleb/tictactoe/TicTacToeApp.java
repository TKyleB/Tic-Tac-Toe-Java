package com.tkyleb.tictactoe;

import com.tkyleb.tictactoe.model.Game;
import com.tkyleb.tictactoe.model.Player;
import com.tkyleb.tictactoe.model.UpdateResult;
import com.tkyleb.tictactoe.model.WinResult;
import com.tkyleb.tictactoe.view.ConsoleView;

public class TicTacToeApp {
    public static void main(String[] args) {

        ConsoleView view = new ConsoleView();
        Game game;

        view.displayWelcomeMessage();
        Player[] players = view.getPlayerSymbols();
        game = new Game(players[0], players[1]);

        view.printGameBoard(game.getBoard());

        while (true) {
            int moveInput = view.getPlayerMove(game.getCurrentTurn());
            UpdateResult updateResult;

            updateResult = switch (moveInput) {
                case 7 -> game.makeMove(0, 0);
                case 8 -> game.makeMove(0, 1);
                case 9 -> game.makeMove(0, 2);
                case 4 -> game.makeMove(1, 0);
                case 5 -> game.makeMove(1, 1);
                case 6 -> game.makeMove(1, 2);
                case 1 -> game.makeMove(2, 0);
                case 2 -> game.makeMove(2, 1);
                case 3 -> game.makeMove(2, 2);
                default -> UpdateResult.failure("Invalid Move");
            };
            if (!updateResult.isSuccess()) {
                view.displayErrorMessage(updateResult);
            }

            view.printGameBoard(game.getBoard());
            WinResult result = game.checkWin();
            if (result.isWinner()) {
                view.displayGameResult(result);
                break;
            }

        }


    }
}

