package edu.lawrence.tilegame;

public class GameGrid {
    private Cell[][] cells;
    
    public GameGrid(GamePane pane) {
        cells = new Cell[6][5];
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                Cell c = new Cell(row, col);
                cells[row][col] = c;
                pane.getChildren().add(c.getShape());
            }
        }
    }
    
    // Find the Cell that contains the given point.
    public Cell findCell() {
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 5; col++) {
                if(!cells[row][col].hasTile()){
                    return cells[row][col]; 
                }
                
            }
        }
        return null;
    }
    public Cell getCell(int x, int y){
        return cells[x][y];
    }
    public void undoCell(int row,int col){
       cells[row][col].releaseTile();   
    }
    
    public Cell getCellLeft(Cell cell) {
        if(cell.getCol() > 0)
            return cells[cell.getRow()][cell.getCol() - 1];
        return null;
    }
    
    public Cell getCellRight(Cell cell) {
        if(cell.getCol() < 4)
            return cells[cell.getRow()][cell.getCol() + 1];
        return null;
    }
    
    public Cell getCellAbove(Cell cell) {
        if(cell.getRow() > 0)
            return cells[cell.getRow() - 1][cell.getCol()];
        return null;
    }
    
    public Cell getCellBelow(Cell cell) {
        if(cell.getRow() < 5)
            return cells[cell.getRow() + 1][cell.getCol()];
        return null;
    }
}
