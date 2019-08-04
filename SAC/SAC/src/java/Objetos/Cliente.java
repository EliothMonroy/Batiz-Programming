/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import BD.cDatos;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LifeSoft
 */
public class Cliente {
    //Definiendo los atributos de nuestro cliente
    private int id_cliente;
    private String email;
    private String contra;
    private String nombre;
    private int tipo;
    private Date fecha_registro;
    private String direccion;
    private String telefono;
    private String logo;
    private String slogan;
    private int premium;
    
    //Cuando el cliente es creado, solicita estos datos.
    public Cliente(String email, String contra, String nombre, int tipo, String direccion, String telefono, String logo, String slogan){
          this.email=email;
          this.contra=contra;
          this.nombre=nombre;
          this.tipo=tipo;
          this.direccion=direccion;
          this.telefono=telefono;
          this.logo=logo;
          this.slogan=slogan;
    }
    //Método para registrar a un cliente.
    public int registrarCliente() throws SQLException{
        int val=-1;//-1 indica un error externo a la lógica.
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            //Registramos al cliente
            String consulta="call sp_AltaCliente('"+email+"','"+contra+"','"+nombre+"',"+tipo+",'"+direccion+"','"+telefono+"','"+logo+"','"+slogan+"');";
            ResultSet r=conexion.Consulta(consulta);
            if(r.next()){
                val=r.getInt("valido");
            }
            r.close();
            conexion.CloseConexion();
        }catch(Exception e){
            System.err.println(e);
            val=-1;//-1 indica un error externo a la lógica.
        }
        return val;
    }
    //Constructor para configuración.
    public Cliente(String email, String contra){
        this.email=email;
        this.contra=contra;
    }
    //Metodo que devuelve el tipo del usuario.
    public int getTipo(){
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            ResultSet r=conexion.Consulta("call sp_ConsultaCliente('"+this.email+"');");
            if(r.next()){
                this.tipo=r.getInt("tipo");
            }else{
                this.tipo=-1;
            }
            r.close();
            conexion.CloseConexion();
        }catch(Exception e){
            System.err.println(e);
            this.tipo=-1;
        }
        return this.tipo;
    }
    //Método que devuelve el nombre del servicio(Cliente).
    public String getNombre(){
        return nombre;
    }
    //Método para hacer nulo el al objeto cliente.
    public void limpiarCliente(){
        id_cliente=-1;
        email="";
        contra="";
        nombre="";
        tipo=-1;
        fecha_registro=null;
        direccion="";
        telefono="";
        logo="";
        slogan="";
        premium=-1;        
    }
}