package edu.lawrence.tilegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Cell {
    private static final double CELL_SIZE = 50.0;
    private Rectangle border;
    private Tile tile;
    private int row, col;
    
    public Cell(int row,int col) {
        border = new Rectangle(320+col*CELL_SIZE,100+row*CELL_SIZE,CELL_SIZE,CELL_SIZE);
        border.setStroke(Color.BLACK);
        border.setFill(Color.WHITE);
        tile = null;
        this.row= row;
        this.col = col;
    }
    
    public Shape getShape() { return border; }
    
    public boolean containsPoint(double x, double y) {
        return border.contains(x,y);
    }
    
    public boolean hasTile() {
        return tile != null;
    }
    
    public void claimTile(Tile t) {
        tile = t;
        tile.moveTo(border.getX() + 2.5, border.getY() + 2.5);
    }
     public Tile releaseTile() {
        Tile t = tile;
        tile = null;
        return t;
    }
    

     public Tile getTile() { return tile; }
    public int getRow() { return row; }
    public int getCol() { return col; }
}
