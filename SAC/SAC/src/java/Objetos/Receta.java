/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import BD.cDatos;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Receta {
    private int id_usuario;
    private ArrayList medicamento=new ArrayList();
    private ArrayList duracion= new ArrayList();
    private ArrayList dosis = new ArrayList();
    private ArrayList hora=new ArrayList();
    private ArrayList Receta=new ArrayList();
    //Constructor de receta
    public Receta(int id_usuario){
        this.id_usuario=id_usuario;
    }
    public ArrayList getRecetas(){
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            ResultSet r=conexion.Consulta("call sp_ObtenerRecetas("+id_usuario+")");
           if(r.next()){
               if(r.getInt("id_receta")!=0){
                do{
                    Receta.add(duracion);
                    Receta.add(dosis);
                    Receta.add(medicamento);
                    Receta.add(hora);
                }while(r.next());
               }else{
                   System.out.print("No hay recetas");
               }
           }else{
               System.out.print("Error en el procedure");
           } 
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        
                return null;
    }
}
