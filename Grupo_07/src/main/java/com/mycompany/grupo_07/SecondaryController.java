package com.mycompany.grupo_07;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import objects.Tablero;


public class SecondaryController implements Initializable{

    @FXML
    private Pane paneID;
    @FXML
    private GridPane gPaneID;
    @FXML
    private Button secondaryButton;
    
    
    private String turno;
    private int valorjugador;
    private int valorComputador;
    private String modoJuego;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Tablero t=new Tablero(gPaneID);
        t.crearTablero();
        
        try {
            readMenu();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        if(modoJuego.equals("pvp")){
            t.setPlayerVSplayer(true);
            t.setValorJugador(1);
        }else if (modoJuego.equals("pvc")){
            try {
                readData();

                t.setValorJugador(valorjugador);
                t.setValorcomputador(valorComputador);

                if(this.turno.equals("machine")){
                    t.jugadaMachine();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            
        }
        
    }
    
    public void readData() throws FileNotFoundException, IOException{
        String[] list;
        FileReader reader = new FileReader(App.pathJuego);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        line = bufferedReader.readLine();
        list= line.split(",");
        reader.close();
        this.turno=list[1];
        
        definiendovalores(Integer.parseInt(list[0]), Integer.parseInt(list[2]));
    }
    
    public void readMenu() throws FileNotFoundException, IOException{
        FileReader reader = new FileReader(App.pathMenu);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line;
        line = bufferedReader.readLine();
        modoJuego = line;
        reader.close();
    }
    
    public void definiendovalores(int v1, int v2){
        if(this.turno.equals("player")){
            valorjugador=v1;
            valorComputador=v2; 
        }else{
            valorjugador=v2;
            valorComputador=v1;            
        }        
    }   
 
}
    

    
