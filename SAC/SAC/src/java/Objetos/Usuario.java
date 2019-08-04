/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Objetos;

import BD.cDatos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alumno
 */
public class Usuario{
    //Atributos de un usuario.
    int id_usuario=0;
    String contraseña="";
    int tipo=-1;
    String correo="";
    String nombre="";
    String apellido_p="";
    String apellido_m="";
    boolean estado;
    
    //Creación de un objeto usuario de manera normal.
    public Usuario(int id_usuario){
        this.id_usuario=id_usuario;
    }
    
    //Creación de un objeto usuario para registrar a un cliente
    public Usuario(String correo, String contraseña, int tipo){
        this.correo=correo;
        this.contraseña=contraseña;
        this.tipo=tipo;
    }
    
    //Constructor normal para el registro de un usuario.
    public Usuario(String correo, String contraseña, int tipo, String nombre, String apellido_p, String apellido_m){
        this.correo=correo;
        this.contraseña=contraseña;
        this.tipo=tipo;
        this.nombre=nombre;
        this.apellido_p=apellido_p;
        this.apellido_m=apellido_m;
    }
    
    //Método para obtener las recetas de un paciente.
    public ArrayList obtenerRecetas(){
        return null;
    }
    
    //Método para registrar a un Usuario(Sirve para registrar a una clinica como usuario)
    public int registrarUsuario(){
        int valido=0;
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            ResultSet r=conexion.Consulta("call sp_ConsultaCliente('"+this.correo+"');");//Obteniendo datos del cliente.
            if(r.next()){
                this.nombre=r.getString("nombre_cliente");
                this.apellido_p=r.getString("nombre_cliente");
                this.apellido_m=r.getString("nombre_cliente");
                r.close();
                r=conexion.Consulta("call sp_AltaUsuario('"+this.contraseña+"', "+this.tipo+", '"+this.correo+"', '"+this.nombre+"', '"+this.apellido_p+"', '"+this.apellido_m+"');");
                if(r.next()){
                    valido=r.getInt("valido");
                    r.close();
                    conexion.CloseConexion();
                }
            }else{
                System.out.println("Procedure sp_ConsultaCliente no encontro al cliente :/");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return valido;
    }
    
    //Método para registrar a un empleado de manera normal.
    public int registrarUsuario(String nombre, String paterno, String materno){
        int valido=0;
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            this.nombre=nombre;
            this.apellido_p=paterno;
            this.apellido_m=materno;
            ResultSet r=conexion.Consulta("call sp_AltaUsuario('"+this.contraseña+"', "+this.tipo+", '"+this.correo+"', '"+this.nombre+"', '"+this.apellido_p+"', '"+this.apellido_m+"');");
            if(r.next()){
                valido=r.getInt("valido");
                r.close();
                conexion.CloseConexion();
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        return valido;
    }
    
    //Método para obtener el id del usuario.
    public int getId() {
        if(this.id_usuario==0){
            cDatos conexion=new cDatos();
            try{
                conexion.Conexion();
                ResultSet r=conexion.Consulta("call sp_ConsultaUsuario('"+this.correo+"')");
                if(r.next()){
                    System.out.println("Método getId si encontro al usuario");
                    this.id_usuario=r.getInt("id_usuario");
                }else{
                    System.out.println("Método getId no encontro nada ");
                }
            }catch(SQLException e){
                System.err.println(e);
            }
        }else{
            System.out.println("ID del usuario no es cero");
        }        
        return this.id_usuario;
    }    
}
