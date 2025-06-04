package com.tkbeasley.tictactoe;

import com.tkbeasley.tictactoe.model.Board;
import com.tkbeasley.tictactoe.model.Game;
import com.tkbeasley.tictactoe.model.Player;
import com.tkbeasley.tictactoe.model.Symbol;

import java.util.Scanner;

public class TicTacToeApp {
    public static void main(String[] args) {

        System.out.println("Tic-Tac-Toe");
        Game game = Setup();
        PrintGameBoard(game.getBoard());
        // System.out.println("Player " + game.getCurrentTurn()  + ". Make a move.");

    }

    public static Game Setup() {
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
    public static void PrintGameBoard(Board board) {
        for (int row=0; row < board.getSize(); row++) {
            System.out.println("-----------");
            for (int col=0; col < board.getSize(); col++) {
                if (col == 2) System.out.print(" " + board.getCell(row, col) + " \n");
                else System.out.print(" " + board.getCell(row, col) + "  |");
            }
        }
    }
}

