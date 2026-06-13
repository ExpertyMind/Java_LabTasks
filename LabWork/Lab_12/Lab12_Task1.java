package Lab_12;

class animal{

    void specie(){
        System.out.println("Janwaar");
    }

}

class Dog extends animal{
    void bark(){
        System.out.println("bhao bhao");
    }
}

public class Lab12_Task1 {
    static void main(String[] args) {
        Dog dog = new Dog();
        dog.specie();
        dog.bark();
    }
}