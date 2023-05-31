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

public class ordencamisa extends javax.swing.JFrame {

    public static boolean ventanaordencamisa = false;
    public static String ordenbordadocamisa = "";
    
    String nuevoestatusorden = "";
    

    String bordadosdisponiblesstring = "0";
    int bordadosdisponiblesint = 0;
    String cantidadprendasstring = "";
    int cantidadprendasint = 0;
   
    int remanentebordadosint = 0;
    String remanentebordadosstring = "";
    int nuevoremanentebordadosint = 0;
    String nuevoremanentebordadossstring = "";
    
    String fechaubicacion = "";

    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;

    String nuevosbordadosutilizadosstring = "";
    int nuevosbordadosutilizadosint = 0;

    String primero = "";
    String ultimo = "";

    int traspaso = 0;
    String iptraspaso = "";
    
    String host = ingresotienda.strIP;
   
    String numerosucursal = "";
    String sucursal = "";
    String numerosolicitoarticulos = "";
    String tiendasolicitoarticulos = "";

    String numeroordenenvio = "";
    String tiendaordenenvio = "";
    String tiendalocal = "";
    String codigocliente = "";
    String lugar = "";
    String prenda ="";
    
    String numerodeorden = "";
    
    ///// para insertar
    
    String ubicacioninsertar = ""; 
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
    
    
    ArrayList<String> listabotones = new ArrayList<String>();
    ArrayList<String> listahilos = new ArrayList<String>();
    
     Connection con = null;
     
     String consecutivobordado = "";

    String latiendaestaconectada = "si";

