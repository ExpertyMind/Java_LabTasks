package Pacman;

import java.util.Scanner;

import static Pacman.GameMap.map;

public class Pacman extends Entity{
    char move;
    private static char Player = 'C';

    private static int Score = 0;
    Scanner sc = new Scanner(System.in);

    Pacman(){
        super(Player);
        Coordinates();
    }


    // MOVEMENT
    void Movement(){
        System.out.print("press (w/a/s/d) key: ");
        move = sc.next().toLowerCase().charAt(0);

        // if(move == 'w' || move == 's' || move == 'a' || move == 'd') map[y][x] = ' ';                // When key is pressed. Player has moved somewhere.

        if (move == 'w') {
            if (Collisions(x, y-1)){
                clear();
                move_up();
            }
        }

        if (move == 's') {
            if (Collisions(x, y+1)){
                clear();
                move_down();
            }
        }

        if (move == 'd') {
            if (Collisions(x+1, y)){
                clear();
                move_right();
            }
        }

        if (move == 'a') {
            if (Collisions(x-1, y)){
                clear();
                move_left();
            }
        }

    }

    // =============================================
//    private void move_up(){
//        y--;
//        map[this.y][this.x] = Player;
//    }
//
//    private void move_down(){
//        y++;
//        map[y][x] = Player;
//    }
//
//    private void move_right(){
//        x++;
//        map[y][x] = Player;
//    }
//
//    private void move_left(){
//        x--;
//        map[y][x] = Player;
//    }

    private void clear(){
        if(move == 'w' || move == 's' || move == 'a' || move == 'd') map[y][x] = ' ';                // When key is pressed. Player has moved somewhere.
    }
    // ================================================


    // ================================================
    //              COLLISIONS
    boolean Collisions(int x, int y){
        Food(x, y);
        return Check_Boundary(x, y);
    }

    void Food(int x, int y){
        if (map[y][x] == '.') Pacman.Eaten();
    }

    // =================================================

    public int getScore() {
        return Score;
    }

    public static void Eaten() {
        Score++;
    }
}
