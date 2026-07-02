package Lab_3;

import java.util.Scanner;

public class Lab3_Task2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Time t = new Time();

        System.out.print("Enter Seconds: ");
        System.out.println(t.whatTime(input.nextInt()));

    }
}

class Time{
    private int total_seconds, s, m, h, day;
    static Scanner input = new Scanner(System.in);


    public int getTotal_seconds() {
        return total_seconds;
    }

    public void setTotal_seconds(int total_seconds) {
        this.total_seconds = total_seconds;
    }

    public int getS() {
        return s;
    }

    public void setS(int s) {
        this.s = s;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String whatTime(int total_seconds) {
        this.total_seconds = total_seconds;
        convertor();

        System.out.print("1) 24-Hour Format\n" +
                "2) 12-Hour Format (Type Number)\n" +
                ">> ");
        int Format = input.nextInt();
        System.out.println("_______________TIME_______________");
        switch (Format){
            case 1:
                return String.format("Day: %d\n%02d:%02d:%02d", day, h, m, s);
            case 2:
                if (h > 12 && h < 24){
                    return String.format("Day: %d\n%02d:%02d:%02d pm", day, Math.abs(h-12), m, s);
                }
                else if (h == 12) {
                    return String.format("Day: %d\n%02d:%02d:%02d pm", day, Math.abs(h), m, s);
                } else if (h == 0) {
                    return String.format("Day: %d\n%02d:%02d:%02d am", day, 12, m, s);
                } else {
                    return String.format("Day: %d\n%02d:%02d:%02d am", day, Math.abs(h), m, s);
                }
            default:
                    System.out.println("Enter Correct Format Option (24-Hour Format Below");
                    return String.format("Day: %d\n%02d:%02d:%02d", day, h, m, s);
        }
    }

    private void convertor() {
        int total_hours = total_seconds / 3600;

        this.day = total_hours / 24;
        this.h   = total_hours % 24;
        this.m   = (total_seconds % 3600) / 60;
        this.s   =  total_seconds % 60;

    }

}
