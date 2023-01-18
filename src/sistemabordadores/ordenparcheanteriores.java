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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ordenparcheanteriores extends javax.swing.JFrame {
public static boolean ventanaordenparcheanteriores = false;

        private PreparedStatement pst;
        
        String numerocatalogoprendas = "";
        String numerocatalogoubicacion = "";
        String numerocatalogocolores = "";
        
        
        String cantidad = "";
        String cantidadparche = "";
        String parche = "";
        String nombre = "";
        String ubicacion = "";
        String aplicacion = "";
        String observacion = "";
        int renglon = 0;
        
        String primero = "";
        String ultimo = "";
        String cantidadparchesactualizar = "";
        String nombredelparche = "";
        String numeroventa = "";
        String ubicacioninsertar = "";
        String aplicacioninsertar = "";
   
    public ordenparcheanteriores() 
    {
        initComponents();
        ventanaordenparcheanteriores = true;
        
        bntcantidadparches1.setEnabled(false);
        bntcantidadparches2.setEnabled(false);
        bntcantidadparches3.setEnabled(false);
        bntcantidadparches4.setEnabled(false);
        bntcantidadparches5.setEnabled(false);
        bntcantidadparches6.setEnabled(false);
        bntcantidadparches7.setEnabled(false);
        bntcantidadparches8.setEnabled(false);
        bntcantidadparches9.setEnabled(false);
        bntcantidadparches10.setEnabled(false);
        
    }

    
    
    
    void datos()
    {
        
        
        limpiar();
        renglon = 0;
        
     String folio = lbfolio.getText();
     String sql = "SELECT numero,numero_venta,fecha,hora,cliente,tipo,estatus_entrega,articulo,parche,cantidad,cantidad_parche,observacion,aplicacion,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observaciongeneral,lugar FROM historial_ordenes_parche WHERE numero = '"+folio+"' ";
     

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                lbfolio.setText(rs.getString("numero"));
                lbfecha.setText(rs.getString("fecha"));
                lbhora.setText(rs.getString("hora"));  
                lbcliente.setText(rs.getString("cliente"));
               
               
                lbsolicita.setText(rs.getString("nombre_persona_solicita")); 
                lbtelefono.setText(rs.getString("telefono")); 
                lbfechaentrega.setText(rs.getString("fecha_entrega")); 
                lbhoraentrega.setText(rs.getString("hora_entrega")); 
                lbobservacion.setText(rs.getString("observaciongeneral"));  
                
                numeroventa =rs.getString("numero_venta");
                        
                        
                 parche = rs.getString("parche");
                 nombre = rs.getString("articulo");
                 cantidad = rs.getString("cantidad");
                 cantidadparche = rs.getString("cantidad_parche");
                 aplicacion = rs.getString("aplicacion");
                 observacion = rs.getString("observacion");
                
                 renglon = renglon +1 ; 
           
                
                
                 mostrarrenglones();
                
             
             
            }

        } catch (SQLException ex) 
        {
           JOptionPane.showMessageDialog(null,"orden parche anteriores datos" + ex);
        }
   
        
        
      
        
    }
    
    
    void mostrarrenglones()
    {
        
        if (renglon==1)
        {
            lbcantidad1.setText(cantidad);
            lbparche1.setText(parche);
            lbnombre1.setText(nombre);
            lbaplicacion1.setText(aplicacion);
            lbobservacion1.setText(observacion);
            
            if(cantidadparche.equals("0"))
            {
               bntcantidadparches1.setEnabled(true);
            }
            else
            {
               bntcantidadparches1.setEnabled(false); 
            }    
            
        }
        else
        
        
         if (renglon==2)
        {
            lbcantidad2.setText(cantidad);
            lbparche2.setText(parche);
            lbnombre2.setText(nombre);
            lbaplicacion2.setText(aplicacion);
            lbobservacion2.setText(observacion);
            
            if(cantidadparche.equals("0"))
            {
               bntcantidadparches2.setEnabled(true);
            }
            else
            {
               bntcantidadparches2.setEnabled(false); 
            } 
            
        }
        
         else
         
          if (renglon==3)
        {
            lbcantidad3.setText(cantidad);
            lbparche3.setText(parche);
            lbnombre3.setText(nombre);
            lbaplicacion3.setText(aplicacion);
            lbobservacion3.setText(observacion);
            
            if(cantidadparche.equals("0"))
            {
               bntcantidadparches3.setEnabled(true);
            }
            else
            {
               bntcantidadparches3.setEnabled(false); 
            } 
            
        }
           else
              
           if (renglon==4)
        {
            lbcantidad4.setText(cantidad);
            lbparche4.setText(parche);
            lbnombre4.setText(nombre);
            lbaplicacion4.setText(aplicacion);
            lbobservacion4.setText(observacion);
            
            if(cantidadparche.equals("0"))
            {
               bntcantidadparches4.setEnabled(true);
            }
            else
            {
               bntcantidadparches4.setEnabled(false); 
            } 
            
        }
        
         else
           
            if (renglon==5)
        {
            lbcantidad5.setText(cantidad);
            lbparche5.setText(parche);
            lbnombre5.setText(nombre);
            lbaplicacion5.setText(aplicacion);
            lbobservacion5.setText(observacion);
            
            if(cantidadparche.equals("0"))
            {
               bntcantidadparches5.setEnabled(true);
            }
            else
            {
               bntcantidadparches5.setEnabled(false); 
            } 
            
        }
        
          else
           
            if (renglon==6)
        {
            lbcantidad6.setText(cantidad);
            lbparche6.setText(parche);
            lbnombre6.setText(nombre);
            lbaplicacion6.setText(aplicacion);
            lbobservacion6.setText(observacion);
            
            if(cantidadparche.equals("0"))
            {
               bntcantidadparches6.setEnabled(true);
            }
            else
            {
               bntcantidadparches6.setEnabled(false); 
            } 
            
        }
        
          else
           
            if (renglon==7)
        {
            lbcantidad7.setText(cantidad);
            lbparche7.setText(parche);
            lbnombre7.setText(nombre);
            lbaplicacion7.setText(aplicacion);
            lbobservacion7.setText(observacion);
            
            if(cantidadparche.equals("0"))
            {
               bntcantidadparches7.setEnabled(true);
            }
            else
            {
               bntcantidadparches7.setEnabled(false); 
            } 
            
        }
        
          else
           
            if (renglon==8)
        {
            lbcantidad8.setText(cantidad);
            lbparche8.setText(parche);
            lbnombre8.setText(nombre);
            lbaplicacion8.setText(aplicacion);
            lbobservacion8.setText(observacion);
            
            if(cantidadparche.equals("0"))
            {
               bntcantidadparches8.setEnabled(true);
            }
            else
            {
               bntcantidadparches8.setEnabled(false); 
            } 
            
        }
        
          else
           
            if (renglon==9)
        {
            lbcantidad9.setText(cantidad);
            lbparche9.setText(parche);
            lbnombre9.setText(nombre);
            lbaplicacion9.setText(aplicacion);
            lbobservacion9.setText(observacion);
            
            if(cantidadparche.equals("0"))
            {
               bntcantidadparches9.setEnabled(true);
            }
            else
            {
               bntcantidadparches9.setEnabled(false); 
            } 
            
        }
        
          else
           
            if (renglon==10)
        {
            lbcantidad10.setText(cantidad);
            lbparche10.setText(parche);
            lbnombre10.setText(nombre);
            lbaplicacion10.setText(aplicacion);
            lbobservacion10.setText(observacion);
            
            if(cantidadparche.equals("0"))
            {
               bntcantidadparches10.setEnabled(true);
            }
            else
            {
               bntcantidadparches10.setEnabled(false); 
            } 
            
        }
        
      
      
        
    }
    
   
    
   
   
     void limpiar()
             
     {
         
         
                lbcantidad1.setText("");
                lbparche1.setText("");
              
                lbaplicacion1 .setText("");
                
                lbcantidad2.setText("");
                lbparche2.setText("");
             
                lbaplicacion2 .setText("");
                
                lbcantidad3.setText("");
                lbparche3.setText("");
                
                lbaplicacion3 .setText("");
                
                lbcantidad4.setText("");
                lbparche4.setText("");
              
                lbaplicacion4 .setText("");
                
                lbcantidad5.setText("");
                lbparche5.setText("");
                
                lbaplicacion5 .setText("");
                
               
         
                lbfecha.setText("");
                lbfecha.setText("");
                lbtipo.setText("");
               
                lbestatusentrega.setText("");
                lbarticulo.setText("");
              
                lbsolicita.setText("");
                lbtelefono.setText("");
                lbfechaentrega.setText("");
                lbhoraentrega.setText("");
                lbobservacion.setText("");
               
         
         
         
     }
    
    
      void actualizarlascantidadesbordadas(String cantidadponchadosactualizar,String nombredelparche)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_parche set cantidad_parche='" +cantidadponchadosactualizar+ "' where numero = '"+lbfolio.getText()+"' and articulo = '"+nombredelparche+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Actualizado correctamente ");

        datos();
        
        
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
    
    void agregarexistenciabordados(String ubicacioninsertar,String aplicacioninsertar,String cantidadaplicacion,String cantidad)
    {
        
       
        
        //// bordado
        String InsertarSQL = "INSERT INTO historial_bordados_existencia(numero,dia,hora,articulo,concepto,cantidad) VALUES (?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
            
                
 
                pst.setString(1, numeroventa);
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, ubicacioninsertar);
                pst.setString(5, "ninguno");
                pst.setString(6, cantidad);
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }

           int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion);
           
           
           if(cantidadaplicacionint > 0)
           {
               int cantidadprendasint = Integer.parseInt(cantidad);
               int totalaplicaciones = cantidadprendasint * cantidadaplicacionint;
               
               String Insertaraplicacion = "INSERT INTO historial_bordados_existencia(numero,dia,hora,articulo,concepto,cantidad) VALUES (?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(Insertaraplicacion);
            
                
 
                pst.setString(1, numeroventa);
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, aplicacioninsertar);
                pst.setString(5, "ninguno");
                pst.setString(6, String.valueOf(totalaplicaciones));
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }
               
           }
        
        
    }
    
    
    void agregaralsurtidasalhistorialdeventas(String ubicacion, String cantidad) 
      {

        
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
   
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbfolio = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbparche1 = new javax.swing.JLabel();
        lbaplicacion1 = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbparche2 = new javax.swing.JLabel();
        lbaplicacion2 = new javax.swing.JLabel();
        lbobservacion = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbparche3 = new javax.swing.JLabel();
        lbaplicacion3 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbparche4 = new javax.swing.JLabel();
        lbaplicacion4 = new javax.swing.JLabel();
        lbcantidad5 = new javax.swing.JLabel();
        lbparche5 = new javax.swing.JLabel();
        lbaplicacion5 = new javax.swing.JLabel();
        lbnombre1 = new javax.swing.JLabel();
        lbnombre2 = new javax.swing.JLabel();
        lbnombre3 = new javax.swing.JLabel();
        lbnombre4 = new javax.swing.JLabel();
        lbnombre5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbobservacion1 = new javax.swing.JLabel();
        lbobservacion2 = new javax.swing.JLabel();
        lbobservacion3 = new javax.swing.JLabel();
        lbobservacion4 = new javax.swing.JLabel();
        lbobservacion5 = new javax.swing.JLabel();
        lbcantidad6 = new javax.swing.JLabel();
        lbcantidad7 = new javax.swing.JLabel();
        lbcantidad8 = new javax.swing.JLabel();
        lbcantidad9 = new javax.swing.JLabel();
        lbcantidad10 = new javax.swing.JLabel();
        lbparche6 = new javax.swing.JLabel();
        lbparche7 = new javax.swing.JLabel();
        lbparche8 = new javax.swing.JLabel();
        lbparche9 = new javax.swing.JLabel();
        lbparche10 = new javax.swing.JLabel();
        lbnombre6 = new javax.swing.JLabel();
        lbnombre7 = new javax.swing.JLabel();
        lbnombre8 = new javax.swing.JLabel();
        lbnombre9 = new javax.swing.JLabel();
        lbnombre10 = new javax.swing.JLabel();
        lbaplicacion6 = new javax.swing.JLabel();
        lbaplicacion7 = new javax.swing.JLabel();
        lbaplicacion8 = new javax.swing.JLabel();
        lbaplicacion9 = new javax.swing.JLabel();
        lbaplicacion10 = new javax.swing.JLabel();
        lbobservacion6 = new javax.swing.JLabel();
        lbobservacion7 = new javax.swing.JLabel();
        lbobservacion8 = new javax.swing.JLabel();
        lbobservacion9 = new javax.swing.JLabel();
        lbobservacion10 = new javax.swing.JLabel();
        bntcantidadparches1 = new javax.swing.JButton();
        bntcantidadparches2 = new javax.swing.JButton();
        bntcantidadparches3 = new javax.swing.JButton();
        bntcantidadparches4 = new javax.swing.JButton();
        bntcantidadparches5 = new javax.swing.JButton();
        bntcantidadparches6 = new javax.swing.JButton();
        bntcantidadparches7 = new javax.swing.JButton();
        bntcantidadparches8 = new javax.swing.JButton();
        bntcantidadparches9 = new javax.swing.JButton();
        bntcantidadparches10 = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        lbhora = new javax.swing.JLabel();
        lbtelefono = new javax.swing.JLabel();
        lbfechaentrega = new javax.swing.JLabel();
        lbsolicita = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        lbarticulo = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbhoraentrega = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbestatusentrega = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden de parche anteriores");
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Solicitó:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Celular:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Fecha Entrega:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Folio");

        lbfolio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbfolio.setForeground(new java.awt.Color(204, 0, 0));
        lbfolio.setText("00000000");

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setText("ORDEN DE PARCHES");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cantidad");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Parche");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("Aplicacion");

        jLabel6.setText("Observaciones");

        lbcantidad1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbaplicacion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbaplicacion2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbaplicacion3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbaplicacion4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbaplicacion5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel21.setText("Observaciones");

        lbobservacion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbaplicacion6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbaplicacion7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbaplicacion8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbaplicacion9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbaplicacion10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bntcantidadparches1.setText("Hecho");
        bntcantidadparches1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadparches1ActionPerformed(evt);
            }
        });

        bntcantidadparches2.setText("Hecho");
        bntcantidadparches2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadparches2ActionPerformed(evt);
            }
        });

        bntcantidadparches3.setText("Hecho");
        bntcantidadparches3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadparches3ActionPerformed(evt);
            }
        });

        bntcantidadparches4.setText("Hecho");
        bntcantidadparches4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadparches4ActionPerformed(evt);
            }
        });

        bntcantidadparches5.setText("Hecho");
        bntcantidadparches5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadparches5ActionPerformed(evt);
            }
        });

        bntcantidadparches6.setText("Hecho");
        bntcantidadparches6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadparches6ActionPerformed(evt);
            }
        });

        bntcantidadparches7.setText("Hecho");
        bntcantidadparches7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadparches7ActionPerformed(evt);
            }
        });

        bntcantidadparches8.setText("Hecho");
        bntcantidadparches8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadparches8ActionPerformed(evt);
            }
        });

        bntcantidadparches9.setText("Hecho");
        bntcantidadparches9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadparches9ActionPerformed(evt);
            }
        });

        bntcantidadparches10.setText("Hecho");
        bntcantidadparches10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadparches10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(626, 626, 626)
                        .addComponent(jLabel21))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(550, 550, 550)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad8, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbparche2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbparche1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbparche3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbparche4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbparche5, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbparche6, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbparche7, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbparche8, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbparche9, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbparche10, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbcantidad10, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombre9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnombre10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbaplicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaplicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaplicacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaplicacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaplicacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaplicacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaplicacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaplicacion8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaplicacion9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaplicacion10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbobservacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbobservacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbobservacion8, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbobservacion9, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbobservacion10, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbobservacion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbobservacion3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbobservacion4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbobservacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbobservacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(bntcantidadparches1)
                                                    .addComponent(bntcantidadparches2, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addComponent(bntcantidadparches3, javax.swing.GroupLayout.Alignment.TRAILING))
                                            .addComponent(bntcantidadparches4, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addComponent(bntcantidadparches5, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(bntcantidadparches6, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bntcantidadparches7, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bntcantidadparches8, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bntcantidadparches10, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(bntcantidadparches9, javax.swing.GroupLayout.Alignment.TRAILING)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lbobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 678, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addComponent(jLabel21))
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGap(2, 2, 2)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                    .addComponent(lbobservacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(bntcantidadparches1))
                                                                                .addGap(4, 4, 4)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(lbobservacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(bntcantidadparches2)))
                                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(lbparche1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(lbnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(lbaplicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(7, 7, 7)
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                    .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(lbparche2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(lbnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                    .addComponent(lbaplicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addComponent(lbobservacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                            .addComponent(bntcantidadparches3)))
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbparche3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(13, 13, 13)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(lbobservacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(bntcantidadparches4))
                                                                    .addComponent(lbaplicacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(lbparche4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addComponent(lbobservacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lbparche5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(bntcantidadparches5)))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addGap(61, 61, 61)
                                                                        .addComponent(lbaplicacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                        .addGap(66, 66, 66)
                                                                        .addComponent(lbnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addGap(35, 35, 35))
                                                            .addComponent(lbnombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGap(13, 13, 13)
                                                        .addComponent(lbaplicacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(lbnombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lbnombre6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(lbobservacion6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(bntcantidadparches6)
                                                    .addComponent(lbparche6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(lbaplicacion6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lbnombre7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lbaplicacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbobservacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bntcantidadparches7)))
                                    .addComponent(lbparche7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbcantidad8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbnombre8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbaplicacion8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbobservacion8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(bntcantidadparches8)))
                            .addComponent(lbparche8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbcantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbnombre9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbaplicacion9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbobservacion9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntcantidadparches9)))
                    .addComponent(lbparche9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbcantidad10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbparche10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnombre10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbaplicacion10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbobservacion10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bntcantidadparches10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(75, 75, 75))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(111, 111, 111))))
        );

        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Fecha:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Hora:");

        lbfecha.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbfecha.setForeground(new java.awt.Color(204, 0, 0));
        lbfecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbhora.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbhora.setForeground(new java.awt.Color(204, 0, 0));
        lbhora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbtelefono.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbtelefono.setForeground(new java.awt.Color(204, 0, 0));
        lbtelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbfechaentrega.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbfechaentrega.setForeground(new java.awt.Color(204, 0, 0));
        lbfechaentrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbsolicita.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbsolicita.setForeground(new java.awt.Color(204, 0, 0));
        lbsolicita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbtipo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbtipo.setForeground(new java.awt.Color(204, 0, 0));

        lbarticulo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbarticulo.setForeground(new java.awt.Color(204, 0, 0));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Hora Entrega:");

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbhoraentrega.setForeground(new java.awt.Color(204, 0, 0));
        lbhoraentrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel20.setText("Cliente:");

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        lbestatusentrega.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel29.setText("Estatus Entrega:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(10, 10, 10)
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 486, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(429, 429, 429)
                        .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(189, 189, 189))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel18)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel30))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(34, 34, 34)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel17)
                                            .addComponent(jLabel7)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel29))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbestatusentrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbsolicita, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbtelefono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbhoraentrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbfechaentrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbhora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbfecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(58, Short.MAX_VALUE))
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
                        .addContainerGap()
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel20))
                            .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(lbfolio))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel18))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel12))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel30)
                            .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8)
                            .addComponent(lbtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbsolicita, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel29)
                            .addComponent(lbestatusentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(113, 113, 113)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
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
       
        ventanaordenparcheanteriores = false;
        this.dispose();
        
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordenparcheanteriores = false;
    }//GEN-LAST:event_formWindowClosing

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
      
    
        
        
    }//GEN-LAST:event_btncancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        datos();
    }//GEN-LAST:event_formWindowOpened

    private void bntcantidadparches1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadparches1ActionPerformed

        cantidadparchesactualizar = lbcantidad1.getText();
        nombredelparche = lbnombre1.getText();
        actualizarlascantidadesbordadas((String) cantidadparchesactualizar,(String)nombredelparche);
        String cantidadaplicacion = lbaplicacion1.getText();
        String cantidad = lbcantidad1.getText();
        ubicacioninsertar = lbnombre1.getText();
        aplicacioninsertar = "APLICACION PARCHE1";
        agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion,(String) cantidad); 
        agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;

    }//GEN-LAST:event_bntcantidadparches1ActionPerformed

    private void bntcantidadparches2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadparches2ActionPerformed
        cantidadparchesactualizar = lbcantidad2.getText();
        nombredelparche = lbnombre2.getText();
        actualizarlascantidadesbordadas((String) cantidadparchesactualizar,(String)nombredelparche);
        String cantidadaplicacion = lbaplicacion2.getText();
        String cantidad = lbcantidad2.getText();
        ubicacioninsertar = lbnombre2.getText();
        aplicacioninsertar = "APLICACION PARCHE2";
        agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion,(String) cantidad); 
        agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
    }//GEN-LAST:event_bntcantidadparches2ActionPerformed

    private void bntcantidadparches3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadparches3ActionPerformed
      cantidadparchesactualizar = lbcantidad3.getText();
        nombredelparche = lbnombre3.getText();
        actualizarlascantidadesbordadas((String) cantidadparchesactualizar,(String)nombredelparche);
        String cantidadaplicacion = lbaplicacion3.getText();
        String cantidad = lbcantidad3.getText();
        ubicacioninsertar = lbnombre3.getText();
        aplicacioninsertar = "APLICACION PARCHE3";
        agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion,(String) cantidad); 
        agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
    }//GEN-LAST:event_bntcantidadparches3ActionPerformed

    private void bntcantidadparches4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadparches4ActionPerformed
     cantidadparchesactualizar = lbcantidad4.getText();
        nombredelparche = lbnombre4.getText();
        actualizarlascantidadesbordadas((String) cantidadparchesactualizar,(String)nombredelparche);
        String cantidadaplicacion = lbaplicacion4.getText();
        String cantidad = lbcantidad4.getText();
        ubicacioninsertar = lbnombre4.getText();
        aplicacioninsertar = "APLICACION PARCHE4";
        agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion,(String) cantidad); 
        agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
    }//GEN-LAST:event_bntcantidadparches4ActionPerformed

    private void bntcantidadparches5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadparches5ActionPerformed
      cantidadparchesactualizar = lbcantidad5.getText();
        nombredelparche = lbnombre5.getText();
        actualizarlascantidadesbordadas((String) cantidadparchesactualizar,(String)nombredelparche);
        String cantidadaplicacion = lbaplicacion5.getText();
        String cantidad = lbcantidad5.getText();
        ubicacioninsertar = lbnombre5.getText();
        aplicacioninsertar = "APLICACION PARCHE5";
        agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion,(String) cantidad); 
        agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
    }//GEN-LAST:event_bntcantidadparches5ActionPerformed

    private void bntcantidadparches6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadparches6ActionPerformed
       cantidadparchesactualizar = lbcantidad6.getText();
        nombredelparche = lbnombre6.getText();
        actualizarlascantidadesbordadas((String) cantidadparchesactualizar,(String)nombredelparche);
        String cantidadaplicacion = lbaplicacion6.getText();
        String cantidad = lbcantidad6.getText();
        ubicacioninsertar = lbnombre6.getText();
        aplicacioninsertar = "APLICACION PARCHE6";
        agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion,(String) cantidad); 
        agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
    }//GEN-LAST:event_bntcantidadparches6ActionPerformed

    private void bntcantidadparches7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadparches7ActionPerformed
       cantidadparchesactualizar = lbcantidad7.getText();
        nombredelparche = lbnombre7.getText();
        actualizarlascantidadesbordadas((String) cantidadparchesactualizar,(String)nombredelparche);
        String cantidadaplicacion = lbaplicacion7.getText();
        String cantidad = lbcantidad7.getText();
        ubicacioninsertar = lbnombre7.getText();
        aplicacioninsertar = "APLICACION PARCHE7";
        agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion,(String) cantidad); 
        agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
    }//GEN-LAST:event_bntcantidadparches7ActionPerformed

    private void bntcantidadparches8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadparches8ActionPerformed
        cantidadparchesactualizar = lbcantidad8.getText();
        nombredelparche = lbnombre8.getText();
        actualizarlascantidadesbordadas((String) cantidadparchesactualizar,(String)nombredelparche);
        String cantidadaplicacion = lbaplicacion8.getText();
        String cantidad = lbcantidad8.getText();
        ubicacioninsertar = lbnombre8.getText();
        aplicacioninsertar = "APLICACION PARCHE8";
        agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion,(String) cantidad); 
        agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
    }//GEN-LAST:event_bntcantidadparches8ActionPerformed

    private void bntcantidadparches9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadparches9ActionPerformed
       cantidadparchesactualizar = lbcantidad9.getText();
        nombredelparche = lbnombre9.getText();
        actualizarlascantidadesbordadas((String) cantidadparchesactualizar,(String)nombredelparche);
        String cantidadaplicacion = lbaplicacion9.getText();
        String cantidad = lbcantidad9.getText();
        ubicacioninsertar = lbnombre9.getText();
        aplicacioninsertar = "APLICACION PARCHE9";
        agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion,(String) cantidad); 
        agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
    }//GEN-LAST:event_bntcantidadparches9ActionPerformed

    private void bntcantidadparches10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadparches10ActionPerformed
       cantidadparchesactualizar = lbcantidad10.getText();
        nombredelparche = lbnombre10.getText();
        actualizarlascantidadesbordadas((String) cantidadparchesactualizar,(String)nombredelparche);
        String cantidadaplicacion = lbaplicacion10.getText();
        String cantidad = lbcantidad10.getText();
        ubicacioninsertar = lbnombre10.getText();
        aplicacioninsertar = "APLICACION PARCHE10";
        agregarexistenciabordados((String) ubicacioninsertar,(String) aplicacioninsertar,(String) cantidadaplicacion,(String) cantidad); 
        agregaralsurtidasalhistorialdeventas((String) ubicacioninsertar, (String) cantidad) ;
    }//GEN-LAST:event_bntcantidadparches10ActionPerformed

    
    ResultSet rs;
    ResultSet rs2;
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordenparcheanteriores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntcantidadparches1;
    private javax.swing.JButton bntcantidadparches10;
    private javax.swing.JButton bntcantidadparches2;
    private javax.swing.JButton bntcantidadparches3;
    private javax.swing.JButton bntcantidadparches4;
    private javax.swing.JButton bntcantidadparches5;
    private javax.swing.JButton bntcantidadparches6;
    private javax.swing.JButton bntcantidadparches7;
    private javax.swing.JButton bntcantidadparches8;
    private javax.swing.JButton bntcantidadparches9;
    private javax.swing.JButton btncancelar;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbaplicacion1;
    private javax.swing.JLabel lbaplicacion10;
    private javax.swing.JLabel lbaplicacion2;
    private javax.swing.JLabel lbaplicacion3;
    private javax.swing.JLabel lbaplicacion4;
    private javax.swing.JLabel lbaplicacion5;
    private javax.swing.JLabel lbaplicacion6;
    private javax.swing.JLabel lbaplicacion7;
    private javax.swing.JLabel lbaplicacion8;
    private javax.swing.JLabel lbaplicacion9;
    private javax.swing.JLabel lbarticulo;
    private javax.swing.JLabel lbcantidad1;
    private javax.swing.JLabel lbcantidad10;
    private javax.swing.JLabel lbcantidad2;
    private javax.swing.JLabel lbcantidad3;
    private javax.swing.JLabel lbcantidad4;
    private javax.swing.JLabel lbcantidad5;
    private javax.swing.JLabel lbcantidad6;
    private javax.swing.JLabel lbcantidad7;
    private javax.swing.JLabel lbcantidad8;
    private javax.swing.JLabel lbcantidad9;
    public static javax.swing.JLabel lbcliente;
    private javax.swing.JLabel lbestatusentrega;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbfechaentrega;
    public static javax.swing.JLabel lbfolio;
    private javax.swing.JLabel lbhora;
    private javax.swing.JLabel lbhoraentrega;
    private javax.swing.JLabel lbnombre1;
    private javax.swing.JLabel lbnombre10;
    private javax.swing.JLabel lbnombre2;
    private javax.swing.JLabel lbnombre3;
    private javax.swing.JLabel lbnombre4;
    private javax.swing.JLabel lbnombre5;
    private javax.swing.JLabel lbnombre6;
    private javax.swing.JLabel lbnombre7;
    private javax.swing.JLabel lbnombre8;
    private javax.swing.JLabel lbnombre9;
    private javax.swing.JLabel lbobservacion;
    private javax.swing.JLabel lbobservacion1;
    private javax.swing.JLabel lbobservacion10;
    private javax.swing.JLabel lbobservacion2;
    private javax.swing.JLabel lbobservacion3;
    private javax.swing.JLabel lbobservacion4;
    private javax.swing.JLabel lbobservacion5;
    private javax.swing.JLabel lbobservacion6;
    private javax.swing.JLabel lbobservacion7;
    private javax.swing.JLabel lbobservacion8;
    private javax.swing.JLabel lbobservacion9;
    private javax.swing.JLabel lbparche1;
    private javax.swing.JLabel lbparche10;
    private javax.swing.JLabel lbparche2;
    private javax.swing.JLabel lbparche3;
    private javax.swing.JLabel lbparche4;
    private javax.swing.JLabel lbparche5;
    private javax.swing.JLabel lbparche6;
    private javax.swing.JLabel lbparche7;
    private javax.swing.JLabel lbparche8;
    private javax.swing.JLabel lbparche9;
    private javax.swing.JLabel lbsolicita;
    private javax.swing.JLabel lbtelefono;
    private javax.swing.JLabel lbtipo;
    // End of variables declaration//GEN-END:variables

 connectar cc = new connectar();
    Connection cn = cc.conexion();


}
