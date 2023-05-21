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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ordenpantalon extends javax.swing.JFrame {

    public static boolean ventanaordenpantalonanteriores = false;
    public static String ordenbordadopantalon = "";
    
    
    int traspaso = 0;
    String iptraspaso = "";
    String tienda_traspaso = "";
    String latiendaestaconectada = "si";
    Connection con = null;
     String numerosucursal = "";

    String cantidadprendasstring = "";
    int cantidadprendasint = 0;

    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;

    String primero = "";
    String ultimo = "";
    
    String numeropedido = "";
    String tiendaalaqueselesolicito = "";
    String lugardondesebordara = "";
    
    ///
    String ubicacioninsertar = "";
    String aplicacioninsertar = "";
    
    String ladoizquierdofrentenombre = "";
    String ladoderechofrentenombre = "";
    String ladoizquierdoatrasnombre = "";
    String ladoderechoatrasnombre = "";
 
    
    String rutaimagen="";
    String rutaladoizquierdofrente="";
    String rutaladoizquierdoatras="";
    String rutaladoderechofrente="";
    String rutaladoderechoatras ="";
    String rutaarchivo = "";
    String nombrearchivo = "";
    String codigocliente ="";
    String tienefotomontaje ="";
    
    public static String enquesucursalsebordara = "";
    public static String tipotabla = "";
    String terminetodo ="";
    ArrayList<String> listabotones = new ArrayList<String>();
    String nombredelatabla ="";
    String tiendaenvia = "";
    
    
    String identificadordeprenda = "";
    String consecutivo = "";
    String tieneunaobservacion = ""; 
    
    String tienenumerodesucursal = "";
    String numerosucursalordenpantalon = "";
    String sucursal = "";
    String tiendalocal = "";
    String rutadedondeestanlosbordados ="";
    

    private PreparedStatement pst;

    public ordenpantalon()
    {
        initComponents();
        ventanaordenpantalonanteriores = true;
        
        btnterminetodo.setEnabled(false);
        btndatos.setEnabled(false);
       
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
        
        
    }

    void datosOrdenesLocales() throws FileNotFoundException, IOException
    {
        
        String folio = lbfolio.getText();
        String numeroventa ="";
        
        String prendasql = "";
        String prendanombresql="";
        String prenda ="";
         BufferedImage img = null;
        
      
        
        String activadoladoizquierdofrente ="";
        String activadoladoizquierdoatras ="";
        String activadoladoderechofrente ="";
        String activadoladoderechoatras ="";


        

        String sql = "Select fecha,hora,cliente,numero_venta,estatus_orden,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,lado_izquierdo_frente,lado_derecho_frente,lado_izquierdo_atras,lado_derecho_atras,cantidad_lado_izquierdo_frente,cantidad_lado_derecho_frente,cantidad_lado_izquierdo_atras,cantidad_lado_derecho_atras,lado_izquierdo_frente_puntadas,lado_derecho_frente_puntadas,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas,lugar,identificador_prenda,numero_orden from historial_ordenes_pantalon where numero = '" + folio + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));
                lbnumeroventa.setText(rs.getString("numero_venta"));
                numeroventa = rs.getString("numero_venta");
                prenda = rs.getString("prenda");
                
                numerosucursalordenpantalon=rs.getString("numero_orden");
                sucursal="ninguno"; //rs.getString("tienda");
                
                 if(numerosucursalordenpantalon ==null  || numerosucursalordenpantalon.equals("") ||numerosucursalordenpantalon.equals(" ") )
                {
                    tienenumerodesucursal ="no";
                }
                else
                {
                    tienenumerodesucursal ="si";
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

                
                
                ladoizquierdofrentenombre = rs.getString("lado_izquierdo_frente");
                ladoderechofrentenombre = rs.getString("lado_derecho_frente");
                ladoizquierdoatrasnombre = rs.getString("lado_izquierdo_atras");
                ladoderechoatrasnombre = rs.getString("lado_derecho_atras");
                identificadordeprenda = rs.getString("identificador_prenda");
                lbidentificadordeprenda.setText(identificadordeprenda);
                lugardondesebordara = rs.getString("lugar");
                lbcantidad.setText(rs.getString("cantidad"));
                
                        
                lbladoizquierdofrente.setText(rs.getString("lado_izquierdo_frente"));
                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente");
                if (ladoizquierdofrente == null || ladoizquierdofrente.equals("")) 
                {
                    
                  btnladoizquierdofrente.setEnabled(false);

                } else {

                   
                    String b = rs.getString("lado_izquierdo_frente_puntadas");
                    lbladoizquierdofrentepuntadas.setText(rs.getString("lado_izquierdo_frente_puntadas"));
                    btnladoizquierdofrente.setEnabled(true);
                    btnladoizquierdofrente.setText("Lado Izquierdo Frente");
                    btnladoizquierdofrente.setForeground(Color.green.darker());
                    activadoladoizquierdofrente ="si";
                    
                    
                    
                }

                
                /// lado derecho frente
                
                lbladoderechofrente.setText(rs.getString("lado_derecho_frente"));
                String ladoderechofrente = rs.getString("lado_derecho_frente");

                if (ladoderechofrente == null || ladoderechofrente.equals("")) 
                {
                    btnladoderechofrente.setEnabled(false);
                } 
                else
                {

                    lbladoderechofrentepuntadas.setText(rs.getString("lado_derecho_frente_puntadas"));
                    btnladoderechofrente.setEnabled(true);
                    btnladoderechofrente.setText("Lado Derecho Frente");
                    btnladoderechofrente.setForeground(Color.green.darker());
                    activadoladoderechofrente ="si";
                   
                    
                   
                    
                }

                lbdadoizquierdoatras.setText(rs.getString("lado_izquierdo_atras"));
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras");
                if (ladoizquierdoatras == null || ladoizquierdoatras.equals(""))
                {
                    btnladoizquierdoatras.setEnabled(false);
                } 
                else 
                {


                    lbladoizquierdoatraspuntadas.setText(rs.getString("lado_izquierdo_atras_puntadas"));
                    btnladoizquierdoatras.setEnabled(true);
                    activadoladoizquierdoatras ="si";
                    btnladoizquierdoatras.setText("Lado Izquierdo Atras");
                    btnladoizquierdoatras.setForeground(Color.green.darker());
                   
                    
                }

                lbladoderechoatras.setText(rs.getString("lado_derecho_atras"));
                String ladoderechoatras = rs.getString("lado_derecho_atras");
                if (ladoderechoatras == null || ladoderechoatras.equals("")) 
                {
                     btnladoderechoatras.setEnabled(false);
                }
                else 
                {


                   
                    lbladoderechoatraspuntadas.setText(rs.getString("lado_derecho_atras_puntadas"));
                    btnladoderechoatras.setEnabled(true);
                    btnladoderechoatras.setText("Lado Derecho Atras");
                    btnladoderechoatras.setForeground(Color.green.darker());
                    activadoladoderechoatras ="si";
                    
                   
                    
                }
                
                
              
                
                if(lugardondesebordara.equals("Esta sucursal"))
                {
                    
                  
                
                String cantidadladoizquierdofrente = rs.getString("cantidad_lado_izquierdo_frente");
                if(cantidadladoizquierdofrente.equals("0") && activadoladoizquierdofrente.equals("si"))
                {
                    btnladoizquierdofrente.setEnabled(true);
                    listabotones.add("btnladoizquierdofrente");
                }
                else
                {
                    if( activadoladoizquierdofrente.equals("si"))
                    {
                    btnladoizquierdofrente.setText("Cancelar");
                     btnladoizquierdofrente.setForeground(Color.red.darker());
                    }
                   
                }    
                
                
                String cantidadladoderechofrente = rs.getString("cantidad_lado_derecho_frente");
                if(cantidadladoizquierdofrente.equals("0")&& activadoladoderechofrente.equals("si"))
                {
                   btnladoderechofrente.setEnabled(true);
                   listabotones.add("btnladoderechofrente");
                }
                else
                {
                   if( activadoladoderechofrente.equals("si"))
                   {
                   btnladoderechofrente.setText("Cancelar");
                   btnladoderechofrente.setForeground(Color.red.darker());
                   }
                
                
                } 
                
                
                String cantidadladoizquierdoatras = rs.getString("cantidad_lado_izquierdo_atras");
                if(cantidadladoizquierdoatras.equals("0") && activadoladoizquierdoatras.equals("si"))
                {
                    btnladoizquierdoatras.setEnabled(true);
                    listabotones.add("btnladoizquierdoatras");
                }
                else
                {
                    if( activadoladoizquierdoatras.equals("si"))
                   {
                    btnladoizquierdoatras.setText("Cancelar");
                    btnladoizquierdoatras.setForeground(Color.red.darker());
                   }
                
                } 
                
                
                String cantidadladoderechoatras = rs.getString("cantidad_lado_derecho_atras");
                if(cantidadladoderechoatras.equals("0")&& activadoladoderechoatras.equals("si"))
                {
                    btnladoderechoatras.setEnabled(true);
                    listabotones.add("btnladoderechoatras");
                }
                else
                {
                    if( activadoladoderechoatras.equals("si"))
                   {
                    btnladoderechoatras.setText("Cancelar");
                    btnladoderechoatras.setForeground(Color.red.darker());
                   } 
                }
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

        } catch (SQLException ex) {
           
           
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
         String sqlcodigo = "Select codigo_cliente from historial_ventas where numero = '" + numeroventa + "'  ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcodigo);
            if (rs.next()) 
            {

                codigocliente = rs.getString("codigo_cliente");
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);

        }         

        datostienda();
        agregarfotomontaje();

    }
    
    
     void datostienda() {
        /// busca las ordenes de pantalon generadas 

        String numero = lbnumeroventa.getText();
        String pedirarticulos = "";
        String ordenenvio = "";
        String sql2 = "Select solicito_articulos, enviada_ordenenvio from historial_ventas where numero = '" + numero + "' ";

        try {
            PreparedStatement prst = cn.prepareStatement(sql2);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                
                pedirarticulos = rs.getString("solicito_articulos");
                ordenenvio = rs.getString("enviada_ordenenvio");

            }
        } catch (Exception exx) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+exx+"");

        }

        if (pedirarticulos.equals("si")) {
            String sql3 = "Select numero,sucursal from historial_pedidos_sucursal_solicitados where numventa = '" + numero + "' and estatus_entrega = 'Por confirmar' ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
                    numeropedido = rs.getString("numero");
                    tiendaalaqueselesolicito = rs.getString("sucursal");
                   
                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+exx+"");

            }

        } else {
            if (ordenenvio.equals("si")) {

                String sql3 = "Select numero,sucursal from historial_ordenes_envio_solicitadas where numero_venta = '" + numero + "' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {
                        numeropedido = rs.getString("numero");
                        tiendaalaqueselesolicito = rs.getString("sucursal");
                       
                    }
                } catch (Exception exx) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+exx+"");

                }

            }
        }
        
        
        lbtiendareplica.setText(tiendaalaqueselesolicito);

    }
    
     
     
     
     
     /*
      void agregarfotomontajeotrasucursal() throws FileNotFoundException, IOException  
    {
        
        String numero = lbfolio.getText();
        String prenda = "Pantalon";
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);
        
        
        if (tiendaenvia.equals(tiendalocal))
            
        {
            
      
        numerosucursal = lbnumerosucursal.getText();
        

        String sql7 = "Select prenda,tienda,identificador_prenda from historial_ordenes_pantalon where numero = '" + numerosucursal + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql7);
            if (rs.next()) {

              
          
                prenda = (rs.getString("prenda"));
                sucursal = rs.getString("tienda");
                identificadordeprenda = rs.getString("identificador_prenda");
                

            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }

            
            cliente();
            
            
       String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificadordeprenda+"' and tipo = '"+prenda+"'   ";  ///

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
           
           
            lbfotomontaje.setVisible(false);
            btnverfotomontaje.setEnabled(false);
       
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
            
        }  

        
            
            
            
            
            
        }
        else
            
        {
            
            
            sdsd
            
        

       String sql = "Select imagen_nombre,imagen from historial_ordenes_pantalon_recibidas where numero = '"+numero+"'  and prenda = '"+prenda+"'   ";  ///

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
          /*  btnmangaderecha.setEnabled(false);
            btnmangaizquierda.setEnabled(false);
            btnpechoderecho.setEnabled(false);
            btnpechoizquierdo.setEnabled(false);
            btnespalda.setEnabled(false);
            btnotraubicacion.setEnabled(false);
            btnotraubicacion2.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");

            
            
            
         
            lbfotomontaje.setVisible(false);
            btnverfotomontaje.setEnabled(false);
          

            
            
        }  

        
        }
        
        
    }

    
     */
     
     
     
     
     
 
    void hilosycolor()
    {
       
     

        String sql = "Select hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,color1,color2,color3,color4,color5,color6,color7,numero_consecutivo from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificadordeprenda+"' and tipo = 'PANTALON'   ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next()) 
            {
                Object hilo1 = rs1.getString("hilo1");
                Object hilo2 = rs1.getString("hilo2");
                Object hilo3 = rs1.getString("hilo3");
                Object hilo4 = rs1.getString("hilo4");
               
                
                
                
                
                Object codigo1 = rs1.getString("color1");
                Object codigo2 = rs1.getString("color2");
                Object codigo3 = rs1.getString("color3");
                Object codigo4 = rs1.getString("color4");
             
                
                
                consecutivo = rs1.getString("numero_consecutivo");
                
                if(codigo1.equals("ninguno"))
                {
                   
                }
                else
                {
                  lbcolormangaderecha.setText(codigo1.toString());
                  lbcodigoladoderechofrente.setText(hilo1.toString());
                }  
                
                if(codigo2.equals("ninguno"))
                {
                  
                }
                else
                {
                  lbcolormangaizquierda.setText(codigo2.toString());
                  lbcodigoladoderechoatras.setText(hilo2.toString());
                }  
                
                 if(codigo3.equals("ninguno"))
                {
                  
                }
                else
                {
                  lbcolorpechoderecho.setText(codigo3.toString());
                  lbcodigoladoizquierdofrente.setText(hilo3.toString());
                }  
                
                if(codigo4.equals("ninguno"))
                {
                  
                }
                else
                {
                  lbcolorpechoizquierdo.setText(codigo4.toString());
                  lbcodigoladoizquierdoatras.setText(hilo4.toString());
                }    
                
             
                
                    
                
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
    }
    
    
    
    
    
    
    
    
     void agregarfotomontaje() throws FileNotFoundException, IOException  
    {
        
      
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);
        String puntadasenfotomontajes = "";

       String sql = "Select extension_imagen,imagen,numero_consecutivo,puntadas_en_fotomontajes from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificadordeprenda+"' and tipo = 'PANTALON'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                 puntadasenfotomontajes=rs.getString("puntadas_en_fotomontajes");
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
                      
                      JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");

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
                     rutaimagen = "C://archivospdf/fotomontaje."+nombredelarchivo+" ";   
                    }
                    else
                    {   
                    rutaimagen = "C://archivospdf/"+nombredelarchivo+" ";
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
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        /*
        
        if(puntadasenfotomontajes.equals("si"))
        {

            btnladoderechofrente.setEnabled(false);
            btnladoderechoatras.setEnabled(false);
            btnladoizquierdofrente.setEnabled(false);
            btnladoizquierdoatras.setEnabled(false);
                      
            
       
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar nuevo fotomontaje SIN PUNTADAS");
            btnfotomontajesinpuntadas.setEnabled(true);
            btnterminetodo.setEnabled(false);
            
        
        }

        else
        
        */
        if(tienefotomontaje.equals("no"))
        {
            
           
            
            btnladoderechofrente.setEnabled(false);
            btnladoderechoatras.setEnabled(false);
            btnladoizquierdofrente.setEnabled(false);
            btnladoizquierdoatras.setEnabled(false);
            
           
            lbfotomontaje.setVisible(false);
            btnverfotomontaje.setEnabled(false);
         

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
            
       }  

        
        
    }
     
     /*
     void agregarfotomontajeotrasucursal() throws FileNotFoundException, IOException  
    {
        
        String numero = lbfolio.getText();
        String numeroventa = lbnumeroventa.getText();
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);

       String sql = "Select imagen_nombre,imagen from historial_ordenes_pantalon_recibidas where numero = '"+lbfolio.getText()+"'   ";  ///

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
                      
                      JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");

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
                        if (nombredelarchivo.equals("jpg") || nombredelarchivo.equals("png") || nombredelarchivo.equals("jpeg") || nombredelarchivo.equals("JPEG") || nombredelarchivo.equals("PNG") || nombredelarchivo.equals("JPG")) {
                            rutaimagen = "C:\\archivospdf\\FOTOMONTAJE." + nombredelarchivo + " ";
                        } else {
                            nombredelarchivo = nombredelarchivo.replace(" ", "");
                            rutaimagen = "C:\\archivospdf\\" + nombredelarchivo + " ";
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
           
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        if(tienefotomontaje.equals("si"))
        {
          

            
            
            
        
        }
        else
        {
            btnladoderechofrente.setEnabled(false);
            btnladoderechoatras.setEnabled(false);
            btnladoizquierdofrente.setEnabled(false);
            btnladoizquierdoatras.setEnabled(false);
            
          
            lbfotomontaje.setVisible(false);
            btnverfotomontaje.setEnabled(false);
         

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
            
        }  

        
        
    }
     
     
     */
     
     void datosotrasucursal () throws FileNotFoundException, IOException
    {
        
        String folio = lbfolio.getText();
        String numeroventa = "";
        String prendasql = "";
        String prendanombresql = "";
        String prenda = "";
       



        String activadoladoizquierdofrente = "";
        String activadoladoizquierdoatras = "";
        String activadoladoderechofrente = "";
        String activadoladoderechoatras = "";

        String sql = "Select fecha,hora,cliente,numero_sucursal_orden,tienda,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,lado_izquierdo_frente,lado_derecho_frente,lado_izquierdo_atras,lado_derecho_atras,cantidad_lado_izquierdo_frente,cantidad_lado_derecho_frente,cantidad_lado_izquierdo_atras,cantidad_lado_derecho_atras,lado_izquierdo_frente_puntadas,lado_derecho_frente_puntadas,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas,lugar from historial_ordenes_pantalon_recibidas where numero = '" + folio + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));
                prenda = rs.getString("prenda");
                numerosucursal = rs.getString("numero_sucursal_orden");
                lbnumerosucursal.setText(numerosucursal);
                tiendaenvia=rs.getString("tienda");
                
                ladoizquierdofrentenombre = rs.getString("lado_izquierdo_frente");
                ladoderechofrentenombre = rs.getString("lado_derecho_frente");
                ladoizquierdoatrasnombre = rs.getString("lado_izquierdo_atras");
                ladoderechoatrasnombre = rs.getString("lado_derecho_atras");
                        
                lbladoizquierdofrente.setText(rs.getString("lado_izquierdo_frente"));
                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente");
                if (ladoizquierdofrente == null || ladoizquierdofrente.equals("")) 
                {
                    
                  btnladoizquierdofrente.setEnabled(false);

                } else {


                    String b = rs.getString("lado_izquierdo_frente_puntadas");
                    lbladoizquierdofrentepuntadas.setText(rs.getString("lado_izquierdo_frente_puntadas"));
                    btnladoizquierdofrente.setEnabled(true);
                    activadoladoizquierdofrente ="si";
                   
                    
                    
                }

                
                /// lado derecho frente
                
                lbladoderechofrente.setText(rs.getString("lado_derecho_frente"));
                String ladoderechofrente = rs.getString("lado_derecho_frente");

                if (ladoderechofrente == null || ladoderechofrente.equals("")) 
                {
                    btnladoderechofrente.setEnabled(false);
                } 
                else
                {

 
                    lbladoderechofrentepuntadas.setText(rs.getString("lado_derecho_frente_puntadas"));
                    btnladoderechofrente.setEnabled(true);
                    activadoladoderechofrente ="si";
                    
                }

                lbdadoizquierdoatras.setText(rs.getString("lado_izquierdo_atras"));
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras");
                if (ladoizquierdoatras == null || ladoizquierdoatras.equals("")) {
                    btnladoizquierdoatras.setEnabled(false);
                } else {


                    lbladoizquierdoatraspuntadas.setText(rs.getString("lado_izquierdo_atras_puntadas"));
                    btnladoizquierdoatras.setEnabled(true);
                    activadoladoizquierdoatras ="si";
                    
                }

                lbladoderechoatras.setText(rs.getString("lado_derecho_atras"));
                String ladoderechoatras = rs.getString("lado_derecho_atras");
                if (ladoderechoatras == null || ladoderechoatras.equals("")) {
                     btnladoderechoatras.setEnabled(false);
                } else {


                    String a = rs.getString("lado_derecho_atras_puntadas");
                    lbladoderechoatraspuntadas.setText(rs.getString("lado_derecho_atras_puntadas"));
                    btnladoderechoatras.setEnabled(true);
                    activadoladoderechoatras ="si";
                    
                }
                
                
                lugardondesebordara = rs.getString("lugar");
                lbcantidad.setText(rs.getString("cantidad"));
                
                if(lugardondesebordara.equals("Esta sucursal"))
                {
                    
                  
                
                String cantidadladoizquierdofrente = rs.getString("cantidad_lado_izquierdo_frente");
                if(cantidadladoizquierdofrente.equals("0") && activadoladoizquierdofrente.equals("si"))
                {
                    btnladoizquierdofrente.setEnabled(true);
                     listabotones.add("btnladoizquierdofrente");
                }
                else
                {
                    btnladoizquierdofrente.setEnabled(false);
                }    
                
                
                String cantidadladoderechofrente = rs.getString("cantidad_lado_derecho_frente");
                if(cantidadladoizquierdofrente.equals("0")&& activadoladoderechofrente.equals("si"))
                {
                   btnladoderechofrente.setEnabled(true);
                   listabotones.add("btnladoderechofrente");
                }
                else
                {
                   btnladoderechofrente.setEnabled(false); 
                } 
                String cantidadladoizquierdoatras = rs.getString("cantidad_lado_izquierdo_atras");
                if(cantidadladoizquierdoatras.equals("0") && activadoladoizquierdoatras.equals("si"))
                {
                    btnladoizquierdoatras.setEnabled(true);
                    listabotones.add("btnladoizquierdoatras");
                }
                else
                {
                    btnladoizquierdoatras.setEnabled(false);
                } 
                String cantidadladoderechoatras = rs.getString("cantidad_lado_derecho_atras");
                if(cantidadladoderechoatras.equals("0")&& activadoladoderechoatras.equals("si"))
                {
                    btnladoderechoatras.setEnabled(true);
                    listabotones.add("btnladoderechoatras");
                }
                else
                {
                    btnladoderechoatras.setEnabled(false);
                } 
                
                }

            }

        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        
        
        
        
        
        
          
        String cliente = lbcliente.getText();
        
        
        
                tiendaconectada();   
             
            
                
              if (latiendaestaconectada.equals("si"))

                      {
                
                
                 try {
         
                     
                     
            Class.forName("com.mysql.jdbc.Driver");
       
         
            con = DriverManager.getConnection("jdbc:mysql://" + iptraspaso + "/" + tiendaenvia + "", "root", "sistemas");
      

        String sql7 = "Select cliente,lugar,identificador_prenda from historial_ordenes_pantalon where numero = '" + numerosucursal + "' ";

        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql7);
            if (rs.next()) {

                cliente = rs.getString("cliente");
                prenda = (rs.getString("prenda"));
                sucursal = rs.getString("lugar");
                identificadordeprenda = rs.getString("identificador_prenda");
                

            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }

        
     
        
        
         BufferedImage img = null;
        
        
        
       String sql4 = "Select extension_imagen,imagen from bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificadordeprenda+"' and tipo = '"+prenda+"'   ";  ///

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
     
     
     
     
     
     
     
     void tiendaconectada()
 {
     
     
     
     String tienda =tiendaenvia;
     
     
     try {
            
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tiendas", "root", "sistemas");

            try {
              
                
                
                
                String sql = "SELECT ip FROM catalogo_tiendas where tienda = '" + tienda + "'";

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

        if (tienda == null || tienda.equals("Seleccione Tienda")) 
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
 
    
     
     
     
     
     
     
     
     

      void actualizarlascantidadesbordadas(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set "+ubicacion+"='" + lbcantidad.getText() + "',fecha='"+dia()+"' where numero = '"+lbfolio.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
       
        try {
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
      
    void actualizarlascantidadesbordadascancelar(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set "+ubicacion+"='0' where numero = '"+lbfolio.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
       
        try {
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }  
      
      
    void actualizarlascantidadesbordadasotrasucursal(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set "+ubicacion+"='" + lbcantidad.getText() + "',fecha='"+dia()+"' where numero = '"+lbfolio.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
       
        try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*
        
       try {    
            agregarfotomontajeotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        */
        
        
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
                pst.setString(5, identificadordeprenda);
                pst.setString(6, lbcantidad.getText());
                
                 if(tienenumerodesucursal.equals("no") )
                {
                    pst.setString(7, "00000000");
                    pst.setString(8, "ninguno");
                }
                else
                {
                    pst.setString(7, numerosucursalordenpantalon);
                    pst.setString(8, sucursal);
                } 
                
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }

           int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
           
           
           if(cantidadaplicacionint > 0)
           {
               int cantidadprendasint = Integer.parseInt(lbcantidad.getText());
               int totalaplicaciones = cantidadprendasint * cantidadaplicacionint;
               
               String Insertaraplicacion = "INSERT INTO historial_bordados_existencia(numero,dia,hora,articulo,concepto,cantidad,numero_sucursal,sucursal) VALUES (?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(Insertaraplicacion);
                pst.setString(1, lbnumeroventa.getText());
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, aplicacioninsertar);
                pst.setString(5, identificadordeprenda);
                pst.setString(6, String.valueOf(totalaplicaciones));
                  if(tienenumerodesucursal.equals("no") )
                {
                    pst.setString(7, "00000000");
                    pst.setString(8, "ninguno");
                }
                else
                {
                    pst.setString(7, numerosucursalordenpantalon);
                    pst.setString(8, sucursal);
                } 
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
               
           }
        
        
    }
    
    
    void agregarexistenciabordadoscancelar(String ubicacioninsertar,String aplicacioninsertar,String cantidadaplicacion)
    {
        
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
    
    
    
      
     void cliente(){
        
        
        String cliente = lbcliente.getText();
        
          String sql = "SELECT nombre_comercial,identificador FROM catalogo_clientes WHERE nombre = '" + cliente + "' ";

                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {

                        
                      
                        lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                        lbbordacliente.setText(rs.getString("identificador"));

                    }

                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+e+"");

                }
        
    }
    
    
    void agregarexistenciabordadosotrasucursal(String ubicacioninsertar,String aplicacioninsertar,String cantidadaplicacion)
    {
        
       
        
        //// bordado
        String InsertarSQL = "INSERT INTO historial_bordados_existencia(numero_sucursal,sucursal,dia,hora,articulo,concepto,cantidad) VALUES (?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            
                
 
                pst.setString(1, lbnumeroventa.getText());
                pst.setString(2, tiendaenvia);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, ubicacioninsertar);
                pst.setString(6, "ninguno");
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
            
                
 
                 pst.setString(1,lbnumeroventa.getText());
                pst.setString(2, tiendaenvia);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, ubicacioninsertar);
                pst.setString(6, "ninguno");
                pst.setString(7, lbcantidad.getText());
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
               
           }
        
        
    }
    
     void agregaralsurtidasalhistorialdeventas(String ubicacion, String cantidad) 
      {

        String numeroventa =  lbnumeroventa.getText();
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
        
        String SQL2 = "select cantidad from historial_ventas where numero = '" + numeroventa + "' and articulo = '" + ubicacion + "' ";
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
     
    
      void codigocliente()
    {
        String sql = "SELECT codigo_cliente FROM historial_ventas WHERE numero = '" + lbnumeroventa.getText() + "' ";


        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
            {
                
               codigocliente = rs.getString("codigo_cliente");
                
            }


        } catch (SQLException ex) {
            System.out.println (ex);
        }
    }
      
     void descargarponchado(String ubicacion,String ubicacionnombre)
     {
         JFileChooser fs = new JFileChooser();
        

         try (
                 PreparedStatement ps = cn.prepareStatement("select " + ubicacion + "," + ubicacionnombre + " from historial_ordenes_pantalon_recibidas where numero = '" + lbfolio.getText() + "' ")) {
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
     
    
      void estacompletalaorden()
    {
        
        String cantidad = "0";
        int tienecantidad = 0;
        int botonesactivados = 0;
        
         String sql = "Select cantidad,cantidad_lado_izquierdo_frente,lado_izquierdo_frente,"
                  + "cantidad_lado_derecho_frente,lado_derecho_frente,"
                  + "cantidad_lado_izquierdo_atras,lado_izquierdo_atras,"
                  + "cantidad_lado_derecho_atras,lado_derecho_atras from historial_ordenes_pantalon where numero = '"+lbfolio.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cantidad = rs.getString("cantidad");   
                String cantidadladoizquierdofrente = rs.getString("cantidad_lado_izquierdo_frente");
                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente");
                
                String cantidadladoderechofrente = rs.getString("cantidad_lado_derecho_frente");
                String ladoderechofrente = rs.getString("lado_derecho_frente");
                
                String cantidadladoizquierdoatras = rs.getString("cantidad_lado_izquierdo_atras");
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras");
               
                String cantidadladoderechoatras = rs.getString("cantidad_lado_derecho_atras");
                String ladoderechoatras = rs.getString("lado_derecho_atras");


                
                if(ladoizquierdofrente==null || ladoizquierdofrente.equals("")||ladoizquierdofrente.equals(" ")||ladoizquierdofrente.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                } 
                
                
                if(ladoderechofrente==null || ladoderechofrente.equals("")||ladoderechofrente.equals(" ")||ladoderechofrente.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(ladoizquierdoatras==null || ladoizquierdoatras.equals("")||ladoizquierdoatras.equals(" ")||ladoizquierdoatras.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(ladoderechoatras==null || ladoderechoatras.equals("")||ladoderechoatras.equals(" ")||ladoderechoatras.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                
           
           
                ////////////////////////////////////////////////////////////////
                
                 if(cantidadladoizquierdofrente.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                } 
                
                
                if(cantidadladoderechofrente.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                }
                
                if(cantidadladoizquierdoatras.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
                if(cantidadladoderechoatras.equals("0"))
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
               
           
            
           
           if(tienecantidad == botonesactivados)
           {
               try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set estatus_orden='realizada',fecha='"+dia()+"' where numero='" + lbfolio.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                  
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
               
           }
           else
           {
                try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set estatus_orden='generada' where numero='" + lbfolio.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                  
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
               
           }    


        }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        lbfolio = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lbnumeroventa = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        btnreplicar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbfotomontaje = new javax.swing.JLabel();
        lbtiendareplica = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        btnladoderechofrente = new javax.swing.JButton();
        btnladoderechoatras = new javax.swing.JButton();
        btnladoizquierdofrente = new javax.swing.JButton();
        btnladoizquierdoatras = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        lbcolormangaderecha = new javax.swing.JLabel();
        lbcolormangaizquierda = new javax.swing.JLabel();
        lbcolorpechoderecho = new javax.swing.JLabel();
        lbcolorpechoizquierdo = new javax.swing.JLabel();
        btnverfotomontaje = new javax.swing.JButton();
        btnterminetodo = new javax.swing.JButton();
        lbbordacliente = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbnombrecomercial = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbcodigoladoderechofrente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbcodigoladoizquierdoatras = new javax.swing.JLabel();
        lbcodigoladoizquierdofrente = new javax.swing.JLabel();
        lbcodigoladoderechoatras = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        lbidentificadordeprenda = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        lbladoderechoatras = new javax.swing.JLabel();
        lbladoderechoatraspuntadas = new javax.swing.JLabel();
        lbdadoizquierdoatras = new javax.swing.JLabel();
        lbladoizquierdoatraspuntadas = new javax.swing.JLabel();
        lbladoizquierdofrente = new javax.swing.JLabel();
        lbladoizquierdofrentepuntadas = new javax.swing.JLabel();
        lbladoderechofrente = new javax.swing.JLabel();
        lbladoderechofrentepuntadas = new javax.swing.JLabel();
        btnfotomontajesinpuntadas = new javax.swing.JButton();
        btnvercolorido = new javax.swing.JButton();
        btndatos = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        lbnumerosucursal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden Pantalon");
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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Orden de bordado");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfolio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfolio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Cliente:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbnumeroventa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumeroventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("No. de Venta");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnreplicar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreplicar.setText("Replicar Bordados");
        btnreplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);

        lbfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfotomontaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbfotomontaje.setText("Sin imagen");
        lbfotomontaje.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lbfotomontaje);
        lbfotomontaje.setBounds(8, 10, 690, 560);

        lbtiendareplica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbtiendareplica.setText("Replicar a tienda");
        lbtiendareplica.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Cantidad");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcantidad.setText("0");
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnladoderechofrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechofrente.setText("Lado Derecho Frente");
        btnladoderechofrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechofrenteActionPerformed(evt);
            }
        });

        btnladoderechoatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechoatras.setText("Lado Derecho Atras");
        btnladoderechoatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechoatrasActionPerformed(evt);
            }
        });

        btnladoizquierdofrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdofrente.setText("Lado Izquierdo Frente");
        btnladoizquierdofrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdofrenteActionPerformed(evt);
            }
        });

        btnladoizquierdoatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdoatras.setText("Lado Izquierdo Atras");
        btnladoizquierdoatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdoatrasActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ubicación");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Color");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Puntos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbsumapuntos.setText("0.00");
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolormangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolormangaderecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolormangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolormangaizquierda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorpechoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorpechoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        btnterminetodo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnterminetodo.setForeground(new java.awt.Color(0, 102, 0));
        btnterminetodo.setText("***Termine todo***");
        btnterminetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterminetodoActionPerformed(evt);
            }
        });

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel27.setText("Bordacliente");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Nombre comercial");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoderechofrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoderechofrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Codigo");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoizquierdoatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoizquierdoatras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoizquierdofrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoizquierdofrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoderechoatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoderechoatras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminar.setText("Editar bordado");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Identificador de prenda");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificadordeprenda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbidentificadordeprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Observaciones");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        lbladoderechoatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechoatras.setText("Lado derecho atras");

        lbladoderechoatraspuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechoatraspuntadas.setForeground(new java.awt.Color(255, 0, 0));
        lbladoderechoatraspuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdadoizquierdoatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdadoizquierdoatras.setText("Lado izquierdo atras");

        lbladoizquierdoatraspuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdoatraspuntadas.setForeground(new java.awt.Color(255, 0, 0));
        lbladoizquierdoatraspuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdofrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdofrente.setText("Lado izquierdo frente");

        lbladoizquierdofrentepuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdofrentepuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderechofrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechofrente.setText("Lado derecho frente");

        lbladoderechofrentepuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechofrentepuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnfotomontajesinpuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnfotomontajesinpuntadas.setText("Fotomontaje sin puntadas");
        btnfotomontajesinpuntadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfotomontajesinpuntadasActionPerformed(evt);
            }
        });

        btnvercolorido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnvercolorido.setText("Ver colorido");
        btnvercolorido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvercoloridoActionPerformed(evt);
            }
        });

        btndatos.setText("datos");
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Numero de sucursal");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumerosucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumerosucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(650, 650, 650)
                                .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 516, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnfotomontajesinpuntadas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(327, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 717, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(lbladoderechofrente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbladoizquierdofrente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbdadoizquierdoatras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbladoderechoatras, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbladoderechoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbladoizquierdoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbladoizquierdofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbladoderechofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnladoderechofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnladoderechoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnladoizquierdofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnladoizquierdoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(14, 14, 14)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolormangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolormangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolorpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolorpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcodigoladoderechofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigoladoizquierdoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigoladoizquierdofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigoladoderechoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbtiendareplica, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btndatos)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbnumerosucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(2, 2, 2))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 546, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbnumeroventa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnumerosucursal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnfotomontajesinpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbcolormangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(2, 2, 2)
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnladoderechofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbcolormangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbcolorpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnladoderechoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnladoizquierdofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbcolorpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbcodigoladoderechofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbcodigoladoderechoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbcodigoladoizquierdofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbcodigoladoizquierdoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(btnladoizquierdoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbladoderechoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbladoderechoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbdadoizquierdoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbladoizquierdoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbladoizquierdofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbladoizquierdofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbladoderechofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbladoderechofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbtiendareplica, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndatos)))
                .addContainerGap(38, Short.MAX_VALUE))
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ventanaordenpantalonanteriores = false;
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordenpantalonanteriores = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing


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

    private void btnreplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicarActionPerformed

         

        
        int traspaso = 0;
        
        String tipo = "Orden pantalon";
        numerosucursal = lbfolio.getText();
        String prenda = "Pantalon";
        String cliente = lbcliente.getText();

        String path = "";
        String tiendaalaquesereplicara = lbtiendareplica.getText();
        String stringIP = "";
        String stringlocal = "";
        String stringBDlocal = "";

        String nombrearchivo1 = "";
        String nombrearchivo2 = "";
        String nombrearchivo3 = "";
        String nombrearchivo4 = "";
        String nombrearchivo5 = "";
        String nombrearchivo6 = "";

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
            System.out.println(e);
        }

        Connection conn = null;
        String iptraspaso = stringIP;
        String tienda_traspaso = stringlocal;

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
            Object ponchado1 = rutaladoizquierdofrente;
            if (ponchado1 == null || ponchado1.equals("")||ponchado1.equals("lbrutaladoizquierdofrente")) {

            } else {
                
                try {
                    String filePath = rutaladoizquierdofrente;
                    File archivo = new File(filePath);
                    nombrearchivo1 = archivo.getName();
                    input = new FileInputStream(new File(filePath));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_frente_ponchado=? where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_frente_ponchado_nombre='" + nombrearchivo1 + "' where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            ///ponchado2
            Object ponchado2 = rutaladoderechofrente;
            if (ponchado2 == null || ponchado2.equals("") || ponchado2.equals(" ")|| ponchado2.equals("lbrutaladoderechofrente")) {

            } else {
                try {
                    String filePath2 = rutaladoderechofrente;
                    File archivo2 = new File(filePath2);
                    nombrearchivo2 = archivo2.getName();
                    input2 = new FileInputStream(new File(filePath2));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_frente_ponchado=? where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input2);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_frente_ponchado_nombre='" + nombrearchivo2 + "' where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

            ///ponchado3
            Object ponchado3 = rutaladoizquierdoatras;
            if (ponchado3 == null || ponchado3.equals("") || ponchado3.equals(" ")||ponchado3.equals("lbrutaladoizquierdoatras")) {

            } else {
                try {
                    String filePath3 = rutaladoizquierdoatras;
                    File archivo3 = new File(filePath3);
                    nombrearchivo3 = archivo3.getName();
                    input3 = new FileInputStream(new File(filePath3));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_atras_ponchado=? where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input3);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_atras_ponchado_nombre='" + nombrearchivo3 + "' where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            //ponchado 4
            Object ponchado4 = rutaladoderechoatras;

            if (ponchado4 == null || ponchado4.equals("") || ponchado4.equals(" ")|| ponchado4.equals("lbrutaladoderechoatras")) {

            } else {
                try {
                    String filePath4 = rutaladoderechoatras;
                    File archivo4 = new File(filePath4);
                    nombrearchivo4 = archivo4.getName();
                    input4 = new FileInputStream(new File(filePath4));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_atras_ponchado=? where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input4);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_atras_ponchado_nombre='" + nombrearchivo4 + "' where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
                    pst.executeUpdate();
                    System.out.println(pst);
                    pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

          

           /// imagen jlabel
            Object imagen = rutaimagen;

            if (imagen == null || imagen.equals("") || imagen.equals(" ")||imagen.equals("lbrutaimagen") ) {

            } else {
                try {
                    String filePath6 = rutaimagen;
                    File archivo6 = new File(filePath6);
                    nombrearchivo6 = archivo6.getName();
                    input6 = new FileInputStream(new File(filePath6));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set imagen=? where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input6);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set imagen_nombre='" + nombrearchivo6 + "' where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return;
        }

        if (traspaso > 0)
        {
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden se inserto correctamente en la otra sucursal");

            String numero = lbfolio.getText();
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon SET estatus_orden='enviado' WHERE numero='" + numero + "'");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            ordenesporrealizar.btnactualizar.doClick();

        }
        else
        {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden No se inserto en la otra sucursal");
        }   

       
         this.dispose();
         
         
         
         
        
    }//GEN-LAST:event_btnreplicarActionPerformed
   
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

         if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
        
        nombredelatabla = "historial_ordenes_pantalon";
        
     try {
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
     
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
     
        cliente();
        
        
        
        
    } 
    
    else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
        
        nombredelatabla = "historial_ordenes_pantalon_recibidas";
        
         try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         /*
         try {    
            agregarfotomontajeotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
         */
         
         
        btnreplicar.setEnabled(false);
         
    }   
         
         
     hilosycolor();
         
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
        
        
        
     // sumapuntos();
        
    }//GEN-LAST:event_formWindowOpened

    private void btnladoizquierdofrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdofrenteActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
             if (btnladoizquierdofrente.getText().equals("Cancelar")) 
        {
            if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de manga derecha?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                 {
                     String ubicacion = "cantidad_lado_izquierdo_frente";
                     actualizarlascantidadesbordadascancelar((String) ubicacion);
                     String cantidadaplicacion = "0";
                     ubicacioninsertar = "BORDADO PANTALON FRENTE LADO IZQUIERDO "+ladoizquierdofrentenombre + "";
                     aplicacioninsertar = "";
                     String cantidad = lbcantidad.getText();
                     agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
                     agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
                     estacompletalaorden();
                 }

        }
        else     
        {
            
            
            String ubicacion = "cantidad_lado_izquierdo_frente";
            actualizarlascantidadesbordadas((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO PANTALON FRENTE LADO IZQUIERDO "+ladoizquierdofrentenombre + "";
            aplicacioninsertar = "";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
            estacompletalaorden();
            
        }
             
        }      
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaladoizquierdofrente= fl ;
            btnladoizquierdofrente.setEnabled(false);

        }
        
        }
        
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
            int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="lado_izquierdo_frente_ponchado";
                String ubicacionnombre ="lado_izquierdo_frente_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
            {
            
            String ubicacion = "cantidad_lado_izquierdo_frente";
            String nombrebordado = ladoizquierdofrentenombre;
            String cantidadaplicacion = "0";
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            
            }
            
             
            
        }
        
         try {
                 datosOrdenesLocales();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
             }

        
        }
    }//GEN-LAST:event_btnladoizquierdofrenteActionPerformed

    private void btnladoizquierdoatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrasActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
             if (btnladoizquierdoatras.getText().equals("Cancelar")) 
        {
            if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de manga derecha?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                 {
                      String ubicacion = "cantidad_lado_izquierdo_atras";
                     actualizarlascantidadesbordadascancelar((String) ubicacion);
                     String cantidadaplicacion = "0";
                     ubicacioninsertar = "BORDADO PANTALON ATRAS LADO IZQUIERDO "+ladoizquierdoatrasnombre + "";
                     aplicacioninsertar = "";
                     String cantidad = lbcantidad.getText();
                     agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
                     agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
                     estacompletalaorden();
                 }

        }
        else     
        {
            
            String ubicacion = "cantidad_lado_izquierdo_atras";
            actualizarlascantidadesbordadas((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO PANTALON ATRAS LADO IZQUIERDO "+ladoizquierdoatrasnombre + "";
            aplicacioninsertar = "";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
            estacompletalaorden();
        }    
        }
         else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaladoizquierdoatras=fl;
            btnladoizquierdoatras.setEnabled(false);

        }
        
        }
       
         else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
            int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="lado_izquierdo_atras_ponchado";
                String ubicacionnombre ="lado_izquierdo_atras_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
            {
            
            String ubicacion = "cantidad_lado_izquierdo_atras";
            String nombrebordado = ladoizquierdoatrasnombre;
            String cantidadaplicacion = "0";
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            
            }
            
             
            
        }
         
        
         try {
                 datosOrdenesLocales();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
        
        }
    }//GEN-LAST:event_btnladoizquierdoatrasActionPerformed

    private void btnladoderechoatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoatrasActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
         if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

        if (btnladoderechoatras.getText().equals("Cancelar")) 
        {
            if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de manga derecha?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                 {
                     String ubicacion = "cantidad_lado_derecho_atras";
                     actualizarlascantidadesbordadascancelar((String) ubicacion);
                     String cantidadaplicacion = "0";
                     ubicacioninsertar = "BORDADO PANTALON ATRAS LADO DERECHO "+ladoderechoatrasnombre + "";
                     aplicacioninsertar = "";
                     String cantidad = lbcantidad.getText();
                     agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
                     agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
                     estacompletalaorden();
                 }

        }
        else     
        {
            
            String ubicacion = "cantidad_lado_derecho_atras";
            actualizarlascantidadesbordadas((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO PANTALON ATRAS LADO DERECHO "+ladoderechoatrasnombre + "";
            aplicacioninsertar = "";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
            estacompletalaorden();
        }
        
        }
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaladoderechoatras= fl;
            btnladoderechoatras.setEnabled(false);

        }
        
        }
       else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
            int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="lado_derecho_atras_ponchado";
                String ubicacionnombre ="lado_derecho_atras_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
            {
            
            String ubicacion = "cantidad_lado_derecho_atras";
            String nombrebordado = ladoderechoatrasnombre;
            String cantidadaplicacion = "0";
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            
            }
            
             
            
        }
         
          try {
                 datosOrdenesLocales();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
             }
         
         
        }
    }//GEN-LAST:event_btnladoderechoatrasActionPerformed

    private void btnladoderechofrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechofrenteActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
         if(lugardondesebordara.equals("Esta sucursal")  && tipotabla.equals("Local"))
         {
             
          
        if (btnladoderechofrente.getText().equals("Cancelar")) 
        {
            if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de manga derecha?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                 {
                     String ubicacion = "cantidad_lado_derecho_frente";
                     actualizarlascantidadesbordadascancelar((String) ubicacion);
                     String cantidadaplicacion = "0";
                     ubicacioninsertar = "BORDADO PANTALON FRENTE LADO DERECHO " + ladoderechofrentenombre + "";
                     aplicacioninsertar = "";
                     String cantidad = lbcantidad.getText();
                     agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
                     agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
                     estacompletalaorden();
                 }

        }
        else     
        {
            String ubicacion = "cantidad_lado_derecho_frente";
            actualizarlascantidadesbordadas((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO PANTALON FRENTE LADO DERECHO "+ladoderechofrentenombre + "";
            aplicacioninsertar = "";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
            estacompletalaorden();
            
        }
        
        }
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaladoderechofrente=fl;
            btnladoderechofrente.setEnabled(false);

        }
        
        }
          else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
            int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="lado_derecho_frente_ponchado";
                String ubicacionnombre ="lado_derecho_frente_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
            {
            
            String ubicacion = "cantidad_lado_derecho_frente";
            String nombrebordado = ladoderechoatrasnombre;
            String cantidadaplicacion = "0";
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            
            }
            
             
            
        }
         
         
             try {
                 datosOrdenesLocales();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
             }
         
         
        }
    }//GEN-LAST:event_btnladoderechofrenteActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
      ventanaordenpantalonanteriores = false;
       
    }//GEN-LAST:event_formWindowClosed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed

            String fileLocal = new String(rutaimagen);
            try {

                File path = new File(fileLocal);
                Desktop.getDesktop().open(path);

            } catch (IOException e) {
                System.out.println(e);
            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }

        
        
        
    }//GEN-LAST:event_btnverfotomontajeActionPerformed

    private void btnterminetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterminetodoActionPerformed

        terminetodo = "si";

        for(int i = 0; i < listabotones.size(); i++)
        {
            Object boton =  listabotones.get(i);

            if(boton.equals("btnladoizquierdofrente"))
            {
                
                if(btnladoizquierdofrente.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoizquierdofrente.doClick();
                }
                
            }
            else if(boton.equals("btnladoderechofrente"))
            {
                if(btnladoderechofrente.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoderechofrente.doClick();
                }
            }
            else if(boton.equals("btnladoizquierdoatras"))
            {
                if(btnladoizquierdoatras.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoizquierdoatras.doClick();
                }
            }
            else if(boton.equals("btnladoderechoatras"))
            {
                if(btnladoderechoatras.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoderechoatras.doClick();
                }
            }
            

        }
        
        try {
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
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

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed


        if (bordadosdelclienteeditar.ventanabordadosdelclienteeditar)

        {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La ventana de bordados de cliente ya está abierta");
        }
        else

        {

            bordadosdelclienteeditar ventana = new bordadosdelclienteeditar();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);

            bordadosdelclienteeditar.lbcliente.setText(lbcliente.getText());
            bordadosdelclienteeditar.lbnombrecomercial.setText(lbnombrecomercial.getText());
            bordadosdelclienteeditar.lbidentificador.setText(lbbordacliente.getText());
            bordadosdelclienteeditar.lbcodigocliente.setText(codigocliente);
            bordadosdelclienteeditar.lbconsecutivo.setText(consecutivo);
            bordadosdelclienteeditar.txtidentificadordeprenda.setText(identificadordeprenda);

            bordadosdelclienteeditar.lbprenda.setText("PANTALON");

        }

    }//GEN-LAST:event_btneliminarActionPerformed

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

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigocliente+"' and identificador_prenda = '"+identificadordeprenda+"' and tipo = 'PANTALON' and numero_consecutivo = '"+consecutivo+"' ";

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
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"',puntadas_en_fotomontajes ='no' where codigo='"+codigocliente+"' and identificador_prenda = '"+identificadordeprenda+"' and tipo = 'PANTALON' and numero_consecutivo = '"+consecutivo+"' ");
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
        
        nombredelatabla = "historial_ordenes_pantalon";
        
     try {
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        
     
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
     
        cliente();
        
        
        
        
    } 
    
    else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
        
        nombredelatabla = "historial_ordenes_pantalon_recibidas";
        
         try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         /*
         try {    
            agregarfotomontajeotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        } 
        */

         
        btnreplicar.setEnabled(false);
         
    }   
         
         
     hilosycolor();
         
      AudioClip sonido;
      if(tieneunaobservacion.equals("si"))
        {
            sonido= java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/tienesunaobservacion.wav"));    
            sonido.play();
            
        }
        
     // sumapuntos();
    }//GEN-LAST:event_btndatosActionPerformed

    ResultSet rs;
    ResultSet rs2;

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordenpantalon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    private javax.swing.JButton btnladoderechoatras;
    private javax.swing.JButton btnladoderechofrente;
    private javax.swing.JButton btnladoizquierdoatras;
    private javax.swing.JButton btnladoizquierdofrente;
    private javax.swing.JButton btnreplicar;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    public static javax.swing.JLabel lbbordacliente;
    public static javax.swing.JLabel lbcantidad;
    public static javax.swing.JLabel lbcliente;
    public javax.swing.JLabel lbcodigoladoderechoatras;
    public javax.swing.JLabel lbcodigoladoderechofrente;
    public javax.swing.JLabel lbcodigoladoizquierdoatras;
    public javax.swing.JLabel lbcodigoladoizquierdofrente;
    public javax.swing.JLabel lbcolormangaderecha;
    public javax.swing.JLabel lbcolormangaizquierda;
    public javax.swing.JLabel lbcolorpechoderecho;
    public javax.swing.JLabel lbcolorpechoizquierdo;
    public static javax.swing.JLabel lbdadoizquierdoatras;
    public static javax.swing.JLabel lbfolio;
    private javax.swing.JLabel lbfotomontaje;
    public static javax.swing.JLabel lbidentificadordeprenda;
    public static javax.swing.JLabel lbladoderechoatras;
    public static javax.swing.JLabel lbladoderechoatraspuntadas;
    public static javax.swing.JLabel lbladoderechofrente;
    public static javax.swing.JLabel lbladoderechofrentepuntadas;
    public static javax.swing.JLabel lbladoizquierdoatraspuntadas;
    public static javax.swing.JLabel lbladoizquierdofrente;
    public static javax.swing.JLabel lbladoizquierdofrentepuntadas;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumerosucursal;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JTextArea lbobservaciones;
    public javax.swing.JLabel lbsumapuntos;
    private javax.swing.JLabel lbtiendareplica;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

   
}
