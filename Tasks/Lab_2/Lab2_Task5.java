package Tasks.Lab_2;

public class Lab2_Task5 {

    public static void main(String[] args) {
        int userGuess, compGuess;

        userGuess = 5;
        compGuess = (int) ((Math.random() * 10) + 1);  // 1-10 Random Number Assigned

        System.out.print(userGuess == compGuess);
    }
}
