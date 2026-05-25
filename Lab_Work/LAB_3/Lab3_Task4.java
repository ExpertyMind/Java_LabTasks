package Lab_Work.LAB_3;

import java.util.ArrayList;

class Perc{

    static ArrayList<Double> Percentages = new ArrayList<>();

    public static void Percentage(ArrayList<Integer> Marks){
        for(int marks : Marks){
            Percentages.add(marks/30.0 * 100);
        }
    }

    public static void showPerc(){
        for (int i = 0; i < Lab3_Task2.Info.size() - 1; i++) {

            System.out.print("Name: " + Lab3_Task3.Names.get(i) + ", " + "Roll: " + Lab3_Task3.Roll_No.get(i) + ", " + "Percentage: " + String.format("%.2f", Percentages.get(i)) + "%, " + "Grade: " + Grade(Percentages.get(i)));
            System.out.println();
        }
    }

    static String Grade(double num){

        if(!(num > 100)){
            if (num >= 90){
                return "A";
            } else if (num >= 80) {
               return "B";
            }
            else if (num >= 70) {
                return "C";
            } else if (num >= 60) {
                return "E";
            }else {
                return "F";
            }

        }else {
            throw new RuntimeException("Percentage Higher than 100.");
        }


    }

}


