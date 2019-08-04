/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Objetos;

import BD.cDatos;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Elioth
 */
public class Empleado extends Usuario{
    private String grado_estudios;
    private String especialidad;
    private String institucion;
    private String cedula;
    
    //Creación de un objeto empleado para registrar al cliente.
    public Empleado(String correo, String contraseña, int tipo) {
        super(correo, contraseña, tipo);
        this.correo=correo;
        this.contraseña=contraseña;
        this.tipo=tipo;
    }
    
    //Constructor normal para el empleado
    public Empleado(String correo, String contraseña, int tipo, String nombre, String apellido_p, String apellido_m) {
        super(correo, contraseña, tipo, nombre, apellido_p, apellido_m);
        this.correo=correo;
        this.contraseña=contraseña;
        this.tipo=tipo;
        this.nombre=nombre;
        this.apellido_p=apellido_p;
        this.apellido_m=apellido_m;        
    } 
    
    //Creación de un objeto empleado de manera normal.
    public Empleado(int id_usuario) {
        super(id_usuario);
        this.id_usuario=id_usuario;
    }
        
    //Método que se ejecuta en la logica para guardar a un doctor
    public int registrarDoctor(String grado_estudios, String especialidad, String institucion, String cedula){
        int valido=0;
        this.grado_estudios=grado_estudios;
        this.especialidad=especialidad;
        this.institucion=institucion;
        this.cedula=cedula;
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            int val=registrarUsuario(this.nombre, this.apellido_p, this.apellido_m);
            if(val==1){
                System.out.println("Registro correctamente al usuario");
                this.id_usuario=getId();
                ResultSet r=conexion.Consulta("call sp_AltaEmpleado('"+this.id_usuario+"', '"+this.grado_estudios+"', '"+this.especialidad+"', '"+this.institucion+"', '"+this.cedula+"');");
                if(r.next()){
                    valido=r.getInt("valido");
                    r.close();
                    conexion.CloseConexion();
                    System.out.println("Si entro al procedure de altaEmpleado");
                }else{
                    System.out.println("No entro al procedure de altaEmpleado");
                }
            }else{
                System.out.println("Imposible de registrar al usuario en primera instancia");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        
        return valido;
    }
    
    //Método para registrar a un admi
    public int registrarAdmi(){
        int valido=0;
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            int val=registrarUsuario(this.nombre, this.apellido_p, this.apellido_m);
            if(val==1){
                System.out.println("Registro correctamente al usuario");
                this.id_usuario=getId();
                ResultSet r=conexion.Consulta("call sp_AltaEmpleado('"+this.id_usuario+"', 'default', 'default', 'default', 'default');");
                if(r.next()){
                    valido=r.getInt("valido");
                    r.close();
                    conexion.CloseConexion();
                    System.out.println("Si entro al procedure de altaEmpleado");
                }else{
                    System.out.println("No entro al procedure de altaEmpleado");
                }
            }else{
                System.out.println("Imposible de registrar al usuario en primera instancia");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        
        return valido;
    }
    
    //Método para registrar a una secretaria.
    public int registrarSecretaria(){
        int valido=0;
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            int val=registrarUsuario(this.nombre, this.apellido_p, this.apellido_m);
            if(val==1){
                System.out.println("Registro correctamente al usuario");
                this.id_usuario=getId();
                ResultSet r=conexion.Consulta("call sp_AltaEmpleado('"+this.id_usuario+"', 'default', 'default', 'default', 'default');");
                if(r.next()){
                    valido=r.getInt("valido");
                    r.close();
                    conexion.CloseConexion();
                    System.out.println("Si entro al procedure de altaEmpleado");
                }else{
                    System.out.println("No entro al procedure de altaEmpleado");
                }
            }else{
                System.out.println("Imposible de registrar al usuario en primera instancia");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        
        return valido;
    }
    
    
    //Método para registrar a un doctor admi.
    public int registrarDoctorAdmi(String grado_estudios, String especialidad, String institucion, String cedula){
        int valido=0;
        this.grado_estudios=grado_estudios;
        this.especialidad=especialidad;
        this.institucion=institucion;
        this.cedula=cedula;
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            int val=registrarUsuario(this.nombre, this.apellido_p, this.apellido_m);
            if(val==1){
                System.out.println("Registro correctamente al usuario");
                this.id_usuario=getId();
                ResultSet r=conexion.Consulta("call sp_AltaEmpleado('"+this.id_usuario+"', '"+this.grado_estudios+"', '"+this.especialidad+"', '"+this.institucion+"', '"+this.cedula+"');");
                if(r.next()){
                    valido=r.getInt("valido");
                    r.close();
                    conexion.CloseConexion();
                    System.out.println("Si entro al procedure de altaEmpleado");
                }else{
                    System.out.println("No entro al procedure de altaEmpleado");
                }
            }else{
                System.out.println("Imposible de registrar al usuario en primera instancia");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        
        return valido;
    }

    public int registrarEnfermera(String grado_estudios, String especialidad, String institucion, String cedula) {
        int valido=0;
        this.grado_estudios=grado_estudios;
        this.especialidad=especialidad;
        this.institucion=institucion;
        this.cedula=cedula;
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            int val=registrarUsuario(this.nombre, this.apellido_p, this.apellido_m);
            if(val==1){
                System.out.println("Registro correctamente al usuario");
                this.id_usuario=getId();
                ResultSet r=conexion.Consulta("call sp_AltaEmpleado('"+this.id_usuario+"', '"+this.grado_estudios+"', '"+this.especialidad+"', '"+this.institucion+"', '"+this.cedula+"');");
                if(r.next()){
                    valido=r.getInt("valido");
                    r.close();
                    conexion.CloseConexion();
                    System.out.println("Si entro al procedure de altaEmpleado");
                }else{
                    System.out.println("No entro al procedure de altaEmpleado");
                }
            }else{
                System.out.println("Imposible de registrar al usuario en primera instancia");
            }
        }catch(SQLException e){
            System.err.println(e);
        }
        
        return valido;
    }
    
    
}
