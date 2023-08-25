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

public class ordengorraS extends javax.swing.JFrame {

    public static boolean ventanaordengorra = false;
   
    
    public static String ordenbordadocamisa = "";

    String codigocliente ="";
    String iplocal = ingresotienda.iplocal;
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
    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;
    Connection cnsucursal = null;
    String nuevosbordadosutilizadosstring = "";
    int nuevosbordadosutilizadosint = 0;
    String numerodeventa = "";
    String tiendaconectada = "";
    String numeroordendebordadolocalorecibida = "";
    String numeroordendeenviosolicitada = "";
    String prenda ="";
    String cantidadaplicacion = "";
    String aplicacionfrente = "";
    String primero = "";
    String ultimo = "";
    String ipsucursal = "";
    String nuevoestatusorden = "";
    String nombrebordado = "";
    int traspaso = 0;
    String rutadelip = "";
    String numerosucursal = "";
    String numerosucursalordenbordado = "";
    String sucursal = "";
    String numerosolicitoarticulos = "";
    String tiendasolicitoarticulos = "";
    String numeroordenenvio = "";
    String tiendaordenenvio = "";
    String lugar = "";
    String numeroordendebordadosolicitadoorecibidasisehabredesderecibidas = "";
    int descargado = 0;
    
    String ladoizquierdonombre = "";
    String ladoderechonombre = "";
    String frentenombre = "";
    String atrasnombre = "";
    String numeroordenopedidorecibido = "";
    String descripcion ="";
    String descripcionaplicacion = "";
    String ubicacionprenda = "";
    String tienefotomontaje = "";
    String rutaimagen = "";
    public static String ordengorraautorizacion = "";
    String rutaarchivo = "";
    String nombrearchivo = "";
    public static String enquesucursalsebordara = "";
    public static String tipotabla = "";
    String nombredelatabla = "";
    String terminetodo ="";
    ArrayList<String> listabotones = new ArrayList<String>();
    public static String esponchado ="";
    
   String identificador = "";
   String consecutivo = "";
   String tieneunaobservacion = "";
   String tienenumerodesucursal = "";
   String tiendalocal = principal.tiendalocal;
   String rutadedondeestanlosbordados ="";
   String esenvioopedido = "";
   String rutafrente = "";
   String rutaatras = "";
   String rutaladoizquierdo = "";
   String rutaladoderecho = "";
   String tiendeordenopedido = "";
   
   
   
        String botonhabilitado1 = "";
        String botonhabilitado2 = "";
        String botonhabilitado3 = "";
        String botonhabilitado4 = "";
   
      public static final Color anaranjado = new Color(255,166,77);
   
 

