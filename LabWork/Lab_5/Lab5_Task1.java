package Lab_5;

public class Lab5_Task1 {
    static void main(String[] args) {
        Student st1 = new Student("Ali", 20);
        System.out.println(st1.Name);
    }
}




class Student{
    String Name;
    private int id;

    Student(String Name, int id){
        this.Name = Name;
        this.id = id;
    }

}
