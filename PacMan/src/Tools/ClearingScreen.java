package Tools;

public class ClearingScreen {
    public static void ClearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Tells Windows to execute 'cls'
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // Tells Mac/Linux to execute 'clear'
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("Error clearing screen.");
        }
    }
}
