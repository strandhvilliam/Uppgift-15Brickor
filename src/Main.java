import javax.swing.*;

public class Main {

    public Main() {
        GUI g = new GUI();
        JButton[][] buttonList = g.createGUI();
        g.setColor();
    }

    public static void main(String[] args) {
        Main m = new Main();
    }

}
