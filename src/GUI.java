import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame {

    protected JPanel panel = new JPanel();
    protected JButton button = new JButton();

    List<JButton> buttonList = new ArrayList<>();

    public List<JButton> createGUI() {
        this.add(panel);
        this.setTitle("BRICK GAME");
        int num = 0;
        for (int i = 0; i < 16; i++) {
            JButton b = new JButton(String.valueOf(num));
            buttonList.add(b);
            panel.add(b);

            num++;
        }

        panel.setLayout(new GridLayout(4, 4));
        this.setSize(1000, 1000);
        // panel.setSize(1000,1000);                        panel.setsize verkar inte funka det går när jag skriver this. insteed men kanske inte bestpractice??
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        return buttonList;
    }

    public void mouseListener(List<JButton> list) {
        for (JButton b: list) {

        }

    }

    public void setColor() {
        for (JButton button : buttonList) {
            button.setBackground(Color.PINK);
        }
        button = buttonList.get(0);
        button.setBackground(Color.WHITE);
    }

}
