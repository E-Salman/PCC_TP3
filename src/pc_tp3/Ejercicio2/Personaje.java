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
public class Personaje implements Runnable{
    int modificador;
    VIDA vida;
    
    public Personaje(VIDA vida){
        this.vida = vida;        
    }
    
    public void actuar(){
        System.out.println("Vida modificada: " + modificador + " por: " + Thread.currentThread().getName());
        vida.operarVida(modificador);
    }
    
    public void run(){
        actuar();
    }
}