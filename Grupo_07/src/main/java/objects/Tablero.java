/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import com.mycompany.grupo_07.App;
import java.io.IOException;
import java.lang.reflect.Array;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import modelo.JugadaComputador;
import modelo.Wins;

/**
 *
 * @author USER
 */
public class Tablero {
    private GridPane grid;
    private int a[][];
    private int ulilidad;
    private int ValorJugador;
    private int Valorcomputador;
    private boolean playerVSplayer;
    
    //contructores
     public Tablero(GridPane grid){
         this.grid=grid;
         a = new int[3][3];
         this.playerVSplayer=false;
    }
     public Tablero(GridPane grid, int Valorcomputador, int valorJugador){
         this.grid=grid;
         a = new int[3][3];
         this.Valorcomputador=Valorcomputador;
         this.ValorJugador=valorJugador;
         this.playerVSplayer=false;
     }
     public Tablero(int matrix[][]){
         this.a = matrix;
         
     }

    public int[][] getA() {
        return a;
    }

    public int getUlilidad() {
        return ulilidad;
    }

    public int getValorJugador() {
        return ValorJugador;
    }

    public int getValorcomputador() {
        return Valorcomputador;
    }

    public void setValorJugador(int ValorJugador) {
        this.ValorJugador = ValorJugador;
    }

    public void setValorcomputador(int Valorcomputador) {
        this.Valorcomputador = Valorcomputador;
    }

    public void setPlayerVSplayer(boolean playerVSplayer) {
        this.playerVSplayer = playerVSplayer;
    }
    
    
    
     
    
    public void crearTablero(){//Configurando y definiendo el grid pane
        Wins w = new Wins();
        if(!(w.checkWin(this) || w.checkEmpate(this))){
        for (int i = 0 ; i < 3 ; i++) {
            ColumnConstraints colConstraints = new ColumnConstraints();
            colConstraints.setHgrow(Priority.SOMETIMES);
            grid.getColumnConstraints().add(colConstraints);
        }

        for (int i = 0 ; i < 3 ; i++) {
            RowConstraints rowConstraints = new RowConstraints();
            rowConstraints.setVgrow(Priority.SOMETIMES);
            grid.getRowConstraints().add(rowConstraints);
        }
        
            for (int i = 0 ; i < 3 ; i++) {//Para añadir un panel a cada celda y asociaes un evento de click
            for (int j = 0; j < 3; j++) {
                addPane(i, j);
                a[i][j]=0;
            }
        }
        
        }else if(w.checkWin(this) || w.checkEmpate(this)){
            System.out.println(w.getWinner());
        }
        System.out.println("AQUIIIIIIIIIIII");
        
    }
    
    private void addPane(int colIndex, int rowIndex) {
        Pane pane = new Pane();
        pane.setOnMouseClicked(e -> {
            if(playerVSplayer){
                hacerJugada(colIndex, rowIndex, ValorJugador);
                ganoPlayerVsPlayer();
                cambiarValor();
            }if(!playerVSplayer){
                hacerJugada(colIndex, rowIndex, ValorJugador);
                jugadaMachine();
                System.out.printf("Mouse enetered cell [%d, %d]%n", colIndex, rowIndex);
            }
            
        });
        grid.add(pane, colIndex, rowIndex);
    }
    
    public void jugadaMachine(){
        Wins win =new Wins();
        
        if(!win.checkWin(this)){
            JugadaComputador jugada=new JugadaComputador(this);
            jugada.CreandoExtados();
            Tablero t=jugada.predecirJugada();// obtengo el tablero en el que se debe hacer a jugada
            if(t!=null){
                int coordenadas[]=coordenadasJugada(t);//obtengo las coordenadas para cher la jugada
                hacerJugada(coordenadas[0], coordenadas[1], Valorcomputador);
                gano();

            }
        }else{
            gano(win.getWinner());
        }
        
    }
    
