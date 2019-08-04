/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

/**
 *
 * @author Alumno
 */
public class cValidacion {
    String cadena="";
    int valido=0;
    public cValidacion(String cadena){
        this.cadena=cadena;
    }
    public int validar(){
        
           if(cadena.contains("/")||cadena.contains("<")||cadena.contains(">")||cadena.contains("\\")||cadena.contains("'")||cadena.contains("+")||cadena.contains("|")){
                valido=0;
            }else{
               valido=1;
           }
        return valido;
    }
}
