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
 * @author Elioth
 */
public class Paciente extends Usuario{
    private String curp;
    private String nacimiento;
    private int sexo;
    private String sangre;
    public Paciente(String correo, String contraseña, int tipo, String nombre, String apellido_p, String apellido_m) {
        super(correo, contraseña, tipo, nombre, apellido_p, apellido_m);
        this.correo=correo;
        this.contraseña=contraseña;
        this.tipo=tipo;
        this.nombre=nombre;
        this.apellido_p=apellido_p;
        this.apellido_m=apellido_m;
    }
    public int registrarPaciente(String curp, String nacimiento , int sexo, String sangre) {
        int valido=0;
        this.curp=curp;
        this.nacimiento=nacimiento;
        this.sexo=sexo;
        this.sangre=sangre;
        cDatos conexion=new cDatos();
        try{
            conexion.Conexion();
            int val=registrarUsuario(this.nombre, this.apellido_p, this.apellido_m);
            if(val==1){
                System.out.println("Registro correctamente al usuario");
                this.id_usuario=getId();
                ResultSet r=conexion.Consulta("call sp_AltaPaciente('"+this.id_usuario+"', '"+this.curp+"', "+this.nacimiento+", "+this.sexo+", '"+this.sangre+"');");
                if(r.next()){
                    valido=r.getInt("valido");
                    r.close();
                    conexion.CloseConexion();
                    System.out.println("Si entro al procedure de altaPaciente");
                }else{
                    System.out.println("No entro al procedure de altaPaciente");
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
