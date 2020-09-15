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
    char[] ultimoTurno;    
    int proximoTurno;
    boolean imprimiendo;
    
    public Turno(){
        ultimoTurno = new char[3];
        ultimoTurno[0] = 'A';
        ultimoTurno[1] = 'B';
        ultimoTurno[2] = 'C';
        proximoTurno = 'A';
        imprimiendo = false;
    }
        
    public void enUso(){
        imprimiendo = !imprimiendo;
    }
    
    public void calcularProximoTurno(char letra){
        int auxLetra = 0;
        for(int i = 0; i < 2; i++){
            if(letra == ultimoTurno[i]) auxLetra = i;
        }
        if(auxLetra == 2) proximoTurno = 0;
        else proximoTurno = ultimoTurno[auxLetra + 1];
    }
    
    public boolean obtenerTurno(char letra){
        return (letra == proximoTurno && !imprimiendo);
    }
}