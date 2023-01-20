package sistemabordadores;

import javax.swing.JOptionPane;

import com.inet.jortho.FileUserDictionary;
import com.inet.jortho.SpellChecker;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import javax.print.DocFlavor;

import javax.swing.JTextField;

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
import java.nio.charset.StandardCharsets;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
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

import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;

public class ordenportanombre extends javax.swing.JFrame {

    public static boolean ventanaordenportanombremultipleanterior = false;

    String numerocatalogoprendas = "";
    String numerocatalogoubicacion = "";
    String numerocatalogocolores = "";

    String nombre = "";
    String cantidad = "";
    String prenda = "";
    String ubicacion = "";
    String color = "";

    public static String Portanombre = "";

    String nombrecliente = "";
    int renglon = 0;
    String primero = "";
    String ultimo = "";
    String tienebordado = "no";

    public ordenportanombre() {
        initComponents();
        topes();
        ventanaordenportanombremultipleanterior = true;

        txtnombre1.setHorizontalAlignment(JTextField.CENTER);
        txtnombre2.setHorizontalAlignment(JTextField.CENTER);
        txtnombre3.setHorizontalAlignment(JTextField.CENTER);
        txtnombre4.setHorizontalAlignment(JTextField.CENTER);
        txtnombre5.setHorizontalAlignment(JTextField.CENTER);
        txtnombre6.setHorizontalAlignment(JTextField.CENTER);
        txtnombre7.setHorizontalAlignment(JTextField.CENTER);
        
        
        

    }

