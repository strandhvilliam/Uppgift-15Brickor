import javax.swing.*;
import java.util.List;

public class Main {

    public Main() {
        GUI g = new GUI();
        List<JButton> buttonList = g.createGUI();
        g.mouseListener(buttonList);
        g.setColor();
    }

    public static void main(String[] args) {
        Main m = new Main();
    }

}
