package Lab_9;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lab9_Task2 {

    static ArrayList<Integer> Marks = new ArrayList<>();
    public static List<String> Names = new ArrayList<>();
    public static List<String> Roll_No = new ArrayList<>();

    static void main(String[] args) throws IOException {
        Lab9_Task1.read();
        Get_Marks();
        Get_Name();
        Get_Roll();
        //System.out.println(Marks);
        Perc.Percentage(Marks);
        Perc.showPerc();
    }

    static void Average(){
        

    }

    static int Sum(){
        int Sum = 0;
        for (int marks : Marks){
            Sum = Sum + marks;
        }
        return Sum;
    }

    static void Get_Marks(){
        for(int i = 1; i < Lab9_Task1.Info.size(); i++){
            Marks.add(Integer.parseInt(Lab9_Task1.Info.get(i).split(",")[2]));
        }
    }

    static void Get_Name(){
        for(int i = 1; i < Lab9_Task1.Info.size(); i++){
            Names.add(Lab9_Task1.Info.get(i).split(",")[0]);
        }
    }

    static void Get_Roll(){
        for(int i = 1; i < Lab9_Task1.Info.size(); i++){
            Roll_No.add(Lab9_Task1.Info.get(i).split(",")[1]);
        }
    }
}
