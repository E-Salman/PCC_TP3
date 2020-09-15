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
import pc_tp3.Ejercicio2.VIDA;
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
        //1)
        /*VerificarCuenta vc = new VerificarCuenta();
        Thread Luis = new Thread(vc, "Luis");
        Thread Manuel = new Thread(vc, "Manuel");
        Thread Juan = new Thread(vc, "Juan");
        Luis.start();
        Manuel.start(); 
        Juan.start();/
        
        //2)
        /*VIDA vida = new VIDA();
        Orco orco = new Orco(vida);
        Curandero curandero = new Curandero(vida);
        Thread orcoHilo = new Thread(orco, "orco");
        Thread curanderoHilo = new Thread(curandero, "curandero");
        orcoHilo.start();
        curanderoHilo.start();
        try{
            orcoHilo.join();            //Los dos joins son para que el hilo main espere a que terminen sus ejecuciones 
            curanderoHilo.join();       //los dos hilos antes de imprimir la vida resultante final
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Vida resultante: " + vida.obtenerVida());*/
        
        //3)
        Turno turno = new Turno();
        Letra a,b,c;
        a = new Letra('A', 1, turno);
        b = new Letra('B', 2, turno);
        c = new Letra('C', 3, turno);
        Thread aHilo = new Thread(a, "A");
        Thread bHilo = new Thread(b, "B");
        Thread cHilo = new Thread(c, "C");
        aHilo.start();
        bHilo.start();
        cHilo.start();
        
        //4)
        /*Service service = new Service();
        Auto a1, a2, a3, a4, a5;
        a1 = new Auto(service, 50);
        a2 = new Auto(service, 125);
        a3 = new Auto(service, 150);
        a4 = new Auto(service, 250);
        a5 = new Auto(service, 175);
        Thread a1Hilo = new Thread(a1, "Auto 1");
        Thread a2Hilo = new Thread(a2, "Auto 2");
        Thread a3Hilo = new Thread(a3, "Auto 3");
        Thread a4Hilo = new Thread(a4, "Auto 4");
        Thread a5Hilo = new Thread(a5, "Auto 5");        
        a1Hilo.start();
        a2Hilo.start();
        a3Hilo.start();
        a4Hilo.start();
        a5Hilo.start();*/
    }    
}