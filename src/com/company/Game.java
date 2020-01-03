package com.company;

public class Game {
    private Board board;
    public int sz = 3;
    public boolean over = false;
    private char player;

    public Game() {
        board = new Board(sz);
        player = 'x';
        System.out.println("Turns " + player);
    }

    public boolean turn(int x, int y) {
        if (!board.turn(player, x, y)) {
            return false;
        }
        if (board.winner(player, x, y)) {
            endGame(player);
            over = true;
            return true;
        }
        player = player == 'x' ? 'o' : 'x';
        System.out.println();
        System.out.println("Now turns " + player);
        return true;
    }



    private void endGame(char player) {
        System.out.println("Game is over. Congratulation to " + (player == 'x' ? "crosses" : "noughts"));
    }
}
