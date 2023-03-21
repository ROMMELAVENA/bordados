package sistemabordadores;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;


public class ordeninternaparcheanterior extends javax.swing.JFrame {
public static boolean ventanaordeninternaparcheanterior = false;

        private PreparedStatement pst;
        
        String numerocatalogoprendas = "";
        String numerocatalogoubicacion = "";
        String numerocatalogocolores = "";
        
        
        String cantidad = "";
        String cantidadentregada = "";
        String cantidadremanente = "";
        String parche = "";
        String nombre = "";
        String ubicacion = "";
        String aplicacion = "";
        String observacion = "";
        String estatusentrega ="";
        int renglon = 0;
        
        String primero = "";
        String ultimo = "";
     int posicion=0;
     int primernumero = 0;
     int posiciondelarreglo = 0;
     ArrayList<String> listaparches = new ArrayList<String>();

        
     
    String prenda = "";
    String color = "";
    String descripcion = "";
    String nombrecompleto = "";

    String s1 = "GORRA ";
    String s2 = " CON BORDADO ";

    
        
   
    public ordeninternaparcheanterior() {
        initComponents();
        ventanaordeninternaparcheanterior = true;
        topes();
          
       btncancelarbordado.setVisible(false);
        
    }

    
    void limpiar()
    {
        
        lbcantidad1.setText("0");
        lbcantidad2.setText("0");
        lbcantidad3.setText("0");
        lbcantidad4.setText("0");
        lbcantidad5.setText("0");
        lbcantidad6.setText("0");
        lbcantidad7.setText("0");
        lbcantidad8.setText("0");
        lbcantidad9.setText("0");
        lbcantidad10.setText("0");
        
        lbcantidadrecibida1.setText("0");
        lbcantidadrecibida2.setText("0");
        lbcantidadrecibida3.setText("0");
        lbcantidadrecibida4.setText("0");
        lbcantidadrecibida5.setText("0");
        lbcantidadrecibida6.setText("0");
        lbcantidadrecibida7.setText("0");
        lbcantidadrecibida8.setText("0");
        lbcantidadrecibida9.setText("0");
        lbcantidadrecibida10.setText("0");
        
        lbcantidadremanente1.setText("0");
        lbcantidadremanente2.setText("0");
        lbcantidadremanente3.setText("0");
        lbcantidadremanente4.setText("0");
        lbcantidadremanente5.setText("0");
        lbcantidadremanente6.setText("0");
        lbcantidadremanente7.setText("0");
        lbcantidadremanente8.setText("0");
        lbcantidadremanente9.setText("0");
        lbcantidadremanente10.setText("0");
        
        lbnombre1.setText("");
        lbnombre2.setText("");
        lbnombre3.setText("");
        lbnombre4.setText("");
        lbnombre5.setText("");
        lbnombre6.setText("");
        lbnombre7.setText("");
        lbnombre8.setText("");
        lbnombre9.setText("");
        lbnombre10.setText("");
        
        
        
    }
    
    
     void topes() {

      String sql = "Select distinct numero from historial_ordenes_bordados_interno where prenda = 'Parche' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String numero = rs.getString("numero");

                listaparches.add(numero);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

        primero = listaparches.get(0).toString();
        primernumero = Integer.parseInt(primero);
        

        posicion = listaparches.size() - 1;
        
        ultimo = listaparches.get(posicion);
        posiciondelarreglo =  posicion;
        
         txtbusqueda.setText(ultimo);
         btnbuscar.doClick();

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

    void datos(String tipoprenda) {

        String sql ="";
        String numero = txtbusqueda.getText();
        renglon = 0;

            
             sql = "SELECT numero,fecha,hora,cantidad,cantidad_entregada,cantidad_remanente,descripcion,estatus_entrega,fecha_entrega FROM historial_ordenes_bordados_interno WHERE numero = '" + numero + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                lbfolio.setText(rs.getString("numero"));
                lbfecha.setText(rs.getString("fecha"));
                lbhora.setText(rs.getString("hora"));
                
                cantidad = rs.getString("cantidad");
                cantidadentregada = rs.getString("cantidad_entregada");
                
                int cantidadint = Integer.parseInt(cantidad);
                int cantidadentregadaint = Integer.parseInt(cantidadentregada);
                
                int cantidadremanenteint = cantidadint - cantidadentregadaint;
                
                cantidadremanente = String.valueOf(cantidadremanenteint) ;
                
                descripcion = rs.getString("descripcion");
                estatusentrega = rs.getString("estatus_entrega");
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbestatusentrega.setText(estatusentrega);
               
                if(estatusentrega.equals("cancelada")||estatusentrega.equals("entregada"))
                {
                    btncancelar.setEnabled(false);
                  
                }
                renglon = renglon + 1;
                mostrarrenglonesparche();

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
            
       
    
    }

    void mostrarrenglonesgorra() {

        if (renglon == 1)
        {
            ordeninternagorraanterior.lbcantidad1.setText(cantidad);
           ordeninternagorraanterior. lbcolor1.setText(color);
            ordeninternagorraanterior.lbnombre1.setText(descripcion);
            ordeninternagorraanterior.lbobservacion1.setText(nombrecompleto);
            
        } else if (renglon == 2) {
            ordeninternagorraanterior.lbcantidad2.setText(cantidad);
           ordeninternagorraanterior. lbcolor2.setText(color);
           ordeninternagorraanterior. lbnombre2.setText(descripcion);
           ordeninternagorraanterior. lbobservacion2.setText(nombrecompleto);

        } else if (renglon == 3) {
           ordeninternagorraanterior. lbcantidad3.setText(cantidad);
           ordeninternagorraanterior. lbcolor3.setText(color);
           ordeninternagorraanterior. lbnombre3.setText(descripcion);
           ordeninternagorraanterior. lbobservacion3.setText(nombrecompleto);

        } else if (renglon == 4) {
           ordeninternagorraanterior. lbcantidad4.setText(cantidad);
          ordeninternagorraanterior .lbcolor4.setText(color);
          ordeninternagorraanterior.  lbnombre4.setText(descripcion);
          ordeninternagorraanterior.  lbobservacion4.setText(nombrecompleto);

        } else if (renglon == 5) {
          ordeninternagorraanterior.  lbcantidad5.setText(cantidad);
          ordeninternagorraanterior.  lbcolor5.setText(color);
          ordeninternagorraanterior.  lbnombre5.setText(descripcion);
           ordeninternagorraanterior. lbobservacion5.setText(nombrecompleto);

        }
        else if (renglon == 6) {
          ordeninternagorraanterior.  lbcantidad6.setText(cantidad);
          ordeninternagorraanterior.  lbcolor6.setText(color);
          ordeninternagorraanterior.  lbnombre6.setText(descripcion);
           ordeninternagorraanterior. lbobservacion6.setText(nombrecompleto);

        }
        else if (renglon == 7) {
          ordeninternagorraanterior.  lbcantidad7.setText(cantidad);
          ordeninternagorraanterior.  lbcolor7.setText(color);
          ordeninternagorraanterior.  lbnombre7.setText(descripcion);
           ordeninternagorraanterior. lbobservacion7.setText(nombrecompleto);

        }
        else if (renglon == 8) {
          ordeninternagorraanterior.  lbcantidad8.setText(cantidad);
          ordeninternagorraanterior.  lbcolor8.setText(color);
          ordeninternagorraanterior.  lbnombre8.setText(descripcion);
           ordeninternagorraanterior. lbobservacion8.setText(nombrecompleto);

        }
        else if (renglon == 9) {
          ordeninternagorraanterior.  lbcantidad9.setText(cantidad);
          ordeninternagorraanterior.  lbcolor9.setText(color);
          ordeninternagorraanterior.  lbnombre9.setText(descripcion);
           ordeninternagorraanterior. lbobservacion9.setText(nombrecompleto);

        }
        else if (renglon == 10) {
          ordeninternagorraanterior.  lbcantidad10.setText(cantidad);
          ordeninternagorraanterior.  lbcolor10.setText(color);
          ordeninternagorraanterior.  lbnombre10.setText(descripcion);
           ordeninternagorraanterior. lbobservacion10.setText(nombrecompleto);

        }

    }
    
    
    void mostrarrenglonesparche() {

        if (renglon == 1)
        {
            lbcantidad1.setText(cantidad);
            lbcantidadrecibida1.setText(cantidadentregada);
            lbcantidadremanente1.setText(cantidadremanente);
            lbnombre1.setText(descripcion);
        
            
        } else if (renglon == 2) {
            lbcantidad2.setText(cantidad);
            lbcantidadrecibida2.setText(cantidadentregada);
            lbcantidadremanente2.setText(cantidadremanente);
            lbnombre2.setText(descripcion);


        } else if (renglon == 3) {
            lbcantidad3.setText(cantidad);
            lbcantidadrecibida3.setText(cantidadentregada);
            lbcantidadremanente3.setText(cantidadremanente);
            lbnombre3.setText(descripcion);


        } else if (renglon == 4) {
            lbcantidad4.setText(cantidad);
            lbcantidadrecibida4.setText(cantidadentregada);
            lbcantidadremanente4.setText(cantidadremanente);
            lbnombre4.setText(descripcion);


        } else if (renglon == 5) {
            lbcantidad5.setText(cantidad);
            lbcantidadrecibida5.setText(cantidadentregada);
            lbcantidadremanente5.setText(cantidadremanente);
            lbnombre5.setText(descripcion);

        }
        else if (renglon == 6) {
            lbcantidad6.setText(cantidad);
            lbcantidadrecibida6.setText(cantidadentregada);
            lbcantidadremanente6.setText(cantidadremanente);
            lbnombre6.setText(descripcion);

        }
        else if (renglon == 7) {
            lbcantidad7.setText(cantidad);
            lbcantidadrecibida7.setText(cantidadentregada);
            lbcantidadremanente7.setText(cantidadremanente);
            lbnombre7.setText(descripcion);

        }
        else if (renglon == 8) {
            lbcantidad8.setText(cantidad);
            lbcantidadrecibida8.setText(cantidadentregada);
            lbcantidadremanente8.setText(cantidadremanente);
            lbnombre8.setText(descripcion);

        }else if (renglon == 9) {
            lbcantidad9.setText(cantidad);
            lbcantidadrecibida9.setText(cantidadentregada);
            lbcantidadremanente9.setText(cantidadremanente);
            lbnombre9.setText(descripcion);

        }
        else if (renglon == 10) {
            lbcantidad10.setText(cantidad);
            lbcantidadrecibida10.setText(cantidadentregada);
            lbcantidadremanente10.setText(cantidadremanente);
            lbnombre10.setText(descripcion);

        }
        
        
       

    }
    
   
    void sumadelremanente()
    {
        
        
        Object cantidad1 = lbcantidadremanente1.getText();
        if(cantidad1 ==null || cantidad1.equals(""))
        {
            cantidad1 = 0;
        }
        Object cantidad2 = lbcantidadremanente2.getText();
        if(cantidad2 ==null || cantidad2.equals(""))
        {
            cantidad2 = 0;
        }
        Object cantidad3 = lbcantidadremanente3.getText();
        if(cantidad3 ==null || cantidad3.equals(""))
        {
            cantidad3 = 0;
        }
        Object cantidad4 = lbcantidadremanente4.getText();
        if(cantidad4 ==null || cantidad4.equals(""))
        {
            cantidad4 = 0;
        }
        Object cantidad5 = lbcantidadremanente5.getText();
        if(cantidad5 ==null || cantidad5.equals(""))
        {
            cantidad5 = 0;
        }
        Object cantidad6 = lbcantidadremanente6.getText();
        if(cantidad6 ==null || cantidad6.equals(""))
        {
            cantidad6 = 0;
        }
        Object cantidad7 = lbcantidadremanente7.getText();
        if(cantidad7 ==null || cantidad7.equals(""))
        {
            cantidad7 = 0;
        }
        Object cantidad8 = lbcantidadremanente8.getText();
        if(cantidad8 ==null || cantidad8.equals(""))
        {
            cantidad8 = 0;
        }
        Object cantidad9 = lbcantidadremanente9.getText();
        if(cantidad9 ==null || cantidad9.equals(""))
        {
            cantidad9 = 0;
        }
        Object cantidad10 = lbcantidadremanente10.getText();
        if(cantidad10 ==null || cantidad10.equals(""))
        {
            cantidad10 = 0;
        }
        
        
        int cantidadremanente1 =  Integer.parseInt(cantidad1.toString());
        int cantidadremanente2 =  Integer.parseInt(cantidad2.toString());
        int cantidadremanente3 =  Integer.parseInt(cantidad3.toString());
        int cantidadremanente4 =  Integer.parseInt(cantidad4.toString());
        int cantidadremanente5 =  Integer.parseInt(cantidad5.toString());
        int cantidadremanente6 =  Integer.parseInt(cantidad6.toString());
        int cantidadremanente7 =  Integer.parseInt(cantidad7.toString());
        int cantidadremanente8 =  Integer.parseInt(cantidad8.toString());
        int cantidadremanente9 =  Integer.parseInt(cantidad9.toString());
        int cantidadremanente10 =  Integer.parseInt(cantidad10.toString()); 
        
        int sumadeelremantente = cantidadremanente1+cantidadremanente2+cantidadremanente3+cantidadremanente4+cantidadremanente5+cantidadremanente6+cantidadremanente7+cantidadremanente8+cantidadremanente9+cantidadremanente10;
        
        if(sumadeelremantente > 0 )
        {
            btnrecibir.setEnabled(true);
        }
        else
        {
            btnrecibir.setEnabled(false);
        }  
        
    }
    
    
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel13 = new javax.swing.JLabel();
        lbfolio = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbcantidad5 = new javax.swing.JLabel();
        lbnombre1 = new javax.swing.JLabel();
        lbnombre2 = new javax.swing.JLabel();
        lbnombre3 = new javax.swing.JLabel();
        lbnombre4 = new javax.swing.JLabel();
        lbnombre5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbcantidad6 = new javax.swing.JLabel();
        lbnombre6 = new javax.swing.JLabel();
        lbnombre7 = new javax.swing.JLabel();
        lbcantidad7 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        lbnombre8 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbcantidad8 = new javax.swing.JLabel();
        lbnombre9 = new javax.swing.JLabel();
        lbcantidad9 = new javax.swing.JLabel();
        lbnombre10 = new javax.swing.JLabel();
        lbcantidad10 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbcantidadrecibida1 = new javax.swing.JLabel();
        lbcantidadrecibida2 = new javax.swing.JLabel();
        lbcantidadrecibida3 = new javax.swing.JLabel();
        lbcantidadrecibida4 = new javax.swing.JLabel();
        lbcantidadrecibida5 = new javax.swing.JLabel();
        lbcantidadrecibida6 = new javax.swing.JLabel();
        lbcantidadrecibida7 = new javax.swing.JLabel();
        lbcantidadrecibida8 = new javax.swing.JLabel();
        lbcantidadrecibida9 = new javax.swing.JLabel();
        lbcantidadrecibida10 = new javax.swing.JLabel();
        lbcantidadremanente3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbcantidadremanente7 = new javax.swing.JLabel();
        lbcantidadremanente5 = new javax.swing.JLabel();
        lbcantidadremanente1 = new javax.swing.JLabel();
        lbcantidadremanente10 = new javax.swing.JLabel();
        lbcantidadremanente4 = new javax.swing.JLabel();
        lbcantidadremanente9 = new javax.swing.JLabel();
        lbcantidadremanente6 = new javax.swing.JLabel();
        lbcantidadremanente2 = new javax.swing.JLabel();
        lbcantidadremanente8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txtbusqueda = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbventas = new javax.swing.JTable();
        btnprimero = new javax.swing.JButton();
        btnanterior = new javax.swing.JButton();
        btnsiguiente = new javax.swing.JButton();
        btnultimo = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        lbtipo = new javax.swing.JLabel();
        lbarticulo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbhora = new javax.swing.JLabel();
        lbestatusentrega = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbfechaentrega = new javax.swing.JLabel();
        btnrecibir = new javax.swing.JButton();
        btncancelarbordado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orden interna parches anterior");
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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Folio");

        lbfolio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbfolio.setForeground(new java.awt.Color(204, 0, 0));
        lbfolio.setText("00000");

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setText("Orden interna parches anterior");

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cantidad");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setText("1.-");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 0, 0));
        jLabel16.setText("2.-");

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 0, 0));
        jLabel22.setText("3.-");

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 0, 0));
        jLabel23.setText("4.-");

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 0, 0));
        jLabel24.setText("5.-");

        lbcantidad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("6.-");

        lbcantidad6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 0, 0));
        jLabel25.setText("7.-");

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 0, 0));
        jLabel26.setText("8.-");

        lbnombre8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(204, 0, 0));
        jLabel31.setText("9.-");

        lbcantidad8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(204, 0, 0));
        jLabel32.setText("10.-");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Recibidas");

        lbcantidadrecibida1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibida1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibida2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibida2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibida3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibida3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibida4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibida4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibida5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibida5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibida6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibida6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibida7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibida7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibida8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibida8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibida9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibida9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibida10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibida10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setText("Remanente");

        lbcantidadremanente7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(lbcantidadrecibida1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbcantidadrecibida2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcantidadrecibida3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcantidadrecibida4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbcantidad10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcantidadrecibida10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidadrecibida7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidadrecibida8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidadrecibida9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbcantidadrecibida5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbcantidadrecibida6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(lbcantidadremanente1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidadremanente10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidadremanente7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidadremanente8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidadremanente9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidadremanente2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidadremanente3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidadremanente4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidadremanente5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidadremanente6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbnombre3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbnombre4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbnombre6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbnombre8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbnombre9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbnombre10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbnombre1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbnombre5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbnombre7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(339, 339, 339)
                .addComponent(jLabel3)
                .addGap(621, 621, 621))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(17, 17, 17)
                        .addComponent(lbnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lbnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(lbnombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbnombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbnombre10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbnombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbnombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbnombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(lbnombre9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbcantidadrecibida4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(17, 17, 17)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel5))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(jLabel16)
                                                .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(15, 15, 15)
                                            .addComponent(jLabel22)))
                                    .addGap(13, 13, 13)
                                    .addComponent(jLabel23)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addGap(17, 17, 17)
                                        .addComponent(lbcantidadremanente1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbcantidadremanente3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(13, 13, 13))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbcantidadrecibida3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lbcantidadremanente2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel2)
                                                        .addGap(17, 17, 17)
                                                        .addComponent(lbcantidadrecibida1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(lbcantidadrecibida2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(37, 37, 37)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(lbcantidadremanente4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel24))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbcantidad8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbcantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel9))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel25)
                                                    .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(15, 15, 15)
                                                .addComponent(jLabel26)))
                                        .addGap(13, 13, 13)
                                        .addComponent(jLabel31)))
                                .addGap(13, 13, 13)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcantidad10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel32)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbcantidadrecibida5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbcantidadrecibida9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbcantidadrecibida8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbcantidadrecibida6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbcantidadrecibida7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)))
                                        .addGap(35, 35, 35))
                                    .addComponent(lbcantidadremanente6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addComponent(lbcantidadrecibida10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbcantidadremanente5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbcantidadremanente9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbcantidadremanente8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbcantidadremanente7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)))
                                        .addGap(35, 35, 35)))
                                .addGap(13, 13, 13)
                                .addComponent(lbcantidadremanente10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );

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
        jScrollPane3.setViewportView(tbventas);

        btnprimero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnprimero.setText("<<");
        btnprimero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprimeroActionPerformed(evt);
            }
        });

        btnanterior.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnanterior.setText("<");
        btnanterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanteriorActionPerformed(evt);
            }
        });

        btnsiguiente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsiguiente.setText(">");
        btnsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguienteActionPerformed(evt);
            }
        });

        btnultimo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnultimo.setText(">>");
        btnultimo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnultimoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnanterior)
                            .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btnsiguiente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnultimo)))))
                .addGap(1058, 1058, 1058))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnprimero)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnprimero, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnultimo))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnbuscar)
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        lbtipo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbtipo.setForeground(new java.awt.Color(204, 0, 0));

        lbarticulo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbarticulo.setForeground(new java.awt.Color(204, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fecha");

        lbfecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfecha.setText(" ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Hora");

        lbhora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhora.setText(" ");

        lbestatusentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbestatusentrega.setText(" ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Estatus Entrega");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Fecha Entrega");

        lbfechaentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfechaentrega.setText(" ");

        btnrecibir.setText("Recibir");
        btnrecibir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrecibirActionPerformed(evt);
            }
        });

        btncancelarbordado.setText("btncancelarbordado");
        btncancelarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarbordadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbestatusentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 284, Short.MAX_VALUE)
                                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(149, 149, 149)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btncancelarbordado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnrecibir, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(205, 205, 205)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbtipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbarticulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(lbfolio))))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(lbfechaentrega))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(lbestatusentrega))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(lbhora))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(lbfecha)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnrecibir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btncancelarbordado))
                                .addGap(8, 8, 8)))))
                .addGap(0, 24, Short.MAX_VALUE))
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
       
        ventanaordeninternaparcheanterior = false;
        this.dispose();
        
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordeninternaparcheanterior = false;
    }//GEN-LAST:event_formWindowClosing

    private void btnprimeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprimeroActionPerformed
