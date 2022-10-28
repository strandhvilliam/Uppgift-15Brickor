import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MListener implements MouseListener, ActionListener {

    JButton jb = new JButton();

    public MListener(JButton jb) {
        this.jb = jb;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        jb.setForeground(Color.blue);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        jb.setForeground(Color.cyan);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        jb.setForeground(Color.yellow);
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        jb.setForeground(Color.black);
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
