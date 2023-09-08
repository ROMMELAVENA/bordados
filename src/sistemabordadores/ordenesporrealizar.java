package sistemabordadores;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;

public class ordenesporrealizar extends javax.swing.JFrame {

    public static boolean ventanaordenesporrealizar = false;
    String fechainicial = "";
    String fechafinal = "";
    String nombrecliente = "";
   
    String tiendalocal = principal.tiendalocal;
    String fotomontajeautorizado = "";
    
    public static String localuotrasucursal ="";
   
    Object sucursal = "";

    public ordenesporrealizar() {
        initComponents();
        ventanaordenesporrealizar = true;
       
        
        lbinterface.setVisible(false);
        lbtienda.setVisible(false);
        btndatos.setVisible(false);
        btnfrente.setVisible(false);
        
        TableFilterHeader filterHeader = new TableFilterHeader(tabla, AutoChoices.ENABLED);
        
       
          
 
        

    }
    
    
    
    
    
    
    
    
  
    void datos() {
        
        
        limpiartabla();

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        String donde = "";
        
        
        
        
        
        String[] datos = new String[16];
        
        
        
        
        
       if (localuotrasucursal.equals("Otra Sucursal"))
       {
           donde = "Otra Sucursal";
       }
       else
       {
           donde = "Esta sucursal";
       }
      
        
        //// historial_orden_camisa
        
        String sqlcamisa = "SELECT numero,borda_cliente,prenda,tipo,lugar,numero_venta,fecha,tienda,identificador_prenda,observacion,cantidad,cliente FROM historial_ordenes_camisa where lugar = '"+donde+"' and (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'realizada parcialmente') order by fecha desc  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcamisa);
         
            
            while (rs.next()) {
                datos[0] = rs.getString("numero");
                datos[1] = rs.getString("borda_cliente");
                datos[2] = rs.getString("prenda");
                datos[3] = rs.getString("tipo");
                datos[4] = rs.getString("lugar");
                datos[5] = rs.getString("numero_venta");
                datos[6] = rs.getString("fecha");
                datos[7] = rs.getString("tienda");
                datos[8] = "";
                datos[9] = "";
                datos[10] = "Local";
                datos[11] = rs.getString("identificador_prenda");
                datos[12] = rs.getString("observacion");
                datos[13] = rs.getString("cantidad");
                datos[14] = rs.getString("cliente");

                modelo.addRow(datos);

            }

            

        } catch (SQLException ex) {
           
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }

        
        
        
        
        
        
        
        
        //// historial_orden_gorra
        
        String[] datos2 = new String[15];
        
        String sqlgorra = "SELECT numero,borda_cliente,prenda,tipo,lugar,numero_venta,fecha,tienda,identificador_prenda,observacion,cantidad,cliente  FROM historial_ordenes_gorra where lugar = '"+donde+"'  and (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'realizada parcialmente') order by fecha desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlgorra);
            while (rs.next()) {
                datos2[0] = rs.getString("numero");
                datos2[1] = rs.getString("borda_cliente");
                datos2[2] = rs.getString("prenda");
                datos2[3] = rs.getString("tipo");
                datos2[4] = rs.getString("lugar");
                datos2[5] = rs.getString("numero_venta");
                datos2[6] = rs.getString("fecha");
                datos2[7] = rs.getString("tienda");
                datos2[8] = "";
                datos2[9] = "";
                datos2[10] = "Local";
                datos2[11] = rs.getString("identificador_prenda");
                datos2[12] = rs.getString("observacion");
                datos2[13] = rs.getString("cantidad");
                datos2[14] = rs.getString("cliente");
                
                modelo.addRow(datos2);

            }

           

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        
        
        
        
        
        //// historial_orden_pantalon
        
        
        String[] datos3 = new String[15];
        
