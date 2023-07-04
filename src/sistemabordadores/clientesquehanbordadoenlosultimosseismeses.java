/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabordadores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sistemas
 */
public class clientesquehanbordadoenlosultimosseismeses extends javax.swing.JFrame {
    
    public static String quefechabuscare ="";

    /**
     * Creates new form clientesquehanbordadoenlosultimosseismeses
     */
    public clientesquehanbordadoenlosultimosseismeses() {
        initComponents();
       
    }

     void datos6meses()
     {
         
       List<String> listaclientes = new ArrayList<String>();
       String[] datos = new String[10];
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       String fechainicio = "";
       String fechafinal = "";
         
       SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" ); 
       
       Calendar calendario = Calendar.getInstance();
       calendario.add( calendario.MONTH, -6 ); // date manipulation
       fechainicio = df.format( calendario.getTime() ) ;
       
       Calendar calendario2 = Calendar.getInstance();
       fechafinal = df.format( calendario2.getTime() ) ;
         
         
         String sql = "SELECT distinct cliente,fecha from historial_ordenes_camisa\n"
                        + "where fecha BETWEEN '"+fechainicio+"'  AND '"+fechafinal+"' AND (cliente not LIKE '%SA DE CV%' OR cliente NOT LIKE '%S.A. DE C.V.%' OR cliente NOT LIKE '%S.A DE C.V%' OR cliente NOT LIKE '%S DE RL DE CV%') \n"
                        + "union\n"
                        + "SELECT distinct cliente,fecha from historial_ordenes_gorra \n"
                        + "where fecha BETWEEN '"+fechainicio+"'  AND '"+fechafinal+"' AND (cliente not LIKE '%SA DE CV%' OR cliente NOT LIKE '%S.A. DE C.V.%' OR cliente NOT LIKE '%S.A DE C.V%' OR cliente NOT LIKE '%S DE RL DE CV%') \n"
                        + "union \n"
                        + "SELECT distinct cliente,fecha from historial_ordenes_pantalon  \n"
                        + "where fecha BETWEEN '"+fechainicio+"'  AND '"+fechafinal+"' AND (cliente not LIKE '%SA DE CV%' OR cliente NOT LIKE '%S.A. DE C.V.%' OR cliente NOT LIKE '%S.A DE C.V%' OR cliente NOT LIKE '%S DE RL DE CV%')\n"
                        + "union \n"
                        + "SELECT distinct cliente,fecha from historial_ordenes_corbata  \n"
                        + "where fecha BETWEEN '"+fechainicio+"'  AND '"+fechafinal+"' AND (cliente not LIKE '%SA DE CV%' OR cliente NOT LIKE '%S.A. DE C.V.%' OR cliente NOT LIKE '%S.A DE C.V%' OR cliente NOT LIKE '%S DE RL DE CV%')\n"
                        + "union\n"
                        + "SELECT distinct cliente,fecha from historial_ordenes_distinta \n"
                        + "where fecha BETWEEN '"+fechainicio+"'  AND '"+fechafinal+"' AND (cliente not LIKE '%SA DE CV%' OR cliente NOT LIKE '%S.A. DE C.V.%' OR cliente NOT LIKE '%S.A DE C.V%' OR cliente NOT LIKE '%S DE RL DE CV%') ORDER BY cliente ";
             
       
       
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                

                
                Object cliente = rs.getString("cliente");
                
                if(cliente == null || cliente.equals("")||cliente.equals(" "))
                {
                    
                }
                else
                {    
                    
                listaclientes.add(cliente.toString());
           
                }
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
         
         
     
        if(listaclientes.size() > 0)
      {
      

          listaclientes = listaclientes.stream().distinct().collect(Collectors.toList());
          
          for(int i = 0; i < listaclientes.size(); i++)
          {
              
               datos[0] = listaclientes.get(i);
               modelo.addRow(datos);
              
          }
          
          
     
      }
     
     
     
     
     
     
     }
     
     
     
