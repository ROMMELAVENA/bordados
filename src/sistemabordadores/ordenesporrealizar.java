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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import static sistemabordadores.ordenesrealizadas.btnactualizar;

public class ordenesporrealizar extends javax.swing.JFrame {

    public static boolean ventanaordenesbordadogenerada = false;
    String fechainicial = "";
    String fechafinal = "";
    String nombrecliente = "";
    String tiendalocal = "";
    String fotomontajeautorizado = "";
    public static String localuotrasucursal ="";

    public ordenesporrealizar() {
        initComponents();
        ventanaordenesbordadogenerada = true;
        lbinterface.setVisible(false);
        lbtienda.setVisible(false);
        btnactualizar.setVisible(false);
        btnfrente.setVisible(false);
        
        File file = new File("C:\\sistema\\configuracion.txt");
        try {
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String str[] = line.split(":");
                tiendalocal = str[1];
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        
          
        
        

    }
    
    
    void fechas()
    {
    
        Calendar now = Calendar.getInstance();
        int año = now.get(Calendar.YEAR);
        int mes = now.get(Calendar.MONTH) + 1 ;
        cbaño.setSelectedItem(String.valueOf(año));
        
        
               if(mes ==1)
               {
                   fechainicial = ""+año+"-01-01";
                   fechafinal = ""+año+"-01-31";   
                   cbmes.setSelectedItem("Enero");
               }
               else if(mes ==2)
               {
                   fechainicial = ""+año+"-02-01";
                   fechafinal = ""+año+"-02-29";  
                   cbmes.setSelectedItem("Febrero");
               }
               else if(mes ==3)
               {
                   fechainicial = ""+año+"-03-01";  
                   fechafinal = ""+año+"-03-31";  
                   cbmes.setSelectedItem("Marzo");
               }
               else if(mes ==4)
               {
                   fechainicial = ""+año+"-04-01";
                   fechafinal = ""+año+"-04-30"; 
                   cbmes.setSelectedItem("Abril");
               }
               else if(mes ==5)
               {
                   fechainicial = ""+año+"-05-01";  
                   fechafinal = ""+año+"-05-31"; 
                   cbmes.setSelectedItem("Mayo");
               }
               else if(mes ==6)
               {
                   fechainicial = ""+año+"-06-01";  
                   fechafinal = ""+año+"-06-30"; 
                   cbmes.setSelectedItem("Junio");
               }
               else if(mes ==7)
               {
                   fechainicial = ""+año+"-07-01"; 
                   fechafinal = ""+año+"-07-31"; 
                   cbmes.setSelectedItem("Julio");
               }
               else if(mes ==8)
               {
                   fechainicial = ""+año+"-08-01";
                   fechafinal = ""+año+"-08-31" ;
                   cbmes.setSelectedItem("Agosto");
               }
               else if(mes ==9)
               {
                   fechainicial = ""+año+"-09-01"; 
                   fechafinal = ""+año+"-09-30";  
                   cbmes.setSelectedItem("Septiembre");
               }
               else if(mes ==10)
               {
                   fechainicial = ""+año+"-10-01"; 
                   fechafinal = ""+año+"-10-31"; 
                   cbmes.setSelectedItem("Octubre");
               }
               else if(mes ==11)
               {
                   fechainicial = ""+año+"-11-01"; 
                   fechafinal = ""+año+"-11-30";  
                   cbmes.setSelectedItem("Noviembre");
               }
               else if(mes ==12)
               {
                   fechainicial = ""+año+"-12-01"; 
                   fechafinal = ""+año+"-12-31"; 
                   cbmes.setSelectedItem("Diciembre");
               }
               
        
        
    }
    

    void datos() {
        
        
        
        
        limpiartabla();

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       
        
        
        //// historial_orden_camisa
        
        String[] datos = new String[13];
        
        
        String sqlcamisa = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha,nombre_concepto  "
                         + "FROM historial_ordenes_camisa where lugar = 'Esta sucursal' "
                         + "and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by hora  ";

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
                datos[11] = rs.getString("nombre_concepto");

                modelo.addRow(datos);

            }

            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "sql orden camisa" +  ex);
        }

        
        //// historial_orden_gorra
        
        String[] datos2 = new String[12];
        
        String sqlgorra = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha,nombre_concepto  FROM historial_ordenes_gorra where lugar = 'Esta sucursal'  and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by hora";

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
                datos2[11] = rs.getString("nombre_concepto");

                modelo.addRow(datos2);

            }

           

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"sql orden gorra" +  ex);
        }
        
        //// historial_orden_pantalon
        
        
        String[] datos3 = new String[12];
        
         String sqlpantalon = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha,nombre_concepto  FROM historial_ordenes_pantalon where lugar = 'Esta sucursal' and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by hora";

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
                datos3[11] = rs.getString("nombre_concepto");

                modelo.addRow(datos3);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden pantalon" + ex);
        }
        
        
        //// historial_orden_parches
        
        String[] datos4 = new String[12];
        
        String sqlparches = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha,nombre_concepto  FROM historial_ordenes_parche where lugar = 'Esta sucursal'  and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by hora";

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
                datos4[11] = rs.getString("nombre_concepto");

                modelo.addRow(datos4);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden parche" + ex);
        }
      
         
           /// historial ordenes corbata
        
         String[] datos5 = new String[12];
        
        String sqlcorbata= "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha,nombre_concepto  FROM historial_ordenes_corbata where lugar = 'Esta sucursal'  and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by hora ";

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
                datos5[7] = "";
                datos5[8] = "";
                datos5[9] = "";
                datos5[10] = "Local";
                datos5[11] = rs.getString("nombre_concepto");

                modelo.addRow(datos5);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden corbata" + ex);
        }

         
         
       
        
              
        /// historial orden portanombres
        
        String[] datos7 = new String[12];
        
        String sqlportanombre= "SELECT Distinct numero,tipo,numero_venta,fecha  FROM historial_ordenes_portanombres where (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by hora ";

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
                datos7[11] = "Porta nombre";

                modelo.addRow(datos7);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden corbata" + ex);
        }


        /// historial´ portanombre multiple
        
        String[] datos8 = new String[12];

         String sqlportanombremultiple= "SELECT Distinct numero,tipo,numero_venta,fecha  FROM historial_ordenes_portanombres_multiple where (estatus_orden = 'generada' or estatus_orden = 'solicitada' ) and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by hora ";

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

                modelo.addRow(datos8);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden portanombremultiple" + ex);
        }        
     
        
        
        
            
         //// historial_orden_ponchado
         
         
         
         
         String[] datos6 = new String[13];
        
        String sqlponchados = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_ponchados where lugar = 'Esta sucursal'  and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by hora";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlponchados);
            while (rs.next()) {
                datos6[0] = rs.getString("numero");
                datos6[1] = rs.getString("cliente");
                datos6[2] = "Ponchado";
                datos6[3] = rs.getString("tipo");
                datos6[4] = rs.getString("lugar");
                datos6[5] = rs.getString("numero_venta");
                datos6[6] = rs.getString("fecha");
                datos6[7] = "";
                datos6[8] = "";
                datos6[9] = "";
                datos6[10] = "Local";
                datos6[11] = "Ponchado";

                modelo.addRow(datos6);

            }

            

        } catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null,"sql orden ponchado" + ex);
        }
        
        
        
        //// distinta
        
        
        
        
        String sqldistinta = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha,nombre_concepto  "
                         + "FROM historial_ordenes_distinta where lugar = 'Esta sucursal' "
                         + "and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by hora  ";

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
                datos[11] = rs.getString("nombre_concepto");

                modelo.addRow(datos);

            }

            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "sql orden camisa" +  ex);
        }
        
        
        
        // ORDENES DE OTRAS SUCURSALES
        //////////////////////////////
        /////////////////////////////
        
        
        
        //CAMISA
        
        
        String[] datos9 = new String[12];

        String sql3 = "SELECT numero,numero_sucursal,cliente,prenda,tipo,tienda,fecha,lugar  FROM historial_ordenes_camisa_recibidas where estatus_orden = 'generada' and fecha between '"+fechainicial+"' and '"+fechafinal+"' order by hora "; //and tienda not in('"+tiendalocal+"')

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
                datos9[8] = rs.getString("numero_sucursal");
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

        String sql4 = "SELECT numero,numero_sucursal,cliente,prenda,tipo,cliente,tienda,lugar,fecha,numero_sucursal_orden FROM historial_ordenes_gorra_recibidas  where estatus_orden = 'generada' and fecha between '"+fechainicial+"' and '"+fechafinal+"'  order by hora  ";

        try {
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql4);
            while (rs2.next()) 
            {
                datos10[0] = rs2.getString("numero");
                datos10[1] = rs2.getString("cliente");
                datos10[2] = rs2.getString("prenda");
                datos10[3] = rs2.getString("tipo");
                datos10[4] = rs2.getString("lugar");
                datos10[5] = "0000000";  
                datos10[6] = rs2.getString("fecha");
                datos10[7] = rs2.getString("tienda");
                datos10[8] = rs2.getString("numero_sucursal_orden");
                datos10[9] = "";
                datos10[10] = "Recibida";

                modelo.addRow(datos10);

            }


        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        tieneponchados();

        
        
        
        /// PANTALON
        
        String[] datos11 = new String[12];

        String sql15 = "SELECT numero,numero_sucursal,cliente,prenda,tipo,cliente,tienda,lugar,fecha,numero_sucursal_orden  FROM historial_ordenes_pantalon_recibidas  where estatus_orden = 'generada' and fecha between '"+fechainicial+"' and '"+fechafinal+"'   order by hora  ";

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
                datos11[8] = rs.getString("numero_sucursal_orden");
                datos11[9] = "";
                datos11[10] = "Recibida";
            
                modelo.addRow(datos11);

            }

            tabla.setModel(modelo);

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        tieneponchados();
        
        
        
        
      /*  
        TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabla.getModel());
        tabla.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>(100);
        sortKeys.add(new RowSorter.SortKey(6, SortOrder.DESCENDING));
        sorter.setSortKeys(sortKeys);
        
     */   
        
        Colorear ft = new Colorear();
        tabla.setDefaultRenderer(Object.class, ft);
        
        
    }
    
    
     void datos2() {
        
        
        
        
        limpiartabla();

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
       
        
        
        //// historial_orden_camisa
        
        String[] datos = new String[12];
        
        
        String sqlcamisa = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  "
                         + "FROM historial_ordenes_camisa where lugar = 'Otra sucursal' "
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
                datos[7] = "";
                datos[8] = "";
                datos[9] = "";
                datos[10] = "Local";

                modelo.addRow(datos);

            }

            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "sql orden camisa" +  ex);
        }

        
        //// historial_orden_gorra
        
        String[] datos2 = new String[12];
        
        String sqlgorra = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_gorra where lugar = 'Otra sucursal' and (estatus_orden = 'por solicitar' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

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
            JOptionPane.showMessageDialog(null,"sql orden gorra" +  ex);
        }
        
        //// historial_orden_pantalon
        
        
        String[] datos3 = new String[12];
        
         String sqlpantalon = "SELECT numero,cliente,prenda,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_pantalon where  lugar = 'Otra sucursal' and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

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
           JOptionPane.showMessageDialog(null,"sql orden pantalon" + ex);
        }
        
        
        //// historial_orden_parches
        
        String[] datos4 = new String[12];
        
        String sqlparches = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_parche where  lugar = 'Otra sucursal' and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

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
           JOptionPane.showMessageDialog(null,"sql orden parche" + ex);
        }
        
         //// historial_orden_ponchado
         
         
         String[] datos5 = new String[12];
        
        String sqlponchados = "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_ponchados where lugar = 'Otra sucursal' and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

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
           JOptionPane.showMessageDialog(null,"sql orden ponchado" + ex);
        }
        
        /// historial ordenes corbata
        
         String[] datos6 = new String[12];
        
        String sqlcorbata= "SELECT Distinct numero,cliente,tipo,lugar,numero_venta,fecha  FROM historial_ordenes_corbata where  lugar = 'Otra sucursal' and (estatus_orden = 'generada' or estatus_orden = 'solicitada') and fecha between '"+fechainicial+"' and '"+fechafinal+"' ";

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
           JOptionPane.showMessageDialog(null,"sql orden corbata" + ex);
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
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }
}
  
    
     void datoscombos()
     {
         Object mescombo = cbmes.getSelectedItem();
        Object año = cbaño.getSelectedItem();
        
          if(mescombo.equals("Enero"))
               {
                   fechainicial = ""+año+"-01-01";
                   fechafinal = ""+año+"-01-31";      
               }
               else if(mescombo.equals("Febrero"))
               {
                   fechainicial = ""+año+"-02-01";
                   fechafinal = ""+año+"-02-29";       
               }
               else if(mescombo.equals("Marzo"))
               {
                   fechainicial = ""+año+"-03-01";  
                   fechafinal = ""+año+"-03-31";       
               }
               else if(mescombo.equals("Abril"))
               {
                   fechainicial = ""+año+"-04-01";
                   fechafinal = ""+año+"-04-30";     
               }
               else if(mescombo.equals("Mayo"))
               {
                   fechainicial = ""+año+"-05-01";  
                   fechafinal = ""+año+"-05-31";         
               }
               else if(mescombo.equals("Junio"))
               {
                   fechainicial = ""+año+"-06-01";  
                   fechafinal = ""+año+"-06-30";         
               }
               else if(mescombo.equals("Julio"))
               {
                   fechainicial = ""+año+"-07-01"; 
                   fechafinal = ""+año+"-07-31";        
               }
               else if(mescombo.equals("Agosto"))
               {
                   fechainicial = ""+año+"-08-01";
                   fechafinal = ""+año+"-08-31" ;       
               }
               else if(mescombo.equals("Septiembre"))
               {
                   fechainicial = ""+año+"-09-01"; 
                   fechafinal = ""+año+"-09-30";       
               }
               else if(mescombo.equals("Octubre"))
               {
                   fechainicial = ""+año+"-10-01"; 
                   fechafinal = ""+año+"-10-31";      
               }
               else if(mescombo.equals("Noviembre"))
               {
                   fechainicial = ""+año+"-11-01"; 
                   fechafinal = ""+año+"-11-30";        
               }
               else if(mescombo.equals("Diciembre"))
               {
                   fechainicial = ""+año+"-12-01"; 
                   fechafinal = ""+año+"-12-31";        
               }
          
          
             if(localuotrasucursal.equals("Local"))
        {
           datos(); 
        }
        else
        {
           datos2(); 
        }  
         
     }
             
    
     void autorizaciondelfotomontaje(String numerofolio,String nombre_tabla)
     {
         String sqlcamisa = "SELECT fotomontaje_autorizado FROM "+nombre_tabla+" where numero = '"+numerofolio+"'  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcamisa);
            if (rs.next()) 
            {
               fotomontajeautorizado = rs.getString("fotomontaje_autorizado");
                
            }

            

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "sql fotomontajeautorizado" +  ex);
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
        cbmes = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbaño = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ordenes por realizar");
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
            tabla.getColumnModel().getColumn(1).setMinWidth(100);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(350);
            tabla.getColumnModel().getColumn(1).setMaxWidth(700);
            tabla.getColumnModel().getColumn(3).setMinWidth(0);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(3).setMaxWidth(0);
            tabla.getColumnModel().getColumn(4).setMinWidth(0);
            tabla.getColumnModel().getColumn(4).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(4).setMaxWidth(0);
            tabla.getColumnModel().getColumn(5).setMinWidth(0);
            tabla.getColumnModel().getColumn(5).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(5).setMaxWidth(0);
            tabla.getColumnModel().getColumn(6).setMinWidth(0);
            tabla.getColumnModel().getColumn(6).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(6).setMaxWidth(0);
            tabla.getColumnModel().getColumn(8).setMinWidth(0);
            tabla.getColumnModel().getColumn(8).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(8).setMaxWidth(0);
            tabla.getColumnModel().getColumn(10).setMinWidth(0);
            tabla.getColumnModel().getColumn(10).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(10).setMaxWidth(0);
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

        cbmes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre" }));
        cbmes.setSelectedIndex(-1);
        cbmes.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbmesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbmesPopupMenuWillBecomeVisible(evt);
            }
        });
        cbmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmesActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Mes");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Año");

        cbaño.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbaño.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        cbaño.setSelectedIndex(-1);
        cbaño.setToolTipText("");
        cbaño.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbañoPopupMenuWillBecomeInvisible(evt);
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
                        .addComponent(btnfrente, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnactualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbinterface, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(210, 210, 210)
                        .addComponent(lbtienda, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(cbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(cbaño, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnumero)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbaño, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 780, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        fechas();
        
        if(localuotrasucursal.equals("Local"))
        {
           datos(); 
        }
        else
        {
           datos2(); 
        }  
    }//GEN-LAST:event_formWindowOpened

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        if (evt.getClickCount() == 2) {

            int fila = tabla.getSelectedRow();

            if (fila >= 0) 
            {

                Object tipo = tabla.getValueAt(fila, 3).toString();
                Object tablanombre = tabla.getValueAt(fila, 10).toString();

                if (tipo.equals("Orden camisa")||tipo.equals("Orden Camisa")) 
                {
                    if (ordencamisa.ventanaordencamisaanteriores == true) 
                    {
                        
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de orden de camisa anteriores");

                    }
                    else 
                    {
                        
                        Object numerodefolio = tabla.getValueAt(fila, 0);
                        Object nombre_tabla = "historial_ordenes_camisa";
                        autorizaciondelfotomontaje((String)numerodefolio,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal")||tablanombre.equals("Recibida"))
                        {
                        
                        ordencamisa orden = new ordencamisa();
                        orden.setVisible(true);

                        ordencamisa.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                        ordencamisa.lbnumeroventa.setText(tabla.getValueAt(fila, 5).toString());
                        ordencamisa.lbprenda.setText(tabla.getValueAt(fila, 2).toString());
                        ordencamisa.lbtipo.setText(tabla.getValueAt(fila, 3).toString());
                        ordencamisa.enquesucursalsebordara=(tabla.getValueAt(fila, 4).toString());
                        ordencamisa.tipotabla=(tabla.getValueAt(fila, 10).toString());
                        tabla.clearSelection();
                        this.setState(this.ICONIFIED);
                        
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Este bordado aun no se ah autorizado; consulte al encargado");   
                        }    
                        
                        
                       
                    }

                
                }
               
                
                else if (tipo.equals("Orden gorra")||tipo.equals("Orden Gorra")) 
                {
                    if (ordengorra.ventanaordengorra == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de orden de gorra anteriores");

                    }
                    else 
                    {
                        
                        Object numerodefolio = tabla.getValueAt(fila, 0);
                        Object nombre_tabla = "historial_ordenes_gorra";
                        autorizaciondelfotomontaje((String)numerodefolio,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal")||tablanombre.equals("Recibida"))
                        {

                        ordengorra orden = new ordengorra();
                        orden.setVisible(true);

                        ordengorra.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                        ordengorra.lbnumeroventa.setText(tabla.getValueAt(fila, 5).toString());
                        ordengorra.lbprenda.setText(tabla.getValueAt(fila, 2).toString());
                        ordengorra.lbtipo.setText(tabla.getValueAt(fila, 3).toString());
                        ordengorra.enquesucursalsebordara=(tabla.getValueAt(fila, 4).toString());
                        ordengorra.tipotabla=(tabla.getValueAt(fila, 10).toString());
                        tabla.clearSelection();
                        this.setState(this.ICONIFIED);
                         
                        } 
                        else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Este bordado aun no se ah autorizado; consulte al encargado");   
                        }    
                        
                    }
                }
                
                else if (tipo.equals("Orden pantalon")) {
                    if (ordenpantalon.ventanaordenpantalonanteriores == true) 
                    {
                        
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\"> Favor de cerrar la ventana de orden de pantalones");

                    } 
                    
                    else
                    {
                        
                        
                        Object numerodefolio = tabla.getValueAt(fila, 0);
                        Object nombre_tabla = "historial_ordenes_pantalon";
                        autorizaciondelfotomontaje((String)numerodefolio,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal")||tablanombre.equals("Recibida"))
                        {
                             ordenpantalon orden = new ordenpantalon();
                            orden.setVisible(true);

                            ordenpantalon.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                            ordenpantalon.lbnumeroventa.setText(tabla.getValueAt(fila, 5).toString());
                            ordenpantalon.lbtipo.setText(tabla.getValueAt(fila, 3).toString());
                            ordenpantalon.enquesucursalsebordara = (tabla.getValueAt(fila, 4).toString());
                            ordenpantalon.tipotabla = (tabla.getValueAt(fila, 10).toString());
                            tabla.clearSelection();
                            this.setState(this.ICONIFIED);
                            
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Este bordado aun no se ah autorizado; consulte al encargado");   
                        }
                       
                    }

                
                } 
                
                
                else if (tipo.equals("Orden ponchado")) 
                {
                    if (ordenponchado.ventanaordenparcheanteriores == true) 
                    {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de orden de ponchado anteriores");

                    }
                    else 
                    {
                        
                        Object numerodefolio = tabla.getValueAt(fila, 0);
                        Object nombre_tabla = "historial_ordenes_ponchados";
                        autorizaciondelfotomontaje((String)numerodefolio,(String) nombre_tabla);
                        
                         if (fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal")||tablanombre.equals("Recibida")) {
                            ordenponchado orden = new ordenponchado();
                            orden.setVisible(true);

                            ordenponchado.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                            ordenponchado.lbnumeroventa.setText(tabla.getValueAt(fila, 5).toString());
                            tabla.clearSelection();
                            this.setState(this.ICONIFIED);
                         }
                         else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Este bordado aun no se ah autorizado; consulte al encargado");   
                        }  
                        
                    }
                }
                
                else if (tipo.equals("Orden parche")||tipo.equals("Parche")) 
                {
                    if (ordenparche.ventanaordenparcheanteriores == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de orden de ponchado anteriores");

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
                   
                        
                        if (ordencorbata.ventanaordencorbataanteriores == true) 
                        {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de orden de corbata anteriores");

                        }
                        else 
                        {
                        
                        Object numerodefolio = tabla.getValueAt(fila, 0);
                        Object nombre_tabla = "historial_ordenes_corbata";
                        autorizaciondelfotomontaje((String)numerodefolio,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal"))
                        {    
                            
                        ordencorbata orden = new ordencorbata();
                        orden.setVisible(true);

                        ordencorbata.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                        ordencorbata.lbnumeroventa.setText(tabla.getValueAt(fila, 5).toString());
                        ordencamisa.enquesucursalsebordara=(tabla.getValueAt(fila, 4).toString());
                        ordencamisa.tipotabla=(tabla.getValueAt(fila, 10).toString());
                        
                         tabla.clearSelection();
                         this.setState(this.ICONIFIED);
                        
                        }
                         else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Este bordado aun no se ah autorizado; consulte al encargado");   
                        }   
                         
                    }
                        
                 
                   
                }
                else if (tipo.equals("Porta nombre escolar")) 
                {
                   
                        
                   if (ordenportanombreescolar.ventanaordenportanombreanterior == true) 
                   {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de orden de portanombre");

                   } else 
                   
                   {
                       Object numerodefolio = tabla.getValueAt(fila, 0);
                        Object nombre_tabla = "historial_ordenes_portanombres";
                        autorizaciondelfotomontaje((String)numerodefolio,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal"))
                        {
                       
                            ordenportanombreescolar orden = new ordenportanombreescolar();
                            orden.setVisible(true);
                            ordenportanombreescolar.lbnumero.setText(tabla.getValueAt(fila, 0).toString());
                            tabla.clearSelection();
                            this.setState(this.ICONIFIED);
                        }
                         else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Este bordado aun no se ah autorizado; consulte al encargado");   
                        }     
                            
                        
                    }
                                           
                }
                else if (tipo.equals("porta nombre multiple")) 
                {
                   
                        
                    if (ordenportanombremultiple.ventanaordenportanombremultipleanterior == true) 
                    {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de orden de portanombre");

                    } 
                    else 
                    {
                         Object numerodefolio = tabla.getValueAt(fila, 0);
                        Object nombre_tabla = "historial_ordenes_portanombres_multiple";
                        autorizaciondelfotomontaje((String)numerodefolio,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal"))
                        {
                        
                            ordenportanombremultiple orden = new ordenportanombremultiple();
                            orden.setVisible(true);
                            ordenportanombremultiple.lbnumerohistorialordenesbordados.setText(tabla.getValueAt(fila, 0).toString());
                            tabla.clearSelection();
                            this.setState(this.ICONIFIED);
                        }    
                          else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Este bordado aun no se ah autorizado; consulte al encargado");   
                        }     
                            
                        
                    }
                                           
                }
                else
                {
                   
                    
                    
                    if (ordendistinta.ventanaordencamisaanteriores == true) 
                    {
                        
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de orden distinta");

                    }
                    else 
                    {
                        
                        Object numerodefolio = tabla.getValueAt(fila, 0);
                        Object nombre_tabla = "historial_ordenes_distinta";
                        autorizaciondelfotomontaje((String)numerodefolio,(String) nombre_tabla);
                        
                        
                        if(fotomontajeautorizado.equals("si")||localuotrasucursal.equals("Otra Sucursal"))
                        {
                        
                        ordendistinta orden = new ordendistinta();
                        orden.setVisible(true);

                        ordendistinta.lbfolio.setText(tabla.getValueAt(fila, 0).toString());
                        ordendistinta.lbnumeroventa.setText(tabla.getValueAt(fila, 5).toString());
                        ordendistinta.lbprenda.setText(tabla.getValueAt(fila, 2).toString());
                        ordendistinta.lbtipo.setText(tabla.getValueAt(fila, 3).toString());
                        ordendistinta.enquesucursalsebordara=(tabla.getValueAt(fila, 4).toString());
                        ordendistinta.tipotabla=(tabla.getValueAt(fila, 10).toString());
                        tabla.clearSelection();
                        this.setState(this.ICONIFIED);
                        
                        }
                        else
                        {
                          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Este bordado aun no se ah autorizado; consulte al encargado");   
                        }    
                        
                        
                       
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
       if(localuotrasucursal.equals("Local"))
        {
           datos(); 
        }
        else
        {
           datos2(); 
        }    
    }//GEN-LAST:event_btnactualizarActionPerformed

    private void btnfrenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfrenteActionPerformed
        this.toFront();
    }//GEN-LAST:event_btnfrenteActionPerformed

    private void tablaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tablaKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_F5) 
        {
            btnactualizar.doClick();
        }
    }//GEN-LAST:event_tablaKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
          if (evt.getKeyCode() == KeyEvent.VK_F5) 
        {
            btnactualizar.doClick();
        }
    }//GEN-LAST:event_formKeyPressed

    private void cbmesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbmesPopupMenuWillBecomeInvisible

        datoscombos();
        
      
    }//GEN-LAST:event_cbmesPopupMenuWillBecomeInvisible

    private void cbmesPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbmesPopupMenuWillBecomeVisible

    }//GEN-LAST:event_cbmesPopupMenuWillBecomeVisible

    private void cbmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbmesActionPerformed

    private void cbañoPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbañoPopupMenuWillBecomeInvisible

       datoscombos();
    }//GEN-LAST:event_cbañoPopupMenuWillBecomeInvisible

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
    private javax.swing.JComboBox<String> cbaño;
    private javax.swing.JComboBox<String> cbmes;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JLabel lbinterface;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbtienda;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
connectar cc = new connectar();
Connection cn = cc.conexion();

}
