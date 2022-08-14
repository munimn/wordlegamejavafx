package edu.lawrence.tilegame;

import java.util.ArrayList;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class GamePane extends Pane {

    private Tile dragging;
    private Hand hand;
    private double lastX, lastY;
    private GameGrid grid;
    private Round round;
    private int row=0;
    private int col=0;
    private Dictionary dictionary;
    private String guessword;
    

    public GamePane() {
        Dictionary.Init();
        dictionary = new Dictionary(); 
        guessword = dictionary.randomWord();
        System.out.println(guessword);
        grid = new GameGrid(this);
        round = null;
        hand = new Hand(this, 200, 500);
        this.setOnMousePressed(e -> startDrag(e));
    }

    public void startDrag(MouseEvent e) {
        lastX = e.getX();
        lastY = e.getY();
        dragging = hand.getTile(lastX, lastY);
        String letter = String.valueOf(dragging.getText());
        if (!letter.equals("ENTER") && !letter.equals("BACK"))
        {
            Cell c = grid.findCell();
            row = c.getRow();
            col =c.getCol();
        Tile tile = new Tile(letter);
        tile.setColor(Color.WHITE);
        tile.setTextColor(Color.BLACK);
                    if (!c.hasTile()) {
                        c.claimTile(tile);
                        this.getChildren().addAll(tile.getShapes());  
                    }    
        }
        if(letter.equals("ENTER")){
            Cell newc= grid.getCell(row,0);
            round = new Round(newc,grid);
            round.isLegal(grid,hand,guessword);    
        }
        if(letter.equals("BACK")) {
                        Cell recentc = grid.getCell(row, col);
                        Tile t = recentc.getTile();
                        this.getChildren().removeAll(t.getShapes());  
                        grid.undoCell(row, col);
                        col = recentc.getCol()-1;
        }  
    }

   

    

    
}