      void datos6a12meses()
     {
         
       List<String> listaclientes = new ArrayList<String>();
       String[] datos = new String[10];
       DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       String fechainicio = "";
       String fechafinal = "";
         
       SimpleDateFormat df = new SimpleDateFormat( "yyyy-MM-dd" ); 
       
       Calendar calendario = Calendar.getInstance();
       calendario.add( calendario.MONTH, -12 ); // date manipulation
       fechainicio = df.format( calendario.getTime() ) ;
       
       Calendar calendario2 = Calendar.getInstance();
       fechafinal = df.format( calendario2.getTime() ) ;
         
         
         String sql = "SELECT distinct cliente,fecha from historial_ordenes_camisa\n"
                        + "where fecha BETWEEN '"+fechainicio+"'  AND '"+fechafinal+"' AND (cliente not LIKE '%SA DE CV%' OR cliente NOT LIKE '%S.A. DE C.V.%' OR cliente NOT LIKE '%S.A DE C.V%' OR cliente NOT LIKE '%S DE RL DE CV%') \n"
                        + "union\n"
                        + "SELECT distinct cliente,fecha from historial_ordenes_gorra \n"
                        + "where fecha BETWEEN '"+fechainicio+"'  AND '"+fechafinal+"' AND (cliente not LIKE '%SA DE CV%' OR cliente NOT LIKE '%S.A. DE C.V.%' OR cliente NOT LIKE '%S.A DE C.V%' OR cliente NOT LIKE '%S DE RL DE CV%') \n"
                        + "union \n"
                        + "SELECT distinct cliente,fecha from historial_ordenes_pantalon  \n"
                        + "where fecha BETWEEN '"+fechainicio+"'  AND '"+fechafinal+"' AND (cliente not LIKE '%SA DE CV%' OR cliente NOT LIKE '%S.A. DE C.V.%' OR cliente NOT LIKE '%S.A DE C.V%' OR cliente NOT LIKE '%S DE RL DE CV%')\n"
                        + "union \n"
                        + "SELECT distinct cliente,fecha from historial_ordenes_corbata  \n"
                        + "where fecha BETWEEN '"+fechainicio+"'  AND '"+fechafinal+"' AND (cliente not LIKE '%SA DE CV%' OR cliente NOT LIKE '%S.A. DE C.V.%' OR cliente NOT LIKE '%S.A DE C.V%' OR cliente NOT LIKE '%S DE RL DE CV%')\n"
                        + "union\n"
                        + "SELECT distinct cliente,fecha from historial_ordenes_distinta \n"
                        + "where fecha BETWEEN '"+fechainicio+"'  AND '"+fechafinal+"' AND (cliente not LIKE '%SA DE CV%' OR cliente NOT LIKE '%S.A. DE C.V.%' OR cliente NOT LIKE '%S.A DE C.V%' OR cliente NOT LIKE '%S DE RL DE CV%') ORDER BY cliente ";
             
       
       
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                

                
                Object cliente = rs.getString("cliente");
                
                if(cliente == null || cliente.equals("")||cliente.equals(" "))
                {
                    
                }
                else
                {    
                    
                listaclientes.add(cliente.toString());
           
                }
            
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
         
         
     
        if(listaclientes.size() > 0)
      {
      

          listaclientes = listaclientes.stream().distinct().collect(Collectors.toList());
          
          for(int i = 0; i < listaclientes.size(); i++)
          {
              
               datos[0] = listaclientes.get(i);
               modelo.addRow(datos);
              
          }
          
          
     
      }
     
     
     
     
     
     
     }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        bntsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Clientes que han bordado en los ultimos 6 meses");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(25);
        jScrollPane1.setViewportView(tabla);

        bntsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bntsalir.setText("Salir");
        bntsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bntsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 828, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bntsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bntsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntsalirActionPerformed
    
    this.dispose();
        
    }//GEN-LAST:event_bntsalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
        if(quefechabuscare.equals("6meses"))
        {
        datos6meses();
        }
        else
        {
          datos6a12meses();  
        }    
        
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(clientesquehanbordadoenlosultimosseismeses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(clientesquehanbordadoenlosultimosseismeses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(clientesquehanbordadoenlosultimosseismeses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(clientesquehanbordadoenlosultimosseismeses.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new clientesquehanbordadoenlosultimosseismeses().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntsalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
coneccionlocal cc = new coneccionlocal();
Connection cn = cc.conexion();


}
