import java.util.*;

public class BoardHandler { //innehåller metoder för board


    private final Random randomGenerator = new Random();

    public BoardHandler() {}


    /**
     * Skapar en ny 2d array med slumpmässiga nummer
     * Nuvarande hårdkodad storlek
     * @return 2dArray spelplan med nummer 0 - 15
     */
    public Tile[][] createNewBoard() {
        List<Integer> numbers = Arrays.asList(15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0);
        Tile[][] board = new Tile[4][4];
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
        int[] emptyTilePosition = getPosOfNum(board, 0);
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
     * Metoden kollar om nuvarande spelplan är färdig
     * Jämför med en hårdkodad färdiga nummer
     * Går att göra feature för att göra dynamisk
     * @param board nuvarande spelplan
     * @return true om spelplanen är färdig, annars false
     */
    public boolean compareToWinningBoard(Tile[][] board) {
        int[][] winningNumbers = {{15, 14, 13, 12}, {11, 10, 9, 8}, {7, 6, 5, 4}, {3, 2, 1, 0}};

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getNum() != winningNumbers[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Metoden hämtar positionen av ett nummer i 2dArrayen
     * @param board spelplanen som ska letas efter numret
     * @param x numret som ska letas efter
     * @return int[] array med positionen i form av {RAD, KOLUMN}
     */
    public int[] getPosOfNum(Tile[][] board, int x) {
        int[] pos = new int[2];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].getNum() == x) {
                    pos = new int[]{i, j};
                }
            }
        }
        return pos;
    }

    /**
     * Endast för tillfällig testning för utskrift i terminalen
     * @param board
     */
    public void printBoard(Tile[][] board) {
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
        Tile[][] testBoard = {{new Tile(15), new Tile(14), new Tile(13), new Tile(12)},
                {new Tile(11), new Tile(10), new Tile(9), new Tile(8)},
                {new Tile(7), new Tile(6), new Tile(5), new Tile(4)},
                {new Tile(3), new Tile(2), new Tile(1), new Tile(0)}};

        System.out.println(boardHandler.compareToWinningBoard(testBoard));


    }

}
