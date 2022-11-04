import java.util.*;

public class BoardHandler { //innehåller metoder för board

    private final int sideLength;
    private final int boardSize;

    public BoardHandler(int sideLength) {
        this.sideLength = sideLength;
        this.boardSize = (int)Math.pow(sideLength, 2);
    }


    /**
     * Skapar en ny 2d array med slumpmässiga nummer
     * @return 2dArray spelplan
     */
    public Tile[][] createNewBoard() {
        List<Integer> numbers = getNumbers();
        Tile[][] board = new Tile[sideLength][sideLength];
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
     * Metoden hämtar alla nummer som ska vara med i spelet
     * @return lista med alla nummer
     */
    public List<Integer> getNumbers() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        for (int i = boardSize-1; i > 0; i--) {
            numbers.add(i);
        }
        return numbers;
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
        int[][] winningNumbers = new int[sideLength][sideLength];
        List<Integer> winningNumbersList = getNumbers();

        for (int i = 0; i < winningNumbers.length; i++) {
            for (int j = 0; j < winningNumbers[i].length; j++) {
                winningNumbers[i][j] = winningNumbersList.get(0);
                winningNumbersList.remove(0);
            }
        }

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

}
