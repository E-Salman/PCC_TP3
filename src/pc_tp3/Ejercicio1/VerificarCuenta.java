/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc_tp3.Ejercicio1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class VerificarCuenta implements Runnable{
    
    private CuentaBanco cb = new CuentaBanco(); //Recurso compartido
    
    private void hacerRetiro(int cantidad){
        cb.retiroBancario(cantidad, cb);
    }
    
    public void run(){
        for(int i = 0; i <= 3; i++){
            this.hacerRetiro(10);
            if(cb.getBalance() < 0){
                System.out.println("La cuenta esta sobregirada.");
            }
        }
    }
}
