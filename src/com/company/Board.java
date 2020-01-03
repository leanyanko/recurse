package com.company;

public class Board {
    private char[][] grid;
    private int sz ;

    public Board(int sz) {
        this.sz = sz;
        this.grid = new char[sz][sz];
        for (int x = 0; x < sz; x++) {
            for (int y = 0; y < sz; y++) {
                grid[x][y] = '_';
            }
        }
    }

    public boolean turn(char player, int x, int y) {
        if (grid[x][y] == '_') {
            grid[x][y] = player;
            printGrid();
            return true;
        }
        return false;
    }

    public boolean winner(char player, int x, int y) {
        //check diag
        if (x == y) {
            for (x = 0; x < sz; x++) {
                if (grid[x][x] != player) break;
            }
            if (x == sz) return true;
        }

        for (x = 0; x < sz; x++) {
            if (grid[x][sz - 1 - x] != player) break;
        }
        if (x == sz) return true;

        //check rows and columns
        for (x = 0; x < sz; x++) {
            y = 0;
            for (y = 0; y < sz; y++) {
                if (grid[x][y] != player) break;
            }
            if (y == sz) return true;

            int z;
            for (z = 0; z < sz; z++) {
                if (grid[z][x] != player) break;
            }
            if (z == sz) return true;
        }
        return false;
    }

    private void printGrid() {
        for (int x = 0; x < sz; x++) {
            for (int y = 0; y < sz; y++) {
                System.out.print(grid[x][y] + " ");
            }
            System.out.println();
        }
    }
}
