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
  
    
    
    public Connection conexion(){
      String strIP = ""; 
      String strBD = ""; 
        
        File file = new File("C:\\sistema\\configuracion.txt");
try
{
    Scanner sc = new Scanner(file);
    while(sc.hasNext())
    {
        String line = sc.nextLine();
        String str[] = line.split(":");
        strIP = str[0]; 
        strBD = str[1]; 
    }
}catch(IOException e)
 {
    System.out.println(e);
 }
        

String host=strIP;
String basedatos=strBD; 
        
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
  
      conectar=DriverManager.getConnection("jdbc:mysql://"+host+"/"+basedatos+"","root","sistemas");
                      
        } catch (Exception e) {
            
            System.out.println(e);
        
        }
        return conectar;
      //  return cn;
    }
    
}