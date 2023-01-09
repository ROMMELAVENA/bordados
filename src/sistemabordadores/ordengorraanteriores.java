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
import java.io.OutputStream;
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
import static ordenesdebordado.ordencamisaanteriores.lbnumero;

public class ordengorraanteriores extends javax.swing.JFrame {

    public static boolean ventanaordengorraanteriores = false;
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
    String sucursal = "";
    String numerosolicitoarticulos = "";
    String tiendasolicitoarticulos = "";
    String numeroordenenvio = "";
    String tiendaordenenvio = "";

    int descargado = 0;

 

    public ordengorraanteriores() {
        initComponents();
        ventanaordengorraanteriores = true;

        lbatras.setEnabled(false);
        lbladoderecho.setEnabled(false);
        lbladoizquierdo.setEnabled(false);
        lbfrente.setEnabled(false);
        lbnumeroventa.setVisible(false);
        lbtienda.setVisible(false);
        lbtiendaalaquereplicara.setVisible(false);
        
        lbrutaladoizquierdo.setVisible(false);
        lbrutaladoderecho.setVisible(false);
        lbrutaatras.setVisible(false);        
        lbrutafrente.setVisible(false);
        lbrutaimagen.setVisible(false);       
        lbtipo.setVisible(false);
        btnreplicar.setEnabled(false);

    }

