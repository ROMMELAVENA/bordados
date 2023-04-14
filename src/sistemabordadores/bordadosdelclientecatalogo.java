package sistemabordadores;

import java.awt.Component;
import java.awt.Desktop;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.DefaultComboBoxModel;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

public class bordadosdelclientecatalogo extends javax.swing.JFrame {

    public static boolean ventanabordadosdelclientecatalogonuevo = false;
    public static String dedondevengo = "";
    String rutaarchivo = "";
    String nombrearchivo = "";
    String prenda ="";
    String prendafotomontaje = "";
    String nombreprendafotomontaje = "";
    /// string cliente
    String codigocliente = "";
    public static ArrayList<String> lista = new ArrayList<String>();
    
    public static ArrayList<String> listadistinta = new ArrayList<String>();
    
    
    String []datos = new String [23]; 
    DefaultTableModel modelo = null;
    
    String consecutivo = "00000000";
    
    Object prendacombo = "";
    

    public bordadosdelclientecatalogo() 
    {
        initComponents();
        ventanabordadosdelclientecatalogonuevo = true;
        bntmaximizar.setVisible(false);
        lbinterface.setVisible(false);
        lbcodigocliente.setVisible(false);
        btndatos.setVisible(false);
        comboprendas();
        comboclientes();
      
      
      
    }
    
    
    
    
    
    void comboprendas(){

        cbprenda.removeAllItems();

         try {
                
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
           
            
            String descripcion = "";

            String sql = "SELECT descripcion FROM catalogo_prenda_bordados ORDER BY codigo";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                
              descripcion = rs.getString("descripcion");
              
              
                if (descripcion.equals("")  ||   descripcion.equals(" "))
                {
                }
                else
                {

                modelo.addElement(descripcion);
              
                
                }
            }

            
            
            
            
            String sql2 = "SELECT distinct tipo FROM bordados_puntadas where prenda_especial = 'DISTINTA'";

            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            while (rs2.next()) {
                
                
              descripcion = rs2.getString("tipo");
             
              listadistinta.add(descripcion);

                modelo.addElement(descripcion);
              
               
            }

            
            
            cbprenda.setModel(modelo);
            AutoCompleteDecorator.decorate(cbprenda);
            cbprenda.addItem("TODOS");
            cbprenda.setSelectedItem("TODOS");
            cbprenda.setEditable(false);
            
           
            
            
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
        
    }
    
    void comboclientes(){

        cbcomboclientes.removeAllItems();
        DefaultComboBoxModel modelocombo = new DefaultComboBoxModel();
        String nombre = "";

         try {
            String sql = "SELECT DISTINCT nombre FROM bordados_puntadas ORDER BY nombre";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                
              nombre = rs.getString("nombre");
              
              
                if (nombre.equals("")  ||   nombre.equals(" "))
                {
                }
                else
                {

                modelocombo.addElement(nombre);
              
                
                }
            }


            
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

         
        cbcomboclientes.setModel(modelocombo);
        AutoCompleteDecorator.decorate(cbcomboclientes);
        cbcomboclientes.setSelectedIndex(-1);
        
        
    }
    
    

