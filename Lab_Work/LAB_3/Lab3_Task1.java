package Lab_Work.LAB_3;

import java.io.*;
import java.nio.file.*;
import java.util.List;
import java.util.SortedMap;


public class Lab3_Task1 {

    static String path = "Getter.txt";
    static File file = new File("Getter.txt");


    static void main(String[] args) throws IOException {
        //create();
        write(path, "Hello World..\n");
        Reader(path);
    }

    static void Reader(String path) throws IOException {
        List<String> Data = Files.readAllLines(Paths.get(path));
        for(String Line : Data ){
            System.out.println(Line);
        }
    }

//    static void Read() throws IOException {
//    }

    static void create() throws IOException{
        if(!file.exists()) {
            file.createNewFile();
        }
        else {
            System.out.println("File Exists");
        }
    }

    static void write(String FileName, String message) throws IOException{
        FileWriter fw = new FileWriter(FileName, true);
        fw.write(message);
        fw.close();
    }

}