    public ordengorraS() {
        initComponents();
        ventanaordengorra = true;

      
        btnreplicartodoslosponchados.setEnabled(false);
    //    btndatos.setVisible(false); 
        btnterminetodo.setEnabled(false);
        
        btnfrentecancelar.setEnabled(false);
         btnladoderechocancelar.setEnabled(false);      
          btnladoizquierdocancelar.setEnabled(false);
          btnatrascancelar.setEnabled(false);
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
        
        
        
        
if((enquesucursalsebordara.equals("Esta sucursal") ||   enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
      
         nombredelatabla = "historial_ordenes_gorra";

        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordengorraS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        codigocliente();
        
       
        
         hilosycolor();
        
        try {
            cargarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordengorraS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(enquesucursalsebordara.equals("Otra sucursal") && (numerosucursalordenbordado == null || numerosucursalordenbordado.equals("") || numerosucursalordenbordado.equals(" ") ) )
        {
            
         btnterminetodo.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Recuerda que Aqui solo replicas los ponchados y el fotomontaje");
        
        }
       
        sumapuntos();
        
    }


else 
    
    if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
        nombredelatabla = "historial_ordenes_gorra_recibidas";
        
         try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         
         sumapuntos();
    }


        AudioClip sonido;
        if (tieneunaobservacion.equals("si")) {
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/tienesunaobservacion.wav"));
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
        
       sumapuntos();
        
        
    }
    
    
    
    
    
    
    
    
    
    
    void deshabilitarbotonesporqueesponchado(){
        
        
        
        
        btnfrentetermine.setEnabled(false);
        btnladoderechotermine.setEnabled(false);
        btnladoizquierdotermine.setEnabled(false);
        btnatrastermine.setEnabled(false);
        
        
        btnterminetodo.setEnabled(false);        
                
                
        btnfrentecancelar.setEnabled(false);
        btnladoderechocancelar.setEnabled(false); 
        btnladoizquierdocancelar.setEnabled(false);
        btnatrascancelar.setEnabled(false);
        
        btnponchado1.setEnabled(false);
        btnponchado2.setEnabled(false);
        btnponchado3.setEnabled(false);
        btnponchado4.setEnabled(false);
           
     
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  

    void datostiendalocal() throws IOException {

        numeroordendebordadolocalorecibida = lborden.getText();
        
        

        String sql = "Select fecha,hora,cliente,nombre_comercial,borda_cliente,numero_venta,numero_orden,cantidad,cantidad_bordados,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,"
                + "lado_izquierdo_nombre,lado_derecho_nombre,frente_nombre,atras_nombre,aplicacion_frente,aplicacion_frente_color,lugar,frente_cantidad,lado_derecho_cantidad,lado_izquierdo_cantidad,atras_cantidad,identificador_prenda,estatus_orden,numero_orden,tienda,frente_puntadas,atras_puntadas,lado_izquierdo_puntadas,lado_derecho_puntadas from historial_ordenes_gorra where numero = '" + numeroordendebordadolocalorecibida + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                
                lbfecha.setText( rs.getString("fecha"));
                
                cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
                lbnombrecomercial.setText( rs.getString("nombre_comercial"));
                
               
                lbbordacliente.setText( rs.getString("borda_cliente"));
                
                numerodeventa = rs.getString("numero_venta");
                lbnumerodeventa.setText(numerodeventa);
                
                lbnumeroordenopedidosolicitado.setText( rs.getString("numero_orden"));
             
                lbnombrecomercial.setText( rs.getString("numero_orden"));
                
                cantidad = rs.getString("cantidad");
                lbcantidad.setText(cantidad);
                
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));
                
                frentenombre = rs.getString("frente_nombre");
               
                
                atrasnombre = rs.getString("atras_nombre");
                lbatrasnombre.setText(atrasnombre);
                
                ladoizquierdonombre = rs.getString("lado_izquierdo_nombre");
                lbladoizquierdonombre.setText(ladoizquierdonombre);
               
                ladoderechonombre = rs.getString("lado_derecho_nombre");
                lbladoderechonombre.setText(ladoderechonombre);
              
                
                
                
                
                identificador =rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                
                numeroordendeenviosolicitada=rs.getString("numero_orden");
                sucursal=rs.getString("tienda");
                
                lbsucursal.setText(sucursal);
             
                
                if(numerosucursalordenbordado ==null  || numerosucursalordenbordado.equals("") ||numerosucursalordenbordado.equals(" ") )
                {
                    tienenumerodesucursal ="no";
                }
                else
                {
                    tienenumerodesucursal ="si";
                }    
                
                
                
             
               
                if(frentenombre ==null||frentenombre.equals("") ||frentenombre.equals("ninguno"))
                {
                   
               
                    btnponchado1.setEnabled(false);
                    btncargarponchado1.setEnabled(false);
                    
                    
                }
                else
                {
                    
                     lbfrentenombre.setText(frentenombre);
                    lbfrentepuntadas.setText(rs.getString("frente_puntadas"));
                    botonhabilitado1 = "si";
                   btnponchado1.setEnabled(true);
                   btncargarponchado1.setEnabled(true);
                    
                }    
                
                
                
                
                    
                
                String atras =  rs.getString("atras_puntadas");
                if(atras ==null||atras.equals("") || atras.equals("ninguno"))
                {
                    btnponchado2.setEnabled(false);  
                    btncargarponchado2.setEnabled(false);
                }
                 else
                {
                    
                    
                    lbatrasnombre.setText(atrasnombre);
                    lbatraspuntadas.setText(rs.getString("atras_puntadas"));
                     botonhabilitado2 = "si";
                    
                      btnponchado2.setEnabled(true);
                      btncargarponchado2.setEnabled(true);
                } 
                
                
                
                
                
                
                
                
                
                String ladoizquierdo =  rs.getString("lado_izquierdo_puntadas");
               
                if(ladoizquierdo ==null||ladoizquierdo.equals("") || ladoizquierdo.equals("ninguno"))
                {
                  btnponchado3.setEnabled(false);  
                  btncargarponchado3.setEnabled(false);
                }
                else
                {
                     lbladoizquierdonombre.setText(ladoizquierdonombre);
                    lbladoizquierdopuntadas.setText(rs.getString("lado_izquierdo_puntadas"));
                     botonhabilitado3 = "si";
                     
                      btnponchado3.setEnabled(true);
                      btncargarponchado3.setEnabled(true);
                }    
                
                
                
                
                
                
               
                 String ladoderecho =  rs.getString("lado_derecho_puntadas");
                if(ladoderecho ==null || ladoderecho.equals("") || ladoderecho.equals("ninguno"))
                {
                   btnponchado4.setEnabled(false); 
                   btncargarponchado4.setEnabled(false);
                }
                 else
                {
                    
                     lbladoderechonombre.setText(ladoderechonombre);
                    lbladoderechopuntadas.setText(rs.getString("lado_derecho_puntadas"));
                     botonhabilitado4 = "si";
                      
                      btnponchado4.setEnabled(true);  
                      btncargarponchado4.setEnabled(true);
                }  
                
                
                
            
               
                aplicacionfrente = rs.getString("aplicacion_frente");

                if (aplicacionfrente.equals("ninguno")) {
                    aplicacionfrente = "";
                }

                
                String aplicacionfrentecolor = rs.getString("aplicacion_frente_color");

                if (aplicacionfrentecolor.equals("ninguno")) {
                    aplicacionfrentecolor = "";
                }

                
                
                lugar = rs.getString("lugar");
                
                
                
                
                
                //////////////////////////////////////////
                
                
                
                
                
                
                
                String cantidadfrente = rs.getString("frente_cantidad");
                String cantidadladoderecho = rs.getString("lado_derecho_cantidad");
                String cantidadladoizquierdo = rs.getString("lado_izquierdo_cantidad");
                String cantidadatras = rs.getString("atras_cantidad");
                
                
                
                
                
                
                
                if( botonhabilitado1.equals("si"))
                {
                     
                          
                   if(cantidadfrente.equals("0"))
                   {
                   listabotones.add("btnfrente");
                   
                   
                   btnfrentetermine.setEnabled(true);
                   btnfrentecancelar.setEnabled(false);
                   
                    lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
               
                   
                   }
                  else
                       
                   {
                      
                      btnfrentecancelar.setEnabled(true);
                        btnfrentetermine.setEnabled(false); 
                  
                   lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());   
                       
                   }
                   
                }
                else
                {
                    
                    
                  btnfrentetermine.setEnabled(false); 
                   
                   
                   
                }
                
                
                
                
                
                
                
                
                
                 if(  botonhabilitado2.equals("si") )
                {
                  
                   
                  
                   if(cantidadatras.equals("0"))
                   {
                    listabotones.add("btnatras");
                    
                       btnatrastermine.setEnabled(true);
                       
                       
                    btnponchado2.setEnabled(true); 
                     btnatrascancelar.setEnabled(false);
                    
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                    
                   }
                   
                   else
                       
                   {
                        btnatrascancelar.setEnabled(true);
                         btnatrastermine.setEnabled(false);
                         
                         
                 lbcantidad2.setText(cantidad);
                 lbcantidad2.setForeground(Color.GREEN.darker());
                       
                       
                   }
                   
                   
                }
                else
                {
                    
                    
                     btnatrastermine.setEnabled(false); 
                  
                    
                  
                } 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 /// lado izquierdo
                 
                 if( botonhabilitado3.equals("si"))
                {
                 
                   
           
               
                   if(cantidadladoizquierdo.equals("0"))
                   {
                   listabotones.add("btnladoizquierdo");
                   
                     btnladoizquierdotermine.setEnabled(true);
                      btnladoizquierdocancelar.setEnabled(false);
                     
                     
                   lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                   }
                   
                   else
                       
                   {
                         btnladoizquierdocancelar.setEnabled(true);
                         btnladoizquierdotermine.setEnabled(false);
                  lbcantidad3.setText(cantidad);
                 lbcantidad3.setForeground(Color.GREEN.darker());
                       
                       
                       
                   }
                }
                else
                {
                    
                     btnladoizquierdotermine.setEnabled(false);
                 
                     
                     
                     
                }
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                  if(  botonhabilitado4.equals("si"))
                {
                   
                   
                   if(cantidadladoderecho.equals("0"))
                   {
                    listabotones.add("btnladoderecho");
                    
                    
                     btnladoderechotermine.setEnabled(true);
                      btnladoderechocancelar.setEnabled(false);
                    
                    
                     lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                   }
                   
                   else
                   {
                      btnladoderechocancelar.setEnabled(true);
                       btnladoderechotermine.setEnabled(false);
                       
                  lbcantidad4.setText(cantidad);
                 lbcantidad4.setForeground(Color.GREEN.darker());  
                       
                       
                   }
                }
                else
                {
                    
                      btnladoderechotermine.setEnabled(false);
                    
                     
                     
                 
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
                
                
                
                
                
                

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        datosdepedidosyenvios();
        

    }

    
    
    void datosdepedidosyenvios() {
        /// busca las ordenes de camisa generadas 

        String numero = lbnumerodeventa.getText();
        String pedirarticulos = "";
        String ordenenvio = "";
        String sql2 = "Select solicito_articulos, enviada_ordenenvio from historial_ventas where numero = '" + numero + "' AND (solicito_articulos NOT IN ('0') or enviada_ordenenvio NOT IN ('no')) and estatus_pago not in ('cancelada') ";

        try {
            PreparedStatement prst = cn.prepareStatement(sql2);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) 
            {
                pedirarticulos = rs.getString("solicito_articulos");
                ordenenvio = rs.getString("enviada_ordenenvio");

            }
        } catch (Exception exx) {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">"+exx+"");
            

        }

