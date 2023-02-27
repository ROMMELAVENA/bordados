package sistemabordadores;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class connectar {
    Connection conectar=null;
    Connection cn=null;
    String host = ingresotienda.strIP;
    String basedatos =ingresotienda.strBD;
    
    
    public Connection conexion()
    {
     

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://" + host + "/" + basedatos + "", "root", "sistemas");
        } catch (Exception e) {

            System.out.println(e);

        }
        return conectar;
        //  return cn;
    }
    
}