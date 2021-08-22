/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objects;

/**
 *
 * @author USER
 */
public class Celda {
    private boolean marcado;
    private Sign marca;

    public boolean isMarcado() {
        return marcado;
    }

    public void setMarcado(boolean marcado) {
        this.marcado = marcado;
    }

    public Sign getMarca() {
        return marca;
    }

    public void setMarca(Sign marca) {
        this.marca = marca;
    }
    
    
}
