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
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class historialayudabordador extends javax.swing.JFrame {

    String mesdelaño ="";
    int añoactual = 0;
    
    
    public historialayudabordador() 
    {
        initComponents();
        
        Calendar now = Calendar.getInstance();
        String[] strMonths = new String[]{"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};

        añoactual = now.get(Calendar.YEAR);
        
    
        
    
    
    }
    
    void sumahoras()
    {
         
        int filas = tabla.getRowCount();
        double sumatotal = 0;

        for (int j = 0; j < filas; j++) 
        {

       
            Object horasobject = tabla.getValueAt(j,1);

            double horasdouble = Double.parseDouble(horasobject.toString());

            sumatotal = sumatotal + horasdouble;
           
        }
        
        String sumatotalstring = String.valueOf(sumatotal);

        lbsumahoras.setText(sumatotalstring);
        
        
    }
    
    
    void limpiartabla() {
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
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

        jLabel1 = new javax.swing.JLabel();
        cbmes = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        lbsumahoras = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        lbaño = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("historial ayuda bordador");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Mes");

        cbmes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre", "Seleccione mes" }));
        cbmes.setSelectedIndex(-1);
        cbmes.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbmesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        tabla.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Dia", "Hora"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(24);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Suma");

        lbsumahoras.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbsumahoras.setText("0");
        lbsumahoras.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbaño.setText("0000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbaño, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lbsumahoras, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 29, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(104, 104, 104))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbaño, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lbsumahoras, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(65, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbmesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbmesPopupMenuWillBecomeInvisible

        DefaultTableModel modelotabla = (DefaultTableModel) tabla.getModel();
        String[] datos = new String[2];
        Object mesdelaño =  cbmes.getSelectedItem();
        Object añoobject =lbaño.getText();
        añoactual = Integer.parseInt(añoobject.toString());
        String diafinal = "";
        String dia = "";
        String mes = "";
        Object tiempo = "";
        Object fecha = "";
        
        limpiartabla();
        
        if(mesdelaño.equals("Enero"))
        {
            diafinal = "31";
            mes ="01";
        }
        else if(mesdelaño.equals("Febrero"))
        {
           diafinal = "29"; 
            mes ="02";
        }
        else if(mesdelaño.equals("Marzo"))
        {
            diafinal = "31";
             mes ="03";
        }
        else if(mesdelaño.equals("Abril"))
        {
            diafinal = "30";
            mes ="04";
        }
        else if(mesdelaño.equals("Mayo"))
        {
            diafinal = "31";
            mes ="05";
        }
        else if(mesdelaño.equals("Junio"))
        {
            diafinal = "30";
            mes ="06";
        }
        else if(mesdelaño.equals("Julio"))
        {
            diafinal = "31";
            mes ="07";
        }
        else if(mesdelaño.equals("Agosto"))
        {
            diafinal = "31";
            mes ="08";
        }
        else if(mesdelaño.equals("Septiembre"))
        {
            diafinal = "30";
            mes ="09";
        }
        else if(mesdelaño.equals("Octubre"))
        {
           diafinal = "31"; 
           mes ="10";
        }
        else if(mesdelaño.equals("Noviembre"))
        {
          diafinal = "30";  
          mes ="11";
        }
        else if(mesdelaño.equals("Diciembre"))
        {
          diafinal = "31"; 
          mes ="12";
        }
        
        int diafinalint = Integer.parseInt(diafinal);
        

        for (int i = 1; i <= diafinalint; i++) 
        {

            datos[0] = String.valueOf(i);
            dia = String.valueOf(i);
            
            fecha = (+añoactual+ "-" +mes+ "-" +dia);
            tiempo = "0";
           
            String SQL = "Select tiempo from ayuda_bordador where fecha= '"+fecha+"' ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) 
            {
                
             tiempo =rs.getString(1);
             
            }
             

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }  
        
            if(tiempo ==null || tiempo.equals("") || tiempo.equals(" "))
            {
                tiempo = "0";
            }
        
        
            datos[1] = tiempo.toString();
            
            modelotabla.addRow(datos);

        }
        
        sumahoras();
        
        
    }//GEN-LAST:event_cbmesPopupMenuWillBecomeInvisible

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    
    cbmes.setSelectedItem(mesdelaño);
    cbmes.firePopupMenuWillBecomeInvisible();
    
    
    }//GEN-LAST:event_formWindowOpened

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
     this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

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
            java.util.logging.Logger.getLogger(historialayudabordador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(historialayudabordador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(historialayudabordador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(historialayudabordador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new historialayudabordador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsalir;
    public static javax.swing.JComboBox<String> cbmes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbaño;
    private javax.swing.JLabel lbsumahoras;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
coneccionlocal cc = new coneccionlocal();
Connection cn = cc.conexion();


}
