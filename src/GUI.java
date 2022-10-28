import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GUI extends JFrame implements ActionListener {

    JPanel panel = new JPanel();

    List<JButton> buttonList = new ArrayList<>();
    public void createGUI(){
        this.add(panel);
       this.setTitle("BRICK GAME");
        for (int i = 0; i < 16 ; i++) {
            JButton b = new JButton();
            buttonList.add(b);
            panel.add(b);

        }


        panel.setLayout(new GridLayout(4,4));
        this.setSize(1000,1000);
        // panel.setSize(1000,1000);                        panel.setsize verkar inte funka det går när jag skriver this. insteed men kanske inte bestpractice??
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void actionListner(){


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
