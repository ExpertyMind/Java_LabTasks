package Lab_Work;

import java.io.*;

import java.nio.file.Files;
import java.nio.file.Path;


public class Lab7_Task3 {

    static void main(String[] args) throws IOException  {
        File file = new File("Data.txt");

        // Files files = new Files();


//      create(file);
        file = rename(file, "Data.csv");
//        System.out.println(file.getName());
//        write(file, "Name: Ali\nRollNo: 163");
        read(file);


    }

    static void create(File file) throws IOException{
        if(!file.exists()) {
            file.createNewFile();
            System.out.println(file.exists());
        }
        else {
            System.out.println("File Exists");
        }
    }

    static File rename(File file, String Name){
        file = null;
        file = new File("C:\\Users\\Lenovo\\Documents\\Programming\\Java_Lab\\" + Name);
        return file;
    }

    static void write(File file, String Message) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        writer.println(Message);
        writer.close();
    }

    static void read(File file) throws IOException {
        System.out.println(Files.readString(Path.of(file.getPath())));
    }

}



