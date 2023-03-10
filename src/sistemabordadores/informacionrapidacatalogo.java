
package sistemabordadores;

import java.awt.Dimension;
import static java.awt.Event.DELETE;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import static java.awt.event.KeyEvent.VK_F5;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;


public class informacionrapidacatalogo extends javax.swing.JFrame {
public static boolean ventanainformacionrapidacatalogo=false;
   
    public informacionrapidacatalogo() {
        initComponents();
        setVisible(true);
        TableFilterHeader filterHeader = new TableFilterHeader(tabla, AutoChoices.DISABLED);
        mostrarcolumnas();
        datos();
             
        ventanainformacionrapidacatalogo=true;
        btnmaximizar.setVisible(false);
        btndatos.setVisible(false);
                
          btneliminar.setEnabled(false);        
      
    }
    
    void mostrarcolumnas() {

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("codigo");//0
        modelo.addColumn("Descripcion");//1
        modelo.addColumn("Area");//2
        modelo.addColumn("detalle");//3
        modelo.addColumn("Extension");//4
        
         

        tabla.setModel(modelo);
        
        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        tabla.getColumnModel().getColumn(0).setWidth(0);
        
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(3).setWidth(0);
        
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(4).setWidth(0);
        
       
        

    }
    
    void datos(){

        limpiartabla();
        DefaultTableModel modelo=  (DefaultTableModel) tabla.getModel();
        String sql = "";
        
        
        Object area = cbarea.getSelectedItem();
        
        if (area.equals("Todas la areas excepto informacion que solicita el cliente"))
        {
            
            sql="SELECT codigo,descripcion,area,detalle,extension_archivo FROM catalogo_informacion_rapida WHERE area not in('Informaci�n que solicita el cliente')ORDER BY descripcion";
            
        }
        else
        {
            
            if (area.equals("Todas las areas"))
        {
            
            sql="SELECT codigo,descripcion,area,detalle,extension_archivo FROM catalogo_informacion_rapida ORDER BY descripcion";
            
        }
        else
        {
            
            
            
            
            
            sql="SELECT codigo,descripcion,area,detalle,extension_archivo FROM catalogo_informacion_rapida where area = '"+area+"'ORDER BY descripcion";
            
        }
        }     
     
         String []datos = new String [5];
     
         try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
            
                datos[0]=rs.getString("codigo");
                datos[1]=rs.getString("descripcion");
                datos[2]=rs.getString("area");
                datos[3]=rs.getString("detalle");
                datos[4]=rs.getString("extension_archivo");
           
                
                modelo.addRow(datos);
         
            
            }
            tabla.setModel(modelo);
        } catch (SQLException ex) {
            Logger.getLogger(informacionrapidacatalogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
 
      void limpiartabla() 
      {
          
        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int filas = tabla.getRowCount();
            for (int i = 0; filas > i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
       
             JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al limpiar la tabla");
        }
    
      
      }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog = new javax.swing.JDialog();
        ubic = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        menu = new javax.swing.JPopupMenu();
        btnagregar = new javax.swing.JButton();
        btneliminar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false; //Disallow the editing of any cell
            }
        };
        btndatos = new javax.swing.JButton();
        btnmaximizar = new javax.swing.JButton();
        cbarea = new javax.swing.JComboBox<>();

        ubic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubicActionPerformed(evt);
            }
        });

        jButton4.setText("Guardar en ../ Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(204, 0, 0));
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogLayout = new javax.swing.GroupLayout(jDialog.getContentPane());
        jDialog.getContentPane().setLayout(jDialogLayout);
        jDialogLayout.setHorizontalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(ubic, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton4)
                .addGap(19, 19, 19))
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel16))
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogLayout.setVerticalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Informacion rapida catalogo");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnagregar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnagregar.setText("Agregar");
        btnagregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarActionPerformed(evt);
            }
        });

        btneliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminar.setText("Eliminar");
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        tabla.setAutoCreateRowSorter(true);
        tabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Descripcion", "Area", "Detalle", "Extension"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setComponentPopupMenu(menu);
        tabla.setRowHeight(28);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(200);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(0).setMaxWidth(200);
            tabla.getColumnModel().getColumn(1).setMinWidth(10);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(700);
            tabla.getColumnModel().getColumn(1).setMaxWidth(1200);
            tabla.getColumnModel().getColumn(3).setMinWidth(0);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            tabla.getColumnModel().getColumn(4).setMinWidth(0);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        btndatos.setText("datos");
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
            }
        });

        btnmaximizar.setText("maximizar");
        btnmaximizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmaximizarActionPerformed(evt);
            }
        });

        cbarea.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        cbarea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todas la areas excepto informacion que solicita el cliente", "Todas las areas", "Capacitacion", "Formatos", "Información interna", "Información que solicita el cliente", "Labor de venta", "Ventas", "Respuestas rápidas", " ", " " }));
        cbarea.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbareaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
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
                        .addComponent(btnmaximizar)
                        .addGap(18, 18, 18)
                        .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1720, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbarea, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnagregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbarea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnmaximizar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
