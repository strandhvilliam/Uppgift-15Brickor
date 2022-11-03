import javax.swing.*;

public class Main {

    public Main() {
        GUI g = new GUI();
        int side = Integer.parseInt(JOptionPane.showInputDialog("Enter the side of the board:"));
        g.createGUI(side);
        g.setColor();
    }//test
    public static void main(String[] args) {
        Main m = new Main();
    }

}
