package sistemabordadores;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;
import javax.swing.JTextField;
import static sistemabordadores.ordenesterminadas.btndatos;


public class ordenesterminadas extends javax.swing.JFrame {

    public static boolean ventanaordenesterminadas = false;
    String fechainicial = "";
    String fechafinal = "";
    String nombrecliente = "";
    String tiendalocal = principal.tiendalocal;
    String sucursal = "";
    public static String localuotrasucursal ="";
    String primerafecha = "";
    

    public ordenesterminadas() {
        initComponents();
        
        TableFilterHeader filterHeader = new TableFilterHeader(tabla, AutoChoices.ENABLED);
        
        
        ventanaordenesterminadas = true;
        lbinterface.setVisible(false);
        lbtienda.setVisible(false);
        btndatos.setVisible(false);
        btnfrente.setVisible(false);
        
        
        
        
        
        
        
             Calendar cal = new GregorianCalendar();
        
    
         int diaactual = (cal.get(Calendar.DAY_OF_MONTH));
         int mesactual = (cal.get(Calendar.MONTH)+1);
         int año =  cal.get(Calendar.YEAR);
        
        String fechaactual = (+diaactual+ "/" + mesactual + "/" + año);
        
         try {
                 SimpleDateFormat sdfSource = new SimpleDateFormat("d/MM/yyyy");

                java.util.Date date = sdfSource.parse(fechaactual);

               SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/MM/dd");

                fechaactual = sdfDestination.format(date);

            } catch (Exception pe) {
                
            }
       
         
         int diainicial = diaactual - 10;  //PONER LOS DIAS QUE QUIERE QUE SE MUESTREN
         int mesinicial = mesactual;
         if (diainicial<0) {diainicial = diainicial + 30; mesinicial = mesactual-1; }
                 
                  
            String fechaini = (diainicial + "/" + mesinicial + "/" + año);
          
            try {
                 SimpleDateFormat sdfSource = new SimpleDateFormat("d/MM/yyyy");

                java.util.Date date2 = sdfSource.parse(fechaini);

               SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/MM/dd");

                fechaini = sdfDestination.format(date2);

            } catch (Exception pe) {
                
            }

       
           
     java.util.Date fecha1;
     java.util.Date fecha2;
    
     
        try {
            fecha1 = new SimpleDateFormat("yyyy/MM/dd").parse(fechaini);
            fecha2 = new SimpleDateFormat("yyyy/MM/dd").parse(fechaactual);
            
            lbfechainicial.setDate(fecha1);
            lbfechafinal.setDate(fecha2);
            
        } catch (ParseException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
  
        
        
        

        
        
       
        

    }
    
     
     
     

    void datos() {
        
        
        
        
        limpiartabla();
        primerafecha = "no";
        
        
        
        
            Object t = ((JTextField) lbfechainicial.getDateEditor().getUiComponent()).getText();
        if (t == null || t.equals("")) {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha inicial");
        } else {
            String diainicial = Integer.toString(lbfechainicial.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mesinicial = Integer.toString(lbfechainicial.getCalendar().get(Calendar.MONTH) + 01);
            String añoinicial = Integer.toString(lbfechainicial.getCalendar().get(Calendar.YEAR));

           fechainicial = (añoinicial + "/" + mesinicial + "/" + diainicial);
            
          
          
        }

        Object f = ((JTextField) lbfechafinal.getDateEditor().getUiComponent()).getText();
        if (f == null || f.equals("")) {
            JOptionPane.showMessageDialog(null, "Selecciona una fecha final");
        } else {
             String dia = Integer.toString(lbfechafinal.getCalendar().get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(lbfechafinal.getCalendar().get(Calendar.MONTH) + 01);
            String year = Integer.toString(lbfechafinal.getCalendar().get(Calendar.YEAR));

            fechafinal = (year + "/" + mes + "/" + dia);
           

        }
    
    
         
         
         

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       
        
        
        //// historial_orden_camisa
        
        String[] datos = new String[12];
        
        
        String sqlcamisa = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha,identificador_prenda  "
                         + "FROM historial_ordenes_camisa where lugar = 'Esta sucursal' "
                         + "and estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc  ";
        
        
        
        

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcamisa);
            while (rs.next()) {
                
                
                
               
                
               String num = rs.getString("numero"); 
                
                 if (num.equals("00002273"))
                 {
                     int aquivoy = 0;
                 }
                
                
                datos[0] = rs.getString("numero");
                datos[1] = rs.getString("cliente");
                datos[2] = rs.getString("prenda");
                datos[3] = rs.getString("tipo");
                datos[4] = rs.getString("lugar");
                datos[5] = rs.getString("numero_venta");
                datos[6] = rs.getString("fecha");
                datos[7] = "";
                datos[8] = "";
                datos[9] = "";
                datos[10] = "Local";
                datos[11] = rs.getString("identificador_prenda");

                modelo.addRow(datos);

            }

            

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }

        
        
        
        
        
        
        
        
        //// historial_orden_gorra
        
        String[] datos2 = new String[12];
        
        String sqlgorra = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha,identificador_prenda  FROM historial_ordenes_gorra where lugar = 'Esta sucursal'  and estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc";

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
                datos2[7] = "";
                datos2[8] = "";
                datos2[9] = "";
                datos2[10] = "Local";
                datos2[11] = rs.getString("identificador_prenda");

                modelo.addRow(datos2);

            }

           

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
        
        
        
        
        //// historial_orden_pantalon
        
        
        String[] datos3 = new String[12];
        
         String sqlpantalon = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha,identificador_prenda  FROM historial_ordenes_pantalon where lugar = 'Esta sucursal' and estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlpantalon);
            while (rs.next()) 
            {
                datos3[0] = rs.getString("numero");
                datos3[1] = rs.getString("cliente");
                datos3[2] = rs.getString("prenda");
                datos3[3] = rs.getString("tipo");
                datos3[4] = rs.getString("lugar");
                datos3[5] = rs.getString("numero_venta");
                datos3[6] = rs.getString("fecha");
                datos3[7] = "";
                datos3[8] = "";
                datos3[9] = "";
                datos3[10] = "Local";
                datos3[11] = rs.getString("identificador_prenda");

                modelo.addRow(datos3);

            }

            

        } catch (SQLException ex)
        {
           
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
        
        
        
        
        
        /// historial ordenes corbata
        
         String[] datos6 = new String[12];
        
        String sqlcorbata= "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha,identificador_prenda  FROM historial_ordenes_corbata where lugar = 'Esta sucursal'  and estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc ";

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
                datos6[7] = "";
                datos6[8] = "";
                datos6[9] = "";
                datos6[10] = "Local";
                datos6[11] = rs.getString("identificador_prenda");

                modelo.addRow(datos6);

            }

            

        } catch (SQLException ex)
        {
          
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
        
        
        
        //// historial_orden_parches
        
        String[] datos4 = new String[12];
        
        String sqlparches = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha,identificador_prenda  FROM historial_ordenes_parche where lugar = 'Esta sucursal'  and estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc";

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
                datos4[7] = "";
                datos4[8] = "";
                datos4[9] = "";
                datos4[10] = "Local";
                datos4[11] = rs.getString("identificador_prenda");

                modelo.addRow(datos4);

            }

            

        } catch (SQLException ex)
        {
          
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
      
        
        
        
        
        
        
        /// historial orden portanombres
        
        String[] datos7 = new String[12];
        
        String sqlportanombre= "SELECT Distinct numero,tipo,numero_venta,fecha  FROM historial_ordenes_portanombres where  estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlportanombre);
            while (rs.next()) 
            {
                String numeroventa = rs.getString("numero_venta");
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

                modelo.addRow(datos7);

            }

            

        } catch (SQLException ex)
        {
          
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }


        /// historial´ portanombre multiple
        
        String[] datos8 = new String[12];

         String sqlportanombremultiple= "SELECT Distinct numero,tipo,numero_venta,fecha  FROM historial_ordenes_portanombres_multiple where estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc ";

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

                modelo.addRow(datos8);

            }

            

        } catch (SQLException ex)
        {
          
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }        
     
        
        
        
        
        
        
         //// historial_orden_ponchado
         
         
         String[] datos5 = new String[12];
        
        String sqlponchados = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_ponchados where lugar = 'Esta sucursal'  and estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc";

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
                datos5[7] = "";
                datos5[8] = "";
                datos5[9] = "";
                datos5[10] = "Local";
                

                modelo.addRow(datos5);

            }

            

        } catch (SQLException ex)
        {
           
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
        /// distinta
        
         String sqldistinta = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha,identificador_prenda  "
                         + "FROM historial_ordenes_distinta where lugar = 'Esta sucursal' "
                         + "and estatus_orden = 'realizada totalmente' order by fecha desc  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqldistinta);
            while (rs.next()) {
                datos[0] = rs.getString("numero");
                datos[1] = rs.getString("cliente");
                datos[2] = "Distinta";
                datos[3] = rs.getString("tipo");
                datos[4] = rs.getString("lugar");
                datos[5] = rs.getString("numero_venta");
                datos[6] = rs.getString("fecha");
                datos[7] = "";
                datos[8] = "";
                datos[9] = "";
                datos[10] = "Local";
                datos[11] = rs.getString("identificador_prenda");

                modelo.addRow(datos);

            }

            

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
         //// historial ordenes internas
        
        String sql5 = "Select numero,tipo,fecha,cantidad,prenda,descripcion,hora from historial_ordenes_bordados_interno where estatus_entrega = 'entregada' and fecha between '"+fechainicial+"' and '"+fechafinal+"'  order by fecha desc ";

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

                
                 modelo.addRow(datos);
                

                

            }

           
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        
        
        
        
        
        // ORDENES DE OTRAS SUCURSALES
        //////////////////////////////
        /////////////////////////////
        
        
        
        //CAMISA
        
        
        String[] datos9 = new String[12];

        String sql3 = "SELECT numero,numero_orden_camisa_solicitada,cliente,prenda,tipo,tienda,fecha,lugar  FROM historial_ordenes_camisa_recibidas where estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc "; //and tienda not in('"+tiendalocal+"')

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql3);
            while (rs.next()) {
                datos9[0] = rs.getString("numero");
                datos9[1] = rs.getString("cliente");
                datos9[2] = rs.getString("prenda");
                datos9[3] = rs.getString("tipo");
                datos9[4] = rs.getString("lugar");
                datos9[5] = "00000000";
                datos9[6] = rs.getString("fecha");
                datos9[7] = rs.getString("tienda");
                datos9[8] = rs.getString("numero_orden_camisa_solicitada");
                datos9[9] = "";
                datos9[10] = "Recibida";

                modelo.addRow(datos9);

            }

            tabla.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
     
        
        
        
        // GORRA
        
        String[] datos10 = new String[12];

        String sql4 = "SELECT numero,numero_orden_gorra_solicitada,cliente,prenda,tipo,cliente,tienda,lugar,fecha,numero_orden_o_pedido_solicitada  FROM historial_ordenes_gorra_recibidas  where estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql4);
            while (rs.next()) {
                datos10[0] = rs.getString("numero");
                datos10[1] = rs.getString("cliente");
                datos10[2] = rs.getString("prenda");
                datos10[3] = rs.getString("tipo");
                datos10[4] = rs.getString("lugar");
                datos10[5] = "0000000";  
                datos10[6] = rs.getString("fecha");
                datos10[7] = rs.getString("tienda");
                datos10[8] = rs.getString("numero_orden_o_pedido_solicitada");
                datos10[9] = "";
                datos10[10] = "Recibida";

                modelo.addRow(datos10);

            }

            tabla.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
         
        
        
        /// PANTALON
        
        String[] datos11 = new String[12];

        String sql15 = "SELECT numero,numero_orden_pantalon_solicitada,cliente,prenda,tipo,cliente,tienda,lugar,fecha,numero_orden_o_pedido_solicitada  FROM historial_ordenes_pantalon_recibidas  where estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql15);
            while (rs.next()) {
                datos11[0] = rs.getString("numero");
                datos11[1] = rs.getString("cliente");
                datos11[2] = rs.getString("prenda");
                datos11[3] = rs.getString("tipo");
                datos11[4] = rs.getString("lugar");
                datos11[5] = "0000000";  
                datos11[6] = rs.getString("fecha");
                datos11[7] = rs.getString("tienda");
                datos11[8] = rs.getString("numero_orden_o_pedido_solicitada");
                datos11[9] = "";
                datos11[10] = "Recibida";
            
                modelo.addRow(datos11);

            }

            tabla.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        
        
        
        /// CORBATA
        
        String[] datos16 = new String[12];

        String sql16 = "SELECT numero,numero_orden_corbata_solicitada,cliente,prenda,tipo,cliente,tienda,lugar,fecha,numero_orden_o_pedido_solicitada  FROM historial_ordenes_corbata_recibidas  where estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"'  order by fecha desc  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql16);
            while (rs.next()) {
                datos16[0] = rs.getString("numero");
                datos16[1] = rs.getString("cliente");
                datos16[2] = rs.getString("prenda");
                datos16[3] = rs.getString("tipo");
                datos16[4] = rs.getString("lugar");
                datos16[5] = "0000000";  
                datos16[6] = rs.getString("fecha");
                datos16[7] = rs.getString("tienda");
                datos16[8] = rs.getString("numero_orden_o_pedido_solicitada");
                datos16[9] = "";
                datos16[10] = "Recibida";
            
                modelo.addRow(datos16);

            }

            tabla.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
    
        
        
        
         /// PARCHE
        
        String[] datos17 = new String[12];

        String sql17 = "SELECT numero,numero_orden_parche_solicitada,cliente,prenda,tipo,cliente,tienda,lugar,fecha,numero_orden_o_pedido_solicitada  FROM historial_ordenes_parche_recibidas  where estatus_orden = 'realizada totalmente' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by fecha desc  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql17);
            while (rs.next()) {
                datos17[0] = rs.getString("numero");
                datos17[1] = rs.getString("cliente");
                datos17[2] = rs.getString("prenda");
                datos17[3] = rs.getString("tipo");
                datos17[4] = rs.getString("lugar");
                datos17[5] = "0000000";  
                datos17[6] = rs.getString("fecha");
                datos17[7] = rs.getString("tienda");
                datos17[8] = rs.getString("numero_orden_o_pedido_solicitada");
                datos17[9] = "";
                datos17[10] = "Recibida";
            
                modelo.addRow(datos17);

            }

            tabla.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
       
        
        
        tieneponchados();
        
        
        
        
        
        
        
        
        
        
        
        
 
        
    }
    
    
     void datos2() {
        
        
        
        
        limpiartabla();

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       
        
        
        //// historial_orden_camisa
        
        String[] datos = new String[12];
        
        
        String sqlcamisa = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  "
                         + "FROM historial_ordenes_camisa where lugar = 'Otra sucursal' "
                         + "and (estatus_orden = 'generada' or estatus_orden = 'solicitada')  ";

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
                datos[7] = "";
                datos[8] = "";
                datos[9] = "";
                datos[10] = "Local";

                modelo.addRow(datos);

            }

            

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }

        
        //// historial_orden_gorra
        
        String[] datos2 = new String[12];
        
        String sqlgorra = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_gorra where lugar = 'Otra sucursal' and (estatus_orden = 'generada' or estatus_orden = 'solicitada')";

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
                datos2[7] = "";
                datos2[8] = "";
                datos2[9] = "";
                datos2[10] = "Local";

                modelo.addRow(datos2);

            }

           

        } catch (SQLException ex) {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        //// historial_orden_pantalon
        
        
        String[] datos3 = new String[12];
        
         String sqlpantalon = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_pantalon where  lugar = 'Otra sucursal' and (estatus_orden = 'generada' or estatus_orden = 'solicitada') ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlpantalon);
            while (rs.next()) 
            {
                datos3[0] = rs.getString("numero");
                datos3[1] = rs.getString("cliente");
                datos3[2] = rs.getString("prenda");
                datos3[3] = rs.getString("tipo");
                datos3[4] = rs.getString("lugar");
                datos3[5] = rs.getString("numero_venta");
                datos3[6] = rs.getString("fecha");
                datos3[7] = "";
                datos3[8] = "";
                datos3[9] = "";
                datos3[10] = "Local";

                modelo.addRow(datos3);

            }

            

        } catch (SQLException ex)
        {
           
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        
        //// historial_orden_parches
        
        String[] datos4 = new String[12];
        
        String sqlparches = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_parche where  lugar = 'Otra sucursal' and (estatus_orden = 'generada' or estatus_orden = 'solicitada')  ";

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
                datos4[7] = "";
                datos4[8] = "";
                datos4[9] = "";
                datos4[10] = "Local";

                modelo.addRow(datos4);

            }

            

        } catch (SQLException ex)
        {
          
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
         //// historial_orden_ponchado
         
         
         String[] datos5 = new String[12];
        
        String sqlponchados = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_ponchados where lugar = 'Otra sucursal' and (estatus_orden = 'generada' or estatus_orden = 'solicitada')  ";

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
                datos5[7] = "";
                datos5[8] = "";
                datos5[9] = "";
                datos5[10] = "Local";

                modelo.addRow(datos5);

            }

            

        } catch (SQLException ex)
        {
           
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        
        /// historial ordenes corbata
        
         String[] datos6 = new String[12];
        
        String sqlcorbata= "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_corbata where  lugar = 'Otra sucursal' and (estatus_orden = 'generada' or estatus_orden = 'solicitada') ";

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
                datos6[7] = "";
                datos6[8] = "";
                datos6[9] = "";
                datos6[10] = "Local";

                modelo.addRow(datos6);

            }

            

        } catch (SQLException ex)
        {
           
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+ex+"");
        }
        

       /* 
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabla.getModel());
        tabla.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(100);
        sortKeys.add(new RowSorter.SortKey(6, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        
       */
        
        
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
                        
                        JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+e+"");
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
        lbfechainicial = new com.toedter.calendar.JDateChooser();
        lbfechafinal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordenes terminadas");
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
                "Numero Orden", "cliente", "prenda", "tipo", "lugar", "No. de venta", "fecha", "Sucursal", "No. sucursal", "tieneponchados", "tabla", "Nombre bordado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false
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
        tabla.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tablaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(100);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(150);
            tabla.getColumnModel().getColumn(0).setMaxWidth(200);
            tabla.getColumnModel().getColumn(1).setMinWidth(100);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(350);
            tabla.getColumnModel().getColumn(1).setMaxWidth(700);
            tabla.getColumnModel().getColumn(2).setMinWidth(100);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabla.getColumnModel().getColumn(2).setMaxWidth(300);
            tabla.getColumnModel().getColumn(3).setMinWidth(0);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            tabla.getColumnModel().getColumn(5).setMinWidth(0);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(5).setMaxWidth(0);
            tabla.getColumnModel().getColumn(7).setMinWidth(50);
            tabla.getColumnModel().getColumn(7).setPreferredWidth(120);
            tabla.getColumnModel().getColumn(7).setMaxWidth(180);
            tabla.getColumnModel().getColumn(8).setMinWidth(0);
            tabla.getColumnModel().getColumn(8).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(8).setMaxWidth(0);
            tabla.getColumnModel().getColumn(9).setMinWidth(50);
            tabla.getColumnModel().getColumn(9).setPreferredWidth(120);
            tabla.getColumnModel().getColumn(9).setMaxWidth(150);
            tabla.getColumnModel().getColumn(10).setMinWidth(50);
            tabla.getColumnModel().getColumn(10).setPreferredWidth(100);
            tabla.getColumnModel().getColumn(10).setMaxWidth(150);
            tabla.getColumnModel().getColumn(11).setMinWidth(100);
            tabla.getColumnModel().getColumn(11).setPreferredWidth(450);
            tabla.getColumnModel().getColumn(11).setMaxWidth(800);
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

        lbfechainicial.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfechainicial.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lbfechainicialPropertyChange(evt);
            }
        });

        lbfechafinal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbfechafinal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                lbfechafinalPropertyChange(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbfechainicial, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbfechafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1384, 1384, 1384)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btndatos)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbinterface, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(210, 210, 210)
                                .addComponent(lbtienda, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 9, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbfechafinal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbfechainicial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 876, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        ventanaordenesterminadas = false;
        this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        
        datos(); 
        
        
        
          TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabla.getModel());
