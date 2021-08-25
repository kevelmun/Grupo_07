/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import objects.Tablero;

/**
 *
 * @author Elix
 */
public class Wins {
    private int winner;
    public boolean checkWin(Tablero tablero){
        
     boolean filasO = checkWinFilas(tablero,1);
     boolean columnasO = checkWinColumnas(tablero, 1);
    boolean diagonalesO = cheackWinDiagonales(tablero, 1);
    
    boolean filasX = checkWinFilas(tablero,2);
     boolean columnasX = checkWinColumnas(tablero, 2);
    boolean diagonalesX = cheackWinDiagonales(tablero, 2);
        
        if(filasX || columnasX || diagonalesX){
            
            this.winner=2;
            return true;
        }
        if(filasO || columnasO || diagonalesO){
            
            this.winner=1;
            return true;
        }
        return false;
    }

    private static boolean checkWinColumnas(Tablero tablero, int n) {
       int[][] a = tablero.getA();
        
                
        boolean cOne= a[0][0]==n && a[1][0]==n && a[2][0]==n;
        boolean cTwo= a[0][1]==n && a[1][1]==n && a[2][1]==n;
        boolean cThree= a[0][2]==n && a[1][2]==n && a[2][2]==n;
        
        if( cOne || cTwo || cThree){
            return true;
        }
        
        return false;
    }

    private static boolean checkWinFilas(Tablero tablero, int n) {
        int[][] a = tablero.getA();
        boolean fOne= a[0][0]==n && a[0][1]==n && a[0][2]==n;
        boolean fTwo= a[1][0]==n && a[1][1]==n && a[1][2]==n;
        boolean fThree= a[2][0]==n && a[2][1]==n && a[2][2]==n;
                
        if( fOne || fTwo || fThree){
            return true;
        }
        
        return false;
    }

    private static boolean cheackWinDiagonales(Tablero tablero, int n) {
        
        boolean dP = cheackWinDiagonalP(tablero, n);
        boolean dS = cheackWinDiagonalS(tablero, n);
        
        return dP || dS;
    }

    private static boolean cheackWinDiagonalP(Tablero tablero, int n) {
        
        int[][] a = tablero.getA();
        
        if(a[0][0]==n && a[1][1]==n && a[2][2]==n){
            return true;
        }
        return false;
    }
    
    private static boolean cheackWinDiagonalS(Tablero tablero, int n) {
        int[][] a = tablero.getA();
        
        if(a[2][0]==n && a[1][1]==n && a[0][2]==n){
            return true;
           
        }
        return false;
    }
    
    public boolean checkEmpate(Tablero tablero){
        int [][] a = tablero.getA();
        if(checkWin(tablero)){
            return false;
        }
        if(a[0][0]!=0 && a[1][0]!=0 && a[2][0]!=0 && 
           a[0][1]!=0 && a[1][1]!=0 && a[2][1]!=0 &&
           a[0][2]!=0 && a[1][2]!=0 && a[2][2]!=0){
             this.winner=3;
            return true;
        }
        return false;
    }

    public int getWinner() {
        return winner;
    }

    public void setWinner(int winner) {
        this.winner = winner;
    }
    
    
    
    
    
    
    
    
}
