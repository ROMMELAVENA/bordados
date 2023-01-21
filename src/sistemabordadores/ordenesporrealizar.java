package sistemabordadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ordenesporrealizar extends javax.swing.JFrame {

    public static boolean ventanaordenesbordadogenerada = false;
    String fechainicial = "";
    String fechafinal = "";
    String nombrecliente = "";

    public ordenesporrealizar() {
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
        
        
        
        
        limpiartabla();

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       

        String[] datos = new String[10];
        String[] datos2 = new String[10];
        String[] datos3 = new String[10];
        String[] datos4 = new String[10];
        String[] datos5 = new String[10];
        String[] datos6 = new String[10];
        String[] datos7 = new String[10];

        //// historial_orden_camisa
        
        String sqlcamisa = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  "
                         + "FROM historial_ordenes_camisa where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') "
                         + "and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"'  ";

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
        
        String sqlgorra = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_gorra where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

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

                modelo.addRow(datos2);

            }

           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"sql orden gorra" +  ex);
        }
        
        //// historial_orden_pantalon
        
         String sqlpantalon = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_pantalon where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

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

                modelo.addRow(datos3);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden pantalon" + ex);
        }
        
        
        //// historial_orden_parches
        
        String sqlparches = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_parche where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

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

                modelo.addRow(datos4);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden parche" + ex);
        }
        
         //// historial_orden_ponchado
        
        String sqlponchados = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_ponchados where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

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

                modelo.addRow(datos5);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden ponchado" + ex);
        }
        
        /// historial ordenes corbata
        
        String sqlcorbata= "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_corbata where (lugar = 'Esta sucursal' OR lugar = 'Otra sucursal') and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcorbata);
            while (rs.next()) {
                datos6[0] = rs.getString("numero");
                datos6[1] = rs.getString("cliente");
                datos6[2] = "Corbata";
                datos6[3] = rs.getString("tipo");
                datos6[4] = rs.getString("lugar");
                datos6[5] = rs.getString("numero_venta");
                datos6[6] = rs.getString("fecha");

                modelo.addRow(datos6);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden corbata" + ex);
        }
        
        /// historial orden portanombres
        
        String sqlportanombre= "SELECT Distinct numero,tipo,numero_venta,fecha  FROM historial_ordenes_portanombres where (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlportanombre);
            while (rs.next()) 
            {
                String numeroventa = rs.getString("numero_venta");
                nombredelcliente((String) numeroventa);
                datos6[0] = rs.getString("numero");
                datos6[1] = nombrecliente;
                datos6[2] = "Porta nombre";
                datos6[3] = rs.getString("tipo");
                datos6[4] = "Esta sucursal";
                datos6[5] = rs.getString("numero_venta");
                datos6[6] = rs.getString("fecha");

                modelo.addRow(datos6);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden corbata" + ex);
        }


        /// historial´ portanombre multiple

         String sqlportanombremultiple= "SELECT Distinct numero,tipo,numero_venta,fecha  FROM historial_ordenes_portanombres_multiple where (estatus_orden = 'generada' or estatus_orden = 'solicitada' ) and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlportanombremultiple);
            while (rs.next()) 
            {
                String numeroventa = rs.getString("numero_venta");
                nombredelcliente((String) numeroventa);
                datos6[0] = rs.getString("numero");
                datos6[1] = nombrecliente;
                datos6[2] = "Porta nombre multiple";
                datos6[3] = rs.getString("tipo");
                datos6[4] = "Esta sucursal";
                datos6[5] = rs.getString("numero_venta");
                datos6[6] = rs.getString("fecha");

                modelo.addRow(datos6);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden portanombremultiple" + ex);
        }        
        
        
        
        
        
        // ORDENES DE OTRAS SUCURSALES
        //////////////////////////////
        /////////////////////////////
        
        
        
        //CAMISA
        
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
        
        
        
        // GORRA
        
        
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

        
        
        
        /// PANTALON
        
        
        
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
        
        
        
        
        
        
        
        
        
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabla.getModel());
        tabla.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(100);
        sortKeys.add(new RowSorter.SortKey(5, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        
        
    }
    
     void nombredelcliente(String numeroventa)
    {
        
        String sql1 = "SELECT nombre_cliente from historial_Ventas where numero = '"+numeroventa+"' ";

                    try {
                        PreparedStatement prst = cn.prepareStatement(sql1);
                        ResultSet rs2 = prst.executeQuery();
                        if (rs2.next()) 
                        {
                            nombrecliente = rs2.getString("nombre_cliente");
                           
                            
                        }
                        rs2.close();
                    } catch (Exception exx) {
                        JOptionPane.showMessageDialog(null, exx);

                    }
                
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
        btnfrente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordenes bordado por realizar");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
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
        tabla.setRowHeight(32);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(1).setMinWidth(100);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(600);
            tabla.getColumnModel().getColumn(1).setMaxWidth(800);
            tabla.getColumnModel().getColumn(4).setMinWidth(0);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(4).setMaxWidth(0);
            tabla.getColumnModel().getColumn(5).setMinWidth(0);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(5).setMaxWidth(0);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbinterface, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btnactualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbtienda, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1380, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnumero)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbinterface)
                    .addComponent(btnfrente)
                    .addComponent(btnactualizar)
                    .addComponent(lbtienda))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        ventanaordenesbordadogenerada = false;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        if (evt.getClickCount() == 2) {

            int fila = tabla.getSelectedRow();

            if (fila >= 0) 
            {

                Object tipo = tabla.getValueAt(fila, 3).toString();

                if (tipo.equals("Orden camisa")||tipo.equals("Orden Camisa")) {
                    if (ordencamisa.ventanaordencamisaanteriores == true) {
                        
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de camisa anteriores");

                    } else {
                        ordencamisa orden = new ordencamisa();
                        orden.setVisible(true);

                        ordencamisa.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                        ordencamisa.lbnumeroventa.setText(tabla.getValueAt(fila, 5).toString());
                        ordencamisa.lbprenda.setText(tabla.getValueAt(fila, 2).toString());
                        ordencamisa.lbtipo.setText(tabla.getValueAt(fila, 3).toString());
                        tabla.clearSelection();
                        this.setState(this.ICONIFIED);
                       
                    }

                
                } 
                else if (tipo.equals("Orden gorra")||tipo.equals("Orden Gorra")) 
                {
                    if (ordengorra.ventanaordengorraanteriores == true) {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de camisa anteriores");

                    } else {
                        ordengorra orden = new ordengorra();
                        orden.setVisible(true);

                        ordengorra.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                        ordengorra.lbnumeroventa.setText(tabla.getValueAt(fila, 5).toString());
                        ordengorra.lbprenda.setText(tabla.getValueAt(fila, 2).toString());
                        ordengorra.lbtipo.setText(tabla.getValueAt(fila, 3).toString());
                         tabla.clearSelection();
                         this.setState(this.ICONIFIED);
                        
                    }
                }
                else if (tipo.equals("Orden ponchado")) 
                {
                    if (ordenponchado.ventanaordenparcheanteriores == true) {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de ponchado anteriores");

                    } else {
                        ordenponchado orden = new ordenponchado();
                        orden.setVisible(true);

                        ordenponchado.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                        ordenponchado.lbnumeroventa.setText(tabla.getValueAt(fila, 5).toString());
                         tabla.clearSelection();
                         this.setState(this.ICONIFIED);
                        
                    }
                }
                else if (tipo.equals("Orden parche")) 
                {
                    if (ordenparche.ventanaordenparcheanteriores == true) {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de ponchado anteriores");

                    } else {
                        ordenparche orden = new ordenparche();
                        orden.setVisible(true);

                        ordenparche.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                         tabla.clearSelection();
                         this.setState(this.ICONIFIED);
                        
                    }
                }
                else if (tipo.equals("Orden corbata")) 
                {
                   
                        
                        if (ordencorbata.ventanaordencorbataanteriores == true) {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de corbata anteriores");

                    } else {
                        ordencorbata orden = new ordencorbata();
                        orden.setVisible(true);

                        ordencorbata.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                        ordencorbata.lbnumeroventa.setText(tabla.getValueAt(fila, 5).toString());
                        
                         tabla.clearSelection();
                         this.setState(this.ICONIFIED);
                        
                    }
                        
                 
                   
                }
                else if (tipo.equals("Porta nombre escolar")) 
                {
                   
                        
                        if (ordenportanombremultiple.ventanaordenportanombremultipleanterior == true) {
                        JOptionPane.showMessageDialog(null, "Favor de cerrar la ventana de orden de portanombre");

                    } else {
                            ordenportanombreescolar orden = new ordenportanombreescolar();
                            orden.setVisible(true);
                            ordenportanombreescolar.lbnumero.setText(tabla.getValueAt(fila, 0).toString());
                            tabla.clearSelection();
                            this.setState(this.ICONIFIED);
                        
                    }
                        
                 
                   
                }
                
                
                

            } /// 

        } 


       
        
    }//GEN-LAST:event_tablaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordenesbordadogenerada = false;
    }//GEN-LAST:event_formWindowClosing

    private void btnactualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnactualizarActionPerformed
       limpiartabla();
      
       datos();
    }//GEN-LAST:event_btnactualizarActionPerformed

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
            java.util.logging.Logger.getLogger(ordenesporrealizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordenesporrealizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordenesporrealizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordenesporrealizar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ordenesporrealizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnactualizar;
    public static javax.swing.JButton btnfrente;
    private javax.swing.JButton btnsalir;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbinterface;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbtienda;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
connectar cc = new connectar();
Connection cn = cc.conexion();

}
