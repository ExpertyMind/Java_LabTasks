package Lab_3;

import java.util.Arrays;
import java.util.Scanner;

public class Lab3_Task1 {
    public static void main(String[] args) {
        Point p1 = new Point(1);
        Point p2 = new Point(2);
        Point p3;

        p1.translate(5,5,5);
        p3 = p1.add(p2);
        System.out.println(p3);

    }
}



class Point{
    private int x,y,z;

    int[] point = new int[3];

    static Scanner input = new Scanner(System.in);

    public Point(int n) {
        System.out.printf("Enter Values for Point p%d: \n", n);

        System.out.print("x = ");
        this.setX(input.nextInt());

        System.out.print("y = ");
        this.setY(input.nextInt());

        System.out.print("z = ");
        this.setZ(input.nextInt());
    }

    public Point() {

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        point[0] = this.x;
    }

    public int getY() {
        return y;

    }

    public void setY(int y) {
        this.y = y;
        point[1] = this.y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
        point[2] = this.z;
    }

    public void translate(int x, int y, int z){
        this.x += x;
        this.y += y;
        this.z += z;
        this.point[0] = this.x;
        this.point[1] = this.y;
        this.point[2] = this.z;
    }

    public Point add(Point p){

        Point result = new Point();

        result.setX(this.x + p.x);
        result.setY(this.y + p.y);
        result.setZ(this.z + p.z);

        return result;

    }

    @Override
    public String toString() {
        return Arrays.toString(point);
    }
}

