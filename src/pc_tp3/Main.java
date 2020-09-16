package pc_tp3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.logging.Level;
import java.util.logging.Logger;
import pc_tp3.Ejercicio1.VerificarCuenta;
import pc_tp3.Ejercicio4.Auto;
import pc_tp3.Ejercicio4.Service;
import pc_tp3.Ejercicio2.Curandero;
import pc_tp3.Ejercicio2.Vida;
import pc_tp3.Ejercicio2.Orco;
import pc_tp3.Ejercicio3.Letra;
import pc_tp3.Ejercicio3.Turno;

/**
 *
 * @author Admin
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        int ejercicio = 3;        //Modificar para elegir que ejercicio ejecutar
                                  //Ej: ejercicio = 1 ejecuta el primer ejercicio
        switch(ejercicio){
            case 1:
                ejecutarEj1();
                break;
            case 2:
                ejecutarEj2();
                break;
            case 3:
                ejecutarEj3();
                break;
            case 4:
                ejecutarEj4();
                break;
        }
    }
    
    public static void ejecutarEj1(){
        VerificarCuenta vc = new VerificarCuenta();
        Thread[] hilos = new Thread[2];
        hilos[0] = new Thread(vc, "Luis");
        hilos[1] = new Thread(vc, "Manuel");
        for(int i = 0; i < 2; i++) hilos[i].start();
    }
    
    public static void ejecutarEj2(){
        Vida vida = new Vida();
        Thread[] hilos = new Thread[2];
        hilos[0] = new Thread(new Orco(vida), "orco");
        hilos[1] = new Thread(new Curandero(vida), "curandero");
        for(int i = 0; i < 2; i++){
            hilos[i].start();
        }
        try{        
            for(int i = 0; i < 2; i++){
                hilos[i].join();            //Los dos joins son para que el hilo main espere a que terminen sus ejecuciones 
            }                               //los dos hilos antes de imprimir la vida resultante final
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Vida resultante: " + vida.obtenerVida());
    }
    
    public static void ejecutarEj3(){
        Turno turno = new Turno();
        Thread[] hilos = new Thread[3];
        hilos[0] = new Thread(new Letra ('A', 1, turno));
        hilos[1] = new Thread(new Letra ('B', 2, turno));
        hilos[2] = new Thread(new Letra ('C', 3, turno));
        for(int i = 0; i < 3; i++) hilos[i].start();
    }
    
    public static void ejecutarEj4(){
        Service service = new Service();
        Thread[] hilos = new Thread[5];
        hilos[0] = new Thread(new Auto (service, 50), "Auto 1");
        hilos[1] = new Thread(new Auto (service, 125), "Auto 2");
        hilos[2] = new Thread(new Auto (service, 150), "Auto 3");
        hilos[3] = new Thread(new Auto (service, 250), "Auto 4");
        hilos[4] = new Thread(new Auto (service, 175), "Auto 5");
        for(int i = 0; i < 5; i++) hilos[i].start();
    }
}