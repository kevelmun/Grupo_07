/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import TDAs.Tree;
import objects.Tablero;

/**
 *
 * @author Usuario
 */
public class JugadaComputador {
    
    
    private Tree<Tablero> tree;

    public JugadaComputador(Tablero tablero) {
        tree=new Tree(tablero);
    }
    public void CreandoExtados(){
        int valorComputador=tree.getRoot().getContent().getValorcomputador();
        int valorJugador=tree.getRoot().getContent().getValorJugador();
        crearArbolExtendido(tree, valorComputador, valorJugador, 1);
        for (Tree<Tablero> t: tree.getRoot().getChildren()) {
            crearArbolExtendido(t, valorComputador, valorJugador,2);
        }

        
        
    }
    
    
    private void crearArbolExtendido(Tree<Tablero> t, int vc, int vj, int turno){
        
        for (int i=0; i < t.getRoot().getContent().getA().length; i++) {
            for (int j = 0; j < t.getRoot().getContent().getA()[i].length; j++) {

                if(t.getRoot().getContent().getA()[i][j]==0){
                    int [][]copia=copiarArreglo(t.getRoot().getContent().getA());
                    Tablero estado= new Tablero(copia);
                    if(turno == 1)
                        estado.getA()[i][j]=vc;
                    if(turno == 2)
                        estado.getA()[i][j]=vj;
                    estado.ActualizarUtilidad(vc, vj);
                    t.addChild(estado);  
                }    
            }
        }  

    }
    
    public int [][] copiarArreglo(int[][] original){
        int [][]copia =new int[3][3];
        for (int i = 0; i < original.length; i++) {
            for (int j = 0; j < original[i].length; j++) {
                copia[i][j]=original[i][j];
            } 
        }
        return copia;
        
    }
    
    
    public Tablero predecirJugada(){
        
        Tablero jugada=null;
        
        
        int utilidad=-10;
        for(Tree<Tablero> t1: tree.getRoot().getChildren()){
            if(tree.getRoot().getChildren().size()==1)
                jugada=t1.getRoot().getContent();
                
            System.out.println();
            imprimir(t1.getRoot().getContent().getA());
            System.out.println("----------------------------------------");
            
            for(Tree<Tablero> t2: t1.getRoot().getChildren()){
                imprimir(t2.getRoot().getContent().getA());
                System.out.println("");
                
                if(t2.getRoot().getContent().getUlilidad()>utilidad){
                    
                    utilidad=t2.getRoot().getContent().getUlilidad();
                    jugada=t1.getRoot().getContent(); 
                }
            }
            System.out.println("----------------------------------------");
            
        }
        return jugada;
    }
    
    
    void imprimir(int[][] a){
        int[][] matriz=a;
       for (int x=0; x < matriz.length; x++) {
           for (int y=0; y < matriz.length; y++) {
               System.out.print (a[y][x] + " ");
               
           }
           System.out.println();
       }
    
    }
    
    
    
    
}