txtbusqueda.setText(primero);
limpiar();
btnbuscar.doClick();
posiciondelarreglo = 0;
    }//GEN-LAST:event_btnprimeroActionPerformed

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed
    posiciondelarreglo =posiciondelarreglo+1;
     if(posiciondelarreglo > posicion)
{
    JOptionPane.showMessageDialog(null, "Este es tu ultimo registro");
    posiciondelarreglo=posicion;
    
}

else
{  
String numero =  listaparches.get(posiciondelarreglo);
txtbusqueda.setText(numero);
btnbuscar.doClick();
}
    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void btnanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanteriorActionPerformed
posiciondelarreglo =posiciondelarreglo -1;

if(posiciondelarreglo < 0)
{
    JOptionPane.showMessageDialog(null, "Este es tu ultimo registro");
    posiciondelarreglo=0;
}

else
{   
String numero =  listaparches.get(posiciondelarreglo);
txtbusqueda.setText(numero);
limpiar();
btnbuscar.doClick();
}   

    }//GEN-LAST:event_btnanteriorActionPerformed

    private void btnultimoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnultimoActionPerformed
txtbusqueda.setText(ultimo);
limpiar();
btnbuscar.doClick();
posiciondelarreglo = listaparches.size() - 1;

    }//GEN-LAST:event_btnultimoActionPerformed

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
String tipoprenda ="";
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
        lbfolio.setText(numerodeventa);

        String sql = "";
        sql = "SELECT numero,prenda FROM historial_ordenes_bordados_interno WHERE numero = '"+numerodeventa+"' ";

        try {
            pst = cn.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                
                lbfolio.setText(rs.getString("numero"));
                 tipoprenda =rs.getString("prenda");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

      
        datos(tipoprenda);
        sumadelremanente(); 
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void tbventasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbventasMouseClicked

    }//GEN-LAST:event_tbventasMouseClicked

    private void tbventasPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tbventasPropertyChange

    }//GEN-LAST:event_tbventasPropertyChange
