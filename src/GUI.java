import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame implements ActionListener {

    protected JPanel panel = new JPanel();

    protected JButton button = new JButton("New game!");

    protected JPanel border = new JPanel();

    BoardHandler boardHandler = new BoardHandler();

    private Tile[][] board;

    //List<JButton> buttonList = new ArrayList<>();

    public JButton[][] buttonArray = new JButton[4][4];

    //public JButton[][] createGUI() {
    public void createGUI() {
        this.setTitle("BRICK GAME");

        board = boardHandler.createNewBoard(); //board med slumpade nummer

        panel.setLayout(new GridLayout(4, 4));

        updateBoard();

        border.setLayout(new BorderLayout());
        border.add(panel, BorderLayout.CENTER);
        border.add(button, BorderLayout.SOUTH);

        this.add(border);
        button.setSize(120, 30);
        button.setLocation(0,0);
        this.setSize(1000, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //return buttonArray;
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
            }
        }
        setColor();

        java.util.List<Integer[]> list = boardHandler.getPossibleMoves(board);
        for (Integer[] number : list) {
            buttonArray[number[0]][number[1]].setEnabled(true);
        }
        int[] zeroPos = boardHandler.getPosOfNum(board,0);
        buttonArray[zeroPos[0]][zeroPos[1]].setVisible(false);
    }

        GUI(){
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.removeAll();
                button.setBackground(Color.GRAY);
                if(e.getSource() == button){
                    button.setText("New game created");
                    createGUI();
                }
            }
        });
        }



    public void setColor() {
        for (int i = 0; i < buttonArray.length; i++) {
            for (int j = 0; j < buttonArray[i].length; j++) {
                if(!buttonArray[i][j].getText().equals("0")) {
                    buttonArray[i][j].setBackground(Color.PINK);
                }
            }


        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
