class Tile {

    int x, y;
    boolean walkable;
    boolean start = false;
    boolean end = false;
    boolean pathNode = false;
    boolean searched = false;

    Tile(int x, int y) {
        this.x = x;
        this.y = y;
        walkable = true;
    }

    Tile(int x, int y, boolean walkable) {
        this.x = x;
        this.y = y;
        this.walkable = walkable;
    }

}
