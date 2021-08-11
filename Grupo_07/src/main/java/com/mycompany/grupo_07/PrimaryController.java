package com.mycompany.grupo_07;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}
