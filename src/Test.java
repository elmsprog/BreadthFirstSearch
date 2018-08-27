public class Test {

    public static void main(String[] arg) {

        System.out.println("Starting");

        Tilemap tilemap = new Tilemap(32, 32);
        tilemap.build();

        Tile start = tilemap.tiles[1][1];
        Tile end   = tilemap.tiles[25][15];

        System.out.println("Map built");

        start.start = true;
        start.walkable = true;
        end.end = true;
        end.walkable = true;

        System.out.println("Start and End set");

        long startTime = System.currentTimeMillis();
        BreadthFirstSearch bfs = new BreadthFirstSearch(tilemap, start.x, start.y, end.x, end.y);
        bfs.search();
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println("Process Time: " + estimatedTime / 1000.0 + " seconds");

        tilemap.setSearched(bfs.explored);
        tilemap.setPath(bfs.path);

        tilemap.drawMap();


    }

}
