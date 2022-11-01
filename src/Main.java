import testing.Testing;
import view.GUI;


public class Main {
    public static void main(String[] args) {
        Testing test = new Testing();
        test.testIntegerType();
        test.testTimeType();

        GUI gui = new GUI();
        gui.showMenu();

    }
}