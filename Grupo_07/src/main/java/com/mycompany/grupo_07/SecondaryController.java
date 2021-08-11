package com.mycompany.grupo_07;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import objects.O;
import objects.Sign;

public class SecondaryController {

    @FXML
    private Pane paneID;
    @FXML
    private GridPane gPaneID;
    @FXML
    private Button secondaryButton;
    
    
    
    @FXML
    private void switchToPrimary() throws IOException {
     
        gPaneID.add(new ImageView(new Image("src/main/resources/pics/O.png")), 1, 1);
     
        //App.setRoot("primary");
        //new ImageView(new Image("/src/main/resources/pics/O.png"))
    }
    
    
    
    
}