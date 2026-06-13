package Lab_10;

abstract class Bank{
    abstract void pay(int money);
}

class Mashreq extends Bank{
    int payment;

    @Override
    void pay(int money){
        System.out.println("You are going to pay: " + money);
        this.payment = money;
    }

}

class Jazzcash extends Bank{
    int payment;

    @Override
    void pay(int money) {

    }
}

public class Lab10_Task2 {

    static void main(String[] args) {
        Mashreq app = new Mashreq();
        app.pay(900);
    }

}
