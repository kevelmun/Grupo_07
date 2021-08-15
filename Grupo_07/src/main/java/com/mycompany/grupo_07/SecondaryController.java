package com.mycompany.grupo_07;

import java.io.IOException;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import objects.O;


public class SecondaryController {

    @FXML
    private Pane paneID;
    @FXML
    private GridPane gPaneID;
    @FXML
    private Button secondaryButton;
    
    
    
    @FXML
    private void switchToPrimary() throws IOException {
        /*
        O o = new O("0");
        O o1 = new O("1");
        O o2 = new O("2");
        O o3 = new O("3");
        O o4 = new O("4");
        O o5 = new O("5");
        O o6 = new O("6");
        O o7 = new O("7");
        O o8 = new O("8");
        gPaneID.add(o.getImage(), 0, 0);
        gPaneID.add(o1.getImage(), 0, 1);
        gPaneID.add(o2.getImage(), 0, 2);
        gPaneID.add(o3.getImage(), 1, 0);
        gPaneID.add(o4.getImage(), 1, 1);
        gPaneID.add(o5.getImage(), 1, 2);
        gPaneID.add(o6.getImage(), 2, 0);
        gPaneID.add(o7.getImage(), 2, 1);
        gPaneID.add(o8.getImage(), 2, 2);*/
        
        gPaneID.setAlignment(Pos.CENTER);
        cheackBox();
        //App.setRoot("primary");
        
    }
    
    
    private void cheackBox(){
        gPaneID.getChildren().forEach(item -> {
            item.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent t) {
                    gPaneID.add(new O("1").getImage(), 0, 0);
                }
            });

        });
    }
    

    
}