public class Tile {

    private int num;

    public Tile(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void switchNum(Tile targetTile) {
        int tempNum = num;
        this.num = targetTile.getNum();
        targetTile.switchNum(this);
    }
}
