package sistemabordadores;

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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ordengorrarecibida extends javax.swing.JFrame {

    public static boolean ventanaordengorraanteriores = false;
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
    
    String numerosucursal = "";
    String sucursal = "";
    String numerosolicitoarticulos = "";
    String tiendasolicitoarticulos = "";

    String numeroordenenvio = "";
    String tiendaordenenvio = "";
    
    int descargado = 0;

    private PreparedStatement pst;

    public ordengorrarecibida() {
        initComponents();
        ventanaordengorraanteriores = true;

        lbatras.setEnabled(false);
        lbladoderecho.setEnabled(false);
        lbladoizquierdo.setEnabled(false);
        lbfrente.setEnabled(false);
        
        lbnumeroventa.setVisible(false);
        lbtienda.setVisible(false);
        lbnumero.setVisible(false);
        
        
        topes();
        
    }

    void datos() {

        btncancelar.setEnabled(true);

        String folio = lbfolio.getText();

        String sql = "Select fecha,hora,cliente,cantidad,cantidad,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,lado_izquierdo,lado_derecho,frente,atras,aplicacion_frente,aplicacion_frente_color,lugar from historial_ordenes_gorra_recibidas where numero = '" + folio + "'";

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
    
    void cargarimagen() {

        String numero = lbnumero.getText();
        String sql = "Select imagen from historial_ordenes_gorra_recibidas where numero = '" + numero + "' ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Imagen imagen = new Imagen();
                Blob blob = rs.getBlob("imagen");
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
            rs.close();
        } catch (SQLException ex) {

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
        btncancelar = new javax.swing.JButton();
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
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btncancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden De Bordado Gorra anteriores");
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Fecha Entrega");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Folio");

        lbfolio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbfolio.setForeground(new java.awt.Color(204, 0, 0));
        lbfolio.setText("00000");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 0, 0));
        jLabel15.setText("Cantidad de Prendas:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setText("Cliente:");

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setText("ORDEN DE BORDADO DE GORRA");

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Hora Entrega");

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        lbfechaentrega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(204, 0, 0));
        jLabel21.setText("Prenda:");

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setText("Frente");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(380, 510, 80, 15);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Atras");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(350, 80, 90, 15);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jLabel4.setText("Lado derecho");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(70, 320, 120, 15);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 0, 0));
        jLabel5.setText("Lado izquierdo");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(630, 310, 110, 15);

        lbaplicacionatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionatras.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionatras);
        lbaplicacionatras.setBounds(330, 120, 140, 17);

        lbaplicacionladoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionladoderecho.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionladoderecho);
        lbaplicacionladoderecho.setBounds(110, 380, 130, 19);

        lbaplicacionladoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionladoizquierdo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbaplicacionladoizquierdo);
        lbaplicacionladoizquierdo.setBounds(600, 360, 150, 19);

        lbaplicacionfrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionfrente.setForeground(new java.awt.Color(255, 0, 0));
        lbaplicacionfrente.setOpaque(true);
        jPanel1.add(lbaplicacionfrente);
        lbaplicacionfrente.setBounds(340, 560, 60, 19);

        lbatras.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbatras.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbatras);
        lbatras.setBounds(320, 100, 260, 20);

        lbladoderecho.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoderecho.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbladoderecho);
        lbladoderecho.setBounds(70, 340, 250, 20);

        lbladoizquierdo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbladoizquierdo.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(lbladoizquierdo);
        lbladoizquierdo.setBounds(580, 330, 250, 20);

        lbfrente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfrente.setForeground(new java.awt.Color(255, 0, 0));
        lbfrente.setOpaque(true);
        jPanel1.add(lbfrente);
        lbfrente.setBounds(340, 530, 270, 20);

        lbaplicacionfrentecolor.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbaplicacionfrentecolor.setForeground(new java.awt.Color(255, 0, 0));
        lbaplicacionfrentecolor.setOpaque(true);
        jPanel1.add(lbaplicacionfrentecolor);
        lbaplicacionfrentecolor.setBounds(420, 560, 190, 19);

        btnatras.setText("Atras");
        btnatras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnatrasActionPerformed(evt);
            }
        });
        jPanel1.add(btnatras);
        btnatras.setBounds(350, 50, 80, 23);

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
        btnfrente.setBounds(370, 480, 110, 23);

        btnladoizquierdo.setText("Lado Izquierdo");
        btnladoizquierdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnladoizquierdoActionPerformed(evt);
            }
        });
        jPanel1.add(btnladoizquierdo);
        btnladoizquierdo.setBounds(610, 280, 110, 23);

        lbnumeroventa.setText("00000000");

        lbtienda.setText("00000000");

        lbnumero.setText("00000000");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Foto Montaje");

        btncancelar1.setText("Eliminar");
        btncancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelar1ActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 552, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbprenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                        .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 781, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbnumero)
                                                    .addComponent(lbtienda))
                                                .addComponent(lbnumeroventa))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(lbtipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbrutaladoizquierdo, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbrutaladoderecho, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbrutaatras, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(5, 5, 5)
                                                .addComponent(lbrutafrente, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbrutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btncancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(948, 948, 948)
                                .addComponent(jLabel3)))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel16)
                            .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lbfolio)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21)
                                    .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addComponent(lbnumeroventa, javax.swing.GroupLayout.DEFAULT_SIZE, 24, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbtienda)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbnumero)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbrutaladoizquierdo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaatras, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaladoderecho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutafrente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(lbrutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
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

         if (descargado >= 1) {
            
             String numero = lbnumero.getText();
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas SET estatus='descargada' WHERE numero='" + numero + "'");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        }

        ordenesbordadorecibida.btnactualizar.doClick();
        ventanaordengorraanteriores = false;
        this.dispose();
        
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordengorraanteriores = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        datos();
        cargarimagen();
    }//GEN-LAST:event_formWindowOpened

    private void btnladoderechoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoderechoActionPerformed
       JSystemFileChooser fs = new JSystemFileChooser();;
        String numero = lbnumero.getText();

        try (
                PreparedStatement ps
                = cn.prepareStatement("select lado_derecho_ponchado,lado_derecho_ponchado_nombre from historial_ordenes_gorra_recibidas where numero = '" + numero + "' ")) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                String nombre1 = rs.getString("lado_derecho_ponchado_nombre");
                fs.setSelectedFile(new File(nombre1));
                int tampak = fs.showSaveDialog(null);

                if (tampak == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile();
                    try (InputStream stream = rs.getBinaryStream("lado_derecho_ponchado");
                            OutputStream output = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        while (stream.read(buffer) > 0) {
                            output.write(buffer);
                        }
                    }
                    
                    descargado = 1;
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
    }//GEN-LAST:event_btnladoderechoActionPerformed

    private void btnfrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrenteActionPerformed
         JSystemFileChooser fs = new JSystemFileChooser();;
        String numero = lbnumero.getText();

        try (
                PreparedStatement ps
                = cn.prepareStatement("select frente_ponchado,frente_ponchado_nombre from historial_ordenes_gorra_recibidas where numero = '" + numero + "' ")) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                String nombre1 = rs.getString("frente_ponchado_nombre");
                fs.setSelectedFile(new File(nombre1));
                int tampak = fs.showSaveDialog(null);

                if (tampak == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile();
                    try (InputStream stream = rs.getBinaryStream("frente_ponchado");
                            OutputStream output = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        while (stream.read(buffer) > 0) {
                            output.write(buffer);
                        }
                    }
                }
                
                descargado = 1;
            }
            rs.close();
        } catch (FileNotFoundException fnfe) {
            // FileNotFoundException handling
        } catch (IOException ioe) {
            // IOException handling
        } catch (SQLException sqle) {
            // SQLException handling
        }
    }//GEN-LAST:event_btnfrenteActionPerformed

    private void btnladoizquierdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnladoizquierdoActionPerformed
       JSystemFileChooser fs = new JSystemFileChooser();;
        String numero = lbnumero.getText();

        try (
                PreparedStatement ps
                = cn.prepareStatement("select lado_izquierdo_ponchado,lado_izquierdo_ponchado_nombre from historial_ordenes_gorra_recibidas where numero = '" + numero + "' ")) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                String nombre1 = rs.getString("lado_izquierdo_ponchado_nombre");
                fs.setSelectedFile(new File(nombre1));
                int tampak = fs.showSaveDialog(null);

                if (tampak == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile();
                    try (InputStream stream = rs.getBinaryStream("lado_izquierdo_ponchado");
                            OutputStream output = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        while (stream.read(buffer) > 0) {
                            output.write(buffer);
                        }
                    }
                    
                    descargado = 1;
                    
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
    }//GEN-LAST:event_btnladoizquierdoActionPerformed

    private void btnatrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnatrasActionPerformed
        JSystemFileChooser fs = new JSystemFileChooser();;
        String numero = lbnumero.getText();

        try (
                PreparedStatement ps
                = cn.prepareStatement("select atras_ponchado,atras_ponchado_nombre from historial_ordenes_gorra_recibidas where numero = '" + numero + "' ")) {
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                fs.setCurrentDirectory(new File(System.getProperty("user.home") + "/Desktop"));
                String nombre1 = rs.getString("atras_ponchado_nombre");
                fs.setSelectedFile(new File(nombre1));
                int tampak = fs.showSaveDialog(null);

                if (tampak == JFileChooser.APPROVE_OPTION) {
                    File file = fs.getSelectedFile();
                    try (InputStream stream = rs.getBinaryStream("atras_ponchado");
                            OutputStream output = new FileOutputStream(file)) {
                        byte[] buffer = new byte[4096];
                        while (stream.read(buffer) > 0) {
                            output.write(buffer);
                        }
                    }
                    
                    descargado = 1;
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
    }//GEN-LAST:event_btnatrasActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
    this.dispose();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void btncancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelar1ActionPerformed
         String numero = lbnumero.getText();
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_gorra_recibidas SET estatus='descargada' WHERE numero='" + numero + "'");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }  
            
            this.dispose();
            ordenesbordadorecibida.btnactualizar.doClick();
    }//GEN-LAST:event_btncancelar1ActionPerformed

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
            java.util.logging.Logger.getLogger(ordengorrarecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordengorrarecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordengorrarecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordengorrarecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ordengorrarecibida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnatras;
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btncancelar1;
    private javax.swing.JButton btnfrente;
    private javax.swing.JButton btnladoderecho;
    private javax.swing.JButton btnladoizquierdo;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
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
    public static javax.swing.JLabel lbtipo;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
