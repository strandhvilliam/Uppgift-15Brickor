import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MListener implements MouseListener, ActionListener {

    private JButton jb;
    private Tile[][] board;
    private GUI gui;

    private BoardHandler boardHandler;

    public MListener(GUI gui, Tile[][] board, JButton jb) {
        this.gui = gui;
        this.board = board;
        this.jb = jb;
        boardHandler = new BoardHandler(board.length);
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
        JButton clickedButton = (JButton) e.getSource();
        int num = Integer.parseInt(clickedButton.getText());
        int[] targetPos = boardHandler.getPosOfNum(board, num);
        int[] emptyPos = boardHandler.getPosOfNum(board, 0);
        boardHandler.moveTile(board[emptyPos[0]][emptyPos[1]], board[targetPos[0]][targetPos[1]]);
        int[] zeroPos = boardHandler.getPosOfNum(board,0);
        gui.buttonArray[zeroPos[0]][zeroPos[1]].setVisible(false);
        gui.updateBoard();

    }
}
