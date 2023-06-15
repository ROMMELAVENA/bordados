package sistemabordadores;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.sql.*;
import java.util.Scanner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;


public class ingresotienda extends javax.swing.JFrame {
  public static String ip="";
  public static String correo="";
  public static String contrasenacorreo="";
  public static boolean ventanaingresotienda=false;
  public static String tienda_bd="";
 
  public static String iplocal = ""; 
  public static String tiendalocal = ""; 
  

  
 
 
 public ingresotienda() 
 {
       
        initComponents();
       
       ventanaingresotienda=true;
       btnentrar.setEnabled(false);
       

     cbtienda.getEditor().getEditorComponent().addKeyListener(new KeyListener() {

         public void keyPressed(KeyEvent e) {
             if (e.getKeyCode() == e.VK_ENTER) {

                 btnentrar.doClick();
             }
         }

         public void keyReleased(KeyEvent e) {
         }

         public void keyTyped(KeyEvent e) {
         }

     });
     
     
     
     File file =null;
     file = new File("C:\\sistema\\tiendalocal.txt");
  
     try {
           Scanner sc = new Scanner(file);
           if (sc.hasNext()) 
           {
               tiendalocal = sc.nextLine();
      

           }

       } catch (IOException e) {
           System.out.println(e);
       }
   
   
         DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        
         modelo.addElement(tiendalocal);
         cbtienda.setModel(modelo);
         AutoCompleteDecorator.decorate(cbtienda);
       //  cbtienda.setSelectedIndex(-1);
         cbtienda.setSelectedItem(tiendalocal);
         
         
         
         
         
          if (tiendalocal.equals("cdmxcentro")) {
           file = new File("C:\\sistema\\cdmxcentro.txt");
       } else if (tiendalocal.equals("cdmxsur")) {
           file = new File("C:\\sistema\\cdmxsur.txt");
       } else if (tiendalocal.equals("guadalajara")) {
           file = new File("C:\\sistema\\guadalajara.txt");
       } else if (tiendalocal.equals("monterrey")) {
           file = new File("C:\\sistema\\monterrey.txt");
       } else if (tiendalocal.equals("tijuana")) {
           file = new File("C:\\sistema\\tijuana.txt");
       }
       
         
          try {
           Scanner sc = new Scanner(file);
           if (sc.hasNext()) 
           {
               String line = sc.nextLine();
               String str[] = line.split(":");
               iplocal = str[0];
              
               

           }
         
         } catch (IOException e) {
           System.out.println(e);
       }
         
         
         
         
    
        pingtienda(); 
     
     
     


    }
    


