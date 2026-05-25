package Pacman;

import static Pacman.GameMap.Walls;
import static Pacman.GameMap.map;

public class Entity {
    int x;
    int y;
    char Character;

    public Entity(char ch){
        this.Character = ch;
    }


    boolean Check_Boundary(int x, int y){
        for (char wall: Walls){
            if(map[y][x] == wall){
                return false;   // COLLISION
            }
        }
        return true;            // NO COLLISION
    }

    void Coordinates(){
        int[] Cords = GameMap.find(Character);
        this.x = Cords[0];
        this.y = Cords[1];
    }

    void move_up(){
        this.y--;
        map[this.y][this.x] = Character;
    }

    void move_down(){
        this.y++;
        map[this.y][this.x] = Character;
    }

    void move_right(){
        this.x++;
        map[this.y][this.x] = Character;
    }

    void move_left(){
        this.x--;
        map[this.y][this.x] = Character;
    }


}
