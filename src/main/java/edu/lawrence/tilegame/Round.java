package edu.lawrence.tilegame;

import edu.lawrence.tilegame.Cell;
import edu.lawrence.tilegame.Cell;
import edu.lawrence.tilegame.GameGrid;
import edu.lawrence.tilegame.Hand;
import edu.lawrence.tilegame.Hand;
import edu.lawrence.tilegame.Tile;
import edu.lawrence.tilegame.Tile;
import edu.lawrence.tilegame.TileRun;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import javafx.scene.paint.Color;

public class Round {
    private boolean letterright;
    private boolean positionright;
    private ArrayList<Cell> cells;
    private LinkedList<Cell> newcells;
    
    private  LinkedList<String> word;
    private  String[] mainword;
    private Dictionary dictionary;
    private Hand hand;
    
    
    public Round(Cell cell,GameGrid grid) {
        cells = new ArrayList<Cell>();
        cells.add(cell);
        
    }
   
   
    public void isLegal(GameGrid grid,Hand hand, String guessword) {
        dictionary = new Dictionary();
        TileRun run = new TileRun(cells.get(0));     
        run.expandHorizontally(grid);
        newcells = new LinkedList<Cell>();
        newcells = run.getCells();
        word = new LinkedList<String>();
        String rowword = run.toString();
        if(dictionary.getSet().contains(rowword)) {
            
        
        word = run.toArray();
        mainword = guesswordSplit(guessword);
        
        for(int i=0;i<5;i++){
            Cell c =run.getCells().get(i);
            Tile keys = hand.getletterTile(word.get(i));
            Tile t = c.getTile();
            for(int j=0;j<5;j++){
                if(String.valueOf(word.get(i)).equals(mainword[i]))
                {  
                keys.setColor(Color.GREEN);
                t.setColor(Color.GREEN);
                break;}
                else if(String.valueOf(word.get(i)).equals(mainword[j]))
                {
                keys.setColor(Color.GOLDENROD);
                t.setColor(Color.GOLDENROD);
                break;} 
                else{
                    keys.setColor(Color.SLATEGREY);
                    t.setColor(Color.GREY);}
            }
                
            }   
        }
    }
    
    public void undo(Hand hand) {
        for(Cell c : cells) {
            Tile t = c.releaseTile();
            hand.reclaimTile(t);
        }
    }
    
   
    
    public String[] guesswordSplit(String wordguess){
        mainword = new String[wordguess.length()];
        for(int i=0;i<wordguess.length();i++){
            char c = wordguess.charAt(i);
            String letter = Character.toString(c);
            mainword[i]=letter;
        }
            
        return mainword;
    }
    
    
    
}