    void datos() throws IOException {

        btnreplicar.setEnabled(true);

        String folio = lbfolio.getText();

        String sql = "Select fecha,hora,cliente,numero_venta,cantidad,cantidad_bordados,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,lado_izquierdo,lado_derecho,frente,atras,aplicacion_frente,aplicacion_frente_color,lugar from historial_ordenes_gorra where numero = '" + folio + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));

                lbprenda.setText(rs.getString("prenda"));
                lbcantidad.setText(rs.getString("cantidad"));
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));
                
                
                lbfrente.setText(rs.getString("frente"));
                String frente =  rs.getString("frente");
                if(frente ==null||frente.equals(""))
                {
                    btnfrente.setVisible(false);
                }
                
                lbladoizquierdo.setText(rs.getString("lado_izquierdo"));
                String ladoizquierdo =  rs.getString("lado_izquierdo");
                if(ladoizquierdo ==null||ladoizquierdo.equals(""))
                {
                    btnladoizquierdo.setVisible(false);
                }
                
                
                lbladoderecho.setText(rs.getString("lado_derecho"));
                 String ladoderecho =  rs.getString("lado_derecho");
                if(ladoderecho ==null||ladoderecho.equals(""))
                {
                    btnladoderecho.setVisible(false);
                }
                
                lbatras.setText(rs.getString("atras"));
                String atras =  rs.getString("atras");
                if(atras ==null||atras.equals(""))
                {
                    btnatras.setVisible(false);
                }
               
                String aplicacionfrente = rs.getString("aplicacion_frente");

                if (aplicacionfrente.equals("ninguno")) {
                    aplicacionfrente = "";
                }

                lbaplicacionfrente.setText(aplicacionfrente);
                
                
                String aplicacionfrentecolor = rs.getString("aplicacion_frente_color");

                if (aplicacionfrentecolor.equals("ninguno")) {
                    aplicacionfrentecolor = "";
                }

                lbaplicacionfrentecolor.setText(aplicacionfrentecolor);
                

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        datostienda();
        agregarfotomontaje();

    }

    void topes() {

        String sql = "SELECT min(numero) as min_numero, max(numero) as max_numero FROM historial_ordenes_gorra";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            rs.last();

            primero = rs.getString("min_numero");
            ultimo = rs.getString("max_numero");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    
    void datostienda() {
        /// busca las ordenes de camisa generadas 

        String numero = lbnumeroventa.getText();
        String pedirarticulos = "";
        String ordenenvio = "";
        String sql2 = "Select solicito_articulos, enviada_ordenenvio from historial_ventas where numero = '" + numero + "' and estatus_pago not in ('cancelada') ";

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
                JOptionPane.showMessageDialog(null, exx);

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
                    JOptionPane.showMessageDialog(null, exx);

                }

            }
        }

    }
    
    void agregarfotomontaje() throws FileNotFoundException, IOException
    {
        
        String numero = lbnumero.getText();
        String numeroventa = lbnumeroventa.getText();
        BufferedImage img = null;
        String prenda =lbprenda.getText();
        String prendasql ="";
        String prendanombresql="";
                
                if(prenda.equals("Gorra"))
                {
                    prendasql = "gorra";
                    prendanombresql = "gorraextension";
                }
                else if(prenda.equals("Gorra2"))
                {
                    prendasql = "gorra2";
                    prendanombresql = "gorra2extension";
                }
                else if(prenda.equals("Gorra3"))
                {
                    prendasql = "gorra3";
                    prendanombresql = "gorra3extension";
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
        } catch (SQLException ex) 
        {
             JOptionPane.showMessageDialog(null, ex);

        }         
                
                
                

       String sql = "Select "+prendasql+","+prendanombresql+" from catalogo_clientes where codigo = '" + codigocliente + "'  ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Imagen imagen = new Imagen();
                Blob blob = rs.getBlob(""+prendasql+"");
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
                    
                    String ext = rs.getString(""+prendanombresql+"");
                    String path = "C:\\\\archivospdf\\"+prendasql+"." + ext + " ";
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
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbfolio = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btnreplicar = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbfechaentrega = new javax.swing.JLabel();
        lbhoraentrega = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbprenda = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbaplicacionatras = new javax.swing.JLabel();
        lbaplicacionladoderecho = new javax.swing.JLabel();
        lbaplicacionladoizquierdo = new javax.swing.JLabel();
        lbaplicacionfrente = new javax.swing.JLabel();
        lbatras = new javax.swing.JLabel();
        lbladoderecho = new javax.swing.JLabel();
        lbladoizquierdo = new javax.swing.JLabel();
        lbfrente = new javax.swing.JLabel();
        lbaplicacionfrentecolor = new javax.swing.JLabel();
        btnatras = new javax.swing.JButton();
        btnladoderecho = new javax.swing.JButton();
        btnfrente = new javax.swing.JButton();
        btnladoizquierdo = new javax.swing.JButton();
        lbnumeroventa = new javax.swing.JLabel();
        lbtienda = new javax.swing.JLabel();
        lbnumero = new javax.swing.JLabel();
        lbrutaladoderecho = new javax.swing.JLabel();
        lbrutafrente = new javax.swing.JLabel();
        lbrutaimagen = new javax.swing.JLabel();
        lbrutaladoizquierdo = new javax.swing.JLabel();
        lbrutaatras = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        btnimagen = new javax.swing.JButton();
        lbtiendaalaquereplicara = new javax.swing.JLabel();
        btnreplicar1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        btnverfotomontaje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden De Bordado Gorra anteriores");
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setText("Fecha Entrega");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Folio");

        lbfolio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbfolio.setForeground(new java.awt.Color(204, 0, 0));
        lbfolio.setText("00000000");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("Cantidad de Prendas:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Cliente:");

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setText("ORDEN DE BORDADO DE GORRA");

        btnreplicar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreplicar.setText("Replicar");
        btnreplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setText("Hora Entrega");

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbfechaentrega.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbcantidad.setText("00000000");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("Prenda:");

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Frente");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(450, 510, 80, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Atras");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(410, 80, 90, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Lado derecho");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 320, 120, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Lado izquierdo");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(720, 310, 110, 15);

        lbaplicacionatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionatras.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionatras);
        lbaplicacionatras.setBounds(360, 120, 140, 17);

        lbaplicacionladoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionladoderecho.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionladoderecho);
        lbaplicacionladoderecho.setBounds(110, 380, 130, 19);

        lbaplicacionladoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionladoizquierdo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionladoizquierdo);
        lbaplicacionladoizquierdo.setBounds(720, 360, 150, 19);

        lbaplicacionfrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionfrente.setForeground(new java.awt.Color(255, 0, 0));
        lbaplicacionfrente.setOpaque(true);
        jPanel1.add(lbaplicacionfrente);
        lbaplicacionfrente.setBounds(380, 560, 60, 19);

        lbatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbatras.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbatras);
        lbatras.setBounds(350, 100, 260, 20);

        lbladoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderecho.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbladoderecho);
        lbladoderecho.setBounds(70, 340, 250, 20);

        lbladoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbladoizquierdo);
        lbladoizquierdo.setBounds(670, 330, 250, 20);

        lbfrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfrente.setForeground(new java.awt.Color(255, 0, 0));
        lbfrente.setOpaque(true);
        jPanel1.add(lbfrente);
        lbfrente.setBounds(380, 530, 270, 20);

        lbaplicacionfrentecolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionfrentecolor.setForeground(new java.awt.Color(255, 0, 0));
        lbaplicacionfrentecolor.setOpaque(true);
        jPanel1.add(lbaplicacionfrentecolor);
        lbaplicacionfrentecolor.setBounds(460, 560, 190, 19);

        btnatras.setText("Atras");
        btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnatras);
        btnatras.setBounds(460, 70, 80, 23);

        btnladoderecho.setText("Lado Derecho");
        btnladoderecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoderechoActionPerformed(evt);
            }
        });
        jPanel1.add(btnladoderecho);
        btnladoderecho.setBounds(60, 290, 110, 23);

        btnfrente.setText("Frente");
        btnfrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrenteActionPerformed(evt);
            }
        });
        jPanel1.add(btnfrente);
        btnfrente.setBounds(410, 480, 110, 23);

        btnladoizquierdo.setText("Lado Izquierdo");
        btnladoizquierdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdoActionPerformed(evt);
            }
        });
        jPanel1.add(btnladoizquierdo);
        btnladoizquierdo.setBounds(700, 280, 110, 23);

        lbnumeroventa.setText("00000000");

        lbtienda.setText("00000000");

        lbnumero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbnumero.setText("00000000");

        lbrutaladoderecho.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutafrente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutaimagen.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutaladoizquierdo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbrutaatras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnimagen.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnimagen.setText("Agregar Fotomontaje");
        btnimagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimagenActionPerformed(evt);
            }
        });

        lbtiendaalaquereplicara.setText("00000000");

        btnreplicar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreplicar1.setText("Eliminar");
        btnreplicar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicar1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setText("Numero Sucursal");

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverfotomontaje.setText("Ampliar Imagen");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
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
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnreplicar1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbtipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbrutaladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbrutaladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbrutaatras, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbrutafrente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lbrutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbtiendaalaquereplicara)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbtienda)
                                        .addComponent(lbnumeroventa)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnimagen, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                    .addComponent(btnverfotomontaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 22, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbprenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(19, 19, 19)
                                        .addComponent(lbcantidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16)
                                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(lbfolio)
                                    .addComponent(jLabel17)
                                    .addComponent(lbnumero))))))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 387, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnreplicar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnimagen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbtienda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbtiendaalaquereplicara)
                                .addGap(23, 23, 23)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbrutaladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaatras, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutafrente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 758, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
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

        ventanaordengorraanteriores = false;
        this.dispose();

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordengorraanteriores = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordengorraanteriores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnladoderechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoActionPerformed
      JSystemFileChooser adjuntar = new JSystemFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaladoderecho.setText(fl);
            btnladoderecho.setEnabled(false);
            descargado = 1;

        }
    }//GEN-LAST:event_btnladoderechoActionPerformed

    private void btnreplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicarActionPerformed


        String tipo = lbtipo.getText();
        String numerosucursal =lbnumero.getText();
        String prenda =lbprenda.getText();
                

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
                Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {

                    String sql2 = "UPDATE historial_ordenes_gorra_recibidas set lado_izquierdo_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();
                    
                    System.out.println("\nlado_izquierdo_ponchado");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set lado_izquierdo_ponchado_nombre='"+nombrearchivo1+"' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  "); 
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
                Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
              try {

                    String sql2 = "UPDATE historial_ordenes_gorra_recibidas set lado_derecho_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input2);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nlado_derecho_ponchado");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set lado_derecho_ponchado_nombre='"+nombrearchivo2+"' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  "); 
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
                Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {

                    String sql2 = "UPDATE historial_ordenes_gorra_recibidas set atras_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input3);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set atras_ponchado_nombre='"+nombrearchivo3+"' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  "); 
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
                Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {

                    String sql2 = "UPDATE historial_ordenes_gorra_recibidas set frente_ponchado=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input4);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set frente_ponchado_nombre='"+nombrearchivo4+"' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  "); 
                   pst.executeUpdate();
                   System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }
                
                
                
                                   //ponchado5
      
                
           /// imagen jlabel
        
        Object imagen = lbrutaimagen.getText();

        if (imagen == null || imagen.equals("") || imagen.equals(" ")) {

        } else {
            try {
                String filePath6 = lbrutaimagen.getText();
                File archivo6 = new File(filePath6);
                 nombrearchivo6 =archivo6.getName();
                input6 = new FileInputStream(new File(filePath6));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            try {

                    String sql2 = "UPDATE historial_ordenes_gorra_recibidas set imagen=? where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input6);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                 try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set imagen_nombre='"+nombrearchivo6+"' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  "); 
                   pst.executeUpdate();
                   System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
        }
        
        
         try {
                
                PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas set estatus='por guardar' where numero_sucursal_orden='" + numerosucursal + "' and tienda = '" + strBDlocal   + "' and prenda = '"+prenda+"'  "); 
                   pst.executeUpdate();
                   System.out.println(pst);
                   pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
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
           
        
        ordenesbordadogenerada.btnactualizar.doClick();
        this.dispose();

        }
        else
        {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden NO se inserto correctamente en la otra sucursal");
            
        } 
       
        


       
    }//GEN-LAST:event_btnreplicarActionPerformed

    private void btnfrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrenteActionPerformed
        JSystemFileChooser adjuntar = new JSystemFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutafrente.setText(fl);
            btnfrente.setEnabled(false);
            descargado = 1;

        }
    }//GEN-LAST:event_btnfrenteActionPerformed

    private void btnladoizquierdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoActionPerformed
       JSystemFileChooser adjuntar = new JSystemFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaladoizquierdo.setText(fl);
            btnladoizquierdo.setEnabled(false);
            descargado = 1;

        }
    }//GEN-LAST:event_btnladoizquierdoActionPerformed

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
       JSystemFileChooser adjuntar = new JSystemFileChooser();
      

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaatras.setText(fl);
            btnatras.setEnabled(false);
            descargado = 1;

        }
    }//GEN-LAST:event_btnatrasActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
         ventanaordengorraanteriores = false;
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

    private void btnreplicar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicar1ActionPerformed
         String numero = lbfolio.getText();
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_gorra SET estatus_orden='generada' WHERE numero='" + numero + "'");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }  
            
            this.dispose();
            ordenesbordadorecibida.btnactualizar.doClick();
    }//GEN-LAST:event_btnreplicar1ActionPerformed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed

        String cliente = lbcliente.getText();
        String prenda = lbprenda.getText();
        String prendafotomontaje = "";
        String nombreprendafotomontaje = "";
        String rutadelarchivo = "";
        String existe = "";

        //// prenda del fotomontaje

        if(prenda.equals("Gorra"))
                {
                    prendafotomontaje = "gorra";
                    nombreprendafotomontaje = "gorraextension";
                }
                else if(prenda.equals("Gorra2"))
                {
                    prendafotomontaje = "gorra2";
                    nombreprendafotomontaje = "gorra2extension";
                }
                else if(prenda.equals("Gorra3"))
                {
                    prendafotomontaje = "gorra3";
                    nombreprendafotomontaje = "gorra3extension";
                }
 
        
        String SQL = "SELECT "+prendafotomontaje+","+nombreprendafotomontaje+" FROM catalogo_clientes where codigo = '"+codigocliente+"' ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(SQL);
            if (rs1.next())
            {
                Object camisa1 = rs1.getString(1);
                if (camisa1 == null||camisa1.equals("")||camisa1.equals(" "))
                {
                    existe = "no";
                } else

                {
                    String nombredelarchivo = rs1.getString(2);
                    if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {

                        rutadelarchivo = "C://archivospdf/fotomontaje."+nombredelarchivo+" ";

                    }
                    else
                    {

                        rutadelarchivo = "C://archivospdf/"+nombredelarchivo+" ";

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
            java.util.logging.Logger.getLogger(ordengorraanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordengorraanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordengorraanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordengorraanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordengorraanteriores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btnfrente;
    private javax.swing.JButton btnimagen;
    private javax.swing.JButton btnladoderecho;
    private javax.swing.JButton btnladoizquierdo;
    private javax.swing.JButton btnreplicar;
    private javax.swing.JButton btnreplicar1;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lbaplicacionatras;
    public static javax.swing.JLabel lbaplicacionfrente;
    public static javax.swing.JLabel lbaplicacionfrentecolor;
    public static javax.swing.JLabel lbaplicacionladoderecho;
    public static javax.swing.JLabel lbaplicacionladoizquierdo;
    public static javax.swing.JLabel lbatras;
    public static javax.swing.JLabel lbcantidad;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbfechaentrega;
    public static javax.swing.JLabel lbfolio;
    public static javax.swing.JLabel lbfrente;
    public static javax.swing.JLabel lbhoraentrega;
    private javax.swing.JLabel lblImagen;
    public static javax.swing.JLabel lbladoderecho;
    public static javax.swing.JLabel lbladoizquierdo;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JLabel lbprenda;
    private javax.swing.JLabel lbrutaatras;
    private javax.swing.JLabel lbrutafrente;
    private javax.swing.JLabel lbrutaimagen;
    private javax.swing.JLabel lbrutaladoderecho;
    private javax.swing.JLabel lbrutaladoizquierdo;
    public static javax.swing.JLabel lbtienda;
    public static javax.swing.JLabel lbtiendaalaquereplicara;
    public static javax.swing.JLabel lbtipo;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
