/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc_tp3.Ejercicio2;

/**
 *
 * @author Admin
 */
public class Vida {
    public int vida = 10;
    
    public void guardarVida(int vida){
        this.vida = vida;
    }
    
    public int obtenerVida(){
        return vida;
    }
    
    public synchronized void operarVida(int modificacion){
        guardarVida(vida + modificacion);
    }            
}
