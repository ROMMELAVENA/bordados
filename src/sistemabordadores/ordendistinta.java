package sistemabordadores;
import java.applet.AudioClip;
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
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class ordendistinta extends javax.swing.JFrame {

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
    
    
    ///// para insertar
    
    String ubicacioninsertar = ""; 
    String aplicacioninsertar = "";
    
    
    String distinta1 = "ninguno";
    String distinta2 = "ninguno";
    String distinta3 = "ninguno";
    String distinta4 = "ninguno";
    String distinta5 = "ninguno";
    String distinta6 = "ninguno";
    String distinta7 = "ninguno";
    
    
    String distinta1nombre = "ninguno";
    String distinta2nombre = "ninguno";
    String distinta3nombre = "ninguno";
    String distinta4nombre = "ninguno";
    String distinta5nombre = "ninguno";
    String distinta6nombre = "ninguno";
    String distinta7nombre = "ninguno";
    
    String distinta1aplicacion = "ninguno";
    String distinta2aplicacion = "ninguno";
    String distinta3aplicacion = "ninguno";
    String distinta4aplicacion = "ninguno"; 
    String distinta5aplicacion = "ninguno";
    String distinta6aplicacion = "ninguno";
    String distinta7aplicacion = "ninguno";
    
    String distinta1ubicacion = "ninguno";
    String distinta2ubicacion = "ninguno";
    String distinta3ubicacion = "ninguno";
    String distinta4ubicacion = "ninguno"; 
    String distinta5ubicacion = "ninguno";
    String distinta6ubicacion = "ninguno";
    String distinta7ubicacion = "ninguno";
    
    String distinta1cantidad = "0";
    String distinta2cantidad = "0";
    String distinta3cantidad = "0";
    String distinta4cantidad = "0"; 
    String distinta5cantidad = "0";
    String distinta6cantidad = "0";
    String distinta7cantidad = "0";
    
    String tipoprenda = "";
    String estatusorden = "";

    
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
    String tienefotomontaje = "";
    String tieneunaobservacion = "";
    
    ArrayList<String> listabotones = new ArrayList<String>();

    

    public ordendistinta() {
        initComponents();
        ventanaordencamisaanteriores = true;

        lbnumeroventa.setVisible(false);       
        lbtipo.setVisible(false);
        lbnombreconcepto.setVisible(false);
        lbtitulo.setVisible(false);
        btneliminar.setVisible(false);
        
        
       btnterminetodo.setEnabled(false);
       
        
        
    BufferedImage image = null;
    try 
    {
        image = ImageIO.read(new File("C:\\sistema\\tallas.png"));

    } catch (Exception e) 
    {
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
        
    }

    void datos() throws IOException {

        String folio = lbfolio.getText();
        
        cancelar1.setVisible(false);
        cancelar2.setVisible(false);
        cancelar3.setVisible(false);
        cancelar4.setVisible(false);
        cancelar5.setVisible(false);
        cancelar6.setVisible(false);
        cancelar7.setVisible(false);
        
        String botonhabilitado1 = "si";
        String botonhabilitado2 = "si";
        String botonhabilitado3 = "si";
        String botonhabilitado4 = "si";
        String botonhabilitado5 = "si";
        String botonhabilitado6 = "si";
        String botonhabilitado7 = "si";
        
        
        datostienda();

        String sql = "Select codigo,tipo,estatus_orden,numero,numero_venta,fecha,hora,cliente,tipo,nombre_concepto,estatus_orden,estatus_entrega,articulo,cantidad,prenda,cantidad_bordados,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,\n" +
"	   distinta1,distinta1_ubicacion,distinta1_nombre,distinta1_cantidad,distinta1_aplicacion,distinta1_aplicacion_color,\n" +
"	   distinta2,distinta2_ubicacion,distinta2_nombre,distinta2_cantidad,distinta2_aplicacion,distinta2_aplicacion_color, \n" +
"	   distinta3,distinta3_ubicacion,distinta3_nombre,distinta3_cantidad,distinta3_aplicacion,distinta3_aplicacion_color, \n" +
"	   distinta4,distinta4_ubicacion,distinta4_nombre,distinta4_cantidad,distinta4_aplicacion,distinta4_aplicacion_color, \n" +
"	   distinta5,distinta5_ubicacion,distinta5_nombre,distinta5_cantidad,distinta5_aplicacion,distinta5_aplicacion_color,\n" +
"	   distinta6,distinta6_ubicacion,distinta6_nombre,distinta6_cantidad,distinta6_aplicacion,distinta6_aplicacion_color,\n" +
"	   distinta7,distinta7_ubicacion,distinta7_nombre,distinta7_cantidad,distinta7_aplicacion,distinta7_aplicacion_color,\n" +
"	   lugar,fotomontaje_autorizado from historial_ordenes_distinta where numero = '"+folio+"'  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
            {

                lbcliente.setText(rs.getString("cliente"));
                lbprenda.setText(rs.getString("prenda"));
                prenda = (rs.getString("prenda"));
                lbfecha.setText(rs.getString("fecha"));

                
                tipoprenda = rs.getString("tipo");
                estatusorden = rs.getString("estatus_orden");
                
                String observacion = rs.getString("observacion");
                
                if(observacion == null || observacion.equals("")||observacion.equals(" ") )
                {
                    
                }
                else
                {
                
                 
                tieneunaobservacion="si";    
                lbobservaciones.setText(observacion);
                
                }
                
                
                
                distinta1cantidad =rs.getString("distinta1_cantidad");
                distinta2cantidad =rs.getString("distinta2_cantidad");         
                distinta3cantidad =rs.getString("distinta3_cantidad"); 
                distinta4cantidad =rs.getString("distinta4_cantidad");
                distinta5cantidad =rs.getString("distinta5_cantidad");
                distinta6cantidad =rs.getString("distinta6_cantidad");
                distinta7cantidad =rs.getString("distinta7_cantidad");
               
                
                distinta1nombre = rs.getString("distinta1_nombre");
                distinta1ubicacion = rs.getString("distinta1_ubicacion");
                distinta1 = rs.getString("distinta1");
                lbdistinta1nombre.setText(distinta1nombre);
                lbdistinta1.setText(distinta1);
              
                if (distinta1 == null || distinta1.equals("")||distinta1.equals(" ")) 
                {

                   
                    botonhabilitado1 = "no";
                    

                }
                  

                
                
                distinta2nombre = rs.getString("distinta2_nombre");
                distinta2= rs.getString("distinta2");
                lbdistinta2nombre.setText(distinta2nombre);
                lbdistinta2.setText(distinta2);
                if (distinta2 == null | distinta2.equals("")) 
                {

                   
                    botonhabilitado2 = "no";

                }

                distinta3nombre = rs.getString("distinta3_nombre");
                distinta3 = rs.getString("distinta3");
                lbdistinta3nombre.setText(distinta3nombre);
                lbdistinta3.setText(distinta3);
                if (distinta3 == null | distinta3.equals("")) {

                   
                    botonhabilitado3 = "no";

                }

                distinta4nombre = rs.getString("distinta4_nombre");
                distinta4 = rs.getString("distinta4");
                lbdistinta4nombre.setText(distinta4nombre);
                lbdistinta4.setText(distinta4);
                if (distinta4 == null | distinta4.equals("")) 
                {

                   
                    botonhabilitado4 = "no";
                    
                }

                distinta5nombre = rs.getString("distinta5_nombre");
                distinta5 = rs.getString("distinta5");
                lbdistinta5nombre.setText(distinta5nombre);
                lbdistinta5.setText(distinta5);
                if (distinta5 == null | distinta5.equals("")) 
                {
                   
                    botonhabilitado5 = "no";

                }


                distinta6nombre = rs.getString("distinta6_nombre");
                distinta6 = rs.getString("distinta6");
                lbdistinta6nombre.setText(distinta6nombre);
                lbdistinta6.setText(distinta6);
                if (distinta6 == null | distinta6.equals("")) {

                  
                    botonhabilitado6 = "no";

                }

                distinta7nombre = rs.getString("distinta7_nombre");
                distinta7 = rs.getString("distinta7");
                lbdistinta7nombre.setText(distinta7nombre);
                lbdistinta7.setText(distinta7);
            
                if (distinta7 == null | distinta7.equals("")) {

                   
                    botonhabilitado7 = "no";
                    

                }
                
                
               distinta1aplicacion = rs.getString("distinta1_aplicacion");

                if (distinta1aplicacion.equals("ninguno")) {
                    distinta1aplicacion = "";
                }

                 distinta2aplicacion = rs.getString("distinta2_aplicacion");

                if (distinta2aplicacion.equals("ninguno")) {
                    distinta2aplicacion = "";
                }

                 distinta3aplicacion = rs.getString("distinta3_aplicacion");

                if (distinta3aplicacion.equals("ninguno")) {
                    distinta3aplicacion = "";
                }

                 distinta4aplicacion = rs.getString("distinta4_aplicacion");

                if (distinta4aplicacion.equals("ninguno")) {
                    distinta4aplicacion = "";
                }

                distinta5aplicacion = rs.getString("distinta5_aplicacion");

                if (distinta5aplicacion.equals("ninguno")) {
                    distinta5aplicacion = "";
                }

                
                  distinta6aplicacion = rs.getString("distinta6_aplicacion");

                if (distinta6aplicacion.equals("ninguno")) {
                    distinta6aplicacion = "";
                }

                
                distinta7aplicacion = rs.getString("distinta7_aplicacion");

                if (distinta7aplicacion.equals("ninguno")) {
                    distinta7aplicacion = "";
                } 

                
                lbcantidad.setText(rs.getString("cantidad"));
                String nombreconcepto = rs.getString("nombre_concepto");
                lbnombreconcepto.setText(nombreconcepto);  
                lugardondesebordara = rs.getString("lugar");
                
                
                
                
                if(lugardondesebordara.equals("Esta sucursal"))
                {
                
                    
                    btninsertarponchados.setEnabled(false);
                    cbsucursal.setEnabled(false);
                
                
                if(distinta1nombre==null||distinta1nombre.equals("")||distinta1nombre.equals(" "))
                {
                   btndistinta1.setEnabled(false);
                   
                }
                else
                {

                   
                   if(botonhabilitado1.equals("si"))
                   {
                   listabotones.add("btndistinta1");
                   }

                    
                } 
                
                
                
                /// distinta2
                
                 if(distinta2nombre==null||distinta2nombre.equals("")||distinta2nombre.equals(" "))
                {
                   btndistinta2.setEnabled(false);
                   
                }
                else
                {

                 
                   

                   if(botonhabilitado2.equals("si"))
                   {
                   listabotones.add("btndistinta2");
                   }
                   
                    
                    
                } 
                
                 if(distinta3nombre==null||distinta3nombre.equals("")||distinta3nombre.equals(" "))
                {
                   btndistinta3.setEnabled(false);
                   
                }
                else
                {
                    
                    
                  
                   if(botonhabilitado3.equals("si"))
                   {
                   listabotones.add("btndistinta3");
                   }

                    
                    
                } 
                
                if(distinta4nombre==null||distinta4nombre.equals("")||distinta4nombre.equals(" "))
                {
                   btndistinta4.setEnabled(false);
                   
                }
                else
                {
                    
                    
                  
                   if(botonhabilitado4.equals("si"))
                   {
                   listabotones.add("btndistinta4");
                   }

                    
                    
                } 
                
                if(distinta5nombre==null||distinta5nombre.equals("")||distinta5nombre.equals(" "))
                {
                   btndistinta5.setEnabled(false);
                   
                }
                else
                {
                    
                    
                  
                   if(botonhabilitado5.equals("si"))
                   {
                   listabotones.add("btndistinta5");
                   }

                    
                    
                } 
                
                if(distinta6nombre==null||distinta6nombre.equals("")||distinta6nombre.equals(" "))
                {
                   btndistinta6.setEnabled(false);
                   
                }
                else
                {
                    
                    
                  
                   if(botonhabilitado6.equals("si"))
                   {
                   listabotones.add("btndistinta6");
                   }

                    
                    
                }
                
                
                if(distinta7nombre==null||distinta7nombre.equals("")||distinta7nombre.equals(" "))
                {
                   btndistinta7.setEnabled(false);
                   
                }
                else
                {
                    
                    
                   
                   if(botonhabilitado7.equals("si"))
                   {
                   listabotones.add("btndistinta7");
                   }
                   
                    
                } 
                
                
                
                
                
                
                }
                else
                {
                    
                    btninsertarponchados.setEnabled(true);
                    cbsucursal.setEnabled(true);
                    
                }
                
                
                
                if(estatusorden.equals("realizada"))
                {
                    
                     if(distinta1nombre!=null && Integer.parseInt(distinta1cantidad) > 0  )
                     {
                         btndistinta1.setEnabled(false);
                         cancelar1.setVisible(true);
                     }
                     else if(distinta2nombre!=null && Integer.parseInt(distinta2cantidad) > 0  )
                     {
                         btndistinta2.setEnabled(false);
                         cancelar2.setVisible(true);
                     }
                      else if( distinta3nombre!=null && Integer.parseInt(distinta3cantidad) > 0  )
                     {
                         btndistinta3.setEnabled(false);
                         cancelar3.setVisible(true);
                     }
                     else if( distinta4nombre!=null && Integer.parseInt(distinta4cantidad) > 0  )
                     {
                         btndistinta4.setEnabled(false);
                         cancelar4.setVisible(true);
                     }
                     else if( distinta5nombre!=null && Integer.parseInt(distinta5cantidad) > 0  )
                     {
                         btndistinta5.setEnabled(false);
                         cancelar5.setVisible(true);
                     }
                     else if( distinta6nombre!=null && Integer.parseInt(distinta6cantidad) > 0  )
                     {
                         btndistinta6.setEnabled(false);
                         cancelar6.setVisible(true);
                     }
                     else if( distinta7nombre!=null && Integer.parseInt(distinta7cantidad) > 0  )
                     {
                         btndistinta7.setEnabled(false);
                         cancelar7.setVisible(true);
                     }
                     
                     
                     btnterminetodo.setEnabled(false);
                    
                    
                }
                else if(estatusorden.equals("generada"))
                {
                    
                     if(distinta1nombre!=null && Integer.parseInt(distinta1cantidad) == 0  )
                     {
                         btndistinta1.setEnabled(true);
                         cancelar1.setVisible(false);
                     }
                     else if(distinta2nombre!=null && Integer.parseInt(distinta2cantidad) == 0  )
                     {
                         btndistinta2.setEnabled(true);
                         cancelar2.setVisible(false);
                     }
                      else if( distinta3nombre!=null && Integer.parseInt(distinta3cantidad) == 0  )
                     {
                         btndistinta3.setEnabled(true);
                         cancelar3.setVisible(false);
                     }
                     else if( distinta4nombre!=null && Integer.parseInt(distinta4cantidad) == 0  )
                     {
                         btndistinta4.setEnabled(true);
                         cancelar4.setVisible(false);
                     }
                     else if( distinta5nombre!=null && Integer.parseInt(distinta5cantidad) == 0  )
                     {
                         btndistinta5.setEnabled(true);
                         cancelar5.setVisible(false);
                     }
                     else if( distinta6nombre!=null && Integer.parseInt(distinta6cantidad) == 0  )
                     {
                         btndistinta6.setEnabled(true);
                         cancelar6.setVisible(false);
                     }
                     else if( distinta7nombre!=null && Integer.parseInt(distinta7cantidad) == 0  )
                     {
                         btndistinta7.setEnabled(true);
                         cancelar7.setVisible(false);
                     }
                     
                     btnterminetodo.setEnabled(true);
                    
                    
                }
                

            
            
            
            }

        } catch (SQLException ex) 
        {
             
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
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
        
        Object numero = lbnumero.getText();
        Object numeroventa = lbnumeroventa.getText();
        Object nombreconcepto =lbnombreconcepto.getText();
        BufferedImage img = null;
        
        String prendasql ="";
        String prendanombresql="";
        btnverfotomontaje.setEnabled(false);

       String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_bordado= '"+nombreconcepto+"' and prenda_especial = 'DISTINTA'   ";  ///

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
                    btnagregarfotomontaje.setEnabled(true);
                    
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
                    lblImagen.setIcon(new ImageIcon(img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
                    lblImagen.setVisible(true);
                    btnverfotomontaje.setEnabled(true);
                    tienefotomontaje = "si";
                    btnverfotomontaje.setEnabled(true);
                    btnagregarfotomontaje.setEnabled(false);

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
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
        
        if(tienefotomontaje.equals("si"))
        {
          
            lbdistinta1nombre.setVisible(false);
            lbdistinta1.setVisible(false);
            
            lbdistinta2nombre.setVisible(false);
            lbdistinta2.setVisible(false);
            
            lbdistinta3nombre.setVisible(false);
            lbdistinta3.setVisible(false);
            
            lbdistinta4nombre.setVisible(false);
            lbdistinta4.setVisible(false);
            
            lbdistinta5nombre.setVisible(false);
            lbdistinta5.setVisible(false);
            
            lbdistinta6nombre.setVisible(false);
            lbdistinta6.setVisible(false);
            
            lbdistinta7nombre.setVisible(false);
            lbdistinta7.setVisible(false);
        
            
            
        
        }
        else
        {
            btndistinta1.setEnabled(false);
            btndistinta2.setEnabled(false);
            btndistinta3.setEnabled(false);
            btndistinta4.setEnabled(false);
            btndistinta5.setEnabled(false);
            btndistinta6.setEnabled(false);
            btndistinta7.setEnabled(false);
            
            ordencamisaimagencontorno p = new ordencamisaimagencontorno();
            jPanel1.add(p);
            jPanel1.repaint();
            lblImagen.setVisible(false);
            btnverfotomontaje.setEnabled(false);
            btnagregarfotomontaje.setEnabled(true);

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
            
        }  

        
        
    }

     void agregarfotomontajeotrasucursal() throws FileNotFoundException, IOException  
    {
        
        String numero = lbfolio.getText();
        String prenda =lbprenda.getText();
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);
        
        
        

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
                    lblImagen.setIcon(new ImageIcon(img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
                    lblImagen.setVisible(true);
                    btnverfotomontaje.setEnabled(true);
                    tienefotomontaje = "si";
                    btnverfotomontaje.setEnabled(true);
                    btnagregarfotomontaje.setEnabled(false);

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
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
        
        if(tienefotomontaje.equals("si"))
        {
          
            lbdistinta1nombre.setVisible(false);
            lbdistinta1.setVisible(false);
            
            lbdistinta2nombre.setVisible(false);
            lbdistinta2.setVisible(false);
            
            lbdistinta3nombre.setVisible(false);
            lbdistinta3.setVisible(false);
            
            lbdistinta4nombre.setVisible(false);
            lbdistinta4.setVisible(false);
            
            lbdistinta5nombre.setVisible(false);
            lbdistinta5.setVisible(false);
            
            lbdistinta6nombre.setVisible(false);
            lbdistinta6.setVisible(false);
            
            lbdistinta7nombre.setVisible(false);
            lbdistinta7.setVisible(false);
        
           
            
        
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
            btnagregarfotomontaje.setEnabled(true);

            
            
        }  

        
        
    }

    
    
    
    void datostienda() 
    {
        /// busca las ordenes de camisa generadas 

        
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
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

        }

        if (pedirarticulos.equals("si")) 
        {
            
            
            
            String sql3 = "Select numero,sucursal from historial_pedidos_sucursal_solicitados where numventa = '" + numero + "' and estatus_entrega not in ('cancelada')  ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
                    numerosolicitoarticulos = rs.getString("numero");
                    tiendasolicitoarticulos = rs.getString("sucursal");
                    
                    
                    cbsucursal.addItem(tiendasolicitoarticulos);
                    lbnumero.setText(numerosolicitoarticulos);
                }
            } catch (Exception exx) {
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }
            
            /// solicito articulos de la
            

        }
        else 
        {
            if (ordenenvio.equals("si")) 
            {

                
                
                String sql3 = "Select distinct numero,sucursal from historial_ordenes_envio_solicitadas where numero_venta = '" + numero + "'  ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    while (rs.next()) 
                    {
                        numeroordenenvio = rs.getString("numero");
                        tiendaordenenvio = rs.getString("sucursal");
                        
                       
                    }
                } catch (Exception exx) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }
                
                
                cbsucursal.addItem(tiendaordenenvio);
                lbnumero.setText(numeroordenenvio);

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
                        lbnumero.setText(numerosolicitoarticulos);
                    }
                    else
                    {
                        
                    }
                    
                    
                } catch (Exception exx) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

            } else {
                cbsucursal.addItem(tiendaordenenvio);
                lbnumero.setText(numeroordenenvio);
            }

            
        }

    }
    
    
    void actualizarlascantidadesbordadascancelar(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_distinta set "+ubicacion+"='0' where numero = '"+lbfolio.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
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
            Logger.getLogger(ordendistinta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
    void actualizarlascantidadesbordadas(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_distinta set "+ubicacion+"='" + lbcantidad.getText() + "' where numero = '"+lbfolio.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
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
        
        
        /*
        try {
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordendistinta.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        
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
                pst.setString(5, lbnombreconcepto.getText());
                pst.setString(6, lbcantidad.getText());
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
                pst.setString(5, lbnombreconcepto.getText());
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
            
                
 
                pst.setString(1, lbnumero.getText());
                pst.setString(2, tiendaenvia);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, ubicacioninsertar);
                pst.setString(6, lbnombreconcepto.getText());
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
            
                
 
                 pst.setString(1, lbnumero.getText());
                pst.setString(2, tiendaenvia);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, ubicacioninsertar);
                pst.setString(6, lbnombreconcepto.getText());
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
                  + "aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2 from "+nombredelatabla+" where numero = '"+lbfolio.getText()+"' ";

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
               
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
        
         String sql = "Select cantidad,distinta1_cantidad,distinta1,distinta2_cantidad,distinta2,"
                  + "distinta3_cantidad,distinta3,distinta4_cantidad,distinta4,distinta4_cantidad,distinta4,"
                  + "distinta5_cantidad,distinta5,distinta6_cantidad,distinta6,distinta7_cantidad,distinta7 from "+nombredelatabla+" where numero = '"+lbfolio.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cantidad = rs.getString("cantidad");   
                String distinta1cantidad = rs.getString("distinta1_cantidad");
                String distinta1 = rs.getString("distinta1");
                String distinta2cantidad = rs.getString("distinta2_cantidad");
                String distinta2 = rs.getString("distinta2");
                String distinta3cantidad = rs.getString("distinta3_cantidad");
                String distinta3 = rs.getString("distinta3");
                String distinta4cantidad = rs.getString("distinta4_cantidad");
                String distinta4 = rs.getString("distinta4");
                String distinta5cantidad = rs.getString("distinta5_cantidad");
                String distinta5 = rs.getString("distinta4");
                String distinta6cantidad = rs.getString("distinta6_cantidad");
                String distinta6 = rs.getString("distinta6");
                String distinta7cantidad = rs.getString("distinta7_cantidad");
                String distinta7 = rs.getString("distinta7");

                
                if(distinta1==null || distinta1.equals("")||distinta1.equals(" ")||distinta1.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                } 
                
                
                if(distinta2==null || distinta2.equals("")||distinta2.equals(" ")||distinta2.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(distinta3==null || distinta3.equals("")||distinta3.equals(" ")||distinta3.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(distinta4==null || distinta4.equals("")||distinta4.equals(" ")||distinta4.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(distinta5==null || distinta5.equals("")||distinta5.equals(" ")||distinta5.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
            
                
                if(distinta6==null || distinta6.equals("")||distinta6.equals(" ")||distinta6.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
            
           if(distinta7==null || distinta7.equals("")||distinta7.equals(" ")||distinta7.equals("ninguno") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
           
           
                ////////////////////////////////////////////////////////////////
                
                 if(distinta1cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                } 
                
                
                if(distinta2cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                }
                
                if(distinta3cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
                if(distinta4cantidad.equals("0"))
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
                if(distinta5cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
            
                
                if(distinta6cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                }
            
           if(distinta7cantidad.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1; 
                }
           
            
           
           if(tienecantidad == botonesactivados)
           {
               try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set estatus_orden='realizada' where numero='" + lbfolio.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
                }
               
           }


        }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
    
    void hilosycolor()
    {
        Object cliente = lbcliente.getText();
        Object tipo = lbprenda.getText();
        Object prenda =lbprenda.getText();
        Object nombreconcepto =lbnombreconcepto.getText();
       

        String sql = "Select hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,color1,color2,color3,color4,color5,color6,color7 from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_bordado= '"+nombreconcepto+"' and prenda_especial = 'DISTINTA'   ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next()) 
            {
                Object hilo1 = rs1.getString("hilo1");
                Object hilo2 = rs1.getString("hilo2");
                Object hilo3 = rs1.getString("hilo3");
                Object hilo4 = rs1.getString("hilo4");
                Object hilo5 = rs1.getString("hilo5");
                Object hilo6 = rs1.getString("hilo6");
                Object hilo7 = rs1.getString("hilo7");
                
                
                
                
                
                Object codigo1 = rs1.getString("color1");
                Object codigo2 = rs1.getString("color2");
                Object codigo3 = rs1.getString("color3");
                Object codigo4 = rs1.getString("color4");
                Object codigo5 = rs1.getString("color5");
                Object codigo6 = rs1.getString("color6");
                Object codigo7 = rs1.getString("color7");
                
                if(codigo1.equals("ninguno"))
                {
                  lbcolorpechoizquierdo.setVisible(false);  
                  lbcodigopechoizquierdo.setVisible(false); 
                }
                else
                {
                  lbcolorpechoizquierdo.setText(codigo1.toString());
                  lbcodigopechoizquierdo.setText(hilo1.toString());
                }  
                
                if(codigo2.equals("ninguno"))
                {
                  lbcolorpechoderecho.setVisible(false); 
                  lbcodigopechoderecho.setVisible(false); 
                }
                else
                {
                  lbcolorpechoderecho.setText(codigo2.toString());
                  lbcodigopechoderecho.setText(hilo2.toString());
                }  
                
                 if(codigo3.equals("ninguno"))
                {
                  lbcolormangaizquierda.setVisible(false); 
                  lbcodigomangaizquierda.setVisible(false); 
                }
                else
                {
                  lbcolormangaizquierda.setText(codigo3.toString());
                  lbcodigomangaizquierda.setText(hilo3.toString());
                }  
                
                if(codigo4.equals("ninguno"))
                {
                  lbcolormangaderecha.setVisible(false);  
                  lbcodigomangaderecha.setVisible(false);  
                }
                else
                {
                  lbcolormangaderecha.setText(codigo4.toString());
                  lbcodigomangaderecha.setText(hilo4.toString());
                }    
                
                if(codigo5.equals("ninguno"))
                {
                  lbcolorespalda.setVisible(false);  
                  lbcodigoespalda.setVisible(false);  
                }
                else
                {
                  lbcolorespalda.setText(codigo5.toString());
                  lbcodigoespalda.setText(hilo5.toString());
                }   
                
                 if(codigo6.equals("ninguno"))
                {
                  lbcolorotraubicacion.setVisible(false); 
                  lbcodigootraubicacion.setVisible(false);  
                }
                else
                {
                  lbcolorotraubicacion.setText(codigo6.toString());
                  lbcodigootraubicacion.setText(hilo6.toString());
                } 
                
                 if(codigo7.equals("ninguno"))
                {
                  lbcolorotraubicacion2.setVisible(false);  
                  lbcodigootraubicacion2.setVisible(false);  
                }
                else
                {
                  lbcolorotraubicacion2.setText(codigo7.toString());
                  lbcodigootraubicacion2.setText(hilo7.toString());
                } 
                    
                
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
    }
    
   
    
    
    
     
     void descargarponchado(String ubicacion,String ubicacionnombre)
     {
         JSystemFileChooser fs = new JSystemFileChooser();
        

         try (
                 PreparedStatement ps = cn.prepareStatement("select " + ubicacion + "," + ubicacionnombre + " from historial_ordenes_gorra_recibidas where numero = '" + lbfolio.getText() + "' ")) {
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
        lbdistinta1 = new javax.swing.JLabel();
        lbdistinta1nombre = new javax.swing.JLabel();
        lbdistinta2 = new javax.swing.JLabel();
        lbdistinta2nombre = new javax.swing.JLabel();
        lbdistinta3 = new javax.swing.JLabel();
        lbdistinta3nombre = new javax.swing.JLabel();
        lbdistinta4 = new javax.swing.JLabel();
        lbdistinta4nombre = new javax.swing.JLabel();
        lbdistinta5 = new javax.swing.JLabel();
        lbdistinta5nombre = new javax.swing.JLabel();
        lbdistinta6 = new javax.swing.JLabel();
        lbdistinta6nombre = new javax.swing.JLabel();
        lbdistinta7 = new javax.swing.JLabel();
        lbdistinta7nombre = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbfolio = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        lbtitulo = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbprenda = new javax.swing.JLabel();
        lbnumeroventa = new javax.swing.JLabel();
        btninsertarponchados = new javax.swing.JButton();
        lbtipo = new javax.swing.JLabel();
        lbnumero = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();
        cbsucursal = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnverfotomontaje = new javax.swing.JButton();
        lbnombreconcepto = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
        btndistinta1 = new javax.swing.JButton();
        btndistinta2 = new javax.swing.JButton();
        btndistinta3 = new javax.swing.JButton();
        btndistinta4 = new javax.swing.JButton();
        btndistinta5 = new javax.swing.JButton();
        btndistinta6 = new javax.swing.JButton();
        btndistinta7 = new javax.swing.JButton();
        lbltallas = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        lbcliente1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbcolormangaderecha = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        btnagregarfotomontaje = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        lbcolormangaizquierda = new javax.swing.JLabel();
        lbcolorpechoderecho = new javax.swing.JLabel();
        lbcolorpechoizquierdo = new javax.swing.JLabel();
        lbcolorespalda = new javax.swing.JLabel();
        lbcolorotraubicacion = new javax.swing.JLabel();
        lbcolorotraubicacion2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        lbcodigomangaderecha = new javax.swing.JLabel();
        lbcodigomangaizquierda = new javax.swing.JLabel();
        lbcodigopechoderecho = new javax.swing.JLabel();
        lbcodigopechoizquierdo = new javax.swing.JLabel();
        lbcodigoespalda = new javax.swing.JLabel();
        lbcodigootraubicacion = new javax.swing.JLabel();
        lbcodigootraubicacion2 = new javax.swing.JLabel();
        btnterminetodo = new javax.swing.JButton();
        cancelar1 = new javax.swing.JLabel();
        cancelar2 = new javax.swing.JLabel();
        cancelar3 = new javax.swing.JLabel();
        cancelar4 = new javax.swing.JLabel();
        cancelar5 = new javax.swing.JLabel();
        cancelar6 = new javax.swing.JLabel();
        cancelar7 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden distinta");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(null);

        lbdistinta1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta1);
        lbdistinta1.setBounds(80, 60, 260, 16);

        lbdistinta1nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta1nombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta1nombre);
        lbdistinta1nombre.setBounds(80, 40, 260, 16);

        lbdistinta2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta2);
        lbdistinta2.setBounds(510, 60, 300, 20);

        lbdistinta2nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta2nombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta2nombre);
        lbdistinta2nombre.setBounds(510, 40, 300, 20);

        lbdistinta3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta3.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta3);
        lbdistinta3.setBounds(80, 260, 270, 20);

        lbdistinta3nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta3nombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta3nombre);
        lbdistinta3nombre.setBounds(80, 280, 270, 20);

        lbdistinta4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta4.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta4);
        lbdistinta4.setBounds(520, 250, 270, 20);

        lbdistinta4nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta4nombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta4nombre);
        lbdistinta4nombre.setBounds(520, 270, 270, 20);

        lbdistinta5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta5.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta5);
        lbdistinta5.setBounds(520, 460, 310, 19);

        lbdistinta5nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta5nombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta5nombre);
        lbdistinta5nombre.setBounds(520, 440, 310, 19);

        lbdistinta6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta6.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta6);
        lbdistinta6.setBounds(70, 460, 310, 19);

        lbdistinta6nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta6nombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta6nombre);
        lbdistinta6nombre.setBounds(70, 440, 310, 19);

        lbdistinta7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta7.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta7);
        lbdistinta7.setBounds(70, 560, 310, 19);

        lbdistinta7nombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbdistinta7nombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbdistinta7nombre);
        lbdistinta7nombre.setBounds(70, 540, 310, 19);

        lblImagen.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setToolTipText("");
        lblImagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.add(lblImagen);
        lblImagen.setBounds(0, 10, 870, 700);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel13.setText("No.Orden");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfolio.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbfolio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel16.setText("Cliente");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbtitulo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbprenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbprendaMouseClicked(evt);
            }
        });

        lbnumeroventa.setText("00000000");

        btninsertarponchados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btninsertarponchados.setText("Replicar Fotomontajes y Ponchados");
        btninsertarponchados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarponchadosActionPerformed(evt);
            }
        });

        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumero.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbnumero.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel22.setText("Sucursal a que Replica");

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminar.setText("Ver datos del bordado");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        cbsucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbsucursal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "cdmxsur", "cdmxcentro", "guadalajara", "monterrey", "tijuana" }));
        cbsucursal.setSelectedIndex(-1);

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel14.setText("Numero Sucursal");
        jLabel14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ampliar Imagen");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        lbnombreconcepto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel15.setText("Cantidad");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfecha.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbfecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel17.setText("Fecha de entrega");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setText("Identificador");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndistinta1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta1.setText("Distinta1");
        btndistinta1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta1ActionPerformed(evt);
            }
        });

        btndistinta2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta2.setText("Distinta2");
        btndistinta2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta2ActionPerformed(evt);
            }
        });

        btndistinta3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta3.setText("Distinta3");
        btndistinta3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta3ActionPerformed(evt);
            }
        });

        btndistinta4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta4.setText("Distinta4");
        btndistinta4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta4ActionPerformed(evt);
            }
        });

        btndistinta5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta5.setText("Distinta5");
        btndistinta5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta5ActionPerformed(evt);
            }
        });

        btndistinta6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta6.setText("Distinta6");
        btndistinta6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta6ActionPerformed(evt);
            }
        });

        btndistinta7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btndistinta7.setText("Distinta7");
        btndistinta7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndistinta7ActionPerformed(evt);
            }
        });

        lbltallas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbltallasMouseClicked(evt);
            }
        });

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbsumapuntos.setText("0.00");
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Puntos");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel19.setText("Nombre comercial");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcliente1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        lbcolormangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolormangaderecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 0));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Observaciones");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnagregarfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnagregarfotomontaje.setText("Agregar Fotomontaje");
        btnagregarfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarfotomontajeActionPerformed(evt);
            }
        });

        lbcolormangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolormangaizquierda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorpechoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorpechoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorespalda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorotraubicacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorotraubicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolorotraubicacion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcolorotraubicacion2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Codigo");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigomangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigomangaderecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigomangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigomangaizquierda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigopechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigopechoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigopechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigopechoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoespalda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigootraubicacion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigootraubicacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigootraubicacion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigootraubicacion2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnterminetodo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnterminetodo.setForeground(new java.awt.Color(0, 102, 0));
        btnterminetodo.setText("**-Termine todo***");
        btnterminetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterminetodoActionPerformed(evt);
            }
        });

        cancelar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        cancelar1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelar1MouseClicked(evt);
            }
        });

        cancelar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        cancelar2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelar2MouseClicked(evt);
            }
        });

        cancelar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        cancelar3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelar3MouseClicked(evt);
            }
        });

        cancelar4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        cancelar4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelar4MouseClicked(evt);
            }
        });

        cancelar5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        cancelar5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelar5MouseClicked(evt);
            }
        });

        cancelar6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        cancelar6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelar6MouseClicked(evt);
            }
        });

        cancelar7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancel.png"))); // NOI18N
        cancelar7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelar7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 872, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane6))
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addComponent(lbltallas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(cancelar7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbcolorotraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 241, Short.MAX_VALUE))
                            .addComponent(jSeparator3)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(btndistinta1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(btndistinta2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                                                    .addComponent(btndistinta3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(0, 0, Short.MAX_VALUE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(cancelar2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbcolormangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(cancelar3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbcolorpechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(3, 3, 3)
                                                        .addComponent(cancelar1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lbcolormangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(btndistinta7, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(btndistinta6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btndistinta5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                                        .addComponent(btndistinta4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(cancelar5)
                                                            .addComponent(cancelar4))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lbcolorpechoizquierdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lbcolorespalda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(cancelar6)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbcolorotraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigomangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigomangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigopechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigopechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigoespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigootraubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigootraubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbnumero, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)))
                                    .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbtitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btninsertarponchados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnagregarfotomontaje))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(22, 22, 22)
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbcliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbnombreconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(596, 596, 596))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnagregarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btninsertarponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbltallas, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(lbcodigomangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(cancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(btndistinta1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                    .addGroup(layout.createSequentialGroup()
                                                                        .addGap(36, 36, 36)
                                                                        .addComponent(lbcolormangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(5, 5, 5)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addComponent(cancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(btndistinta2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(lbcolormangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                .addGap(5, 5, 5)
                                                                                .addComponent(btndistinta3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                .addGap(6, 6, 6)
                                                                                .addComponent(cancelar3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                    .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(lbcodigomangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lbcodigopechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                            .addComponent(lbcolorpechoderecho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(btndistinta4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(lbcodigopechoizquierdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(cancelar4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addComponent(lbcolorpechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btndistinta5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cancelar5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(lbcodigoespalda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(lbcolorespalda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(btndistinta6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cancelar6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcodigootraubicacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbcolorotraubicacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btndistinta7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelar7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbcodigootraubicacion2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbcolorotraubicacion2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbfolio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnombreconcepto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnumeroventa)))
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
        
        nombredelatabla = "historial_ordenes_distinta";
        
     try {
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordendistinta.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     codigocliente();
     
     hilosycolor();
     
     try {    
            agregarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordendistinta.class.getName()).log(Level.SEVERE, null, ex);
        }

      
     
        
        
    } 
    
    
     AudioClip sonido;
      if(tieneunaobservacion.equals("si"))
        {
            sonido= java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/tienesunaobservacion.wav"));    
            sonido.play();
            
        }
    
     
        
   //sumapuntos();
        
    }//GEN-LAST:event_formWindowOpened

    private void lbprendaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbprendaMouseClicked
        String prenda = lbprenda.getText();
        String cliente = lbcliente.getText();
        String imagen = "";
        String existe = "";
        String SQL = "";

        if (prenda.startsWith("Camisa")) {
            SQL = "SELECT camisa1 FROM catalogo_clientes where nombre = '" + cliente + "' ";
            imagen = "camisa1";
        } else if (prenda.startsWith("CAMISA2")) {
            SQL = "SELECT camisa2 FROM catalogo_clientes where nombre = '" + cliente + "' ";
            imagen = "camisa2";
        } else if (prenda.startsWith("CHAMARRA DESMON")) {
            SQL = "SELECT chamarra FROM catalogo_clientes where nombre = '" + cliente + "' ";
            imagen = "chamarra";
        } else if (prenda.startsWith("CHAMARRA ROMP")) {
    //SQL = "SELECT chaleco,chalecoextension FROM catalogo_clientes where codigo = '" + codigo + "' ";
        } else if (prenda.startsWith("CAMISOLA")) {
            SQL = "SELECT camisola FROM catalogo_clientes where nombre = '" + cliente + "' ";
            imagen = "camisola";
        } else if (prenda.startsWith("CHALECO")) {
            SQL = "SELECT chaleco FROM catalogo_clientes where nombre = '" + cliente + "' ";
            imagen = "chaleco";
        } else if (prenda.startsWith("SACO")) {
   // SQL = "SELECT chaleco,chalecoextension FROM catalogo_clientes where codigo = '" + codigo + "' ";
        }

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                byte[] img = rs.getBytes(imagen);
                //Resize The ImageIcon
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImg = im.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                lblImagen.setIcon(newImage);
            } else {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No hay imagen que mostrar");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_lbprendaMouseClicked

    private void btndistinta2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta2ActionPerformed

    if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta2_cantidad";
            String nombrebordado = distinta2nombre;
            String cantidadaplicacion = distinta2aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadas((String) ubicacion);

            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta2ubicacion + " " + distinta2nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta2ubicacion + " " + distinta2nombre + "";

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            //sumapuntos(); 
            
        }    
         

    }//GEN-LAST:event_btndistinta2ActionPerformed

    private void btndistinta4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta4ActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta4_cantidad";
            String nombrebordado = distinta4nombre;
            String cantidadaplicacion = distinta4aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadas((String) ubicacion);

            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta4ubicacion + " " + distinta4nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta4ubicacion + " " + distinta4nombre + "";

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
        //sumapuntos(); 
            
        } 
    
    }//GEN-LAST:event_btndistinta4ActionPerformed

    private void btndistinta5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta5ActionPerformed

         if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta5_cantidad";
            String nombrebordado = distinta5nombre;
            String cantidadaplicacion = distinta5aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadas((String) ubicacion);

            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta5ubicacion + " " + distinta5nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta5ubicacion + " " + distinta5nombre + "";

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            //sumapuntos(); 
            
        } 
         
    }//GEN-LAST:event_btndistinta5ActionPerformed

    private void btndistinta3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta3ActionPerformed
     
        if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta3_cantidad";
            String nombrebordado = distinta3nombre;
            String cantidadaplicacion = distinta3aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadas((String) ubicacion);

            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta3ubicacion + " " + distinta3nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta3ubicacion + " " + distinta3nombre + "";

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            //sumapuntos(); 
            
        }  
        
    }//GEN-LAST:event_btndistinta3ActionPerformed

    private void btndistinta1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta1ActionPerformed

        if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta1_cantidad";
            String nombrebordado = distinta1nombre;
            String cantidadaplicacion = distinta1aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadas((String) ubicacion);

            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta1ubicacion + " " + distinta1nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta1ubicacion + " " + distinta1nombre + "";

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            //sumapuntos(); 
            
        }
            
           
        
        
    }//GEN-LAST:event_btndistinta1ActionPerformed

    private void btninsertarponchadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarponchadosActionPerformed
       
        
       Object sucursalreplica =  cbsucursal.getSelectedItem();
        

        String tipo = lbtipo.getText();
        String numerosucursal = lbnumero.getText();
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

            String numero = lbnumero.getText();
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa SET estatus_entrega='enviado' WHERE numero='" + numero + "'");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
               
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
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

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

    }//GEN-LAST:event_btneliminarActionPerformed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed
       
        
          String cliente = lbcliente.getText();
        String tipo = lbprenda.getText();
        String prenda =lbprenda.getText().toUpperCase();
        String nombreconcepto =lbnombreconcepto.getText();
        String prendafotomontaje = "";
        String nombreprendafotomontaje = "";
        String rutadelarchivo = "";
        String existe = "";
        
        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_bordado= '"+nombreconcepto+"' and tipo = '"+prenda+"'   ";

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

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:5px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        
        } 

    }//GEN-LAST:event_btnverfotomontajeActionPerformed

    private void btndistinta6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta6ActionPerformed

       if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta6_cantidad";
            String nombrebordado = distinta6nombre;
            String cantidadaplicacion = distinta6aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadas((String) ubicacion);

            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta6ubicacion + " " + distinta6nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta6ubicacion + " " + distinta6nombre + "";

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            //sumapuntos(); 
            
        } 
        
    }//GEN-LAST:event_btndistinta6ActionPerformed

    private void btndistinta7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndistinta7ActionPerformed
       
        if(lbcantidad.getText().equals("0"))
        {
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La cantidad es 0 revisa por favor la orden");
        }
         
        else if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta7_cantidad";
            String nombrebordado = distinta7nombre;
            String cantidadaplicacion = distinta7aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadas((String) ubicacion);

            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta7ubicacion + " " + distinta7nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta7ubicacion + " " + distinta7nombre + "";

            agregarexistenciabordados((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            //sumapuntos(); 
            
        } 
    }//GEN-LAST:event_btndistinta7ActionPerformed

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
               
            }

        }
    }//GEN-LAST:event_lbltallasMouseClicked

    private void btnagregarfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarfotomontajeActionPerformed

        
         if (ordencamisaautorizacion.equals("si")) 
         {
        
        
        ordencamisaautorizacion="no";
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

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigocliente+"' and nombre_bordado = '"+lbnombreconcepto.getText()+"' and tipo = '"+lbprenda.getText().toUpperCase()+"' ";

                myStmt = cn.prepareStatement(sql);
                File theFile = new File(rutaarchivo);
                input = new FileInputStream(theFile);
                myStmt.setBinaryStream(1, input);
                myStmt.executeUpdate();
                myStmt.close();
               
                
               
                btnagregarfotomontaje.setEnabled(false);        
                
                
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"' where codigo='"+codigocliente+"' and nombre_bordado = '"+lbnombreconcepto.getText()+"' and tipo = '"+lbprenda.getText()+"'  ");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
            
            btndistinta1.setVisible(true);
            btndistinta2.setVisible(true);
            btndistinta3.setVisible(true);
            btndistinta4.setVisible(true);
            btndistinta5.setVisible(true);
            btndistinta6.setVisible(true);
            btndistinta7.setVisible(true);
            
              try {
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordendistinta.class.getName()).log(Level.SEVERE, null, ex);
        }
     
     codigocliente();
     
     
     try {    
            agregarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordendistinta.class.getName()).log(Level.SEVERE, null, ex);
        }

        
          
        
       //sumapuntos();
       
           

        }
        
        
        
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
            
            autorizacion.lbinterfaz.setText("ordencamisa");
            
             
            }
             
         }    
                 
         
    }//GEN-LAST:event_btnagregarfotomontajeActionPerformed

    private void btnterminetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterminetodoActionPerformed
      
        terminetodo = "si";
        
        
        for(int i = 0; i < listabotones.size(); i++)
        {
            Object boton =  listabotones.get(i);
            
            
            
            if(boton.equals("btndistinta1"))
            {
                btndistinta1.doClick();
            }
            else if(boton.equals("btndistinta2"))
            {
                btndistinta2.doClick();
            }
            else if(boton.equals("btndistinta3"))
            {
                btndistinta3.doClick();
            }
            else if(boton.equals("btndistinta4"))
            {
                btndistinta4.doClick();
            }
            else if(boton.equals("btndistinta5"))
            {
                btndistinta5.doClick();
            }
            else if(boton.equals("btndistinta6"))
            {
                btndistinta6.doClick();
            }
            else if(boton.equals("btndistinta7"))
            {
                btndistinta7.doClick();
            }
            
        }
        
        
        
        
         terminetodo = "no";
         btnterminetodo.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden se actualizo");
         
         if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
         {
             ordenesporrealizar.btnactualizar.doClick();
         }
         
         listabotones.clear();
         
         this.dispose();
         
    }//GEN-LAST:event_btnterminetodoActionPerformed

    private void cancelar1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelar1MouseClicked

     if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {   
        
        
     if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {

            String ubicacion = "distinta1_cantidad";
            String nombrebordado = distinta1nombre;
            String cantidadaplicacion = distinta1aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadascancelar((String) ubicacion);

            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta1ubicacion + " " + distinta1nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta1ubicacion + " " + distinta1nombre + "";
                         
            
            agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
            //sumapuntos();
            

            
            
        }
        
     }
        
       
    }//GEN-LAST:event_cancelar1MouseClicked

    private void cancelar2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelar2MouseClicked

        

        if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
        
            String ubicacion = "distinta2_cantidad";
            String nombrebordado = distinta2nombre;
            String cantidadaplicacion = distinta2aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadascancelar((String) ubicacion);


            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta2ubicacion + " " + distinta2nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta2ubicacion + " " + distinta2nombre + "";  

       agregarexistenciabordadoscancelar((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
       agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad) ;
       estacompletalaorden(); 
       //sumapuntos(); 
       
        }
        }
        
        
    }//GEN-LAST:event_cancelar2MouseClicked

    private void cancelar3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelar3MouseClicked

        
        
        if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            String ubicacion = "distinta3_cantidad";
            String nombrebordado =distinta3nombre;
           String cantidadaplicacion = distinta3aplicacion;
           String cantidad = lbcantidad.getText();
           nombredelatabla = "historial_ordenes_distinta";
           actualizarlascantidadesbordadascancelar((String) ubicacion);
           
             
            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta3ubicacion + " " + distinta3nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta3ubicacion + " " + distinta3nombre + "";  
            
       agregarexistenciabordadoscancelar((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
       agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad) ;
       estacompletalaorden(); 
      // sumapuntos();
            
        }
        
        
        }
        
        
        
    }//GEN-LAST:event_cancelar3MouseClicked

    private void cancelar4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelar4MouseClicked
        
        
        if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
           String ubicacion = "distinta4_cantidad";
           String nombrebordado =distinta4nombre;
           String cantidadaplicacion = distinta4aplicacion;
           String cantidad = lbcantidad.getText();
           nombredelatabla = "historial_ordenes_distinta";
           actualizarlascantidadesbordadascancelar((String) ubicacion);  
           
          
            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta4ubicacion + " " + distinta4nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta4ubicacion + " " + distinta4nombre + "";  

       agregarexistenciabordadoscancelar((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
       agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad) ;   
       estacompletalaorden(); 
       //sumapuntos();   
        
             
            
        }
        
        }
        
       
    }//GEN-LAST:event_cancelar4MouseClicked

    private void cancelar5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelar5MouseClicked

        
        if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            String ubicacion = "distinta5_cantidad";
            String nombrebordado =distinta5nombre;
           String cantidadaplicacion = distinta5aplicacion;
           String cantidad = lbcantidad.getText();
           nombredelatabla = "historial_ordenes_distinta";
           actualizarlascantidadesbordadascancelar((String) ubicacion);

            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta5ubicacion + " " + distinta5nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta5ubicacion + " " + distinta5nombre + "";  

       agregarexistenciabordadoscancelar((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
       agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad) ;   
       estacompletalaorden();
       //sumapuntos();       
            
        }
        
        }
        
      
    }//GEN-LAST:event_cancelar5MouseClicked

    private void cancelar6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelar6MouseClicked

        
        if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            String ubicacion = "distinta6_cantidad";
            String nombrebordado = distinta6nombre;
            String cantidadaplicacion = distinta6aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadascancelar((String) ubicacion);


            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta6ubicacion + " " + distinta6nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta6ubicacion + " " + distinta6nombre + "";  
            
            agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
           // sumapuntos();
            
        }
        
        }
        
       
    }//GEN-LAST:event_cancelar6MouseClicked

    private void cancelar7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelar7MouseClicked

        
        if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado?", "WARNING",
     JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) { 
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            String ubicacion = "distinta7_cantidad";
            String nombrebordado = distinta7nombre;
            String cantidadaplicacion = distinta7aplicacion;
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_distinta";
            actualizarlascantidadesbordadascancelar((String) ubicacion);

            ubicacioninsertar = "BORDADO " + tipoprenda + " " + distinta7ubicacion + " " + distinta7nombre + " ";
            aplicacioninsertar = "APLICACION " + tipoprenda + " " + distinta7ubicacion + " " + distinta7nombre + "";  

            agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
            estacompletalaorden();
          //  sumapuntos();
            
        }
        
        
        }
        
        
    }//GEN-LAST:event_cancelar7MouseClicked



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
            java.util.logging.Logger.getLogger(ordendistinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordendistinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordendistinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordendistinta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordendistinta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnagregarfotomontaje;
    private javax.swing.JButton btndistinta1;
    private javax.swing.JButton btndistinta2;
    private javax.swing.JButton btndistinta3;
    private javax.swing.JButton btndistinta4;
    private javax.swing.JButton btndistinta5;
    private javax.swing.JButton btndistinta6;
    private javax.swing.JButton btndistinta7;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btninsertarponchados;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JLabel cancelar1;
    private javax.swing.JLabel cancelar2;
    private javax.swing.JLabel cancelar3;
    private javax.swing.JLabel cancelar4;
    private javax.swing.JLabel cancelar5;
    private javax.swing.JLabel cancelar6;
    private javax.swing.JLabel cancelar7;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JLabel lbcantidad;
    public static javax.swing.JLabel lbcantidad1;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbcliente1;
    public javax.swing.JLabel lbcodigoespalda;
    public javax.swing.JLabel lbcodigomangaderecha;
    public javax.swing.JLabel lbcodigomangaizquierda;
    public javax.swing.JLabel lbcodigootraubicacion;
    public javax.swing.JLabel lbcodigootraubicacion2;
    public javax.swing.JLabel lbcodigopechoderecho;
    public javax.swing.JLabel lbcodigopechoizquierdo;
    public javax.swing.JLabel lbcolorespalda;
    public javax.swing.JLabel lbcolormangaderecha;
    public javax.swing.JLabel lbcolormangaizquierda;
    public javax.swing.JLabel lbcolorotraubicacion;
    public javax.swing.JLabel lbcolorotraubicacion2;
    public javax.swing.JLabel lbcolorpechoderecho;
    public javax.swing.JLabel lbcolorpechoizquierdo;
    public static javax.swing.JLabel lbdistinta1;
    public static javax.swing.JLabel lbdistinta1nombre;
    public static javax.swing.JLabel lbdistinta2;
    public static javax.swing.JLabel lbdistinta2nombre;
    public static javax.swing.JLabel lbdistinta3;
    public static javax.swing.JLabel lbdistinta3nombre;
    public static javax.swing.JLabel lbdistinta4;
    public static javax.swing.JLabel lbdistinta4nombre;
    public static javax.swing.JLabel lbdistinta5;
    public static javax.swing.JLabel lbdistinta5nombre;
    public static javax.swing.JLabel lbdistinta6;
    public static javax.swing.JLabel lbdistinta6nombre;
    public static javax.swing.JLabel lbdistinta7;
    public static javax.swing.JLabel lbdistinta7nombre;
    public static javax.swing.JLabel lbfecha;
    public static javax.swing.JLabel lbfolio;
    public static javax.swing.JLabel lbidentificador;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lbltallas;
    private javax.swing.JLabel lbnombreconcepto;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lbprenda;
    public javax.swing.JLabel lbsumapuntos;
    public static javax.swing.JLabel lbtipo;
    private javax.swing.JLabel lbtitulo;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