    void topes() {

        String sql = "SELECT min(numero) as min_numero, max(numero) as max_numero FROM historial_ordenes_portanombres_multiple";

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

    void limpiardatos() {
        lbcantidad1.setText("");
        lbcantidad2.setText("");
        lbcantidad3.setText("");
        lbcantidad4.setText("");
        lbcantidad5.setText("");
        lbcantidad6.setText("");
        lbcantidad7.setText("");

        txtnombre1.setText("");
        txtnombre2.setText("");
        txtnombre3.setText("");
        txtnombre4.setText("");
        txtnombre5.setText("");
        txtnombre6.setText("");
        txtnombre7.setText("");

        lbprenda1.setText("");
        lbprenda2.setText("");
        lbprenda3.setText("");
        lbprenda4.setText("");
        lbprenda5.setText("");
        lbprenda6.setText("");
        lbprenda7.setText("");

        lbubicacion1.setText("");
        lbubicacion2.setText("");
        lbubicacion3.setText("");
        lbubicacion4.setText("");
        lbubicacion5.setText("");
        lbubicacion6.setText("");
        lbubicacion7.setText("");

        txtcolor1.setText("");
        txtcolor2.setText("");
        txtcolor3.setText("");
        txtcolor4.setText("");
        txtcolor5.setText("");
        txtcolor6.setText("");
        txtcolor7.setText("");

    }

    void datosportanombres() {

        String numero = lbnumerohistorialordenesbordados.getText();
        String numeroventa = "";
        String fecha = "";
        String hora = "";
        String tipo = "";
        String cliente = "";
        String estatusorden = "";
        String tipoletra = "";
        String cantidadtotal = "";
        String nombrepersonasolicita = "";
        String telefono = "";
        String fechaentrega = "";
        String horaentrega = "";
        String observacion = "";
        String lugar = "";

        String sql = "Select numero,numero_venta,fecha,hora,tipo,cliente,estatus_orden,nombre,tipo_letra,cantidad,prenda,color,ubicacion,cantidad_total,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion,lugar from historial_ordenes_portanombres_multiple where numero = '" + numero + "'   ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                lbnumerohistorialordenesbordados.setText(rs.getString("numero"));
                lbnumeroventa.setText(rs.getString("numero_venta"));
                txtlugar.setText(rs.getString("fecha"));
                txthora.setText(rs.getString("hora"));
                lbprenda.setText(rs.getString("tipo"));
                lbcliente.setText(rs.getString("cliente"));
                txtestatusorden.setText(rs.getString("estatus_orden"));
                String estatus = rs.getString("estatus_orden");
                
                lbtipoletra.setText(rs.getString("tipo_letra"));
                nombre = rs.getString("nombre");
                prenda = rs.getString("prenda");
                color = rs.getString("color");
                cantidad = rs.getString("cantidad");
                ubicacion = rs.getString("ubicacion");
                lbcantidadprendas.setText(rs.getString("cantidad_total"));
                txtsolicito.setText(rs.getString("nombre_persona_solicita"));
                txttelefono.setText(rs.getString("telefono"));
                txtdia.setText(rs.getString("fecha_entrega"));
                txthora.setText(rs.getString("hora_entrega"));
                txtobservacion.setText(rs.getString("observacion"));
                txtlugar.setText(rs.getString("lugar"));

                renglon = renglon + 1;
                mostrarrenglonesordenportanombre();

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        renglon = 0;

    }

    void mostrarrenglonesordenportanombre() {

        if (renglon == 1) {
            lbcantidad1.setText(cantidad);
            txtnombre1.setText(nombre);
            lbprenda1.setText(prenda);
            lbubicacion1.setText(ubicacion);
            txtcolor1.setText(color);

        } else if (renglon == 2) {
            lbcantidad2.setText(cantidad);
            txtnombre2.setText(nombre);
            lbprenda2.setText(prenda);
            lbubicacion2.setText(ubicacion);
            txtcolor2.setText(color);

        } else if (renglon == 3) {
            lbcantidad3.setText(cantidad);
            txtnombre3.setText(nombre);
            lbprenda3.setText(prenda);
            lbubicacion3.setText(ubicacion);
            txtcolor3.setText(color);

        } else if (renglon == 4) {
            lbcantidad4.setText(cantidad);
            txtnombre4.setText(nombre);
            lbprenda4.setText(prenda);
            lbubicacion4.setText(ubicacion);
            txtcolor4.setText(color);

        } else if (renglon == 5) {
            lbcantidad5.setText(cantidad);
            txtnombre5.setText(nombre);
            lbprenda5.setText(prenda);
            lbubicacion5.setText(ubicacion);
            txtcolor5.setText(color);

        } else if (renglon == 6) {
            lbcantidad6.setText(cantidad);
            txtnombre6.setText(nombre);
            lbprenda6.setText(prenda);
            lbubicacion6.setText(ubicacion);
            txtcolor6.setText(color);

        } else if (renglon == 7) {
            lbcantidad7.setText(cantidad);
            txtnombre7.setText(nombre);
            lbprenda7.setText(prenda);
            lbubicacion7.setText(ubicacion);
            txtcolor7.setText(color);

        }

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

    void diasemana() {
        Calendar now = Calendar.getInstance();

        System.out.println("Fecha actual : " + (now.get(Calendar.MONTH) + 1)
                + "-"
                + now.get(Calendar.DATE)
                + "-"
                + now.get(Calendar.YEAR));

        String[] strDays = new String[]{
            "domingo",
            "lunes",
            "martes",
            "miercoles",
            "jueves",
            "viernes",
            "sabado"};

        txtdia.setText(strDays[now.get(Calendar.DAY_OF_WEEK)]);

    }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbnumerohistorialordenesbordados = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        txtdia = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txthora = new javax.swing.JTextField();
        lbnumeroventa = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtobservacion = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        txtcolor5 = new javax.swing.JTextField();
        txtcolor7 = new javax.swing.JTextField();
        txtcolor6 = new javax.swing.JTextField();
        txtcolor1 = new javax.swing.JTextField();
        txtcolor3 = new javax.swing.JTextField();
        txtcolor2 = new javax.swing.JTextField();
        txtcolor4 = new javax.swing.JTextField();
        lbcantidadprendas = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtnombre1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtnombre2 = new javax.swing.JTextField();
        txtnombre3 = new javax.swing.JTextField();
        txtnombre4 = new javax.swing.JTextField();
        txtnombre5 = new javax.swing.JTextField();
        txtnombre6 = new javax.swing.JTextField();
        txtnombre7 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        lbprenda = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbcodigocliente = new javax.swing.JLabel();
        txtsolicito = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txttelefono = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lbtipoletra = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbcantidad5 = new javax.swing.JLabel();
        lbcantidad6 = new javax.swing.JLabel();
        lbcantidad7 = new javax.swing.JLabel();
        lbprenda1 = new javax.swing.JLabel();
        lbprenda2 = new javax.swing.JLabel();
        lbprenda3 = new javax.swing.JLabel();
        lbprenda4 = new javax.swing.JLabel();
        lbprenda5 = new javax.swing.JLabel();
        lbprenda6 = new javax.swing.JLabel();
        lbprenda7 = new javax.swing.JLabel();
        lbubicacion2 = new javax.swing.JLabel();
        lbubicacion1 = new javax.swing.JLabel();
        lbubicacion3 = new javax.swing.JLabel();
        lbubicacion4 = new javax.swing.JLabel();
        lbubicacion6 = new javax.swing.JLabel();
        lbubicacion5 = new javax.swing.JLabel();
        lbubicacion7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtbusqueda = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tbventas = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        btnprimero = new javax.swing.JButton();
        btnanterior = new javax.swing.JButton();
        btnsiguiente = new javax.swing.JButton();
        btnultimo = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        txtlugar = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtestatusorden = new javax.swing.JTextField();
        txtfecha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden portanombre multiple anterior");
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setText("Hora:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Folio");

        lbnumerohistorialordenesbordados.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbnumerohistorialordenesbordados.setForeground(new java.awt.Color(204, 0, 0));
        lbnumerohistorialordenesbordados.setText("00000000");

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        txtdia.setEditable(false);
        txtdia.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("Entrega:");

        txthora.setEditable(false);
        txthora.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        lbnumeroventa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbnumeroventa.setForeground(new java.awt.Color(204, 0, 0));
        lbnumeroventa.setText("00000");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 0, 0));
        jLabel18.setText("No venta");

