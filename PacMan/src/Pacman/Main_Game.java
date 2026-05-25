package Pacman;

public class Main_Game {
    static void main(String[] args) {
        Pacman PLAYER = new Pacman();
        Ghost GHOST = new Ghost(PLAYER);

        while(PLAYER.getScore() < 116) {
            System.out.println("SCORE: " + PLAYER.getScore());
            GameMap.show_map();
            PLAYER.Movement();
            GHOST.Movement();


            // GAMEOVER?
            if(GHOST.Game_Over()){
                break;
            }
        }

        if(PLAYER.getScore() == 116) System.out.println(
                "YOU WON" +
                "\nSCORE: " + PLAYER.getScore());

        else System.out.println("YOU LOST");
    }
}
