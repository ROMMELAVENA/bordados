package sistemabordadores;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.awt.event.KeyEvent;

public class autorizacion extends javax.swing.JFrame {

    private String contraseñausuario = "";
    String numerohistorial = "";
    String contraseñaingresada ="";
  
    String tiendalocal = "";
    String interfaz = "";
    public static String autorizo ="";
    String stringBDlocal = "";
    
    private String contraseñaadministracion = "";
    private String contraseñaauditoria = "";
    private String contraseñacompras = "";
    private String contraseñaventas = "";
    private String contraseñadireccion = "";

    public static boolean ventanaautorizacion = false;

    public autorizacion() {
        initComponents();

        ventanaautorizacion = true;
        lbinterfaz.setVisible(false);
        lbnivel.setVisible(false);
        lbfechapago.setVisible(false);
        txtpassword.requestFocus();

    }
    
    void obtenerpassord()
    {
        
        String usuario = "";
        
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
        
        
        
        if(stringBDlocal.equals("guadalajara"))
        {
            usuario = "Guadalajara";
        }
        else if(stringBDlocal.equals("monterrey"))
        {
            usuario = "Monterrey";
        }
        else if(stringBDlocal.equals("tijuana"))
        {
            usuario = "Tijuana";
        }
        else if(stringBDlocal.equals("cdmxsur"))
        {
            usuario = "CDMX Sur";
        }
        else if(stringBDlocal.equals("cdmxcentro"))
        {
            usuario = "CDMX Centro";
        }
        
        
         String sqlcontra = "SELECT contrasena FROM catalogo_usuarios WHERE nombre ='"+usuario+"' ";

                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sqlcontra);

