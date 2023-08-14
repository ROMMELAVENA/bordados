package sistemabordadores;

import java.applet.AudioClip;


import java.io.FileInputStream;


import java.net.InetAddress;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


import javax.swing.Icon;

import javax.swing.JFileChooser;

import java.awt.Color;
import java.awt.Font;

import java.awt.Image;


import java.io.ByteArrayInputStream;

import java.io.InputStream;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

import javax.swing.DefaultComboBoxModel;


import java.util.logging.Level;
import java.util.logging.Logger;


import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import javax.swing.JOptionPane;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.Blob;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.awt.Desktop;
import java.io.OutputStream;
import static sistemabordadores.ordengorraS.lbbordacliente;
import static sistemabordadores.ordengorraS.lbcliente;

public class ordencamisaS extends javax.swing.JFrame {

    public static boolean ventanaordencamisa = false;
    public static String ordenbordadocamisa = "";
    
    String nuevoestatusorden = "";
    
    String cliente = "";
    String bordadosdisponiblesstring = "0";
    int bordadosdisponiblesint = 0;
    String cantidadprendasstring = "";
    int cantidadprendasint = 0;
    String cantidad = "";
    int remanentebordadosint = 0;
    String remanentebordadosstring = "";
    int nuevoremanentebordadosint = 0;
    String nuevoremanentebordadossstring = "";
    String numerodeventa = "";
    String fechaubicacion = "";
    String ubicacion = "";
    Connection cnsucursal = null;
    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;
    String cantidadaplicacion = "";
    String nuevosbordadosutilizadosstring = "";
    int nuevosbordadosutilizadosint = 0;
    String ubicacionprenda = "";
    String primero = "";
    String ultimo = "";
    String nombrebordado = "";
    int traspaso = 0;
    String ipsucursal = "";
    
    String numeroordendeenviosolicitada = "";
    String numerohistorialordenbordadorecibida = "";
    String numerosucursal = "";
    String sucursal = "";
    String numerosolicitoarticulos = "";
    String tiendasolicitoarticulos = "";

    String numeroordenenvio = "";
    String tiendaordenenvio = "";
    String tiendalocal = principal.tiendalocal;
    String iplocal = principal.lbiplocal.getText();
    String codigocliente = "";
    String lugar = "";
    String prenda ="";
    String ubicacionponchado = "";
    String ubicacionponchadonombre = "";
   
    String numeroordendebordadosolicitadoorecibidasisehabredesderecibidas = "";

    ///// para insertar
    
    String descripcion = ""; 
    String aplicacioninsertar = "";
    
    String rutadelip = "";
    
    
    String mangaderechanombre = "ninguno";
    String mangaizquierdanombre = "ninguno";
    String pechoderechonombre = "ninguno";
    String pechoizquierdonombre = "ninguno";
    String espaldanombre = "ninguno";
    String otraubicacionnombre = "ninguno";
    String otraubicacion2nombre = "ninguno";
    
    String aplicacionmangaderecha = "0";
    String aplicacionmangaizquierda = "0";
    String aplicacionpechoderecho = "0";
    String aplicacionpechoizquierdo = "0"; 
    String aplicacionespalda = "0";
    String aplicacionotraubicacion = "0";
    String aplicacionotraubicacion2 = "0";
    String tienefotomontaje = "no";
    
    String rutaimagen = "";
    
    String ruta1= "";
    String ruta2= "";
    String ruta3= "";
    String ruta4= "";
    String ruta5= "";
    String ruta6= "";
    String ruta7= "";
    
    String rutaarchivo = "";
    String  nombrearchivo = "";
    
    
    int botonesactivados = 0;
    
    
    public static String ordencamisaautorizacion = "";
    public static String enquesucursalsebordara ="";
    public static String esponchado = "";
 
    
    public static String tipotabla ="";
    String nombredelatabla ="";
    
    String terminetodo = "";
    
    String identificador = "";
    
    String consecutivo = "";
    String tieneunaobservacion = "";
    
    
    String hilo1seleccionado = "";
    String hilo2seleccionado = "";
    String hilo3seleccionado = "";
    String hilo4seleccionado = "";
    String hilo5seleccionado = "";
    String hilo6seleccionado = "";
    String hilo7seleccionado = "";
    
    String color1seleccionado = "";
    String color2seleccionado = "";
    String color3seleccionado = "";
    String color4seleccionado = "";
    String color5seleccionado = "";
    String color6seleccionado = "";
    String color7seleccionado = "";
    
    
    String tienenumerodesucursal = "";
    String numerosucursalordencamisa = "";
    String rutadedondeestanlosbordados = "";
    
    
    String cantidadpechoizquierdo = "";
    String cantidadpechoderecho = "";
    String cantidadmangaizquierda = "";
    String cantidadmangaderecha = "";
    String cantidadespalda = "";
    String cantidadotraubicacion = "";
    String cantidadotraubicacion2 = "";
    String numeroordenopedidorecibido = "";
    
    
    ArrayList<String> listabotones = new ArrayList<String>();
    ArrayList<String> listahilos = new ArrayList<String>();
    
     
     String consecutivobordado = "";
    String tiendeordenopedido = "";
    String tiendaconectada = "";
    
    
    
    public static final Color anaranjado = new Color(255,166,77);
    
    
    

    public ordencamisaS() 
    {
        initComponents();
        ventanaordencamisa = true;
         lbautorizacion.setVisible(false);
        lbtipo.setVisible(false);

        btnterminetodo.setEnabled(false);
     //   btndatos.setVisible(false);
        
        
        btnpechoizquierdocancelar.setEnabled(false);
        btnpechoderechocancelar.setEnabled(false);
        btnmangaizquierdacancelar.setEnabled(false);
        btnmangaderechacancelar.setEnabled(false);
        btnespaldacancelar.setEnabled(false);
        btnotraubicacioncancelar.setEnabled(false);
        btnotraubicacion2cancelar.setEnabled(false);
        
        btnreplicar1.setEnabled(false);
        btnreplicar2.setEnabled(false);
        btnreplicar3.setEnabled(false);
        btnreplicar4.setEnabled(false);
        btnreplicar5.setEnabled(false);
        btnreplicar6.setEnabled(false);
        btnreplicar7.setEnabled(false);
        btnreplicartodoslosponchados.setEnabled(false);
        
        btnquitarponchado1.setEnabled(false);
        btnquitarponchado2.setEnabled(false);
        btnquitarponchado3.setEnabled(false);
        btnquitarponchado4.setEnabled(false);
        btnquitarponchado5.setEnabled(false);
        btnquitarponchado6.setEnabled(false);
        btnquitarponchado7.setEnabled(false);
        
     
        
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:\\sistema\\tallas.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(lbltallas.getWidth(), lbltallas.getHeight(), Image.SCALE_DEFAULT));
    lbltallas.setIcon(imageIcon);

       
        tiendalocal = principal.lbtiendalocal.getText();
        
        
        
        if(tiendalocal.equals("cdmxcentro"))
        {
            rutadedondeestanlosbordados = "C:\\onedrive\\PONCHADOS\\MEXICO CENTRO\\ponchados";
        }
        else if(tiendalocal.equals("cdmxsur"))
        {
            rutadedondeestanlosbordados = "C:\\onedrive\\PONCHADOS\\MEXICO SUR\\PONCHADOS";
        }
        else if(tiendalocal.equals("guadalajara"))
        {
            rutadedondeestanlosbordados = "C:\\onedrive\\PONCHADOS\\GUADALAJARA\\PONCHADOS";
        }
      
