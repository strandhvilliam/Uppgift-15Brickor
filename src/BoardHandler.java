import java.util.*;

public class BoardHandler { //innehåller metoder för board


    private Random randomGenerator = new Random();

    public BoardHandler() {

    }


    /**
     * Skapar en ny 2d array med slumpmässiga nummer
     * Nuvarande hårdkodad storlek
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
     * Returnerar inget utan byter värdet på brickorna.
     * Tekniskt sett flyttas då aldrig brickorna utan de ändrar
     * bara värde
     * @param emptyTile den tommar rutan
     * @param targetTile rutan som man vill byta med
     * @throws ArrayIndexOutOfBoundsException om man försöker flytta utanför
     */
    public void moveTile(Tile emptyTile, Tile targetTile) {
        try {
            emptyTile.setNum(targetTile.getNum());
            targetTile.setNum(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("not possible move");
        }
    }


    /**
     * Metoden returnerar en lista med positioner i 2dArrayen som går att flytta till
     * Returnerar alltid minst 2 positioner i form av {RAD, KOLUMN} i en int[] array
     * @param board spelplanen som ska letas efter möjliga flyttningar
     * @return lista med Integer[] arrayobjekt med möjliga positioner att flytta
     */
    public List<Integer[]> getPossibleMoves(Tile[][] board) {
        List<Integer[]> possibleMoves = new ArrayList<>();
        int[] emptyTilePosition = getCurrentPosition(board);
        int row = emptyTilePosition[0];
        int col = emptyTilePosition[1];
        if (row > 0) {
            possibleMoves.add(new Integer[]{row - 1, col}); //kollar om man kan flytta uppåt
        }
        if (row < board.length - 1) {
            possibleMoves.add(new Integer[]{row + 1, col}); //kollar om man kan flytta neråt
        }
        if (col > 0) {
            possibleMoves.add(new Integer[]{row, col - 1}); //kollar om man kan flytta vänster
        }
        if (col < board[0].length - 1) {
            possibleMoves.add(new Integer[]{row, col + 1}); //kollar om man kan flytta höger
        }
        return possibleMoves;
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

        List<Integer[]> list = boardHandler.getPossibleMoves(board);

        for (Integer[] pos : list) {
            System.out.print(pos[0] + " " + pos[1]);
            System.out.println();
        }
    }




}
