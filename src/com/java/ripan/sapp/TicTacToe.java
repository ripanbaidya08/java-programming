package com.java.ripan.sapp;

import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private char currentPlayer;

    private String player1;
    private String player2;

    private boolean gameOver;
    private boolean draw;

    public TicTacToe(String player1, String player2) {
        this.board = new char[3][3];
        this.currentPlayer = 'X';
        this.player1 = player1;
        this.player2 = player2;
        this.gameOver = false;
        this.draw = false;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = Character.forDigit(i * 3 + j + 1, 10);
            }
        }
    }

    public void printBoard() {
        System.out.println("---------------****---------------");
        System.out.println(" ______________");
        for (int i = 0; i < 3; i++) {
            System.out.println("|    |    |    |");
            System.out.println("|  " + board[i][0] + " | " + board[i][1] + "  | " + board[i][2] + "  |");
            System.out.println("|____|____|____|");
        }
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }

    public void makeMove(int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        if (board[row][col] == 'X' || board[row][col] == 'O') {
            System.out.println("Space is Already Full!");
        } else {
            board[row][col] = currentPlayer;
            switchPlayer();
        }
    }

    public boolean checkWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == currentPlayer && board[i][1] == currentPlayer && board[i][2] == currentPlayer) {
                return true; // horizontal win
            }
            if (board[0][i] == currentPlayer && board[1][i] == currentPlayer && board[2][i] == currentPlayer) {
                return true; // vertical win
            }
        }
        if (board[0][0] == currentPlayer && board[1][1] == currentPlayer && board[2][2] == currentPlayer) {
            return true; // diagonal win
        }
        if (board[0][2] == currentPlayer && board[1][1] == currentPlayer && board[2][0] == currentPlayer) {
            return true; // diagonal win
        }
        return false;
    }

    public boolean isDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] != 'X' && board[i][j] != 'O') {
                    return false; // game is still going on
                }
            }
        }
        draw = true;
        return true; // game is a draw
    }

    public void playGame() {
        System.out.println("_________________WELCOME!! ___________________");
        System.out.println("_______________TIC___TAC___TOE________________");
        System.out.println();
        System.out.print("Player 1, please Enter your Name: ");
        Scanner scanner = new Scanner(System.in);
        player1 = scanner.nextLine();
        System.out.print("Player 2, Please Enter your Name: ");
        player2 = scanner.nextLine();
        System.out.println();

        while (!gameOver) {
            printBoard();
            System.out.println(currentPlayer == 'X' ? player1 + ", please Enter your choice: " : player2 + ", please Enter your choice: ");
            int choice = scanner.nextInt();
            makeMove(choice);
            if (checkWin()) {
                printBoard();
                System.out.println("Congratulations " + (currentPlayer == 'X' ? player2 : player1) + ", you are the winner!");
                gameOver = true;
            } else if (isDraw()) {
                printBoard();
                System.out.println("It's a Draw!");
                gameOver = true;
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe("", "");
        game.playGame();
    }
}

