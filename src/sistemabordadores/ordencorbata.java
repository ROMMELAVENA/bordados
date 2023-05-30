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
import static sistemabordadores.ordencamisa.lborden;

public class ordencorbata extends javax.swing.JFrame {

    public static boolean ventanaordencorbataanteriores = false;
    public static String ordenbordadocorbata = "";

    String cantidadprendasstring = "";
    int cantidadprendasint = 0;

    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;

    String primero = "";
    String ultimo = "";
    String lugar = "";
    
    String prenda = "";
     String iptraspaso = "";
      String numerosucursal = "";
  
    String latiendaestaconectada = "si";
    Connection con = null;
    
     String numerodeorden = "";
    

    String frentenombre = "";
  
    String ubicacioninsertar ="";
    String aplicacioninsertar = "";
    String cantidadbordados = "";
    String codigocliente ="";
    String tienefotomontaje ="";
    String rutaimagen ="";
 
    private PreparedStatement pst;
    String identificador = "";
    String consecutivo = "";
    String tieneunaobservacion = ""; 
    
    String sucursal = "";
    
    

    public ordencorbata() {
        initComponents();
        ventanaordencorbataanteriores = true;
        lbcantidad.setText("0");
        
      btnfrentecancelar.setEnabled(false);
       

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
    
    
    void datosOrdenesLocales() throws IOException {

        lbtitulofrente.setText("");

        String folio = lborden.getText();

        String sql = "Select fecha,hora,cliente,numero_venta,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,lugar,identificador_prenda,frente,frente_puntadas,cantidad_frente from historial_ordenes_corbata where numero = '" + folio + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));
                lbnumeroventa.setText(rs.getString("numero_venta"));
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

                lbfrente.setText(rs.getString("frente"));
                frentenombre= rs.getString("frente");
                identificador =rs.getString("identificador_prenda"); 
                lbidentificador.setText(identificador);
                
                cantidadbordados = rs.getString("cantidad"); 
                
                String frentecantidad = rs.getString("cantidad_frente");
                if(frentecantidad.equals("0"))
                {
                   btnfrente.setEnabled(true);
                }
                else
                {
                    btnfrente.setEnabled(false);
                }    
                
                
                if (frentenombre == null || frentenombre.equals("")) 
                {

                } else {

                    lbtitulofrente.setText(frentenombre);
                    lbfrentepuntadas.setText(rs.getString("frente_puntadas"));

                }

                lblugar.setText(rs.getString("lugar"));
                lugar =rs.getString("lugar");

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        String sql3 = "SELECT nombre_comercial,codigo_cliente from historial_ventas where numero = '"+lbnumeroventa.getText()+"'  ";

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


        agregarfotomontaje();
        
        
        
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
              
             
                
                
                consecutivo = rs1.getString("numero_consecutivo");
                
