public class Main {


  private BoardHandler boardHandler = new BoardHandler(); //metoder för att hantera spelplanen

  private Tile[][] board;

  public Main(){
      board = boardHandler.createNewBoard();
      boardHandler.printBoard(board);

  }


    public static void main(String[] args) {
      Main m = new Main();
    }

}