    private int[] coordenadasJugada(Tablero t){
        int coordenadas[]=new int[2];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if(this.a[i][j]!=t.a[i][j]){
                    coordenadas[0]=i;
                    coordenadas[1]=j;
                    return coordenadas; 
                }  
            }
            
        }
        
        return coordenadas;
    }
    
    private void hacerJugada( int col, int row, int valor){
        
        
        Node n=null;
        for (Node node : grid.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                n = node;
            }
        }
        if(n instanceof Pane){
            if(valor==2)
                grid.add(new O("1").getImage(), col, row);
            else
                grid.add(new X("2").getImage(), col, row);
            a[col][row]=valor; 
        }if(empate())
            finalizar("Es un empate");
            
        
    }
    
    public void ActualizarUtilidad(int v1, int v2){
        int p1=pFilasColumna(v1)+ pDiagonal(v1);
        int p2=pFilasColumna(v2)+ pDiagonal(v2);
        ulilidad=p1-p2;
        
        
    }
    
    public int pFilasColumna(int valor){
        int px=0;
        for (int i = 0; i < 3; i++) {
            int x=0, y=0;
            for (int j = 0; j < 3; j++) {
                if(a[i][j]==0 || a[i][j]==valor)
                    x++;
                if(a[j][i]==0 || a[j][i]==valor)
                    y++;
            }
            if(x==3 && y==3)
                px+=2;
            else if(x==3 || y==3)
                px++;
        }
        return px;   
    }
    public int pDiagonal(int valor){
        int px=0;
        int x=0,y=0;
        for (int i = 0; i < 3; i++) {
            if(a[i][i]==valor || a[i][i]==0)
                x++;
            if(a[i][(2-i)]==valor || a[i][(2-i)]==0)
                y++;
        }        
        if(x==3 && y==3)
            px+=2;
        else if(x==3 || y==3)
            px++;
        return px;
            
        }
    
    public void gano(int ganador){
        String nomGanador="Gano ";
        if(ganador==ValorJugador)
            nomGanador+="Jugador"; 
        else
            nomGanador+="Computador";
        finalizar(nomGanador); 
        
    }
    public void gano(){
        Wins win =new Wins();
        
        if(win.checkWin(this)){
            String nomGanador="Gano ";
            if(win.getWinner()==ValorJugador)
                nomGanador+="Jugador"; 
            else
                nomGanador+="Computador";
            finalizar(nomGanador);
        }
        
    }
    
    public void ganoPlayerVsPlayer(){
        Wins win =new Wins();
        
        if(win.checkWin(this)){
            String nomGanador="Gano ";
            if(win.getWinner()==1)
                nomGanador+="X"; 
            else
                nomGanador+="O";
            finalizar(nomGanador);
        }
        
    }
    
    public void finalizar(String mensaje){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(mensaje);
        alert.showAndWait();
        try {
            App.setRoot("menu");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    public boolean empate(){
        Wins win =new Wins();
        return win.checkEmpate(this);
        
    }
    
    public void cambiarValor(){
        if(ValorJugador==1)
            ValorJugador=2;
        else
            ValorJugador=1;
    }
    
    
     
     
     
     
    
    /*public boolean columnaDisponible(int indexColumna, Sign jugador){
        int count = 0;
        for(int i=0 ; i<3 ; i++){
            Celda celda = tabla[i][indexColumna];
            if(celda.isMarcado()){
                if (celda.getMarca().getClass() != jugador.getClass())
                count++;
            }
        }
        return count == 0;
    }
    
    public boolean filaDisponible(int indexFila, Sign jugador){
        int count = 0;
        for(int i=0 ; i<3 ; i++){
            Celda celda = tabla[indexFila][i];
            if(celda.isMarcado()){
                if (celda.getMarca().getClass() != jugador.getClass())
                count++;
            }
        }
        return count == 0;
    }
    
    public boolean diagonalPrincipalDisponible(Sign jugador){
        int count = 0;
        for(int i=0 ; i<3 ; i++){
            Celda celda = tabla[i][i];
            if(celda.isMarcado()){
                if (celda.getMarca().getClass() != jugador.getClass())
                count++;
            }
        }
        return count == 0;
    }
    
    public boolean diagonalSecundariaDisponible(Sign jugador){
        int count = 0;
        int j = 2;
        for(int i=0 ; i<3 ; i++){
            Celda celda = tabla[i][j];
            if(celda.isMarcado() && celda.getMarca().getClass()==jugador.getClass()){
                count++;
                j--;
            }
        }
        return count == 0;
    }
    
    public int calcularP(Sign jugador){
        int filas = 0;
        int columnas = 0; 
        int diagonales = 0;
        
        for(int i=0 ; i<3 ; i++){
            if(columnaDisponible(i,jugador)) {columnas++;}
            if(filaDisponible(i,jugador)) {filas++;}
        }
        if(diagonalPrincipalDisponible(jugador)){diagonales++;}
        if(diagonalSecundariaDisponible(jugador)){diagonales++;}
        return filas + columnas + diagonales; 
    }*/
 
}