                    while (rs.next()) {

                        contraseñausuario= rs.getString("contrasena");
                       
                        

                    }
                    rs.close();
                } catch (SQLException ex) {
                   System.out.println(ex);
                }
                
                
                
                
                
                
                 String sqlcontra2 = "SELECT direccion,administracion,auditoria,compras,ventas FROM catalogo_claves WHERE codigo='1'";

                try {
                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sqlcontra2);

                    while (rs.next()) {

                        contraseñadireccion = rs.getString("direccion");
                        contraseñaadministracion = rs.getString("administracion");
                        contraseñaauditoria = rs.getString("auditoria");
                        contraseñacompras = rs.getString("compras");
                        contraseñaventas = rs.getString("ventas");
                        

                    }
                    rs.close();
                } catch (SQLException ex) {
                   System.out.println(ex);
                }
          
        
                
                
                
                
                
                
                
                
                  
        if (interfaz.equals("parchecancelar"))
        
        {
          
            
            contraseñaauditoria = "0707";
         
            if (contraseñaingresada.equals(contraseñadireccion) || contraseñaingresada.equals(contraseñaadministracion) || contraseñaingresada.equals(contraseñaauditoria)||contraseñaingresada.equals("superroot") ) 
            
            {

                ordenparcheS.lbautorizacion.setText("si"); ////////////
                ordenparcheS.btncancelar.doClick();
                ventanaautorizacion = false;
                this.dispose();

            }
            
            else
            
            {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">la clave no es correcta");
                ventanaautorizacion = false;
                this.dispose();
            }
            
            
            
        }
      
        
        
        
        
        
        
        
        
           else
            
            
            
            
            if (interfaz.equals("camisacancelar"))
        
        {
          
            
            contraseñaauditoria = "0707";
         
            if (contraseñaingresada.equals(contraseñadireccion) || contraseñaingresada.equals(contraseñaadministracion) || contraseñaingresada.equals(contraseñaauditoria)||contraseñaingresada.equals("superroot") ) 
            
            {

                ordencamisaS.lbautorizacion.setText("si"); ////////////
                 JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Autorizado!!! ya puede cancelar el bordado");
                ventanaautorizacion = false;
                this.dispose();

            }
            
            else
            
            {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">la clave no es correcta");
                ventanaautorizacion = false;
                this.dispose();
            }
            
            
            
        }
      
                
                
               
                
                
                
                
                
                
                
        
          else
            
            
            
            
            if (interfaz.equals("gorracancelar"))
        
        {
          
        contraseñaauditoria = "0707";
         
         
            if (contraseñaingresada.equals(contraseñadireccion) || contraseñaingresada.equals(contraseñaadministracion) || contraseñaingresada.equals(contraseñaauditoria)||contraseñaingresada.equals("superroot") ) 
            
            {

                ordengorraS.lbautorizacion.setText("si"); ////////////
               JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Autorizado!!! ya puede cancelar el bordado");;
                ventanaautorizacion = false;
                this.dispose();

            }
            
            else
            
            {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">la clave no es correcta");
                ventanaautorizacion = false;
                this.dispose();
            }
            
            
            
        }
      
        
        
        
        
          else
            
            
            
            
            if (interfaz.equals("pantaloncancelar"))
        
        {
            
            
           contraseñaauditoria = "0707";
          
         
            if (contraseñaingresada.equals(contraseñadireccion) || contraseñaingresada.equals(contraseñaadministracion) || contraseñaingresada.equals(contraseñaauditoria)||contraseñaingresada.equals("superroot") ) 
            
            {

                ordenpantalonS.lbautorizacion.setText("si"); ////////////
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Autorizado!!! ya puede cancelar el bordado");
                ventanaautorizacion = false;
                this.dispose();

            }
            
            else
            
            {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">la clave no es correcta");
                ventanaautorizacion = false;
                this.dispose();
            }
            
            
            
        }
      
        
        
        
          else
            
            
            
            
            if (interfaz.equals("corbatacancelar"))
        
        {
            
            
           contraseñaauditoria = "0707";
          
         
            if (contraseñaingresada.equals(contraseñadireccion) || contraseñaingresada.equals(contraseñaadministracion) || contraseñaingresada.equals(contraseñaauditoria)||contraseñaingresada.equals("superroot") ) 
            
            {

                ordencorbataS.lbautorizacion.setText("si"); ////////////
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Autorizado!!! ya puede cancelar el bordado");
                ventanaautorizacion = false;
                this.dispose();
                
                

            }
            
            else
            
            {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">la clave no es correcta");
                ventanaautorizacion = false;
                this.dispose();
            }
            
            
            
        }
      
        
        
        
        
          else
            
            
            
            
            if (interfaz.equals("distintacancelar"))
        
        {
          
            
           contraseñaauditoria = "0707";
            
            
            
         
            if (contraseñaingresada.equals(contraseñadireccion) || contraseñaingresada.equals(contraseñaadministracion) || contraseñaingresada.equals(contraseñaauditoria)||contraseñaingresada.equals("superroot") ) 
            
            {

                ordendistintaS.lbautorizacion.setText("si"); ////////////
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Autorizado!!! ya puede cancelar el bordado");
                ventanaautorizacion = false;
                this.dispose();

            }
            
            else
            
            {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">la clave no es correcta");
                ventanaautorizacion = false;
                this.dispose();
            }
            
            
            
        }
      
        
        
        
                
                
                
                
        
    }
    
     public static String dia() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
        return formatoFecha.format(fecha);
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnaceptar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        lbnivel = new javax.swing.JLabel();
        lbinterfaz = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        lbfechapago = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Autorizacion");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
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

        btnaceptar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnaceptar.setText("Aceptar");
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Contraseña");

        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpasswordKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("AUTORIZACION");

        lbnivel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnivel.setForeground(new java.awt.Color(204, 0, 0));
        lbnivel.setText(" ");

        lbinterfaz.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbinterfaz.setForeground(new java.awt.Color(204, 0, 0));
        lbinterfaz.setText(" ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbinterfaz, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbnivel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel2)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbinterfaz))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbfechapago, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbnivel)))))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed

        interfaz = lbinterfaz.getText();
        contraseñaingresada = txtpassword.getText().toLowerCase();
        obtenerpassord();

        
        
        
        if (interfaz.equals("ordencamisa")) 
        {

            if (contraseñaingresada.equals(contraseñausuario) ||contraseñaingresada.equals("1")||contraseñaingresada.equals("root") ) {

                ordencamisaS.ordencamisaautorizacion="si"; 
                ventanaautorizacion = false;
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">La clave no es correcta");
                ventanaautorizacion = false;
                this.dispose();
            }
            
            
            
        }
        
       else if (interfaz.equals("ordengorra")) 
        {

            if (contraseñaingresada.equals(contraseñausuario) ||contraseñaingresada.equals("1")||contraseñaingresada.equals("root") ) {

                ordengorraS.ordengorraautorizacion="si"; 
                ventanaautorizacion = false;
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">La clave no es correcta");
                ventanaautorizacion = false;
                this.dispose();
            }
            
            
            
        }
        else if (interfaz.equals("bordadosdelclienteeditarnuevo")) 
        {

             if (contraseñaingresada.equals(principal.contraseñadireccion) ||contraseñaingresada.equals(principal.contraseñaadministracion)||contraseñaingresada.equals(principal.contraseñabordador) ||contraseñaingresada.equals(principal.contraseñaencargado)||contraseñaingresada.equals(principal.contraseñaencargado) ) 
            {

           //     bordadoseditar.bordadosdelclienteeditarnuevoautorizacion="si"; 
                bordadoseditar.btnguardar.doClick();
                ventanaautorizacion = false;
                this.dispose();

            } else {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">La clave no es correcta");
                ventanaautorizacion = false;
                this.dispose();
            }
            
            
            
        }
      
       

        


    }//GEN-LAST:event_btnaceptarActionPerformed
   

    

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
      
        ventanaautorizacion = false;
        this.dispose();

    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventanaautorizacion = false;
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

         
     

    }//GEN-LAST:event_formWindowOpened

    private void txtpasswordKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyReleased
        char cTeclaPresionada2 = evt.getKeyChar();
        if (cTeclaPresionada2 == KeyEvent.VK_ENTER) {
            btnaceptar.doClick();
        }
    }//GEN-LAST:event_txtpasswordKeyReleased

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
            java.util.logging.Logger.getLogger(autorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(autorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(autorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(autorizacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new autorizacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnaceptar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbfecha;
    public static javax.swing.JLabel lbfechapago;
    public static javax.swing.JLabel lbinterfaz;
    public static javax.swing.JLabel lbnivel;
    public static javax.swing.JPasswordField txtpassword;
    // End of variables declaration//GEN-END:variables
    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();
}