void cancelarbordado()
{
     String numero = lbfolio.getText();
        String modi2 = "UPDATE historial_ordenes_bordados_interno SET estatus_entrega='cancelada' WHERE numero = '" + numero + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi2);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }   
        
btncancelar.setEnabled(false);
}
    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed

        if (autorizacion.ventanaautorizacion == true)
            {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de autorizaci�n");
            }
            
            else
            {
            autorizacion ventana = new autorizacion();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);
            
            autorizacion.lbinterfaz.setText("ordenanteriorbordadointernoparches");
            autorizacion.lbnivel.setText("1");
            
            
            
            
            }
             
             btnbuscar.doClick();
        
       

    }//GEN-LAST:event_btncancelarActionPerformed

    private void btnrecibirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrecibirActionPerformed
      
/*        
        ordeninternaparcherecibir entregar = new ordeninternaparcherecibir();
        entregar.setVisible(true);

        ordeninternaparcherecibir.lbfolio.setText(lbfolio.getText());

        String nombreparche1 = lbnombre1.getText();
        String cantidadparche1 = lbcantidadremanente1.getText();

        String nombreparche2 = lbnombre2.getText();
        String cantidadparche2 = lbcantidadremanente2.getText();

        String nombreparche3 = lbnombre3.getText();
        String cantidadparche3 = lbcantidadremanente3.getText();

        String nombreparche4 = lbnombre4.getText();
        String cantidadparche4 = lbcantidadremanente4.getText();

        String nombreparche5 = lbnombre5.getText();
        String cantidadparche5 = lbcantidadremanente5.getText();

        String nombreparche6 = lbnombre6.getText();
        String cantidadparche6 = lbcantidadremanente6.getText();

        String nombreparche7 = lbnombre7.getText();
        String cantidadparche7 = lbcantidadremanente7.getText();

        String nombreparche8 = lbnombre8.getText();
        String cantidadparche8 = lbcantidadremanente8.getText();

        String nombreparche9 = lbnombre9.getText();
        String cantidadparche9 = lbcantidadremanente9.getText();

        String nombreparche10 = lbnombre10.getText();
        String cantidadparche10 = lbcantidadremanente10.getText();

        int parche1 = nombreparche1.length();
        
        if (parche1 > 0) 
        {
            ordeninternaparcherecibir.txtparche1.setText(nombreparche1);
            ordeninternaparcherecibir.txtparche1cantidad.setText(cantidadparche1);
            
        } else {

            ordeninternaparcherecibir.txtparche1.setEnabled(false);
            ordeninternaparcherecibir.txtparche1cantidad.setEnabled(false);
        }

        int parche2 = nombreparche2.length();
        if (parche2 > 0) {
            ordeninternaparcherecibir.txtparche2.setText(nombreparche2);
            ordeninternaparcherecibir.txtparche2cantidad.setText(cantidadparche2);
           
        } else {
            ordeninternaparcherecibir.txtparche2.setEnabled(false);
            ordeninternaparcherecibir.txtparche2cantidad.setEnabled(false);
            
        }

        int parche3 = nombreparche3.length();
        if (parche3 > 0) {
            ordeninternaparcherecibir.txtparche3.setText(nombreparche3);
            ordeninternaparcherecibir.txtparche3cantidad.setText(cantidadparche3);
            
        } else {
            ordeninternaparcherecibir.txtparche3.setEnabled(false);
            ordeninternaparcherecibir.txtparche3cantidad.setEnabled(false);
        }

        int parche4 = nombreparche4.length();
        if (parche4 > 0) {
            ordeninternaparcherecibir.txtparche4.setText(nombreparche4);
            ordeninternaparcherecibir.txtparche4cantidad.setText(cantidadparche4);
            
        } else {
            ordeninternaparcherecibir.txtparche4.setEnabled(false);
            ordeninternaparcherecibir.txtparche4cantidad.setEnabled(false);
        }

        int parche5 = nombreparche5.length();
        if (parche5 > 0) {
            ordeninternaparcherecibir.txtparche5.setText(nombreparche5);
            ordeninternaparcherecibir.txtparche5cantidad.setText(cantidadparche5);
            
        } else {
            ordeninternaparcherecibir.txtparche5.setEnabled(false);
            ordeninternaparcherecibir.txtparche5cantidad.setEnabled(false);
        }

        int parche6 = nombreparche6.length();
        if (parche6 > 0) {
            ordeninternaparcherecibir.txtparche6.setText(nombreparche6);
            ordeninternaparcherecibir.txtparche6cantidad.setText(cantidadparche6);
            
        } else {
            ordeninternaparcherecibir.txtparche6.setEnabled(false);
            ordeninternaparcherecibir.txtparche6cantidad.setEnabled(false);
        }

        int parche7 = nombreparche6.length();
        if (parche7 > 0) {
            ordeninternaparcherecibir.txtparche7.setText(nombreparche7);
            ordeninternaparcherecibir.txtparche7cantidad.setText(cantidadparche7);
            
        } else {
            ordeninternaparcherecibir.txtparche7.setEnabled(false);
            ordeninternaparcherecibir.txtparche7cantidad.setEnabled(false);
        }

        int parche8 = nombreparche8.length();
        if (parche8 > 0) {
            ordeninternaparcherecibir.txtparche8.setText(nombreparche8);
            ordeninternaparcherecibir.txtparche8cantidad.setText(cantidadparche8);
            
        } else {
            ordeninternaparcherecibir.txtparche8.setEnabled(false);
            ordeninternaparcherecibir.txtparche8cantidad.setEnabled(false);
        }

        int parche9 = nombreparche9.length();
        if (parche9 > 0) {
            ordeninternaparcherecibir.txtparche9.setText(nombreparche9);
            ordeninternaparcherecibir.txtparche9cantidad.setText(cantidadparche9);
            
        } else {
            ordeninternaparcherecibir.txtparche9.setEnabled(false);
            ordeninternaparcherecibir.txtparche9cantidad.setEnabled(false);
        }

        int parche10 = nombreparche6.length();
        if (parche10 > 0) {
            ordeninternaparcherecibir.txtparche10.setText(nombreparche10);
            ordeninternaparcherecibir.txtparche10cantidad.setText(cantidadparche10);
            
        } else {
            ordeninternaparcherecibir.txtparche10.setEnabled(false);
            ordeninternaparcherecibir.txtparche10cantidad.setEnabled(false);
        }


*/
    }//GEN-LAST:event_btnrecibirActionPerformed

    private void btncancelarbordadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarbordadoActionPerformed
       cancelarbordado();
    }//GEN-LAST:event_btncancelarbordadoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
          
        
    }//GEN-LAST:event_formWindowOpened
