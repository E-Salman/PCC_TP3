/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc_tp3.Ejercicio4;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Auto extends Vehiculo{
    String patente, modelo, marca;
    double kmFaltantesParaElService;        //Cantidad de kilometros restantes para cargar nafta
    boolean cargoNafta;                     //Indica si el Auto cargo nafta o no
    Service proximoService;                 //Recurso compartido
    
    public Auto(Service service, double kmFaltantes){
        cargoNafta = false;
        proximoService = service;
        kmFaltantesParaElService = kmFaltantes;
    }    
    
    public void run(){
        recorrer();
    }
    
    public void recorrer(){
        double auxKm;
        while(!cargoNafta){                     //Mientras que no haya cargado nafta, el auto sigue avanzando
            auxKm = new Random().nextInt(30);   //Simula la cantidad de kilometros que avanzara el Auto
            try {
                Thread.sleep(2000);             //Simula el tiempo que se toma el auto en recorrer los kilometros.            
                if(auxKm <= kmFaltantesParaElService){
                    System.out.println("El " + Thread.currentThread().getName() + " avanza " + auxKm + " KM");
                }
                else{
                    System.out.println("El " + Thread.currentThread().getName() + " llego a la estacion.");
                }
                kmFaltantesParaElService = kmFaltantesParaElService - auxKm;
                if(0 >= kmFaltantesParaElService){  //Si llego a la estacion, carga nafta
                    proximoService.cargarNafta();
                    System.out.println("El " + Thread.currentThread().getName() + " termino de cargar nafta.");
                    cargoNafta = true;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
           }            
        }                
    }
}