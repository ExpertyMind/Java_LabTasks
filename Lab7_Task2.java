package Lab_Work;

import java.util.Scanner;

public class Lab7_Task2 {
    static void main(String[] args) {
        studentsss st = new studentsss("Ali", 134);
        //System.out.println(st);

//        st.set_Name("Hassan");
//        System.out.println(st.Display());
//        System.out.println(st.get_Name());
//        System.out.println(st.get_Roll_no());
    }
}


class studentsss{
    private String Name;
    private int Roll_no;

    static Scanner input = new Scanner(System.in);


    studentsss(String Name, int Roll_no){
        this.Name = Name;
        this.Roll_no = Roll_no;
        String choice;

        System.out.println(this.Student_Display());

        System.out.print("Do You want to Change your Name (Yes/ No): ");
        choice = input.next();

        if(choice.equalsIgnoreCase("yes")) set_Name();

        //System.out.println("Name: " + Name + " Roll_No: " + Roll_no);
    }

    int get_Roll_no(){
        return Roll_no;
    }

    String get_Name(){
        return Name;
    }

    String Display(){
        return Student_Display();
    }

    private String Student_Display(){
        return "Name: " + Name + ". Roll_No: " + Roll_no;
    }

    void set_Name(String Name){
        this.Name = Name;
    }

    void set_Name(){
        System.out.print("Name: ");
        input.nextLine();
        this.Name = input.nextLine();
    }



//    @Override
//    public String toString(){
//        return "Name: " + Name + ". Roll_No: " + Roll_no;
//    }

}