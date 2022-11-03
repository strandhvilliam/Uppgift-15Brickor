import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {

    protected JPanel panel = new JPanel();

    protected JButton button = new JButton("New game!");

    protected JPanel border = new JPanel();

    protected JPanel buttonPanel = new JPanel();
    private BoardHandler boardHandler;

    private int sideLength;

    private Tile[][] board;


    public JButton[][] buttonArray;

    public void createGUI(int side) {
        this.setTitle("BRICK GAME");
        this.sideLength = side;
        boardHandler = new BoardHandler(sideLength);
        buttonArray = new JButton[sideLength][sideLength];
        board = boardHandler.createNewBoard(); //board med slumpade nummer

        panel.setLayout(new GridLayout(sideLength, sideLength));

        updateBoard();
        border.setLayout(new BorderLayout());
        border.add(buttonPanel, BorderLayout.SOUTH);
        border.add(panel, BorderLayout.CENTER);
        buttonPanel.add(button);
        button.setSize(120, 30);
        button.setLocation(0, 0);
        this.add(border);


        this.setSize(1000, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public void updateBoard() {
        panel.removeAll();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int num = board[i][j].getNum();
                JButton b = new JButton(String.valueOf(num));
                b.addActionListener(new MListener(this, board, b));
                b.setEnabled(false);
                buttonArray[i][j] = b;
                panel.add(buttonArray[i][j]);
                b.setFont(new Font("Times New Roman", Font.PLAIN, 20));
            }
        }
        setColor();

        java.util.List<Integer[]> list = boardHandler.getPossibleMoves(board);
        for (Integer[] number : list) {
            buttonArray[number[0]][number[1]].setEnabled(true);
        }
        int[] zeroPos = boardHandler.getPosOfNum(board, 0);
        buttonArray[zeroPos[0]][zeroPos[1]].setVisible(false); //gömmer 0 knappen

        if (boardHandler.compareToWinningBoard(board)) {
            JOptionPane.showMessageDialog(null, "You won!");
        }
    }

    GUI() {
        button.addActionListener(e -> {
            panel.removeAll();
            button.setBackground(Color.GRAY);
            if (e.getSource() == button) {
                createGUI(sideLength);
                panel.repaint();
            }
        });
    }


    public void setColor() {
        for (int i = 0; i < buttonArray.length; i++) {
            for (int j = 0; j < buttonArray[i].length; j++) {
                if (!buttonArray[i][j].getText().equals("0")) {
                    buttonArray[i][j].setBackground(Color.PINK);
                    button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
                    button.setBackground(Color.GREEN);
                }
            }
        }
    }

}
