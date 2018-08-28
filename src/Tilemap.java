import java.util.ArrayList;
import java.util.HashMap;


class Tilemap {

    private int width, height;
    Tile[][] tiles;

    Tilemap(int width, int height) {
        this.width = width;
        this.height = height;
        tiles = new Tile[width][height];
    }

    void build() {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                if(Math.random() < 0.2) {
                    tiles[i][j] = new Tile(i, j, false);
                } else {
                    tiles[i][j] = new Tile(i, j);
                }
            }
        }
    }

    boolean walkable(int x, int y) {
        if(x >= 0 && y >= 0 && x < width && y < height) {
            return tiles[x][y].walkable;
        } else {
            return false;
        }
    }

    void setSearched(HashMap<Tile, Tile> tilesSearched) {
        if(tilesSearched != null && !tilesSearched.isEmpty()) {
            for(Tile tile: tilesSearched.keySet()) {
                tile.searched = true;
            }
        }
    }

    void setPath(ArrayList<Tile> path) {
        if(path != null && path.size() > 0) {
            for (Tile tile : path) {
                tile.pathNode = true;
            }
        }
    }

    void drawMap() {
        for(int i = 0; i < width; i++) {
            System.out.println();
            for(int j = 0; j < height; j++) {
                if(tiles[i][j].start) {
                    System.out.print("[@]");
                } else if(tiles[i][j].end) {
                    System.out.print("[E]");
                } else if(tiles[i][j].pathNode) {
                    System.out.print("[*]");
                } else if(tiles[i][j].searched) {
                    System.out.print("[-]");
                } else if(tiles[i][j].walkable) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[X]");
                }
            }
        }
    }

}
