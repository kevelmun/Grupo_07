/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.grupo_07;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MenuController {
    @FXML
    private RadioButton PvPID;
    @FXML
    private ToggleGroup beggins;
    @FXML
    private RadioButton PvCID;
    @FXML
    private Button playButtonID;
     
    
    @FXML
    private void jugar() throws IOException {
        String opcion = "";
        if(PvPID.isSelected()){
            opcion = "pvp";
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("X empieza el juego");
            alert.showAndWait();
            try {
                App.setRoot("secondary");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        if(PvCID.isSelected()){
            opcion = "pvc";
            App.setRoot("primary");
        }
        
        try {
            FileWriter writer = new FileWriter(App.pathMenu, false);
            writer.write(opcion);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }
}
