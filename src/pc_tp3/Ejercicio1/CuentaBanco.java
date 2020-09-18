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
public class CuentaBanco {
    private int balance = 50;
    
    public int getBalance(){
        return balance;
    }
        
    public synchronized void retiroBancario(int retiro, CuentaBanco cb){        //Todo el metodo tiene que estar sincronizado porque si se hace o no la operacion depende de una variable 
        if(cb.getBalance() >= retiro){                                                                      //que puede ser modificada dentro del metodo
            System.out.println(Thread.currentThread().getName() + " esta realizando un retiro de: " + retiro + ".");
            try {
                Thread.sleep(2000);             //Simula el tiempo que toma la transaccion
            } catch (InterruptedException ex) {
                Logger.getLogger(CuentaBanco.class.getName()).log(Level.SEVERE, null, ex);
            }
            balance = balance - retiro;           
            System.out.println(Thread.currentThread().getName() + ": Retiro realizado.");
            System.out.println(Thread.currentThread().getName() + ": Los fondos son de: " + cb.getBalance());
        }
        else{
            System.out.println(Thread.currentThread().getName() + " No hay suficiente dinero en la cuenta para realizar el retiro Sr." + Thread.currentThread().getName());
            System.out.println("Su saldo actual es de: " + cb.getBalance());
        }
    }
}
