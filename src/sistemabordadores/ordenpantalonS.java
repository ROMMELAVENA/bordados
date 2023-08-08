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
import static sistemabordadores.ordengorraS.lbcliente;

public class ordenpantalonS extends javax.swing.JFrame {

    public static boolean ventanaordenpantalonanteriores = false;
    public static String ordenbordadopantalon = "";
    
    
    int traspaso = 0;
    String ipsucursal = "";
    String iplocal = principal.lbiplocal.getText();
    String sucursal = "";
    String tiendaconectada = "";
    String cliente = "";
    String numerosucursal = "";
    String fechaubicacion = "";
    String cantidadprendasstring = "";
    int cantidadprendasint = 0;
    String cantidad = "";
    Connection cnsucursal = null;
    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;
    String cantidadaplicacion = "";
    String primero = "";
    String ultimo = "";
    String numerodeventa = "";
    String numeropedido = "";
    String tiendaalaqueselesolicito = "";
    String lugar = "";
    String nuevoestatusorden = "";
    ///
    String descripcion = "";
    String aplicacioninsertar = "";
    String numeroordendeenviosolicitada = "";
    String ladoizquierdofrentenombre = "";
    String ladoderechofrentenombre = "";
    String ladoizquierdoatrasnombre = "";
    String ladoderechoatrasnombre = "";
 
     String numeroordendebordadolocalorecibida = "";
    
    
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
       
       

    public ordenpantalonS()
    {
        initComponents();
        ventanaordenpantalonanteriores = true;
        
        btnterminetodo.setEnabled(false);
      //  btndatos.setEnabled(false);
        
        btnladoderechofrentecancelar.setEnabled(false);
        btnladoderechoatrascancelar.setEnabled(false);        
        btnladoizquierdofrentecancelar.setEnabled(false);        
        btnladoizquierdoatrascancelar.setEnabled(false);
       lbautorizacion.setVisible(false);
           
                
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
        else if(tiendalocal.equals("tijuana"))
        {
            rutadedondeestanlosbordados = "C:\\Users\\Mostrador DFNorte\\OneDrive\\PONCHADOS\\TIJUANA\\PONCHADOS SINCRONIZADOS";
        }
        else if(tiendalocal.equals("monterrey"))
        {
            rutadedondeestanlosbordados = "C:\\onedrive\\PONCHADOS\\MONTERREY\\PONCHADOS";
        }
        
        
    }
    
    
    
    
    
    
    void datos(){
        
        
        
        
        
        
         if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
        
        nombredelatabla = "historial_ordenes_pantalon";
        
     try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
      codigocliente();
        
        cliente();
        
         hilosycolor();
        
     
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
     
        cliente();
        
        
        
        
    } 
    
    else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
        
        nombredelatabla = "historial_ordenes_pantalon_recibidas";
        
