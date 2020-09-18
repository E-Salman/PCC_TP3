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
    char letra;         //El caracter que imprime esta Letra
    int cantidad;       //La cantidad de veces que imprimi por ciclo esta Letra
    boolean imprimio;   //Indica si esta Letra termino de imprimir su caracter
    Turno turno;        //Variable compartida entre los hilos de Letras
    
    public Letra(char letra, int cantidad, Turno turno){
        this.letra = letra;
        this.cantidad = cantidad;
        this.turno = turno;
        imprimio = false;
    }
    
    public void run(){
        while(!imprimio){
            if(turno.obtenerTurno(letra)) imprimir();   //Si es su turno, imprime a traves del metodo imprimir()
            else try {
                Thread.sleep(1000);
            } catch (InterruptedException ex){//prueba comentario
                Logger.getLogger(Letra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void imprimir(){
        synchronized(turno){                            //Este bloque esta sincronizado sobre el objeto compartido turno, 
            turno.calcularProximoTurno(letra);          //para que otros hilos no impriman mientras haya otro imprimiendo
            for(int i = 0; i < cantidad; i++) System.out.println(letra);    //Imprime el caracter de Letra en base a la variable cantidad
            imprimio = true;
        }        
    }    
}