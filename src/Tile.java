public class Tile {

    public int x, y;
    public boolean walkable;
    public boolean start = false;
    public boolean end = false;
    public boolean pathNode = false;
    public boolean searched = false;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        walkable = true;
    }

    public Tile(int x, int y, boolean walkable) {
        this.x = x;
        this.y = y;
        this.walkable = walkable;
    }

}
