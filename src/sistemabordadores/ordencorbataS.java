package sistemabordadores;



import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
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
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static sistemabordadores.ordencamisaS.lborden;
import static sistemabordadores.ordencamisaS.lbordenopedidorecibido;
import static sistemabordadores.ordengorraS.lbcliente;

public class ordencorbataS extends javax.swing.JFrame {

    public static boolean ventanaordencorbataanteriores = false;
    public static String ordenbordadocorbata = "";
    public static String esponchado ="";
    
    String cantidadprendasstring = "";
    int cantidadprendasint = 0;
    String cliente = "";
    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;
    String nombredelatabla ="";
    String primero = "";
    String ultimo = "";
    String lugar = "";
    String fechaubicacion = "";
    String prenda = "";
     String ipsucursal = "";
      String numerosucursal = "";
     String numerodeventa = "";
    String tiendaconectada = "si";
    String tiendeordenopedido = "";
    public static String tipotabla = "";
     String numeroordendebordadolocalorecibida = "";
    String nuevoestatusorden = "";
    Connection cnsucursal = null;
    String cantidad = "";

    String frentenombre = "";
    String terminetodo ="";
    String descripcion ="";
    String aplicacioninsertar = "";
    String cantidadaplicacion = "";
    String codigocliente ="";
    String tienefotomontaje ="";
    String rutaimagen ="";
 
    private PreparedStatement pst;
    String identificador = "";
    String consecutivo = "";
    String tieneunaobservacion = ""; 
    
    String sucursal = "";
    
    public static String enquesucursalsebordara = "";
    
    ;
    String iplocal = principal.lbiplocal.getText();
    String tiendalocal = principal.tiendalocal;
    
       public static final Color anaranjado = new Color(255,166,77);
    

    public ordencorbataS() {
        initComponents();
        ventanaordencorbataanteriores = true;
        lbcantidad.setText("0");
         lbautorizacion.setVisible(false);
        
      btncancelar.setEnabled(false);
      lbhoraelaboracion.setVisible(false);
    
       

    }

