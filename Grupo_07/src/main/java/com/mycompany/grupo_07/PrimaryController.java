package com.mycompany.grupo_07;

import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class PrimaryController {

    @FXML
    private RadioButton xOptionID;
    @FXML
    private ToggleGroup Signo;
    @FXML
    private RadioButton oOptionID;
    @FXML
    private RadioButton playerOptionID;
    @FXML
    private RadioButton machineOptionID;
    @FXML
    private Button playButtonID;
    @FXML
    private Label errorLabelID;
  
    
    @FXML
    private void switchToSecondary() throws IOException {
      boolean op1 = oOptionID.isSelected() && playerOptionID.isSelected();
      boolean op2 = xOptionID.isSelected() && playerOptionID.isSelected();
      
      boolean op3 = oOptionID.isSelected() && machineOptionID.isSelected();
      boolean op4 = xOptionID.isSelected() && machineOptionID.isSelected();
      String signOption="";
      String startOption="";
      String otherOptions="";
      
        if(op1){
            signOption="2";
            startOption="player";
            otherOptions="1";
          
        }else if(op2){
            signOption="1";
            startOption="player";
            otherOptions="2";
         
        }else if(op3){
            signOption="1";
            startOption="machine";
            otherOptions="2";
           
        }else if(op4){
            signOption="2";
            startOption="machine";
            otherOptions="1";
            
        }if(op1 || op2 || op3 || op4){
           
            try {
            FileWriter writer = new FileWriter(App.pathJuego, false);
            writer.write(signOption+","+startOption+","+otherOptions);
            writer.close();
        } catch (IOException e) {
            
            e.printStackTrace();
        }finally{
                App.setRoot("secondary");
            }
        }else{
            
        errorLabelID.setText("EXISTEN REQUERIMINETOS POR SELECCIONAR");
        }

        }
    }

