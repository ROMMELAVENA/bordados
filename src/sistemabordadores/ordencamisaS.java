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
    Connection cnsucursal = null;
    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;

    String nuevosbordadosutilizadosstring = "";
    int nuevosbordadosutilizadosint = 0;

    String primero = "";
    String ultimo = "";
    String nombrebordado = "";
    int traspaso = 0;
    String ipsucursal = "";
    
    String numeroordendeenviosolicitada = "";
   
    String numerosucursal = "";
    String sucursal = "";
    String numerosolicitoarticulos = "";
    String tiendasolicitoarticulos = "";

    String numeroordenenvio = "";
    String tiendaordenenvio = "";
    String tiendalocal = "";
    String iplocal = principal.lbiplocal.getText();
    String codigocliente = "";
    String lugar = "";
    String prenda ="";
    
    String numerodeorden = "";
    
    ///// para insertar
    
    String descripcion = ""; 
    String aplicacioninsertar = "";
    
    
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
    
    
    ArrayList<String> listabotones = new ArrayList<String>();
    ArrayList<String> listahilos = new ArrayList<String>();
    
     
     String consecutivobordado = "";

    String tiendaconectada = "";
    
    
    
    public static final Color anaranjado = new Color(255,166,77);
    
    
    

    public ordencamisaS() 
    {
        initComponents();
        ventanaordencamisa = true;

        lbtipo.setVisible(false);

        btnterminetodo.setEnabled(false);
        btndatos.setVisible(false);
        
        
        btnpechoizquierdocancelar.setEnabled(false);
        btnpechoderechocancelar.setEnabled(false);
        btnmangaizquierdacancelar.setEnabled(false);
        btnmangaderechacancelar.setEnabled(false);
        btnespaldacancelar.setEnabled(false);
        btnotraubicacioncancelar.setEnabled(false);
        btnotraubicacion2cancelar.setEnabled(false);
        
     
        
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
        
        
        
        String sql = "SELECT color1,color2,color3,color4,color5,color6,color7,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7 FROM bordados_puntadas where identificador_prenda = '"+lbidentificador.getText()+"' AND nombre = '"+lbcliente.getText()+"' ";


            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                    
                            
                        String color1 = rs.getString("color1");
                        String color2 = rs.getString("color2");
                        String color3 = rs.getString("color3");
                        String color4 = rs.getString("color4");
                        String color5 = rs.getString("color5");
                        String color6 = rs.getString("color6");
                        String color7 = rs.getString("color7");
                        
                        String hilo1 = rs.getString("hilo1");
                        String hilo2 = rs.getString("hilo2");
                        String hilo3 = rs.getString("hilo3");
                        String hilo4 = rs.getString("hilo4");
                        String hilo5 = rs.getString("hilo5");
                        String hilo6 = rs.getString("hilo6");
                        String hilo7 = rs.getString("hilo7");
                        
                        
                        if (color1.equals("ninguno") || color1.equals("0")){}else{lbcolor1.setText(color1);}
                        if (color2.equals("ninguno") || color2.equals("0")){}else{lbcolor2.setText(color2);}
                        if (color3.equals("ninguno") || color3.equals("0")){}else{lbcolor3.setText(color3);}
                        if (color4.equals("ninguno") || color4.equals("0")){}else{lbcolor4.setText(color4);}
                        if (color5.equals("ninguno") || color5.equals("0")){}else{lbcolor5.setText(color5);}
                        if (color6.equals("ninguno") || color6.equals("0")){}else{lbcolor6.setText(color6);}
                        if (color7.equals("ninguno") || color7.equals("0")){}else{lbcolor7.setText(color7);}
                       
                       
                        
                        
                        if (hilo1.equals("ninguno") || hilo1.equals("0")){}else{lbhilo1.setText(color1);}
                         if (hilo2.equals("ninguno") || hilo2.equals("0")){}else{lbhilo2.setText(color2);}
                          if (hilo3.equals("ninguno") || hilo3.equals("0")){}else{lbhilo3.setText(color3);}
                           if (hilo4.equals("ninguno") || hilo4.equals("0")){}else{lbhilo4.setText(color4);}
                            if (hilo5.equals("ninguno") || hilo5.equals("0")){}else{lbhilo5.setText(color5);}
                             if (hilo6.equals("ninguno") || hilo6.equals("0")){}else{lbhilo6.setText(color6);}
                              if (hilo7.equals("ninguno") || hilo7.equals("0")){}else{lbhilo7.setText(color7);}
                     
                    
                    
                        
                        
                         
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
    
     
     
     
     
     
     
     
     
     
     
     
    
    void datostiendalocal() throws IOException {

        
        
        numerodeorden = lborden.getText();

        String botonhabilitado1 = "si";
        String botonhabilitado2 = "si";
        String botonhabilitado3 = "si";
        String botonhabilitado4 = "si";
        String botonhabilitado5 = "si";
        String botonhabilitado6 = "si";
        String botonhabilitado7 = "si";
        
        

        String sql = "Select fecha,hora,cliente,nombre_comercial,borda_cliente,numero_venta,numero_orden,cantidad,cantidad,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,"
                + "   pecho_izquierdo,pecho_derecho,manga_izquierda,manga_derecha,espalda,otra_ubicacion,otra_ubicacion2,"
                + "   cantidad_pecho_izquierdo,cantidad_pecho_derecho,cantidad_manga_izquierda,cantidad_manga_derecha,cantidad_espalda,"
                + "   pecho_izquierdo_nombre,pecho_derecho_nombre,manga_izquierda_nombre,manga_derecha_nombre,espalda_nombre,"
                + "   otra_ubicacion,otra_ubicacion_nombre,cantidad_otra_ubicacion,otra_ubicacion2,otra_ubicacion2_nombre,cantidad_otra_ubicacion2,"
                + "   aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2,"
                + "   aplicacion_pecho_izquierdo_color,aplicacion_pecho_derecho_color,aplicacion_manga_izquierda_color,aplicacion_manga_derecha_color,aplicacion_espalda_color,aplicacion_otra_ubicacion_color,aplicacion_otra_ubicacion2_color,"
                + "   lugar,estatus_orden,identificador_prenda,tienda,tienda from historial_ordenes_camisa where numero = '" + numerodeorden + "' ";

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
              
                  String pechoizquierdo = rs.getString("pecho_izquierdo");
                  
               
                  
                if (pechoizquierdo == null || pechoizquierdo.equals("") || pechoizquierdo.equals("ninguno")) {

                    btnpechoizquierdotermine.setEnabled(false);
                    botonhabilitado1 = "no";
                    
                    btnpechoizquierdoponchado.setEnabled(false);
                 
                    
                }
                 else
                {
                    
                    lbpechoizquierdo.setText(pechoizquierdo);
                     btnterminetodo.setEnabled(true);
                 
                     
                     
                     
                }
                
                
                
                
                
                
                
                
                 pechoderechonombre = rs.getString("pecho_derecho_nombre");
                 lbpechoderechonombre.setText(pechoderechonombre);
                
                String pechoderecho = rs.getString("pecho_derecho");
                
              
                if (pechoderecho == null || pechoderecho.equals("")  || pechoderecho.equals("ninguno")) {

                    btnpechoderechotermine.setEnabled(false);
                    botonhabilitado2 = "no";
                    
                     btnpechoderechoponchado.setEnabled(false);
                  

                }
                 else
                {
                    
                    lbpechoderecho.setText(pechoderecho);
                     btnterminetodo.setEnabled(true);
                     
                }
                
                
                
                

              
                
                  mangaizquierdanombre = rs.getString("manga_izquierda_nombre");
                  lbmangaizquierdanombre.setText(mangaizquierdanombre);
                  
                  String mangaizquierda = rs.getString("manga_izquierda");
                  
             
                if (mangaizquierda == null || mangaizquierda.equals("") || mangaizquierda.equals("ninguno")) {

                    btnmangaizquierdatermine.setEnabled(false);
                    botonhabilitado3 = "no";
                    
                    btnmangaizquierdaponchado.setEnabled(false);
                  

                }
                 else
                {
                    
                    lbmangaizquierda.setText(mangaizquierda);
                     btnterminetodo.setEnabled(true);
                   
                     
                }
                
                
                
                
                
                
                
                
                mangaderechanombre = rs.getString("manga_derecha_nombre");
                lbmangaderechanombre.setText(mangaderechanombre);
                
                String mangaderecha = rs.getString("manga_derecha");
               
               
                if (mangaderecha == null || mangaderecha.equals("")   || mangaderecha.equals("ninguno")) 
                {

                    btnmangaderechatetermine.setEnabled(false);
                    botonhabilitado4 = "no";
                    
                    btnmangaderechaponchado.setEnabled(false);
                   

                }
                 else
                {
                    
                     lbmangaderecha.setText(mangaderecha);
                     btnterminetodo.setEnabled(true);
                    
                }

              
                
                
                

                espaldanombre = rs.getString("espalda_nombre");
                lbespaldanombre.setText(espaldanombre);
                
                String espalda = rs.getString("espalda");
                
               
                if (espalda == null || espalda.equals("")  || espalda.equals("ninguno")) {

                    btnespaldatetermine.setEnabled(false);
                    botonhabilitado5 = "no";
                    
                    btnespaldaponchado.setEnabled(false);
                  
                   
                }
                 else
                {
                    
                    lbespalda.setText(espalda);
                     btnterminetodo.setEnabled(true);
                   
                }
                

                
                

                otraubicacionnombre = rs.getString("otra_ubicacion_nombre");
                lbotraubicacionnombre.setText(otraubicacionnombre);
                
                String otraubicacion = rs.getString("otra_ubicacion");
               
             
                if (otraubicacion == null || otraubicacion.equals("")  || otraubicacion.equals("ninguno")) {

                    btnotraubicaciontetermine.setEnabled(false);
                    botonhabilitado6 = "no";
                    
                    btnotraubicacionponchado.setEnabled(false);
                  

                }
                 else
                {
                    
                     lbotraubicacion.setText(otraubicacion);
                     btnterminetodo.setEnabled(true);
                 
                }

                
                
                
                
                
                
                otraubicacion2nombre = rs.getString("otra_ubicacion2_nombre");
                lbotraubicacion2nombre.setText(otraubicacion2nombre);
                
                String otraubicacion2 = rs.getString("otra_ubicacion2");
               
              
                if (otraubicacion2 == null || otraubicacion2.equals("")   || otraubicacion2.equals("ninguno")) {

                    btnotraubicacion2tetermine.setEnabled(false);
                    botonhabilitado7 = "no";
                    
                     btnotraubicacion2ponchado.setEnabled(false);
                   
                    

                }
                else
                {
                    
                     lbotraubicacion2.setText(otraubicacion2);
                     btnterminetodo.setEnabled(true);
                   
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
                
                
                cantidadpechoizquierdo =rs.getString("cantidad_pecho_izquierdo");
                cantidadpechoderecho =rs.getString("cantidad_pecho_derecho");         
                cantidadmangaizquierda =rs.getString("cantidad_manga_izquierda"); 
                cantidadmangaderecha =rs.getString("cantidad_manga_derecha");
                cantidadespalda =rs.getString("cantidad_espalda");
                cantidadotraubicacion =rs.getString("cantidad_otra_ubicacion");
                cantidadotraubicacion2 =rs.getString("cantidad_otra_ubicacion2");
                
                
                if(lugar.equals("Esta sucursal"))
                {
                
                    
                    btninsertarponchados.setEnabled(false);
                    lblugar.setEnabled(false);
                
                    
                    
                    
                    
                    
                      
                    
                
                    
                    
                    
                    
                
                //// pecho izquierdo    
                    
                if(cantidadpechoizquierdo.equals("0") && botonhabilitado1.equals("si") )
                {
                   btnpechoizquierdotermine.setEnabled(true);
       
                   if(botonhabilitado1.equals("si"))
                   {
                   listabotones.add("btnpechoizquierdo");
                   
                   
                     lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
                      
                   
                   
                   }
                  
                }
                else
                {
                    
                     if(botonhabilitado1.equals("si"))
                   {
                     btnpechoizquierdocancelar.setEnabled(true);
                   btnpechoizquierdotermine.setEnabled(true);  //  ROMMEL PONERLE FALSE 
                   
                   
                     lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());
                   
                   
                   
                     
                   }
                     
                  
                
                } 
                
               
                //// pecho derecho
                
                if(cantidadpechoderecho.equals("0")  && botonhabilitado2.equals("si") )
                {
                   btnpechoderechotermine.setEnabled(true);
            
                   if(botonhabilitado2.equals("si"))
                   {
                   listabotones.add("btnpechoderecho");
                   
                   
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                   
                         
                  
                   
                   
                   
                   
                   
                   
                   
                   }
                  
                }
                else
                {
                    
                     if(botonhabilitado2.equals("si"))
                   {
                    btnpechoderechocancelar.setEnabled(true);
                       btnpechoderechotermine.setEnabled(true);    //  ROMMEL PONERLE FALSE
                       
                         lbcantidad2.setText(cantidad);
                   lbcantidad2.setForeground(Color.GREEN.darker());
                    
                   }
                  
               
                } 
                
                
                if(cantidadmangaizquierda.equals("0")  && botonhabilitado3.equals("si") )
                {
                   btnmangaizquierdatermine.setEnabled(true);
            
                   if(botonhabilitado3.equals("si"))
                   {
                   listabotones.add("btnmangaizquierda");
                   
                    lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                   
                
                   
                   }
                  
                }
                else
                {
                    
                   if(botonhabilitado3.equals("si"))
                   {
                  btnmangaizquierdacancelar.setEnabled(true);
                       btnmangaizquierdatermine.setEnabled(true);   //  ROMMEL PONERLE FALSE 
                       
                        lbcantidad3.setText(cantidad);
                   lbcantidad3.setForeground(Color.GREEN.darker());
                   
                   }
                  
                } 
                
                
                
                    
                if(cantidadmangaderecha.equals("0")  && botonhabilitado4.equals("si") )
                {
                   btnmangaderechatetermine.setEnabled(true);
         
                    if(botonhabilitado4.equals("si"))
                   {
                   listabotones.add("btnmangaderecha");
                   
                    lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                    
                   
                  
                   
                             
                             
                             
                   }
                   
                   
                   
                }
                else
                {
                    
                     if(botonhabilitado4.equals("si"))
                   {
                 btnmangaderechacancelar.setEnabled(true);
                 btnmangaderechatetermine.setEnabled(true);   //  ROMMEL PONERLE FALSE 
                 
                 
                  lbcantidad4.setText(cantidad);
                   lbcantidad4.setForeground(Color.GREEN.darker());
              
                    
                   }
                 
                } 
                
                
                
                
                
                
                
                
                
                
                
                if(cantidadespalda.equals("0")  && botonhabilitado5.equals("si") )
                {
                   btnespaldatetermine.setEnabled(true);
            
                   if(botonhabilitado5.equals("si"))
                   {
                   listabotones.add("btnespalda");
                   
                   lbcantidad5.setText("0");
                    lbcantidad5.setForeground(Color.red.darker());
                   
                          
                   }
                  
                   
                }
                else
                {
                    
                   if(botonhabilitado5.equals("si"))
                   {
                   btnespaldacancelar.setEnabled(true);
                   btnespaldatetermine.setEnabled(true);   //  ROMMEL PONERLE FALSE 
                   
                   
                    lbcantidad5.setText(cantidad);
                   lbcantidad5.setForeground(Color.GREEN.darker());
                  
                   }
                    
                    
                    
                } 
                
                
                if(cantidadotraubicacion.equals("0")  && botonhabilitado6.equals("si") )
                {
                   btnotraubicaciontetermine.setEnabled(true);
              
                   if(botonhabilitado6.equals("si"))
                   {
                   listabotones.add("btnotraubicacion");
                   
                   
                   lbcantidad6.setText("0");
                    lbcantidad6.setForeground(Color.red.darker());
                       
                           
                   }
                   
                   
                }
                else
                {
                    
                    if(botonhabilitado6.equals("si"))
                   {
                   btnotraubicacioncancelar.setEnabled(true);
                   btnotraubicaciontetermine.setEnabled(true);   //  ROMMEL PONERLE FALSE 
                   
                   
                     lbcantidad6.setText(cantidad);
                   lbcantidad6.setForeground(Color.GREEN.darker());
                  
                   }
                  
                } 
                
                if(cantidadotraubicacion2.equals("0")  && botonhabilitado7.equals("si") )
                {
                   btnotraubicacion2tetermine.setEnabled(true);
           
                   if(botonhabilitado7.equals("si"))
                   {
                       listabotones.add("btnotraubicacion2");
                       
                      
                         lbcantidad7.setText("0");
                    lbcantidad7.setForeground(Color.red.darker());
                       
                            
                               
                   }
                  
                   
                }
                else
                {
                    
                     if(botonhabilitado7.equals("si"))
                   {
                 btnotraubicacion2cancelar.setEnabled(true);
                 btnotraubicacion2tetermine.setEnabled(true);   //  ROMMEL PONERLE FALSE 
                 
                 
                  lbcantidad7.setText(cantidad);
                   lbcantidad7.setForeground(Color.GREEN.darker());
                 
                   }
                  
                } 
                
                
                
                }
                else
                {
                    
                    btninsertarponchados.setEnabled(true);
                    lblugar.setEnabled(true);
                    
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
                 
                 
                 
        datostienda();
        
        
       
        
        
        
        

    }
    
    void datosotrasucursal() throws IOException {
        
        
       
        
        String botonhabilitado1 = "";
        String botonhabilitado2 = "";
        String botonhabilitado3 = "";
        String botonhabilitado4 = "";
        String botonhabilitado5 = "";
        String botonhabilitado6 = "";
        String botonhabilitado7 = "";
      

        numerodeorden = lborden.getText();
        
        String sql = "Select fecha,hora,cliente,nombre_comercial,borda_cliente,cantidad,cantidad,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,fecha_entrega,hora_entrega,observacion,\n"
                + "pecho_izquierdo,pecho_derecho,manga_izquierda,manga_derecha,espalda,otra_ubicacion,otra_ubicacion2,\n"
                + "cantidad_pecho_izquierdo,cantidad_pecho_derecho,cantidad_manga_izquierda,cantidad_manga_derecha,cantidad_espalda,\n"
                + "pecho_izquierdo_nombre,pecho_derecho_nombre,manga_izquierda_nombre,manga_derecha_nombre,espalda_nombre,\n"
                + "otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion2,otra_ubicacion2_nombre,\n"
                + "aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2,\n"
                + "aplicacion_pecho_izquierdo_color,aplicacion_pecho_derecho_color,aplicacion_manga_izquierda_color,aplicacion_manga_derecha_color,aplicacion_espalda_color,aplicacion_otra_ubicacion_color,aplicacion_otra_ubicacion2_color,\n"
                + "lugar,estatus_orden,numero_sucursal_orden,tienda,numero_sucursal,identificador_prenda\n"
                + "from historial_ordenes_camisa_recibidas where numero = '" + numerodeorden + "' and prenda = '" + prenda + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

               
                cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
                lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                lbbordacliente.setText(rs.getString("borda_cliente"));
                lbprenda.setText(rs.getString("prenda"));
                prenda = (rs.getString("prenda"));
                lbfecha.setText(rs.getString("fecha"));
                lbnumerodelaotrasucursal.setText(rs.getString("numero_sucursal_orden"));
                numerosucursal = rs.getString("numero_sucursal");
                
                sucursal = rs.getString("tienda");
                lbsucursal.setText(sucursal);
            
                
                
                
                
                
                
                
                
                
                pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre");
                Object pechoizquierdo = rs.getString("pecho_izquierdo");
          
                lbpechoizquierdo.setText(rs.getString("pecho_izquierdo"));
                if (pechoizquierdo == null || pechoizquierdo.equals("") || pechoizquierdo.equals("ninguno")) {

                    btnpechoizquierdotermine.setVisible(false);
                    

                }
                else
                {
                    botonhabilitado4 = "si";
                    lbpechoizquierdonombre.setText(pechoizquierdonombre);
                } 
                
                
                
                
                
                
                
                
                
                pechoderechonombre = rs.getString("pecho_derecho_nombre");
                Object pechoderecho = rs.getString("pecho_derecho");
            
                lbpechoderecho.setText(rs.getString("pecho_derecho"));
                if (pechoderecho == null || pechoderecho.equals("") || pechoderecho.equals("ninguno")) {

                    btnpechoderechotermine.setVisible(false);
                     

                }
                else
                {
                    botonhabilitado3 = "si";
                    lbpechoderechonombre.setText(pechoderechonombre);
                } 
                
                
                
                
                
                
                
                
                
                
                 
                String mangaizquierda = rs.getString("manga_izquierda");
      
                lbmangaizquierda.setText(rs.getString("manga_izquierda"));
                
                if (mangaizquierda == null || mangaizquierda.equals("") || mangaizquierda.equals("ninguno")) {

                    btnmangaizquierdatermine.setVisible(false); 
                

                }
                else
                {
                    
                   lbmangaizquierdanombre.setText(mangaizquierdanombre);
                    botonhabilitado2 = "si";
                } 

                
                
                
                
                
                
                
                
                
                mangaderechanombre = rs.getString("manga_derecha_nombre");
                Object mangaderecha = rs.getString("manga_derecha");
         
                lbmangaderecha.setText(rs.getString("manga_derecha"));
                if (mangaderecha == null || mangaderecha.equals("") || mangaderecha.equals("ninguno"))
                
                {

                    btnmangaderechatetermine.setVisible(false);
                     


                }
                else
                {
                    lbmangaderechanombre.setText(mangaderechanombre);
                    botonhabilitado1 = "si";
                }   

                
                
                
                
                
                
                
                
                
                
                
               


                espaldanombre = rs.getString("espalda_nombre");
                Object espalda = rs.getString("espalda");
          
                lbespalda.setText(rs.getString("espalda"));
                if (espalda == null || espalda.equals("")) {

                    btnespaldatetermine.setVisible(false);
                 

                }
                else
                {
                    botonhabilitado5 = "si";
                    lbespaldanombre.setText(espaldanombre);
                } 

                
                
                
                
                
                
                
                
                
                otraubicacionnombre = rs.getString("otra_ubicacion_nombre");
                Object otraubicacion = rs.getString("otra_ubicacion");
         
                lbotraubicacion.setText(rs.getString("otra_ubicacion"));
                if (otraubicacion == null || otraubicacion.equals("") || otraubicacion.equals("ninguno")) {

                    btnotraubicaciontetermine.setVisible(false);
                    

                }
                else
                {
                    botonhabilitado6 = "si";
                    lbotraubicacionnombre.setText(otraubicacionnombre);
                            
                } 

                
                
                
                
                
                
                otraubicacion2nombre = rs.getString("otra_ubicacion2_nombre");
                Object otraubicacion2 = rs.getString("otra_ubicacion2");
                
               
                lbotraubicacion2.setText(rs.getString("otra_ubicacion2"));
                if (otraubicacion2 == null || otraubicacion2.equals("") || otraubicacion2.equals("ninguno")) 
                {

                    btnotraubicacion2tetermine.setVisible(false);
                   
                }
                else
                {
                    botonhabilitado7 = "si";
                    lbotraubicacion2nombre.setText(otraubicacion2nombre);
                    
                    
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

                String cantidadpechoizquiedo = rs.getString("cantidad_pecho_izquierdo");
                String cantidadpechoderecho = rs.getString("cantidad_pecho_derecho");
                String cantidadmangaizquierda = rs.getString("cantidad_manga_izquierda");
                String cantidadmangaderecha = rs.getString("cantidad_manga_derecha");
                String cantidadespalda = rs.getString("cantidad_espalda");

              

                    btninsertarponchados.setEnabled(false);
                    lblugar.setEnabled(false);

                    
                    
                    
                    
                    
                    if(cantidadpechoizquiedo.equals("0") && botonhabilitado4.equals("si") )
                {
                   btnpechoizquierdotermine.setEnabled(true);
                   btnpechoizquierdoponchado.setEnabled(true);
                  
                   if(botonhabilitado4.equals("si"))
                   {
                   listabotones.add("btnpechoizquierdo");
                   btnterminetodo.setEnabled(true);
                   }
                   
                }
                else
                {
                    btnpechoizquierdotermine.setEnabled(false);
                    btnpechoizquierdoponchado.setEnabled(false);
                   
                } 
                
               
                
                if(cantidadpechoderecho.equals("0")  && botonhabilitado3.equals("si") )
                {
                    
                   btnpechoderechotermine.setEnabled(true);
                   btnpechoderechoponchado.setEnabled(true);
                           
                           
                   if(botonhabilitado3.equals("si"))
                   {
                   listabotones.add("btnpechoderecho");
                   btnterminetodo.setEnabled(true);
                   
                   
                   }
                  
                }
                else
                {
                    btnpechoderechotermine.setEnabled(false);
                    btnpechoderechoponchado.setEnabled(false);
                   
                } 
                
                
                if(cantidadmangaizquierda.equals("0")  && botonhabilitado2.equals("si") )
                {
                    
                   btnmangaizquierdatermine.setEnabled(true);
                   btnmangaizquierdaponchado.setEnabled(true);
                   
                   
                   if(botonhabilitado2.equals("si"))
                   {
                   listabotones.add("btnmangaizquierda");
                   btnterminetodo.setEnabled(true);
                   }
                  
                }
                else
                {
                    btnmangaizquierdatermine.setEnabled(false);
                    btnmangaizquierdaponchado.setEnabled(false);
                   
                } 
                    
                if(cantidadmangaderecha.equals("0")  && botonhabilitado1.equals("si") )
                {
                   btnmangaderechatetermine.setEnabled(true);
                   btnmangaderechaponchado.setEnabled(true);
                           
                           
                    if(botonhabilitado1.equals("si"))
                   {
                   listabotones.add("btnmangaderecha");
                   btnterminetodo.setEnabled(true);
                   }
                   
                   
                   
                }
                else
                {
                    btnmangaderechatetermine.setEnabled(false);
                    btnmangaderechaponchado.setEnabled(false);
                    
                } 
                
                
                if(cantidadespalda.equals("0")  && botonhabilitado5.equals("si") )
                {
                   btnespaldatetermine.setEnabled(true);
                   btnespaldaponchado.setEnabled(true);
                           
                   if(botonhabilitado5.equals("si"))
                   {
                   listabotones.add("btnespalda");
                   btnterminetodo.setEnabled(true);
                   }
                 
                   
                }
                else
                {
                    btnespaldatetermine.setEnabled(false);
                    btnespaldaponchado.setEnabled(false);
                    
                } 
                
                
                
                btnotraubicacionponchado.setEnabled(false);
                btnotraubicacion2ponchado.setEnabled(false);
                
                
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

        
        
        
        
        
        String cliente = lbcliente.getText();
        
        
        
        
        
          numerodeorden = lborden.getText();
      
          
      
 
                tiendaconectada();   
             
            
                
              if (tiendaconectada.equals("si"))

                      {
      
                          
                        
                
                 try {
         
               
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
    
    
 void tiendaconectada()
 {
     
     
     
     sucursal = lbsucursal.getText();
     
     
      try {
          
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + iplocal + "/tiendas", "root", "sistemas");
             
              try {   
                
                String sql = "SELECT ip FROM catalogo_tiendas where tienda = '" + sucursal + "'";

                Statement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {

                    ipsucursal = rs.getString("ip");
              

                } else {

                }

                st.close();
            } catch (SQLException ex) {
                
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al buscar tiendas");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ingresotienda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ingresotienda.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        InetAddress ping;

        if (sucursal == null || sucursal.equals("Seleccione Tienda")) 
        {
            
              JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al conectar con tienda");
            
            
        }
        else 
        {

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
        
        
        
        
        
           if (tiendaconectada.equals("si"))
          
                
            {       
            
               try { 
                     
                     
                     
            cnsucursal = DriverManager.getConnection("jdbc:mysql://" + ipsucursal + "/" + sucursal + "", "root", "sistemas");
        } catch (SQLException ex) {
            Logger.getLogger(ordenparcheS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
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
            
             btnpechoizquierdoponchado.setEnabled(false);
        btnpechoderechoponchado.setEnabled(false);
        btnmangaizquierdaponchado.setEnabled(false);
        btnmangaderechaponchado.setEnabled(false);
        btnespaldaponchado.setEnabled(false);        
        btnotraubicacionponchado.setEnabled(false);        
        btnotraubicacion2ponchado.setEnabled(false);      
            
            
            
            
         
            
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
   
       
        String sql = "SELECT imagen,extension_imagen FROM bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";  ///
    
    
            
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
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void datostienda() 
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
                    
                    
                    lblugar.setText(tiendasolicitoarticulos);
                    lbnumerodelaotrasucursal.setText(numerosolicitoarticulos);
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
                
                
                lblugar.setText(tiendaordenenvio);
                lbnumerodelaotrasucursal.setText(numeroordenenvio);

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

                        lblugar.setText(tiendasolicitoarticulos);
                        lbnumerodelaotrasucursal.setText(numerosolicitoarticulos);
                    }
                    else
                    {
                        
                    }
                    
                    
                } catch (Exception exx) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

                }

            } else {
                lblugar.setText(tiendaordenenvio);
               
                lbnumerodelaotrasucursal.setText(numeroordenenvio);
            }

            
        }

    }
    
    
    void eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion(String ubicacion, String fecha){
    
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa set "+ubicacion+"='0' where numero = '"+lborden.getText()+"'");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");

                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        
        if(terminetodo.equals("si"))
        {
            
        }
        else
        {    
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" cancelada correctamente ");
        }
        
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    void insertarlacantidadylafechaenlaubicacion(String ubicacion, String fechaubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa set "+ubicacion+"='" + cantidad + "',"+fechaubicacion+"  =  '"+dia()+"' where numero = '"+lborden.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        
        if(terminetodo.equals("si"))
        {
            
        }
        else
        {    
     //   JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        }
        
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    
    
    void insertarlacantidadylafechaenlaubicacionotrasucursal(String ubicacion)
    {
        
        
    
        
        try {
        
         
            

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacion+"='" + cantidad + "',fecha = '"+dia()+"',"+fechaubicacion+" = '"+dia()+"'  where numero = '"+lborden.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();
                    
                    
                     String ubicacionsinguiones = ubicacion;
                         ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
                    
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");

                } catch (Exception ex) {
                    
                    
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                     JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al actualizar al actualizar las cantidades en el historial de ordenes de camisa recibidas ");
                    
                }
        
        
       
        
        
        
        
        try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
    
    void agregaralsurtidasalhistorialdeventasyactualizarestatusentrega(String ubicacion, String cantidad) 
      {

        String numeroventa =  lbnumerodeventa.getText();
        String surtidaactualstring ="";
        int surtidaactualint =  0;
        String nuevasurtidastring = "";
        String estatusentrega ="";
        String estatusentregaventa = "";
        
        String SQL2 = "select articulo,surtida,estatus_entrega from historial_ventas where numero = '" + numeroventa + "' and articulo = '" + ubicacion + "' ";
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
            
        
        
        
        
        
        
        
        
        
        // AQUI LO VAS A MODIFICAR ROMMEL, QUE ENTRE CUANDO SEA ORDEN DE ENVIO, NO CUANDO ESTE SURTIDA Y ENTREGADA TOTALMENTE
        if(estatusentregaventa.equals("surtida totalmente entregada totalmente") )
        {
            
            
            
         if(sucursal.equals(tiendalocal) && !numeroordendeenviosolicitada.equals("0"))    
         
                 {
                     
          
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET surtida = '" + nuevasurtidastring + "' WHERE numero_sucursal ='" + numeroordendeenviosolicitada + "' and articulo = '" + ubicacion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       

        ////Actualiza el estatus

      String cantidadsurtida = "";  
      String cantidadvendida = "";  
      String cantidadentregada = "";  
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(enviadas) as enviadas from historial_ordenes_envio_recibidas where numero = '"+numeroordendeenviosolicitada+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        cantidadvendida = rs.getString("cantidad");
        cantidadsurtida = rs.getString("surtida");
        cantidadentregada = rs.getString("enviadas");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
      
      /////
      
      double cantidadvendidadouble = Double.parseDouble(cantidadvendida);
      double cantidadsurtidadouble = Double.parseDouble(cantidadsurtida);
      double cantidadenviadadouble = Double.parseDouble(cantidadentregada);
      
        
        if((cantidadvendidadouble == (cantidadsurtidadouble + cantidadenviadadouble)) && cantidadenviadadouble  == 0 )
        {
          estatusentrega ="surtida totalmente no enviada";  
        }
        else
            
            
              if((cantidadvendidadouble == (cantidadsurtidadouble + cantidadenviadadouble)) && cantidadenviadadouble  > 0 )
        {
          estatusentrega ="surtida totalmente enviada parcialmente";  
        }
       
        else
            
         if((cantidadvendidadouble > (cantidadsurtidadouble + cantidadenviadadouble ))  && cantidadenviadadouble  == 0 )
        {
          estatusentrega ="surtida parcialmente no enviada";  
        }
         
       
        else
        {
          estatusentrega ="surtida parcialmente enviada parcialmente";   
        }    
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET estatus_entrega = '" + estatusentrega + "' WHERE numero_sucursal='" + numeroordendeenviosolicitada + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      

        }
      
                     
                 
            
            
            
            
        }
        else
        {
        
     
        
      
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + nuevasurtidastring + "' WHERE numero='" + numeroventa + "' and articulo = '" + ubicacion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       

        ////Actualiza el estatus

      String cantidadsurtida = "";  
      String cantidadvendida = "";  
      String cantidadentregada = "";  
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(entregadas) as entregadas from historial_ventas where numero = '"+numeroventa+"'  ";
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
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroventa + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      

        }
      
      
      }  
    
    
     void agregaralsurtidasalhistorialdeventascancelar(String ubicacion, String cantidad) 
      {

        String numeroventa =  lbnumerodeventa.getText();
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
       
        
        String SQL2 = "select cantidad,estatus_entrega from historial_ventas where numero = '" + numeroventa + "' and articulo = '" + ubicacion + "' ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {

        cantidadstring = rs.getString("cantidad");
        estatusentrega= rs.getString("estatus_entrega");

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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '"+nuevacantidadstring+"' WHERE numero='" + numeroventa + "' and articulo = '" + ubicacion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       

        ////Actualiza el estatus

      String cantidadsurtida = "";  
      String cantidadvendida = "";  
      String cantidadentregada = "";  
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(entregadas) as entregadas from historial_ventas where numero = '"+numeroventa+"'  ";
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
      
        
      
         
    //  si tiene orden de envio le cambio el estatus a la orden de envio
              
               
       {     
              
      
      
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
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroventa + "'       ");
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
        
         String sql = "Select cantidad,cantidad_pecho_izquierdo,pecho_izquierdo,"
                  + "cantidad_pecho_derecho,pecho_derecho,"
                  + "cantidad_manga_izquierda,manga_izquierda,"
                  + "cantidad_manga_derecha,manga_derecha,"
                  + "cantidad_espalda,espalda,"
                  + "cantidad_otra_ubicacion,otra_ubicacion,"
                  + "cantidad_otra_ubicacion2,otra_ubicacion2,"
                  + "aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2 from "+nombredelatabla+" where numero = '"+lborden.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                       cantidad = rs.getString("cantidad");   
                String cantidadpechoizquierdo = rs.getString("cantidad_pecho_izquierdo");
                String pechoizquierdo = rs.getString("pecho_izquierdo");
                String cantidadpechoderecho = rs.getString("cantidad_pecho_derecho");
                String pechoderecho = rs.getString("pecho_derecho");
                String cantidadmangaizquierda = rs.getString("cantidad_manga_izquierda");
                String mangaizquierda = rs.getString("manga_izquierda");
                String cantidadmangaderecha = rs.getString("cantidad_manga_derecha");
                String mangaderecha = rs.getString("manga_derecha");
                String cantidadespalda = rs.getString("cantidad_espalda");
                String espalda = rs.getString("espalda");
                String cantidadotraubicacion = rs.getString("cantidad_otra_ubicacion");
                String otraubicacion = rs.getString("otra_ubicacion");
                String cantidadotraubicacion2 = rs.getString("cantidad_otra_ubicacion2");
                String otraubicacion2 = rs.getString("otra_ubicacion2");
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
                if (rs.next()) {

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
    
    
    void estacompletalaorden()
    {
        
        
       
   
        int tienecantidad = 0;
        botonesactivados = 0;
        
         String sql = "Select cantidad,cantidad_pecho_izquierdo,pecho_izquierdo,"
                  + "cantidad_pecho_derecho,pecho_derecho,"
                  + "cantidad_manga_izquierda,manga_izquierda,"
                  + "cantidad_manga_derecha,manga_derecha,"
                  + "cantidad_espalda,espalda,"
                  + "cantidad_otra_ubicacion,otra_ubicacion,"
                  + "cantidad_otra_ubicacion2,otra_ubicacion2 from "+nombredelatabla+" where numero = '"+lborden.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

              
                String cantidadpechoizquierdo = rs.getString("cantidad_pecho_izquierdo");
                String pechoizquierdo = rs.getString("pecho_izquierdo");
                String cantidadpechoderecho = rs.getString("cantidad_pecho_derecho");
                String pechoderecho = rs.getString("pecho_derecho");
                String cantidadmangaizquierda = rs.getString("cantidad_manga_izquierda");
                String mangaizquierda = rs.getString("manga_izquierda");
                String cantidadmangaderecha = rs.getString("cantidad_manga_derecha");
                String mangaderecha = rs.getString("manga_derecha");
                String cantidadespalda = rs.getString("cantidad_espalda");
                String espalda = rs.getString("espalda");
                String cantidadotraubicacion = rs.getString("cantidad_otra_ubicacion");
                String otraubicacion = rs.getString("otra_ubicacion");
                String cantidadotraubicacion2 = rs.getString("cantidad_otra_ubicacion2");
                String otraubicacion2 = rs.getString("otra_ubicacion2");

                
                if(pechoizquierdo==null || pechoizquierdo.equals("")||pechoizquierdo.equals(" ")||pechoizquierdo.equals("ninguno") )
                {
                    
                    
                    
                }
                else
                {
                    
                     if(cantidadpechoizquierdo.equals("0") )
                {
                    lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                   
                    botonesactivados = botonesactivados + 1; 
                   lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());
                   
                } 
                    
                    
                    
                  
                } 
                
                
                
                
                
                if(pechoderecho==null || pechoderecho.equals("")||pechoderecho.equals(" ")||pechoderecho.equals("ninguno") )
                {
                    
                   
                    
                }
                else
                {
                    
                    
                     if(cantidadpechoderecho.equals("0") )
                {
                    
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                   
                     botonesactivados = botonesactivados + 1;
                    lbcantidad2.setText(cantidad);
                     lbcantidad2.setForeground(Color.GREEN.darker());
                }
                     
                     
                 
                }
                
                
                
                
                
                
                    
                if(mangaizquierda==null || mangaizquierda.equals("")||mangaizquierda.equals(" ")||mangaizquierda.equals("ninguno") )
                {
                    
                  
                    
                }
                else
                {
                    
                    
                    
                    
                    
                    
                        if(cantidadmangaizquierda.equals("0"))
                {
                    
                    
                      lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                   
                    botonesactivados = botonesactivados + 1;
                   lbcantidad3.setText(cantidad);
                    lbcantidad3.setForeground(Color.GREEN.darker());
                }
                        
                        
                        
                  
                }
                
                
                
                
                
                
                
                
                if(mangaderecha==null || mangaderecha.equals("")||mangaderecha.equals(" ")||mangaderecha.equals("ninguno") )
                {
                    
                    
                    
                }
                else
                {
                    
                    
                    
                     if(cantidadmangaderecha.equals("0") )
                {
                    
                    lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                   
                    botonesactivados = botonesactivados + 1;
                   lbcantidad4.setText(cantidad);
                    lbcantidad4.setForeground(Color.GREEN.darker());
                    
                }
                    
                  
                }
                
                
                
                
                
            
                
                if(espalda==null || espalda.equals("")||espalda.equals(" ")||espalda.equals("ninguno") )
                {
                    
                  
                    
                }
                else
                {
                    
                    
                      if(cantidadespalda.equals("0") )
                {
                      lbcantidad5.setText("0");
                    lbcantidad5.setForeground(Color.red.darker());
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                   
                   botonesactivados = botonesactivados + 1;
                   lbcantidad5.setText(cantidad);
                    lbcantidad5.setForeground(Color.GREEN.darker());
                    
                    
                }
            
                      
                      
                   
                }
            
                
                
                
                
                
                
                if(otraubicacion==null || otraubicacion.equals("")||otraubicacion.equals(" ")||otraubicacion.equals("ninguno") )
                {
                    
                   
                    
                }
                else
                {
                    
                    
                      
                if(cantidadotraubicacion.equals("0") )
                {
                    
                     lbcantidad6.setText("0");
                    lbcantidad6.setForeground(Color.red.darker());
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                     botonesactivados = botonesactivados + 1;
                   lbcantidad6.setText(cantidad);
                    lbcantidad6.setForeground(Color.GREEN.darker());
                   
                }
            
                
                
                
                 
                }
            
                
                
                
                
                
                
           if(otraubicacion2==null || otraubicacion2.equals("")||otraubicacion2.equals(" ")||otraubicacion2.equals("ninguno") )
                {
                    
                    
                    
                }
                else
                {
                    
                     if(cantidadotraubicacion2.equals("0") )
                {
                    
                    lbcantidad7.setText("0");
                    lbcantidad7.setForeground(Color.red.darker());
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                   
                    botonesactivados = botonesactivados + 1;
                   lbcantidad7.setText(cantidad);
                    lbcantidad7.setForeground(Color.GREEN.darker());
                    
                }
           
                    
                  
                }
           
           
           
           
           
           
           
           
                ////////////////////////////////////////////////////////////////
                
                
                
                
                
                
                
               
                
                
               
                
                
                
              
                  
                  
                
               
                
              
                
              
              
          
            
           
           if(tienecantidad == botonesactivados)
           {
               
             nuevoestatusorden = "realizada totalmente";
               
           }
         
           else
       
           {
               
               nuevoestatusorden = "realizada parcialmente";
            
           }   
               
               
               
               try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set estatus_orden='"+nuevoestatusorden+"' where numero='" + lborden.getText() + "' and prenda='" +prenda+ "'   ");
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
        String sql = "Select imagen,imagen_nombre from historial_ordenes_camisa_recibidas where numero = '"+lborden.getText()+"'   ";

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
                 PreparedStatement ps = cn.prepareStatement("select " + ubicacion + "," + ubicacionnombre + " from historial_ordenes_camisa_recibidas where numero = '" + lborden.getText() + "' ")) {
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
        btninsertarponchados = new javax.swing.JButton();
        lbtipo = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
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
        lbnumerodelaotrasucursal = new javax.swing.JLabel();
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
        btnotraubicacion2ponchado = new javax.swing.JButton();
        btnotraubicacionponchado = new javax.swing.JButton();
        btnespaldaponchado = new javax.swing.JButton();
        btnpechoizquierdoponchado = new javax.swing.JButton();
        btnpechoderechoponchado = new javax.swing.JButton();
        btnmangaizquierdaponchado = new javax.swing.JButton();
        btnmangaderechaponchado = new javax.swing.JButton();
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
        lblugar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden camisa");
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
        lbfotomontaje.setBounds(-10, 0, 1040, 640);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("Numero orden de bordado camisa");
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

        lbnumerodeventa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbnumerodeventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btninsertarponchados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btninsertarponchados.setText("Replicar pnchados");
        btninsertarponchados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarponchadosActionPerformed(evt);
            }
        });

        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Replicar a ");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        lbidentificador.setForeground(new java.awt.Color(153, 0, 0));
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Cantidad");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad.setForeground(new java.awt.Color(153, 0, 0));
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
        btnmangaderechatetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechatetermineActionPerformed(evt);
            }
        });

        btnmangaizquierdatermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaizquierdatermine.setText("Termine");
        btnmangaizquierdatermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdatermineActionPerformed(evt);
            }
        });

        btnpechoderechotermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoderechotermine.setText("Termine");
        btnpechoderechotermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechotermineActionPerformed(evt);
            }
        });

        btnpechoizquierdotermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoizquierdotermine.setText("Termine");
        btnpechoizquierdotermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdotermineActionPerformed(evt);
            }
        });

        btnespaldatetermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnespaldatetermine.setText("Termine");
        btnespaldatetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldatetermineActionPerformed(evt);
            }
        });

        btnotraubicaciontetermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicaciontetermine.setText("Termine");
        btnotraubicaciontetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicaciontetermineActionPerformed(evt);
            }
        });

        btnotraubicacion2tetermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacion2tetermine.setText("Termine");
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

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbsumapuntos.setForeground(new java.awt.Color(153, 0, 0));
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

        btnterminetodo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnterminetodo.setForeground(new java.awt.Color(0, 102, 0));
        btnterminetodo.setText("**-Termine todo***");
        btnterminetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterminetodoActionPerformed(evt);
            }
        });

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Numero de Sucursal");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumerodelaotrasucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumerodelaotrasucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnotraubicacion2ponchado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacion2ponchado.setText("Ponchado");
        btnotraubicacion2ponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacion2ponchadoActionPerformed(evt);
            }
        });

        btnotraubicacionponchado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacionponchado.setText("Ponchado");
        btnotraubicacionponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacionponchadoActionPerformed(evt);
            }
        });

        btnespaldaponchado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnespaldaponchado.setText("Ponchado");
        btnespaldaponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldaponchadoActionPerformed(evt);
            }
        });

        btnpechoizquierdoponchado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoizquierdoponchado.setText("Ponchado");
        btnpechoizquierdoponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdoponchadoActionPerformed(evt);
            }
        });

        btnpechoderechoponchado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoderechoponchado.setText("Ponchado");
        btnpechoderechoponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechoponchadoActionPerformed(evt);
            }
        });

        btnmangaizquierdaponchado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaizquierdaponchado.setText("Ponchado");
        btnmangaizquierdaponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdaponchadoActionPerformed(evt);
            }
        });

        btnmangaderechaponchado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaderechaponchado.setText("Ponchado");
        btnmangaderechaponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechaponchadoActionPerformed(evt);
            }
        });

        btnpechoizquierdocancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoizquierdocancelar.setText("Cancelar");
        btnpechoizquierdocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdocancelarActionPerformed(evt);
            }
        });

        btnpechoderechocancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoderechocancelar.setText("Cancelar");
        btnpechoderechocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechocancelarActionPerformed(evt);
            }
        });

        btnmangaizquierdacancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaizquierdacancelar.setText("Cancelar");
        btnmangaizquierdacancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdacancelarActionPerformed(evt);
            }
        });

        btnmangaderechacancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaderechacancelar.setText("Cancelar");
        btnmangaderechacancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechacancelarActionPerformed(evt);
            }
        });

        btnespaldacancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnespaldacancelar.setText("Cancelar");
        btnespaldacancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldacancelarActionPerformed(evt);
            }
        });

        btnotraubicacioncancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacioncancelar.setText("Cancelar");
        btnotraubicacioncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacioncancelarActionPerformed(evt);
            }
        });

        btnotraubicacion2cancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacion2cancelar.setText("Cancelar");
        btnotraubicacion2cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacion2cancelarActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Sucursal");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsucursal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbsucursal.setForeground(new java.awt.Color(153, 0, 0));
        lbsucursal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
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

        lblugar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblugar.setForeground(new java.awt.Color(153, 0, 0));
        lblugar.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
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
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1036, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(9, 9, 9)
                                                .addComponent(lbdiaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btndatos))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(5, 5, 5)
                                                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel13)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(12, 12, 12)
                                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 639, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(96, 96, 96)
                                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(167, 167, 167)
                                        .addComponent(btnfotomontajesinpuntadas))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbltallas, javax.swing.GroupLayout.PREFERRED_SIZE, 813, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbpechoizquierdonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbpechoderechonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbmangaizquierdanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbmangaderechanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbespaldanombre1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbotraubicacionnombre1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbotraubicacion2nombre1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbpechoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbpechoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbmangaizquierdanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbmangaderechanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbespaldanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(lbotraubicacionnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbotraubicacion2nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnotraubicaciontetermine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnotraubicacion2tetermine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmangaderechatetermine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmangaizquierdatermine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnpechoderechotermine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnpechoizquierdotermine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnespaldatetermine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnpechoizquierdocancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnpechoderechocancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnmangaizquierdacancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnmangaderechacancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnespaldacancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnotraubicacioncancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnotraubicacion2cancelar, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnpechoizquierdoponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnpechoderechoponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmangaizquierdaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnmangaderechaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnespaldaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnotraubicacionponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnotraubicacion2ponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(158, 158, 158)
                                .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(168, 168, 168)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lblugar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btninsertarponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(11, 11, 11))
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
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnfotomontajesinpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbltallas, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbdiaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbpechoizquierdonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(lbpechoderechonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(lbmangaizquierdanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(lbmangaderechanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblugar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btninsertarponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(lbespaldanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24)
                                .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbpechoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbpechoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbmangaizquierdanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbmangaderechanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbespaldanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbotraubicacionnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbotraubicacionnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbotraubicacion2nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbotraubicacion2nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(47, 47, 47)
                                    .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnpechoizquierdoponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(7, 7, 7)
                                    .addComponent(btnpechoderechoponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(46, 46, 46)
                                    .addComponent(btnmangaderechaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(btnespaldaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(btnotraubicacionponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(btnotraubicacion2ponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnpechoizquierdotermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnpechoizquierdocancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(7, 7, 7)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(lbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(lbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(btnpechoderechocancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(7, 7, 7)
                                                            .addComponent(btnmangaizquierdacancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addComponent(btnmangaizquierdaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(7, 7, 7)
                                                        .addComponent(btnmangaderechacancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGap(10, 10, 10)
                                                        .addComponent(lbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnpechoderechotermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10)
                                                        .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnmangaizquierdatermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10)
                                                        .addComponent(btnmangaderechatetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnespaldacancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(lbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnespaldatetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnotraubicacioncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnotraubicacion2cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnotraubicacion2tetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(lbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(lbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnotraubicaciontetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(37, 37, 37))
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
         if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
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
   
        
        prenda = lbprenda.getText();
        nombredelatabla = "historial_ordenes_camisa";
        
    if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
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
    
    else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
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
      
        
    }//GEN-LAST:event_formWindowOpened

    private void btnmangaizquierdatermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdatermineActionPerformed

        
          
          String ubicacion = "cantidad_manga_izquierda";
          fechaubicacion  = "manga_izquierda_fecha";
          
        
                
                                                
                                                
                                                
         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
 
            
            
            nombrebordado = mangaizquierdanombre;
            String cantidadaplicacion = aplicacionmangaizquierda;
          
            nombredelatabla = "historial_ordenes_camisa";
          
            
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);

              if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA IZQUIERDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA IZQUIERDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA IZQUIERDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA IZQUIERDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA IZQUIERDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA IZQUIERDA";

            }

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
       
            
       
        }
 else if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutamangaizquierda=fl;
            btnmangaizquierdatermine.setEnabled(false);

        }
    }
 
 
 else 
     
     
     
     if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
 
                
                nombrebordado = mangaizquierdanombre;
                String cantidadaplicacion = aplicacionmangaizquierda;
             
                nombredelatabla = "historial_ordenes_camisa_recibidas";
            
                insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
                 
                if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA IZQUIERDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA IZQUIERDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA IZQUIERDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA IZQUIERDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA IZQUIERDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA IZQUIERDA";

            }

              
                estacompletalaorden();
                sumapuntos();
            
       
    
        }
        
        }
        
    }//GEN-LAST:event_btnmangaizquierdatermineActionPerformed

    private void btnpechoizquierdotermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdotermineActionPerformed

        
    //  btnpechoizquierdotermine
        
       
      
      fechaubicacion  = "pecho_izquierdo_fecha";
      String ubicacion = "cantidad_pecho_izquierdo";
       
        
         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 
        
            
            
            
            
            
            
            
            //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
      
            
           sucursal = tiendalocal;
           nombrebordado =pechoizquierdonombre;
           String cantidadaplicacion = aplicacionpechoizquierdo;
       
           nombredelatabla = "historial_ordenes_camisa";
           
           
           
           
           insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);  
           
           
           
           
           
           
           if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA PECHO IZQUIERDO";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA PECHO IZQUIERDO";

            } //// chamarra desmontable
         
            
            
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO IZQUIERDO";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA PECHO IZQUIERDO";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA PECHO IZQUIERDO";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO PECHO IZQUIERDO";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO PECHO IZQUIERDO";

            }

     
   
       agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad) ;   
    
       estacompletalaorden(); 
    
       sumapuntos();   
        
        
            
        }
        
        
        
        
        
        
        
        
        else 
            
            
         // OTRA SUCURSAL NO SE QUE ES 
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {    
        
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        
        
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutapechoizquierdo =fl;
            btnpechoizquierdotermine.setEnabled(false);

        }
        }
  
            
            
            
            
        else 
                
                
                
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
   
            nombrebordado = pechoizquierdonombre;
            String cantidadaplicacion = aplicacionpechoizquierdo;
           
            nombredelatabla = "historial_ordenes_camisa_recibidas";
        
            insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
         
            if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA PECHO IZQUIERDO";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA PECHO IZQUIERDO";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO IZQUIERDO";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA PECHO IZQUIERDO";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA PECHO IZQUIERDO";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO PECHO IZQUIERDO";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO PECHO IZQUIERDO";

            }

        
            estacompletalaorden();
            sumapuntos();
            

        }
    
        }
    
    
    }//GEN-LAST:event_btnpechoizquierdotermineActionPerformed

    private void btnespaldatetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldatetermineActionPerformed

        
        
        
          
          fechaubicacion  = "espalda_fecha";
           String ubicacion = "cantidad_espalda";
                  
         
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
      
           
            nombrebordado = espaldanombre;
            String cantidadaplicacion = aplicacionespalda;
           
            nombredelatabla = "historial_ordenes_camisa";
         
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);

             if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA ESPALDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA ESPALDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE ESPALDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS ESPALDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA ESPALDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA ESPALDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO ESPALDA";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO ESPALDA";

            }

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad);
            estacompletalaorden();
            sumapuntos();       
            
        }
         else if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaespalda = fl ;
            btnespaldatetermine.setEnabled(false);

        }
        
        }
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            

            nombrebordado = espaldanombre;
            String cantidadaplicacion = aplicacionespalda;
           
            nombredelatabla = "historial_ordenes_camisa_recibidas";
            insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
            if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA ESPALDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA ESPALDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE ESPALDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS ESPALDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA ESPALDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA ESPALDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO ESPALDA";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO ESPALDA";

            }
            
            estacompletalaorden();
            sumapuntos();
            
           
            
        }
        
        } 
    }//GEN-LAST:event_btnespaldatetermineActionPerformed

    private void btnpechoderechotermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechotermineActionPerformed
     
        
        fechaubicacion  = "pecho_derecho_fecha";
        String ubicacion = "cantidad_pecho_derecho";
        
                                        
         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 

        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
     
            
            nombrebordado = pechoderechonombre;
            String cantidadaplicacion = aplicacionpechoderecho;
           
            nombredelatabla = "historial_ordenes_camisa";
          
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);

             if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA PECHO DERECHO";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA PECHO DERECHO";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO DERECHO";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO DERECHO";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA PECHO DERECHO";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA PECHO DERECHO";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO PECHO DERECHO";

            }
                else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO PECHO DERECHO";

            }

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
       
            
        }
         else if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutapechoderecho = fl;
            btnpechoderechotermine.setEnabled(false);

        }
        
        
        }
        
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
     
            nombrebordado = pechoderechonombre;
            String cantidadaplicacion = aplicacionpechoderecho;
           
            nombredelatabla = "historial_ordenes_camisa_recibidas";
         
            
            insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
            
            
            if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA PECHO DERECHO";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA PECHO DERECHO";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO DERECHO";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO DERECHO";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA PECHO DERECHO";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA PECHO DERECHO";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO PECHO DERECHO";

            }
                else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO PECHO DERECHO";

            }
            
            estacompletalaorden();
            sumapuntos();
            
        
       
        }
        
        }
        
    }//GEN-LAST:event_btnpechoderechotermineActionPerformed

    private void btnmangaderechatetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechatetermineActionPerformed

        
         
          fechaubicacion  = "manga_derecha_fecha";
          String ubicacion = "cantidad_manga_derecha";
                 
                        
                                        
                                        
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {    
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            
            nombrebordado = mangaderechanombre;
            String cantidadaplicacion = aplicacionmangaderecha;
           
            nombredelatabla = "historial_ordenes_camisa";
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);

            
            if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA DERECHA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA DERECHA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA DERECHA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA DERECHA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA DERECHA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA DERECHA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA DERECHA";

            }

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad);
            estacompletalaorden();
            sumapuntos();  
            
            
            
        }
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {

         

        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);
        String archivoextension ="";
        
        
        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            archivoextension= archivoelegido.getName();
            String fl = archivoelegido.toString();

            rutamangaderecha= fl;
            btnmangaderechatetermine.setEnabled(false);

        }
        
        
        }
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
       
            nombrebordado = mangaderechanombre;
            String cantidadaplicacion = aplicacionmangaderecha;
         
            nombredelatabla = "historial_ordenes_camisa_recibidas";
            insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
            if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA DERECHA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA DERECHA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA DERECHA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA DERECHA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA DERECHA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA DERECHA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA DERECHA";

            }
            
            estacompletalaorden();
            sumapuntos();  
            
            
        }
            
            
        }    
           
        btndatos.doClick();
        
    }//GEN-LAST:event_btnmangaderechatetermineActionPerformed

    private void btninsertarponchadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarponchadosActionPerformed
       
        
       
       String tiendaalaquesereplicara =  lblugar.getText();
        

        String tipo = lbtipo.getText();
        String numerosucursal = lbnumerodelaotrasucursal.getText();
        String prenda = lbprenda.getText();

        String path = "";
       
        String stringIP = "";
       
        String stringBDlocal = "";

        String nombrearchivo1 = "";
        String nombrearchivo2 = "";
        String nombrearchivo3 = "";
        String nombrearchivo4 = "";
        String nombrearchivo5 = "";
        String nombrearchivo6 = "";
        
        
        if(!tiendaalaquesereplicara.equals("ninguna"))
       
        { 

        File file = new File("C:\\sistema\\configuracion.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String str[] = line.split(":");
                stringBDlocal = str[1];
                
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        if (tiendaalaquesereplicara.equals("cdmxcentro")) {
            path = "C:\\sistema\\cdmxcentro.txt";
        } else if (tiendaalaquesereplicara.equals("cdmxsur")) {
            path = "C:\\sistema\\cdmxsur.txt";
        } else if (tiendaalaquesereplicara.equals("guadalajara")) {
            path = "C:\\sistema\\guadalajara.txt";
        } else if (tiendaalaquesereplicara.equals("monterrey")) {
            path = "C:\\sistema\\monterrey.txt";
        } else {
            if (tiendaalaquesereplicara.equals("tijuana")) {
                path = "C:\\sistema\\tijuana.txt";
            }
        }

        File file1 = new File(path);
        try {
            Scanner sc = new Scanner(file1);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String str[] = line.split(":");
                stringIP = str[0];
             
            }
        } catch (IOException e) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
        }

        Connection conn = null;

        ipsucursal = stringIP;
      

        FileInputStream input = null;
        FileInputStream input2 = null;
        FileInputStream input3 = null;
        FileInputStream input4 = null;
        FileInputStream input5 = null;
        FileInputStream input6 = null;

        String extensionponchado1 = "", extensionponchado2 = "", extensionponchado3 = "", extensionponchado4 = "", extensionponchado5 = "";

        //ponchado1
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://" + ipsucursal + "/" + sucursal + "", "root", "sistemas");

            //primerponchado   
            Object ponchado1 = rutamangaizquierda;
            if (ponchado1 == null || ponchado1.equals("")) 
            {

            } else {
                try {
                    String filePath = rutamangaizquierda;
                    File archivo = new File(filePath);
                    nombrearchivo1 = archivo.getName();
                    input = new FileInputStream(new File(filePath));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set manga_izquierda_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set manga_izquierda_ponchado_nombre='" + nombrearchivo1 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
            }

            ///ponchado2
            Object ponchado2 = rutapechoizquierdo;
            if (ponchado2 == null || ponchado2.equals("") || ponchado2.equals(" ")) {

            } else {
                try {
                    String filePath2 = rutapechoizquierdo;
                    File archivo2 = new File(filePath2);
                    nombrearchivo2 = archivo2.getName();
                    input2 = new FileInputStream(new File(filePath2));
                } catch (FileNotFoundException ex) {
                 
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set pecho_izquierdo_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input2);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                 
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");

                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set pecho_izquierdo_ponchado_nombre='" + nombrearchivo2 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }

            }

            ///ponchado3
            Object ponchado3 = rutaespalda;
            if (ponchado3 == null || ponchado3.equals("") || ponchado3.equals(" ")) {

            } else {
                try {
                    String filePath3 = rutaespalda;
                    File archivo3 = new File(filePath3);
                    nombrearchivo3 = archivo3.getName();
                    input3 = new FileInputStream(new File(filePath3));
                } catch (FileNotFoundException ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set espalda_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input3);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set espalda_ponchado_nombre='" + nombrearchivo3 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
            }

            //ponchado 4
            Object ponchado4 = rutamangaderecha;

            if (ponchado4 == null || ponchado4.equals("") || ponchado4.equals(" ")) {

            } else {
                try {
                    String filePath4 = rutamangaderecha;
                    File archivo4 = new File(filePath4);
                    nombrearchivo4 = archivo4.getName();
                    input4 = new FileInputStream(new File(filePath4));
                } catch (FileNotFoundException ex) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set manga_derecha_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input4);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set manga_derecha_ponchado_nombre='" + nombrearchivo4 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
            }

            //ponchado5
            Object ponchado5 = rutapechoderecho;

            if (ponchado5 == null || ponchado5.equals("") || ponchado5.equals(" ")) {

            } else {
                try {
                    String filePath5 = rutapechoderecho;
                    File archivo5 = new File(filePath5);
                    nombrearchivo5 = archivo5.getName();
                    input5 = new FileInputStream(new File(filePath5));
                } catch (FileNotFoundException ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set pecho_derecho_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input5);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                  
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set pecho_derecho_ponchado_nombre='" + nombrearchivo5 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                  
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
            }

           /// imagen jlabel
            Object imagen = rutaimagen;

            if (imagen == null || imagen.equals("") || imagen.equals(" ")) {

            } else {
                try {
                    String filePath6 = rutaimagen;
                    File archivo6 = new File(filePath6);
                    nombrearchivo6 = archivo6.getName();
                    input6 = new FileInputStream(new File(filePath6));
                } catch (FileNotFoundException ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set imagen=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input6);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set imagen_nombre='" + nombrearchivo6 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                 
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
            return;
        }

        if (traspaso > 0) {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden se inserto correctamente en la otra sucursal");

            String numero = lbnumerodelaotrasucursal.getText();
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa SET estatus_entrega='enviado' WHERE numero='" + numero + "'");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
            }

            ordenesporrealizar.btnactualizar.doClick();

        }
        else
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden NO SE INSERTO correctamente en la otra sucursal"); 
        }  

        
        
       ventanaordencamisa = false;
        this.dispose();
        
        }

   

    }//GEN-LAST:event_btninsertarponchadosActionPerformed

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
        
               
         
                                        
                                        
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        

        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            

            
            if(btnotraubicaciontetermine.getText().equals("Cancelar"))
            {
                
                
            }
            else
            {
            String ubicacion = "cantidad_otra_ubicacion";
            nombrebordado = otraubicacionnombre;
            String cantidadaplicacion = aplicacionotraubicacion;
          
            nombredelatabla = "historial_ordenes_camisa";
     
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);

          if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION";

            }

            
          
            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
            
            }
            
        }
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaespalda = fl;
            btnotraubicaciontetermine.setEnabled(false);

        }
        
        }
         else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
     
            
            String ubicacion = "cantidad_otra_ubicacion";
            nombrebordado = otraubicacionnombre;
            String cantidadaplicacion = aplicacionotraubicacion;
            nombredelatabla = "historial_ordenes_camisa_recibidas";
          
            insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
              if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION";

            }

            
            estacompletalaorden();
            sumapuntos();
            
            
            
            
        }
        
        
        }
        
    }//GEN-LAST:event_btnotraubicaciontetermineActionPerformed

    private void btnotraubicacion2tetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacion2tetermineActionPerformed

        
         
         fechaubicacion  = "otra_ubicacion2_fecha";
                                    
                                        
         
                                                
                                                
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
     
            String ubicacion = "cantidad_otra_ubicacion2";
            nombrebordado = otraubicacion2nombre;
            String cantidadaplicacion = aplicacionotraubicacion2;
           
            nombredelatabla = "historial_ordenes_camisa";
      
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);
           
             if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION2";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION2";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION2";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION2";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION2";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION2";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION2";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION2";

            }

            
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
            
            
            
        }
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaespalda = fl;
            btnotraubicaciontetermine.setEnabled(false);

        }
        
        }
        else
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
   

                String ubicacion = "cantidad_otra_ubicacion2";
                nombrebordado = otraubicacion2nombre;
                String cantidadaplicacion = aplicacionotraubicacion2;
              
                nombredelatabla = "historial_ordenes_camisa_recibidas";
                insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
                  if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION2";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION2";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION2";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION2";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION2";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION2";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION2";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION2";

            }
                
                estacompletalaorden();
                sumapuntos();

            
            
        }
        
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
        
        
        for(int i = 0; i < listabotones.size(); i++)
        {
            Object boton =  listabotones.get(i);
            
            
            
            if(boton.equals("btnpechoizquierdo"))
            {
                if(btnpechoizquierdotermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                {    
                
                btnpechoizquierdotermine.doClick();
                
                }
            }
            else if(boton.equals("btnpechoderecho"))
            {
                if(btnpechoderechotermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnpechoderechotermine.doClick();
                }
            }
            else if(boton.equals("btnmangaizquierda"))
            {
                if(btnmangaizquierdatermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnmangaizquierdatermine.doClick();
                }
            }
            else if(boton.equals("btnmangaderecha"))
            {
                if(btnmangaderechatetermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnmangaderechatetermine.doClick();
                }
            }
            else if(boton.equals("btnespalda"))
            {
                if(btnespaldatetermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnespaldatetermine.doClick();
                }
            }
            else if(boton.equals("btnotraubicacion"))
            {
                if(btnotraubicaciontetermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnotraubicaciontetermine.doClick();
                }
            }
            else if(boton.equals("btnotraubicacion2"))
            {
                if(btnotraubicaciontetermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnotraubicacion2tetermine.doClick();
                }
            }
            
        }
        
        
        
        
         terminetodo = "no";
         btnterminetodo.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden se actualizo");
         
         if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
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
  
        
        
        
        if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
        
        nombredelatabla = "historial_ordenes_camisa";
        
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
    
    else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
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

    private void btnotraubicacion2ponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacion2ponchadoActionPerformed
     
        
        
         String ubicacion = "otra_ubicacion2_ponchado";
                String ubicacionnombre = "otra_ubicacion2_ponchado_nombre";

                descargarponchado((String) ubicacion, (String) ubicacionnombre);
                
                
                
    }//GEN-LAST:event_btnotraubicacion2ponchadoActionPerformed

    private void btnotraubicacionponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacionponchadoActionPerformed
    
        
        
           String ubicacion ="otra_ubicacion_ponchado";
                String ubicacionnombre ="otra_ubicacion_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
                
    }//GEN-LAST:event_btnotraubicacionponchadoActionPerformed

    private void btnespaldaponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldaponchadoActionPerformed
      
        
        
            String ubicacion ="espalda_ponchado";
                String ubicacionnombre ="espalda_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
                
    }//GEN-LAST:event_btnespaldaponchadoActionPerformed

    private void btnpechoizquierdoponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdoponchadoActionPerformed
    
        
        String ubicacion ="pecho_izquierdo_ponchado";
                String ubicacionnombre ="pecho_izquierdo_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
    }//GEN-LAST:event_btnpechoizquierdoponchadoActionPerformed

    private void btnpechoderechoponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechoponchadoActionPerformed
   
        
            String ubicacion ="pecho_derecho_ponchado";
                String ubicacionnombre ="pecho_derecho_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
                
    }//GEN-LAST:event_btnpechoderechoponchadoActionPerformed

    private void btnmangaizquierdaponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdaponchadoActionPerformed
    
        
         String ubicacion ="manga_derecha_ponchado";
                String ubicacionnombre ="manga_derecha_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
                
    }//GEN-LAST:event_btnmangaizquierdaponchadoActionPerformed

    private void btnmangaderechaponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechaponchadoActionPerformed
      
        
        
           String ubicacion ="manga_derecha_ponchado";
                String ubicacionnombre ="manga_derecha_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
                
                
                
    }//GEN-LAST:event_btnmangaderechaponchadoActionPerformed

    private void btnpechoizquierdocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdocancelarActionPerformed
      
        
           if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado pecho izquierdo?", "WARNING",
           JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        
            
           String ubicacion = "cantidad_pecho_izquierdo";
           String fecha = "pecho_izquierdo_fecha";
           
           eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);         
                  
           
           nombrebordado =pechoizquierdonombre;
           String cantidadaplicacion = aplicacionpechoizquierdo;
         
           nombredelatabla = "historial_ordenes_camisa";
           
           
           
          if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA PECHO IZQUIERDO";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA PECHO IZQUIERDO";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO IZQUIERDO";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA PECHO IZQUIERDO";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA PECHO IZQUIERDO";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO PECHO IZQUIERDO";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO PECHO IZQUIERDO";

            }

     
       agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad) ;   
       estacompletalaorden(); 
       sumapuntos();   
        
             
            
        }  
        
        
        
    }//GEN-LAST:event_btnpechoizquierdocancelarActionPerformed

    private void btnpechoderechocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechocancelarActionPerformed
      
        
        
                if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado pecho derecho?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    String ubicacion = "cantidad_pecho_derecho";
                    String fecha = "pecho_derecho_fecha";
                    eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha); 
                    
                    nombrebordado = pechoderechonombre;
                    String cantidadaplicacion = aplicacionpechoderecho;
                   
                    nombredelatabla = "historial_ordenes_camisa";
                    

                    if (prenda.toUpperCase().equals("CAMISA")) {

                        descripcion = "BORDADO CAMISA PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION CAMISA PECHO DERECHO";

                    } //// playera
                    else if (prenda.toUpperCase().equals("PLAYERA")) {

                        descripcion = "BORDADO PLAYERA PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION PLAYERA PECHO DERECHO";

                    } //// chamarra desmontable
                    else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                        descripcion = "BORDADO CHAMARRA DESMONTABLE PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO DERECHO";

                    } /// chamarra rompevientos
                    else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                        descripcion = "BORDADO CHAMARRA ROMPEVIENTOS PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO DERECHO";

                    } ///camisola
                    else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                        descripcion = "BORDADO CAMISOLA PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION CAMISOLA PECHO DERECHO";

                    } else if (prenda.toUpperCase().equals("FILIPINA")) {

                        descripcion = "BORDADO FILIPINA PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION FILIPINA PECHO DERECHO";

                    } ///SACO
                    else if (prenda.toUpperCase().equals("SACO")) {

                        descripcion = "BORDADO SACO PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION SACO PECHO DERECHO";

                    } else if (prenda.toUpperCase().equals("CHALECO")) {

                        descripcion = "BORDADO CHALECO PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION CHALECO PECHO DERECHO";

                    }
                   
                    agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad);
                    estacompletalaorden();
                    sumapuntos();
            
        
        
        
            }
                 
                
                
                
    }//GEN-LAST:event_btnpechoderechocancelarActionPerformed

    private void btnmangaizquierdacancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdacancelarActionPerformed
      
        
        
            if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado manga izquierda?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
       
        
            String ubicacion = "cantidad_manga_izquierda";
            String fecha = "manga_izquierda_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
            
            nombrebordado = mangaizquierdanombre;
            String cantidadaplicacion = aplicacionmangaizquierda;
         
            nombredelatabla = "historial_ordenes_camisa";
             
            
              if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA IZQUIERDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA IZQUIERDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA IZQUIERDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA IZQUIERDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA IZQUIERDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA IZQUIERDA";

            }

    
       agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad) ;
       estacompletalaorden(); 
       sumapuntos(); 
       
        
                
            }
            
            
            
            
    }//GEN-LAST:event_btnmangaizquierdacancelarActionPerformed

    private void btnmangaderechacancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechacancelarActionPerformed
      
        
               if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de manga derecha?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                 {   

            String ubicacion = "cantidad_manga_derecha";
            String fecha = "manga_derecha_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha); 
            
            nombrebordado = mangaderechanombre;
            String cantidadaplicacion = aplicacionmangaderecha;
         
            nombredelatabla = "historial_ordenes_camisa";
            

             if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA DERECHA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA DERECHA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA DERECHA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA DERECHA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA DERECHA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA DERECHA";

            } ///SACO
          
            
            else
                
                if (prenda.toUpperCase().equals("SACO")) 
                
                {

                descripcion = "BORDADO SACO MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA DERECHA";

            }
            
             
             
             
            
          
            agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
                 
            }
          
               
               
    }//GEN-LAST:event_btnmangaderechacancelarActionPerformed

    private void btnespaldacancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldacancelarActionPerformed
      
        
        if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado espalda?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        
            String ubicacion = "cantidad_espalda";
            String fecha = "espalda_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha); 
            
            
            nombrebordado =espaldanombre;
           String cantidadaplicacion = aplicacionespalda;
         
            nombredelatabla = "historial_ordenes_camisa";
            
        
            
             if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA ESPALDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA ESPALDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE ESPALDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS ESPALDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA ESPALDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA ESPALDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO ESPALDA";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO ESPALDA";

            }

     
       agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad) ;   
       estacompletalaorden();
       sumapuntos();       
            
        
        
        }
                
        
        
        
    }//GEN-LAST:event_btnespaldacancelarActionPerformed

    private void btnotraubicacioncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacioncancelarActionPerformed
       
        
        
                if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado otra ubicacion?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        
            String ubicacion = "cantidad_otra_ubicacion";
            String fecha = "otra_ubicacion_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha); 
            
            nombrebordado = otraubicacionnombre;
            String cantidadaplicacion = aplicacionotraubicacion;
           
            nombredelatabla = "historial_ordenes_camisa";
            

            if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION";

            }
          
            agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
            
        
        
        }
                
                
                
    }//GEN-LAST:event_btnotraubicacioncancelarActionPerformed

    private void btnotraubicacion2cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacion2cancelarActionPerformed
      
        
        
        
        
                   if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado otra ubicacion2?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
                       
                       
            String ubicacion = "cantidad_otra_ubicacion2";
            String fecha = "otra_ubicacion2_fecha";
            eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);            
        
            
            nombrebordado = otraubicacion2nombre;
            String cantidadaplicacion = aplicacionotraubicacion2;
          
            nombredelatabla = "historial_ordenes_camisa";
          
            
            if (prenda.toUpperCase().equals("CAMISA")) {

                descripcion = "BORDADO CAMISA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION2";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                descripcion = "BORDADO PLAYERA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION2";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                descripcion = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION2";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                descripcion = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION2";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                descripcion = "BORDADO CAMISOLA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION2";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                descripcion = "BORDADO FILIPINA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION2";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                descripcion = "BORDADO SACO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION2";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                descripcion = "BORDADO CHALECO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION2";

            }

           
            agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
            
        
        
        
        }
                   
                   
                   
    }//GEN-LAST:event_btnotraubicacion2cancelarActionPerformed



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
                new ordencamisaS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btndatos;
    private javax.swing.JButton btneditarbordado;
    private javax.swing.JButton btnespaldacancelar;
    private javax.swing.JButton btnespaldaponchado;
    private javax.swing.JButton btnespaldatetermine;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    private javax.swing.JButton btninsertarponchados;
    private javax.swing.JButton btnmangaderechacancelar;
    private javax.swing.JButton btnmangaderechaponchado;
    private javax.swing.JButton btnmangaderechatetermine;
    private javax.swing.JButton btnmangaizquierdacancelar;
    private javax.swing.JButton btnmangaizquierdaponchado;
    private javax.swing.JButton btnmangaizquierdatermine;
    private javax.swing.JButton btnotraubicacion2cancelar;
    private javax.swing.JButton btnotraubicacion2ponchado;
    private javax.swing.JButton btnotraubicacion2tetermine;
    private javax.swing.JButton btnotraubicacioncancelar;
    private javax.swing.JButton btnotraubicacionponchado;
    private javax.swing.JButton btnotraubicaciontetermine;
    private javax.swing.JButton btnpechoderechocancelar;
    private javax.swing.JButton btnpechoderechoponchado;
    private javax.swing.JButton btnpechoderechotermine;
    private javax.swing.JButton btnpechoizquierdocancelar;
    private javax.swing.JButton btnpechoizquierdoponchado;
    private javax.swing.JButton btnpechoizquierdotermine;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
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
    public javax.swing.JLabel lblugar;
    public javax.swing.JLabel lbmangaderecha;
    public javax.swing.JLabel lbmangaderechanombre;
    public static javax.swing.JLabel lbmangaderechanombre1;
    public javax.swing.JLabel lbmangaizquierda;
    public javax.swing.JLabel lbmangaizquierdanombre;
    public static javax.swing.JLabel lbmangaizquierdanombre1;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumerodelaotrasucursal;
    public static javax.swing.JLabel lbnumerodeventa;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
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
    public static javax.swing.JLabel lbtipo;
    // End of variables declaration//GEN-END:variables

    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();

}