    public static String dia() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        return formatoFecha.format(fecha);
    }

    public static String hora() {
        Date hora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat(" HH:mm:ss  ");
        return formatoFecha.format(hora);
    }
    
    
    
    
    
    
    void datos(){
        
        
        
        
        
     if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
      
         nombredelatabla = "historial_ordenes_corbata";

        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordengorraS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        codigocliente();
        
        cliente();
        
         hilosycolor();
        
        try {
            cargarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordengorraS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(enquesucursalsebordara.equals("Otra sucursal")  )
        {
            
         btnterminetodo.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Recuerda que Aqui solo replicas los ponchados y el fotomontaje");
        
        }
       
        sumapuntos();
        
    }




     else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
        
        nombredelatabla = "historial_ordenes_corbata_recibidas";
        
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
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void datostiendalocal() throws IOException {

         
        numeroordendebordadolocalorecibida = lborden.getText();

        

        String sql = "Select fecha,hora,cliente,nombre_comercial,borda_cliente,numero_venta,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,lugar,identificador_prenda,frente_nombre,frente_puntadas,frente_cantidad,estatus_orden from historial_ordenes_corbata where numero = '" + numeroordendebordadolocalorecibida + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

               cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
                lbnombrecomercial.setText( rs.getString("nombre_comercial"));
                
                lbbordacliente.setText( rs.getString("borda_cliente"));
                
                lbnumerodeventa.setText(rs.getString("numero_venta"));
                lbcantidad.setText(rs.getString("cantidad_bordados"));

                lbfechaelaboracion.setText(rs.getString("fecha"));
                lbhoraelaboracion.setText(rs.getString("hora"));
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));
            
                String observacion = rs.getString("observacion");
                
                if(observacion == null || observacion.equals("")||observacion.equals(" ") )
                {
                    
                }
                else
                {
                
                 
                tieneunaobservacion="si";    
                lbobservaciones.setText(observacion);
                
                }

                lbfrentepuntadas.setText(rs.getString("frente_puntadas"));
                
                
                frentenombre= rs.getString("frente_nombre");
                lbfrentenombre.setText(frentenombre);
                
                
                
                identificador =rs.getString("identificador_prenda"); 
                lbidentificador.setText(identificador);
                
                cantidad = rs.getString("cantidad"); 
                
                
                lugar =rs.getString("lugar");
               
               
                
                
                
                
                
                
                
                String estatusorden = rs.getString("estatus_orden");
                 lbestatus.setText(estatusorden);
                
                if(estatusorden.equals("realizada totalmente"))
                {
                  
                  btntermine.setEnabled(false);
                  btncancelar.setEnabled(true); 
                  
                  
                  btnterminetodo.setEnabled(false);
                  
                  
                  lbestatus.setForeground(Color.green.darker());
                  lbcantidad1.setText(cantidad);
                  lbcantidad1.setForeground(Color.GREEN.darker());
                  
                  
                  lbestatus.setForeground(Color.green.darker());
                  
                  
                }
                else
                {
                    
                    
                   btntermine.setEnabled(true);
                   btncancelar.setEnabled(false); 
                   
                   btnterminetodo.setEnabled(true); 
                   
                   
                   
                    lbcantidad1.setText("0");
                      lbcantidad1.setForeground(Color.red.darker());
                   
                   
                      
                  
                      lbestatus.setForeground(Color.red.darker());
                    
                      
                  
                   
                   
                   
                   
                   
                }   
                
                
                
                
                
                

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        String sql3 = "SELECT nombre_comercial,codigo_cliente from historial_ventas where numero = '"+lbnumerodeventa.getText()+"'  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql3);

            if (rs.next());
            {

                lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                codigocliente = rs.getString("codigo_cliente");

            }
        } catch (Exception e) {
            System.out.println(e);
        }


      cargarfotomontaje();
        
        
        
        tiendalocal = principal.lbtiendalocal.getText();
        
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
      
      
      
      
    
    
    
    
 
    void hilosycolor()
    {
       

        String sql = "Select hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,color1,color2,color3,color4,color5,color6,color7,numero_consecutivo from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'CORBATA'   ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next()) 
            {
                Object hilo1 = rs1.getString("hilo1");
              
                
                
                
                Object codigo1 = rs1.getString("color1");
              
                if(codigo1.equals("ninguno"))
                {
                
             
                }
                else
                {
                  lbcolor.setText(codigo1.toString());
                  lbcodigo.setText(hilo1.toString());
                }  
                
                
                
                
                consecutivo = rs1.getString("numero_consecutivo");
                
             
                
               
                
                    
                
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
    }
    
    
    
    void eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion(String ubicacion, String fecha){
        
         try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE  "+nombredelatabla+" set "+ubicacion+"='0', "+fecha+"=null where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
        
        
        
    }
    
    
    
    
    
    void cargarfotomontaje() throws FileNotFoundException, IOException  
    {
        
    
        BufferedImage img = null;
        
      
        btnverfotomontaje.setEnabled(false);
        identificador  = lbidentificador.getText();
        
        

       String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'CORBATA'";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
            {
                
                Blob blob = rs.getBlob("imagen");
                
                
                
                if (blob == null) 
                {

                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
                    
                } 
                
                else 
                
                {
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) 
                    {
                      
                      JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");

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
                    String ext = rs.getString("extension_imagen");
                    String path = "C:\\archivospdf\\FOTOMONTAJE"+ext+" ";
                    rutaimagen=path;
                    File file = new File(path);
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
           
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
        
        if(tienefotomontaje.equals("si"))
        {
          
          
     

        }
        else
        {
            
        
            btnverfotomontaje.setEnabled(false);
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
            
           
            
        }  

        
        
    }

    
    
    
    
    
    void verfotomontajetiendalocal(){
        
      
         
         
         
        
        String rutadelarchivo = "";
        String existe = "";

        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'CORBATA'   ";

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

                JOptionPane.showMessageDialog(null,  "<HTML><b style=\"Color:red; font-size:5px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                
            }

        }
        
    }
   

    
    
    
    
      void verfotomontajesucursal(){
        
      
         
         
         
        
        String rutadelarchivo = "";
        String existe = "";

        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'CORBATA'   ";

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

                JOptionPane.showMessageDialog(null,  "<HTML><b style=\"Color:red; font-size:5px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                
            }

        }
        
    }
  
    
    
    
    
    
    
    
    
    
    
  
    void insertarlacantidadylafechaenlaubicacion(String ubicacion, String fechaubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_corbata set frente_cantidad='" + cantidad + "',"+fechaubicacion+"  =  '"+dia()+"' where numero = '"+numeroordendebordadolocalorecibida+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
       
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordencorbataS.class.getName()).log(Level.SEVERE, null, ex);
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
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");

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
        
         String SQL2 = "select articulo,surtida,estatus_entrega from historial_ventas where numero = '" + numerodeventa + "' and articulo = '" + ubicacion + "' and identificador_prenda = '"+identificador+"'";
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
    
    
    
    
    
    
    
    
     void datosotrasucursal () throws FileNotFoundException, IOException
    {
        
        numeroordendebordadolocalorecibida = lborden.getText();
        prenda = "Corbata";
       
       
        
         String sql = "Select orden_o_pedido,fecha,hora,cliente,numero_venta,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,lugar,identificador_prenda,frente_puntadas,frente_nombre,frente_cantidad,identificador_prenda,numero_orden_o_pedido_solicitada from historial_ordenes_corbata_recibidas where numero = '" + numeroordendebordadolocalorecibida + "' and prenda = '" + prenda + "'";
     
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                
                
                tiendeordenopedido = rs.getString("orden_o_pedido");
                lbordenopedidorecibido.setText(tiendeordenopedido);
                
                cliente = rs.getString("cliente");
                lbcliente.setText(cliente);
                
                lbnumerodeventa.setText(rs.getString("numero_venta"));
                lbcantidad.setText(rs.getString("cantidad_bordados"));

                lbfechaelaboracion.setText(rs.getString("fecha"));
                lbhoraelaboracion.setText(rs.getString("hora"));
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));
            
                String observacion = rs.getString("observacion");
                
                if(observacion == null || observacion.equals("")||observacion.equals(" ") )
                {
                    
                }
                else
                {
                
                 
                tieneunaobservacion="si";    
                lbobservaciones.setText(observacion);
                
                }

                lbfrentepuntadas.setText(rs.getString("frente_puntadas"));
                
                
                frentenombre= rs.getString("frente_nombre");
                lbfrentenombre.setText(frentenombre);
                
                
                identificador =rs.getString("identificador_prenda"); 
                lbidentificador.setText(identificador);
                
                cantidad = rs.getString("cantidad"); 
                
                String frentecantidad = rs.getString("frente_cantidad");
                if(frentecantidad.equals("0"))
                {
                   btntermine.setEnabled(true);
                }
                else
                {
                    btntermine.setEnabled(false);
                }    
                
                
               

            
                lugar =rs.getString("lugar");

            }
                
                
                 identificador =  rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                
                
                lbnumerodelaotrasucursal.setText(rs.getString("numero_orden_o_pedido_solicitada"));
                
            
        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, ex);
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        
        
          
        String cliente = lbcliente.getText();
        
        
        
                tiendaconectada();   
             
            
                
              if (tiendaconectada.equals("si"))

                      {
                
                
                 try {
         
                     
                     
            
      

        String sql7 = "Select cliente,lugar,identificador_prenda from historial_ordenes_pantalon where numero = '" + numerosucursal + "' ";

        try {
            Statement st = cnsucursal.createStatement();
            ResultSet rs = st.executeQuery(sql7);
            if (rs.next()) {

                cliente = rs.getString("cliente");
                prenda = (rs.getString("prenda"));
               
                sucursal = rs.getString("lugar");
                lbsucursal.setText(sucursal);
                
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

        int nuevacantidadint = cantidadstringint - cantidadint;
        nuevacantidadstring =  String.valueOf(nuevacantidadint);
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + nuevacantidadstring + "' WHERE numero='" + numerodeventa + "' and articulo = '" + ubicacion + "'      ");
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
    
    
    
     
     void tiendaconectada()
 {
     
     
     
     try {
            
            
            Connection con = null;
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/tiendas", "root", "sistemas");

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
            Logger.getLogger(ordencorbataS.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
            
            }
        
        
        
        
        
        

     
 }
 
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    void sumapuntos()
    {
        
        
     
        double importefrente = 0.0;
     

        String costostring = "0";
       
        int cantidadint = Integer.parseInt(cantidad);
        Object cantidad = ""; 
        Object cantidadfrente = "";

        
            String sql = "Select cantidad,frente_cantidad from historial_ordenes_corbata where numero = '"+numeroordendebordadolocalorecibida+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cantidad = rs.getString("cantidad"); 
                cantidadfrente = rs.getString("frente_cantidad");

            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            
        
          if(cantidadfrente == null || cantidadfrente.equals("")|| cantidadfrente.equals(" "))
          {
              cantidadfrente = "0";
          }
            int cantidadfrenteint = Integer.parseInt(cantidadfrente.toString());

                // FRENTE
                double costopuntadafrente = 0.0;

                Object frenteobject = lbfrentepuntadas.getText();

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");
                    

                }

                String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadafrente);

                importefrente = cantidadint * costopuntadafrente;
                double sumabordados = importefrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                lbsumapuntos.setText(sumabordadosstring);

         
        
        
    }
    
    
    
    
    
    
    
    
    
    
    void actualizarestatusentregaordendebordado()
    {
         int tienecantidad = 0;
        int botonesactivados = 0;
        
         String sql = "Select frente,frente_cantidad from "+nombredelatabla+" where numero = '"+numeroordendebordadolocalorecibida+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                 
                
                String corbata = rs.getString("frente_puntadas");
                String cantidadubicacion1 = rs.getString("frente_cantidad");
               
                
                
                
                
               if(corbata==null || corbata.equals("")||corbata.equals(" ") || corbata.equals("ninguno"))
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                   
                   
                
                
                if(cantidadubicacion1==null || cantidadubicacion1.equals("")||cantidadubicacion1.equals(" "))
                {
                    
                //       lbcantidad1.setText("0");
                //    lbcantidad1.setForeground(Color.red.darker());
                    
                         cantidadubicacion1= "0";
                    
                }
                
                else
                    
                    
                {
                     tienecantidad = tienecantidad + 1; 
                   
                   
               //    lbcantidad1.setText(cantidad);
                //   lbcantidad1.setForeground(Color.GREEN.darker());
                    
                }
            
                }
                    
                
                
                    if(tienecantidad == botonesactivados)
           {
               
             nuevoestatusorden = "realizada totalmente";
              lbestatus.setForeground(Color.green.darker());
               
           }
         
           else
       
           {
               
               nuevoestatusorden = "generada";
            lbestatus.setForeground(Color.red.darker());
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
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        lbprenda = new javax.swing.JLabel();
        lborden = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        lbnumerodeventa = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbfechaentrega = new javax.swing.JLabel();
        lbhoraentrega = new javax.swing.JLabel();
        lbfechaelaboracion = new javax.swing.JLabel();
        lbhoraelaboracion = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbestatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbfotomontaje = new javax.swing.JLabel();
        lbnombrecomercial = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btntermine = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        btnverfotomontaje = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        lbbordacliente = new javax.swing.JLabel();
        btneditarbordado = new javax.swing.JButton();
        lbidentificador = new javax.swing.JLabel();
        lbcolor = new javax.swing.JLabel();
        lbcodigo = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnvercolorido = new javax.swing.JButton();
        btnfotomontajesinpuntadas = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnfrenteponchado = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        btnterminetodo = new javax.swing.JButton();
        lbprenda1 = new javax.swing.JLabel();
        lbprenda2 = new javax.swing.JLabel();
        lbprenda3 = new javax.swing.JLabel();
        lbprenda4 = new javax.swing.JLabel();
        lbfrentenombre = new javax.swing.JLabel();
        lbfrentepuntadas = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbnumerodelaotrasucursal = new javax.swing.JLabel();
        lbsucursal = new javax.swing.JLabel();
        lbautorizacion = new javax.swing.JLabel();
        lbnumeroordenopedidosolicitado = new javax.swing.JLabel();
        lbprenda5 = new javax.swing.JLabel();
        btndatos = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        lbordenopedidorecibido = new javax.swing.JLabel();
        btncargarponchado1 = new javax.swing.JButton();
        btnpechoizquierdoponchado1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        lbsumapuntos1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden corbata");
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Fecha Entrega");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda.setText("Corbata");
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lborden.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Cantidad:");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumerodeventa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnumerodeventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("Numero de Venta");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad.setText("0");
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Hora Entrega");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfechaentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfechaentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhoraentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfechaelaboracion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfechaelaboracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhoraelaboracion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhoraelaboracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Estatus");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbestatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbestatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);
        jPanel1.add(lbfotomontaje);
        lbfotomontaje.setBounds(10, 10, 1090, 620);

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Nombre Comercial");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Total de Puntos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Bordacliente");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btneditarbordado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneditarbordado.setText("Editar bordado");
        btneditarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarbordadoActionPerformed(evt);
            }
        });

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbidentificador.setForeground(new java.awt.Color(0, 0, 153));
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcodigo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Numero de orden");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Frente");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnfrenteponchado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnfrenteponchado.setText("Ponchado");
        btnfrenteponchado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnfrenteponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrenteponchadoActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btncancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                btncancelarMouseReleased(evt);
            }
        });
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Observacion:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jScrollPane6.setBackground(new java.awt.Color(0, 0, 0));

        lbobservaciones.setEditable(false);
        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        btnterminetodo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnterminetodo.setText("Termine todo");
        btnterminetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterminetodoActionPerformed(evt);
            }
        });

        lbprenda1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda1.setText("Sucursal");
        lbprenda1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda2.setText("Orden o pedido solicitado");
        lbprenda2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda3.setText("Identificador");
        lbprenda3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda4.setText("Prenda");
        lbprenda4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfrentenombre.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbfrentenombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfrentepuntadas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbfrentepuntadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumerodelaotrasucursal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnumerodelaotrasucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsucursal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbautorizacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbautorizacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroordenopedidosolicitado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumeroordenopedidosolicitado.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda5.setText("Numero orden bordado solicitada");
        lbprenda5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndatos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btndatos.setText("Datos");
        btndatos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Tiene orden o pedido recibido?");
        jLabel29.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbordenopedidorecibido.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbordenopedidorecibido.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btncargarponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncargarponchado1.setText("Cargar Ponchado");
        btncargarponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarponchado1ActionPerformed(evt);
            }
        });

        btnpechoizquierdoponchado1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnpechoizquierdoponchado1.setText("Replicar");
        btnpechoizquierdoponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdoponchado1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Puntos");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos1.setForeground(new java.awt.Color(0, 0, 153));
        lbsumapuntos1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addGap(12, 12, 12)
                        .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel16)
                        .addGap(7, 7, 7)
                        .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jLabel25)
                        .addGap(7, 7, 7)
                        .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1097, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(166, 166, 166)
                                .addComponent(btnfotomontajesinpuntadas))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbprenda2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbprenda3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addGap(28, 28, 28)
                                        .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(jLabel14)
                                        .addGap(12, 12, 12)
                                        .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(147, 147, 147))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(18, 18, 18)
                                        .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbhoraelaboracion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbfechaelaboracion, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(lbprenda4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbprenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbprenda5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(3, 3, 3)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel23)
                                .addGap(12, 12, 12)
                                .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbfrentenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbfrentepuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btntermine, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(lbcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbcolor, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)
                                .addComponent(btncargarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(btnpechoizquierdoponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnfrenteponchado, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbsumapuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneditarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnfotomontajesinpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbprenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumeroordenopedidosolicitado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbprenda1, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                    .addComponent(lbsucursal, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                                .addComponent(lbprenda5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbnumerodelaotrasucursal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnumerodeventa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbprenda4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbprenda3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbhoraelaboracion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfechaelaboracion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbordenopedidorecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbestatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbautorizacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncargarponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnpechoizquierdoponchado1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(lbfrentenombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(lbfrentepuntadas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(lbcantidad1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(btntermine, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(btncancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(lbcodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(lbcolor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                                .addComponent(btnfrenteponchado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsumapuntos1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
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

        ventanaordencorbataanteriores = false;
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      
        
        ventanaordencorbataanteriores = false;
        this.dispose();
        
        
    }//GEN-LAST:event_formWindowClosing
   

   

    
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      
        
        datos();
        
  
        
    }//GEN-LAST:event_formWindowOpened

    private void btntermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermineActionPerformed
       
        
        
        if(lugar.equals("Esta sucursal"))
        {
      
            String ubicacion = "frente_cantidad";
            fechaubicacion = "frente_fecha";
        
           insertarlacantidadylafechaenlaubicacion((String) ubicacion, (String) fechaubicacion); 
           
           
            cantidadaplicacion = "0";
            descripcion = "BORDADO CORBATA FRENTE "+frentenombre+ "";
            aplicacioninsertar = "";
       
            agregaralsurtidasalhistorialdeventasyactualizarestatusentrega((String) descripcion, (String) cantidad, (String) aplicacioninsertar);
            actualizarestatusentregaordendebordado();
            sumapuntos();
            
             if(ordenesporrealizar.ventanaordenesporrealizar==true)
        {
            ordenesporrealizar.btnactualizar.doClick();
        }
        
      
            
        }
        else
        {
            
        }
       
        try {
            datostiendalocal();
        } catch (IOException ex) {
            Logger.getLogger(ordencorbataS.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE AGREGÓ CORRECTAMENTE");
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_btntermineActionPerformed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed

      
        
        
        
        
        if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
   
         verfotomontajetiendalocal();
       
      
        
    }
        
        
        
        
    else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
       
        
        
            verfotomontajetiendalocal();
            
    }
        
        
        
        
        
    }//GEN-LAST:event_btnverfotomontajeActionPerformed

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

    private void btnfotomontajesinpuntadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfotomontajesinpuntadasActionPerformed

        
       /* 
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
        
        */
    }//GEN-LAST:event_btnfotomontajesinpuntadasActionPerformed

    private void btnfrenteponchadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrenteponchadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnfrenteponchadoActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed

        
            String autorizado = lbautorizacion.getText();
        if (autorizado.equals("si"))     
        {
            
            
        
    
            
        
                    String ubicacion = "frente_cantidad";
                    String fecha = "frente_fecha";
                    eliminardelaordendebordadoslacantidaddelaubicacionylafechadelaubicacion((String) ubicacion, (String) fecha);
                    
                    
                    
                     descripcion = "BORDADO CORBATA FRENTE " +frentenombre+ "";
                    
                    
                    agregaralsurtidasalhistorialdeventasyactualizarestatusentregaCancelar((String) descripcion, (String) cantidad, (String) aplicacioninsertar);
                    actualizarestatusentregaordendebordado();
                    sumapuntos();
                    
                    
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">El "+descripcion+" SE CANCELO CORRECTAMENTE");
                    
                    
                    
                    
                  if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
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
            autorizacion.lbinterfaz.setText("corbatacancelar");
            autorizacion.lbnivel.setText("2");

        }
        }    
                    
        
        
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnterminetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterminetodoActionPerformed

        terminetodo = "si";


        if (btntermine.isEnabled())
            
        {
            btntermine.doClick();
            btnterminetodo.setEnabled(false);
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Orden terminada completamente");
        }
        
      

        if(ordenesporrealizar.ventanaordenesporrealizar==true)
        {
            ordenesporrealizar.btnactualizar.doClick();
        }
 
        
        
        
    }//GEN-LAST:event_btnterminetodoActionPerformed

    private void btntermineMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btntermineMouseReleased
               
                if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btnactualizar.doClick();
         }
        
        
                datos();
                
                
                
                
    }//GEN-LAST:event_btntermineMouseReleased

    private void btncancelarMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btncancelarMouseReleased
             
           
                
                
    }//GEN-LAST:event_btncancelarMouseReleased

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed
      
        datos();
        
        
    }//GEN-LAST:event_btndatosActionPerformed

    private void btncargarponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btncargarponchado1ActionPerformed

    private void btnpechoizquierdoponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdoponchado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnpechoizquierdoponchado1ActionPerformed

    ResultSet rs;
    ResultSet rs2;

    public static void main(String args[]) {
       
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordencorbataS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btncancelar;
    private javax.swing.JButton btncargarponchado1;
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneditarbordado;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    private javax.swing.JButton btnfrenteponchado;
    private javax.swing.JButton btnpechoizquierdoponchado1;
    private javax.swing.JButton btntermine;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JLabel lbautorizacion;
    public static javax.swing.JLabel lbbordacliente;
    public static javax.swing.JLabel lbcantidad;
    public javax.swing.JLabel lbcantidad1;
    public static javax.swing.JLabel lbcliente;
    public javax.swing.JLabel lbcodigo;
    public javax.swing.JLabel lbcolor;
    public static javax.swing.JLabel lbestatus;
    public static javax.swing.JLabel lbfechaelaboracion;
    public static javax.swing.JLabel lbfechaentrega;
    private javax.swing.JLabel lbfotomontaje;
    public javax.swing.JLabel lbfrentenombre;
    public static javax.swing.JLabel lbfrentepuntadas;
    public static javax.swing.JLabel lbhoraelaboracion;
    public static javax.swing.JLabel lbhoraentrega;
    private javax.swing.JLabel lbidentificador;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumerodelaotrasucursal;
    public static javax.swing.JLabel lbnumerodeventa;
    public static javax.swing.JLabel lbnumeroordenopedidosolicitado;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    public static javax.swing.JLabel lbordenopedidorecibido;
    private javax.swing.JLabel lbprenda;
    private javax.swing.JLabel lbprenda1;
    private javax.swing.JLabel lbprenda2;
    private javax.swing.JLabel lbprenda3;
    private javax.swing.JLabel lbprenda4;
    private javax.swing.JLabel lbprenda5;
    public static javax.swing.JLabel lbsucursal;
    public javax.swing.JLabel lbsumapuntos;
    public javax.swing.JLabel lbsumapuntos1;
    // End of variables declaration//GEN-END:variables

    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();


}