         try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
         
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
        
      
        
        
    }
    
    
    
    
    
    
    
    

    void datostiendalocal() throws FileNotFoundException, IOException
    {
      
       
        
         numeroordendebordadolocalorecibida = lborden.getText();
      
        String prenda ="";
      
        
        String activadoladoizquierdofrente ="";
        String activadoladoizquierdoatras ="";
        String activadoladoderechofrente ="";
        String activadoladoderechoatras ="";


        

        String sql = "Select fecha,hora,cliente,nombre_comercial,borda_cliente,numero_venta,estatus_orden,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,lado_izquierdo_frente_nombre,lado_derecho_frente_nombre,lado_izquierdo_atras_nombre,lado_derecho_atras_nombre,lado_izquierdo_frente_cantidad,lado_derecho_frente_cantidad,lado_izquierdo_atras_cantidad,lado_derecho_atras_cantidad,lado_izquierdo_frente_puntadas,lado_derecho_frente_puntadas,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas,lugar,identificador_prenda,numero_orden from historial_ordenes_pantalon where numero = '" + numeroordendebordadolocalorecibida + "'";

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

                
                
                ladoizquierdofrentenombre = rs.getString("lado_izquierdo_frente_puntadas");
                ladoderechofrentenombre = rs.getString("lado_derecho_frente_puntadas");
                ladoizquierdoatrasnombre = rs.getString("lado_izquierdo_atras_puntadas");
                ladoderechoatrasnombre = rs.getString("lado_derecho_atras_puntadas");
                identificador = rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                lugar = rs.getString("lugar");
                
                cantidad = rs.getString("cantidad");
                lbcantidad.setText(cantidad);
                
                        
                
              
                if (ladoizquierdofrentenombre == null || ladoizquierdofrentenombre.equals("")) 
                {
                    
                 
                  btnladoizquierdofrenteponchado.setEnabled(false);
                  
                  

                }
                
                else
                
                {

                   lbladoizquierdofrentenombre.setText(ladoizquierdofrentenombre);
                   lbladoizquierdofrentepuntadas.setText(rs.getString("lado_izquierdo_frente_puntadas"));
                    
                    btnladoizquierdofrenteponchado.setEnabled(true);
                 
                    activadoladoizquierdofrente ="si";
                    
                    
                    
                }

                
                /// lado derecho frente
                
               
                if (ladoderechofrentenombre == null || ladoderechofrentenombre.equals("")) 
                {
                   
                    btnladoderechofrenteponchado.setEnabled(false);
                } 
                else
                {

                     lbladoderechofrentenombre.setText(ladoderechofrentenombre);
                    lbladoderechofrentepuntadas.setText(rs.getString("lado_derecho_frente_nombre"));
                  
                    btnladoderechofrenteponchado.setEnabled(true);
                    
                    activadoladoderechofrente ="si";
                   
                }

                
                
                
                
                
            
                if (ladoizquierdoatrasnombre == null || ladoizquierdoatrasnombre.equals(""))
                {
                   
                    btnladoizquierdoatrasponchado.setEnabled(false);
                } 
                else 
                {


                    lbladoizquierdoatrasnombre.setText(ladoizquierdoatrasnombre);
                    lbladoizquierdoatraspuntadas.setText(rs.getString("lado_izquierdo_atras_puntadas"));
                  
                     btnladoizquierdoatrasponchado.setEnabled(true);
                    
                    activadoladoizquierdoatras ="si";
           
                   
                    
                }

               
                if (ladoderechoatrasnombre == null || ladoderechoatrasnombre.equals("")) 
                {
                   
                     btnladoderechoatrasponchado.setEnabled(false);
                }
                else 
                {


                   lbladoderechoatrasnombre.setText(ladoderechoatrasnombre);
                    lbladoderechoatraspuntadas.setText(rs.getString("lado_derecho_atras_puntadas"));
                    
                     btnladoderechoatrasponchado.setEnabled(true);
                 
                    activadoladoderechoatras ="si";
                    
                   
                    
                }
                
                
                
                
                
                
                
                
                
                
                
              
                
                if(lugar.equals("Esta sucursal"))
                {
                    
                  
                
                String cantidadladoizquierdofrente = rs.getString("lado_izquierdo_frente_cantidad");
                String cantidadladoderechofrente = rs.getString("lado_derecho_frente_cantidad");
                 String cantidadladoizquierdoatras = rs.getString("lado_izquierdo_atras_cantidad");
                String cantidadladoderechoatras = rs.getString("lado_derecho_atras_cantidad");
                
                
                
                 if( activadoladoizquierdofrente.equals("si"))
                {
                    
                    
                    
                    if(cantidadladoizquierdofrente.equals("0") )
                        
                    {
                    
                    btnladoizquierdofrentetetermine.setEnabled(true);
                    btnladoizquierdofrentecancelar.setEnabled(false);
                    
                     lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
                    
                    
                    
                    
                    
                    listabotones.add("btnladoizquierdofrente");
                    
                    
                    
                    }
                    
                    else
                        
                    {
                        
                           btnladoizquierdofrentecancelar.setEnabled(true);
                           btnladoizquierdofrentetetermine.setEnabled(false);
                           
                           
                        lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());
                        
                    }
                    
                    
                    
                    
                }
                else
                {
                   btnladoizquierdofrentetetermine.setEnabled(false);
                   
                }    
                
                
                
                 
                 
                 
                 
                 
                 
                if(cantidadladoderechofrente.equals("si"))
                {
                    
                    
                    
                    
                     if(cantidadladoderechofrente.equals("0"))
                    
                     {
                   btnladoderechofrentetetermine.setEnabled(true);
                   btnladoderechoatrascancelar.setEnabled(false);
                    
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                    
                   listabotones.add("btnladoderechofrente");
                   
                   
                     }
                     
                     else
                     {
                         
                            btnladoderechoatrascancelar.setEnabled(true);
                            btnladoderechofrentetetermine.setEnabled(false);
                  lbcantidad2.setText(cantidad);
                   lbcantidad2.setForeground(Color.GREEN.darker());
                         
                         
                     }
                     
                     
                }
                else
                {
                    
                    
                  btnladoderechofrentetetermine.setEnabled(false);
                
                
                } 
                
              
                
                
                
               
                if( activadoladoizquierdoatras.equals("si"))
                {
                    
                    
                    
                    if(cantidadladoizquierdoatras.equals("0"))
                        
                    {
                    btnladoizquierdoatrastetermine.setEnabled(true);
                   btnladoizquierdofrentecancelar.setEnabled(false);
                     
                      lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                     
                     
                    listabotones.add("btnladoizquierdoatras");
                    
                    
                    }
                    
                    else
                        
                    {
                            btnladoizquierdofrentecancelar.setEnabled(true);
                             btnladoizquierdoatrastetermine.setEnabled(false);
                  lbcantidad3.setText(cantidad);
                   lbcantidad3.setForeground(Color.GREEN.darker());
                        
                    }
                    
                    
                }
                else
                {
                    btnladoizquierdoatrastetermine.setEnabled(false);
                
                } 
                
                
                
                if( activadoladoderechoatras.equals("si"))
                {
                    
                    
                    
                    if(cantidadladoderechoatras.equals("0"))
                        
                        
                    {
                    btnladoderechoatrastetermine.setEnabled(true);
                    btnladoizquierdoatrascancelar.setEnabled(false);
                     
                      lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                     
                     
                    listabotones.add("btnladoderechoatras");
                    
                    }
                    
                    
                    else
                        
                    {
                        
                           
                 btnladoizquierdoatrascancelar.setEnabled(true);
                  btnladoderechoatrastetermine.setEnabled(false);
                  
                  
                   lbcantidad4.setText(cantidad);
                   lbcantidad4.setForeground(Color.GREEN.darker());
                        
                    }
                    
                }
                else
                {
                     btnladoderechoatrastetermine.setEnabled(false);
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
        
        
         String sqlcodigo = "Select codigo_cliente from historial_ventas where numero = '" + numerodeventa + "'  ";

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

        datosdepedidosyenvios();
        cargarfotomontaje();

    }
    
    
    
    
    
     void verfotomontajetiendalocal()
    {
      
        String rutadelarchivo = "";
        String existe = "";
    
     
        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'PANTALON'   ";

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

                JOptionPane.showMessageDialog(null,"<HTML><b style=\"Color:red; font-size:20px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        
        } 
        
    }
    
    
    
     
     
    
    
     void verfotomontajesucursal()
    {
      
        String rutadelarchivo = "";
        String existe = "";
    
     
        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'PANTALON'   ";

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

                JOptionPane.showMessageDialog(null,"<HTML><b style=\"Color:red; font-size:20px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        
        } 
        
    }
    
    
    
    
    
    
    
    
    
    
     void datosdepedidosyenvios() {
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
        
        
        lbsucursal.setText(tiendaalaqueselesolicito);

    }
    
     
     
     
     
    
      void cargarfotomontajeotrasucursal() throws FileNotFoundException, IOException  
    {
        
        
        prenda = "Pantalon";
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);
        
        
        if (sucursal.equals(tiendalocal))
            
        {
            
      
        numerosucursal = lbnumerodelaotrasucursal.getText();
        

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
            
            
           
            
        

       String sql = "Select imagen_nombre,imagen from historial_ordenes_pantalon_recibidas where numero = '"+numeroordendebordadolocalorecibida+"'  and prenda = '"+prenda+"'   ";  ///

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
         */
        
    }

        }
    
     
     
    }
     
     
 
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
    
    
    
    
    
    
    
    
     void cargarfotomontaje() throws FileNotFoundException, IOException  
    {
        
      
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);
     

       String sql = "Select extension_imagen,imagen,numero_consecutivo,puntadas_en_fotomontajes from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'PANTALON'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                 consecutivo=rs.getString("numero_consecutivo");
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
    
     
     void datosotrasucursal () throws FileNotFoundException, IOException
    {
        
         numeroordendebordadolocalorecibida = lborden.getText();
         prenda = "Pantalon";
       

        String activadoladoizquierdofrente = "";
        String activadoladoizquierdoatras = "";
        String activadoladoderechofrente = "";
        String activadoladoderechoatras = "";

        String sql = "Select fecha,hora,cliente,nombre_comercial,borda_cliente,numero_orden_o_pedido_solicitada,tienda,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,lado_izquierdo_frente_nombre,lado_derecho_frente_nombre,lado_izquierdo_atras_nombre,lado_derecho_atras_nombre,lado_izquierdo_frente_nombre,lado_derecho_frente_cantidad,lado_izquierdo_atras_nombre,lado_derecho_atras_cantidad,lado_izquierdo_frente_puntadas,lado_derecho_frente_nombre,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas,lugar,identificador_prenda,estatus_orden from historial_ordenes_pantalon_recibidas where numero = '" + numeroordendebordadolocalorecibida + "' and prenda = '" + prenda + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
                lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                lbbordacliente.setText(rs.getString("borda_cliente"));
                prenda = rs.getString("prenda");
                numerosucursal = rs.getString("numero_orden_o_pedido_solicitada");
                lbnumerodelaotrasucursal.setText(numerosucursal);
                sucursal=rs.getString("tienda");
                
                ladoizquierdofrentenombre = rs.getString("lado_izquierdo_frente_puntadas");
                ladoderechofrentenombre = rs.getString("lado_derecho_frente_puntadas");
                ladoizquierdoatrasnombre = rs.getString("lado_izquierdo_atras_puntadas");
                ladoderechoatrasnombre = rs.getString("lado_derecho_atras_puntadas");
                        
          //      lbladoizquierdofrente.setText(rs.getString("lado_izquierdo_frente_puntadas"));
                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente_puntadas");
             
                
                
                
                
                
                
                // LADO IZQUIERDO FRENTE
                
                if (ladoizquierdofrente == null || ladoizquierdofrente.equals("")) 
                {
                    
                  btnladoizquierdofrentetetermine.setEnabled(false);
                  btnladoizquierdofrenteponchado.setEnabled(false);

                }
                
                else
                
                {


                    String b = rs.getString("lado_izquierdo_frente_puntadas");
                    lbladoizquierdofrentepuntadas.setText(rs.getString("lado_izquierdo_frente_puntadas"));
                    
                    
                    btnladoizquierdofrentetetermine.setEnabled(true);
                    btnladoizquierdofrenteponchado.setEnabled(true);
                    
                    
                    activadoladoizquierdofrente ="si";
                   
                    
                    
                }

                
                
                
                
                
                
                
                /// LADO DERECHO FRENTE
           
                String ladoderechofrente = rs.getString("lado_derecho_frente_puntadas");

                if (ladoderechofrente == null || ladoderechofrente.equals("")) 
                {
                    btnladoderechofrentetetermine.setEnabled(false);
                    btnladoderechofrenteponchado.setEnabled(false);
                } 
                else
                {

 
                    lbladoderechofrentepuntadas.setText(rs.getString("lado_derecho_frente_nombre"));
                    
                    
                    btnladoderechofrentetetermine.setEnabled(true);
                    btnladoderechofrenteponchado.setEnabled(true);
                    
                    
                    activadoladoderechofrente ="si";
                    
                }
                
                
                
                
                
                // LADO IZQUIERDO ATRAS
                
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras_puntadas");
             
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

           //     lbladoderechoatras.setText(rs.getString("lado_derecho_atras_puntadas"));
                String ladoderechoatras = rs.getString("lado_derecho_atras_puntadas");
             
                if (ladoderechoatras == null || ladoderechoatras.equals("")) 
                
                {
                    
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
                cantidad = rs.getString("cantidad");
                lbcantidad.setText(cantidad);
                
                
                
                 identificador =  rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                
                
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
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                if(lugar.equals("Esta sucursal"))
                {
                    
                  
                
                String cantidadladoizquierdofrente = rs.getString("lado_izquierdo_frente_cantidad");
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
                
                
                String cantidadladoderechofrente = rs.getString("lado_derecho_frente_cantidad");
             
                if(cantidadladoderechofrente.equals("0")&& activadoladoderechofrente.equals("si"))
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
                
                
                
                
                
                String cantidadladoizquierdoatras = rs.getString("lado_izquierdo_atras_cantidad");
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
                
                
                
                
                
                String cantidadladoderechoatras = rs.getString("lado_derecho_atras_cantidad");
                if(cantidadladoderechoatras.equals("0") && activadoladoderechoatras.equals("si"))
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
             
            
                
              if (tiendaconectada.equals("si"))

                      {
                
                
                 try {
         
                     
                     
            Class.forName("com.mysql.jdbc.Driver");
       
         
            cnsucursal = DriverManager.getConnection("jdbc:mysql://" + ipsucursal + "/" + sucursal + "", "root", "sistemas");
      

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
     
     
     
     
     
     
     
     void tiendaconectada()
 {
     
     
     
     try {
         
           
           Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://" + iplocal + "/tiendas", "root", "sistemas");

            try {

                String sql = "SELECT ip FROM catalogo_tiendas where tienda = 'cdmxcentro'";

                Statement st = con.prepareStatement(sql);
                ResultSet rs = st.executeQuery(sql);

                if (rs.next()) {

                    ipsucursal = rs.getString("ip");

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
 
    
     
     
     
     
     
     
     
     

      void insertarlacantidadylafechaenlaubicacion(String ubicacion, String fechaubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set "+ubicacion+"='" + cantidad + "',"+fechaubicacion+"  =  '"+dia()+"' where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
    //    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
       
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
      
    void eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion(String ubicacion, String fecha)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE  "+nombredelatabla+" set "+ubicacion+"='0', "+fecha+"=null where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
    //    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
       
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }  
      
      
    void insertarlacantidadylafechaenlaubicacionhistorialRECIBIDO(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set "+ubicacion+"='" + cantidad + "',fecha='"+dia()+"' where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
     //   JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
       
        try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
          
        try {
            cargarfotomontajeotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
     void agregaralsurtidasalhistorialdeventasyactualizarestatusentrega(String ubicacion, String cantidad, String ubicacionaplicacion) 
      {

        numerodeventa =  lbnumerodeventa.getText();
        String surtidaactualstring ="";
        int surtidaactualint =  0;
        String nuevasurtidastring = "";
        String estatusentrega ="";
        String estatusentregaventa = "";
        
         String SQL2 = "select articulo,surtida,estatus_entrega from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + ubicacion + "'  and identificador_prenda = '"+identificador+"' ";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '"+nuevacantidadstring+"' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacion + "'");
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
                 PreparedStatement ps = cn.prepareStatement("select " + ubicacion + "," + ubicacionnombre + " from historial_ordenes_pantalon_recibidas where numero = '" + numeroordendebordadolocalorecibida + "' ")) {
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
        
       
        int tienecantidad = 0;
        int botonesactivados = 0;
        
         String sql = "Select lado_izquierdo_frente_nombre,lado_izquierdo_frente_nombre,"
                  + "lado_derecho_frente_cantidad,lado_derecho_frente_nombre,"
                  + "lado_izquierdo_atras_cantidad,lado_izquierdo_atras_nombre,"
                  + "lado_derecho_atras_cantidad,lado_derecho_atras_nombre from historial_ordenes_pantalon where numero = '"+numeroordendebordadolocalorecibida+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

               
                String cantidadladoizquierdofrente = rs.getString("lado_izquierdo_frente_cantidad");
                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente_puntadas");
                
                String cantidadladoderechofrente = rs.getString("lado_derecho_frente_cantidad");
                String ladoderechofrente = rs.getString("lado_derecho_frente_puntadas");
                
                String cantidadladoizquierdoatras = rs.getString("lado_izquierdo_atras_cantidad");
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras_puntadas");
               
                String cantidadladoderechoatras = rs.getString("lado_derecho_atras_cantidad");
                String ladoderechoatras = rs.getString("lado_derecho_atras_puntadas");


                
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

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set estatus_orden='realizada totalmente',fecha='"+dia()+"' where numero='" + numeroordendebordadolocalorecibida + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                  
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
          
               
              


        }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
         lbestatus.setText(nuevoestatusorden);
        
        
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
        lbsucursal = new javax.swing.JLabel();
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
        lbnumerodelaotrasucursal = new javax.swing.JLabel();
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
        lbladoizquierdoatrasnombre = new javax.swing.JLabel();
        lbladoderechoatrasnombre = new javax.swing.JLabel();
        lbladoderechofrentenombre = new javax.swing.JLabel();
        lbladoizquierdofrentenombre = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbestatus = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbautorizacion = new javax.swing.JLabel();
        lbnumeroordenopedidosolicitado = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();

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

        lbsucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbsucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Cantidad");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcantidad.setText("0");
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnladoderechofrentetetermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechofrentetetermine.setText("Termine");
        btnladoderechofrentetetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoderechofrentetetermineMouseReleased(evt);
            }
        });
        btnladoderechofrentetetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechofrentetetermineActionPerformed(evt);
            }
        });

        btnladoderechoatrastetermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechoatrastetermine.setText("Termine");
        btnladoderechoatrastetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoderechoatrastetermineMouseReleased(evt);
            }
        });
        btnladoderechoatrastetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechoatrastetermineActionPerformed(evt);
            }
        });

        btnladoizquierdofrentetetermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdofrentetetermine.setText("Termine");
        btnladoizquierdofrentetetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoizquierdofrentetetermineMouseReleased(evt);
            }
        });
        btnladoizquierdofrentetetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdofrentetetermineActionPerformed(evt);
            }
        });

        btnladoizquierdoatrastetermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdoatrastetermine.setText("Termine");
        btnladoizquierdoatrastetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoizquierdoatrastetermineMouseReleased(evt);
            }
        });
        btnladoizquierdoatrastetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdoatrastetermineActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total de puntos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos.setForeground(new java.awt.Color(0, 0, 153));
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
        lbidentificador.setForeground(new java.awt.Color(0, 0, 153));
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Observaciones");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        lbladoderechoatraspuntadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoderechoatraspuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdoatraspuntadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoizquierdoatraspuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdofrentepuntadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoizquierdofrentepuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderechofrentepuntadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
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
        jLabel28.setText("Orden o pedido solicitado");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumerodelaotrasucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumerodelaotrasucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbprenda.setText("Pantalon");
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnladoderechofrentecancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechofrentecancelar.setText("Cancelar");
        btnladoderechofrentecancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoderechofrentecancelarMouseReleased(evt);
            }
        });
        btnladoderechofrentecancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechofrentecancelarActionPerformed(evt);
            }
        });

        btnladoderechoatrascancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechoatrascancelar.setText("Cancelar");
        btnladoderechoatrascancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoderechoatrascancelarMouseReleased(evt);
            }
        });
        btnladoderechoatrascancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechoatrascancelarActionPerformed(evt);
            }
        });

        btnladoizquierdofrentecancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdofrentecancelar.setText("Cancelar");
        btnladoizquierdofrentecancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoizquierdofrentecancelarMouseReleased(evt);
            }
        });
        btnladoizquierdofrentecancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdofrentecancelarActionPerformed(evt);
            }
        });

        btnladoizquierdoatrascancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdoatrascancelar.setText("Cancelar");
        btnladoizquierdoatrascancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoizquierdoatrascancelarMouseReleased(evt);
            }
        });
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

        lbladoizquierdoatrasnombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoizquierdoatrasnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderechoatrasnombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoderechoatrasnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderechofrentenombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoderechofrentenombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdofrentenombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoizquierdofrentenombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbautorizacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbautorizacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroordenopedidosolicitado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumeroordenopedidosolicitado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel19.setText("Numero");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbladoizquierdofrente1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbladoderechofrente1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbdadoizquierdoatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbladoderechoatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbladoderechoatrasnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbladoderechofrentenombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbladoizquierdoatrasnombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbladoizquierdofrentenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbladoderechoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbladoizquierdofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbladoderechofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbladoizquierdoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnladoderechoatrastetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(btnladoderechoatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnladoizquierdofrentetetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnladoderechofrentetetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnladoizquierdoatrastetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(8, 8, 8)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btnladoizquierdofrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btnladoderechofrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnladoizquierdoatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(18, 18, 18)
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
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnladoderechoatrasponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnladoizquierdoatrasponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnladoderechofrenteponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(12, 12, 12)
                                        .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnladoizquierdofrenteponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(115, 115, 115))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(16, 16, 16)
                                                .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel15)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(17, 17, 17))))
                                    .addComponent(jScrollPane6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnfotomontajesinpuntadas))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btndatos))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(212, 212, 212)
                                                .addComponent(jLabel18))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel30)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(29, 29, 29)
                                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(0, 15, Short.MAX_VALUE))
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
                        .addComponent(btneliminarbtneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton2)))
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(7, 7, 7)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 725, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbladoizquierdofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbladoderechofrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbladoizquierdoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(lbladoderechoatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbladoizquierdofrentenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbladoderechofrentenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbladoizquierdoatrasnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(7, 7, 7)
                            .addComponent(lbladoderechoatrasnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcolorpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcolormangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcolorpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnladoizquierdofrenteponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addComponent(btnladoderechofrenteponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnladoizquierdoatrasponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcodigoladoizquierdofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcodigoladoderechofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbcodigoladoizquierdoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcodigoladoderechoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolormangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnladoderechoatrasponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnladoizquierdofrentetetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnladoderechofrentetetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnladoizquierdoatrastetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnladoizquierdoatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnladoizquierdofrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnladoderechofrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnladoderechoatrastetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnladoderechoatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbladoizquierdofrente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbladoderechofrente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbdadoizquierdoatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbladoderechoatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(2, 2, 2))))
                .addContainerGap(48, Short.MAX_VALUE))
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
    
        prenda = "Pantalon";
        String cliente = lbcliente.getText();

        String path = "";
        String tiendaalaquesereplicara = lbsucursal.getText();
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
        ipsucursal = stringIP;
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
            conn = DriverManager.getConnection("jdbc:mysql://" + ipsucursal + "/" + sucursal + "", "root", "sistemas");

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

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_frente_ponchado=? where numero_orden_pantalon_solicitada='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_frente_ponchado_nombre='" + nombrearchivo1 + "' where numero_orden_pantalon_solicitada='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
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

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_frente_ponchado=? where numero_orden_pantalon_solicitada='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input2);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_frente_ponchado_nombre='" + nombrearchivo2 + "' where numero_orden_pantalon_solicitada='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
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

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_atras_ponchado=? where numero_orden_pantalon_solicitada='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input3);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_atras_ponchado_nombre='" + nombrearchivo3 + "' where numero_orden_pantalon_solicitada='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
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

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_atras_ponchado=? where numero_orden_pantalon_solicitada='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input4);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_atras_ponchado_nombre='" + nombrearchivo4 + "' where numero_orden_pantalon_solicitada='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
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

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set imagen=? where numero_orden_pantalon_solicitada='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input6);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set imagen_nombre='" + nombrearchivo6 + "' where numero_orden_pantalon_solicitada='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
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
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">La orden se inserto correctamente en la otra sucursal");

          
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon SET estatus_orden='enviado' WHERE numero='" + numeroordendebordadolocalorecibida + "'");
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

        
        datos();
        
    }//GEN-LAST:event_formWindowOpened

    private void btnladoizquierdofrentetetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdofrentetetermineActionPerformed

         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
      
            
            
            String ubicacion = "lado_izquierdo_frente_cantidad";
            fechaubicacion = "lado_izquierdo_frente_fecha";
          
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);
            
            cantidadaplicacion = "0";
            descripcion = "BORDADO PANTALON FRENTE LADO IZQUIERDO "+ladoizquierdofrentenombre + "";
            aplicacioninsertar = "";
           
          
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);
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
            
     
            
            String ubicacion = "lado_izquierdo_frente_cantidad";
          
            cantidadaplicacion = "0";
           
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            
            insertarlacantidadylafechaenlaubicacionhistorialRECIBIDO((String) ubicacion);
            
            estacompletalaorden();
            
            
            
             JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
            
        }
        
         try {
                 datostiendalocal();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
             }

        
        }
    }//GEN-LAST:event_btnladoizquierdofrentetetermineActionPerformed

    private void btnladoizquierdoatrastetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrastetermineActionPerformed

         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
        
        if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            

            
            String ubicacion = "lado_izquierdo_atras_cantidad";
            fechaubicacion = "lado_izquierdo_atras_fecha";
          
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);
            
            cantidadaplicacion = "0";
            descripcion = "BORDADO PANTALON ATRAS LADO IZQUIERDO "+ladoizquierdoatrasnombre + "";
            aplicacioninsertar = "";
          
         
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);
            estacompletalaorden();
            
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
            
            
            
           
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
            
    
            
            String ubicacion = "lado_izquierdo_atras_cantidad";
           
            cantidadaplicacion = "0";
          
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            
            insertarlacantidadylafechaenlaubicacionhistorialRECIBIDO((String) ubicacion);
            
            estacompletalaorden();
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
             
            
        }
         
        
         try {
                 datostiendalocal();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
             }
        
        
        
        }
    }//GEN-LAST:event_btnladoizquierdoatrastetermineActionPerformed

    private void btnladoderechoatrastetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoatrastetermineActionPerformed

         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
         if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            
            String ubicacion = "lado_derecho_atras_cantidad";
            fechaubicacion = "lado_derecho_atras_fecha";
            
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);
            
            cantidadaplicacion = "0";
            descripcion = "BORDADO PANTALON ATRAS LADO DERECHO "+ladoderechoatrasnombre + "";
            aplicacioninsertar = "";
            
       
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);
            estacompletalaorden();
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
        
        
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
            
      
            
            String ubicacion = "lado_derecho_atras_cantidad";
          
            cantidadaplicacion = "0";
          
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            
            insertarlacantidadylafechaenlaubicacionhistorialRECIBIDO((String) ubicacion);
            
            estacompletalaorden();
            
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
             
            
        }
         
          try {
                 datostiendalocal();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
             }
         
         
        }
    }//GEN-LAST:event_btnladoderechoatrastetermineActionPerformed

    private void btnladoderechofrentetetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechofrentetetermineActionPerformed

         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        {
        
         if(lugar.equals("Esta sucursal")  && tipotabla.equals("Local"))
         {
             
          
    
            String ubicacion = "lado_derecho_frente_cantidad";
            fechaubicacion = "lado_derecho_frente_fecha";
            
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);
            
            cantidadaplicacion = "0";
            descripcion = "BORDADO PANTALON FRENTE LADO DERECHO "+ladoderechofrentenombre + "";
            aplicacioninsertar = "";
           
          
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);
            estacompletalaorden();
            
        
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
        
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
            
        
            String ubicacion = "lado_derecho_frente_cantidad";
          
            cantidadaplicacion = "0";
          
            nombredelatabla = "historial_ordenes_pantalon_recibidas";
            
            insertarlacantidadylafechaenlaubicacionhistorialRECIBIDO((String) ubicacion);
            
            estacompletalaorden();
            
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
            
            
            
        }
         
         
             try {
                 datostiendalocal();
             } catch (IOException ex) {
                 Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
             }
         
         
        }
    }//GEN-LAST:event_btnladoderechofrentetetermineActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
      ventanaordenpantalonanteriores = false;
       
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
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
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
      
 
        datos();
        
    }//GEN-LAST:event_btndatosActionPerformed

    private void btnladoderechofrentecancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechofrentecancelarActionPerformed
            String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
       
    
            
                     String ubicacion = "lado_derecho_frente_cantidad";
                     String fecha = "lado_derecho_frente_fecha";
                    eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
                    
                    
                     cantidadaplicacion = "0";
                     descripcion = "BORDADO PANTALON FRENTE LADO DERECHO " + ladoderechofrentenombre + "";
                     aplicacioninsertar = "";
                    
                    
                     agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);
                     estacompletalaorden();
                     
                     
                     
                         lbautorizacion.setText("no");
                         
                          datos();
                
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
            autorizacion.lbinterfaz.setText("pantaloncancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
                 
    }//GEN-LAST:event_btnladoderechofrentecancelarActionPerformed

    private void btnladoderechoatrascancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoatrascancelarActionPerformed
        
        
        
        String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
       
                     String ubicacion = "lado_derecho_atras_cantidad";
                     String fecha = "lado_derecho_atras_fecha";
                    eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
                    
                    
                     cantidadaplicacion = "0";
                     descripcion = "BORDADO PANTALON ATRAS LADO DERECHO "+ladoderechoatrasnombre + "";
                     aplicacioninsertar = "";
                    
                   
                     agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);
                     estacompletalaorden();
                 
                     
                         lbautorizacion.setText("no");
                
                          datos();
                          
                          
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
            autorizacion.lbinterfaz.setText("pantaloncancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
                 
                 
            
                 
                 
                 
                 
                 
                 

    }//GEN-LAST:event_btnladoderechoatrascancelarActionPerformed

    private void btnladoizquierdofrentecancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdofrentecancelarActionPerformed
     
        
        
        
        
        String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
        
    
            
                     String ubicacion = "lado_izquierdo_frente_cantidad";
                     String fecha = "lado_izquierdo_frente_fecha";
                     eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
                    
                  
                     descripcion = "BORDADO PANTALON FRENTE LADO IZQUIERDO "+ladoizquierdofrentenombre + "";
                     aplicacioninsertar = "";
                   
                    
                     agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);
                     estacompletalaorden();
                     
                     
                         lbautorizacion.setText("no");
                         
                          datos();
                
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
            autorizacion.lbinterfaz.setText("pantaloncancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
                 
    }//GEN-LAST:event_btnladoizquierdofrentecancelarActionPerformed

    private void btnladoizquierdoatrascancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrascancelarActionPerformed
        String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
      
    
            
                    String ubicacion = "lado_izquierdo_atras_cantidad";
                    String fecha = "lado_izquierdo_atras_fecha";
                    eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
                    
                    
                     cantidadaplicacion = "0";
                     descripcion = "BORDADO PANTALON ATRAS LADO IZQUIERDO "+ladoizquierdoatrasnombre + "";
                     aplicacioninsertar = "";
                   
                    
                     agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);
                     estacompletalaorden();
                     
                     
                     
                         lbautorizacion.setText("no");
                         
                          datos();
                
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
            autorizacion.lbinterfaz.setText("pantaloncancelar");
            autorizacion.lbnivel.setText("2");

        }
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

    private void btnladoizquierdofrentetetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoizquierdofrentetetermineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnladoizquierdofrentetetermineMouseReleased

    private void btnladoderechofrentetetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoderechofrentetetermineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnladoderechofrentetetermineMouseReleased

    private void btnladoizquierdoatrastetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrastetermineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnladoizquierdoatrastetermineMouseReleased

    private void btnladoderechoatrastetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoderechoatrastetermineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnladoderechoatrastetermineMouseReleased

    private void btnladoizquierdofrentecancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoizquierdofrentecancelarMouseReleased
        // TODO add your handling code here:       
                if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
             
    }//GEN-LAST:event_btnladoizquierdofrentecancelarMouseReleased

    private void btnladoderechofrentecancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoderechofrentecancelarMouseReleased
               
                if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
             
    }//GEN-LAST:event_btnladoderechofrentecancelarMouseReleased

    private void btnladoizquierdoatrascancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrascancelarMouseReleased
             
                if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
               
    }//GEN-LAST:event_btnladoizquierdoatrascancelarMouseReleased

    private void btnladoderechoatrascancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoderechoatrascancelarMouseReleased
             
                if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                
    }//GEN-LAST:event_btnladoderechoatrascancelarMouseReleased

    ResultSet rs;
    ResultSet rs2;

    public static void main(String args[]) {
     
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordenpantalonS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneliminarbtneditarbordado;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    public static javax.swing.JButton btnladoderechoatrascancelar;
    private javax.swing.JButton btnladoderechoatrasponchado;
    private javax.swing.JButton btnladoderechoatrastetermine;
    public static javax.swing.JButton btnladoderechofrentecancelar;
    private javax.swing.JButton btnladoderechofrenteponchado;
    private javax.swing.JButton btnladoderechofrentetetermine;
    public static javax.swing.JButton btnladoizquierdoatrascancelar;
    private javax.swing.JButton btnladoizquierdoatrasponchado;
    private javax.swing.JButton btnladoizquierdoatrastetermine;
    public static javax.swing.JButton btnladoizquierdofrentecancelar;
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
    private javax.swing.JLabel jLabel19;
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
    public static javax.swing.JLabel lbautorizacion;
    public static javax.swing.JLabel lbbordacliente;
    public static javax.swing.JLabel lbcantidad;
    public javax.swing.JLabel lbcantidad1;
    public javax.swing.JLabel lbcantidad2;
    public javax.swing.JLabel lbcantidad3;
    public javax.swing.JLabel lbcantidad4;
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
    public static javax.swing.JLabel lbladoderechoatrasnombre;
    public static javax.swing.JLabel lbladoderechoatraspuntadas;
    public static javax.swing.JLabel lbladoderechofrente1;
    public static javax.swing.JLabel lbladoderechofrentenombre;
    public static javax.swing.JLabel lbladoderechofrentepuntadas;
    public static javax.swing.JLabel lbladoizquierdoatrasnombre;
    public static javax.swing.JLabel lbladoizquierdoatraspuntadas;
    public static javax.swing.JLabel lbladoizquierdofrente1;
    public static javax.swing.JLabel lbladoizquierdofrentenombre;
    public static javax.swing.JLabel lbladoizquierdofrentepuntadas;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumerodelaotrasucursal;
    public static javax.swing.JLabel lbnumerodeventa;
    public static javax.swing.JLabel lbnumeroordenopedidosolicitado;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    public static javax.swing.JLabel lbprenda;
    public static javax.swing.JLabel lbsucursal;
    public javax.swing.JLabel lbsumapuntos;
    // End of variables declaration//GEN-END:variables

    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();

   
}
