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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ordengorra extends javax.swing.JFrame {

    public static boolean ventanaordengorra = false;
   
    
    public static String ordenbordadocamisa = "";

    String codigocliente ="";
   
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
    String iptraspaso = "";
    String tienda_traspaso = "";
   
    int traspaso = 0;

    String numerosucursal = "";
    String numerosucursalordengorra = "";
    String sucursal = "";
    String numerosolicitoarticulos = "";
    String tiendasolicitoarticulos = "";
    String numeroordenenvio = "";
    String tiendaordenenvio = "";
    String lugardondesebordara = "";

    int descargado = 0;
    
    String ladoizquierdonombre = "";
    String ladoderechonombre = "";
    String frentenombre = "";
    String atrasnombre = "";
   
    String ubicacioninsertar ="";
    String aplicacioninsertar = "";
    
    String tienefotomontaje = "";
    String rutaimagen = "";
    public static String ordengorraautorizacion = "";
    String rutaarchivo = "";
    String nombrearchivo = "";
    public static String enquesucursalsebordara = "";
    public static String tipotabla = "";
    String sucursalqueenvia ="";
    String nombredelatabla = "";
    String terminetodo ="";
    ArrayList<String> listabotones = new ArrayList<String>();
    
   String identificadordeprenda = "";
   String consecutivo = "";
   String tieneunaobservacion = "";
   String tienenumerodesucursal = "";
   String tiendalocal = "";
   String rutadedondeestanlosbordados ="";
   
 

    public ordengorra() {
        initComponents();
        ventanaordengorra = true;

        lbnumeroventa.setVisible(false);
        lbtiendaalaquereplicara.setVisible(false);
        
        lbrutaladoizquierdo.setVisible(false);
        lbrutaladoderecho.setVisible(false);
        lbrutaatras.setVisible(false);        
        lbrutafrente.setVisible(false);
        lbrutaimagen.setVisible(false);       
        lbtipo.setVisible(false);
        btnreplicar.setEnabled(false);
        btndatos.setVisible(false); 
        btnterminetodo.setEnabled(false);
                
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

    void datos() throws IOException {

        btnreplicar.setEnabled(true);

        String folio = lborden.getText();
        String botonactivado1 = "";
        String botonactivado2 = "";
        String botonactivado3 = "";
        String botonactivado4 = "";

        String sql = "Select fecha,hora,cliente,numero_venta,cantidad,cantidad_bordados,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,"
                + "lado_izquierdo,lado_derecho,frente,atras,aplicacion_frente,aplicacion_frente_color,lugar,cantidad_frente,cantidad_lado_derecho,cantidad_lado_izquierdo,cantidad_atras,nombre_concepto,estatus_orden,numero_orden,tienda from historial_ordenes_gorra where numero = '" + folio + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));
              
                lbcantidad.setText(rs.getString("cantidad"));
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));
                
                ladoizquierdonombre = rs.getString("lado_izquierdo");
                ladoderechonombre = rs.getString("lado_derecho");
                frentenombre = rs.getString("frente");
                atrasnombre = rs.getString("atras");
                
                identificadordeprenda =rs.getString("nombre_concepto");
                lbidentificadordeprenda.setText(identificadordeprenda);
                
                numerosucursalordengorra=rs.getString("numero_orden");
                sucursal=rs.getString("tienda");
                
                lbtiendaalaquereplicara.setText(sucursal);
                lbtienda.setText(sucursal);
                
                if(numerosucursalordengorra ==null  || numerosucursalordengorra.equals("") ||numerosucursalordengorra.equals(" ") )
                {
                    tienenumerodesucursal ="no";
                }
                else
                {
                    tienenumerodesucursal ="si";
                }    
                
                
                
                lbfrente.setText(rs.getString("frente"));
                String frente =  rs.getString("frente");
               
                if(frente ==null||frente.equals(""))
                {
                    btnfrente.setEnabled(false);
                    
                }
                else
                {
                    botonactivado1 = "si";
                   btnterminetodo.setEnabled(true);
                    
                }    
                
                lbladoizquierdo.setText(rs.getString("lado_izquierdo"));
                String ladoizquierdo =  rs.getString("lado_izquierdo");
               
                if(ladoizquierdo ==null||ladoizquierdo.equals(""))
                {
                    btnladoizquierdo.setEnabled(false);
                }
                else
                {
                     botonactivado2 = "si";
                      btnterminetodo.setEnabled(true);
                }    
                
                lbladoderecho.setText(rs.getString("lado_derecho"));
                 String ladoderecho =  rs.getString("lado_derecho");
                if(ladoderecho ==null||ladoderecho.equals(""))
                {
                    btnladoderecho.setEnabled(false);
                }
                 else
                {
                     botonactivado3 = "si";
                      btnterminetodo.setEnabled(true);
                }  
                
                lbatras.setText(rs.getString("atras"));
                String atras =  rs.getString("atras");
                if(atras ==null||atras.equals(""))
                {
                    btnatras.setEnabled(false);
                }
                 else
                {
                     botonactivado4 = "si";
                      btnterminetodo.setEnabled(true);
                } 
               
                String aplicacionfrente = rs.getString("aplicacion_frente");

                if (aplicacionfrente.equals("ninguno")) {
                    aplicacionfrente = "";
                }

                
                
                
                String aplicacionfrentecolor = rs.getString("aplicacion_frente_color");

                if (aplicacionfrentecolor.equals("ninguno")) {
                    aplicacionfrentecolor = "";
                }

                
                
                lugardondesebordara = rs.getString("lugar");
                
                String cantidadfrente = rs.getString("cantidad_frente");
                String cantidadladoderecho = rs.getString("cantidad_lado_derecho");
                String cantidadladoizquierdo = rs.getString("cantidad_lado_izquierdo");
                String cantidadatras = rs.getString("cantidad_atras");
                
                if(cantidadfrente.equals("0") && botonactivado1.equals("si"))
                {
                   btnfrente.setEnabled(true);  
                   btnfrente.setText("Frente");
                   btnfrente.setForeground(Color.green.darker());
                   if(botonactivado1.equals("si"))
                   {
                   listabotones.add("btnfrente");
                   }
                }
                else
                {
                     if(botonactivado1.equals("si"))
                   {
                     btnfrente.setEnabled(true);
                     btnfrente.setText("Cancelar"); 
                     btnfrente.setForeground(Color.red);
                     

                     
                   }
                   else
                   {
                   btnfrente.setEnabled(false);  
                   }
                }
                
                
                
                
                 if(cantidadladoderecho.equals("0")  && botonactivado3.equals("si") )
                {
                   btnladoderecho.setEnabled(true); 
                   btnladoderecho.setText("Lado Derecho");
                   btnladoderecho.setForeground(Color.green.darker());
                   if(botonactivado3.equals("si"))
                   {
                    listabotones.add("btnladoderecho");
                   }
                }
                else
                {
                     if(botonactivado3.equals("si"))
                   {
                     btnladoderecho.setEnabled(true);
                     btnladoderecho.setText("Cancelar"); 
                     btnladoderecho.setForeground(Color.red);
                     

                     
                   }
                   else
                   {
                   btnladoderecho.setEnabled(false);  
                   }
                } 
                 
                 /// lado izquierdo
                 
                 if(cantidadladoizquierdo.equals("0")  && botonactivado2.equals("si"))
                {
                   btnladoizquierdo.setEnabled(true); 
                   btnladoizquierdo.setText("Lado Izquierdo");
                   btnladoizquierdo.setForeground(Color.green.darker());
                   if(botonactivado2.equals("si"))
                   {
                   listabotones.add("btnladoizquierdo");
                   }
                }
                else
                {
                      if(botonactivado2.equals("si"))
                   {
                     btnladoizquierdo.setEnabled(true);
                     btnladoizquierdo.setText("Cancelar"); 
                     btnladoizquierdo.setForeground(Color.red);

                   }
                   else
                   {
                    btnladoizquierdo.setEnabled(false);
                   }
                }
                 
                 
                 
                 
                  if(cantidadatras.equals("0")  && botonactivado4.equals("si"))
                {
                   btnatras.setEnabled(true);
                   btnatras.setText("Atras");
                   btnatras.setForeground(Color.green.darker());
                   if(botonactivado4.equals("si"))
                   {
                    listabotones.add("btnatras");
                   }
                }
                else
                {
                      if(botonactivado4.equals("si"))
                   {
                     btnatras.setEnabled(true);
                     btnatras.setText("Cancelar"); 
                     btnatras.setForeground(Color.red);

                   }
                   else
                   {
                    btnatras.setEnabled(false);
                   }
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
            System.out.println(ex);
        }
        
        datostienda();
        

    }

    
    
    void datostienda() {
        /// busca las ordenes de camisa generadas 

        String numero = lbnumeroventa.getText();
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
                    lbtiendaalaquereplicara.setText(tiendasolicitoarticulos);
                    lbnumero.setText(numerosolicitoarticulos);
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
                        lbtiendaalaquereplicara.setText(tiendaordenenvio);
                        lbnumero.setText(numeroordenenvio);
                    }
                } catch (Exception exx) {
                    
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">"+exx+"");

                }

            }
        }

    }
    
    void agregarfotomontaje() throws FileNotFoundException, IOException  
    {
        
        String numero = lbnumero.getText();
        String numeroventa = lbnumeroventa.getText();
       
        BufferedImage img = null;
        
        String prendasql ="";
        String prendanombresql="";
        String puntadasenfotomontajes = "";
        btnverfotomontaje.setEnabled(false);
        String path ="";

       String sql = "Select extension_imagen,imagen,numero_consecutivo,puntadas_en_fotomontajes from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_bordado= '"+identificadordeprenda+"' and tipo = 'GORRA'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                puntadasenfotomontajes=rs.getString("puntadas_en_fotomontajes");
                consecutivo = rs.getString("numero_consecutivo");
                 
                Imagen imagen = new Imagen();
                Blob blob = rs.getBlob("imagen");
                if (blob == null) 
                {

                    
                    ordencamisaimagencontorno p = new ordencamisaimagencontorno();
                    jPanel1.add(p);
                    jPanel1.repaint();
                    lblImagen.setVisible(false);
                    btnverfotomontaje.setEnabled(false);
                    tienefotomontaje = "no";
                   // btnagregarfotomontaje.setEnabled(true);
                    
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
                    
                } 
                
                else 
                
                {
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) 
                    {
                       
                      JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");

                    }

                    imagen.setImagen(img);
                    lblImagen.setIcon(new ImageIcon(img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
                    lblImagen.setVisible(true);
                    btnverfotomontaje.setEnabled(true);
                    tienefotomontaje = "si";
                    btnverfotomontaje.setEnabled(true);
                    //btnagregarfotomontaje.setEnabled(false);

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
        } catch (SQLException ex) 
        {
           
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
        }
        
        /*
        
         if(puntadasenfotomontajes.equals("si"))
        {

            btnfrente.setEnabled(false);
            btnladoizquierdo.setEnabled(false);
            btnladoderecho.setEnabled(false);
            btnatras.setEnabled(false);
           
            
       
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar nuevo fotomontaje SIN PUNTADAS");
            btnfotomontajesinpuntadas.setEnabled(true);
            btnterminetodo.setEnabled(false);
            
        
        }
        
        
        
         else
        
        
        */
        
        
        if(tienefotomontaje.equals("no"))
        {
        
          
            
            btnatras.setEnabled(false);
            btnladoizquierdo.setEnabled(false);
            btnladoderecho.setEnabled(false);
            btnfrente.setEnabled(false);
            
             JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
             btnfotomontajesinpuntadas.setEnabled(false);
             btnterminetodo.setEnabled(false);
            
     }  

        
        
    }
    
    
     void datosotrasucursal() throws IOException 
     {

        btnreplicar.setEnabled(true);

        String folio = lborden.getText();

        String sql = "Select fecha,hora,cliente,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,numero_sucursal_orden,\n" +
                     "lado_izquierdo,lado_derecho,frente,atras,aplicacion_frente,aplicacion_frente_color,lugar,tienda,numero_sucursal from historial_ordenes_gorra_recibidas where numero = '" + folio + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));

              
                lbcantidad.setText(rs.getString("cantidad"));
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));
                lbnumero.setText(rs.getString("numero_sucursal_orden"));
                
                ladoizquierdonombre = rs.getString("lado_izquierdo");
                ladoderechonombre = rs.getString("lado_derecho");
                frentenombre = rs.getString("frente");
                atrasnombre = rs.getString("atras");
                sucursalqueenvia= rs.getString("tienda");
                numerosucursal= rs.getString("numero_sucursal");
                
                               
                lbfrente.setText(rs.getString("frente"));
                String frente =  rs.getString("frente");
                if(frente ==null||frente.equals(""))
                {
                    btnfrente.setVisible(false);
                    lbfrente.setVisible(false);
                    btnfrente.setEnabled(false);
                    
                }
                else
                {
                   btnfrente.setEnabled(true);  
                }     
                
                lbladoizquierdo.setText(rs.getString("lado_izquierdo"));
                String ladoizquierdo =  rs.getString("lado_izquierdo");
                if(ladoizquierdo ==null||ladoizquierdo.equals("")||ladoizquierdo.equals("ninguno"))
                {
                    btnladoizquierdo.setVisible(false);
                    lbladoizquierdo.setVisible(false);
                    btnladoizquierdo.setEnabled(false); 
                }
                else
                {
                    btnladoizquierdo.setEnabled(true); 
                }
                    
                
                
                lbladoderecho.setText(rs.getString("lado_derecho"));
                 String ladoderecho =  rs.getString("lado_derecho");
                if(ladoderecho ==null||ladoderecho.equals("")||ladoderecho.equals("ninguno"))
                {
                    btnladoderecho.setVisible(false);
                    lbladoderecho.setVisible(false);
                    btnladoderecho.setEnabled(false);
                }
                else
                {
                    btnladoderecho.setEnabled(true); 
                }    
                
                lbatras.setText(rs.getString("atras"));
                String atras =  rs.getString("atras");
                if(atras ==null||atras.equals(""))
                {
                    btnatras.setVisible(false);
                    lbatras.setVisible(false);
                    btnatras.setEnabled(false);
                }
                else
                {
                    btnatras.setEnabled(true);
                }    
               
                String aplicacionfrente = rs.getString("aplicacion_frente");

                if (aplicacionfrente.equals("ninguno")) {
                    aplicacionfrente = "";
                }

                
                
                
                String aplicacionfrentecolor = rs.getString("aplicacion_frente_color");

                if (aplicacionfrentecolor.equals("ninguno")) {
                    aplicacionfrentecolor = "";
                }

               
                
                lugardondesebordara = rs.getString("lugar");
                
               
                
                
                

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        btnreplicar.setEnabled(false);
     
        lbcoloratras.setEnabled(false);
        lbcolorladoizquierdo.setEnabled(false);
        lbcolorladoderecho.setEnabled(false);
        lbcolorfrente.setEnabled(false);

 }
     
 void agregarfotomontajeotrasucursal() throws FileNotFoundException, IOException  
    {
        
        String numero = lborden.getText();
        
        String cliente = "";
        String numeroordensucursal = "";
        String numeroventa = "";
        String numerodeorden ="";
        
      
        BufferedImage img = null;
        btnverfotomontaje.setEnabled(false);
        
        
         if (sucursalqueenvia.equals(tiendalocal))
            
        {
            
      
        numerodeorden = lborden.getText();
        
        String sql1 = "Select numero_sucursal_orden from historial_ordenes_gorra_recibidas where numero = '" + numerodeorden + "' and numero_sucursal = '"+numerosucursal+"' ";

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
                lbnumeroventa.setText(numeroventa);
                

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
        
        
      
 
                
             
                
        
      

        String sql7 = "Select cliente,prenda,tienda,nombre_concepto from historial_ordenes_gorra where numero = '" + numerosucursal + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql7);
            if (rs.next()) {

                cliente = rs.getString("cliente");
                sucursal = rs.getString("tienda");
                identificadordeprenda = rs.getString("nombre_concepto");
                

            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px ;\">"+ex+"");
        }

            codigocliente();
            cliente();
            

        
       

       String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_bordado= '"+identificadordeprenda+"' and tipo = 'GORRA'   ";  ///

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
             btnatras.setEnabled(false);
            btnladoizquierdo.setEnabled(false);
            btnladoderecho.setEnabled(false);
            btnfrente.setEnabled(false);
            
            ordengorraimagen p = new ordengorraimagen();
            jPanel1.add(p);
            jPanel1.repaint();
            lblImagen.setVisible(false);
            btnverfotomontaje.setEnabled(false);
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
            
            
           
        }  

        
            
            
            
            
            
        }
        else

        
        {

       String sql = "Select imagen_nombre,imagen from historial_ordenes_gorra_recibidas where numero = '"+numero+"'  and prenda = 'Gorra'    ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                Imagen imagen = new Imagen();
                Blob blob = rs.getBlob("imagen");
                if (blob == null) 
                {

                    tienefotomontaje = "no";
                   // btnagregarfotomontaje.setEnabled(true);

                    
                } 
                
                else 
                
                {
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) 
                    {
                      JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+""); 
                      

                    }

                    imagen.setImagen(img);
                    lblImagen.setIcon(new ImageIcon(img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
                    lblImagen.setVisible(true);
                    btnverfotomontaje.setEnabled(true);
                    tienefotomontaje = "si";
                    btnverfotomontaje.setEnabled(true);
                    //btnagregarfotomontaje.setEnabled(false);

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

            } //end while
            rs.close();
        } catch (SQLException ex) 
        {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
            
        }
        
        
        
        if(tienefotomontaje.equals("si"))
        {
          

           
            
        
        }
        else
        {
            btnatras.setEnabled(false);
            btnladoizquierdo.setEnabled(false);
            btnladoderecho.setEnabled(false);
            btnfrente.setEnabled(false);
            
            ordengorraimagen p = new ordengorraimagen();
            jPanel1.add(p);
            jPanel1.repaint();
            lblImagen.setVisible(false);
            btnverfotomontaje.setEnabled(false);
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar fotomontaje para poder iniciar el bordado y registrar puntos");
            
            
        }  

        
        }
        
        
    }    
    
 
 
 
 
 
 
    void hilosycolor()
    {
       

        String sql = "Select hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,color1,color2,color3,color4,color5,color6,color7,numero_consecutivo from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_bordado= '"+identificadordeprenda+"' and tipo = 'GORRA'   ";

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
                  lbcolorfrente.setVisible(false);  
                  lbcodigofrente.setVisible(false); 
                }
                else
                {
                  lbcolorfrente.setText(codigo1.toString());
                  lbcodigofrente.setText(hilo1.toString());
                }  
                
                if(codigo2.equals("ninguno"))
                {
                  lbcolorladoizquierdo.setVisible(false); 
                  lbcodigoladoizquierdo.setVisible(false); 
                }
                else
                {
                  lbcolorladoizquierdo.setText(codigo2.toString());
                  lbcodigoladoizquierdo.setText(hilo2.toString());
                }  
                
                 if(codigo3.equals("ninguno"))
                {
                  lbcolorladoderecho.setVisible(false); 
                  lbcodigoladoderecho.setVisible(false); 
                }
                else
                {
                  lbcolorladoderecho.setText(codigo3.toString());
                  lbcodigoladoderecho.setText(hilo3.toString());
                }  
                
                if(codigo4.equals("ninguno"))
                {
                  lbcoloratras.setVisible(false);  
                  lbcodigoatras.setVisible(false);  
                }
                else
                {
                  lbcoloratras.setText(codigo4.toString());
                  lbcodigoatras.setText(hilo4.toString());
                }    
                
             
                
                    
                
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } 
        
    }
    
    
    
    
    
    
    
    
    
    
    void actualizarlascantidadesbordadas(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_gorra set "+ubicacion+"='" + lbcantidad.getText() + "',fecha='"+dia()+"' where numero = '"+lborden.getText()+"'  ");
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
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    void actualizarlascantidadesbordadascancelar(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_gorra set "+ubicacion+"='0' where numero = '"+lborden.getText()+"'  ");
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
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    void actualizarlascantidadesbordadasotrasucursal(String ubicacion)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set "+ubicacion+"='" + lbcantidad.getText() + "',fecha='"+dia()+"' where numero = '"+lborden.getText()+"'  ");
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
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         try {
            agregarfotomontajeotrasucursal();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisa.class.getName()).log(Level.SEVERE, null, ex);
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
                    pst.setString(7, numerosucursalordengorra);
                    pst.setString(8, sucursal);
                } 
                
                
                
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }

            
           if(cantidadaplicacion==null || cantidadaplicacion.equals("")||cantidadaplicacion.equals(" "))
           {
               cantidadaplicacion = "0";
           }
            
           int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
           
           
           if(cantidadaplicacionint > 0)
           {
               int cantidadprendasint = Integer.parseInt(lbcantidad.getText());
               int totalaplicaciones = cantidadprendasint * cantidadaplicacionint;
               
               String Insertaraplicacion = "INSERT INTO historial_bordados_existencia(numero,dia,hora,articulo,concepto,cantidad,numero_orden,sucursal) VALUES (?,?,?,?,?,?,?,?)";

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
                    pst.setString(7, numerosucursalordengorra);
                    pst.setString(8, sucursal);
                } 
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
                pst.setString(2, sucursalqueenvia);
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

            
           if(cantidadaplicacion==null || cantidadaplicacion.equals("")||cantidadaplicacion.equals(" "))
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
                pst.setString(2, sucursalqueenvia);
                pst.setString(3, dia());
                pst.setString(4, hora());
                pst.setString(5, aplicacioninsertar);
                pst.setString(6, identificadordeprenda);
                pst.setString(7, String.valueOf(totalaplicaciones));
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
            if (rs.next()) {
                
               codigocliente = rs.getString("codigo_cliente");
                
            }


        } catch (SQLException ex) {
            System.out.println (ex);
        }
    }
     
    void estacompletalaorden()
    {
        
        String cantidad = "0";
        int tienecantidad = 0;
        int botonesactivados = 0;
        
         String sql = "Select cantidad,lado_izquierdo,cantidad_lado_izquierdo,lado_derecho,cantidad_lado_derecho,frente,cantidad_frente,atras,cantidad_atras from "+nombredelatabla+" where numero = '"+lborden.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cantidad = rs.getString("cantidad");   
                String cantidadladoizquierdo = rs.getString("cantidad_lado_izquierdo");
                String ladoizquierdo = rs.getString("lado_izquierdo");
                
                String cantidadladoderecho = rs.getString("cantidad_lado_derecho");
                String ladoderecho = rs.getString("lado_derecho");
                
                String cantidadfrente = rs.getString("cantidad_frente");
                String frente = rs.getString("frente");
                
                String cantidadatras = rs.getString("cantidad_atras");
                String atras = rs.getString("atras");
                
                
                if(ladoizquierdo==null || ladoizquierdo.equals("")||ladoizquierdo.equals(" ") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                } 
                
                
                if(ladoderecho==null || ladoderecho.equals("")||ladoderecho.equals(" ") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(frente==null || frente.equals("")||frente.equals(" ") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
                if(atras==null || atras.equals("")||atras.equals(" ") )
                {
                    
                    
                }
                else
                {
                   botonesactivados = botonesactivados + 1; 
                }
                
               
           
           
                ////////////////////////////////////////////////////////////////
                
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
                
                if(cantidadatras.equals("0") )
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
                if(cantidadfrente.equals("0"))
                {
                    
                    
                }
                else
                {
                   tienecantidad = tienecantidad + 1;
                }
                
               
           
            
           
           if(tienecantidad == botonesactivados)
           {
               try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set estatus_orden='realizada' ,fecha='"+dia()+"' where numero='" + lborden.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
                }
               
           }
           else
           {
               try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE "+nombredelatabla+" set estatus_orden='generada' where numero='" + lborden.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:15px;\">"+ex+"");
                }
               
           }    


        }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
    }
    
    
     void sumapuntos()
    {
   
        
         String sql = "Select cantidad,cantidad_lado_izquierdo,puntadas_lado_izquierdo,"
                  + "cantidad_lado_derecho,puntadas_lado_derecho,"
                  + "cantidad_frente,puntadas_frente,"
                  + "cantidad_atras,puntadas_atras,"
                  + "aplicacion_frente from "+nombredelatabla+" where numero = '"+lborden.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String cantidad = rs.getString("cantidad");   
                String cantidadladoizquierdo = rs.getString("cantidad_lado_izquierdo");
                String ladoizquierdo = rs.getString("puntadas_lado_izquierdo");
                String cantidadladoderecho = rs.getString("cantidad_lado_derecho");
                String ladoderecho = rs.getString("puntadas_lado_derecho");
                String cantidadatras = rs.getString("cantidad_atras");
                String atras = rs.getString("puntadas_atras");
                String cantidadfrente = rs.getString("cantidad_frente");
                String frente = rs.getString("puntadas_frente");
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
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    void verfotomontajelocal()
    {
        String cliente = lbcliente.getText();
      
        String prendafotomontaje = "";
        String nombreprendafotomontaje = "";
        String rutadelarchivo = "";
        String existe = "";
        
        //// prenda del fotomontaje
        String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_bordado= '"+identificadordeprenda+"' and tipo = 'GORRA'   ";

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
    
    
    void verfotomontajerecibido()
    {
        
        String cliente = lbcliente.getText();
      
        String prendafotomontaje = "";
        String nombreprendafotomontaje = "";
        String rutadelarchivo = "";
        String existe = "";
        
        //// prenda del fotomontaje
        String sql = "Select imagen,imagen_nombre from historial_ordenes_gorra_recibidas where numero = '"+lborden.getText()+"'   ";

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

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
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
                        lbidentificador.setText(rs.getString("identificador"));

                    }

                } catch (Exception e) {
                   
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+e+"");

                }
        
    }
             
             
             
    
     
     void descargarponchado(String ubicacion,String ubicacionnombre)
     {
         JFileChooser fs = new JFileChooser();
        

         try (
                 PreparedStatement ps = cn.prepareStatement("select " + ubicacion + "," + ubicacionnombre + " from historial_ordenes_gorra_recibidas where numero = '" + lborden.getText() + "' ")) {
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

        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lborden = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        btnreplicar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbfechaentrega = new javax.swing.JLabel();
        lbhoraentrega = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lblImagen = new javax.swing.JLabel();
        lbnumeroventa = new javax.swing.JLabel();
        lbtienda = new javax.swing.JLabel();
        lbnumero = new javax.swing.JLabel();
        lbrutaladoderecho = new javax.swing.JLabel();
        lbrutafrente = new javax.swing.JLabel();
        lbrutaimagen = new javax.swing.JLabel();
        lbrutaladoizquierdo = new javax.swing.JLabel();
        lbrutaatras = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        lbtiendaalaquereplicara = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        btnverfotomontaje = new javax.swing.JButton();
        btnatras = new javax.swing.JButton();
        btnladoizquierdo = new javax.swing.JButton();
        btnfrente = new javax.swing.JButton();
        btnladoderecho = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        lbcoloratras = new javax.swing.JLabel();
        lbcolorfrente = new javax.swing.JLabel();
        lbcolorladoizquierdo = new javax.swing.JLabel();
        lbcolorladoderecho = new javax.swing.JLabel();
        btnterminetodo = new javax.swing.JButton();
        lbnombrecomercial = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
        lbcodigoladoderecho = new javax.swing.JLabel();
        lbcodigoladoizquierdo = new javax.swing.JLabel();
        lbcodigofrente = new javax.swing.JLabel();
        lbcodigoatras = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbidentificadordeprenda = new javax.swing.JLabel();
        btneliminar = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        jSeparator3 = new javax.swing.JSeparator();
        lbatrasnombre = new javax.swing.JLabel();
        lbfrentenombre = new javax.swing.JLabel();
        lbladoizquierdonombre = new javax.swing.JLabel();
        lbladoderechonombre = new javax.swing.JLabel();
        lbatras = new javax.swing.JLabel();
        lbladoderecho = new javax.swing.JLabel();
        lbladoizquierdo = new javax.swing.JLabel();
        lbfrente = new javax.swing.JLabel();
        btnvercolorido = new javax.swing.JButton();
        btnfotomontajesinpuntadas = new javax.swing.JButton();
        btndatos = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden gorra");
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

        btnreplicar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreplicar.setText("Replicar");
        btnreplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicarActionPerformed(evt);
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

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad.setText("0");
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);
        jPanel1.add(lblImagen);
        lblImagen.setBounds(10, 10, 910, 650);

        lbnumeroventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtienda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbtienda.setText("lbtienda");
        lbtienda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumero.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnumero.setText("00000000");
        lbnumero.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutaladoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutafrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutaimagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutaladoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutaatras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtiendaalaquereplicara.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbtiendaalaquereplicara.setText("00000000");
        lbtiendaalaquereplicara.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Numero Sucursal:");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        btnatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnatras.setText("Atras");
        btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasActionPerformed(evt);
            }
        });

        btnladoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoizquierdo.setText("Lado Izquierdo");
        btnladoizquierdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdoActionPerformed(evt);
            }
        });

        btnfrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnfrente.setText("Frente");
        btnfrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrenteActionPerformed(evt);
            }
        });

        btnladoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnladoderecho.setText("Lado Derecho");
        btnladoderecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ubicación");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Color");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Puntos");
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

        btnterminetodo.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnterminetodo.setForeground(new java.awt.Color(0, 102, 0));
        btnterminetodo.setText("***Termine todo***");
        btnterminetodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnterminetodoActionPerformed(evt);
            }
        });

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel20.setText("Nombre comercial");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel18.setText("Bordacliente");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoladoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoladoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigofrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigofrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigoatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigoatras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Codigo");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificadordeprenda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbidentificadordeprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminar.setText("Editar bordado");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Sucursal:");
        jLabel19.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("No. de venta");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(153, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Observacion");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        lbatrasnombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbatrasnombre.setForeground(new java.awt.Color(255, 0, 0));
        lbatrasnombre.setText("Atras");

        lbfrentenombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfrentenombre.setForeground(new java.awt.Color(255, 0, 0));
        lbfrentenombre.setText("Frente");

        lbladoizquierdonombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdonombre.setForeground(new java.awt.Color(255, 0, 0));
        lbladoizquierdonombre.setText("Lado izquierdo");

        lbladoderechonombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderechonombre.setForeground(new java.awt.Color(255, 0, 0));
        lbladoderechonombre.setText("Lado derecho");

        lbatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbatras.setForeground(new java.awt.Color(255, 0, 0));
        lbatras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderecho.setForeground(new java.awt.Color(255, 0, 0));
        lbladoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbladoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdo.setForeground(new java.awt.Color(255, 0, 0));
        lbladoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfrente.setForeground(new java.awt.Color(255, 0, 0));
        lbfrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbfrente.setOpaque(true);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(lbidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel18)
                        .addGap(6, 6, 6)
                        .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel16)
                        .addGap(6, 6, 6)
                        .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6)
                                .addGap(18, 18, 18)
                                .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(lbtienda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbtiendaalaquereplicara, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btndatos)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbrutaladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbrutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbrutaatras, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbrutafrente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbrutaladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbfrentenombre, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbladoizquierdonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbladoderechonombre, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbatrasnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbfrente, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                            .addComponent(lbladoderecho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbladoizquierdo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbatras, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1)
                                    .addComponent(jSeparator3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnfotomontajesinpuntadas))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(lbcolorfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(lbcodigofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(lbcolorladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(lbcodigoladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(lbcolorladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(lbcodigoladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnatras, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(lbcoloratras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(14, 14, 14)
                                                .addComponent(lbcodigoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lborden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnvercolorido, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnfotomontajesinpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolorfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcodigofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolorladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcodigoladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolorladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcodigoladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcoloratras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcodigoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbatrasnombre)
                            .addComponent(lbatras, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbfrentenombre)
                            .addComponent(lbfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbladoizquierdonombre)
                            .addComponent(lbladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbladoderechonombre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                                .addComponent(btnterminetodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbtienda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbtiendaalaquereplicara, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(btndatos)
                                .addGap(10, 10, 10))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbrutafrente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbrutaladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbrutaatras, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbrutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbrutaladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 78, Short.MAX_VALUE))
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
        
        if(ordenesporrealizar.ventanaordenesbordadogenerada==true)
        {
            ordenesporrealizar.btnactualizar.doClick();
        }

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordengorra = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
      
         nombredelatabla = "historial_ordenes_gorra";

        try {
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordengorra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        codigocliente();
        
        cliente();
        
         hilosycolor();
        
        try {
            agregarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordengorra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        if(enquesucursalsebordara.equals("Otra sucursal") && (numerosucursalordengorra == null || numerosucursalordengorra.equals("") || numerosucursalordengorra.equals(" ") ) )
        {
            
         btnterminetodo.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Recuerda que Aqui solo replicas los ponchados y el fotomontaje");
        
        }
       
        sumapuntos();
        
    }
else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
        nombredelatabla = "historial_ordenes_gorra_recibidas";
        
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
        
         
         
         
         sumapuntos();
    }


        AudioClip sonido;
        if (tieneunaobservacion.equals("si")) {
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/tienesunaobservacion.wav"));
            sonido.play();

        }

        
    }//GEN-LAST:event_formWindowOpened

    private void btnladoderechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoActionPerformed
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
             if (btnladoderecho.getText().equals("Cancelar")) 
            {
                if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de lado derecho?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    String ubicacion = "cantidad_lado_derecho";
            actualizarlascantidadesbordadascancelar((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO GORRA LADO DERECHO "+ladoderechonombre+ "";
            aplicacioninsertar = "";
            nombredelatabla = "historial_ordenes_gorra";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordadoscancelar((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad) ;
            estacompletalaorden();
            sumapuntos();   
                    
                }
            }
             else
            {     
            String ubicacion = "cantidad_lado_derecho";
            actualizarlascantidadesbordadas((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO GORRA LADO DERECHO "+ladoderechonombre+ "";
            aplicacioninsertar = "";
            nombredelatabla = "historial_ordenes_gorra";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
            estacompletalaorden();
            sumapuntos();   
           }
            
        }
         else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaladoderecho.setText(fl);
            btnladoderecho.setEnabled(false);
            descargado = 1;

        }
        
        }
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
             int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="lado_derecho_ponchado";
                String ubicacionnombre ="lado_derecho_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
            {
            
            String ubicacion = "cantidad_lado_derecho";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO GORRA LADO DERECHO "+ladoderechonombre+ "";
            aplicacioninsertar = "";
            nombredelatabla = "historial_ordenes_gorra_recibidas";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion);
            estacompletalaorden();
            sumapuntos();  
            }
            
        }
        
        btndatos.doClick();
    }//GEN-LAST:event_btnladoderechoActionPerformed

    private void btnreplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicarActionPerformed


        String tipo = lbtipo.getText();
        String numerosucursal =lbnumero.getText();
     
                

        String path = "";
        String tiendaalaquesereplicara = lbtiendaalaquereplicara.getText();
        String strIP = "";
        String strBD = "";
        String strBDlocal = "";
        
         
         
         String nombrearchivo1 ="";
         String nombrearchivo2="";
         String nombrearchivo3 ="";
         String nombrearchivo4 ="";
         String nombrearchivo5 ="";
         String nombrearchivo6 ="";
         
         
        
        File file = new File("C:\\sistema\\configuracion.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String str[] = line.split(":");
                strBDlocal = str[1];
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
                strIP = str[0];
                strBD = str[1];
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        Connection conn = null;

        iptraspaso = strIP;
        tienda_traspaso = strBD;

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
        Object ponchado1 = lbrutaladoizquierdo.getText();
        if (ponchado1 == null || ponchado1.equals("") ) {

        } else {
            try {
                String filePath = lbrutaladoizquierdo.getText();
                File archivo = new File(filePath);
                 nombrearchivo1 =archivo.getName();
                input = new FileInputStream(new File(filePath));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {

                    String sql2 = "UPDATE historial_ordenes_gorra_recibidas set lado_izquierdo_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();
                    
                    System.out.println("\nlado_izquierdo_ponchado");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set lado_izquierdo_ponchado_nombre='"+nombrearchivo1+"' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  "); 
                   pst.executeUpdate();
                    System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }   
                

            
              ///ponchado2
        Object ponchado2 = lbladoderecho.getText();
        if (ponchado2 == null || ponchado2.equals("") || ponchado2.equals(" ")) {

        } else {
            try {
                String filePath2 = lbladoderecho.getText();
                File archivo2 = new File(filePath2);
                 nombrearchivo2 =archivo2.getName();
                input2 = new FileInputStream(new File(filePath2));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              try {

                    String sql2 = "UPDATE historial_ordenes_gorra_recibidas set lado_derecho_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input2);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nlado_derecho_ponchado");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set lado_derecho_ponchado_nombre='"+nombrearchivo2+"' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  "); 
                   pst.executeUpdate();
                   System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                 
                 
        } 
                
              
            
                
                  ///ponchado3
        Object ponchado3 = lbatras.getText();
        if (ponchado3 == null || ponchado3.equals("") || ponchado3.equals(" ")) {

        } else {
            try {
                String filePath3 = lbatras.getText();
                File archivo3 = new File(filePath3);
                 nombrearchivo3 =archivo3.getName();
                input3 = new FileInputStream(new File(filePath3));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {

                    String sql2 = "UPDATE historial_ordenes_gorra_recibidas set atras_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input3);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set atras_ponchado_nombre='"+nombrearchivo3+"' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  "); 
                   pst.executeUpdate();
                   System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }
                
                
            
                     //ponchado 4
        Object ponchado4 = lbrutafrente.getText();

        if (ponchado4 == null || ponchado4.equals("") || ponchado4.equals(" ")) {

        } else {
            try {
                String filePath4 = lbrutafrente.getText();
                File archivo4 = new File(filePath4);
                 nombrearchivo4 =archivo4.getName();
                input4 = new FileInputStream(new File(filePath4));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {

                    String sql2 = "UPDATE historial_ordenes_gorra_recibidas set frente_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input4);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set frente_ponchado_nombre='"+nombrearchivo4+"' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  "); 
                   pst.executeUpdate();
                   System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }
                
                
                
                                   //ponchado5
      
                
           /// imagen jlabel
        
        Object imagen =rutaimagen;

        if (imagen == null || imagen.equals("") || imagen.equals(" ")) {

        } else {
            try {
                String filePath6 = rutaimagen;
                File archivo6 = new File(filePath6);
                 nombrearchivo6 =archivo6.getName();
                input6 = new FileInputStream(new File(filePath6));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {

                    String sql2 = "UPDATE historial_ordenes_gorra_recibidas set imagen=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input6);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set imagen_nombre='"+nombrearchivo6+"' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  "); 
                   pst.executeUpdate();
                   System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }
        
        
         try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set estatus='por guardar' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = 'gorra'  "); 
                   pst.executeUpdate();
                   System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">"+e+"");
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Revisa tu hamachi");
            
            return;
        }

       
        
        
        if (traspaso > 0) {
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden se inserto correctamente en la otra sucursal");
            
            String numero = lbnumero.getText();
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_gorra SET estatus='enviado' WHERE numero='" + numero + "'");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }
           
        
        ordenesporrealizar.btnactualizar.doClick();
        this.dispose();

        }
        else
        {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden NO se inserto correctamente en la otra sucursal");
            
        } 
       
        


       
    }//GEN-LAST:event_btnreplicarActionPerformed

    private void btnfrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrenteActionPerformed

        
        
        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local") )
        {
            if (btnfrente.getText().equals("Cancelar")) 
            {
                if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de frente gorra?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    String ubicacion = "cantidad_frente";
                    actualizarlascantidadesbordadascancelar((String) ubicacion);
                    String cantidadaplicacion = "0";
                    ubicacioninsertar = "BORDADO GORRA FRENTE " + frentenombre + "";
                    aplicacioninsertar = "APLICACION GORRA FRENTE";
                    String cantidad = lbcantidad.getText();
                    nombredelatabla = "historial_ordenes_gorra";
                    agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
                    agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
                    estacompletalaorden();
                    sumapuntos();

                }

            }
            else
            {
                
            String ubicacion = "cantidad_frente";
            actualizarlascantidadesbordadas((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO GORRA FRENTE "+frentenombre+ "";
            aplicacioninsertar = "APLICACION GORRA FRENTE";
            String cantidad = lbcantidad.getText();
            nombredelatabla = "historial_ordenes_gorra";
            agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
            estacompletalaorden();
            sumapuntos();    
        
           }
        }
         else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local") && (tienenumerodesucursal.equals("no")) )
        {

        JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutafrente.setText(fl);
            btnfrente.setEnabled(false);
            descargado = 1;

        }
        
        }
         else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
            
             int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="frente_ponchado";
                String ubicacionnombre ="frente_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
            {
            
            String ubicacion = "cantidad_frente";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO GORRA FRENTE "+frentenombre+ "";
            aplicacioninsertar = "APLICACION GORRA FRENTE";
            nombredelatabla = "historial_ordenes_gorra_recibidas";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            estacompletalaorden();
            sumapuntos();  
                
            }
            
            
            
            
            
            
            
              
            
        }
    
        
        btndatos.doClick();
    }//GEN-LAST:event_btnfrenteActionPerformed

    private void btnladoizquierdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoActionPerformed

        if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
             if (btnladoizquierdo.getText().equals("Cancelar")) 
            {
                if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de lado izquierdo?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    String ubicacion = "cantidad_lado_izquierdo";
                    actualizarlascantidadesbordadascancelar((String) ubicacion);
                    String cantidadaplicacion = "0";
                    ubicacioninsertar = "BORDADO GORRA LADO IZQUIERDO "+ladoizquierdonombre+ "";
                    aplicacioninsertar = "";
                    String cantidad = lbcantidad.getText();
                    nombredelatabla = "historial_ordenes_gorra";
                    agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
                    agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
                    estacompletalaorden();
                    sumapuntos();

                }

            }
            else
            {
            
            String ubicacion = "cantidad_lado_izquierdo";
            actualizarlascantidadesbordadas((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO GORRA LADO IZQUIERDO "+ladoizquierdonombre+ "";
            aplicacioninsertar = "";
            nombredelatabla = "historial_ordenes_gorra";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion);
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
            estacompletalaorden();
            sumapuntos();   
            
            }
            
        }
         else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaladoizquierdo.setText(fl);
            btnladoizquierdo.setEnabled(false);
            descargado = 1;

        }
       }
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
            
            
             int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="lado_izquierdo_ponchado";
                String ubicacionnombre ="lado_izquierdo_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
            else if (respuesta == JOptionPane.NO_OPTION) 
            {
            nombredelatabla = "historial_ordenes_gorra_recibidas";
            String ubicacion = "cantidad_lado_izquierdo";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO GORRA LADO IZQUIERDO "+ladoizquierdonombre+ "";
            aplicacioninsertar = "";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion);
            estacompletalaorden();
            sumapuntos(); 
            }
            
        }
        
        btndatos.doClick();
    }//GEN-LAST:event_btnladoizquierdoActionPerformed

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed

       if(lugardondesebordara.equals("Esta sucursal") && tipotabla.equals("Local"))
        {
            
             if (btnatras.getText().equals("Cancelar")) 
            {
                if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cancelar este bordado de Atras?", "WARNING",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
                {
                    String ubicacion = "cantidad_atras";
                    actualizarlascantidadesbordadascancelar((String) ubicacion);
                    String cantidadaplicacion = "0";
                    ubicacioninsertar = "BORDADO GORRA ATRAS " + atrasnombre + "";
                    aplicacioninsertar = "";
                    nombredelatabla = "historial_ordenes_gorra";
                    String cantidad = lbcantidad.getText();
                    agregarexistenciabordadoscancelar((String) ubicacioninsertar, (String) aplicacioninsertar, (String) cantidadaplicacion);
                    agregaralsurtidasalhistorialdeventascancelar((String) ubicacioninsertar, (String) cantidad);
                    estacompletalaorden();
                    sumapuntos();
                    
                }   
            }
            else
            {        
            String ubicacion = "cantidad_atras";
            actualizarlascantidadesbordadas((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO GORRA ATRAS "+atrasnombre+ "";
            aplicacioninsertar = "";
            nombredelatabla = "historial_ordenes_gorra";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
            estacompletalaorden();
            sumapuntos();    
            }

        }
         else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Local"))
        {
        
        JFileChooser adjuntar = new JFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaatras.setText(fl);
            btnatras.setEnabled(false);
            descargado = 1;

        }
        
        }
        else if(lugardondesebordara.equals("Otra sucursal") && tipotabla.equals("Recibida") )
        {
              int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea descargar el ponchado o ponerla como realizada???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Descargar Ponchado", "Poner como realizado"}, "Descargar Ponchado");
            
            if (respuesta == JOptionPane.YES_OPTION) 
            {
                String ubicacion ="atras_ponchado";
                String ubicacionnombre ="atras_ponchado_nombre";
                        
                descargarponchado((String) ubicacion,(String) ubicacionnombre); 
                
            }
           else if (respuesta == JOptionPane.NO_OPTION) 
            {
            
            
            String ubicacion = "cantidad_atras";
            actualizarlascantidadesbordadasotrasucursal((String) ubicacion);
            String cantidadaplicacion = "0";
            ubicacioninsertar = "BORDADO GORRA ATRAS "+atrasnombre+ "";
            aplicacioninsertar = "";
            nombredelatabla = "historial_ordenes_gorra_recibidas";
            String cantidad = lbcantidad.getText();
            agregarexistenciabordadosotrasucursal((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion); 
            estacompletalaorden();
            sumapuntos();   
            
            }
            
        }
       
       btndatos.doClick();
       
    }//GEN-LAST:event_btnatrasActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventanaordengorra = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed

        if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
        
        verfotomontajelocal();
        
    }
    else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
        verfotomontajerecibido();
    }
            
        
    }//GEN-LAST:event_btnverfotomontajeActionPerformed

    private void btnterminetodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnterminetodoActionPerformed

        terminetodo = "si";

        for(int i = 0; i < listabotones.size(); i++)
        {
            Object boton =  listabotones.get(i);

            if(boton.equals("btnfrente"))
            {
                if(btnfrente.getText().equals("Cancelar"))
                {
                    
                }
                else
                {    
                btnfrente.doClick();
                }
            }
            else if(boton.equals("btnladoderecho"))
            {
                 if(btnladoderecho.getText().equals("Cancelar"))
                {
                    
                }
                else
                {
                btnladoderecho.doClick();
                }
            }
            else if(boton.equals("btnladoizquierdo"))
            {
                if(btnladoderecho.getText().equals("Cancelar"))
                {
                    
                }
                else
                {
                btnladoizquierdo.doClick();
                }
            }
            else if(boton.equals("btnatras"))
            {
                if(btnladoderecho.getText().equals("Cancelar"))
                {
                    
                }
                else
                {
                btnatras.doClick();
                }
            
            }

        }

        terminetodo = "no";
        btnterminetodo.setEnabled(false);
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden se actualizó correctamente");
        
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
            bordadosdelclienteeditar.lbidentificador.setText(lbidentificador.getText());
            bordadosdelclienteeditar.lbcodigocliente.setText(codigocliente);
            bordadosdelclienteeditar.lbconsecutivo.setText(consecutivo);
            bordadosdelclienteeditar.txtidentificadordeprenda.setText(identificadordeprenda);

            bordadosdelclienteeditar.lbprenda.setText("GORRA");

        }

    }//GEN-LAST:event_btneliminarActionPerformed

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

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigocliente+"' and nombre_bordado = '"+identificadordeprenda+"' and tipo = 'GORRA' and numero_consecutivo = '"+consecutivo+"' ";

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
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"',puntadas_en_fotomontajes ='no' where codigo='"+codigocliente+"' and nombre_bordado = '"+identificadordeprenda+"' and tipo = 'GORRA' and numero_consecutivo = '"+consecutivo+"' ");
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

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed

        if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
    {
      
         nombredelatabla = "historial_ordenes_gorra";

        try {
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordengorra.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        codigocliente();
        
        cliente();
        
         hilosycolor();
        
        try {
            agregarfotomontaje();
        } catch (IOException ex) {
            Logger.getLogger(ordengorra.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(enquesucursalsebordara.equals("Otra sucursal") && (numerosucursalordengorra == null || numerosucursalordengorra.equals("") || numerosucursalordengorra.equals(" ") ) )
        {
        btnterminetodo.setEnabled(false);
         JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Recuerda que Aqui solo replicas los ponchados y el fotomontaje");
        
        }
        sumapuntos();
        
    }
else if(enquesucursalsebordara.equals("Otra sucursal") && tipotabla.equals("Recibida"))    
    {
        nombredelatabla = "historial_ordenes_gorra_recibidas";
        
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
        
         
         
         
         sumapuntos();
    }


        AudioClip sonido;
        if (tieneunaobservacion.equals("si")) {
            sonido = java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/tienesunaobservacion.wav"));
            sonido.play();

        }

        
        
        
        
    }//GEN-LAST:event_btndatosActionPerformed

 

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
            java.util.logging.Logger.getLogger(ordengorra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordengorra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordengorra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordengorra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ordengorra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnfotomontajesinpuntadas;
    private javax.swing.JButton btnfrente;
    private javax.swing.JButton btnladoderecho;
    private javax.swing.JButton btnladoizquierdo;
    private javax.swing.JButton btnreplicar;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnterminetodo;
    private javax.swing.JButton btnvercolorido;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    public static javax.swing.JLabel lbatras;
    private javax.swing.JLabel lbatrasnombre;
    public static javax.swing.JLabel lbcantidad;
    public static javax.swing.JLabel lbcliente;
    public javax.swing.JLabel lbcodigoatras;
    public javax.swing.JLabel lbcodigofrente;
    public javax.swing.JLabel lbcodigoladoderecho;
    public javax.swing.JLabel lbcodigoladoizquierdo;
    public javax.swing.JLabel lbcoloratras;
    public javax.swing.JLabel lbcolorfrente;
    public javax.swing.JLabel lbcolorladoderecho;
    public javax.swing.JLabel lbcolorladoizquierdo;
    public static javax.swing.JLabel lbfechaentrega;
    public static javax.swing.JLabel lbfrente;
    private javax.swing.JLabel lbfrentenombre;
    public static javax.swing.JLabel lbhoraentrega;
    public static javax.swing.JLabel lbidentificador;
    public static javax.swing.JLabel lbidentificadordeprenda;
    private javax.swing.JLabel lblImagen;
    public static javax.swing.JLabel lbladoderecho;
    private javax.swing.JLabel lbladoderechonombre;
    public static javax.swing.JLabel lbladoizquierdo;
    private javax.swing.JLabel lbladoizquierdonombre;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lborden;
    private javax.swing.JLabel lbrutaatras;
    private javax.swing.JLabel lbrutafrente;
    private javax.swing.JLabel lbrutaimagen;
    private javax.swing.JLabel lbrutaladoderecho;
    private javax.swing.JLabel lbrutaladoizquierdo;
    public javax.swing.JLabel lbsumapuntos;
    public static javax.swing.JLabel lbtienda;
    public static javax.swing.JLabel lbtiendaalaquereplicara;
    public static javax.swing.JLabel lbtipo;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