    void limpiarstringdatos()
    {
        datos[0] = "";
        datos[1] = "";
        datos[2] = "";
        datos[3] = "";
        datos[4] = "";
        datos[5] = "";
        datos[6] = "";
        datos[7] = "";
        datos[8] = "";
        datos[9] = "";
        datos[10] = "";
        datos[11] = "";
        datos[12] = "";
        datos[13] = "";
        datos[14] = "";
        datos[15] = "";
        datos[16] = "";
        datos[17] = "";
        datos[18] = "";
        datos[19] = "";

        
    }


     
    void datosdetodoslosbordadosdetodaslasprendas()
    {
        
        Object codigocliente = lbcodigocliente.getText();
    
        
        
        String bordado1 = "";
        String bordado2 = "";
        String bordado3 = "";
        String bordado4 = "";
        String bordado5 = "";
        String bordado6 = "";
        String bordado7 = "";
      
        
        String tipo = "";
        String nombre ="";
     
        
        

        String  sql = "SELECT tipo,nombre_bordado,pecho_izquierdo_nombre,pecho_derecho_nombre,manga_derecha_nombre,manga_izquierda_nombre,espalda_nombre,otra_ubicacion_nombre,otra_ubicacion2_nombre,"
                + "frente_nombre,lado_izquierdo_nombre,lado_derecho_nombre,atras_nombre,"
                + "pantalon_lado_izquierdo_frente_nombre,pantalon_lado_derecho_frente_nombre,pantalon_lado_izquierdo_atras_nombre,pantalon_lado_derecho_atras_nombre,"
                + "corbata_frente_nombre,parche_nombre, parche_aplicacion, parche_aplicacion_color,"
                + "distinta1_nombre,distinta2_nombre,distinta3_nombre,distinta4_nombre,distinta5_nombre,distinta6_nombre,distinta6_nombre,distinta7_nombre,"
                + "numero_consecutivo FROM bordados_puntadas where codigo = '" + codigocliente + "' order by tipo ";    
         
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            System.out.println(sql);
            while (rs.next()) {

                tipo =rs.getString("tipo");  
                nombre = rs.getString("nombre_bordado");
                consecutivo = rs.getString("numero_consecutivo");
                
                
                
                
                
                
                // CAMISA
                
                
                if(tipo.equals("CAMISA") || tipo.equals("PLAYERA") || tipo.equals("CAMISOLA") || tipo.equals("CHAMARRA DESMONTABLE") || tipo.equals("CHAMARRA ROMPEVIENTOS") || tipo.equals("FILIPINA") || tipo.equals("FILIPINA") || tipo.equals("CHALECO")  || tipo.equals("MANDIL"))        
                        
                        
                {    
                
                bordado1 = rs.getString("pecho_izquierdo_nombre");
                bordado2 = rs.getString("pecho_derecho_nombre");
                bordado3 = rs.getString("manga_derecha_nombre");
                bordado4 = rs.getString("manga_izquierda_nombre");
                bordado5 = rs.getString("espalda_nombre");
                bordado6 = rs.getString("otra_ubicacion_nombre");
                bordado7 = rs.getString("otra_ubicacion2_nombre");
                
                if (bordado1.equals("ninguno") && bordado2.equals("ninguno") && bordado3.equals("ninguno") && bordado4.equals("ninguno") && bordado5.equals("ninguno") && bordado6.equals("ninguno") && bordado7.equals("ninguno") ) 
                {   //
                    
                } 
                else
                {
                    
                    if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                     if(bordado2.equals("ninguno"))
                    {
                        bordado2 = "";
                    }
                      if(bordado3.equals("ninguno"))
                    {
                        bordado3 = "";
                    }
                       if(bordado4.equals("ninguno"))
                    {
                        bordado4 = "";
                    }
                     if(bordado5.equals("ninguno"))
                    {
                        bordado5 = "";
                    }
                      if(bordado6.equals("ninguno"))
                    {
                        bordado6 = "";
                    }
                       if(bordado7.equals("ninguno"))
                    {
                        bordado7 = "";
                    }
                       
                    
                    lista.add(nombre);
                    datos[0] = tipo;
                    datos[1] = nombre;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = bordado1;
                    datos[6] = bordado2;
                    datos[7] = bordado3;
                    datos[8] = bordado4;
                    datos[9] = bordado5;
                    datos[10] = bordado6;
                    datos[11] = bordado7;
                    datos[12] = "";
                    datos[13] = "";
                    datos[14] = "";
                    datos[15] = "";
                    datos[16] = "";
                    datos[17] = "";
                    datos[18] = consecutivo;
                    modelo.addRow(datos);
                    
                } 
                
               
                }
                
                
                
                else
                
                
                
                
                
                // PANTALON
                
                
                if(tipo.equals("PANTALON"))
                {
                
                bordado1 = rs.getString("pantalon_lado_izquierdo_frente_nombre");
                bordado2 = rs.getString("pantalon_lado_derecho_frente_nombre");
                bordado3 = rs.getString("pantalon_lado_izquierdo_atras_nombre");
                bordado4 = rs.getString("pantalon_lado_derecho_atras_nombre");
                
                
                if (bordado1.equals("ninguno") && bordado2.equals("ninguno") && bordado3.equals("ninguno") && bordado4.equals("ninguno")  ) 
                {   //
                    
                } 
                else
                {
                    if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                     if(bordado2.equals("ninguno"))
                    {
                        bordado2 = "";
                    }
                      if(bordado3.equals("ninguno"))
                    {
                        bordado3 = "";
                    }
                       if(bordado4.equals("ninguno"))
                    {
                        bordado4 = "";
                    }
                    
                    lista.add(nombre);
                    datos[0] = tipo;
                    datos[1] = nombre; 
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[8] = "";
                    datos[9] = bordado1;
                    datos[10] = bordado2;
                    datos[11] = bordado3;
                    datos[12] = bordado4;
                    datos[18] = consecutivo;
                    
                    modelo.addRow(datos);
                    
                } 
                    
                }
                
                
                
                
                
                
                
                
                
                // SI ES GORRA
                
                else if(tipo.equals("GORRA"))
                {
                
                bordado1 = rs.getString("frente_nombre");
                bordado2 = rs.getString("lado_izquierdo_nombre");
                bordado3 = rs.getString("lado_derecho_nombre");
                bordado4 = rs.getString("atras_nombre");
                
                
                if (bordado1.equals("ninguno") && bordado2.equals("ninguno") && bordado3.equals("ninguno") && bordado4.equals("ninguno")  ) 
                {   //
                    
                } 
                else
                {
                    
                    if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                     if(bordado2.equals("ninguno"))
                    {
                        bordado2 = "";
                    }
                      if(bordado3.equals("ninguno"))
                    {
                        bordado3 = "";
                    }
                       if(bordado4.equals("ninguno"))
                    {
                        bordado4 = "";
                    }
                    
                    lista.add(nombre);
                    datos[0] = tipo;
                    datos[1] = nombre;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[8] = "";
                    datos[9] = "";
                    datos[10] = "";
                    datos[11] = "";
                    datos[12] = "";
                    datos[13] = bordado1;
                    datos[14] = bordado2;
                    datos[15] = bordado3;
                    datos[16] = bordado4;
                    datos[17] = "";
                    datos[18] = consecutivo;
                    
                    modelo.addRow(datos);
                    
                } 
                    
                }
                
                
                // SI ES CORBATA
                
                
                else if(tipo.equals("CORBATA"))
                {
                
                bordado1 = rs.getString("corbata_frente_nombre");
                
                
                
                if (bordado1.equals("ninguno")   ) 
                {   //
                    
                } 
                else
                {
                    
                    if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                    
                    
                    lista.add(nombre);
                    datos[0] = tipo;
                    datos[1] = nombre; 
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[8] = "";
                    datos[9] = "";
                    datos[10] = "";
                    datos[11] = "";
                    datos[12] = "";
                    datos[13] = "";
                    datos[14] = "";
                    datos[15] = "";
                    datos[16] = "";
                    datos[17] = bordado1;
                    datos[18] = consecutivo;
                    
                    
                    modelo.addRow(datos);
                    
                } 
                    
                }
                
                
                
                
                
                
                
                
                
                
                
                
                
                // SI ES PARCHE
                
                  else
                    
                    
                    if(tipo.equals("PARCHE"))
                {
                
                bordado1 = rs.getString("parche_nombre");
               
                
                
                if (bordado1.equals("ninguno") && bordado2.equals("ninguno") && bordado3.equals("ninguno") && bordado4.equals("ninguno")  ) 
                {   //
                    
                } 
                else
                {
                    
                    if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                  
                    
                    lista.add(nombre);
                    datos[0] = tipo;
                    datos[1] = nombre;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[8] = "";
                    datos[9] = "";
                    datos[10] = "";
                    datos[11] = "";
                    datos[12] = "";
                    datos[13] = bordado1;
                    datos[14] ="";
                    datos[15] ="";
                    datos[16] ="";
                    datos[17] = "";
                    datos[18] = consecutivo;
                    
                    modelo.addRow(datos);
                    
                } 
                    
                }
                
                
               
                
                
                // DISTINTA
                
                else
                        
            
                        
                {    
                
                bordado1 = rs.getString("distinta1_nombre");
                bordado2 = rs.getString("distinta2_nombre");
                bordado3 = rs.getString("distinta3_nombre");
                bordado4 = rs.getString("distinta4_nombre");
                bordado5 = rs.getString("distinta5_nombre");
                bordado6 = rs.getString("distinta6_nombre");
                bordado7 = rs.getString("distinta7_nombre");
                
                if (bordado1.equals("ninguno") && bordado2.equals("ninguno") && bordado3.equals("ninguno") && bordado4.equals("ninguno") && bordado5.equals("ninguno") && bordado6.equals("ninguno") && bordado7.equals("ninguno") ) 
                {   //
                    
                } 
                else
                {
                    
                    if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                     if(bordado2.equals("ninguno"))
                    {
                        bordado2 = "";
                    }
                      if(bordado3.equals("ninguno"))
                    {
                        bordado3 = "";
                    }
                       if(bordado4.equals("ninguno"))
                    {
                        bordado4 = "";
                    }
                     if(bordado5.equals("ninguno"))
                    {
                        bordado5 = "";
                    }
                      if(bordado6.equals("ninguno"))
                    {
                        bordado6 = "";
                    }
                       if(bordado7.equals("ninguno"))
                    {
                        bordado7 = "";
                    }
                       
                    
                    lista.add(nombre);
                    datos[0] = tipo;
                    datos[1] = nombre; 
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = bordado1;
                    datos[6] = bordado2;
                    datos[7] = bordado3;
                    datos[8] = bordado4;
                    datos[9] = bordado5;
                    datos[10] = bordado6;
                    datos[11] = bordado7;
                    datos[12] = "";
                    datos[13] = "";
                    datos[14] = "";
                    datos[15] = "";
                    datos[16] = "";
                    datos[17] = "";
                    datos[18] = consecutivo;
                 
                    modelo.addRow(datos);
                    
                } 
                
               
                }
                
                
                
                
                

                
            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        
        ////
        
        
        
        tabla.getColumnModel().getColumn(0).setMinWidth(150);
        tabla.getColumnModel().getColumn(0).setMaxWidth(500);
        tabla.getColumnModel().getColumn(0).setWidth(250);
       
        
        tabla.getColumnModel().getColumn(1).setMinWidth(350);
        tabla.getColumnModel().getColumn(1).setMaxWidth(800);
        tabla.getColumnModel().getColumn(1).setWidth(400);
        
        
         tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(3).setWidth(0);
        
        
        /*
        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0);
        
        
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(3).setWidth(0);
        
        
        
        tabla.getColumnModel().getColumn(4).setMinWidth(90);
        tabla.getColumnModel().getColumn(4).setMaxWidth(90);
        tabla.getColumnModel().getColumn(4).setWidth(350);
        
        */
       
        /*
        
         tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMaxWidth(0);
        tabla.getColumnModel().getColumn(5).setWidth(0);
        
       tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMaxWidth(0);
        tabla.getColumnModel().getColumn(6).setWidth(0);
        
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setMaxWidth(0);
        tabla.getColumnModel().getColumn(7).setWidth(0);
        
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.getColumnModel().getColumn(8).setWidth(0);
        
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        tabla.getColumnModel().getColumn(9).setWidth(0);
        
        tabla.getColumnModel().getColumn(10).setMinWidth(0);
        tabla.getColumnModel().getColumn(10).setMaxWidth(0);
        tabla.getColumnModel().getColumn(10).setWidth(0);
        
        
        tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMaxWidth(0);
        tabla.getColumnModel().getColumn(11).setWidth(0);
        
        tabla.getColumnModel().getColumn(12).setMinWidth(0);
        tabla.getColumnModel().getColumn(12).setMaxWidth(0);
        tabla.getColumnModel().getColumn(12).setWidth(0);
        
        
        
       
        tabla.getColumnModel().getColumn(13).setMinWidth(0);
        tabla.getColumnModel().getColumn(13).setMaxWidth(0);
        tabla.getColumnModel().getColumn(13).setWidth(0);
        
        tabla.getColumnModel().getColumn(14).setMinWidth(0);
        tabla.getColumnModel().getColumn(14).setMaxWidth(0);
        tabla.getColumnModel().getColumn(14).setWidth(0);
        
        
        */
        tabla.getColumnModel().getColumn(15).setMinWidth(0);
        tabla.getColumnModel().getColumn(15).setMaxWidth(0);
        tabla.getColumnModel().getColumn(15).setWidth(0);
        
        tabla.getColumnModel().getColumn(16).setMinWidth(0);
        tabla.getColumnModel().getColumn(16).setMaxWidth(0);
        tabla.getColumnModel().getColumn(16).setWidth(0);
        
        tabla.getColumnModel().getColumn(17).setMinWidth(0);
        tabla.getColumnModel().getColumn(17).setMaxWidth(0);
        tabla.getColumnModel().getColumn(17).setWidth(0);
        
        tabla.getColumnModel().getColumn(18).setMinWidth(0);
        tabla.getColumnModel().getColumn(18).setMaxWidth(0);
        tabla.getColumnModel().getColumn(18).setWidth(0);
        
        tabla.getColumnModel().getColumn(19).setMinWidth(0);
        tabla.getColumnModel().getColumn(19).setMaxWidth(0);
        tabla.getColumnModel().getColumn(19).setWidth(0);
        
        
       
        
         TableColumn agregarColumn1;
        agregarColumn1 = tabla.getColumnModel().getColumn(2);
        agregarColumn1.setCellEditor(new bordadosdelclientecatalogoAgregar(tabla));
        agregarColumn1.setCellRenderer(new bordadosdelclientecatalogobotonagregar(true)); 
                                           
        
        
        
        
        TableColumn agregarColumn;
        agregarColumn = tabla.getColumnModel().getColumn(3);
        agregarColumn.setCellEditor(new bordadosdelclientecatalogoEditar(tabla));
        agregarColumn.setCellRenderer(new bordadosdelclientecatalogobotoneditar(true));
        
        
        
        TableColumn agregarColumn2;
        agregarColumn2 = tabla.getColumnModel().getColumn(4);
        agregarColumn2.setCellEditor(new bordadosdelclientecatalogoVer(tabla));
        agregarColumn2.setCellRenderer(new bordadosdelclientecatalogobotonver(true));
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
   
    void datoscamisas()
    {
        
        Object codigocliente = lbcodigocliente.getText();
    
        Object tipoprenda = cbprenda.getSelectedItem();
        
        
        
        
        
        String bordado1 = "";
        String bordado2 = "";
        String bordado3 = "";
        String bordado4 = "";
        String bordado5 = "";
        String bordado6 = "";
        String bordado7 = "";
       
    
        String nombre ="";
        
        

        String  sql = "SELECT nombre_bordado,pecho_izquierdo_nombre,pecho_derecho_nombre,manga_derecha_nombre,manga_izquierda_nombre,espalda_nombre,otra_ubicacion_nombre,otra_ubicacion2_nombre,numero_consecutivo FROM bordados_puntadas where codigo = '" + codigocliente + "' and tipo = '"+tipoprenda+"'  ";    
         
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                nombre = rs.getString(1); 
                bordado1 = rs.getString(2);
                bordado2 = rs.getString(3);
                bordado3 = rs.getString(4);
                bordado4 = rs.getString(5);
                bordado5 = rs.getString(6);
                bordado6 = rs.getString(7);
                bordado7 = rs.getString(8); 
               consecutivo = rs.getString("numero_consecutivo");

                
               
                if (bordado1.equals("ninguno") && bordado2.equals("ninguno") && bordado3.equals("ninguno") && bordado4.equals("ninguno") && bordado5.equals("ninguno") && bordado6.equals("ninguno") && bordado7.equals("ninguno") ) 
                {   //
                    
                } 
                else
                {
                    
                    
                     if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                     if(bordado2.equals("ninguno"))
                    {
                        bordado2 = "";
                    }
                      if(bordado3.equals("ninguno"))
                    {
                        bordado3 = "";
                    }
                       if(bordado4.equals("ninguno"))
                    {
                        bordado4 = "";
                    }
                     if(bordado5.equals("ninguno"))
                    {
                        bordado5 = "";
                    }
                      if(bordado6.equals("ninguno"))
                    {
                        bordado6 = "";
                    }
                       if(bordado7.equals("ninguno"))
                    {
                        bordado7 = "";
                    }
                    
                    
                    lista.add(nombre);
                    datos[0] = nombre;
                    datos[4] = bordado1;
                    datos[5] = bordado2;
                    datos[6] = bordado3;
                    datos[7] = bordado4;
                    datos[8] = bordado5;
                    datos[9] = bordado6;
                    datos[10] = bordado7;
                    datos[11] = consecutivo;
                    modelo.addRow(datos);
                    
                } 
                    
                
                
            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        

        
        

    }
    
    
    
    
    
    void datospantalones()
    {
        
        Object codigocliente = lbcodigocliente.getText();
        String sql = "";

        String bordado1 = "";
        String bordado2 = "";
        String bordado3 = "";
        String bordado4 = "";
       
        String nombre ="";
        
        

        //pantlaon
     
              
           
            sql = "SELECT nombre_bordado,pantalon_lado_izquierdo_frente_nombre,pantalon_lado_derecho_frente_nombre,pantalon_lado_izquierdo_atras_nombre,pantalon_lado_derecho_atras_nombre,numero_consecutivo FROM bordados_puntadas where codigo = '" + codigocliente + "' and tipo = 'PANTALON'";
           
          
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                nombre= rs.getString(1);
                bordado1 = rs.getString(2);
                bordado2 = rs.getString(3);
                bordado3 = rs.getString(4);
                bordado4 = rs.getString(5);
               consecutivo = rs.getString("numero_consecutivo");
                

               
                 if (bordado1.equals("ninguno") && bordado2.equals("ninguno") && bordado3.equals("ninguno") && bordado4.equals("ninguno")) 
                {   //
                    
                } 
                else
                {
                    
                     if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                     if(bordado2.equals("ninguno"))
                    {
                        bordado2 = "";
                    }
                      if(bordado3.equals("ninguno"))
                    {
                        bordado3 = "";
                    }
                       if(bordado4.equals("ninguno"))
                    {
                        bordado4 = "";
                    }
                    
                    
                    
                    lista.add(nombre);
                    datos[0] = nombre;
                    datos[4] = bordado1;
                    datos[5] = bordado2;
                    datos[6] = bordado3;
                    datos[7] = bordado4;
                    datos[8] = "";
                    datos[9] = "";
                    datos[10] = "";
                    datos[11] = consecutivo;
                    modelo.addRow(datos);
                    
                } 

                
            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        

        
        
    }
    
    

    void datosgorras()
    {
        
        Object codigocliente = lbcodigocliente.getText();
        String sql = "";

        String bordado1 = "";
        String bordado2 = "";
        String bordado3 = "";
        String bordado4 = "";
      
        String nombre ="";

            sql = "SELECT  nombre_bordado,frente_nombre,lado_izquierdo_nombre,lado_derecho_nombre,atras_nombre,numero_consecutivo FROM bordados_puntadas where codigo = '" + codigocliente + "' and tipo = 'GORRA' ";
           
          
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                nombre = rs.getString(1);
                bordado1 = rs.getString(2);
                bordado2 = rs.getString(3);
                bordado3 = rs.getString(4);
                bordado4 = rs.getString(5);
                consecutivo = rs.getString("numero_consecutivo");

                
                 if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                     if(bordado2.equals("ninguno"))
                    {
                        bordado2 = "";
                    }
                      if(bordado3.equals("ninguno"))
                    {
                        bordado3 = "";
                    }
                       if(bordado4.equals("ninguno"))
                    {
                        bordado4 = "";
                    }
                     
                
                
                lista.add(nombre);
                datos[0] = nombre;
                datos[4] = bordado1;
                datos[5] = bordado2;
                datos[6] = bordado3;
                datos[7] = bordado4;
                datos[8] = consecutivo;
                datos[9] = "";
                datos[10] ="";
                datos[11] ="";
                modelo.addRow(datos);
                    
           

                
            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        

        
        
    }
    
    void  datoscorbatas()
    {
        
        Object codigocliente = lbcodigocliente.getText();
        String sql = "";

        String bordado1 = "";
   
        String nombre ="";

        sql = "SELECT nombre_bordado,corbata_frente_nombre,numero_consecutivo FROM bordados_puntadas where codigo = '"+codigocliente+"' and tipo = 'CORBATA'   ";
           
          
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                nombre = rs.getString("nombre_bordado");
                bordado1 = rs.getString("corbata_frente_nombre");
                consecutivo = rs.getString("numero_consecutivo");

                 if (bordado1.equals("ninguno") ) 
                {   //
                    
                } 
                else
                {
                    lista.add(nombre);
                    
                    
                     if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                    
                    
                    datos[0] = nombre;
                    datos[4] = bordado1;
                    datos[11] = consecutivo;
                    modelo.addRow(datos);
                    
                } 

                
            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        

        
       
    }
    
    
    
    void datosparches()
    {
        
        Object codigocliente = lbcodigocliente.getText();
        String sql = "";

        
        
        String nombre ="";
        String bordado = "";
      
          
     
          sql = "SELECT nombre_bordado,parche_nombre,numero_consecutivo FROM bordados_puntadas where codigo = '"+codigocliente+"' and tipo = 'PARCHE'   ";
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {

                 nombre = rs.getString("nombre_bordado");
                bordado = rs.getString("parche_nombre");
                consecutivo = rs.getString("numero_consecutivo");
               
                    

               
                    
                    
                     if(bordado.equals("ninguno"))
                    {
                        bordado = "";
                    }
                     else
                    {
                        
                         lista.add(nombre);
                    
                    
                     if(bordado.equals("ninguno"))
                    {
                        bordado = "";
                    }
                     
                     
                   
             
                     datos[0] = nombre;
                    datos[1] = bordado;
                    datos[11] = consecutivo;
                    
                    
                    modelo.addRow(datos);    
                     
                    }
                     
                     
                  

            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        

        
    }
    
    
    
    
    void datosdistinta()
    {
        
        Object codigocliente = lbcodigocliente.getText();
    
        Object tipo = cbprenda.getSelectedItem();
        
        
        String bordado1 = "";
        String bordado2 = "";
        String bordado3 = "";
        String bordado4 = "";
        String bordado5 = "";
        String bordado6 = "";
        String bordado7 = "";
       
    
        String nombre ="";
        
        
 
        String  sql = "SELECT nombre_bordado,distinta1_nombre,distinta2_nombre,distinta3_nombre,distinta4_nombre,distinta5_nombre,distinta6_nombre,distinta7_nombre,numero_consecutivo FROM bordados_puntadas where codigo = '" + codigocliente + "' and tipo = '"+tipo+"'  ";    
         
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                nombre = rs.getString(1); 
                bordado1 = rs.getString(2);
                bordado2 = rs.getString(3);
                bordado3 = rs.getString(4);
                bordado4 = rs.getString(5);
                bordado5 = rs.getString(6);
                bordado6 = rs.getString(7);
                bordado7 = rs.getString(8); 
                consecutivo = rs.getString("numero_consecutivo");
                
               
                if (bordado1.equals("ninguno") && bordado2.equals("ninguno") && bordado3.equals("ninguno") && bordado4.equals("ninguno") && bordado5.equals("ninguno") && bordado6.equals("ninguno") && bordado7.equals("ninguno") ) 
                {   //
                    
                } 
                else
                {
                    
                    
                     if(bordado1.equals("ninguno"))
                    {
                        bordado1 = "";
                    }
                     if(bordado2.equals("ninguno"))
                    {
                        bordado2 = "";
                    }
                      if(bordado3.equals("ninguno"))
                    {
                        bordado3 = "";
                    }
                       if(bordado4.equals("ninguno"))
                    {
                        bordado4 = "";
                    }
                     if(bordado5.equals("ninguno"))
                    {
                        bordado5 = "";
                    }
                      if(bordado6.equals("ninguno"))
                    {
                        bordado6 = "";
                    }
                       if(bordado7.equals("ninguno"))
                    {
                        bordado7 = "";
                    }
                    
                    
                    lista.add(nombre);
                
                    datos[0] = nombre;
                    datos[4] = bordado1;
                    datos[5] = bordado2;
                    datos[6] = bordado3;
                    datos[7] = bordado4;
                    datos[8] = bordado5;
                    datos[9] = bordado6;
                    datos[10] = bordado7;
                    datos[11] = consecutivo;
               
                    modelo.addRow(datos);
                    
                } 
                    
                
                
            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        

        
        

    }
    
    
    
    
    void nombredelosbotonesparcheviejos()
    {
        
        Object codigocliente = lbcodigocliente.getText();
        String sql = "";

        String bordado1 = "";
        String bordado2 = "";
        String bordado3 = ""; 
        String bordado4 = ""; 
        String bordado5 = ""; 
        String bordado6 = ""; 
        String bordado7 = ""; 
        String bordado8 = ""; 
        String bordado9 = ""; 
        String bordado10 = ""; 
        String bordado11 = ""; 
        String bordado12 = ""; 
        String bordado13 = ""; 
        String bordado14 = ""; 
        String bordado15 = ""; 
        String nombre ="";
        
          
        sql = "SELECT parche1_nombre,parche2_nombre,parche3_nombre,parche4_nombre,parche5_nombre,parche6_nombre,parche7_nombre,parche8_nombre,parche9_nombre,parche10_nombre,parche11_nombre,parche12_nombre,parche13_nombre,parche14_nombre,parche15_nombre from puntadas_prendas where codigo = '" + codigocliente + "'";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {

                bordado1 = rs.getString("parche1_nombre");
                bordado2 = rs.getString("parche2_nombre");
                bordado3 = rs.getString("parche3_nombre");
                bordado4 = rs.getString("parche4_nombre");
                bordado5 = rs.getString("parche5_nombre");
                bordado6 = rs.getString("parche6_nombre");
                bordado7 = rs.getString("parche7_nombre");
                bordado8 = rs.getString("parche8_nombre");
                bordado9 = rs.getString("parche9_nombre");
                bordado10 = rs.getString("parche10_nombre");
                bordado11 = rs.getString("parche11_nombre");
                bordado12 = rs.getString("parche12_nombre");
                bordado13 = rs.getString("parche13_nombre");
                bordado14 = rs.getString("parche14_nombre");
                bordado15 = rs.getString("parche15_nombre");
                    

               
                    
                    
                     if(bordado1.equals("ninguno")  ||  bordado1.equals(""))
                    {
                        bordado1 = "";
                    }
                     else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE1";
                    datos[1] = bordado1;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                    modelo.addRow(datos);
                         
                    }
                     
                     
                     
                     if(bordado2.equals("ninguno")  ||  bordado2.equals(""))
                    {
                        bordado2 = "";
                    }
                    else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE2";
                    datos[1] = bordado2;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    } 
                     
                     
                      if(bordado3.equals("ninguno")  ||  bordado3.equals(""))
                    {
                        bordado3 = "";
                    }
                     else
                    {

                    lista.add(nombre);
                    datos[0] = "PARCHE3";
                    datos[1] = bordado3;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    }

                       if(bordado4.equals("ninguno")  ||  bordado4.equals(""))
                    {
                        bordado4 = "";
                    }
                    else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE4";
                    datos[1] = bordado4;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                    modelo.addRow(datos);
                         
                    }   
                       
                     if(bordado5.equals("ninguno")   ||  bordado5.equals(""))
                    {
                        bordado5 = "";
                    }
                    else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE5";
                    datos[1] = bordado5;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    } 
                     
                     
                      if(bordado6.equals("ninguno")   ||  bordado6.equals(""))
                    {
                        bordado6 = "";
                    }
                    else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE6";
                    datos[1] = bordado6;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    }  
                      
