package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        Game game = new Game();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (!game.over) {
            String[] line = reader.readLine().split(" ");
            if (line.length !=  2) {
                System.out.println("unexpected input");
                continue;
            }
            int x = Integer.parseInt(line[0]);
            int y = Integer.parseInt(line[1]);
            if (x >= game.sz || y >= game.sz) {
                System.out.println("Coordinates are out of board");
                continue;
            }
            if(!game.turn(x,y)) {
                System.out.println("Turn failed, try different coordinates");
            }

        }
    }
}
