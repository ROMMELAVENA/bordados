package sistemabordadores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ordenesbordadorecibida extends javax.swing.JFrame {

    public static boolean ventanaordenbordadorecibida = false;

    public ordenesbordadorecibida() {
        initComponents();
        ventanaordenbordadorecibida = true;
        lbinterface.setVisible(false);
        lbtienda.setVisible(false);
        btnactualizar.setVisible(false);
        btnfrente.setVisible(false);
        datoscamisa();
        datosgorra();
        datospantalon();

    }

    void datoscamisa() 
    {

        DefaultTableModel modelocamisas = (DefaultTableModel) tabla.getModel();

        String[] datos = new String[10];

        String sql3 = "SELECT numero,numero_sucursal,cliente,prenda,tipo,cliente,tienda  FROM historial_ordenes_camisa_recibidas where estatus = 'por guardar' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql3);
            while (rs.next()) {
                datos[0] = rs.getString("numero");
                datos[1] = rs.getString("numero_sucursal");
                datos[2] = rs.getString("cliente");
                datos[3] = rs.getString("prenda");
                datos[4] = rs.getString("tipo");
                datos[5] = rs.getString("tienda");

                modelocamisas.addRow(datos);

            }

            tabla.setModel(modelocamisas);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        tieneponchados();

    }
    
    
    void datosgorra() {

        DefaultTableModel modelogorras = (DefaultTableModel) tabla1.getModel();

        String[] datos = new String[10];

        String sql3 = "SELECT numero,numero_sucursal,cliente,prenda,tipo,cliente,tienda  FROM historial_ordenes_gorra_recibidas  where estatus = 'por guardar' order by numero  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql3);
            while (rs.next()) {
                datos[0] = rs.getString("numero");
                datos[1] = rs.getString("numero_sucursal");
                datos[2] = rs.getString("cliente");
                datos[3] = rs.getString("prenda");
                datos[4] = rs.getString("tipo");
                datos[5] = rs.getString("tienda");

                modelogorras.addRow(datos);

            }

            tabla1.setModel(modelogorras);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        tieneponchados();

    }
    
    void datospantalon() {

        DefaultTableModel modelopantalon = (DefaultTableModel) tabla2.getModel();

        String[] datos = new String[10];

        String sql3 = "SELECT numero,numero_sucursal,cliente,prenda,tipo,cliente,tienda  FROM historial_ordenes_pantalon_recibidas  where estatus = 'por guardar' order by numero  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql3);
            while (rs.next()) {
                datos[0] = rs.getString("numero");
                datos[1] = rs.getString("numero_sucursal");
                datos[2] = rs.getString("cliente");
                datos[3] = rs.getString("prenda");
                datos[4] = rs.getString("tipo");
                datos[5] = rs.getString("tienda");

                modelopantalon.addRow(datos);

            }

            

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        tieneponchados();

    }
    
    
    
    void tieneponchados() {

   String tieneponchadoscamisa ="";
   String tieneponchadosgorra ="";
        
        for(int i =0; i < tabla.getRowCount();i++)
            
        {   
            
            Object tipocamisa =  tabla.getValueAt(i, 3);
            Object numerocamisa =  tabla.getValueAt(i, 0);

            
          
            String sqlcamisas  = "SELECT manga_izquierda_ponchado, manga_derecha_ponchado,pecho_izquierdo_ponchado,pecho_derecho_ponchado,espalda_ponchado  FROM historial_ordenes_camisa_recibidas where numero =  '"+numerocamisa+"'  ";
            
              
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcamisas);
            while (rs.next()) {
               
                  tieneponchadoscamisa ="";
                 String boton1 = rs.getString("manga_izquierda_ponchado");
              if (boton1==null||boton1.equals(""))
              {
              
              }
              else
              {
                  tieneponchadoscamisa ="si";
              }    
              
              String boton2 = rs.getString("manga_derecha_ponchado");
              if (boton2==null||boton2.equals(""))
              {
             
              }
              else
              {
                  tieneponchadoscamisa ="si";
              } 
              
              
              String boton3 = rs.getString("pecho_izquierdo_ponchado");
              if (boton3==null||boton3.equals(""))
              {
              
              }
              else
              {
                  tieneponchadoscamisa ="si";
              } 
              
              String boton4 = rs.getString("pecho_derecho_ponchado");
              if (boton4==null||boton4.equals(""))
              {
              
              }
              else
              {
                  tieneponchadoscamisa ="si";
              } 
              
              String boton5 = rs.getString("espalda_ponchado");
              if (boton5==null||boton5.equals(""))
              {
            
              }
              else
              {
                  tieneponchadoscamisa ="si";
              } 

            }
            
            
            if(tieneponchadoscamisa.equals("si"))
            {
                tabla.setValueAt("si", i,6);
            }
            else
            {
                tabla.setValueAt("no", i,6);
            }    

           

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        }
        
         for(int i =0; i < tabla1.getRowCount();i++)
            
        {   
            
            
            Object tipogorra =  tabla1.getValueAt(i, 3);
            Object numerogorra =  tabla1.getValueAt(i, 0);
         
           //// sql gorra 
            
          String  sqlgorra  = "SELECT frente_ponchado, lado_izquierdo_ponchado,lado_derecho_ponchado,atras_ponchado  FROM historial_ordenes_gorra_recibidas where numero =  '"+numerogorra+"'  ";
            
              
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlgorra);
            while (rs.next()) {
               
                  tieneponchadosgorra ="";
                 String boton1 = rs.getString("frente_ponchado");
              if (boton1==null||boton1.equals(""))
              {
              
              }
              else
              {
                  tieneponchadosgorra ="si";
              }    
              
              String boton2 = rs.getString("lado_izquierdo_ponchado");
              if (boton2==null||boton2.equals(""))
              {
             
              }
              else
              {
                  tieneponchadosgorra ="si";
              } 
              
              
              String boton3 = rs.getString("lado_derecho_ponchado");
              if (boton3==null||boton3.equals(""))
              {
              
              }
              else
              {
                  tieneponchadosgorra ="si";
              } 
              
              String boton4 = rs.getString("atras_ponchado");
              if (boton4==null||boton4.equals(""))
              {
              
              }
              else
              {
                  tieneponchadosgorra ="si";
              } 
              
              

            }
            
            
            if(tieneponchadosgorra.equals("si"))
            {
                tabla1.setValueAt("si", i,6);
            }
            else
            {
                tabla1.setValueAt("no", i,6);
            }    

           

        } catch (SQLException ex) {
            System.out.println(ex);
        }
               
        }     
        

        
       

    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnsalir = new javax.swing.JButton();
        lbnumero = new javax.swing.JLabel();
        lbinterface = new javax.swing.JLabel();
        lbtienda = new javax.swing.JLabel();
        btnactualizar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnfrente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordenes bordado recibidas");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Numero sucursal", "cliente", "prenda", "tipo", "tienda", "tiene ponchados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(4).setMinWidth(0);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(4).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setMinWidth(0);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(6).setMaxWidth(0);
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

        tabla1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabla1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Numero sucursal", "cliente", "prenda", "tipo", "tienda", "tiene ponchados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabla1);
        if (tabla1.getColumnModel().getColumnCount() > 0) {
            tabla1.getColumnModel().getColumn(4).setMinWidth(0);
            tabla1.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabla1.getColumnModel().getColumn(4).setMaxWidth(0);
            tabla1.getColumnModel().getColumn(6).setMinWidth(0);
            tabla1.getColumnModel().getColumn(6).setPreferredWidth(0);
            tabla1.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Pantalon");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Gorra");

        tabla2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabla2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numero", "Numero sucursal", "cliente", "prenda", "tipo", "tienda", "tiene ponchados"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabla2MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla2);
        if (tabla2.getColumnModel().getColumnCount() > 0) {
            tabla2.getColumnModel().getColumn(4).setMinWidth(0);
            tabla2.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabla2.getColumnModel().getColumn(4).setMaxWidth(0);
            tabla2.getColumnModel().getColumn(6).setMinWidth(0);
            tabla2.getColumnModel().getColumn(6).setPreferredWidth(0);
            tabla2.getColumnModel().getColumn(6).setMaxWidth(0);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Camisa \\ Chamarra \\ Camisola ");

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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE))
                    .addComponent(jLabel3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(88, 88, 88)
                        .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnactualizar)
                            .addComponent(btnfrente))
                        .addGap(69, 69, 69))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbinterface, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbtienda, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 266, Short.MAX_VALUE))
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 586, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbnumero)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)))
                    .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnactualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnfrente)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbinterface)
                    .addComponent(lbtienda)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        ventanaordenbordadorecibida = false;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        if (evt.getClickCount() == 1) {

            int fila = tabla.getSelectedRow();

            if (fila >= 0) {
                
                Object tipo = tabla.getValueAt(fila, 3).toString();

                if (tipo.equals("camisa")||tipo.equals("Camisa")||tipo.equals("Camisa2")||tipo.equals("Camisa3")||tipo.equals("Camisa4")||tipo.equals("Camisa5")||tipo.equals("Chamarra rompevientos")||tipo.equals("Chaleco")||tipo.equals("Chamarra desmontable")||tipo.equals("Chamarra2 desmontable")||tipo.equals("Playera")||tipo.equals("Playera2")||tipo.equals("Playera3")||tipo.equals("Playera4")||tipo.equals("Playera5")||tipo.equals("Camisola")) {

               ordencamisa ventana = new ordencamisa();
               
               
               String clienteordenrecibida = tabla.getValueAt(fila, 2).toString(); 
               String numeroordenrecibida = tabla.getValueAt(fila, 0).toString();
               String numerofolio = tabla.getValueAt(fila, 1).toString();
               
               
              ordencamisa.lbcliente.setText(clienteordenrecibida);
              ordencamisa.lbnumero.setText(numeroordenrecibida);
              ordencamisa.lbfolio.setText(numeroordenrecibida);
              
              ventana.setVisible(true);

                }
               
  
            
            } else {
            JOptionPane.showMessageDialog(null, "no seleciono fila");
        }

        }
        
        

    }//GEN-LAST:event_tablaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordenbordadorecibida = false;
    }//GEN-LAST:event_formWindowClosing
