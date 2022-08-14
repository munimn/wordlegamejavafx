package edu.lawrence.tilegame;

public class Hand {

    private static final int HAND_SIZE = 28;
    private Tile[] tiles = new Tile[HAND_SIZE];
    private Bag bag;
    private GamePane pane;
    private double originX;
    private double originY;

    public Hand(GamePane p, double x, double y) {
        pane = p;
        bag = new Bag();
        this.originX = x;
        this.originY = y;
        for (int n = 0; n < 10; n++) {
            tiles[n] = bag.drawTile(n);
            tiles[n].moveTo(x + n * 50, y);
            pane.getChildren().addAll(tiles[n].getShapes());
        }
        for (int n = 10; n < 19; n++) {
            tiles[n] = bag.drawTile(n);
            tiles[n].moveTo(x+ 40 + (n-10) * 50, y +50);
            pane.getChildren().addAll(tiles[n].getShapes());
        }
        for (int n = 19; n < 28; n++) {
            tiles[n] = bag.drawTile(n);
            if(n==19){
            tiles[n].moveTo(x +(n-19) *50 , y +100);}
            else{
                tiles[n].moveTo(x+30 +(n-19) *50, y +100);
            }
            pane.getChildren().addAll(tiles[n].getShapes());
        }
        
    }

    

    public Tile getTile(double x, double y) {
        for (int n = 0; n < 28; n++) {
            if (tiles[n] != null && tiles[n].containsPoint(x, y)) {
                Tile t = tiles[n];
                return t;
            }
        }
        return null;
    }
        public Tile getletterTile(String letter) {
        for (int n = 0; n < 28; n++) {
            if (tiles[n] != null && tiles[n].containsLetter(letter)) {
                Tile t = tiles[n];
                return t;
            }
        }
        return null;
    }

    public void reclaimTile(Tile t) {
        double x = originX;
        double y = originY;
        for (int n = 0; n < 28; n++) {
            if (tiles[n] == null) {
                tiles[n] = t;
                t.moveTo(x + n * 50, y);
                break;
            }
        }
    }
    
}
