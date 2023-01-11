package sistemabordadores;

import java.awt.Color;
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
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ordenpantalonanteriores extends javax.swing.JFrame {

    public static boolean ventanaordenpantalonanteriores = false;
    public static String ordenbordadopantalon = "";

    String cantidadprendasstring = "";
    int cantidadprendasint = 0;

    String bordadosutilizadosstring = "";
    int bordadosutilizadosint = 0;

    String primero = "";
    String ultimo = "";
    
    String numeropedido = "";
    String tiendaalaqueselesolicito = "";

    private PreparedStatement pst;

    public ordenpantalonanteriores()
    {
        initComponents();
        ventanaordenpantalonanteriores = true;

    }

    void datos () throws FileNotFoundException, IOException
    {
        
        String folio = lbfolio.getText();
        String numeroventa ="";
        String codigocliente ="";
        String prendasql = "";
        String prendanombresql="";
        String prenda ="";
         BufferedImage img = null;
        
        lbtituloladoderechoatras.setText("");
        lbtituloladoizquierdoatras.setText("");
        lbtituloladoizquierdofrente.setText("");
        lbtituloladoderechofrente.setText("");


        

        String sql = "Select fecha,hora,cliente,numero_venta,cantidad,cantidad_bordados,prenda,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,"
                + "   lado_izquierdo_frente,lado_derecho_frente,lado_izquierdo_atras,lado_derecho_atras,"
                + "   lado_izquierdo_frente_puntadas,lado_derecho_frente_puntadas,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas,"
                + "   lugar from historial_ordenes_pantalon where numero = '" + folio + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                lbcliente.setText(rs.getString("cliente"));
                lbnumeroventa.setText(rs.getString("numero_venta"));
                numeroventa = rs.getString("numero_venta");
                prenda = rs.getString("prenda");
                

                lbladoizquierdofrente.setText(rs.getString("lado_izquierdo_frente"));
                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente");
                if (ladoizquierdofrente == null || ladoizquierdofrente.equals("")) 
                {
                    
                  btnagregarbordado1.setEnabled(false);

                } else {

                    lbtituloladoizquierdofrente.setText("Lado izquierdo frente");
                    String b = rs.getString("lado_izquierdo_frente_puntadas");
                    lbladoizquierdofrentepuntadas.setText(rs.getString("lado_izquierdo_frente_puntadas"));
                    btnagregarbordado1.setEnabled(true);
                }

                
                /// lado derecho frente
                
                lbladoderechofrente.setText(rs.getString("lado_derecho_frente"));
                String ladoderechofrente = rs.getString("lado_derecho_frente");

                if (ladoderechofrente == null || ladoderechofrente.equals("")) 
                {
                    btnagregarbordado2.setEnabled(false);
                } 
                else
                {

                    lbtituloladoderechofrente.setText("Lado derecho frente");
                    lbladoderechofrentepuntadas.setText(rs.getString("lado_derecho_frente_puntadas"));
                    btnagregarbordado2.setEnabled(true);
                }

                lbdadoizquierdoatras.setText(rs.getString("lado_izquierdo_atras"));
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras");
                if (ladoizquierdoatras == null || ladoizquierdoatras.equals("")) {
                    btnagregarbordado3.setEnabled(false);
                } else {

                    lbtituloladoizquierdoatras.setText("Lado izquierdo atras");
                    lbladoizquierdoatraspuntadas.setText(rs.getString("lado_izquierdo_atras_puntadas"));
                    btnagregarbordado3.setEnabled(true);
                }

                lbladoderechoatras.setText(rs.getString("lado_derecho_atras"));
                String ladoderechoatras = rs.getString("lado_derecho_atras");
                if (ladoderechoatras == null || ladoderechoatras.equals("")) {
                     btnagregarbordado4.setEnabled(false);
                } else {

                    lbtituloladoderechoatras.setText("Lado derecho atras");
                    String a = rs.getString("lado_derecho_atras_puntadas");
                    lbladoderechoatraspuntadas.setText(rs.getString("lado_derecho_atras_puntadas"));
                     btnagregarbordado4.setEnabled(false);
                }

               

            }

        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(null, ex);
        }
        
        
         String sqlcodigo = "Select codigo_cliente from historial_ventas where numero = '" + numeroventa + "'  ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcodigo);
            if (rs.next()) {
               
                      codigocliente = rs.getString("codigo_cliente");
                }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);

        }         
                
             
        
        if(prenda.equals("Pantalon"))
                {
                    prendasql = "pantalon";
                    prendanombresql = "pantalonextension";
                }
                else if(prenda.equals("Pantalon2"))
                {
                    prendasql = "pantalon2";
                    prendanombresql = "pantalon2extension";
                }
        
                

       String sqlimagen = "Select pantalon,pantalonextension from catalogo_clientes where codigo = '" + codigocliente + "'  ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlimagen);
            while (rs.next()) {
                Imagen imagen = new Imagen();
                Blob blob = rs.getBlob("pantalon");
                if (blob == null) {

                    lblImagen.setText("NO HAY IMAGEN");
                    lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
                    lblImagen.setVerticalAlignment(SwingConstants.CENTER);
                    
                    btnagregarfotomontaje.setEnabled(true);
                    
                } else {
                    
                    btnagregarfotomontaje.setEnabled(false);
                    
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) {

                    }

                    imagen.setImagen(img);
                    lblImagen.setIcon(new ImageIcon(
                    img.getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_DEFAULT)));
                    repaint();
                    
                    /// *******
                    
                    String ext = rs.getString("pantalonextension");
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
            String sql3 = "Select numero,tienda from historial_pedidos_sucursal_solicitados where numventa = '" + numero + "' and estatus_entrega = 'Por confirmar' ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {
                    numeropedido = rs.getString("numero");
                    tiendaalaqueselesolicito = rs.getString("tienda");
                   
                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

        } else {
            if (ordenenvio.equals("si")) {

                String sql3 = "Select numero,sucursal from historial_ordenes_envio_solicitadas where numero_venta = '" + numero + "' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {
                        numeropedido = rs.getString("numero");
                        tiendaalaqueselesolicito = rs.getString("sucursal");
                       
                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

            }
        }
        
        
        lbtiendareplica.setText(tiendaalaqueselesolicito);

    }

    

    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        lbfolio = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        lbnumeroventa = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        btnreplicar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        lbtituloladoderechoatras = new javax.swing.JLabel();
        lbtituloladoizquierdoatras = new javax.swing.JLabel();
        lbtituloladoderechofrente = new javax.swing.JLabel();
        lbtituloladoizquierdofrente = new javax.swing.JLabel();
        lbdadoizquierdoatras = new javax.swing.JLabel();
        lbladoderechofrente = new javax.swing.JLabel();
        lbladoderechoatras = new javax.swing.JLabel();
        lbladoizquierdofrentepuntadas = new javax.swing.JLabel();
        lbladoderechofrentepuntadas = new javax.swing.JLabel();
        lbladoizquierdoatraspuntadas = new javax.swing.JLabel();
        lbladoderechoatraspuntadas = new javax.swing.JLabel();
        lbladoizquierdofrente = new javax.swing.JLabel();
        btnagregarbordado1 = new javax.swing.JButton();
        btnagregarbordado2 = new javax.swing.JButton();
        btnagregarbordado3 = new javax.swing.JButton();
        btnagregarbordado4 = new javax.swing.JButton();
        btncancelarbordado = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbtiendareplica = new javax.swing.JLabel();
        btnagregarfotomontaje = new javax.swing.JButton();
        lbrutaimagen = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        lbrutaladoizquierdofrente = new javax.swing.JLabel();
        lbrutaladoizquierdoatras = new javax.swing.JLabel();
        lbrutaladoderechofrente = new javax.swing.JLabel();
        lbrutaladoderechoatras = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden Pantalon anteriores");
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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 0, 0));
        jLabel13.setText("Folio");

        lbfolio.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        lbfolio.setForeground(new java.awt.Color(204, 0, 0));
        lbfolio.setText("00000");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setText("Cliente:");

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setText("Salir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setText("Orden de Pantalón");

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        lbnumeroventa.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setText("No. de Venta");

        btnreplicar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnreplicar.setText("Replicar Bordados");
        btnreplicar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreplicarActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 800));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 800));
        jPanel1.setName(""); // NOI18N
        jPanel1.setLayout(null);

        lbtituloladoderechoatras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbtituloladoderechoatras);
        lbtituloladoderechoatras.setBounds(510, 240, 280, 20);

        lbtituloladoizquierdoatras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbtituloladoizquierdoatras);
        lbtituloladoizquierdoatras.setBounds(30, 240, 210, 20);

        lbtituloladoderechofrente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbtituloladoderechofrente);
        lbtituloladoderechofrente.setBounds(20, 40, 230, 20);

        lbtituloladoizquierdofrente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbtituloladoizquierdofrente);
        lbtituloladoizquierdofrente.setBounds(510, 40, 280, 20);

        lbdadoizquierdoatras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbdadoizquierdoatras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbdadoizquierdoatras);
        lbdadoizquierdoatras.setBounds(30, 270, 210, 20);

        lbladoderechofrente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbladoderechofrente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbladoderechofrente);
        lbladoderechofrente.setBounds(20, 70, 230, 20);

        lbladoderechoatras.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbladoderechoatras.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbladoderechoatras);
        lbladoderechoatras.setBounds(510, 270, 280, 20);

        lbladoizquierdofrentepuntadas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbladoizquierdofrentepuntadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbladoizquierdofrentepuntadas);
        lbladoizquierdofrentepuntadas.setBounds(510, 100, 280, 20);

        lbladoderechofrentepuntadas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbladoderechofrentepuntadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbladoderechofrentepuntadas);
        lbladoderechofrentepuntadas.setBounds(20, 100, 230, 20);

        lbladoizquierdoatraspuntadas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbladoizquierdoatraspuntadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbladoizquierdoatraspuntadas);
        lbladoizquierdoatraspuntadas.setBounds(30, 300, 210, 20);

        lbladoderechoatraspuntadas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbladoderechoatraspuntadas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbladoderechoatraspuntadas);
        lbladoderechoatraspuntadas.setBounds(510, 300, 280, 20);

        lbladoizquierdofrente.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbladoizquierdofrente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(lbladoizquierdofrente);
        lbladoizquierdofrente.setBounds(510, 70, 280, 20);

        btnagregarbordado1.setText("Lado Izquierdo Frente");
        btnagregarbordado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarbordado1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregarbordado1);
        btnagregarbordado1.setBounds(510, 10, 230, 23);

        btnagregarbordado2.setText("Lado Derecho Frente");
        btnagregarbordado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarbordado2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregarbordado2);
        btnagregarbordado2.setBounds(20, 10, 230, 23);

        btnagregarbordado3.setText("Lado Izquierdo Atras");
        btnagregarbordado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarbordado3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregarbordado3);
        btnagregarbordado3.setBounds(20, 210, 230, 23);

        btnagregarbordado4.setText("Lado Derecho Atras");
        btnagregarbordado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarbordado4ActionPerformed(evt);
            }
        });
        jPanel1.add(btnagregarbordado4);
        btnagregarbordado4.setBounds(510, 210, 230, 23);

        btncancelarbordado.setText("cancelarbordado");
        btncancelarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarbordadoActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Tienda a Replicar");

        lbtiendareplica.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbtiendareplica.setText("00000000");

        btnagregarfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnagregarfotomontaje.setText("Agregar Fotomontaje");
        btnagregarfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarfotomontajeActionPerformed(evt);
            }
        });

        lbrutaimagen.setText("lbrutaimagen");

        lblImagen.setText("jLabel3");

        lbrutaladoizquierdofrente.setText("lbrutaladoizquierdofrente");

        lbrutaladoizquierdoatras.setText("lbrutaladoizquierdoatras");

        lbrutaladoderechofrente.setText("lbrutaladoderechofrente");

        lbrutaladoderechoatras.setText("lbrutaladoderechoatras");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addGap(0, 0, 0)
                                        .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(lbtiendareplica, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btncancelarbordado)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnreplicar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                        .addComponent(btnagregarfotomontaje)
                                        .addGap(29, 29, 29)))
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaimagen, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaladoizquierdofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaladoizquierdoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaladoderechofrente, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbrutaladoderechoatras, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(lbtiendareplica, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addComponent(lbfolio))
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnreplicar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnagregarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(btncancelarbordado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbrutaimagen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbrutaladoizquierdofrente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbrutaladoizquierdoatras)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbrutaladoderechofrente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbrutaladoderechoatras)
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 445, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(106, 106, 106))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        ordenpantalonimagen p = new ordenpantalonimagen();
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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        ventanaordenpantalonanteriores = false;
        this.dispose();

    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordenpantalonanteriores = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed

      
        
            

    }//GEN-LAST:event_btncancelarActionPerformed


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

    private void btnreplicarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreplicarActionPerformed

         File f = new File(lbrutaladoizquierdofrente.getText());
        System.out.println(f.getName());

        
        int traspaso = 0;
        
        String tipo = "Orden pantalon";
        String numerosucursal = lbfolio.getText();
        String prenda = "Pantalon";
        String cliente = lbcliente.getText();

        String path = "";
        String tiendaalaquesereplicara = lbtiendareplica.getText();
        String stringIP = "";
        String stringlocal = "";
        String stringBDlocal = "";

        String nombrearchivo1 = "";
        String nombrearchivo2 = "";
        String nombrearchivo3 = "";
        String nombrearchivo4 = "";
        String nombrearchivo5 = "";
        String nombrearchivo6 = "";

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
            System.out.println(e);
        }

        Connection conn = null;
        String iptraspaso = stringIP;
        String tienda_traspaso = stringlocal;

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
            Object ponchado1 = lbrutaladoizquierdofrente.getText();
            if (ponchado1 == null || ponchado1.equals("")||ponchado1.equals("lbrutaladoizquierdofrente")) {

            } else {
                
                try {
                    String filePath = lbrutaladoizquierdofrente.getText();
                    File archivo = new File(filePath);
                    nombrearchivo1 = archivo.getName();
                    input = new FileInputStream(new File(filePath));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_frente_ponchado=? where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_frente_ponchado_nombre='" + nombrearchivo1 + "' where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            ///ponchado2
            Object ponchado2 = lbrutaladoderechofrente.getText();
            if (ponchado2 == null || ponchado2.equals("") || ponchado2.equals(" ")|| ponchado2.equals("lbrutaladoderechofrente")) {

            } else {
                try {
                    String filePath2 = lbrutaladoderechofrente.getText();
                    File archivo2 = new File(filePath2);
                    nombrearchivo2 = archivo2.getName();
                    input2 = new FileInputStream(new File(filePath2));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_frente_ponchado=? where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input2);
                    traspaso = modificar.executeUpdate();


                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_frente_ponchado_nombre='" + nombrearchivo2 + "' where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

            ///ponchado3
            Object ponchado3 = lbrutaladoizquierdoatras.getText();
            if (ponchado3 == null || ponchado3.equals("") || ponchado3.equals(" ")||ponchado3.equals("lbrutaladoizquierdoatras")) {

            } else {
                try {
                    String filePath3 = lbrutaladoizquierdoatras.getText();
                    File archivo3 = new File(filePath3);
                    nombrearchivo3 = archivo3.getName();
                    input3 = new FileInputStream(new File(filePath3));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_atras_ponchado=? where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input3);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_izquierdo_atras_ponchado_nombre='" + nombrearchivo3 + "' where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

            //ponchado 4
            Object ponchado4 = lbrutaladoderechoatras.getText();

            if (ponchado4 == null || ponchado4.equals("") || ponchado4.equals(" ")|| ponchado4.equals("lbrutaladoderechoatras")) {

            } else {
                try {
                    String filePath4 = lbrutaladoderechoatras.getText();
                    File archivo4 = new File(filePath4);
                    nombrearchivo4 = archivo4.getName();
                    input4 = new FileInputStream(new File(filePath4));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_atras_ponchado=? where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input4);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set lado_derecho_atras_ponchado_nombre='" + nombrearchivo4 + "' where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
                    pst.executeUpdate();
                    System.out.println(pst);
                    pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

          

           /// imagen jlabel
            Object imagen = lbrutaimagen.getText();

            if (imagen == null || imagen.equals("") || imagen.equals(" ")||imagen.equals("lbrutaimagen") ) {

            } else {
                try {
                    String filePath6 = lbrutaimagen.getText();
                    File archivo6 = new File(filePath6);
                    nombrearchivo6 = archivo6.getName();
                    input6 = new FileInputStream(new File(filePath6));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(ordenbordadosolicitarotrasucursal.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    String sql2 = "UPDATE historial_ordenes_pantalon_recibidas set imagen=? where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ";
                    PreparedStatement modificar = conn.prepareStatement(sql2);
                    modificar.setBinaryStream(1, input6);
                    System.out.println(sql2);
                    traspaso = modificar.executeUpdate();

                    System.out.println("\nCompleted successfully!");

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {

                    PreparedStatement pst = conn.prepareStatement("UPDATE historial_ordenes_pantalon_recibidas set imagen_nombre='" + nombrearchivo6 + "' where numero_sucursal='" + numerosucursal + "' and tienda = '" + stringBDlocal + "' and cliente = '" + cliente + "'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
            return;
        }

        if (traspaso > 0)
        {
            
            JOptionPane.showMessageDialog(null, "La orden se inserto correctamente en la otra sucursal");

            String numero = lbfolio.getText();
            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon SET estatus_orden='enviado' WHERE numero='" + numero + "'");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            ordenesbordadogenerada.btnactualizar.doClick();

        }

        this.dispose();
        
    }//GEN-LAST:event_btnreplicarActionPerformed
   
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {     
            datos();
        } catch (IOException ex) {
            Logger.getLogger(ordenpantalonanteriores.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btncancelarbordadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarbordadoActionPerformed
    
        
        
    }//GEN-LAST:event_btncancelarbordadoActionPerformed

    private void btnagregarfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarfotomontajeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnagregarfotomontajeActionPerformed

    private void btnagregarbordado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarbordado1ActionPerformed
      JSystemFileChooser adjuntar = new JSystemFileChooser();

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaladoizquierdofrente.setText(fl);
            btnagregarbordado1.setEnabled(false);

        }
    }//GEN-LAST:event_btnagregarbordado1ActionPerformed

    private void btnagregarbordado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarbordado3ActionPerformed
     JSystemFileChooser adjuntar = new JSystemFileChooser();

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaladoizquierdoatras.setText(fl);
            btnagregarbordado3.setEnabled(false);

        }
    }//GEN-LAST:event_btnagregarbordado3ActionPerformed

    private void btnagregarbordado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarbordado4ActionPerformed
       JSystemFileChooser adjuntar = new JSystemFileChooser();

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaladoderechoatras.setText(fl);
            btnagregarbordado4.setEnabled(false);

        }
    }//GEN-LAST:event_btnagregarbordado4ActionPerformed

    private void btnagregarbordado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarbordado2ActionPerformed
       JSystemFileChooser adjuntar = new JSystemFileChooser();

        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaladoderechofrente.setText(fl);
            btnagregarbordado2.setEnabled(false);

        }
    }//GEN-LAST:event_btnagregarbordado2ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
      ventanaordenpantalonanteriores = false;
       
    }//GEN-LAST:event_formWindowClosed

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
            java.util.logging.Logger.getLogger(ordenpantalonanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordenpantalonanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordenpantalonanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordenpantalonanteriores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ordenpantalonanteriores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarbordado1;
    private javax.swing.JButton btnagregarbordado2;
    private javax.swing.JButton btnagregarbordado3;
    private javax.swing.JButton btnagregarbordado4;
    private javax.swing.JButton btnagregarfotomontaje;
    private javax.swing.JButton btncancelar;
    public static javax.swing.JButton btncancelarbordado;
    private javax.swing.JButton btnreplicar;
    public static javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbdadoizquierdoatras;
    public static javax.swing.JLabel lbfolio;
    private javax.swing.JLabel lblImagen;
    public static javax.swing.JLabel lbladoderechoatras;
    public static javax.swing.JLabel lbladoderechoatraspuntadas;
    public static javax.swing.JLabel lbladoderechofrente;
    public static javax.swing.JLabel lbladoderechofrentepuntadas;
    public static javax.swing.JLabel lbladoizquierdoatraspuntadas;
    public static javax.swing.JLabel lbladoizquierdofrente;
    public static javax.swing.JLabel lbladoizquierdofrentepuntadas;
    public static javax.swing.JLabel lbnumeroventa;
    private javax.swing.JLabel lbrutaimagen;
    private javax.swing.JLabel lbrutaladoderechoatras;
    private javax.swing.JLabel lbrutaladoderechofrente;
    private javax.swing.JLabel lbrutaladoizquierdoatras;
    private javax.swing.JLabel lbrutaladoizquierdofrente;
    private javax.swing.JLabel lbtiendareplica;
    private javax.swing.JLabel lbtituloladoderechoatras;
    private javax.swing.JLabel lbtituloladoderechofrente;
    private javax.swing.JLabel lbtituloladoizquierdoatras;
    private javax.swing.JLabel lbtituloladoizquierdofrente;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

   
}
