package Lab_Work.LAB_4;

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

class main{

    static void main(String[] args) {
        Mashreq app = new Mashreq();
        app.pay(900);
    }

}