         String sqlpantalon = "SELECT numero,borda_cliente,prenda,tipo,lugar,numero_venta,fecha,tienda,identificador_prenda,observacion,cantidad,cliente  FROM historial_ordenes_pantalon where lugar = '"+donde+"' and (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'realizada parcialmente') order by fecha desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlpantalon);
            while (rs.next()) 
            {
                datos3[0] = rs.getString("numero");
                datos3[1] = rs.getString("borda_cliente");
                datos3[2] = rs.getString("prenda");
                datos3[3] = rs.getString("tipo");
                datos3[4] = rs.getString("lugar");
                datos3[5] = rs.getString("numero_venta");
                datos3[6] = rs.getString("fecha");
                datos3[7] = rs.getString("tienda");
                datos3[8] = "";
                datos3[9] = "";
                datos3[10] = "Local";
                datos3[11] = rs.getString("identificador_prenda");
                datos3[12] = rs.getString("observacion"); 
                datos3[13] = rs.getString("cantidad");
                datos3[14] = rs.getString("cliente");
                
                
                
                modelo.addRow(datos3);

            }

            

        } catch (SQLException ex)
        {
       
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        
        
        
         
           /// historial ordenes corbata
        
         String[] datos5 = new String[15];
        
        String sqlcorbata= "SELECT Distinct numero,borda_cliente,tipo,lugar,numero_venta,fecha,tienda,identificador_prenda,observacion,cantidad,cliente  FROM historial_ordenes_corbata where lugar = '"+donde+"'  and (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'realizada parcialmente') order by fecha desc ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcorbata);
            while (rs.next()) {
                datos5[0] = rs.getString("numero");
                datos5[1] = rs.getString("borda_cliente");
                datos5[2] = "Corbata";
                datos5[3] = rs.getString("tipo");
                datos5[4] = rs.getString("lugar");
                datos5[5] = rs.getString("numero_venta");
                datos5[6] = rs.getString("fecha");
                datos5[7] = rs.getString("tienda");
                datos5[8] = "";
                datos5[9] = "";
                datos5[10] = "Local";
                datos5[11] = rs.getString("identificador_prenda");
                datos5[12] = rs.getString("observacion");
                datos5[13] = rs.getString("cantidad");
                datos5[14] = rs.getString("cliente");
                modelo.addRow(datos5);

            }

            

        } catch (SQLException ex)
        {
           
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }

         
        
        
        
        
        
        
        
        
        
        //// historial_orden_parches
        
        String[] datos4 = new String[15];
        
        String sqlparches = "SELECT Distinct numero,borda_cliente,tipo,lugar,numero_venta,fecha,tienda,identificador_prenda,observaciongeneral,cantidad,cliente  FROM historial_ordenes_parche where lugar = '"+donde+"'  and (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'realizada parcialmente') order by fecha desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlparches);
            while (rs.next()) {
                datos4[0] = rs.getString("numero");
                datos4[1] = rs.getString("borda_cliente");
                datos4[2] = "Parche";
                datos4[3] = rs.getString("tipo");
                datos4[4] = rs.getString("lugar");
                datos4[5] = rs.getString("numero_venta");
                datos4[6] = rs.getString("fecha");
                datos4[7] = rs.getString("tienda");
                datos4[8] = "";
                datos4[9] = "";
                datos4[10] = "Local";
                datos4[11] = rs.getString("identificador_prenda");
                datos4[12] = rs.getString("observaciongeneral");
                datos4[13] = rs.getString("cantidad");
                datos4[14] = rs.getString("cliente");
                modelo.addRow(datos4);

            }

            

        } catch (SQLException ex)
        {
           
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
      
        
        
        
        
        
        
        //// distinta
        
        
        
        
        String sqldistinta = "SELECT numero,borda_cliente,prenda,tipo,lugar,numero_venta,fecha,tienda,identificador_prenda,observacion,cantidad,cliente  "
                         + "FROM historial_ordenes_distinta where lugar = '"+donde+"' "
                         + "and (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'realizada parcialmente') order by fecha desc  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqldistinta);
            while (rs.next()) {
                datos[0] = rs.getString("numero");
                datos[1] = rs.getString("borda_cliente");
                datos[2] = "Distinta";
                datos[3] = rs.getString("tipo");
                datos[4] = rs.getString("lugar");
                datos[5] = rs.getString("numero_venta");
                datos[6] = rs.getString("fecha");
                datos[7] = rs.getString("tienda");
                datos[8] = "";
                datos[9] = "";
                datos[10] = "Local";
                datos[11] = rs.getString("identificador_prenda");
                datos[12] = rs.getString("observacion");
                datos[13] = rs.getString("cantidad");
                datos[14] = rs.getString("cliente");

                modelo.addRow(datos);

            }

            

        } catch (SQLException ex) {
          
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        
        
        
            
         //// historial_orden_ponchado
         
         
         
         
        String[] datos9 = new String[15];
        String sqlponchados = "SELECT Distinct numero,borda_cliente,tipo,lugar,numero_venta,fecha,tienda,observaciones,cliente  FROM historial_ordenes_ponchados where lugar = '"+donde+"'  and (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'realizada parcialmente') order by fecha desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlponchados);
            while (rs.next()) {
                datos9[0] = rs.getString("numero");
                datos9[1] = rs.getString("borda_cliente");
                datos9[2] = "Muestra";
                datos9[3] = rs.getString("tipo");
                datos9[4] = rs.getString("lugar");
                datos9[5] = rs.getString("numero_venta");
                datos9[6] = rs.getString("fecha");
                datos9[7] = rs.getString("tienda");
                datos9[8] = "";
                datos9[9] = "";
                datos9[10] = "Local";
                datos9[11] = "Muestra";
                datos9[12] = rs.getString("observaciones");
                datos9[13] = "1";
                datos9[14] = rs.getString("cliente");
                
                modelo.addRow(datos9);

            }

            

        } catch (SQLException ex)
        {
          
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
         
       
        
              
        /// historial orden portanombres
        
        String[] datos7 = new String[15];
        
        String sqlportanombre= "SELECT Distinct numero,tipo,numero_venta,fecha,observacion,nombre_renglon1,nombre_renglon2,nombre_renglon3,cantidad,cliente  FROM historial_ordenes_portanombres where (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'realizada parcialmente') order by fecha desc ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlportanombre);
            while (rs.next()) 
            {
                String numeroventa = rs.getString("numero_venta");
                String nombre = rs.getString("nombre_renglon1");
                String nombre2 = rs.getString("nombre_renglon2");
                String nombre3 = rs.getString("nombre_renglon3");
                
                nombre = "Portanombre".concat(" ").concat(nombre).concat(" ").concat(nombre2).concat(" ").concat(nombre3);
                nombredelcliente((String) numeroventa);
                
                
                datos7[0] = rs.getString("numero");
                datos7[1] = nombrecliente;
                datos7[2] = "Porta nombre";
                datos7[3] = rs.getString("tipo");
                datos7[4] = "Esta sucursal";
                datos7[5] = rs.getString("numero_venta");
                datos7[6] = rs.getString("fecha");
                datos7[7] = "";
                datos7[8] = "";
                datos7[9] = "";
                datos7[10] = "Local";
                datos7[11] = nombre;
                datos7[12] = rs.getString("observacion");
                datos7[13] = rs.getString("cantidad");
                datos7[14] = rs.getString("cliente");

                modelo.addRow(datos7);

            }

            

        } catch (SQLException ex)
        {
          
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }


        /// historial´ portanombre multiple
        
        String[] datos8 = new String[15];

         String sqlportanombremultiple= "SELECT Distinct numero,tipo,numero_venta,fecha,observacion,cantidad,cliente  FROM historial_ordenes_portanombres_multiple where (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'realizada parcialmente') order by fecha desc ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlportanombremultiple);
            while (rs.next()) 
            {
                String numeroventa = rs.getString("numero_venta");
                nombredelcliente((String) numeroventa);
                
                
                datos8[0] = rs.getString("numero");
                datos8[1] = nombrecliente;
                datos8[2] = "Porta nombre multiple";
                datos8[3] = rs.getString("tipo");
                datos8[4] = "Esta sucursal";
                datos8[5] = rs.getString("numero_venta");
                datos8[6] = rs.getString("fecha");
                datos8[7] = "";
                datos8[8] = "";
                datos8[9] = "";
                datos8[10] = "Local";
                datos8[11] = "Porta nombre";
                datos8[12] = rs.getString("observacion"); 
                datos8[13] = rs.getString("cantidad");
                datos8[14] = rs.getString("cliente");
                modelo.addRow(datos8);

            }

            

        } catch (SQLException ex)
        {
           
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }        
     
        
        
        
        //// historial ordenes internas
        
        String sql5 = "Select Distinct numero,tipo,fecha,cantidad,prenda,descripcion,hora from historial_ordenes_bordados_interno where (estatus_entrega = 'solicitada' OR estatus_entrega = 'realizada parcialmente') group by numero order by fecha desc ";

        try {
            Statement st5 = cn.createStatement();
            ResultSet rs5 = st5.executeQuery(sql5);

            while (rs5.next()) 
            {

                String fecha = rs5.getString("fecha");
                String cliente = "Orden bordado interno";
                String cantidad = rs5.getString("cantidad");
                String tipo = rs5.getString("tipo");
                String prenda = rs5.getString("prenda");
                String descripcion = rs5.getString("descripcion");


               
                datos[0] = rs5.getString("numero");
                datos[1] = cliente;
                datos[2] = "Orden bordado interno";
                datos[3] = tipo;
                datos[4] = "Local";
                datos[5] = "ninguno";
                datos[6] = fecha;
                datos[7] = "";
                datos[8] = "";
                datos[9] = "";
                datos[10] = "Local";
                datos[11] = rs5.getString("descripcion");
                datos[12] = "";
                datos[14] = "Orden bordado interno";
                
           
                
                 modelo.addRow(datos);
                

                

            }

           
        } catch (SQLException ex) {
        
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        
        
        ////
        
           
        
      
        
        
        

        
        
        // ORDENES DE OTRAS SUCURSALES
        //////////////////////////////
        /////////////////////////////
        
        
        
        
        
        
        
        
        //CAMISA
        
        
        String[] datos10 = new String[15];
        String sucursalsolicita = "";
        String numerosucursal = "";
       

        String sql3 = "SELECT numero,numero_orden_camisa_solicitada,borda_cliente,prenda,tipo,tienda,fecha,lugar,observacion,identificador_prenda,cantidad,cliente  FROM historial_ordenes_camisa_recibidas where (estatus_orden = 'generada' or estatus_orden = 'realizada parcialmente') order by fecha desc "; //and tienda not in('"+tiendalocal+"')

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql3);
            while (rs.next()) {
             
                
                sucursalsolicita = rs.getString("tienda");
                
                
                datos10[0] = rs.getString("numero");
                
              
                
                
                datos10[1] = rs.getString("borda_cliente");
                datos10[2] = rs.getString("prenda");
                datos10[3] = rs.getString("tipo");
                datos10[4] = rs.getString("lugar");
                datos10[5] = "00000000";
                datos10[6] = rs.getString("fecha");
                datos10[7] = rs.getString("tienda");
                
                numerosucursal = rs.getString("numero_orden_camisa_solicitada");
                datos10[8] = numerosucursal;
             
                datos10[9] = "";
                datos10[10] = "Recibida";
                datos10[11] = rs.getString("identificador_prenda");
                datos10[12] = rs.getString("observacion");
                datos10[13] = rs.getString("cantidad");
                datos10[14] = rs.getString("cliente");
                
              

                modelo.addRow(datos10);

            }

            

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
     
        
        
        
        
        
        
        // GORRA
        
        String[] datos11 = new String[15];

        String sql4 = "SELECT numero,numero_orden_gorra_solicitada,cliente,prenda,tipo,borda_cliente,tienda,lugar,fecha,numero_orden_o_pedido_solicitada,observacion,identificador_prenda,cantidad,cliente FROM historial_ordenes_gorra_recibidas  where (estatus_orden = 'generada' or estatus_orden = 'realizada parcialmente') order by fecha desc  ";

        try {
            Statement st2 = cn.createStatement();
            ResultSet rs = st2.executeQuery(sql4);
            while (rs.next()) 
            {
                datos11[0] = rs.getString("numero");
                datos11[1] = rs.getString("borda_cliente");
                datos11[2] = rs.getString("prenda");
                datos11[3] = rs.getString("tipo");
                datos11[4] = rs.getString("lugar");
                datos11[5] = "0000000";  
                datos11[6] = rs.getString("fecha");
                datos11[7] = rs.getString("tienda");
                datos11[8] = rs.getString("numero_orden_o_pedido_solicitada");
                datos11[9] = "";
                datos11[10] = "Recibida";
                datos11[11] = rs.getString("identificador_prenda");
                datos11[12] = rs.getString("observacion");
                datos11[13] = rs.getString("cantidad");
                datos11[14] = rs.getString("cliente");

                modelo.addRow(datos11);

            }


        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        tieneponchados();

        
        
        
        
        
        
        
        /// PANTALON
        
        String[] datos12 = new String[15];

        String sql15 = "SELECT numero,numero_orden_pantalon_solicitada,cliente,prenda,tipo,borda_cliente,tienda,lugar,fecha,numero_orden_o_pedido_solicitada,observacion,identificador_prenda,cantidad,cliente  FROM historial_ordenes_pantalon_recibidas where (estatus_orden = 'generada' or estatus_orden = 'realizada parcialmente') order by fecha desc  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql15);
            while (rs.next()) {
                datos12[0] = rs.getString("numero");
                datos12[1] = rs.getString("borda_cliente");
                datos12[2] = rs.getString("prenda");
                datos12[3] = rs.getString("tipo");
                datos12[4] = rs.getString("lugar");
                datos12[5] = "0000000";  
                datos12[6] = rs.getString("fecha");
                datos12[7] = rs.getString("tienda");
                datos12[8] = rs.getString("numero_orden_o_pedido_solicitada");
                datos12[9] = "";
                datos12[10] = "Recibida";
                datos12[11] = rs.getString("identificador_prenda");
                datos12[12] = rs.getString("observacion");
                datos12[13] = rs.getString("cantidad");
                datos12[14] = rs.getString("cliente");
            
                modelo.addRow(datos12);

            }

            

        } catch (SQLException ex) {
         JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        
        
        
        
        
        
        
        
        
        //// historial_orden_parches
        
        String[] datos42 = new String[15];
        
        String sqlparches2 = "SELECT Distinct numero,numero_orden_parche_solicitada,borda_cliente,prenda,tipo,cliente,tienda,lugar,fecha,numero_orden_o_pedido_solicitada,observacion,identificador_prenda,cantidad,cliente  FROM historial_ordenes_parche_recibidas where (estatus_orden = 'generada' or estatus_orden = 'solicitada' or estatus_orden = 'realizada parcialmente') order by fecha desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlparches2);
      
            
            
            while (rs.next()) {
                datos42[0] = rs.getString("numero");
                datos42[1] = rs.getString("borda_cliente");
                datos42[2] = rs.getString("prenda");
                datos42[3] = rs.getString("tipo");
                datos42[4] = rs.getString("lugar");
                datos42[5] = "0000000";  
                datos42[6] = rs.getString("fecha");
                datos42[7] = rs.getString("tienda");
                datos42[8] = rs.getString("numero_orden_o_pedido_solicitada");
                datos42[9] = "";
                datos42[10] = "Recibida";
                datos42[11] = rs.getString("identificador_prenda");
                datos42[12] = rs.getString("observacion");
                datos42[13] = rs.getString("cantidad");
                datos42[14] = rs.getString("cliente");
             
                
                
                modelo.addRow(datos42);

            }

            

        } catch (SQLException ex)
        {
           
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
      
        
        
        
        
        
        
        // PONCHADOS
        
        tieneponchados();
        
        
        
        String sql16 = "SELECT Distinct numero,borda_cliente,tipo,lugar,numero_orden_ponchado_solicitada,fecha,observacion,cliente  FROM historial_ordenes_ponchados_recibidas where (estatus_orden = 'generada' or estatus_orden = 'realizada parcialmente') order by fecha desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql16);
            while (rs.next()) {
                datos9[0] = rs.getString("numero");
                datos9[1] = rs.getString("borda_cliente");
                datos9[2] = "Ponchado";
                datos9[3] = rs.getString("tipo");
                datos9[4] = "Otra sucursal";
                datos9[5] = rs.getString("numero_orden_ponchado_solicitada");
                datos9[6] = rs.getString("fecha");
                datos9[7] = "";
                datos9[8] = "";
                datos9[9] = "";
                datos9[10] = "Recibida";
                datos9[11] = "";
                datos9[12] = rs.getString("observacion");
                datos9[13] = "1";
                datos9[14] = rs.getString("cliente");
                
                modelo.addRow(datos9);

            }

            

        } catch (SQLException ex)
        {
          
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        

        
        Colorear ft = new Colorear();
        tabla.setDefaultRenderer(Object.class, ft);
        
        
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
                        
                        JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+exx+"");

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
                tabla.setValueAt("si", i,9);
            }
            else
            {
                tabla.setValueAt("no", i,9);
            }    

           

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        }
        
        
        
        
        
        
        
        
         for(int i =0; i < tabla.getRowCount();i++)
            
        {   
            
            
            Object tipogorra =  tabla.getValueAt(i, 3);
            Object numerogorra =  tabla.getValueAt(i, 0);
         
           //// sql gorra 
            
          String  sqlgorra  = "SELECT frente_ponchado,lado_izquierdo_ponchado,lado_derecho_ponchado,atras_ponchado  FROM historial_ordenes_gorra_recibidas where numero =  '"+numerogorra+"'  ";
           
              
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
                tabla.setValueAt("si", i,9);
            }
            else
            {
                tabla.setValueAt("no", i,9);
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
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+e+"");
        }
}
  /*
    
     void datoscombos()
     {
         
         
          
             if(localuotrasucursal.equals("Local"))
        {
           datos(); 
           
           
           
                   
          TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
tabla.setRowSorter(sorter);
List<RowSorter.SortKey> sortKeys = new ArrayList<>();
 
int columnIndexToSort = 6;
sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
 
sorter.setSortKeys(sortKeys);
sorter.sort();

        }
        else
        {
           datos2(); 
        }  
         
     }
             */
    
     void autorizaciondelfotomontaje(String numerofolio,String nombre_tabla)
     {
         String sql = "SELECT fotomontaje_autorizado FROM "+nombre_tabla+" where numero = '"+numerofolio+"' and estatus_orden not in('cancelada') ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) 
            {
               fotomontajeautorizado = rs.getString("fotomontaje_autorizado");
                
            }

            

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
        }
  
     }
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnsalir = new javax.swing.JButton();
        lbinterface = new javax.swing.JLabel();
        lbtienda = new javax.swing.JLabel();
        btndatos = new javax.swing.JButton();
        btnfrente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordenes por realizar o terminadas parcialmente");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        tabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "No. Orden", "borda cliente", "prenda", "tipo", "lugar", "No. de venta", "fecha", "Sucursal", "No. sucursal", "tiene ponchados", "tabla", "Identificador de prenda", "observacion", "Cantidad", "cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
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
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablaMouseEntered(evt);
            }
        });
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(50);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(0).setMaxWidth(150);
            tabla.getColumnModel().getColumn(1).setMinWidth(100);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(350);
            tabla.getColumnModel().getColumn(1).setMaxWidth(700);
            tabla.getColumnModel().getColumn(3).setMinWidth(0);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            tabla.getColumnModel().getColumn(5).setMinWidth(0);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(5).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setMinWidth(60);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(6).setMaxWidth(120);
            tabla.getColumnModel().getColumn(7).setMinWidth(50);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(120);
            tabla.getColumnModel().getColumn(7).setMaxWidth(180);
            tabla.getColumnModel().getColumn(8).setMinWidth(0);
            tabla.getColumnModel().getColumn(8).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(8).setMaxWidth(0);
            tabla.getColumnModel().getColumn(9).setMinWidth(100);
            tabla.getColumnModel().getColumn(9).setPreferredWidth(120);
            tabla.getColumnModel().getColumn(9).setMaxWidth(220);
            tabla.getColumnModel().getColumn(10).setMinWidth(50);
            tabla.getColumnModel().getColumn(10).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(10).setMaxWidth(150);
            tabla.getColumnModel().getColumn(11).setMinWidth(100);
            tabla.getColumnModel().getColumn(11).setPreferredWidth(450);
            tabla.getColumnModel().getColumn(11).setMaxWidth(800);
            tabla.getColumnModel().getColumn(12).setMinWidth(0);
            tabla.getColumnModel().getColumn(12).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(12).setMaxWidth(0);
            tabla.getColumnModel().getColumn(13).setMinWidth(70);
            tabla.getColumnModel().getColumn(13).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(13).setMaxWidth(150);
            tabla.getColumnModel().getColumn(14).setMinWidth(200);
            tabla.getColumnModel().getColumn(14).setPreferredWidth(400);
            tabla.getColumnModel().getColumn(14).setMaxWidth(500);
        }

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbinterface.setText(" ");

        lbtienda.setText(" ");

        btndatos.setText("datos");
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbinterface, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(lbtienda, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1145, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbinterface)
                    .addComponent(btnfrente)
                    .addComponent(btndatos)
                    .addComponent(lbtienda))
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        ventanaordenesporrealizar = false;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
     
      
        
        if(localuotrasucursal.equals("Local"))
        {
           datos(); 
           
           
                   
          TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
tabla.setRowSorter(sorter);
List<RowSorter.SortKey> sortKeys = new ArrayList<>();
 
int columnIndexToSort = 6;
sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
 
sorter.setSortKeys(sortKeys);
sorter.sort();

        }
        else
        {
       
           
           datos();
        }  
        
        
        
        
        
          
          TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
