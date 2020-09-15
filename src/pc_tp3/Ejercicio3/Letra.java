/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc_tp3.Ejercicio3;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Letra implements Runnable{
    char letra;
    int cantidad;
    boolean imprimio;
    Turno turno;    
    
    public Letra(char letra, int cantidad, Turno turno){
        this.letra = letra;
        this.cantidad = cantidad;
        this.turno = turno;
        imprimio = false;
    }
    
    public void run(){
        while(!imprimio){
            if(turno.obtenerTurno(letra)) imprimir();
            else try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Letra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void imprimir(){
        turno.enUso();
        turno.calcularProximoTurno(letra);
        for(int i = 0; i < cantidad; i++)
            System.out.println(letra);
        turno.enUso();
        imprimio = true;
    }    
}
