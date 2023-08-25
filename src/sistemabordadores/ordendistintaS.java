package sistemabordadores;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static sistemabordadores.ordenparcheS.lbcliente;

public class ordendistintaS extends javax.swing.JFrame {

    public static boolean ventanaordencamisaanteriores = false;
    public static String ordenbordadocamisa = "";
    public static String esponchado ="";

    String bordadosdisponiblesstring = "0";
    int bordadosdisponiblesint = 0;
    String cantidadprendasstring = "";
    int cantidadprendasint = 0;
    String cantidad = "";
    
     String cliente = "";
    int remanentebordadosint = 0;
    String remanentebordadosstring = "";
    int nuevoremanentebordadosint = 0;
    String nuevoremanentebordadossstring = "";
     String ubicacionfecha = "";
     String ubicacioncantidad = "";
     String consecutivo = "";
    String nuevoestatusorden = "";
    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;

    String nuevosbordadosutilizadosstring = "";
    int nuevosbordadosutilizadosint = 0;
    
    String identificador = "";
    String rutadelip = "";
    String primero = "";
    String ultimo = "";
    String iplocal = principal.lbiplocal.getText();
    int traspaso = 0;
    String ipsucursal = "";
   

    String numerosucursal = "";
    String sucursal = "";
    String numerosolicitoarticulos = "";
  
    String numeroordenenvio = "";
    String tiendaordenenvio = "";
   String tiendalocal = principal.tiendalocal;
    String codigocliente = "";
    String lugar = "";
    String prenda ="";
    
     String numeroordendebordadolocalorecibida = "";

    String tiendaconectada = "si";
    Connection cnsucursal = null;
    
    
    ///// para insertar
    
    String descripcion = ""; 
    String descripcionaplicacon = "";
    
    
    String distinta1 = "ninguno";
    String distinta2 = "ninguno";
    String distinta3 = "ninguno";
    String distinta4 = "ninguno";
    String distinta5 = "ninguno";
    String distinta6 = "ninguno";
    String distinta7 = "ninguno";
    
    
    String distinta1nombre = "ninguno";
    String distinta2nombre = "ninguno";
    String distinta3nombre = "ninguno";
    String distinta4nombre = "ninguno";
    String distinta5nombre = "ninguno";
    String distinta6nombre = "ninguno";
    String distinta7nombre = "ninguno";
    
    String distinta1aplicacion = "ninguno";
    String distinta2aplicacion = "ninguno";
    String distinta3aplicacion = "ninguno";
    String distinta4aplicacion = "ninguno"; 
    String distinta5aplicacion = "ninguno";
    String distinta6aplicacion = "ninguno";
    String distinta7aplicacion = "ninguno";
    
    String distinta1ubicacion = "ninguno";
    String distinta2ubicacion = "ninguno";
    String distinta3ubicacion = "ninguno";
    String distinta4ubicacion = "ninguno"; 
    String distinta5ubicacion = "ninguno";
    String distinta6ubicacion = "ninguno";
    String distinta7ubicacion = "ninguno";
    
    String distinta1cantidad = "0";
    String distinta2cantidad = "0";
    String distinta3cantidad = "0";
    String distinta4cantidad = "0"; 
    String distinta5cantidad = "0";
    String distinta6cantidad = "0";
    String distinta7cantidad = "0";
    
    String tipoprenda = "";
    String estatusorden = "";
    String numerodeventa = "";
    String cantidadaplicacion = "";
    
    String rutaimagen = "";
    String rutamangaderecha= "";
    String rutamangaizquierda= "";
    String rutapechoizquierdo= "";
    String rutapechoderecho= "";
    String rutaespalda= "";
    int botonesactivados = 0;
    
    String rutaarchivo = "";
    String  nombrearchivo = "";
    public static String ordencamisaautorizacion = "";
    public static String enquesucursalsebordara ="";
    public static String tipotabla ="";
    String nombredelatabla ="";
   
    String terminetodo = "";
    String tienefotomontaje = "";
    String tieneunaobservacion = "";
    
    
         String botonhabilitado1 = "si";
        String botonhabilitado2 = "si";
        String botonhabilitado3 = "si";
        String botonhabilitado4 = "si";
        String botonhabilitado5 = "si";
        String botonhabilitado6 = "si";
        String botonhabilitado7 = "si";
        
        
    String cantidaddistinta1 = "";
    String cantidaddistinta2 = "";
    String cantidaddistinta3 = "";
    String cantidaddistinta4 = "";
    String cantidaddistinta5 = "";
    String cantidaddistinta6 = "";
    String cantidaddistinta7 = "";
        
        
    
    ArrayList<String> listabotones = new ArrayList<String>();
    
    
    
       public static final Color anaranjado = new Color(255,166,77);

    

