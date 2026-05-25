package Tools;

import java.io.IOException;
import java.util.Scanner;

public class Map {
    static char[][] map =
            {
                    "┌───────────────────────────────────────────────────┐".toCharArray(),
                    "│ . . . . . . . . . . . . . . . . . . . . . . . . . │".toCharArray(),
                    "│ .   │                   C                   │   . │".toCharArray(),
                    "│ .   │   .   ┌───────         ───────┐   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .               .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .   ┌──   ──┐   .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .   │       │   .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .   │   G   │   .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .   └───────┘   .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .               .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   └───────         ───────┘   .   │   . │".toCharArray(),
                    "│ .   │   . . . . . . . . . . . . . . . . .   │   . │".toCharArray(),
                    "│ . . . . . . . . . . . . . . . . . . . . . . . . . │".toCharArray(),
                    "└───────────────────────────────────────────────────┘".toCharArray()
            };


    static void main(String[] args) throws IOException {
//        System.out.println(
//                "┌───────────────────────────────────────────────────┐\n" +
//                "│ . . . . . . . . . . . . . . . . . . . . . . . . . │\n" +
//                "│ .   │                  C                    │   . │\n" +
//                "│ .   │   .   ┌───────         ───────┐   .   │   . │\n" +
//                "│ .   │   .   │   .               .   │   .   │   . │\n" +
//                "│ .   │   .   │   .   ┌──   ──┐   .   │   .   │   . │\n" +
//                "│ .   │   .   │   .   │       │   .   │   .   │   . │\n" +
//                "│ .   │   .   │   .   │   G   │   .   │   .   │   . │\n" +
//                "│ .   │   .   │   .   └───────┘   .   │   .   │   . │\n" +
//                "│ .   │   .   │   .               .   │   .   │   . │\n" +
//                "│ .   │   .   └───────         ───────┘   .   │   . │\n" +
//                "│ .   │   . . . . . . . . . . . . . . . . .   │   . │\n" +
//                "│ . . . . . . . . . . . . . . . . . . . . . . . . . │\n" +
//                "└───────────────────────────────────────────────────┘");

    player();
    }



    static void map(){

        for (char[] row : map) {
            for (char tile : row) {
                System.out.print(tile);
            }
            System.out.println();
        }

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                //System.out.print(map[i][j]);
//                if(map[i][j] == 'G'){
//                    System.out.println("i = " + i);
//                    System.out.println("j = " + j);
                }
                //System.out.println();
            }
            //System.out.println(map[2][26]);
            //System.out.println(map[7][26]);
        }

    static void player() throws IOException {
        int y = 2;
        int x = 26;
        char ch;
        Scanner sc = new Scanner(System.in);

        map();

        while (true) {
            System.out.print("press wasd: ");

            ch = sc.next().toLowerCase().charAt(0);

            if (ch == 'w') {
                map[y][x] = ' ';
                y--;
                map[y][x] = 'C';
            }

            if (ch == 'd') {
                map[y][x] = ' ';
                x++;
                map[y][x] = 'C';
            }

            if (ch == 's') {
                map[y][x] = ' ';
                y++;
                map[y][x] = 'C';
            }

            if (ch == 'a') {
                map[y][x] = ' ';
                x--;
                map[y][x] = 'C';
            }

            if (ch == 'c'){
                break;
            }

            map();
        }
    }

}


