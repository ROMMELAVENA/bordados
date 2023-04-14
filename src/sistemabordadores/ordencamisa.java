package sistemabordadores;

import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Desktop;
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
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class ordencamisa extends javax.swing.JFrame {

    public static boolean ventanaordencamisaanteriores = false;
    public static String ordenbordadocamisa = "";
    

    String bordadosdisponiblesstring = "0";
    int bordadosdisponiblesint = 0;
    String cantidadprendasstring = "";
    int cantidadprendasint = 0;

    int remanentebordadosint = 0;
    String remanentebordadosstring = "";
    int nuevoremanentebordadosint = 0;
    String nuevoremanentebordadossstring = "";

    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;

    String nuevosbordadosutilizadosstring = "";
    int nuevosbordadosutilizadosint = 0;

    String primero = "";
    String ultimo = "";

    int traspaso = 0;
    String iptraspaso = "";
    String tienda_traspaso = "";

    String numerosucursal = "";
    String sucursal = "";
    String numerosolicitoarticulos = "";
    String tiendasolicitoarticulos = "";

    String numeroordenenvio = "";
    String tiendaordenenvio = "";
    String tiendalocal = "";
    String codigocliente = "";
    String lugardondesebordara = "";
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
    String tiendaenvia = "";
    String terminetodo = "";
    
    String identificadordeprenda = "";
    
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

    

    public ordencamisa() 
    {
        initComponents();
        ventanaordencamisaanteriores = true;

        lbnumeroventa.setVisible(false);
        lbtipo.setVisible(false);

        btnterminetodo.setEnabled(false);
        btndatos.setVisible(false);
        
        
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
        else if(tiendalocal.equals("tijuana"))
        {
            rutadedondeestanlosbordados = "C:\\Users\\Mostrador DFNorte\\OneDrive\\PONCHADOS\\TIJUANA\\PONCHADOS SINCRONIZADOS";
        }
        else if(tiendalocal.equals("monterrey"))
        {
            rutadedondeestanlosbordados = "C:\\onedrive\\PONCHADOS\\MONTERREY\\PONCHADOS";
        }
        
        
        combohilo(); 
        

    }

    void combohilo() 
    {

        
        String color = "";
        String hilo = "";
        String hiloconcolor = "";
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo3 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo4 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo5 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo6 = new DefaultComboBoxModel();
        
        
        try {
           

            String sql = "SELECT distinct hilo,color  FROM catalogo_materiales where descripcion like 'HILO CODIGO%'ORDER BY hilo";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {

                modelo.addElement(rs.getObject("hilo"));
                modelo1.addElement(rs.getObject("hilo"));
                modelo2.addElement(rs.getObject("hilo"));
                modelo3.addElement(rs.getObject("hilo"));
                modelo4.addElement(rs.getObject("hilo"));
                modelo5.addElement(rs.getObject("hilo"));
                modelo6.addElement(rs.getObject("hilo"));
                
                
                hilo = rs.getString("hilo");
                color  = rs.getString("color");
                hiloconcolor = hilo.concat(color);
                
                listahilos.add(hiloconcolor);
                
                
                

            }
            
            
          

            cbhilo1.setModel(modelo);
            AutoCompleteDecorator.decorate(cbhilo1);
            cbhilo1.addItem("0");
            cbhilo1.setSelectedItem("0");

            cbhilo2.setModel(modelo1);
            AutoCompleteDecorator.decorate(cbhilo2);
            cbhilo2.addItem("0");
            cbhilo2.setSelectedItem("0");
            
            cbhilo3.setModel(modelo2);
            AutoCompleteDecorator.decorate(cbhilo3);
            cbhilo3.addItem("0");
            cbhilo3.setSelectedItem("0");

            cbhilo4.setModel(modelo3);
            AutoCompleteDecorator.decorate(cbhilo4);
            cbhilo4.addItem("0");
            cbhilo4.setSelectedItem("0");
  

            cbhilo5.setModel(modelo4);
            AutoCompleteDecorator.decorate(cbhilo5);
            cbhilo5.addItem("0");
            cbhilo5.setSelectedItem("0");

            cbhilo6.setModel(modelo5);
            AutoCompleteDecorator.decorate(cbhilo6);
            cbhilo6.addItem("0");
            cbhilo6.setSelectedItem("0");

            cbhilo7.setModel(modelo6);
            AutoCompleteDecorator.decorate(cbhilo7);
            cbhilo7.addItem("0");
            cbhilo7.setSelectedItem("0");

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
     void datoscolorido()
    {
        
        
        
        String sql = "SELECT color1,color2,color3,color4,color5,color6,color7,color8,color9,color10,color11,color12,color13,color14,color15,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,hilo8,hilo9,hilo10,hilo11,hilo12,hilo13,hilo14,hilo15 FROM colorido_bordados where nombre_bordado = '"+lbidentificadordeprenda.getText()+"' and codigo = '"+codigocliente+"' AND nombre = '"+lbcliente.getText()+"' ";


            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                        cbhilo1.setSelectedItem(rs.getString("hilo1"));
                        cbhilo2.setSelectedItem(rs.getString("hilo2"));
                        cbhilo3.setSelectedItem(rs.getString("hilo3"));
                        cbhilo4.setSelectedItem(rs.getString("hilo4"));
                        cbhilo5.setSelectedItem(rs.getString("hilo5"));
                        cbhilo6.setSelectedItem(rs.getString("hilo6"));
                        cbhilo7.setSelectedItem(rs.getString("hilo7"));
                        
                       
                        lbcolor1.setText(rs.getString("color1"));
                        lbcolor2.setText(rs.getString("color2"));
                        lbcolor3.setText(rs.getString("color3"));
                        lbcolor4.setText(rs.getString("color4"));
                        lbcolor5.setText(rs.getString("color5"));
                        lbcolor6.setText(rs.getString("color6"));
                        lbcolor7.setText(rs.getString("color7"));
                        
                        
                        
                         
                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        
        
    }
    
    
    void datos() throws IOException {

        
        
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
                + "   lugar,estatus_orden,nombre_concepto,tienda,estatus_orden,tienda from historial_ordenes_camisa where numero = '" + numerodeorden + "' ";

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
                identificadordeprenda = rs.getString("nombre_concepto");
                lbidentificadordeprenda.setText(identificadordeprenda);
                lugardondesebordara = rs.getString("lugar");

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
                

                mangaderechanombre = rs.getString("manga_derecha_nombre");
                Object mangaderecha = rs.getString("manga_derecha");
                lbmangaderecha.setText(rs.getString("manga_derecha"));
                if (mangaderecha == null | mangaderecha.equals("")) 
                {

                    btnmangaderecha.setEnabled(false);
                    botonhabilitado1 = "no";
                   

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
                  

                }
                 else
                {
                     btnterminetodo.setEnabled(true);
                }
                

                pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre");
                Object pechoizquierdo = rs.getString("pecho_izquierdo");
                
                lbpechoizquierdo.setText(rs.getString("pecho_izquierdo"));
                if (pechoizquierdo == null | pechoizquierdo.equals("")) {

                    btnpechoizquierdo.setEnabled(false);
                    botonhabilitado4 = "no";
                 
                    
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
                
                
                if(lugardondesebordara.equals("Esta sucursal"))
                {
                
                    
                    btninsertarponchados.setEnabled(false);
                    cbsucursal.setEnabled(false);
                
                
                //// pecho izquierdo    
                    
                if(cantidadpechoizquiedo.equals("0") && botonhabilitado4.equals("si") )
                {
                   btnpechoizquierdo.setEnabled(true);
                   btnpechoizquierdo.setText("Pecho Izquierdo");
                    btnpechoizquierdo.setForeground(Color.green.darker());
                   if(botonhabilitado4.equals("si"))
                   {
                   listabotones.add("btnpechoizquierdo");
                   }
                  
                }
                else
                {
                    
                     if(botonhabilitado4.equals("si"))
                   {
                     btnpechoizquierdo.setEnabled(true);
                     btnpechoizquierdo.setText("Cancelar"); 
                     btnpechoizquierdo.setForeground(Color.red);
                     

                     
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
                   btnpechoderecho.setText("Pecho derecho");
                   btnpechoderecho.setForeground(Color.green.darker());
                   if(botonhabilitado3.equals("si"))
                   {
                   listabotones.add("btnpechoderecho");
                   
                   }
                  
                }
                else
                {
                    
                     if(botonhabilitado3.equals("si"))
                   {
                       btnpechoderecho.setEnabled(true);
                       btnpechoderecho.setText("Cancelar");
                        btnpechoderecho.setForeground(Color.red);
                    
                   }
                   else
                   {
                     btnpechoderecho.setEnabled(false);
                   }
               
                } 
                
                
                if(cantidadmangaizquierda.equals("0")  && botonhabilitado2.equals("si") )
                {
                   btnmangaizquierda.setEnabled(true);
                   btnmangaizquierda.setText("Manga izquierda");
                    btnmangaizquierda.setForeground(Color.green.darker());
                   if(botonhabilitado2.equals("si"))
                   {
                   listabotones.add("btnmangaizquierda");
                   }
                  
                }
                else
                {
                    
                   if(botonhabilitado2.equals("si"))
                   {
                       btnmangaizquierda.setEnabled(true);
                       btnmangaizquierda.setText("Cancelar");
                       btnmangaizquierda.setForeground(Color.red);
                   
                   }
                   else
                   {
                       
                       btnmangaizquierda.setEnabled(false);
                    
                   }
                } 
                
                
                
                    
                if(cantidadmangaderecha.equals("0")  && botonhabilitado1.equals("si") )
                {
                   btnmangaderecha.setEnabled(true);
                   btnmangaderecha.setText("Manga Derecha");
                   btnmangaderecha.setForeground(Color.green.darker());
                    if(botonhabilitado1.equals("si"))
                   {
                   listabotones.add("btnmangaderecha");
                   }
                   
                   
                   
                }
                else
                {
                    
                     if(botonhabilitado1.equals("si"))
                   {
                    btnmangaderecha.setEnabled(true);
                    btnmangaderecha.setText("Cancelar");
                    btnmangaderecha.setForeground(Color.red);
                    
                   }
                   else
                   {
                    btnmangaderecha.setEnabled(false);
                   }
                } 
                
                
                if(cantidadespalda.equals("0")  && botonhabilitado5.equals("si") )
                {
                   btnespalda.setEnabled(true);
                   btnespalda.setText("Espalda");
                   btnespalda.setForeground(Color.green.darker());
                   if(botonhabilitado5.equals("si"))
                   {
                   listabotones.add("btnespalda");
                   }
                  
                   
                }
                else
                {
                    
                   if(botonhabilitado5.equals("si"))
                   {
                    btnespalda.setEnabled(false);
                    btnespalda.setText("Cancelar");
                    btnespalda.setForeground(Color.red);
                   }
                   else
                   {
                     btnespalda.setEnabled(false);
                   }    
                    
                    
                } 
                
                
                if(cantidadotraubicacion.equals("0")  && botonhabilitado6.equals("si") )
                {
                   btnotraubicacion.setEnabled(true);
                   btnotraubicacion.setText("Otra ubicacion");
                   btnotraubicacion.setForeground(Color.green.darker());
                   if(botonhabilitado6.equals("si"))
                   {
                   listabotones.add("btnotraubicacion");
                   }
                   
                   
                }
                else
                {
                    
                    if(botonhabilitado6.equals("si"))
                   {
                    btnotraubicacion.setEnabled(true);
                    btnotraubicacion.setText("Cancelar");
                    btnotraubicacion.setForeground(Color.red);
                   }
                   else
                   {
                    btnotraubicacion.setEnabled(false);
                   }
                } 
                
                if(cantidadotraubicacion2.equals("0")  && botonhabilitado7.equals("si") )
                {
                   btnotraubicacion2.setEnabled(true);
                   btnotraubicacion2.setText("Otra ubicacion2");
                   btnotraubicacion2.setForeground(Color.green.darker());
                   if(botonhabilitado7.equals("si"))
                   {
                       listabotones.add("btnotraubicacion2");
                   }
                  
                   
                }
                else
                {
                    
                     if(botonhabilitado7.equals("si"))
                   {
                    btnotraubicacion2.setEnabled(true);
                    btnotraubicacion2.setText("Cancelar");
                    btnotraubicacion2.setForeground(Color.red);
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
        
        String sql = "Select fecha,hora,cliente,cantidad,cantidad,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,fecha_entrega,hora_entrega,observacion,\n"
                + "pecho_izquierdo,pecho_derecho,manga_izquierda,manga_derecha,espalda,otra_ubicacion,otra_ubicacion2,\n"
                + "cantidad_pecho_izquierdo,cantidad_pecho_derecho,cantidad_manga_izquierda,cantidad_manga_derecha,cantidad_espalda,\n"
                + "pecho_izquierdo_nombre,pecho_derecho_nombre,manga_izquierda_nombre,manga_derecha_nombre,espalda_nombre,\n"
                + "otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion2,otra_ubicacion2_nombre,\n"
                + "aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2,\n"
                + "aplicacion_pecho_izquierdo_color,aplicacion_pecho_derecho_color,aplicacion_manga_izquierda_color,aplicacion_manga_derecha_color,aplicacion_espalda_color,aplicacion_otra_ubicacion_color,aplicacion_otra_ubicacion2_color,\n"
                + "lugar,estatus_orden,numero_sucursal_orden,tienda,numero_sucursal  from historial_ordenes_camisa_recibidas where numero = '" + numerodeorden + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));
                lbprenda.setText(rs.getString("prenda"));
                prenda = (rs.getString("prenda"));
                lbfecha.setText(rs.getString("fecha"));
                lbnumerodelaotrasucursal.setText(rs.getString("numero_sucursal_orden"));
                numerosucursal = rs.getString("numero_sucursal");
                tiendaenvia = rs.getString("tienda");
                
                
                
                

                mangaderechanombre = rs.getString("manga_derecha_nombre");
                Object mangaderecha = rs.getString("manga_derecha");
                lbmangaderechanombre.setText(mangaderechanombre);
                lbmangaderecha.setText(rs.getString("manga_derecha"));
                if (mangaderecha == null || mangaderecha.equals("") || mangaderecha.equals("ninguno")) {

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

               
                lugardondesebordara = rs.getString("lugar");

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
                  
                   if(botonhabilitado4.equals("si"))
                   {
                   listabotones.add("btnpechoizquierdo");
                   btnterminetodo.setEnabled(true);
                   }
                   
                }
                else
                {
                    btnpechoizquierdo.setEnabled(false);
                   
                } 
                
               
                
                if(cantidadpechoderecho.equals("0")  && botonhabilitado3.equals("si") )
                {
                   btnpechoderecho.setEnabled(true);
                   if(botonhabilitado3.equals("si"))
                   {
                   listabotones.add("btnpechoderecho");
                   btnterminetodo.setEnabled(true);
                   
                   }
                  
                }
                else
                {
                    btnpechoderecho.setEnabled(false);
                   
                } 
                
                
                if(cantidadmangaizquierda.equals("0")  && botonhabilitado2.equals("si") )
                {
                   btnmangaizquierda.setEnabled(true);
                   if(botonhabilitado2.equals("si"))
                   {
                   listabotones.add("btnmangaizquierda");
                   btnterminetodo.setEnabled(true);
                   }
                  
                }
                else
                {
                    btnmangaizquierda.setEnabled(false);
                   
                } 
                    
                if(cantidadmangaderecha.equals("0")  && botonhabilitado1.equals("si") )
                {
                   btnmangaderecha.setEnabled(true);
                    if(botonhabilitado1.equals("si"))
                   {
                   listabotones.add("btnmangaderecha");
                   btnterminetodo.setEnabled(true);
                   }
                   
                   
                   
                }
                else
                {
                    btnmangaderecha.setEnabled(false);
                    
                } 
                
                
                if(cantidadespalda.equals("0")  && botonhabilitado5.equals("si") )
                {
                   btnespalda.setEnabled(true);
                   if(botonhabilitado5.equals("si"))
                   {
                   listabotones.add("btnespalda");
                   btnterminetodo.setEnabled(true);
                   }
                 
                   
                }
                else
                {
                    btnespalda.setEnabled(false);
                    
                } 
                
                
                

                    


            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
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
        
        String numero = lbnumerodelaotrasucursal.getText();
        String numeroventa = lbnumeroventa.getText();
        String prenda =lbprenda.getText().toUpperCase();
        identificadordeprenda =lbidentificadordeprenda.getText();
        BufferedImage img = null;
        
        String prendasql ="";
        String prendanombresql="";
        String puntadasenfotomontajes = "";
        btnverfotomontaje.setEnabled(false);
        
       

       String sql = "Select extension_imagen,imagen,numero_consecutivo,fotomontaje_con_puntadas from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_bordado= '"+identificadordeprenda+"' and tipo = '"+prenda+"'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                puntadasenfotomontajes=rs.getString("fotomontaje_con_puntadas");
                Blob blob = rs.getBlob("imagen");
                if (blob == null) 
                {

                    ordencamisaimagencontorno p = new ordencamisaimagencontorno();
                    jPanel1.add(p);
                    jPanel1.repaint();
                    lblImagen.setVisible(false);
                    btnverfotomontaje.setEnabled(false);
                    tienefotomontaje = "no";
              
                    
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje o marcarle a Rommel para que les corrija elpara poder iniciar el bordado y registrar puntos");
                    
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
                    lblImagen.setIcon(new ImageIcon(img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
                    lblImagen.setVisible(true);
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
        
        
        
        if(puntadasenfotomontajes.equals("si"))
        {

            btnmangaderecha.setEnabled(false);
            btnmangaizquierda.setEnabled(false);
            btnpechoderecho.setEnabled(false);
            btnpechoizquierdo.setEnabled(false);
            btnespalda.setEnabled(false);
            btnotraubicacion.setEnabled(false);
            btnotraubicacion2.setEnabled(false);
            
            
       
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar nuevo fotomontaje SIN PUNTADAS");
            btnfotomontajesinpuntadas.setEnabled(true);
            btnterminetodo.setEnabled(false);
            
        
        }
       else if(tienefotomontaje.equals("no"))
        
        {
            btnmangaderecha.setEnabled(false);
            btnmangaizquierda.setEnabled(false);
            btnpechoderecho.setEnabled(false);
            btnpechoizquierdo.setEnabled(false);
            btnespalda.setEnabled(false);
            btnotraubicacion.setEnabled(false);
            btnotraubicacion2.setEnabled(false);
            
            ordencamisaimagencontorno p = new ordencamisaimagencontorno();
            jPanel1.add(p);
            jPanel1.repaint();
            lblImagen.setVisible(false);
            btnverfotomontaje.setEnabled(false);
       
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
             btnfotomontajesinpuntadas.setEnabled(false);
             btnterminetodo.setEnabled(false);
        }  

        
        
    }

     void agregarfotomontajeotrasucursal() throws FileNotFoundException, IOException  
    {
        
        String numero = lborden.getText();
        String prenda =lbprenda.getText();
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);
        
        String cliente = "";
        String numeroordensucursal = "";
        String numeroventa = "";
        
        
        if (tiendaenvia.equals(tiendalocal))
            
        {
            
      
        numerodeorden = lborden.getText();
        
        String sql1 = "Select numero_sucursal_orden from historial_ordenes_camisa_recibidas where numero = '" + numerodeorden + "' and numero_sucursal = '"+numerosucursal+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql1);
            if (rs.next())
            {

                numeroordensucursal = rs.getString("numero_sucursal_orden");
                
                
                String sql2 = "Select numero_venta from historial_ordenes_envio_solicitadas where numero = '" + numeroordensucursal + "' ";

        try {
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            if (rs2.next())
            {

                numeroventa = rs2.getString("numero_venta");
               
                

            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }   
               
                

            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }
        
        
      
 
                
             
                
        
      

        String sql7 = "Select cliente,prenda,tienda,nombre_concepto from historial_ordenes_camisa where numero = '" + numerosucursal + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql7);
            if (rs.next()) {

                cliente = rs.getString("cliente");
                lbprenda.setText(rs.getString("prenda"));
                prenda = (rs.getString("prenda"));
                sucursal = rs.getString("tienda");
                identificadordeprenda = rs.getString("nombre_concepto");
                

            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }

            
            cliente();
            
            
            
            
      //   numero = lbnumerodelaotrasucursal.getText();
      //  String numeroventa = lbnumeroventa.getText();
      //  prenda =lbprenda.getText().toUpperCase();
      //  identificadordeprenda =lbidentificadordeprenda.getText();
       
        
     //   String prendasql ="";
      //  String prendanombresql="";
     //   btnverfotomontaje.setEnabled(false);
        
       

       String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_bordado= '"+identificadordeprenda+"' and tipo = '"+prenda+"'   ";  ///

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
                    lblImagen.setVisible(false);
                    btnverfotomontaje.setEnabled(false);
                    tienefotomontaje = "no";
              
                    
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje o marcarle a Rommel para que les corrija elpara poder iniciar el bordado y registrar puntos");
                    
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
                    lblImagen.setIcon(new ImageIcon(img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
                    lblImagen.setVisible(true);
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
            
            ordencamisaimagencontorno p = new ordencamisaimagencontorno();
            jPanel1.add(p);
            jPanel1.repaint();
            lblImagen.setVisible(false);
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
                    lblImagen.setIcon(new ImageIcon(img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
                    lblImagen.setVisible(true);
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
            lblImagen.setVisible(false);
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
            datos();
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
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    void actualizarlascantidadesbordadasotrasucursal(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set "+ubicacion+"='" + lbcantidad.getText() + "',fecha = '"+dia()+"'  where numero = '"+lborden.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
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
        
       
        
        //// bordado
        String InsertarSQL = "INSERT INTO historial_bordados_existencia(numero,dia,hora,articulo,concepto,cantidad,numero_sucursal,sucursal) VALUES (?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            
                
 
                pst.setString(1, lbnumeroventa.getText());
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, ubicacioninsertar);
                pst.setString(5, lbidentificadordeprenda.getText());
                pst.setString(6, lbcantidad.getText());
                
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
                pst.setString(5, lbidentificadordeprenda.getText());
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
                pst.setString(2, tiendaenvia);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, ubicacioninsertar);
                pst.setString(6, lbidentificadordeprenda.getText());
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
                pst.setString(2, tiendaenvia);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, ubicacioninsertar);
                pst.setString(6, lbidentificadordeprenda.getText());
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
        
        String cantidad = "0";
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
               try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set estatus_orden='realizada',fecha = '"+dia()+"'  where numero='" + lborden.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                 
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                }
               
           }


        }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
    
   

     void verfotomontajerecibido()
    {
        
        String cliente = lbcliente.getText();
        String tipo = lbprenda.getText();
        String prenda =lbprenda.getText().toUpperCase();
        String prendafotomontaje = "";
        String nombreprendafotomontaje = "";
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
        
          String sql = "SELECT nombre_comercial,identificador,codigo FROM catalogo_clientes WHERE nombre = '" + cliente + "' ";

                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {

                        
                      
                        lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                        lbidentificador.setText(rs.getString("identificador"));
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
        lblImagen = new javax.swing.JLabel();
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
        lbidentificadordeprenda = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
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
        lbcantidad1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        btnterminetodo = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        lbprenda = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbnumerodelaotrasucursal = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbdiaentrega = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbhoraentrega = new javax.swing.JLabel();
        cbhilo1 = new javax.swing.JComboBox();
        cbhilo2 = new javax.swing.JComboBox();
        cbhilo3 = new javax.swing.JComboBox();
        cbhilo5 = new javax.swing.JComboBox();
        cbhilo4 = new javax.swing.JComboBox();
        cbhilo6 = new javax.swing.JComboBox();
        cbhilo7 = new javax.swing.JComboBox();
        btnvercolorido = new javax.swing.JButton();
        lbcolor1 = new javax.swing.JLabel();
        lbcolor2 = new javax.swing.JLabel();
        lbcolor3 = new javax.swing.JLabel();
        lbcolor4 = new javax.swing.JLabel();
        lbcolor5 = new javax.swing.JLabel();
        lbcolor6 = new javax.swing.JLabel();
        lbcolor7 = new javax.swing.JLabel();
        btndatos = new javax.swing.JButton();
        lbmangaderecha = new javax.swing.JLabel();
        lbmangaderechanombre = new javax.swing.JLabel();
        lbmangaizquierda = new javax.swing.JLabel();
        lbmangaizquierdanombre = new javax.swing.JLabel();
        lbpechoderechonombre = new javax.swing.JLabel();
        lbpechoderecho = new javax.swing.JLabel();
        lbpechoizquierdonombre = new javax.swing.JLabel();
        lbpechoizquierdo = new javax.swing.JLabel();
        lbespalda = new javax.swing.JLabel();
        lbespaldanombre = new javax.swing.JLabel();
        lbotraubicacionnombre = new javax.swing.JLabel();
        lbotraubicacion = new javax.swing.JLabel();
        lbotraubicacion2nombre = new javax.swing.JLabel();
        lbotraubicacion2 = new javax.swing.JLabel();
        btnfotomontajesinpuntadas = new javax.swing.JButton();

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

        lblImagen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setToolTipText("");
        lblImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblImagen);
        lblImagen.setBounds(0, 10, 820, 640);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel13.setText("No.Orden");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lborden.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lborden.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel16.setText("Cliente");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroventa.setText("00000000");

        btninsertarponchados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btninsertarponchados.setText("Replicar Fotomontajes y Ponchados");
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
        cbsucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cdmxsur", "cdmxcentro", "guadalajara", "monterrey", "tijuana" }));
        cbsucursal.setSelectedIndex(-1);

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        lbidentificadordeprenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbidentificadordeprenda.setForeground(new java.awt.Color(153, 0, 0));
        lbidentificadordeprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setText("Cantidad");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfecha.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbfecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel17.setText("Dia entrega");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel18.setText("Identificador");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnmangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnmangaderecha.setText("Manga Derecha");
        btnmangaderecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechaActionPerformed(evt);
            }
        });

        btnmangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnmangaizquierda.setText("Manga izquierda");
        btnmangaizquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdaActionPerformed(evt);
            }
        });

        btnpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnpechoderecho.setText("Pecho derecho");
        btnpechoderecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechoActionPerformed(evt);
            }
        });

        btnpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnpechoizquierdo.setText("Pecho Izquierdo");
        btnpechoizquierdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdoActionPerformed(evt);
            }
        });

        btnespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnespalda.setText("Espalda");
        btnespalda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldaActionPerformed(evt);
            }
        });

        btnotraubicacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnotraubicacion.setText("Otra ubicacion");
        btnotraubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnotraubicacionActionPerformed(evt);
            }
        });

        btnotraubicacion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnotraubicacion2.setText("Otra ubicacion2");
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

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Puntos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel19.setText("Nombre comercial");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ubicación");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Color");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
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

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbprenda.setForeground(new java.awt.Color(153, 0, 0));
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

        lbdiaentrega.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbdiaentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setText("Hora");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbhoraentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbhilo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo1.setToolTipText("");
        cbhilo1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo1PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo2.setToolTipText("");
        cbhilo2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo2PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo3.setToolTipText("");
        cbhilo3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo3PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo5.setToolTipText("");
        cbhilo5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo5PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo4.setToolTipText("");
        cbhilo4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo4PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo6.setToolTipText("");
        cbhilo6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo6PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo7.setToolTipText("");
        cbhilo7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo7PopupMenuWillBecomeVisible(evt);
            }
        });

        btnvercolorido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnvercolorido.setText("Ver colorido");
        btnvercolorido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvercoloridoActionPerformed(evt);
            }
        });

        lbcolor1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndatos.setText("datos");
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
            }
        });

        lbmangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbmangaderecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmangaderechanombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbmangaderechanombre.setForeground(new java.awt.Color(153, 0, 0));
        lbmangaderechanombre.setText("Manga derecha");
        lbmangaderechanombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbmangaizquierda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmangaizquierdanombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbmangaizquierdanombre.setForeground(new java.awt.Color(153, 0, 0));
        lbmangaizquierdanombre.setText("Manga izquierda");
        lbmangaizquierdanombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoderechonombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoderechonombre.setForeground(new java.awt.Color(153, 0, 0));
        lbpechoderechonombre.setText("Pecho Derecho");
        lbpechoderechonombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoizquierdonombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoizquierdonombre.setForeground(new java.awt.Color(153, 0, 0));
        lbpechoizquierdonombre.setText("Pecho Izquierdo");
        lbpechoizquierdonombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbespalda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbespaldanombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbespaldanombre.setForeground(new java.awt.Color(153, 0, 0));
        lbespaldanombre.setText("Espalda");
        lbespaldanombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacionnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbotraubicacionnombre.setForeground(new java.awt.Color(153, 0, 0));
        lbotraubicacionnombre.setText("Otra ubicacion");
        lbotraubicacionnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbotraubicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacion2nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbotraubicacion2nombre.setForeground(new java.awt.Color(153, 0, 0));
        lbotraubicacion2nombre.setText("Otra ubicacion2");
        lbotraubicacion2nombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbotraubicacion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbotraubicacion2.setForeground(new java.awt.Color(255, 0, 0));
        lbotraubicacion2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnfotomontajesinpuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnfotomontajesinpuntadas.setText("Fotomontaje sin puntadas");
        btnfotomontajesinpuntadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfotomontajesinpuntadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbnumeroventa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel22)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btninsertarponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66))
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbdiaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(12, 12, 12)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(23, 23, 23)
                            .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addComponent(btndatos)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btnfotomontajesinpuntadas))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(7, 7, 7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbotraubicacionnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbespaldanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbpechoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbmangaizquierdanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbmangaderechanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbpechoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbotraubicacion2nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(23, 23, 23)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbpechoizquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbpechoderecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbmangaderecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbmangaizquierda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbespalda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbotraubicacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbltallas, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(27, 27, 27)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(30, 30, 30)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lbcolor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbcolor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbcolor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbcolor4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbcolor5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbcolor6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbcolor7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(169, 169, 169)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jSeparator1))
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel18)
                                    .addGap(7, 7, 7)
                                    .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(22, 22, 22)
                                    .addComponent(jLabel16)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 592, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(46, 46, 46)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbdiaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnfotomontajesinpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(lbltallas, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btnpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(btnespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(4, 4, 4)
                                        .addComponent(cbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(7, 7, 7)
                                        .addComponent(cbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13)
                                .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbmangaderechanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbmangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbmangaizquierdanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbmangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbpechoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbpechoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbespaldanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbotraubicacionnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbotraubicacion2nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btndatos)
                            .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 655, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btninsertarponchados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22))
                        .addComponent(lbfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbtipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
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
         if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
        {
            ordenesporrealizar.btnactualizar.doClick();
        }

        this.dispose();

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordencamisaanteriores = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
   
    if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
        
        nombredelatabla = "historial_ordenes_camisa";
        
     try {
            datos();
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
         
         
         
        
         
         try {    
            agregarfotomontajeotrasucursal();
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
        
    }//GEN-LAST:event_formWindowOpened

    private void btnmangaizquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdaActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
        
            if(btnmangaizquierda.getText().equals("Cancelar"))
            {
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
        }
            else
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
            
       
        }
 else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
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
 else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
            int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="manga_derecha_ponchado";
                String ubicacionnombre ="manga_derecha_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
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
        
        }
        
    }//GEN-LAST:event_btnmangaizquierdaActionPerformed

    private void btnpechoizquierdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdoActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
            
            
            if(btnpechoizquierdo.getText().equals("Cancelar"))
            {
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
            }
            else
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
            
        }
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
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
    else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
             int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="pecho_izquierdo_ponchado";
                String ubicacionnombre ="pecho_izquierdo_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
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
    
        }
    
    
    }//GEN-LAST:event_btnpechoizquierdoActionPerformed

    private void btnespaldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldaActionPerformed

        if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
            if(btnespalda.getText().equals("Cancelar"))
            {
                
                  if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado espalda?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        
            String ubicacion = "cantidad_espalda";
            String nombrebordado =espaldanombre;
           String cantidadaplicacion = aplicacionespalda;
           String cantidad = lbcantidad.getText();
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
                
            }
            else
            {
            String ubicacion = "cantidad_espalda";
            String nombrebordado = espaldanombre;
            String cantidadaplicacion = aplicacionespalda;
            String cantidad = lbcantidad.getText();
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
        }
         else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
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
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
            int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="espalda_ponchado";
                String ubicacionnombre ="espalda_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
            {
            
            String ubicacion = "cantidad_espalda";
            String nombrebordado = espaldanombre;
            String cantidadaplicacion = aplicacionespalda;
            String cantidad = lbcantidad.getText();
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
        
        } 
    }//GEN-LAST:event_btnespaldaActionPerformed

    private void btnpechoderechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechoActionPerformed
     
         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 

        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
          if( btnpechoderecho.getText().equals("Cancelar") )
            {
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
                       
            }
            else
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
          }///
            
        }
         else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
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
        
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="pecho_derecho_ponchado";
                String ubicacionnombre ="pecho_derecho_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
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
        
        }
        
    }//GEN-LAST:event_btnpechoderechoActionPerformed

    private void btnmangaderechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechaActionPerformed

        if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {    
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
            if(btnmangaderecha.getText().equals("Cancelar"))
            {
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
            else if (prenda.toUpperCase().equals("SACO")) {

                ubicacioninsertar = "BORDADO SACO MANGA DERECHA " + nombrebordado + "";
                aplicacioninsertar = "APLICACION SACO MANGA DERECHA";

            }
            
            
            agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            sumapuntos();
                 
            }
            
                
            }   
            else
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
            
        }
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
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
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
             int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="manga_derecha_ponchado";
                String ubicacionnombre ="manga_derecha_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
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
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");
        }

        Connection conn = null;

        iptraspaso = stringIP;
        tienda_traspaso = stringlocal;

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
            conn = DriverManager.getConnection("jdbc:mysql://" + iptraspaso + "/" + tienda_traspaso + "", "root", "sistemas");

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
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set manga_izquierda_ponchado_nombre='" + nombrearchivo1 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
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
                 
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set pecho_izquierdo_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input2);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                 
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");

                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set pecho_izquierdo_ponchado_nombre='" + nombrearchivo2 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
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
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set espalda_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input3);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set espalda_ponchado_nombre='" + nombrearchivo3 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
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
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set manga_derecha_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input4);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set manga_derecha_ponchado_nombre='" + nombrearchivo4 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
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
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set pecho_derecho_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input5);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                  
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set pecho_derecho_ponchado_nombre='" + nombrearchivo5 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                  
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
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
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set imagen=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input6);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set imagen_nombre='" + nombrearchivo6 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                 
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
                }
                
                
                
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");
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
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");
            }

            ordenesporrealizar.btnactualizar.doClick();

        }
        else
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden NO SE INSERTO correctamente en la otra sucursal"); 
        }  

        this.dispose();
        
        }

    }//GEN-LAST:event_btninsertarponchadosActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventanaordencamisaanteriores = false;
    }//GEN-LAST:event_formWindowClosed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed
       
        
        String cliente = lbcliente.getText();
        String tipo = lbprenda.getText();
        String prenda =lbprenda.getText().toUpperCase();
        identificadordeprenda =lbidentificadordeprenda.getText();
        String prendafotomontaje = "";
        String nombreprendafotomontaje = "";
        String rutadelarchivo = "";
        String existe = "";
        
        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_bordado= '"+identificadordeprenda+"' and tipo = '"+prenda+"'   ";

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

                JOptionPane.showMessageDialog(null, "No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+e+"");
               
            }
        
        } 

    }//GEN-LAST:event_btnverfotomontajeActionPerformed

    private void btnotraubicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacionActionPerformed

        if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        

        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            

            
            if(btnotraubicacion.getText().equals("Cancelar"))
            {
                
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
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
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
         else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
             int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="otra_ubicacion_ponchado";
                String ubicacionnombre ="otra_ubicacion_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
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
        
        
        }
        
    }//GEN-LAST:event_btnotraubicacionActionPerformed

    private void btnotraubicacion2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnotraubicacion2ActionPerformed
       
        if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            if(btnotraubicacion2.getText().equals("Cancelar"))
            {
            
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
                
            }
            else
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
            
        }
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
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
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
            int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");

            if (respuesta == JOptionPane.YES_OPTION) {
                String ubicacion = "otra_ubicacion2_ponchado";
                String ubicacionnombre = "otra_ubicacion2_ponchado_nombre";

                descargarponchado((String) ubicacion, (String) ubicacionnombre);

            } else if (respuesta == JOptionPane.NO_OPTION) {

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
        
        }
    }//GEN-LAST:event_btnotraubicacion2ActionPerformed

    private void lbltallasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbltallasMouseClicked
        if (evt.getClickCount() == 2) 
        {

            if (lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local")) 
            {
            }
            else if (lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida")) 
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
         
    }//GEN-LAST:event_btnterminetodoActionPerformed

    private void btneditarbordadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarbordadoActionPerformed

        
        
        
         String prendacombo = lbprenda.getText();
         prendacombo = prendacombo.toUpperCase();
      
        
        
          if (bordadosdelclienteeditarnuevo.ventanabordadosdelclienteeditarnuevo) 
              
          {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La ventana de bordados de cliente ya está abierta");
          }
          else
              
          {
              
              
          
           
        bordadosdelclienteeditarnuevo ventana = new bordadosdelclienteeditarnuevo();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
        
        
        bordadosdelclienteeditarnuevo.lbcliente.setText(lbcliente.getText());
        bordadosdelclienteeditarnuevo.lbnombrecomercial.setText(lbnombrecomercial.getText());
        bordadosdelclienteeditarnuevo.lbidentificador.setText(lbidentificador.getText());
        bordadosdelclienteeditarnuevo.lbcodigocliente.setText(codigocliente);
        bordadosdelclienteeditarnuevo.lbconsecutivo.setText(consecutivo);
        bordadosdelclienteeditarnuevo.txtidentificadordeprenda.setText(identificadordeprenda);
       
       
           bordadosdelclienteeditarnuevo.lbprenda.setText(prendacombo);
          
    }
       
        
        
    }//GEN-LAST:event_btneditarbordadoActionPerformed

    private void cbhilo1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo1PopupMenuWillBecomeInvisible

        String hilo = cbhilo1.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor1.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor1.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo1.setSelectedItem(hilo1seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor1.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo1PopupMenuWillBecomeInvisible

    private void cbhilo1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo1PopupMenuWillBecomeVisible

        hilo1seleccionado = cbhilo1.getSelectedItem().toString();
        color1seleccionado = lbcolor1.getText();

    }//GEN-LAST:event_cbhilo1PopupMenuWillBecomeVisible

    private void cbhilo2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo2PopupMenuWillBecomeInvisible

        String hilo = cbhilo2.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor2.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo ="ninguno";
                        }
                        

                        if (!colorencombo.equals("ninguno")  )

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor2.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo2.setSelectedItem(hilo2seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor2.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo2PopupMenuWillBecomeInvisible

    private void cbhilo2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo2PopupMenuWillBecomeVisible

        hilo2seleccionado = cbhilo2.getSelectedItem().toString();
        color2seleccionado = lbcolor2.getText();

    }//GEN-LAST:event_cbhilo2PopupMenuWillBecomeVisible

    private void cbhilo3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo3PopupMenuWillBecomeInvisible

        String hilo = cbhilo3.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor3.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor3.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo3.setSelectedItem(hilo3seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor3.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo3PopupMenuWillBecomeInvisible

    private void cbhilo3PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo3PopupMenuWillBecomeVisible

        hilo3seleccionado = cbhilo3.getSelectedItem().toString();
        color3seleccionado = lbcolor3.getText();

    }//GEN-LAST:event_cbhilo3PopupMenuWillBecomeVisible

    private void cbhilo5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo5PopupMenuWillBecomeInvisible

        String hilo = cbhilo5.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor5.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor5.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo5.setSelectedItem(hilo5seleccionado);

                                }
                            }

                        }
                        else
                        {

                           lbcolor5.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo5PopupMenuWillBecomeInvisible

    private void cbhilo5PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo5PopupMenuWillBecomeVisible

        hilo5seleccionado = cbhilo5.getSelectedItem().toString();
        color5seleccionado = lbcolor5.getText();

    }//GEN-LAST:event_cbhilo5PopupMenuWillBecomeVisible

    private void cbhilo4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo4PopupMenuWillBecomeInvisible

        String hilo = cbhilo4.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor4.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor4.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo4.setSelectedItem(hilo4seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor4.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo4PopupMenuWillBecomeInvisible

    private void cbhilo4PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo4PopupMenuWillBecomeVisible

        hilo4seleccionado = cbhilo4.getSelectedItem().toString();
        color4seleccionado = lbcolor4.getText();

    }//GEN-LAST:event_cbhilo4PopupMenuWillBecomeVisible

    private void cbhilo6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo6PopupMenuWillBecomeInvisible

        String hilo = cbhilo6.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor6.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor6.setText(colorsinhilo);

                                }
                                else
                                {

                                    lbcolor6.setText(hilo6seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor6.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo6PopupMenuWillBecomeInvisible

    private void cbhilo6PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo6PopupMenuWillBecomeVisible

        hilo6seleccionado = cbhilo6.getSelectedItem().toString();
        color6seleccionado = lbcolor6.getText();

    }//GEN-LAST:event_cbhilo6PopupMenuWillBecomeVisible

    private void cbhilo7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo7PopupMenuWillBecomeInvisible

        String hilo = cbhilo7.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor7.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor7.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo7.setSelectedItem(hilo7seleccionado);

                                }
                            }

                        }
                        else
                        {

                           lbcolor7.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo7PopupMenuWillBecomeInvisible

    private void cbhilo7PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo7PopupMenuWillBecomeVisible

        hilo7seleccionado = cbhilo7.getSelectedItem().toString();
        color7seleccionado = lbcolor7.getText();

    }//GEN-LAST:event_cbhilo7PopupMenuWillBecomeVisible

    private void btnvercoloridoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvercoloridoActionPerformed
       
    if(colorido.ventanacolorido ==true)
    {
        
    }
    else
    {
        colorido ventana =  new colorido();
        colorido.lbcliente.setText(lbcliente.getText());
        colorido.lbcodigo.setText(codigocliente);
        colorido.lbnombrebordado.setText(lbidentificadordeprenda.getText());
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
    }    
           
    }//GEN-LAST:event_btnvercoloridoActionPerformed

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed
        if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
        
        nombredelatabla = "historial_ordenes_camisa";
        
     try {
            datos();
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

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigocliente+"' and nombre_bordado = '"+identificadordeprenda+"' and tipo = '"+lbprenda.getText()+"' and numero_consecutivo = '"+consecutivo+"' ";

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
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"',puntadas_en_fotomontajes ='no' where codigo='"+codigocliente+"' and nombre_bordado = '"+identificadordeprenda+"' and tipo = '"+lbprenda.getText()+"' and numero_consecutivo = '"+consecutivo+"' ");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
            ImageIcon fot = new ImageIcon(rutaarchivo);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT));
            lblImagen.setIcon(icono);
            this.repaint();
            
            btndatos.doClick();
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Fotomontaje agregado correctamente");
            

        }
        
        
    }//GEN-LAST:event_btnfotomontajesinpuntadasActionPerformed



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
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneditarbordado;
    private javax.swing.JButton btnespalda;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    private javax.swing.JButton btninsertarponchados;
    private javax.swing.JButton btnmangaderecha;
    private javax.swing.JButton btnmangaizquierda;
    private javax.swing.JButton btnotraubicacion;
    private javax.swing.JButton btnotraubicacion2;
    private javax.swing.JButton btnpechoderecho;
    private javax.swing.JButton btnpechoizquierdo;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JComboBox cbhilo1;
    private javax.swing.JComboBox cbhilo2;
    private javax.swing.JComboBox cbhilo3;
    private javax.swing.JComboBox cbhilo4;
    private javax.swing.JComboBox cbhilo5;
    private javax.swing.JComboBox cbhilo6;
    private javax.swing.JComboBox cbhilo7;
    private javax.swing.JComboBox<String> cbsucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JLabel lbcantidad;
    public static javax.swing.JLabel lbcantidad1;
    public static javax.swing.JLabel lbcliente;
    public javax.swing.JLabel lbcolor1;
    public javax.swing.JLabel lbcolor2;
    public javax.swing.JLabel lbcolor3;
    public javax.swing.JLabel lbcolor4;
    public javax.swing.JLabel lbcolor5;
    public javax.swing.JLabel lbcolor6;
    public javax.swing.JLabel lbcolor7;
    public static javax.swing.JLabel lbdiaentrega;
    public static javax.swing.JLabel lbespalda;
    public static javax.swing.JLabel lbespaldanombre;
    public static javax.swing.JLabel lbfecha;
    public static javax.swing.JLabel lbhoraentrega;
    public static javax.swing.JLabel lbidentificador;
    private javax.swing.JLabel lbidentificadordeprenda;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lbltallas;
    public static javax.swing.JLabel lbmangaderecha;
    public static javax.swing.JLabel lbmangaderechanombre;
    public static javax.swing.JLabel lbmangaizquierda;
    public static javax.swing.JLabel lbmangaizquierdanombre;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumerodelaotrasucursal;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    public static javax.swing.JLabel lbotraubicacion;
    public static javax.swing.JLabel lbotraubicacion2;
    public static javax.swing.JLabel lbotraubicacion2nombre;
    public static javax.swing.JLabel lbotraubicacionnombre;
    public static javax.swing.JLabel lbpechoderecho;
    public static javax.swing.JLabel lbpechoderechonombre;
    public static javax.swing.JLabel lbpechoizquierdo;
    public static javax.swing.JLabel lbpechoizquierdonombre;
    public static javax.swing.JLabel lbprenda;
    public javax.swing.JLabel lbsumapuntos;
    public static javax.swing.JLabel lbtipo;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
