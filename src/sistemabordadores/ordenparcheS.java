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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static sistemabordadores.ordengorraS.lbcliente;


public class ordenparcheS extends javax.swing.JFrame {
public static boolean ventanaordenparche = false;

        private PreparedStatement pst;
        String cliente = "";
        String numerocatalogoprendas = "";
        String numerocatalogoubicacion = "";
        String numerocatalogocolores = "";
        String prenda = "";
        String nuevoestatusorden = "";
        String cantidad = "";
        String cantidadparche = "";
        String parche = "";
        String parchenombre = "";
        String nombre = "";
        String ubicacion = "";
        String aplicacion = "";
        String observacion = "";
       
        String numerosucursalordenbordado = "";
        String primero = "";
        String ultimo = "";
        String cantidadparchesactualizar = "";
        String tipo = "";
        String numerodeventa = "";
        String descripcion = "";
        String aplicacioninsertar = "";
        String fechaubicacion = "";
        String tienefotomontaje = "";
        String rutaimagen = "";
        String codigocliente = "";
     
       String lugar = "";
       String numeroordendebordadolocalorecibida = "";
       String identificador = "";
       String consecutivo = "";
       String tieneunaobservacion = "";
       String numerosucursalordencamisa = "";
       String tienenumerodesucursal = "";
       String sucursal = "";
       String numeroordendeenviosolicitada = "";
       String ipsucursal = "";
       Connection cnsucursal = null;
       String tiendaconectada = "";
       String esenvioopedido = "";
       String numeroenvioopedidorecibido = "";
        
        String numerosucursal = "";
        public static String tipotabla ="";
        String nombredelatabla ="";
        
        String tiendalocal = "";
        String iplocal = ingresotienda.iplocal;
        
        String terminetodo = "";
        
        ArrayList<String> listabotones = new ArrayList<String>();
         ArrayList<String> listahilos = new ArrayList<String>();
        
     
     public static String enquesucursalsebordara ="";
     
     
        public static final Color anaranjado = new Color(255,166,77);
    
    
   
    public ordenparcheS() 
    {
        initComponents();
        ventanaordenparche = true;
      //  btndatos.setVisible(false);
        lbhora.setVisible(false);
        btnterminetodo.setEnabled(false);
        lbautorizacion.setVisible(false);
        
         tiendalocal = principal.lbtiendalocal.getText();

    }

    
    