void limpiartabla() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
        
        
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla1.getModel();
            int filas = tabla1.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla1.");
        }
        
}
    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
       limpiartabla();
       datoscamisa();
       datosgorra();
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void tabla1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla1MouseClicked
 if (evt.getClickCount() == 1) {

            int fila = tabla1.getSelectedRow();

            if (fila >= 0) 
            {
                
                Object tipo = tabla1.getValueAt(fila, 3).toString();

                    
                 if (tipo.equals("gorra") || tipo.equals("Gorra") || tipo.equals("Gorra2") || tipo.equals("Gorra3")) 
                {

                    ordengorra ventana = new ordengorra();

                    String clienteordenrecibida = tabla1.getValueAt(fila, 2).toString();
                    String numeroordenrecibida = tabla1.getValueAt(fila, 0).toString();
                    ordengorra.lbcliente.setText(clienteordenrecibida);
                    ordengorra.lbnumero.setText(numeroordenrecibida);
                    ordengorra.lbfolio.setText(numeroordenrecibida);

                    ventana.setVisible(true);

                }

                
                
  
            
            } else {
            JOptionPane.showMessageDialog(null, "no seleciono fila");
        }

        }   
    }//GEN-LAST:event_tabla1MouseClicked

    private void tabla2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabla2MouseClicked
      if (evt.getClickCount() == 2) 
      {

            int fila = tabla2.getSelectedRow();

            if (fila >= 0) 
            {
                
               ordenpantalon ventana = new ordenpantalon();
               String clienteordenrecibida = tabla2.getValueAt(fila, 2).toString(); 
               String numeroordenrecibida = tabla2.getValueAt(fila, 0).toString();
               String tiendasolicita = tabla2.getValueAt(fila, 5).toString();
               ordenpantalon.lbcliente.setText(clienteordenrecibida);
               ordenpantalon.lbfolio.setText(numeroordenrecibida);
             //  ordenpantalon.lbtiendasolicita.setText(tiendasolicita);
               ventana.setVisible(true);

            } else 
            
            {
            JOptionPane.showMessageDialog(null, "no seleciono fila");
            }

        }   
    }//GEN-LAST:event_tabla2MouseClicked

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
            java.util.logging.Logger.getLogger(ordenesbordadorecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordenesbordadorecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordenesbordadorecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordenesbordadorecibida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ordenesbordadorecibida().setVisible(true);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lbinterface;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbtienda;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tabla1;
    private javax.swing.JTable tabla2;
    // End of variables declaration//GEN-END:variables
connectar cc = new connectar();
    Connection cn = cc.conexion();

}
