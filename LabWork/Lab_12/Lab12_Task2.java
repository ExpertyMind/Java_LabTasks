package Lab_12;

class Owner{
    String name;
    int age;
    Dogg dogg = new Dogg();

    public Owner(String name , int age){
        this.name = name;
        this.age = age;
    }

}


class Dogg{
    void bark(){
        System.out.println("BHAO BHAO");
    }

    void show(){
        Owner master = new Owner("Jogindhar" , 19);
        System.out.println(master.name);
        System.out.println(master.age);
    }
}

public class Lab12_Task2 {
    static void main(String[] args) {
        Dogg dog = new Dogg();
        Owner masterr = new Owner("Mukesh", 23);
        dog.bark();
        dog.show();
        masterr.dogg.bark();
        //masterr.dogg.bark();
    }
}
