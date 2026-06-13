package Lab_10;


abstract class Animal{
    abstract void AnimalInfo();
}


class Lion extends Animal{
    String AnimalName;
    String type;

    Lion(String AnimalName, String type) {
        this.AnimalName = AnimalName;
        this.type = type;
    }

    @Override
    void AnimalInfo(){
        System.out.println("Name: " + AnimalName);
        System.out.println("Animal Type: " + type);
    }
}

class Stu{
    static void main(String[] args) {

        Lion animal = new Lion("Lion", "Wild");
        animal.AnimalInfo();

    }
}
