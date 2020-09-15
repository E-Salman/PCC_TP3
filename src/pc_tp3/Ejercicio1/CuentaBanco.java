/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc_tp3.Ejercicio1;

/**
 *
 * @author Admin
 */
public class CuentaBanco {
    private int balance = 100;
    
    public int getBalance(){
        return balance;
    }
        
    public synchronized void retiroBancario(int retiro, CuentaBanco cb) throws InterruptedException{
        if(cb.getBalance() >= retiro){
            System.out.println(Thread.currentThread().getName() + " esta realizando un retiro de: " + retiro + ".");
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
