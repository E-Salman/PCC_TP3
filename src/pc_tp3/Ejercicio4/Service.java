/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc_tp3.Ejercicio4;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class Service{
    
    public synchronized void cargarNafta() throws InterruptedException{
        System.out.println("El " + Thread.currentThread().getName() + " esta cargando nafta.");
        Thread.sleep(1000);          //Simula el tiempo que toma el Auto para cargar nafta
    }
}