    void pingtienda()
    {
        Object tienda = cbtienda.getSelectedItem();
        InetAddress ping;

        if (tienda == null) {
        } else {
            try {
                lbtiendaconectada.setText("");
                ping = InetAddress.getByName(iplocal);
                if (ping.isReachable(5000)) 
                {
                    lbtiendaconectada.setText("Tienda conectada");
                    lbtiendaconectada.setBackground(Color.GREEN);
                    btnentrar.setEnabled(true);
                    
                    
                  
                     System.out.println(iplocal);
                    
                    
                    
                    
                    
                    
                }
                else 
                {
                    lbtiendaconectada.setText("Error al conectar con tienda");
                    lbtiendaconectada.setBackground(Color.red);
                    btnentrar.setEnabled(false);

                }
            } catch (IOException ex) {
                System.out.println(ex);
            }

        }
    }
    
    
            
    
    
 
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbtienda = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btnentrar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        lbtiendaconectada = new javax.swing.JLabel();
        lbip = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Ingreso tienda Sistema Bordadores");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        cbtienda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        cbtienda.setToolTipText("");
        cbtienda.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                cbtiendaPopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbtiendaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbtiendaPopupMenuWillBecomeVisible(evt);
            }
        });
        cbtienda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtiendaActionPerformed(evt);
            }
        });
        cbtienda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbtiendaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                cbtiendaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                cbtiendaKeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Tienda: ");

        btnentrar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnentrar.setText("Entrar");
        btnentrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentrarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbtiendaconectada.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtiendaconectada.setForeground(new java.awt.Color(0, 153, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lbip, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbtienda, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbtiendaconectada, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(26, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbip, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cbtienda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addComponent(lbtiendaconectada, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                        .addComponent(btnentrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30))
        );

        setSize(new java.awt.Dimension(531, 235));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
ventanaingresotienda=false;
this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void cbtiendaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbtiendaKeyTyped

    }//GEN-LAST:event_cbtiendaKeyTyped

    private void cbtiendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbtiendaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtiendaKeyReleased

    private void cbtiendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbtiendaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtiendaKeyPressed

    private void cbtiendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtiendaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtiendaActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        ventanaingresotienda=false;
        System.exit(0);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnentrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentrarActionPerformed

        Object tienda = cbtienda.getSelectedItem();
        
        if (tienda.equals("Seleccione tienda") || tienda == null || tienda.equals("") || tienda.equals(" "))
        {
          JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Seleccione una tienda");
        }
        else
        {
            
      

        principal ventana = new principal();
       
        ventana.setVisible(true);
      //  ventan.setLocationRelativeTo(null);
       
        principal.lbtiendalocal.setText(tiendalocal);
        principal.lbiplocal.setText(iplocal);
   
        ventana.setTitle("Sistema bordadores "+tiendalocal.toUpperCase()+"");     
        this.dispose();

        }
        
        
        
    }//GEN-LAST:event_btnentrarActionPerformed

    private void cbtiendaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbtiendaPopupMenuWillBecomeInvisible

        
        
   Object tiendaseleccionada = cbtienda.getSelectedItem();
   File file =null;
  
   
    if (tiendaseleccionada.equals("Seleccione tienda") || tiendaseleccionada == null || tiendaseleccionada.equals("") || tiendaseleccionada.equals(" "))
    {
          JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">Seleccione una tienda");
    }
   else
   {    
   
       
   
       if (tiendaseleccionada.equals("cdmxcentro")) {
           file = new File("C:\\sistema\\cdmxcentro.txt");
       } else if (tiendaseleccionada.equals("cdmxsur")) {
           file = new File("C:\\sistema\\cdmxsur.txt");
       } else if (tiendaseleccionada.equals("guadalajara")) {
           file = new File("C:\\sistema\\guadalajara.txt");
       } else if (tiendaseleccionada.equals("monterrey")) {
           file = new File("C:\\sistema\\monterrey.txt");
       } else if (tiendaseleccionada.equals("tijuana")) {
           file = new File("C:\\sistema\\tijuana.txt");
       }
       
 
       try {
           Scanner sc = new Scanner(file);
           while (sc.hasNext()) 
           {
               String line = sc.nextLine();
               String str[] = line.split(":");
               iplocal = str[0];
             
               

           }

       } catch (IOException e) {
           System.out.println(e);
       }


       
        pingtienda(); 
       
   }
    
    
    
    }//GEN-LAST:event_cbtiendaPopupMenuWillBecomeInvisible

    private void cbtiendaPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbtiendaPopupMenuWillBecomeVisible
    lbtiendaconectada.setText("");      
    }//GEN-LAST:event_cbtiendaPopupMenuWillBecomeVisible

    private void cbtiendaPopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbtiendaPopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_cbtiendaPopupMenuCanceled
 
   
   
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
              
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ingresotienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ingresotienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ingresotienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ingresotienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new ingresotienda().setVisible(true);
                
            }
            
        });
        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnentrar;
    public static javax.swing.JButton btnsalir;
    public static javax.swing.JComboBox cbtienda;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel lbip;
    private javax.swing.JLabel lbtiendaconectada;
    // End of variables declaration//GEN-END:variables


}
