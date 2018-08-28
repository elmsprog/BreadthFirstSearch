import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {

    private Tilemap tilemap;
    private int startX, startY, endX, endY;

    private Queue<Tile> frontier;
    HashMap<Tile, Tile> explored;

    private Tile current;

    ArrayList<Tile> path;

    public BreadthFirstSearch(Tilemap tilemap, int startX, int startY, int endX, int endY) {
        this.tilemap = tilemap;
        this.startX = startX;
        this.startY = startY;
        this.endX = endX;
        this.endY = endY;

        frontier = new LinkedList<>();
        explored = new HashMap<>();
        path = new ArrayList<>();

        frontier.add(this.tilemap.tiles[startX][startY]);
        explored.put(this.tilemap.tiles[startX][startY], null);

    }

    void search() {

        System.out.println("Searching for path");

        while(!frontier.isEmpty()) {
            current = frontier.remove();
            if(current == tilemap.tiles[endX][endY]) {
                System.out.println("Path found");
                createPath();
                break;
            }
            for(Tile tile: getNeighbors(current)) {
                if(!explored.containsKey(tile)) {
                    frontier.add(tile);
                    explored.put(tile, current);
                }
            }
        }

    }

    private ArrayList<Tile> getNeighbors(Tile node) {
        ArrayList<Tile> neighbors = new ArrayList<>();
        int x = node.x;
        int y = node.y;

        if (tilemap.walkable(x,y - 1)) {
            neighbors.add(tilemap.tiles[x][y - 1]);
        }
        if (tilemap.walkable(x + 1,y)) {
            neighbors.add(tilemap.tiles[x + 1][y]);
        }
        if (tilemap.walkable(x,y + 1)) {
            neighbors.add(tilemap.tiles[x][y + 1]);
        }
        if (tilemap.walkable(x - 1,y)) {
            neighbors.add(tilemap.tiles[x - 1][y]);
        }
        if (tilemap.walkable(x - 1,y - 1)) {
            neighbors.add(tilemap.tiles[x - 1][y - 1]);
        }
        if (tilemap.walkable(x + 1,y - 1)) {
            neighbors.add(tilemap.tiles[x + 1][y - 1]);
        }
        if (tilemap.walkable(x + 1,y + 1)) {
            neighbors.add(tilemap.tiles[x + 1][y + 1]);
        }
        if (tilemap.walkable(x - 1,y + 1)) {
            neighbors.add(tilemap.tiles[x - 1][y + 1]);
        }
        return neighbors;
    }

    private void createPath() {
        System.out.println("Building path");
        current = explored.get(tilemap.tiles[endX][endY]);
        while(current != tilemap.tiles[startX][startY]) {
            path.add(0, current);
            current = explored.get(current);
        }
    }

}
