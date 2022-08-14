package edu.lawrence.tilegame;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Tile {
    private String letter;
    private Rectangle rect;
    private Text text;
    private static Font font = new Font("Arial",12);
    
    public Tile(String letter) {
        this.letter = letter;
        rect = new Rectangle(0,0,35+10*letter.length(),45);
        rect.setFill(Color.GREY);
        text = new Text(20,20,letter);
        text.setFont(font);
        text.setStroke(Color.WHITE);
    }
    
    public Shape[] getShapes() {
        Shape[] shapes = new Shape[2];
        shapes[0] = rect;
        shapes[1] = text;
        return shapes;
    }
    public double getendx(){
        double r = rect.getWidth();
        return r;
    }
    
    public boolean containsPoint(double x,double y) {
        return rect.contains(x, y);
    }
    public boolean containsLetter(String letter){
        return letter.equals(getText().toLowerCase());
    }
    
    public void moveTo(double x,double y) {
        rect.setX(x);
        rect.setY(y);
        text.setX(x + 20);
        text.setY(y+25);
    }
    public void setColor(Color c){
        rect.setFill(c);
    }
    public Color getColor(){
        Color c = (Color) rect.getFill();
        return c;
    }
    public String getText(){
        String letter = text.getText();
        return letter;
    }
    public void setTextColor(Color c){
        text.setStroke(c);
    }
    public String getLetter() { return letter; }
    
    public void moveBy(double deltaX, double deltaY) {
        rect.setX(rect.getX() + deltaX);
        rect.setY(rect.getY() + deltaY);
        text.setX(rect.getX() + 20);
        text.setY(rect.getY() + 25);
    }
}
