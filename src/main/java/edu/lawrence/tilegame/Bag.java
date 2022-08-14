package edu.lawrence.tilegame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Bag {
    private ArrayList<Tile> tiles;
    
    
    public Bag() {
        tiles = new ArrayList<Tile>();
        String[] keys = new String[]{"Q","W","E","R","T","Y","U","I","O","P","A","S","D","F","G","H","J","K","L","BACK","Z","X","C","V","B","N","M","ENTER"};

        for(int i=0; i < keys.length; i++){
            String str = new String(keys[i]);
                Tile t = new Tile(str);
                tiles.add(t);
            }
    }
    
    public Tile drawTile(int i) {
        Tile t = tiles.get(i);
        return t;
    }
    
    public void replaceTile(Tile t) {
        tiles.add(t);
        Collections.shuffle(tiles);
    }
}
