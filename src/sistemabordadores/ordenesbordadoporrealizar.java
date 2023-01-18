package sistemabordadores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ordenesbordadoporrealizar extends javax.swing.JFrame {

    public static boolean ventanaordenesbordadogenerada = false;
    String fechainicial = "";
    String fechafinal = "";

    public ordenesbordadoporrealizar() {
        initComponents();
        ventanaordenesbordadogenerada = true;
        lbinterface.setVisible(false);
        lbtienda.setVisible(false);
        btnactualizar.setVisible(false);
        btnfrente.setVisible(false);
        fechas();
        datos();

    }
    
    
    void fechas()
    {
    
        Calendar now = Calendar.getInstance();
        int año = now.get(Calendar.YEAR);
        int mes = now.get(Calendar.MONTH) + 1 ;
        
        
               if(mes ==1)
               {
                   fechainicial = ""+año+"-01-01";
                   fechafinal = ""+año+"-01-31";      
               }
               else if(mes ==2)
               {
                   fechainicial = ""+año+"-02-01";
                   fechafinal = ""+año+"-02-29";       
               }
               else if(mes ==3)
               {
                   fechainicial = ""+año+"-03-01";  
                   fechafinal = ""+año+"-03-31";       
               }
               else if(mes ==4)
               {
                   fechainicial = ""+año+"-04-01";
                   fechafinal = ""+año+"-04-30";     
               }
               else if(mes ==5)
               {
                   fechainicial = ""+año+"-05-01";  
                   fechafinal = ""+año+"-05-31";         
               }
               else if(mes ==6)
               {
                   fechainicial = ""+año+"-06-01";  
                   fechafinal = ""+año+"-06-30";         
               }
               else if(mes ==7)
               {
                   fechainicial = ""+año+"-07-01"; 
                   fechafinal = ""+año+"-07-31";        
               }
               else if(mes ==8)
               {
                   fechainicial = ""+año+"-08-01";
                   fechafinal = ""+año+"-08-31" ;       
               }
               else if(mes ==9)
               {
                   fechainicial = ""+año+"-09-01"; 
                   fechafinal = ""+año+"-09-30";       
               }
               else if(mes ==10)
               {
                   fechainicial = ""+año+"-10-01"; 
                   fechafinal = ""+año+"-10-31";      
               }
               else if(mes ==11)
               {
                   fechainicial = ""+año+"-11-01"; 
                   fechafinal = ""+año+"-11-30";        
               }
               else if(mes ==12)
               {
                   fechainicial = ""+año+"-12-01"; 
                   fechafinal = ""+año+"-12-31";        
               }
               
        
        
    }
    

    void datos() {

        DefaultTableModel modelo = (DefaultTableModel) tablacamisa.getModel();
        DefaultTableModel modelo2 = (DefaultTableModel) tablagorra.getModel();
        DefaultTableModel modelopantalon = (DefaultTableModel) tablapantalon.getModel();
        DefaultTableModel modeloparches = (DefaultTableModel) tablaparches.getModel();

        String[] datos = new String[10];
        String[] datos2 = new String[10];
        String[] datos3 = new String[10];
        String[] datos4 = new String[10];
        String[] datos5 = new String[10];

        //// historial_orden_camisa
        
        String sqlcamisa = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  "
                         + "FROM historial_ordenes_camisa where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') "
                         + "and (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'por solicitar') and fecha between '"+fechainicial+"' and '"+fechafinal+"'  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcamisa);
            while (rs.next()) {
                datos[0] = rs.getString("numero");
                datos[1] = rs.getString("cliente");
                datos[2] = rs.getString("prenda");
                datos[3] = rs.getString("tipo");
                datos[4] = rs.getString("lugar");
                datos[5] = rs.getString("numero_venta");
                datos[6] = rs.getString("fecha");

                modelo.addRow(datos);

            }

            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "sql orden camisa" +  ex);
        }

        
        //// historial_orden_gorra
        
        String sqlgorra = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_gorra where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') and (estatus_orden = 'generada' or estatus_orden = 'por solicitar' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlgorra);
            while (rs.next()) {
                datos2[0] = rs.getString("numero");
                datos2[1] = rs.getString("cliente");
                datos2[2] = rs.getString("prenda");
                datos2[3] = rs.getString("tipo");
                datos2[4] = rs.getString("lugar");
                datos2[5] = rs.getString("numero_venta");
                datos2[6] = rs.getString("fecha");

                modelo2.addRow(datos2);

            }

           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"sql orden gorra" +  ex);
        }
        
        //// historial_orden_pantalon
        
         String sqlpantalon = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_pantalon where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') and estatus_orden = 'generada' and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlpantalon);
            while (rs.next()) {
                datos3[0] = rs.getString("numero");
                datos3[1] = rs.getString("cliente");
                datos3[2] = rs.getString("prenda");
                datos3[3] = rs.getString("tipo");
                datos3[4] = rs.getString("lugar");
                datos3[5] = rs.getString("numero_venta");
                datos3[6] = rs.getString("fecha");

                modelopantalon.addRow(datos3);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden pantalon" + ex);
        }
        
        
        //// historial_orden_parches
        
        String sqlparches = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_parche where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') and estatus_orden = 'generada' and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlparches);
            while (rs.next()) {
                datos4[0] = rs.getString("numero");
                datos4[1] = rs.getString("cliente");
                datos4[2] = "Parche";
                datos4[3] = rs.getString("tipo");
                datos4[4] = rs.getString("lugar");
                datos4[5] = rs.getString("numero_venta");
                datos4[6] = rs.getString("fecha");

                modeloparches.addRow(datos4);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden parche" + ex);
        }
        
         //// historial_orden_parches
        
        String sqlponchados = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_ponchados where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') and estatus_orden = 'generada' and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlponchados);
            while (rs.next()) {
                datos5[0] = rs.getString("numero");
                datos5[1] = rs.getString("cliente");
                datos5[2] = "Ponchado";
                datos5[3] = rs.getString("tipo");
                datos5[4] = rs.getString("lugar");
                datos5[5] = rs.getString("numero_venta");
                datos5[6] = rs.getString("fecha");

                modeloparches.addRow(datos5);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden ponchado" + ex);
        }
        
        String sqlcorbata= "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_corbata where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') and estatus_orden = 'generada' and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcorbata);
            while (rs.next()) {
                datos5[0] = rs.getString("numero");
                datos5[1] = rs.getString("cliente");
                datos5[2] = "Corbata";
                datos5[3] = rs.getString("tipo");
                datos5[4] = rs.getString("lugar");
                datos5[5] = rs.getString("numero_venta");
                datos5[6] = rs.getString("fecha");

                modeloparches.addRow(datos5);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden corbata" + ex);
        }
        
        
        
    }
    
    
    void limpiartabla() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablacamisa.getModel();
            int filas = tablacamisa.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
}
    
    
    void limpiartabla1() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablagorra.getModel();
            int filas = tablagorra.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
}
    
    void limpiartabla2() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tablapantalon.getModel();
            int filas = tablapantalon.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
}
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablacamisa = new javax.swing.JTable();
        btnsalir = new javax.swing.JButton();
        lbnumero = new javax.swing.JLabel();
        lbinterface = new javax.swing.JLabel();
        lbtienda = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablagorra = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablapantalon = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablaparches = new javax.swing.JTable();
        btnfrente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordenes bordado generadas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tablacamisa.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tablacamisa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Orden", "cliente", "prenda", "tipo", "lugar", "numeroventa", "fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablacamisa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablacamisaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablacamisa);
        if (tablacamisa.getColumnModel().getColumnCount() > 0) {
            tablacamisa.getColumnModel().getColumn(3).setMinWidth(0);
            tablacamisa.getColumnModel().getColumn(3).setPreferredWidth(0);
            tablacamisa.getColumnModel().getColumn(3).setMaxWidth(0);
            tablacamisa.getColumnModel().getColumn(4).setMinWidth(0);
            tablacamisa.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablacamisa.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbnumero.setText(" ");

        lbinterface.setText(" ");

        lbtienda.setText(" ");

        btnactualizar.setText("actualizar");
        btnactualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnactualizarActionPerformed(evt);
            }
        });

        tablagorra.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tablagorra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Orden", "cliente", "prenda", "tipo", "lugar", "numeroventa", "fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablagorra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablagorraMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablagorra);
        if (tablagorra.getColumnModel().getColumnCount() > 0) {
            tablagorra.getColumnModel().getColumn(3).setMinWidth(0);
            tablagorra.getColumnModel().getColumn(3).setPreferredWidth(0);
            tablagorra.getColumnModel().getColumn(3).setMaxWidth(0);
            tablagorra.getColumnModel().getColumn(4).setMinWidth(0);
            tablagorra.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablagorra.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Gorra");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Camisa \\ Chamarra \\ Camisola ");

        tablapantalon.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tablapantalon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Orden", "cliente", "prenda", "tipo", "lugar", "numeroventa", "fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablapantalon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablapantalonMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablapantalon);
        if (tablapantalon.getColumnModel().getColumnCount() > 0) {
            tablapantalon.getColumnModel().getColumn(3).setMinWidth(100);
            tablapantalon.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablapantalon.getColumnModel().getColumn(3).setMaxWidth(100);
            tablapantalon.getColumnModel().getColumn(4).setMinWidth(0);
            tablapantalon.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablapantalon.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Pantalon");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Parches \\ Ponchados \\ Corbata");

        tablaparches.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tablaparches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero Orden", "cliente", "prenda", "tipo", "lugar", "numeroventa", "fecha"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaparches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaparchesMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tablaparches);
        if (tablaparches.getColumnModel().getColumnCount() > 0) {
            tablaparches.getColumnModel().getColumn(3).setMinWidth(100);
            tablaparches.getColumnModel().getColumn(3).setPreferredWidth(100);
            tablaparches.getColumnModel().getColumn(3).setMaxWidth(100);
            tablaparches.getColumnModel().getColumn(4).setMinWidth(0);
            tablaparches.getColumnModel().getColumn(4).setPreferredWidth(0);
            tablaparches.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        btnfrente.setText("frente");
        btnfrente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfrenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 443, Short.MAX_VALUE)
                        .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(520, 520, 520))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(lbinterface, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbtienda, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel2)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 616, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(btnfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btnactualizar))
                                    .addComponent(jScrollPane4)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbnumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(2, 2, 2)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnfrente)
                    .addComponent(btnactualizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbinterface)
                    .addComponent(lbtienda)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        ventanaordenesbordadogenerada = false;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void tablacamisaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablacamisaMouseClicked

        if (evt.getClickCount() == 2) {

            int fila = tablacamisa.getSelectedRow();

            if (fila >= 0) {

                Object tipo = tablacamisa.getValueAt(fila, 3).toString();

                if (tipo.equals("Orden camisa")||tipo.equals("Orden Camisa")) {
                    if (ordencamisaanteriores.ventanaordencamisaanteriores == true) {
                        
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de camisa anteriores");

                    } else {
                        ordencamisaanteriores orden = new ordencamisaanteriores();
                        orden.setVisible(true);

                        ordencamisaanteriores.lbfolio.setText(tablacamisa.getValueAt(fila, 0).toString());
                        ordencamisaanteriores.lbnumeroventa.setText(tablacamisa.getValueAt(fila, 5).toString());
                        ordencamisaanteriores.lbprenda.setText(tablacamisa.getValueAt(fila, 2).toString());
                         ordencamisaanteriores.lbtipo.setText(tablacamisa.getValueAt(fila, 3).toString());

                       
                    }

                
                } else if (tipo.equals("Orden gorra")||tipo.equals("Orden Gorra")) {
                    if (ordengorraanteriores.ventanaordengorraanteriores == true) {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de camisa anteriores");

                    } else {
                        ordengorraanteriores orden = new ordengorraanteriores();
                        orden.setVisible(true);

                        ordengorraanteriores.lbfolio.setText(tablacamisa.getValueAt(fila, 0).toString());
                        ordengorraanteriores.lbnumeroventa.setText(tablacamisa.getValueAt(fila, 5).toString());
                        ordengorraanteriores.lbprenda.setText(tablacamisa.getValueAt(fila, 2).toString());
                        ordengorraanteriores.lbtipo.setText(tablacamisa.getValueAt(fila, 3).toString());

                        
                    }
                } else {

                  

                }

            }

        } else {
           
        }


    }//GEN-LAST:event_tablacamisaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordenesbordadogenerada = false;
    }//GEN-LAST:event_formWindowClosing

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
       limpiartabla();
       limpiartabla1();
       limpiartabla2();
       datos();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void tablagorraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablagorraMouseClicked
       if (evt.getClickCount() == 2) {

            int fila = tablagorra.getSelectedRow();

            if (fila >= 0) {

                Object tipo = tablagorra.getValueAt(fila, 3).toString();

                if (tipo.equals("Orden gorra")||tipo.equals("Orden Gorra")) {
                    if (ordengorraanteriores.ventanaordengorraanteriores == true) {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de camisa anteriores");

                    } else {
                        ordengorraanteriores orden = new ordengorraanteriores();
                        orden.setVisible(true);

                        ordengorraanteriores.lbfolio.setText(tablagorra.getValueAt(fila, 0).toString());
                        ordengorraanteriores.lbnumeroventa.setText(tablagorra.getValueAt(fila, 5).toString());
                        ordengorraanteriores.lbprenda.setText(tablagorra.getValueAt(fila, 2).toString());
                        ordengorraanteriores.lbtipo.setText(tablagorra.getValueAt(fila, 3).toString());

                        this.setState(this.ICONIFIED);
                    }
                } else {

                  

                }

            }

        } else {
           
        }
    }//GEN-LAST:event_tablagorraMouseClicked

    private void tablapantalonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablapantalonMouseClicked
       if (evt.getClickCount() == 2) 
       {

            int fila = tablapantalon.getSelectedRow();

            if (fila >= 0) {

                    if (ordenpantalonanteriores.ventanaordenpantalonanteriores == true)
                    {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de pantalon anteriores");

                    }
                    else
                    {
                        ordenpantalonanteriores orden = new ordenpantalonanteriores();
                        orden.setVisible(true);

                        ordenpantalonanteriores.lbfolio.setText(tablapantalon.getValueAt(fila, 0).toString());
                        ordenpantalonanteriores.lbnumeroventa.setText(tablapantalon.getValueAt(fila, 5).toString());
                        this.setState(this.ICONIFIED);
                    }
                

            }

        } 

    }//GEN-LAST:event_tablapantalonMouseClicked

    private void tablaparchesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaparchesMouseClicked
        if (evt.getClickCount() == 2) 
       {

            int fila = tablaparches.getSelectedRow();

            if (fila >= 0) 
            {
                
                    Object tipo = tablaparches.getValueAt(fila, 2);
                    
                    
                    if(tipo.equals("Parche"))
                    {

                    if (ordenparcheanteriores.ventanaordenparcheanteriores == true)
                    {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de pantalon anteriores");

                    }
                    else
                    {
                        ordenparcheanteriores orden = new ordenparcheanteriores();
                        orden.setVisible(true);
                        ordenparcheanteriores.lbfolio.setText(tablaparches.getValueAt(fila, 0).toString());
                        
                        this.setState(this.ICONIFIED);
                    }
                
                    }
                    else if(tipo.equals("Ponchado"))
                    {
                        if (ordenponchadoanteriores.ventanaordenparcheanteriores == true)
                    {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de pantalon anteriores");

                    }
                    else
                    {
                        ordenponchadoanteriores orden = new ordenponchadoanteriores();
                        orden.setVisible(true);
                        ordenponchadoanteriores.lbfolio.setText(tablaparches.getValueAt(fila, 0).toString());
                        
                        this.setState(this.ICONIFIED);
                    }
                        
                    }
                    else 
                    {
                        if (ordencorbataanteriores.ventanaordencorbataanteriores == true)
                    {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de pantalon anteriores");

                    }
                    else
                    {
                        ordencorbataanteriores orden = new ordencorbataanteriores();
                        orden.setVisible(true);
                        ordencorbataanteriores.lbfolio.setText(tablaparches.getValueAt(fila, 0).toString());
                        
                        this.setState(this.ICONIFIED);
                    }
                        
                    } 
                    

            }

        } 
    }//GEN-LAST:event_tablaparchesMouseClicked

    private void btnfrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrenteActionPerformed
        this.toFront();
    }//GEN-LAST:event_btnfrenteActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ordenesbordadoporrealizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordenesbordadoporrealizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordenesbordadoporrealizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordenesbordadoporrealizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ordenesbordadoporrealizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnactualizar;
    public static javax.swing.JButton btnfrente;
    private javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel lbinterface;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbtienda;
    private javax.swing.JTable tablacamisa;
    private javax.swing.JTable tablagorra;
    private javax.swing.JTable tablapantalon;
    private javax.swing.JTable tablaparches;
    // End of variables declaration//GEN-END:variables
connectar cc = new connectar();
Connection cn = cc.conexion();

}