        else if(tiendalocal.equals("monterrey"))
        {
            rutadedondeestanlosbordados = "C:\\onedrive\\PONCHADOS\\MONTERREY\\PONCHADOS";
        }
          else if(tiendalocal.equals("tijuana"))
        {
            rutadedondeestanlosbordados = "C:\\Users\\Mostrador DFNorte\\OneDrive\\PONCHADOS\\TIJUANA\\PONCHADOS SINCRONIZADOS";
        }
        
        

    }

    
    
    
    
    
    
      void codigoycolordehilo()
    {
        
        
        
        
        
                        String color1 = "";;
                        String color2 = "";
                        String color3 = "";
                        String color4 = "";
                        String color5 = "";
                        String color6 = "";
                        String color7 = "";
                        
                        String hilo1 = "";
                        String hilo2 = "";
                        String hilo3 = "";
                        String hilo4 = "";
                        String hilo5 = "";
                        String hilo6 = "";
                        String hilo7 = "";
        
        
        
        
        
        
        
        
        
        
        
        String sql = "SELECT color1,color2,color3,color4,color5,color6,color7,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7 FROM bordados_puntadas where identificador_prenda = '"+lbidentificador.getText()+"' AND nombre = '"+lbcliente.getText()+"' ";


            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                    
                    if (prenda.equals("Chaleco"))
                        
                    {
                        
                        
                       color1 = rs.getString("color1");
                       color2 = rs.getString("color2");
                       
                       color5 = rs.getString("color3");
                       color6 = rs.getString("color4");
                       color7 = rs.getString("color5");
                        
                       hilo1 = rs.getString("hilo1");
                       hilo2 = rs.getString("hilo2");
                       
                       hilo5 = rs.getString("hilo3");
                       hilo6 = rs.getString("hilo4");
                       hilo7 = rs.getString("hilo5");
                        
                        
                    }
                    else
                    {
                            
                       color1 = rs.getString("color1");
                       color2 = rs.getString("color2");
                       color3 = rs.getString("color3");
                       color4 = rs.getString("color4");
                       color5 = rs.getString("color5");
                       color6 = rs.getString("color6");
                       color7 = rs.getString("color7");
                        
                       hilo1 = rs.getString("hilo1");
                       hilo2 = rs.getString("hilo2");
                       hilo3 = rs.getString("hilo3");
                       hilo4 = rs.getString("hilo4");
                       hilo5 = rs.getString("hilo5");
                       hilo6 = rs.getString("hilo6");
                       hilo7 = rs.getString("hilo7");
                        
                        
                    }
                                              
                        
                        if (color1.equals("ninguno") || color1.equals("0")){}else{lbcolor1.setText(color1);}
                        if (color2.equals("ninguno") || color2.equals("0")){}else{lbcolor2.setText(color2);}
                        if (color3.equals("ninguno") || color3.equals("0")){}else{lbcolor3.setText(color3);}
                        if (color4.equals("ninguno") || color4.equals("0")){}else{lbcolor4.setText(color4);}
                        if (color5.equals("ninguno") || color5.equals("0")){}else{lbcolor5.setText(color5);}
                        if (color6.equals("ninguno") || color6.equals("0")){}else{lbcolor6.setText(color6);}
                        if (color7.equals("ninguno") || color7.equals("0")){}else{lbcolor7.setText(color7);}
                       
                       
                        
                        
                        if (hilo1.equals("ninguno") || hilo1.equals("0")){}else{lbhilo1.setText(hilo1);}
                         if (hilo2.equals("ninguno") || hilo2.equals("0")){}else{lbhilo2.setText(hilo2);}
                          if (hilo3.equals("ninguno") || hilo3.equals("0")){}else{lbhilo3.setText(hilo3);}
                           if (hilo4.equals("ninguno") || hilo4.equals("0")){}else{lbhilo4.setText(hilo4);}
                            if (hilo5.equals("ninguno") || hilo5.equals("0")){}else{lbhilo5.setText(hilo5);}
                             if (hilo6.equals("ninguno") || hilo6.equals("0")){}else{lbhilo6.setText(hilo6);}
                              if (hilo7.equals("ninguno") || hilo7.equals("0")){}else{lbhilo7.setText(hilo7);}
                     
                    
                    
                        
                        
                         
                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
     void datoscolorido()
    {
        
        
        
        
        
        
        
        
        String sql = "SELECT color1,color2,color3,color4,color5,color6,color7,color8,color9,color10,color11,color12,color13,color14,color15,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,hilo8,hilo9,hilo10,hilo11,hilo12,hilo13,hilo14,hilo15 FROM colorido_bordados where nombrebordado = '"+nombrebordado+"' and codigo = '"+codigocliente+"' AND nombre = '"+lbcliente.getText()+"' ";


            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                       
                       
                       
                        
                        
                        
                         
                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        
        
    }
    
     
     
     
     void datos(){
         
         
           
        prenda = lbprenda.getText();
        nombredelatabla = "historial_ordenes_camisa";
        
    if(enquesucursalsebordara.equals("Esta sucursal"))    
    {
        
        
        
     try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     codigocliente();
     
      cliente();
     
   
     
     try {    
            cargarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }

      
      if(enquesucursalsebordara.equals("Otra sucursal"))
        {
        btnterminetodo.setEnabled(false);
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Recuerda que Aqui solo replicas los ponchados y el fotomontaje");
        
        }
     
        
        
    } 
    
    
    
    
    
    
    
    else if(enquesucursalsebordara.equals("Otra sucursal") )    
    {
        
        nombredelatabla = "historial_ordenes_camisa_recibidas";
        
         try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
         
       
    }   
      datoscolorido();  
      sumapuntos();
      
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
         
       // joption en 2 renglones tip
       
String[] lineas = observacion.split("\n");

String mensaje = "<HTML><span style=\"Color:red;font-size:25px;\">NOTA: " + lineas[0] + "</span><br>";
if (lineas.length > 1) {
    mensaje += "<span style=\"Color:red; font-size:25px;\">" + lineas[1] + "</span>";
}

JOptionPane.showMessageDialog(null, mensaje);



        }
      
        
        
        
        
        
        
        
         
     }
     
     
     
     
     
     
     
    
    void datostiendalocal() throws IOException {

        
        
        numeroordendebordadosolicitadoorecibidasisehabredesderecibidas = lborden.getText();

        String botonhabilitado1 = "si";
        String botonhabilitado2 = "si";
        String botonhabilitado3 = "si";
        String botonhabilitado4 = "si";
        String botonhabilitado5 = "si";
        String botonhabilitado6 = "si";
        String botonhabilitado7 = "si";
        
        

        String sql = "Select fecha,hora,cliente,nombre_comercial,borda_cliente,numero_venta,numero_orden,cantidad,cantidad,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,"
                + "   pecho_izquierdo_puntadas,pecho_derecho_puntadas,manga_izquierda_puntadas,manga_derecha_puntadas,espalda_puntadas,otra_ubicacion_puntadas,otra_ubicacion2_puntadas,"
                + "   pecho_izquierdo_cantidad,pecho_derecho_cantidad,manga_izquierda_cantidad,manga_derecha_cantidad,espalda_cantidad,"
                + "   pecho_izquierdo_nombre,pecho_derecho_nombre,manga_izquierda_nombre,manga_derecha_nombre,espalda_nombre,"
                + "   otra_ubicacion_puntadas,otra_ubicacion_nombre,otra_ubicacion_cantidad,otra_ubicacion2_puntadas,otra_ubicacion2_nombre,otra_ubicacion2_cantidad,"
                + "   aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2,"
                + "   aplicacion_pecho_izquierdo_color,aplicacion_pecho_derecho_color,aplicacion_manga_izquierda_color,aplicacion_manga_derecha_color,aplicacion_espalda_color,aplicacion_otra_ubicacion_color,aplicacion_otra_ubicacion2_color,"
                + "   lugar,estatus_orden,identificador_prenda,tienda,numero_historial_camisa_recibida from historial_ordenes_camisa where numero = '" + numeroordendebordadosolicitadoorecibidasisehabredesderecibidas + "' ";

        
        
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
               
                lbnombrecomercial.setText( rs.getString("nombre_comercial"));
                
               
                lbbordacliente.setText( rs.getString("borda_cliente"));
               
                numerodeventa = rs.getString("numero_venta");
                lbnumerodeventa.setText(numerodeventa);
                
                numeroordendeenviosolicitada =  rs.getString("numero_orden");
                
                lbprenda.setText(rs.getString("prenda"));
                prenda = (rs.getString("prenda"));
                lbfecha.setText(rs.getString("fecha"));
                
                cantidad = rs.getString("cantidad");
                lbcantidad.setText(cantidad);
                
                lbdiaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));
               
                
                identificador = rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                
               lugar = rs.getString("lugar");
               
               numerohistorialordenbordadorecibida = rs.getString("numero_historial_camisa_recibida");
               lbnumeroordenbordadodelaotrasucursal.setText(numerohistorialordenbordadorecibida);
               
               
               
               
              
                

                String observacion = rs.getString("observacion");

                if(observacion == null || observacion.equals("")||observacion.equals(" ") )
                {
                    
                }
                else
                {
                tieneunaobservacion="si";    
                lbobservaciones.setText(observacion);
             
                
                }
                

                sucursal=rs.getString("tienda");
                
                
                
                
                
                
                  pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre");
                  lbpechoizquierdonombre.setText(pechoizquierdonombre);
              
                  String pechoizquierdo = rs.getString("pecho_izquierdo_puntadas");
                  
                if (pechoizquierdo == null || pechoizquierdo.equals("") || pechoizquierdo.equals("ninguno")) {

                   
                    botonhabilitado1 = "no";
                     btnponchado1.setEnabled(false);
                 
                    
                }
                 else
                {
                    
                    lbpechoizquierdo.setText(pechoizquierdo);
                     
                     botonhabilitado1 = "si";
                 
                 btnponchado1.setEnabled(true);
                     
                     
                     
                }
                
                
                
                
                
                
                
                
                 pechoderechonombre = rs.getString("pecho_derecho_nombre");
                 lbpechoderechonombre.setText(pechoderechonombre);
                
                String pechoderecho = rs.getString("pecho_derecho_puntadas");
                
              
                if (pechoderecho == null || pechoderecho.equals("")  || pechoderecho.equals("ninguno")) {

                  
                    botonhabilitado2 = "no";
                    
                     btnponchado2.setEnabled(false);
                  

                }
                 else
                {
                    
                    lbpechoderecho.setText(pechoderecho);
                    
                     botonhabilitado2 = "si";
                     
                     btnponchado2.setEnabled(true);
                     
                }
                
                
                
                

              
                
                  mangaizquierdanombre = rs.getString("manga_izquierda_nombre");
                  lbmangaizquierdanombre.setText(mangaizquierdanombre);
                  
                  String mangaizquierda = rs.getString("manga_izquierda_puntadas");
                  
             
                if (mangaizquierda == null || mangaizquierda.equals("") || mangaizquierda.equals("ninguno")) {

                   
                    botonhabilitado3 = "no";
                    
                    btnponchado3.setEnabled(false);
                  

                }
                 else
                {
                    
                    lbmangaizquierda.setText(mangaizquierda);
                   
                      botonhabilitado3 = "si";
                      
                      btnponchado3.setEnabled(true);
                   
                     
                }
                
                
                
                mangaderechanombre = rs.getString("manga_derecha_nombre");
                lbmangaderechanombre.setText(mangaderechanombre);
                
                String mangaderecha = rs.getString("manga_derecha_puntadas");
               
               
                if (mangaderecha == null || mangaderecha.equals("")   || mangaderecha.equals("ninguno")) 
                {

                  
                    botonhabilitado4 = "no";
                    
                    btnponchado4.setEnabled(false);
                   

                }
                 else
                {
                    
                     lbmangaderecha.setText(mangaderecha);
                     
                     botonhabilitado4 = "si";
                     
                      btnponchado4.setEnabled(true);
                    
                }


                espaldanombre = rs.getString("espalda_nombre");
                lbespaldanombre.setText(espaldanombre);
                
                String espalda = rs.getString("espalda_puntadas");
                
               
                if (espalda == null || espalda.equals("")  || espalda.equals("ninguno")) {

                 
                    botonhabilitado5 = "no";
                    
                    btnponchado5.setEnabled(false);
                  
                   
                }
                 else
                {
                    
                    lbespalda.setText(espalda);
                    
                      botonhabilitado5 = "si";
                      
                       btnponchado5.setEnabled(true);
                   
                }
                


                otraubicacionnombre = rs.getString("otra_ubicacion_nombre");
                lbotraubicacionnombre.setText(otraubicacionnombre);
                
                String otraubicacion = rs.getString("otra_ubicacion_puntadas");
               
             
                if (otraubicacion == null || otraubicacion.equals("")  || otraubicacion.equals("ninguno")) {

                   
                    botonhabilitado6 = "no";
                    
                    btnponchado6.setEnabled(false);
                  

                }
                 else
                {
                    
                     lbotraubicacion.setText(otraubicacion);
                    
                      botonhabilitado6 = "si";
                      
                       btnponchado6.setEnabled(true);
                 
                }

                
                otraubicacion2nombre = rs.getString("otra_ubicacion2_nombre");
                lbotraubicacion2nombre.setText(otraubicacion2nombre);
                
                String otraubicacion2 = rs.getString("otra_ubicacion2_puntadas");
               
              
                if (otraubicacion2 == null || otraubicacion2.equals("")   || otraubicacion2.equals("ninguno")) {

                   
                    botonhabilitado7 = "no";
                    
                     btnponchado7.setEnabled(false);
                   
                    

                }
                else
                {
                    
                     lbotraubicacion2.setText(otraubicacion2);
                     
                     botonhabilitado7 = "si";
                     
                     btnponchado7.setEnabled(true);
                   
                }

                
                

                aplicacionpechoizquierdo = rs.getString("aplicacion_pecho_izquierdo");

                if (aplicacionpechoizquierdo.equals("ninguno")) {
                    aplicacionpechoizquierdo = "";
                }

                
                
                
                 aplicacionpechoderecho = rs.getString("aplicacion_pecho_derecho");

                if (aplicacionpechoderecho.equals("ninguno")) {
                    aplicacionpechoderecho = "";
                }

                
                
                
                 aplicacionmangaizquierda = rs.getString("aplicacion_manga_izquierda");

                if (aplicacionmangaizquierda.equals("ninguno")) {
                    aplicacionmangaizquierda = "";
                }

                
                
                
                 aplicacionmangaderecha = rs.getString("aplicacion_manga_derecha");

                if (aplicacionmangaderecha.equals("ninguno")) {
                    aplicacionmangaderecha = "";
                }

                
                
                
                aplicacionespalda = rs.getString("aplicacion_espalda");

                if (aplicacionespalda.equals("ninguno")) {
                    aplicacionespalda = "";
                }

                
                
                
                
                  aplicacionotraubicacion = rs.getString("aplicacion_otra_ubicacion");

                if (aplicacionotraubicacion.equals("ninguno")) {
                    aplicacionotraubicacion = "";
                }

                
                
                
                
                aplicacionotraubicacion2 = rs.getString("aplicacion_otra_ubicacion2");

                if (aplicacionotraubicacion2.equals("ninguno")) {
                    aplicacionotraubicacion2 = "";
                }


                
                ///////////////////////////////////////////////////              
                
                
                cantidadpechoizquierdo =rs.getString("pecho_izquierdo_cantidad");
                cantidadpechoderecho =rs.getString("pecho_derecho_cantidad");         
                cantidadmangaizquierda =rs.getString("manga_izquierda_cantidad"); 
                cantidadmangaderecha =rs.getString("manga_derecha_cantidad");
                cantidadespalda =rs.getString("espalda_cantidad");
                cantidadotraubicacion =rs.getString("otra_ubicacion_cantidad");
                cantidadotraubicacion2 =rs.getString("otra_ubicacion2_cantidad");
                
                
                
                
                
                 btnterminetodo.setEnabled(false);
                
                
                
                
                
                
                
                if(lugar.equals("Esta sucursal"))
                {
                
                    
              //      btnreplicarponchados.setEnabled(false);
                  
                    
                
                //// pecho izquierdo    
                    
                if( botonhabilitado1.equals("si") )
                {
                  
                   
                   
                   
       
                   if(cantidadpechoizquierdo.equals("0"))
                   {
                       
                       
                   listabotones.add("btnpechoizquierdo");
                   
                    btnpechoizquierdotermine.setEnabled(true);
                    btnpechoizquierdocancelar.setEnabled(false);
                     
                   
                     lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
                    
                       
                   
                   
                   }
                   
                   else
                   {
                       
                        btnpechoizquierdocancelar.setEnabled(true);
                   btnpechoizquierdotermine.setEnabled(false);  
                   
                     lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());
                      
                       
                   }
                  
                }
                else
                {
                    
                 btnpechoizquierdotermine.setEnabled(false);
               
                  
                
                } 
                
                
                
                
                
                
                
                
                
               
                //// pecho derecho
                
                if(  botonhabilitado2.equals("si") )
                {
                   btnpechoderechotermine.setEnabled(true);
                   
                   
                    btnterminetodo.setEnabled(true);
            
                   
                   
                   if(cantidadpechoderecho.equals("0"))
                   {
                   listabotones.add("btnpechoderecho");
                   
                   
                    btnpechoderechotermine.setEnabled(true);
                    btnpechoderechocancelar.setEnabled(false);   
                   
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                   
                   }
                   
                   else
                   {                       
                       
                         btnpechoderechocancelar.setEnabled(true);
                       btnpechoderechotermine.setEnabled(false);    
                       
                         lbcantidad2.setText(cantidad);
                   lbcantidad2.setForeground(Color.GREEN.darker());
                   }
                  
                }
                else
                {
                    
                   btnpechoderechotermine.setEnabled(false);
                          
                } 
                
                
                
                
                
                
                
                
                
                if(  botonhabilitado3.equals("si") )
                {
                   
            
                   if(cantidadmangaizquierda.equals("0"))
                   {
                       
                        listabotones.add("btnmangaizquierda");
                        
                        
                       btnmangaizquierdatermine.setEnabled(true);
                        btnmangaizquierdacancelar.setEnabled(false);
                       
                      
                       
                        
                   
                    lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                       
                   }
                       else
                       {
                               
                           
                            btnmangaizquierdacancelar.setEnabled(true);
                       btnmangaizquierdatermine.setEnabled(false);  
                       
                        lbcantidad3.setText(cantidad);
                   lbcantidad3.setForeground(Color.GREEN.darker());
                               
                               }
                       
                  
                }
                else
                {
                    
                     btnmangaizquierdatermine.setEnabled(false);
                     
                       
                   
                  
                } 
                
                
                
                    
                if(  botonhabilitado4.equals("si") )
                {
                  
         
                    if(cantidadmangaderecha.equals("0"))
                   {
                       
                       
                   listabotones.add("btnmangaderecha");
                   
                    btnmangaderechatetermine.setEnabled(true);
                      btnmangaderechacancelar.setEnabled(false);
                    
                 
                   
                    lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                    
                          
                             
                   }
                    
                    else
                    {
                        
                         btnmangaderechacancelar.setEnabled(true);
                 btnmangaderechatetermine.setEnabled(false);  
                 
                 
                  lbcantidad4.setText(cantidad);
                   lbcantidad4.setForeground(Color.GREEN.darker());
                        
                    }
                   
                   
                   
                }
                else
                {
                      btnmangaderechatetermine.setEnabled(false);
                   
                 
                } 
                
                
                
                
                
                
                
                
                
                
                
                if(  botonhabilitado5.equals("si") )
                {
                 
            
                   if(cantidadespalda.equals("0"))
                   {
                   listabotones.add("btnespalda");
                   
                   
                     btnespaldatetermine.setEnabled(true);
                      btnespaldacancelar.setEnabled(false);
                    
                     
                   
                   lbcantidad5.setText("0");
                    lbcantidad5.setForeground(Color.red.darker());
                   
                          
                   }
                   
                   else
                   {
                         btnespaldacancelar.setEnabled(true);
                   btnespaldatetermine.setEnabled(false); 
                   
                   
                    lbcantidad5.setText(cantidad);
                   lbcantidad5.setForeground(Color.GREEN.darker());
                       
                   }
                  
                   
                }
                else
                {
                    
                   btnespaldatetermine.setEnabled(false);
                    
                    
                    
                    
                } 
                
                
                
                
                
                
                
                
                if(  botonhabilitado6.equals("si") )
                {
                  
              
                   if(cantidadotraubicacion.equals("0") )
                   {
                   listabotones.add("btnotraubicacion");
                   
                    btnotraubicaciontetermine.setEnabled(true);
                      btnotraubicacioncancelar.setEnabled(false);
                   
                   
                   
                   lbcantidad6.setText("0");
                    lbcantidad6.setForeground(Color.red.darker());
                       
                           
                   }
                   
                   else
                   {
                       
                        btnotraubicacioncancelar.setEnabled(true);
                   btnotraubicaciontetermine.setEnabled(false);   
                   
                   
                     lbcantidad6.setText(cantidad);
                   lbcantidad6.setForeground(Color.GREEN.darker());
                       
                   }
                   
                   
                }
                else
                {
                    
                    btnotraubicaciontetermine.setEnabled(false);
                
                  
                } 
                
                
                
                
                
                
                
                
                
                
                
                
                if(  botonhabilitado7.equals("si") )
                {
                   
           
                   if(cantidadotraubicacion2.equals("0"))
                   {
                       listabotones.add("btnotraubicacion2");
                       
                      btnotraubicacion2tetermine.setEnabled(true);
                       btnotraubicacion2cancelar.setEnabled(false);
                    
                      
                         lbcantidad7.setText("0");
                    lbcantidad7.setForeground(Color.red.darker());
                       
                            
                               
                   }
                   
                   else
                   {
                         btnotraubicacion2cancelar.setEnabled(true);
                 btnotraubicacion2tetermine.setEnabled(false); 
                 
                 
                  lbcantidad7.setText(cantidad);
                   lbcantidad7.setForeground(Color.GREEN.darker());
                       
                   }
                  
                   
                }
                else
                {
                    
                   btnotraubicacion2tetermine.setEnabled(false);
                     
                  
                } 
                
                
                
                }
                else
                {
                    
                 
                 
                    
                } 
                
                
                 String estatusorden = rs.getString("estatus_orden");
                 lbestatus.setText(estatusorden);
                
                if(estatusorden.equals("realizada totalmente"))
                {
                  btnterminetodo.setEnabled(false);
                  lbestatus.setForeground(Color.green.darker());
               
                  
                  
                }
                else
                {
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
                

            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
        }

       
        
         codigoycolordehilo();
                 
                 
                 
        datosdepedidosyenvios();
        
        
       
        
        
        
        

    }
    
    
    void datosotrasucursal() throws IOException {
        
        
       
        
        String botonhabilitado1 = "";
        String botonhabilitado2 = "";
        String botonhabilitado3 = "";
        String botonhabilitado4 = "";
        String botonhabilitado5 = "";
        String botonhabilitado6 = "";
        String botonhabilitado7 = "";
      

        numeroordendebordadosolicitadoorecibidasisehabredesderecibidas = lborden.getText();
        
        
        
        
       
           String sql = "Select orden_o_pedido,numero_orden_o_pedido_solicitada,numero_orden_camisa_solicitada,numero_orden_o_pedido_recibida,fecha,hora,cliente,nombre_comercial,borda_cliente,cantidad,cantidad,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,"
                + "   pecho_izquierdo_puntadas,pecho_derecho_puntadas,manga_izquierda_puntadas,manga_derecha_puntadas,espalda_puntadas,otra_ubicacion_puntadas,otra_ubicacion2_puntadas,"
                + "   pecho_izquierdo_cantidad,pecho_derecho_cantidad,manga_izquierda_cantidad,manga_derecha_cantidad,espalda_cantidad,"
                + "   pecho_izquierdo_nombre,pecho_derecho_nombre,manga_izquierda_nombre,manga_derecha_nombre,espalda_nombre,"
                + "   otra_ubicacion_puntadas,otra_ubicacion_nombre,otra_ubicacion_cantidad,otra_ubicacion2_puntadas,otra_ubicacion2_nombre,otra_ubicacion2_cantidad,"
                + "   aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2,"
                + "   aplicacion_pecho_izquierdo_color,aplicacion_pecho_derecho_color,aplicacion_manga_izquierda_color,aplicacion_manga_derecha_color,aplicacion_espalda_color,aplicacion_otra_ubicacion_color,aplicacion_otra_ubicacion2_color,"
                + "   lugar,estatus_orden,identificador_prenda,tienda from historial_ordenes_camisa_recibidas where numero = '" + numeroordendebordadosolicitadoorecibidasisehabredesderecibidas + "' ";

      
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

               
                tiendeordenopedido = rs.getString("orden_o_pedido");
                lbordenopedidorecibido.setText(tiendeordenopedido);
                
                lbnumeroordenbordadodelaotrasucursal.setText(rs.getString("numero_orden_o_pedido_solicitada"));
                numerosucursal = rs.getString("numero_orden_camisa_solicitada");
                
                numeroordenopedidorecibido = rs.getString("numero_orden_o_pedido_recibida");
                lbnumeroordenopedidorecibido.setText(numeroordenopedidorecibido);
                
                
                cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
                lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                lbbordacliente.setText(rs.getString("borda_cliente"));
                lbprenda.setText(rs.getString("prenda"));
                prenda = rs.getString("prenda");
                lbfecha.setText(rs.getString("fecha"));
                
                
                sucursal = rs.getString("tienda");
                lbsucursal.setText(sucursal);
            
                
                
                
                
                
                
                
                
                
                pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre");
             
                String pechoizquierdo = rs.getString("pecho_izquierdo_puntadas");
                lbpechoizquierdo.setText(pechoizquierdo);
                
                if (pechoizquierdo == null || pechoizquierdo.equals("") || pechoizquierdo.equals("ninguno")) {

                   
                    btnponchado1.setEnabled(false);
                    

                }
                else
                {
                    botonhabilitado1 = "si";
                    lbpechoizquierdonombre.setText(pechoizquierdonombre);
                    btnponchado1.setEnabled(true);
                } 
                
                
                
                
                
                
                
                
                
                pechoderechonombre = rs.getString("pecho_derecho_nombre");
              
                String pechoderecho = rs.getString("pecho_derecho_puntadas");
                lbpechoderecho.setText(pechoderecho);
                
                if (pechoderecho == null || pechoderecho.equals("") || pechoderecho.equals("ninguno")) {

                   
                    btnponchado2.setEnabled(false);
                     

                }
                else
                {
                    botonhabilitado2 = "si";
                    lbpechoderechonombre.setText(pechoderechonombre);
                    btnponchado2.setEnabled(true);
                } 
                
                
                
                
                
                
                
                
                
                
                 mangaizquierdanombre = rs.getString("manga_izquierda_nombre");
              
                 String mangaizquierda = rs.getString("manga_izquierda_puntadas");
                 lbmangaizquierda.setText(mangaizquierda);
                
                if (mangaizquierda == null || mangaizquierda.equals("") || mangaizquierda.equals("ninguno")) {

                  
                    btnponchado3.setEnabled(false);
                

                }
                else
                {
                    
                  
                    botonhabilitado3 = "si";
                     lbmangaizquierdanombre.setText(mangaizquierdanombre);
                    btnponchado3.setEnabled(true);
                } 

                
                
                
                
                
                
                
                
                
                mangaderechanombre = rs.getString("manga_derecha_nombre");
              
                String mangaderecha = rs.getString("manga_derecha_puntadas");
                lbmangaderecha.setText(mangaderecha);
                
                if (mangaderecha == null || mangaderecha.equals("") || mangaderecha.equals("ninguno"))
                
                {

                    btnponchado4.setEnabled(false);
               


                }
                else
                {
                    lbmangaderechanombre.setText(mangaderechanombre);
                    btnponchado4.setEnabled(true);
                    botonhabilitado4 = "si";
                }   

                
                
                
                
                
                
                
                
                
                
                
               


                espaldanombre = rs.getString("espalda_nombre");
           
                String espalda = rs.getString("espalda_puntadas");
                lbespalda.setText(espalda);
             
                if (espalda == null || espalda.equals("") || espalda.equals("ninguno")) {

                  
                    btnponchado5.setEnabled(false);
                 

                }
                else
                {
                    botonhabilitado5 = "si";
                    lbespaldanombre.setText(espaldanombre);
                    btnponchado5.setEnabled(true);
                } 

                
                
                
                
                
                
                
                
                
                otraubicacionnombre = rs.getString("otra_ubicacion_nombre");
            
                String otraubicacion = rs.getString("otra_ubicacion_puntadas");
                lbotraubicacion.setText(otraubicacion);
                
                
                if (otraubicacion == null || otraubicacion.equals("") || otraubicacion.equals("ninguno")) {

                  
                   btnponchado6.setEnabled(false);
                    

                }
                else
                {
                    botonhabilitado6 = "si";
                    lbotraubicacionnombre.setText(otraubicacionnombre);
                    btnponchado6.setEnabled(true);
                            
                } 

                
                
                
                
                
                
                otraubicacion2nombre = rs.getString("otra_ubicacion2_nombre");
                
                String otraubicacion2 = rs.getString("otra_ubicacion2_puntadas");
                lbotraubicacion2.setText(otraubicacion2);
           
                if (otraubicacion2 == null || otraubicacion2.equals("") || otraubicacion2.equals("ninguno")) 
                {

                   
                    btnponchado7.setEnabled(false);
                   
                }
                else
                {
                    botonhabilitado7 = "si";
                    lbotraubicacion2nombre.setText(otraubicacion2nombre);
                    btnponchado7.setEnabled(true);
                    
                    
                } 

                
                cantidad = rs.getString("cantidad");
                lbcantidad.setText(cantidad);

                aplicacionpechoizquierdo = rs.getString("aplicacion_pecho_izquierdo");

                if (aplicacionpechoizquierdo.equals("ninguno")) {
                    aplicacionpechoizquierdo = "";
                }

                aplicacionpechoderecho = rs.getString("aplicacion_pecho_derecho");

                if (aplicacionpechoderecho.equals("ninguno")) {
                    aplicacionpechoderecho = "";
                }

                aplicacionmangaizquierda = rs.getString("aplicacion_manga_izquierda");

                if (aplicacionmangaizquierda.equals("ninguno")) {
                    aplicacionmangaizquierda = "";
                }

                aplicacionmangaderecha = rs.getString("aplicacion_manga_derecha");

                if (aplicacionmangaderecha.equals("ninguno")) {
                    aplicacionmangaderecha = "";
                }

                aplicacionespalda = rs.getString("aplicacion_espalda");

                if (aplicacionespalda.equals("ninguno")) {
                    aplicacionespalda = "";
                }

                aplicacionotraubicacion = rs.getString("aplicacion_otra_ubicacion");

                if (aplicacionotraubicacion.equals("ninguno")) {
                    aplicacionotraubicacion = "";
                }

                aplicacionotraubicacion2 = rs.getString("aplicacion_otra_ubicacion2");

                if (aplicacionotraubicacion2.equals("ninguno")) {
                    aplicacionotraubicacion2 = "";
                }

               
                lugar = rs.getString("lugar");

              

           //         btnreplicarponchados.setEnabled(false);
                  
                    
                    
                    ////////////////////
                    //////////////////
                    /////CANTIDAD
                    
                    
                 cantidadpechoizquierdo =rs.getString("pecho_izquierdo_cantidad");
                cantidadpechoderecho =rs.getString("pecho_derecho_cantidad");         
                cantidadmangaizquierda =rs.getString("manga_izquierda_cantidad"); 
                cantidadmangaderecha =rs.getString("manga_derecha_cantidad");
                cantidadespalda =rs.getString("espalda_cantidad");
                cantidadotraubicacion =rs.getString("otra_ubicacion_cantidad");
                cantidadotraubicacion2 =rs.getString("otra_ubicacion2_cantidad");
                
                
                
                
                
                 btnterminetodo.setEnabled(false);
                
                
                
                
                    
             //       btnreplicarponchados.setEnabled(false);
                  
                    
                
                //// pecho izquierdo    
                    
                if( botonhabilitado1.equals("si") )
                {
                  
                   
                   
                   
       
                   if(cantidadpechoizquierdo.equals("0"))
                   {
                       
                       
                   listabotones.add("btnpechoizquierdo");
                   
                    btnpechoizquierdotermine.setEnabled(true);
                    btnpechoizquierdocancelar.setEnabled(false);
                     
                   
                     lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
                    
                       
                   
                   
                   }
                   
                   else
                   {
                       
                        btnpechoizquierdocancelar.setEnabled(true);
                   btnpechoizquierdotermine.setEnabled(false);  
                   
                     lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());
                      
                       
                   }
                  
                }
                else
                {
                    
                 btnpechoizquierdotermine.setEnabled(false);
               
                  
                
                } 
                
                
                
                
                
                
                
                
                
               
                //// pecho derecho
                
                if(  botonhabilitado2.equals("si") )
                {
                   btnpechoderechotermine.setEnabled(true);
                   
                   
                    btnterminetodo.setEnabled(true);
            
                   
                   
                   if(cantidadpechoderecho.equals("0"))
                   {
                   listabotones.add("btnpechoderecho");
                   
                   
                    btnpechoderechotermine.setEnabled(true);
                    btnpechoderechocancelar.setEnabled(false);   
                   
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                   
                   }
                   
                   else
                   {                       
                       
                         btnpechoderechocancelar.setEnabled(true);
                       btnpechoderechotermine.setEnabled(false);    
                       
                         lbcantidad2.setText(cantidad);
                   lbcantidad2.setForeground(Color.GREEN.darker());
                   }
                  
                }
                else
                {
                    
                   btnpechoderechotermine.setEnabled(false);
                          
                } 
                
                
                
                
                
                
                
                
                
                if(  botonhabilitado3.equals("si") )
                {
                   
            
                   if(cantidadmangaizquierda.equals("0"))
                   {
                       
                        listabotones.add("btnmangaizquierda");
                        
                        
                       btnmangaizquierdatermine.setEnabled(true);
                        btnmangaizquierdacancelar.setEnabled(false);
                       
                      
                       
                        
                   
                    lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                       
                   }
                       else
                       {
                               
                           
                            btnmangaizquierdacancelar.setEnabled(true);
                       btnmangaizquierdatermine.setEnabled(false);  
                       
                        lbcantidad3.setText(cantidad);
                   lbcantidad3.setForeground(Color.GREEN.darker());
                               
                               }
                       
                  
                }
                else
                {
                    
                     btnmangaizquierdatermine.setEnabled(false);
                     
                       
                   
                  
                } 
                
                
                
                    
                if(  botonhabilitado4.equals("si") )
                {
                  
         
                    if(cantidadmangaderecha.equals("0"))
                   {
                       
                       
                   listabotones.add("btnmangaderecha");
                   
                    btnmangaderechatetermine.setEnabled(true);
                      btnmangaderechacancelar.setEnabled(false);
                    
                 
                   
                    lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                    
                          
                             
                   }
                    
                    else
                    {
                        
                         btnmangaderechacancelar.setEnabled(true);
                 btnmangaderechatetermine.setEnabled(false);  
                 
                 
                  lbcantidad4.setText(cantidad);
                   lbcantidad4.setForeground(Color.GREEN.darker());
                        
                    }
                   
                   
                   
                }
                else
                {
                      btnmangaderechatetermine.setEnabled(false);
                   
                 
                } 
                
                
                
                
                
                
                
                
                
                
                
                if(  botonhabilitado5.equals("si") )
                {
                 
            
                   if(cantidadespalda.equals("0"))
                   {
                   listabotones.add("btnespalda");
                   
                   
                     btnespaldatetermine.setEnabled(true);
                      btnespaldacancelar.setEnabled(false);
                    
                     
                   
                   lbcantidad5.setText("0");
                    lbcantidad5.setForeground(Color.red.darker());
                   
                          
                   }
                   
                   else
                   {
                         btnespaldacancelar.setEnabled(true);
                   btnespaldatetermine.setEnabled(false); 
                   
                   
                    lbcantidad5.setText(cantidad);
                   lbcantidad5.setForeground(Color.GREEN.darker());
                       
                   }
                  
                   
                }
                else
                {
                    
                   btnespaldatetermine.setEnabled(false);
                    
                    
                    
                    
                } 
                
                
                
                
                
                
                
                
                if(  botonhabilitado6.equals("si") )
                {
                  
              
                   if(cantidadotraubicacion.equals("0") )
                   {
                   listabotones.add("btnotraubicacion");
                   
                    btnotraubicaciontetermine.setEnabled(true);
                      btnotraubicacioncancelar.setEnabled(false);
                   
                   
                   
                   lbcantidad6.setText("0");
                    lbcantidad6.setForeground(Color.red.darker());
                       
                           
                   }
                   
                   else
                   {
                       
                        btnotraubicacioncancelar.setEnabled(true);
                   btnotraubicaciontetermine.setEnabled(false);   
                   
                   
                     lbcantidad6.setText(cantidad);
                   lbcantidad6.setForeground(Color.GREEN.darker());
                       
                   }
                   
                   
                }
                else
                {
                    
                    btnotraubicaciontetermine.setEnabled(false);
                
                  
                } 
                
                
                
                
                
                
                
                
                
                
                
                
                if(  botonhabilitado7.equals("si") )
                {
                   
           
                   if(cantidadotraubicacion2.equals("0"))
                   {
                       listabotones.add("btnotraubicacion2");
                       
                      btnotraubicacion2tetermine.setEnabled(true);
                       btnotraubicacion2cancelar.setEnabled(false);
                    
                      
                         lbcantidad7.setText("0");
                    lbcantidad7.setForeground(Color.red.darker());
                       
                            
                               
                   }
                   
                   else
                   {
                         btnotraubicacion2cancelar.setEnabled(true);
                 btnotraubicacion2tetermine.setEnabled(false); 
                 
                 
                  lbcantidad7.setText(cantidad);
                   lbcantidad7.setForeground(Color.GREEN.darker());
                       
                   }
                  
                   
                }
                else
                {
                    
                   btnotraubicacion2tetermine.setEnabled(false);
                     
                  
                } 
                
               
                
                
               String estatus = rs.getString("estatus_orden");
                 lbestatus.setText(estatus);
                
                if(estatus.equals("realizada totalmente"))
                {
                  btnterminetodo.setEnabled(false);
                  lbestatus.setForeground(Color.green.darker());
               
                  
                  
                }
                else
                {
                   btnterminetodo.setEnabled(true); 
                    btnterminetodo.setEnabled(true);
                   
                   
                  if(estatus.equals("realizada parcialmente"))
                  {
                      
                       lbestatus.setForeground(anaranjado);
                      
                  }
                  else
                  {
                      lbestatus.setForeground(Color.red);
                  }
                   
                   
                }
                
                
                   identificador =  rs.getString("identificador_prenda");
                   lbidentificador.setText(identificador);


            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
        }

        
        
        
        
        
        cliente = lbcliente.getText();
        
        
 
             
              if (tiendaconectada.equals("si"))

                      {
      
                          
                        
                
                 try {
         
               
         BufferedImage img = null;
        
        
        
       String sql4 = "Select extension_imagen,imagen from bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";  ///

        try {

            Statement st = cnsucursal.createStatement();
            ResultSet rs = st.executeQuery(sql4);
            if (rs.next()) 
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
            
            
            else
                
            {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">No se encotro imangen con el nombre de este identificador; quizas el encardo de la otra tienda cambio el nombre del identificador");
                
            }
            
            
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void determinaciondeladescripciondelbordado(){
        
        
        descripcion = "BORDADO CAMISA " + ubicacionprenda + " " + nombrebordado + "";
        
             if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA " +ubicacionprenda+" " + nombrebordado+ "";
                aplicacioninsertar = "APLICACION CAMISA " + ubicacionprenda + "";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA " + ubicacionprenda + " " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA " + ubicacionprenda + "";

            } //// chamarra desmontable
         
            
            
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE " + ubicacionprenda + " " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE " + ubicacionprenda + "";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS " + ubicacionprenda + " " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS " + ubicacionprenda + "";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA " + ubicacionprenda + " " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA " + ubicacionprenda + "";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA " + ubicacionprenda + " " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA " + ubicacionprenda + "";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO " + ubicacionprenda + " " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO " + ubicacionprenda + "";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO " + ubicacionprenda + " " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO " + ubicacionprenda + "";

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
 
    
        
 
    
    
     void codigocliente()
    {
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
        
    
        prenda =lbprenda.getText().toUpperCase();
        identificador =lbidentificador.getText();
        BufferedImage img = null;
        
      
        btnverfotomontaje.setEnabled(false);
        
        
    
       

       String sql = "Select extension_imagen,imagen,numero_consecutivo from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
               
                Blob blob = rs.getBlob("imagen");
                if (blob == null) 
                {

                 
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
                 
                      JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");

                    }

                    if(img==null)
                    {
                       tienefotomontaje = "no"; 
                    }
                    else
                    {
                    
                    Imagen ventana = new Imagen();
                    ventana.setImagen(img);
                    
                    lbfotomontaje.setIcon(new ImageIcon(img.getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT)));
                    lbfotomontaje.setVisible(true);
                    btnverfotomontaje.setEnabled(true);
                    tienefotomontaje = "si";
                    btnverfotomontaje.setEnabled(true);
                  

                    Blob archivo = rs.getBlob("imagen");
                    consecutivo = rs.getString("numero_consecutivo");
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
          
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }
        
        
        
        
        
        if(tienefotomontaje.equals("no"))
        
        {
          
            
            
            
            
            btnmangaderechatetermine.setEnabled(false);
            btnmangaizquierdatermine.setEnabled(false);
            btnpechoderechotermine.setEnabled(false);
            btnpechoizquierdotermine.setEnabled(false);
            btnespaldatetermine.setEnabled(false);
            btnotraubicaciontetermine.setEnabled(false);
            btnotraubicacion2tetermine.setEnabled(false);
            
             btnponchado1.setEnabled(false);
        btnponchado2.setEnabled(false);
        btnponchado3.setEnabled(false);
        btnponchado4.setEnabled(false);
        btnponchado5.setEnabled(false);        
        btnponchado6.setEnabled(false);        
        btnponchado7.setEnabled(false);      
            
            
            
            
         
            
            lbfotomontaje.setVisible(false);
            btnverfotomontaje.setEnabled(false);
       
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
             btnfotomontajesinpuntadas.setEnabled(false);
             btnterminetodo.setEnabled(false);
       } 

        
        
    }

    
    
    
    
    
    void verfotomontajetiendalocal(){
        
        
        
        
        
        String cliente = lbcliente.getText();
        String rutadelarchivo = "";
        String existe = "";
        prenda = lbprenda.getText();
   
       
        String sql = "SELECT imagen,extension_imagen FROM bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";  ///
    
    
            
             try {
            
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next())
            {
                Object camisa1 = rs1.getString(1);
                if (camisa1 == null||camisa1.equals("")||camisa1.equals(" "))
                {
                    existe = "no";
                } else

                {
                    
                    
                    String nombredelarchivo = rs1.getString(2);
                    
                    
                    
                    
                    if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                        rutadelarchivo = "C://archivospdf/fotomontaje."+nombredelarchivo+" ";
                         
                        
                    }
                    else
                    {
                        rutadelarchivo = "C://archivospdf/"+nombredelarchivo+" ";
                       
                        
                    }
                    
                    
                    
                    existe = "si";
                    File file = new File(rutadelarchivo);
                    FileOutputStream output = null;
                    try {
                        output = new FileOutputStream(file);
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                    }
                    Blob archivo = rs1.getBlob(1);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    try {
                        while ((length = inStream.read(buffer)) != -1) {
                            output.write(buffer, 0, length);
                            // output.flush();
                        }
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    try {
                        // inStream.close();
                        output.close();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
          
   //       } catch (Exception x) {
   //                            System.out.println(x); 
   //                         }
        
           
           

        if (existe.equals("si"))
        {
            String fileLocal = new String(rutadelarchivo);
            try {

                File path = new File(fileLocal);
                Desktop.getDesktop().open(path);

            } catch (IOException e2) {
                System.out.println(e2);
            } catch (IllegalArgumentException e3) {

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e3);
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">No se pudo abrir el fotomontaje, debido a que no se encontró el IDENTIFICADOR; quizas le cambíó de nombre al IDENTIFICADOR","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
    
    
    
    
    
     void verfotomontajesucursal(){
        
        
        
        
        
        String cliente = lbcliente.getText();
        String rutadelarchivo = "";
        String existe = "";
        prenda = lbprenda.getText();
   
       
        String sql = "SELECT imagen,extension_imagen FROM bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";  ///
    
    
            
             try {
            
            Statement st1 = cnsucursal.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next())
            {
                Object camisa1 = rs1.getString(1);
                if (camisa1 == null||camisa1.equals("")||camisa1.equals(" "))
                {
                    existe = "no";
                } else

                {
                    
                    
                    String nombredelarchivo = rs1.getString(2);
                    
                    
                    
                    
                    if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                        rutadelarchivo = "C://archivospdf/fotomontaje."+nombredelarchivo+" ";
                         
                        
                    }
                    else
                    {
                        rutadelarchivo = "C://archivospdf/"+nombredelarchivo+" ";
                       
                        
                    }
                    
                    
                    
                    existe = "si";
                    File file = new File(rutadelarchivo);
                    FileOutputStream output = null;
                    try {
                        output = new FileOutputStream(file);
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                    }
                    Blob archivo = rs1.getBlob(1);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    try {
                        while ((length = inStream.read(buffer)) != -1) {
                            output.write(buffer, 0, length);
                            // output.flush();
                        }
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    try {
                        // inStream.close();
                        output.close();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
          
   //       } catch (Exception x) {
   //                            System.out.println(x); 
   //                         }
        
           
           

        if (existe.equals("si"))
        {
            String fileLocal = new String(rutadelarchivo);
            try {

                File path = new File(fileLocal);
                Desktop.getDesktop().open(path);

            } catch (IOException e2) {
                System.out.println(e2);
            } catch (IllegalArgumentException e3) {

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e3);
            }

        }
        else
        {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">No se pudo abrir el fotomontaje, debido a que no se encontró el IDENTIFICADOR; quizas le cambíó de nombre al IDENTIFICADOR","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
        
    }
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void datosdepedidosyenvios() 
    {
        /// busca las ordenes de camisa generadas 

        
        String numero = lbnumerodeventa.getText();
        String pedirarticulos = "";
        String ordenenvio = "";
        String sql2 = "Select solicito_articulos, enviada_ordenenvio from historial_ventas where numero = '" + numero + "'  ";

        try {
            PreparedStatement prst = cn.prepareStatement(sql2);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                pedirarticulos = rs.getString("solicito_articulos");
                ordenenvio = rs.getString("enviada_ordenenvio");

            }
        } catch (Exception exx) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

        }

        if (pedirarticulos.equals("si")) 
        {
            
            
            
            String sql3 = "Select numero,sucursal from historial_pedidos_sucursal_solicitados where numventa = '" + numero + "' and estatus_entrega not in ('cancelada') and sucursal = '"+sucursal+"'  ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
                    numerosolicitoarticulos = rs.getString("numero");
                    tiendasolicitoarticulos = rs.getString("sucursal");
                    
                    
                    lbsucursal.setText(tiendasolicitoarticulos);
                    lbnumeroordenbordadodelaotrasucursal.setText(numerosolicitoarticulos);
                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

            }
            
            /// solicito articulos de la
            

        }
        else 
        {
            if (ordenenvio.equals("si")) 
            {

                
                
                String sql3 = "Select distinct numero,sucursal from historial_ordenes_envio_solicitadas where numero_venta = '" + numero + "' and sucursal = '"+sucursal+"' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    while (rs.next()) 
                    {
                        numeroordenenvio = rs.getString("numero");
                        tiendaordenenvio = rs.getString("sucursal");
                        
                       
                    }
                } catch (Exception exx) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

                }
                
                
                lbsucursal.setText(tiendaordenenvio);
                lbnumeroordenbordadodelaotrasucursal.setText(numeroordenenvio);

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
                        tiendasolicitoarticulos = rs.getString("sucursal");

                        lbsucursal.setText(tiendasolicitoarticulos);
                        lbnumeroordenbordadodelaotrasucursal.setText(numerosolicitoarticulos);
                    }
                    else
                    {
                        
                    }
                    
                    
                } catch (Exception exx) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

                }

            } else {
                lbsucursal.setText(tiendaordenenvio);
               
                lbnumeroordenbordadodelaotrasucursal.setText(numeroordenenvio);
            }

            
        }

    }
    
    
    void insertarlacantidadylafechaenlaubicacionCancelar(String ubicacion, String fecha){
    
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE  "+nombredelatabla+" set "+ubicacion+"='0', "+fecha+"=null where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"'");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");

                }
        
        
    }
    
    
    
    
    void insertarlacantidadylafechaenlaubicacion(String ubicacion, String fechaubicacion)
    {
        try {
            
            
            
           

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set "+ubicacion+"='" + cantidad + "',"+fechaubicacion+"  =  '"+dia()+"' where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                     JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al actualizar al actualizar las cantidades en el historial de ordenes de camisa");
                }
        
        
        
        
      
    }
    
    
    
    
    
    
    
    
    void insertarlacantidadylafechaenlaubicacionhistorialRECIBIDO(String ubicacion)
    {
        
        
                  
        
        try {
        
                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacion+"='" + cantidad + "',fecha = '"+dia()+"',"+fechaubicacion+" = '"+dia()+"'  where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"'  ");
                    pst.executeUpdate();
                    pst.close();
                    
                    
                     String ubicacionsinguiones = ubicacion;
                         ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
                    
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");

                } catch (Exception ex)
                
                {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                     JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al actualizar al actualizar las cantidades en el historial de ordenes de camisa");
                    
                }
        
        
           
        
    }
    
    
     public static String dia() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
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
       
        
        String SQL2 = "select articulo,surtida from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + ubicacion + "'  and identificador_prenda = '"+identificador+"' ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {
            
       

        surtidaactualstring = rs.getString("surtida");
        surtidaactualint = Integer.parseInt(surtidaactualstring);
      

        }
        
        else
        {
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EN LA VENTA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
        String[] lineas = observacion.split("\n");
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el artículo "+ubicacion+"" + lineas[0] + "</span><br>";
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
            
        
        
        
        
        
        
        
        
        
        // AQUI LO VAS A MODIFICAR ROMMEL, QUE ENTRE CUANDO SEA ORDEN DE ENVIO, NO CUANDO ESTE SURTIDA Y ENTREGADA TOTALMENTE
      
            
            
            
         if(sucursal.equals(tiendalocal) && !numeroordendeenviosolicitada.equals("0"))    
         
                 {
                     
          
                     
            
            
            // TIENE APLICACION
            
            
            
          

      
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
      
        
        
        
        
        
      
     ////Actualiza el estatus
      
     
      
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
        else
        {
        
     
        
      
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + nuevasurtidastring + "' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacion + "'  and identificador_prenda = '"+identificador+"'   ");
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + totalaplicaciones + "' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacionaplicacion + "'  and identificador_prenda = '"+identificador+"'   ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       
             
             
             
            
            }
            
            
            

        ////Actualiza el estatus

      String cantidadsurtida = "";  
      String cantidadvendida = "";  
      String cantidadentregada = "";  
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(entregadas) as entregadas from historial_ventas where numero = '"+numerodeventa+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        cantidadvendida = rs.getString("cantidad");
        cantidadsurtida = rs.getString("surtida");
        cantidadentregada = rs.getString("entregadas");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
      
      /////
      
      double cantidadvendidadouble = Double.parseDouble(cantidadvendida);
      double cantidadsurtidadouble = Double.parseDouble(cantidadsurtida);
      double cantidadentregadadouble = Double.parseDouble(cantidadentregada);
      
        
        if(cantidadvendidadouble == cantidadsurtidadouble && cantidadentregadadouble == 0 )
        {
          estatusentrega ="surtida totalmente no entregada";  
        }
        else  if(cantidadvendidadouble == (cantidadsurtidadouble + cantidadentregadadouble )  &&  cantidadentregadadouble <  cantidadvendidadouble  )
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
      
      
      }
    
    
     void agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar(String ubicacion, String cantidad, String ubicacionaplicacion) 
      {

        numerodeventa =  lbnumerodeventa.getText();
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
       
        
        String SQL2 = "select cantidad from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + ubicacion + "' and identificador_prenda = '"+identificador+"'";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {

        cantidadstring = rs.getString("cantidad");
     

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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '"+nuevacantidadstring+"' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacion + "'  and identificador_prenda = '"+identificador+"'");
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
    
    
     
     
     
     
     
     
     
    void agregarsurtidasalhistorialdepedidosoenviosyactualizarestatus(String ubicacion, String cantidad, String ubicacionaplicacion) 
      {
          
          
          
          
         
          
          
           // PEDIDO
          
          
          
            if (tiendeordenopedido.equals("pedido"))
            {
            
            
                
                
        String surtidaactualstring ="";
        int surtidaactualint =  0;
        String nuevasurtidastring = "";
        String estatusentrega ="";
       
        
        String SQL2 = "select articulo,surtidas from historial_pedidos_sucursal_recibidos where numero = '" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {
            
       

        surtidaactualstring = rs.getString("surtidas");
        surtidaactualint = Integer.parseInt(surtidaactualstring);
      

        }
        
        else
        {
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EN LA VENTA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
        String[] lineas = observacion.split("\n");
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el artículo "+ubicacion+"" + lineas[0] + "</span><br>";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET surtidas = '" + nuevasurtidastring + "' WHERE numero ='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
            
            
                     
            
            
            // TIENE APLICACION
            
            
            
            
            if (cantidadaplicacion.equals("0") || cantidadaplicacion.equals(""))
            {
                
                
                
                
            }
            
            else
            {
                
                int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
                
                cantidadaplicacionint = cantidadaplicacionint * surtidasnuevasint;
                
                String totalaplicaciones = String.valueOf(cantidadaplicacionint);
                
            
          
            
            
              try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET surtidas = '" + totalaplicaciones + "' WHERE numero ='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       

            }
              

      
        ////Actualiza el estatus

      String vendidastring = "";    
      String surtidastring = "";  
      String enviadastring = "";  
     
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(enviadas) as enviadas,Sum(surtidas) as surtidas from historial_pedidos_sucursal_recibidos where numero = '" + numeroordenopedidorecibido + "' ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        vendidastring = rs.getString("cantidad");
        surtidastring = rs.getString("surtidas");
        enviadastring = rs.getString("enviadas");
       
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
        
        
        
        
      
     ////Actualiza el estatus
      
     
      
      int vendida = Integer.parseInt(vendidastring);
      int surtida = Integer.parseInt(surtidastring);
      int enviada = Integer.parseInt(enviadastring);
     
      
        
        if(vendida == (surtida + enviada) && enviada == 0 )
        {
          estatusentrega ="surtido totalmente no traspasada";  
        }
        
        else
          if(vendida == (surtida + enviada) && enviada > 0 )
        {
          estatusentrega ="surtido totalmente traspasada parcialmente";  
        }
          
          
           else
          if(vendida > (surtida +enviada) && enviada > 0 )
        {
          estatusentrega ="surtido parcialmente traspasada parcialmente";  
        }
     
        
        else
        {
          estatusentrega ="surtido parcialmente no traspasada";   
        }    
        
        
        
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET estatus_entrega = '" + estatusentrega + "' where numero = '" + numeroordenopedidorecibido + "' ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      
      
            
       
            }
            
            
           // ORDEN DE ENVIO
           // ORDEN DE ENVIO
           // ORDEN DE ENVIO
            // ORDEN DE ENVIO
            
            else
                
                
            {
                
                
                
                
                
                   
                
        String surtidaactualstring ="";
        int surtidaactualint =  0;
        String nuevasurtidastring = "";
        String estatusentrega ="";
       
        
        String SQL2 = "select articulo,surtidas from historial_ordenes_envio_recibidas where numero = '" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {
            
       

        surtidaactualstring = rs.getString("surtidas");
        surtidaactualint = Integer.parseInt(surtidaactualstring);
      

        }
        
        else
        {
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EN LA VENTA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
        String[] lineas = observacion.split("\n");
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el artículo "+ubicacion+"" + lineas[0] + "</span><br>";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET surtidas = '" + nuevasurtidastring + "' WHERE numero ='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
            
            
                     
            
            
            // TIENE APLICACION
            
            
            
            
            if (cantidadaplicacion.equals("0") || cantidadaplicacion.equals(""))
            {
                
                
                
                
            }
            
            else
            {
                
                int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
                
                cantidadaplicacionint = cantidadaplicacionint * surtidasnuevasint;
                
                String totalaplicaciones = String.valueOf(cantidadaplicacionint);
                
            
          
            
            
              try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET surtidas = '" + totalaplicaciones + "' WHERE numero ='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       

            }
              

      
        ////Actualiza el estatus

      String vendidastring = "";    
      String surtidastring = "";  
      String enviadastring = "";  
     
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(enviadas) as enviadas,Sum(surtidas) as surtidas from historial_ordenes_envio_recibidas where numero = '" + numeroordenopedidorecibido + "' ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        vendidastring = rs.getString("cantidad");
        surtidastring = rs.getString("surtidas");
        enviadastring = rs.getString("enviadas");
       
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
        
        
        
        
      
     ////Actualiza el estatus
      
     
      
      int vendida = Integer.parseInt(vendidastring);
      int surtida = Integer.parseInt(surtidastring);
      int enviada = Integer.parseInt(enviadastring);
     
      
        
        if(vendida == (surtida + enviada) && enviada == 0 )
        {
          estatusentrega ="surtido totalmente no enviada";  
        }
        
        else
          if(vendida == (surtida + enviada) && enviada > 0 )
        {
          estatusentrega ="surtido totalmente enviada parcialmente";  
        }
          
          
           else
          if(vendida > (surtida +enviada) && enviada > 0 )
        {
          estatusentrega ="surtido parcialmente enviada parcialmente";  
        }
     
        
        else
        {
          estatusentrega ="surtido parcialmente no enviada";   
        }    
        
        
        
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET estatus_entrega = '" + estatusentrega + "' WHERE numero = '" + numeroordenopedidorecibido + "' ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      
      
            
              
                
                
                
                
                
                
                
                
            }
         
         
      
      }
    
     
     
    
    
 
            
            
            
            
    void agregarsurtidasalhistorialdepedidosoenviosyactualizarestatusCancelar(String ubicacion, String cantidad, String ubicacionaplicacion) 
      {
          
          
          
          
          
          
          
          
           // PEDIDO
          
          
          
            if (tiendeordenopedido.equals("pedido"))
            {
            
            
                
                
        String surtidaactualstring ="";
        int surtidaactualint =  0;
        String nuevasurtidastring = "";
        String estatusentrega ="";
       
        
        String SQL2 = "select articulo,surtidas from historial_pedidos_sucursal_recibidos where numero = '" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {
            
       

        surtidaactualstring = rs.getString("surtidas");
        surtidaactualint = Integer.parseInt(surtidaactualstring);
      

        }
        
        else
        {
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EN LA VENTA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
        String[] lineas = observacion.split("\n");
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el artículo "+ubicacion+"" + lineas[0] + "</span><br>";
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
        
         //////////// RESTA LAS SURTIDAS
        int surtidasnuevasint = surtidaactualint - surtidasint;
       
        nuevasurtidastring =  String.valueOf(surtidasnuevasint);
            
            
          
             
                     
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET surtidas = '" + nuevasurtidastring + "' WHERE numero ='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
            
            
                     
            
            
            // TIENE APLICACION
            
            
            
            
            if (cantidadaplicacion.equals("0") || cantidadaplicacion.equals(""))
            {
                
                
                
                
            }
            
            else
            {
                
                int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
                
                cantidadaplicacionint = cantidadaplicacionint * surtidasnuevasint;
                
                String totalaplicaciones = String.valueOf(cantidadaplicacionint);
                
            
          
            
            
              try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET surtidas = '" + totalaplicaciones + "' WHERE numero ='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       

            }
              

      
        ////Actualiza el estatus

      String vendidastring = "";    
      String surtidastring = "";  
      String enviadastring = "";  
     
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(enviadas) as enviadas,Sum(surtidas) as surtidas from historial_pedidos_sucursal_recibidos where numero = '" + numeroordenopedidorecibido + "' ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        vendidastring = rs.getString("cantidad");
        surtidastring = rs.getString("surtidas");
        enviadastring = rs.getString("enviadas");
       
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
        
        
        
        
      
     ////Actualiza el estatus
      
     
      
      int vendida = Integer.parseInt(vendidastring);
      int surtida = Integer.parseInt(surtidastring);
      int enviada = Integer.parseInt(enviadastring);
     
      
        
        if(vendida == (surtida + enviada) && enviada == 0 )
        {
          estatusentrega ="surtida totalmente no traspasada";  
        }
        
        else
          if(vendida == (surtida + enviada) && enviada > 0 )
        {
          estatusentrega ="surtida totalmente traspasada parcialmente";  
        }
          
          
           else
          if(vendida > (surtida +enviada) && enviada > 0 )
        {
          estatusentrega ="surtida parcialmente traspasada parcialmente";  
        }
     
        
        else
        {
          estatusentrega ="surtida parcialmente no traspasada";   
        }    
        
        
        
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET estatus_entrega = '" + estatusentrega + "' where numero = '" + numeroordenopedidorecibido + "' ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      
      
            
       
            }
            
            
           // ORDEN DE ENVIO
           // ORDEN DE ENVIO
           // ORDEN DE ENVIO
            // ORDEN DE ENVIO
            
            else
                
                
            {
                
                
                
                
                
                   
                
        String surtidaactualstring ="";
        int surtidaactualint =  0;
        String nuevasurtidastring = "";
        String estatusentrega ="";
       
        
        String SQL2 = "select articulo,surtidas from historial_ordenes_envio_recibidas where numero = '" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {
            
       

        surtidaactualstring = rs.getString("surtidas");
        surtidaactualint = Integer.parseInt(surtidaactualstring);
      

        }
        
        else
        {
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRO EN LA VENTA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
        String[] lineas = observacion.split("\n");
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el artículo "+ubicacion+"" + lineas[0] + "</span><br>";
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
        
        
        //////////// RESTA LAS SURTIDAS
        int surtidasnuevasint = surtidaactualint - surtidasint;
       
        nuevasurtidastring =  String.valueOf(surtidasnuevasint);
            
        
        
       
             
                     
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET surtidas = '" + nuevasurtidastring + "' WHERE numero ='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
            
            
                     
            
            
            // TIENE APLICACION
            
            
            
            
            if (cantidadaplicacion.equals("0") || cantidadaplicacion.equals(""))
            {
                
                
                
                
            }
            
            else
            {
                
                int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
                
                cantidadaplicacionint = cantidadaplicacionint * surtidasnuevasint;
                
                String totalaplicaciones = String.valueOf(cantidadaplicacionint);
                
            
          
            
            
              try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET surtidas = '" + totalaplicaciones + "' WHERE numero ='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacion + "'   and identificador = '"+identificador+"'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       

            }
              

      
        ////Actualiza el estatus

      String vendidastring = "";    
      String surtidastring = "";  
      String enviadastring = "";  
     
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(enviadas) as enviadas,Sum(surtidas) as surtidas from historial_ordenes_envio_recibidas where numero = '" + numeroordenopedidorecibido + "' ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        vendidastring = rs.getString("cantidad");
        surtidastring = rs.getString("surtidas");
        enviadastring = rs.getString("enviadas");
       
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
        
        
        
        
      
     ////Actualiza el estatus
      
     
      
      int vendida = Integer.parseInt(vendidastring);
      int surtida = Integer.parseInt(surtidastring);
      int enviada = Integer.parseInt(enviadastring);
     
      
        
        if(vendida == (surtida + enviada) && enviada == 0 )
        {
          estatusentrega ="surtida totalmente no enviada";  
        }
        
        else
          if(vendida == (surtida + enviada) && enviada > 0 )
        {
          estatusentrega ="surtida totalmente enviada parcialmente";  
        }
          
          
           else
          if(vendida > (surtida +enviada) && enviada > 0 )
        {
          estatusentrega ="surtida parcialmente enviada parcialmente";  
        }
     
        
        else
        {
          estatusentrega ="surtida parcialmente no enviada";   
        }    
        
        
        
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET estatus_entrega = '" + estatusentrega + "' WHERE numero = '" + numeroordenopedidorecibido + "' ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      
      
            
              
                
                
                
                
                
                
                
                
            }
         
         
      
      }
    
     
     
   
     
     
     
     
     
     
     
    void sumapuntos()
    {
        
        String cantidad = "0";
        
         String sql = "Select cantidad,pecho_izquierdo_cantidad,pecho_izquierdo_puntadas,"
                  + "pecho_derecho_cantidad,pecho_derecho_puntadas,"
                  + "manga_izquierda_cantidad,manga_izquierda_puntadas,"
                  + "manga_derecha_cantidad,manga_derecha_puntadas,"
                  + "espalda_cantidad,espalda_puntadas,"
                  + "otra_ubicacion_cantidad,otra_ubicacion_puntadas,"
                  + "otra_ubicacion2_cantidad,otra_ubicacion2_puntadas,"
                  + "aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2 from "+nombredelatabla+" where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"' ";

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
              
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

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
               
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

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
               
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

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
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadasaplicacioneschicas = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

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
    
    
    
    
    
    void deshabilitarbotonesporqueesponchado(){
        
        
        
        
        btnpechoizquierdotermine.setEnabled(false);
        btnpechoderechotermine.setEnabled(false);
        btnmangaizquierdatermine.setEnabled(false);
        btnmangaderechatetermine.setEnabled(false);
        btnespaldatetermine.setEnabled(false);
        btnotraubicaciontetermine.setEnabled(false);
        btnotraubicacion2tetermine.setEnabled(false);
        
        btnterminetodo.setEnabled(false);        
                
                
        btnpechoizquierdocancelar.setEnabled(false);
        btnpechoderechocancelar.setEnabled(false); 
        btnmangaizquierdacancelar.setEnabled(false);
        btnmangaderechacancelar.setEnabled(false);
        btnespaldacancelar.setEnabled(false);
        btnotraubicacioncancelar.setEnabled(false);
        btnotraubicacion2cancelar.setEnabled(false); 
        
        btnponchado1.setEnabled(false);
        btnponchado2.setEnabled(false);
        btnponchado3.setEnabled(false);
        btnponchado4.setEnabled(false);
        btnponchado5.setEnabled(false);
        btnponchado6.setEnabled(false);
        btnponchado7.setEnabled(false);       
        
        
        
        
    }
    
    
    
    
    
    
    
    void actualizarestatusentregaordendebordado()
    {
        
        
       
   
        int tienecantidad = 0;
        botonesactivados = 0;
        
         String sql = "Select pecho_izquierdo_cantidad,pecho_izquierdo_puntadas,"
                  + "pecho_derecho_cantidad,pecho_derecho_puntadas,"
                  + "manga_izquierda_cantidad,manga_izquierda_puntadas,"
                  + "manga_derecha_cantidad,manga_derecha_puntadas,"
                  + "espalda_cantidad,espalda_puntadas,"
                  + "otra_ubicacion_cantidad,otra_ubicacion_puntadas,"
                  + "otra_ubicacion2_cantidad,otra_ubicacion2_puntadas from "+nombredelatabla+" where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

              
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

                
                if(pechoizquierdo==null || pechoizquierdo.equals("")||pechoizquierdo.equals(" ")||pechoizquierdo.equals("ninguno") )
                {
                    
                    
                    
                }
                else
                {
                    
                     botonesactivados = botonesactivados + 1; 
                    
                    
                     if(cantidadpechoizquierdo.equals("0") )
                {
              //      lbcantidad1.setText("0");
              //      lbcantidad1.setForeground(Color.red.darker());
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                   
                   
                //   lbcantidad1.setText(cantidad);
                //   lbcantidad1.setForeground(Color.GREEN.darker());
                   
                } 
                    
                    
                    
                  
                } 
                
                
                
                
                
                if(pechoderecho==null || pechoderecho.equals("")||pechoderecho.equals(" ")||pechoderecho.equals("ninguno") )
                {
                    
                   
                    
                }
                else
                {
                    botonesactivados = botonesactivados + 1;
                    
                     if(cantidadpechoderecho.equals("0") )
                {
                    
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                   
                     
               //     lbcantidad2.setText(cantidad);
                //     lbcantidad2.setForeground(Color.GREEN.darker());
                }
                     
                     
                 
                }
                
                
                
                
                
                
                    
                if(mangaizquierda==null || mangaizquierda.equals("")||mangaizquierda.equals(" ")||mangaizquierda.equals("ninguno") )
                {
                    
                  
                    
                }
                else
                {
                    
                    
                    botonesactivados = botonesactivados + 1;
                    
                    
                    
                        if(cantidadmangaizquierda.equals("0"))
                {
                    
                    
                //      lbcantidad3.setText("0");
                //    lbcantidad3.setForeground(Color.red.darker());
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                   
                    
                 //  lbcantidad3.setText(cantidad);
                //    lbcantidad3.setForeground(Color.GREEN.darker());
                }
                        
                        
                        
                  
                }
                
                
                
                
                
                
                
                
                if(mangaderecha==null || mangaderecha.equals("")||mangaderecha.equals(" ")||mangaderecha.equals("ninguno") )
                {
                    
                    
                    
                }
                else
                {
                    
                    botonesactivados = botonesactivados + 1;
                    
                    
                    
                     if(cantidadmangaderecha.equals("0") )
                {
                    
                  //  lbcantidad4.setText("0");
                 //   lbcantidad4.setForeground(Color.red.darker());
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                   
                    
              //     lbcantidad4.setText(cantidad);
              //      lbcantidad4.setForeground(Color.GREEN.darker());
                    
                }
                    
                  
                }
                
                
                
                
                
            
                
                if(espalda==null || espalda.equals("")||espalda.equals(" ")||espalda.equals("ninguno") )
                {
                    
                  
                    
                }
                else
                {
                    
                    botonesactivados = botonesactivados + 1;
                    
                    
                      if(cantidadespalda.equals("0") )
                {
             //         lbcantidad5.setText("0");
            //        lbcantidad5.setForeground(Color.red.darker());
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                   
                   
               //    lbcantidad5.setText(cantidad);
               //     lbcantidad5.setForeground(Color.GREEN.darker());
                    
                    
                }
            
                      
                      
                   
                }
            
                
                
                
                
                
                
                if(otraubicacion==null || otraubicacion.equals("")||otraubicacion.equals(" ")||otraubicacion.equals("ninguno") )
                {
                    
                   
                    
                }
                else
                {
                    
                    
                    botonesactivados = botonesactivados + 1;
                    
                    
                      
                if(cantidadotraubicacion.equals("0") )
                {
                    
                //     lbcantidad6.setText("0");
               //     lbcantidad6.setForeground(Color.red.darker());
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                     
              //     lbcantidad6.setText(cantidad);
             //       lbcantidad6.setForeground(Color.GREEN.darker());
                   
                }
            
                
                
                
                 
                }
            
                
                
                
                
                
                
           if(otraubicacion2==null || otraubicacion2.equals("")||otraubicacion2.equals(" ")||otraubicacion2.equals("ninguno") )
                {
                    
                    
                    
                }
                else
                {
                    
                    
                    botonesactivados = botonesactivados + 1;
                    
                    
                     if(cantidadotraubicacion2.equals("0") )
                {
                    
                    
                    
              //      lbcantidad7.setText("0");
               //     lbcantidad7.setForeground(Color.red.darker());
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                   
                    
              //     lbcantidad7.setText(cantidad);
              //      lbcantidad7.setForeground(Color.GREEN.darker());
                    
                }
           
                    
                  
                }
           
           
           
           
           
           
           
           
                ////////////////////////////////////////////////////////////////
                
                
                
                
                
                
                
               
                
                
               
                
                
                
              
                  
                  
                
               
                
              
                
              
              
          
            
           
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
               
               
               
               try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set estatus_orden='"+nuevoestatusorden+"' where numero='" + numeroordendebordadosolicitadoorecibidasisehabredesderecibidas + "' and prenda='" +prenda+ "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                 
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                }
               
           


        }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        
        
        lbestatus.setText(nuevoestatusorden);
        
        
        
        
    }
    
   

     void verfotomontajerecibido()
    {
       String prenda =lbprenda.getText().toUpperCase();
     
        String rutadelarchivo = "";
        String existe = "";
        
        //// prenda del fotomontaje
        String sql = "Select imagen,imagen_nombre from historial_ordenes_camisa_recibidas where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"'   ";

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
                    String nombredelarchivo = rs1.getString("imagen_nombre");
                    if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                        
                     rutadelarchivo = "C:\\archivospdf\\fotomontajegorra."+nombredelarchivo+" ";   
                   
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

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px ;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE); 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");
            }
        
        } 
        
        
    }
    
     
     
     
     
     
    void cliente(){
        
        
        String cliente = lbcliente.getText();
        
          String sql = "SELECT nombre_comercial,borda_cliente,codigo FROM catalogo_clientes WHERE nombre = '" + cliente + "' ";

                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {

                        
                      
                        lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                        lbbordacliente.setText(rs.getString("borda_cliente"));
                         codigocliente = rs.getString("codigo");

                    }

                } catch (Exception e) {
                
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");

                }
        
    }
    
    
    
    
    
     
     void descargarponchado(String ubicacion,String ubicacionnombre)
     {
         
         JFileChooser fs = new JFileChooser();
        

         try (
                 PreparedStatement ps = cn.prepareStatement("select " + ubicacion + "," + ubicacionnombre + " from historial_ordenes_camisa_recibidas where numero = '" + numeroordendebordadosolicitadoorecibidasisehabredesderecibidas + "' ")) {
             ResultSet rs = ps.executeQuery();

             if (rs.next()) {

                 fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
            
                 
                 
                 
                 String nombre = rs.getString("" + ubicacionnombre + "");
                 
                 if (nombre==null)
                 {
                 
               JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encontró el ponchado, favor de marcarle a la sucursal para que se lo replique o llame a sistemas");
                 
                 }
                 else
                 {
                     
                 
                 
                 fs.setSelectedFile(new File(nombre));
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
        lbcliente = new javax.swing.JLabel();
        lbnumerodeventa = new javax.swing.JLabel();
        btnreplicartodoslosponchados = new javax.swing.JButton();
        lbtipo = new javax.swing.JLabel();
        btneditarbordado = new javax.swing.JButton();
        btnverfotomontaje = new javax.swing.JButton();
        lbidentificador = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbbordacliente = new javax.swing.JLabel();
        btnmangaderechatetermine = new javax.swing.JButton();
        btnmangaizquierdatermine = new javax.swing.JButton();
        btnpechoderechotermine = new javax.swing.JButton();
        btnpechoizquierdotermine = new javax.swing.JButton();
        btnespaldatetermine = new javax.swing.JButton();
        btnotraubicaciontetermine = new javax.swing.JButton();
        btnotraubicacion2tetermine = new javax.swing.JButton();
        lbltallas = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbnombrecomercial = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnterminetodo = new javax.swing.JButton();
        lbprenda = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbnumeroordenbordadodelaotrasucursal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbdiaentrega = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbhoraentrega = new javax.swing.JLabel();
        btnvercolorido = new javax.swing.JButton();
        lbcolor1 = new javax.swing.JLabel();
        lbcolor2 = new javax.swing.JLabel();
        lbcolor3 = new javax.swing.JLabel();
        lbcolor4 = new javax.swing.JLabel();
        lbcolor5 = new javax.swing.JLabel();
        lbcolor6 = new javax.swing.JLabel();
        lbcolor7 = new javax.swing.JLabel();
        btndatos = new javax.swing.JButton();
        btnfotomontajesinpuntadas = new javax.swing.JButton();
        lbhilo1 = new javax.swing.JLabel();
        lbhilo2 = new javax.swing.JLabel();
        lbhilo3 = new javax.swing.JLabel();
        lbhilo4 = new javax.swing.JLabel();
        lbhilo5 = new javax.swing.JLabel();
        lbhilo6 = new javax.swing.JLabel();
        lbhilo7 = new javax.swing.JLabel();
        lbpechoizquierdo = new javax.swing.JLabel();
        lbpechoderecho = new javax.swing.JLabel();
        lbmangaizquierda = new javax.swing.JLabel();
        lbmangaderecha = new javax.swing.JLabel();
        lbespalda = new javax.swing.JLabel();
        lbotraubicacion = new javax.swing.JLabel();
        lbotraubicacion2 = new javax.swing.JLabel();
        lbpechoderechonombre1 = new javax.swing.JLabel();
        lbpechoizquierdonombre1 = new javax.swing.JLabel();
        lbmangaizquierdanombre1 = new javax.swing.JLabel();
        lbmangaderechanombre1 = new javax.swing.JLabel();
        lbespaldanombre1 = new javax.swing.JLabel();
        lbotraubicacionnombre1 = new javax.swing.JLabel();
        lbotraubicacion2nombre1 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        btnponchado7 = new javax.swing.JButton();
        btnponchado6 = new javax.swing.JButton();
        btnponchado5 = new javax.swing.JButton();
        btnponchado1 = new javax.swing.JButton();
        btnponchado2 = new javax.swing.JButton();
        btnponchado3 = new javax.swing.JButton();
        btnponchado4 = new javax.swing.JButton();
        btnpechoizquierdocancelar = new javax.swing.JButton();
        btnpechoderechocancelar = new javax.swing.JButton();
        btnmangaizquierdacancelar = new javax.swing.JButton();
        btnmangaderechacancelar = new javax.swing.JButton();
        btnespaldacancelar = new javax.swing.JButton();
        btnotraubicacioncancelar = new javax.swing.JButton();
        btnotraubicacion2cancelar = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lbsucursal = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbpechoizquierdonombre = new javax.swing.JLabel();
        lbpechoderechonombre = new javax.swing.JLabel();
        lbmangaizquierdanombre = new javax.swing.JLabel();
        lbmangaderechanombre = new javax.swing.JLabel();
        lbespaldanombre = new javax.swing.JLabel();
        lbotraubicacionnombre = new javax.swing.JLabel();
        lbotraubicacion2nombre = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbestatus = new javax.swing.JLabel();
        lbcantidad7 = new javax.swing.JLabel();
        lbcantidad6 = new javax.swing.JLabel();
        lbcantidad5 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbautorizacion = new javax.swing.JLabel();
        lbnumeroordenopedidosolicitado = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbordenopedidorecibido = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbnumeroordenopedidorecibido = new javax.swing.JLabel();
        btnreplicar7 = new javax.swing.JButton();
        btnreplicar6 = new javax.swing.JButton();
        btnreplicar5 = new javax.swing.JButton();
        btnreplicar1 = new javax.swing.JButton();
        btnreplicar2 = new javax.swing.JButton();
        btnreplicar3 = new javax.swing.JButton();
        btnreplicar4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbsumapuntos1 = new javax.swing.JLabel();
        lbsumapuntos2 = new javax.swing.JLabel();
        lbsumapuntos3 = new javax.swing.JLabel();
        lbsumapuntos4 = new javax.swing.JLabel();
        lbsumapuntos5 = new javax.swing.JLabel();
        lbsumapuntos6 = new javax.swing.JLabel();
        lbsumapuntos7 = new javax.swing.JLabel();
        btncargarponchado1 = new javax.swing.JButton();
        btncargarponchado3 = new javax.swing.JButton();
        btncargarponchado2 = new javax.swing.JButton();
        btncargarponchado4 = new javax.swing.JButton();
        btncargarponchado5 = new javax.swing.JButton();
        btncargarponchado6 = new javax.swing.JButton();
        btncargarponchado7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnquitarponchado1 = new javax.swing.JButton();
        btnquitarponchado2 = new javax.swing.JButton();
        btnquitarponchado3 = new javax.swing.JButton();
        btnquitarponchado4 = new javax.swing.JButton();
        btnquitarponchado5 = new javax.swing.JButton();
        btnquitarponchado6 = new javax.swing.JButton();
        btnquitarponchado7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden camisa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
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
        lbfotomontaje.setBounds(-10, 0, 1040, 600);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Numero orden de bordado");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lborden.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lborden.setForeground(new java.awt.Color(0, 0, 153));
        lborden.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Cliente");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumerodeventa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnumerodeventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnreplicartodoslosponchados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreplicartodoslosponchados.setText("Replicar todos");
        btnreplicartodoslosponchados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicartodoslosponchadosActionPerformed(evt);
            }
        });

        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btneditarbordado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneditarbordado.setText("Editar bordado");
        btneditarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarbordadoActionPerformed(evt);
            }
        });

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbidentificador.setForeground(new java.awt.Color(0, 0, 153));
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Cantidad");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfecha.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbfecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Fecha entrega");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Bordacliente");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnmangaderechatetermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaderechatetermine.setText("Termine");
        btnmangaderechatetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnmangaderechatetermineMouseReleased(evt);
            }
        });
        btnmangaderechatetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechatetermineActionPerformed(evt);
            }
        });

        btnmangaizquierdatermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaizquierdatermine.setText("Termine");
        btnmangaizquierdatermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnmangaizquierdatermineMouseReleased(evt);
            }
        });
        btnmangaizquierdatermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdatermineActionPerformed(evt);
            }
        });

        btnpechoderechotermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoderechotermine.setText("Termine");
        btnpechoderechotermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnpechoderechotermineMouseReleased(evt);
            }
        });
        btnpechoderechotermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechotermineActionPerformed(evt);
            }
        });

        btnpechoizquierdotermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoizquierdotermine.setText("Termine");
        btnpechoizquierdotermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnpechoizquierdotermineMouseReleased(evt);
            }
        });
        btnpechoizquierdotermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdotermineActionPerformed(evt);
            }
        });

        btnespaldatetermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnespaldatetermine.setText("Termine");
        btnespaldatetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnespaldatetermineMouseReleased(evt);
            }
        });
        btnespaldatetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldatetermineActionPerformed(evt);
            }
        });

        btnotraubicaciontetermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicaciontetermine.setText("Termine");
        btnotraubicaciontetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnotraubicaciontetermineMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnotraubicaciontetermineMouseReleased(evt);
            }
        });
        btnotraubicaciontetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicaciontetermineActionPerformed(evt);
            }
        });

        btnotraubicacion2tetermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacion2tetermine.setText("Termine");
        btnotraubicacion2tetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnotraubicacion2tetermineMouseReleased(evt);
            }
        });
        btnotraubicacion2tetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacion2tetermineActionPerformed(evt);
            }
        });

        lbltallas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbltallasMouseClicked(evt);
            }
        });

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsumapuntos.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total de Puntos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Nombre comercial");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Observacion");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnterminetodo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnterminetodo.setText("Terminé todos!!");
        btnterminetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterminetodoActionPerformed(evt);
            }
        });

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Numero orden o pedido solicitado");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroordenbordadodelaotrasucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumeroordenbordadodelaotrasucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Fecha de elaboración");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdiaentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbdiaentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Hora entrega");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhoraentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnvercolorido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnvercolorido.setText("Ver colorido");
        btnvercolorido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvercoloridoActionPerformed(evt);
            }
        });

        lbcolor1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcolor1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcolor2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcolor3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcolor4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcolor5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcolor6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcolor7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndatos.setText("datos");
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
            }
        });

        btnfotomontajesinpuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnfotomontajesinpuntadas.setText("Fotomontaje sin puntadas");
        btnfotomontajesinpuntadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfotomontajesinpuntadasActionPerformed(evt);
            }
        });

        lbhilo1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbhilo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhilo2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbhilo2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhilo3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbhilo3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhilo4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbhilo4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhilo5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbhilo5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhilo6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbhilo6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhilo7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbhilo7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbpechoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbpechoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbmangaizquierda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmangaderecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbmangaderecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbespalda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbespalda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbotraubicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacion2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbotraubicacion2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoderechonombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoderechonombre1.setText("Pecho Derecho");
        lbpechoderechonombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoizquierdonombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoizquierdonombre1.setText("Pecho Izquierdo");
        lbpechoizquierdonombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmangaizquierdanombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbmangaizquierdanombre1.setText("Manga izquierda");
        lbmangaizquierdanombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmangaderechanombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbmangaderechanombre1.setText("Manga derecha");
        lbmangaderechanombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbespaldanombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbespaldanombre1.setText("Espalda");
        lbespaldanombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacionnombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbotraubicacionnombre1.setText("Otra ubicacion");
        lbotraubicacionnombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacion2nombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbotraubicacion2nombre1.setText("Otra ubicacion2");
        lbotraubicacion2nombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel14.setText("No. de venta");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnponchado7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnponchado7.setText("Ponchado");
        btnponchado7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado7ActionPerformed(evt);
            }
        });

        btnponchado6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnponchado6.setText("Ponchado");
        btnponchado6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado6ActionPerformed(evt);
            }
        });

        btnponchado5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnponchado5.setText("Ponchado");
        btnponchado5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado5ActionPerformed(evt);
            }
        });

        btnponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnponchado1.setText("Ponchado");
        btnponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado1ActionPerformed(evt);
            }
        });

        btnponchado2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnponchado2.setText("Ponchado");
        btnponchado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado2ActionPerformed(evt);
            }
        });

        btnponchado3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnponchado3.setText("Ponchado");
        btnponchado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado3ActionPerformed(evt);
            }
        });

        btnponchado4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnponchado4.setText("Ponchado");
        btnponchado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado4ActionPerformed(evt);
            }
        });

        btnpechoizquierdocancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoizquierdocancelar.setText("Cancelar");
        btnpechoizquierdocancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnpechoizquierdocancelarMouseReleased(evt);
            }
        });
        btnpechoizquierdocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdocancelarActionPerformed(evt);
            }
        });

        btnpechoderechocancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoderechocancelar.setText("Cancelar");
        btnpechoderechocancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnpechoderechocancelarMouseReleased(evt);
            }
        });
        btnpechoderechocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechocancelarActionPerformed(evt);
            }
        });

        btnmangaizquierdacancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaizquierdacancelar.setText("Cancelar");
        btnmangaizquierdacancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnmangaizquierdacancelarMouseReleased(evt);
            }
        });
        btnmangaizquierdacancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdacancelarActionPerformed(evt);
            }
        });

        btnmangaderechacancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaderechacancelar.setText("Cancelar");
        btnmangaderechacancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnmangaderechacancelarMouseReleased(evt);
            }
        });
        btnmangaderechacancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechacancelarActionPerformed(evt);
            }
        });

        btnespaldacancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnespaldacancelar.setText("Cancelar");
        btnespaldacancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnespaldacancelarMouseReleased(evt);
            }
        });
        btnespaldacancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldacancelarActionPerformed(evt);
            }
        });

        btnotraubicacioncancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacioncancelar.setText("Cancelar");
        btnotraubicacioncancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnotraubicacioncancelarMouseReleased(evt);
            }
        });
        btnotraubicacioncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacioncancelarActionPerformed(evt);
            }
        });

        btnotraubicacion2cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacion2cancelar.setText("Cancelar");
        btnotraubicacion2cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnotraubicacion2cancelarMouseReleased(evt);
            }
        });
        btnotraubicacion2cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacion2cancelarActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Sucursal");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsucursal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbsucursal.setForeground(new java.awt.Color(0, 0, 153));
        lbsucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Prenda");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Identificador");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoizquierdonombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbpechoizquierdonombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoderechonombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbpechoderechonombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmangaizquierdanombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbmangaizquierdanombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmangaderechanombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbmangaderechanombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbespaldanombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbespaldanombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacionnombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbotraubicacionnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacion2nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbotraubicacion2nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Estatus");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbestatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbestatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbautorizacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbautorizacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroordenopedidosolicitado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumeroordenopedidosolicitado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Tiene orden o pedido recibido?");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbordenopedidorecibido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbordenopedidorecibido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel27.setText("Número");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroordenopedidorecibido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnumeroordenopedidorecibido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnreplicar7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar7.setText("Replicar");
        btnreplicar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar7ActionPerformed(evt);
            }
        });

        btnreplicar6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar6.setText("Replicar");
        btnreplicar6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar6ActionPerformed(evt);
            }
        });

        btnreplicar5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar5.setText("Replicar");
        btnreplicar5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar5ActionPerformed(evt);
            }
        });

        btnreplicar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar1.setText("Replicar");
        btnreplicar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar1ActionPerformed(evt);
            }
        });

        btnreplicar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar2.setText("Replicar");
        btnreplicar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar2ActionPerformed(evt);
            }
        });

        btnreplicar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar3.setText("Replicar");
        btnreplicar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar3ActionPerformed(evt);
            }
        });

        btnreplicar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar4.setText("Replicar");
        btnreplicar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Puntos");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Puntos");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Puntos");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Puntos");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Puntos");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Puntos");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Puntos");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btncargarponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado1.setText("Cargar Ponchado");
        btncargarponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado1ActionPerformed(evt);
            }
        });

        btncargarponchado3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado3.setText("Cargar Ponchado");
        btncargarponchado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado3ActionPerformed(evt);
            }
        });

        btncargarponchado2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado2.setText("Cargar Ponchado");
        btncargarponchado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado2ActionPerformed(evt);
            }
        });

        btncargarponchado4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado4.setText("Cargar Ponchado");
        btncargarponchado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado4ActionPerformed(evt);
            }
        });

        btncargarponchado5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado5.setText("Cargar Ponchado");
        btncargarponchado5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado5ActionPerformed(evt);
            }
        });

        btncargarponchado6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado6.setText("Cargar Ponchado");
        btncargarponchado6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado6ActionPerformed(evt);
            }
        });

        btncargarponchado7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado7.setText("Cargar Ponchado");
        btncargarponchado7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado7ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Numero orden o pedido solicitado");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel28.setText("Numero orden de bordado rebidida por la otra sucursal");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnquitarponchado1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado1.setText("-");
        btnquitarponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado1ActionPerformed(evt);
            }
        });

        btnquitarponchado2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado2.setText("-");
        btnquitarponchado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado2ActionPerformed(evt);
            }
        });

        btnquitarponchado3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado3.setText("-");
        btnquitarponchado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado3ActionPerformed(evt);
            }
        });

        btnquitarponchado4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado4.setText("-");
        btnquitarponchado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado4ActionPerformed(evt);
            }
        });

        btnquitarponchado5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado5.setText("-");
        btnquitarponchado5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado5ActionPerformed(evt);
            }
        });

        btnquitarponchado6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado6.setText("-");
        btnquitarponchado6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado6ActionPerformed(evt);
            }
        });

        btnquitarponchado7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado7.setText("-");
        btnquitarponchado7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(272, 272, 272)
                                        .addComponent(btnfotomontajesinpuntadas))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(lbdiaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbnumeroordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lbltallas, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel13)
                                                        .addGap(7, 7, 7)
                                                        .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(5, 5, 5)
                                                .addComponent(lbnumeroordenbordadodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel18)
                                .addGap(7, 7, 7)
                                .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel16)
                                .addGap(7, 7, 7)
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel19)
                                .addGap(7, 7, 7)
                                .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbmangaizquierdanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(lbmangaizquierdanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnmangaizquierdatermine, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnmangaizquierdacancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btncargarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbpechoderechonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(lbpechoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnpechoderechotermine, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnpechoderechocancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btncargarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbpechoizquierdonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(lbpechoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(lbpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnpechoizquierdotermine, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnpechoizquierdocancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncargarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnterminetodo)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbmangaderechanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbespaldanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbotraubicacionnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbotraubicacion2nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(12, 12, 12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbmangaderechanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbespaldanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbotraubicacionnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbotraubicacion2nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(btnmangaderechatetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addComponent(btnespaldatetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnotraubicaciontetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(btnotraubicacion2tetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnespaldacancelar)
                                    .addComponent(btnotraubicacion2cancelar)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnmangaderechacancelar)
                                            .addComponent(btnotraubicacioncancelar))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btncargarponchado5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btncargarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btncargarponchado6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)
                                                .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btncargarponchado7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnquitarponchado1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnquitarponchado2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnquitarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnquitarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnquitarponchado5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnquitarponchado6, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnquitarponchado7, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnreplicar1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(btnponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(4, 4, 4)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnreplicar2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(10, 10, 10)
                                                                .addComponent(btnponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnreplicar3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(10, 10, 10)
                                                                .addComponent(btnponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnreplicar4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(10, 10, 10)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(btnponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(btnponchado7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                                .addGap(3, 3, 3))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addGap(5, 5, 5)
                                                    .addComponent(btnreplicar5, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btnponchado5, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(4, 4, 4))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addGap(8, 8, 8)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnreplicar7, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(btnreplicar6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(btnponchado6, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(5, 5, 5)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnreplicartodoslosponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(102, 102, 102)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(lbsumapuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(lbsumapuntos2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(lbsumapuntos3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(15, 15, 15))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbsumapuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbsumapuntos5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbsumapuntos6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbsumapuntos7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 601, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnfotomontajesinpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(lbltallas, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumeroordenbordadodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbdiaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbnumeroordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbsumapuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbsumapuntos2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbsumapuntos3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbsumapuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lbsumapuntos5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbsumapuntos6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lbsumapuntos7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnreplicar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnquitarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(163, 163, 163)
                                        .addComponent(btnponchado6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(163, 163, 163)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnreplicar6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(btnreplicar7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnreplicar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnreplicar3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnquitarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnreplicar4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnreplicar5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnponchado5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(80, 80, 80)
                                        .addComponent(btnponchado7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnreplicartodoslosponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbpechoizquierdonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbpechoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnpechoizquierdotermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnpechoizquierdocancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btncargarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbpechoderechonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbpechoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnpechoderechotermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnpechoderechocancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbmangaizquierdanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbmangaizquierdanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnmangaizquierdatermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnmangaizquierdacancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbmangaderechanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(lbespaldanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)
                                        .addComponent(lbotraubicacionnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(lbotraubicacion2nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbmangaderechanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(lbespaldanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addComponent(lbotraubicacionnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(lbotraubicacion2nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(lbespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(11, 11, 11)
                                                .addComponent(lbotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(lbotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnmangaderechatetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(btnespaldatetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(btnotraubicaciontetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(btnotraubicacion2tetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnmangaderechacancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(btnespaldacancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(btnotraubicacioncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(4, 4, 4)
                                                .addComponent(btnotraubicacion2cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(7, 7, 7)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btncargarponchado7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(btnquitarponchado7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btncargarponchado6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnquitarponchado6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btncargarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnquitarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(btncargarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btncargarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnquitarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btncargarponchado5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnquitarponchado5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
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

        ventanaordencamisa = false;
         if(ordenesporrealizar.ventanaordenesporrealizar==true)
        {
            ordenesporrealizar.btnactualizar.doClick();
        }

        this.dispose();
        ventanaordencamisa = false;

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordencamisa = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   
      datos();
      
      
      conectadaasucursal();
      
      
      
       
               if (esponchado.equals("si"))
                   
               {
           lugar = enquesucursalsebordara;
           deshabilitarbotonesporqueesponchado();
           
            btnreplicartodoslosponchados.setEnabled(true);
                
                
                  if(lugar.equals("Esta sucursal"))
        {
       
           nombredelatabla = "historial_ordenes_camisa";
                
        }
                  else
                      
                  {
  
            
           nombredelatabla = "historial_ordenes_camisa_recibidas";
            
            
                    
                  }
                
                
               }  
                
      
      
      
      
      
        
    }//GEN-LAST:event_formWindowOpened

    private void btnmangaizquierdatermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdatermineActionPerformed

        
          
          ubicacion = "manga_izquierda_cantidad";
          fechaubicacion  = "manga_izquierda_fecha";
           nombrebordado = mangaizquierdanombre;
            cantidadaplicacion = aplicacionmangaizquierda;
        
                ubicacionprenda = "MANGA IZQUIERDA";
                                                
                                                
                                                
         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 
        
       
            
           
              determinaciondeladescripciondelbordado();
           
            
            
            //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
       agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
    
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
          
         //    nombredelatabla = "historial_ordenes_camisa_recibidas";
        
            agregarsurtidasalhistorialdepedidosoenviosyactualizarestatus((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
            
          

        }
        
        
        
        
        
        
        
        insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);  
        
        actualizarestatusentregaordendebordado(); 
    
        sumapuntos();   
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
        
        }
         
         
         
         
         
         
         
         
         
         
         
         
         
         
        
    }//GEN-LAST:event_btnmangaizquierdatermineActionPerformed

    private void btnpechoizquierdotermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdotermineActionPerformed

        
        
        
           fechaubicacion  = "pecho_izquierdo_fecha";
           ubicacion = "pecho_izquierdo_cantidad"; 
            
           ubicacionprenda = "PECHO IZQUIERDO";
           nombrebordado =pechoizquierdonombre;
           cantidadaplicacion = aplicacionpechoizquierdo;
        
        
        
        
        
        
         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 
        
      
           
              determinaciondeladescripciondelbordado();
           
            
            
            //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
       agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
    
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
          
         //    nombredelatabla = "historial_ordenes_camisa_recibidas";
        
            agregarsurtidasalhistorialdepedidosoenviosyactualizarestatus((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
            
          

        }
        
        
        
        
        
        
        
        insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);  
        
        actualizarestatusentregaordendebordado(); 
    
        sumapuntos();   
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
        
        
    
        }
    
    
    }//GEN-LAST:event_btnpechoizquierdotermineActionPerformed

    private void btnespaldatetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldatetermineActionPerformed

        
        
        
          
          fechaubicacion  = "espalda_fecha";
           ubicacion = "espalda_cantidad";
           
            nombrebordado = espaldanombre;
            cantidadaplicacion = aplicacionespalda;
            
            ubicacionprenda = "ESPALDA";
                  
         
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
      
           
              determinaciondeladescripciondelbordado();
           
            
            
            //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
       agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
    
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
          
         //    nombredelatabla = "historial_ordenes_camisa_recibidas";
        
            agregarsurtidasalhistorialdepedidosoenviosyactualizarestatus((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
            
          

        }
        
        
        
        
        
        
        
        insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);  
        
        actualizarestatusentregaordendebordado(); 
    
        sumapuntos();   
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
      
       
        
        } 
        
        
        
    }//GEN-LAST:event_btnespaldatetermineActionPerformed

    private void btnpechoderechotermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechotermineActionPerformed
     
        
        fechaubicacion  = "pecho_derecho_fecha";
        ubicacion = "pecho_derecho_cantidad";
        nombrebordado = pechoderechonombre;
        cantidadaplicacion = aplicacionpechoderecho;
        ubicacionprenda = "PECHO DERECHO";
        
        
        
         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 

    
            
           
              determinaciondeladescripciondelbordado();
           
            
            
            //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
       agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
    
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
          
         //    nombredelatabla = "historial_ordenes_camisa_recibidas";
        
            agregarsurtidasalhistorialdepedidosoenviosyactualizarestatus((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
            
          

        }
        
        
        
        
        
        
        
        insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);  
        
        actualizarestatusentregaordendebordado(); 
    
        sumapuntos();   
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
      
        
        }
        
    }//GEN-LAST:event_btnpechoderechotermineActionPerformed

    private void btnmangaderechatetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechatetermineActionPerformed

        
         
          fechaubicacion  = "manga_derecha_fecha";
          ubicacion = "manga_derecha_cantidad";
          nombrebordado = mangaderechanombre;
          cantidadaplicacion = aplicacionmangaderecha;       
                        
          ubicacionprenda = "MANGA DERECHA";                              
                                        
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {    
        
       
           
              determinaciondeladescripciondelbordado();
           
            
            
            //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
       agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
    
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
          
         //    nombredelatabla = "historial_ordenes_camisa_recibidas";
        
            agregarsurtidasalhistorialdepedidosoenviosyactualizarestatus((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
            
          

        }
        
        
        
        
        
        
        
        insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);  
        
        actualizarestatusentregaordendebordado(); 
    
        sumapuntos();   
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
      
           
            
        }    
   
        
    }//GEN-LAST:event_btnmangaderechatetermineActionPerformed

    private void btnreplicartodoslosponchadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicartodoslosponchadosActionPerformed
       
        
        
           if(btnreplicar1.isEnabled())
                {
                    btnreplicar1.doClick();
                }
                
                
                if(btnreplicar2.isEnabled())
                {
                    btnreplicar2.doClick();
                }
                
                
                if(btnreplicar3.isEnabled())
                {
                    btnreplicar3.doClick();
                }
                
                
                if(btnreplicar4.isEnabled())
                {
                    btnreplicar4.doClick();
                }
                
                
                if(btnreplicar5.isEnabled())
                {
                    btnreplicar5.doClick();
                }
                
                
                if(btnreplicar6.isEnabled())
                {
                    btnreplicar6.doClick();
                }
                
                
                if(btnreplicar7.isEnabled())
                {
                    btnreplicar7.doClick();
                }
              
          
      
        
        
        
        
        

    }//GEN-LAST:event_btnreplicartodoslosponchadosActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
    }//GEN-LAST:event_formWindowClosed

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

    private void btnotraubicaciontetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicaciontetermineActionPerformed

        
          
          fechaubicacion  = "otra_ubicacion_fecha";
          ubicacion = "otra_ubicacion_cantidad";
          nombrebordado = otraubicacionnombre;
          cantidadaplicacion = aplicacionotraubicacion;
               
         ubicacionprenda = "OTRA UBICACION";
                                        
                                        
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        

           
              determinaciondeladescripciondelbordado();
           
            
            
            //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
       agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
    
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
          
         //    nombredelatabla = "historial_ordenes_camisa_recibidas";
        
            agregarsurtidasalhistorialdepedidosoenviosyactualizarestatus((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
            
          

        }
        
        
        
        
        
        
        
        insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);  
        
        actualizarestatusentregaordendebordado(); 
    
        sumapuntos();   
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
      
       
        
        
        }
        
    }//GEN-LAST:event_btnotraubicaciontetermineActionPerformed

    private void btnotraubicacion2tetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacion2tetermineActionPerformed

        
         
         fechaubicacion  = "otra_ubicacion2_fecha";
            ubicacion = "otra_ubicacion2_cantidad";
            nombrebordado = otraubicacion2nombre;
            cantidadaplicacion = aplicacionotraubicacion2; 
            
            ubicacionprenda = "OTRA UBICACION2";
                                        
         
                                                
                                                
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
      
           
              determinaciondeladescripciondelbordado();
           
            
            
            //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
       agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
    
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
          
         //    nombredelatabla = "historial_ordenes_camisa_recibidas";
        
            agregarsurtidasalhistorialdepedidosoenviosyactualizarestatus((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
            
          

        }
        
        
        
        
        
        
        
        insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);  
        
        actualizarestatusentregaordendebordado(); 
    
        sumapuntos();   
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
      
            
            
        }
        
        
    }//GEN-LAST:event_btnotraubicacion2tetermineActionPerformed

    private void lbltallasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbltallasMouseClicked
        if (evt.getClickCount() == 2) 
        {

            if (lugar.equals("Otra sucursal") && tipotabla.equals("Local")) 
            {
            }
            else if (lugar.equals("Otra sucursal") && tipotabla.equals("Recibida")) 
            {
            }
            else 
            {
                tallas ventana = new tallas();
                ventana.setVisible(true);
                ventana.setLocationRelativeTo(null);
                this.setState(this.ICONIFIED);
            }

        }
    }//GEN-LAST:event_lbltallasMouseClicked

    private void btnterminetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterminetodoActionPerformed
      
        terminetodo = "si";
        
            
           
                if(btnpechoizquierdotermine.isEnabled())
                {
                    btnpechoizquierdotermine.doClick();
                }
                
                
                if(btnpechoderechotermine.isEnabled())
                {
                    btnpechoderechotermine.doClick();
                }
                
                
                if(btnmangaizquierdatermine.isEnabled())
                {
                    btnmangaizquierdatermine.doClick();
                }
                
                
                if(btnmangaderechatetermine.isEnabled())
                {
                    btnmangaderechatetermine.doClick();
                }
                
                
                if(btnespaldatetermine.isEnabled())
                {
                    btnespaldatetermine.doClick();
                }
                
                
                if(btnotraubicaciontetermine.isEnabled())
                {
                    btnotraubicaciontetermine.doClick();
                }
                
                
                if(btnotraubicacion2tetermine.isEnabled())
                {
                    btnotraubicacion2tetermine.doClick();
                }
              
          
      
        
        
        
        
         terminetodo = "no";
         btnterminetodo.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden se actualizo");
         
         if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
         this.dispose();
         ventanaordencamisa = false;
         
         
         
         
         
         
    }//GEN-LAST:event_btnterminetodoActionPerformed

    private void btneditarbordadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarbordadoActionPerformed

        
        
        
         prenda = lbprenda.getText();
         prenda = prenda.toUpperCase();
      
        
        
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

    private void btnvercoloridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvercoloridoActionPerformed
       
    if(colorido.ventanacolorido ==true)
    {
        
    }
    else
    {
        colorido ventana =  new colorido();
        colorido.lbcliente.setText(lbcliente.getText());
        colorido.lbcodigo.setText(codigocliente);
        colorido.lbidentificador.setText(lbidentificador.getText());
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }    
           
    }//GEN-LAST:event_btnvercoloridoActionPerformed

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed
  
        
        datos();
      
      
    }//GEN-LAST:event_btndatosActionPerformed

    private void btnfotomontajesinpuntadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfotomontajesinpuntadasActionPerformed

        JFileChooser elegirImagen = new JFileChooser();
        elegirImagen.setMultiSelectionEnabled(false);
        int o = elegirImagen.showOpenDialog(this);
        if (o == JFileChooser.APPROVE_OPTION)
        {
            rutaarchivo = elegirImagen.getSelectedFile().getAbsolutePath();
            nombrearchivo = elegirImagen.getSelectedFile().getName();

            PreparedStatement myStmt = null;
            FileInputStream input = null;
            try {

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigocliente+"' and identificador_prenda = '"+identificador+"' and tipo = '"+lbprenda.getText()+"' and numero_consecutivo = '"+consecutivo+"' ";

                myStmt = cn.prepareStatement(sql);
                File theFile = new File(rutaarchivo);
                input = new FileInputStream(theFile);
                myStmt.setBinaryStream(1, input);
                myStmt.executeUpdate();
                myStmt.close();

                btnverfotomontaje.setEnabled(true);

            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"',puntadas_en_fotomontajes ='no' where codigo='"+codigocliente+"' and identificador_prenda = '"+identificador+"' and tipo = '"+lbprenda.getText()+"' and numero_consecutivo = '"+consecutivo+"' ");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            ImageIcon fot = new ImageIcon(rutaarchivo);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT));
            lbfotomontaje.setIcon(icono);
            this.repaint();

            btndatos.doClick();

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Fotomontaje agregado correctamente");

        }

    }//GEN-LAST:event_btnfotomontajesinpuntadasActionPerformed

    private void btnponchado7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado7ActionPerformed
     
        
        
         ubicacion = "otra_ubicacion2_ponchado";
                String ubicacionnombre = "otra_ubicacion2_ponchado_nombre";

                descargarponchado((String) ubicacion, (String) ubicacionnombre);
                
                
                
    }//GEN-LAST:event_btnponchado7ActionPerformed

    private void btnponchado6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado6ActionPerformed
    
        
        
           ubicacion ="otra_ubicacion_ponchado";
                String ubicacionnombre ="otra_ubicacion_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
                
    }//GEN-LAST:event_btnponchado6ActionPerformed

    private void btnponchado5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado5ActionPerformed
      
        
        
            ubicacion ="espalda_ponchado";
                String ubicacionnombre ="espalda_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
                
    }//GEN-LAST:event_btnponchado5ActionPerformed

    private void btnponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado1ActionPerformed
    
        
        ubicacion ="pecho_izquierdo_ponchado";
                String ubicacionnombre ="pecho_izquierdo_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
    }//GEN-LAST:event_btnponchado1ActionPerformed

    private void btnponchado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado2ActionPerformed
   
        
            ubicacion ="pecho_derecho_ponchado";
                String ubicacionnombre ="pecho_derecho_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
                
    }//GEN-LAST:event_btnponchado2ActionPerformed

    private void btnponchado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado3ActionPerformed
    
        
         ubicacion ="manga_derecha_ponchado";
                String ubicacionnombre ="manga_derecha_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
                
    }//GEN-LAST:event_btnponchado3ActionPerformed

    private void btnponchado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado4ActionPerformed
      
        
        
           ubicacion ="manga_derecha_ponchado";
                String ubicacionnombre ="manga_derecha_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
                
                
    }//GEN-LAST:event_btnponchado4ActionPerformed

    private void btnpechoizquierdocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdocancelarActionPerformed
      
        
        
        
        
          fechaubicacion  = "pecho_izquierdo_fecha";
           ubicacion = "pecho_izquierdo_cantidad"; 
            
           nombrebordado =pechoizquierdonombre;
           cantidadaplicacion = aplicacionpechoizquierdo;  
           
           ubicacionprenda = "PECHO IZQUIERDO";
        
        
        
            String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
        
              
           
              
              
          determinaciondeladescripciondelbordado();
              
              
            
            if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
          
           
             agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar  ) ;   
             
           
            }
           
           
           
          else
          
          
          {
          
           
          agregarsurtidasalhistorialdepedidosoenviosyactualizarestatusCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
         
              
                  
          }
           
                
         
           insertarlacantidadylafechaenlaubicacionCancelar((String) ubicacion, (String) fechaubicacion); 
           actualizarestatusentregaordendebordado(); 
             sumapuntos();   
           
           
           
           
           
            datos();
           
           
           
           
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
            autorizacion.lbinterfaz.setText("camisacancelar1");
            autorizacion.lbnivel.setText("2");

        }
            
            
            
            
            
            
            
        }    
        
        
        
        
        
        
    }//GEN-LAST:event_btnpechoizquierdocancelarActionPerformed

    private void btnpechoderechocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechocancelarActionPerformed
      
        
        
           
           
           
        fechaubicacion = "pecho_derecho_fecha";
         ubicacion = "pecho_derecho_cantidad";
        nombrebordado = pechoderechonombre;
        cantidadaplicacion = aplicacionpechoderecho;
        
        ubicacionprenda = "PECHO DERECHO";
        
        
            String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
            
          determinaciondeladescripciondelbordado();
              
              
            
            if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
          
           
             agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar  ) ;   
             
           
            }
           
           
           
          else
          
          
          {
          
           
          agregarsurtidasalhistorialdepedidosoenviosyactualizarestatusCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
         
              
                  
          }
           
                
         
           insertarlacantidadylafechaenlaubicacionCancelar((String) ubicacion, (String) fechaubicacion); 
           actualizarestatusentregaordendebordado(); 
             sumapuntos();   
           
           
           
           
           
            datos();
           
           
           
           
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
            autorizacion.lbinterfaz.setText("camisacancelar1");
            autorizacion.lbnivel.setText("2");

        }
            
            

            
            
        }    
                
                
                
    }//GEN-LAST:event_btnpechoderechocancelarActionPerformed

    private void btnmangaizquierdacancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdacancelarActionPerformed
      
        
        
        fechaubicacion = "manga_izquierda_fecha";
        ubicacion = "manga_izquierda_cantidad";
        nombrebordado = mangaizquierdanombre;
            cantidadaplicacion = aplicacionmangaizquierda;
            
             ubicacionprenda = "MANGA IZQUIERDA";
        
        
          String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
          determinaciondeladescripciondelbordado();
              
              
            
            if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
          
           
             agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar  ) ;   
             
           
            }
           
           
           
          else
          
          
          {
          
           
          agregarsurtidasalhistorialdepedidosoenviosyactualizarestatusCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
         
              
                  
          }
           
                
         
           insertarlacantidadylafechaenlaubicacionCancelar((String) ubicacion, (String) fechaubicacion); 
           actualizarestatusentregaordendebordado(); 
             sumapuntos();   
           
           
           
           
           
            datos();
           
           
           
           
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
            autorizacion.lbinterfaz.setText("camisacancelar1");
            autorizacion.lbnivel.setText("2");

        }
            
            

        
        }    
      
            
            
    }//GEN-LAST:event_btnmangaizquierdacancelarActionPerformed

    private void btnmangaderechacancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechacancelarActionPerformed
      
        
        ubicacion = "manga_derecha_cantidad";
             fechaubicacion = "manga_derecha_fecha";
        nombrebordado = mangaderechanombre;
            cantidadaplicacion = aplicacionmangaderecha;
            
            ubicacionprenda = "MANGA DERECHA";    
        
        
        
          String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
        
          determinaciondeladescripciondelbordado();
              
              
            
            if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
          
           
             agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar  ) ;   
             
           
            }
           
           
           
          else
          
          
          {
          
           
          agregarsurtidasalhistorialdepedidosoenviosyactualizarestatusCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
         
              
                  
          }
           
                
         
           insertarlacantidadylafechaenlaubicacionCancelar((String) ubicacion, (String) fechaubicacion); 
           actualizarestatusentregaordendebordado(); 
             sumapuntos();   
           
           
           
           
           
            datos();
           
           
           
           
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
            autorizacion.lbinterfaz.setText("camisacancelar1");
            autorizacion.lbnivel.setText("2");

        }
            
            

    
             
        }    
         
               
    }//GEN-LAST:event_btnmangaderechacancelarActionPerformed

    private void btnespaldacancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldacancelarActionPerformed
      
        
        
        ubicacion = "espalda_cantidad";
          fechaubicacion = "espalda_fecha";
        nombrebordado =espaldanombre;
        cantidadaplicacion = aplicacionespalda;
        
         ubicacionprenda = "ESPALDA";
        
        String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
        
          determinaciondeladescripciondelbordado();
              
              
            
            if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
          
           
             agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar  ) ;   
             
           
            }
           
           
           
          else
          
          
          {
          
           
          agregarsurtidasalhistorialdepedidosoenviosyactualizarestatusCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
         
              
                  
          }
           
                
         
           insertarlacantidadylafechaenlaubicacionCancelar((String) ubicacion, (String) fechaubicacion); 
           actualizarestatusentregaordendebordado(); 
             sumapuntos();   
           
           
           
           
           
            datos();
           
           
           
           
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
            autorizacion.lbinterfaz.setText("camisacancelar1");
            autorizacion.lbnivel.setText("2");

        }
            
            

    
        }    
        
        
        
    }//GEN-LAST:event_btnespaldacancelarActionPerformed

    private void btnotraubicacioncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacioncancelarActionPerformed
       
        
        
        ubicacion = "otra_ubicacion_cantidad";
            fechaubicacion = "otra_ubicacion_fecha";
        nombrebordado = otraubicacionnombre;
            cantidadaplicacion = aplicacionotraubicacion;
            
            ubicacionprenda = "OTRA UBICACION";
        
        
                  String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
        
          determinaciondeladescripciondelbordado();
              
              
            
            if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
          
           
             agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar  ) ;   
             
           
            }
           
           
           
          else
          
          
          {
          
           
          agregarsurtidasalhistorialdepedidosoenviosyactualizarestatusCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
         
              
                  
          }
           
                
         
           insertarlacantidadylafechaenlaubicacionCancelar((String) ubicacion, (String) fechaubicacion); 
           actualizarestatusentregaordendebordado(); 
             sumapuntos();   
           
           
           
           
           
            datos();
           
           
           
           
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
            autorizacion.lbinterfaz.setText("camisacancelar1");
            autorizacion.lbnivel.setText("2");

        }
            
            

    
        }    
                
                
    }//GEN-LAST:event_btnotraubicacioncancelarActionPerformed

    private void btnotraubicacion2cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacion2cancelarActionPerformed
      
        
        
        ubicacion = "otra_ubicacion2_cantidad";
            fechaubicacion = "otra_ubicacion2_fecha";
            nombrebordado = otraubicacion2nombre;
            cantidadaplicacion = aplicacionotraubicacion2;
            
            ubicacionprenda = "OTRA UBICACION2";
            
        
            String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
        
          determinaciondeladescripciondelbordado();
              
              
            
            if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
          
           
             agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar  ) ;   
             
           
            }
           
           
           
          else
          
          
          {
          
           
          agregarsurtidasalhistorialdepedidosoenviosyactualizarestatusCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);  
         
              
                  
          }
           
                
         
           insertarlacantidadylafechaenlaubicacionCancelar((String) ubicacion, (String) fechaubicacion); 
           actualizarestatusentregaordendebordado(); 
             sumapuntos();   
           
           
           
           
           
            datos();
           
           
           
           
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
            autorizacion.lbinterfaz.setText("camisacancelar1");
            autorizacion.lbnivel.setText("2");

        }
            
            

    
        }    
                   
                   
                   
    }//GEN-LAST:event_btnotraubicacion2cancelarActionPerformed

    private void btnpechoizquierdotermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpechoizquierdotermineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
                
                
                
                
                
    }//GEN-LAST:event_btnpechoizquierdotermineMouseReleased

    private void btnpechoderechotermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpechoderechotermineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
                
                
                
    }//GEN-LAST:event_btnpechoderechotermineMouseReleased

    private void btnmangaizquierdatermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmangaizquierdatermineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
                
                
                
    }//GEN-LAST:event_btnmangaizquierdatermineMouseReleased

    private void btnmangaderechatetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmangaderechatetermineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
                
                
    }//GEN-LAST:event_btnmangaderechatetermineMouseReleased

    private void btnespaldatetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnespaldatetermineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
                
                
    }//GEN-LAST:event_btnespaldatetermineMouseReleased

    private void btnotraubicaciontetermineMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnotraubicaciontetermineMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnotraubicaciontetermineMousePressed

    private void btnotraubicaciontetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnotraubicaciontetermineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
                
                
    }//GEN-LAST:event_btnotraubicaciontetermineMouseReleased

    private void btnotraubicacion2tetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnotraubicacion2tetermineMouseReleased
               
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
                
                
                
    }//GEN-LAST:event_btnotraubicacion2tetermineMouseReleased

    private void btnpechoizquierdocancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpechoizquierdocancelarMouseReleased
            
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
               
                
                
                
    }//GEN-LAST:event_btnpechoizquierdocancelarMouseReleased

    private void btnpechoderechocancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnpechoderechocancelarMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
            
                
                
                
    }//GEN-LAST:event_btnpechoderechocancelarMouseReleased

    private void btnmangaizquierdacancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmangaizquierdacancelarMouseReleased
            
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
               
                
                
                
    }//GEN-LAST:event_btnmangaizquierdacancelarMouseReleased

    private void btnmangaderechacancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnmangaderechacancelarMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
               
                
                
    }//GEN-LAST:event_btnmangaderechacancelarMouseReleased

    private void btnespaldacancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnespaldacancelarMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
             
                
                
    }//GEN-LAST:event_btnespaldacancelarMouseReleased

    private void btnotraubicacioncancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnotraubicacioncancelarMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
               
    }//GEN-LAST:event_btnotraubicacioncancelarMouseReleased

    private void btnotraubicacion2cancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnotraubicacion2cancelarMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
               
                
                
                
    }//GEN-LAST:event_btnotraubicacion2cancelarMouseReleased

    private void btnreplicar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar7ActionPerformed
       
        
        
         ubicacionponchado= "otra_ubicacion2_ponchado";
        ubicacionponchadonombre = "otra_ubicacion2_ponchado_nombre";
                
        
          String nombrearchivo ="";
        
        FileInputStream input = null;


            
            if (ruta7 == null || ruta7.equals("")) 
            {

            } 
            
            else
            
            {
                try {
                    
                  
                     File archivo = new File(ruta7);
                     nombrearchivo =archivo.getName();
                     
                    input = new FileInputStream(new File(ruta7));
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchado+" =? where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
        
            
            
            
            
    }//GEN-LAST:event_btnreplicar7ActionPerformed

    private void btnreplicar6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar6ActionPerformed
        
        
        
         ubicacionponchado= "otra_ubicacion_ponchado";
        ubicacionponchadonombre = "otra_ubicacion_ponchado_nombre";
                
        
          String nombrearchivo ="";
        
        FileInputStream input = null;


            
            if (ruta6 == null || ruta6.equals("")) 
            {

            } 
            
            else
            
            {
                try {
                    
                  
                     File archivo = new File(ruta6);
                     nombrearchivo =archivo.getName();
                     
                    input = new FileInputStream(new File(ruta6));
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchado+" =? where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
        
            
            
            
            
    }//GEN-LAST:event_btnreplicar6ActionPerformed

    private void btnreplicar5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar5ActionPerformed
       
        
        
         ubicacionponchado= "espalda_ponchado";
        ubicacionponchadonombre = "espalda_ponchado_nombre";
                
        
          String nombrearchivo ="";
        
        FileInputStream input = null;


            
            if (ruta5 == null || ruta5.equals("")) 
            {

            } 
            
            else
            
            {
                try {
                    
                  
                     File archivo = new File(ruta5);
                     nombrearchivo =archivo.getName();
                     
                    input = new FileInputStream(new File(ruta5));
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchado+" =? where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
        
            
            
            
            
            
    }//GEN-LAST:event_btnreplicar5ActionPerformed

    private void btnreplicar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar1ActionPerformed
      
        
        ubicacionponchado= "pecho_izquierdo_ponchado";
        ubicacionponchadonombre = "pecho_izquierdo_ponchado_nombre";
                
        
          String nombrearchivo ="";
        
        FileInputStream input = null;


            
            if (ruta1 == null || ruta1.equals("")) 
            {

            } 
            
            else
            
            {
                try {
                    
                  
                     File archivo = new File(ruta1);
                     nombrearchivo =archivo.getName();
                     
                    input = new FileInputStream(new File(ruta1));
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchado+" =? where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
        
            
            
        
    }//GEN-LAST:event_btnreplicar1ActionPerformed

    private void btnreplicar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar2ActionPerformed
       
        
        ubicacionponchado= "pecho_derecho_ponchado";
        ubicacionponchadonombre = "pecho_derecho_ponchado_nombre";
                
        
          String nombrearchivo ="";
        
        FileInputStream input = null;


            
            if (ruta2 == null || ruta2.equals("")) 
            {

            } 
            
            else
            
            {
                try {
                    
                  
                     File archivo = new File(ruta2);
                     nombrearchivo =archivo.getName();
                     
                    input = new FileInputStream(new File(ruta2));
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchado+" =? where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
        
            
        
    }//GEN-LAST:event_btnreplicar2ActionPerformed

    private void btnreplicar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar3ActionPerformed
       
        
         ubicacionponchado= "manga_izquierda_ponchado";
        ubicacionponchadonombre = "manga_izquierda_ponchado_nombre";
                
        
          String nombrearchivo ="";
        
        FileInputStream input = null;


            
            if (ruta3 == null || ruta3.equals("")) 
            {

            } 
            
            else
            
            {
                try {
                    
                  
                     File archivo = new File(ruta3);
                     nombrearchivo =archivo.getName();
                     
                    input = new FileInputStream(new File(ruta3));
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchado+" =? where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
        
            
            
            
        
    }//GEN-LAST:event_btnreplicar3ActionPerformed

    private void btnreplicar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar4ActionPerformed
      
        
        
         ubicacionponchado= "manga_derecha_ponchado";
        ubicacionponchadonombre = "manga_derecha_ponchado_nombre";
                
        
          String nombrearchivo ="";
        
        FileInputStream input = null;


            
            if (ruta4 == null || ruta4.equals("")) 
            {

            } 
            
            else
            
            {
                try {
                    
                  
                     File archivo = new File(ruta4);
                     nombrearchivo =archivo.getName();
                     
                    input = new FileInputStream(new File(ruta4));
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchado+" =? where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_camisa_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
        
            
            
            
            
    }//GEN-LAST:event_btnreplicar4ActionPerformed

    private void btncargarponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado1ActionPerformed
      
        
        
        JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
   
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            ruta1 = archivoelegido.toString();
          
            
             btnreplicar1.setEnabled(true);
           btnquitarponchado1.setEnabled(true);
          
           btnreplicartodoslosponchados.setEnabled(true);
           
            btncargarponchado1.setEnabled(false);
        
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado agregado correctamente");
          
          
           
        
        }
    
    
    }//GEN-LAST:event_btncargarponchado1ActionPerformed

    private void btncargarponchado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado3ActionPerformed
           JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
   
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            ruta3 = archivoelegido.toString();
          
         btnreplicar3.setEnabled(true);
           btnquitarponchado3.setEnabled(true);
           btnreplicartodoslosponchados.setEnabled(true);
            btncargarponchado3.setEnabled(false);
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado agregado correctamente");
          
          
        
        }
    }//GEN-LAST:event_btncargarponchado3ActionPerformed

    private void btncargarponchado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado2ActionPerformed
           JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
   
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            ruta2 = archivoelegido.toString();
          
        
              btnreplicar2.setEnabled(true);
           btnquitarponchado2.setEnabled(true);
           btnreplicartodoslosponchados.setEnabled(true);
            btncargarponchado2.setEnabled(false);
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado agregado correctamente");
          
         
        
        }
    }//GEN-LAST:event_btncargarponchado2ActionPerformed

    private void btncargarponchado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado4ActionPerformed
           JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
   
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            ruta4 = archivoelegido.toString();
          
        
          btnreplicar4.setEnabled(true);
           btnquitarponchado4.setEnabled(true);
           btnreplicartodoslosponchados.setEnabled(true);
            btncargarponchado4.setEnabled(false);
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado agregado correctamente");
          
          
        
        }
    }//GEN-LAST:event_btncargarponchado4ActionPerformed

    private void btncargarponchado5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado5ActionPerformed
           JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
   
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            ruta5 = archivoelegido.toString();
          
        
              btnreplicar5.setEnabled(true);
           btnquitarponchado5.setEnabled(true);
           btnreplicartodoslosponchados.setEnabled(true);
            btncargarponchado5.setEnabled(false);
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado agregado correctamente");
          
         
        
        }
    }//GEN-LAST:event_btncargarponchado5ActionPerformed

    private void btncargarponchado6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado6ActionPerformed
            JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
   
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            ruta6 = archivoelegido.toString();
          
        
            btnreplicar6.setEnabled(true);
           btnquitarponchado6.setEnabled(true);
           btnreplicartodoslosponchados.setEnabled(true);
            btncargarponchado6.setEnabled(false);
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado agregado correctamente");
          
           
        
        }
    }//GEN-LAST:event_btncargarponchado6ActionPerformed

    private void btncargarponchado7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado7ActionPerformed
            JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
   
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            ruta7 = archivoelegido.toString();
          
        
            btnreplicar7.setEnabled(true);
           btnquitarponchado7.setEnabled(true);
           btnreplicartodoslosponchados.setEnabled(true);
            btncargarponchado7.setEnabled(false);
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado agregado correctamente");
          
           
        
        }
    }//GEN-LAST:event_btncargarponchado7ActionPerformed

    private void btnquitarponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado1ActionPerformed
       
        
        btncargarponchado1.setEnabled(true);
        btnreplicar1.setEnabled(false);
        
        btnquitarponchado1.setEnabled(false);
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
                
                
        
    }//GEN-LAST:event_btnquitarponchado1ActionPerformed

    private void btnquitarponchado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado2ActionPerformed
       
        
        btncargarponchado2.setEnabled(true);
        btnreplicar2.setEnabled(false);
         btnquitarponchado2.setEnabled(false);
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
        
        
    }//GEN-LAST:event_btnquitarponchado2ActionPerformed

    private void btnquitarponchado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado3ActionPerformed
     
        btncargarponchado3.setEnabled(true);
        btnreplicar3.setEnabled(false);
         btnquitarponchado3.setEnabled(false);
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
        
        
    }//GEN-LAST:event_btnquitarponchado3ActionPerformed

    private void btnquitarponchado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado4ActionPerformed
       
        btncargarponchado4.setEnabled(true);
        btnreplicar4.setEnabled(false);
         btnquitarponchado4.setEnabled(false);
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
        
        
    }//GEN-LAST:event_btnquitarponchado4ActionPerformed

    private void btnquitarponchado5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado5ActionPerformed
     
        btncargarponchado5.setEnabled(true);
        btnreplicar5.setEnabled(false);
         btnquitarponchado5.setEnabled(false);
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
        
        
    }//GEN-LAST:event_btnquitarponchado5ActionPerformed

    private void btnquitarponchado6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado6ActionPerformed
     
        btncargarponchado6.setEnabled(true);
        btnreplicar6.setEnabled(false);
         btnquitarponchado6.setEnabled(false);
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
        
        
    }//GEN-LAST:event_btnquitarponchado6ActionPerformed

    private void btnquitarponchado7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado7ActionPerformed
     
        btncargarponchado7.setEnabled(true);
        btnreplicar7.setEnabled(false);
         btnquitarponchado7.setEnabled(false);
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
        
        
    }//GEN-LAST:event_btnquitarponchado7ActionPerformed



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
            java.util.logging.Logger.getLogger(ordencamisaS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordencamisaS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordencamisaS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordencamisaS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordencamisaS().setVisible(true);
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
    public static javax.swing.JButton btndatos;
    private javax.swing.JButton btneditarbordado;
    public static javax.swing.JButton btnespaldacancelar;
    private javax.swing.JButton btnespaldatetermine;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    public static javax.swing.JButton btnmangaderechacancelar;
    private javax.swing.JButton btnmangaderechatetermine;
    public static javax.swing.JButton btnmangaizquierdacancelar;
    public static javax.swing.JButton btnmangaizquierdatermine;
    public static javax.swing.JButton btnotraubicacion2cancelar;
    private javax.swing.JButton btnotraubicacion2tetermine;
    public static javax.swing.JButton btnotraubicacioncancelar;
    private javax.swing.JButton btnotraubicaciontetermine;
    public static javax.swing.JButton btnpechoderechocancelar;
    public static javax.swing.JButton btnpechoderechotermine;
    public static javax.swing.JButton btnpechoizquierdocancelar;
    public static javax.swing.JButton btnpechoizquierdotermine;
    private javax.swing.JButton btnponchado1;
    private javax.swing.JButton btnponchado2;
    private javax.swing.JButton btnponchado3;
    private javax.swing.JButton btnponchado4;
    private javax.swing.JButton btnponchado5;
    private javax.swing.JButton btnponchado6;
    private javax.swing.JButton btnponchado7;
    private javax.swing.JButton btnquitarponchado1;
    private javax.swing.JButton btnquitarponchado2;
    private javax.swing.JButton btnquitarponchado3;
    private javax.swing.JButton btnquitarponchado4;
    private javax.swing.JButton btnquitarponchado5;
    private javax.swing.JButton btnquitarponchado6;
    private javax.swing.JButton btnquitarponchado7;
    private javax.swing.JButton btnreplicar1;
    private javax.swing.JButton btnreplicar2;
    private javax.swing.JButton btnreplicar3;
    private javax.swing.JButton btnreplicar4;
    private javax.swing.JButton btnreplicar5;
    private javax.swing.JButton btnreplicar6;
    private javax.swing.JButton btnreplicar7;
    private javax.swing.JButton btnreplicartodoslosponchados;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    public javax.swing.JLabel lbcolor1;
    public javax.swing.JLabel lbcolor2;
    public javax.swing.JLabel lbcolor3;
    public javax.swing.JLabel lbcolor4;
    public javax.swing.JLabel lbcolor5;
    public javax.swing.JLabel lbcolor6;
    public javax.swing.JLabel lbcolor7;
    public static javax.swing.JLabel lbdiaentrega;
    public javax.swing.JLabel lbespalda;
    public javax.swing.JLabel lbespaldanombre;
    public static javax.swing.JLabel lbespaldanombre1;
    public static javax.swing.JLabel lbestatus;
    public static javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbfotomontaje;
    public javax.swing.JLabel lbhilo1;
    public javax.swing.JLabel lbhilo2;
    public javax.swing.JLabel lbhilo3;
    public javax.swing.JLabel lbhilo4;
    public javax.swing.JLabel lbhilo5;
    public javax.swing.JLabel lbhilo6;
    public javax.swing.JLabel lbhilo7;
    public static javax.swing.JLabel lbhoraentrega;
    private javax.swing.JLabel lbidentificador;
    private javax.swing.JLabel lbltallas;
    public javax.swing.JLabel lbmangaderecha;
    public javax.swing.JLabel lbmangaderechanombre;
    public static javax.swing.JLabel lbmangaderechanombre1;
    public javax.swing.JLabel lbmangaizquierda;
    public javax.swing.JLabel lbmangaizquierdanombre;
    public static javax.swing.JLabel lbmangaizquierdanombre1;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumerodeventa;
    public static javax.swing.JLabel lbnumeroordenbordadodelaotrasucursal;
    public static javax.swing.JLabel lbnumeroordenopedidorecibido;
    public static javax.swing.JLabel lbnumeroordenopedidosolicitado;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    public static javax.swing.JLabel lbordenopedidorecibido;
    public javax.swing.JLabel lbotraubicacion;
    public javax.swing.JLabel lbotraubicacion2;
    public javax.swing.JLabel lbotraubicacion2nombre;
    public static javax.swing.JLabel lbotraubicacion2nombre1;
    public javax.swing.JLabel lbotraubicacionnombre;
    public static javax.swing.JLabel lbotraubicacionnombre1;
    public javax.swing.JLabel lbpechoderecho;
    public javax.swing.JLabel lbpechoderechonombre;
    public static javax.swing.JLabel lbpechoderechonombre1;
    public javax.swing.JLabel lbpechoizquierdo;
    public javax.swing.JLabel lbpechoizquierdonombre;
    public static javax.swing.JLabel lbpechoizquierdonombre1;
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
    // End of variables declaration//GEN-END:variables

    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();

}