    public ordencamisa() 
    {
        initComponents();
        ventanaordencamisa = true;

        lbnumeroventa.setVisible(false);
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
        
        /*
        btnpechoizquierdoponchado.setEnabled(false);
        btnpechoderechoponchado.setEnabled(false);
        btnmangaizquierdaponchado.setEnabled(false);
        btnmangaderechaponchado.setEnabled(false);
        btnespalda1.setEnabled(false);        
        btnotraubicacionponchado.setEnabled(false);        
        btnotraubicacion2ponchado.setEnabled(false);        
           */     
                
        
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File("C:\\sistema\\tallas.png"));

        } catch (Exception e) {
            e.printStackTrace();
        }

    ImageIcon imageIcon = new ImageIcon(image.getScaledInstance(lbltallas.getWidth(), lbltallas.getHeight(), Image.SCALE_DEFAULT));
    lbltallas.setIcon(imageIcon);

        
        File file = new File("C:\\sistema\\configuracion.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String str[] = line.split(":");
                tiendalocal = str[1];
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        
        
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
        
        
        
        
        
        
        
        
        String sql = "SELECT color1,color2,color3,color4,color5,color6,color7,color8,color9,color10,color11,color12,color13,color14,color15,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,hilo8,hilo9,hilo10,hilo11,hilo12,hilo13,hilo14,hilo15 FROM colorido_bordados where identificador_prenda = '"+lbidentificador.getText()+"' and codigo = '"+codigocliente+"' AND nombre = '"+lbcliente.getText()+"' ";


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
    
    
    void datosOrdenesLocales() throws IOException {

        
        
        numerodeorden = lborden.getText();

        String botonhabilitado1 = "si";
        String botonhabilitado2 = "si";
        String botonhabilitado3 = "si";
        String botonhabilitado4 = "si";
        String botonhabilitado5 = "si";
        String botonhabilitado6 = "si";
        String botonhabilitado7 = "si";
        
        
        

        String sql = "Select fecha,hora,cliente,numero_venta,cantidad,cantidad,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,"
                + "   pecho_izquierdo,pecho_derecho,manga_izquierda,manga_derecha,espalda,otra_ubicacion,otra_ubicacion2,"
                + "   cantidad_pecho_izquierdo,cantidad_pecho_derecho,cantidad_manga_izquierda,cantidad_manga_derecha,cantidad_espalda,"
                + "   pecho_izquierdo_nombre,pecho_derecho_nombre,manga_izquierda_nombre,manga_derecha_nombre,espalda_nombre,"
                + "   otra_ubicacion,otra_ubicacion_nombre,cantidad_otra_ubicacion,otra_ubicacion2,otra_ubicacion2_nombre,cantidad_otra_ubicacion2,"
                + "   aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2,"
                + "   aplicacion_pecho_izquierdo_color,aplicacion_pecho_derecho_color,aplicacion_manga_izquierda_color,aplicacion_manga_derecha_color,aplicacion_espalda_color,aplicacion_otra_ubicacion_color,aplicacion_otra_ubicacion2_color,"
                + "   lugar,estatus_orden,identificador_prenda,tienda,estatus_orden,tienda from historial_ordenes_camisa where numero = '" + numerodeorden + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));
                lbprenda.setText(rs.getString("prenda"));
                prenda = (rs.getString("prenda"));
                lbfecha.setText(rs.getString("fecha"));
                lbcantidad.setText(rs.getString("cantidad"));
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
                

                //numerosucursalordencamisa=rs.getString("numero_orden");
                sucursal=rs.getString("tienda");
                
                
                if(numerosucursalordencamisa ==null  || numerosucursalordencamisa.equals("") ||numerosucursalordencamisa.equals(" ") )
                {
                    tienenumerodesucursal ="no";
                }
                else
                {
                    tienenumerodesucursal ="si";
                }   
                

                
                
                
                
                  pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre");
                Object pechoizquierdo = rs.getString("pecho_izquierdo");
                
                lbpechoizquierdo.setText(rs.getString("pecho_izquierdo"));
                if (pechoizquierdo == null | pechoizquierdo.equals("")) {

                    btnpechoizquierdo.setEnabled(false);
                    botonhabilitado4 = "no";
                    
                    btnpechoizquierdoponchado.setEnabled(false);
                 
                    
                }
                 else
                {
                     btnterminetodo.setEnabled(true);
                    
                }
                
                
                
                
                
                
                
                
                 pechoderechonombre = rs.getString("pecho_derecho_nombre");
                Object pechoderecho = rs.getString("pecho_derecho");
                
                lbpechoderecho.setText(rs.getString("pecho_derecho"));
              
                if (pechoderecho == null | pechoderecho.equals("")) {

                    btnpechoderecho.setEnabled(false);
                    botonhabilitado3 = "no";
                    
                     btnpechoderechoponchado.setEnabled(false);
                  

                }
                 else
                {
                     btnterminetodo.setEnabled(true);
                     
                }
                
                
                
                

              
                
                  mangaizquierdanombre = rs.getString("manga_izquierda_nombre");
                Object mangaizquierda = rs.getString("manga_izquierda");
                lbmangaizquierda.setText(rs.getString("manga_izquierda"));
             
                if (mangaizquierda == null | mangaizquierda.equals("")) {

                    btnmangaizquierda.setEnabled(false);
                    botonhabilitado2 = "no";
                    
                    btnmangaizquierdaponchado.setEnabled(false);
                  

                }
                 else
                {
                     btnterminetodo.setEnabled(true);
                   
                     
                }
                
                
                
                
                
                
                
                
                mangaderechanombre = rs.getString("manga_derecha_nombre");
                Object mangaderecha = rs.getString("manga_derecha");
                lbpechoizquierdo.setText(rs.getString("manga_derecha"));
               
                if (mangaderecha == null | mangaderecha.equals("")) 
                {

                    btnmangaderecha.setEnabled(false);
                    botonhabilitado1 = "no";
                    
                    btnmangaderechaponchado.setEnabled(false);
                   

                }
                 else
                {
                     btnterminetodo.setEnabled(true);
                    
                }

              
                
                
                

                espaldanombre = rs.getString("espalda_nombre");
                Object espalda = rs.getString("espalda");
                
                lbespalda.setText(rs.getString("espalda"));
               
                if (espalda == null | espalda.equals("")) {

                    btnespalda.setEnabled(false);
                    botonhabilitado5 = "no";
                    
                    btnespaldaponchado.setEnabled(false);
                  
                   
                }
                 else
                {
                     btnterminetodo.setEnabled(true);
                   
                }
                

                
                

                otraubicacionnombre = rs.getString("otra_ubicacion_nombre");
                Object otraubicacion = rs.getString("otra_ubicacion");
                
                lbotraubicacion.setText(rs.getString("otra_ubicacion"));
             
                if (otraubicacion == null | otraubicacion.equals("")) {

                    btnotraubicacion.setEnabled(false);
                    botonhabilitado6 = "no";
                    
                    btnotraubicacionponchado.setEnabled(false);
                  

                }
                 else
                {
                     btnterminetodo.setEnabled(true);
                 
                }

                
                
                
                
                
                
                otraubicacion2nombre = rs.getString("otra_ubicacion2_nombre");
                Object otraubicacion2 = rs.getString("otra_ubicacion2");
                
                lbotraubicacion2.setText(rs.getString("otra_ubicacion2"));
              
                if (otraubicacion2 == null | otraubicacion2.equals("")) {

                    btnotraubicacion2.setEnabled(false);
                    botonhabilitado7 = "no";
                    
                     btnotraubicacion2ponchado.setEnabled(false);
                   
                    

                }
                else
                {
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


                
                
                
                
                
                
                
                
                
                
                
                String cantidadpechoizquiedo =rs.getString("cantidad_pecho_izquierdo");
                String cantidadpechoderecho =rs.getString("cantidad_pecho_derecho");         
                String cantidadmangaizquierda =rs.getString("cantidad_manga_izquierda"); 
                String cantidadmangaderecha =rs.getString("cantidad_manga_derecha");
                String cantidadespalda =rs.getString("cantidad_espalda");
                String cantidadotraubicacion =rs.getString("cantidad_otra_ubicacion");
                String cantidadotraubicacion2 =rs.getString("cantidad_otra_ubicacion2");
                
                
                if(lugar.equals("Esta sucursal"))
                {
                
                    
                    btninsertarponchados.setEnabled(false);
                    cbsucursal.setEnabled(false);
                
                
                //// pecho izquierdo    
                    
                if(cantidadpechoizquiedo.equals("0") && botonhabilitado4.equals("si") )
                {
                   btnpechoizquierdo.setEnabled(true);
              //     btnpechoizquierdo.setText("Pecho Izquierdo");
               //     btnpechoizquierdo.setForeground(Color.green.darker());
                   if(botonhabilitado4.equals("si"))
                   {
                   listabotones.add("btnpechoizquierdo");
                   }
                  
                }
                else
                {
                    
                     if(botonhabilitado4.equals("si"))
                   {
                     btnpechoizquierdocancelar.setEnabled(true);
                   
                     
                   }
                   else
                   {
                     btnpechoizquierdo.setEnabled(false);
                   }
              
                
                } 
                
               
                //// pecho derecho
                
                if(cantidadpechoderecho.equals("0")  && botonhabilitado3.equals("si") )
                {
                   btnpechoderecho.setEnabled(true);
              //     btnpechoderecho.setText("Pecho derecho");
             //      btnpechoderecho.setForeground(Color.green.darker());
                   if(botonhabilitado3.equals("si"))
                   {
                   listabotones.add("btnpechoderecho");
                   
                   }
                  
                }
                else
                {
                    
                     if(botonhabilitado3.equals("si"))
                   {
                    btnpechoderechocancelar.setEnabled(true);
                      
                    
                   }
                   else
                   {
                     btnpechoderecho.setEnabled(false);
                   }
               
                } 
                
                
                if(cantidadmangaizquierda.equals("0")  && botonhabilitado2.equals("si") )
                {
                   btnmangaizquierda.setEnabled(true);
              //     btnmangaizquierda.setText("Manga izquierda");
              //      btnmangaizquierda.setForeground(Color.green.darker());
                   if(botonhabilitado2.equals("si"))
                   {
                   listabotones.add("btnmangaizquierda");
                   }
                  
                }
                else
                {
                    
                   if(botonhabilitado2.equals("si"))
                   {
                  btnmangaizquierdacancelar.setEnabled(true);
                     
                   
                   }
                   else
                   {
                       
                       btnmangaizquierda.setEnabled(false);
                    
                   }
                } 
                
                
                
                    
                if(cantidadmangaderecha.equals("0")  && botonhabilitado1.equals("si") )
                {
                   btnmangaderecha.setEnabled(true);
              //     btnmangaderecha.setText("Manga Derecha");
              //     btnmangaderecha.setForeground(Color.green.darker());
                    if(botonhabilitado1.equals("si"))
                   {
                   listabotones.add("btnmangaderecha");
                   }
                   
                   
                   
                }
                else
                {
                    
                     if(botonhabilitado1.equals("si"))
                   {
                 btnmangaderechacancelar.setEnabled(true);
              
                    
                   }
                   else
                   {
                    btnmangaderecha.setEnabled(false);
                   }
                } 
                
                
                if(cantidadespalda.equals("0")  && botonhabilitado5.equals("si") )
                {
                   btnespalda.setEnabled(true);
              //     btnespalda.setText("Espalda");
              //     btnespalda.setForeground(Color.green.darker());
                   if(botonhabilitado5.equals("si"))
                   {
                   listabotones.add("btnespalda");
                   }
                  
                   
                }
                else
                {
                    
                   if(botonhabilitado5.equals("si"))
                   {
                   btnespaldacancelar.setEnabled(false);
                  
                   }
                   else
                   {
                     btnespalda.setEnabled(false);
                   }    
                    
                    
                } 
                
                
                if(cantidadotraubicacion.equals("0")  && botonhabilitado6.equals("si") )
                {
                   btnotraubicacion.setEnabled(true);
              //     btnotraubicacion.setText("Otra ubicacion");
               //    btnotraubicacion.setForeground(Color.green.darker());
                   if(botonhabilitado6.equals("si"))
                   {
                   listabotones.add("btnotraubicacion");
                   }
                   
                   
                }
                else
                {
                    
                    if(botonhabilitado6.equals("si"))
                   {
                   btnotraubicacioncancelar.setEnabled(true);
                  
                   }
                   else
                   {
                    btnotraubicacion.setEnabled(false);
                   }
                } 
                
                if(cantidadotraubicacion2.equals("0")  && botonhabilitado7.equals("si") )
                {
                   btnotraubicacion2.setEnabled(true);
              //     btnotraubicacion2.setText("Otra ubicacion2");
               //    btnotraubicacion2.setForeground(Color.green.darker());
                   if(botonhabilitado7.equals("si"))
                   {
                       listabotones.add("btnotraubicacion2");
                   }
                  
                   
                }
                else
                {
                    
                     if(botonhabilitado7.equals("si"))
                   {
                 btnotraubicacion2cancelar.setEnabled(true);
                 
                   }
                   else
                   {
                     btnotraubicacion2.setEnabled(false);
                   }
                } 
                
                
                
                }
                else
                {
                    
                    btninsertarponchados.setEnabled(true);
                    cbsucursal.setEnabled(true);
                    
                } 
                
                
                 String estatusorden = rs.getString("estatus_orden");
                
                if(estatusorden.equals("realizada"))
                {
                  btnterminetodo.setEnabled(false);  
                }
                else
                {
                   btnterminetodo.setEnabled(true); 
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
        
        
        regresaralaconeccionlocal();
        
        
       
        
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

                
          //       consecutivobordado = rs.getString("numero_folio");
                
                lbcliente.setText(rs.getString("cliente"));
                lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                lbbordacliente.setText(rs.getString("borda_cliente"));
                lbprenda.setText(rs.getString("prenda"));
                prenda = (rs.getString("prenda"));
                lbfecha.setText(rs.getString("fecha"));
                lbnumerodelaotrasucursal.setText(rs.getString("numero_sucursal_orden"));
                numerosucursal = rs.getString("numero_sucursal");
                
                sucursal = rs.getString("tienda");
                lbsucursal.setText(sucursal);
            
                mangaderechanombre = rs.getString("manga_derecha_nombre");
                Object mangaderecha = rs.getString("manga_derecha");
                lbmangaderechanombre.setText(mangaderechanombre);
                lbmangaderecha.setText(rs.getString("manga_derecha"));
                if (mangaderecha == null || mangaderecha.equals("") || mangaderecha.equals("ninguno"))
                
                {

                    btnmangaderecha.setVisible(false);
                     


                }
                else
                {
                    botonhabilitado1 = "si";
                }   

                mangaizquierdanombre = rs.getString("manga_izquierda_nombre");
                Object mangaizquierda = rs.getString("manga_izquierda");
                lbmangaizquierdanombre.setText(mangaizquierdanombre);
                lbmangaizquierda.setText(rs.getString("manga_izquierda"));
                if (mangaizquierda == null || mangaizquierda.equals("") || mangaizquierda.equals("ninguno")) {

                    btnmangaizquierda.setVisible(false); 
                

                }
                else
                {
                    botonhabilitado2 = "si";
                } 

                pechoderechonombre = rs.getString("pecho_derecho_nombre");
                Object pechoderecho = rs.getString("pecho_derecho");
                lbpechoderechonombre.setText(pechoderechonombre);
                lbpechoderecho.setText(rs.getString("pecho_derecho"));
                if (pechoderecho == null || pechoderecho.equals("") || pechoderecho.equals("ninguno")) {

                    btnpechoderecho.setVisible(false);
                     

                }
                else
                {
                    botonhabilitado3 = "si";
                } 

                pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre");
                Object pechoizquierdo = rs.getString("pecho_izquierdo");
                lbpechoizquierdonombre.setText(pechoizquierdonombre);
                lbpechoizquierdo.setText(rs.getString("pecho_izquierdo"));
                if (pechoizquierdo == null || pechoizquierdo.equals("") || pechoizquierdo.equals("ninguno")) {

                    btnpechoizquierdo.setVisible(false);
                    

                }
                else
                {
                    botonhabilitado4 = "si";
                } 

                espaldanombre = rs.getString("espalda_nombre");
                Object espalda = rs.getString("espalda");
                lbespaldanombre.setText(espaldanombre);
                lbespalda.setText(rs.getString("espalda"));
                if (espalda == null || espalda.equals("")) {

                    btnespalda.setVisible(false);
                 

                }
                else
                {
                    botonhabilitado5 = "si";
                } 

                otraubicacionnombre = rs.getString("otra_ubicacion_nombre");
                Object otraubicacion = rs.getString("otra_ubicacion");
                lbotraubicacionnombre.setText(otraubicacionnombre);
                lbotraubicacion.setText(rs.getString("otra_ubicacion"));
                if (otraubicacion == null || otraubicacion.equals("") || otraubicacion.equals("ninguno")) {

                    btnotraubicacion.setVisible(false);
                    

                }
                else
                {
                    botonhabilitado6 = "si";
                } 

                otraubicacion2nombre = rs.getString("otra_ubicacion2_nombre");
                Object otraubicacion2 = rs.getString("otra_ubicacion2");
                
                
                
                lbotraubicacion2nombre.setText(otraubicacion2nombre);
                lbotraubicacion2.setText(rs.getString("otra_ubicacion2"));
                if (otraubicacion2 == null || otraubicacion2.equals("") || otraubicacion2.equals("ninguno")) 
                {

                    btnotraubicacion2.setVisible(false);
                   
                }
                else
                {
                    botonhabilitado7 = "si";
                } 

                lbcantidad.setText(rs.getString("cantidad"));

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
                    cbsucursal.setEnabled(false);

                    
                    
                    
                    
                    
                    if(cantidadpechoizquiedo.equals("0") && botonhabilitado4.equals("si") )
                {
                   btnpechoizquierdo.setEnabled(true);
                   btnpechoizquierdoponchado.setEnabled(true);
                  
                   if(botonhabilitado4.equals("si"))
                   {
                   listabotones.add("btnpechoizquierdo");
                   btnterminetodo.setEnabled(true);
                   }
                   
                }
                else
                {
                    btnpechoizquierdo.setEnabled(false);
                    btnpechoizquierdoponchado.setEnabled(false);
                   
                } 
                
               
                
                if(cantidadpechoderecho.equals("0")  && botonhabilitado3.equals("si") )
                {
                    
                   btnpechoderecho.setEnabled(true);
                   btnpechoderechoponchado.setEnabled(true);
                           
                           
                   if(botonhabilitado3.equals("si"))
                   {
                   listabotones.add("btnpechoderecho");
                   btnterminetodo.setEnabled(true);
                   
                   }
                  
                }
                else
                {
                    btnpechoderecho.setEnabled(false);
                    btnpechoderechoponchado.setEnabled(false);
                   
                } 
                
                
                if(cantidadmangaizquierda.equals("0")  && botonhabilitado2.equals("si") )
                {
                    
                   btnmangaizquierda.setEnabled(true);
                   btnmangaizquierdaponchado.setEnabled(true);
                   
                   
                   if(botonhabilitado2.equals("si"))
                   {
                   listabotones.add("btnmangaizquierda");
                   btnterminetodo.setEnabled(true);
                   }
                  
                }
                else
                {
                    btnmangaizquierda.setEnabled(false);
                    btnmangaizquierdaponchado.setEnabled(false);
                   
                } 
                    
                if(cantidadmangaderecha.equals("0")  && botonhabilitado1.equals("si") )
                {
                   btnmangaderecha.setEnabled(true);
                   btnmangaderechaponchado.setEnabled(true);
                           
                           
                    if(botonhabilitado1.equals("si"))
                   {
                   listabotones.add("btnmangaderecha");
                   btnterminetodo.setEnabled(true);
                   }
                   
                   
                   
                }
                else
                {
                    btnmangaderecha.setEnabled(false);
                    btnmangaderechaponchado.setEnabled(false);
                    
                } 
                
                
                if(cantidadespalda.equals("0")  && botonhabilitado5.equals("si") )
                {
                   btnespalda.setEnabled(true);
                   btnespaldaponchado.setEnabled(true);
                           
                   if(botonhabilitado5.equals("si"))
                   {
                   listabotones.add("btnespalda");
                   btnterminetodo.setEnabled(true);
                   }
                 
                   
                }
                else
                {
                    btnespalda.setEnabled(false);
                    btnespaldaponchado.setEnabled(false);
                    
                } 
                
                
                
                
                
                
                
                btnotraubicacionponchado.setEnabled(false);
                btnotraubicacion2ponchado.setEnabled(false);
                
                
                
                
                
                
                
                
                
                
                
                
                
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
             
            
                
              if (latiendaestaconectada.equals("si"))

                      {
      
                          
                        
                
                 try {
         
                     
                     
            Class.forName("com.mysql.jdbc.Driver");
       
         
            con = DriverManager.getConnection("jdbc:mysql://" + iptraspaso + "/" + sucursal + "", "root", "sistemas");
      

        
        
         BufferedImage img = null;
        
        
        
       String sql4 = "Select extension_imagen,imagen from bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";  ///

        try {

            Statement st = con.createStatement();
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
    
    
     void regresaralaconeccionlocal(){
          
        
         
         
         
        try {
            Class.forName("com.mysql.jdbc.Driver");
             cn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + tiendalocal + "", "root", "sistemas"); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
           
         
         
         /*
              
              try {
                Class.forName("com.mysql.jdbc.Driver");
                
              
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
            }
              
            
       try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://" + host + "/tiendas", "root", "sistemas");
        } catch (Exception e) {

            System.out.println(e);

        }
       
       
       */
        
       
     }
    
    
 void tiendaconectada()
 {
     
     
      regresaralaconeccionlocal();
     
     
     sucursal = lbsucursal.getText();
     
     
      try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://" + host + "/tiendas", "root", "sistemas");
       
            
     
             
              try {   
                
                String sql = "SELECT ip FROM catalogo_tiendas where tienda = '" + sucursal + "'";

                Statement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {

                    iptraspaso = rs.getString("ip");
              

                } else {

                }

                st.close();
            } catch (SQLException ex) {
                JOptionPane op = new JOptionPane();
                JLabel label = new JLabel("<HTML><b style=\"Color:red; font-size:20px;\">Error al buscar tiendas".toUpperCase());
                label.setFont(new Font("Arial", Font.BOLD, 40));
                label.setOpaque(true);
                label.setForeground(Color.red.brighter());
                label.setBackground(Color.YELLOW.brighter());
                op.showMessageDialog(null, label, "ERROR!!", op.WARNING_MESSAGE);
                //JOptionPane.showMessageDialog(null, "Error al buscar tiendas");
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
                
                

                ping = InetAddress.getByName(iptraspaso);
            
                if (ping.isReachable(5000)) 
                {
                  
                  latiendaestaconectada = "si";
                  

                }
                
                else 
                
                {
                    
                    latiendaestaconectada = "no";
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al conectar con tienda");
                    

                }
            } catch (IOException ex) {
                System.out.println(ex);
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al conectar con tienda");
               
                
            }

        }         

     
 }
 
    
        
 
    
    
     void codigocliente()
    {
        String sql = "SELECT codigo_cliente FROM historial_ventas WHERE numero = '" + lbnumeroventa.getText() + "' ";


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

  
    
    
    void agregarfotomontaje() throws FileNotFoundException, IOException  
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
          
            
            
            
            
            btnmangaderecha.setEnabled(false);
            btnmangaizquierda.setEnabled(false);
            btnpechoderecho.setEnabled(false);
            btnpechoizquierdo.setEnabled(false);
            btnespalda.setEnabled(false);
            btnotraubicacion.setEnabled(false);
            btnotraubicacion2.setEnabled(false);
            
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

     void agregarfotomontajeotrasucursal() throws FileNotFoundException, IOException  
    {
        
        String numero = lborden.getText();
        prenda =lbprenda.getText();
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);
        
        
        if (sucursal.equals(tiendalocal))
            
        {
            
      
        numerodeorden = lborden.getText();
        

        String sql7 = "Select prenda,tienda,identificador_prenda from historial_ordenes_camisa where numero = '" + numerosucursal + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql7);
            if (rs.next()) {

              
                lbprenda.setText(rs.getString("prenda"));
                prenda = (rs.getString("prenda"));
                sucursal = rs.getString("tienda");
                identificador = rs.getString("identificador_prenda");
                

            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }

            
            cliente();
            
            
       String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
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
        
        
        
        if(tienefotomontaje.equals("si"))
        {
          
            
        
            
            
        
        }
        else
        {
            btnmangaderecha.setEnabled(false);
            btnmangaizquierda.setEnabled(false);
            btnpechoderecho.setEnabled(false);
            btnpechoizquierdo.setEnabled(false);
            btnespalda.setEnabled(false);
            btnotraubicacion.setEnabled(false);
            btnotraubicacion2.setEnabled(false);
            
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
            
        }  

        
            
            
            
            
            
        }
        else
            
        {
            
        

       String sql = "Select imagen_nombre,imagen from historial_ordenes_camisa_recibidas where numero = '"+numero+"'  and prenda = '"+prenda+"'   ";  ///

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

            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }
        
        
        
        if(tienefotomontaje.equals("si"))
        {
          
           
        
           
            
        
        }
        else
        {
       
         
            lbfotomontaje.setVisible(false);
            btnverfotomontaje.setEnabled(false);
          

            
            
        }  

        
        }
        
        
    }

    
    
    
    void datostienda() 
    {
        /// busca las ordenes de camisa generadas 

        
        String numero = lbnumeroventa.getText();
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
                    
                    
                    cbsucursal.addItem(tiendasolicitoarticulos);
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
                
                
                cbsucursal.addItem(tiendaordenenvio);
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

                        cbsucursal.addItem(tiendasolicitoarticulos);
                        lbnumerodelaotrasucursal.setText(numerosolicitoarticulos);
                    }
                    else
                    {
                        
                    }
                    
                    
                } catch (Exception exx) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

                }

            } else {
                cbsucursal.addItem(tiendaordenenvio);
                cbsucursal.setSelectedItem(tiendaordenenvio);
                lbnumerodelaotrasucursal.setText(numeroordenenvio);
            }

            
        }

    }
    
    
    void actualizarlascantidadesbordadascancelar(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa set "+ubicacion+"='0' where numero = '"+lborden.getText()+"'  ");
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
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    void actualizarlascantidadesbordadas(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa set "+ubicacion+"='" + lbcantidad.getText() + "',fecha='"+dia()+"' where numero = '"+lborden.getText()+"'  ");
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
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        }
        
        try {
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    
    
    void actualizarlascantidadesbordadasotrasucursal(String ubicacion)
    {
        
        regresaralaconeccionlocal();
    
        
        try {
        
         
            

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacion+"='" + lbcantidad.getText() + "',fecha = '"+dia()+"',"+fechaubicacion+" = '"+dia()+"'  where numero = '"+lborden.getText()+"'  ");
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
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    void agregarexistenciabordados(String ubicacioninsertar,String aplicacioninsertar,String cantidadaplicacion)
    {
        
       
        identificador = lbidentificador.getText();
        String cantidad = lbcantidad.getText();
        
        
        //// bordado
        String InsertarSQL = "INSERT INTO historial_bordados_existencia(numero,dia,hora,articulo,concepto,cantidad,numero_sucursal,sucursal) VALUES (?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            
                
 
                pst.setString(1, lbnumeroventa.getText());
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, ubicacioninsertar);
                pst.setString(5, identificador);
                pst.setString(6, cantidad);
                
                 if(tienenumerodesucursal.equals("no") )
                {
                    pst.setString(7, "00000000");
                    pst.setString(8, "ninguno");
                }
                else
                {
                    pst.setString(7, numerosucursalordencamisa);
                    pst.setString(8, sucursal);
                } 
                
                
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }

            
           if(cantidadaplicacion==null || cantidadaplicacion.equals("") ||cantidadaplicacion.equals(" "))
           {
              cantidadaplicacion = "0"; 
           }
            
           int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
           
           
           if(cantidadaplicacionint > 0)
           {
               int cantidadprendasint = Integer.parseInt(lbcantidad.getText());
               int totalaplicaciones = cantidadprendasint * cantidadaplicacionint;
               
               String Insertaraplicacion = "INSERT INTO historial_bordados_existencia(numero,dia,hora,articulo,concepto,cantidad) VALUES (?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(Insertaraplicacion);
            
                
 
                pst.setString(1, lbnumeroventa.getText());
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, aplicacioninsertar);
                pst.setString(5, lbidentificador.getText());
                pst.setString(6, String.valueOf(totalaplicaciones));
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
               
           }
        
        
    }
    
    void agregarexistenciabordadosotrasucursal(String ubicacioninsertar,String aplicacioninsertar,String cantidadaplicacion)
    {
        
       
        
        //// bordado
        String InsertarSQL = "INSERT INTO historial_bordados_existencia(numero_sucursal,sucursal,dia,hora,articulo,concepto,cantidad) VALUES (?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            
                
 
                pst.setString(1, lbnumerodelaotrasucursal.getText());
                pst.setString(2, sucursal);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, ubicacioninsertar);
                pst.setString(6, lbidentificador.getText());
                pst.setString(7, lbcantidad.getText());
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }

            
           if(cantidadaplicacion==null || cantidadaplicacion.equals("") ||cantidadaplicacion.equals(" "))
           {
              cantidadaplicacion = "0"; 
           }
            
           int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
           
           
           if(cantidadaplicacionint > 0)
           {
               int cantidadprendasint = Integer.parseInt(lbcantidad.getText());
               int totalaplicaciones = cantidadprendasint * cantidadaplicacionint;
               
               String Insertaraplicacion = "INSERT INTO historial_bordados_existencia(numero_sucursal,sucursal,dia,hora,articulo,concepto,cantidad) VALUES (?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(Insertaraplicacion);
            
                
 
                 pst.setString(1, lbnumerodelaotrasucursal.getText());
                pst.setString(2, sucursal);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, ubicacioninsertar);
                pst.setString(6, lbidentificador.getText());
                pst.setString(7, lbcantidad.getText());
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
               
           }
        
        
    }
    
    
    void agregarexistenciabordadoscancelar(String ubicacioninsertar,String aplicacioninsertar,String cantidadaplicacion)
    {
        
      
       
        
        //// bordado
        
        try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM historial_bordados_existencia WHERE numero='"+lbnumeroventa.getText()+"' and articulo ='"+ubicacioninsertar+"'   ");
                pst.executeUpdate();
                pst.close();
            
            } catch (Exception e) {
                System.out.println(e);
            }
      

       //// aplicacion      
           if(cantidadaplicacion==null || cantidadaplicacion.equals("") ||cantidadaplicacion.equals(" "))
           {
              cantidadaplicacion = "0"; 
           }
            
           int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
           
           
           if(cantidadaplicacionint > 0)
           {
               
               
                try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM historial_bordados_existencia WHERE numero='"+lbnumeroventa.getText()+"' and articulo ='"+aplicacioninsertar+"'   ");
                pst.executeUpdate();
                pst.close();
            
            } catch (Exception e) {
                System.out.println(e);
            }
               
               
           }
        
        
    }
    

    
    void agregaralsurtidasalhistorialdeventas(String ubicacion, String cantidad) 
      {

        String numeroventa =  lbnumeroventa.getText();
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
        String estatusentregaventa = "";
        
        String SQL2 = "select articulo,cantidad,estatus_entrega from historial_ventas where numero = '" + numeroventa + "' and articulo = '" + ubicacion + "' ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {
            
       

        cantidadstring = rs.getString("cantidad");
        estatusentregaventa= rs.getString("estatus_entrega");

        }
        
        else
        {
         //    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px ;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacion+" no se pudo surtir debido a que NO SE ENCONTRÓ EN LA VENTA; QUIZAS SE CAMBIO DE NOMBRE");

             
             
         // JOPTION EN 2 RENGLONES tip    
             
             
               //   JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Preguntale al cliente si estan correctas las personas autorizadas para COMPRAR Y PARA RECIBIR");
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EN LA VENTA; QUIZAS SE CAMBIO DE NOMBRE";
        
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
        
        if(estatusentregaventa.equals("surtida totalmente entregada totalmente"))
        {
            
        }
        else
        {
        
      if(cantidadstring ==null || cantidadstring.equals("")||cantidadstring.equals(" "))
      {
          cantidadstring ="0";
      }
       
        
        
        int cantidadstringint = Integer.parseInt(cantidadstring.toString());
        int cantidadint =  Integer.parseInt(cantidad);

        int nuevacantidadint = cantidadint;
        nuevacantidadstring =  String.valueOf(nuevacantidadint);
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + nuevacantidadstring + "' WHERE numero='" + numeroventa + "' and articulo = '" + ubicacion + "'      ");
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

        String numeroventa =  lbnumeroventa.getText();
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
        String estatusentregaventa = "";
        
        String SQL2 = "select cantidad,estatus_entrega from historial_ventas where numero = '" + numeroventa + "' and articulo = '" + ubicacion + "' ";
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
        
        
       regresaralaconeccionlocal();
   
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
                   botonesactivados = botonesactivados + 1; 
                } 
                
                
                if(pechoderecho==null || pechoderecho.equals("")||pechoderecho.equals(" ")||pechoderecho.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(mangaderecha==null || mangaderecha.equals("")||mangaderecha.equals(" ")||mangaderecha.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(mangaizquierda==null || mangaizquierda.equals("")||mangaizquierda.equals(" ")||mangaizquierda.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(espalda==null || espalda.equals("")||espalda.equals(" ")||espalda.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
            
                
                if(otraubicacion==null || otraubicacion.equals("")||otraubicacion.equals(" ")||otraubicacion.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
            
           if(otraubicacion2==null || otraubicacion2.equals("")||otraubicacion2.equals(" ")||otraubicacion2.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
           
           
                ////////////////////////////////////////////////////////////////
                
                 if(cantidadpechoizquierdo.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                } 
                
                
                if(cantidadpechoderecho.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                }
                
                if(cantidadmangaderecha.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
                if(cantidadmangaizquierda.equals("0"))
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
                if(cantidadespalda.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
            
                
                if(cantidadotraubicacion.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                }
            
           if(cantidadotraubicacion2.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                }
           
            
           
           if(tienecantidad == botonesactivados)
           {
               
             nuevoestatusorden = "realizada totalmente";
               
           }
         
           else
       
           {
               
               nuevoestatusorden = "realizada parcialmente";
            
           }   
               
               
               
               try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set estatus_orden='"+nuevoestatusorden+"',fecha = '"+dia()+"'  where numero='" + lborden.getText() + "' and prenda='" +prenda+ "'   ");
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
         
         
         
         
        regresaralaconeccionlocal();
         
         
         
         
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
        lbnumeroventa = new javax.swing.JLabel();
        btninsertarponchados = new javax.swing.JButton();
        lbtipo = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btneditarbordado = new javax.swing.JButton();
        cbsucursal = new javax.swing.JComboBox<>();
        btnverfotomontaje = new javax.swing.JButton();
        lbidentificador = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbbordacliente = new javax.swing.JLabel();
        btnmangaderecha = new javax.swing.JButton();
        btnmangaizquierda = new javax.swing.JButton();
        btnpechoderecho = new javax.swing.JButton();
        btnpechoizquierdo = new javax.swing.JButton();
        btnespalda = new javax.swing.JButton();
        btnotraubicacion = new javax.swing.JButton();
        btnotraubicacion2 = new javax.swing.JButton();
        lbltallas = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbnombrecomercial = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbventa = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
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
        lbmangaderechanombre = new javax.swing.JLabel();
        lbotraubicacion2nombre = new javax.swing.JLabel();
        lbotraubicacionnombre = new javax.swing.JLabel();
        lbespaldanombre = new javax.swing.JLabel();
        lbpechoizquierdonombre = new javax.swing.JLabel();
        lbpechoderechonombre = new javax.swing.JLabel();
        lbmangaizquierdanombre = new javax.swing.JLabel();
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
        btnotraubicacion2ponchado1 = new javax.swing.JButton();
        btnotraubicacionponchado1 = new javax.swing.JButton();
        btnespaldaponchado1 = new javax.swing.JButton();
        btnpechoizquierdoponchadoagregar = new javax.swing.JButton();
        btnpechoderechoponchadoagregar = new javax.swing.JButton();
        btnmangaizquierdaponchado1 = new javax.swing.JButton();
        btnmangaderechaponchado1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden camisa");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
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
        lbfotomontaje.setBounds(-10, 10, 1200, 690);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("No.Orden");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lborden.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
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

        lbnumeroventa.setText("00000000");

        btninsertarponchados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btninsertarponchados.setText("Replicar pnchados");
        btninsertarponchados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarponchadosActionPerformed(evt);
            }
        });

        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel22.setText("Sucursal:");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btneditarbordado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneditarbordado.setText("Editar bordado");
        btneditarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarbordadoActionPerformed(evt);
            }
        });

        cbsucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbsucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ninguna", "cdmxsur", "cdmxcentro", "guadalajara", "monterrey", "tijuana" }));

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
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
        jLabel17.setText("Dia entrega");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Bordacliente");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbordacliente.setForeground(new java.awt.Color(153, 0, 0));
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnmangaderecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaderecha.setText("Termine");
        btnmangaderecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechaActionPerformed(evt);
            }
        });

        btnmangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaizquierda.setText("Termine");
        btnmangaizquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdaActionPerformed(evt);
            }
        });

        btnpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoderecho.setText("Termine");
        btnpechoderecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechoActionPerformed(evt);
            }
        });

        btnpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoizquierdo.setText("Termine");
        btnpechoizquierdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdoActionPerformed(evt);
            }
        });

        btnespalda.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnespalda.setText("Termine");
        btnespalda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldaActionPerformed(evt);
            }
        });

        btnotraubicacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacion.setText("Termine");
        btnotraubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacionActionPerformed(evt);
            }
        });

        btnotraubicacion2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacion2.setText("Termine");
        btnotraubicacion2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacion2ActionPerformed(evt);
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
        jLabel1.setText("Puntos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Nombre comercial");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ubicación");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbventa.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Color");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Observacion");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Codigo");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
        jLabel6.setText("Numero de la otra sucursal");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumerodelaotrasucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumerodelaotrasucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel23.setText("Fecha de elaboración");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdiaentrega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdiaentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel20.setText("Hora");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
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

        lbmangaderechanombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbmangaderechanombre.setText("Manga derecha");
        lbmangaderechanombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacion2nombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbotraubicacion2nombre.setText("Otra ubicacion2");
        lbotraubicacion2nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacionnombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbotraubicacionnombre.setText("Otra ubicacion");
        lbotraubicacionnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbespaldanombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbespaldanombre.setText("Espalda");
        lbespaldanombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoizquierdonombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbpechoizquierdonombre.setText("Pecho Izquierdo");
        lbpechoizquierdonombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoderechonombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbpechoderechonombre.setText("Pecho Derecho");
        lbpechoderechonombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmangaizquierdanombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbmangaizquierdanombre.setText("Manga izquierda");
        lbmangaizquierdanombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnotraubicacion2ponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacion2ponchado1.setText("Ponchado");
        btnotraubicacion2ponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacion2ponchado1ActionPerformed(evt);
            }
        });

        btnotraubicacionponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnotraubicacionponchado1.setText("Ponchado");
        btnotraubicacionponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacionponchado1ActionPerformed(evt);
            }
        });

        btnespaldaponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnespaldaponchado1.setText("Ponchado");
        btnespaldaponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldaponchado1ActionPerformed(evt);
            }
        });

        btnpechoizquierdoponchadoagregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoizquierdoponchadoagregar.setText("Ponchado");
        btnpechoizquierdoponchadoagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdoponchadoagregarActionPerformed(evt);
            }
        });

        btnpechoderechoponchadoagregar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoderechoponchadoagregar.setText("Ponchado");
        btnpechoderechoponchadoagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechoponchadoagregarActionPerformed(evt);
            }
        });

        btnmangaizquierdaponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaizquierdaponchado1.setText("Ponchado");
        btnmangaizquierdaponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdaponchado1ActionPerformed(evt);
            }
        });

        btnmangaderechaponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnmangaderechaponchado1.setText("Ponchado");
        btnmangaderechaponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechaponchado1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lbventa, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btndatos)
                .addGap(17, 17, 17)
                .addComponent(lbnumeroventa)
                .addGap(4, 4, 4)
                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jLabel22)
                .addGap(11, 11, 11)
                .addComponent(cbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btninsertarponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btnfotomontajesinpuntadas)
                        .addGap(7, 7, 7)
                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbltallas, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbotraubicacion2nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btnotraubicacion2cancelar)
                                .addGap(5, 5, 5)
                                .addComponent(lbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnotraubicacion2ponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbpechoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lbpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnpechoizquierdoponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbpechoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lbpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnpechoderechoponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbmangaizquierdanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lbmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnmangaizquierdaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbmangaderechanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lbmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnmangaderechaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbespaldanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lbespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnespaldaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbotraubicacionnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lbotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnotraubicacionponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbotraubicacion2nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lbotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnotraubicacion2ponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(183, 183, 183)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbpechoizquierdonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(btnpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btnpechoizquierdocancelar)
                                        .addGap(5, 5, 5)
                                        .addComponent(lbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbpechoderechonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(btnpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btnpechoderechocancelar)
                                        .addGap(5, 5, 5)
                                        .addComponent(lbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbmangaizquierdanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(btnmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btnmangaizquierdacancelar)
                                        .addGap(5, 5, 5)
                                        .addComponent(lbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbmangaderechanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(btnmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btnmangaderechacancelar)
                                        .addGap(5, 5, 5)
                                        .addComponent(lbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbespaldanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(btnespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btnespaldacancelar)
                                        .addGap(5, 5, 5)
                                        .addComponent(lbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbotraubicacionnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(btnotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btnotraubicacioncancelar)
                                        .addGap(5, 5, 5)
                                        .addComponent(lbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnpechoizquierdoponchadoagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnpechoderechoponchadoagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnmangaizquierdaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnmangaderechaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnespaldaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnotraubicacionponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lbdiaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(243, 243, 243)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(390, 390, 390)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(7, 7, 7)
                                .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel16)
                                .addGap(7, 7, 7)
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addGap(7, 7, 7)
                                .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))))
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
                    .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnfotomontajesinpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbltallas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbpechoizquierdonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnpechoizquierdocancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnpechoderechocancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbpechoderechonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnpechoderechoponchadoagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnmangaizquierdaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbmangaizquierdanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnmangaizquierdacancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbmangaderechanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(btnmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(btnmangaderechacancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(lbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnmangaderechaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbespaldanombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnespaldacancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbotraubicacionnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnotraubicacioncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnotraubicacionponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addComponent(btnespaldaponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbotraubicacion2nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnotraubicacion2cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnotraubicacion2ponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(12, 12, 12)
                                .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbpechoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnpechoizquierdoponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lbpechoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnpechoderechoponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lbmangaizquierdanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnmangaizquierdaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(lbmangaderechanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnmangaderechaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(lbespaldanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(lbespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnespaldaponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnotraubicacionponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbotraubicacionnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnotraubicacion2ponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbotraubicacion2nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(btnpechoizquierdoponchadoagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbdiaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btninsertarponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
        
        
    if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
        
        nombredelatabla = "historial_ordenes_camisa";
        
     try {
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     codigocliente();
     
      cliente();
     
   
     
     try {    
            agregarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
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

    private void btnmangaizquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdaActionPerformed

        
          regresaralaconeccionlocal();
          fechaubicacion  = "manga_izquierda_fecha";
        
        
                
                                                
                                                
                                                
         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
 
            
            String ubicacion = "cantidad_manga_izquierda";
            String nombrebordado = mangaizquierdanombre;
            String cantidadaplicacion = aplicacionmangaizquierda;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadas((String) ubicacion);

              if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA IZQUIERDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA IZQUIERDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA IZQUIERDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA IZQUIERDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA IZQUIERDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA IZQUIERDA";

            }

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
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
            btnmangaizquierda.setEnabled(false);

        }
    }
 
 
 else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
 
         

                String ubicacion = "cantidad_manga_izquierda";
                String nombrebordado = mangaizquierdanombre;
                String cantidadaplicacion = aplicacionmangaizquierda;
                String cantidad = lbcantidad.getText();
                nombredelatabla = "historial_ordenes_camisa_recibidas";
                actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
                 
                if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA IZQUIERDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA IZQUIERDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA IZQUIERDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA IZQUIERDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA IZQUIERDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA IZQUIERDA";

            }

                agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
                estacompletalaorden();
                sumapuntos();
            
       
    
        }
        
        }
        
    }//GEN-LAST:event_btnmangaizquierdaActionPerformed

    private void btnpechoizquierdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdoActionPerformed

        
      regresaralaconeccionlocal();  
      fechaubicacion  = "pecho_izquierdo_fecha";
        
        
         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
      
            
           String ubicacion = "cantidad_pecho_izquierdo";
           String nombrebordado =pechoizquierdonombre;
           String cantidadaplicacion = aplicacionpechoizquierdo;
           String cantidad = lbcantidad.getText();
           nombredelatabla = "historial_ordenes_camisa";
           
           
           
           
           
           
           
           
           
           
           actualizarlascantidadesbordadas((String) ubicacion);  
           
           
           
           
           
           
           if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA PECHO IZQUIERDO";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA PECHO IZQUIERDO";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO IZQUIERDO";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA PECHO IZQUIERDO";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA PECHO IZQUIERDO";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO PECHO IZQUIERDO";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO PECHO IZQUIERDO";

            }

       agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
       agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;   
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

            rutapechoizquierdo =fl;
            btnpechoizquierdo.setEnabled(false);

        }
        }
    else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
   
            
            String ubicacion = "cantidad_pecho_izquierdo";
            String nombrebordado = pechoizquierdonombre;
            String cantidadaplicacion = aplicacionpechoizquierdo;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa_recibidas";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
           if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA PECHO IZQUIERDO";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA PECHO IZQUIERDO";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO IZQUIERDO";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA PECHO IZQUIERDO";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA PECHO IZQUIERDO";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO PECHO IZQUIERDO";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO PECHO IZQUIERDO";

            }

            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            sumapuntos();
            

        }
    
        }
    
    
    }//GEN-LAST:event_btnpechoizquierdoActionPerformed

    private void btnespaldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldaActionPerformed

        
        
        
          regresaralaconeccionlocal();
          fechaubicacion  = "espalda_fecha";
        
                  
         
                                                
                                                
        
        String cantidad = lbcantidad.getText();
        
        if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
      
            String ubicacion = "cantidad_espalda";
            String nombrebordado = espaldanombre;
            String cantidadaplicacion = aplicacionespalda;
           
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadas((String) ubicacion);

             if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA ESPALDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA ESPALDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE ESPALDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS ESPALDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA ESPALDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA ESPALDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO ESPALDA";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO ESPALDA";

            }

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
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
            btnespalda.setEnabled(false);

        }
        
        }
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            

            
            String ubicacion = "cantidad_espalda";
            String nombrebordado = espaldanombre;
            String cantidadaplicacion = aplicacionespalda;
           
            nombredelatabla = "historial_ordenes_camisa_recibidas";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
            if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA ESPALDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA ESPALDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE ESPALDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS ESPALDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA ESPALDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA ESPALDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO ESPALDA";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO ESPALDA";

            }
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            sumapuntos();
            
           
            
        }
        
        } 
    }//GEN-LAST:event_btnespaldaActionPerformed

    private void btnpechoderechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechoActionPerformed
     
        regresaralaconeccionlocal();
        fechaubicacion  = "pecho_derecho_fecha";
        
        
                                        
         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 

        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
     
            String ubicacion = "cantidad_pecho_derecho";
            String nombrebordado = pechoderechonombre;
            String cantidadaplicacion = aplicacionpechoderecho;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadas((String) ubicacion);

             if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA PECHO DERECHO";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA PECHO DERECHO";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO DERECHO";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO DERECHO";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA PECHO DERECHO";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA PECHO DERECHO";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO PECHO DERECHO";

            }
                else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO PECHO DERECHO";

            }

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
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
            btnpechoderecho.setEnabled(false);

        }
        
        
        }
        
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
     
            String ubicacion = "cantidad_pecho_derecho";
            String nombrebordado = pechoderechonombre;
            String cantidadaplicacion = aplicacionpechoderecho;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa_recibidas";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
                 if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA PECHO DERECHO";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA PECHO DERECHO";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO DERECHO";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO DERECHO";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA PECHO DERECHO";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA PECHO DERECHO";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO PECHO DERECHO";

            }
                else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO PECHO DERECHO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO PECHO DERECHO";

            }
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            sumapuntos();
            
        
       
        }
        
        }
        
    }//GEN-LAST:event_btnpechoderechoActionPerformed

    private void btnmangaderechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechaActionPerformed

        
         regresaralaconeccionlocal();
          fechaubicacion  = "manga_derecha_fecha";
        
                 
                        
                                        
                                        
        if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {    
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "cantidad_manga_derecha";
            String nombrebordado = mangaderechanombre;
            String cantidadaplicacion = aplicacionmangaderecha;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadas((String) ubicacion);

            if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA DERECHA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA DERECHA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA DERECHA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA DERECHA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA DERECHA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA DERECHA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA DERECHA";

            }

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
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
            btnmangaderecha.setEnabled(false);

        }
        
        
        }
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
       
            String ubicacion = "cantidad_manga_derecha";
            String nombrebordado = mangaderechanombre;
            String cantidadaplicacion = aplicacionmangaderecha;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa_recibidas";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
            if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA DERECHA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA DERECHA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA DERECHA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA DERECHA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA DERECHA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA DERECHA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA DERECHA";

            }
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            sumapuntos();  
            
            
        }
            
            
        }    
           
        btndatos.doClick();
        
    }//GEN-LAST:event_btnmangaderechaActionPerformed

    private void btninsertarponchadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarponchadosActionPerformed
       
        
       
       Object sucursalreplica =  cbsucursal.getSelectedItem();
        

        String tipo = lbtipo.getText();
        String numerosucursal = lbnumerodelaotrasucursal.getText();
        String prenda = lbprenda.getText();

        String path = "";
        Object tiendaalaquesereplicara = cbsucursal.getSelectedItem();
        String stringIP = "";
        String stringlocal = "";
        String stringBDlocal = "";

        String nombrearchivo1 = "";
        String nombrearchivo2 = "";
        String nombrearchivo3 = "";
        String nombrearchivo4 = "";
        String nombrearchivo5 = "";
        String nombrearchivo6 = "";
        
        
        if(!sucursalreplica.equals("ninguna"))
       
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
                stringlocal = str[1];
            }
        } catch (IOException e) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
        }

        Connection conn = null;

        iptraspaso = stringIP;
      

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
            conn = DriverManager.getConnection("jdbc:mysql://" + iptraspaso + "/" + sucursal + "", "root", "sistemas");

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
       
        
        
         //  codigocliente = lbcodigocliente.getText();
        String cliente = lbcliente.getText();
        String rutadelarchivo = "";
        String existe = "";
        prenda = lbprenda.getText();
       // String nombre = nombrebordado.getText().trim();
   
       
      
     //    String SQL = "SELECT imagen,extension_imagen FROM bordados_puntadas where nombre = '"+cliente+"' and tipo = '"+prenda+"' and numero_consecutivo = '"+consecutivobordado+"'  ";
        String sql = "SELECT imagen,extension_imagen FROM bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificador+"' and tipo = '"+prenda+"'   ";  ///
    
    
        try {
            
           
            Class.forName("com.mysql.jdbc.Driver");
           
         
            con = DriverManager.getConnection("jdbc:mysql://" + iptraspaso + "/" + sucursal + "", "root", "sistemas");
   
            
            
             try {
            
            Statement st1 = con.createStatement();
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
        
          
          } catch (Exception x) {
                               System.out.println(x); 
                            }
        
           
           

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
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Para ver el fotomontaje, primero debe de guardar puntadas","Error",JOptionPane.ERROR_MESSAGE);
        }
        
        
        //rommel
        
        regresaralaconeccionlocal();
        
        
        
        
        
    }//GEN-LAST:event_btnverfotomontajeActionPerformed

    private void btnotraubicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacionActionPerformed

        
          regresaralaconeccionlocal();
          fechaubicacion  = "otra_ubicacion_fecha";
        
               
         
                                        
                                        
        if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        

        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            

            
            if(btnotraubicacion.getText().equals("Cancelar"))
            {
                
                
            }
            else
            {
            String ubicacion = "cantidad_otra_ubicacion";
            String nombrebordado = otraubicacionnombre;
            String cantidadaplicacion = aplicacionotraubicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadas((String) ubicacion);

          if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION";

            }

            
          
            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
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
            btnotraubicacion.setEnabled(false);

        }
        
        }
         else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
     
            
            String ubicacion = "cantidad_otra_ubicacion";
            String nombrebordado = otraubicacionnombre;
            String cantidadaplicacion = aplicacionotraubicacion;
            nombredelatabla = "historial_ordenes_camisa_recibidas";
            String cantidad = lbcantidad.getText();
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
              if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION";

            }

            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            sumapuntos();
            
            
            
            
        }
        
        
        }
        
    }//GEN-LAST:event_btnotraubicacionActionPerformed

    private void btnotraubicacion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacion2ActionPerformed

        
         regresaralaconeccionlocal();
         fechaubicacion  = "otra_ubicacion2_fecha";
                                    
                                        
         
                                                
                                                
        if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
     
            String ubicacion = "cantidad_otra_ubicacion2";
            String nombrebordado = otraubicacion2nombre;
            String cantidadaplicacion = aplicacionotraubicacion2;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadas((String) ubicacion);
           
             if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION2";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION2";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION2";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION2";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION2";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION2";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION2";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION2";

            }

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
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
            btnotraubicacion.setEnabled(false);

        }
        
        }
        else
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
   

                String ubicacion = "cantidad_otra_ubicacion2";
                String nombrebordado = otraubicacion2nombre;
                String cantidadaplicacion = aplicacionotraubicacion2;
                String cantidad = lbcantidad.getText();
                nombredelatabla = "historial_ordenes_camisa_recibidas";
                actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
                  if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION2";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION2";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION2";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION2";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION2";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION2";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION2";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION2";

            }
                agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
                estacompletalaorden();
                sumapuntos();

            
            
        }
        
        }
    }//GEN-LAST:event_btnotraubicacion2ActionPerformed

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
                if(btnpechoizquierdo.getText().equals("Cancelar"))
                {
                    
                }
                else
                {    
                
                btnpechoizquierdo.doClick();
                
                }
            }
            else if(boton.equals("btnpechoderecho"))
            {
                if(btnpechoderecho.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnpechoderecho.doClick();
                }
            }
            else if(boton.equals("btnmangaizquierda"))
            {
                if(btnmangaizquierda.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnmangaizquierda.doClick();
                }
            }
            else if(boton.equals("btnmangaderecha"))
            {
                if(btnmangaderecha.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnmangaderecha.doClick();
                }
            }
            else if(boton.equals("btnespalda"))
            {
                if(btnespalda.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnespalda.doClick();
                }
            }
            else if(boton.equals("btnotraubicacion"))
            {
                if(btnotraubicacion.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnotraubicacion.doClick();
                }
            }
            else if(boton.equals("btnotraubicacion2"))
            {
                if(btnotraubicacion.getText().equals("Cancelar"))
                {
                    
                }
                else
                { 
                btnotraubicacion2.doClick();
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
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     codigocliente();
     
     cliente();
     
   
     
     try {    
            agregarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         
        if (sucursal.equals(cc))
         
         try {    
            agregarfotomontajeotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
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
           String nombrebordado =pechoizquierdonombre;
           String cantidadaplicacion = aplicacionpechoizquierdo;
           String cantidad = lbcantidad.getText();
           nombredelatabla = "historial_ordenes_camisa";
           actualizarlascantidadesbordadascancelar((String) ubicacion);  
           
          if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA PECHO IZQUIERDO";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA PECHO IZQUIERDO";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO IZQUIERDO";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA PECHO IZQUIERDO";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA PECHO IZQUIERDO";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO PECHO IZQUIERDO";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO PECHO IZQUIERDO " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO PECHO IZQUIERDO";

            }

       agregarexistenciabordadoscancelar((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
       agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad) ;   
       estacompletalaorden(); 
       sumapuntos();   
        
             
            
        }  
        
        
        
    }//GEN-LAST:event_btnpechoizquierdocancelarActionPerformed

    private void btnpechoderechocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechocancelarActionPerformed
      
        
        
                if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado pecho derecho?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                    String ubicacion = "cantidad_pecho_derecho";
                    String nombrebordado = pechoderechonombre;
                    String cantidadaplicacion = aplicacionpechoderecho;
                    String cantidad = lbcantidad.getText();
                    nombredelatabla = "historial_ordenes_camisa";
                    actualizarlascantidadesbordadascancelar((String) ubicacion);

                    if (prenda.toUpperCase().equals("CAMISA")) {

                        ubicacioninsertar = "BORDADO CAMISA PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION CAMISA PECHO DERECHO";

                    } //// playera
                    else if (prenda.toUpperCase().equals("PLAYERA")) {

                        ubicacioninsertar = "BORDADO PLAYERA PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION PLAYERA PECHO DERECHO";

                    } //// chamarra desmontable
                    else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                        ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE PECHO DERECHO";

                    } /// chamarra rompevientos
                    else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                        ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS PECHO DERECHO";

                    } ///camisola
                    else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                        ubicacioninsertar = "BORDADO CAMISOLA PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION CAMISOLA PECHO DERECHO";

                    } else if (prenda.toUpperCase().equals("FILIPINA")) {

                        ubicacioninsertar = "BORDADO FILIPINA PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION FILIPINA PECHO DERECHO";

                    } ///SACO
                    else if (prenda.toUpperCase().equals("SACO")) {

                        ubicacioninsertar = "BORDADO SACO PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION SACO PECHO DERECHO";

                    } else if (prenda.toUpperCase().equals("CHALECO")) {

                        ubicacioninsertar = "BORDADO CHALECO PECHO DERECHO " + nombrebordado + "";
                        aplicacioninsertar = "APLICACION CHALECO PECHO DERECHO";

                    }
                    agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
                    agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
                    estacompletalaorden();
                    sumapuntos();
            
        
        
        
            }
                 
                
                
                
    }//GEN-LAST:event_btnpechoderechocancelarActionPerformed

    private void btnmangaizquierdacancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdacancelarActionPerformed
      
        
        
            if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado manga izquierda?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
       
        
            String ubicacion = "cantidad_manga_izquierda";
            String nombrebordado = mangaizquierdanombre;
            String cantidadaplicacion = aplicacionmangaizquierda;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadascancelar((String) ubicacion);
            
              if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA IZQUIERDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA IZQUIERDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA IZQUIERDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA IZQUIERDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA IZQUIERDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO MANGA IZQUIERDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA IZQUIERDA";

            }

       agregarexistenciabordadoscancelar((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
       agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad) ;
       estacompletalaorden(); 
       sumapuntos(); 
       
        
                
            }
            
            
            
            
    }//GEN-LAST:event_btnmangaizquierdacancelarActionPerformed

    private void btnmangaderechacancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechacancelarActionPerformed
      
        
               if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de manga derecha?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                 {   

            String ubicacion = "cantidad_manga_derecha";
            String nombrebordado = mangaderechanombre;
            String cantidadaplicacion = aplicacionmangaderecha;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadascancelar((String) ubicacion);

             if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA MANGA DERECHA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA MANGA DERECHA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE MANGA DERECHA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS MANGA DERECHA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA MANGA DERECHA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA MANGA DERECHA";

            } ///SACO
          
            
            else
                
                if (prenda.toUpperCase().equals("SACO")) 
                
                {

                ubicacioninsertar = "BORDADO SACO MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA DERECHA";

            }
            
             
             
             
            
            agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
                 
            }
          
               
               
    }//GEN-LAST:event_btnmangaderechacancelarActionPerformed

    private void btnespaldacancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldacancelarActionPerformed
      
        
        if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado espalda?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        
            String ubicacion = "cantidad_espalda";
            String nombrebordado =espaldanombre;
           String cantidadaplicacion = aplicacionespalda;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadascancelar((String) ubicacion);
        
           nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadascancelar((String) ubicacion);
            
             if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA ESPALDA";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA ESPALDA";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE ESPALDA";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS ESPALDA";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA ESPALDA";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA ESPALDA";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO ESPALDA";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO ESPALDA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO ESPALDA";

            }

       agregarexistenciabordadoscancelar((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
       agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad) ;   
       estacompletalaorden();
       sumapuntos();       
            
        
        
        }
                
        
        
        
    }//GEN-LAST:event_btnespaldacancelarActionPerformed

    private void btnotraubicacioncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacioncancelarActionPerformed
       
        
        
                if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado otra ubicacion?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        
            String ubicacion = "cantidad_otra_ubicacion";
            String nombrebordado = otraubicacionnombre;
            String cantidadaplicacion = aplicacionotraubicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadascancelar((String) ubicacion);

            if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION";

            }
            else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO OTRA UBICACION " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION";

            }
            agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
            
        
        
        }
                
                
                
    }//GEN-LAST:event_btnotraubicacioncancelarActionPerformed

    private void btnotraubicacion2cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacion2cancelarActionPerformed
      
        
        
        
        
                   if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado otra ubicacion2?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        
            String ubicacion = "cantidad_otra_ubicacion2";
            String nombrebordado = otraubicacion2nombre;
            String cantidadaplicacion = aplicacionotraubicacion2;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_camisa";
            actualizarlascantidadesbordadascancelar((String) ubicacion);
           
            if (prenda.toUpperCase().equals("CAMISA")) {

                ubicacioninsertar = "BORDADO CAMISA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISA OTRA UBICACION2";

            } //// playera
            else if (prenda.toUpperCase().equals("PLAYERA")) {

                ubicacioninsertar = "BORDADO PLAYERA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION PLAYERA OTRA UBICACION2";

            } //// chamarra desmontable
            else if (prenda.toUpperCase().startsWith("CHAMARRA DESMONTABLE")) {

                ubicacioninsertar = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA DESMONTABLE OTRA UBICACION2";

            } /// chamarra rompevientos
            else if (prenda.toUpperCase().startsWith("CHAMARRA ROMPEVIENTOS")) {

                ubicacioninsertar = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHAMARRA ROMPEVIENTOS OTRA UBICACION2";

            } ///camisola
            else if (prenda.toUpperCase().startsWith("CAMISOLA")) {

                ubicacioninsertar = "BORDADO CAMISOLA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CAMISOLA OTRA UBICACION2";

            } else if (prenda.toUpperCase().equals("FILIPINA")) {

                ubicacioninsertar = "BORDADO FILIPINA OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION FILIPINA OTRA UBICACION2";

            } ///SACO
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO OTRA UBICACION2";

            }
             else if (prenda.toUpperCase().equals("CHALECO")) {

                ubicacioninsertar = "BORDADO CHALECO OTRA UBICACION2 " + nombrebordado + "";
                aplicacioninsertar = "APLICACION CHALECO OTRA UBICACION2";

            }

            agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
            
        
        
        
        }
                   
                   
                   
    }//GEN-LAST:event_btnotraubicacion2cancelarActionPerformed

    private void btnotraubicacion2ponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacion2ponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnotraubicacion2ponchado1ActionPerformed

    private void btnotraubicacionponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacionponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnotraubicacionponchado1ActionPerformed

    private void btnespaldaponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldaponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnespaldaponchado1ActionPerformed

    private void btnpechoizquierdoponchadoagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdoponchadoagregarActionPerformed
    
       


        JSystemFileChooser adjuntar = new JSystemFileChooser();
        String archivoextension ="";
        
        
        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            archivoextension= archivoelegido.getName();
            String fl = archivoelegido.toString();

            rutamangaderecha= fl;
            btnmangaderecha.setEnabled(false);

        }
        
        
        
        
    }//GEN-LAST:event_btnpechoizquierdoponchadoagregarActionPerformed

    private void btnpechoderechoponchadoagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechoponchadoagregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpechoderechoponchadoagregarActionPerformed

    private void btnmangaizquierdaponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdaponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmangaizquierdaponchado1ActionPerformed

    private void btnmangaderechaponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechaponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnmangaderechaponchado1ActionPerformed



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
            java.util.logging.Logger.getLogger(ordencamisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordencamisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordencamisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordencamisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordencamisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btndatos;
    private javax.swing.JButton btneditarbordado;
    private javax.swing.JButton btnespalda;
    private javax.swing.JButton btnespaldacancelar;
    private javax.swing.JButton btnespaldaponchado;
    private javax.swing.JButton btnespaldaponchado1;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    private javax.swing.JButton btninsertarponchados;
    private javax.swing.JButton btnmangaderecha;
    private javax.swing.JButton btnmangaderechacancelar;
    private javax.swing.JButton btnmangaderechaponchado;
    private javax.swing.JButton btnmangaderechaponchado1;
    private javax.swing.JButton btnmangaizquierda;
    private javax.swing.JButton btnmangaizquierdacancelar;
    private javax.swing.JButton btnmangaizquierdaponchado;
    private javax.swing.JButton btnmangaizquierdaponchado1;
    private javax.swing.JButton btnotraubicacion;
    private javax.swing.JButton btnotraubicacion2;
    private javax.swing.JButton btnotraubicacion2cancelar;
    private javax.swing.JButton btnotraubicacion2ponchado;
    private javax.swing.JButton btnotraubicacion2ponchado1;
    private javax.swing.JButton btnotraubicacioncancelar;
    private javax.swing.JButton btnotraubicacionponchado;
    private javax.swing.JButton btnotraubicacionponchado1;
    private javax.swing.JButton btnpechoderecho;
    private javax.swing.JButton btnpechoderechocancelar;
    private javax.swing.JButton btnpechoderechoponchado;
    private javax.swing.JButton btnpechoderechoponchadoagregar;
    private javax.swing.JButton btnpechoizquierdo;
    private javax.swing.JButton btnpechoizquierdocancelar;
    private javax.swing.JButton btnpechoizquierdoponchado;
    private javax.swing.JButton btnpechoizquierdoponchadoagregar;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JComboBox<String> cbsucursal;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JLabel lbbordacliente;
    public static javax.swing.JLabel lbcantidad;
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
    public static javax.swing.JLabel lbespaldanombre;
    public static javax.swing.JLabel lbespaldanombre1;
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
    public static javax.swing.JLabel lbmangaderechanombre;
    public static javax.swing.JLabel lbmangaderechanombre1;
    public javax.swing.JLabel lbmangaizquierda;
    public static javax.swing.JLabel lbmangaizquierdanombre;
    public static javax.swing.JLabel lbmangaizquierdanombre1;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumerodelaotrasucursal;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    public javax.swing.JLabel lbotraubicacion;
    public javax.swing.JLabel lbotraubicacion2;
    public static javax.swing.JLabel lbotraubicacion2nombre;
    public static javax.swing.JLabel lbotraubicacion2nombre1;
    public static javax.swing.JLabel lbotraubicacionnombre;
    public static javax.swing.JLabel lbotraubicacionnombre1;
    public javax.swing.JLabel lbpechoderecho;
    public static javax.swing.JLabel lbpechoderechonombre;
    public static javax.swing.JLabel lbpechoderechonombre1;
    public javax.swing.JLabel lbpechoizquierdo;
    public static javax.swing.JLabel lbpechoizquierdonombre;
    public static javax.swing.JLabel lbpechoizquierdonombre1;
    public static javax.swing.JLabel lbprenda;
    public static javax.swing.JLabel lbsucursal;
    public javax.swing.JLabel lbsumapuntos;
    public static javax.swing.JLabel lbtipo;
    public static javax.swing.JLabel lbventa;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
