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
    String ubicacioncantidad = "";
    String ubicacionfecha = "";
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
    String descripcionaplicacon = "";
    String numeroordendeenviosolicitada = "";
    String ladoizquierdofrentenombre = "";
    String ladoderechofrentenombre = "";
    String ladoizquierdoatrasnombre = "";
    String ladoderechoatrasnombre = "";
     String numeroordenopedidorecibido = "";
     String numeroordendebordadosolicitadoorecibidasisehabredesderecibidas = "";
     String descripcionaplicacion = "";
     String ubicacionponchado = "";
     String ubicacionponchadonombre = "";
    
    String rutaimagen="";
    String rutaladoizquierdofrente="";
    String rutaladoizquierdoatras="";
    String rutaladoderechofrente="";
    String rutaladoderechoatras ="";
    String rutaarchivo = "";
    String nombrearchivo = "";
    String codigocliente ="";
    String tienefotomontaje ="";
    
    
    String nombrebordado = "";
    String ubicacionprenda = "";
    
    public static String enquesucursalsebordara = "";
    public static String esponchado ="";
    
    
    public static String tipotabla = "";
    String terminetodo ="";
    ArrayList<String> listabotones = new ArrayList<String>();
    String nombredelatabla ="";
 
    String identificador = "";
    String consecutivo = "";
    String tieneunaobservacion = ""; 
    String rutadelip = "";
    String tienenumerodesucursal = "";
    String numerosucursalordenpantalon = "";
    String tiendalocal = "";
    String rutadedondeestanlosbordados ="";
    String tiendeordenopedido = "";
    String prenda = "";
    
     String ruta1= "";
    String ruta2= "";
    String ruta3= "";
    String ruta4= "";
    

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
       
       
          btnreplicar1.setEnabled(false);
        btnreplicar2.setEnabled(false);
        btnreplicar3.setEnabled(false);
        btnreplicar4.setEnabled(false);
      
        btnreplicartodoslosponchados.setEnabled(false);
        
        btnquitarponchado1.setEnabled(false);
        btnquitarponchado2.setEnabled(false);
        btnquitarponchado3.setEnabled(false);
        btnquitarponchado4.setEnabled(false);
           
                
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
            Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     
      codigocliente();
        
        cliente();
        
         hilosycolor();
        
     
     try {    
            cargarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
        }

         if(enquesucursalsebordara.equals("Otra sucursal"))
        {
        btnterminetodo.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Recuerda que Aqui solo replicas los ponchados y el fotomontaje");
        } 
     
        cliente();
        
        
        sumapuntos();
        
    } 
    
    else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
        
        nombredelatabla = "historial_ordenes_pantalon_recibidas";
        
         try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
         
        btnreplicartodoslosponchados.setEnabled(false);
         
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
      
       
        
         numeroordendebordadosolicitadoorecibidasisehabredesderecibidas = lborden.getText();
      
      
        
        String botonhabilitado1 ="";
        String botonhabilitado2 ="";
        String botonhabilitado3 ="";
        String botonhabilitado4 ="";


        

        String sql = "Select fecha,hora,cliente,nombre_comercial,borda_cliente,numero_venta,estatus_orden,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,lado_izquierdo_frente_nombre,lado_derecho_frente_nombre,lado_izquierdo_atras_nombre,lado_derecho_atras_nombre,lado_izquierdo_frente_cantidad,lado_derecho_frente_cantidad,lado_izquierdo_atras_cantidad,lado_derecho_atras_cantidad,lado_izquierdo_frente_puntadas,lado_derecho_frente_puntadas,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas,lugar,identificador_prenda,numero_orden from historial_ordenes_pantalon where numero = '" + numeroordendebordadosolicitadoorecibidasisehabredesderecibidas + "'";

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

                
                
                ladoizquierdofrentenombre = rs.getString("lado_izquierdo_frente_nombre");
                ladoderechofrentenombre = rs.getString("lado_derecho_frente_nombre");
                ladoizquierdoatrasnombre = rs.getString("lado_izquierdo_atras_nombre");
                ladoderechoatrasnombre = rs.getString("lado_derecho_atras_nombre");
                identificador = rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                lugar = rs.getString("lugar");
                
                cantidad = rs.getString("cantidad");
                lbcantidad.setText(cantidad);
                
                        
                
              
                if (ladoizquierdofrentenombre == null || ladoizquierdofrentenombre.equals("") || ladoizquierdofrentenombre.equals("ninguno")) 
                {
                    
                 
                  btnponchado1.setEnabled(false);
                  btncargarponchado1.setEnabled(false);
                  

                }
                
                else
                
                {

                   lbladoizquierdofrentenombre.setText(ladoizquierdofrentenombre);
                   lbladoizquierdofrentepuntadas.setText(rs.getString("lado_izquierdo_frente_puntadas"));
                    
                    btnponchado1.setEnabled(true);
                 
                    botonhabilitado1 ="si";
                    btncargarponchado1.setEnabled(true);
                    
                    
                    
                }

                
                /// lado derecho frente
                
               
                if (ladoderechofrentenombre == null || ladoderechofrentenombre.equals("")  || ladoderechofrentenombre.equals("ninguno")) 
                {
                   
                    btnponchado2.setEnabled(false);
                    btncargarponchado2.setEnabled(false);
                } 
                else
                {

                     lbladoderechofrentenombre.setText(ladoderechofrentenombre);
                    lbladoderechofrentepuntadas.setText(rs.getString("lado_derecho_frente_nombre"));
                  
                    btnponchado2.setEnabled(true);
                    
                    botonhabilitado2 ="si";
                    btncargarponchado3.setEnabled(true);
                   
                }

                
                
                
                
                
            
                if (ladoizquierdoatrasnombre == null || ladoizquierdoatrasnombre.equals("") || ladoizquierdoatrasnombre.equals("ninguno"))
                {
                   
                    btnponchado3.setEnabled(false);
                    btncargarponchado3.setEnabled(false);
                } 
                else 
                {


                    lbladoizquierdoatrasnombre.setText(ladoizquierdoatrasnombre);
                    lbladoizquierdoatraspuntadas.setText(rs.getString("lado_izquierdo_atras_puntadas"));
                  
                     btnponchado3.setEnabled(true);
                    
                    botonhabilitado3 ="si";
                    btncargarponchado3.setEnabled(false);
           
                   
                    
                }

               
                if (ladoderechoatrasnombre == null || ladoderechoatrasnombre.equals("") || ladoderechoatrasnombre.equals("ninguno")) 
                {
                   
                     btnponchado4.setEnabled(false);
                     btncargarponchado4.setEnabled(false);
                }
                else 
                {


                   lbladoderechoatrasnombre.setText(ladoderechoatrasnombre);
                    lbladoderechoatraspuntadas.setText(rs.getString("lado_derecho_atras_puntadas"));
                    
                     btnponchado4.setEnabled(true);
                 
                    botonhabilitado4 ="si";
                    btncargarponchado4.setEnabled(true);
                    
                   
                    
                }
                
                
                
                
                
                
                
                
                
                
                
              
                
                if(lugar.equals("Esta sucursal"))
                {
                    
                  
                
                String cantidadladoizquierdofrente = rs.getString("lado_izquierdo_frente_cantidad");
                String cantidadladoderechofrente = rs.getString("lado_derecho_frente_cantidad");
                 String cantidadladoizquierdoatras = rs.getString("lado_izquierdo_atras_cantidad");
                String cantidadladoderechoatras = rs.getString("lado_derecho_atras_cantidad");
                
                
                
                 if( botonhabilitado1.equals("si"))
                {
                    
                    
                    
                    if(cantidadladoizquierdofrente.equals("0") )
                        
                    {
                    
                    btnladoizquierdofrentetermine.setEnabled(true);
                    btnladoizquierdofrentecancelar.setEnabled(false);
                    
                     lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
                    
                    
                    
                    
                    
                    listabotones.add("btnladoizquierdofrente");
                    
                    
                    
                    }
                    
                    else
                        
                    {
                        
                           btnladoizquierdofrentecancelar.setEnabled(true);
                           btnladoizquierdofrentetermine.setEnabled(false);
                           
                           
                        lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());
                        
                    }
                    
                    
                    
                    
                }
                else
                {
                   btnladoizquierdofrentetermine.setEnabled(false);
                   
                }    
                
                
                
                 
                 
                 
                 
                 
                 
                 
                 
                 
                if(botonhabilitado2.equals("si"))
                {
                    
                    
                    
                    
                     if(cantidadladoderechofrente.equals("0"))
                    
                     {
                   btnladoderechofrentetermine.setEnabled(true);
                   btnladoderechoatrascancelar.setEnabled(false);
                    
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                    
                   listabotones.add("btnladoderechofrente");
                   
                   
                     }
                     
                     else
                     {
                         
                            btnladoderechoatrascancelar.setEnabled(true);
                            btnladoderechofrentetermine.setEnabled(false);
                  lbcantidad2.setText(cantidad);
                   lbcantidad2.setForeground(Color.GREEN.darker());
                         
                         
                     }
                     
                     
                }
                else
                {
                    
                    
                  btnladoderechofrentetermine.setEnabled(false);
                
                
                } 
                
              
                
                
                
               
                if( botonhabilitado3.equals("si"))
                {
                    
                    
                    
                    if(cantidadladoizquierdoatras.equals("0"))
                        
                    {
                    btnladoizquierdoatrastermine.setEnabled(true);
                   btnladoizquierdoatrascancelar.setEnabled(false);
                     
                      lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                     
                     
                    listabotones.add("btnladoizquierdoatras");
                    
                    
                    }
                    
                    else
                        
                    {
                            btnladoizquierdoatrascancelar.setEnabled(true);
                             btnladoizquierdoatrastermine.setEnabled(false);
                  lbcantidad3.setText(cantidad);
                   lbcantidad3.setForeground(Color.GREEN.darker());
                        
                    }
                    
                    
                }
                else
                {
                    btnladoizquierdoatrastermine.setEnabled(false);
                
                } 
                
                
                
                
                
                
                
                
                
                
                
                
                
                if( botonhabilitado4.equals("si"))
                {
                    
                    
                    
                    if(cantidadladoderechoatras.equals("0"))
                        
                        
                    {
                    btnladoderechoatrastermine.setEnabled(true);
                    btnladoderechoatrascancelar.setEnabled(false);
                     
                      lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                     
                     
                    listabotones.add("btnladoderechoatras");
                    
                    }
                    
                    
                    else
                        
                    {
                        
                           
                 btnladoderechoatrascancelar.setEnabled(true);
                  btnladoderechoatrastermine.setEnabled(false);
                  
                  
                   lbcantidad4.setText(cantidad);
                   lbcantidad4.setForeground(Color.GREEN.darker());
                        
                    }
                    
                }
                else
                {
                     btnladoderechoatrastermine.setEnabled(false);
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
                Object pantalon1 = rs1.getString("imagen");
                if (pantalon1 == null||pantalon1.equals("")||pantalon1.equals(" ")) 
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
                Object pantalon1 = rs1.getString("imagen");
                if (pantalon1 == null||pantalon1.equals("")||pantalon1.equals(" ")) 
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
    
    
    
    
    
    
    
     
     
     
     
    
    void deshabilitarbotonesporqueesponchado(){
        
        
        
       
        btnladoizquierdofrentetermine.setEnabled(false);
        btnladoderechofrentetermine.setEnabled(false);
        btnladoizquierdoatrastermine.setEnabled(false);
        btnladoderechoatrastermine.setEnabled(false);
        
        
        btnterminetodo.setEnabled(false);        
                
                
        btnladoizquierdofrentecancelar.setEnabled(false);
        btnladoderechofrentecancelar.setEnabled(false); 
        btnladoizquierdoatrascancelar.setEnabled(false);
        btnladoderechoatrascancelar.setEnabled(false);
        
        btnponchado1.setEnabled(false);
        btnponchado2.setEnabled(false);
        btnponchado3.setEnabled(false);
        btnponchado4.setEnabled(false);
           
     
        
        
        
    }
    
     
     
     
     
     
    
    
    
    
    void determinaciondeladescripciondelbordado(){
        
        
        descripcion = "BORDADO PANTALON " + ubicacionprenda + " " + nombrebordado + "";
        
          descripcionaplicacion = "APLICACION PANTALON";
            
         
           
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
            
            
           
            
        

       String sql = "Select imagen_nombre,imagen from historial_ordenes_pantalon_recibidas where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"'  and prenda = '"+prenda+"'   ";  ///

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
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
    
     void sumapuntos()
    {
        
        
        
        
         String sql = "Select cantidad,lado_izquierdo_frente_cantidad,lado_izquierdo_frente_puntadas,lado_derecho_frente_cantidad,lado_derecho_frente_puntadas,"
                  + "lado_izquierdo_atras_cantidad,lado_izquierdo_atras_puntadas,lado_derecho_atras_cantidad,lado_derecho_atras_puntadas from "
                  + ""+nombredelatabla+" where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"' ";
         

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                
                String cantidad = rs.getString("cantidad");   
                
                String cantidad1string = rs.getString("lado_izquierdo_frente_cantidad");
                String frente = rs.getString("lado_izquierdo_frente_puntadas");
           ;
                
                String cantidad2string = rs.getString("lado_derecho_frente_cantidad");
                String atras = rs.getString("lado_derecho_frente_puntadas");
                
                String cantidad3string = rs.getString("lado_izquierdo_atras_cantidad");
                String ladoizquierdo = rs.getString("lado_izquierdo_atras_puntadas");
               
                String cantidad4string = rs.getString("lado_derecho_atras_cantidad");
                String ladoderecho = rs.getString("lado_derecho_atras_puntadas");
                
                

             int cantidad1int = Integer.parseInt(cantidad1string);
             int cantidad2int = Integer.parseInt(cantidad2string);
            int cantidad3int = Integer.parseInt(cantidad3string);
            int cantidad4int = Integer.parseInt(cantidad4string);
            
            
            
 
            String costostring = "0.00";
            double importe1 = 0.00;
            double importe2 = 0.00;
            double importe3 = 0.00;
            double importe4= 0.00;
            
            double costopuntadaladoizquierdo = 0.0;
            double costopuntadaladoderecho = 0.0;
            double costopuntadaatras = 0.0;
            double costopuntadafrente = 0.0;
            
            
               //LADO IZQUIERDO FRENTE
            
            
            String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" +frente+ "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql1);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next())
                {

                    costostring = rs2.getString("costo");
                    costopuntadaladoizquierdo = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+exx+"");

            }

            
            
            importe1 = cantidad1int * costopuntadaladoizquierdo;
            lbsumapuntos1.setText(String.format("%.02f ", importe1));
       
            



            //LADO DERECHO FRENTE
            
            String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + atras + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql2);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaladoderecho = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+exx+"");

            }

          
            importe2 = cantidad2int * costopuntadaladoderecho;
            lbsumapuntos2.setText(String.format("%.02f ", importe2));

            
             //LADO IZQUIERDO ATRAS
            
 
            String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdo+ "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaatras = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+exx+"");

            }

          
            importe3 = cantidad3int * costopuntadaatras;
            lbsumapuntos3.setText(String.format("%.02f ", importe3));
            
            
            
             
              
                // LADO DERECHO ATRAS
            
            String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '"+ladoderecho+"'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql4);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadafrente = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+exx+"");

            }

            importe4 = cantidad4int * costopuntadafrente;
            lbsumapuntos4.setText(String.format("%.02f ", importe4));
          
           
           
           
            

            double sumabordados = importe1 + importe2 + importe3 + importe4 ;
            String sumabordadosstring = String.format("%.02f ", sumabordados);
            lbsumapuntos.setText(sumabordadosstring);

        }



            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
     
     
     
     
    
      
     
     void agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega(){
         
       
         
         
         String surtidaactualstring ="";
        int surtidaactualint =  0;
        String surtidanuevastring = "";
        String estatusentrega ="";
        int surtidanuevaint = 0;
        int cantidadint = 0;
        
        
       
                 if (tiendeordenopedido.equals("ordendeenvio")) 
        {
            
            
            
            String sql3 = "Select surtidas from historial_ordenes_envio_recibidas where articulo = '" + ubicacioncantidad + "' and  numero = '" + numeroordenopedidorecibido + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
               
                    
                  
                   surtidaactualstring = rs.getString("surtidas");
                          surtidaactualint = Integer.parseInt(surtidaactualstring);
        

                }
        
        else
        {
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EL BORDADO EN LA ORDEN DE ENVIO RECIBIDA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
        String[] lineas = observacion.split("\n");
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacioncantidad+"" + lineas[0] + "</span><br>";
        if (lineas.length > 1) {
         mensaje += "<span style=\"Color:red; font-size:20px;\">" + lineas[1] + "</span>";
}

          JOptionPane.showMessageDialog(null, mensaje);
                   
                   
                
                    
                }
                
                
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

            }
            
          
        
          if(surtidaactualstring ==null || surtidaactualstring.equals("")||surtidaactualstring.equals(" "))
      {
          surtidaactualstring ="0";
      } 
          
       
         cantidadint =  Integer.parseInt(cantidad);
        surtidanuevaint = surtidaactualint + cantidadint;
       
        surtidanuevastring =  String.valueOf(surtidanuevaint);
            
      
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET surtidas = '" + surtidanuevastring + "' WHERE numero='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacioncantidad + "'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       
            
            
            
            
            

        ////Actualiza el estatus

      String sumasurtidastring = "";  
      String sumavendidastring = "";  
      String sumaenviadastring = "";  
      
      int sumasurtidaint = 0;  
      int sumavendidaint = 0;  
      int sumaenviadaint = 0;  
       
      
      
      
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(enviadas) as enviadas from historial_ordenes_envio_recibidas where numero = '"+numeroordenopedidorecibido+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        sumavendidastring = rs.getString("cantidad");
        sumasurtidastring = rs.getString("surtidas");
        sumaenviadastring = rs.getString("enviadas");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
      
      /////
      
       sumavendidaint = Integer.parseInt(sumavendidastring);
       sumasurtidaint = Integer.parseInt(sumasurtidastring);
       sumaenviadaint = Integer.parseInt(sumaenviadastring);
      
        
        if(sumavendidaint == sumasurtidaint && sumaenviadaint == 0 )
        {
          estatusentrega ="surtida totalmente no enviada";  
        }
        else  if(sumavendidaint == (sumasurtidaint + sumaenviadaint )  &&  sumaenviadaint <  sumavendidaint  )
        {
          estatusentrega ="surtida totalmente enviada parcialmente";  
        }
        
        else
        {
          estatusentrega ="surtida parcialmente no enviada";   
        }    
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroordenopedidorecibido + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      

            
            
            
            
            ////////////////////////////////////////////////
            
            
            

        }
        else 
        {
            
            
            ////////////////////////////////////////////////////////
            
            
        }
           if (tiendeordenopedido.equals("pedido")) 
            {

                
                
              
            String sql3 = "Select surtidas from historial_pedidos_sucursal_recibidos where articulo = '" + descripcion + "' and numero = '" + numeroordenopedidorecibido + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
               
                    
                  
                   surtidaactualstring = rs.getString("surtidas");
                          surtidaactualint = Integer.parseInt(surtidaactualstring);
        

                }
        
        else
        {
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EL BORDADO EN LA ORDEN DE ENVIO RECIBIDA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
        String[] lineas = observacion.split("\n");
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacioncantidad+"" + lineas[0] + "</span><br>";
        if (lineas.length > 1) {
         mensaje += "<span style=\"Color:red; font-size:20px;\">" + lineas[1] + "</span>";
}

          JOptionPane.showMessageDialog(null, mensaje);
                   
                   
                
                    
                }
                
                
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

            }
            
          
            
            
          
        
          if(surtidaactualstring ==null || surtidaactualstring.equals("")||surtidaactualstring.equals(" "))
      {
          surtidaactualstring ="0";
      } 
          
       
         cantidadint =  Integer.parseInt(cantidad);
        surtidanuevaint = surtidaactualint + cantidadint;
       
        surtidanuevastring =  String.valueOf(surtidanuevaint);
            
      
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET surtidas = '" + surtidanuevastring + "' WHERE numero='" + numeroordenopedidorecibido + "' and articulo = '" + descripcion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       
            
            
            
            
            
            

        ////Actualiza el estatus

      String sumasurtidastring = "";  
      String sumavendidastring = "";  
      String sumaenviadastring = "";  
      
      int sumasurtidaint = 0;  
      int sumavendidaint = 0;  
      int sumaenviadaint = 0;  
       
      
      
      
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtidas) as surtidas,Sum(enviadas) as enviadas from historial_pedidos_sucursal_recibidos where numero = '"+numeroordenopedidorecibido+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        sumavendidastring = rs.getString("cantidad");
        sumasurtidastring = rs.getString("surtidas");
        sumaenviadastring = rs.getString("enviadas");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
      
      /////
      
       sumavendidaint = Integer.parseInt(sumavendidastring);
       sumasurtidaint = Integer.parseInt(sumasurtidastring);
       sumaenviadaint = Integer.parseInt(sumaenviadastring);
      
        
        if(sumavendidaint == sumasurtidaint && sumaenviadaint == 0 )
        {
          estatusentrega ="surtida completamente no traspasado";  
        }
        else  if(sumavendidaint == (sumasurtidaint + sumaenviadaint )  &&  sumaenviadaint <  sumavendidaint  )
        {
          estatusentrega ="surtida completamente traspasada parcialmente";  
        }
        
        else
        {
          estatusentrega ="surtida parcialmente no traspasado";   
        }    
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroordenopedidorecibido + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      

            
            
            
            
            }
         
         
         
         
         
     }
     
     
     
     
     
     
     
     
     
     void agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentregacancelar(){
         
       
         
         
         String surtidaactualstring ="";
        int surtidaactualint =  0;
        String surtidanuevastring = "";
        String estatusentrega ="";
        int surtidanuevaint = 0;
        int cantidadint = 0;
        
        
       
                 if (tiendeordenopedido.equals("ordendeenvio")) 
        {
            
            
            
            String sql3 = "Select surtidas from historial_ordenes_envio_recibidas where articulo = '" + ubicacioncantidad + "' and  numero = '" + numeroordenopedidorecibido + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
               
                    
                  
                   surtidaactualstring = rs.getString("surtidas");
                          surtidaactualint = Integer.parseInt(surtidaactualstring);
        

                }
        
        else
        {
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EL BORDADO EN LA ORDEN DE ENVIO RECIBIDA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
        String[] lineas = observacion.split("\n");
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacioncantidad+"" + lineas[0] + "</span><br>";
        if (lineas.length > 1) {
         mensaje += "<span style=\"Color:red; font-size:20px;\">" + lineas[1] + "</span>";
}

          JOptionPane.showMessageDialog(null, mensaje);
                   
                   
                
                    
                }
                
                
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

            }
            
          
        
          if(surtidaactualstring ==null || surtidaactualstring.equals("")||surtidaactualstring.equals(" "))
      {
          surtidaactualstring ="0";
      } 
          
       
         cantidadint =  Integer.parseInt(cantidad);
        surtidanuevaint = surtidaactualint - cantidadint;
       
        surtidanuevastring =  String.valueOf(surtidanuevaint);
            
      
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET surtidas = '" + surtidanuevastring + "' WHERE numero='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacioncantidad + "'");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       
            
            
            
            
            

        ////Actualiza el estatus

      String sumasurtidastring = "";  
      String sumavendidastring = "";  
      String sumaenviadastring = "";  
      
      int sumasurtidaint = 0;  
      int sumavendidaint = 0;  
      int sumaenviadaint = 0;  
       
      
      
      
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(enviadas) as enviadas from historial_ordenes_envio_recibidas where numero = '"+numeroordenopedidorecibido+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        sumavendidastring = rs.getString("cantidad");
        sumasurtidastring = rs.getString("surtidas");
        sumaenviadastring = rs.getString("enviadas");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
      
      /////
      
       sumavendidaint = Integer.parseInt(sumavendidastring);
       sumasurtidaint = Integer.parseInt(sumasurtidastring);
       sumaenviadaint = Integer.parseInt(sumaenviadastring);
      
        
        if(sumavendidaint == sumasurtidaint && sumaenviadaint == 0 )
        {
          estatusentrega ="surtida totalmente no enviada";  
        }
        else  if(sumavendidaint == (sumasurtidaint + sumaenviadaint )  &&  sumaenviadaint <  sumavendidaint  )
        {
          estatusentrega ="surtida totalmente enviada parcialmente";  
        }
        
        else
        {
          estatusentrega ="surtida parcialmente no enviada";   
        }    
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroordenopedidorecibido + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      

            
            
            
            
            ////////////////////////////////////////////////
            
            
            

        }
        else 
        {
            
            
            ////////////////////////////////////////////////////////
            
            
        }
           if (tiendeordenopedido.equals("pedido")) 
            {

                
                
              
            String sql3 = "Select surtidas from historial_pedidos_sucursal_recibidos where articulo = '" + descripcion + "' and numero = '" + numeroordenopedidorecibido + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
               
                    
                  
                   surtidaactualstring = rs.getString("surtidas");
                          surtidaactualint = Integer.parseInt(surtidaactualstring);
        

                }
        
        else
        {
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EL BORDADO EN LA ORDEN DE ENVIO RECIBIDA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
        String[] lineas = observacion.split("\n");
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacioncantidad+"" + lineas[0] + "</span><br>";
        if (lineas.length > 1) {
         mensaje += "<span style=\"Color:red; font-size:20px;\">" + lineas[1] + "</span>";
}

          JOptionPane.showMessageDialog(null, mensaje);
                   
                   
                
                    
                }
                
                
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

            }
            
          
            
            
          
        
          if(surtidaactualstring ==null || surtidaactualstring.equals("")||surtidaactualstring.equals(" "))
      {
          surtidaactualstring ="0";
      } 
          
       
         cantidadint =  Integer.parseInt(cantidad);
        surtidanuevaint = surtidaactualint - cantidadint;
       
        surtidanuevastring =  String.valueOf(surtidanuevaint);
            
      
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET surtidas = '" + surtidanuevastring + "' WHERE numero='" + numeroordenopedidorecibido + "' and articulo = '" + descripcion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       
            
            
            
            
            
            

        ////Actualiza el estatus

      String sumasurtidastring = "";  
      String sumavendidastring = "";  
      String sumaenviadastring = "";  
      
      int sumasurtidaint = 0;  
      int sumavendidaint = 0;  
      int sumaenviadaint = 0;  
       
      
      
      
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtidas) as surtidas,Sum(enviadas) as enviadas from historial_pedidos_sucursal_recibidos where numero = '"+numeroordenopedidorecibido+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        sumavendidastring = rs.getString("cantidad");
        sumasurtidastring = rs.getString("surtidas");
        sumaenviadastring = rs.getString("enviadas");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
      
      /////
      
       sumavendidaint = Integer.parseInt(sumavendidastring);
       sumasurtidaint = Integer.parseInt(sumasurtidastring);
       sumaenviadaint = Integer.parseInt(sumaenviadastring);
      
        
        if(sumasurtidaint > 0 && sumaenviadaint > 0 )
        {
          estatusentrega ="surtida parcialmente traspasada parcialmente";  
        }
        else
          if(sumasurtidaint > 0 && sumaenviadaint == 0 )
        {
          estatusentrega ="surtida parcialmente no traspasado";  
        }
        
        else
        {
          estatusentrega ="no surtida no traspasada";   
        }    
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroordenopedidorecibido + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      

            
            
            
            
            }
         
         
         
         
         
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
      
      
      
      
      
     
     
 
    void hilosycolor()
    {
       
     

        String sql = "Select hilo1,hilo2,hilo3,hilo4,color1,color2,color3,color4,numero_consecutivo from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'PANTALON'   ";

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
                  lbcolor1.setText(codigo1.toString());
                  lbcodigo1.setText(hilo1.toString());
                }  
                
                if(codigo2.equals("ninguno"))
                {
                  
                }
                else
                {
                  lbcolor2.setText(codigo2.toString());
                  lbcodigo2.setText(hilo2.toString());
                }  
                
                 if(codigo3.equals("ninguno"))
                {
                  
                }
                else
                {
                  lbcolor3.setText(codigo3.toString());
                  lbcodigo3.setText(hilo3.toString());
                }  
                
                if(codigo4.equals("ninguno"))
                {
                  
                }
                else
                {
                  lbcolor4.setText(codigo4.toString());
                  lbcodigo4.setText(hilo4.toString());
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
            
           
            
            btnladoderechofrentetermine.setEnabled(false);
            btnladoderechoatrastermine.setEnabled(false);
            btnladoizquierdofrentetermine.setEnabled(false);
            btnladoizquierdoatrastermine.setEnabled(false);
            
            btnponchado2.setEnabled(false);
            btnponchado4.setEnabled(false);
            btnponchado1.setEnabled(false);
            btnponchado3.setEnabled(false);
            
           
            lbfotomontaje.setVisible(false);
            btnverfotomontaje.setEnabled(false);
         

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
            
       }  

        
        
    }
    
     
     void datosotrasucursal () throws FileNotFoundException, IOException
    {
        
         numeroordendebordadosolicitadoorecibidasisehabredesderecibidas = lborden.getText();
         prenda = "Pantalon";
       

        String botonhabilitado1 = "";
        String botonhabilitado2 = "";
        String botonhabilitado3 = "";
        String botonhabilitado4 = "";

        String sql = "Select orden_o_pedido,fecha,hora,cliente,nombre_comercial,borda_cliente,numero_orden_o_pedido_solicitada,numero_orden_o_pedido_recibida,tienda,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,lado_izquierdo_frente_nombre,lado_derecho_frente_nombre,lado_izquierdo_atras_nombre,lado_derecho_atras_nombre,lado_izquierdo_frente_nombre,lado_derecho_frente_cantidad,lado_izquierdo_atras_nombre,lado_derecho_atras_cantidad,lado_izquierdo_frente_puntadas,lado_derecho_frente_nombre,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas,lugar,identificador_prenda,estatus_orden from historial_ordenes_pantalon_recibidas where numero = '" + numeroordendebordadosolicitadoorecibidasisehabredesderecibidas + "' and prenda = '" + prenda + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                
                
                tiendeordenopedido = rs.getString("orden_o_pedido");
                lbordenopedidorecibido.setText(tiendeordenopedido);
                
                numeroordenopedidorecibido = rs.getString("numero_orden_o_pedido_recibida");
                lbnumeroordenopedidorecibido.setText(numeroordenopedidorecibido);

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
             
                
                
                
                
                
                if (ladoizquierdofrentenombre == null || ladoizquierdofrentenombre.equals("") || ladoizquierdofrentenombre.equals("ninguno")) 
                {
                    
                 
                  btnponchado1.setEnabled(false);
                  btncargarponchado1.setEnabled(false);
                  

                }
                
                else
                
                {

                   lbladoizquierdofrentenombre.setText(ladoizquierdofrentenombre);
                   lbladoizquierdofrentepuntadas.setText(rs.getString("lado_izquierdo_frente_puntadas"));
                    
                    btnponchado1.setEnabled(true);
                 
                    botonhabilitado1 ="si";
                    btncargarponchado1.setEnabled(true);
                    
                    
                    
                }

                
                /// lado derecho frente
                
               
                if (ladoderechofrentenombre == null || ladoderechofrentenombre.equals("")  || ladoderechofrentenombre.equals("ninguno")) 
                {
                   
                    btnponchado2.setEnabled(false);
                    btncargarponchado2.setEnabled(false);
                } 
                else
                {

                     lbladoderechofrentenombre.setText(ladoderechofrentenombre);
                    lbladoderechofrentepuntadas.setText(rs.getString("lado_derecho_frente_nombre"));
                  
                    btnponchado2.setEnabled(true);
                    
                    botonhabilitado2 ="si";
                    btncargarponchado3.setEnabled(true);
                   
                }

                
                
                
                
                
            
                if (ladoizquierdoatrasnombre == null || ladoizquierdoatrasnombre.equals("") || ladoizquierdoatrasnombre.equals("ninguno"))
                {
                   
                    btnponchado3.setEnabled(false);
                    btncargarponchado3.setEnabled(false);
                } 
                else 
                {


                    lbladoizquierdoatrasnombre.setText(ladoizquierdoatrasnombre);
                    lbladoizquierdoatraspuntadas.setText(rs.getString("lado_izquierdo_atras_puntadas"));
                  
                     btnponchado3.setEnabled(true);
                    
                    botonhabilitado3 ="si";
                    btncargarponchado3.setEnabled(false);
           
                   
                    
                }

               
                if (ladoderechoatrasnombre == null || ladoderechoatrasnombre.equals("") || ladoderechoatrasnombre.equals("ninguno")) 
                {
                   
                     btnponchado4.setEnabled(false);
                     btncargarponchado4.setEnabled(false);
                }
                else 
                {


                   lbladoderechoatrasnombre.setText(ladoderechoatrasnombre);
                    lbladoderechoatraspuntadas.setText(rs.getString("lado_derecho_atras_puntadas"));
                    
                     btnponchado4.setEnabled(true);
                 
                    botonhabilitado4 ="si";
                    btncargarponchado4.setEnabled(true);
                    
                   
                    
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
                String cantidadladoderechofrente = rs.getString("lado_derecho_frente_cantidad");
                 String cantidadladoizquierdoatras = rs.getString("lado_izquierdo_atras_cantidad");
                String cantidadladoderechoatras = rs.getString("lado_derecho_atras_cantidad");
                
                
                
                 if( botonhabilitado1.equals("si"))
                {
                    
                    
                    
                    if(cantidadladoizquierdofrente.equals("0") )
                        
                    {
                    
                    btnladoizquierdofrentetermine.setEnabled(true);
                    btnladoizquierdofrentecancelar.setEnabled(false);
                    
                     lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
                    
                    
                    
                    
                    
                    listabotones.add("btnladoizquierdofrente");
                    
                    
                    
                    }
                    
                    else
                        
                    {
                        
                           btnladoizquierdofrentecancelar.setEnabled(true);
                           btnladoizquierdofrentetermine.setEnabled(false);
                           
                           
                        lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());
                        
                    }
                    
                    
                    
                    
                }
                else
                {
                   btnladoizquierdofrentetermine.setEnabled(false);
                   
                }    
                
                
                
                 
                 
                 
                 
                 
                 
                 
                 
                 
                if(botonhabilitado2.equals("si"))
                {
                    
                    
                    
                    
                     if(cantidadladoderechofrente.equals("0"))
                    
                     {
                   btnladoderechofrentetermine.setEnabled(true);
                   btnladoderechoatrascancelar.setEnabled(false);
                    
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                    
                   listabotones.add("btnladoderechofrente");
                   
                   
                     }
                     
                     else
                     {
                         
                            btnladoderechoatrascancelar.setEnabled(true);
                            btnladoderechofrentetermine.setEnabled(false);
                  lbcantidad2.setText(cantidad);
                   lbcantidad2.setForeground(Color.GREEN.darker());
                         
                         
                     }
                     
                     
                }
                else
                {
                    
                    
                  btnladoderechofrentetermine.setEnabled(false);
                
                
                } 
                
              
                
                
                
               
                if( botonhabilitado3.equals("si"))
                {
                    
                    
                    
                    if(cantidadladoizquierdoatras.equals("0"))
                        
                    {
                    btnladoizquierdoatrastermine.setEnabled(true);
                   btnladoizquierdoatrascancelar.setEnabled(false);
                     
                      lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                     
                     
                    listabotones.add("btnladoizquierdoatras");
                    
                    
                    }
                    
                    else
                        
                    {
                            btnladoizquierdoatrascancelar.setEnabled(true);
                             btnladoizquierdoatrastermine.setEnabled(false);
                  lbcantidad3.setText(cantidad);
                   lbcantidad3.setForeground(Color.GREEN.darker());
                        
                    }
                    
                    
                }
                else
                {
                    btnladoizquierdoatrastermine.setEnabled(false);
                
                } 
                
                
                
                
                
                
                
                
                
                
                
                
                
                if( botonhabilitado4.equals("si"))
                {
                    
                    
                    
                    if(cantidadladoderechoatras.equals("0"))
                        
                        
                    {
                    btnladoderechoatrastermine.setEnabled(true);
                    btnladoderechoatrascancelar.setEnabled(false);
                     
                      lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                     
                     
                    listabotones.add("btnladoderechoatras");
                    
                    }
                    
                    
                    else
                        
                    {
                        
                           
                 btnladoderechoatrascancelar.setEnabled(true);
                  btnladoderechoatrastermine.setEnabled(false);
                  
                  
                   lbcantidad4.setText(cantidad);
                   lbcantidad4.setForeground(Color.GREEN.darker());
                        
                    }
                    
                }
                else
                {
                     btnladoderechoatrastermine.setEnabled(false);
                }
                
                
                
                
                
                
                      
                    
                    
                    
                    
                    
                    
                    
                    
                
               
                
                }

            }

        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        
        
        
        
        
        
          
        String cliente = lbcliente.getText();
        
        
        
            
                
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
     
     
     
     
     
     
     
     

      void insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDA()
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE  "+nombredelatabla+" set "+ubicacioncantidad+"='" + cantidad + "',"+ubicacionfecha+"  =  '"+dia()+"' where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacioncantidad;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
    //    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
       
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalonS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
      
    void insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDAcancelar()
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE  "+nombredelatabla+" set "+ubicacioncantidad+"='0', "+ubicacionfecha+"=null where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacioncantidad;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
    //    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
       
        try {
            datostiendalocal();
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
    
    
    
     void agregaralsurtidasalhistorialdeventasyactualizarestatusentrega() 
      {

        numerodeventa =  lbnumerodeventa.getText();
        String surtidaactualstring ="";
        int surtidaactualint =  0;
        String nuevasurtidastring = "";
        String estatusentrega ="";
        String estatusentregaventa = "";
        
         String SQL2 = "select articulo,surtida,estatus_entrega from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + descripcion + "'  and identificador_prenda = '"+identificador+"' ";
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
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+descripcion+"" + lineas[0] + "</span><br>";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + nuevasurtidastring + "' WHERE numero='" + numerodeventa + "' and articulo = '" + descripcion + "'      ");
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + totalaplicaciones + "' WHERE numero='" + numerodeventa + "' and articulo = '" + descripcionaplicacion + "'      ");
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
     
    
     void agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar() 
      {

        numerodeventa =  lbnumerodeventa.getText();
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
        String estatusentregaventa = "";
        
        String SQL2 = "select cantidad,estatus_entrega from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + descripcion + "' and identificador_prenda = '"+identificador+"'";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '"+nuevacantidadstring+"' WHERE numero='" + numerodeventa + "' and articulo = '" + descripcion + "'");
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '"+totalaplicaciones+"' WHERE numero='" + numerodeventa + "' and articulo = '" + descripcionaplicacion + "'  and identificador_prenda = '"+identificador+"'");
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
                 PreparedStatement ps = cn.prepareStatement("select " + ubicacion + "," + ubicacionnombre + " from historial_ordenes_pantalon_recibidas where numero = '" + numeroordendebordadosolicitadoorecibidasisehabredesderecibidas + "' ")) {
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
     
    
      void actualizarestatusentregaordendebordado()
    {
        
       
        int tienecantidad = 0;
        int botonesactivados = 0;
        
         String sql = "Select lado_izquierdo_frente_cantidad,lado_izquierdo_frente_puntadas,"
                  + "lado_derecho_frente_cantidad,lado_derecho_frente_puntadas,"
                  + "lado_izquierdo_atras_cantidad,lado_izquierdo_atras_puntadas,"
                  + "lado_derecho_atras_cantidad,lado_derecho_atras_puntadas from historial_ordenes_pantalon where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"' ";

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

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon set estatus_orden='"+nuevoestatusorden+"',fecha='"+dia()+"' where numero='" + numeroordendebordadosolicitadoorecibidasisehabredesderecibidas + "'   ");
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
        btnreplicartodoslosponchados = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbfotomontaje = new javax.swing.JLabel();
        lbsucursal = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        btnladoderechofrentetermine = new javax.swing.JButton();
        btnladoderechoatrastermine = new javax.swing.JButton();
        btnladoizquierdofrentetermine = new javax.swing.JButton();
        btnladoizquierdoatrastermine = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        lbcolor2 = new javax.swing.JLabel();
        lbcolor4 = new javax.swing.JLabel();
        lbcolor1 = new javax.swing.JLabel();
        lbcolor3 = new javax.swing.JLabel();
        btnverfotomontaje = new javax.swing.JButton();
        btnterminetodo = new javax.swing.JButton();
        lbbordacliente = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lbnombrecomercial = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbcodigo2 = new javax.swing.JLabel();
        lbcodigo3 = new javax.swing.JLabel();
        lbcodigo1 = new javax.swing.JLabel();
        lbcodigo4 = new javax.swing.JLabel();
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
        btnponchado2 = new javax.swing.JButton();
        btnponchado4 = new javax.swing.JButton();
        btnponchado1 = new javax.swing.JButton();
        btnponchado3 = new javax.swing.JButton();
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
        jLabel25 = new javax.swing.JLabel();
        lbordenopedidorecibido = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbsumapuntos4 = new javax.swing.JLabel();
        lbsumapuntos3 = new javax.swing.JLabel();
        lbsumapuntos2 = new javax.swing.JLabel();
        lbsumapuntos1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btncargarponchado2 = new javax.swing.JButton();
        btncargarponchado1 = new javax.swing.JButton();
        btncargarponchado3 = new javax.swing.JButton();
        btncargarponchado4 = new javax.swing.JButton();
        btnreplicar4 = new javax.swing.JButton();
        btnreplicar3 = new javax.swing.JButton();
        btnreplicar2 = new javax.swing.JButton();
        btnreplicar1 = new javax.swing.JButton();
        btnquitarponchado1 = new javax.swing.JButton();
        btnquitarponchado2 = new javax.swing.JButton();
        btnquitarponchado3 = new javax.swing.JButton();
        btnquitarponchado4 = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        lbnumeroordenopedidorecibido = new javax.swing.JLabel();

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
        jLabel13.setText("Numero orden de bordado");
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

        btnreplicartodoslosponchados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreplicartodoslosponchados.setText("Replicar todos");
        btnreplicartodoslosponchados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicartodoslosponchadosActionPerformed(evt);
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

        btnladoderechofrentetermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechofrentetermine.setText("Termine");
        btnladoderechofrentetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoderechofrentetermineMouseReleased(evt);
            }
        });
        btnladoderechofrentetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechofrentetermineActionPerformed(evt);
            }
        });

        btnladoderechoatrastermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderechoatrastermine.setText("Termine");
        btnladoderechoatrastermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoderechoatrastermineMouseReleased(evt);
            }
        });
        btnladoderechoatrastermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechoatrastermineActionPerformed(evt);
            }
        });

        btnladoizquierdofrentetermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdofrentetermine.setText("Termine");
        btnladoizquierdofrentetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoizquierdofrentetermineMouseReleased(evt);
            }
        });
        btnladoizquierdofrentetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdofrentetermineActionPerformed(evt);
            }
        });

        btnladoizquierdoatrastermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdoatrastermine.setText("Termine");
        btnladoizquierdoatrastermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoizquierdoatrastermineMouseReleased(evt);
            }
        });
        btnladoizquierdoatrastermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdoatrastermineActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total de puntos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbsumapuntos.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolor2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolor4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolor1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolor3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        btnterminetodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnterminetodo.setText("Termine todo");
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

        lbcodigo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigo2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigo3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigo1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigo4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btneliminarbtneditarbordado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminarbtneditarbordado.setText("Editar bordado");
        btneliminarbtneditarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarbtneditarbordadoActionPerformed(evt);
            }
        });

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        btnponchado2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnponchado2.setText("Ponchado");
        btnponchado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado2ActionPerformed(evt);
            }
        });

        btnponchado4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnponchado4.setText("Ponchado");
        btnponchado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado4ActionPerformed(evt);
            }
        });

        btnponchado1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnponchado1.setText("Ponchado");
        btnponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado1ActionPerformed(evt);
            }
        });

        btnponchado3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnponchado3.setText("Ponchado");
        btnponchado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado3ActionPerformed(evt);
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

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel25.setText("Tiene orden o pedido recibido?");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbordenopedidorecibido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbordenopedidorecibido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Puntos");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Puntos");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Puntos");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbsumapuntos4.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbsumapuntos3.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbsumapuntos2.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbsumapuntos1.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Puntos");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btncargarponchado2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado2.setText("Cargar Ponchado");
        btncargarponchado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado2ActionPerformed(evt);
            }
        });

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

        btncargarponchado4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado4.setText("Cargar Ponchado");
        btncargarponchado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado4ActionPerformed(evt);
            }
        });

        btnreplicar4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar4.setText("Replicar");
        btnreplicar4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar4ActionPerformed(evt);
            }
        });

        btnreplicar3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar3.setText("Replicar");
        btnreplicar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar3ActionPerformed(evt);
            }
        });

        btnreplicar2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar2.setText("Replicar");
        btnreplicar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar2ActionPerformed(evt);
            }
        });

        btnreplicar1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnreplicar1.setText("Replicar");
        btnreplicar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar1ActionPerformed(evt);
            }
        });

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

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel31.setText("Orden o pedido recibido");
        jLabel31.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroordenopedidorecibido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumeroordenopedidorecibido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(btnladoderechoatrastermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(8, 8, 8)
                                                        .addComponent(btnladoderechoatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(btnladoizquierdofrentetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnladoderechofrentetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btnladoizquierdoatrastermine, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                            .addComponent(lbcodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lbcodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lbcodigo3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(20, 20, 20)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lbcodigo4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(20, 20, 20)
                                                        .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(btncargarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(btncargarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(2, 2, 2))
                                                    .addComponent(btncargarponchado4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btncargarponchado3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnreplicartodoslosponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(btnquitarponchado1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnquitarponchado2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnquitarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnquitarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btnreplicar1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnreplicar2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnreplicar3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnreplicar4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(25, 25, 25)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(lbsumapuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(lbsumapuntos2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(lbsumapuntos3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(1, 1, 1)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(15, 15, 15)
                                                .addComponent(lbsumapuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane6)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60)
                                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnfotomontajesinpuntadas))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbidentificador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btndatos)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel18)
                                                .addGap(160, 160, 160)
                                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel30)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(jLabel15)
                                                        .addGroup(layout.createSequentialGroup()
                                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addGap(12, 12, 12)
                                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                            .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                            .addComponent(lbnumeroordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(29, 29, 29)
                                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(0, 18, Short.MAX_VALUE)))))
                        .addGap(15, 15, 15))
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
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbnumeroordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(13, 13, 13)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnquitarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnquitarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnquitarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncargarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnquitarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncargarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnreplicar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnreplicar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(btnreplicar3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnreplicar4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btncargarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncargarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                            .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(lbcodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(lbcodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(lbcodigo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbcodigo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnladoizquierdofrentetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(btnladoderechofrentetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnladoizquierdoatrastermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnladoizquierdoatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(btnladoizquierdofrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(btnladoderechofrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(7, 7, 7)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnladoderechoatrastermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbladoizquierdofrente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(lbladoderechofrente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(lbdadoizquierdoatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(lbladoderechoatras1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbsumapuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(btnponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(btnponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnreplicartodoslosponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                
                
             
              
          
         
        
    }//GEN-LAST:event_btnreplicartodoslosponchadosActionPerformed
   
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

          conectadaasucursal();
          
          
        datos();
        
      
        
        
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

    private void btnladoizquierdofrentetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdofrentetermineActionPerformed

        
        
        ubicacionfecha  = "lado_izquierdo_frente_fecha";
           ubicacioncantidad = "lado_izquierdo_frente_cantidad"; 
            
           ubicacionprenda = "LADO DERECHO FRENTE";
           nombrebordado =ladoizquierdofrentenombre;
           cantidadaplicacion = "1";
        
        
        determinaciondeladescripciondelbordado();
                
                
                
                    if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        
                    {
                
    
                        
                        
              //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
        agregaralsurtidasalhistorialdeventasyactualizarestatusentrega();       
          
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal"))
        {
          
       
        
         
         agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega();
            
           

        }
                      
                        
                        
            insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDA();
        
         
         actualizarestatusentregaordendebordado();    
        
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
                     
                    }
                    
                    
                    
                    
                
                    
                    
                    
                    
        
        
        
    }//GEN-LAST:event_btnladoizquierdofrentetermineActionPerformed

    private void btnladoizquierdoatrastermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrastermineActionPerformed

        
          ubicacionfecha  = "lado_izquierdo_atras_fecha";
           ubicacioncantidad = "lado_izquierdo_atras_cantidad"; 
            
           ubicacionprenda = "LADO DERECHO ATRAS";
           nombrebordado =ladoizquierdoatrasnombre;
           cantidadaplicacion = "1";
        
        
           
           
            determinaciondeladescripciondelbordado();
                
                
                
                    if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        
                    {
                
    
                        
                        
              //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
        agregaralsurtidasalhistorialdeventasyactualizarestatusentrega();       
          
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal"))
        {
          
       
        
         
         agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega();
            
           

        }
                      
                        
                        
            insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDA();
        
         
         actualizarestatusentregaordendebordado();    
        
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
                     
                    }
                    
                    
                    
                    
                
                    
                    
                    
                    
           
    }//GEN-LAST:event_btnladoizquierdoatrastermineActionPerformed

    private void btnladoderechoatrastermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoatrastermineActionPerformed

        
        
          ubicacionfecha  = "lado_izquierdo_atras_fecha";
           ubicacioncantidad = "lado_izquierdo_atras_cantidad"; 
            
           ubicacionprenda = "LADO DERECHO ATRAS";
           nombrebordado =ladoizquierdoatrasnombre;
           cantidadaplicacion = "1";
        
        
        determinaciondeladescripciondelbordado();
        
        
        
         determinaciondeladescripciondelbordado();
                
                
                
                    if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        
                    {
                
    
                        
                        
              //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
        agregaralsurtidasalhistorialdeventasyactualizarestatusentrega();       
          
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal"))
        {
          
       
        
         
         agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega();
            
           

        }
                      
                        
                        
            insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDA();
        
         
         actualizarestatusentregaordendebordado();    
        
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
                     
                    }
                    
                    
                    
                    
                
                    
                    
                    
                    
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnladoderechoatrastermineActionPerformed

    private void btnladoderechofrentetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechofrentetermineActionPerformed

        
        
        
          ubicacionfecha  = "lado_izquierdo_frente_fecha";
           ubicacioncantidad = "lado_izquierdo_frente_cantidad"; 
            
           ubicacionprenda = "LADO IZQUIERDO FRENTE";
           nombrebordado =ladoizquierdofrentenombre;
           cantidadaplicacion = "1";
        
        
       
            determinaciondeladescripciondelbordado();
                
                
                
                    if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        
                    {
                
    
                        
                        
              //ESTA SUCURSAL
            
        if(lugar.equals("Esta sucursal"))
        {
       
      
        agregaralsurtidasalhistorialdeventasyactualizarestatusentrega();       
          
       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal"))
        {
          
       
        
         
         agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega();
            
           

        }
                      
                        
                        
            insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDA();
        
         
         actualizarestatusentregaordendebordado();    
        
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
                     
                    }
                    
                    
                    
                    
                
                    
                    
                    
                    
           
           
    }//GEN-LAST:event_btnladoderechofrentetermineActionPerformed

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
                
                if(btnladoizquierdofrentetermine.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoizquierdofrentetermine.doClick();
                }
                
            }
            else if(boton.equals("btnladoderechofrente"))
            {
                if(btnladoderechofrentetermine.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoderechofrentetermine.doClick();
                }
            }
            else if(boton.equals("btnladoizquierdoatras"))
            {
                if(btnladoizquierdoatrastermine.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoizquierdoatrastermine.doClick();
                }
            }
            else if(boton.equals("btnladoderechoatras"))
            {
                if(btnladoderechoatrastermine.getText().equals("Cancelar"))
                {
                }
                else
                {
                btnladoderechoatrastermine.doClick();
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
        
         if(ordenesporrealizar.ventanaordenesporrealizar==true)
        {
            ordenesporrealizar.btndatos.doClick();
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

        
        
         
          ubicacionfecha  = "lado_izquierdo_frente_fecha";
           ubicacioncantidad = "lado_izquierdo_frente_cantidad"; 
            
           ubicacionprenda = "LADO IZQUIERDO FRENTE";
           nombrebordado =ladoizquierdofrentenombre;
           cantidadaplicacion = "1";
        
        
        
        
        
        
        
        
        
        String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
       
    
                
          determinaciondeladescripciondelbordado();
              
              
              
                    
          if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
                       
                    
                    
                    agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar();
              
                    
                    
                    
                    
                    
                    
        }    
          
          
          else
              
              
          {
              
              
           agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentregacancelar();
              
          }
                    
                    
                    
                    insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDAcancelar();
         
                    
                    
                    actualizarestatusentregaordendebordado();
                 
                  
                    
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
            autorizacion.lbinterfaz.setText("pantaloncancelar2");
            autorizacion.lbnivel.setText("2");

        }
        }    
                 
    }//GEN-LAST:event_btnladoderechofrentecancelarActionPerformed

    private void btnladoderechoatrascancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoatrascancelarActionPerformed
        
        
        
           ubicacionfecha  = "lado_izquierdo_atras_fecha";
           ubicacioncantidad = "lado_izquierdo_atras_cantidad"; 
            
           ubicacionprenda = "LADO DERECHO ATRAS";
           nombrebordado =ladoizquierdoatrasnombre;
           cantidadaplicacion = "1";
        
        
        
        String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
           
          determinaciondeladescripciondelbordado();
              
              
              
                    
          if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
                       
                    
                    
                    agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar();
              
                    
                    
                    
                    
                    
                    
        }    
          
          
          else
              
              
          {
              
              
           agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentregacancelar();
              
          }
                    
                    
                    
                    insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDAcancelar();
         
                    
                    
                    actualizarestatusentregaordendebordado();
                 
                  
                    
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
            autorizacion.lbinterfaz.setText("pantaloncancelar4");
            autorizacion.lbnivel.setText("2");

        }
        }    
                 
                 
            
                 
                 
                 
                 
                 
                 

    }//GEN-LAST:event_btnladoderechoatrascancelarActionPerformed

    private void btnladoizquierdofrentecancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdofrentecancelarActionPerformed
     
        
           ubicacionfecha  = "lado_izquierdo_frente_fecha";
           ubicacioncantidad = "lado_izquierdo_frente_cantidad"; 
            
           ubicacionprenda = "LADO DERECHO FRENTE";
           nombrebordado =ladoizquierdofrentenombre;
           cantidadaplicacion = "1";
        
        
        String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
        
    
                
          determinaciondeladescripciondelbordado();
              
              
              
                    
          if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
                       
                    
                    
                    agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar();
              
                    
                    
                    
                    
                    
                    
        }    
          
          
          else
              
              
          {
              
              
           agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentregacancelar();
              
          }
                    
                    
                    
                    insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDAcancelar();
         
                    
                    
                    actualizarestatusentregaordendebordado();
                 
                  
                    
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
            autorizacion.lbinterfaz.setText("pantaloncancelar1");
            autorizacion.lbnivel.setText("2");

        }
        }    
                 
    }//GEN-LAST:event_btnladoizquierdofrentecancelarActionPerformed

    private void btnladoizquierdoatrascancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrascancelarActionPerformed


         
          ubicacionfecha  = "lado_izquierdo_atras_fecha";
           ubicacioncantidad = "lado_izquierdo_atras_cantidad"; 
            
           ubicacionprenda = "LADO DERECHO ATRAS";
           nombrebordado =ladoizquierdoatrasnombre;
           cantidadaplicacion = "1";






        String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
      
    
                
          determinaciondeladescripciondelbordado();
              
              
              
                    
          if(lugar.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
                       
                    
                    
                    agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar();
              
                    
                    
                    
                    
                    
                    
        }    
          
          
          else
              
              
          {
              
              
           agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentregacancelar();
              
          }
                    
                    
                    
                    insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDAcancelar();
         
                    
                    
                    actualizarestatusentregaordendebordado();
                 
                  
                    
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
            autorizacion.lbinterfaz.setText("pantaloncancelar3");
            autorizacion.lbnivel.setText("2");

        }
        }    
                 
    }//GEN-LAST:event_btnladoizquierdoatrascancelarActionPerformed

    private void btnponchado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado2ActionPerformed
       String ubicacion ="lado_derecho_frente_ponchado";
                String ubicacionnombre ="lado_derecho_frente_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
    }//GEN-LAST:event_btnponchado2ActionPerformed

    private void btnponchado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado4ActionPerformed
       String ubicacion ="lado_derecho_atras_ponchado";
                String ubicacionnombre ="lado_derecho_atras_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
    }//GEN-LAST:event_btnponchado4ActionPerformed

    private void btnponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado1ActionPerformed

        
        String ubicacion ="lado_izquierdo_frente_ponchado";
                String ubicacionnombre ="lado_izquierdo_frente_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
    }//GEN-LAST:event_btnponchado1ActionPerformed

    private void btnponchado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado3ActionPerformed
       String ubicacion ="lado_izquierdo_atras_ponchado";
                String ubicacionnombre ="lado_izquierdo_atras_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
    }//GEN-LAST:event_btnponchado3ActionPerformed

    private void btnladoizquierdofrentetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoizquierdofrentetermineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnladoizquierdofrentetermineMouseReleased

    private void btnladoderechofrentetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoderechofrentetermineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnladoderechofrentetermineMouseReleased

    private void btnladoizquierdoatrastermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrastermineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnladoizquierdoatrastermineMouseReleased

    private void btnladoderechoatrastermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoderechoatrastermineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnladoderechoatrastermineMouseReleased

    private void btnladoizquierdofrentecancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoizquierdofrentecancelarMouseReleased
        // TODO add your handling code here:       
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
             
    }//GEN-LAST:event_btnladoizquierdofrentecancelarMouseReleased

    private void btnladoderechofrentecancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoderechofrentecancelarMouseReleased
               
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
             
    }//GEN-LAST:event_btnladoderechofrentecancelarMouseReleased

    private void btnladoizquierdoatrascancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoizquierdoatrascancelarMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
               
    }//GEN-LAST:event_btnladoizquierdoatrascancelarMouseReleased

    private void btnladoderechoatrascancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoderechoatrascancelarMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                
    }//GEN-LAST:event_btnladoderechoatrascancelarMouseReleased

    private void btncargarponchado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado2ActionPerformed
        
        
        
          JSystemFileChooser adjuntar = new JSystemFileChooser();
      

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

    private void btncargarponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado1ActionPerformed
      
        
         JSystemFileChooser adjuntar = new JSystemFileChooser();
      

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
       
        
            
         JSystemFileChooser adjuntar = new JSystemFileChooser();
      

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

    private void btncargarponchado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado4ActionPerformed
      
        
        
            
         JSystemFileChooser adjuntar = new JSystemFileChooser();
      

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

    private void btnreplicar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar4ActionPerformed
    
        
        
        ubicacionponchado= "lado_derecho_atras_ponchado";
        ubicacionponchadonombre = "lado_derecho_atras_ponchado_nombre";
                
        
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

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set "+ubicacionponchado+" =? where numero_orden_pantalon_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_pantalon_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL NOMBRE DEL PONCHADO");
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
            
            
            
        
        
    }//GEN-LAST:event_btnreplicar4ActionPerformed

    private void btnreplicar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar3ActionPerformed
         ubicacionponchado= "lado_izquierdo_atras_ponchado";
        ubicacionponchadonombre = "lado_izquierdo_atras_nombre";
                
        
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

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set "+ubicacionponchado+" =? where numero_orden_pantalon_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_pantalon_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL NOMBRE DEL PONCHADO");
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
        
        
    }//GEN-LAST:event_btnreplicar3ActionPerformed

    private void btnreplicar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar2ActionPerformed
     
        
        
        ubicacionponchado= "lado_derecho_frente_ponchado";
        ubicacionponchadonombre = "lado_derecho_frente_nombre";
                
        
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

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set "+ubicacionponchado+" =? where numero_orden_pantalon_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_pantalon_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL NOMBRE DEL PONCHADO");
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
        
        
    }//GEN-LAST:event_btnreplicar2ActionPerformed

    private void btnreplicar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar1ActionPerformed
     
        
         ubicacionponchado= "lado_izquierdo_frente_ponchado";
        ubicacionponchadonombre = "lado_izquierdo_frente_nombre";
                
        
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

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set "+ubicacionponchado+" =? where numero_orden_pantalon_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"' ";
                    PreparedStatement pst = cnsucursal.prepareStatement(sql2);
                    pst.setBinaryStream(1, input);
                    pst.executeUpdate();
                    pst.close();
                 

                } catch (Exception e) {
                   
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL PONCHADO");
                }
                
                
                
                 try {
                
                PreparedStatement pst = cnsucursal.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set "+ubicacionponchadonombre+" ='"+nombrearchivo+"' where numero_orden_pantalon_solicitada='" +numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+ "' and prenda = '" + prenda + "' and identificador_prenda = '"+identificador+"'");
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Error al REPLICAR EL NOMBRE DEL PONCHADO");
                }
                 
                 
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado en "+ubicacionponchadonombre+" replicado correctamente ");
                
             

            }
        
        
        
    }//GEN-LAST:event_btnreplicar1ActionPerformed

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
    private javax.swing.JButton btncargarponchado1;
    private javax.swing.JButton btncargarponchado2;
    private javax.swing.JButton btncargarponchado3;
    private javax.swing.JButton btncargarponchado4;
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneliminarbtneditarbordado;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    public static javax.swing.JButton btnladoderechoatrascancelar;
    private javax.swing.JButton btnladoderechoatrastermine;
    public static javax.swing.JButton btnladoderechofrentecancelar;
    private javax.swing.JButton btnladoderechofrentetermine;
    public static javax.swing.JButton btnladoizquierdoatrascancelar;
    private javax.swing.JButton btnladoizquierdoatrastermine;
    public static javax.swing.JButton btnladoizquierdofrentecancelar;
    private javax.swing.JButton btnladoizquierdofrentetermine;
    private javax.swing.JButton btnponchado1;
    private javax.swing.JButton btnponchado2;
    private javax.swing.JButton btnponchado3;
    private javax.swing.JButton btnponchado4;
    private javax.swing.JButton btnquitarponchado1;
    private javax.swing.JButton btnquitarponchado2;
    private javax.swing.JButton btnquitarponchado3;
    private javax.swing.JButton btnquitarponchado4;
    private javax.swing.JButton btnreplicar1;
    private javax.swing.JButton btnreplicar2;
    private javax.swing.JButton btnreplicar3;
    private javax.swing.JButton btnreplicar4;
    private javax.swing.JButton btnreplicartodoslosponchados;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
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
    public javax.swing.JLabel lbcodigo1;
    public javax.swing.JLabel lbcodigo2;
    public javax.swing.JLabel lbcodigo3;
    public javax.swing.JLabel lbcodigo4;
    public javax.swing.JLabel lbcolor1;
    public javax.swing.JLabel lbcolor2;
    public javax.swing.JLabel lbcolor3;
    public javax.swing.JLabel lbcolor4;
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
    public static javax.swing.JLabel lbnumeroordenopedidorecibido;
    public static javax.swing.JLabel lbnumeroordenopedidosolicitado;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    public static javax.swing.JLabel lbordenopedidorecibido;
    public static javax.swing.JLabel lbprenda;
    public static javax.swing.JLabel lbsucursal;
    public javax.swing.JLabel lbsumapuntos;
    public javax.swing.JLabel lbsumapuntos1;
    public javax.swing.JLabel lbsumapuntos2;
    public javax.swing.JLabel lbsumapuntos3;
    public javax.swing.JLabel lbsumapuntos4;
    // End of variables declaration//GEN-END:variables

    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();

   
}
