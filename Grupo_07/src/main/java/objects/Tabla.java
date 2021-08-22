/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

import java.lang.reflect.Array;

/**
 *
 * @author USER
 */
public class Tabla {
    private Celda tabla[][];

    public Tabla() {
        Celda tabla2[][]= {{new Celda(), new Celda(), new Celda()}, 
                           {new Celda(), new Celda(), new Celda()},
                           {new Celda(), new Celda(), new Celda()}};
        tabla = tabla2;
    }
    
    public boolean columnaDisponible(int indexColumna, Sign jugador){
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
    }
 
}
