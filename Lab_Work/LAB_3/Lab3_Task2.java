package Lab_Work.LAB_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab3_Task2 {
    static File file = new File("C:\\Users\\Lenovo\\Documents\\Book1.csv");
    public static ArrayList<String> Info = new ArrayList<>();

    static void main(String[] args) throws IOException {
        read();
        for (String data : Info){
            System.out.println(data);
        }
    }

    static void read() throws IOException {
        Scanner fs = new Scanner(file);
        while (fs.hasNextLine()){
            Info.add(fs.nextLine());
        }
    }
}

