package sistemabordadores;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ordenponchadoanteriores extends javax.swing.JFrame {
public static boolean ventanaordenparcheanteriores = false;

        private PreparedStatement pst;
        
        String numerocatalogoprendas = "";
        String numerocatalogoubicacion = "";
        String numerocatalogocolores = "";
        
        
        String cantidad = "";
        String parche = "";
        String nombre = "";
        String ubicacion = "";
        String aplicacion = "";
        String observacion = "";
        String cantidadponchado ="";
        String cantidadponchadosactualizar="";
        String nombredelponchado="";
        int renglon = 0;
        
        String primero = "";
        String ultimo = "";
   
    public ordenponchadoanteriores() {
        initComponents();
        ventanaordenparcheanteriores = true;
        topes();
           
        
    }

    
     void topes() {

        String sql = "SELECT min(numero) as min_numero, max(numero) as max_numero FROM historial_ordenes_ponchados";

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
    
    void datos()
    {
        
        
        limpiar();
        
        
        String numero = lbfolio.getText();
       
        
        renglon = 0;
       
     String sql = "SELECT numero,numero_venta,tipo,fecha,hora,cliente,estatus_orden,articulo,cantidad,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,"
             + "lugar,cantidad_ponchado FROM historial_ordenes_ponchados WHERE numero = '" + numero + "'";
     

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                lbfolio.setText(rs.getString("numero"));
                lbnumeroventa.setText(rs.getString("numero_venta"));
                lbfecha.setText(rs.getString("fecha"));
                lbhora.setText(rs.getString("hora"));  
                lbcliente.setText(rs.getString("cliente"));
                lbsolicita.setText(rs.getString("nombre_persona_solicita")); 
                lbtelefono.setText(rs.getString("telefono")); 
                lbfechaentrega.setText(rs.getString("fecha_entrega")); 
                lbhoraentrega.setText(rs.getString("hora_entrega"));
                
                nombre = rs.getString("articulo");
                cantidad = rs.getString("cantidad");
                cantidadponchado= rs.getString("cantidad_ponchado");
                
                renglon = renglon +1 ; 
                mostrarrenglones();
             
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
   
        
        
      //  datosfueratabla();
        
    }
    
    
    void mostrarrenglones()
    {
        
        if (renglon==1)
        {
            lbcantidad1.setText(cantidad);
            lbparche1.setText(nombre);
            
            if(cantidadponchado.equals("0"))
            {
                bntcantidadponchado1.setEnabled(true);
            }
            else
            {
                bntcantidadponchado1.setEnabled(false);
            }    

            
        }
        else
        
        
         if (renglon==2)
        {
            lbcantidad2.setText(cantidad);
            lbparche2.setText(nombre);
            
            if(cantidadponchado.equals("0"))
            {
                bntcantidadponchado2.setEnabled(true);
            }
            else
            {
                bntcantidadponchado2.setEnabled(false);
            }   
            
        }
        
         else
         
          if (renglon==3)
        {
            lbcantidad3.setText(cantidad);
            lbparche3.setText(nombre);
            
            if(cantidadponchado.equals("0"))
            {
                bntcantidadponchado3.setEnabled(true);
            }
            else
            {
                bntcantidadponchado3.setEnabled(false);
            }  
            
            
        }
           else
              
           if (renglon==4)
        {
            lbcantidad4.setText(cantidad);
            lbparche4.setText(nombre);
            
            if(cantidadponchado.equals("0"))
            {
                bntcantidadponchado4.setEnabled(true);
            }
            else
            {
                bntcantidadponchado4.setEnabled(false);
            }  
            
            
        }
        
         else
           
            if (renglon==5)
        {
            lbcantidad5.setText(cantidad);
            lbparche5.setText(nombre);
            
            if(cantidadponchado.equals("0"))
            {
                bntcantidadponchado5.setEnabled(true);
            }
            else
            {
                bntcantidadponchado5.setEnabled(false);
            }  
            
            
        }
        
         
      
      
        
    }

   
     void limpiar()
             
     {
         
         
                lbcantidad1.setText("");
                lbparche1.setText("");                
                lbcantidad2.setText("");
                lbparche2.setText("");
                lbcantidad3.setText("");
                lbparche3.setText("");
                lbcantidad4.setText("");
                lbparche4.setText("");
                lbcantidad5.setText("");
                lbparche5.setText("");
                lbfecha.setText("");
                lbfecha.setText("");
                lbtipo.setText("");
                lbarticulo.setText("");
                lbsolicita.setText("");
                lbtelefono.setText("");
                lbfechaentrega.setText("");
                lbhoraentrega.setText("");

     }
    
    
 
    void actualizarlascantidadesbordadas(String cantidadponchadosactualizar,String nombredelponchado)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_ponchados set cantidad_ponchado='" +cantidadponchadosactualizar+ "' where numero = '"+lbfolio.getText()+"' and articulo = '"+nombredelponchado+"'  ");
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
        lbcantidad1 = new javax.swing.JLabel();
        lbparche1 = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbparche2 = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbparche3 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbparche4 = new javax.swing.JLabel();
        lbcantidad5 = new javax.swing.JLabel();
        lbparche5 = new javax.swing.JLabel();
        bntcantidadponchado1 = new javax.swing.JButton();
        bntcantidadponchado2 = new javax.swing.JButton();
        bntcantidadponchado3 = new javax.swing.JButton();
        bntcantidadponchado4 = new javax.swing.JButton();
        bntcantidadponchado5 = new javax.swing.JButton();
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
        jLabel28 = new javax.swing.JLabel();
        lbnumeroventa = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden de ponchados anteriores");
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

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Solicitó:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Celular:");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Fecha Entrega:");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 0, 0));
        jLabel13.setText("Folio");

        lbfolio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbfolio.setForeground(new java.awt.Color(204, 0, 0));
        lbfolio.setText("00000000");

        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel19.setText("ORDEN DE PONCHADOS ANTERIORES");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cantidad");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Ponchado");

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbparche1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbparche2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbparche3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbparche4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbparche5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbparche5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        bntcantidadponchado1.setText("Hecho");
        bntcantidadponchado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadponchado1ActionPerformed(evt);
            }
        });

        bntcantidadponchado2.setText("Hecho");
        bntcantidadponchado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadponchado2ActionPerformed(evt);
            }
        });

        bntcantidadponchado3.setText("Hecho");
        bntcantidadponchado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadponchado3ActionPerformed(evt);
            }
        });

        bntcantidadponchado4.setText("Hecho");
        bntcantidadponchado4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadponchado4ActionPerformed(evt);
            }
        });

        bntcantidadponchado5.setText("Hecho");
        bntcantidadponchado5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntcantidadponchado5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbparche1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbparche5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbparche2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbparche3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbparche4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bntcantidadponchado1)
                            .addComponent(bntcantidadponchado2)
                            .addComponent(bntcantidadponchado3)
                            .addComponent(bntcantidadponchado4)
                            .addComponent(bntcantidadponchado5))))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37))
                                    .addComponent(lbcantidad3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35))
                            .addComponent(lbcantidad4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbparche1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bntcantidadponchado1))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(7, 7, 7)
                                                .addComponent(lbparche2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(bntcantidadponchado2)))
                                        .addGap(10, 10, 10)
                                        .addComponent(bntcantidadponchado3))
                                    .addComponent(lbparche3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(13, 13, 13)
                                .addComponent(bntcantidadponchado4))
                            .addComponent(lbparche4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbparche5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bntcantidadponchado5))))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Fecha:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel18.setText("Hora:");

        lbfecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfecha.setForeground(new java.awt.Color(204, 0, 0));
        lbfecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbhora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhora.setForeground(new java.awt.Color(204, 0, 0));
        lbhora.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbtelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbtelefono.setForeground(new java.awt.Color(204, 0, 0));
        lbtelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbfechaentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfechaentrega.setForeground(new java.awt.Color(204, 0, 0));
        lbfechaentrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbsolicita.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsolicita.setForeground(new java.awt.Color(204, 0, 0));
        lbsolicita.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbtipo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbtipo.setForeground(new java.awt.Color(204, 0, 0));

        lbarticulo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbarticulo.setForeground(new java.awt.Color(204, 0, 0));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Hora Entrega:");

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhoraentrega.setForeground(new java.awt.Color(204, 0, 0));
        lbhoraentrega.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel28.setText("No. de Venta");

        lbnumeroventa.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbnumeroventa.setText("00000000");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        jLabel20.setText("Cliente:");

        lbcliente.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(460, 460, 460))
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(839, 839, 839)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(834, 834, 834)
                                .addComponent(jLabel30))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addGap(10, 10, 10)
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 682, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbsolicita, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                                    .addComponent(lbtelefono, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbfecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(lbhoraentrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbfechaentrega, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbhora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(147, 147, 147)
                                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbtipo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbarticulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(lbfolio))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel28)
                    .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel20))
                            .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
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
                            .addComponent(jLabel7))))
                .addContainerGap(99, Short.MAX_VALUE))
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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        datos();
    }//GEN-LAST:event_formWindowOpened

    private void bntcantidadponchado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadponchado1ActionPerformed
    
    cantidadponchadosactualizar = lbcantidad1.getText();
    nombredelponchado = lbparche1.getText();
    actualizarlascantidadesbordadas((String) cantidadponchadosactualizar,(String)nombredelponchado);  
    
    
    }//GEN-LAST:event_bntcantidadponchado1ActionPerformed

    private void bntcantidadponchado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadponchado2ActionPerformed
    cantidadponchadosactualizar = lbcantidad2.getText();
    nombredelponchado = lbparche2.getText();
    actualizarlascantidadesbordadas((String) cantidadponchadosactualizar,(String)nombredelponchado);  
    }//GEN-LAST:event_bntcantidadponchado2ActionPerformed

    private void bntcantidadponchado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadponchado3ActionPerformed
    cantidadponchadosactualizar = lbcantidad3.getText();
    nombredelponchado = lbparche3.getText();
    actualizarlascantidadesbordadas((String) cantidadponchadosactualizar,(String)nombredelponchado);  
    }//GEN-LAST:event_bntcantidadponchado3ActionPerformed

    private void bntcantidadponchado4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadponchado4ActionPerformed
     cantidadponchadosactualizar = lbcantidad4.getText();
    nombredelponchado = lbparche4.getText();
    actualizarlascantidadesbordadas((String) cantidadponchadosactualizar,(String)nombredelponchado);  
    }//GEN-LAST:event_bntcantidadponchado4ActionPerformed

    private void bntcantidadponchado5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntcantidadponchado5ActionPerformed
    cantidadponchadosactualizar = lbcantidad5.getText();
    nombredelponchado = lbparche5.getText();
    actualizarlascantidadesbordadas((String) cantidadponchadosactualizar,(String)nombredelponchado);  
    }//GEN-LAST:event_bntcantidadponchado5ActionPerformed

    
    ResultSet rs;
    ResultSet rs2;
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordenponchadoanteriores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntcantidadponchado1;
    private javax.swing.JButton bntcantidadponchado2;
    private javax.swing.JButton bntcantidadponchado3;
    private javax.swing.JButton bntcantidadponchado4;
    private javax.swing.JButton bntcantidadponchado5;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbarticulo;
    private javax.swing.JLabel lbcantidad1;
    private javax.swing.JLabel lbcantidad2;
    private javax.swing.JLabel lbcantidad3;
    private javax.swing.JLabel lbcantidad4;
    private javax.swing.JLabel lbcantidad5;
    public static javax.swing.JLabel lbcliente;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbfechaentrega;
    public static javax.swing.JLabel lbfolio;
    private javax.swing.JLabel lbhora;
    private javax.swing.JLabel lbhoraentrega;
    public static javax.swing.JLabel lbnumeroventa;
    private javax.swing.JLabel lbparche1;
    private javax.swing.JLabel lbparche2;
    private javax.swing.JLabel lbparche3;
    private javax.swing.JLabel lbparche4;
    private javax.swing.JLabel lbparche5;
    private javax.swing.JLabel lbsolicita;
    private javax.swing.JLabel lbtelefono;
    private javax.swing.JLabel lbtipo;
    // End of variables declaration//GEN-END:variables

 connectar cc = new connectar();
    Connection cn = cc.conexion();


}