        txtobservacion.setColumns(20);
        txtobservacion.setRows(5);
        jScrollPane6.setViewportView(txtobservacion);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Observaciones");

        txtcolor5.setEditable(false);

        txtcolor7.setEditable(false);

        txtcolor6.setEditable(false);

        txtcolor1.setEditable(false);

        txtcolor3.setEditable(false);

        txtcolor2.setEditable(false);
        txtcolor2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcolor2ActionPerformed(evt);
            }
        });

        txtcolor4.setEditable(false);

        lbcantidadprendas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadprendas.setForeground(new java.awt.Color(204, 0, 0));
        lbcantidadprendas.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Total de Prendas:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Color");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Tipo de Letra:");

        txtnombre1.setEditable(false);
        txtnombre1.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtnombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre1KeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Ubicación");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Prenda");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cantidad");

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setText("Nombre");

        txtnombre2.setEditable(false);
        txtnombre2.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtnombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre2KeyTyped(evt);
            }
        });

        txtnombre3.setEditable(false);
        txtnombre3.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtnombre3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre3KeyTyped(evt);
            }
        });

        txtnombre4.setEditable(false);
        txtnombre4.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtnombre4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre4KeyTyped(evt);
            }
        });

        txtnombre5.setEditable(false);
        txtnombre5.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtnombre5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre5KeyTyped(evt);
            }
        });

        txtnombre6.setEditable(false);
        txtnombre6.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtnombre6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre6KeyTyped(evt);
            }
        });

        txtnombre7.setEditable(false);
        txtnombre7.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtnombre7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre7KeyTyped(evt);
            }
        });

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel22.setText("Orden de:");

        lbprenda.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel16.setText("Cliente:");

        lbcliente.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbclienteMouseClicked(evt);
            }
        });

        txtsolicito.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Solicitó:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Telefono:");

        txttelefono.setEditable(false);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 0, 0));
        jLabel19.setText("Donde se bordadá?");

        lbtipoletra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad1.setText("0");
        lbcantidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad2.setText("0");
        lbcantidad2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad3.setText("0");
        lbcantidad3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad4.setText("0");
        lbcantidad4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad5.setText("0");
        lbcantidad5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad6.setText("0");
        lbcantidad6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad7.setText("0");
        lbcantidad7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbprenda2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbprenda3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbprenda4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbprenda5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbprenda6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbprenda7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbubicacion2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbubicacion1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbubicacion3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbubicacion4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbubicacion6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbubicacion5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        lbubicacion7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusquedaActionPerformed(evt);
            }
        });
        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyTyped(evt);
            }
        });

        btnbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnbuscar.setText("Buscar");
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        tbventas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbventas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tbventas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbventasMouseClicked(evt);
            }
        });
        tbventas.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tbventasPropertyChange(evt);
            }
        });
        jScrollPane7.setViewportView(tbventas);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setText("Busqueda");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(957, 957, 957))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscar)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnprimero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnprimero.setText("<< primero");
        btnprimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprimeroActionPerformed(evt);
            }
        });

        btnanterior.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnanterior.setText("<anterior");
        btnanterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanteriorActionPerformed(evt);
            }
        });

        btnsiguiente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsiguiente.setText("siguiente>");
        btnsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguienteActionPerformed(evt);
            }
        });

        btnultimo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnultimo.setText("ultimo>>");
        btnultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnultimoActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel23.setText("Fecha");

        txtlugar.setEditable(false);
        txtlugar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setText("Estatus Orden");

        txtestatusorden.setEditable(false);
        txtestatusorden.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        txtfecha.setEditable(false);
        txtfecha.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(txtnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(lbprenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbubicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(txtnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lbprenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbprenda3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbubicacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtnombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbprenda4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbubicacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtnombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbprenda5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbubicacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtnombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbprenda6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbubicacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtnombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lbprenda7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lbubicacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(txtcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(txtsolicito, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtdia, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19)
                    .addComponent(txtlugar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnprimero)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(100, 100, 100)
                                .addComponent(btnanterior))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(190, 190, 190)
                                .addComponent(btnsiguiente)))
                        .addGap(1, 1, 1)
                        .addComponent(btnultimo))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(txtestatusorden, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(146, 146, 146)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(229, 229, 229)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(88, 88, 88)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(179, 179, 179))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel16)
                            .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(lbtipoletra, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lbnumerohistorialordenesbordados, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbcantidadprendas, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(35, 35, 35)
                                        .addComponent(jLabel18)
                                        .addGap(20, 20, 20)
                                        .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(238, 238, 238)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel16))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(lbnumeroventa))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel13)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(lbnumerohistorialordenesbordados)
                                            .addComponent(jLabel15)))
                                    .addComponent(lbcantidadprendas, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel21))
                            .addComponent(lbtipoletra, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel20)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbcantidad1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lbprenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbubicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbcantidad2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(txtnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbprenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcantidad3)
                    .addComponent(txtnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbprenda3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbubicacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcantidad4)
                    .addComponent(txtnombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbprenda4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbubicacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcantidad5)
                    .addComponent(txtnombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbprenda5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbubicacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcantidad6)
                    .addComponent(txtnombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbprenda6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbubicacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbcantidad7)
                    .addComponent(txtnombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbprenda7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbubicacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel8)))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtsolicito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel14)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel12))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtdia, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txthora, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel23))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(txtfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel19)
                        .addGap(15, 15, 15)
                        .addComponent(txtlugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnprimero)
                            .addComponent(btnanterior)
                            .addComponent(btnsiguiente)
                            .addComponent(btnultimo))
                        .addGap(2, 2, 2)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel9)
                    .addComponent(txtestatusorden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
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

        ventanaordenportanombremultipleanterior = false;
        this.dispose();

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordenportanombremultipleanterior = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void txtnombre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre1KeyTyped
        if (txtnombre1.getText().length() >= 22) {
            evt.consume();
        }
    }//GEN-LAST:event_txtnombre1KeyTyped

    private void txtnombre2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre2KeyTyped

    private void txtnombre3KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre3KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre3KeyTyped

    private void txtnombre4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre4KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre4KeyTyped

    private void txtnombre5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre5KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre5KeyTyped

    private void txtnombre6KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre6KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre6KeyTyped

    private void txtnombre7KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre7KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre7KeyTyped
   
    private void lbclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbclienteMouseClicked

       
    }//GEN-LAST:event_lbclienteMouseClicked

    private void txtcolor2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcolor2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcolor2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


    }//GEN-LAST:event_formWindowOpened

    private void txtbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbusquedaActionPerformed

    private void txtbusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0')
                || (caracter > '9'))
                && (caracter != '\b')) {
            evt.consume();

        }

        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnbuscar.doClick();
        }
    }//GEN-LAST:event_txtbusquedaKeyTyped

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed

        String num = txtbusqueda.getText();
        int numeroanterior = Integer.parseInt(num);
        int resta = numeroanterior + 0;
        String numerodeventa = Integer.toString(resta);
        int largo = numerodeventa.length();

        if (largo == 1) {
            String var2 = numerodeventa;
            String var3 = new String("0000000");
            numerodeventa = var3.concat(var2);
        }
        if (largo == 2) {
            String var2 = numerodeventa;
            String var3 = new String("000000");
            numerodeventa = var3.concat(var2);
        }
        if (largo == 3) {
            String var2 = numerodeventa;
            String var3 = new String("00000");
            numerodeventa = var3.concat(var2);
        }
        if (largo == 4) {
            String var2 = numerodeventa;
            String var3 = new String("0000");
            numerodeventa = var3.concat(var2);
        }
        if (largo == 5) {
            String var2 = numerodeventa;
            String var3 = new String("000");
            numerodeventa = var3.concat(var2);
        }
        if (largo == 6) {
            String var2 = numerodeventa;
            String var3 = new String("00");
            numerodeventa = var3.concat(var2);
        }
        if (largo == 7) {
            String var2 = numerodeventa;
            String var3 = new String("0");
            numerodeventa = var3.concat(var2);
        }
        txtbusqueda.setText(numerodeventa);
        lbnumerohistorialordenesbordados.setText(numerodeventa);

        String sql = "";
        sql = "SELECT numero FROM historial_ordenes_portanombres_multiple WHERE numero = '" + numerodeventa + "' ";

        try {
            PreparedStatement pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                String add1 = rs.getString("numero");
                lbnumerohistorialordenesbordados.setText(add1);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        datosportanombres();

    }//GEN-LAST:event_btnbuscarActionPerformed

    private void tbventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbventasMouseClicked

    }//GEN-LAST:event_tbventasMouseClicked

    private void tbventasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbventasPropertyChange

    }//GEN-LAST:event_tbventasPropertyChange

    private void btnprimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprimeroActionPerformed
        limpiardatos();
        txtbusqueda.setText(primero);
        lbnumerohistorialordenesbordados.setText(primero);
        datosportanombres();
    }//GEN-LAST:event_btnprimeroActionPerformed

    private void btnanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanteriorActionPerformed

        limpiardatos();
        int nummin = Integer.parseInt(primero);
        String num = txtbusqueda.getText();
        int numeroanterior = Integer.parseInt(num);
        int resta = numeroanterior - 1;
        if (numeroanterior == nummin) {
            JOptionPane.showMessageDialog(null, "Este es el ultimo registro");
        } else {
            String numero = Integer.toString(resta);
            txtbusqueda.setText(numero);

            String sql = "";
            sql = "SELECT numero FROM historial_ordenes_portanombres_multiple WHERE numero like '%" + numero + "' ";

            try {
                PreparedStatement pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    lbnumerohistorialordenesbordados.setText(rs.getString("numero"));
                    txtbusqueda.setText(rs.getString("numero"));

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

        datosportanombres();
    }//GEN-LAST:event_btnanteriorActionPerformed

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed

        limpiardatos();
        int nummax = Integer.parseInt(ultimo);
        String numeroactual = txtbusqueda.getText();
        int num = Integer.parseInt(numeroactual);
        int numerosiguiente = num + 1;
        if (num == nummax) {
            JOptionPane.showMessageDialog(null, "Este es el ultimo registro");
        } else {
            String numero = Integer.toString(numerosiguiente);
            txtbusqueda.setText(numero);

            String sql = "";
            sql = "SELECT numero FROM historial_ordenes_portanombres_multiple WHERE numero like '%" + numero + "' ";

            try {
                PreparedStatement pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                if (rs.next()) {

                    lbnumerohistorialordenesbordados.setText(rs.getString("numero"));
                    txtbusqueda.setText(rs.getString("numero"));

                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);

            }
        }

        datosportanombres();


    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void btnultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnultimoActionPerformed
        limpiardatos();
        txtbusqueda.setText(ultimo);
        lbnumerohistorialordenesbordados.setText(ultimo);
        datosportanombres();
    }//GEN-LAST:event_btnultimoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventanaordenportanombremultipleanterior = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    ResultSet rs;
    ResultSet rs2;

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordenportanombre().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnanterior;
    public static javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnprimero;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JButton btnultimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JLabel lbcantidad1;
    private javax.swing.JLabel lbcantidad2;
    private javax.swing.JLabel lbcantidad3;
    private javax.swing.JLabel lbcantidad4;
    private javax.swing.JLabel lbcantidad5;
    private javax.swing.JLabel lbcantidad6;
    private javax.swing.JLabel lbcantidad7;
    public static javax.swing.JLabel lbcantidadprendas;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbcodigocliente;
    public static javax.swing.JLabel lbnumerohistorialordenesbordados;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JLabel lbprenda;
    private javax.swing.JLabel lbprenda1;
    private javax.swing.JLabel lbprenda2;
    private javax.swing.JLabel lbprenda3;
    private javax.swing.JLabel lbprenda4;
    private javax.swing.JLabel lbprenda5;
    private javax.swing.JLabel lbprenda6;
    private javax.swing.JLabel lbprenda7;
    private javax.swing.JLabel lbtipoletra;
    private javax.swing.JLabel lbubicacion1;
    private javax.swing.JLabel lbubicacion2;
    private javax.swing.JLabel lbubicacion3;
    private javax.swing.JLabel lbubicacion4;
    private javax.swing.JLabel lbubicacion5;
    private javax.swing.JLabel lbubicacion6;
    private javax.swing.JLabel lbubicacion7;
    public static javax.swing.JTable tbventas;
    public static javax.swing.JTextField txtbusqueda;
    private javax.swing.JTextField txtcolor1;
    private javax.swing.JTextField txtcolor2;
    private javax.swing.JTextField txtcolor3;
    private javax.swing.JTextField txtcolor4;
    private javax.swing.JTextField txtcolor5;
    private javax.swing.JTextField txtcolor6;
    private javax.swing.JTextField txtcolor7;
    private javax.swing.JTextField txtdia;
    private javax.swing.JTextField txtestatusorden;
    private javax.swing.JTextField txtfecha;
    private javax.swing.JTextField txthora;
    private javax.swing.JTextField txtlugar;
    private javax.swing.JTextField txtnombre1;
    private javax.swing.JTextField txtnombre2;
    private javax.swing.JTextField txtnombre3;
    private javax.swing.JTextField txtnombre4;
    private javax.swing.JTextField txtnombre5;
    private javax.swing.JTextField txtnombre6;
    private javax.swing.JTextField txtnombre7;
    private javax.swing.JTextArea txtobservacion;
    private javax.swing.JTextField txtsolicito;
    private javax.swing.JTextField txttelefono;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