        if (pedirarticulos.equals("si")) 
        {
            String sql3 = "Select numero,sucursal from historial_pedidos_sucursal_solicitados where numventa = '" + numero + "' ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
                    numerosolicitoarticulos = rs.getString("numero");
                    tiendasolicitoarticulos = rs.getString("sucursal");
                    lbsucursal.setText(tiendasolicitoarticulos);
                    lbnumeroordenopedidorecibido.setText(numerosolicitoarticulos);
                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">"+exx+"");

            }

        } else {
            if (ordenenvio.equals("si")) {

                String sql3 = "Select numero,sucursal from historial_ordenes_envio_solicitadas where numero_venta = '" + numero + "'  AND articulo LIKE '%BORDADO GORRA%' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    while (rs.next()) {
                        numeroordenenvio = rs.getString("numero");
                        tiendaordenenvio = rs.getString("sucursal");
                        lbsucursal.setText(tiendaordenenvio);
                        lbnumeroordenopedidorecibido.setText(numeroordenenvio);
                    }
                } catch (Exception exx) {
                    
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">"+exx+"");

                }

            }
        }

    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void determinaciondeladescripciondelbordado(){
        
        
        descripcion = "BORDADO GORRA " + ubicacionprenda + " " + nombrebordado + "";
        
          descripcionaplicacion = "APLICACION GORRA FRENTE";
            
         
           
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void cargarfotomontaje() throws FileNotFoundException, IOException  
    {
        
       
       
        BufferedImage img = null;
         btnverfotomontaje.setEnabled(false);
     

       String sql = "Select extension_imagen,imagen,numero_consecutivo,puntadas_en_fotomontajes from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'GORRA'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
              
                consecutivo = rs.getString("numero_consecutivo");
                 
                Imagen imagen = new Imagen();
                Blob blob = rs.getBlob("imagen");
                if (blob == null) 
                {

                    
                    ordencamisaimagencontorno p = new ordencamisaimagencontorno();
                    jPanel1.add(p);
                    jPanel1.repaint();
                    lbfotomontaje.setVisible(false);
                    btnverfotomontaje.setEnabled(false);
                    tienefotomontaje = "no";
                   // btncargarfotomontaje.setEnabled(true);
                    
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
                    
                } 
                
                else 
                
                {
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    }
                    catch (IOException ex) 
                    {
                       
                      JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");

                    }

                    imagen.setImagen(img);
                    lbfotomontaje.setIcon(new ImageIcon(img.getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT)));
                    lbfotomontaje.setVisible(true);
                    btnverfotomontaje.setEnabled(true);
                    tienefotomontaje = "si";
                    btnverfotomontaje.setEnabled(true);
                    //btncargarfotomontaje.setEnabled(false);

                    Blob archivo = rs.getBlob("imagen");
                    String nombredelarchivo = rs.getString("extension_imagen");
                    if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                     rutaimagen = "C:\\archivospdf\\Fotomontajegorra."+nombredelarchivo+" ";
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
        } 
        catch (SQLException ex) 
        {
           
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
        }
        
        
        
        if(tienefotomontaje.equals("no"))
        {
        
          
            
            btnladoderechotermine.setEnabled(false);
            btnladoizquierdotermine.setEnabled(false);
            btnatrastermine.setEnabled(false);
            btnfrentetermine.setEnabled(false);
            
             JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
             btnfotomontajesinpuntadas.setEnabled(false);
             btnterminetodo.setEnabled(false);
            
     }  

        
        
    }
    
    
     void datosotrasucursal() throws IOException 
     {

        btnreplicartodoslosponchados.setEnabled(true);
        btnterminetodo.setEnabled(true);

        numeroordendebordadolocalorecibida = lborden.getText();
        prenda = "Gorra";

        String sql = "Select orden_o_pedido,fecha,hora,cliente,nombre_comercial,borda_cliente,numero_orden_o_pedido_recibida,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,numero_orden_o_pedido_solicitada,\n" +
                     "frente_puntadas,frente_nombre,frente_cantidad,frente_fecha,atras_puntadas,atras_nombre,atras_cantidad,atras_fecha,aplicacion_frente,aplicacion_frente_color,lado_izquierdo_puntadas,lado_izquierdo_nombre,lado_izquierdo_cantidad,lado_izquierdo_fecha,lado_derecho_puntadas,lado_derecho_nombre,lado_derecho_cantidad,lado_derecho_fecha,lugar,tienda,numero_orden_gorra_solicitada,identificador_prenda,estatus_orden from historial_ordenes_gorra_recibidas where numero = '" + numeroordendebordadolocalorecibida + "' and prenda = '" + prenda + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                
                tiendeordenopedido = rs.getString("orden_o_pedido");
                lbordenopedidorecibido.setText(tiendeordenopedido);
                
                cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
                numeroordenopedidorecibido = rs.getString("numero_orden_o_pedido_recibida");
                lbnumeroordenopedidorecibido.setText(numeroordenopedidorecibido);
                
                
                lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                lbbordacliente.setText(rs.getString("borda_cliente"));
                
                cantidad = rs.getString("cantidad");
                lbcantidad.setText(rs.getString("cantidad"));
                
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));
                lbnumeroordenopedidosolicitado.setText(rs.getString("numero_orden_o_pedido_solicitada"));
                
                ladoizquierdonombre = rs.getString("lado_izquierdo_nombre");
                ladoderechonombre = rs.getString("lado_derecho_nombre");
                frentenombre = rs.getString("frente_nombre");
                atrasnombre = rs.getString("atras_nombre");
                sucursal= rs.getString("tienda");
                numerosucursal= rs.getString("numero_orden_gorra_solicitada");
                
               


                  if(frentenombre ==null||frentenombre.equals("") ||frentenombre.equals("ninguno"))
                {
                   
               
                    btnponchado1.setEnabled(false);
                    btncargarponchado1.setEnabled(false);
                    
                    
                }
                else
                {
                    
                     lbfrentenombre.setText(frentenombre);
                    lbfrentepuntadas.setText(rs.getString("frente_puntadas"));
                    botonhabilitado1 = "si";
                   btnponchado1.setEnabled(true);
                   btncargarponchado1.setEnabled(true);
                    
                }    
                
                
                
                
                    
                
                String atras =  rs.getString("atras_puntadas");
                if(atras ==null||atras.equals("") || atras.equals("ninguno"))
                {
                    btnponchado2.setEnabled(false);  
                    btncargarponchado2.setEnabled(false);
                }
                 else
                {
                    
                    
                    lbatrasnombre.setText(atrasnombre);
                    lbatraspuntadas.setText(rs.getString("atras_puntadas"));
                     botonhabilitado2 = "si";
                    
                      btnponchado2.setEnabled(true);
                      btncargarponchado2.setEnabled(true);
                } 
                
                
                
                
                
                
                
                
                
                String ladoizquierdo =  rs.getString("lado_izquierdo_puntadas");
               
                if(ladoizquierdo ==null||ladoizquierdo.equals("") || ladoizquierdo.equals("ninguno"))
                {
                  btnponchado3.setEnabled(false);  
                  btncargarponchado3.setEnabled(false);
                }
                else
                {
                     lbladoizquierdonombre.setText(ladoizquierdonombre);
                    lbladoizquierdopuntadas.setText(rs.getString("lado_izquierdo_puntadas"));
                     botonhabilitado3 = "si";
                     
                      btnponchado3.setEnabled(true);
                      btncargarponchado3.setEnabled(true);
                }    
                
                
                
                
                
                
               
                 String ladoderecho =  rs.getString("lado_derecho_puntadas");
                if(ladoderecho ==null || ladoderecho.equals("") || ladoderecho.equals("ninguno"))
                {
                   btnponchado4.setEnabled(false); 
                   btncargarponchado4.setEnabled(false);
                }
                 else
                {
                    
                     lbladoderechonombre.setText(ladoderechonombre);
                    lbladoderechopuntadas.setText(rs.getString("lado_derecho_puntadas"));
                     botonhabilitado4 = "si";
                      
                      btnponchado4.setEnabled(true);  
                      btncargarponchado4.setEnabled(true);
                }  
                
                
                
            
               
                aplicacionfrente = rs.getString("aplicacion_frente");

                if (aplicacionfrente.equals("ninguno")) {
                    aplicacionfrente = "";
                }

                
                String aplicacionfrentecolor = rs.getString("aplicacion_frente_color");

                if (aplicacionfrentecolor.equals("ninguno")) {
                    aplicacionfrentecolor = "";
                }

                
                
                lugar = rs.getString("lugar");
                
              
                
                
                
                 String cantidadfrente = rs.getString("frente_cantidad");
                String cantidadladoderecho = rs.getString("lado_derecho_cantidad");
                String cantidadladoizquierdo = rs.getString("lado_izquierdo_cantidad");
                String cantidadatras = rs.getString("atras_cantidad");
                
                
                
                if( botonhabilitado1.equals("si"))
                {
                     
                          
                   if(cantidadfrente.equals("0"))
                   {
                   listabotones.add("btnfrente");
                   
                   
                   btnfrentetermine.setEnabled(true);
                   btnfrentecancelar.setEnabled(false);
                   
                    lbcantidad1.setText("0");
                    lbcantidad1.setForeground(Color.red.darker());
               
                   
                   }
                  else
                       
                   {
                      
                      btnfrentecancelar.setEnabled(true);
                        btnfrentetermine.setEnabled(false); 
                  
                   lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());   
                       
                   }
                   
                }
                else
                {
                    
                    
                  btnfrentetermine.setEnabled(false); 
                   
                   
                   
                }
                
                
                
                
                
                
                
                
                
                 if(  botonhabilitado3.equals("si") )
                {
                  
                   
                  
                   if(cantidadladoderecho.equals("0"))
                   {
                    listabotones.add("btnladoderecho");
                    
                       btnatrastermine.setEnabled(true);
                       
                       
                    btnponchado2.setEnabled(true); 
                     btnladoderechocancelar.setEnabled(false);
                    
                     lbcantidad2.setText("0");
                    lbcantidad2.setForeground(Color.red.darker());
                    
                    
                   }
                   
                   else
                       
                   {
                        btnladoderechocancelar.setEnabled(true);
                         btnatrastermine.setEnabled(false);
                         
                         
                 lbcantidad2.setText(cantidad);
                 lbcantidad2.setForeground(Color.GREEN.darker());
                       
                       
                   }
                   
                   
                }
                else
                {
                    
                    
                     btnatrastermine.setEnabled(false); 
                  
                    
                  
                } 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 
                 /// lado izquierdo
                 
                 if( botonhabilitado2.equals("si"))
                {
                 
                   
           
               
                   if(cantidadladoizquierdo.equals("0"))
                   {
                   listabotones.add("btnladoizquierdo");
                   
                     btnladoizquierdotermine.setEnabled(true);
                      btnladoizquierdocancelar.setEnabled(false);
                     
                     
                   lbcantidad3.setText("0");
                    lbcantidad3.setForeground(Color.red.darker());
                   }
                   
                   else
                       
                   {
                         btnladoizquierdocancelar.setEnabled(true);
                         btnladoizquierdotermine.setEnabled(false);
                  lbcantidad3.setText(cantidad);
                 lbcantidad3.setForeground(Color.GREEN.darker());
                       
                       
                       
                   }
                }
                else
                {
                    
                     btnladoizquierdotermine.setEnabled(false);
                 
                     
                     
                     
                }
                 
                 
                 
                 
                  if(  botonhabilitado4.equals("si"))
                {
                   
              
                   
                   
        
                 
              
                   
                   if(cantidadatras.equals("0"))
                   {
                    listabotones.add("btnatras");
                    
                    
                     btnladoderechotermine.setEnabled(true);
                      btnatrascancelar.setEnabled(false);
                    
                    
                     lbcantidad4.setText("0");
                    lbcantidad4.setForeground(Color.red.darker());
                   }
                   
                   else
                   {
                      btnatrascancelar.setEnabled(true);
                       btnladoderechotermine.setEnabled(false);
                       
                  lbcantidad4.setText(cantidad);
                 lbcantidad4.setForeground(Color.GREEN.darker());  
                       
                       
                   }
                }
                else
                {
                    
                      btnladoderechotermine.setEnabled(false);
                    
                     
                     
                 
                } 
                
                  
                  
                
             
                
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
                
                
                

            }

        } catch (SQLException ex) {
            System.out.println(ex);
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
        
        
        
        
        esordendeenvioopedidoyobtenernumeros();
        
        
        
        
        
        
        btnreplicartodoslosponchados.setEnabled(false);
     
        lbcoloratras.setEnabled(false);
        lbcolorladoizquierdo.setEnabled(false);
        lbcolorladoderecho.setEnabled(false);
        lbcolorfrente.setEnabled(false);

 }
     
     
     
     
     
     
     
     
     
     
     
     
     
    
    
        
        
    void hilosycolor()
    {
       

        String sql = "Select hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,color1,color2,color3,color4,color5,color6,color7,numero_consecutivo from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'GORRA'   ";

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
                
               
                
             
                
                    
                
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
    }
    
    
    
    
    
    
    
     void insertarlacantidadylafechaenlaubicacionhistorialRECIBIDO()
    {
        
      
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set "+ubicacioncantidad+"='" + cantidad + "',"+ubicacionfecha+"='"+dia()+"' where numero = '"+numeroordendebordadosolicitadoorecibidasisehabredesderecibidas+"'");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacioncantidad;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
        try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordengorraS.class.getName()).log(Level.SEVERE, null, ex);
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
 
    
    
    
    void  insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDA()
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE  "+nombredelatabla+" set "+ubicacioncantidad+" = '"+cantidad+"',  "+ubicacionfecha+"  =  '"+dia()+"' where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacioncantidad;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    void insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDAcancelar()
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE  "+nombredelatabla+" set "+ubicacioncantidad+"='0', "+ubicacionfecha+" = null where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacioncantidad;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
      JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
    
    
    
    
    void esordendeenvioopedidoyobtenernumeros() 
    {
        /// busca las ordenes de camisa generadas 

        
        String numero = lbnumerodeventa.getText();
        String pedi = "";
        
        
        
        
        
        
        String sql2 = "Select orden_o_pedido,numero_orden_o_pedido_recibida from historial_ordenes_gorra_recibidas where numero = '" + numero + "'  ";

        try {
            PreparedStatement prst = cn.prepareStatement(sql2);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                esenvioopedido = rs.getString("orden_o_pedido");
                numeroordenopedidorecibido = rs.getString("numero_orden_o_pedido_recibida");

            }
            
          
            
            
        } catch (Exception exx) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

        }


    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega()
    {
    





          
        
         
         String surtidaactualstring ="";
        int surtidaactualint =  0;
        String surtidanuevastring = "";
        String estatusentrega ="";
        int surtidanuevaint = 0;
        int cantidadint = 0;
        
        
       
                 if (esenvioopedido.equals("ordendeenvio")) 
        {
            
            
            
            String sql3 = "Select surtidas from historial_ordenes_envio_recibidas where numero = '" + numeroordenopedidorecibido + "'";

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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET surtidas = '" + surtidanuevastring + "' WHERE numero='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacioncantidad + "'      ");
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
          estatusentrega ="surtida totalmente no entregada";  
        }
        else  if(sumavendidaint == (sumasurtidaint + sumaenviadaint )  &&  sumaenviadaint <  sumavendidaint  )
        {
          estatusentrega ="surtida totalmente entregada parcialmente";  
        }
        
        else
        {
          estatusentrega ="surtida parcialmente no entregada";   
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
           if (esenvioopedido.equals("pedido")) 
            {

                
                
              
            String sql3 = "Select surtidas from historial_pedidos_sucursal_recibidos where numero = '" + numeroordenopedidorecibido + "'";

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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET surtidas = '" + surtidanuevastring + "' WHERE numero='" + numeroordenopedidorecibido + "' and articulo = '" + ubicacioncantidad + "'      ");
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
       
      
      
      
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(enviadas) as enviadas from historial_pedidos_sucursal_recibidos where numero = '"+numeroordenopedidorecibido+"'  ";
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
          estatusentrega ="surtida totalmente no entregada";  
        }
        else  if(sumavendidaint == (sumasurtidaint + sumaenviadaint )  &&  sumaenviadaint <  sumavendidaint  )
        {
          estatusentrega ="surtida totalmente entregada parcialmente";  
        }
        
        else
        {
          estatusentrega ="surtida parcialmente no entregada";   
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
    
    
    
    
    
    
    
    
    
    
    void agregaralsurtidasalhistorialdeventasyactualizarestatusentrega() 
      {

          numerodeventa =  lbnumerodeventa.getText();
        String surtidaactualstring ="";
        int surtidaactualint =  0;
        String nuevasurtidastring = "";
        String estatusentrega ="";
       
        
        String SQL2 = "select articulo,surtida from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + ubicacioncantidad + "'  and identificador_prenda = '"+identificador+"' ";
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
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacioncantidad+"" + lineas[0] + "</span><br>";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + nuevasurtidastring + "' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacioncantidad + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception ex) {
                            System.out.println (ex);
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
     
     
     
     
     
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
     void agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar() 
      {

         numerodeventa =  lbnumerodeventa.getText();
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
       
        
        String SQL2 = "select cantidad from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + ubicacioncantidad + "'  and identificador_prenda = '"+identificador+"'";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '"+nuevacantidadstring+"' WHERE numero='" + numerodeventa + "' and articulo = '" + descripcion + "'  and identificador_prenda = '"+identificador+"'    ");
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
            if (rs.next()) {
                
               codigocliente = rs.getString("codigo_cliente");
                
            }


        } catch (SQLException ex) {
            System.out.println (ex);
        }
    }
     
    void actualizarestatusentregaordendebordado()
    {
        
     
        int tienecantidad = 0;
        int botonesactivados = 0;
        
         String sql = "Select lado_izquierdo_puntadas,lado_izquierdo_cantidad,lado_derecho_puntadas,lado_derecho_cantidad,frente_puntadas,frente_cantidad,atras_puntadas,atras_cantidad from "+nombredelatabla+" where numero = '"+numeroordendebordadolocalorecibida+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

              
                
                String cantidadfrente = rs.getString("frente_cantidad");
                String frente = rs.getString("frente_puntadas");
                
                
                 String cantidadatras = rs.getString("atras_cantidad");
                String atras = rs.getString("atras_puntadas");
                
                
                String cantidadladoizquierdo = rs.getString("lado_izquierdo_cantidad");
                String ladoizquierdo = rs.getString("lado_izquierdo_puntadas");
                
                String cantidadladoderecho = rs.getString("lado_derecho_cantidad");
                String ladoderecho = rs.getString("lado_derecho_puntadas");
                
               
                
               
                
                
                
                
                if(frente==null || frente.equals("")||frente.equals(" ")  || frente.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                
                
                
                
                
                
                if(atras==null || atras.equals("")||atras.equals(" ") ||atras.equals("ninguno"))
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                 
                
                
                
                
                if(ladoizquierdo==null || ladoizquierdo.equals("")||ladoizquierdo.equals(" ")  || ladoizquierdo.equals("ninguno"))
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                } 
                
                
                
                
                
                
                if(ladoderecho==null || ladoderecho.equals("")||ladoderecho.equals(" ")  || ladoderecho.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
               
               
           
           
                ////////////////////////////////////////////////////////////////
                
                
                
                
                  if(cantidadfrente.equals("0"))
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
                
                
                  
                    if(cantidadatras.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
              
                    
                    
                
                 if(cantidadladoizquierdo.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                } 
                
                
                if(cantidadladoderecho.equals("0") )
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

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set estatus_orden='"+nuevoestatusorden+"' where numero='" + numeroordendebordadolocalorecibida + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
                }
               
           
           
           
        }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        lbestatus.setText(nuevoestatusorden);
        
        
        
        
        
    }
    
    
     void sumapuntos()
    {
   
        
        
        
         String sql = "Select cantidad,lado_izquierdo_cantidad,lado_izquierdo_puntadas,"
                  + "lado_derecho_cantidad,lado_derecho_puntadas,"
                  + "frente_cantidad,frente_puntadas,"
                  + "atras_cantidad,atras_puntadas,"
                  + "aplicacion_frente from "+nombredelatabla+" where numero = '"+numeroordendebordadolocalorecibida+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String cantidad = rs.getString("cantidad");   
                String cantidadladoizquierdo = rs.getString("lado_izquierdo_cantidad");
                String ladoizquierdo = rs.getString("lado_izquierdo_puntadas");
                String cantidadladoderecho = rs.getString("lado_derecho_cantidad");
                String ladoderecho = rs.getString("lado_derecho_puntadas");
                String cantidadatras = rs.getString("atras_cantidad");
                String atras = rs.getString("atras_puntadas");
                String cantidadfrente = rs.getString("frente_cantidad");
                String frente = rs.getString("frente_puntadas");
                String aplicacionfrente= rs.getString("aplicacion_frente");

                
            int cantidadladoizquierdoint = Integer.parseInt(cantidadladoizquierdo);
            int cantidadladoderechoint = Integer.parseInt(cantidadladoderecho);
            int cantidadatrasint = Integer.parseInt(cantidadatras);
            int cantidadfrenteint = Integer.parseInt(cantidadfrente);
            
 
            String costostring = "0.00";
            double importeladoizquierdo = 0.00;
            double importeladoderecho = 0.00;
            double importeatras = 0.00;
            double importefrente= 0.00;
            
            double costopuntadaladoizquierdo = 0.0;
            double costopuntadaladoderecho = 0.0;
            double costopuntadaatras = 0.0;
            double costopuntadafrente = 0.0;
            
            
            double costopuntadasaplicacioneschicas = 0.00;
            double costopuntadasaplicacionesgrandes = 0.00;
            double totalpuntosaplicacioneschicas = 0.00;
            double totalpuntosaplicacionesgrandes = 0.00;
            

            //PECHO IZQUIERDO
            
            String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" +ladoizquierdo+ "'";

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

            String costopuntadapechoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdo);
            importeladoizquierdo = cantidadladoizquierdoint * costopuntadaladoizquierdo;

            //PECHO DERECHO
            
            String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderecho + "'";

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

            String costopuntadapechoderechostring = String.format("%.02f ", costopuntadaladoderecho);
            importeladoderecho = cantidadladoderechoint * costopuntadaladoderecho;

//MANGA IZQUIERDA
            
 
            String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + atras+ "'";

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

            String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadaatras);
            importeatras = cantidadatrasint * costopuntadaatras;

//MANGA DERECHA
            
            String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '"+frente+"'";

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

            String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
            importefrente = cantidadfrenteint * costopuntadafrente;

            // ESPALDA
           
           
           
            
//// aplicaciones
            
             

            if (aplicacionfrente == null || aplicacionfrente.equals("") || aplicacionfrente.equals(" ")) {
                aplicacionfrente = "0";
            }
            int aplicacionfrenteint = Integer.parseInt(aplicacionfrente.toString());


            



            int sumadelasaplicaciones = aplicacionfrenteint  ;

            String sqlaplicacionchica = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION CHICA' ";

            try {
                PreparedStatement prst = cn.prepareStatement(sqlaplicacionchica);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadasaplicacioneschicas = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+exx+"");

            }

            totalpuntosaplicacioneschicas = costopuntadasaplicacioneschicas * (sumadelasaplicaciones * Integer.parseInt(cantidad));

            double sumabordados = importeladoizquierdo + importeladoderecho + importeatras + importefrente + totalpuntosaplicacioneschicas ;
            String sumabordadosstring = String.format("%.02f ", sumabordados);
            lbsumapuntos.setText(sumabordadosstring);

        }



            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    void verfotomontajetiendalocal()
    {
      
        String rutadelarchivo = "";
        String existe = "";
     
        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'GORRA'   ";

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
        String sql = "Select extension_imagen,imagen from bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'GORRA'   ";

        try {
            Statement st1 = cnsucursal.createStatement();
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
    
    
    
    
    
    
    
    
    
    
             
    
     
     void descargarponchado(String ubicacionponchado,String ubicacionnombre)
     {
         JFileChooser fs = new JFileChooser();
        

         try (
                 PreparedStatement ps = cn.prepareStatement("select " + ubicacionponchado + "," + ubicacionnombre + " from historial_ordenes_gorra_recibidas where numero = '" + numeroordendebordadolocalorecibida + "' ")) {
             ResultSet rs = ps.executeQuery();

             if (rs.next()) {

                 fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                 String nombre1 = rs.getString("" + ubicacionnombre + "");
                 fs.setSelectedFile(new File(nombre1));
                 int tampak = fs.showSaveDialog(null);

                 if (tampak == JFileChooser.APPROVE_OPTION) 
                 {
                     File file = fs.getSelectedFile();
                     try (InputStream stream = rs.getBinaryStream("" + ubicacionponchado + "");
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

        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lborden = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        btnreplicartodoslosponchados = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbfechaentrega = new javax.swing.JLabel();
        lbhoraentrega = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbfotomontaje = new javax.swing.JLabel();
        lbnumerodeventa = new javax.swing.JLabel();
        lbsucursal = new javax.swing.JLabel();
        lbnumeroordenopedidorecibido = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnverfotomontaje = new javax.swing.JButton();
        btnladoderechotermine = new javax.swing.JButton();
        btnladoizquierdotermine = new javax.swing.JButton();
        btnfrentetermine = new javax.swing.JButton();
        btnatrastermine = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        lbcoloratras = new javax.swing.JLabel();
        lbcolorfrente = new javax.swing.JLabel();
        lbcolorladoizquierdo = new javax.swing.JLabel();
        lbcolorladoderecho = new javax.swing.JLabel();
        btnterminetodo = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbbordacliente = new javax.swing.JLabel();
        lbcodigoladoderecho = new javax.swing.JLabel();
        lbcodigoladoizquierdo = new javax.swing.JLabel();
        lbcodigofrente = new javax.swing.JLabel();
        lbcodigoatras = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
        btneditarbordado = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        lbatrasnombre1 = new javax.swing.JLabel();
        lbladoizquierdonombre1 = new javax.swing.JLabel();
        lbladoderechonombre1 = new javax.swing.JLabel();
        lbatraspuntadas = new javax.swing.JLabel();
        lbladoderechopuntadas = new javax.swing.JLabel();
        lbladoizquierdopuntadas = new javax.swing.JLabel();
        lbfrentepuntadas = new javax.swing.JLabel();
        btnvercolorido = new javax.swing.JButton();
        btnfotomontajesinpuntadas = new javax.swing.JButton();
        btndatos = new javax.swing.JButton();
        lbprenda = new javax.swing.JLabel();
        lbfrentenombre1 = new javax.swing.JLabel();
        btnladoderechocancelar = new javax.swing.JButton();
        btnladoizquierdocancelar = new javax.swing.JButton();
        btnfrentecancelar = new javax.swing.JButton();
        btnatrascancelar = new javax.swing.JButton();
        btnponchado2 = new javax.swing.JButton();
        btnponchado3 = new javax.swing.JButton();
        btnponchado1 = new javax.swing.JButton();
        btnponchado4 = new javax.swing.JButton();
        lbnombrecomercial = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        lbprenda1 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbfrentenombre = new javax.swing.JLabel();
        lbladoizquierdonombre = new javax.swing.JLabel();
        lbladoderechonombre = new javax.swing.JLabel();
        lbatrasnombre = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbestatus = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbautorizacion = new javax.swing.JLabel();
        lbnumeroordenopedidosolicitado = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbordenopedidorecibido = new javax.swing.JLabel();
        btnreplicar1 = new javax.swing.JButton();
        btnreplicar2 = new javax.swing.JButton();
        btnreplicar3 = new javax.swing.JButton();
        btnreplicar4 = new javax.swing.JButton();
        btncargarponchado4 = new javax.swing.JButton();
        btncargarponchado3 = new javax.swing.JButton();
        btncargarponchado1 = new javax.swing.JButton();
        btncargarponchado2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbsumapuntos1 = new javax.swing.JLabel();
        lbsumapuntos2 = new javax.swing.JLabel();
        lbsumapuntos3 = new javax.swing.JLabel();
        lbsumapuntos4 = new javax.swing.JLabel();
        btnquitarponchado4 = new javax.swing.JButton();
        btnquitarponchado3 = new javax.swing.JButton();
        btnquitarponchado2 = new javax.swing.JButton();
        btnquitarponchado1 = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden gorra");
        setResizable(false);
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Fecha Entrega");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Número de orden");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lborden.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lborden.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setText("Cantidad");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Cliente:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnreplicartodoslosponchados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreplicartodoslosponchados.setText("Replicar ponchados");
        btnreplicartodoslosponchados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicartodoslosponchadosActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Hora Entrega");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfechaentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfechaentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhoraentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad.setText("0");
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);
        jPanel1.add(lbfotomontaje);
        lbfotomontaje.setBounds(10, 0, 1010, 620);

        lbnumerodeventa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnumerodeventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsucursal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroordenopedidorecibido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnumeroordenopedidorecibido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Orden o pedido solicitado");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        btnladoderechotermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnladoderechotermine.setText("Termine");
        btnladoderechotermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoderechotermineMouseReleased(evt);
            }
        });
        btnladoderechotermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechotermineActionPerformed(evt);
            }
        });

        btnladoizquierdotermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnladoizquierdotermine.setText("Termine");
        btnladoizquierdotermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoizquierdotermineMouseReleased(evt);
            }
        });
        btnladoizquierdotermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdotermineActionPerformed(evt);
            }
        });

        btnfrentetermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnfrentetermine.setText("Termine");
        btnfrentetermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnfrentetermineMouseReleased(evt);
            }
        });
        btnfrentetermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrentetermineActionPerformed(evt);
            }
        });

        btnatrastermine.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnatrastermine.setText("Termine");
        btnatrastermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnatrastermineMouseReleased(evt);
            }
        });
        btnatrastermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrastermineActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Total de puntos");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsumapuntos.setText("0.00");
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcoloratras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcoloratras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorfrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorfrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorladoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorladoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorladoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorladoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnterminetodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnterminetodo.setText("Termine todo");
        btnterminetodo.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                btnterminetodoAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        btnterminetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterminetodoActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Nombre comercial");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Bordacliente");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigofrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigofrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoatras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbidentificador.setForeground(new java.awt.Color(0, 0, 153));
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btneditarbordado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneditarbordado.setText("Editar bordado");
        btneditarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarbordadoActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Sucursal:");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("No. de venta");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Observacion");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        lbatrasnombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbatrasnombre1.setText("Atras");
        lbatrasnombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdonombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdonombre1.setText("Lado izquierdo");
        lbladoizquierdonombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderechonombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechonombre1.setText("Lado derecho");
        lbladoderechonombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbatraspuntadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbatraspuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderechopuntadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoderechopuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdopuntadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoizquierdopuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfrentepuntadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbfrentepuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbfrentepuntadas.setOpaque(true);

        btnvercolorido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnvercolorido.setText("Ver colorido");
        btnvercolorido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvercoloridoActionPerformed(evt);
            }
        });

        btnfotomontajesinpuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnfotomontajesinpuntadas.setText("Fotomontaje sin puntadas");
        btnfotomontajesinpuntadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfotomontajesinpuntadasActionPerformed(evt);
            }
        });

        btndatos.setText("datos");
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
            }
        });

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda.setText("Gorra");
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfrentenombre1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfrentenombre1.setText("Frente");
        lbfrentenombre1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnladoderechocancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnladoderechocancelar.setText("Cancelar");
        btnladoderechocancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoderechocancelarMouseReleased(evt);
            }
        });
        btnladoderechocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechocancelarActionPerformed(evt);
            }
        });

        btnladoizquierdocancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnladoizquierdocancelar.setText("Cancelar");
        btnladoizquierdocancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnladoizquierdocancelarMouseReleased(evt);
            }
        });
        btnladoizquierdocancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdocancelarActionPerformed(evt);
            }
        });

        btnfrentecancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnfrentecancelar.setText("Cancelar");
        btnfrentecancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnfrentecancelarMouseReleased(evt);
            }
        });
        btnfrentecancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrentecancelarActionPerformed(evt);
            }
        });

        btnatrascancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnatrascancelar.setText("Cancelar");
        btnatrascancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btnatrascancelarMouseReleased(evt);
            }
        });
        btnatrascancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrascancelarActionPerformed(evt);
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

        btnponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnponchado1.setText("Ponchado");
        btnponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado1ActionPerformed(evt);
            }
        });

        btnponchado4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnponchado4.setText("Ponchado");
        btnponchado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnponchado4ActionPerformed(evt);
            }
        });

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Fecha de elaboración");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda1.setText("Identificador");
        lbprenda1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Prenda");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfrentenombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbfrentenombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbfrentenombre.setOpaque(true);

        lbladoizquierdonombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoizquierdonombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderechonombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbladoderechonombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbatrasnombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbatrasnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel26.setText("Estatus");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbestatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbestatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbautorizacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbautorizacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroordenopedidosolicitado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumeroordenopedidosolicitado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Numero");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Tiene orden o pedido recibido?");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbordenopedidorecibido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbordenopedidorecibido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Puntos");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Puntos");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Puntos");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Puntos");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnquitarponchado4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado4.setText("-");
        btnquitarponchado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado4ActionPerformed(evt);
            }
        });

        btnquitarponchado3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado3.setText("-");
        btnquitarponchado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado3ActionPerformed(evt);
            }
        });

        btnquitarponchado2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado2.setText("-");
        btnquitarponchado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado2ActionPerformed(evt);
            }
        });

        btnquitarponchado1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnquitarponchado1.setText("-");
        btnquitarponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnquitarponchado1ActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Orden o pedido recibido");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1022, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(127, 127, 127)
                                .addComponent(jLabel21)
                                .addGap(12, 12, 12)
                                .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(339, 339, 339)
                                        .addComponent(btnfotomontajesinpuntadas))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(303, 303, 303)
                                        .addComponent(jLabel15)
                                        .addGap(7, 7, 7)
                                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbprenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel14)
                                        .addGap(3, 3, 3)
                                        .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel26)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbnumeroordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 18, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbladoderechonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbladoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbladoderechopuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addComponent(btnladoderechotermine, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnladoderechocancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbcodigoladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbcolorladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbatrasnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbatrasnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnatrastermine, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(lbcodigoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbcoloratras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbladoizquierdonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbladoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbladoizquierdopuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(238, 238, 238)
                                .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addComponent(btnladoizquierdotermine, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnladoizquierdocancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbcodigoladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbcolorladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbfrentenombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbfrentenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbfrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(btnfrentetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btnfrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(lbcodigofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbcolorfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnterminetodo)
                        .addGap(340, 340, 340)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnreplicartodoslosponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btncargarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btncargarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncargarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncargarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnquitarponchado1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnquitarponchado2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnquitarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnquitarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnreplicar1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnreplicar2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnreplicar3, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnreplicar4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(btnponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
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
                                .addComponent(lbsumapuntos4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnfotomontajesinpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumeroordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lbprenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbfrentenombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbfrentenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnfrentetermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnfrentecancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcodigofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcolorfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbfrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(7, 7, 7)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbatrasnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbatrasnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbatraspuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(btnatrastermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnatrascancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lbcodigoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcoloratras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(5, 5, 5)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbladoizquierdonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbladoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbladoizquierdopuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnladoizquierdotermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnladoizquierdocancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcodigoladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcolorladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbladoderechonombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbladoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(5, 5, 5)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbladoderechopuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbcodigoladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbcolorladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnladoderechotermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnladoderechocancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncargarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnreplicar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                    .addGap(9, 9, 9)
                                    .addComponent(btnponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(btnponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(btnponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnreplicar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btncargarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnreplicar3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btncargarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(10, 10, 10)
                                            .addComponent(btnreplicar4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btncargarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnquitarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnquitarponchado2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(btnquitarponchado4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnquitarponchado3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnreplicartodoslosponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(43, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ordengorraimagen p = new ordengorraimagen();
        jPanel1.add(p);
        jPanel1.repaint();
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

        ventanaordengorra = false;
        this.dispose();
        
        if(ordenesporrealizar.ventanaordenesporrealizar==true)
        {
            ordenesporrealizar.btndatos.doClick();
        }

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordengorra = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

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

    private void btnatrastermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrastermineActionPerformed
      
       
                ubicacioncantidad = "lado_derecho_cantidad";
                ubicacionfecha = "lado_derecho_fecha";
                nombrebordado =ladoderechonombre;
             //   cantidadaplicacion = aplicacionladoderecho
                ubicacionprenda = "LADO DERECHO";
              
                
                
                
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
       
      
        agregaralsurtidasalhistorialdeventasyactualizarestatusentrega();       
            
        }
        
        
        else 
            
                
        // OTRA SUCURSAL           
            
            if(lugar.equals("Otra sucursal") )
        {
      
         agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega();   
          

        }
                      
                        
                        
            
        insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDA();
        
        
        actualizarestatusentregaordendebordado(); 
    
      
        
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
                     
                    }
        
        
        
        
    }//GEN-LAST:event_btnatrastermineActionPerformed

    private void btnreplicartodoslosponchadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicartodoslosponchadosActionPerformed

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

    private void btnfrentetermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrentetermineActionPerformed

        
        
                 ubicacioncantidad = "frente_cantidad";
                ubicacionfecha = "frente_fecha";
                nombrebordado =frentenombre;
                cantidadaplicacion = aplicacionfrente;
                
                ubicacionprenda = "FRENTE";
              
                
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
                    
                    
                    
                    
                
                    
                    
                    
                    
                    
                    
                    
        
        
        
    }//GEN-LAST:event_btnfrentetermineActionPerformed

    private void btnladoizquierdotermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdotermineActionPerformed

       
        
                ubicacioncantidad = "lado_izquierdo_cantidad";
                ubicacionfecha = "lado_izquierdo_fecha";
                nombrebordado =ladoizquierdonombre;
           //     cantidadaplicacion = aplicacionladoizquierdo;
                
                ubicacionprenda = "LADO IZQUIERDO";
              
                
                
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
            
            if(lugar.equals("Otra sucursal") )
        {
          
         agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega();   
          

        }
                      
                        
        insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDA(); 
        
        actualizarestatusentregaordendebordado(); 
    
        
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
                     
                    }
        
        
        
        
    }//GEN-LAST:event_btnladoizquierdotermineActionPerformed

    private void btnladoderechotermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechotermineActionPerformed

             ubicacioncantidad = "atras_cantidad";
                ubicacionfecha = "atras_fecha";
                nombrebordado =atrasnombre;
                cantidadaplicacion = aplicacionfrente;
                
                ubicacionprenda = "ATRAS";
              
                
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
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
      
        
         agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega();   
          

        }
                      
                        
                        
        insertarlacantidadylafechaenlaubicacionLOCALYRECIBIDA();
        
        actualizarestatusentregaordendebordado(); 
    
      
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
       
                     
                    }
        
       
    }//GEN-LAST:event_btnladoderechotermineActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventanaordengorra = false;
        this.dispose();
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

            if(boton.equals("btnfrente"))
            {
                if(btnfrentetermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                {    
                btnfrentetermine.doClick();
                }
            }
            else if(boton.equals("btnladoderecho"))
            {
                 if(btnatrastermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                {
                btnatrastermine.doClick();
                }
            }
            else if(boton.equals("btnladoizquierdo"))
            {
                if(btnatrastermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                {
                btnladoizquierdotermine.doClick();
                }
            }
            else if(boton.equals("btnatras"))
            {
                if(btnatrastermine.getText().equals("Cancelar"))
                {
                    
                }
                else
                {
                btnladoderechotermine.doClick();
                }
            
            }

        }

        terminetodo = "no";
        btnterminetodo.setEnabled(false);
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">La orden se actualizó correctamente");
        
        if(ordenesporrealizar.ventanaordenesporrealizar==true)
        {
            ordenesporrealizar.btndatos.doClick();
        }
        
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
        bordadoseditar.txtidentificador.setText(identificador);
        bordadoseditar.lbcodigocliente.setText(codigocliente);
        bordadoseditar.lbconsecutivo.setText(consecutivo);
        bordadoseditar.lbprenda.setText("GORRA");

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

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigocliente+"' and identificador_prenda = '"+identificador+"' and tipo = 'GORRA' and numero_consecutivo = '"+consecutivo+"' ";

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
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"',puntadas_en_fotomontajes ='no' where codigo='"+codigocliente+"' and identificador_prenda = '"+identificador+"' and tipo = 'GORRA' and numero_consecutivo = '"+consecutivo+"' ");
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

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed

        
        datos();
        
        
        
    }//GEN-LAST:event_btndatosActionPerformed

    private void btnladoderechocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechocancelarActionPerformed
                 
        
           
        
        
        
                    
                    
          ubicacionfecha  = "lado_derecho_fecha";
           ubicacioncantidad = "lado_derecho_cantidad"; 
            
           nombrebordado =ladoderechonombre;
          // cantidadaplicacion = aplicacionfrente;  
           
           ubicacionprenda = "LADO DERECHO";
        
        
        
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
            autorizacion.lbinterfaz.setText("gorracancelar1");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
        
        
        
              
    }//GEN-LAST:event_btnladoderechocancelarActionPerformed

    private void btnladoizquierdocancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdocancelarActionPerformed
            
        
         
        
        
        
                    
                    
          ubicacionfecha  = "lado_izquierdo_fecha";
           ubicacioncantidad = "lado_izquierdo_cantidad"; 
            
           nombrebordado =ladoizquierdonombre;
         //  cantidadaplicacion = aplicacionfrente;  
           
           ubicacionprenda = "LADO IZQUIERDO";
        
        
        
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
            autorizacion.lbinterfaz.setText("gorracancelar1");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
        
        
        

    }//GEN-LAST:event_btnladoizquierdocancelarActionPerformed

    private void btnfrentecancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrentecancelarActionPerformed
      
   
                      
                      
                  ///////////////////    
                      
                 
        
                    
                    
          ubicacionfecha  = "frente_fecha";
           ubicacioncantidad = "frente_cantidad"; 
            
           nombrebordado =frentenombre;
           cantidadaplicacion = aplicacionfrente;  
           
           ubicacionprenda = "FRENTE";
        
        
        
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
            autorizacion.lbinterfaz.setText("gorracancelar1");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
        

                
    }//GEN-LAST:event_btnfrentecancelarActionPerformed

    private void btnatrascancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrascancelarActionPerformed
       
        
        
                    
                    
          ubicacionfecha  = "atras_fecha";
           ubicacioncantidad = "atras_cantidad"; 
            
           nombrebordado =atrasnombre;
         // cantidadaplicacion = aplicacionfrent;  
           
           ubicacionprenda = "ATRAS";
        
        
        
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
            autorizacion.lbinterfaz.setText("gorracancelar1");
            autorizacion.lbnivel.setText("2");

        }
        }    
        
        
        
        
        
            
    }//GEN-LAST:event_btnatrascancelarActionPerformed

    private void btnponchado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado2ActionPerformed
      
        
        String ubicacionponchado ="atras_ponchado";
                String ubicacionnombre ="atras_ponchado_nombre";
                        
                descargarponchado((String) ubicacionponchado,(String) ubicacionnombre); 
    }//GEN-LAST:event_btnponchado2ActionPerformed

    private void btnponchado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado3ActionPerformed
        
        
        String ubicacionponchado ="lado_izquierdo_ponchado";
                String ubicacionnombre ="lado_izquierdo_ponchado_nombre";
                        
                descargarponchado((String) ubicacionponchado,(String) ubicacionnombre); 
                
                
                
    }//GEN-LAST:event_btnponchado3ActionPerformed

    private void btnponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado1ActionPerformed
      
        
        String ubicacionponchado ="frente_ponchado";
                String ubicacionnombre ="frente_ponchado_nombre";
                        
                descargarponchado((String) ubicacionponchado,(String) ubicacionnombre); 
                
                
    }//GEN-LAST:event_btnponchado1ActionPerformed

    private void btnponchado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnponchado4ActionPerformed
    
        
        String ubicacionponchado ="lado_derecho_ponchado";
                String ubicacionnombre ="lado_derecho_ponchado_nombre";
                        
                descargarponchado((String) ubicacionponchado,(String) ubicacionnombre); 
                
                
    }//GEN-LAST:event_btnponchado4ActionPerformed

    private void btnfrentetermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfrentetermineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
                
                
    }//GEN-LAST:event_btnfrentetermineMouseReleased

    private void btnladoderechotermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoderechotermineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnladoderechotermineMouseReleased

    private void btnladoizquierdotermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoizquierdotermineMouseReleased
             
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnladoizquierdotermineMouseReleased

    private void btnatrastermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnatrastermineMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
    }//GEN-LAST:event_btnatrastermineMouseReleased

    private void btnfrentecancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnfrentecancelarMouseReleased
            
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
               
                
                
                
                
    }//GEN-LAST:event_btnfrentecancelarMouseReleased

    private void btnladoderechocancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoderechocancelarMouseReleased
            
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
              
    }//GEN-LAST:event_btnladoderechocancelarMouseReleased

    private void btnladoizquierdocancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnladoizquierdocancelarMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
             
    }//GEN-LAST:event_btnladoizquierdocancelarMouseReleased

    private void btnatrascancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnatrascancelarMouseReleased
              
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
               
                
                
    }//GEN-LAST:event_btnatrascancelarMouseReleased

    private void btnterminetodoAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_btnterminetodoAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_btnterminetodoAncestorAdded

    private void btnreplicar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnreplicar1ActionPerformed

    private void btnreplicar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnreplicar2ActionPerformed

    private void btnreplicar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnreplicar3ActionPerformed

    private void btnreplicar4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnreplicar4ActionPerformed

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

    private void btnquitarponchado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado4ActionPerformed

        btncargarponchado4.setEnabled(true);
        btnreplicar4.setEnabled(false);
        btnquitarponchado4.setEnabled(false);

        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
    }//GEN-LAST:event_btnquitarponchado4ActionPerformed

    private void btnquitarponchado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado3ActionPerformed

        btncargarponchado3.setEnabled(true);
        btnreplicar3.setEnabled(false);
        btnquitarponchado3.setEnabled(false);

        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
    }//GEN-LAST:event_btnquitarponchado3ActionPerformed

    private void btnquitarponchado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado2ActionPerformed

        btncargarponchado2.setEnabled(true);
        btnreplicar2.setEnabled(false);
        btnquitarponchado2.setEnabled(false);

        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
    }//GEN-LAST:event_btnquitarponchado2ActionPerformed

    private void btnquitarponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnquitarponchado1ActionPerformed

        btncargarponchado1.setEnabled(true);
        btnreplicar1.setEnabled(false);

        btnquitarponchado1.setEnabled(false);

        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Ponchado eliminado");
    }//GEN-LAST:event_btnquitarponchado1ActionPerformed

 

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
            java.util.logging.Logger.getLogger(ordengorraS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordengorraS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordengorraS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordengorraS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ordengorraS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnatrascancelar;
    private javax.swing.JButton btnatrastermine;
    private javax.swing.JButton btncargarponchado1;
    private javax.swing.JButton btncargarponchado2;
    private javax.swing.JButton btncargarponchado3;
    private javax.swing.JButton btncargarponchado4;
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneditarbordado;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    public static javax.swing.JButton btnfrentecancelar;
    private javax.swing.JButton btnfrentetermine;
    public static javax.swing.JButton btnladoderechocancelar;
    private javax.swing.JButton btnladoderechotermine;
    public static javax.swing.JButton btnladoizquierdocancelar;
    private javax.swing.JButton btnladoizquierdotermine;
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
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JLabel lbatrasnombre;
    private javax.swing.JLabel lbatrasnombre1;
    public static javax.swing.JLabel lbatraspuntadas;
    public static javax.swing.JLabel lbautorizacion;
    public static javax.swing.JLabel lbbordacliente;
    public static javax.swing.JLabel lbcantidad;
    public javax.swing.JLabel lbcantidad1;
    public javax.swing.JLabel lbcantidad2;
    public javax.swing.JLabel lbcantidad3;
    public javax.swing.JLabel lbcantidad4;
    public static javax.swing.JLabel lbcliente;
    public javax.swing.JLabel lbcodigoatras;
    public javax.swing.JLabel lbcodigofrente;
    public javax.swing.JLabel lbcodigoladoderecho;
    public javax.swing.JLabel lbcodigoladoizquierdo;
    public javax.swing.JLabel lbcoloratras;
    public javax.swing.JLabel lbcolorfrente;
    public javax.swing.JLabel lbcolorladoderecho;
    public javax.swing.JLabel lbcolorladoizquierdo;
    public static javax.swing.JLabel lbestatus;
    public static javax.swing.JLabel lbfecha;
    public static javax.swing.JLabel lbfechaentrega;
    private javax.swing.JLabel lbfotomontaje;
    public static javax.swing.JLabel lbfrentenombre;
    private javax.swing.JLabel lbfrentenombre1;
    public static javax.swing.JLabel lbfrentepuntadas;
    public static javax.swing.JLabel lbhoraentrega;
    public static javax.swing.JLabel lbidentificador;
    public static javax.swing.JLabel lbladoderechonombre;
    private javax.swing.JLabel lbladoderechonombre1;
    public static javax.swing.JLabel lbladoderechopuntadas;
    public static javax.swing.JLabel lbladoizquierdonombre;
    private javax.swing.JLabel lbladoizquierdonombre1;
    public static javax.swing.JLabel lbladoizquierdopuntadas;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumerodeventa;
    public static javax.swing.JLabel lbnumeroordenopedidorecibido;
    public static javax.swing.JLabel lbnumeroordenopedidosolicitado;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    public static javax.swing.JLabel lbordenopedidorecibido;
    public static javax.swing.JLabel lbprenda;
    public static javax.swing.JLabel lbprenda1;
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
