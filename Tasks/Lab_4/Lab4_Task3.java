package Tasks.Lab_4;

import pkg1.A;

import java.util.Random;
import java.util.Scanner;

public class Lab4_Task3 {

    static Hurdle[] Hurdles = {
            new Hurdle(1, 2),
            new Hurdle(2, 2),
            new Hurdle(-1, 1),
            new Hurdle(0, 3),
            new Hurdle(-2, -1),
            new Hurdle(3, 0),
            new Hurdle(-1, -2),
            new Hurdle(1, -1)
    };

    static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random ran = new Random();
        String arrow_Ali;

        int random_Hassan;



        Human Ali = new Human();
        Human Hassan = new Human();

        System.out.println("Starting: Ali's Location is = (0 : 0) Hassan's Location is = (0 : 0)");
        System.out.println("Hasan has Random Movement, Ali follows order\n");

        while (true) {
            System.out.print("Ali: Where should i go now: ");
            arrow_Ali = input.nextLine();

            System.out.println("\n\n");
            switch (arrow_Ali) {
                case "^":
                    Ali.moveUp();
                    if (checkHurdle(Ali)) {
                        System.out.println("Ali encounters a hurdle at (" + Ali.getX() + ":" + Ali.getY() + ")");
                        Ali.moveDown();
                    }
                    break;
                case "v":
                    Ali.moveDown();
                    if (checkHurdle(Ali)) {
                        System.out.println("Ali encounters a hurdle at (" + Ali.getX() + ":" + Ali.getY() + ")");
                        Ali.moveUp();
                    }
                    break;
                case ">":
                    Ali.moveRight();
                    if (checkHurdle(Ali)) {
                        System.out.println("Ali encounters a hurdle at (" + Ali.getX() + ":" + Ali.getY() + ")");
                        Ali.moveLeft();
                    }
                    break;
                case "<":
                    Ali.moveLeft();
                    if (checkHurdle(Ali)) {
                        System.out.println("Ali encounters a hurdle at (" + Ali.getX() + ":" + Ali.getY() + ")");
                        Ali.moveRight();
                    }
                    break;
                default:
                    System.out.println("Invalid input. Use ^, v, <, or >.");
                    continue;
            }



            random_Hassan = ran.nextInt(4);

            switch (random_Hassan){
                case 0:
                    Hassan.moveUp();
                    if (checkHurdle(Hassan)) {
                        System.out.println("Hassan encounters a hurdle at (" + Hassan.getX() + ":" + Hassan.getY() + ")");
                        Hassan.moveDown();
                    }
                    break;
                case 1:
                    Hassan.moveDown();
                    if (checkHurdle(Hassan)) {
                        System.out.println("Hassan encounters a hurdle at (" + Hassan.getX() + ":" + Hassan.getY() + ")");
                        Hassan.moveUp();
                    }
                    break;
                case 2:
                    Hassan.moveRight();
                    if (checkHurdle(Hassan)) {
                        System.out.println("Hassan encounters a hurdle at (" + Hassan.getX() + ":" + Hassan.getY() + ")");
                        Hassan.moveLeft();
                    }
                    break;
                case 3:
                    Hassan.moveLeft();
                    if (checkHurdle(Hassan)) {
                        System.out.println("Hassan encounters a hurdle at (" + Hassan.getX() + ":" + Hassan.getY() + ")");
                        Hassan.moveRight();
                    }
                    break;
            }

            System.out.println("Ali is at (" + Ali.getX() + ":" + Ali.getY() + ")");
            System.out.println("\n\nHasan is at (" + Hassan.getX() + ":" + Hassan.getY() + ")\n\n");

        }


    }

    static boolean checkHurdle(Human human){
        for (Hurdle hurdle: Hurdles){
            if(hurdle.getX() == human.getX() && hurdle.getY() == human.getY()){
                return true;
            }
        }
        return false;
    }

}

class Hurdle{
    private int x, y;

    Hurdle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

}

class Human{
    private int x = 0, y = 0;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    void moveUp() {
        this.y++;
    }

    void moveDown() {
        this.y--;
    }

    void moveRight() {
        this.x++;
    }

    void moveLeft() {
        this.x--;
    }
}
