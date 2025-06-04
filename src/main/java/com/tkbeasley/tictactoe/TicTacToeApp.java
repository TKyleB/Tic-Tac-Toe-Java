package com.tkbeasley.tictactoe;

import com.tkbeasley.tictactoe.model.*;

import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {

        System.out.println("Tic-Tac-Toe");
        Game game = setup();
        printGameBoard(game.getBoard());
        playGame(game);

    }

    public static Game setup() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Player 1: X or O?");
            String input = scanner.nextLine().toLowerCase();
            if (input.equals("x")) {
                Player playerOne = new Player(Symbol.X);
                Player playerTwo = new Player(Symbol.O);
                return new Game(playerOne, playerTwo);
            } else if (input.equals("o")) {
                Player playerOne = new Player(Symbol.O);
                Player playerTwo = new Player(Symbol.X);
                return new Game(playerOne, playerTwo);
            } else {
                System.out.println("Invalid Selection. Try Again.");
            }
        }
    }
    public static void printGameBoard(Board board) {
        for (int row=0; row < board.getSize(); row++) {
            System.out.println("-----------");
            for (int col=0; col < board.getSize(); col++) {
                if (col == 2) System.out.print(" " + board.getCell(row, col) + " \n");
                else System.out.print(" " + board.getCell(row, col) + "  |");
            }
        }
        System.out.println("-----------\n");
    }
    public static void playGame(Game game) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            UpdateResult updateResult;
            System.out.println("Player " + game.getCurrentTurn() + ". Make a move.");
            int input = scanner.nextInt();

            switch (input) {
                case 7:
                    updateResult = game.makeMove(0, 0);
                    break;
                case 8:
                    updateResult = game.makeMove(0, 1);
                    break;
                case 9:
                    updateResult = game.makeMove(0, 2);
                    break;
                case 4:
                    updateResult = game.makeMove(1, 0);
                    break;
                case 5:
                    updateResult = game.makeMove(1, 1);
                    break;
                case 6:
                    updateResult = game.makeMove(1, 2);
                    break;
                case 1:
                    updateResult = game.makeMove(2, 0);
                    break;
                case 2:
                    updateResult = game.makeMove(2, 1);
                    break;
                case 3:
                    updateResult = game.makeMove(2, 2);
                    break;
                default:
                    updateResult = UpdateResult.failure("Invalid Move");
            }

            if (!updateResult.isSuccess()) {
                System.out.println(updateResult.getErrorMessage());
            }
            printGameBoard(game.getBoard());
            WinResult result = game.checkWin();
            if (result.isWinner()) {
                if  (result.getWinner().getSymbol() == Symbol.Empty) {
                System.out.println("Its a draw!");
                break;
                }
                else {
                    System.out.println("Game Over! " + result.getWinner().getSymbol() + " wins!");
                }
            }
        }
    }

}