                if(codigo1.equals("ninguno"))
                {
                  lbcolorfrente.setVisible(false);  
                  lbcodigofrente.setVisible(false); 
                }
                else
                {
                  lbcolorfrente.setText(codigo1.toString());
                  lbcodigofrente.setText(hilo1.toString());
                }  
                
               
                
                    
                
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
    }
    
    
    
    
    
    
    void agregarfotomontaje() throws FileNotFoundException, IOException  
    {
        
        String folio = lborden.getText();
        String numeroventa = lbnumeroventa.getText();
        BufferedImage img = null;
        
      
        btnverfotomontaje.setEnabled(false);

       String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and identificador_prenda= '"+identificador+"' and tipo = 'CORBATA'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
            {
                
                Blob blob = rs.getBlob("imagen");
                if (blob == null) 
                {

                    ordencorbataimagen p = new ordencorbataimagen();
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
          
            lbtitulofrente.setVisible(false);
            lbfrente.setVisible(false);
            lbfrentepuntadas.setVisible(false);

        }
        else
        {
            btnfrente.setEnabled(false);
            ordencorbataimagen p = new ordencorbataimagen();
            jPanel1.add(p);
            jPanel1.repaint();
            lbfotomontaje.setVisible(false);
            btnverfotomontaje.setEnabled(false);
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
            
           
            
        }  

        
        
    }

   

  
    void actualizarlascantidadesbordadas(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_corbata set cantidad_frente='" + lbcantidad.getText() + "',fecha='"+dia()+"'  where numero = '"+lborden.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+ubicacionsinguiones+" actualizada correctamente ");
        
        
       
        try {
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordencorbata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    
    void agregarexistenciabordados(String ubicacioninsertar,String aplicacioninsertar,String cantidadaplicacion)
    {
        
       
        
        //// bordado
        String InsertarSQL = "INSERT INTO historial_bordados_existencia(numero,dia,hora,articulo,concepto,cantidad) VALUES (?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            
                
 
                pst.setString(1, lbnumeroventa.getText());
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, ubicacioninsertar);
                pst.setString(5, identificador);
                pst.setString(6, lbcantidad.getText());
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
               
               String Insertaraplicacion = "INSERT INTO historial_bordados_existencia(numero,dia,hora,articulo,concepto,cantidad) VALUES (?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(Insertaraplicacion);
            
                
 
                pst.setString(1, lbnumeroventa.getText());
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, aplicacioninsertar);
                pst.setString(5, identificador);
                pst.setString(6, String.valueOf(totalaplicaciones));
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
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
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");

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
    
    
    
    
    
    
    
    
     void datosotrasucursal () throws FileNotFoundException, IOException
    {
        
        numerodeorden = lborden.getText();
        prenda = "Corbata";
       
       



        String activadoladoizquierdofrente = "";
        String activadoladoizquierdoatras = "";
        String activadoladoderechofrente = "";
        String activadoladoderechoatras = "";

        
         String sql = "Select fecha,hora,cliente,numero_venta,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,lugar,identificador_prenda,frente,frente_puntadas,cantidad_frente,identificador_prenda from historial_ordenes_corbata where numero = '" + numerodeorden + "' and prenda = '" + prenda + "'";
     
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                
                
                
                 lbcliente.setText(rs.getString("cliente"));
                lbnumeroventa.setText(rs.getString("numero_venta"));
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

                lbfrente.setText(rs.getString("frente"));
                frentenombre= rs.getString("frente");
                identificador =rs.getString("identificador_prenda"); 
                lbidentificador.setText(identificador);
                
                cantidadbordados = rs.getString("cantidad"); 
                
                String frentecantidad = rs.getString("cantidad_frente");
                if(frentecantidad.equals("0"))
                {
                   btnfrente.setEnabled(true);
                }
                else
                {
                    btnfrente.setEnabled(false);
                }    
                
                
                if (frentenombre == null || frentenombre.equals("")) 
                {

                } else {

                    lbtitulofrente.setText(frentenombre);
                    lbfrentepuntadas.setText(rs.getString("frente_puntadas"));

                }

                lblugar.setText(rs.getString("lugar"));
                lugar =rs.getString("lugar");

            }
                
                
                 identificador =  rs.getString("identificador_prenda");
                lbidentificador.setText(identificador);
                
                
            
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
       
         
            con = DriverManager.getConnection("jdbc:mysql://" + iptraspaso + "/" + sucursal + "", "root", "sistemas");
      

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
 
    
     
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    void sumapuntos()
    {
        
        
        double importeladoizquierdo = 0.0;
        double importeladoderecho = 0.0;
        double importefrente = 0.0;
        double importeatras = 0.0;

        String costostring = "0";
        Object cantidadobject = lbcantidad.getText();
        int cantidadint = Integer.parseInt(cantidadobject.toString());
        Object cantidad = ""; 
        Object cantidadfrente = "";

        
            String sql = "Select cantidad,cantidad_frente from historial_ordenes_corbata where numero = '"+lborden.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cantidad = rs.getString("cantidad"); 
                cantidadfrente = rs.getString("cantidad_frente");

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
    
    void estacompletalaorden()
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_corbata set estatus_orden='realizada',fecha='"+dia()+"' where numero='" + lborden.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbprenda = new javax.swing.JLabel();
        lborden = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        lbnumeroventa = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbfechaentrega = new javax.swing.JLabel();
        lbhoraentrega = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbfechaelaboracion = new javax.swing.JLabel();
        lbhoraelaboracion = new javax.swing.JLabel();
        lblugar = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        lbestatus = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbtitulofrente = new javax.swing.JLabel();
        lbfrente = new javax.swing.JLabel();
        lbfrentepuntadas = new javax.swing.JLabel();
        lbfotomontaje = new javax.swing.JLabel();
        lbnombrecomercial = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbautorizado = new javax.swing.JLabel();
        btnfrente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        btnverfotomontaje = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        lbbordacliente = new javax.swing.JLabel();
        btneditarbordado = new javax.swing.JButton();
        lbidentificador = new javax.swing.JLabel();
        lbcolorfrente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbcodigofrente = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        btnvercolorido = new javax.swing.JButton();
        btnfotomontajesinpuntadas = new javax.swing.JButton();
        lbpuntdas = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnfrenteponchado = new javax.swing.JButton();
        btnfrentecancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden corbata");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        jScrollPane6.setBackground(new java.awt.Color(0, 0, 0));

        lbobservaciones.setEditable(false);
        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        getContentPane().add(jScrollPane6);
        jScrollPane6.setBounds(1338, 85, 537, 114);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Observacion:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6);
        jLabel6.setBounds(1338, 47, 94, 30);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Fecha Entrega");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel12);
        jLabel12.setBounds(487, 845, 103, 30);

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda.setText("Corbata");
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbprenda);
        lbprenda.setBounds(12, 47, 105, 30);

        lborden.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lborden.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lborden);
        lborden.setBounds(122, 845, 116, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setText("Cliente:");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel16);
        jLabel16.setBounds(440, 13, 56, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1780, 13, 95, 30);

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel24.setText("Cantidad:");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel24);
        jLabel24.setBounds(637, 48, 95, 30);

        lbnumeroventa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbnumeroventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbnumeroventa);
        lbnumeroventa.setBounds(355, 845, 125, 30);

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel26.setText("No. de Venta");
        jLabel26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel26);
        jLabel26.setBounds(245, 845, 98, 30);

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcantidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad.setText("0");
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbcantidad);
        lbcantidad.setBounds(744, 48, 53, 30);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Hora Entrega");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel14);
        jLabel14.setBounds(748, 845, 97, 30);

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbcliente);
        lbcliente.setBounds(503, 13, 629, 30);

        lbfechaentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfechaentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbfechaentrega);
        lbfechaentrega.setBounds(597, 845, 139, 30);

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhoraentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbhoraentrega);
        lbhoraentrega.setBounds(852, 845, 127, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Fecha de elaboración");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel18);
        jLabel18.setBounds(991, 845, 162, 30);

        lbfechaelaboracion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfechaelaboracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbfechaelaboracion);
        lbfechaelaboracion.setBounds(1160, 845, 122, 30);

        lbhoraelaboracion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhoraelaboracion.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbhoraelaboracion);
        lbhoraelaboracion.setBounds(1289, 845, 144, 30);

        lblugar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblugar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lblugar);
        lblugar.setBounds(1451, 950, 133, 30);

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setText("Estatus");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel23);
        jLabel23.setBounds(1348, 587, 56, 30);

        lbestatus.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbestatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbestatus);
        lbestatus.setBounds(1416, 587, 335, 30);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);

        lbtitulofrente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(lbtitulofrente);
        lbtitulofrente.setBounds(500, 120, 360, 20);

        lbfrente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(lbfrente);
        lbfrente.setBounds(500, 150, 360, 20);

        lbfrentepuntadas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(lbfrentepuntadas);
        lbfrentepuntadas.setBounds(500, 180, 360, 20);
        jPanel1.add(lbfotomontaje);
        lbfotomontaje.setBounds(10, 10, 1280, 600);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(12, 123, 1197, 715);

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbnombrecomercial);
        lbnombrecomercial.setBounds(1277, 13, 351, 30);

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel25.setText("Nombre Comercial");
        jLabel25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel25);
        jLabel25.setBounds(1139, 13, 131, 30);

        lbautorizado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbautorizado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbautorizado);
        lbautorizado.setBounds(1160, 882, 77, 30);

        btnfrente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnfrente.setText("Termine");
        btnfrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnfrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrenteActionPerformed(evt);
            }
        });
        getContentPane().add(btnfrente);
        btnfrente.setBounds(1340, 250, 100, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Frente");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1240, 330, 80, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Color");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel2);
        jLabel2.setBounds(1770, 210, 100, 30);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Puntos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1350, 480, 152, 30);

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbsumapuntos);
        lbsumapuntos.setBounds(1520, 480, 154, 30);

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });
        getContentPane().add(btnverfotomontaje);
        btnverfotomontaje.setBounds(12, 86, 151, 30);

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel27.setText("Bordacliente");
        jLabel27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel27);
        jLabel27.setBounds(12, 13, 90, 30);

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbbordacliente);
        lbbordacliente.setBounds(114, 13, 319, 30);

        btneditarbordado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneditarbordado.setText("Editar bordado");
        btneditarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarbordadoActionPerformed(evt);
            }
        });
        getContentPane().add(btneditarbordado);
        btneditarbordado.setBounds(1633, 13, 140, 30);

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbidentificador.setForeground(new java.awt.Color(153, 0, 0));
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbidentificador);
        lbidentificador.setBounds(124, 47, 506, 30);

        lbcolorfrente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolorfrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbcolorfrente);
        lbcolorfrente.setBounds(1770, 250, 100, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Codigo");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1660, 210, 100, 30);

        lbcodigofrente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcodigofrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbcodigofrente);
        lbcodigofrente.setBounds(1660, 250, 80, 30);

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("No. de orden");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel28);
        jLabel28.setBounds(12, 845, 98, 30);

        btnvercolorido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnvercolorido.setText("Ver colorido");
        btnvercolorido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvercoloridoActionPerformed(evt);
            }
        });
        getContentPane().add(btnvercolorido);
        btnvercolorido.setBounds(170, 86, 151, 30);

        btnfotomontajesinpuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnfotomontajesinpuntadas.setText("Fotomontaje sin puntadas");
        btnfotomontajesinpuntadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfotomontajesinpuntadasActionPerformed(evt);
            }
        });
        getContentPane().add(btnfotomontajesinpuntadas);
        btnfotomontajesinpuntadas.setBounds(333, 86, 195, 30);

        lbpuntdas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbpuntdas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbpuntdas);
        lbpuntdas.setBounds(1330, 330, 260, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Ubicación");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1338, 212, 80, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Frente");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1240, 250, 80, 30);

        btnfrenteponchado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnfrenteponchado.setText("Ponchado");
        btnfrenteponchado.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnfrenteponchado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrenteponchadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnfrenteponchado);
        btnfrenteponchado.setBounds(1610, 330, 100, 30);

        btnfrentecancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnfrentecancelar.setText("Cancelar");
        btnfrentecancelar.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btnfrentecancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrentecancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnfrentecancelar);
        btnfrentecancelar.setBounds(1470, 250, 100, 30);

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
        try {     
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordencorbata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        cliente();
        sumapuntos();       
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

        
    }//GEN-LAST:event_formWindowOpened

    private void btnfrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrenteActionPerformed
       if(lugar.equals("Esta sucursal"))
        {
           String ubicacion = "cantidad_frente";
            actualizarlascantidadesbordadas((String) ubicacion); 
            String cantidad = cantidadbordados;
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO CORBATA FRENTE "+frentenombre+ "";
            aplicacioninsertar = "";
            agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
            estacompletalaorden();
            sumapuntos();
            
             if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
        {
            ordenesporrealizar.btnactualizar.doClick();
        }
        
      
            
        }
        else
        {
            
        }
       
        try {
            datosOrdenesLocales();
        } catch (IOException ex) {
            Logger.getLogger(ordencorbata.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.dispose();
    }//GEN-LAST:event_btnfrenteActionPerformed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed

        String cliente = lbcliente.getText();
       
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

    private void btnfrentecancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrentecancelarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnfrentecancelarActionPerformed

    ResultSet rs;
    ResultSet rs2;

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
            java.util.logging.Logger.getLogger(ordencorbata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordencorbata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordencorbata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordencorbata.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ordencorbata().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btneditarbordado;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    private javax.swing.JButton btnfrente;
    private javax.swing.JButton btnfrentecancelar;
    private javax.swing.JButton btnfrenteponchado;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JLabel lbautorizado;
    public static javax.swing.JLabel lbbordacliente;
    public static javax.swing.JLabel lbcantidad;
    public static javax.swing.JLabel lbcliente;
    public javax.swing.JLabel lbcodigofrente;
    public javax.swing.JLabel lbcolorfrente;
    public static javax.swing.JLabel lbestatus;
    public static javax.swing.JLabel lbfechaelaboracion;
    public static javax.swing.JLabel lbfechaentrega;
    private javax.swing.JLabel lbfotomontaje;
    public static javax.swing.JLabel lbfrente;
    public static javax.swing.JLabel lbfrentepuntadas;
    public static javax.swing.JLabel lbhoraelaboracion;
    public static javax.swing.JLabel lbhoraentrega;
    private javax.swing.JLabel lbidentificador;
    public static javax.swing.JLabel lblugar;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    private javax.swing.JLabel lbprenda;
    public javax.swing.JLabel lbpuntdas;
    public javax.swing.JLabel lbsumapuntos;
    private javax.swing.JLabel lbtitulofrente;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();


}
