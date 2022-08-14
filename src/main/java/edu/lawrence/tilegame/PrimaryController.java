package edu.lawrence.tilegame;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {
    @FXML
    private VBox vBox;
    private GamePane game;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        game = new GamePane();
        game.setPrefSize(1000,860);
        vBox.getChildren().add(game);
    }  
}
