package sistemabordadores;


import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class connectar {
    Connection conectar=null;
    Connection cn=null;
    String iplocal = ingresotienda.iplocal;
    String tiendalocal =ingresotienda.tiendalocal;
    
    
    
    
    
    public Connection conexion()
    {
        
   //     JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">host = '"+host+"'");
  // JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">base de datos = '"+tiendalocal+"'");
     
   
     

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection("jdbc:mysql://" + iplocal + "/" + tiendalocal + "", "root", "sistemas");
        } catch (Exception e) {

            System.out.println(e);

        }
        return conectar;
        //  return cn;
    }
    
}