void modificarexistenciaykardex(String descripcion, String cantidad) {

         String numero = lbfolio.getText();
        String cantidadactual = "0";
        String nuevaexistencia = "";
        String codigoarticulo = "";

        String sql = "SELECT existencia,codigo FROM catalogo_articulos WHERE  descripcion='" + descripcion + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                cantidadactual = rs.getString(1);
                codigoarticulo = rs.getString(2);

            }

        } catch (Exception e) {
        }

        int cantidadactualint = Integer.parseInt(cantidadactual);
        int cantidadsurtidaint =  Integer.parseInt(cantidad);
        int nuevaexistenciaint = cantidadactualint + cantidadsurtidaint;
        nuevaexistencia = String.valueOf(nuevaexistenciaint);
        
            if (cantidad.equals("0"))
        {
            
        }
        else
        {
      
        String modi = "UPDATE catalogo_articulos SET existencia='" + nuevaexistencia + "' WHERE descripcion = '" + descripcion + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        String modi2 = "UPDATE historial_ordenes_bordados_interno SET estatus_entrega='entregada' WHERE numero = '" + numero + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi2);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }

                  
            String InsertarSQL = "INSERT INTO kardex(descripcion,fecha,hora,tipo,numero,cantidad_anterior,cantidad,cantidad_nueva,codigo) VALUES (?,?,?,?,?,?,?,?,?)";

          
            String tipo = "produccion de bordados";
           


            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, descripcion);
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, tipo);
                pst.setString(5, numero);
                pst.setString(6, cantidadactual);
                pst.setString(7, cantidad);
                pst.setString(8, nuevaexistencia);
                pst.setString(9, codigoarticulo);
                pst.executeUpdate();
                pst.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            
            
            
      
    }
    
    }
    
    ResultSet rs;
    ResultSet rs2;
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordeninternaparcheanterior().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnanterior;
    public static javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    public static javax.swing.JButton btncancelarbordado;
    private javax.swing.JButton btnprimero;
    private javax.swing.JButton btnrecibir;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JButton btnultimo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbarticulo;
    public static javax.swing.JLabel lbcantidad1;
    public static javax.swing.JLabel lbcantidad10;
    public static javax.swing.JLabel lbcantidad2;
    public static javax.swing.JLabel lbcantidad3;
    public static javax.swing.JLabel lbcantidad4;
    public static javax.swing.JLabel lbcantidad5;
    public static javax.swing.JLabel lbcantidad6;
    public static javax.swing.JLabel lbcantidad7;
    public static javax.swing.JLabel lbcantidad8;
    public static javax.swing.JLabel lbcantidad9;
    public static javax.swing.JLabel lbcantidadrecibida1;
    public static javax.swing.JLabel lbcantidadrecibida10;
    public static javax.swing.JLabel lbcantidadrecibida2;
    public static javax.swing.JLabel lbcantidadrecibida3;
    public static javax.swing.JLabel lbcantidadrecibida4;
    public static javax.swing.JLabel lbcantidadrecibida5;
    public static javax.swing.JLabel lbcantidadrecibida6;
    public static javax.swing.JLabel lbcantidadrecibida7;
    public static javax.swing.JLabel lbcantidadrecibida8;
    public static javax.swing.JLabel lbcantidadrecibida9;
    public static javax.swing.JLabel lbcantidadremanente1;
    public static javax.swing.JLabel lbcantidadremanente10;
    public static javax.swing.JLabel lbcantidadremanente2;
    public static javax.swing.JLabel lbcantidadremanente3;
    public static javax.swing.JLabel lbcantidadremanente4;
    public static javax.swing.JLabel lbcantidadremanente5;
    public static javax.swing.JLabel lbcantidadremanente6;
    public static javax.swing.JLabel lbcantidadremanente7;
    public static javax.swing.JLabel lbcantidadremanente8;
    public static javax.swing.JLabel lbcantidadremanente9;
    public static javax.swing.JLabel lbestatusentrega;
    public static javax.swing.JLabel lbfecha;
    public static javax.swing.JLabel lbfechaentrega;
    public static javax.swing.JLabel lbfolio;
    public static javax.swing.JLabel lbhora;
    public static javax.swing.JLabel lbnombre1;
    public static javax.swing.JLabel lbnombre10;
    public static javax.swing.JLabel lbnombre2;
    public static javax.swing.JLabel lbnombre3;
    public static javax.swing.JLabel lbnombre4;
    public static javax.swing.JLabel lbnombre5;
    public static javax.swing.JLabel lbnombre6;
    public static javax.swing.JLabel lbnombre7;
    public static javax.swing.JLabel lbnombre8;
    public static javax.swing.JLabel lbnombre9;
    private javax.swing.JLabel lbtipo;
    public static javax.swing.JTable tbventas;
    public static javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables

 connectar cc = new connectar();
    Connection cn = cc.conexion();


}