tabla.setRowSorter(sorter);
List<RowSorter.SortKey> sortKeys = new ArrayList<>();
 
int columnIndexToSort = 6;
sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
 
sorter.setSortKeys(sortKeys);
sorter.sort();




        
        
    }//GEN-LAST:event_formWindowOpened

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        
        
        if (evt.getClickCount() == 2) {

            int fila = tabla.getSelectedRow();

            if (fila >= 0) 
            {

                Object tipo = tabla.getValueAt(fila, 3).toString();

                
                
                
                
                
                
                if (tipo.equals("Orden camisa")||tipo.equals("Orden Camisa"))
                
                
                
                {
                    if (ordencamisaS.ventanaordencamisa == true) 
                    {
                        
                       
                        JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de camisa ya está abierta");

                    } else {
                        ordencamisaS orden = new ordencamisaS();
                        orden.setVisible(true);

                        ordencamisaS.lborden.setText(tabla.getValueAt(fila, 0).toString());
                        ordencamisaS.lbnumerodeventa.setText(tabla.getValueAt(fila, 5).toString());
                        ordencamisaS.lbprenda.setText(tabla.getValueAt(fila, 2).toString());
                        ordencamisaS.lbtipo.setText(tabla.getValueAt(fila, 3).toString());
                        ordencamisaS.enquesucursalsebordara = (tabla.getValueAt(fila, 4).toString());
                       
                         
                          sucursal = tabla.getValueAt(fila, 7).toString();
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordencamisaS.lbsucursal.setText(sucursal);
                        
                        
                        ordencamisaS.tipotabla=(tabla.getValueAt(fila, 10).toString());
                        tabla.clearSelection();
                        this.setState(this.ICONIFIED);
                       
                    }

                
                } 
                else 
                    
                    
                    if (tipo.equals("Orden gorra")||tipo.equals("Orden Gorra")) 
                {
                    if (ordengorraS.ventanaordengorra == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de gorra ya está abierta");

                    } else
                    {
                        ordengorraS orden = new ordengorraS();
                        orden.setVisible(true);

                        ordengorraS.lborden.setText(tabla.getValueAt(fila, 0).toString());
                        ordengorraS.lbnumerodeventa.setText(tabla.getValueAt(fila, 5).toString());
                   
                        ordengorraS.enquesucursalsebordara = (tabla.getValueAt(fila, 4).toString());
                        
                         sucursal = tabla.getValueAt(fila, 7).toString();
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordengorraS.lbsucursal.setText(sucursal);
                        
                        
                        ordengorraS.tipotabla = (tabla.getValueAt(fila, 10).toString());
                        tabla.clearSelection();
                        this.setState(this.ICONIFIED);
                        
                    }
                }
                
                else
                        
                
                if (tipo.equals("Orden pantalon"))
                
                
                {
                    if (ordenpantalonS.ventanaordenpantalonanteriores == true) 
                    {
                        
                        JOptionPane.showMessageDialog(null,"<HTML><b style=\"Color:red; font-size:20px;\">La orden de pantalon ya está abierta");

                    } else {
                        ordenpantalonS orden = new ordenpantalonS();
                        orden.setVisible(true);

                        ordenpantalonS.lborden.setText(tabla.getValueAt(fila, 0).toString());
                        ordenpantalonS.lbnumerodeventa.setText(tabla.getValueAt(fila, 5).toString());
                     
                        ordenpantalonS.enquesucursalsebordara=(tabla.getValueAt(fila, 4).toString());
                        
                         sucursal = tabla.getValueAt(fila, 7).toString();
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordenpantalonS.lbsucursal.setText(sucursal);
                        
                        
                        ordenpantalonS.tipotabla=(tabla.getValueAt(fila, 10).toString());
                        tabla.clearSelection();
                        this.setState(this.ICONIFIED);
                       
                    }

                
                } 
                
                
                else
                    
             
                        
                        
                       
                            
                            
                            if (tipo.equals("Orden corbata")) 
                {
                   
                        
                        if (ordencorbataS.ventanaordencorbataanteriores == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de corbata ya está abierta");

                    } 
                        
                        else
                        
                        {
                            
                        ordencorbataS ventana = new ordencorbataS();
                        ventana.setVisible(true);

                        ordencorbataS.lborden.setText(tabla.getValueAt(fila, 0).toString());
                        ordencorbataS.lbnumerodeventa.setText(tabla.getValueAt(fila, 5).toString());
                        ordencorbataS.enquesucursalsebordara=(tabla.getValueAt(fila, 4).toString());
                        
                         sucursal = tabla.getValueAt(fila, 7).toString();
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordencorbataS.lbsucursal.setText(sucursal);
                        
                        
                        ordencorbataS.tipotabla=(tabla.getValueAt(fila, 10).toString());
                        
                         tabla.clearSelection();
                         this.setState(this.ICONIFIED);
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                         
                        
                    }
                        
                 
                   
                }
                            
                            
                            
                else 
                                
                                
                                
                                 if (tipo.equals("Orden parche")||tipo.equals("Parche")) 
                {
                    if (ordenparcheS.ventanaordenparche == true) {
                        JOptionPane.showMessageDialog(null,"<HTML><b style=\"Color:red; font-size:20px;\">La orden de parche ya está abierta");

                    } 
                    
                    else
                    
                    {
                        ordenparcheS ventana = new ordenparcheS();
                        ventana.setVisible(true);

                        ordenparcheS.lborden.setText(tabla.getValueAt(fila, 0).toString());
                        ordenparcheS.lbnumerodeventa.setText(tabla.getValueAt(fila, 5).toString());
                   
                        ordenparcheS.enquesucursalsebordara = (tabla.getValueAt(fila, 4).toString());
                        
                        
                        
                        
                          sucursal = tabla.getValueAt(fila, 7).toString();
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordenparcheS.lbsucursal.setText(sucursal);
                        
                        
                        ordenparcheS.tipotabla = (tabla.getValueAt(fila, 10).toString());
                        tabla.clearSelection();
                        this.setState(this.ICONIFIED);
                        
                    }
                }
                        
                        
                else 
                                
                                
                                
                                
                                       
                    if (tipo.equals("Orden ponchado")) 
                {
                    if (ordenponchadoS.ventanaordenponchado == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de ponchado ya está abierta");

                    } else {
                        ordenponchadoS orden = new ordenponchadoS();
                        orden.setVisible(true);

                        ordenponchadoS.lbordendebordado.setText(tabla.getValueAt(fila, 0).toString());
                        ordenponchadoS.lbnumerodeventa.setText(tabla.getValueAt(fila, 5).toString());
                        
                        ordenponchadoS.enquesucursalsebordara=(tabla.getValueAt(fila, 4).toString());
                        
                         sucursal = tabla.getValueAt(fila, 7).toString();
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordenponchadoS.lbsucursal.setText(sucursal);
                        
                        
                        ordenponchadoS.tipotabla=(tabla.getValueAt(fila, 10).toString());
                         tabla.clearSelection();
                         this.setState(this.ICONIFIED);
                        
                    }
                }
                    
                    
                else
                                
                                
                                if (tipo.equals("Porta nombre escolar")) 
                {
                   
                        
                        if (ordenportanombreescolarS.ventanaordenportanombreanterior == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de porta nombre ya está abierta");

                    } else {
                            ordenportanombreescolarS ventana = new ordenportanombreescolarS();
                            ventana.setVisible(true);
                            
                            ordenportanombreescolarS.lbnumero.setText(tabla.getValueAt(fila, 0).toString());
                            tabla.clearSelection();
                            this.setState(this.ICONIFIED);
                        
                    }
                                           
                }
                                
                                
                else
                                    
                                    
                                    if (tipo.equals("porta nombre multiple")) 
                {
                   
                        
                        if (ordenportanombremultipleS.ventanaordenportanombremultipleanterior == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de porta nombre multiple ya está abierta");

                    } else {
                            ordenportanombremultipleS ventana = new ordenportanombremultipleS();
                            ventana.setVisible(true);
                            
                            ordenportanombremultipleS.lbnumerohistorialordenesbordados.setText(tabla.getValueAt(fila, 0).toString());
                            tabla.clearSelection();
                            this.setState(this.ICONIFIED);
                        
                    }
                                           
                }
                                    
                else if (tipo.equals("Orden bordado interno gorra")) 
                {
                   
                        
                    if (ordeninternagorra.ventanaordeninternagorraanterior == true) 
                    {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de gorra interna ya está abierta");

                    } 
                    else 
                    {
                      
                        ordeninternagorra orden = new ordeninternagorra();
                        orden.setVisible(true);
                        
                        
                        ordeninternagorra.lbnumerodeorden.setText(tabla.getValueAt(fila, 0).toString());
                        tabla.clearSelection();

                             
                            
                        
                    }
                                           
                }                    
                                    
                                    
                else
                {
                     if (ordendistintaS.ventanaordencamisaanteriores == true) 
                    {
                        
                        JOptionPane.showMessageDialog(null,"<HTML><b style=\"Color:red; font-size:5px;\">La orden de distinta ya esta abierta");

                    } else {
                        ordendistintaS orden = new ordendistintaS();
                        orden.setVisible(true);

                        ordendistintaS.lborden.setText(tabla.getValueAt(fila, 0).toString());
                        ordendistintaS.lbnumerodeventa.setText(tabla.getValueAt(fila, 5).toString());
                        ordendistintaS.lbprenda.setText(tabla.getValueAt(fila, 2).toString());
                        ordendistintaS.lbtipo.setText(tabla.getValueAt(fila, 3).toString());
                        ordendistintaS.enquesucursalsebordara=(tabla.getValueAt(fila, 4).toString());
                        ordendistintaS.tipotabla=(tabla.getValueAt(fila, 10).toString());
                        tabla.clearSelection();
                        this.setState(this.ICONIFIED);
                       
                    }
                } 
                

            } /// 

        } 


       
        
    }//GEN-LAST:event_tablaMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordenesterminadas = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed
       limpiartabla();
       if(localuotrasucursal.equals("Local"))
        {
           datos(); 
        }
        else
        {
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

    private void lbfechainicialPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lbfechainicialPropertyChange

        if (primerafecha.equals("no"))
        {

            datos();

        }

    }//GEN-LAST:event_lbfechainicialPropertyChange

    private void lbfechafinalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_lbfechafinalPropertyChange

        if (primerafecha.equals("no"))
        {

            datos();

        }

    }//GEN-LAST:event_lbfechafinalPropertyChange

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
            java.util.logging.Logger.getLogger(ordenesterminadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ordenesterminadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ordenesterminadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ordenesterminadas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new ordenesterminadas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btndatos;
    public static javax.swing.JButton btnfrente;
    private javax.swing.JButton btnsalir;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser lbfechafinal;
    private com.toedter.calendar.JDateChooser lbfechainicial;
    public static javax.swing.JLabel lbinterface;
    public static javax.swing.JLabel lbtienda;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
coneccionlocal cc = new coneccionlocal();
Connection cn = cc.conexion();

}
