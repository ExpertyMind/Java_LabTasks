package Lab_6;

public class Lab6_Task3 {
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