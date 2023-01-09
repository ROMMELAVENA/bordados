package sistemabordadores;

import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.ColorSupported;
import javax.print.attribute.standard.PrinterName;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ordencamisaanteriores extends javax.swing.JFrame {

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

    private PreparedStatement pst;

    

    public ordencamisaanteriores() {
        initComponents();
        ventanaordencamisaanteriores = true;

        lbmangaderecha.setEnabled(false);
        lbmangaizquierda.setEnabled(false);
        lbpechoderechonombre.setEnabled(false);
        lbpechoizquierdonombre.setEnabled(false);
        lbespalda.setEnabled(false);
        lbnumeroventa.setVisible(false);
        lbnumero.setVisible(false);
        lbrutaimagen.setVisible(false);
        lbrutamangaderecha.setVisible(false);
        lbrutapechoizquierdo.setVisible(false);
        lbrutapechoderecho.setVisible(false);
        lbrutaespalda.setVisible(false);
        lbtipo.setVisible(false);
        lbnombreconcepto.setVisible(false);

        topes();

        
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
        
        datostienda();

        String sql = "Select fecha,hora,cliente,numero_venta,cantidad,cantidad,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,"
                + "   pecho_izquierdo,pecho_derecho,manga_izquierda,manga_derecha,espalda,"
                + "   pecho_izquierdo_nombre,pecho_derecho_nombre,manga_izquierda_nombre,manga_derecha_nombre,espalda_nombre,"
                + "   aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,   "
                + "   aplicacion_pecho_izquierdo_color,aplicacion_pecho_derecho_color,aplicacion_manga_izquierda_color,aplicacion_manga_derecha_color,aplicacion_espalda_color,"
                + "   lugar,estatus_orden,nombre_concepto from historial_ordenes_camisa where numero = '" + folio + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));
                lbprenda.setText(rs.getString("prenda"));
                String prenda =(rs.getString("prenda"));
                
                if(prenda.contains("Camisa"))
                {
                    lbtitulo.setText("Orden de Camisa");
                }
                else if(prenda.contains("Chamarra desmontable"))
                {
                    lbtitulo.setText("Orden de Chamarra");
                }
                else if(prenda.contains("Chaleco"))
                {
                    lbtitulo.setText("Orden de Chamarra");
                }
                else if(prenda.contains("Camisola"))
                {
                    lbtitulo.setText("Orden de Camisola");
                }
                 else if(prenda.contains("Chamarra rompevientos"))
                {
                    lbtitulo.setText("Orden de Chamarra rompevientos");
                }
                else if(prenda.contains("Playera"))
                {
                    lbtitulo.setText("Orden de Playera");
                }

                lbmangaderecha.setText(rs.getString("manga_derecha"));
                //lbmangaderechanombre.setText(rs.getString("manga_derecha_nombre"));
                Object mangaderecha = rs.getString("manga_derecha");
                if (mangaderecha == null | mangaderecha.equals("")) {
                    jLabel2.setVisible(false);
                    btnmangaderecha.setVisible(false);
                }

                lbmangaizquierda.setText(rs.getString("manga_izquierda"));
                //lbmangaizquierdanombre.setText(rs.getString("manga_izquierda_nombre"));
                Object mangaizquierda = rs.getString("manga_izquierda");
                if (mangaizquierda == null | mangaizquierda.equals("")) {
                    jLabel3.setVisible(false);
                    btnmangaizquierda.setVisible(false);
                }

                lbpechoderecho.setText(rs.getString("pecho_derecho"));
                lbpechoderechonombre.setText(rs.getString("pecho_derecho_nombre"));
                Object pechoderecho = rs.getString("pecho_derecho");
                if (pechoderecho == null | pechoderecho.equals("")) {
                    jLabel4.setVisible(false);
                    btnpechoderecho.setVisible(false);
                }

                lbpechoizquierdo.setText(rs.getString("pecho_izquierdo"));
                lbpechoizquierdonombre.setText(rs.getString("pecho_izquierdo_nombre"));
                Object pechoizquierdo = rs.getString("pecho_izquierdo");
                if (pechoizquierdo == null | pechoizquierdo.equals("")) {
                    jLabel5.setVisible(false);
                    btnpechoizquierdo.setVisible(false);
                }

                lbespalda.setText(rs.getString("espalda"));
                //lbespaldanombre.setText(rs.getString("espalda_nombre"));
                Object espalda = rs.getString("espalda");
                if (espalda == null | espalda.equals("")) {
                    jLabel1.setVisible(false);
                    btnespalda.setVisible(false);
                }

                String aplicacionpechoizquierdo = rs.getString("aplicacion_pecho_izquierdo");

                if (aplicacionpechoizquierdo.equals("ninguno")) {
                    aplicacionpechoizquierdo = "";
                }

                lbaplicacionpechoizquierdo.setText(aplicacionpechoizquierdo);

                String aplicacionpechoizquierdocolor = rs.getString("aplicacion_pecho_izquierdo_color");

                if (aplicacionpechoizquierdocolor.equals("ninguno")) {
                    aplicacionpechoizquierdocolor = "";
                }

                lbaplicacionpechoizquierdocolor.setText(aplicacionpechoizquierdocolor);

                /// pecho derecho
                String aplicacionpechoderecho = rs.getString("aplicacion_pecho_derecho");

                if (aplicacionpechoderecho.equals("ninguno")) {
                    aplicacionpechoderecho = "";
                }

                lbaplicacionpechoderecho.setText(aplicacionpechoderecho);

                String aplicacionpechoderechocolor = rs.getString("aplicacion_pecho_derecho_color");

                if (aplicacionpechoderechocolor.equals("ninguno")) {
                    aplicacionpechoderechocolor = "";
                }

                lbaplicacionpechoderechocolor.setText(aplicacionpechoderechocolor);

                /// manga izquierda
                String aplicacionmangaizquierda = rs.getString("aplicacion_manga_izquierda");

                if (aplicacionmangaizquierda.equals("ninguno")) {
                    aplicacionmangaizquierda = "";
                }

                lbaplicacionmangaizquierda.setText(aplicacionmangaizquierda);

                String aplicacionmangaizquierdacolor = rs.getString("aplicacion_manga_izquierda_color");

                if (aplicacionmangaizquierdacolor.equals("ninguno")) {
                    aplicacionmangaizquierdacolor = "";
                }

                lbaplicacionmangaizquierdacolor.setText(aplicacionmangaizquierdacolor);

                ///manga derecha
                String aplicacionmangaderecha = rs.getString("aplicacion_manga_derecha");

                if (aplicacionmangaderecha.equals("ninguno")) {
                    aplicacionmangaderecha = "";
                }

                lbaplicacionmangaderecha.setText(aplicacionmangaderecha);

                String aplicacionmangaderechacolor = rs.getString("aplicacion_manga_derecha_color");

                if (aplicacionmangaderechacolor.equals("ninguno")) {
                    aplicacionmangaderechacolor = "";
                }

                lbaplicacionmangaderechacolor.setText(aplicacionmangaderechacolor);

                /// manga derecha
                String aplicacionespalda = rs.getString("aplicacion_espalda");

                if (aplicacionespalda.equals("ninguno")) {
                    aplicacionespalda = "";
                }

                lbaplicacionespalda.setText(aplicacionespalda);

                String aplicacionespaldacolor = rs.getString("aplicacion_espalda_color");

                if (aplicacionespaldacolor.equals("ninguno")) {
                    aplicacionespaldacolor = "";
                }

                lbaplicacionespaldacolor.setText(aplicacionespaldacolor);
                
                String nombreconcepto = rs.getString("nombre_concepto");
                lbnombreconcepto.setText(nombreconcepto);

            }

        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(null, ex);
        }

        codigocliente();
        agregarfotomontaje();
        

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

    void topes() 
    {

        String sql = "SELECT min(numero) as min_numero, max(numero) as max_numero FROM historial_ordenes_camisa";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            rs.last();

            primero = rs.getString("min_numero");
            ultimo = rs.getString("max_numero");

        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    
    
    void agregarfotomontaje() throws FileNotFoundException, IOException  
    {
        
        String numero = lbnumero.getText();
        String numeroventa = lbnumeroventa.getText();
        String prenda =lbprenda.getText().toUpperCase();
        String nombreconcepto =lbnombreconcepto.getText();
        BufferedImage img = null;
        String codigocliente ="";
        
        String prendasql ="";
        String prendanombresql="";
                
                               
          
        String sqlcodigo = "Select codigo_cliente from historial_ventas where numero = '" + numeroventa + "'  ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcodigo);
            if (rs.next()) 
            {
               
                      codigocliente = rs.getString("codigo_cliente");
            }

            rs.close();
        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(null, ex);

        }         
                
                
                

       String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_prenda= '"+nombreconcepto+"' and tipo = '"+prenda+"'   ";  ///

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                Imagen imagen = new Imagen();
                Blob blob = rs.getBlob(2);
                if (blob == null) 
                {

                    lblImagen.setText("NO HAY IMAGEN");
                    lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                    lblImagen.setVerticalAlignment(SwingConstants.CENTER);
                } 
                
                else 
                
                {
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) 
                    {
                      JOptionPane.showMessageDialog(null, ex); 

                    }

                    imagen.setImagen(img);
                    lblImagen.setIcon(new ImageIcon(
                            img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
                    repaint();
                    
                    /// *******
                    
                    String ext = rs.getString(1);
                    String path = "C:\\\\archivospdf\\"+nombreconcepto+"." + ext + " ";
                    lbrutaimagen.setText(path);
                    File file = new File(path);
                    FileOutputStream output = new FileOutputStream(file);
                    Blob archivo = rs.getBlob(1);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    while ((length = inStream.read(buffer)) != -1) {
                        output.write(buffer, 0, length);
                        // output.flush();
                    }
                    // inStream.close();
                    output.close();
                    

                }

            } //end while
            rs.close();
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
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
            JOptionPane.showMessageDialog(null, exx);

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
                JOptionPane.showMessageDialog(null, exx);

            }
            
            /// solicito articulos de la
            

        }
        else 
        {
            if (ordenenvio.equals("si")) {

                
                
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
                    JOptionPane.showMessageDialog(null, exx);

                }
                
                
                if(tiendaordenenvio.equals(tiendalocal))
                {
                    
            String sql4 = "Select numero,sucursal from historial_pedidos_sucursal_solicitados where numero_orden_envio = '" + numeroordenenvio + "' and estatus_entrega not in ('cancelada')  ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql4);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
                    numerosolicitoarticulos = rs.getString("numero");
                    tiendasolicitoarticulos = rs.getString("sucursal");
                    
                    
                    cbsucursal.addItem(tiendasolicitoarticulos);
                    lbnumero.setText(numerosolicitoarticulos);
                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }
                    
                }
                else
                {
                     cbsucursal.addItem(tiendaordenenvio);
                     lbnumero.setText(numeroordenenvio);
                } 
                
                

            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbaplicacionmangaderecha = new javax.swing.JLabel();
        lbaplicacionmangaizquierda = new javax.swing.JLabel();
        lbaplicacionpechoderecho = new javax.swing.JLabel();
        lbaplicacionpechoizquierdo = new javax.swing.JLabel();
        lbaplicacionespalda = new javax.swing.JLabel();
        lbmangaderecha = new javax.swing.JLabel();
        lbmangaizquierda = new javax.swing.JLabel();
        lbpechoderechonombre = new javax.swing.JLabel();
        lbpechoizquierdonombre = new javax.swing.JLabel();
        lbespalda = new javax.swing.JLabel();
        btnmangaderecha = new javax.swing.JButton();
        btnmangaizquierda = new javax.swing.JButton();
        btnpechoizquierdo = new javax.swing.JButton();
        btnespalda = new javax.swing.JButton();
        btnpechoderecho = new javax.swing.JButton();
        lbaplicacionespaldacolor = new javax.swing.JLabel();
        lbaplicacionpechoizquierdocolor = new javax.swing.JLabel();
        lbaplicacionpechoderechocolor = new javax.swing.JLabel();
        lbaplicacionmangaderechacolor = new javax.swing.JLabel();
        lbaplicacionmangaizquierdacolor = new javax.swing.JLabel();
        lbpechoizquierdo = new javax.swing.JLabel();
        lbpechoderecho = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbfolio = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        lbtitulo = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbprenda = new javax.swing.JLabel();
        lbnumeroventa = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        btninsertarponchados = new javax.swing.JButton();
        lbrutapechoizquierdo = new javax.swing.JLabel();
        lbrutamangaderecha = new javax.swing.JLabel();
        lbrutapechoderecho = new javax.swing.JLabel();
        lbrutamangaizquierda = new javax.swing.JLabel();
        lbrutaespalda = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        lbnumero = new javax.swing.JLabel();
        btnimagen = new javax.swing.JButton();
        lbrutaimagen = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btninsertarponchados1 = new javax.swing.JButton();
        cbsucursal = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        btnverfotomontaje = new javax.swing.JButton();
        lbnombreconcepto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden de bordado generada");
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

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 800));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Espalda");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(390, 450, 64, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Manga derecha");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(50, 10, 130, 15);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Manga izquierda");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(400, 10, 170, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Pecho derecho");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 270, 130, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Pecho izquierdo");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(410, 260, 130, 15);

        lbaplicacionmangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionmangaderecha.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionmangaderecha);
        lbaplicacionmangaderecha.setBounds(20, 70, 80, 20);

        lbaplicacionmangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionmangaizquierda.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionmangaizquierda);
        lbaplicacionmangaizquierda.setBounds(350, 70, 90, 16);

        lbaplicacionpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionpechoderecho.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionpechoderecho);
        lbaplicacionpechoderecho.setBounds(20, 340, 60, 21);

        lbaplicacionpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionpechoizquierdo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionpechoizquierdo);
        lbaplicacionpechoizquierdo.setBounds(410, 330, 80, 21);

        lbaplicacionespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionespalda.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionespalda);
        lbaplicacionespalda.setBounds(330, 500, 90, 20);

        lbmangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbmangaderecha.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbmangaderecha);
        lbmangaderecha.setBounds(20, 40, 260, 16);

        lbmangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbmangaizquierda.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbmangaizquierda);
        lbmangaizquierda.setBounds(350, 40, 300, 20);

        lbpechoderechonombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoderechonombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbpechoderechonombre);
        lbpechoderechonombre.setBounds(20, 310, 270, 20);

        lbpechoizquierdonombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoizquierdonombre.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbpechoizquierdonombre);
        lbpechoizquierdonombre.setBounds(390, 310, 270, 20);

        lbespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbespalda.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbespalda);
        lbespalda.setBounds(330, 470, 310, 19);

        btnmangaderecha.setText("Manga Derecha");
        btnmangaderecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechaActionPerformed(evt);
            }
        });
        jPanel1.add(btnmangaderecha);
        btnmangaderecha.setBounds(150, 10, 130, 23);

        btnmangaizquierda.setText("Manga izquierda");
        btnmangaizquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdaActionPerformed(evt);
            }
        });
        jPanel1.add(btnmangaizquierda);
        btnmangaizquierda.setBounds(510, 10, 140, 23);

        btnpechoizquierdo.setText("Pecho Izquierdo");
        btnpechoizquierdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdoActionPerformed(evt);
            }
        });
        jPanel1.add(btnpechoizquierdo);
        btnpechoizquierdo.setBounds(520, 250, 130, 23);

        btnespalda.setText("Espalda");
        btnespalda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldaActionPerformed(evt);
            }
        });
        jPanel1.add(btnespalda);
        btnespalda.setBounds(450, 440, 130, 23);

        btnpechoderecho.setText("Pecho derecho");
        btnpechoderecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechoActionPerformed(evt);
            }
        });
        jPanel1.add(btnpechoderecho);
        btnpechoderecho.setBounds(150, 260, 140, 23);

        lbaplicacionespaldacolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionespaldacolor.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionespaldacolor);
        lbaplicacionespaldacolor.setBounds(430, 500, 90, 20);

        lbaplicacionpechoizquierdocolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionpechoizquierdocolor.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionpechoizquierdocolor);
        lbaplicacionpechoizquierdocolor.setBounds(500, 330, 160, 21);

        lbaplicacionpechoderechocolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionpechoderechocolor.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionpechoderechocolor);
        lbaplicacionpechoderechocolor.setBounds(100, 340, 150, 21);

        lbaplicacionmangaderechacolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionmangaderechacolor.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionmangaderechacolor);
        lbaplicacionmangaderechacolor.setBounds(110, 70, 170, 20);

        lbaplicacionmangaizquierdacolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionmangaizquierdacolor.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionmangaizquierdacolor);
        lbaplicacionmangaizquierdacolor.setBounds(460, 70, 190, 16);

        lbpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoizquierdo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbpechoizquierdo);
        lbpechoizquierdo.setBounds(390, 290, 270, 20);

        lbpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoderecho.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbpechoderecho);
        lbpechoderecho.setBounds(20, 290, 270, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Folio");

        lbfolio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbfolio.setForeground(new java.awt.Color(204, 0, 0));
        lbfolio.setText("00000000");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("Cliente");

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbtitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbtitulo.setForeground(new java.awt.Color(204, 0, 0));

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("Prenda:");

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbprenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbprendaMouseClicked(evt);
            }
        });

        lbnumeroventa.setText("00000000");

        btninsertarponchados.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btninsertarponchados.setText("Replicar Ponchados");
        btninsertarponchados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarponchadosActionPerformed(evt);
            }
        });

        lbrutapechoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutamangaderecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutapechoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutamangaizquierda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutaespalda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbnumero.setForeground(new java.awt.Color(204, 0, 0));
        lbnumero.setText("00000000");

        btnimagen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnimagen.setText("Agregar fotomontaje");
        btnimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimagenActionPerformed(evt);
            }
        });

        lbrutaimagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 0));
        jLabel22.setText("Sucursal a que Replica");

        btninsertarponchados1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btninsertarponchados1.setText("Eliminar");
        btninsertarponchados1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninsertarponchados1ActionPerformed(evt);
            }
        });

        cbsucursal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 0, 0));
        jLabel14.setText("Numero Sucursal");

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ampliar Imagen");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        lbnombreconcepto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel21)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(cbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 765, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 527, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnimagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btninsertarponchados1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btninsertarponchados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnverfotomontaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbtipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbrutapechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbrutapechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbrutamangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbnumeroventa))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbrutaespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbrutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbrutamangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbnombreconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lbtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnsalir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbprenda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lbfolio)
                            .addComponent(jLabel14)
                            .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnverfotomontaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btninsertarponchados1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btninsertarponchados, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbrutapechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutamangaderecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutapechoderecho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbrutamangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbnombreconcepto, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbnumeroventa)))
                        .addGap(64, 64, 64))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ordencamisaimagen p = new ordencamisaimagen();
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

        ventanaordencamisaanteriores = false;
        this.dispose();

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordencamisaanteriores = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordencamisaanteriores.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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

    private void btnmangaizquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdaActionPerformed
        JSystemFileChooser adjuntar = new JSystemFileChooser();

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutamangaizquierda.setText(fl);
            btnmangaizquierda.setEnabled(false);

        }
    }//GEN-LAST:event_btnmangaizquierdaActionPerformed

    private void btnpechoizquierdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdoActionPerformed
        JSystemFileChooser adjuntar = new JSystemFileChooser();

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutapechoizquierdo.setText(fl);
            btnpechoizquierdo.setEnabled(false);

        }
    }//GEN-LAST:event_btnpechoizquierdoActionPerformed

    private void btnespaldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldaActionPerformed
        JSystemFileChooser adjuntar = new JSystemFileChooser();

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaespalda.setText(fl);
            btnespalda.setEnabled(false);

        }
    }//GEN-LAST:event_btnespaldaActionPerformed

    private void btnpechoderechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechoActionPerformed
        JSystemFileChooser adjuntar = new JSystemFileChooser();

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutapechoderecho.setText(fl);
            btnpechoderecho.setEnabled(false);

        }
    }//GEN-LAST:event_btnpechoderechoActionPerformed

    private void btnmangaderechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechaActionPerformed
        JSystemFileChooser adjuntar = new JSystemFileChooser();
        String archivoextension ="";
        
        
        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            archivoextension= archivoelegido.getName();
            String fl = archivoelegido.toString();

            lbrutamangaderecha.setText(fl);
            
            btnmangaderecha.setEnabled(false);

        }
    }//GEN-LAST:event_btnmangaderechaActionPerformed

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
            path = "C:\\sistema\\dfnorte.txt";
        } else if (tiendaalaquesereplicara.equals("cdmxsur")) {
            path = "C:\\sistema\\dfsur.txt";
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
            JOptionPane.showMessageDialog(null, e);
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
            Object ponchado1 = lbrutamangaizquierda.getText();
            if (ponchado1 == null || ponchado1.equals("")) 
            {

            } else {
                try {
                    String filePath = lbrutamangaizquierda.getText();
                    File archivo = new File(filePath);
                    nombrearchivo1 = archivo.getName();
                    input = new FileInputStream(new File(filePath));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set manga_izquierda_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                   JOptionPane.showMessageDialog(null, e);
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set manga_izquierda_ponchado_nombre='" + nombrearchivo1 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

            ///ponchado2
            Object ponchado2 = lbrutapechoizquierdo.getText();
            if (ponchado2 == null || ponchado2.equals("") || ponchado2.equals(" ")) {

            } else {
                try {
                    String filePath2 = lbrutapechoizquierdo.getText();
                    File archivo2 = new File(filePath2);
                    nombrearchivo2 = archivo2.getName();
                    input2 = new FileInputStream(new File(filePath2));
                } catch (FileNotFoundException ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set pecho_izquierdo_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input2);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);

                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set pecho_izquierdo_ponchado_nombre='" + nombrearchivo2 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

            }

            ///ponchado3
            Object ponchado3 = lbrutaespalda.getText();
            if (ponchado3 == null || ponchado3.equals("") || ponchado3.equals(" ")) {

            } else {
                try {
                    String filePath3 = lbrutaespalda.getText();
                    File archivo3 = new File(filePath3);
                    nombrearchivo3 = archivo3.getName();
                    input3 = new FileInputStream(new File(filePath3));
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set espalda_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input3);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set espalda_ponchado_nombre='" + nombrearchivo3 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
            }

            //ponchado 4
            Object ponchado4 = lbrutamangaderecha.getText();

            if (ponchado4 == null || ponchado4.equals("") || ponchado4.equals(" ")) {

            } else {
                try {
                    String filePath4 = lbrutamangaderecha.getText();
                    File archivo4 = new File(filePath4);
                    nombrearchivo4 = archivo4.getName();
                    input4 = new FileInputStream(new File(filePath4));
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set manga_derecha_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input4);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set manga_derecha_ponchado_nombre='" + nombrearchivo4 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }

            //ponchado5
            Object ponchado5 = lbrutapechoderecho.getText();

            if (ponchado5 == null || ponchado5.equals("") || ponchado5.equals(" ")) {

            } else {
                try {
                    String filePath5 = lbrutapechoderecho.getText();
                    File archivo5 = new File(filePath5);
                    nombrearchivo5 = archivo5.getName();
                    input5 = new FileInputStream(new File(filePath5));
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set pecho_derecho_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input5);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set pecho_derecho_ponchado_nombre='" + nombrearchivo5 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
            }

           /// imagen jlabel
            Object imagen = lbrutaimagen.getText();

            if (imagen == null || imagen.equals("") || imagen.equals(" ")) {

            } else {
                try {
                    String filePath6 = lbrutaimagen.getText();
                    File archivo6 = new File(filePath6);
                    nombrearchivo6 = archivo6.getName();
                    input6 = new FileInputStream(new File(filePath6));
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_camisa_recibidas set imagen=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input6);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas set imagen_nombre='" + nombrearchivo6 + "' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and prenda = '" + prenda + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                   JOptionPane.showMessageDialog(null, ex);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, e);
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
                JOptionPane.showMessageDialog(null, e);
            }

            ordenesbordadogenerada.btnactualizar.doClick();

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

    private void btnimagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimagenActionPerformed
        JSystemFileChooser adjuntar = new JSystemFileChooser();

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {

            BufferedImage img = null;

            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaimagen.setText(fl);

            try {
                img = ImageIO.read(adjuntar.getSelectedFile()); //it must be an image file, otherwise you'll get an exception
            } catch (IOException ex) {
                Logger.getLogger(ordencamisaanteriores.class.getName()).log(Level.SEVERE, null, ex);
            }
            JLabel label = new JLabel();
            lblImagen.setIcon(new ImageIcon(img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
            repaint();

        }
    }//GEN-LAST:event_btnimagenActionPerformed

    private void btninsertarponchados1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninsertarponchados1ActionPerformed

        String numero = lbfolio.getText();
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa SET estatus_orden='enviado' WHERE numero='" + numero + "'");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            ordenesbordadogenerada.btnactualizar.doClick();
            this.dispose();

    }//GEN-LAST:event_btninsertarponchados1ActionPerformed

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
        
       
        

        String sql = "Select extension_imagen,imagen from bordados_puntadas where codigo = '" + codigocliente + "' and nombre_prenda= '"+nombreconcepto+"' and tipo = '"+prenda+"'   ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            if (rs1.next()) 
            {
                Object camisa1 = rs1.getString(2);
                if (camisa1 == null||camisa1.equals("")||camisa1.equals(" ")) 
                {
                    existe = "no";
                } else 
                
                {
                    String nombredelarchivo = rs1.getString(1);
                    if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                        
                     rutadelarchivo = "C://archivospdf/fotomontaje."+nombredelarchivo+" ";   
                   
                    }
                    else
                    {
                        
                   nombredelarchivo = nombredelarchivo.replace(" ","");
                        String extension = "";

                        int i = nombredelarchivo.lastIndexOf('.');
                        if (i > 0) {
                            extension = nombredelarchivo.substring(i + 1);
                        }
                   
                   rutadelarchivo = "C://archivospdf/fotomontaje."+extension+" ";
                    
                    }
                    existe = "si";
                    File file = new File(rutadelarchivo);
                    FileOutputStream output = new FileOutputStream(file);
                    Blob archivo = rs1.getBlob(1);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    while ((length = inStream.read(buffer)) != -1) {
                        output.write(buffer, 0, length);
                        // output.flush();
                    }
                    // inStream.close();
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

                JOptionPane.showMessageDialog(null, "No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e);
            }
        
        }        

    }//GEN-LAST:event_btnverfotomontajeActionPerformed



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
            java.util.logging.Logger.getLogger(ordencamisaanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordencamisaanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordencamisaanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordencamisaanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordencamisaanteriores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnespalda;
    private javax.swing.JButton btnimagen;
    private javax.swing.JButton btninsertarponchados;
    private javax.swing.JButton btninsertarponchados1;
    private javax.swing.JButton btnmangaderecha;
    private javax.swing.JButton btnmangaizquierda;
    private javax.swing.JButton btnpechoderecho;
    private javax.swing.JButton btnpechoizquierdo;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JComboBox<String> cbsucursal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lbaplicacionespalda;
    public static javax.swing.JLabel lbaplicacionespaldacolor;
    public static javax.swing.JLabel lbaplicacionmangaderecha;
    public static javax.swing.JLabel lbaplicacionmangaderechacolor;
    public static javax.swing.JLabel lbaplicacionmangaizquierda;
    public static javax.swing.JLabel lbaplicacionmangaizquierdacolor;
    public static javax.swing.JLabel lbaplicacionpechoderecho;
    public static javax.swing.JLabel lbaplicacionpechoderechocolor;
    public static javax.swing.JLabel lbaplicacionpechoizquierdo;
    public static javax.swing.JLabel lbaplicacionpechoizquierdocolor;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbespalda;
    public static javax.swing.JLabel lbfolio;
    private javax.swing.JLabel lblImagen;
    public static javax.swing.JLabel lbmangaderecha;
    public static javax.swing.JLabel lbmangaizquierda;
    private javax.swing.JLabel lbnombreconcepto;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JLabel lbpechoderecho;
    public static javax.swing.JLabel lbpechoderechonombre;
    public static javax.swing.JLabel lbpechoizquierdo;
    public static javax.swing.JLabel lbpechoizquierdonombre;
    public static javax.swing.JLabel lbprenda;
    private javax.swing.JLabel lbrutaespalda;
    private javax.swing.JLabel lbrutaimagen;
    private javax.swing.JLabel lbrutamangaderecha;
    private javax.swing.JLabel lbrutamangaizquierda;
    private javax.swing.JLabel lbrutapechoderecho;
    private javax.swing.JLabel lbrutapechoizquierdo;
    public static javax.swing.JLabel lbtipo;
    private javax.swing.JLabel lbtitulo;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
