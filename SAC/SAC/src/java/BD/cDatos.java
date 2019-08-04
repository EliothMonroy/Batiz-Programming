/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package BD;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author LifeSoft
 */
public class cDatos {
    //Variables para la conexión a la base de datos
    private String usuario;
    private String password;
    private String url;
    private String DBdriver;
    private Connection con=null;
    private Statement st;
    
    public cDatos(String user, String pass, String url, String DBdriver){
        this.usuario=user;
        this.password=pass;
        this.url=url;
        this.DBdriver=DBdriver;
    }
    public cDatos(){
        this.usuario="root";
        this.password="n0m3l0";
        this.url="jdbc:mysql://127.0.0.1:3306/saclife";
        this.DBdriver="com.mysql.jdbc.Driver";
    }
    //Metodos para establecer la conexion inresando los valores desde afuera
    public void setUsuario(String Usuario){
        this.usuario=Usuario;
    }
    public void setPassword(String pass){
        this.password=pass;
    }
    public void setUrl(String url){
        this.url=url;
    }
    public void setDriver(String driver){
        this.DBdriver=driver;
    }
    public void setConnection(Connection Connection){
        this.con=Connection;
    }
    //------------Metodo para la Conexion---------
    public void Conexion() throws SQLException{
        try{
        Class.forName(this.DBdriver).newInstance();
        this.con=DriverManager.getConnection(this.url,this.usuario,this.password);
        }
        catch(Exception err)
        {
            System.out.println("Error " + err.getMessage());
        }
    }
    //------Cerrar la Conexion-------
    public void CloseConexion() throws SQLException{
        this.con.close();
    }
    /*-------Sentencias SQL-----------
        Consultas--->tipo ResultSet
        Bajas------->tipo ResultSet
        Altas------->tipo int
        Actualizar-->tipo void
    */
    public ResultSet Consulta(String consulta)  throws SQLException{
        this.st=(Statement) con.createStatement();
        return this.st.executeQuery(consulta);
    }
    public void actualizar(String actualiza) throws SQLException {
        this.st = (Statement) this.con.createStatement();
        st.executeQuery(actualiza);
    } 
    public ResultSet borrar(String borra) throws SQLException {
       this.st = (Statement) this.con.createStatement();
        return (ResultSet) st.executeQuery(borra);
    } 
    public int insertar(String inserta) throws SQLException {
        this.st = (Statement) this.con.createStatement();
        return st.executeUpdate(inserta);
    }
    
}
