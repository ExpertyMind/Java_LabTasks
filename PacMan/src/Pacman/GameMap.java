package Pacman;

public class GameMap {

    // WALLS
    static char[] Walls = "┌┐└┘─│".toCharArray();


    // MAP
    static char[][] map =
            {
                    "┌───────────────────────────────────────────────────┐".toCharArray(),
                    "│ . . . . . . . . . . . . . . . . . . . . . . . . . │".toCharArray(),
                    "│ .   │                   C                   │   . │".toCharArray(),
                    "│ .   │   .   ┌───────         ───────┐   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .               .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .   ┌──   ──┐   .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .   │   .   │   .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .   │   G   │   .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .   └───────┘   .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   │   .               .   │   .   │   . │".toCharArray(),
                    "│ .   │   .   └───────         ───────┘   .   │   . │".toCharArray(),
                    "│ .   │   . . . . . . . . . . . . . . . . .   │   . │".toCharArray(),
                    "│ . . . . . . . . . . . . . . . . . . . . . . . . . │".toCharArray(),
                    "└───────────────────────────────────────────────────┘".toCharArray()
            };

    static int[] find(char ch){
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == ch) {
                    //System.out.println("i = " + y);
                    //System.out.println("j = " + x);
                    return new int[]{x, y};
                }
            }
        }
        return null;
    }

    static void find_dots(char ch){
        int i = 0;
        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                if (map[y][x] == ch) {
                    //System.out.println("i = " + y);
                    //System.out.println("j = " + x);
                    i++;
                }
            }
        }
        System.out.println(i);
    }

    static void show_map() {
        for (char[] row : map) {
            for (char tile : row) {
                System.out.print(tile);
            }
            System.out.println();
        }
    }

//    static void main(String[] args) {
//        GameMap.find_dots('.');
//    }
}

