package Lab_4;

import java.util.Scanner;

public class Lab4_Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        JTime t1 = new JTime(2, 15, 30);
        JTime t2 = new JTime(42050);

        System.out.println("Time 1: " + t1);
        System.out.println("Time 2: " + t2);

        int secondsDiff = t1.elapsedSeconds(t2);
        System.out.println("Difference in Seconds: " + secondsDiff);

        System.out.println("Do You want the time elapsed in format of another time-stamp (Yes/No): ");
        String y_n = input.nextLine();

        if (y_n.equalsIgnoreCase("yes")) {
            System.out.println("Time Object: " + t1.Another_Format(t2));
        }

    }
}

class JTime {
    private int h, m, s;

    JTime() {
        this.h = 0;
        this.m = 0;
        this.s = 0;
    }

    JTime(int h, int m, int s) {
        this.h = h;
        this.m = m;
        this.s = s;
    }

    JTime(int total_seconds) {
        this.h = (total_seconds / 3600) % 24;
        this.m = (total_seconds % 3600) / 60;
        this.s = total_seconds % 60;
    }

    int ConvertTotalSeconds() {
        return (h * 3600) + (m * 60) + s;
    }

    int elapsedSeconds(JTime time_stamp_2) {
        int stamp1 = this.ConvertTotalSeconds();
        int stamp2 = time_stamp_2.ConvertTotalSeconds();
        return Math.abs(stamp1 - stamp2);
    }

    JTime Another_Format(JTime time_stamp_2) {
        int diff = this.elapsedSeconds(time_stamp_2);
        JTime t = new JTime(diff);
        return t;
    }

    @Override
    public String toString() {
        return h + ":" + m + ":" + s;
    }
}