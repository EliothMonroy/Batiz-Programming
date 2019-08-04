/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Logica;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

/**
 *
 * @author JuanDaniel
 */
public class cSeguridad {
    String estado="";
    int port=1111;
        //Metodo para conexion al server
        public void cliente(String estado) throws IOException{
            //Conexion al servidor
            Socket cliente= new Socket("localhost",port);
            //Cadena de entrada
            OutputStream salida=cliente.getOutputStream();
            DataOutputStream cadenaSalida= new DataOutputStream(salida);
            cadenaSalida.writeUTF(estado);
           
        }
}
