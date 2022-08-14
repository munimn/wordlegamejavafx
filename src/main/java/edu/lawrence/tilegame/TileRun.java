package edu.lawrence.tilegame;

import java.util.LinkedList;

// A TileRun is a sequence of connected tiles. Runs of tiles in the 
// game must form proper words.
public class TileRun {
    private LinkedList<Cell> cells;
    private LinkedList<String> usedletter;
    
    // We make a run by starting from a seed cell, and then expanding 
    // outward from that first cell in either a horizontal or a
    // vertical line
    public TileRun(Cell first) {
        cells = new LinkedList<Cell>();
        cells.add(first);
    }
    
    public int getLength() { return cells.size(); }
    public LinkedList<Cell> getCells(){
        return cells;   
}
    
    public void expandHorizontally(GameGrid grid) {
        
        Cell current = cells.getFirst();
        while(true) {
            Cell right = grid.getCellRight(current);
            if(right != null && right.hasTile()) {
                cells.add(right);
                current = right;
            } else
                break;
        } 
    }
    
   
    
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Cell c : cells) {
            Tile t = c.getTile();
            builder.append(t.getLetter());
        }
        return builder.toString().toLowerCase();
    }
    public LinkedList<String> toArray() {
        usedletter = new LinkedList<String>();
        for(Cell c : cells) {
            Tile t = c.getTile();
            
            usedletter.add(t.getLetter().toLowerCase());    
        }
        return usedletter;
    }
}
