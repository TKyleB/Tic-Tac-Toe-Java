package com.tkyleb.tictactoe.view;

import com.tkyleb.tictactoe.model.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleView {
    private final Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }
    public Player[] getPlayerSymbols() {
        while (true) {
            System.out.println("First player, please select your symbol. X or O?");
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("x")) {
                return new Player[]{new Player(Symbol.X), new Player(Symbol.O)};
            } else if (input.equals("o")) {
                return new Player[]{new Player(Symbol.O), new Player(Symbol.X)};
            } else {
                System.out.println("Invalid Select. Please enter 'X' or 'O'.");
            }
        }
    }
    public void displayWelcomeMessage() {
        System.out.println("Tic-Tac-Toe!");
    }
    public void displayErrorMessage(UpdateResult result) {
        System.out.println(result.getErrorMessage());
    }
    public void displayGameResult(WinResult result) {
        if  (result.getWinner().symbol() == Symbol.Empty) {
            System.out.println("Its a draw!");
        } else {
            System.out.println("Game Over! " + result.getWinner().symbol() + " wins!");
        }
    }
    public void printGameBoard(Board board) {
        for (int row=0; row < board.getSize(); row++) {
            System.out.println("-----------");
            for (int col=0; col < board.getSize(); col++) {
                if (col == 2) System.out.print(" " + board.getCell(row, col) + " \n");
                else System.out.print(" " + board.getCell(row, col) + "  |");
            }
        }
        System.out.println("-----------\n");
    }
    public int getPlayerMove(Player currentPlayer) {
        while (true) {
            System.out.println("Player " + currentPlayer + ".   Enter a number (1-9) to make a move:");
            try {
                int input = scanner.nextInt();
                if (input >= 1 && input <= 9) return input;
                else {
                    System.out.println("Invalid input. Please enter a number between 1 and 9.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number (e.g., 1, 2, 3...)");
                scanner.next();
            }
        }
    }
}