                       if(bordado7.equals("ninguno")   ||  bordado7.equals(""))
                    {
                        bordado7 = "";
                    }
                    else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE7";
                    datos[1] = bordado7;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    }   
                       
                       
                        if(bordado8.equals("ninguno")   ||  bordado8.equals(""))
                    {
                        bordado8 = "";
                    }
                    else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE8";
                    datos[1] = bordado8;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    }    
                        
                         if(bordado9.equals("ninguno")   ||  bordado9.equals(""))
                    {
                        bordado9 = "";
                    }
                    else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE9";
                    datos[1] = bordado9;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    }     
                         
                         
                     if(bordado10.equals("ninguno")   ||  bordado10.equals(""))
                    {
                        bordado10 = "";
                    }
                     else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE10";
                    datos[1] = bordado10;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    }
                     
                     if(bordado11.equals("ninguno")   ||  bordado11.equals(""))
                    {
                        bordado11 = "";
                    }
                     else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE11";
                    datos[1] = bordado11;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    }
                         
                   if(bordado12.equals("ninguno")   ||  bordado12.equals(""))
                    {
                        bordado12 = "";
                    }
                     else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE12";
                    datos[1] = bordado12;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    }
                    

                   if(bordado13.equals("ninguno")   ||  bordado13.equals(""))
                    {
                        bordado13 = "";
                    }
                     else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE13";
                    datos[1] = bordado13;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    }
                   
                   
                   if(bordado14.equals("ninguno")  ||  bordado14.equals(""))
                    {
                        bordado14 = "";
                    }
                     else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE14";
                    datos[1] = bordado14;
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                     modelo.addRow(datos);
                         
                    }
                   
                   
                   if(bordado15.equals("ninguno")   ||  bordado15.equals(""))
                    {
                        bordado15 = "";
                    }
                     else
                    {
                   
                    lista.add(nombre);
                    datos[0] = "PARCHE15";
                    datos[1] = bordado15;  
                    datos[2] = "";
                    datos[3] = "";
                    datos[4] = "";
                    datos[5] = "";
                    datos[6] = "";
                    datos[7] = "";
                    datos[11] = "";
                    modelo.addRow(datos);
                         
                    }
                

            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
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
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al limpiar la tabla.");
        }
    }
    
    
        
    void mostrarcolumnasdelaprendaseleccionada()
    {
        
        
        
        
         Object prenda = cbprenda.getSelectedItem();
        
         modelo = new DefaultTableModel(){
        
         @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
        return column == 1 || column == 2|| column == 3;
    }
    

         };
         
         
    //// letrita     
         
        DefaultTableCellRenderer letrita = new DefaultTableCellRenderer() {
        Font font =  new Font("Arial", Font.BOLD,16);

    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);
        setFont(font);
        return this;
    }
    
    

};
        
        
         //// letrita     
         
        DefaultTableCellRenderer letrita2 = new DefaultTableCellRenderer() {
        Font font =  new Font("Arial", Font.BOLD,16);

    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);
        setFont(font);
        return this;
    }
    
    

};
         
        
        
        
        
        
        
       
     //CAMISA, CAMISOLA, PLAYERA, FILIPINA, CHAMARRAS, ETC
     
         if(prenda.equals("CAMISA")||prenda.equals("PLAYERA")||prenda.equals("CAMISOLA")||prenda.equals("CHAMARRA DESMONTABLE")||prenda.equals("CHAMARRA ROMPEVIENTOS")||prenda.equals("FILIPINA")||prenda.equals("SACO")   ||prenda.equals("MANDIL")  ||prenda.equals("CHALECO"))
        {
            
        modelo.addColumn("nombre");//0
        modelo.addColumn("Agregar");//1
        modelo.addColumn("boton2");//2
        modelo.addColumn("Ver");//3
        modelo.addColumn("pecho_izquierdo");//4
        modelo.addColumn("pecho_derecho");//5
        modelo.addColumn("manga_derecha");//6
        modelo.addColumn("manga_izquierda");//7
        modelo.addColumn("espalda");//8
        modelo.addColumn("otra_ubicacion");//9
        modelo.addColumn("otra_ubicacion2");//10
        modelo.addColumn("numero_consecutivo");//11
        
        
         tabla.setModel(modelo); 
        
      
        tabla.setRowHeight(32);
        
        tabla.getColumnModel().getColumn(0).setMinWidth(500);
        tabla.getColumnModel().getColumn(0).setMaxWidth(1200);
        tabla.getColumnModel().getColumn(0).setWidth(700);
        
      
           tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0); 
        
        
           tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0); 
      
        tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMaxWidth(0);
        tabla.getColumnModel().getColumn(11).setWidth(0); 
        
        
        
        
        
        
        TableColumn agregarColumn1;
        agregarColumn1 = tabla.getColumnModel().getColumn(1);
        agregarColumn1.setCellEditor(new bordadosdelclientecatalogoAgregar(tabla));
        agregarColumn1.setCellRenderer(new bordadosdelclientecatalogobotonagregar(true)); 
         
        
        TableColumn agregarColumn;
        agregarColumn = tabla.getColumnModel().getColumn(2);
        agregarColumn.setCellEditor(new bordadosdelclientecatalogoEditar(tabla));
        agregarColumn.setCellRenderer(new bordadosdelclientecatalogobotoneditar(true));
        
        
        
        TableColumn agregarColumn2;
        agregarColumn2 = tabla.getColumnModel().getColumn(3);
        agregarColumn2.setCellEditor(new bordadosdelclientecatalogoVer(tabla));
        agregarColumn2.setCellRenderer(new bordadosdelclientecatalogobotonver(true));
        
         
                 
                 
                 
        }
        
        
         
         
         
         
         
         
         
       //GORRA
         else if(prenda.equals("GORRA"))
        {
        
        modelo.addColumn("nombre");//0
        modelo.addColumn("Agregar");//1
        modelo.addColumn("boton2");//2
        modelo.addColumn("Ver");//3
        modelo.addColumn("gorra_frente");//4
        modelo.addColumn("gorra_lado_izquierdo");//5
        modelo.addColumn("gorra_lado_derecho");//6
        modelo.addColumn("gorra_atras");//7
        modelo.addColumn("numero_consecutivo");//8
        
        
         tabla.setModel(modelo); 
        
      
        tabla.setRowHeight(32);
        
        tabla.getColumnModel().getColumn(0).setMinWidth(500);
        tabla.getColumnModel().getColumn(0).setMaxWidth(500);
        tabla.getColumnModel().getColumn(0).setWidth(500);
        
        
        
        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0); 
        
         tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMaxWidth(0);
        tabla.getColumnModel().getColumn(8).setWidth(0); 
       
        
        
        
        TableColumn agregarColumn1;
        agregarColumn1 = tabla.getColumnModel().getColumn(1);
        agregarColumn1.setCellEditor(new bordadosdelclientecatalogoAgregar(tabla));
        agregarColumn1.setCellRenderer(new bordadosdelclientecatalogobotonagregar(true)); 
         
        
        TableColumn agregarColumn;
        agregarColumn = tabla.getColumnModel().getColumn(2);
        agregarColumn.setCellEditor(new bordadosdelclientecatalogoEditar(tabla));
        agregarColumn.setCellRenderer(new bordadosdelclientecatalogobotoneditar(true));
        
        
        
        TableColumn agregarColumn2;
        agregarColumn2 = tabla.getColumnModel().getColumn(3);
        agregarColumn2.setCellEditor(new bordadosdelclientecatalogoVer(tabla));
        agregarColumn2.setCellRenderer(new bordadosdelclientecatalogobotonver(true));
        
        
        }
         
         
         
         
         
         
         
         
         
         
         // PANTWALON
         
         else if(prenda.equals("PANTALON"))
        {
        
        modelo.addColumn("nombre");//0
        modelo.addColumn("Agregar");//1
        modelo.addColumn("boton2");//2
        modelo.addColumn("Ver");//3
        modelo.addColumn("pantalon_lado_izquierdo_frente");//4
        modelo.addColumn("pantalon_lado_derecho_frente");//5
        modelo.addColumn("pantalon_lado_izquierdo_atras");//6
        modelo.addColumn("pantalon_lado_derecho_atras");//7
        modelo.addColumn("");//8
        modelo.addColumn("");//9
        modelo.addColumn("");//10
        modelo.addColumn("numero_consecutivo");//11
        
         tabla.setModel(modelo); 
        
      
        tabla.setRowHeight(32);
        
        tabla.getColumnModel().getColumn(0).setMinWidth(500);
        tabla.getColumnModel().getColumn(0).setMaxWidth(500);
        tabla.getColumnModel().getColumn(0).setWidth(500);
        
         tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0); 
        
        
          tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMaxWidth(0);
        tabla.getColumnModel().getColumn(11).setWidth(0); 
      
        
        
        TableColumn agregarColumn1;
        agregarColumn1 = tabla.getColumnModel().getColumn(1);
        agregarColumn1.setCellEditor(new bordadosdelclientecatalogoAgregar(tabla));
        agregarColumn1.setCellRenderer(new bordadosdelclientecatalogobotonagregar(true)); 
         
        
        TableColumn agregarColumn;
        agregarColumn = tabla.getColumnModel().getColumn(2);
        agregarColumn.setCellEditor(new bordadosdelclientecatalogoEditar(tabla));
        agregarColumn.setCellRenderer(new bordadosdelclientecatalogobotoneditar(true));
        
        
        
        TableColumn agregarColumn2;
        agregarColumn2 = tabla.getColumnModel().getColumn(3);
        agregarColumn2.setCellEditor(new bordadosdelclientecatalogoVer(tabla));
        agregarColumn2.setCellRenderer(new bordadosdelclientecatalogobotonver(true));
        
        
        }
         
         
         
         
         
         
         
         
         /// CORBATA
         else if(prenda.equals("CORBATA"))
        {
        
        modelo.addColumn("nombre");//0
        modelo.addColumn("Agregar");//1
        modelo.addColumn("boton2");//2
        modelo.addColumn("Ver");//3
        modelo.addColumn("corbata_frente");//4
        modelo.addColumn("");//5
        modelo.addColumn("");//6
        modelo.addColumn("");//7
        modelo.addColumn("");//5
        modelo.addColumn("");//6
        modelo.addColumn("");//7
        modelo.addColumn("numero_consecutivo");//11
       
         tabla.setModel(modelo); 
        
      
        tabla.setRowHeight(32);
        
        tabla.getColumnModel().getColumn(0).setMinWidth(500);
        tabla.getColumnModel().getColumn(0).setMaxWidth(500);
        tabla.getColumnModel().getColumn(0).setWidth(500);
        
       tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0); 
        
        
          tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMaxWidth(0);
        tabla.getColumnModel().getColumn(11).setWidth(0); 
        
        
        
        
        
        
        TableColumn agregarColumn1;
        agregarColumn1 = tabla.getColumnModel().getColumn(1);
        agregarColumn1.setCellEditor(new bordadosdelclientecatalogoAgregar(tabla));
        agregarColumn1.setCellRenderer(new bordadosdelclientecatalogobotonagregar(true)); 
         
        
        TableColumn agregarColumn;
        agregarColumn = tabla.getColumnModel().getColumn(2);
        agregarColumn.setCellEditor(new bordadosdelclientecatalogoEditar(tabla));
        agregarColumn.setCellRenderer(new bordadosdelclientecatalogobotoneditar(true));
        
        
        
        TableColumn agregarColumn2;
        agregarColumn2 = tabla.getColumnModel().getColumn(3);
        agregarColumn2.setCellEditor(new bordadosdelclientecatalogoVer(tabla));
        agregarColumn2.setCellRenderer(new bordadosdelclientecatalogobotonver(true));
        
        
        }
         
         
         
         
         
         
         
         
         
         // CHALECO Y MANDIL
        else if(prenda.equals("CHALECO") ||  prenda.equals("MANDIL"))
        {
            
        modelo.addColumn("nombre");//0
        modelo.addColumn("Agregar");//1
        modelo.addColumn("boton2");//2
        modelo.addColumn("Ver");//3
        modelo.addColumn("chaleco_pecho_izquierdo");//1
        modelo.addColumn("chaleco_pecho_derecho");//2
        modelo.addColumn("chaleco_espalda");//3
        modelo.addColumn("chaleco_otra_ubicacion");//4
        modelo.addColumn("chaleco_otra_ubicacion2");//5
        modelo.addColumn("");//6
        modelo.addColumn("");//7
        modelo.addColumn("numero_consecutivo");//11
        
         tabla.setModel(modelo); 
        
      
        tabla.setRowHeight(32);
        
        tabla.getColumnModel().getColumn(0).setMinWidth(500);
        tabla.getColumnModel().getColumn(0).setMaxWidth(500);
        tabla.getColumnModel().getColumn(0).setWidth(500);
        
        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0); 
        
        
          tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMaxWidth(0);
        tabla.getColumnModel().getColumn(11).setWidth(0); 
        
        
        
        
        
        TableColumn agregarColumn1;
        agregarColumn1 = tabla.getColumnModel().getColumn(1);
        agregarColumn1.setCellEditor(new bordadosdelclientecatalogoAgregar(tabla));
        agregarColumn1.setCellRenderer(new bordadosdelclientecatalogobotonagregar(true)); 
         
        
        TableColumn agregarColumn;
        agregarColumn = tabla.getColumnModel().getColumn(2);
        agregarColumn.setCellEditor(new bordadosdelclientecatalogoEditar(tabla));
        agregarColumn.setCellRenderer(new bordadosdelclientecatalogobotoneditar(true));
        
        
        
        TableColumn agregarColumn2;
        agregarColumn2 = tabla.getColumnModel().getColumn(3);
        agregarColumn2.setCellEditor(new bordadosdelclientecatalogoVer(tabla));
        agregarColumn2.setCellRenderer(new bordadosdelclientecatalogobotonver(true));
        
        
        
        }
        
        
        
        
        
        
        
        //PARCHE
        else if(prenda.equals("PARCHE"))
        {
            
        modelo.addColumn("nombre");//0
        modelo.addColumn("Agregar");//1
        modelo.addColumn("boton2");//2
        modelo.addColumn("Ver");//3
        modelo.addColumn("nombre_parche");//1
        modelo.addColumn("");//2
        modelo.addColumn("");//3
        modelo.addColumn("");//4
        modelo.addColumn("");//5
        modelo.addColumn("");//6
        modelo.addColumn("");//7
        modelo.addColumn("numero_consecutivo");//11        
         tabla.setModel(modelo); 
        
      
        tabla.setRowHeight(32);
        
        tabla.getColumnModel().getColumn(0).setMinWidth(500);
        tabla.getColumnModel().getColumn(0).setMaxWidth(500);
        tabla.getColumnModel().getColumn(0).setWidth(500);
        
        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0); 
        
        
          tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMaxWidth(0);
        tabla.getColumnModel().getColumn(11).setWidth(0); 
        
        
        
        
        
        
          TableColumn agregarColumn1;
        agregarColumn1 = tabla.getColumnModel().getColumn(1);
        agregarColumn1.setCellEditor(new bordadosdelclientecatalogoAgregar(tabla));
        agregarColumn1.setCellRenderer(new bordadosdelclientecatalogobotonagregar(true)); 
         
        
        TableColumn agregarColumn;
        agregarColumn = tabla.getColumnModel().getColumn(2);
        agregarColumn.setCellEditor(new bordadosdelclientecatalogoEditar(tabla));
        agregarColumn.setCellRenderer(new bordadosdelclientecatalogobotoneditar(true));
        
        
        
        TableColumn agregarColumn2;
        agregarColumn2 = tabla.getColumnModel().getColumn(3);
        agregarColumn2.setCellEditor(new bordadosdelclientecatalogoVer(tabla));
        agregarColumn2.setCellRenderer(new bordadosdelclientecatalogobotonver(true));
     
        
        }
        
         
         else
            
         
         
        {
       // DISTINTA 
       
       
       
       String tipoespecial = "";
       
       
       
       
        modelo.addColumn("nombre");//0
        modelo.addColumn("Agregar");//1
        modelo.addColumn("boton2");//2
        modelo.addColumn("Ver");//3
        modelo.addColumn("distinta1");//4
        modelo.addColumn("distinta2");//5
        modelo.addColumn("distinta3");//6
        modelo.addColumn("distinta4");//7
        modelo.addColumn("distinta5");//8
        modelo.addColumn("distinta6");//9
        modelo.addColumn("distinta7");//10
        modelo.addColumn("numero_consecutivo");//11
        
        
         tabla.setModel(modelo); 
        
       
       
       
         
        for (int i = 0; i< listadistinta.size() ; i++)
            
        {
            
            tipoespecial =  listadistinta.get(i);
        
         
         
         
         if(prenda.equals(tipoespecial))
        {
        
            
        
       
      
        tabla.setRowHeight(32);
        
        tabla.getColumnModel().getColumn(0).setMinWidth(500);
        tabla.getColumnModel().getColumn(0).setMaxWidth(500);
        tabla.getColumnModel().getColumn(0).setWidth(500);
        
        
      tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0); 
        
        
          tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMaxWidth(0);
        tabla.getColumnModel().getColumn(11).setWidth(0); 
       
        
        
        
         TableColumn agregarColumn1;
        agregarColumn1 = tabla.getColumnModel().getColumn(1);
        agregarColumn1.setCellEditor(new bordadosdelclientecatalogoAgregar(tabla));
        agregarColumn1.setCellRenderer(new bordadosdelclientecatalogobotonagregar(true)); 
        
       
        TableColumn agregarColumn;
        agregarColumn = tabla.getColumnModel().getColumn(2);
        agregarColumn.setCellEditor(new bordadosdelclientecatalogoEditar(tabla));
        agregarColumn.setCellRenderer(new bordadosdelclientecatalogobotoneditar(true));
        
        
        
        TableColumn agregarColumn2;
        agregarColumn2 = tabla.getColumnModel().getColumn(3);
        agregarColumn2.setCellEditor(new bordadosdelclientecatalogoVer(tabla));
        agregarColumn2.setCellRenderer(new bordadosdelclientecatalogobotonver(true));
     
      
        
        }
        }
        }
        
        
        
        
        
        //BOTON AGREGAR
        TableColumn agregarColumn1;
        agregarColumn1 = tabla.getColumnModel().getColumn(1);
        agregarColumn1.setCellEditor(new bordadosdelclientecatalogoAgregar(tabla));
        agregarColumn1.setCellRenderer(new bordadosdelclientecatalogobotonagregar(true)); 
         
        //BOTON EDITAR
        TableColumn agregarColumn;
        agregarColumn = tabla.getColumnModel().getColumn(2);
        agregarColumn.setCellEditor(new bordadosdelclientecatalogoEditar(tabla));
        agregarColumn.setCellRenderer(new bordadosdelclientecatalogobotoneditar(true));
        
        //BOTON VER
        TableColumn agregarColumn2;
        agregarColumn2 = tabla.getColumnModel().getColumn(3);
        agregarColumn2.setCellEditor(new bordadosdelclientecatalogoVer(tabla));
        agregarColumn2.setCellRenderer(new bordadosdelclientecatalogobotonver(true));
        
        
        /*
     
        TableColumn agregarColumn3;
        agregarColumn3 = tabla.getColumnModel().getColumn(11);
        agregarColumn3.setCellEditor(new bordadosdelclientecatalogonuevoBotonVer(tabla));
        agregarColumn3.setCellRenderer(new myrenderer2(true));
        
       */
        
        
     //   limpiartabla();
       
    }
        
        
   
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngorra1 = new javax.swing.JButton();
        jSeparator16 = new javax.swing.JSeparator();
        jSeparator17 = new javax.swing.JSeparator();
        jSeparator19 = new javax.swing.JSeparator();
        jSeparator20 = new javax.swing.JSeparator();
        jSeparator21 = new javax.swing.JSeparator();
        jSeparator22 = new javax.swing.JSeparator();
        jTextField1 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        btnsalir = new javax.swing.JButton();
        bntmaximizar = new javax.swing.JButton();
        lbinterface = new javax.swing.JLabel();
        lbcodigocliente = new javax.swing.JLabel();
        btndatos = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        cbprenda = new javax.swing.JComboBox<>();
        btnnombres = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btncombo = new javax.swing.JButton();
        cbcomboclientes = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbnombrecomercial = new javax.swing.JComboBox<>();
        lbidentificador = new javax.swing.JComboBox<>();

        btngorra1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btngorra1.setText("Gorra");
        btngorra1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngorra1ActionPerformed(evt);
            }
        });

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Bordados del cliente catalogo");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowIconified(java.awt.event.WindowEvent evt) {
                formWindowIconified(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        bntmaximizar.setText("maximizar");
        bntmaximizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntmaximizarActionPerformed(evt);
            }
        });

        lbinterface.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigocliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndatos.setText("Datos");
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Cliente");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tabla.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prenda", "Agregar", "2", "Editar", "nombre1", "nombre2", "nombre3", "nombre4", "nombre5", "nombre6", "nombre7", "codigo"
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
        tabla.getTableHeader().setReorderingAllowed(false);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(1).setMinWidth(90);
            tabla.getColumnModel().getColumn(1).setPreferredWidth(90);
            tabla.getColumnModel().getColumn(1).setMaxWidth(90);
            tabla.getColumnModel().getColumn(2).setMinWidth(90);
            tabla.getColumnModel().getColumn(2).setPreferredWidth(90);
            tabla.getColumnModel().getColumn(2).setMaxWidth(90);
            tabla.getColumnModel().getColumn(3).setMinWidth(90);
            tabla.getColumnModel().getColumn(3).setPreferredWidth(90);
            tabla.getColumnModel().getColumn(3).setMaxWidth(90);
        }

        cbprenda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbprenda.setToolTipText("");
        cbprenda.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbprendaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        btnnombres.setText("btnnombres");
        btnnombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnombresActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Identificador");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btncombo.setText("Combo");
        btncombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncomboActionPerformed(evt);
            }
        });

        cbcomboclientes.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbcomboclientesPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nombre comercial");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbnombrecomercial.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbnombrecomercialPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        lbidentificador.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                lbidentificadorPopupMenuWillBecomeInvisible(evt);
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
                        .addComponent(bntmaximizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndatos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncombo, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnnombres)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbinterface, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbcomboclientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(jLabel2)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(292, 292, 292)
                                            .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(4, 4, 4))))
                        .addGap(43, 43, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbcomboclientes, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 823, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcodigocliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(bntmaximizar)
                                .addComponent(btndatos)
                                .addComponent(btncombo)
                                .addComponent(btnnombres))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbinterface, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        
        ventanabordadosdelclientecatalogonuevo = false;
        this.dispose();

    }//GEN-LAST:event_btnsalirActionPerformed

    private void bntmaximizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntmaximizarActionPerformed
     
        this.setAlwaysOnTop(true);
        
        this.toFront();
        
        this.setAlwaysOnTop(false);
        
    }//GEN-LAST:event_bntmaximizarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
       
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
        ventanabordadosdelclientecatalogonuevo = false;
       
        
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


    }//GEN-LAST:event_formWindowOpened

    private void btngorra1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngorra1ActionPerformed

    }//GEN-LAST:event_btngorra1ActionPerformed

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed
   
     
         comboprendas(); 
        
    
    }//GEN-LAST:event_btndatosActionPerformed


    private void cbprendaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbprendaPopupMenuWillBecomeInvisible



        
        Object prenda = cbprenda.getSelectedItem();
        lista.clear();
        limpiarstringdatos();
        
        
        if(prenda ==null || prenda.equals("") || prenda.equals(" "))
        {
            
        }
        else 
            
            
        { 
            
           
            
            
            
            if (!prenda.equals("TODOS"))
            {
               limpiartabla();
             mostrarcolumnasdelaprendaseleccionada();   
            
            }
            
            
            if(prenda.equals("CAMISA")  ||  prenda.equals("PLAYERA") || prenda.equals("CAMISOLA") || prenda.equals("CHAMARRA DESMONTABLE") || prenda.equals("CHAMARRA ROMPEVIENTOS")||  prenda.equals("FILIPINA") || prenda.equals("SACO") ||  prenda.equals("CHALECO") || prenda.equals("MANDIL")  )
        {
     
            datoscamisas();
        
        }
            
            
               else
              
                       
                       
         if(prenda.equals("PANTALON"))
        {
        
           datospantalones();
      
        }
         
         
         
         
       
         else 
             
             if(prenda.equals("GORRA"))
        {
      
           datosgorras();
      
        }
       
        
         
     
         else
             
             if(prenda.equals("CORBATA"))
        {
       
            datoscorbatas();
     
        }
         else 
                 
    
           
        if(prenda.equals("PARCHE"))
        {
       
           datosparches();
     
        }
        
       
            
          else    
        
         if(!prenda.equals("TODOS"))
           
          //   DISTINTA
       
        {
      
           datosdistinta();
      
        }
        
        
            
            
             
              
            
            
           
            if(prenda.equals("TODOS"))
        
            {
           limpiartabla(); 
           dedondevengo = lbinterface.getText();
        
           modelo = new DefaultTableModel(){
        
         @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
      return  column == 2|| column == 3|| column == 4;
    }
};
           
          DefaultTableCellRenderer letrita = new DefaultTableCellRenderer() {
    Font font =  new Font("Arial", Font.BOLD,16);

    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);
        setFont(font);
        return this;
    }
    
    

};
        
        
        modelo.addColumn("tipo");//0
        modelo.addColumn("nombre");//1
        modelo.addColumn("Agregar");//2
        modelo.addColumn("boton2");//3
        modelo.addColumn("Ver");//4
        modelo.addColumn("pecho_izquierdo");//5
        modelo.addColumn("pecho_derecho");//6
        modelo.addColumn("manga_derecha");//7
        modelo.addColumn("manga_izquierda");//8
        modelo.addColumn("espalda");//9
        modelo.addColumn("otra_ubicacion");//10
        modelo.addColumn("lado_izquierdo_frente_nombre");//11
        modelo.addColumn("lado_izquierdo_atras_nombre");//12
        modelo.addColumn("lado_derecho_atras_nombre");//13
        modelo.addColumn("frente_nombre");//14
        modelo.addColumn("lado_izquierdo_nombre");//15
        modelo.addColumn("lado_derecho_nombre");//16 
        modelo.addColumn("atras_nombre");//17
        modelo.addColumn("frente_nombre");//18
        modelo.addColumn("numero consecutivo");//19
       
        tabla.setModel(modelo); 
        
       
        
        datosdetodoslosbordadosdetodaslasprendas();
       
     //   tabla.getColumnModel().getColumn(0).setCellRenderer(letrita);
        tabla.setRowHeight(32);

        
       
        }
        
        
        
            }
        
       
         
        
        
    }//GEN-LAST:event_cbprendaPopupMenuWillBecomeInvisible

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked
   
     
         int filaseleccionada = tabla.getSelectedRow();
         prenda = cbprenda.getSelectedItem().toString();
          Object nombredelbordado = "";
        
         if (evt.getClickCount() == 1  ) 
        {
        
            
        
            
         
         codigocliente = lbcodigocliente.getText();
        
       
        if (prenda.equals("TODOS"))
        
        {
            
            
            if(filaseleccionada >= 0)
            {
            prenda = tabla.getValueAt(filaseleccionada, 0).toString();
            nombredelbordado = tabla.getValueAt(filaseleccionada, 1);
            consecutivo = tabla.getValueAt(filaseleccionada, 18).toString();
            }
            
        }
        
        else
        {
            if(filaseleccionada >= 0)
            {
            nombredelbordado = tabla.getValueAt(filaseleccionada, 0);
            consecutivo = tabla.getValueAt(filaseleccionada, 11).toString();
            }
            
        }
         
        
        
           
            
    }
       
        
    
    
    if (evt.getClickCount() == 2  ) 
    {
        
        
    
    
    if(filaseleccionada >=0)
    {
        
    
 
   
           
        
        
        
                if (prenda.equals("TODOS")) {

                    nombredelbordado = tabla.getValueAt(filaseleccionada, 1);
                    consecutivo = tabla.getValueAt(filaseleccionada, 18).toString();
                    prenda = tabla.getValueAt(filaseleccionada, 0).toString();

                } else {
                    nombredelbordado = tabla.getValueAt(filaseleccionada, 0);
                    consecutivo = tabla.getValueAt(filaseleccionada, 11).toString();
                    String codigocliente = lbcodigocliente.getText();

                    String SQL = "SELECT tipo FROM bordados_puntadas where nombre_bordado = '" + nombredelbordado + "' and numero_consecutivo = '" + consecutivo + "' and  codigo = '" + codigocliente + "'  ";

                    try {
                        Statement st = cn.createStatement();
                        ResultSet rs = st.executeQuery(SQL);
                        if (rs.next()) {
                            prenda = rs.getString(1);
                        }

                    } catch (Exception e) {
                        System.out.println(e);
                    }

                }

                if (prenda.equals("CAMISA") || prenda.equals("CAMISOLA") || prenda.equals("CORBATA") || prenda.equals("CHALECO") || prenda.equals("CHAMARRA DESMONTABLE") || prenda.equals("CHAMARRA ROMPEVIENTOS") || prenda.equals("FILIPINA") || prenda.equals("GORRA") || prenda.equals("MANDIL") || prenda.equals("PANTALON") || prenda.equals("PARCHE") || prenda.equals("PLAYERA") || prenda.equals("SACO")) {

                    if (bordadosdelclienteeditarnuevo.ventanabordadosdelclienteeditarnuevo == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La ventana de bordados del cliente editar ya est� abierta");
                    } else {
                        
                        
                         Object nombrecliente = cbcomboclientes.getSelectedItem();
                        if(nombrecliente ==null || nombrecliente.equals("")||nombrecliente.equals(" ") )
                        {
                            nombrecliente = "";
                        }
                        
                        
                        Object nombrecomercial = cbnombrecomercial.getSelectedItem();
                        if(nombrecomercial ==null || nombrecomercial.equals("")||nombrecomercial.equals(" ") )
                        {
                            nombrecomercial = "";
                        }
                        

                        bordadosdelclienteeditarnuevo ventana = new bordadosdelclienteeditarnuevo();
                        ventana.setVisible(true);
                        ventana.setLocationRelativeTo(null);
                        bordadosdelclienteeditarnuevo.lbcliente.setText(nombrecliente.toString());
                        bordadosdelclienteeditarnuevo.lbnombrecomercial.setText(nombrecomercial.toString());
                        bordadosdelclienteeditarnuevo.lbcodigocliente.setText(lbcodigocliente.getText());
                        bordadosdelclienteeditarnuevo.txtidentificadordeprenda.setText(nombredelbordado.toString());
                        bordadosdelclienteeditarnuevo.txtcodigocatalogobordados.setText(consecutivo.toString());
                        bordadosdelclienteeditarnuevo.lbconsecutivo.setText(consecutivo.toString());

                        if (prenda.equals("TODOS")) {
                            bordadosdelclienteeditarnuevo.lbprenda.setText(prenda.toString());

                        } else {
                            bordadosdelclienteeditarnuevo.lbprenda.setText(prenda.toString());
                        }

                        if (prenda.equals("TODOS")) {

                            if (prenda == null || prenda.equals("") || prenda.equals(" ")) {

                            } else {

                                cbprenda.setSelectedItem(prenda);
                                cbprenda.firePopupMenuWillBecomeInvisible();
                            }

                        }

                        /////////////////////////
                    }

                } else {

                    if (bordadoseditardistinta.ventanabordadosdelclienteeditardistinta == true) {
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La ventana de bordados del cliente editar distinta ya est� abierta");
                    } else {

                        bordadoseditardistinta ventana = new bordadoseditardistinta();
                        ventana.setVisible(true);
                        ventana.setLocationRelativeTo(null);
                        
                        
                        Object nombrecliente = cbcomboclientes.getSelectedItem();
                        if(nombrecliente ==null || nombrecliente.equals("")||nombrecliente.equals(" ") )
                        {
                            nombrecliente = "";
                        }
                        
                        
                        Object nombrecomercial = cbnombrecomercial.getSelectedItem();
                        if(nombrecomercial ==null || nombrecomercial.equals("")||nombrecomercial.equals(" ") )
                        {
                            nombrecomercial = "";
                        }

                        bordadoseditardistinta.lbcliente.setText(nombrecliente.toString());
                        bordadoseditardistinta.lbnombrecomercial.setText(nombrecomercial.toString());
                        bordadoseditardistinta.lbcodigocliente.setText(lbcodigocliente.getText());
                        bordadoseditardistinta.txtidentificadordeprenda.setText(nombredelbordado.toString());
                        bordadoseditardistinta.txtconsecutivo.setText(consecutivo.toString());
                        

                        bordadoseditardistinta.lbtipo.setText("DISTINTA");
                        bordadoseditardistinta.lbprenda.setText(prenda);

                    }

                    if (prenda.equals("TODOS")) {

                        if (prenda == null || prenda.equals("") || prenda.equals(" ")) {

                        } else {

                            cbprenda.setSelectedItem("DISTINTA");
                            cbprenda.firePopupMenuWillBecomeInvisible();
                        }

                    }

                }

                //   }
            }

        }
    
    
    
    
        
        
    }//GEN-LAST:event_tablaMouseClicked

    private void formWindowIconified(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowIconified
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowIconified

    
    private void btnnombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnombresActionPerformed

        mostrarcolumnasdelaprendaseleccionada();

    }//GEN-LAST:event_btnnombresActionPerformed

    private void btncomboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncomboActionPerformed

       cbprenda.firePopupMenuWillBecomeInvisible();
        
        
        
    }//GEN-LAST:event_btncomboActionPerformed

    private void cbcomboclientesPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcomboclientesPopupMenuWillBecomeInvisible
       
    Object nombredelcliente = cbcomboclientes.getSelectedItem();
    String codigocliente = "";
        
   String  sql = "SELECT codigo FROM bordados_puntadas where nombre = '" + nombredelcliente + "'  ";    
         
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                codigocliente = rs.getString("codigo"); 

            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        lbcodigocliente.setText(codigocliente);
       
        modelo = new DefaultTableModel(){
        
         @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
      // return column == 1 ;
        return column == 2 || column == 3|| column == 4;
       
    }
};
         
         DefaultTableCellRenderer letrita = new DefaultTableCellRenderer() {
    Font font =  new Font("Arial", Font.BOLD,16);

    public Component getTableCellRendererComponent(JTable table,
            Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus,
                row, column);
        setFont(font);
        return this;
    }
    
    

};
         
         
         
        modelo.addColumn("tipo");//0
        modelo.addColumn("nombre");//1
        modelo.addColumn("Agregar");//2
        modelo.addColumn("boton2");//3
        modelo.addColumn("Ver");//4
        modelo.addColumn("pecho_izquierdo");//5
        modelo.addColumn("pecho_derecho");//6
        modelo.addColumn("manga_derecha");//7
        modelo.addColumn("manga_izquierda");//8
        modelo.addColumn("espalda");//9
        modelo.addColumn("otra_ubicacion");//10
        modelo.addColumn("lado_izquierdo_frente_nombre");//11
        modelo.addColumn("lado_izquierdo_atras_nombre");//12
        modelo.addColumn("lado_derecho_atras_nombre");//13
        modelo.addColumn("frente_nombre");//14
        modelo.addColumn("lado_izquierdo_nombre");//15
        modelo.addColumn("lado_derecho_nombre");//16 
        modelo.addColumn("atras_nombre");//17
        modelo.addColumn("frente_nombre");//18
        modelo.addColumn("numero consecutivo");//19
       
     
        
        
        tabla.setModel(modelo); 
        
        
        
        datosdetodoslosbordadosdetodaslasprendas();
        cbprenda.setSelectedItem("TODOS");
        tabla.getColumnModel().getColumn(0).setCellRenderer(letrita);
        tabla.setRowHeight(32);
        
        
        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMaxWidth(0);
        tabla.getColumnModel().getColumn(2).setWidth(0);
        
        
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMaxWidth(0);
        tabla.getColumnModel().getColumn(3).setWidth(0);
        
        
        
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMaxWidth(0);
        tabla.getColumnModel().getColumn(4).setWidth(0);
        
        
    }//GEN-LAST:event_cbcomboclientesPopupMenuWillBecomeInvisible

    private void cbnombrecomercialPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbnombrecomercialPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbnombrecomercialPopupMenuWillBecomeInvisible

    private void lbidentificadorPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_lbidentificadorPopupMenuWillBecomeInvisible
        // TODO add your handling code here:
    }//GEN-LAST:event_lbidentificadorPopupMenuWillBecomeInvisible

 
    public static void main(String args[]) {
   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bordadosdelclientecatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bordadosdelclientecatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bordadosdelclientecatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bordadosdelclientecatalogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bordadosdelclientecatalogo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bntmaximizar;
    public static javax.swing.JButton btncombo;
    public static javax.swing.JButton btndatos;
    private javax.swing.JButton btngorra1;
    public static javax.swing.JButton btnnombres;
    public static javax.swing.JButton btnsalir;
    public static javax.swing.JComboBox<String> cbcomboclientes;
    public static javax.swing.JComboBox<String> cbnombrecomercial;
    public static javax.swing.JComboBox<String> cbprenda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator16;
    private javax.swing.JSeparator jSeparator17;
    private javax.swing.JSeparator jSeparator19;
    private javax.swing.JSeparator jSeparator20;
    private javax.swing.JSeparator jSeparator21;
    private javax.swing.JSeparator jSeparator22;
    private javax.swing.JTextField jTextField1;
    public static javax.swing.JLabel lbcodigocliente;
    public static javax.swing.JComboBox<String> lbidentificador;
    public static javax.swing.JLabel lbinterface;
    public static javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
connectar cc = new connectar();
    Connection cn = cc.conexion();

}