    void datos(){
        
        
          
if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
      
         nombredelatabla = "historial_ordenes_parche";

    try {
        datostiendalocal();
    } catch (IOException ex) {
        Logger.getLogger(ordenparcheS.class.getName()).log(Level.SEVERE, null, ex);
    }
        
      codigocliente();
        
        cliente();
        
         hilosycolor();
        
        try {
            cargarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordengorraS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(enquesucursalsebordara.equals("Otra sucursal") && (numerosucursalordenbordado == null || numerosucursalordenbordado.equals("") || numerosucursalordenbordado.equals(" ") ) )
        {
            
         
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Recuerda que Aqui solo replicas los ponchados y el fotomontaje");
        
        }
       
        sumapuntos();
        
    }
else
    
    if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
        nombredelatabla = "historial_ordenes_parche_recibidas";
        
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
        
        
        
        
         String observacion = lbobservacion.getText();
        
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
    
        String botonhabilitado1 = "si";
       
        
        limpiar();
   
     
        numeroordendebordadolocalorecibida = lborden.getText();
        
        
   
     String sql = "SELECT numero,numero_venta,fecha,hora,cliente,nombre_comercial,borda_cliente,tipo,estatus_entrega,articulo,parche,parche_nombre,cantidad,cantidad_parche,observacion,aplicacion,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observaciongeneral,lugar,identificador_prenda,estatus_orden,numero_orden FROM historial_ordenes_parche WHERE numero = '"+numeroordendebordadolocalorecibida+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                 cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
                lbnombrecomercial.setText( rs.getString("nombre_comercial"));
                
                lbbordacliente.setText( rs.getString("borda_cliente"));
                
              //  estatusentrega = rs.getString("estatus_entrega");
                        
                lbnumerodelaotrasucursal.setText(rs.getString("numero"));
                lbfechaelaboracion.setText(rs.getString("fecha"));
                lbhora.setText(rs.getString("hora"));
                
                
                
                numerodeventa = rs.getString("numero_venta");
                lbnumerodeventa.setText(numerodeventa);
                
                numeroordendeenviosolicitada=rs.getString("numero_orden");
                
                
                
                
                
                parche = rs.getString("parche");
                lbparchepuntadas.setText(parche);
                parchenombre = rs.getString("parche_nombre");
               
                
                
                
                
                
                  
                if (parche == null || parche.equals("") || parche.equals("ninguno")) {

              
                    botonhabilitado1 = "no";
                    btnparcheponchado.setEnabled(false);
                 
                    
                }
                 else
                {
                    
                    
                     botonhabilitado1 = "si";
                     
                     lbparchenombre.setText(parchenombre);
                    lbparchepuntadas.setText(parche);
                  
                    
                    btnparcheponchado.setEnabled(true);
                     
                }
                
                
                
                
                
                nombre = rs.getString("articulo");
                cantidad = rs.getString("cantidad");
                cantidadparche = rs.getString("cantidad_parche");
                
                
                
                  if( botonhabilitado1.equals("si"))
                {
                     
                          
                   if(cantidadparche.equals("0"))
                   {
                
                 btntermine.setEnabled(true);
                 btncancelar.setEnabled(false);
                 
                 
                  lbcantidad1.setText("0");
                 lbcantidad1.setForeground(Color.red.darker());
                    
                }
                else
                {
                    
                    
                    btncancelar.setEnabled(true);
                    btntermine.setEnabled(false);
                    
                    lbcantidad1.setText(cantidad);
                   lbcantidad1.setForeground(Color.GREEN.darker());
                  
                }    
                
              
                
                }
                  
                  
                  else
                  {
                      
                       btntermine.setEnabled(false);
                  }
                
                
                
                
                
                
                
                aplicacion = rs.getString("aplicacion");
             
                observacion = rs.getString("observacion");
                identificador = rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                lbparchenombre.setText(identificador);
               
                
          //      lbobservacion.setText(rs.getString("observaciongeneral"));
                
                String observacion = rs.getString("observacion");
                
                if(observacion == null || observacion.equals("")||observacion.equals(" ") )
                {
                    
                }
                else
                {
                
                 
                tieneunaobservacion="si";    
                lbobservacion.setText(observacion);
                
                }

               
                sucursal= "ninguno";//rs.getString("tienda")

             
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
                
                
                
                
                cantidad = rs.getString("cantidad"); 
                lbcantidad1.setText(cantidad);
               
               
                
             
            }

        } catch (SQLException ex) 
        {
          
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        esordendeenvioopedidoyobtenernumeros();
        
        
    //    sumapuntos();
      
        
    }
    
    
   
   
    void hilosycolor()
    {
       
     

        String sql = "Select hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,color1,color2,color3,color4,color5,color6,color7,numero_consecutivo from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'parche'   ";

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
         //         lbcolormangaderecha.setText(codigo1.toString());
         //         lbcodigoladoderechofrente.setText(hilo1.toString());
                }  
                
          
                
                    
                
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
    }
    
    
    
    
    
    
    
    
    void esordendeenvioopedidoyobtenernumeros() 
    {
        /// busca las ordenes de camisa generadas 

        
        String numero = lbnumerodeventa.getText();
        String pedi = "";
        
        
        
        
        
        
        String sql2 = "Select orden_o_pedido,numero_orden_o_pedido_recibida from historial_ordenes_parche_recibidas where numero = '" + numero + "'  ";

        try {
            PreparedStatement prst = cn.prepareStatement(sql2);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {
                esenvioopedido = rs.getString("orden_o_pedido");
                numeroenvioopedidorecibido = rs.getString("numero_orden_o_pedido_recibida");

            }
            
          
            
            
        } catch (Exception exx) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+exx+"");

        }


    }
    
    
 
    void numeroconsecutivo()
    {
       

        String sql = "Select numero_consecutivo from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'PARCHE'   ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next()) 
            {
            
                
                consecutivo = rs1.getString("numero_consecutivo");
                
               
             
                
                    
                
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
    }
    
   
   
     void limpiar()
             
     {
         
         
                lbcantidad.setText("0");
                lbcantidad1.setText("0");
                
                lbprenda.setText("");
                
              
                lbaplicacion1 .setText("");
                
         
                lbfechaelaboracion.setText("");
                lbfechaelaboracion.setText("");
              
               
                lbestatus.setText("");
            
              
                lbobservacion.setText("");
               
         
         
         
     }
    
    
      void insertarlacantidadylafechaenlaubicacion(String cantidadponchadosactualizar,String tipo, String fechaubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_parche set cantidad_parche='" +cantidadponchadosactualizar+ "',"+fechaubicacion+"  =  '"+dia()+"' where numero = '"+lbnumerodelaotrasucursal.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Actualizado correctamente ");

    try {
        datostiendalocal();
    } catch (IOException ex) {
        Logger.getLogger(ordenparcheS.class.getName()).log(Level.SEVERE, null, ex);
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
    
    
    
    
    
    
    
    
     void estacompletalaorden()
    {
        
       
        int tienecantidad = 0;
        int botonesactivados = 0;
        
         String sql = "Select cantidad,cantidad_parche from "+nombredelatabla+" where numero = '"+numeroordendebordadolocalorecibida+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cantidad = rs.getString("cantidad");   
                String cantidadubicacion1 = rs.getString("cantidad_parche");
               
                
                
                if(cantidadubicacion1==null || cantidadubicacion1.equals("")||cantidadubicacion1.equals(" ") )
                {
                    
                    
                }
                else
                {
                    
                    
                    
                         if(cantidadubicacion1.equals("0") )
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
                
                
                
                
                
                
                    if(tienecantidad == botonesactivados)
           {
               
             nuevoestatusorden = "realizada totalmente";
               
           }
         
           else
       
           {
               
               nuevoestatusorden = "realizada parcialmente";
            
           }   
                
                
                
             
               try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set estatus_orden='"+nuevoestatusorden+"' where numero='" +numeroordendebordadolocalorecibida+ "'   ");
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
    
    
    
    
    
    
    
    
    
       
    void insertarlacantidadylafechaenlaubicacion(String ubicacion, String fechaubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_parche set "+ubicacion+" = '"+cantidad+"',"+fechaubicacion+"  =  '"+dia()+"' where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    
     void verfotomontajetiendalocal()
    {
      
        String rutadelarchivo = "";
        String existe = "";
        
        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'Parche'   ";

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
        String sql = "Select extension_imagen,imagen from bordados_puntadas where nombre = '" + cliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'Parche'   ";

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
    
     
     
     
    
    void insertarlacantidadylafechaenlaubicacionhistorialRECIBIDO(String ubicacion)
    {
        
      
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_parche_recibidas set "+ubicacion+"='" + cantidad + "',parche_fecha='"+dia()+"' where numero = '"+numeroordendebordadolocalorecibida+"'");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
        try {
            datosotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    
    
    
    
    
    
      void datosotrasucursal() throws IOException 
     {

        btnreplicarponchados.setEnabled(true);
        btnterminetodo.setEnabled(true);

        numeroordendebordadolocalorecibida = lborden.getText();
        prenda = "Parche";
        sucursal = lbsucursal.getText();

        String sql = "Select numero,numero_orden_o_pedido_solicitada,fecha,hora,cliente,nombre_comercial,borda_cliente,tipo,estatus_entrega,articulo,parche,cantidad,parche,observacion,aplicacion,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observaciongeneral,lugar,identificador_prenda,estatus_orden,identificador_prenda,cantidad_parche,parche_fecha FROM historial_ordenes_parche_recibidas where numero = '" + numeroordendebordadolocalorecibida + "' and tienda = '" + sucursal + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

               
                 
                 cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
              
                lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                lbbordacliente.setText(rs.getString("borda_cliente"));
             
               
                lbnumerodelaotrasucursal.setText(rs.getString("numero_orden_o_pedido_solicitada"));
         
                lbfechaelaboracion.setText(rs.getString("fecha"));
                lbhora.setText(rs.getString("hora"));
                
                
                
                parche = rs.getString("parche");
                lbparchepuntadas.setText(parche);
                
                nombre = rs.getString("articulo");
         
                
                cantidad = rs.getString("cantidad");
                lbcantidad.setText(cantidad);
                
                
                aplicacion = rs.getString("aplicacion");
                observacion = rs.getString("observacion");
                
                
                lbestatus.setText(rs.getString("estatus_orden"));
                
                 String estatusorden = rs.getString("estatus_orden");
                 lbestatus.setText(estatusorden);
                
                 
                 
                 
                if(estatusorden.equals("realizada totalmente"))
                {
                  btnterminetodo.setEnabled(false);
                  btntermine.setEnabled(false);
                  
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
                   
                
                
                identificador = rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                lbparchenombre.setText(identificador);
                
                
                lugar = rs.getString("lugar");
                
                cantidadparche = rs.getString("cantidad_parche");
                lbcantidad1.setText(cantidadparche);
                
                
                
                 if(cantidadparche.equals("0"))
                {
                lbcantidad1.setForeground(Color.red.darker());
                    
                }
                else
                {
                    btntermine.setEnabled(false);
                   lbcantidad1.setForeground(Color.GREEN.darker());
                  
                }    
                
              
                
                
                

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        
         cliente = lbcliente.getText();
        
        
        
        
            tiendaconectada();   
             
            
                
              if (tiendaconectada.equals("si"))

                      {
      
                          
                        
                
                 try {
         
                     
                     
            Class.forName("com.mysql.jdbc.Driver");
       
         
            cnsucursal = DriverManager.getConnection("jdbc:mysql://" + ipsucursal + "/" + sucursal + "", "root", "sistemas");
      

        
        
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
     
     
     
     
     
      
       void eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion(String ubicacion, String fecha){
        
           
           
             String estatus = "generada";
           
           
           
           
           
         try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE  "+nombredelatabla+" set estatus_orden = '"+estatus+"', "+ubicacion+"='0', "+fecha+"=null where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
         
         
         
            datos();
        
        
        
    }
    
    
    
     
     
     
    
    void regresaralaconeccionlocal(){
          
        
         
         
         
        try {
            Class.forName("com.mysql.jdbc.Driver");
             cn = DriverManager.getConnection("jdbc:mysql://" + iplocal + "/" + tiendalocal + "", "root", "sistemas"); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ordencamisaS.class.getName()).log(Level.SEVERE, null, ex);
        }
       
         
           
       
     }
    
    
    
    
    
    
     
     void tiendaconectada()
 {
     
    
     
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
            
            
            
              if (tiendaconectada.equals("si"))
          
                
            {       
            
               try { 
                     
                     
                     
            cnsucursal = DriverManager.getConnection("jdbc:mysql://" + ipsucursal + "/" + sucursal + "", "root", "sistemas");
        } catch (SQLException ex) {
            Logger.getLogger(ordenparcheS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            }
            
            
            
            
            
            
            
            
            

        }         

     
 }
 
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void agregaralsurtidasalhistorialdeventasyactualizarestatusentrega(String ubicacion, String cantidad) 
      {

        
        String numeroventa =  lbnumerodeventa.getText();
        String surtidaactualstring ="";
        int surtidaactualint =  0;
        String surtidanuevastring = "";
        String estatusentrega ="";
        int surtidanuevaint = 0;
        int cantidadint = 0;
      
        
          String SQL2 = "select surtida from historial_ventas where numero = '" + numeroventa + "' and articulo = '" + ubicacion + "' ";
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
     
        String observacion = "\n no se pudo surtir debido a que NO SE ENCONTRÓ EL BORDADO EN LA VENTA; QUIZAS SE CAMBIO LA DESCRIPCION DEL BORDADO";
        
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
          
       
         cantidadint =  Integer.parseInt(cantidad);
        surtidanuevaint = surtidaactualint + cantidadint;
       
        surtidanuevastring =  String.valueOf(surtidanuevaint);
            
      
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + surtidanuevastring + "' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       
            
            
            
            
            
            
            
            
            
            
            
            

        ////Actualiza el estatus

      String sumasurtidastring = "";  
      String sumavendidastring = "";  
      String sumaentregadastring = "";  
      
      int sumasurtidaint = 0;  
      int sumavendidaint = 0;  
      int sumaentregadaint = 0;  
       
      
      
      
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(entregadas) as entregadas from historial_ventas where numero = '"+numerodeventa+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        sumavendidastring = rs.getString("cantidad");
        sumasurtidastring = rs.getString("surtida");
        sumaentregadastring = rs.getString("entregadas");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
      
      /////
      
       sumavendidaint = Integer.parseInt(sumavendidastring);
       sumasurtidaint = Integer.parseInt(sumasurtidastring);
       sumaentregadaint = Integer.parseInt(sumaentregadastring);
      
        
        if(sumavendidaint == sumasurtidaint && sumaentregadaint == 0 )
        {
          estatusentrega ="surtida totalmente no entregada";  
        }
        else  if(sumavendidaint == (sumasurtidaint + sumaentregadaint )  &&  sumaentregadaint <  sumavendidaint  )
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
    
    
    
    
    
    
    
    
    
    
    
    
     void agregaralsurtidasalhistorialdeventascancelar(String ubicacion, String cantidad) 
      {

        
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
        
        String SQL2 = "select cantidad from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + ubicacion + "' ";
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

        int nuevacantidadint = cantidadstringint - cantidadint;
        nuevacantidadstring =  String.valueOf(nuevacantidadint);
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + nuevacantidadstring + "' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
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
    
    
    
     
     
     
     
     
     
     
     
     
     void agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega(String ubicacion, String cantidad){
         
       
         
         
         String surtidaactualstring ="";
        int surtidaactualint =  0;
        String surtidanuevastring = "";
        String estatusentrega ="";
        int surtidanuevaint = 0;
        int cantidadint = 0;
        
        
       
                 if (esenvioopedido.equals("ordendeenvio")) 
        {
            
            
            
            String sql3 = "Select surtidas from historial_ordenes_envio_recibidas where numero = '" + numeroenvioopedidorecibido + "'";

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
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacion+"" + lineas[0] + "</span><br>";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET surtidas = '" + surtidanuevastring + "' WHERE numero='" + numeroenvioopedidorecibido + "' and articulo = '" + ubicacion + "'      ");
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
       
      
      
      
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(enviadas) as enviadas from historial_ordenes_envio_recibidas where numero = '"+numeroenvioopedidorecibido+"'  ";
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
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroenvioopedidorecibido + "'       ");
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

                
                
              
            String sql3 = "Select surtidas from historial_pedidos_sucursal_recibidos where numero = '" + numeroenvioopedidorecibido + "'";

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
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacion+"" + lineas[0] + "</span><br>";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET surtidas = '" + surtidanuevastring + "' WHERE numero='" + numeroenvioopedidorecibido + "' and articulo = '" + ubicacion + "'      ");
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
       
      
      
      
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(enviadas) as enviadas from historial_pedidos_sucursal_recibidos where numero = '"+numeroenvioopedidorecibido+"'  ";
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
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroenvioopedidorecibido + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      

            
            
            
            
            }
         
         
         
         
         
     }
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     void agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentregacancelar(String ubicacion, String cantidad)
      {

          
          
          
        
         
         String surtidaactualstring ="";
        int surtidaactualint =  0;
        String surtidanuevastring = "";
        String estatusentrega ="";
        int surtidanuevaint = 0;
        int cantidadint = 0;
        
        
       
                 if (esenvioopedido.equals("ordendeenvio")) 
        {
            
            
            
            String sql3 = "Select surtidas from historial_ordenes_envio_recibidas where numero = '" + numeroenvioopedidorecibido + "'";

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
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacion+"" + lineas[0] + "</span><br>";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET surtidas = '" + surtidanuevastring + "' WHERE numero='" + numeroenvioopedidorecibido + "' and articulo = '" + ubicacion + "'      ");
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
       
      
      
      
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(enviadas) as enviadas from historial_ordenes_envio_recibidas where numero = '"+numeroenvioopedidorecibido+"'  ";
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
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_envio_recibidas SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroenvioopedidorecibido + "'       ");
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

                
                
              
            String sql3 = "Select surtidas from historial_pedidos_sucursal_recibidos where numero = '" + numeroenvioopedidorecibido + "'";

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
        
        String mensaje = "<HTML><span style=\"Color:red;font-size:20px;\">POR FAVOR INDIQUE AL ENCARGADO que el arículo "+ubicacion+"" + lineas[0] + "</span><br>";
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
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET surtidas = '" + surtidanuevastring + "' WHERE numero='" + numeroenvioopedidorecibido + "' and articulo = '" + ubicacion + "'      ");
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
       
      
      
      
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(enviadas) as enviadas from historial_pedidos_sucursal_recibidos where numero = '"+numeroenvioopedidorecibido+"'  ";
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
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_pedidos_sucursal_recibidos SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroenvioopedidorecibido + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      

            
            
            
            
            }
         
         
         

      
    }
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    void cliente(){
        
        
        cliente = lbcliente.getText();
        
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
    
    
    
    
    
    void sumapuntos()
    {
        
        
        
        if (lugar.equals("Otra sucursal"))
        {
         
            
             String costostring = "0";
        
        
     
        int cantidadparcheint = Integer.parseInt(cantidad);
        double costopuntada = 0.0;
        Object puntadaobject = "";
        
        String sql = "SELECT parche from historial_ordenes_parche_recibidas where numero = '"+numeroordendebordadolocalorecibida+"' ";

        try {
            PreparedStatement prst = cn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {

                puntadaobject = rs.getString("parche");
                

            }
        } catch (Exception exx) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+exx+"");

        }
        
        
        String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadaobject + "'";

        try {
            PreparedStatement prst = cn.prepareStatement(sql1);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {

                costostring = rs.getString("costo");
                costopuntada = Double.parseDouble(costostring);

            }
        } catch (Exception exx) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+exx+"");

        }

        double sumabordados = costopuntada * cantidadparcheint;
        String sumabordadosstring = String.format("%.02f ", sumabordados);
        lbsumapuntos.setText(sumabordadosstring);

            
        
        
        
            
        }
        
        else
        {
            
               
              String costostring = "0";
        

     
        int cantidadparcheint = Integer.parseInt(cantidad);
        double costopuntada = 0.0;
        Object puntadaobject = "";
        
        String sql = "SELECT parche from historial_ordenes_parche where numero = '"+lbnumerodelaotrasucursal.getText()+"' ";

        try {
            PreparedStatement prst = cn.prepareStatement(sql);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {

                puntadaobject = rs.getString("parche");
                

            }
        } catch (Exception exx) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+exx+"");

        }
        
        
        String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadaobject + "'";

        try {
            PreparedStatement prst = cn.prepareStatement(sql1);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {

                costostring = rs.getString("costo");
                costopuntada = Double.parseDouble(costostring);

            }
        } catch (Exception exx) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+exx+"");

        }

        double sumabordados = costopuntada * cantidadparcheint;
        String sumabordadosstring = String.format("%.02f ", sumabordados);
        lbsumapuntos.setText(sumabordadosstring);

            
             
             
             
             
             
             
             
             
            
        }
        
        
      
       
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
     void codigocliente()
    {
        
        
        
        
        String sql = "SELECT codigo_cliente FROM historial_ventas WHERE numero = '"+lbnumerodeventa.getText()+"' ";


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
        
        
        String puntadasenfotomontajes = "";
        BufferedImage img = null;

       

        String sql = "Select extension_imagen,imagen,numero_consecutivo,puntadas_en_fotomontajes  from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '" + identificador + "' and tipo = 'PARCHE'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {

                puntadasenfotomontajes=rs.getString("puntadas_en_fotomontajes");
                consecutivo = rs.getString("numero_consecutivo");
                Blob blob = rs.getBlob("imagen");
                if (blob == null) 
                {

                   

                } else {
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) {
                        
                        JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");

                    }

                    if (img == null) 
                    {
                        tienefotomontaje = "no";
                    } else {

                        Imagen imagen = new Imagen();
                        imagen.setImagen(img);
                        lbfotomontaje.setIcon(new ImageIcon(img.getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT)));
                        lbfotomontaje.setVisible(true);
                        tienefotomontaje = "si";

                        Blob archivo = rs.getBlob("imagen");
                        String nombredelarchivo = rs.getString("extension_imagen");
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
        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }

        
/*
        
         if(puntadasenfotomontajes.equals("si"))
        {

           
            
            
            btnfotomontajesinpuntadas.setEnabled(true);
            bntterminetodo.setEnabled(false);
            btnverfotomontaje.setEnabled(false);
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar nuevo fotomontaje SIN PUNTADAS");
            
        
        }


        else

         */

      if(tienefotomontaje.equals("no"))
        {
            
            
        
     
     
           btnfotomontajesinpuntadas.setEnabled(false);
           btnterminetodo.setEnabled(false);  
           btnverfotomontaje.setEnabled(false);  
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");

       }  
        
        
    }
   
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        lbnumerodelaotrasucursal = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbfotomontaje = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbfechaelaboracion = new javax.swing.JLabel();
        lbhora = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbestatus = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        lbbordacliente = new javax.swing.JLabel();
        lbnombrecomercial = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbprenda = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
        lbaplicacion1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnterminetodo = new javax.swing.JButton();
        btneditarbordado = new javax.swing.JButton();
        btnverfotomontaje = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lborden = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservacion = new javax.swing.JTextArea();
        btnvercolorido = new javax.swing.JButton();
        btnfotomontajesinpuntadas = new javax.swing.JButton();
        btndatos = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        lbnumerodeventa = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        btnreplicarponchados = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lbsucursal = new javax.swing.JLabel();
        lbprenda1 = new javax.swing.JLabel();
        lbprenda2 = new javax.swing.JLabel();
        lbprenda3 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        btnparcheponchado = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbparchepuntadas = new javax.swing.JLabel();
        lbparchenombre = new javax.swing.JLabel();
        lbcodigo = new javax.swing.JLabel();
        lbcolor = new javax.swing.JLabel();
        btntermine = new javax.swing.JButton();
        lbcantidad1 = new javax.swing.JLabel();
        lbautorizacion = new javax.swing.JLabel();
        lbnumeroordenopedidosolicitado = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden de parche");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Orden o pedido solicitado");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumerodelaotrasucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumerodelaotrasucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 1137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lbfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 627, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Fecha de elaboración");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfechaelaboracion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfechaelaboracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhora.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbhora.setForeground(new java.awt.Color(204, 0, 0));
        lbhora.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Cliente:");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbestatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbestatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Estatus:");
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 153));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Total de puntos");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos.setText("0.00");
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Bordacliente");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Nombre comercial");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cantidad");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbprenda.setText("Parche");
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbidentificador.setForeground(new java.awt.Color(0, 0, 153));
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbaplicacion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacion1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Aplicacion");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnterminetodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnterminetodo.setForeground(new java.awt.Color(0, 102, 0));
        btnterminetodo.setText("**-Termine todo***");
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

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Numero de orden");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lborden.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lborden.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Observacion:");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane6.setBackground(new java.awt.Color(0, 0, 0));

        lbobservacion.setEditable(false);
        lbobservacion.setColumns(20);
        lbobservacion.setRows(5);
        jScrollPane6.setViewportView(lbobservacion);

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

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("No. de venta");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumerodeventa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumerodeventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtipo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnreplicarponchados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreplicarponchados.setText("Replicar ponchados");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Sucursal");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbsucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbprenda1.setText("Prenda");
        lbprenda1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbprenda2.setText("Identificador");
        lbprenda2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbprenda3.setText("Tipo");
        lbprenda3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btnparcheponchado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnparcheponchado.setText("Ponchado");
        btnparcheponchado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnparcheponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnparcheponchadoActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Parche");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbparchepuntadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbparchepuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbparchenombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbparchenombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcodigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btntermine.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine.setText("Termine");
        btntermine.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btntermine.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btntermineMouseReleased(evt);
            }
        });
        btntermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermineActionPerformed(evt);
            }
        });

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbautorizacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbautorizacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroordenopedidosolicitado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumeroordenopedidosolicitado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Numero");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel20)
                        .addGap(7, 7, 7)
                        .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel23)
                        .addGap(7, 7, 7)
                        .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsalir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(190, 190, 190)
                                    .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(9, 9, 9)
                                    .addComponent(btnfotomontajesinpuntadas))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbprenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(3, 3, 3)
                                    .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel29)
                                    .addGap(6, 6, 6)
                                    .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(93, 93, 93)
                                    .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbfechaelaboracion, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(lbnumerodeventa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbprenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11)
                                    .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(11, 11, 11)
                                    .addComponent(lbprenda3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(1, 1, 1)
                                    .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(5, 5, 5)
                                    .addComponent(jLabel1)
                                    .addGap(14, 14, 14)
                                    .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(14, 14, 14)
                                    .addComponent(jLabel4)
                                    .addGap(8, 8, 8)
                                    .addComponent(lbaplicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lbparchenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbparchepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btntermine, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(lbcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btnparcheponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnreplicarponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnfotomontajesinpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(230, 230, 230)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfechaelaboracion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbprenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbprenda3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaplicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbprenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbparchepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnparcheponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnreplicarponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbparchenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
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
       
        ventanaordenparche = false;
        this.dispose();
        
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     
        ventanaordenparche = false;
        this.dispose();
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
        datos();
        
        
    }//GEN-LAST:event_formWindowOpened

    private void btnterminetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterminetodoActionPerformed

      
        
        
        
        terminetodo = "si";
        
        
        if (btntermine.isEnabled())
            
        {
            btntermine.doClick();
        }
        
        
        
        
         terminetodo = "no";
         btnterminetodo.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden se actualizo");
         
         if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
         this.dispose();
         ventanaordenparche = false;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnterminetodoActionPerformed

    private void btneditarbordadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarbordadoActionPerformed

        if (bordadoseditar.ventanabordadosdelclienteeditar)

        {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La ventana de bordados de cliente ya está abierta");
        }
        else

        {

            bordadoseditar.lbcliente.setText(lbcliente.getText());
        bordadoseditar.lbnombrecomercial.setText(lbnombrecomercial.getText());
        bordadoseditar.lbbordacliente.setText(lbbordacliente.getText());
        bordadoseditar.txtidentificador.setText(lbidentificador.getText());
        bordadoseditar.lbcodigocliente.setText(codigocliente);
        bordadoseditar.lbconsecutivo.setText(consecutivo);
       
       
       
           bordadoseditar.lbprenda.setText(prenda);

        }
    }//GEN-LAST:event_btneditarbordadoActionPerformed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed
     
     
       
        if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
   
        verfotomontajetiendalocal();
      
        
    }
    else 
            
            if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
       
       
         verfotomontajesucursal();
    }
        
        
            
        
    }//GEN-LAST:event_btnverfotomontajeActionPerformed

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

        String rutaarchivo = "";
        String nombrearchivo = "";
        
        
        JSystemFileChooser elegirImagen = new JSystemFileChooser();
        elegirImagen.setMultiSelectionEnabled(false);
        int o = elegirImagen.showOpenDialog(this);
        if (o == JFileChooser.APPROVE_OPTION)
        {
            rutaarchivo = elegirImagen.getSelectedFile().getAbsolutePath();
            nombrearchivo = elegirImagen.getSelectedFile().getName();

            PreparedStatement myStmt = null;
            FileInputStream input = null;
            try {

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigocliente+"' and identificador_prenda = '"+identificador+"' and tipo = 'PARCHE' and numero_consecutivo = '"+consecutivo+"' ";

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
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"',puntadas_en_fotomontajes ='no' where codigo='"+codigocliente+"' and identificador_prenda = '"+identificador+"' and tipo = 'PARCHE' and numero_consecutivo = '"+consecutivo+"' ");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            ImageIcon fot = new ImageIcon(rutaarchivo);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT));
            lbfotomontaje.setIcon(icono);
            this.repaint();

             datos();

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Fotomontaje agregado correctamente");

        }

    }//GEN-LAST:event_btnfotomontajesinpuntadasActionPerformed

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed
      
        
      datos();
      
      
    }//GEN-LAST:event_btndatosActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
      
        
        
            String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
           
        
                   String ubicacion = "cantidad_parche";
                    String fecha = "parche_fecha";
                    eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
        
        
                    
                    descripcion = "BORDADO PARCHE " +parchenombre+ "";
                    
                    
                    agregaralsurtidasalhistorialdeventascancelar((String) descripcion, (String) cantidad) ;
                    
                    
                    
                    
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
            autorizacion.lbinterfaz.setText("parchecancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
                    
                    
                    
                    
                    
        
        
        
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnparcheponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnparcheponchadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnparcheponchadoActionPerformed

    private void btntermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermineActionPerformed

       
      
      fechaubicacion  = "parche_fecha";
      String fechaubicacion = "cantidad_parche";
     
      
         if(cantidad.equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
        else
        { 
        
        
        
        
        if(lugar.equals("Esta sucursal")  && tipotabla.equals("Local"))
        {

          
            insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion);
         
            
            String cantidadaplicacion = "0";
            descripcion = "BORDADO PARCHE "+parchenombre+ "";
            aplicacioninsertar = "APLICACION PARCHE";
            
           
           
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad) ;
            estacompletalaorden();
            sumapuntos();    
      
           
        }
         else 
            
            if(lugar.equals("Otra sucursal") && tipotabla.equals("Local") && (tienenumerodesucursal.equals("no")) )
        {

        JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
          
            
            btntermine.setEnabled(false);
      

        }
        
        }
            
            
            
         else
                
                
                if(lugar.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
         
            
          
            insertarlacantidadylafechaenlaubicacionhistorialRECIBIDO((String) fechaubicacion);
          
            
            String cantidadaplicacion = "0";
         //   descripcion = "BORDADO PARCHE "+parchenombre+ ""; 
            aplicacioninsertar = "APLICACION PARCHE";
            
            
            
            
            
            agregaralsurtidasalhistorialdePEDIDOuORDENdeENVIORECIBIDAyactualizarestatusentrega((String) descripcion, (String) cantidad);
        
           
            
               estacompletalaorden(); 
    
               sumapuntos();   
        
           
               
        
              
            
        }
    
        
       
        

        }


    }//GEN-LAST:event_btntermineActionPerformed

    private void btntermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntermineMouseReleased
       
        
        
               
                if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
            
        
        
    }//GEN-LAST:event_btntermineMouseReleased

    
    ResultSet rs;
    ResultSet rs2;
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordenparcheS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btncancelar;
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneditarbordado;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    private javax.swing.JButton btnparcheponchado;
    private javax.swing.JButton btnreplicarponchados;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btntermine;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JLabel lbaplicacion1;
    public static javax.swing.JLabel lbautorizacion;
    public static javax.swing.JLabel lbbordacliente;
    private javax.swing.JLabel lbcantidad;
    public javax.swing.JLabel lbcantidad1;
    public static javax.swing.JLabel lbcliente;
    public javax.swing.JLabel lbcodigo;
    public javax.swing.JLabel lbcolor;
    private javax.swing.JLabel lbestatus;
    private javax.swing.JLabel lbfechaelaboracion;
    private javax.swing.JLabel lbfotomontaje;
    private javax.swing.JLabel lbhora;
    private javax.swing.JLabel lbidentificador;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumerodelaotrasucursal;
    public static javax.swing.JLabel lbnumerodeventa;
    public static javax.swing.JLabel lbnumeroordenopedidosolicitado;
    public static javax.swing.JTextArea lbobservacion;
    public static javax.swing.JLabel lborden;
    public javax.swing.JLabel lbparchenombre;
    public static javax.swing.JLabel lbparchepuntadas;
    private javax.swing.JLabel lbprenda;
    private javax.swing.JLabel lbprenda1;
    private javax.swing.JLabel lbprenda2;
    private javax.swing.JLabel lbprenda3;
    public static javax.swing.JLabel lbsucursal;
    public javax.swing.JLabel lbsumapuntos;
    public static javax.swing.JLabel lbtipo;
    // End of variables declaration//GEN-END:variables

     coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();


}
