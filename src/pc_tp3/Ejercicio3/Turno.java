/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pc_tp3.Ejercicio3;

/**
 *
 * @author Admin
 */
public class Turno {
    int proximoTurno;       //Indica de que letra es el proximo turno
    
    public Turno(){
        proximoTurno = 65;      //Valor de 'A' en ascii
    }
    
    public void calcularProximoTurno(char letra){
        if((int)letra == 67) proximoTurno = 65;     //67 es el valor de 'C' en ascii, si es mayor, vuelve al valor de 'A'
        else proximoTurno++;                        //Se calcula de quien sera el proximo turno en base al actual, si es 'C', vuelve a 'A'
    }
    
    public boolean obtenerTurno(char letra){        //Verifica si le toca el turno a la letra actual 
        return ((int)letra == proximoTurno);
    }
}