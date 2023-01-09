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
import javax.swing.ImageIcon;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ordencamisarecibida extends javax.swing.JFrame {

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

    private PreparedStatement pst;

    int descargado = 0;

    public ordencamisarecibida() {
        initComponents();
        ventanaordencamisaanteriores = true;

        lbmangaderecha.setEnabled(false);
        lbmangaizquierda.setEnabled(false);
        lbpechoderecho.setEnabled(false);
        lbpechoizquierdo.setEnabled(false);
        lbespalda.setEnabled(false);

        lbnumeroventa.setVisible(false);
        lbtienda.setVisible(false);
        lbnumero.setVisible(false);

        topes();

    }

    void datos() {

        String numero = lbnumero.getText();

        String sql = "Select fecha,hora,cliente,cantidad,cantidad_bordados,cantidad_aplicaciones_chicas,cantidad_aplicaciones_grandes,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,pecho_izquierdo,pecho_derecho,manga_izquierda,manga_derecha,espalda,aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,lugar,estatus_orden from historial_ordenes_camisa_recibidas where numero = '" + numero + "'";

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
                else if(prenda.contains("Chamarra desmontable")||prenda.contains("Chamarra2 desmontable")||prenda.contains("Chamarra3 desmontable"))
                {
                    lbtitulo.setText("Orden de Chamarra");
                }
                else if(prenda.contains("Chaleco"))
                {
                    lbtitulo.setText("Orden de Chaleco");
                }
                else if(prenda.contains("Camisola"))
                {
                    lbtitulo.setText("Orden de Camisola");
                }
                 else if(prenda.contains("Playera")||prenda.contains("Playera2")||prenda.contains("Playera3")||prenda.contains("Playera4")||prenda.contains("Playera5"))
                {
                    lbtitulo.setText("Orden de Playera");
                }

                lbmangaderecha.setText(rs.getString("manga_derecha"));
                Object mangaderecha = rs.getString("manga_derecha");
                if (mangaderecha == null | mangaderecha.equals("")) {
                    jLabel2.setVisible(false);
                    btnmangaderecha.setVisible(false);
                }

                lbmangaizquierda.setText(rs.getString("manga_izquierda"));

                Object mangaizquierda = rs.getString("manga_izquierda");
                if (mangaizquierda == null | mangaizquierda.equals("")) {
                    jLabel3.setVisible(false);
                    btnmangaizquierda.setVisible(false);
                }

                lbpechoderecho.setText(rs.getString("pecho_derecho"));
                Object pechoderecho = rs.getString("pecho_derecho");
                if (pechoderecho == null | pechoderecho.equals("")) {
                    jLabel4.setVisible(false);
                    btnpechoderecho.setVisible(false);
                }

                lbpechoizquierdo.setText(rs.getString("pecho_izquierdo"));
                Object pechoizquierdo = rs.getString("pecho_izquierdo");
                if (pechoizquierdo == null | pechoizquierdo.equals("")) {
                    jLabel5.setVisible(false);
                    btnpechoizquierdo.setVisible(false);
                }

                lbespalda.setText(rs.getString("espalda"));
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

                String aplicacionpechoderecho = rs.getString("aplicacion_pecho_derecho");

                if (aplicacionpechoderecho.equals("ninguno")) {
                    aplicacionpechoderecho = "";
                }

                lbaplicacionpechoderecho.setText(aplicacionpechoderecho);

                String aplicacionmangaizquierda = rs.getString("aplicacion_manga_izquierda");

                if (aplicacionmangaizquierda.equals("ninguno")) {
                    aplicacionmangaizquierda = "";
                }

                lbaplicacionmangaizquierda.setText(aplicacionmangaizquierda);

                String aplicacionmangaderecha = rs.getString("aplicacion_manga_derecha");

                if (aplicacionmangaderecha.equals("ninguno")) {
                    aplicacionmangaderecha = "";
                }

                lbaplicacionmangaderecha.setText(aplicacionmangaderecha);

                String aplicacionespalda = rs.getString("aplicacion_espalda");

                if (aplicacionespalda.equals("ninguno")) {
                    aplicacionespalda = "";
                }

                lbaplicacionespalda.setText(aplicacionespalda);

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        datostienda();

    }

    void topes() {

        String sql = "SELECT min(numero) as min_numero, max(numero) as max_numero FROM historial_ordenes_camisa_recibidas ";

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

        if (pedirarticulos.equals("si")) {
            String sql3 = "Select numero,tienda from historial_pedidos_sucursal_solicitados where numventa = '" + numero + "' ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
                    numerosolicitoarticulos = rs.getString("numero");
                    tiendasolicitoarticulos = rs.getString("tienda");
                    lbtienda.setText(tiendasolicitoarticulos);
                    lbnumero.setText(numerosolicitoarticulos);
                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

        } else {
            if (ordenenvio.equals("si")) {

                String sql3 = "Select numero,tienda_recibe from historial_ordenes_envio_solicitadas where numero_venta = '" + numero + "' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {
                        numeroordenenvio = rs.getString("numero");
                        tiendaordenenvio = rs.getString("tienda_recibe");
                        lbtienda.setText(tiendaordenenvio);
                        lbnumero.setText(numeroordenenvio);
                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

            }
        }

        cargarimagen();

    }

    void cargarimagen() {

        String numero = lbnumero.getText();
        String sql = "Select imagen from historial_ordenes_camisa_recibidas where numero = '" + numero + "' ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Imagen imagen = new Imagen();
                Blob blob = rs.getBlob("imagen");
                if(blob==null)
                {
                  jLabel6 .setText("NO HAY IMAGEN");
                }
                else{
                byte[] data = blob.getBytes(1, (int) blob.length());
                BufferedImage img = null;
                try {
                    img = ImageIO.read(new ByteArrayInputStream(data));
                } catch (IOException ex) {

                }

                imagen.setImagen(img);
                jLabel6.setIcon(new ImageIcon(
                        img.getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_DEFAULT)));
                repaint();
                }
            }
            rs.close();
        } catch (SQLException ex) {

        }

    }
    
    
    void actualizarelestatusdelaorden()
    {

        String numero = lbnumero.getText();
        
        if (descargado >= 1) 
        {
            
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas SET estatus='descargada' WHERE numero='"+numero+"' ");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
                
    }        
    
     void cancelarlaorden()
    {

        String numero = lbnumero.getText();

            
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa_recibidas SET estatus='cancelada' WHERE numero='"+numero+"' ");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
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
        lbpechoderecho = new javax.swing.JLabel();
        lbpechoizquierdo = new javax.swing.JLabel();
        lbespalda = new javax.swing.JLabel();
        btnmangaderecha = new javax.swing.JButton();
        btnmangaizquierda = new javax.swing.JButton();
        btnpechoizquierdo = new javax.swing.JButton();
        btnespalda = new javax.swing.JButton();
        btnpechoderecho = new javax.swing.JButton();
        lbaplicacionmangaizquierdacolor = new javax.swing.JLabel();
        lbaplicacionmangaderechacolor = new javax.swing.JLabel();
        lbaplicacionpechoderechocolor = new javax.swing.JLabel();
        lbaplicacionpechoizquierdocolor = new javax.swing.JLabel();
        lbaplicacionespaldacolor = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbfolio = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbtitulo = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbprenda = new javax.swing.JLabel();
        lbnumeroventa = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbrutapechoizquierdo = new javax.swing.JLabel();
        lbrutamangaderecha = new javax.swing.JLabel();
        lbrutapechoderecho = new javax.swing.JLabel();
        lbrutamangaizquierda = new javax.swing.JLabel();
        lbrutaespalda = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        lbtienda = new javax.swing.JLabel();
        lbnumero = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnverfotomontaje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden de bordado Camisa Recibida");
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
        jLabel3.setBounds(400, 10, 130, 15);

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
        lbaplicacionmangaderecha.setBounds(10, 70, 90, 15);

        lbaplicacionmangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionmangaizquierda.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionmangaizquierda);
        lbaplicacionmangaizquierda.setBounds(370, 70, 60, 20);

        lbaplicacionpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionpechoderecho.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionpechoderecho);
        lbaplicacionpechoderecho.setBounds(10, 320, 70, 21);

        lbaplicacionpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionpechoizquierdo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionpechoizquierdo);
        lbaplicacionpechoizquierdo.setBounds(370, 320, 70, 21);

        lbaplicacionespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionespalda.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionespalda);
        lbaplicacionespalda.setBounds(340, 510, 80, 20);

        lbmangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbmangaderecha.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbmangaderecha);
        lbmangaderecha.setBounds(10, 40, 310, 20);

        lbmangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbmangaizquierda.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbmangaizquierda);
        lbmangaizquierda.setBounds(370, 40, 280, 20);

        lbpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoderecho.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbpechoderecho);
        lbpechoderecho.setBounds(10, 290, 290, 20);

        lbpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbpechoizquierdo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbpechoizquierdo);
        lbpechoizquierdo.setBounds(370, 290, 280, 20);

        lbespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbespalda.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbespalda);
        lbespalda.setBounds(340, 480, 310, 19);

        btnmangaderecha.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnmangaderecha.setText("Manga Derecha");
        btnmangaderecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaderechaActionPerformed(evt);
            }
        });
        jPanel1.add(btnmangaderecha);
        btnmangaderecha.setBounds(150, 10, 130, 23);

        btnmangaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnmangaizquierda.setText("Manga izquierda");
        btnmangaizquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmangaizquierdaActionPerformed(evt);
            }
        });
        jPanel1.add(btnmangaizquierda);
        btnmangaizquierda.setBounds(510, 10, 140, 23);

        btnpechoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnpechoizquierdo.setText("Pecho Izquierdo");
        btnpechoizquierdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoizquierdoActionPerformed(evt);
            }
        });
        jPanel1.add(btnpechoizquierdo);
        btnpechoizquierdo.setBounds(520, 250, 140, 23);

        btnespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnespalda.setText("Espalda");
        btnespalda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnespaldaActionPerformed(evt);
            }
        });
        jPanel1.add(btnespalda);
        btnespalda.setBounds(450, 440, 130, 23);

        btnpechoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnpechoderecho.setText("Pecho derecho");
        btnpechoderecho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpechoderechoActionPerformed(evt);
            }
        });
        jPanel1.add(btnpechoderecho);
        btnpechoderecho.setBounds(150, 260, 140, 23);

        lbaplicacionmangaizquierdacolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionmangaizquierdacolor.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionmangaizquierdacolor);
        lbaplicacionmangaizquierdacolor.setBounds(450, 70, 200, 20);

        lbaplicacionmangaderechacolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionmangaderechacolor.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionmangaderechacolor);
        lbaplicacionmangaderechacolor.setBounds(110, 70, 170, 15);

        lbaplicacionpechoderechocolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionpechoderechocolor.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionpechoderechocolor);
        lbaplicacionpechoderechocolor.setBounds(90, 320, 160, 21);

        lbaplicacionpechoizquierdocolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionpechoizquierdocolor.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionpechoizquierdocolor);
        lbaplicacionpechoizquierdocolor.setBounds(450, 320, 150, 21);

        lbaplicacionespaldacolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionespaldacolor.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionespaldacolor);
        lbaplicacionespaldacolor.setBounds(440, 510, 190, 20);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Folio");

        lbfolio.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbfolio.setForeground(new java.awt.Color(204, 0, 0));
        lbfolio.setText("00000000");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Cliente");

        lbtitulo.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("Prenda:");

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbprenda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbprendaMouseClicked(evt);
            }
        });

        lbnumeroventa.setText("00000000");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setToolTipText("Si me das doble click la imagen se hace grande");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        lbtienda.setText("00000000");

        lbnumero.setText("00000000");

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

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
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(1039, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(16, 16, 16)
                        .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 784, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbnumeroventa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbrutapechoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbrutapechoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbrutamangaderecha, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(lbrutaespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbtienda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbnumero)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbrutamangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lbtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel21)
                    .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbfolio))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbrutapechoizquierdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbrutamangaderecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbrutapechoderecho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbrutaespalda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbtienda)
                                .addComponent(lbnumero))
                            .addComponent(lbrutamangaizquierda, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 629, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbtipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50))
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

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        actualizarelestatusdelaorden();
        ventanaordencamisaanteriores = false;
        this.dispose();
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        datos();
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
                Image myImg = im.getScaledInstance(jLabel6.getWidth(), jLabel6.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImg);
                jLabel6.setIcon(newImage);
            } else {
                JOptionPane.showMessageDialog(null, "No hay imagen que mostrar");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_lbprendaMouseClicked

    private void btnmangaizquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaizquierdaActionPerformed
        JSystemFileChooser fs = new JSystemFileChooser();;
        String numero = lbnumero.getText();

        try (
                PreparedStatement ps
                = cn.prepareStatement("select manga_izquierda_ponchado,manga_izquierda_ponchado_nombre from historial_ordenes_camisa_recibidas where numero = '" + numero + "' ")) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                String nombre1 = rs.getString("manga_izquierda_ponchado_nombre");
                fs.setSelectedFile(new File(nombre1));
                int tampak = fs.showSaveDialog(null);

                if (tampak == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile();
                    try (InputStream stream = rs.getBinaryStream("manga_izquierda_ponchado");
                            OutputStream output = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        while (stream.read(buffer) > 0) {
                            output.write(buffer);
                        }
                    }
                }
            }
            rs.close();
        } catch (FileNotFoundException fnfe) {
            // FileNotFoundException handling
        } catch (IOException ioe) {
            // IOException handling
        } catch (SQLException sqle) {
            // SQLException handling
        }

        descargado = 1;

    }//GEN-LAST:event_btnmangaizquierdaActionPerformed

    private void btnpechoizquierdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoizquierdoActionPerformed
        JSystemFileChooser fs = new JSystemFileChooser();;
        String numero = lbnumero.getText();

        try (
                PreparedStatement ps
                = cn.prepareStatement("select pecho_izquierdo_ponchado,pecho_izquierdo_ponchado_nombre from historial_ordenes_camisa_recibidas where numero = '" + numero + "' ")) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                String nombre1 = rs.getString("pecho_izquierdo_ponchado_nombre");
                fs.setSelectedFile(new File(nombre1));
                int tampak = fs.showSaveDialog(null);

                if (tampak == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile();
                    try (InputStream stream = rs.getBinaryStream("pecho_izquierdo_ponchado");
                            OutputStream output = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        while (stream.read(buffer) > 0) {
                            output.write(buffer);
                        }
                    }
                }
            }
            rs.close();
        } catch (FileNotFoundException fnfe) {
            // FileNotFoundException handling
        } catch (IOException ioe) {
            // IOException handling
        } catch (SQLException sqle) {
            // SQLException handling
        }

        descargado = 1;
    }//GEN-LAST:event_btnpechoizquierdoActionPerformed

    private void btnespaldaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnespaldaActionPerformed
        JSystemFileChooser fs = new JSystemFileChooser();;
        String numero = lbnumero.getText();

        try (
                PreparedStatement ps
                = cn.prepareStatement("select espalda_ponchado,espalda_ponchado_nombre from historial_ordenes_camisa_recibidas where numero = '" + numero + "' ")) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                String nombre1 = rs.getString("espalda_ponchado_nombre");
                fs.setSelectedFile(new File(nombre1));
                int tampak = fs.showSaveDialog(null);

                if (tampak == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile();
                    try (InputStream stream = rs.getBinaryStream("espalda_ponchado");
                            OutputStream output = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        while (stream.read(buffer) > 0) {
                            output.write(buffer);
                        }
                    }
                }
            }
            rs.close();
        } catch (FileNotFoundException fnfe) {
            // FileNotFoundException handling
        } catch (IOException ioe) {
            // IOException handling
        } catch (SQLException sqle) {
            // SQLException handling
        }

        descargado = 1;
    }//GEN-LAST:event_btnespaldaActionPerformed

    private void btnpechoderechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpechoderechoActionPerformed
        JSystemFileChooser fs = new JSystemFileChooser();;
        String numero = lbnumero.getText();

        try (
                PreparedStatement ps
                = cn.prepareStatement("select pecho_derecho_ponchado,pecho_derecho_ponchado_nombre from historial_ordenes_camisa_recibidas where numero = '" + numero + "' ")) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                String nombre1 = rs.getString("pecho_derecho_ponchado_nombre");
                fs.setSelectedFile(new File(nombre1));
                int tampak = fs.showSaveDialog(null);

                if (tampak == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile();
                    try (InputStream stream = rs.getBinaryStream("pecho_derecho_ponchado");
                            OutputStream output = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        while (stream.read(buffer) > 0) {
                            output.write(buffer);
                        }
                    }
                }
            }
            rs.close();
        } catch (FileNotFoundException fnfe) {
            // FileNotFoundException handling
        } catch (IOException ioe) {
            // IOException handling
        } catch (SQLException sqle) {
            // SQLException handling
        }

        descargado = 1;
    }//GEN-LAST:event_btnpechoderechoActionPerformed

    private void btnmangaderechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmangaderechaActionPerformed
        JSystemFileChooser fs = new JSystemFileChooser();;
        String numero = lbnumero.getText();

        try (
                PreparedStatement ps
                = cn.prepareStatement("select manga_derecha_ponchado,manga_derecha_ponchado_nombre from historial_ordenes_camisa_recibidas where numero = '" + numero + "' ")) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                String nombre1 = rs.getString("manga_derecha_ponchado_nombre");
                fs.setSelectedFile(new File(nombre1));
                int tampak = fs.showSaveDialog(null);

                if (tampak == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile();
                    try (InputStream stream = rs.getBinaryStream("manga_derecha_ponchado");
                            OutputStream output = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        while (stream.read(buffer) > 0) {
                            output.write(buffer);
                        }
                    }
                }
            }
            rs.close();
        } catch (FileNotFoundException fnfe) {
            // FileNotFoundException handling
        } catch (IOException ioe) {
            // IOException handling
        } catch (SQLException sqle) {
            // SQLException handling
        }

        descargado = 1;

    }//GEN-LAST:event_btnmangaderechaActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    
    actualizarelestatusdelaorden();    
    ventanaordencamisaanteriores = false;
        
    }//GEN-LAST:event_formWindowClosed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
    
    int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro de cancelar esta orden ???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI", "NO"}, "SI");

    if (respuesta == JOptionPane.YES_OPTION) 
    {            
    cancelarlaorden();
    this.dispose();
    }
    
    
    
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
    
        int respuesta = JOptionPane.showOptionDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro de eliminar esta orden ???", "Selector de opciones", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"SI", "NO"}, "SI");
        if (respuesta == JOptionPane.YES_OPTION) 
    {
        actualizarelestatusdelaorden();
        this.dispose();
        ordenesbordadorecibida.btnactualizar.doClick();
    }
        
    }//GEN-LAST:event_btneliminarActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
      
        
     String numero = lbnumero.getText();   
     String pathname ="";
     String existe = "";
     
     
     if (evt.getClickCount() == 2)
     {
         
         
        String sql = "Select imagen_nombre,imagen from historial_ordenes_camisa_recibidas where numero = '"+numero+"' ";
         
        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(sql);
            while (rs1.next()) 
            {
                Object imagennombre = rs1.getString(1);
                
                if (imagennombre == null || imagennombre.equals("ninguno")|| imagennombre.equals(" ")|| imagennombre.equals("")) 
                {

                } else {
                    
                    pathname = "C:\\archivospdf\\"+imagennombre+"";
                    existe = "si";
                    File file = new File(pathname);
                    FileOutputStream output = new FileOutputStream(file);
                    Blob archivo = rs1.getBlob(2);
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
            String fileLocal = new String(pathname);
            try {

                File path = new File(fileLocal);
                Desktop.getDesktop().open(path);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se pudo encontrar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

          

    }

 
        
    }//GEN-LAST:event_jLabel6MouseClicked

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed

        String cliente = lbcliente.getText();
        String tipo = lbprenda.getText();
        String numero = lbnumero.getText();
        String prendafotomontaje = "";
        String nombreprendafotomontaje = "";
        String rutadelarchivo = "";
        String existe = "";
        
        

       

        String SQL = "Select imagen,imagen_nombre from historial_ordenes_camisa_recibidas where numero = '" + numero + "' ";

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
                    rutadelarchivo = "C://archivospdf/"+nombredelarchivo+" ";

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
            java.util.logging.Logger.getLogger(ordencamisarecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordencamisarecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordencamisarecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordencamisarecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ordencamisarecibida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btncancelar;
    public static javax.swing.JButton btneliminar;
    private javax.swing.JButton btnespalda;
    private javax.swing.JButton btnmangaderecha;
    private javax.swing.JButton btnmangaizquierda;
    private javax.swing.JButton btnpechoderecho;
    private javax.swing.JButton btnpechoizquierdo;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    public static javax.swing.JLabel lbmangaderecha;
    public static javax.swing.JLabel lbmangaizquierda;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JLabel lbpechoderecho;
    public static javax.swing.JLabel lbpechoizquierdo;
    public static javax.swing.JLabel lbprenda;
    private javax.swing.JLabel lbrutaespalda;
    private javax.swing.JLabel lbrutamangaderecha;
    private javax.swing.JLabel lbrutamangaizquierda;
    private javax.swing.JLabel lbrutapechoderecho;
    private javax.swing.JLabel lbrutapechoizquierdo;
    public static javax.swing.JLabel lbtienda;
    public static javax.swing.JLabel lbtipo;
    private javax.swing.JLabel lbtitulo;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