ventanainformacionrapidacatalogo=false;
        this.dispose();  
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnagregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarActionPerformed

        if (informacionrapidaeditar.ventanainformacionrapida == true) 
        {

        }
        else 
        {

            informacionrapidaeditar ventana = new informacionrapidaeditar();
            ventana.setVisible(true);

        }
         
    
    }//GEN-LAST:event_btnagregarActionPerformed

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed

        
        
        int resp=JOptionPane.showConfirmDialog(null,"<HTML><b style=\"Color:red; font-size:20px;\">Estas Seguro De Querer Eliminar La informacion  r�pida ?");
      if (JOptionPane.OK_OPTION == resp){
     
          
          int row = tabla.getSelectedRow();
     
        
        Object codigo=tabla.getValueAt(row, 0);
    
    try {
        PreparedStatement pst = cn.prepareStatement("DELETE FROM catalogo_informacion_rapida WHERE codigo='"+codigo+"'");
        pst.executeUpdate();
   
      
        
        datos();
        
        
    } catch (Exception e) {
    }   
 }
     
    }//GEN-LAST:event_btneliminarActionPerformed

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
int condition = JComponent.WHEN_FOCUSED;
  InputMap inputMap = tabla.getInputMap(condition);
  ActionMap actionMap = tabla.getActionMap();

  inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, 0), DELETE);
  actionMap.put(DELETE, new AbstractAction() {
     public void actionPerformed(ActionEvent e) {
      
         
         
         
         int resp=JOptionPane.showConfirmDialog(null,"<HTML><b style=\"Color:red; font-size:20px;\">Estas Seguro De Querer Eliminar La informacion  r�pida?");
      if (JOptionPane.OK_OPTION == resp){
        int row = tabla.getSelectedRow();
        String codigo="";
     codigo=tabla.getValueAt(row, 0).toString();
    
    try {
        PreparedStatement pst = cn.prepareStatement("DELETE FROM catalogo_informacion_rapida WHERE codigo='"+codigo+"'");
        pst.executeUpdate();
        
        limpiartabla();
        
        
        datos();
    } catch (Exception ex) {
    }   
 }

}
  });    
  

        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0), VK_F5);
  actionMap.put(VK_F5, new AbstractAction() {
     public void actionPerformed(ActionEvent e) {
      
         limpiartabla();
         datos();
          }  
  });
    }//GEN-LAST:event_tablaKeyPressed

    private void ubicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ubicActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:

        JFileChooser dialog = new JFileChooser();
        int opcion = dialog.showSaveDialog(this);

        if(opcion == JFileChooser.APPROVE_OPTION){

            File dir = dialog.getSelectedFile();
            String fl = dir.toString();

            ubic.setText(fl);
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
     
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        
        btneliminar.setEnabled(true);
        
        
        
        if (evt.getClickCount() == 2) 
        { 
            
           
            int filaseleccionada = tabla.getSelectedRow();
            
            
           if (informacionrapidaeditar.ventanainformacionrapida==true)
           {
               
        
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La ventana de informacion r�pida editar ya est� abierta");
               
           }
           else
           {
            
         
                Object nombreobject =tabla.getValueAt(filaseleccionada, 1);
                
                informacionrapidaeditar ventana = new informacionrapidaeditar();
                ventana.setVisible(true);

                informacionrapidaeditar.txtdescripcion.setText(nombreobject.toString());
                ventana.datos();

           }

        }
        
        
      
    }//GEN-LAST:event_tablaMouseClicked

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel(); 
        limpiartabla();
        mostrarcolumnas();
        datos();       
    }//GEN-LAST:event_btndatosActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
ventanainformacionrapidacatalogo=false;
this.dispose();
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void btnmaximizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmaximizarActionPerformed
  this.toFront();        // TODO add your handling code here:
    }//GEN-LAST:event_btnmaximizarActionPerformed

    private void cbareaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbareaPopupMenuWillBecomeInvisible
      
        datos();
        
    }//GEN-LAST:event_cbareaPopupMenuWillBecomeInvisible

    
    public static void main(String args[]) {

       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
             
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(informacionrapidacatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(informacionrapidacatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(informacionrapidacatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(informacionrapidacatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
          
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informacionrapidacatalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregar;
    public static javax.swing.JButton btndatos;
    private javax.swing.JButton btneliminar;
    public static javax.swing.JButton btnmaximizar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JComboBox<String> cbarea;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JDialog jDialog;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu menu;
    public static javax.swing.JTable tabla;
    private javax.swing.JTextField ubic;
    // End of variables declaration//GEN-END:variables
    connectar cc= new connectar();
    Connection cn= cc.conexion();

}