    public ordendistintaS() {
        initComponents();
        ventanaordencamisaanteriores = true;

             
        lbtipo.setVisible(false);
         lbautorizacion.setVisible(false);
        lbtitulo.setVisible(false);
        btneliminar.setVisible(false);
        
        
       btnterminetodo.setEnabled(false);
       
       
       
       btndistinta1cancelar.setEnabled(false);
       btndistinta2cancelar.setEnabled(false);
       btndistinta3cancelar.setEnabled(false);
       btndistinta4cancelar.setEnabled(false);
       btndistinta5cancelar.setEnabled(false);
       btndistinta6cancelar.setEnabled(false);
       btndistinta7cancelar.setEnabled(false);
       
       
    
        
    }

    
    
    
    void datos(){
        
        
        
         if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
        
        nombredelatabla = "historial_ordenes_distinta";
        
     try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordendistintaS.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     codigocliente();
     
     hilosycolor();
     
     try {    
            cargarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordendistintaS.class.getName()).log(Level.SEVERE, null, ex);
        }

      
     
        
        
    } 
    
    
     AudioClip sonido;
      if(tieneunaobservacion.equals("si"))
        {
            sonido= java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/tienesunaobservacion.wav"));    
            sonido.play();
            
        }
    
     
      
       String observacion = lbobservaciones.getText();
        
        if (observacion.equals(""))
        {
            
        }
        else
        {
         
       
String[] lineas = observacion.split("\n");

String mensaje = "<HTML><span style=\"Color:red;font-size:25px;\">NOTA: " + lineas[0] + "</span><br>";
if (lineas.length > 1) {
    mensaje += "<span style=\"Color:red; font-size:25px;\">" + lineas[1] + "</span>";
}

JOptionPane.showMessageDialog(null, mensaje);



        }

        
        
        
    }
    
    
    
    
    void datostiendalocal() throws IOException {

        numeroordendebordadolocalorecibida = lborden.getText();
        
        datosdepedidosyenvios();

        String sql = "Select codigo,tipo,estatus_orden,numero,numero_venta,fecha,hora,cliente,nombre_comercial,borda_cliente,tipo,identificador_prenda,estatus_orden,estatus_entrega,articulo,cantidad,prenda,cantidad_bordados,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,\n" +
"	   distinta1,distinta1_ubicacion,distinta1_nombre,distinta1_cantidad,distinta1_aplicacion,distinta1_aplicacion_color,\n" +
"	   distinta2,distinta2_ubicacion,distinta2_nombre,distinta2_cantidad,distinta2_aplicacion,distinta2_aplicacion_color, \n" +
"	   distinta3,distinta3_ubicacion,distinta3_nombre,distinta3_cantidad,distinta3_aplicacion,distinta3_aplicacion_color, \n" +
"	   distinta4,distinta4_ubicacion,distinta4_nombre,distinta4_cantidad,distinta4_aplicacion,distinta4_aplicacion_color, \n" +
"	   distinta5,distinta5_ubicacion,distinta5_nombre,distinta5_cantidad,distinta5_aplicacion,distinta5_aplicacion_color,\n" +
"	   distinta6,distinta6_ubicacion,distinta6_nombre,distinta6_cantidad,distinta6_aplicacion,distinta6_aplicacion_color,\n" +
"	   distinta7,distinta7_ubicacion,distinta7_nombre,distinta7_cantidad,distinta7_aplicacion,distinta7_aplicacion_color,\n" +
"	   lugar,fotomontaje_autorizado from historial_ordenes_distinta where numero = '"+numeroordendebordadolocalorecibida+"'  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
            {

                 cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
                lbnombrecomercial.setText( rs.getString("nombre_comercial"));
                
                lbbordacliente.setText( rs.getString("borda_cliente"));
                
                lbprenda.setText(rs.getString("prenda"));
                prenda = (rs.getString("prenda"));
                lbfechaelaboracion.setText(rs.getString("fecha"));

                
                tipoprenda = rs.getString("tipo");
           
                
                
                
                 estatusorden = rs.getString("estatus_orden");
                 lbestatus.setText(estatusorden);
                
                if(estatusorden.equals("realizada totalmente"))
                {
                  btnterminetodo.setEnabled(false);
                  lbestatus.setForeground(Color.green.darker());
               
                  
                  
                }
                else
                {
                   btnterminetodo.setEnabled(true); 
                    btnterminetodo.setEnabled(true);
                   
                   
                  if(estatusorden.equals("realizada parcialmente"))
                  {
                      
                       lbestatus.setForeground(anaranjado);
                      
                  }
                  else
                  {
                      lbestatus.setForeground(Color.red);
                  }
                   
                   
                   
                   
                   
                }   
                
                String observacion = rs.getString("observacion");
                
                if(observacion == null || observacion.equals("")||observacion.equals(" ") )
                {
                    
                }
                else
                {
                
                 
                tieneunaobservacion="si";    
                lbobservaciones.setText(observacion);
                
                }
                
                
                
                distinta1cantidad =rs.getString("distinta1_cantidad");
                distinta2cantidad =rs.getString("distinta2_cantidad");         
                distinta3cantidad =rs.getString("distinta3_cantidad"); 
                distinta4cantidad =rs.getString("distinta4_cantidad");
                distinta5cantidad =rs.getString("distinta5_cantidad");
                distinta6cantidad =rs.getString("distinta6_cantidad");
                distinta7cantidad =rs.getString("distinta7_cantidad");
               
                
                
                
                
                
                
                distinta1nombre = rs.getString("distinta1_nombre");
                distinta1ubicacion = rs.getString("distinta1_ubicacion");
                
                lbdistinta1nombre.setText(distinta1nombre);
                lbdistinta1.setText(distinta1);
              
                
                
                if (distinta1 == null || distinta1.equals("")||distinta1.equals(" ")) 
                {

                   
                    botonhabilitado1 = "no";
                    
                    btndistinta1ponnchado.setEnabled(false);
                    

                }
                
                
                else
                {
                    
                    distinta1 = rs.getString("distinta1");
                    
                    botonhabilitado1 = "si";
                    
                    btndistinta1ponnchado.setEnabled(true);
                    
                }
                  

                
                
                distinta2nombre = rs.getString("distinta2_nombre");
                distinta2= rs.getString("distinta2");
                lbdistinta2nombre.setText(distinta2nombre);
                lbdistinta2.setText(distinta2);
                
                
                
                
               if (distinta2 == null || distinta2.equals("")||distinta2.equals(" ")) 
                {

                   
                    botonhabilitado2 = "no";
                    
                    btndistinta2ponnchado.setEnabled(false);
                    

                }
                
                
                else
                {
                    
                    distinta2 = rs.getString("distinta2");
                    
                    botonhabilitado2 = "si";
                    
                    btndistinta2ponnchado.setEnabled(true);
                    
                }
                
                
                distinta3nombre = rs.getString("distinta3_nombre");
                distinta3 = rs.getString("distinta3");
                
                
                
                lbdistinta3nombre.setText(distinta3nombre);
                lbdistinta3.setText(distinta3);
                
                
                
                
                
                
                if (distinta3 == null || distinta3.equals("")||distinta3.equals(" ")) 
                {

                   
                    botonhabilitado3 = "no";
                    
                    btndistinta3ponnchado.setEnabled(false);
                    

                }
                
                
                else
                {
                    
                    distinta3 = rs.getString("distinta3");
                    
                    botonhabilitado3 = "si";
                    
                    btndistinta3ponnchado.setEnabled(true);
                    
                }
                
                

                distinta4nombre = rs.getString("distinta4_nombre");
                distinta4 = rs.getString("distinta4");
                lbdistinta4nombre.setText(distinta4nombre);
                lbdistinta4.setText(distinta4);
               
                
                
                
                if (distinta4 == null || distinta4.equals("")||distinta4.equals(" ")) 
                {

                   
                    botonhabilitado4 = "no";
                    
                    btndistinta4ponnchado.setEnabled(false);
                    

                }
                
                
                else
                {
                    
                    distinta4 = rs.getString("distinta4");
                    
                    botonhabilitado4 = "si";
                    
                    btndistinta4ponnchado.setEnabled(true);
                    
                }
                
                
                

                distinta5nombre = rs.getString("distinta5_nombre");
                distinta5 = rs.getString("distinta5");
                lbdistinta5nombre.setText(distinta5nombre);
                lbdistinta5.setText(distinta5);
              
                
                
                
               if (distinta5 == null || distinta5.equals("")||distinta5.equals(" ")) 
                {

                   
                    botonhabilitado5 = "no";
                    
                    btndistinta5ponnchado.setEnabled(false);
                    

                }
                
                
                else
                {
                    
                    distinta5 = rs.getString("distinta5");
                    
                    botonhabilitado5 = "si";
                    
                    btndistinta5ponnchado.setEnabled(true);
                    
                }
                
                
                
                


                distinta6nombre = rs.getString("distinta6_nombre");
                distinta6 = rs.getString("distinta6");
                lbdistinta6nombre.setText(distinta6nombre);
                lbdistinta6.setText(distinta6);
               
                
                
                
                
                if (distinta6 == null || distinta6.equals("")||distinta6.equals(" ")) 
                {

                   
                    botonhabilitado6 = "no";
                    
                    btndistinta6ponnchado.setEnabled(false);
                    

                }
                
                
                else
                {
                    
                    distinta6 = rs.getString("distinta6");
                    
                    botonhabilitado6 = "si";
                    
                    btndistinta6ponnchado.setEnabled(true);
                    
                }
                
                
                
                

                distinta7nombre = rs.getString("distinta7_nombre");
                distinta7 = rs.getString("distinta7");
                lbdistinta7nombre.setText(distinta7nombre);
                lbdistinta7.setText(distinta7);
            
               
                
                
                
                if (distinta7 == null || distinta7.equals("")||distinta7.equals(" ")) 
                {

                   
                    botonhabilitado7 = "no";
                    
                    btndistinta7ponnchado.setEnabled(false);
                    

                }
                
                
                else
                {
                    
                    distinta7 = rs.getString("distinta7");
                    
                    botonhabilitado7 = "si";
                    
                    btndistinta7ponnchado.setEnabled(true);
                    
                }
                
                
                
                
                
                
                
                
                
                
                
               distinta1aplicacion = rs.getString("distinta1_aplicacion");

               
               
               
               
               if (distinta1aplicacion.equals("ninguno")) {
                    distinta1aplicacion = "";
                }

                 distinta2aplicacion = rs.getString("distinta2_aplicacion");

                if (distinta2aplicacion.equals("ninguno")) {
                    distinta2aplicacion = "";
                }

                 distinta3aplicacion = rs.getString("distinta3_aplicacion");

                if (distinta3aplicacion.equals("ninguno")) {
                    distinta3aplicacion = "";
                }

                 distinta4aplicacion = rs.getString("distinta4_aplicacion");

                if (distinta4aplicacion.equals("ninguno")) {
                    distinta4aplicacion = "";
                }

                distinta5aplicacion = rs.getString("distinta5_aplicacion");

                if (distinta5aplicacion.equals("ninguno")) {
                    distinta5aplicacion = "";
                }

                
                  distinta6aplicacion = rs.getString("distinta6_aplicacion");

                if (distinta6aplicacion.equals("ninguno")) {
                    distinta6aplicacion = "";
                }

                
                distinta7aplicacion = rs.getString("distinta7_aplicacion");

                if (distinta7aplicacion.equals("ninguno")) {
                    distinta7aplicacion = "";
                } 

                
                lbcantidad.setText(rs.getString("cantidad"));
                identificador = rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);  
                lugar = rs.getString("lugar");
                
                
                
                
                if(lugar.equals("Esta sucursal"))
                {
                
                
                    lbsucursal.setEnabled(false);
                    
                    
                    
                 
                    
                    
                    
                    
                    
                    
                    
                    
                    
                if( botonhabilitado1.equals("si") )
                {
                  
                   
                   
                   
       
                   if(cantidaddistinta1.equals("0"))
                   {
                       
                       
                   listabotones.add("btndistinta1");
                   
                    btndistinta1termine.setEnabled(true);
                    btndistinta1cancelar.setEnabled(false);
                     
                   
                     lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
                    
                       
                   
                   
                   }
                   
                   else
                   {
                       
                        btndistinta1cancelar.setEnabled(true);
                   btndistinta1termine.setEnabled(false);  
                   
                     lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());
                      
                       
                   }
                  
                }
                else
                {
                    
                 btndistinta1termine.setEnabled(false);
               
                  
                
                } 
                       
                    
                    
                    
                
                
                
                
                
                
                //2
                     
                if( botonhabilitado2.equals("si") )
                {
                  
                   
                   
                   
       
                   if(cantidaddistinta2.equals("0"))
                   {
                       
                       
                   listabotones.add("btndistinta2");
                   
                    btndistinta2termine.setEnabled(true);
                    btndistinta2cancelar.setEnabled(false);
                     
                   
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                       
                   
                   
                   }
                   
                   else
                   {
                       
                        btndistinta2cancelar.setEnabled(true);
                   btndistinta2termine.setEnabled(false);  
                   
                     lbcantidad2.setText(cantidad);
                   lbcantidad2.setForeground(Color.GREEN.darker());
                      
                       
                   }
                  
                }
                else
                {
                    
                 btndistinta2termine.setEnabled(false);
               
                  
                
                } 
                       
               
                
                
                
                
                
                
                
                
                
                
                
                ///3
                
                     
                if( botonhabilitado3.equals("si") )
                {
                  
                   
                   
                   
       
                   if(cantidaddistinta3.equals("0"))
                   {
                       
                       
                   listabotones.add("btndistinta3");
                   
                    btndistinta3termine.setEnabled(true);
                    btndistinta3cancelar.setEnabled(false);
                     
                   
                     lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                    
                       
                   
                   
                   }
                   
                   else
                   {
                       
                        btndistinta3cancelar.setEnabled(true);
                   btndistinta3termine.setEnabled(false);  
                   
                     lbcantidad3.setText(cantidad);
                   lbcantidad3.setForeground(Color.GREEN.darker());
                      
                       
                   }
                  
                }
                else
                {
                    
                 btndistinta3termine.setEnabled(false);
               
                  
                
                } 
                       
               
                
                
                
                
                
                
                ///4
                
                     
                if( botonhabilitado4.equals("si") )
                {
                  
                   
                   
                   
       
                   if(cantidaddistinta4.equals("0"))
                   {
                       
                       
                   listabotones.add("btndistinta4");
                   
                    btndistinta4termine.setEnabled(true);
                    btndistinta4cancelar.setEnabled(false);
                     
                   
                     lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                    
                       
                   
                   
                   }
                   
                   else
                   {
                       
                        btndistinta4cancelar.setEnabled(true);
                   btndistinta4termine.setEnabled(false);  
                   
                     lbcantidad4.setText(cantidad);
                   lbcantidad4.setForeground(Color.GREEN.darker());
                      
                       
                   }
                  
                }
                else
                {
                    
                 btndistinta4termine.setEnabled(false);
               
                  
                
                } 
                       
               
                
                
                
                
                
                
                
                
                //5
                
                     
                if( botonhabilitado5.equals("si") )
                {
                  
                   
                   
                   
       
                   if(cantidaddistinta5.equals("0"))
                   {
                       
                       
                   listabotones.add("btndistinta5");
                   
                    btndistinta5termine.setEnabled(true);
                    btndistinta5cancelar.setEnabled(false);
                     
                   
                     lbcantidad5.setText("0");
                    lbcantidad5.setForeground(Color.red.darker());
                    
                       
                   
                   
                   }
                   
                   else
                   {
                       
                        btndistinta5cancelar.setEnabled(true);
                   btndistinta5termine.setEnabled(false);  
                   
                     lbcantidad5.setText(cantidad);
                   lbcantidad5.setForeground(Color.GREEN.darker());
                      
                       
                   }
                  
                }
                else
                {
                    
                 btndistinta5termine.setEnabled(false);
               
                  
                
                } 
                       
               
                
                
                
                
                
                
                
                //6
                
                     
                if( botonhabilitado6.equals("si") )
                {
                  
                   
                   
                   
       
                   if(cantidaddistinta6.equals("0"))
                   {
                       
                       
                   listabotones.add("btndistinta6");
                   
                    btndistinta6termine.setEnabled(true);
                    btndistinta6cancelar.setEnabled(false);
                     
                   
                     lbcantidad6.setText("0");
                    lbcantidad6.setForeground(Color.red.darker());
                    
                       
                   
                   
                   }
                   
                   else
                   {
                       
                        btndistinta6cancelar.setEnabled(true);
                   btndistinta6termine.setEnabled(false);  
                   
                     lbcantidad6.setText(cantidad);
                   lbcantidad6.setForeground(Color.GREEN.darker());
                      
                       
                   }
                  
                }
                else
                {
                    
                 btndistinta6termine.setEnabled(false);
               
                  
                
                } 
                       
               
                
                
                
                
                
                
                
                //7
                
                
                     
                if( botonhabilitado7.equals("si") )
                {
                  
                   
                   
                   
       
                   if(cantidaddistinta7.equals("0"))
                   {
                       
                       
                   listabotones.add("btndistinta7");
                   
                    btndistinta7termine.setEnabled(true);
                    btndistinta7cancelar.setEnabled(false);
                     
                   
                     lbcantidad7.setText("0");
                    lbcantidad7.setForeground(Color.red.darker());
                    
                       
                   
                   
                   }
                   
                   else
                   {
                       
                        btndistinta7cancelar.setEnabled(true);
                   btndistinta7termine.setEnabled(false);  
                   
                     lbcantidad7.setText(cantidad);
                   lbcantidad7.setForeground(Color.GREEN.darker());
                      
                       
                   }
                  
                }
                else
                {
                    
                 btndistinta7termine.setEnabled(false);
               
                  
                
                } 
                       
               
                    
                    
                    
                    
                    
                    
                    
                
                
                
                
                
                }
                else
                {
                    
                    lbsucursal.setEnabled(true);
                    
                }
                
                

            
            
            
            }

        } catch (SQLException ex) 
        {
             
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }


    }
    
    
    
    
    
    
    
    
    
    
    
    
     void codigocliente()
    {
        
        numerodeventa = lbnumerodeventa.getText();
        
        
        String sql = "SELECT codigo_cliente FROM historial_ventas WHERE numero = '" + lbnumerodeventa.getText() + "' ";


        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                
               codigocliente = rs.getString("codigo_cliente");
                
            }


        } catch (SQLException ex) {
            System.out.println (ex);
        }
    }

  
    
    
    void cargarfotomontaje() throws FileNotFoundException, IOException  
    {
        
      
        identificador =lbidentificador.getText();
        BufferedImage img = null;
        
        btnverfotomontaje.setEnabled(false);

       String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and prenda_especial = 'DISTINTA'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                Blob blob = rs.getBlob("imagen");
                if (blob == null) 
                {

                    ordencamisaimagencontorno p = new ordencamisaimagencontorno();
                    jPanel1.add(p);
                    jPanel1.repaint();
                    lbfotomontaje.setVisible(false);
                    btnverfotomontaje.setEnabled(false);
                    tienefotomontaje = "no";
                  
                    
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
                    
                } 
                
                else 
                
                {
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) 
                    {
                      
                      JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");

                    }

                    if(img==null)
                    {
                       tienefotomontaje = "no"; 
                    }
                    else
                    {
                    
                    Imagen imagen = new Imagen();
                    imagen.setImagen(img);
                    lbfotomontaje.setIcon(new ImageIcon(img.getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT)));
                    lbfotomontaje.setVisible(true);
                    btnverfotomontaje.setEnabled(true);
                    tienefotomontaje = "si";
                    btnverfotomontaje.setEnabled(true);
               

                    Blob archivo = rs.getBlob("imagen");
                    String nombredelarchivo = rs.getString("extension_imagen");
                     if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                    rutaimagen = "C:\\archivospdf\\FOTOMONTAJE."+nombredelarchivo+" ";
                    }
                    else
                    {
                   nombredelarchivo = nombredelarchivo.replace(" ","");
                    rutaimagen = "C:\\archivospdf\\"+nombredelarchivo+" ";
                    }   
                    
                    File file = new File(rutaimagen);
                    FileOutputStream output = new FileOutputStream(file);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    while ((length = inStream.read(buffer)) != -1) {
                        output.write(buffer, 0, length);
                   
                    }
                   
                    output.close();
                    
                    }
 
                }

            } //end while
            rs.close();
        } catch (SQLException ex) 
        {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
        
        if(tienefotomontaje.equals("si"))
        {
          
            lbdistinta1nombre.setVisible(false);
            lbdistinta1.setVisible(false);
            
            lbdistinta2nombre.setVisible(false);
            lbdistinta2.setVisible(false);
            
            lbdistinta3nombre.setVisible(false);
            lbdistinta3.setVisible(false);
            
            lbdistinta4nombre.setVisible(false);
            lbdistinta4.setVisible(false);
            
            lbdistinta5nombre.setVisible(false);
            lbdistinta5.setVisible(false);
            
            lbdistinta6nombre.setVisible(false);
            lbdistinta6.setVisible(false);
            
            lbdistinta7nombre.setVisible(false);
            lbdistinta7.setVisible(false);
        
            
            
        
        }
        else
        {
            btndistinta1termine.setEnabled(false);
            btndistinta2termine.setEnabled(false);
            btndistinta3termine.setEnabled(false);
            btndistinta4termine.setEnabled(false);
            btndistinta5termine.setEnabled(false);
            btndistinta6termine.setEnabled(false);
            btndistinta7termine.setEnabled(false);
            
            ordencamisaimagencontorno p = new ordencamisaimagencontorno();
            jPanel1.add(p);
            jPanel1.repaint();
            lbfotomontaje.setVisible(false);
            btnverfotomontaje.setEnabled(false);
         

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
            
        }  

        
        
    }

    
    
    
    
    
    void verfotomontajetiendalocal(){
        
        
        
        
        
          cliente = lbcliente.getText();
       
        String prenda =lbprenda.getText().toUpperCase();
      
      
        String rutadelarchivo = "";
        String existe = "";
        
        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next()) 
            {
                Object camisa1 = rs1.getString("imagen");
                if (camisa1 == null||camisa1.equals("")||camisa1.equals(" ")) 
                {
                    existe = "no";
                    
                } else 
                
                {
                    String nombredelarchivo = rs1.getString("extension_imagen");
                    if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                        
                     rutadelarchivo = "C:\\archivospdf\\fotomontaje."+nombredelarchivo+" ";   
                   
                    }
                    else
                    {
                        
                   nombredelarchivo = nombredelarchivo.replace(" ","");
                   rutadelarchivo = "C:\\archivospdf\\"+nombredelarchivo+" ";
                    
                    }
                    existe = "si";
                    File file = new File(rutadelarchivo);
                    FileOutputStream output = new FileOutputStream(file);
                    Blob archivo = rs1.getBlob("imagen");
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    while ((length = inStream.read(buffer)) != -1) {
                        output.write(buffer, 0, length);
                    }
 
                    output.close();
                }
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        if (existe.equals("si")) 
        {
            String fileLocal = new String(rutadelarchivo);
            try {

                File path = new File(fileLocal);
                Desktop.getDesktop().open(path);

            } catch (IOException e) {
                System.out.println(e);
            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:5px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        
        } 
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    void verfotomontajesucursal(){
        
        
        
        
        
          cliente = lbcliente.getText();
       
        String prenda =lbprenda.getText().toUpperCase();
      
      
        String rutadelarchivo = "";
        String existe = "";
        
        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next()) 
            {
                Object camisa1 = rs1.getString("imagen");
                if (camisa1 == null||camisa1.equals("")||camisa1.equals(" ")) 
                {
                    existe = "no";
                    
                } else 
                
                {
                    String nombredelarchivo = rs1.getString("extension_imagen");
                    if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                        
                     rutadelarchivo = "C:\\archivospdf\\fotomontaje."+nombredelarchivo+" ";   
                   
                    }
                    else
                    {
                        
                   nombredelarchivo = nombredelarchivo.replace(" ","");
                   rutadelarchivo = "C:\\archivospdf\\"+nombredelarchivo+" ";
                    
                    }
                    existe = "si";
                    File file = new File(rutadelarchivo);
                    FileOutputStream output = new FileOutputStream(file);
                    Blob archivo = rs1.getBlob("imagen");
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    while ((length = inStream.read(buffer)) != -1) {
                        output.write(buffer, 0, length);
                    }
 
                    output.close();
                }
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        if (existe.equals("si")) 
        {
            String fileLocal = new String(rutadelarchivo);
            try {

                File path = new File(fileLocal);
                Desktop.getDesktop().open(path);

            } catch (IOException e) {
                System.out.println(e);
            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:5px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        
        } 
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
     void cargarfotomontajeotrasucursal() throws FileNotFoundException, IOException  
    {
        
       
        String prenda =lbprenda.getText();
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);
        
        
        

       String sql = "Select imagen_nombre,imagen from historial_ordenes_camisa_recibidas where numero = '"+numeroordendebordadolocalorecibida+"'  and prenda = '"+prenda+"'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                Blob blob = rs.getBlob("imagen");
                if (blob == null) 
                {

                    tienefotomontaje = "no";
                   
                } 
                
                else 
                
                {
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) 
                    {
                     
                      JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");

                    }

                    
                    if(img==null)
                    {
                       tienefotomontaje = "no"; 
                    }
                    else
                    {
                    Imagen imagen = new Imagen();
                    imagen.setImagen(img);
                    lbfotomontaje.setIcon(new ImageIcon(img.getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT)));
                    lbfotomontaje.setVisible(true);
                    btnverfotomontaje.setEnabled(true);
                    tienefotomontaje = "si";
                    btnverfotomontaje.setEnabled(true);
                  

                    Blob archivo = rs.getBlob("imagen");
                    String nombredelarchivo = rs.getString("imagen_nombre");
                    if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                    rutaimagen = "C:\\archivospdf\\FOTOMONTAJE."+nombredelarchivo+" ";
                    }
                    else
                    {
                   nombredelarchivo = nombredelarchivo.replace(" ","");
                    rutaimagen = "C:\\archivospdf\\"+nombredelarchivo+" ";
                    } 
                   
                    File file = new File(rutaimagen);
                    FileOutputStream output = new FileOutputStream(file);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    while ((length = inStream.read(buffer)) != -1) {
                        output.write(buffer, 0, length);
                   
                    }
                   
                    output.close();
                    }
 
                }

            } //end while
            rs.close();
        } catch (SQLException ex) 
        {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
        
        if(tienefotomontaje.equals("si"))
        {
          
            lbdistinta1nombre.setVisible(false);
            lbdistinta1.setVisible(false);
            
            lbdistinta2nombre.setVisible(false);
            lbdistinta2.setVisible(false);
            
            lbdistinta3nombre.setVisible(false);
            lbdistinta3.setVisible(false);
            
            lbdistinta4nombre.setVisible(false);
            lbdistinta4.setVisible(false);
            
            lbdistinta5nombre.setVisible(false);
            lbdistinta5.setVisible(false);
            
            lbdistinta6nombre.setVisible(false);
            lbdistinta6.setVisible(false);
            
            lbdistinta7nombre.setVisible(false);
            lbdistinta7.setVisible(false);
        
           
            
        
        }
        else
        {
          /*  btnmangaderecha.setEnabled(false);
            btnmangaizquierda.setEnabled(false);
            btnpechoderecho.setEnabled(false);
            btnpechoizquierdo.setEnabled(false);
            btnespalda.setEnabled(false);
            btnotraubicacion.setEnabled(false);
            btnotraubicacion2.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");

            */
            
            
            ordencamisaimagencontorno p = new ordencamisaimagencontorno();
            jPanel1.add(p);
            jPanel1.repaint();
            lbfotomontaje.setVisible(false);
            btnverfotomontaje.setEnabled(false);
           

            
            
        }  

        
        
    }

    
    
    
    void datosdepedidosyenvios() 
    {
        /// busca las ordenes de camisa generadas 

        
        numerodeventa = lbnumerodeventa.getText();
        String pedirarticulos = "";
        String ordenenvio = "";
        String sql2 = "Select solicito_articulos, enviada_ordenenvio from historial_ventas where numero = '" + numerodeventa + "' ";

        try {
            PreparedStatement prst = cn.prepareStatement(sql2);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                pedirarticulos = rs.getString("solicito_articulos");
                ordenenvio = rs.getString("enviada_ordenenvio");

            }
        } catch (Exception exx) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

        }

        if (pedirarticulos.equals("si")) 
        {
            
            
            
            String sql3 = "Select numero,sucursal from historial_pedidos_sucursal_solicitados where numventa = '" + numerodeventa + "' and estatus_entrega not in ('cancelada')  ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
                    numerosolicitoarticulos = rs.getString("numero");
                    sucursal = rs.getString("sucursal");
                    
                    
                    lbsucursal.setText(sucursal);
                    lbnumero.setText(numerosolicitoarticulos);
                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }
            
            /// solicito articulos de la
            

        }
        else 
        {
            if (ordenenvio.equals("si")) 
            {

                
                
                String sql3 = "Select distinct numero,sucursal from historial_ordenes_envio_solicitadas where numero_venta = '" + numerodeventa + "'  ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    while (rs.next()) 
                    {
                        numeroordenenvio = rs.getString("numero");
                        tiendaordenenvio = rs.getString("sucursal");
                        
                       
                    }
                } catch (Exception exx) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }
                
                
                lbsucursal.setText(tiendaordenenvio);
                lbnumero.setText(numeroordenenvio);

            }
            
            
            
            if (tiendaordenenvio.equals(tiendalocal)) 
            {

                String sql4 = "Select numero,sucursal from historial_pedidos_sucursal_solicitados where numero = '" + numeroordenenvio + "' and estatus_entrega not in ('cancelada')  ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql4);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next())
                    {
                        numerosolicitoarticulos = rs.getString("numero");
                        sucursal = rs.getString("sucursal");

                        lbsucursal.setText(sucursal);
                        lbnumero.setText(numerosolicitoarticulos);
                    }
                    else
                    {
                        
                    }
                    
                    
                } catch (Exception exx) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

            } else {
                lbsucursal.setText(tiendaordenenvio);
                lbnumero.setText(numeroordenenvio);
            }

            
        }

    }
    
    
    
    
    
    
 void conectadaasucursal()
 {
     
     
     
     sucursal = lbsucursal.getText();
     
     
     
     
       if (sucursal.equals("cdmxcentro")) {
            rutadelip = "C:\\sistema\\cdmxcentro.txt";
        } else if (sucursal.equals("cdmxsur")) {
            rutadelip = "C:\\sistema\\cdmxsur.txt";
        } else if (sucursal.equals("guadalajara")) {
            rutadelip = "C:\\sistema\\guadalajara.txt";
        } else if (sucursal.equals("monterrey")) {
            rutadelip = "C:\\sistema\\monterrey.txt";
        } else {
            if (sucursal.equals("tijuana")) {
                rutadelip = "C:\\sistema\\tijuana.txt";
            }
        }

        File file1 = new File(rutadelip);
        try {
            Scanner sc = new Scanner(file1);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String str[] = line.split(":");
                ipsucursal = str[0];
              
              
            }
        } catch (IOException e) {
            System.out.println(e);
        }

     
     
       
        InetAddress ping;

            
        
        try {
                
               
                ping = InetAddress.getByName(ipsucursal);
            
                if (ping.isReachable(5000)) 
                {
                  
                  tiendaconectada = "si";
                  
                    try {
                        Class.forName("com.mysql.jdbc.Driver");
                        cnsucursal = DriverManager.getConnection("jdbc:mysql://" + ipsucursal + "/" + sucursal + "", "root", "sistemas");
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(ordencorbataS.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(ordencorbataS.class.getName()).log(Level.SEVERE, null, ex);
                    }
                  

                }
                
                else 
                
                {
                    
                    tiendaconectada = "no";
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al conectar con tienda");
                    

                }
            } catch (IOException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al conectar con tienda");
               
                
            }

         
        
        
     
 }
 
    
    
 
 
 
 
 
 
    
    
    void eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion(String ubicacion, String fecha)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE  "+nombredelatabla+" set "+ubicacion+"='0', "+fecha+"=null where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        
        if(terminetodo.equals("si"))
        {
            
        }
        else
        {    
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">"+ubicacionsinguiones+" cancelada correctamente ");
        }
        
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordendistintaS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    void insertarlacantidadylafechaenlaubicacion()
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_distinta set "+ubicacioncantidad+"='" + cantidad + "',"+ubicacionfecha+" = '"+dia()+"' where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacioncantidad;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        
        if(terminetodo.equals("si"))
        {
            
        }
        else
        {    
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        }
        
        
        /*
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordendistintaS.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
    }
    
    
    
    
     public static String dia() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        return formatoFecha.format(fecha);
    }

    public static String hora() {
        Date hora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm:ss");
        return formatoFecha.format(hora);
    }
    
    
    void agregaralsurtidasalhistorialdeventasyactualizarestatusentrega(String ubicacion, String cantidad, String ubicacionaplicacion) 
     
    
    
    {

        numerodeventa =  lbnumerodeventa.getText();
        String surtidaactualstring ="";
        int surtidaactualint =  0;
        String nuevasurtidastring = "";
        String estatusentrega ="";
        String estatusentregaventa = "";
        
         String SQL2 = "select articulo,surtida,estatus_entrega from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + ubicacion + "'and identificador_prenda = '"+identificador+"' ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {
            
       

        surtidaactualstring = rs.getString("surtida");
        surtidaactualint = Integer.parseInt(surtidaactualstring);
        estatusentregaventa= rs.getString("estatus_entrega");

        }
        
        else
        {
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EN LA VENTA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
        String[] lineas = observacion.split("\n");
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacion+"" + lineas[0] + "</span><br>";
        if (lineas.length > 1) {
         mensaje += "<span style=\"Color:red; font-size:20px;\">" + lineas[1] + "</span>";
}

JOptionPane.showMessageDialog(null, mensaje);
             
             
        }
        

        } catch (SQLException ex) {
            System.out.println (ex);
        }
        
        
        
          if(surtidaactualstring ==null || surtidaactualstring.equals("")||surtidaactualstring.equals(" "))
      {
          surtidaactualstring ="0";
      } 
          
       
        int surtidasint =  Integer.parseInt(cantidad);
        int surtidasnuevasint = surtidaactualint + surtidasint;
       
        nuevasurtidastring =  String.valueOf(surtidasnuevasint);
            
      
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + nuevasurtidastring + "' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       
            
            
            
            
            
            
            
               
            if (cantidadaplicacion.equals("0") || cantidadaplicacion.equals(""))
            {
                
                
                
                
            }
            
            else
            {
                
                int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
                
                cantidadaplicacionint = cantidadaplicacionint * surtidasnuevasint;
                
                String totalaplicaciones = String.valueOf(cantidadaplicacionint);
                
            
            
            
               try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + totalaplicaciones + "' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacionaplicacion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception ex) {
                            System.out.println (ex);
                            }
            
            
            
            
            }
            
            
            
            
            
            
            
            
            
            
            
            

        ////Actualiza el estatus

      String vendidastring = "";    
      String surtidastring = "";  
      String entregadastring = "";  
      String ordenstring = "";
      String cambiadastring = "";
      String virtualstring = "";
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(entregadas) as entregadas, Sum(orden) as orden, Sum(cantidad_virtual) as cantidad_virtual, Sum(cambiada) as cambiada from historial_ventas where numero = '"+numerodeventa+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        vendidastring = rs.getString("cantidad");
        surtidastring = rs.getString("surtida");
        entregadastring = rs.getString("entregadas");
        ordenstring = rs.getString("orden");
        cambiadastring = rs.getString("cambiada");
        virtualstring = rs.getString("cantidad_virtual");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
        
      int vendida = Integer.parseInt(vendidastring);
      int surtida = Integer.parseInt(surtidastring);
      int entregada = Integer.parseInt(entregadastring);
      int orden = Integer.parseInt(ordenstring);
      int cambiada = Integer.parseInt(cambiadastring);
      int virtual = Integer.parseInt(virtualstring);
      
        
        if(vendida == (surtida + orden + cambiada + virtual + entregada) && entregada == 0 )
        {
          estatusentrega ="surtida totalmente no entregada";  
        }
        
        else
          if(vendida == (surtida + orden + cambiada + virtual + entregada) && entregada > 0 )
        {
          estatusentrega ="surtida totalmente entregada parcialmente";  
        }
          
          
           else
          if(vendida > (surtida + orden + cambiada + virtual + entregada) && entregada > 0 )
        {
          estatusentrega ="surtida totalmente entregada parcialmente";  
        }
     
        
        else
        {
          estatusentrega ="surtida parcialmente no entregada";   
        }    
        
        
        
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numerodeventa + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      
      

        }
      
      
      
    
    
     void agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar(String ubicacion, String cantidad, String ubicacionaplicacion) 
      {

        numerodeventa =  lbnumerodeventa.getText();
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
        String estatusentregaventa = "";
        
        String SQL2 = "select cantidad,estatus_entrega from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + ubicacion + "' and identificador_prenda = '"+identificador+"'";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {

        cantidadstring = rs.getString("cantidad");
        estatusentregaventa= rs.getString("estatus_entrega");

        }
        

        } catch (SQLException ex) {
            System.out.println (ex);
        }
        
     
        
      if(cantidadstring ==null || cantidadstring.equals("")||cantidadstring.equals(" "))
      {
          cantidadstring ="0";
      }
       
        
        
        int cantidadstringint = Integer.parseInt(cantidadstring.toString());
        int cantidadint =  Integer.parseInt(cantidad);

        int nuevacantidadint = cantidadstringint - cantidadint ;
        nuevacantidadstring =  String.valueOf(nuevacantidadint);
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '"+nuevacantidadstring+"' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       

            
            
            
            
            
            
            
            
               if (cantidadaplicacion.equals("0") || cantidadaplicacion.equals(""))
                
            {
                
            }
            
            else
                
            {
                
                
              int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
                
                cantidadaplicacionint = cantidadaplicacionint * nuevacantidadint;
                
               String totalaplicaciones = String.valueOf(cantidadaplicacionint);
                
                
                
                
                
            
            
             try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '"+totalaplicaciones+"' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacionaplicacion + "'  and identificador_prenda = '"+identificador+"'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
            
            
            
            
            
            
            }
            
            
            
            
            
            
        ////Actualiza el estatus

      String vendidastring = "";    
      String surtidastring = "";  
      String entregadastring = "";  
      String ordenstring = "";
      String cambiadastring = "";
      String virtualstring = "";
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(entregadas) as entregadas, Sum(orden) as orden, Sum(cantidad_virtual) as cantidad_virtual, Sum(cambiada) as cambiada from historial_ventas where numero = '"+numerodeventa+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        vendidastring = rs.getString("cantidad");
        surtidastring = rs.getString("surtida");
        entregadastring = rs.getString("entregadas");
        ordenstring = rs.getString("orden");
        cambiadastring = rs.getString("cambiada");
        virtualstring = rs.getString("cantidad_virtual");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
      
      /////
      
     
      
      int vendida = Integer.parseInt(vendidastring);
      int surtida = Integer.parseInt(surtidastring);
      int entregada = Integer.parseInt(entregadastring);
      int orden = Integer.parseInt(ordenstring);
      int cambiada = Integer.parseInt(cambiadastring);
      int virtual = Integer.parseInt(virtualstring);
      
        
        if((surtida + orden + cambiada + virtual + entregada)== 0 )
        {
          estatusentrega ="no surtida no entregada";  
        }
        
        else
         if(((surtida + orden + cambiada + virtual + entregada)> 0) &&  entregada == 0)
        {
          estatusentrega ="surtida parcialmente no entregada";  
        }
          
           else
           if(((surtida + orden + cambiada + virtual + entregada)> 0) &&  entregada > 0)
        {
          estatusentrega ="surtida parcialmente entregada parcialmente";  
        }
     
       
        
        
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numerodeventa + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      
        
      
      
      }  
     
     
     
     
     
     
    
    
     void datosotrasucursal () throws FileNotFoundException, IOException
    {
         numeroordendebordadolocalorecibida = lborden.getText();
         prenda = "Distinta";



        String activadoladoizquierdofrente = "";
        String activadoladoizquierdoatras = "";
        String activadoladoderechofrente = "";
        String activadoladoderechoatras = "";

          String sql = "Select codigo,tipo,estatus_orden,numero,numero_venta,fecha,hora,cliente,tipo,identificador_prenda,estatus_orden,estatus_entrega,articulo,cantidad,prenda,cantidad_bordados,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,\n" +
"	   distinta1,distinta1_ubicacion,distinta1_nombre,distinta1_cantidad,distinta1_aplicacion,distinta1_aplicacion_color,\n" +
"	   distinta2,distinta2_ubicacion,distinta2_nombre,distinta2_cantidad,distinta2_aplicacion,distinta2_aplicacion_color, \n" +
"	   distinta3,distinta3_ubicacion,distinta3_nombre,distinta3_cantidad,distinta3_aplicacion,distinta3_aplicacion_color, \n" +
"	   distinta4,distinta4_ubicacion,distinta4_nombre,distinta4_cantidad,distinta4_aplicacion,distinta4_aplicacion_color, \n" +
"	   distinta5,distinta5_ubicacion,distinta5_nombre,distinta5_cantidad,distinta5_aplicacion,distinta5_aplicacion_color,\n" +
"	   distinta6,distinta6_ubicacion,distinta6_nombre,distinta6_cantidad,distinta6_aplicacion,distinta6_aplicacion_color,\n" +
"	   distinta7,distinta7_ubicacion,distinta7_nombre,distinta7_cantidad,distinta7_aplicacion,distinta7_aplicacion_color,\n" +
"	   lugar,fotomontaje_autorizado,identificador_prenda from historial_ordenes_distinta where where numero = '" + numeroordendebordadolocalorecibida + "' and prenda = '" + prenda + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
            {

                 cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
                
                lbprenda.setText(rs.getString("prenda"));
                prenda = (rs.getString("prenda"));
                lbfechaelaboracion.setText(rs.getString("fecha"));

                
                tipoprenda = rs.getString("tipo");
                estatusorden = rs.getString("estatus_orden");
                
                String observacion = rs.getString("observacion");
                
                if(observacion == null || observacion.equals("")||observacion.equals(" ") )
                {
                    
                }
                else
                {
                
                 
                tieneunaobservacion="si";    
                lbobservaciones.setText(observacion);
                
                }
                
                
                
                distinta1cantidad =rs.getString("distinta1_cantidad");
                distinta2cantidad =rs.getString("distinta2_cantidad");         
                distinta3cantidad =rs.getString("distinta3_cantidad"); 
                distinta4cantidad =rs.getString("distinta4_cantidad");
                distinta5cantidad =rs.getString("distinta5_cantidad");
                distinta6cantidad =rs.getString("distinta6_cantidad");
                distinta7cantidad =rs.getString("distinta7_cantidad");
               
                
                distinta1nombre = rs.getString("distinta1_nombre");
                distinta1ubicacion = rs.getString("distinta1_ubicacion");
                distinta1 = rs.getString("distinta1");
                lbdistinta1nombre.setText(distinta1nombre);
                lbdistinta1.setText(distinta1);
              
                if (distinta1 == null || distinta1.equals("")||distinta1.equals(" ")) 
                {

                   
                    botonhabilitado1 = "no";
                    

                }
                  

                
                
                distinta2nombre = rs.getString("distinta2_nombre");
                distinta2= rs.getString("distinta2");
                lbdistinta2nombre.setText(distinta2nombre);
                lbdistinta2.setText(distinta2);
                if (distinta2 == null | distinta2.equals("")) 
                {

                   
                    botonhabilitado2 = "no";

                }

                distinta3nombre = rs.getString("distinta3_nombre");
                distinta3 = rs.getString("distinta3");
                lbdistinta3nombre.setText(distinta3nombre);
                lbdistinta3.setText(distinta3);
                if (distinta3 == null | distinta3.equals("")) {

                   
                    botonhabilitado3 = "no";

                }

                distinta4nombre = rs.getString("distinta4_nombre");
                distinta4 = rs.getString("distinta4");
                lbdistinta4nombre.setText(distinta4nombre);
                lbdistinta4.setText(distinta4);
                if (distinta4 == null | distinta4.equals("")) 
                {

                   
                    botonhabilitado4 = "no";
                    
                }

                distinta5nombre = rs.getString("distinta5_nombre");
                distinta5 = rs.getString("distinta5");
                lbdistinta5nombre.setText(distinta5nombre);
                lbdistinta5.setText(distinta5);
                if (distinta5 == null | distinta5.equals("")) 
                {
                   
                    botonhabilitado5 = "no";

                }


                distinta6nombre = rs.getString("distinta6_nombre");
                distinta6 = rs.getString("distinta6");
                lbdistinta6nombre.setText(distinta6nombre);
                lbdistinta6.setText(distinta6);
                if (distinta6 == null | distinta6.equals("")) {

                  
                    botonhabilitado6 = "no";

                }

                distinta7nombre = rs.getString("distinta7_nombre");
                distinta7 = rs.getString("distinta7");
                lbdistinta7nombre.setText(distinta7nombre);
                lbdistinta7.setText(distinta7);
            
                if (distinta7 == null | distinta7.equals("")) {

                   
                    botonhabilitado7 = "no";
                    

                }
                
                
               distinta1aplicacion = rs.getString("distinta1_aplicacion");

                if (distinta1aplicacion.equals("ninguno")) {
                    distinta1aplicacion = "";
                }

                 distinta2aplicacion = rs.getString("distinta2_aplicacion");

                if (distinta2aplicacion.equals("ninguno")) {
                    distinta2aplicacion = "";
                }

                 distinta3aplicacion = rs.getString("distinta3_aplicacion");

                if (distinta3aplicacion.equals("ninguno")) {
                    distinta3aplicacion = "";
                }

                 distinta4aplicacion = rs.getString("distinta4_aplicacion");

                if (distinta4aplicacion.equals("ninguno")) {
                    distinta4aplicacion = "";
                }

                distinta5aplicacion = rs.getString("distinta5_aplicacion");

                if (distinta5aplicacion.equals("ninguno")) {
                    distinta5aplicacion = "";
                }

                
                  distinta6aplicacion = rs.getString("distinta6_aplicacion");

                if (distinta6aplicacion.equals("ninguno")) {
                    distinta6aplicacion = "";
                }

                
                distinta7aplicacion = rs.getString("distinta7_aplicacion");

                if (distinta7aplicacion.equals("ninguno")) {
                    distinta7aplicacion = "";
                } 

                
                lbcantidad.setText(rs.getString("cantidad"));
                identificador = rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);  
                lugar = rs.getString("lugar");
                
                
                
                
                
                
                cantidaddistinta1 =rs.getString("distinta1_cantidad");
                cantidaddistinta2 =rs.getString("distinta2_cantidad");         
                cantidaddistinta3 =rs.getString("distinta3_cantidad"); 
                cantidaddistinta4 =rs.getString("distinta4_cantidad");
                cantidaddistinta5 =rs.getString("distinta5_cantidad");
                cantidaddistinta6 =rs.getString("distinta6_cantidad");
                cantidaddistinta7 =rs.getString("distinta7_cantidad2");
                
                
                
                
                
                
                
                
                
                
                if(lugar.equals("Esta sucursal"))
                {
                
                    lbsucursal.setEnabled(false);
                
                
                if(distinta1nombre==null||distinta1nombre.equals("")||distinta1nombre.equals(" "))
                {
                   btndistinta1termine.setEnabled(false);
                   
                }
                else
                {
                    
                    
                     if(cantidaddistinta1.equals("0") && botonhabilitado1.equals("si") )
                {
                    
                    lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
                }

                   
                   if(botonhabilitado1.equals("si"))
                   {
                   listabotones.add("btndistinta1");
                   lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
                   
                   }

                    
                } 
                
                
                
                /// distinta2
                
                 if(distinta2nombre==null||distinta2nombre.equals("")||distinta2nombre.equals(" "))
                {
                   btndistinta2termine.setEnabled(false);
                   
                }
                else
                {
                    
                    
                     if(cantidaddistinta2.equals("0") && botonhabilitado2.equals("si") )
                {
                   btndistinta2termine.setEnabled(true);
                   lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                 
                }
                     
                   
                  

                   if(botonhabilitado2.equals("si"))
                   {
                   listabotones.add("btndistinta2");
                   lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                   }
                   
                    
                     
                } 
                
                 
                 
                 
                 
                 
                 if(distinta3nombre==null||distinta3nombre.equals("")||distinta3nombre.equals(" "))
                {
                   btndistinta3termine.setEnabled(false);
                   
                }
                else
                {
                    
                    
                         if(cantidaddistinta3.equals("0") && botonhabilitado3.equals("si") )
                {
                   btndistinta3termine.setEnabled(true);
                    lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                   
                }
                         
                    
                   if(botonhabilitado3.equals("si"))
                   {
                   listabotones.add("btndistinta3");
                   lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                   
                   }

                 
                } 
                
                if(distinta4nombre==null||distinta4nombre.equals("")||distinta4nombre.equals(" "))
                {
                   btndistinta4termine.setEnabled(false);
                   
                }
                else
                {
                    
                    
                        if(cantidaddistinta4.equals("0") && botonhabilitado4.equals("si") )
                {
                   btndistinta4termine.setEnabled(true);
                    lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                    
                } 
                  
                   if(botonhabilitado4.equals("si"))
                   {
                   listabotones.add("btndistinta4");
                   lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                    
                   }

                }
                    
                
                
                
                
                
                
                if(distinta5nombre==null||distinta5nombre.equals("")||distinta5nombre.equals(" "))
                {
                   btndistinta5termine.setEnabled(false);
                   
                }
                else
                {
                    
                     if(cantidaddistinta5.equals("0") && botonhabilitado5.equals("si") )
                {
                    btndistinta5termine.setEnabled(true);
                    lbcantidad5.setText("0");
                    lbcantidad5.setForeground(Color.red.darker());
                    
                    
                }
                  
                   if(botonhabilitado5.equals("si"))
                   {
                   listabotones.add("btndistinta5");
                   lbcantidad5.setText("0");
                    lbcantidad5.setForeground(Color.red.darker());
                  
                   }

                    
                
                    
                } 
                
                if(distinta6nombre==null||distinta6nombre.equals("")||distinta6nombre.equals(" "))
                {
                   btndistinta6termine.setEnabled(false);
                   
                }
                else
                {
                    
                    
                  
                     if(cantidaddistinta6.equals("0") && botonhabilitado6.equals("si") )
                {
                    btndistinta6termine.setEnabled(true);
                    lbcantidad6.setText("0");
                    lbcantidad6.setForeground(Color.red.darker());
                   }

                    
                   if(botonhabilitado6.equals("si"))
                   {
                   listabotones.add("btndistinta6");
                   lbcantidad6.setText("0");
                    lbcantidad6.setForeground(Color.red.darker());
                  
                   }
                   
                    
                }
                
                
                if(distinta7nombre==null||distinta7nombre.equals("")||distinta7nombre.equals(" "))
                {
                   btndistinta7termine.setEnabled(false);
                   
                }
                else
                {
                    
                     if(cantidaddistinta7.equals("0") && botonhabilitado7.equals("si") )
                {
                    btndistinta7termine.setEnabled(true);
                    lbcantidad7.setText("0");
                    lbcantidad7.setForeground(Color.red.darker());
                    
                }
                   
                   if(botonhabilitado7.equals("si"))
                   {
                   listabotones.add("btndistinta7");
                    lbcantidad7.setText("0");
                    lbcantidad7.setForeground(Color.red.darker());
                   
                   }
                   
                    
                } 
                
                
                
                
                
                
                }
                else
                {
                    
                    lbsucursal.setEnabled(true);
                    
                }
                
                
                
                if(estatusorden.equals("realizada totalmente"))
                {
                    
                     if(distinta1nombre!=null && Integer.parseInt(distinta1cantidad) > 0  )
                     {
                         btndistinta1termine.setEnabled(false);
          //               cancelar1.setVisible(true);
                     }
                     else if(distinta2nombre!=null && Integer.parseInt(distinta2cantidad) > 0  )
                     {
                         btndistinta2termine.setEnabled(false);
           //              cancelar2.setVisible(true);
                     }
                      else if( distinta3nombre!=null && Integer.parseInt(distinta3cantidad) > 0  )
                     {
                         btndistinta3termine.setEnabled(false);
              //           cancelar3.setVisible(true);
                     }
                     else if( distinta4nombre!=null && Integer.parseInt(distinta4cantidad) > 0  )
                     {
                         btndistinta4termine.setEnabled(false);
              //           cancelar4.setVisible(true);
                     }
                     else if( distinta5nombre!=null && Integer.parseInt(distinta5cantidad) > 0  )
                     {
                         btndistinta5termine.setEnabled(false);
           //              cancelar5.setVisible(true);
                     }
                     else if( distinta6nombre!=null && Integer.parseInt(distinta6cantidad) > 0  )
                     {
                         btndistinta6termine.setEnabled(false);
            //             cancelar6.setVisible(true);
                     }
                     else if( distinta7nombre!=null && Integer.parseInt(distinta7cantidad) > 0  )
                     {
                         btndistinta7termine.setEnabled(false);
            //             cancelar7.setVisible(true);
                     }
                     
                     
                     btnterminetodo.setEnabled(false);
                    
                    
                }
                else if(estatusorden.equals("generada"))
                {
                    
                     if(distinta1nombre!=null && Integer.parseInt(distinta1cantidad) == 0  )
                     {
                         btndistinta1termine.setEnabled(true);
            //             cancelar1.setVisible(false);
                     }
                     else if(distinta2nombre!=null && Integer.parseInt(distinta2cantidad) == 0  )
                     {
                         btndistinta2termine.setEnabled(true);
           //              cancelar2.setVisible(false);
                     }
                      else if( distinta3nombre!=null && Integer.parseInt(distinta3cantidad) == 0  )
                     {
                         btndistinta3termine.setEnabled(true);
           //              cancelar3.setVisible(false);
                     }
                     else if( distinta4nombre!=null && Integer.parseInt(distinta4cantidad) == 0  )
                     {
                         btndistinta4termine.setEnabled(true);
            //             cancelar4.setVisible(false);
                     }
                     else if( distinta5nombre!=null && Integer.parseInt(distinta5cantidad) == 0  )
                     {
                         btndistinta5termine.setEnabled(true);
            //             cancelar5.setVisible(false);
                     }
                     else if( distinta6nombre!=null && Integer.parseInt(distinta6cantidad) == 0  )
                     {
                         btndistinta6termine.setEnabled(true);
          //               cancelar6.setVisible(false);
                     }
                     else if( distinta7nombre!=null && Integer.parseInt(distinta7cantidad) == 0  )
                     {
                         btndistinta7termine.setEnabled(true);
            //             cancelar7.setVisible(false);
                     }
                     
                     btnterminetodo.setEnabled(true);
                    
                    
                }
                

            
            
            
            }         
                 identificador =  rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                
                
            
        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        
        
          
       cliente = lbcliente.getText();
        
        
        
                
              if (tiendaconectada.equals("si"))

                      {
                
                
                 try {
         

        String sql7 = "Select cliente,lugar,identificador_prenda from historial_ordenes_pantalon where numero = '" + numerosucursal + "' ";

        try {
            Statement st = cnsucursal.createStatement();
            ResultSet rs = st.executeQuery(sql7);
            if (rs.next()) {

                cliente = rs.getString("cliente");
                prenda = (rs.getString("prenda"));
                sucursal = rs.getString("lugar");
                identificador = rs.getString("identificador_prenda");
                

            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }

        
     
        
        
         BufferedImage img = null;
        
        
        
       String sql4 = "Select extension_imagen,imagen from bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";  ///

        try {

            Statement st = cnsucursal.createStatement();
            ResultSet rs = st.executeQuery(sql4);
            while (rs.next()) 
            {
                
                Blob blob = rs.getBlob("imagen");
              
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) 
                    {
                 
                      JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");

                    }

                    if(img==null)
                    {
                       tienefotomontaje = "no"; 
                    }
                    else
                    {
                    
                    Imagen imagen = new Imagen();
                    imagen.setImagen(img);
                    lbfotomontaje.setIcon(new ImageIcon(img.getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT)));
                    lbfotomontaje.setVisible(true);
                    btnverfotomontaje.setEnabled(true);
                    tienefotomontaje = "si";
                    btnverfotomontaje.setEnabled(true);
                  

                    Blob archivo = rs.getBlob("imagen");
                    String nombredelarchivo = rs.getString("extension_imagen");
                     if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                    rutaimagen = "C:\\archivospdf\\FOTOMONTAJE."+nombredelarchivo+" ";
                    }
                    else
                    {
                   nombredelarchivo = nombredelarchivo.replace(" ","");
                    rutaimagen = "C:\\archivospdf\\"+nombredelarchivo+" ";
                    }   
                    
                    File file = new File(rutaimagen);
                    FileOutputStream output = new FileOutputStream(file);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    while ((length = inStream.read(buffer)) != -1) {
                        output.write(buffer, 0, length);
                   
                    }
                   
                    output.close();
                    
                    }
 
               

            } //end while
            rs.close();
        } catch (SQLException ex) 
        {
          
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }
        
        
         } catch (Exception x) {
                               System.out.println(x); 
                            }
        
                      }
        
        

    }
     
     
     
     
     
    
    
    void sumapuntos()
    {
   
         String sql = "Select cantidad,pecho_izquierdo_cantidad,pecho_izquierdo_puntadas,"
                  + "pecho_derecho_cantidad,pecho_derecho_puntadas,"
                  + "manga_izquierda_cantidad,manga_izquierda_puntadas,"
                  + "manga_derecha_cantidad,manga_derecha_puntadas,"
                  + "espalda_cantidad,espalda_puntadas,"
                  + "otra_ubicacion_cantidad,otra_ubicacion_puntadas,"
                  + "otra_ubicacion2_cantidad,otra_ubicacion2_puntadas,"
                  + "aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2 from "+nombredelatabla+" where numero = '"+numeroordendebordadolocalorecibida+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cantidad = rs.getString("cantidad");   
                String cantidadpechoizquierdo = rs.getString("pecho_izquierdo_cantidad");
                String pechoizquierdo = rs.getString("pecho_izquierdo_puntadas");
                String cantidadpechoderecho = rs.getString("pecho_derecho_cantidad");
                String pechoderecho = rs.getString("pecho_derecho_puntadas");
                String cantidadmangaizquierda = rs.getString("manga_izquierda_cantidad");
                String mangaizquierda = rs.getString("manga_izquierda_puntadas");
                String cantidadmangaderecha = rs.getString("manga_derecha_cantidad");
                String mangaderecha = rs.getString("manga_derecha_puntadas");
                String cantidadespalda = rs.getString("espalda_cantidad");
                String espalda = rs.getString("espalda_puntadas");
                String cantidadotraubicacion = rs.getString("otra_ubicacion_cantidad");
                String otraubicacion = rs.getString("otra_ubicacion_puntadas");
                String cantidadotraubicacion2 = rs.getString("otra_ubicacion2_cantidad");
                String otraubicacion2 = rs.getString("otra_ubicacion2_puntadas");
                String aplicacionpechoizquierdo= rs.getString("aplicacion_pecho_izquierdo");
                String aplicacionpechoderecho= rs.getString("aplicacion_pecho_derecho");
                String aplicacionmangaizquierda = rs.getString("aplicacion_manga_izquierda");
                String aplicacionmangaderecha = rs.getString("aplicacion_manga_derecha");
                String aplicacionespalda = rs.getString("aplicacion_espalda");
                
            int cantidadpechoizquierdoint = Integer.parseInt(cantidadpechoizquierdo);
            int cantidadpechoderechoint = Integer.parseInt(cantidadpechoderecho);
            int cantidadmangaizquierdaint = Integer.parseInt(cantidadmangaizquierda);
            int cantidadmangaderechaint = Integer.parseInt(cantidadmangaderecha);
            int cantidadespaldaint = Integer.parseInt(cantidadespalda);
            int cantidadotraubicacionint = Integer.parseInt(cantidadotraubicacion);
            int cantidadotraubicacion2int = Integer.parseInt(cantidadotraubicacion2);
 
            String costostring = "0.00";
            double importepechoizquierdo = 0.00;
            double importepechoderecho = 0.00;
            double importemangaderecha = 0.00;
            double importemangaizquierda = 0.00;
            double importeespalda = 0.00;
            double importeotraubicacion = 0.00;
            double importeotraubicacion2 = 0.00;
            
            double costopuntadapechoizquierdo = 0.0;
            double costopuntadapechoderecho = 0.0;
            double costopuntadamangaizquierda = 0.0;
            double costopuntadamangaderecha = 0.0;
            double costopuntadaespalda = 0.0;
            double costopuntadaotraubicacion = 0.0;
            double costopuntadaotraubicacion2 = 0.0;
            
            double costopuntadasaplicacioneschicas = 0.00;
            double totalpuntosaplicacioneschicas = 0.00;
            double totalpuntosaplicacionesgrandes = 0.00;
            

            //PECHO IZQUIERDO
            
            String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" +pechoizquierdo+ "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql1);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next())
                {

                    costostring = rs2.getString("costo");
                    costopuntadapechoizquierdo = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadapechoizquierdostring = String.format("%.02f ", costopuntadapechoizquierdo);
            importepechoizquierdo = cantidadpechoizquierdoint * costopuntadapechoizquierdo;

            //PECHO DERECHO
            
            String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoderecho + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql2);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadapechoderecho = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadapechoderechostring = String.format("%.02f ", costopuntadapechoderecho);
            importepechoderecho = cantidadpechoderechoint * costopuntadapechoderecho;

//MANGA IZQUIERDA
            
 
            String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaizquierda+ "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaizquierda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadamangaizquierda);
            importemangaizquierda = cantidadmangaizquierdaint * costopuntadamangaizquierda;

//MANGA DERECHA
            
            String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '"+mangaderecha+"'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql4);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaderecha = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadamangaderechastring = String.format("%.02f ", costopuntadamangaderecha);
            importemangaderecha = cantidadmangaderechaint * costopuntadamangaderecha;

            // ESPALDA
           
            String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + espalda + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql5);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaespalda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadaespaldastring = String.format("%.02f ", costopuntadaespalda);
             importeespalda = cantidadespaldaint * costopuntadaespalda;

            /// otra ubicacion
           

            String sql6 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacion + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql6);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaotraubicacion = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
               
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadaotraubicacionstring = String.format("%.02f ", costopuntadaotraubicacion);
            importeotraubicacion = cantidadotraubicacionint * costopuntadaotraubicacion;

            /// otra ubicacion2
            
           

            String sql7 = "SELECT costo from catalogo_costos_bordado where puntadas = '" +otraubicacion2+ "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql7);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaotraubicacion2 = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadaotraubicacion2string = String.format("%.02f ", costopuntadaotraubicacion2);
            importeotraubicacion2 = cantidadotraubicacionint * costopuntadaotraubicacion2;
            
           
            
//// aplicaciones
            
             

            if (aplicacionpechoizquierdo == null || aplicacionpechoizquierdo.equals("") || aplicacionpechoizquierdo.equals(" ")) {
                aplicacionpechoizquierdo = "0";
            }
            int aplicacionpechoizquierdoint = Integer.parseInt(aplicacionpechoizquierdo.toString());


            if (aplicacionpechoderecho == null || aplicacionpechoderecho.equals("") || aplicacionpechoderecho.equals(" ")) {
                aplicacionpechoderecho = "0";
            }

            int aplicacionpechoderechoint = Integer.parseInt(aplicacionpechoderecho.toString());


            if (aplicacionmangaizquierda == null || aplicacionmangaizquierda.equals("") || aplicacionmangaizquierda.equals(" ")) {
                aplicacionmangaizquierda = "0";
            }
            int aplicacionmangaizquierdaint = Integer.parseInt(aplicacionmangaizquierda.toString());


            if (aplicacionmangaderecha == null || aplicacionmangaderecha.equals("") || aplicacionmangaderecha.equals(" ")) {
                aplicacionmangaderecha = "0";
            }
            int aplicacionmangaderechaint = Integer.parseInt(aplicacionmangaderecha.toString());



            int sumadelasaplicaciones = aplicacionpechoizquierdoint + aplicacionpechoderechoint + aplicacionmangaizquierdaint + aplicacionmangaderechaint ;

            String sqlaplicacionchica = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION CHICA' ";

            try {
                PreparedStatement prst = cn.prepareStatement(sqlaplicacionchica);
                ResultSet rs2 = prst.executeQuery();
                if (rs.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadasaplicacioneschicas = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            totalpuntosaplicacioneschicas = costopuntadasaplicacioneschicas * (sumadelasaplicaciones * Integer.parseInt(cantidad));

           

       

        //// aplicaciones grandes
        String costoaplicacionesgrandesstring = "";
        double costopuntadasaplicacionesgrandes = 0.00;
          

           
            if (aplicacionespalda == null || aplicacionespalda.equals("") || aplicacionespalda.equals(" ")) {
                aplicacionespalda = "0";
            }
            int aplicacionespaldaint = Integer.parseInt(aplicacionespalda.toString());

            int sumadelasaplicacionesgrandes = aplicacionespaldaint;

            String sql1a = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION GRANDE' ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql1a);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costoaplicacionesgrandesstring = rs2.getString("costo");
                    costopuntadasaplicacionesgrandes = Double.parseDouble(costoaplicacionesgrandesstring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            totalpuntosaplicacionesgrandes = costopuntadasaplicacionesgrandes * (sumadelasaplicacionesgrandes* Integer.parseInt(cantidad));

            
            double sumatotaldepuntosaplicaciones = totalpuntosaplicacioneschicas +  totalpuntosaplicacionesgrandes ;
            

            double sumabordados = importepechoizquierdo + importepechoderecho + importemangaizquierda + importemangaderecha + importeespalda + importeotraubicacion + importeotraubicacion2 +sumatotaldepuntosaplicaciones;
            String sumabordadosstring = String.format("%.02f ", sumabordados);
            lbsumapuntos.setText(sumabordadosstring);

        }



            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
    
    
    void actualizarestatusentregaordendebordado()
    {
        
       
        int tienecantidad = 0;
        botonesactivados = 0;
        
         String sql = "Select distinta1_cantidad,distinta1,distinta2_cantidad,distinta2,"
                  + "distinta3_cantidad,distinta3,distinta4_cantidad,distinta4,distinta4_cantidad,distinta4,"
                  + "distinta5_cantidad,distinta5,distinta6_cantidad,distinta6,distinta7_cantidad,distinta7 from "+nombredelatabla+" where numero = '"+numeroordendebordadolocalorecibida+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

              
                String distinta1cantidad = rs.getString("distinta1_cantidad");
                String distinta1 = rs.getString("distinta1");
                String distinta2cantidad = rs.getString("distinta2_cantidad");
                String distinta2 = rs.getString("distinta2");
                String distinta3cantidad = rs.getString("distinta3_cantidad");
                String distinta3 = rs.getString("distinta3");
                String distinta4cantidad = rs.getString("distinta4_cantidad");
                String distinta4 = rs.getString("distinta4");
                String distinta5cantidad = rs.getString("distinta5_cantidad");
                String distinta5 = rs.getString("distinta4");
                String distinta6cantidad = rs.getString("distinta6_cantidad");
                String distinta6 = rs.getString("distinta6");
                String distinta7cantidad = rs.getString("distinta7_cantidad");
                String distinta7 = rs.getString("distinta7");

                
                if(distinta1==null || distinta1.equals("")||distinta1.equals(" ")||distinta1.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                } 
                
                
                if(distinta2==null || distinta2.equals("")||distinta2.equals(" ")||distinta2.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(distinta3==null || distinta3.equals("")||distinta3.equals(" ")||distinta3.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(distinta4==null || distinta4.equals("")||distinta4.equals(" ")||distinta4.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(distinta5==null || distinta5.equals("")||distinta5.equals(" ")||distinta5.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
            
                
                if(distinta6==null || distinta6.equals("")||distinta6.equals(" ")||distinta6.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
            
           if(distinta7==null || distinta7.equals("")||distinta7.equals(" ")||distinta7.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
           
           
                ////////////////////////////////////////////////////////////////
                
                 if(distinta1cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                } 
                
                
                if(distinta2cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                }
                
                if(distinta3cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
                if(distinta4cantidad.equals("0"))
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
                if(distinta5cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
            
                
                if(distinta6cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                }
            
           if(distinta7cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                }
           
            
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           if(tienecantidad == botonesactivados)
           {
               
             nuevoestatusorden = "realizada totalmente";
             
           lbestatus.setForeground(Color.green.darker());
           
               
           }
         
           else
       
           {
               
               
                 if(tienecantidad > 0)
           {
               
                nuevoestatusorden = "realizada parcialmente";
               
               lbestatus.setForeground(Color.orange.darker());
               
               
           }
                 
                 else
                     
                 {
                   
               
               
               nuevoestatusorden = "generada";
               
               lbestatus.setForeground(Color.red.darker());
               
               
                 }
            
           }   
               
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           
           if(tienecantidad == botonesactivados)
           {
               try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set estatus_orden='realizada totalmente',fecha='"+dia()+"' where numero='" + numeroordendebordadolocalorecibida + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
               
           }


        }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
    
    void hilosycolor()
    {
        Object cliente = lbcliente.getText();
       
        Object prenda =lbprenda.getText();
     
       

        String sql = "Select hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,color1,color2,color3,color4,color5,color6,color7 from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and prenda_especial = 'DISTINTA'   ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next()) 
            {
                Object hilo1 = rs1.getString("hilo1");
                Object hilo2 = rs1.getString("hilo2");
                Object hilo3 = rs1.getString("hilo3");
                Object hilo4 = rs1.getString("hilo4");
                Object hilo5 = rs1.getString("hilo5");
                Object hilo6 = rs1.getString("hilo6");
                Object hilo7 = rs1.getString("hilo7");
                
                
                
                
                
                Object codigo1 = rs1.getString("color1");
                Object codigo2 = rs1.getString("color2");
                Object codigo3 = rs1.getString("color3");
                Object codigo4 = rs1.getString("color4");
                Object codigo5 = rs1.getString("color5");
                Object codigo6 = rs1.getString("color6");
                Object codigo7 = rs1.getString("color7");
                
                if(codigo1.equals("ninguno"))
                {
                  lbcolorpechoizquierdo.setVisible(false);  
                  lbcodigopechoizquierdo.setVisible(false); 
                }
                else
                {
                  lbcolorpechoizquierdo.setText(codigo1.toString());
                  lbcodigopechoizquierdo.setText(hilo1.toString());
                }  
                
                if(codigo2.equals("ninguno"))
                {
                  lbcolorpechoderecho.setVisible(false); 
                  lbcodigopechoderecho.setVisible(false); 
                }
                else
                {
                  lbcolorpechoderecho.setText(codigo2.toString());
                  lbcodigopechoderecho.setText(hilo2.toString());
                }  
                
                 if(codigo3.equals("ninguno"))
                {
                  lbcolormangaizquierda.setVisible(false); 
                  lbcodigomangaizquierda.setVisible(false); 
                }
                else
                {
                  lbcolormangaizquierda.setText(codigo3.toString());
                  lbcodigomangaizquierda.setText(hilo3.toString());
                }  
                
                if(codigo4.equals("ninguno"))
                {
                  lbcolormangaderecha.setVisible(false);  
                  lbcodigomangaderecha.setVisible(false);  
                }
                else
                {
                  lbcolormangaderecha.setText(codigo4.toString());
                  lbcodigomangaderecha.setText(hilo4.toString());
                }    
                
                if(codigo5.equals("ninguno"))
                {
                  lbcolorespalda.setVisible(false);  
                  lbcodigoespalda.setVisible(false);  
                }
                else
                {
                  lbcolorespalda.setText(codigo5.toString());
                  lbcodigoespalda.setText(hilo5.toString());
                }   
                
                 if(codigo6.equals("ninguno"))
                {
                  lbcolorotraubicacion.setVisible(false); 
                  lbcodigootraubicacion.setVisible(false);  
                }
                else
                {
                  lbcolorotraubicacion.setText(codigo6.toString());
                  lbcodigootraubicacion.setText(hilo6.toString());
                } 
                
                 if(codigo7.equals("ninguno"))
                {
                  lbcolorotraubicacion2.setVisible(false);  
                  lbcodigootraubicacion2.setVisible(false);  
                }
                else
                {
                  lbcolorotraubicacion2.setText(codigo7.toString());
                  lbcodigootraubicacion2.setText(hilo7.toString());
                } 
                    
                
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
    }
    
   
    
    
    
     
     void descargarponchado(String ubicacion,String ubicacionnombre)
     {
         JSystemFileChooser fs = new JSystemFileChooser();
        

         try (
                 PreparedStatement ps = cn.prepareStatement("select " + ubicacion + "," + ubicacionnombre + " from historial_ordenes_gorra_recibidas where numero = '" + numeroordendebordadolocalorecibida + "' ")) {
             ResultSet rs = ps.executeQuery();

             if (rs.next()) {

                 fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                 String nombre1 = rs.getString("" + ubicacionnombre + "");
                 fs.setSelectedFile(new File(nombre1));
                 int tampak = fs.showSaveDialog(null);

                 if (tampak == JFileChooser.APPROVE_OPTION) 
                 {
                     File file = fs.getSelectedFile();
                     try (InputStream stream = rs.getBinaryStream("" + ubicacion + "");
                             OutputStream output = new FileOutputStream(file)) 
                     {
                         byte[] buffer = new byte[4096];
                         while (stream.read(buffer) > 0) 
                         {
                             output.write(buffer);
                         }
                     }
                 }

             }
             rs.close();
         } catch (FileNotFoundException fnfe) {
             System.out.println(fnfe);
         } catch (IOException ioe) {
             System.out.println(ioe);
         } catch (SQLException sqle) {
             System.out.println(sqle);
         }
     }
     
     
     
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbfotomontaje = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lborden = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        lbtitulo = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbprenda = new javax.swing.JLabel();
        lbnumerodeventa = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        lbnumero = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        btnverfotomontaje = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        lbfechaelaboracion = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbbordacliente = new javax.swing.JLabel();
        btndistinta1termine = new javax.swing.JButton();
        btndistinta2termine = new javax.swing.JButton();
        btndistinta3termine = new javax.swing.JButton();
        btndistinta4termine = new javax.swing.JButton();
        btndistinta5termine = new javax.swing.JButton();
        btndistinta6termine = new javax.swing.JButton();
        btndistinta7termine = new javax.swing.JButton();
        lbsumapuntos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbnombrecomercial = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
        lbcolormangaderecha = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        lbcolormangaizquierda = new javax.swing.JLabel();
        lbcolorpechoderecho = new javax.swing.JLabel();
        lbcolorpechoizquierdo = new javax.swing.JLabel();
        lbcolorespalda = new javax.swing.JLabel();
        lbcolorotraubicacion = new javax.swing.JLabel();
        lbcolorotraubicacion2 = new javax.swing.JLabel();
        lbcodigomangaderecha = new javax.swing.JLabel();
        lbcodigomangaizquierda = new javax.swing.JLabel();
        lbcodigopechoderecho = new javax.swing.JLabel();
        lbcodigopechoizquierdo = new javax.swing.JLabel();
        lbcodigoespalda = new javax.swing.JLabel();
        lbcodigootraubicacion = new javax.swing.JLabel();
        lbcodigootraubicacion2 = new javax.swing.JLabel();
        btnterminetodo = new javax.swing.JButton();
        btneditarbordado = new javax.swing.JButton();
        lbdistinta2 = new javax.swing.JLabel();
        btndistinta1cancelar = new javax.swing.JButton();
        btndistinta2cancelar = new javax.swing.JButton();
        btndistinta3cancelar = new javax.swing.JButton();
        btndistinta4cancelar = new javax.swing.JButton();
        btndistinta5cancelar = new javax.swing.JButton();
        btndistinta6cancelar = new javax.swing.JButton();
        btndistinta7cancelar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btndistinta3ponnchado = new javax.swing.JButton();
        btndistinta2ponnchado = new javax.swing.JButton();
        btndistinta1ponnchado = new javax.swing.JButton();
        btndistinta7ponnchado = new javax.swing.JButton();
        btndistinta6ponnchado = new javax.swing.JButton();
        btndistinta5ponnchado = new javax.swing.JButton();
        btndistinta4ponnchado = new javax.swing.JButton();
        lbdistinta1nombre = new javax.swing.JLabel();
        lbdistinta1 = new javax.swing.JLabel();
        lbdistinta2nombre = new javax.swing.JLabel();
        lbdistinta3 = new javax.swing.JLabel();
        lbdistinta3nombre = new javax.swing.JLabel();
        lbdistinta4 = new javax.swing.JLabel();
        lbdistinta4nombre = new javax.swing.JLabel();
        lbdistinta6nombre = new javax.swing.JLabel();
        lbdistinta6 = new javax.swing.JLabel();
        lbdistinta5nombre = new javax.swing.JLabel();
        lbdistinta5 = new javax.swing.JLabel();
        lbdistinta7nombre = new javax.swing.JLabel();
        lbdistinta7 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbestatus = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbcantidad5 = new javax.swing.JLabel();
        lbcantidad6 = new javax.swing.JLabel();
        lbcantidad7 = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbautorizacion = new javax.swing.JLabel();
        lbnumeroordenopedidosolicitado = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        lbsumapuntos1 = new javax.swing.JLabel();
        lbsumapuntos2 = new javax.swing.JLabel();
        lbsumapuntos3 = new javax.swing.JLabel();
        lbsumapuntos4 = new javax.swing.JLabel();
        lbsumapuntos5 = new javax.swing.JLabel();
        lbsumapuntos6 = new javax.swing.JLabel();
        lbsumapuntos7 = new javax.swing.JLabel();
        btnotraubicacion2ponchado1 = new javax.swing.JButton();
        btnotraubicacionponchado1 = new javax.swing.JButton();
        btnespaldaponchado1 = new javax.swing.JButton();
        btnpechoizquierdoponchado1 = new javax.swing.JButton();
        btnpechoderechoponchado1 = new javax.swing.JButton();
        btnmangaizquierdaponchado1 = new javax.swing.JButton();
        btnmangaderechaponchado1 = new javax.swing.JButton();
        btncargarponchado5 = new javax.swing.JButton();
        btncargarponchado4 = new javax.swing.JButton();
        btncargarponchado3 = new javax.swing.JButton();
        btncargarponchado1 = new javax.swing.JButton();
        btncargarponchado2 = new javax.swing.JButton();
        btncargarponchado7 = new javax.swing.JButton();
        btncargarponchado6 = new javax.swing.JButton();
        lbsucursal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden distinta");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(null);

        lbfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbfotomontaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbfotomontaje.setToolTipText("");
        lbfotomontaje.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lbfotomontaje);
        lbfotomontaje.setBounds(0, 0, 1180, 510);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Numero de orden");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lborden.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lborden.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Cliente");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbtitulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbprenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbprendaMouseClicked(evt);
            }
        });

        lbnumerodeventa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnumerodeventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumero.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Sucursal");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminar.setText("Ver datos del bordado");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Numero orden de bordado solicitado");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Cantidad");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfechaelaboracion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfechaelaboracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Bordacliente");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndistinta1termine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta1termine.setText("Termine");
        btndistinta1termine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta1termineMouseReleased(evt);
            }
        });
        btndistinta1termine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta1termineActionPerformed(evt);
            }
        });

        btndistinta2termine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta2termine.setText("Termine");
        btndistinta2termine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta2termineMouseReleased(evt);
            }
        });
        btndistinta2termine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta2termineActionPerformed(evt);
            }
        });

        btndistinta3termine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta3termine.setText("Termine");
        btndistinta3termine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta3termineMouseReleased(evt);
            }
        });
        btndistinta3termine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta3termineActionPerformed(evt);
            }
        });

        btndistinta4termine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta4termine.setText("Termine");
        btndistinta4termine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta4termineMouseReleased(evt);
            }
        });
        btndistinta4termine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta4termineActionPerformed(evt);
            }
        });

        btndistinta5termine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta5termine.setText("Termine");
        btndistinta5termine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta5termineMouseReleased(evt);
            }
        });
        btndistinta5termine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta5termineActionPerformed(evt);
            }
        });

        btndistinta6termine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta6termine.setText("Termine");
        btndistinta6termine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta6termineMouseReleased(evt);
            }
        });
        btndistinta6termine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta6termineActionPerformed(evt);
            }
        });

        btndistinta7termine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta7termine.setText("Termine");
        btndistinta7termine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta7termineMouseReleased(evt);
            }
        });
        btndistinta7termine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta7termineActionPerformed(evt);
            }
        });

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsumapuntos.setText("0.00");
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total de puntos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Nombre comercial");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Distinta 7");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbidentificador.setForeground(new java.awt.Color(0, 0, 153));
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolormangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolormangaderecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Observaciones");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolormangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolormangaizquierda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorpechoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorpechoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorespalda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorotraubicacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorotraubicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorotraubicacion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorotraubicacion2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigomangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigomangaderecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigomangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigomangaizquierda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigopechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigopechoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigopechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigopechoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoespalda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigootraubicacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigootraubicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigootraubicacion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigootraubicacion2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnterminetodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnterminetodo.setText("Termine todo");
        btnterminetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterminetodoActionPerformed(evt);
            }
        });

        btneditarbordado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneditarbordado.setText("Editar bordado");
        btneditarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarbordadoActionPerformed(evt);
            }
        });

        lbdistinta2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndistinta1cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta1cancelar.setText("Cancelar");
        btndistinta1cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta1cancelarMouseReleased(evt);
            }
        });
        btndistinta1cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta1cancelarActionPerformed(evt);
            }
        });

        btndistinta2cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta2cancelar.setText("Cancelar");
        btndistinta2cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta2cancelarMouseReleased(evt);
            }
        });
        btndistinta2cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta2cancelarActionPerformed(evt);
            }
        });

        btndistinta3cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta3cancelar.setText("Cancelar");
        btndistinta3cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta3cancelarMouseReleased(evt);
            }
        });
        btndistinta3cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta3cancelarActionPerformed(evt);
            }
        });

        btndistinta4cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta4cancelar.setText("Cancelar");
        btndistinta4cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta4cancelarMouseReleased(evt);
            }
        });
        btndistinta4cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta4cancelarActionPerformed(evt);
            }
        });

        btndistinta5cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta5cancelar.setText("Cancelar");
        btndistinta5cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta5cancelarMouseReleased(evt);
            }
        });
        btndistinta5cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta5cancelarActionPerformed(evt);
            }
        });

        btndistinta6cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta6cancelar.setText("Cancelar");
        btndistinta6cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta6cancelarMouseReleased(evt);
            }
        });
        btndistinta6cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta6cancelarActionPerformed(evt);
            }
        });

        btndistinta7cancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta7cancelar.setText("Cancelar");
        btndistinta7cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btndistinta7cancelarMouseReleased(evt);
            }
        });
        btndistinta7cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta7cancelarActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Distinta 1");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Distinta 2");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Distinta 3");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Distinta 4");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Distinta 5");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Distinta 6");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndistinta3ponnchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta3ponnchado.setText("Ponchado");
        btndistinta3ponnchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta3ponnchadoActionPerformed(evt);
            }
        });

        btndistinta2ponnchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta2ponnchado.setText("Ponchado");
        btndistinta2ponnchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta2ponnchadoActionPerformed(evt);
            }
        });

        btndistinta1ponnchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta1ponnchado.setText("Ponchado");
        btndistinta1ponnchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta1ponnchadoActionPerformed(evt);
            }
        });

        btndistinta7ponnchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta7ponnchado.setText("Ponchado");
        btndistinta7ponnchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta7ponnchadoActionPerformed(evt);
            }
        });

        btndistinta6ponnchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta6ponnchado.setText("Ponchado");
        btndistinta6ponnchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta6ponnchadoActionPerformed(evt);
            }
        });

        btndistinta5ponnchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta5ponnchado.setText("Ponchado");
        btndistinta5ponnchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta5ponnchadoActionPerformed(evt);
            }
        });

        btndistinta4ponnchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta4ponnchado.setText("Ponchado");
        btndistinta4ponnchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta4ponnchadoActionPerformed(evt);
            }
        });

        lbdistinta1nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta1nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta2nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta2nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta3nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta3nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta4nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta4nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta6nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta6nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta5nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta5nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta7nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta7nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdistinta7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbdistinta7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Fecha de elaboración");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel21.setText("Prenda");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Identificador");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Estatus");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbestatus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbestatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbautorizacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbautorizacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroordenopedidosolicitado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumeroordenopedidosolicitado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Numero orden o pedido solicitado");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Numero de venta");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Puntos");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Puntos");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Puntos");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Puntos");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Puntos");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel28.setText("Puntos");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Puntos");
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos1.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos2.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos3.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos4.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos5.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos6.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos7.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnotraubicacion2ponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacion2ponchado1.setText("Replicar");
        btnotraubicacion2ponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacion2ponchado1ActionPerformed(evt);
            }
        });

        btnotraubicacionponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacionponchado1.setText("Replicar");
        btnotraubicacionponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacionponchado1ActionPerformed(evt);
            }
        });

        btnespaldaponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnespaldaponchado1.setText("Replicar");
        btnespaldaponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldaponchado1ActionPerformed(evt);
            }
        });

        btnpechoizquierdoponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoizquierdoponchado1.setText("Replicar");
        btnpechoizquierdoponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdoponchado1ActionPerformed(evt);
            }
        });

        btnpechoderechoponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoderechoponchado1.setText("Replicar");
        btnpechoderechoponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechoponchado1ActionPerformed(evt);
            }
        });

        btnmangaizquierdaponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaizquierdaponchado1.setText("Replicar");
        btnmangaizquierdaponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdaponchado1ActionPerformed(evt);
            }
        });

        btnmangaderechaponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaderechaponchado1.setText("Replicar");
        btnmangaderechaponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechaponchado1ActionPerformed(evt);
            }
        });

        btncargarponchado5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado5.setText("Cargar Ponchado");
        btncargarponchado5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado5ActionPerformed(evt);
            }
        });

        btncargarponchado4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado4.setText("Cargar Ponchado");
        btncargarponchado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado4ActionPerformed(evt);
            }
        });

        btncargarponchado3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado3.setText("Cargar Ponchado");
        btncargarponchado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado3ActionPerformed(evt);
            }
        });

        btncargarponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado1.setText("Cargar Ponchado");
        btncargarponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado1ActionPerformed(evt);
            }
        });

        btncargarponchado2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado2.setText("Cargar Ponchado");
        btncargarponchado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado2ActionPerformed(evt);
            }
        });

        btncargarponchado7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado7.setText("Cargar Ponchado");
        btncargarponchado7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado7ActionPerformed(evt);
            }
        });

        btncargarponchado6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado6.setText("Cargar Ponchado");
        btncargarponchado6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado6ActionPerformed(evt);
            }
        });

        lbsucursal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbsucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbsucursal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbsucursalMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel18)
                .addGap(7, 7, 7)
                .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel16)
                .addGap(7, 7, 7)
                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel19)
                .addGap(7, 7, 7)
                .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 379, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(lbtitulo))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(18, 18, 18)
                        .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel14)
                        .addGap(12, 12, 12)
                        .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(82, 82, 82)
                        .addComponent(jLabel15)
                        .addGap(11, 11, 11)
                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lbfechaelaboracion, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109)
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbdistinta1nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(lbdistinta1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(btndistinta1termine, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btndistinta1cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(lbcodigomangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lbcolormangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(btncargarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addComponent(btnpechoizquierdoponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btndistinta1ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(lbsumapuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbdistinta2nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbdistinta3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbdistinta4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbdistinta6nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbdistinta5nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbdistinta7nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbdistinta2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbdistinta3nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbdistinta4nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbdistinta6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbdistinta5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(lbdistinta7, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btndistinta2termine, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btndistinta3termine, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btndistinta4termine, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btndistinta5termine, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btndistinta6termine, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btndistinta7termine, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btndistinta2cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btndistinta3cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btndistinta4cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btndistinta5cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btndistinta6cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btndistinta7cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcodigomangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbcodigopechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbcodigopechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbcodigoespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbcodigootraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbcolorotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcolormangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbcolorpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbcolorpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbcolorespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbcolorotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbcodigootraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btncargarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btncargarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btncargarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btncargarponchado5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btncargarponchado6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btncargarponchado7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnpechoderechoponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnmangaizquierdaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(btnmangaderechaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(btnespaldaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnotraubicacionponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(btnotraubicacion2ponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btndistinta5ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndistinta6ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndistinta7ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btndistinta2ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndistinta3ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndistinta4ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbsumapuntos2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbsumapuntos3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbsumapuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsumapuntos5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsumapuntos6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsumapuntos7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(layout.createSequentialGroup()
                .addGap(777, 777, 777)
                .addComponent(btnterminetodo)
                .addGap(617, 617, 617)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lbtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 514, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfechaelaboracion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbdistinta1nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbdistinta1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndistinta1termine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndistinta1cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcodigomangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcolormangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncargarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpechoizquierdoponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndistinta1ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsumapuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbdistinta2nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbdistinta3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbdistinta4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbdistinta6nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbdistinta5nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbdistinta7nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbdistinta2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbdistinta3nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbdistinta4nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(lbdistinta6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbdistinta5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbdistinta7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btndistinta2termine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btndistinta3termine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btndistinta4termine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btndistinta5termine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btndistinta6termine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btndistinta7termine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btndistinta2cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(btndistinta3cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btndistinta4cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btndistinta5cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btndistinta6cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btndistinta7cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lbcodigomangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lbcodigopechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbcodigopechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lbcodigoespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbcodigootraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbcolorotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lbcolormangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(lbcolorpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbcolorpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(lbcolorespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbcolorotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbcodigootraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btncargarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btncargarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btncargarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btncargarponchado5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(btncargarponchado6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btncargarponchado7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btnpechoderechoponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnmangaizquierdaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnmangaderechaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnespaldaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(btnotraubicacionponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btnotraubicacion2ponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(btndistinta2ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btndistinta3ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btndistinta4ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btndistinta5ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btndistinta6ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btndistinta7ponnchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(lbsumapuntos2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbsumapuntos3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbsumapuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbsumapuntos5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(lbsumapuntos6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbsumapuntos7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        
    }//GEN-LAST:event_formWindowActivated

    private void rbextrachicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbextrachicaActionPerformed


    }//GEN-LAST:event_rbextrachicaActionPerformed

    private void rbchicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbchicaActionPerformed


    }//GEN-LAST:event_rbchicaActionPerformed

    private void rbmedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmedianaActionPerformed

    }//GEN-LAST:event_rbmedianaActionPerformed

    private void rbgrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbgrandeActionPerformed

    }//GEN-LAST:event_rbgrandeActionPerformed

    private void rbextragrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbextragrandeActionPerformed


    }//GEN-LAST:event_rbextragrandeActionPerformed

    private void rbtalla34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla34ActionPerformed


    }//GEN-LAST:event_rbtalla34ActionPerformed

    private void rbtalla36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla36ActionPerformed

    }//GEN-LAST:event_rbtalla36ActionPerformed

    private void rbtalla38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla38ActionPerformed


    }//GEN-LAST:event_rbtalla38ActionPerformed

    private void rbtalla40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla40ActionPerformed


    }//GEN-LAST:event_rbtalla40ActionPerformed

    private void rbtalla42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla42ActionPerformed


    }//GEN-LAST:event_rbtalla42ActionPerformed

    private void rbtalla44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla44ActionPerformed


    }//GEN-LAST:event_rbtalla44ActionPerformed

    private void rbtalla46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla46ActionPerformed


    }//GEN-LAST:event_rbtalla46ActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed

        ventanaordencamisaanteriores = false;
         if(ordenesporrealizar.ventanaordenesporrealizar==true)
        {
            ordenesporrealizar.btndatos.doClick();
        }

        this.dispose();

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordencamisaanteriores = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   
        
        datos();
        
        
         conectadaasucursal();
        
    }//GEN-LAST:event_formWindowOpened

    private void lbprendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbprendaMouseClicked
        String prenda = lbprenda.getText();
         cliente = lbcliente.getText();
        String imagen = "";
      
        String SQL = "";

        if (prenda.startsWith("Camisa")) {
            SQL = "SELECT camisa1 FROM catalogo_clientes where nombre = '" + cliente + "' ";
            imagen = "camisa1";
        } else if (prenda.startsWith("CAMISA2")) {
            SQL = "SELECT camisa2 FROM catalogo_clientes where nombre = '" + cliente + "' ";
            imagen = "camisa2";
        } else if (prenda.startsWith("CHAMARRA DESMON")) {
            SQL = "SELECT chamarra FROM catalogo_clientes where nombre = '" + cliente + "' ";
            imagen = "chamarra";
        } else if (prenda.startsWith("CHAMARRA ROMP")) {
    //SQL = "SELECT chaleco,chalecoextension FROM catalogo_clientes where codigo = '" + codigo + "' ";
        } else if (prenda.startsWith("CAMISOLA")) {
            SQL = "SELECT camisola FROM catalogo_clientes where nombre = '" + cliente + "' ";
            imagen = "camisola";
        } else if (prenda.startsWith("CHALECO")) {
            SQL = "SELECT chaleco FROM catalogo_clientes where nombre = '" + cliente + "' ";
            imagen = "chaleco";
        } else if (prenda.startsWith("SACO")) {
   // SQL = "SELECT chaleco,chalecoextension FROM catalogo_clientes where codigo = '" + codigo + "' ";
        }

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                byte[] img = rs.getBytes(imagen);
                //Resize The ImageIcon
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                lbfotomontaje.setIcon(newImage);
            } else {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No hay imagen que mostrar");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_lbprendaMouseClicked

    private void btndistinta2termineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta2termineActionPerformed

    if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta2_cantidad";
            ubicacionfecha = "distinta2_fecha";
          
            cantidadaplicacion = distinta2aplicacion;
         
            nombredelatabla = "historial_ordenes_distinta";
        
            
            insertarlacantidadylafechaenlaubicacion();
            

            descripcion = "BORDADO " + tipoprenda + " " + distinta2ubicacion + " " + distinta2nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta2ubicacion + " " + distinta2nombre + "";

          
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
            actualizarestatusentregaordendebordado();
            //sumapuntos(); 
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
            
            
        }    
         

    }//GEN-LAST:event_btndistinta2termineActionPerformed

    private void btndistinta4termineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta4termineActionPerformed

         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta4_cantidad";
            ubicacionfecha = "distinta4_fecha";
           
            cantidadaplicacion = distinta4aplicacion;
           
            nombredelatabla = "historial_ordenes_distinta";
         
            insertarlacantidadylafechaenlaubicacion();

            descripcion = "BORDADO " + tipoprenda + " " + distinta4ubicacion + " " + distinta4nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta4ubicacion + " " + distinta4nombre + "";

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
            actualizarestatusentregaordendebordado();
        //sumapuntos(); 
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
            
        } 
    
    }//GEN-LAST:event_btndistinta4termineActionPerformed

    private void btndistinta5termineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta5termineActionPerformed

         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta5_cantidad";
            ubicacionfecha = "distinta5_fecha";
           
            cantidadaplicacion = distinta5aplicacion;
            
         
            nombredelatabla = "historial_ordenes_distinta";
            
            insertarlacantidadylafechaenlaubicacion();

            descripcion = "BORDADO " + tipoprenda + " " + distinta5ubicacion + " " + distinta5nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta5ubicacion + " " + distinta5nombre + "";

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
            actualizarestatusentregaordendebordado();
            //sumapuntos(); 
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
            
            
            
        } 
         
    }//GEN-LAST:event_btndistinta5termineActionPerformed

    private void btndistinta3termineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta3termineActionPerformed
     
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta3_cantidad";
            ubicacionfecha = "distinta3_fecha";
            
            cantidadaplicacion = distinta3aplicacion;
       
            nombredelatabla = "historial_ordenes_distinta";
            
            insertarlacantidadylafechaenlaubicacion();

            descripcion = "BORDADO " + tipoprenda + " " + distinta3ubicacion + " " + distinta3nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta3ubicacion + " " + distinta3nombre + "";

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
            actualizarestatusentregaordendebordado();
            //sumapuntos(); 
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
            
            
            
        }  
        
    }//GEN-LAST:event_btndistinta3termineActionPerformed

    private void btndistinta1termineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta1termineActionPerformed

        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

          
            ubicacionfecha = "distinta1_fecha";
         
            cantidadaplicacion = distinta1aplicacion;
            
            nombredelatabla = "historial_ordenes_distinta";
            
            
            insertarlacantidadylafechaenlaubicacion();

            descripcion = "BORDADO " + tipoprenda + " " + distinta1ubicacion + " " + distinta1nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta1ubicacion + " " + distinta1nombre + "";

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
            actualizarestatusentregaordendebordado();
            //sumapuntos(); 
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
            
            
            
        }
            
           
        
        
    }//GEN-LAST:event_btndistinta1termineActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventanaordencamisaanteriores = false;
    }//GEN-LAST:event_formWindowClosed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed
       
        
        
        
        
        if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
   
        verfotomontajetiendalocal();
      
        
    }
    else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
       
       
         verfotomontajesucursal();
    }
        
        

    }//GEN-LAST:event_btnverfotomontajeActionPerformed

    private void btndistinta6termineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta6termineActionPerformed

       if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta6_cantidad";
            ubicacionfecha = "distinta6_fecha"; 
            
            cantidadaplicacion = distinta6aplicacion;
           
            nombredelatabla = "historial_ordenes_distinta";
            
            insertarlacantidadylafechaenlaubicacion();

            descripcion = "BORDADO " + tipoprenda + " " + distinta6ubicacion + " " + distinta6nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta6ubicacion + " " + distinta6nombre + "";

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
            actualizarestatusentregaordendebordado();
            //sumapuntos(); 
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
            
            
            
            
        } 
        
    }//GEN-LAST:event_btndistinta6termineActionPerformed

    private void btndistinta7termineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta7termineActionPerformed
       
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta7_cantidad";
            ubicacionfecha = "distinta7_fecha";
          
            
            cantidadaplicacion = distinta7aplicacion;
          
            nombredelatabla = "historial_ordenes_distinta";
            
            insertarlacantidadylafechaenlaubicacion();

            descripcion = "BORDADO " + tipoprenda + " " + distinta7ubicacion + " " + distinta7nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta7ubicacion + " " + distinta7nombre + "";

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
            actualizarestatusentregaordendebordado();
            //sumapuntos(); 
            
        } 
    }//GEN-LAST:event_btndistinta7termineActionPerformed

    private void btnterminetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterminetodoActionPerformed
      
        terminetodo = "si";
        
        
        for(int i = 0; i < listabotones.size(); i++)
        {
            Object boton =  listabotones.get(i);
            
            
            
            if(boton.equals("btndistinta1"))
            {
                btndistinta1termine.doClick();
            }
            else if(boton.equals("btndistinta2"))
            {
                btndistinta2termine.doClick();
            }
            else if(boton.equals("btndistinta3"))
            {
                btndistinta3termine.doClick();
            }
            else if(boton.equals("btndistinta4"))
            {
                btndistinta4termine.doClick();
            }
            else if(boton.equals("btndistinta5"))
            {
                btndistinta5termine.doClick();
            }
            else if(boton.equals("btndistinta6"))
            {
                btndistinta6termine.doClick();
            }
            else if(boton.equals("btndistinta7"))
            {
                btndistinta7termine.doClick();
            }
            
        }
        
        
        
        
         terminetodo = "no";
         btnterminetodo.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden se actualizo");
         
         if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
         listabotones.clear();
         
         this.dispose();
         
    }//GEN-LAST:event_btnterminetodoActionPerformed

    private void btneditarbordadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarbordadoActionPerformed

        if (bordadoseditar.ventanabordadosdelclienteeditar)

        {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La ventana de bordados de cliente ya está abierta");
        }
        else

        {

            bordadoseditar ventana = new bordadoseditar();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);

            bordadoseditar.lbcliente.setText(lbcliente.getText());
        bordadoseditar.lbnombrecomercial.setText(lbnombrecomercial.getText());
        bordadoseditar.lbbordacliente.setText(lbbordacliente.getText());
        bordadoseditar.txtidentificador.setText(lbidentificador.getText());
        bordadoseditar.lbcodigocliente.setText(codigocliente);
        bordadoseditar.lbconsecutivo.setText(consecutivo);
       
       
       
           bordadoseditar.lbprenda.setText(prenda);
           
           

        }
    }//GEN-LAST:event_btneditarbordadoActionPerformed

    private void btndistinta1cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta1cancelarActionPerformed
      
         String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
        
            
            
            
        
     if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta1_cantidad";
            String fecha = "distinta1_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
             
             
           
            cantidadaplicacion = distinta1aplicacion;
           
            nombredelatabla = "historial_ordenes_distinta";
           

            descripcion = "BORDADO " + tipoprenda + " " + distinta1ubicacion + " " + distinta1nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta1ubicacion + " " + distinta1nombre + "";
                         
            
           
            agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
            actualizarestatusentregaordendebordado();
            //sumapuntos();
            

            
            
        }
     
     
     
         lbautorizacion.setText("no");
                
                     }
            
        
        
        
        
        
       else
        {
            if (autorizacion.ventanaautorizacion == true)
            {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de autorización");
            }
            
            else
            {
            autorizacion ventana = new autorizacion();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            autorizacion.lbinterfaz.setText("distintacancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
        
        
        
        
     
    }//GEN-LAST:event_btndistinta1cancelarActionPerformed

    private void btndistinta2cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta2cancelarActionPerformed
      

      String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
        
            
            
            
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
        
            String ubicacion = "distinta2_cantidad";
            String fecha = "distinta2_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
            
            
           
            cantidadaplicacion = distinta2aplicacion;
          
            nombredelatabla = "historial_ordenes_distinta";
            


            descripcion = "BORDADO " + tipoprenda + " " + distinta2ubicacion + " " + distinta2nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta2ubicacion + " " + distinta2nombre + "";  

     
       agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
       actualizarestatusentregaordendebordado(); 
       //sumapuntos(); 
       
        }
        
        
            lbautorizacion.setText("no");
                
                     }
            
       else
        {
            if (autorizacion.ventanaautorizacion == true)
            {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de autorización");
            }
            
            else
            {
            autorizacion ventana = new autorizacion();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            autorizacion.lbinterfaz.setText("distintacancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
    }//GEN-LAST:event_btndistinta2cancelarActionPerformed

    private void btndistinta3cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta3cancelarActionPerformed
    
        
   String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
        
            
            
            
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            String ubicacion = "distinta3_cantidad";
            String fecha = "distinta3_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
            
            
           
           cantidadaplicacion = distinta3aplicacion;
         
           nombredelatabla = "historial_ordenes_distinta";
           
           
             
            descripcion = "BORDADO " + tipoprenda + " " + distinta3ubicacion + " " + distinta3nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta3ubicacion + " " + distinta3nombre + "";  
            
      
       agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
       actualizarestatusentregaordendebordado(); 
      // sumapuntos();
            
        }
        
        
            lbautorizacion.setText("no");
                
                     }
            
       else
        {
            if (autorizacion.ventanaautorizacion == true)
            {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de autorización");
            }
            
            else
            {
            autorizacion ventana = new autorizacion();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            autorizacion.lbinterfaz.setText("distintacancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
        
    }//GEN-LAST:event_btndistinta3cancelarActionPerformed

    private void btndistinta4cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta4cancelarActionPerformed
      
        
        String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
        
            
            
            
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
           String ubicacion = "distinta4_cantidad";
           String fecha = "distinta4_fecha";
           eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha); 
            
            
           
           cantidadaplicacion = distinta4aplicacion;
         
           nombredelatabla = "historial_ordenes_distinta";
          
           
          
            descripcion = "BORDADO " + tipoprenda + " " + distinta4ubicacion + " " + distinta4nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta4ubicacion + " " + distinta4nombre + "";  

     
       agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) descripcionaplicacon);   
       actualizarestatusentregaordendebordado(); 
       //sumapuntos();   
        
             
            
        }
        
            lbautorizacion.setText("no");
                
                     }
            
       else
        {
            if (autorizacion.ventanaautorizacion == true)
            {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de autorización");
            }
            
            else
            {
            autorizacion ventana = new autorizacion();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            autorizacion.lbinterfaz.setText("distintacancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
        
    }//GEN-LAST:event_btndistinta4cancelarActionPerformed

    private void btndistinta5cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta5cancelarActionPerformed
      
        String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
        
            
            
            
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            String ubicacion = "distinta5_cantidad";
            String fecha = "distinta5_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
            
            
         
           cantidadaplicacion = distinta5aplicacion;
          
           nombredelatabla = "historial_ordenes_distinta";
           

            descripcion = "BORDADO " + tipoprenda + " " + distinta5ubicacion + " " + distinta5nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta5ubicacion + " " + distinta5nombre + "";  

     
       agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) descripcionaplicacon);   
       actualizarestatusentregaordendebordado();
       //sumapuntos();       
            
        }
        
        
            lbautorizacion.setText("no");
                
                     }
            
       else
        {
            if (autorizacion.ventanaautorizacion == true)
            {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de autorización");
            }
            
            else
            {
            autorizacion ventana = new autorizacion();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            autorizacion.lbinterfaz.setText("distintacancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
    }//GEN-LAST:event_btndistinta5cancelarActionPerformed

    private void btndistinta6cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta6cancelarActionPerformed
      
        
       String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
        
            
            
            
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            String ubicacion = "distinta5_cantidad";
            String fecha = "distinta5_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
            
            
         
            cantidadaplicacion = distinta6aplicacion;
           
            nombredelatabla = "historial_ordenes_distinta";
            


            descripcion = "BORDADO " + tipoprenda + " " + distinta6ubicacion + " " + distinta6nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta6ubicacion + " " + distinta6nombre + "";  
            
         
            agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
            actualizarestatusentregaordendebordado();
           // sumapuntos();
            
        }
        
        
            lbautorizacion.setText("no");
                
                     }
            
       else
        {
            if (autorizacion.ventanaautorizacion == true)
            {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de autorización");
            }
            
            else
            {
            autorizacion ventana = new autorizacion();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            autorizacion.lbinterfaz.setText("distintacancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
    }//GEN-LAST:event_btndistinta6cancelarActionPerformed

    private void btndistinta7cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta7cancelarActionPerformed
      
        
     String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
        
            
            
            
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            String ubicacion = "distinta7_cantidad";
            String fecha = "distinta7_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
            
            
         
            cantidadaplicacion = distinta7aplicacion;
            
            nombredelatabla = "historial_ordenes_distinta";
            

            descripcion = "BORDADO " + tipoprenda + " " + distinta7ubicacion + " " + distinta7nombre + " ";
            descripcionaplicacon = "APLICACION " + tipoprenda + " " + distinta7ubicacion + " " + distinta7nombre + "";  

       
            agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) descripcionaplicacon);
            actualizarestatusentregaordendebordado();
          //  sumapuntos();
            
        }
        
        
            lbautorizacion.setText("no");
                
                     }
            
       else
        {
            if (autorizacion.ventanaautorizacion == true)
            {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de autorización");
            }
            
            else
            {
            autorizacion ventana = new autorizacion();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            autorizacion.lbinterfaz.setText("distintacancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
        
    }//GEN-LAST:event_btndistinta7cancelarActionPerformed

    private void btndistinta3ponnchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta3ponnchadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndistinta3ponnchadoActionPerformed

    private void btndistinta2ponnchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta2ponnchadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndistinta2ponnchadoActionPerformed

    private void btndistinta1ponnchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta1ponnchadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndistinta1ponnchadoActionPerformed

    private void btndistinta7ponnchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta7ponnchadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndistinta7ponnchadoActionPerformed

    private void btndistinta6ponnchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta6ponnchadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndistinta6ponnchadoActionPerformed

    private void btndistinta5ponnchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta5ponnchadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndistinta5ponnchadoActionPerformed

    private void btndistinta4ponnchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta4ponnchadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btndistinta4ponnchadoActionPerformed

    private void btndistinta1termineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta1termineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta1termineMouseReleased

    private void btndistinta2termineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta2termineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta2termineMouseReleased

    private void btndistinta3termineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta3termineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta3termineMouseReleased

    private void btndistinta4termineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta4termineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta4termineMouseReleased

    private void btndistinta5termineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta5termineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta5termineMouseReleased

    private void btndistinta6termineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta6termineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta6termineMouseReleased

    private void btndistinta7termineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta7termineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta7termineMouseReleased

    private void btndistinta1cancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta1cancelarMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta1cancelarMouseReleased

    private void btndistinta2cancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta2cancelarMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta2cancelarMouseReleased

    private void btndistinta3cancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta3cancelarMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta3cancelarMouseReleased

    private void btndistinta4cancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta4cancelarMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta4cancelarMouseReleased

    private void btndistinta5cancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta5cancelarMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta5cancelarMouseReleased

    private void btndistinta6cancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta6cancelarMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta6cancelarMouseReleased

    private void btndistinta7cancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btndistinta7cancelarMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btndistinta7cancelarMouseReleased

    private void btnotraubicacion2ponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacion2ponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnotraubicacion2ponchado1ActionPerformed

    private void btnotraubicacionponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacionponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnotraubicacionponchado1ActionPerformed

    private void btnespaldaponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldaponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnespaldaponchado1ActionPerformed

    private void btnpechoizquierdoponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdoponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpechoizquierdoponchado1ActionPerformed

    private void btnpechoderechoponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechoponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpechoderechoponchado1ActionPerformed

    private void btnmangaizquierdaponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdaponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmangaizquierdaponchado1ActionPerformed

    private void btnmangaderechaponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechaponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmangaderechaponchado1ActionPerformed

    private void btncargarponchado5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncargarponchado5ActionPerformed

    private void btncargarponchado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncargarponchado4ActionPerformed

    private void btncargarponchado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncargarponchado3ActionPerformed

    private void btncargarponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncargarponchado1ActionPerformed

    private void btncargarponchado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncargarponchado2ActionPerformed

    private void btncargarponchado7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncargarponchado7ActionPerformed

    private void btncargarponchado6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncargarponchado6ActionPerformed

    private void lbsucursalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbsucursalMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lbsucursalMouseClicked



    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ordendistintaS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordendistintaS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordendistintaS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordendistintaS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordendistintaS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncargarponchado1;
    private javax.swing.JButton btncargarponchado2;
    private javax.swing.JButton btncargarponchado3;
    private javax.swing.JButton btncargarponchado4;
    private javax.swing.JButton btncargarponchado5;
    private javax.swing.JButton btncargarponchado6;
    private javax.swing.JButton btncargarponchado7;
    public static javax.swing.JButton btndistinta1cancelar;
    private javax.swing.JButton btndistinta1ponnchado;
    private javax.swing.JButton btndistinta1termine;
    public static javax.swing.JButton btndistinta2cancelar;
    private javax.swing.JButton btndistinta2ponnchado;
    private javax.swing.JButton btndistinta2termine;
    public static javax.swing.JButton btndistinta3cancelar;
    private javax.swing.JButton btndistinta3ponnchado;
    private javax.swing.JButton btndistinta3termine;
    public static javax.swing.JButton btndistinta4cancelar;
    private javax.swing.JButton btndistinta4ponnchado;
    private javax.swing.JButton btndistinta4termine;
    public static javax.swing.JButton btndistinta5cancelar;
    private javax.swing.JButton btndistinta5ponnchado;
    private javax.swing.JButton btndistinta5termine;
    public static javax.swing.JButton btndistinta6cancelar;
    private javax.swing.JButton btndistinta6ponnchado;
    private javax.swing.JButton btndistinta6termine;
    public static javax.swing.JButton btndistinta7cancelar;
    private javax.swing.JButton btndistinta7ponnchado;
    private javax.swing.JButton btndistinta7termine;
    private javax.swing.JButton btneditarbordado;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnespaldaponchado1;
    private javax.swing.JButton btnmangaderechaponchado1;
    private javax.swing.JButton btnmangaizquierdaponchado1;
    private javax.swing.JButton btnotraubicacion2ponchado1;
    private javax.swing.JButton btnotraubicacionponchado1;
    private javax.swing.JButton btnpechoderechoponchado1;
    private javax.swing.JButton btnpechoizquierdoponchado1;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JLabel lbautorizacion;
    public static javax.swing.JLabel lbbordacliente;
    public static javax.swing.JLabel lbcantidad;
    public javax.swing.JLabel lbcantidad1;
    public javax.swing.JLabel lbcantidad2;
    public javax.swing.JLabel lbcantidad3;
    public javax.swing.JLabel lbcantidad4;
    public javax.swing.JLabel lbcantidad5;
    public javax.swing.JLabel lbcantidad6;
    public javax.swing.JLabel lbcantidad7;
    public static javax.swing.JLabel lbcliente;
    public javax.swing.JLabel lbcodigoespalda;
    public javax.swing.JLabel lbcodigomangaderecha;
    public javax.swing.JLabel lbcodigomangaizquierda;
    public javax.swing.JLabel lbcodigootraubicacion;
    public javax.swing.JLabel lbcodigootraubicacion2;
    public javax.swing.JLabel lbcodigopechoderecho;
    public javax.swing.JLabel lbcodigopechoizquierdo;
    public javax.swing.JLabel lbcolorespalda;
    public javax.swing.JLabel lbcolormangaderecha;
    public javax.swing.JLabel lbcolormangaizquierda;
    public javax.swing.JLabel lbcolorotraubicacion;
    public javax.swing.JLabel lbcolorotraubicacion2;
    public javax.swing.JLabel lbcolorpechoderecho;
    public javax.swing.JLabel lbcolorpechoizquierdo;
    public static javax.swing.JLabel lbdistinta1;
    public static javax.swing.JLabel lbdistinta1nombre;
    public static javax.swing.JLabel lbdistinta2;
    public static javax.swing.JLabel lbdistinta2nombre;
    public static javax.swing.JLabel lbdistinta3;
    public static javax.swing.JLabel lbdistinta3nombre;
    public static javax.swing.JLabel lbdistinta4;
    public static javax.swing.JLabel lbdistinta4nombre;
    public static javax.swing.JLabel lbdistinta5;
    public static javax.swing.JLabel lbdistinta5nombre;
    public static javax.swing.JLabel lbdistinta6;
    public static javax.swing.JLabel lbdistinta6nombre;
    public static javax.swing.JLabel lbdistinta7;
    public static javax.swing.JLabel lbdistinta7nombre;
    public static javax.swing.JLabel lbestatus;
    public static javax.swing.JLabel lbfechaelaboracion;
    private javax.swing.JLabel lbfotomontaje;
    public static javax.swing.JLabel lbidentificador;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbnumerodeventa;
    public static javax.swing.JLabel lbnumeroordenopedidosolicitado;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    public static javax.swing.JLabel lbprenda;
    public static javax.swing.JLabel lbsucursal;
    public javax.swing.JLabel lbsumapuntos;
    public javax.swing.JLabel lbsumapuntos1;
    public javax.swing.JLabel lbsumapuntos2;
    public javax.swing.JLabel lbsumapuntos3;
    public javax.swing.JLabel lbsumapuntos4;
    public javax.swing.JLabel lbsumapuntos5;
    public javax.swing.JLabel lbsumapuntos6;
    public javax.swing.JLabel lbsumapuntos7;
    public static javax.swing.JLabel lbtipo;
    private javax.swing.JLabel lbtitulo;
    // End of variables declaration//GEN-END:variables

    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();

}
