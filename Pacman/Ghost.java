package Pacman;

import static Pacman.GameMap.map;

public class Ghost extends Entity{
    Pacman PLAYER;
    private static char Enemy = 'G';

    private char tileUnderneath = ' ';


    Ghost(Pacman PLAYER){
        this.PLAYER = PLAYER;
        super(Enemy);
        Coordinates();
    }

    void Underneath(){
        map[y][x] = tileUnderneath;
    }





    // MOVEMENT
    void Movement() {
//        System.out.println(x + " " + y);
//        UP(x, y-1);
//        System.out.println(x + " " + y);
        where();
    }
    // =============================================
    void UP(int x, int y){
        if(Check_Boundary(x, y)) {
            Underneath();
            tileUnderneath = map[y][x];
            move_up();
        }
    }

    void DOWN(int x, int y){
        if(Check_Boundary(x, y)) {
            Underneath();
            tileUnderneath = map[y][x];
            move_down();
        }
    }

    void RIGHT(int x, int y){
        if(Check_Boundary(x, y)) {
            Underneath();
            tileUnderneath = map[y][x];
            move_right();
        }
    }

    void LEFT(int x, int y){
        if(Check_Boundary(x, y)) {
            Underneath();
            tileUnderneath = map[y][x];
            move_left();
        }
    }
    // =============================================


    // =============================================
    // WHERE TO
    void where() {
        if (this.y != PLAYER.y) {
            if (this.y > PLAYER.y) UP(x, y-1);
            else DOWN(x, y+1);

            return;
        }

        if (this.x != PLAYER.x){
            if (this.x < PLAYER.x) RIGHT(x+1, y);
            else LEFT(x-1, y);
        }
    }
    // ==============================================



    // GAME OVER
    boolean Game_Over(){
        return (this.x == PLAYER.x && this.y == PLAYER.y);
    }

}
