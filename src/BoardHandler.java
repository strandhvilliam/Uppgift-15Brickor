import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BoardHandler { //innehåller metoder för board


    private Random randomGenerator = new Random();

    public BoardHandler() {

    }


    /**
     * Skapar en ny 2d array med slumpmässiga nummer
     * @return 2dArray spelplan med nummer 0 - 15
     */
    public Tile[][] createNewBoard() {
        Tile[][] board = new Tile[4][4];
        List<Integer> numbers = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        Collections.shuffle(numbers); //slumpar ordningen i listan
        int counter = 0; //för position i numbers listan
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Tile(numbers.get(counter));
                counter++;
            }
        }
        return board;
    }


    /**
     * Metoden hämtar nuvarande position för Tile med värdet 0
     * @param board array met brickor med värden
     * @return array med rad och kolumn position för nolla
     */
    public int[] getCurrentPosition(Tile[][] board) {
        int row = 0, col = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getNum() == 0) {
                    row = i;
                    col = j;
                }
            }
        }
        return new int[]{row, col};
    }

    /**
     * Metoden byter nummer på två stycken brickor
     * @param emptyTile den tommar rutan
     * @param targetTile rutan som man vill byta med
     */
    public void moveTile(Tile emptyTile, Tile targetTile) {
        emptyTile.switchNum(targetTile);
    }


    /**
     * Endast för tillfällig testning för utskrift i terminalen
     * @param board
     */
    private void printBoard(Tile[][] board) {
        for (Tile[] tiles : board) {
            for (Tile tile : tiles) {
                System.out.printf("%4d", tile.getNum());
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        BoardHandler boardHandler = new BoardHandler();
        Tile[][] board = boardHandler.createNewBoard();
        boardHandler.printBoard(board);
        System.out.println(Arrays.toString(boardHandler.getCurrentPosition(board)));
    }




}
