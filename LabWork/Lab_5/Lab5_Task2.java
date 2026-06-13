package Lab_5;

public class Lab5_Task2 {
    static void main(String[] args) {
        app software = new app();
        software.PowerOn();
        software.Open_Settings();
        software.Shutdown();
    }
}

class app{

    void PowerOn(){
        System.out.println("Power On");
    }

    private void Setting(){
        System.out.println("Opened Settings");
    }

    void Shutdown(){
        System.out.println("Shutdown");
    }

    void Open_Settings(){
        Setting();
    }

}