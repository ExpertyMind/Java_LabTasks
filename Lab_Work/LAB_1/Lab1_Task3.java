package Lab_Work.LAB_1;

public class Lab1_Task3 {
    public static void main(String[] args) {
        Goat myGoat = new Goat();
        myGoat.eat();
        myGoat.bleat();
        myGoat.graze();
    }
}

class Animal {
    public void eat() {
        System.out.println("Animal is Eating");
    }
}

class Goat extends Animal {
    public void bleat() {
        System.out.println("Meh Meh");
    }

    public void graze() {
        System.out.println("Bakri Kah Rahi hai");
    }
}