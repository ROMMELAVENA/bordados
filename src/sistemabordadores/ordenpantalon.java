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
    String ipdelaotratienda = "";
    String iplocal = principal.lbiplocal.getText();
    String sucursal = "";
    String latiendaestaconectada = "si";
    Connection con = null;
    String numerosucursal = "";
    String fechaubicacion = "";
    String cantidadprendasstring = "";
    int cantidadprendasint = 0;
  
    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;

    String primero = "";
    String ultimo = "";
    String numerodeventa = "";
    String numeropedido = "";
    String tiendaalaqueselesolicito = "";
    String lugar = "";
    
    ///
    String descripcion = "";
    String aplicacioninsertar = "";
    String numeroordendeenviosolicitada = "";
    String ladoizquierdofrentenombre = "";
    String ladoderechofrentenombre = "";
    String ladoizquierdoatrasnombre = "";
    String ladoderechoatrasnombre = "";
 
     String numerodeorden = "";
    
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
 
    String identificador = "";
    String consecutivo = "";
    String tieneunaobservacion = ""; 
    
    String tienenumerodesucursal = "";
    String numerosucursalordenpantalon = "";
    String tiendalocal = "";
    String rutadedondeestanlosbordados ="";
    
    String prenda = "";
    

    private PreparedStatement pst;
    
    
    public static final Color anaranjado = new Color(255,166,77);
       
       

    public ordenpantalon()
    {
        initComponents();
        ventanaordenpantalonanteriores = true;
        
        btnterminetodo.setEnabled(false);
        btndatos.setEnabled(false);
        
        btnladoderechofrentecancelar.setEnabled(false);
        btnladoderechoatrascancelar.setEnabled(false);        
        btnladoizquierdofrentecancelar.setEnabled(false);        
         btnladoizquierdoatrascancelar.setEnabled(false);
         
           
                
                
                
                
       
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
        
        String folio = lborden.getText();
        String numeroventa ="";
        
        String prendasql = "";
       
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
                
                
                 numerodeventa = rs.getString("numero_venta");
                lbnumerodeventa.setText(numerodeventa);
                
                prenda = rs.getString("prenda");
                
                numeroordendeenviosolicitada=rs.getString("numero_orden");
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
                identificador = rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                lugar = rs.getString("lugar");
                lbcantidad.setText(rs.getString("cantidad"));
                
                        
                
                
                
                
                
                
                
            //    lbladoizquierdofrente.setText(rs.getString("lado_izquierdo_frente"));
                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente");
                if (ladoizquierdofrente == null || ladoizquierdofrente.equals("")) 
                {
                    
                  btnladoizquierdofrentetetermine.setEnabled(false);
                  btnladoizquierdofrenteponchado.setEnabled(false);
                  
                  

                } else {

                   
                    String b = rs.getString("lado_izquierdo_frente_puntadas");
                    lbladoizquierdofrentepuntadas.setText(rs.getString("lado_izquierdo_frente_puntadas"));
                    btnladoizquierdofrentetetermine.setEnabled(true);
               //     btnladoizquierdofrentetetermine.setText("Lado Izquierdo Frente");
                    btnladoizquierdofrentetetermine.setForeground(Color.green.darker());
                    activadoladoizquierdofrente ="si";
                    
                    
                    
                }

                
                /// lado derecho frente
                
             //   lbladoderechofrente.setText(rs.getString("lado_derecho_frente"));
                String ladoderechofrente = rs.getString("lado_derecho_frente");

                if (ladoderechofrente == null || ladoderechofrente.equals("")) 
                {
                    btnladoderechofrentetetermine.setEnabled(false);
                    btnladoderechofrenteponchado.setEnabled(false);
                } 
                else
                {

                    lbladoderechofrentepuntadas.setText(rs.getString("lado_derecho_frente_puntadas"));
                    btnladoderechofrentetetermine.setEnabled(true);
                //    btnladoderechofrentetetermine.setText("Lado Derecho Frente");
                    btnladoderechofrentetetermine.setForeground(Color.green.darker());
                    activadoladoderechofrente ="si";
                   
                }

                
                
                
                
             //   lbdadoizquierdoatras.setText(rs.getString("lado_izquierdo_atras"));
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras");
                if (ladoizquierdoatras == null || ladoizquierdoatras.equals(""))
                {
                    btnladoizquierdoatrastetermine.setEnabled(false);
                    btnladoizquierdoatrasponchado.setEnabled(false);
                } 
                else 
                {


                    lbladoizquierdoatraspuntadas.setText(rs.getString("lado_izquierdo_atras_puntadas"));
                    btnladoizquierdoatrastetermine.setEnabled(true);
                    activadoladoizquierdoatras ="si";
              //      btnladoizquierdoatrastetermine.setText("Lado Izquierdo Atras");
                    btnladoizquierdoatrastetermine.setForeground(Color.green.darker());
                   
                    
                }

                
                
                
                
                
              //  lbladoderechoatras.setText(rs.getString("lado_derecho_atras"));
                String ladoderechoatras = rs.getString("lado_derecho_atras");
                if (ladoderechoatras == null || ladoderechoatras.equals("")) 
                {
                     btnladoderechoatrastetermine.setEnabled(false);
                     btnladoderechoatrasponchado.setEnabled(false);
                }
                else 
                {


                   
                    lbladoderechoatraspuntadas.setText(rs.getString("lado_derecho_atras_puntadas"));
                    btnladoderechoatrastetermine.setEnabled(true);
               //     btnladoderechoatrastetermine.setText("Lado Derecho Atras");
                    btnladoderechoatrastetermine.setForeground(Color.green.darker());
                    activadoladoderechoatras ="si";
                    
                   
                    
                }
                
                
              
                
                if(lugar.equals("Esta sucursal"))
                {
                    
                  
                
                String cantidadladoizquierdofrente = rs.getString("cantidad_lado_izquierdo_frente");
                if(cantidadladoizquierdofrente.equals("0") && activadoladoizquierdofrente.equals("si"))
                {
                    btnladoizquierdofrentetetermine.setEnabled(true);
                    btnladoizquierdofrenteponchado.setEnabled(true);
                    
                    
                    listabotones.add("btnladoizquierdofrente");
                }
                else
                {
                    if( activadoladoizquierdofrente.equals("si"))
                    {
               
                       btnladoderechofrentecancelar.setEnabled(true);
                        
                        
                    }
                   
                }    
                
                
                String cantidadladoderechofrente = rs.getString("cantidad_lado_derecho_frente");
                if(cantidadladoizquierdofrente.equals("0")&& activadoladoderechofrente.equals("si"))
                {
                   btnladoderechofrentetetermine.setEnabled(true);
                    btnladoderechofrenteponchado.setEnabled(true);
                    
                    
                   listabotones.add("btnladoderechofrente");
                }
                else
                {
                   if( activadoladoderechofrente.equals("si"))
                   {
                btnladoderechoatrascancelar.setEnabled(true);
                   }
                
                
                } 
                
                
                String cantidadladoizquierdoatras = rs.getString("cantidad_lado_izquierdo_atras");
                if(cantidadladoizquierdoatras.equals("0") && activadoladoizquierdoatras.equals("si"))
                {
                    btnladoizquierdoatrastetermine.setEnabled(true);
                     btnladoizquierdoatrasponchado.setEnabled(true);
                     
                     
                    listabotones.add("btnladoizquierdoatras");
                }
                else
                {
                    if( activadoladoizquierdoatras.equals("si"))
                   {
                btnladoizquierdofrentecancelar.setEnabled(true);
                   }
                
                } 
                
                
                String cantidadladoderechoatras = rs.getString("cantidad_lado_derecho_atras");
                if(cantidadladoderechoatras.equals("0")&& activadoladoderechoatras.equals("si"))
                {
                    btnladoderechoatrastetermine.setEnabled(true);
                     btnladoderechoatrasponchado.setEnabled(true);
                     
                     
                    listabotones.add("btnladoderechoatras");
                }
                else
                {
                    if( activadoladoderechoatras.equals("si"))
                   {
                 btnladoizquierdoatrascancelar.setEnabled(true);
                   } 
                }
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
    
    
    
    
    
    void verfotomontaje(){
        
        
        
        
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

        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
     void datostienda() {
        /// busca las ordenes de pantalon generadas 

        String numero = lbnumerodeventa.getText();
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
        prenda = "Pantalon";
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);
        
        
        if (sucursal.equals(tiendalocal))
            
        {
            
      
        numerosucursal = lbnumerosucursal.getText();
        

        String sql7 = "Select prenda,tienda,identificador_prenda from historial_ordenes_pantalon where numero = '" + numerosucursal + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql7);
            if (rs.next()) {

              
          
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
       
     

        String sql = "Select hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,color1,color2,color3,color4,color5,color6,color7,numero_consecutivo from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'PANTALON'   ";

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

       String sql = "Select extension_imagen,imagen,numero_consecutivo,puntadas_en_fotomontajes from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'PANTALON'   ";  ///

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
        
        
        if(tienefotomontaje.equals("no"))
        {
            
           
            
            btnladoderechofrentetetermine.setEnabled(false);
            btnladoderechoatrastetermine.setEnabled(false);
            btnladoizquierdofrentetetermine.setEnabled(false);
            btnladoizquierdoatrastetermine.setEnabled(false);
            
            btnladoderechofrenteponchado.setEnabled(false);
            btnladoderechoatrasponchado.setEnabled(false);
            btnladoizquierdofrenteponchado.setEnabled(false);
            btnladoizquierdoatrasponchado.setEnabled(false);
            
           
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
        
         numerodeorden = lborden.getText();
         prenda = "Pantalon";
       

        String activadoladoizquierdofrente = "";
        String activadoladoizquierdoatras = "";
        String activadoladoderechofrente = "";
        String activadoladoderechoatras = "";

        String sql = "Select fecha,hora,cliente,nombre_comercial,borda_cliente,numero_sucursal_orden,tienda,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,lado_izquierdo_frente,lado_derecho_frente,lado_izquierdo_atras,lado_derecho_atras,cantidad_lado_izquierdo_frente,cantidad_lado_derecho_frente,cantidad_lado_izquierdo_atras,cantidad_lado_derecho_atras,lado_izquierdo_frente_puntadas,lado_derecho_frente_puntadas,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas,lugar,identificador_prenda from historial_ordenes_pantalon_recibidas where numero = '" + numerodeorden + "' and prenda = '" + prenda + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));
                lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                lbbordacliente.setText(rs.getString("borda_cliente"));
                prenda = rs.getString("prenda");
                numerosucursal = rs.getString("numero_sucursal_orden");
                lbnumerosucursal.setText(numerosucursal);
                sucursal=rs.getString("tienda");
                
                ladoizquierdofrentenombre = rs.getString("lado_izquierdo_frente");
                ladoderechofrentenombre = rs.getString("lado_derecho_frente");
                ladoizquierdoatrasnombre = rs.getString("lado_izquierdo_atras");
                ladoderechoatrasnombre = rs.getString("lado_derecho_atras");
                        
          //      lbladoizquierdofrente.setText(rs.getString("lado_izquierdo_frente"));
                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente");
             
                
                
                
                
                
                
                
                
                if (ladoizquierdofrente == null || ladoizquierdofrente.equals("")) 
                {
                    
                  btnladoizquierdofrentetetermine.setEnabled(false);
                  btnladoizquierdofrenteponchado.setEnabled(false);

                } else {


                    String b = rs.getString("lado_izquierdo_frente_puntadas");
                    lbladoizquierdofrentepuntadas.setText(rs.getString("lado_izquierdo_frente_puntadas"));
                    
                    
                    btnladoizquierdofrentetetermine.setEnabled(true);
                    btnladoizquierdofrenteponchado.setEnabled(true);
                    
                    
                    activadoladoizquierdofrente ="si";
                   
                    
                    
                }

                
                /// lado derecho frente
                
             //   lbladoderechofrente.setText(rs.getString("lado_derecho_frente"));
                String ladoderechofrente = rs.getString("lado_derecho_frente");

                if (ladoderechofrente == null || ladoderechofrente.equals("")) 
                {
                    btnladoderechofrentetetermine.setEnabled(false);
                    btnladoderechofrenteponchado.setEnabled(false);
                } 
                else
                {

 
                    lbladoderechofrentepuntadas.setText(rs.getString("lado_derecho_frente_puntadas"));
                    
                    
                    btnladoderechofrentetetermine.setEnabled(true);
                    btnladoderechofrenteponchado.setEnabled(true);
                    
                    
                    activadoladoderechofrente ="si";
                    
                }

             //   lbdadoizquierdoatras.setText(rs.getString("lado_izquierdo_atras"));
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras");
             
                if (ladoizquierdoatras == null || ladoizquierdoatras.equals("")) 
                {
                    btnladoizquierdoatrastetermine.setEnabled(false);
                    btnladoizquierdoatrasponchado.setEnabled(false);
                    
                } else {


                    lbladoizquierdoatraspuntadas.setText(rs.getString("lado_izquierdo_atras_puntadas"));
                 
                    
                    btnladoizquierdoatrastetermine.setEnabled(true);
                    btnladoizquierdoatrasponchado.setEnabled(true);
                    
                    activadoladoizquierdoatras ="si";
                    
                }

           //     lbladoderechoatras.setText(rs.getString("lado_derecho_atras"));
                String ladoderechoatras = rs.getString("lado_derecho_atras");
             
                if (ladoderechoatras == null || ladoderechoatras.equals("")) {
                    
                     btnladoderechoatrastetermine.setEnabled(false);
                      btnladoderechoatrasponchado.setEnabled(false);
                     
                     
                } else {


                    String a = rs.getString("lado_derecho_atras_puntadas");
                    lbladoderechoatraspuntadas.setText(rs.getString("lado_derecho_atras_puntadas"));
                 
                    btnladoderechoatrastetermine.setEnabled(true);
                    btnladoderechoatrasponchado.setEnabled(true);
                    
                    
                    
                    activadoladoderechoatras ="si";
                    
                }
                
                
                lugar = rs.getString("lugar");
                lbcantidad.setText(rs.getString("cantidad"));
                
                
                
                 identificador =  rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                if(lugar.equals("Esta sucursal"))
                {
                    
                  
                
                String cantidadladoizquierdofrente = rs.getString("cantidad_lado_izquierdo_frente");
                if(cantidadladoizquierdofrente.equals("0") && activadoladoizquierdofrente.equals("si"))
                {
                    btnladoizquierdofrentetetermine.setEnabled(true);
                    btnladoizquierdofrenteponchado.setEnabled(true);
                    
                     listabotones.add("btnladoizquierdofrente");
                }
                else
                {
                    btnladoizquierdofrentetetermine.setEnabled(false);
                    btnladoizquierdofrenteponchado.setEnabled(false);
                }    
                
                
                String cantidadladoderechofrente = rs.getString("cantidad_lado_derecho_frente");
             
                if(cantidadladoderechofrente.equals("0")&& cantidadladoderechofrente.equals("si"))
                {
                   btnladoderechofrentetetermine.setEnabled(true);
                   btnladoderechofrenteponchado.setEnabled(true);
                   
                   
                   listabotones.add("btnladoderechofrente");
                }
                else
                {
                   btnladoderechofrentetetermine.setEnabled(false); 
                   btnladoderechofrenteponchado.setEnabled(false);
                } 
                
                
                
                
                
                String cantidadladoizquierdoatras = rs.getString("cantidad_lado_izquierdo_atras");
                if(cantidadladoizquierdoatras.equals("0") && activadoladoizquierdoatras.equals("si"))
                {
                    btnladoizquierdoatrastetermine.setEnabled(true);
                    btnladoizquierdoatrasponchado.setEnabled(true);
                    
                    
                    listabotones.add("btnladoizquierdoatras");
                }
                else
                {
                    btnladoizquierdoatrastetermine.setEnabled(false);
                    btnladoizquierdoatrasponchado.setEnabled(false);
                } 
                
                
                
                
                
                String cantidadladoderechoatras = rs.getString("cantidad_lado_derecho_atras");
                if(cantidadladoderechoatras.equals("0")&& activadoladoderechoatras.equals("si"))
                {
                    btnladoderechoatrastetermine.setEnabled(true);
                    btnladoderechoatrasponchado.setEnabled(true);
                    
                    listabotones.add("btnladoderechoatras");
                }
                else
                {
                    btnladoderechoatrastetermine.setEnabled(false);
                    btnladoderechoatrasponchado.setEnabled(false);
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
       
         
            con = DriverManager.getConnection("jdbc:mysql://" + ipdelaotratienda + "/" + sucursal + "", "root", "sistemas");
      

        String sql7 = "Select cliente,lugar,identificador_prenda from historial_ordenes_pantalon where numero = '" + numerosucursal + "' ";

        try {
            Statement st = con.createStatement();
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
     
     
     
     try {
            
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection("jdbc:mysql://localhost/tiendas", "root", "sistemas");

            try {
              
                
                
                
                String sql = "SELECT ip FROM catalogo_tiendas where tienda = '" + sucursal + "'";

                Statement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {

                    ipdelaotratienda = rs.getString("ip");
              

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
                
                

                ping = InetAddress.getByName(ipdelaotratienda);
            
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
 
    
     
     
     
     
     
     
     
     

      void insertarlacantidadylafechaenlaubicacion(String ubicacion, String fechaubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set "+ubicacion+"='" + lbcantidad.getText() + "',"+fechaubicacion+"  =  '"+dia()+"' where numero = '"+lborden.getText()+"'  ");
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
      
    void eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion(String ubicacion, String fecha)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set "+ubicacion+"='0', "+fecha+"='' where numero = '"+lborden.getText()+"'  ");
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
      
      
    void insertarlacantidadylafechaenlaubicacionotrasucursal(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set "+ubicacion+"='" + lbcantidad.getText() + "',fecha='"+dia()+"' where numero = '"+lborden.getText()+"'  ");
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

    void agregarexistenciabordados(String descripcion,String aplicacioninsertar,String cantidadaplicacion)
    {
        
       
        
        //// bordado
        String InsertarSQL = "INSERT INTO historial_bordados_existencia(numero,dia,hora,articulo,concepto,cantidad,numero_sucursal,sucursal) VALUES (?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            
                
 
                pst.setString(1, lbnumerodeventa.getText());
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, descripcion);
                pst.setString(5, identificador);
                pst.setString(6, lbcantidad.getText());
                
                  if(sucursal.equals("") || sucursal.equals("ninguno") )
                {
                    
                    sucursal = tiendalocal;
                   numeroordendeenviosolicitada = "0";
                }
                 
                 else
                     
                 {
                    
                    if (sucursal.equals(tiendalocal))
                        
                    {
                       numerosucursal = numeroordendeenviosolicitada;
                     
                    }
                    else
                    {
                   JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encontró numero de venta ni numero de sucursal; llame a sistemas");
                         
                         
                    }
                    
                    
                 }
                  
                  pst.setString(7, numeroordendeenviosolicitada);
                  pst.setString(8, sucursal);
                  
                  
                
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
                pst.setString(1, lbnumerodeventa.getText());
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, aplicacioninsertar);
                pst.setString(5, identificador);
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
    
    
    void agregarexistenciabordadoscancelar(String descripcion,String aplicacioninsertar,String cantidadaplicacion)
    {
        
        try {
                PreparedStatement pst = cn.prepareStatement("DELETE FROM historial_bordados_existencia WHERE numero='"+lbnumerodeventa.getText()+"' and articulo ='"+descripcion+"'   ");
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
                PreparedStatement pst = cn.prepareStatement("DELETE FROM historial_bordados_existencia WHERE numero='"+lbnumerodeventa.getText()+"' and articulo ='"+aplicacioninsertar+"'   ");
                pst.executeUpdate();
                pst.close();
            
            } catch (Exception e) {
                System.out.println(e);
            }
               
               
           }

        
    }
    
    
    
      
     void cliente(){
        
        
        String cliente = lbcliente.getText();
        
          String sql = "SELECT nombre_comercial,borda_cliente FROM catalogo_clientes WHERE nombre = '" + cliente + "' ";

                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    if (rs.next()) {

                        
                      
                        lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                        lbbordacliente.setText(rs.getString("borda_cliente"));

                    }

                } catch (Exception e) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+e+"");

                }
        
    }
    
    
    void agregarexistenciabordadosotrasucursal(String descripcion,String aplicacioninsertar,String cantidadaplicacion)
    {
        
       
        
        //// bordado
        String InsertarSQL = "INSERT INTO historial_bordados_existencia(numero_sucursal,sucursal,dia,hora,articulo,concepto,cantidad) VALUES (?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            
                
 
                pst.setString(1, lbnumerodeventa.getText());
                pst.setString(2, sucursal);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, descripcion);
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
            
                
 
                 pst.setString(1,lbnumerodeventa.getText());
                pst.setString(2, sucursal);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, descripcion);
                pst.setString(6, "ninguno");
                pst.setString(7, lbcantidad.getText());
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
               
           }
        
        
    }
    
     void agregaralsurtidasalhistorialdeventasyactualizarestatusentrega(String ubicacion, String cantidad) 
      {

        String numeroventa =  lbnumerodeventa.getText();
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

        String numeroventa =  lbnumerodeventa.getText();
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
        String sql = "SELECT codigo_cliente FROM historial_ventas WHERE numero = '" + lbnumerodeventa.getText() + "' ";


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
                 PreparedStatement ps = cn.prepareStatement("select " + ubicacion + "," + ubicacionnombre + " from historial_ordenes_pantalon_recibidas where numero = '" + lborden.getText() + "' ")) {
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
                  + "cantidad_lado_derecho_atras,lado_derecho_atras from historial_ordenes_pantalon where numero = '"+lborden.getText()+"' ";

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

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set estatus_orden='realizada totalmente',fecha='"+dia()+"' where numero='" + lborden.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                  
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
               
           }
           else
           {
                try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set estatus_orden='generada' where numero='" + lborden.getText() + "'   ");
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
        lborden = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        lbnumerodeventa = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        btnreplicar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbfotomontaje = new javax.swing.JLabel();
        lbtiendareplica = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        btnladoderechofrentetetermine = new javax.swing.JButton();
        btnladoderechoatrastetermine = new javax.swing.JButton();
        btnladoizquierdofrentetetermine = new javax.swing.JButton();
        btnladoizquierdoatrastetermine = new javax.swing.JButton();
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
        lbcodigoladoizquierdoatras = new javax.swing.JLabel();
        lbcodigoladoizquierdofrente = new javax.swing.JLabel();
        lbcodigoladoderechoatras = new javax.swing.JLabel();
        btneliminarbtneditarbordado = new javax.swing.JButton();
        lbidentificador = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        lbladoderechoatraspuntadas = new javax.swing.JLabel();
        lbladoizquierdoatraspuntadas = new javax.swing.JLabel();
        lbladoizquierdofrentepuntadas = new javax.swing.JLabel();
        lbladoderechofrentepuntadas = new javax.swing.JLabel();
        btnfotomontajesinpuntadas = new javax.swing.JButton();
        btnvercolorido = new javax.swing.JButton();
        btndatos = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        lbnumerosucursal = new javax.swing.JLabel();
        lbprenda = new javax.swing.JLabel();
        btnladoderechofrentecancelar = new javax.swing.JButton();
        btnladoderechoatrascancelar = new javax.swing.JButton();
        btnladoizquierdofrentecancelar = new javax.swing.JButton();
        btnladoizquierdoatrascancelar = new javax.swing.JButton();
        lbladoderechoatras1 = new javax.swing.JLabel();
        lbdadoizquierdoatras1 = new javax.swing.JLabel();
        lbladoizquierdofrente1 = new javax.swing.JLabel();
        lbladoderechofrente1 = new javax.swing.JLabel();
        btnladoderechofrenteponchado = new javax.swing.JButton();
        btnladoderechoatrasponchado = new javax.swing.JButton();
        btnladoizquierdofrenteponchado = new javax.swing.JButton();
        btnladoizquierdoatrasponchado = new javax.swing.JButton();
        lbladoizquierdoatraspuntadas1 = new javax.swing.JLabel();
        lbladoderechoatraspuntadas1 = new javax.swing.JLabel();
        lbladoderechofrentepuntadas1 = new javax.swing.JLabel();
        lbladoizquierdofrentepuntadas1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbestatus = new javax.swing.JLabel();

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
        jLabel13.setText("Numero de orden");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lborden.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lborden.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Cliente:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lbnumerodeventa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumerodeventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("No. de Venta");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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
        lbfotomontaje.setBounds(0, 0, 1160, 720);

        lbtiendareplica.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbtiendareplica.setText("Replicar a tienda");
        lbtiendareplica.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Cantidad");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcantidad.setText("0");
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnladoderechofrentetetermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechofrentetetermine.setText("Termine");
        btnladoderechofrentetetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechofrentetetermineActionPerformed(evt);
            }
        });

        btnladoderechoatrastetermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechoatrastetermine.setText("Termine");
        btnladoderechoatrastetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechoatrastetermineActionPerformed(evt);
            }
        });

        btnladoizquierdofrentetetermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdofrentetetermine.setText("Termine");
        btnladoizquierdofrentetetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdofrentetetermineActionPerformed(evt);
            }
        });

        btnladoizquierdoatrastetermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdoatrastetermine.setText("Termine");
        btnladoizquierdoatrastetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdoatrastetermineActionPerformed(evt);
            }
        });

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

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Bordacliente");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Nombre comercial");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoderechofrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoderechofrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoizquierdoatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoizquierdoatras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoizquierdofrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoizquierdofrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoderechoatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoderechoatras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btneliminarbtneditarbordado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminarbtneditarbordado.setText("Editar bordado");
        btneliminarbtneditarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarbtneditarbordadoActionPerformed(evt);
            }
        });

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbidentificador.setForeground(new java.awt.Color(153, 0, 0));
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Observaciones");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        lbladoderechoatraspuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechoatraspuntadas.setForeground(new java.awt.Color(255, 0, 0));
        lbladoderechoatraspuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdoatraspuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdoatraspuntadas.setForeground(new java.awt.Color(255, 0, 0));
        lbladoizquierdoatraspuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdofrentepuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdofrentepuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbprenda.setText("Pantalon");
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnladoderechofrentecancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechofrentecancelar.setText("Cancelar");
        btnladoderechofrentecancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechofrentecancelarActionPerformed(evt);
            }
        });

        btnladoderechoatrascancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechoatrascancelar.setText("Cancelar");
        btnladoderechoatrascancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechoatrascancelarActionPerformed(evt);
            }
        });

        btnladoizquierdofrentecancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdofrentecancelar.setText("Cancelar");
        btnladoizquierdofrentecancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdofrentecancelarActionPerformed(evt);
            }
        });

        btnladoizquierdoatrascancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdoatrascancelar.setText("Cancelar");
        btnladoizquierdoatrascancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdoatrascancelarActionPerformed(evt);
            }
        });

        lbladoderechoatras1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechoatras1.setText("Lado derecho atras");
        lbladoderechoatras1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdadoizquierdoatras1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdadoizquierdoatras1.setText("Lado izquierdo atras");
        lbdadoizquierdoatras1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdofrente1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdofrente1.setText("Lado izquierdo frente");
        lbladoizquierdofrente1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderechofrente1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechofrente1.setText("Lado derecho frente");
        lbladoderechofrente1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnladoderechofrenteponchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechofrenteponchado.setText("Ponchado");
        btnladoderechofrenteponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechofrenteponchadoActionPerformed(evt);
            }
        });

        btnladoderechoatrasponchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechoatrasponchado.setText("Ponchado");
        btnladoderechoatrasponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechoatrasponchadoActionPerformed(evt);
            }
        });

        btnladoizquierdofrenteponchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdofrenteponchado.setText("Ponchado");
        btnladoizquierdofrenteponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdofrenteponchadoActionPerformed(evt);
            }
        });

        btnladoizquierdoatrasponchado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdoatrasponchado.setText("Ponchado");
        btnladoizquierdoatrasponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdoatrasponchadoActionPerformed(evt);
            }
        });

        lbladoizquierdoatraspuntadas1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdoatraspuntadas1.setForeground(new java.awt.Color(255, 0, 0));
        lbladoizquierdoatraspuntadas1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderechoatraspuntadas1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechoatraspuntadas1.setForeground(new java.awt.Color(255, 0, 0));
        lbladoderechoatraspuntadas1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderechofrentepuntadas1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechofrentepuntadas1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdofrentepuntadas1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdofrentepuntadas1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Fecha de elaboracion");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Sucursal");
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Prenda");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setText("Identificador");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Fecha Entrega");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Hora Entrega");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Estatus");
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbestatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbestatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel16)
                        .addGap(7, 7, 7)
                        .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnfotomontajesinpuntadas))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btneliminarbtneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jButton2))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(45, 45, 45)
                                .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(17, 17, 17))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(115, 115, 115))))
                            .addComponent(jScrollPane6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(158, 158, 158)
                                        .addComponent(btndatos))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(348, 348, 348)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(167, 167, 167)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbnumerosucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(212, 212, 212)
                                        .addComponent(jLabel18))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel30)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 61, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbladoderechoatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(btnladoderechoatrastetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(btnladoderechoatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbladoizquierdofrente1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbladoderechofrente1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbdadoizquierdoatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnladoizquierdofrentetetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnladoderechofrentetetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnladoizquierdoatrastetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnladoizquierdofrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnladoderechofrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnladoizquierdoatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbladoderechoatraspuntadas1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                    .addComponent(lbladoderechofrentepuntadas1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                    .addComponent(lbladoizquierdoatraspuntadas1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
                                    .addComponent(lbladoizquierdofrentepuntadas1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbladoderechoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbladoizquierdofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbladoderechofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbladoizquierdoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcodigoladoizquierdofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigoladoderechofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigoladoizquierdoatras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcolorpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolormangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolorpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbcodigoladoderechoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(20, 20, 20)
                                        .addComponent(lbcolormangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(38, 38, 38)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnladoizquierdofrenteponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnladoderechofrenteponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnladoizquierdoatrasponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnladoderechoatrasponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(458, 458, 458)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbtiendareplica, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(14, 14, 14)
                                        .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminarbtneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnfotomontajesinpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbnumerosucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndatos))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(321, 321, 321)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbladoizquierdofrente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbladoderechofrente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbdadoizquierdoatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnladoizquierdofrentetetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnladoderechofrentetetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnladoizquierdoatrastetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnladoizquierdofrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnladoderechofrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnladoizquierdoatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcolorpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcolormangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcolorpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbladoizquierdofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbladoderechofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbladoizquierdoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnladoizquierdofrenteponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnladoderechofrenteponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnladoizquierdoatrasponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbtiendareplica, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcodigoladoizquierdofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcodigoladoderechofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbcodigoladoizquierdoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbladoderechoatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnladoderechoatrastetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnladoderechoatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcodigoladoderechoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolormangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbladoderechoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnladoderechoatrasponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbladoizquierdofrentepuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbladoderechofrentepuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbladoizquierdoatraspuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbladoderechoatraspuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
        numerosucursal = lborden.getText();
        prenda = "Pantalon";
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
        ipdelaotratienda = stringIP;
       sucursal = stringlocal;

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
            conn = DriverManager.getConnection("jdbc:mysql://" + ipdelaotratienda + "/" + sucursal + "", "root", "sistemas");

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

            String numero = lborden.getText();
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

    private void btnladoizquierdofrentetetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdofrentetetermineActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
      
            
            
            String ubicacion = "cantidad_lado_izquierdo_frente";
            fechaubicacion = "lado_izquierdo_frente_fecha";
          
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);
            
            String cantidadaplicacion = "0";
            descripcion = "BORDADO PANTALON FRENTE LADO IZQUIERDO "+ladoizquierdofrentenombre + "";
            aplicacioninsertar = "";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) descripcion,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad) ;
            estacompletalaorden();
            
        
             
        }      
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaladoizquierdofrente= fl ;
            btnladoizquierdofrentetetermine.setEnabled(false);

        }
        
        }
        
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
     
            
            String ubicacion = "cantidad_lado_izquierdo_frente";
            String nombrebordado = ladoizquierdofrentenombre;
            String cantidadaplicacion = "0";
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
            agregarexistenciabordadosotrasucursal((String) descripcion, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            
            
            
             
            
        }
        
         try {
                 datosOrdenesLocales();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
             }

        
        }
    }//GEN-LAST:event_btnladoizquierdofrentetetermineActionPerformed

    private void btnladoizquierdoatrastetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrastetermineActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            

            
            String ubicacion = "cantidad_lado_izquierdo_atras";
            fechaubicacion = "lado_izquierdo_atras_fecha";
          
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);
            
            String cantidadaplicacion = "0";
            descripcion = "BORDADO PANTALON ATRAS LADO IZQUIERDO "+ladoizquierdoatrasnombre + "";
            aplicacioninsertar = "";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) descripcion,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad) ;
            estacompletalaorden();
           
        }
         else if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaladoizquierdoatras=fl;
            btnladoizquierdoatrastetermine.setEnabled(false);

        }
        
        }
       
         else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
    
            
            String ubicacion = "cantidad_lado_izquierdo_atras";
            String nombrebordado = ladoizquierdoatrasnombre;
            String cantidadaplicacion = "0";
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
            agregarexistenciabordadosotrasucursal((String) descripcion, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            
            
            
             
            
        }
         
        
         try {
                 datosOrdenesLocales();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
        
        }
    }//GEN-LAST:event_btnladoizquierdoatrastetermineActionPerformed

    private void btnladoderechoatrastetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoatrastetermineActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
         if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            
            String ubicacion = "cantidad_lado_derecho_atras";
            fechaubicacion = "lado_derecho_atras_fecha";
            
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);
            
            String cantidadaplicacion = "0";
            descripcion = "BORDADO PANTALON ATRAS LADO DERECHO "+ladoderechoatrasnombre + "";
            aplicacioninsertar = "";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) descripcion,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad) ;
            estacompletalaorden();
        
        
        }
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaladoderechoatras= fl;
            btnladoderechoatrastetermine.setEnabled(false);

        }
        
        }
       else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
      
            
            String ubicacion = "cantidad_lado_derecho_atras";
            String nombrebordado = ladoderechoatrasnombre;
            String cantidadaplicacion = "0";
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
            agregarexistenciabordadosotrasucursal((String) descripcion, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            
            
           
             
            
        }
         
          try {
                 datosOrdenesLocales();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
             }
         
         
        }
    }//GEN-LAST:event_btnladoderechoatrastetermineActionPerformed

    private void btnladoderechofrentetetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechofrentetetermineActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
         if(lugar.equals("Esta sucursal")  && tipotabla.equals("Local"))
         {
             
          
    
            String ubicacion = "cantidad_lado_derecho_frente";
            fechaubicacion = "lado_derecho_frente_fecha";
            
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);
            
            String cantidadaplicacion = "0";
            descripcion = "BORDADO PANTALON FRENTE LADO DERECHO "+ladoderechofrentenombre + "";
            aplicacioninsertar = "";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) descripcion,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad) ;
            estacompletalaorden();
            
        
        
        }
        else if(lugar.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser(rutadedondeestanlosbordados);

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            rutaladoderechofrente=fl;
            btnladoderechofrentetetermine.setEnabled(false);

        }
        
        }
          else if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
        
            String ubicacion = "cantidad_lado_derecho_frente";
            String nombrebordado = ladoderechoatrasnombre;
            String cantidadaplicacion = "0";
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            insertarlacantidadylafechaenlaubicacionotrasucursal((String) ubicacion);
            agregarexistenciabordadosotrasucursal((String) descripcion, (String) aplicacioninsertar, (String) cantidadaplicacion);
            estacompletalaorden();
            
            
            
        }
         
         
             try {
                 datosOrdenesLocales();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalon.class.getName()).log(Level.SEVERE, null, ex);
             }
         
         
        }
    }//GEN-LAST:event_btnladoderechofrentetetermineActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
      ventanaordenpantalonanteriores = false;
       
    }//GEN-LAST:event_formWindowClosed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed

          
        if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
   
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ordengorra.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
      
                 cn = DriverManager.getConnection("jdbc:mysql://" + iplocal + "/" + tiendalocal + "", "root", "sistemas");
            } catch (SQLException ex) {
                Logger.getLogger(ordengorra.class.getName()).log(Level.SEVERE, null, ex);
            }
       
       
      
        
    }
    else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
       
        
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ordengorra.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                cn = DriverManager.getConnection("jdbc:mysql://" + ipdelaotratienda + "/" + sucursal + "", "root", "sistemas");
            } catch (SQLException ex) {
                Logger.getLogger(ordengorra.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
        
        
         verfotomontaje();
            
        
        
    }//GEN-LAST:event_btnverfotomontajeActionPerformed

    private void btnterminetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterminetodoActionPerformed

        terminetodo = "si";

        for(int i = 0; i < listabotones.size(); i++)
        {
            Object boton =  listabotones.get(i);

            if(boton.equals("btnladoizquierdofrente"))
            {
                
                if(btnladoizquierdofrentetetermine.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoizquierdofrentetetermine.doClick();
                }
                
            }
            else if(boton.equals("btnladoderechofrente"))
            {
                if(btnladoderechofrentetetermine.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoderechofrentetetermine.doClick();
                }
            }
            else if(boton.equals("btnladoizquierdoatras"))
            {
                if(btnladoizquierdoatrastetermine.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoizquierdoatrastetermine.doClick();
                }
            }
            else if(boton.equals("btnladoderechoatras"))
            {
                if(btnladoderechoatrastetermine.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoderechoatrastetermine.doClick();
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

    private void btneliminarbtneditarbordadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarbtneditarbordadoActionPerformed


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

    }//GEN-LAST:event_btneliminarbtneditarbordadoActionPerformed

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

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigocliente+"' and identificador_prenda = '"+identificador+"' and tipo = 'PANTALON' and numero_consecutivo = '"+consecutivo+"' ";

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
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"',puntadas_en_fotomontajes ='no' where codigo='"+codigocliente+"' and identificador_prenda = '"+identificador+"' and tipo = 'PANTALON' and numero_consecutivo = '"+consecutivo+"' ");
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
            colorido.lbidentificador.setText(lbidentificador.getText());
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

    private void btnladoderechofrentecancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechofrentecancelarActionPerformed
             if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de manga derecha?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                 {
                     String ubicacion = "cantidad_lado_derecho_frente";
                     String fecha = "lado_derecho_frente_fecha";
                    eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
                    
                    
                     String cantidadaplicacion = "0";
                     descripcion = "BORDADO PANTALON FRENTE LADO DERECHO " + ladoderechofrentenombre + "";
                     aplicacioninsertar = "";
                     String cantidad = lbcantidad.getText();
                     agregarexistenciabordadoscancelar((String) descripcion, (String) aplicacioninsertar, (String) cantidadaplicacion);
                     agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad);
                     estacompletalaorden();
                 }
    }//GEN-LAST:event_btnladoderechofrentecancelarActionPerformed

    private void btnladoderechoatrascancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoatrascancelarActionPerformed
           if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de manga derecha?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                 {
                     String ubicacion = "cantidad_lado_derecho_atras";
                     String fecha = "lado_derecho_atras_fecha";
                    eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
                    
                    
                     String cantidadaplicacion = "0";
                     descripcion = "BORDADO PANTALON ATRAS LADO DERECHO "+ladoderechoatrasnombre + "";
                     aplicacioninsertar = "";
                     String cantidad = lbcantidad.getText();
                     agregarexistenciabordadoscancelar((String) descripcion, (String) aplicacioninsertar, (String) cantidadaplicacion);
                     agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad);
                     estacompletalaorden();
                 }

    }//GEN-LAST:event_btnladoderechoatrascancelarActionPerformed

    private void btnladoizquierdofrentecancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdofrentecancelarActionPerformed
        if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de manga derecha?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                 {
                     String ubicacion = "cantidad_lado_izquierdo_frente";
                     String fecha = "lado_izquierdo_frente_fecha";
                     eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
                    
                    
                     String cantidadaplicacion = "0";
                     descripcion = "BORDADO PANTALON FRENTE LADO IZQUIERDO "+ladoizquierdofrentenombre + "";
                     aplicacioninsertar = "";
                     String cantidad = lbcantidad.getText();
                     agregarexistenciabordadoscancelar((String) descripcion, (String) aplicacioninsertar, (String) cantidadaplicacion);
                     agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad);
                     estacompletalaorden();
                 }
    }//GEN-LAST:event_btnladoizquierdofrentecancelarActionPerformed

    private void btnladoizquierdoatrascancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrascancelarActionPerformed
     if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de manga derecha?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
                 {
                    String ubicacion = "cantidad_lado_izquierdo_atras";
                    String fecha = "lado_izquierdo_atras_fecha";
                    eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
                    
                    
                     String cantidadaplicacion = "0";
                     descripcion = "BORDADO PANTALON ATRAS LADO IZQUIERDO "+ladoizquierdoatrasnombre + "";
                     aplicacioninsertar = "";
                     String cantidad = lbcantidad.getText();
                     agregarexistenciabordadoscancelar((String) descripcion, (String) aplicacioninsertar, (String) cantidadaplicacion);
                     agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad);
                     estacompletalaorden();
                 }
    }//GEN-LAST:event_btnladoizquierdoatrascancelarActionPerformed

    private void btnladoderechofrenteponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechofrenteponchadoActionPerformed
       String ubicacion ="lado_derecho_frente_ponchado";
                String ubicacionnombre ="lado_derecho_frente_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
    }//GEN-LAST:event_btnladoderechofrenteponchadoActionPerformed

    private void btnladoderechoatrasponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoatrasponchadoActionPerformed
       String ubicacion ="lado_derecho_atras_ponchado";
                String ubicacionnombre ="lado_derecho_atras_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
    }//GEN-LAST:event_btnladoderechoatrasponchadoActionPerformed

    private void btnladoizquierdofrenteponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdofrenteponchadoActionPerformed
          String ubicacion ="lado_izquierdo_frente_ponchado";
                String ubicacionnombre ="lado_izquierdo_frente_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
    }//GEN-LAST:event_btnladoizquierdofrenteponchadoActionPerformed

    private void btnladoizquierdoatrasponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrasponchadoActionPerformed
       String ubicacion ="lado_izquierdo_atras_ponchado";
                String ubicacionnombre ="lado_izquierdo_atras_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
    }//GEN-LAST:event_btnladoizquierdoatrasponchadoActionPerformed

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
    private javax.swing.JButton btneliminarbtneditarbordado;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    private javax.swing.JButton btnladoderechoatrascancelar;
    private javax.swing.JButton btnladoderechoatrasponchado;
    private javax.swing.JButton btnladoderechoatrastetermine;
    private javax.swing.JButton btnladoderechofrentecancelar;
    private javax.swing.JButton btnladoderechofrenteponchado;
    private javax.swing.JButton btnladoderechofrentetetermine;
    private javax.swing.JButton btnladoizquierdoatrascancelar;
    private javax.swing.JButton btnladoizquierdoatrasponchado;
    private javax.swing.JButton btnladoizquierdoatrastetermine;
    private javax.swing.JButton btnladoizquierdofrentecancelar;
    private javax.swing.JButton btnladoizquierdofrenteponchado;
    private javax.swing.JButton btnladoizquierdofrentetetermine;
    private javax.swing.JButton btnreplicar;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
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
    public static javax.swing.JLabel lbdadoizquierdoatras1;
    public static javax.swing.JLabel lbestatus;
    private javax.swing.JLabel lbfotomontaje;
    public static javax.swing.JLabel lbidentificador;
    public static javax.swing.JLabel lbladoderechoatras1;
    public static javax.swing.JLabel lbladoderechoatraspuntadas;
    public static javax.swing.JLabel lbladoderechoatraspuntadas1;
    public static javax.swing.JLabel lbladoderechofrente1;
    public static javax.swing.JLabel lbladoderechofrentepuntadas;
    public static javax.swing.JLabel lbladoderechofrentepuntadas1;
    public static javax.swing.JLabel lbladoizquierdoatraspuntadas;
    public static javax.swing.JLabel lbladoizquierdoatraspuntadas1;
    public static javax.swing.JLabel lbladoizquierdofrente1;
    public static javax.swing.JLabel lbladoizquierdofrentepuntadas;
    public static javax.swing.JLabel lbladoizquierdofrentepuntadas1;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumerodeventa;
    public static javax.swing.JLabel lbnumerosucursal;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    public static javax.swing.JLabel lbprenda;
    public javax.swing.JLabel lbsumapuntos;
    private javax.swing.JLabel lbtiendareplica;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

   
}