tabla.setRowSorter(sorter);
List<RowSorter.SortKey> sortKeys = new ArrayList<>();
 
int columnIndexToSort = 6;
sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
 
sorter.setSortKeys(sortKeys);
sorter.sort();




        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }//GEN-LAST:event_formWindowOpened

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        
       String donde = ""; 
       String esponchado = "";
       
       
       
        
       if (localuotrasucursal.equals("Otra Sucursal"))
       {
           donde = "Otra sucursal";
       }
       
       else
           
       {
           donde  = "Esta sucursal";
       }
        
        
                
        
        
        
        if (evt.getClickCount() == 2)
        
        {

            int fila = tabla.getSelectedRow();


             
                

                Object numerodeordendebordado = tabla.getValueAt(fila, 0);
                Object prenda = tabla.getValueAt(fila, 2);
                Object tipo = tabla.getValueAt(fila, 3);
                Object lugar = tabla.getValueAt(fila, 4);
                Object numerodeventa = tabla.getValueAt(fila, 5);
                sucursal = tabla.getValueAt(fila, 7);
                Object tablanombre = tabla.getValueAt(fila, 10);
                
                
                
               
                        
              
                
              if (donde.equals("Otra sucursal"))
                  
              {
                  lugar = "Esta sucursal";
                  esponchado = "si";
                 
                  
              }
              
              
              
                
                
                
                // CAMISA
                
                if (tipo.equals("Orden camisa")||tipo.equals("Orden Camisa")) 
                {
                    if (ordencamisaS.ventanaordencamisa == true) 
                    {
                        
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de camisa ya está abierta");

                    }
                    else 
                    {
                        
                        Object nombre_tabla = "historial_ordenes_camisa";
                        
                        
                        
                        autorizaciondelfotomontaje((String)numerodeordendebordado,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal")||tablanombre.equals("Recibida"))
                        {
                            
                            
                            
                        
                        ordencamisaS ventana = new ordencamisaS();
                        ventana.setVisible(true);

                        ordencamisaS.lborden.setText(numerodeordendebordado.toString());
                        ordencamisaS.lbprenda.setText(prenda.toString());
                        ordencamisaS.lbtipo.setText(tipo.toString());
                        ordencamisaS.enquesucursalsebordara =(lugar.toString());
                        ordencamisaS.lbnumerodeventa.setText(numerodeventa.toString());
                        ordencamisaS.esponchado = esponchado;
                        
                        
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordencamisaS.lbsucursal.setText(sucursal.toString());
                        
                        
                        ordencamisaS.tipotabla=(tablanombre.toString());
                        tabla.clearSelection();
                        
                        
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">El cliente aun no autoriza el fotomontaje, preguntele al Encargado si ya lo autorizó");   
                        }    
                        
                        
                       
                    }

                
                }
               
                
                
                
                
                
                
                // GORRA 
                
                else if (tipo.equals("Orden gorra")||tipo.equals("Orden Gorra")) 
                {
                    if (ordengorraS.ventanaordengorra == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de gorra ya está abierta");

                    }
                    else 
                    {
                        
                        
                        Object nombre_tabla = "historial_ordenes_gorra";
                        autorizaciondelfotomontaje((String)numerodeordendebordado,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal")||tablanombre.equals("Recibida"))
                        {

                        ordengorraS orden = new ordengorraS();
                        orden.setVisible(true);

                        ordengorraS.lborden.setText(numerodeordendebordado.toString());
                        ordengorraS.lbnumerodeventa.setText(numerodeventa.toString());
                        ordengorraS.enquesucursalsebordara=(lugar.toString());
                        ordengorraS.esponchado = esponchado;
                        
                         
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordengorraS.lbsucursal.setText(sucursal.toString());
                         ordengorraS.tipotabla=(tablanombre.toString());
                        tabla.clearSelection();
                        
                         
                        } 
                        else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">El cliente aun no autoriza el fotomontaje, preguntele al Encargado si ya lo autorizó");   
                        }    
                        
                    }
                }
                
                
                
                
                
                
                // PANTALON
                
                else if (tipo.equals("Orden pantalon"))
                
                
                {
                    if (ordenpantalonS.ventanaordenpantalonanteriores == true) 
                    {
                        
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de pantalon ya está abierta");

                    } 
                    
                    else
                    {
                        
                        
                      
                        Object nombre_tabla = "historial_ordenes_pantalon";
                        autorizaciondelfotomontaje((String)numerodeordendebordado,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal")||tablanombre.equals("Recibida"))
                        {
                             ordenpantalonS orden = new ordenpantalonS();
                            orden.setVisible(true);

                            ordenpantalonS.lborden.setText(numerodeordendebordado.toString());
                            ordenpantalonS.lbnumerodeventa.setText(numerodeventa.toString());
                            ordenpantalonS.enquesucursalsebordara = (lugar.toString());
                            ordenpantalonS.esponchado = esponchado;
                            
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordenpantalonS.lbsucursal.setText(sucursal.toString());
                        
                        
                        
                            ordenpantalonS.tipotabla = (tablanombre.toString());
                            tabla.clearSelection();
                           
                            
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">El cliente aun no autoriza el fotomontaje, preguntele al Encargado si ya lo autorizó");   
                        }
                       
                    }

                
                } 
                
                
                
                
                
           
                
                // CORBATA
                
                else if (tipo.equals("Orden corbata")||tipo.equals("Corbata")) 
               
                
                {
                   
                    
                        
                        if (ordencorbataS.ventanaordencorbataanteriores == true) 
                        {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de corbata ya está abierta");

                        }
                        else 
                        {
                        
                       
                        Object nombre_tabla = "historial_ordenes_corbata";
                        autorizaciondelfotomontaje((String)numerodeordendebordado,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal"))
                        {    
                            
                        ordencorbataS orden = new ordencorbataS();
                        orden.setVisible(true);

                        ordencorbataS.lborden.setText(numerodeordendebordado.toString());
                        ordencorbataS.lbnumerodeventa.setText(numerodeventa.toString());
                        ordencorbataS.enquesucursalsebordara=(lugar.toString());
                        ordencorbataS.esponchado = esponchado;
                        
                        
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordencorbataS.lbsucursal.setText(sucursal.toString());
                        
                        
                        
                        ordencorbataS.tipotabla=(tablanombre.toString());
                        
                         tabla.clearSelection();
                         
                        
                        }
                         else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">El cliente aun no autoriza el fotomontaje, preguntele al Encargado si ya lo autorizó");   
                        }   
                         
                    }
                        
                 
                   
                }
                
                
                
                
                
                     // PARCHE
                
                else
                    
                    
                    if (tipo.equals("Orden parche")||tipo.equals("Parche")) 
                        
                        
                {
                    if (ordenparcheS.ventanaordenparche == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de parche ya está abierta");

                    }
                    
                    else 
                    
                    {
                        
                 
                        Object nombre_tabla = "historial_ordenes_parche";
                        autorizaciondelfotomontaje((String)numerodeordendebordado,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal")||tablanombre.equals("Recibida"))      
                        
                        {
                        
                        
                        ordenparcheS orden = new ordenparcheS();
                        orden.setVisible(true);

                        ordenparcheS.lborden.setText(numerodeordendebordado.toString());
                         tabla.clearSelection();
                       
                         
                         
                        ordenparcheS.lborden.setText(numerodeordendebordado.toString());
                        ordenparcheS.lbnumerodeventa.setText(numerodeventa.toString());
                        ordenparcheS.lbtipo.setText(tipo.toString());
                        ordenparcheS.enquesucursalsebordara=(lugar.toString());
                        ordenparcheS.esponchado = esponchado;
                        
                         
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordenparcheS.lbsucursal.setText(sucursal.toString());
                        
                        
                        
                        ordenparcheS.tipotabla=(tablanombre.toString());
                        
                        
                        tabla.clearSelection();    
                         
                         
                         
                         
                        }
                         
                         
                         
                         
                         
                        
                    }
                }
                
                
                    
                     else 
                       
                    
                    // ORDEN DISTINTA
                        
                        
                     if (tipo.equals("Distinta"))    
                        
                     {   
                    
                    if (ordendistintaS.ventanaordencamisaanteriores == true) 
                    {
                        
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de distinta ya está abierta");

                    }
                    else 
                    {
                        
                        
                        Object nombre_tabla = "historial_ordenes_distinta";
                        autorizaciondelfotomontaje((String)numerodeordendebordado,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal"))
                        {
                        
                        ordendistintaS orden = new ordendistintaS();
                        orden.setVisible(true);

                        ordendistintaS.lborden.setText(numerodeordendebordado.toString());
                        ordendistintaS.lbnumerodeventa.setText(numerodeventa.toString());
                        ordendistintaS.lbprenda.setText(prenda.toString());
                        ordendistintaS.lbtipo.setText(tipo.toString());
                        ordendistintaS.enquesucursalsebordara=(lugar.toString());
                        ordendistintaS.tipotabla=(tablanombre.toString());
                        ordendistintaS.esponchado = esponchado;
                        
                        
                        tabla.clearSelection();
                        
                        
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">El cliente aun no autoriza el fotomontaje, preguntele al Encargado si ya lo autorizó");   
                        }    
                        
                        
                       
                    }
                
                
                
                     }
                
                else
                
                
                // PONCHADO
                
               if (tipo.equals("Orden ponchado")) 
                {
                    if (ordenponchadoS.ventanaordenponchado == true) 
                    {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de ponchado ya está abierta");

                    }
                    else 
                    {
                        
                       
                        fotomontajeautorizado ="si";
                        
                         if (fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal")||tablanombre.equals("Recibida")) {
                          
                             
                             ordenponchadoS orden = new ordenponchadoS();
                            orden.setVisible(true);

                            ordenponchadoS.lbordendebordado.setText(numerodeordendebordado.toString());
                            ordenponchadoS.lbnumerodeventa.setText(numerodeventa.toString());
                            ordenponchadoS.enquesucursalsebordara = (lugar.toString());
                            
                            
                              
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordenponchadoS.lbsucursal.setText(sucursal.toString());
                        
                        
                            ordenponchadoS.tipotabla = (tablanombre.toString());
                            tabla.clearSelection();
                           
                         }
                         else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">El cliente aun no autoriza el fotomontaje, preguntele al Encargado si ya lo autorizó");   
                        }  
                        
                    }
                }
                
                
                
                
                
                
                
                
                
                // PORTA NOMBRE ESCOLAR
                
                else if (tipo.equals("Porta nombre escolar")) 
                {
                   
                        
                   if (ordenportanombreescolarS.ventanaordenportanombreanterior == true) 
                   {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de porta nombre ya está abierta");

                   } else 
                   
                   {
                      
                        Object nombre_tabla = "historial_ordenes_portanombres";
                        autorizaciondelfotomontaje((String)numerodeordendebordado,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal"))
                        {
                       
                            ordenportanombreescolarS orden = new ordenportanombreescolarS();
                            orden.setVisible(true);
                            
                            ordenportanombreescolarS.lbnumero.setText(numerodeordendebordado.toString());
                            tabla.clearSelection();
                           
                        }
                         else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">El cliente aun no autoriza el fotomontaje, preguntele al Encargado si ya lo autorizó");   
                        }     
                            
                        
                    }
                                           
                   
                   
                   
                }
                
                
                
                // PORTA NOMBRE MULTIPLE
                
                
                else if (tipo.equals("porta nombre multiple")) 
                {
                   
                        
                    if (ordenportanombremultipleS.ventanaordenportanombremultipleanterior == true) 
                    {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de porta nombre multiple ya está abierta");

                    } 
                    else 
                    {
                      
                        Object nombre_tabla = "historial_ordenes_portanombres_multiple";
                        autorizaciondelfotomontaje((String)numerodeordendebordado,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal"))
                        {
                        
                            ordenportanombremultipleS orden = new ordenportanombremultipleS();
                            orden.setVisible(true);
                            
                            ordenportanombremultipleS.lbnumerohistorialordenesbordados.setText(numerodeordendebordado.toString());
                            tabla.clearSelection();
                           
                        }    
                          else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">El cliente aun no autoriza el fotomontaje, preguntele al Encargado si ya lo autorizó");   
                        }     
                            
                        
                    }
                                           
                }
                
                
                
                else
                    
                    
                    if (tipo.equals("Orden bordado interno gorra")) 
                {
                   
                        
                    if (ordeninternagorra.ventanaordeninternagorraanterior == true) 
                    {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden interna de gorra ya está abierta");

                    } 
                    else 
                    {
                       

                        ordeninternagorra ventana = new ordeninternagorra();
                        ventana.setVisible(true);
                        ordeninternagorra.lbnumerodeorden.setText(numerodeordendebordado.toString());
                        tabla.clearSelection();

                             
                            
                        
                    }
                                           
                }
                
                
                
                
                   else
                    
                    
                    if (tipo.equals("Orden bordado interno parches")) 
                {
                   
                        
                    if (ordeninternaparche.ventanaordeninternaparcheanterior == true) 
                    {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden interna de parches ya está abierta");

                    } 
                    else 
                    {
                       

                        ordeninternaparche ventana = new ordeninternaparche();
                        ventana.setVisible(true);
                        ordeninternaparche.lbnumerodeorden.setText(numerodeordendebordado.toString());
                        tabla.clearSelection();

                             
                            
                        
                    }
                                           
                }
                
                
                
                
                
                
                
                
                
                
                
                
              
          

        } 


       
        
    }//GEN-LAST:event_tablaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        
        ventanaordenesporrealizar = false;
        this.dispose();
        
        
    }//GEN-LAST:event_formWindowClosing

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed

        
        
        limpiartabla();
       if(localuotrasucursal.equals("Local"))
        {
           datos(); 
           
           
                   
          TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
tabla.setRowSorter(sorter);
List<RowSorter.SortKey> sortKeys = new ArrayList<>();
 
int columnIndexToSort = 6;
sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
 
sorter.setSortKeys(sortKeys);
sorter.sort();




        }
        else
        {
     //      datosponchadosporreplicar(); 
           
           datos(); 
           
           
        }    
       
       
       
       
    }//GEN-LAST:event_btndatosActionPerformed

    private void btnfrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrenteActionPerformed
        this.toFront();
    }//GEN-LAST:event_btnfrenteActionPerformed

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_F5) 
        {
            btndatos.doClick();
        }
    }//GEN-LAST:event_tablaKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
          if (evt.getKeyCode() == KeyEvent.VK_F5) 
        {
            btndatos.doClick();
        }
    }//GEN-LAST:event_formKeyPressed

    private void tablaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablaMouseEntered

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordenesporrealizar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btndatos;
    public static javax.swing.JButton btnfrente;
    private javax.swing.JButton btnsalir;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbinterface;
    public static javax.swing.JLabel lbtienda;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
coneccionlocal cc = new coneccionlocal();
Connection cn = cc.conexion();

}
