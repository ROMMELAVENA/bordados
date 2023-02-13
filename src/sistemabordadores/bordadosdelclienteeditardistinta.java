

package sistemabordadores;


import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
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
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class bordadosdelclienteeditardistinta extends javax.swing.JFrame {

    public static boolean ventanabordadosdelclienteeditardistinta = false;
    
    String numerocatalogoprendas = "";
    String numerocatalogoubicacion = "";
    String nombrebordadoanterior = "";
    String codigodelcliente = "";
    String numerocamisa = "";
  
    String rutaarchivo = "";
    String nombrearchivo = "";
    String consultaborrado ="";
    
    String  prendafotomontaje ="";
    String  nombreprendafotomontaje ="";      
    String actualizarbordado ="no";
   
    
    String nombrebordado = "";
  
    
    
    String cerrarinterface = "si";
    String numeroconsecutivo = "";
    String pasa = "si";
    
    String nombreanterior = "";

    
    String prenda = "";
    String tipodeprenda = "";

    
    Object ubicacion1 = "";
    Object ubicacion2 = "";
    Object ubicacion3 = "";
    Object ubicacion4 = "";
    Object ubicacion5 = "";
    Object ubicacion6 = "";
    Object ubicacion7 = "";
  
    
    
    Object distinta1 = "";
    Object distinta2 = "";
    Object distinta3 = "";
    Object distinta4 = "";
    Object distinta5 = "";
    Object distinta6 = "";
    Object distinta7 = "";
    
    String distinta1nombre = "";
    String distinta2nombre = "";
    String distinta3nombre = "";
    String distinta4nombre = "";
    String distinta5nombre = "";
    String distinta6nombre = "";
    String distinta7nombre = "";
    
    Object distinta1aplicacion = "";
    Object distinta2aplicacion = "";
    Object distinta3aplicacion = "";
    Object distinta4aplicacion = "";
    Object distinta5aplicacion = "";
    Object distinta6aplicacion = "";
    Object distinta7aplicacion = "";
    
    
    Object distinta1aplicacioncolor = "";
    Object distinta2aplicacioncolor = "";
    Object distinta3aplicacioncolor = "";
    Object distinta4aplicacioncolor = "";
    Object distinta5aplicacioncolor = "";
    Object distinta6aplicacioncolor = "";
    Object distinta7aplicacioncolor = "";
    
    
    
    String consecutivo = "";
    
    
    String color1seleccionado = "";
    String color2seleccionado = "";
    String color3seleccionado = "";
    String color4seleccionado = "";
    String color5seleccionado = "";
    String color6seleccionado = "";
    String color7seleccionado = "";
    
    
    String hilo1seleccionado = "";
    String hilo2seleccionado = "";
    String hilo3seleccionado = "";
    String hilo4seleccionado = "";
    String hilo5seleccionado = "";
    String hilo6seleccionado = "";
    String hilo7seleccionado = "";
    
    
    String tipo = "";
    
    ArrayList<String> lista = new ArrayList<String>();
    
   
    public bordadosdelclienteeditardistinta() {
        initComponents();
        
        
        
        datoscombo();
        
        
        ventanabordadosdelclienteeditardistinta = true;
        btndatos.setVisible(false);
        lbanuncio.setVisible(false);
        lbcodigocliente.setVisible(false);
        btnimportarfotomontaje.setVisible(false);
        lbnombrebordadoanterior.setVisible(false);

        txtconsecutivo.setVisible(false);
        
        
        
        txtidentificadordeprenda.setEnabled(false);
        txt1.setEnabled(false);
        txt2.setEnabled(false);
        txt3.setEnabled(false);
        txt4.setEnabled(false);
        txt5.setEnabled(false);
        txt6.setEnabled(false);
        txt7.setEnabled(false);         
        
    }

    void agregarcoloresaloscombos() {

        String colores[] = {"Azul Cielo", "Azul Marino", "Blanco", "Gris", "Negro", "Azul Rey", "Rojo", "ninguno"};

        cbaplicacioncolor1.setModel(new javax.swing.DefaultComboBoxModel(colores));
         cbaplicacioncolor1.setSelectedItem("ninguno");

        cbaplicacioncolor2.setModel(new javax.swing.DefaultComboBoxModel(colores));
        cbaplicacioncolor2.setSelectedItem("ninguno");

        cbaplicacioncolor3.setModel(new javax.swing.DefaultComboBoxModel(colores));
        cbaplicacioncolor3.setSelectedItem("ninguno");

        cbaplicacioncolor4.setModel(new javax.swing.DefaultComboBoxModel(colores));
        cbaplicacioncolor4.setSelectedItem("ninguno");

        cbaplicacioncolor5.setModel(new javax.swing.DefaultComboBoxModel(colores));
        cbaplicacioncolor5.setSelectedItem("ninguno");

        cbaplicacioncolor6.setModel(new javax.swing.DefaultComboBoxModel(colores));
        cbaplicacioncolor6.setSelectedItem("ninguno");

        cbaplicacioncolor7.setModel(new javax.swing.DefaultComboBoxModel(colores));
        cbaplicacioncolor7.setSelectedItem("ninguno");

    }

    void tipobordado() {

        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo3 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo4 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo5 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo6 = new DefaultComboBoxModel();

            String sql = "SELECT descripcion, sum(precio) as precio2  FROM catalogo_articulos where descripcion not like  '%PARCHE%'  and ( descripcion like 'SEGURIDAD%' or descripcion like 'VIGILANCIA%' or descripcion like 'BORDADO DE%'   OR descripcion like 'BANDERA DE%'  ) group by precio ORDER BY precio2";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                modelo.addElement(rs.getObject("descripcion"));
                modelo1.addElement(rs.getObject("descripcion"));
                modelo2.addElement(rs.getObject("descripcion"));
                modelo3.addElement(rs.getObject("descripcion"));
                modelo4.addElement(rs.getObject("descripcion"));
                modelo5.addElement(rs.getObject("descripcion"));
                modelo6.addElement(rs.getObject("descripcion"));

            }

            cbpuntadas1.setModel(modelo);
            AutoCompleteDecorator.decorate(cbpuntadas1);
            cbpuntadas1.addItem("ninguno");
            cbpuntadas1.setSelectedItem("ninguno");

            cbpuntadas2.setModel(modelo1);
            AutoCompleteDecorator.decorate(cbpuntadas2);
            cbpuntadas2.addItem("ninguno");
            cbpuntadas2.setSelectedItem("ninguno");

            cbpuntadas4.setModel(modelo2);
            AutoCompleteDecorator.decorate(cbpuntadas4);
            cbpuntadas4.addItem("ninguno");
            cbpuntadas4.setSelectedItem("ninguno");

            cbpuntadas3.setModel(modelo3);
            AutoCompleteDecorator.decorate(cbpuntadas3);
            cbpuntadas3.addItem("ninguno");
            cbpuntadas3.setSelectedItem("ninguno");

            cbpuntadas5.setModel(modelo4);
            AutoCompleteDecorator.decorate(cbpuntadas5);
            cbpuntadas5.addItem("ninguno");
            cbpuntadas5.setSelectedItem("ninguno");

            cbpuntadas6.setModel(modelo5);
            AutoCompleteDecorator.decorate(cbpuntadas6);
            cbpuntadas6.addItem("ninguno");
            cbpuntadas6.setSelectedItem("ninguno");

            cbpuntadas7.setModel(modelo6);
            AutoCompleteDecorator.decorate(cbpuntadas7);
            cbpuntadas7.addItem("ninguno");
            cbpuntadas7.setSelectedItem("ninguno");

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
    
    
    
    
    
    void combohilo() {

        
        String color = "";
        String hilo = "";
        String hiloconcolor = "";
        
        
        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo3 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo4 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo5 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo6 = new DefaultComboBoxModel();

            String sql = "SELECT distinct hilo,color  FROM catalogo_materiales where descripcion like 'HILO CODIGO%'ORDER BY hilo";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                modelo.addElement(rs.getObject("hilo"));
                modelo1.addElement(rs.getObject("hilo"));
                modelo2.addElement(rs.getObject("hilo"));
                modelo3.addElement(rs.getObject("hilo"));
                modelo4.addElement(rs.getObject("hilo"));
                modelo5.addElement(rs.getObject("hilo"));
                modelo6.addElement(rs.getObject("hilo"));
                
                
                hilo = rs.getString("hilo");
                color  = rs.getString("color");
                hiloconcolor = hilo.concat(color);
                
                
                lista.add(hiloconcolor);
                
                
                

            }
            
            
          

            cbhilo1.setModel(modelo);
            AutoCompleteDecorator.decorate(cbhilo1);
            cbhilo1.addItem("0");
            cbhilo1.setSelectedItem("0");

            cbhilo2.setModel(modelo1);
            AutoCompleteDecorator.decorate(cbhilo2);
            cbhilo2.addItem("0");
            cbhilo2.setSelectedItem("0");

            cbhilo4.setModel(modelo2);
            AutoCompleteDecorator.decorate(cbhilo4);
            cbhilo4.addItem("0");
            cbhilo4.setSelectedItem("0");

            cbhilo3.setModel(modelo3);
            AutoCompleteDecorator.decorate(cbhilo3);
            cbhilo3.addItem("0");
            cbhilo3.setSelectedItem("0");

            cbhilo5.setModel(modelo4);
            AutoCompleteDecorator.decorate(cbhilo5);
            cbhilo5.addItem("0");
            cbhilo5.setSelectedItem("0");

            cbhilo6.setModel(modelo5);
            AutoCompleteDecorator.decorate(cbhilo6);
            cbhilo6.addItem("0");
            cbhilo6.setSelectedItem("0");

            cbhilo7.setModel(modelo6);
            AutoCompleteDecorator.decorate(cbhilo7);
            cbhilo7.addItem("0");
            cbhilo7.setSelectedItem("0");

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
    
    
    
    
    
    
    
    
    void combocolor() {

        try {
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo3 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo4 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo5 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo6 = new DefaultComboBoxModel();

           String sql = "SELECT distinct color  FROM catalogo_materiales where descripcion like 'HILO CODIGO%'ORDER BY color";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                modelo.addElement(rs.getObject("color"));
                modelo1.addElement(rs.getObject("color"));
                modelo2.addElement(rs.getObject("color"));
                modelo3.addElement(rs.getObject("color"));
                modelo4.addElement(rs.getObject("color"));
                modelo5.addElement(rs.getObject("color"));
                modelo6.addElement(rs.getObject("color"));

            }

            cbcolor1.setModel(modelo);
            AutoCompleteDecorator.decorate(cbcolor1);
            cbcolor1.addItem("ninguno");
            cbcolor1.setSelectedItem("ninguno");

            cbcolor2.setModel(modelo1);
            AutoCompleteDecorator.decorate(cbcolor2);
            cbcolor2.addItem("ninguno");
            cbcolor2.setSelectedItem("ninguno");

            cbcolor4.setModel(modelo2);
            AutoCompleteDecorator.decorate(cbcolor4);
            cbcolor4.addItem("ninguno");
            cbcolor4.setSelectedItem("ninguno");

            cbcolor3.setModel(modelo3);
            AutoCompleteDecorator.decorate(cbcolor3);
            cbcolor3.addItem("ninguno");
            cbcolor3.setSelectedItem("ninguno");

            cbcolor5.setModel(modelo4);
            AutoCompleteDecorator.decorate(cbcolor5);
            cbcolor5.addItem("ninguno");
            cbcolor5.setSelectedItem("ninguno");

            cbcolor6.setModel(modelo5);
            AutoCompleteDecorator.decorate(cbcolor6);
            cbcolor6.addItem("ninguno");
            cbcolor6.setSelectedItem("ninguno");

            cbcolor7.setModel(modelo6);
            AutoCompleteDecorator.decorate(cbcolor7);
            cbcolor7.addItem("ninguno");
            cbcolor7.setSelectedItem("ninguno");

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
    
    
    
     
    
    void datoscombo()
    {
        
        
        
        Object prendaprevia1 = cbprenda.getSelectedItem();
       
        
        Object ubicacionprevia1 = cbubicacion1.getSelectedItem();
        Object ubicacionprevia2 = cbubicacion2.getSelectedItem();
        Object ubicacionprevia3 = cbubicacion3.getSelectedItem();
        Object ubicacionprevia4 = cbubicacion4.getSelectedItem();
        Object ubicacionprevia5 = cbubicacion5.getSelectedItem();
        Object ubicacionprevia6 = cbubicacion6.getSelectedItem();
        Object ubicacionprevia7 = cbubicacion7.getSelectedItem();
        
        Object colorprevio1 = cbcolor1.getSelectedItem();
        Object colorprevio2 = cbcolor2.getSelectedItem();
        Object colorprevio3 = cbcolor3.getSelectedItem();
        Object colorprevio4 = cbcolor4.getSelectedItem();
        Object colorprevio5 = cbcolor5.getSelectedItem();
        Object colorprevio6 = cbcolor6.getSelectedItem();
        Object colorprevio7 = cbcolor7.getSelectedItem();
       
        
        
          try {
                
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo3 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo4 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo5 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo6 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo7 = new DefaultComboBoxModel();
            

            String sql = "SELECT descripcion FROM catalogo_prendas_portanombres ORDER BY descripcion";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                modelo.addElement(rs.getObject("descripcion"));
                modelo2.addElement(rs.getObject("descripcion"));
                modelo3.addElement(rs.getObject("descripcion"));
                modelo4.addElement(rs.getObject("descripcion"));
                modelo5.addElement(rs.getObject("descripcion"));
                modelo6.addElement(rs.getObject("descripcion"));
                modelo7.addElement(rs.getObject("descripcion"));
            }

            cbprenda.setModel(modelo);
            cbprenda.setSelectedIndex(-1);
            cbprenda.setEditable(false);
            AutoCompleteDecorator.decorate(cbprenda);
            
          
           

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            
        
       
          
          
          
          
           
         try {
                
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo3 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo4 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo5 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo6 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo7 = new DefaultComboBoxModel();

            String sql = "SELECT descripcion FROM catalogo_ubicacion_portanombres ORDER BY descripcion";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                
              String descripcion = rs.getString("descripcion");
              
              
                if (descripcion.equals("")  ||  descripcion.equals(" "))
                {
                }
                else
                {

                modelo.addElement(rs.getObject("descripcion"));
                modelo2.addElement(rs.getObject("descripcion"));
                modelo3.addElement(rs.getObject("descripcion"));
                modelo4.addElement(rs.getObject("descripcion"));
                modelo5.addElement(rs.getObject("descripcion"));
                modelo6.addElement(rs.getObject("descripcion"));
                modelo7.addElement(rs.getObject("descripcion"));
                
                }
            }

            cbubicacion1.setModel(modelo);
            AutoCompleteDecorator.decorate(cbubicacion1);
            cbubicacion1.addItem("ninguno");
            cbubicacion1.setSelectedItem("ninguno");
            cbubicacion1.setEditable(false);
            
            
             cbubicacion2.setModel(modelo2);
            AutoCompleteDecorator.decorate(cbubicacion2);
            cbubicacion2.addItem("ninguno");
            cbubicacion2.setSelectedItem("ninguno");
            cbubicacion2.setEditable(false);
            
             cbubicacion3.setModel(modelo3);
            AutoCompleteDecorator.decorate(cbubicacion3);
            cbubicacion3.addItem("ninguno");
            cbubicacion3.setSelectedItem("ninguno");
            cbubicacion3.setEditable(false);
            
             cbubicacion4.setModel(modelo4);
            AutoCompleteDecorator.decorate(cbubicacion4);
            cbubicacion4.addItem("ninguno");
            cbubicacion4.setSelectedItem("ninguno");
            cbubicacion4.setEditable(false);
            
             cbubicacion5.setModel(modelo5);
            AutoCompleteDecorator.decorate(cbubicacion5);
            cbubicacion5.addItem("ninguno");
            cbubicacion5.setSelectedItem("ninguno");
            cbubicacion5.setEditable(false);
            
             cbubicacion6.setModel(modelo6);
            AutoCompleteDecorator.decorate(cbubicacion6);
            cbubicacion6.addItem("ninguno");
            cbubicacion6.setSelectedItem("ninguno");
            cbubicacion6.setEditable(false);
            
             cbubicacion7.setModel(modelo7);
            AutoCompleteDecorator.decorate(cbubicacion7);
            cbubicacion7.addItem("ninguno");
            cbubicacion7.setSelectedItem("ninguno");
            cbubicacion7.setEditable(false);
            
            
            
            
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
            
        
         
         try {
                
            DefaultComboBoxModel modelo = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo3 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo4 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo5 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo6 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo7 = new DefaultComboBoxModel();
            

            String sql = "SELECT descripcion FROM catalogo_colores_portanombres ORDER BY descripcion";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                modelo.addElement(rs.getObject("descripcion"));
                modelo2.addElement(rs.getObject("descripcion"));
                modelo3.addElement(rs.getObject("descripcion"));
                modelo4.addElement(rs.getObject("descripcion"));
                modelo5.addElement(rs.getObject("descripcion"));
                modelo6.addElement(rs.getObject("descripcion"));
                modelo7.addElement(rs.getObject("descripcion"));
            }

            cbcolor1.setModel(modelo);
            cbcolor1.setSelectedIndex(-1);
            cbcolor1.setEditable(false);
            AutoCompleteDecorator.decorate(cbcolor1);
            
            cbcolor2.setModel(modelo2);
            cbcolor2.setSelectedIndex(-1);
            cbcolor2.setEditable(false);
            AutoCompleteDecorator.decorate(cbcolor2);
            
            cbcolor3.setModel(modelo3);
            cbcolor3.setSelectedIndex(-1);
            cbcolor3.setEditable(false);
            AutoCompleteDecorator.decorate(cbcolor3);
            
            cbcolor4.setModel(modelo4);
            cbcolor4.setSelectedIndex(-1);
            cbcolor4.setEditable(false);
            AutoCompleteDecorator.decorate(cbcolor4);
            
            cbcolor5.setModel(modelo5);
            cbcolor5.setSelectedIndex(-1);
            cbcolor5.setEditable(false);
            AutoCompleteDecorator.decorate(cbcolor5);
            
            cbcolor6.setModel(modelo6);
            cbcolor6.setSelectedIndex(-1);
            cbcolor6.setEditable(false);
            AutoCompleteDecorator.decorate(cbcolor6);
            
            cbcolor7.setModel(modelo7);
           cbcolor7.setSelectedIndex(-1);
            cbcolor7.setEditable(false);
            AutoCompleteDecorator.decorate(cbcolor7);

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }   
         
        
         
         
        cbprenda.setSelectedItem(prendaprevia1);
       
         
         cbubicacion1.setSelectedItem(ubicacionprevia1);
         cbubicacion2.setSelectedItem(ubicacionprevia2);
         cbubicacion3.setSelectedItem(ubicacionprevia3);
         cbubicacion4.setSelectedItem(ubicacionprevia4);
         cbubicacion5.setSelectedItem(ubicacionprevia5);
         cbubicacion6.setSelectedItem(ubicacionprevia6);
         cbubicacion7.setSelectedItem(ubicacionprevia7);
         
        cbcolor1.setSelectedItem(colorprevio1);
        cbcolor2.setSelectedItem(colorprevio2);
        cbcolor3.setSelectedItem(colorprevio3);
        cbcolor4.setSelectedItem(colorprevio4);
        cbcolor5.setSelectedItem(colorprevio5);
        cbcolor6.setSelectedItem(colorprevio6);
        cbcolor7.setSelectedItem(colorprevio7);
        
        
        
        
    }
    
    
    
    
    
    

    void datos() {
       
        
        codigodelcliente = lbcodigocliente.getText();
        nombrebordado = txtidentificadordeprenda.getText().trim();
        numeroconsecutivo = txtconsecutivo.getText();
        tipobordado();
        combocolor();
        combohilo();
        agregarcoloresaloscombos();
        String sql = "";
        
               

                sql = "SELECT prenda_especial,nombre_bordado,"
                        + "distinta1_ubicacion,distinta1,distinta1_nombre,distinta1_aplicacion,distinta1_aplicacion_color,"
                        + "distinta2_ubicacion,distinta2,distinta2_nombre,distinta2_aplicacion,distinta2_aplicacion_color,"
                        + "distinta3_ubicacion,distinta3,distinta3_nombre,distinta3_aplicacion,distinta3_aplicacion_color,"
                        + "distinta4_ubicacion,distinta4,distinta4_nombre,distinta4_aplicacion,distinta4_aplicacion_color,"
                        + "distinta5_ubicacion,distinta5,distinta5_nombre,distinta5_aplicacion,distinta5_aplicacion_color,"
                        + "distinta6_ubicacion,distinta6,distinta6_nombre,distinta6_aplicacion,distinta6_aplicacion_color,"
                        + "distinta7_ubicacion,distinta7,distinta7_nombre,distinta7_aplicacion,distinta7_aplicacion_color,"
                        + "color1,color2,color3,color4,color5,color6,color7,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7 "
                        + " FROM bordados_puntadas where nombre_bordado = '"+nombrebordado+"'  and codigo = '"+codigodelcliente+"' AND tipo = '"+prenda+"' and numero_consecutivo = '"+numeroconsecutivo+"'"; 
            

        
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                        tipo = rs.getString("prenda_especial");
                    
                        nombrebordado = rs.getString("nombre_bordado");
                           
                        ubicacion1 = rs.getString("distinta1_ubicacion");
                        distinta1 = rs.getString("distinta1");
                        distinta1nombre = rs.getString("distinta1_nombre");
                        distinta1aplicacion = rs.getString("distinta1_aplicacion");
                        distinta1aplicacioncolor = rs.getString("distinta1_aplicacion_color");

                        ubicacion2 = rs.getString("distinta2_ubicacion");
                        distinta2 = rs.getString("distinta2");
                        distinta2nombre = rs.getString("distinta2_nombre");
                        distinta2aplicacion = rs.getString("distinta2_aplicacion");
                        distinta2aplicacioncolor = rs.getString("distinta2_aplicacion_color");

                        ubicacion3 = rs.getString("distinta3_ubicacion");
                        distinta3 = rs.getString("distinta3");
                        distinta3nombre = rs.getString("distinta3_nombre");
                        distinta3aplicacion = rs.getString("distinta3_aplicacion");
                        distinta3aplicacioncolor = rs.getString("distinta3_aplicacion_color");

                        ubicacion4 = rs.getString("distinta4_ubicacion");
                        distinta4 = rs.getString("distinta4");
                        distinta4nombre = rs.getString("distinta4_nombre");
                        distinta4aplicacion = rs.getString("distinta4_aplicacion");
                        distinta4aplicacioncolor = rs.getString("distinta4_aplicacion_color");

                        ubicacion5 = rs.getString("distinta5_ubicacion");
                        distinta5 = rs.getString("distinta5");
                        distinta5nombre = rs.getString("distinta5_nombre");
                        distinta5aplicacion = rs.getString("distinta5_aplicacion");
                        distinta5aplicacioncolor = rs.getString("distinta5_aplicacion_color");
                        
                        ubicacion6 = rs.getString("distinta6_ubicacion");
                        distinta6 = rs.getString("distinta6");
                        distinta6nombre = rs.getString("distinta6_nombre");
                        distinta6aplicacion = rs.getString("distinta6_aplicacion");
                        distinta6aplicacioncolor = rs.getString("distinta6_aplicacion_color");
                    
                        ubicacion7 = rs.getString("distinta7_ubicacion");
                        distinta7 = rs.getString("distinta7");
                        distinta7nombre = rs.getString("distinta7_nombre");
                        distinta7aplicacion = rs.getString("distinta7_aplicacion");
                        distinta7aplicacioncolor = rs.getString("distinta7_aplicacion_color");
                        
                        
                        cbcolor1.setSelectedItem(rs.getString("color1"));
                        cbcolor2.setSelectedItem(rs.getString("color2"));
                        cbcolor3.setSelectedItem(rs.getString("color3"));
                        cbcolor4.setSelectedItem(rs.getString("color4"));
                        cbcolor5.setSelectedItem(rs.getString("color5"));
                        cbcolor6.setSelectedItem(rs.getString("color6"));
                        cbcolor7.setSelectedItem(rs.getString("color7"));
                        
                        cbhilo1.setSelectedItem(rs.getString("hilo1"));
                        cbhilo2.setSelectedItem(rs.getString("hilo2"));
                        cbhilo3.setSelectedItem(rs.getString("hilo3"));
                        cbhilo4.setSelectedItem(rs.getString("hilo4"));
                        cbhilo5.setSelectedItem(rs.getString("hilo5"));
                        cbhilo6.setSelectedItem(rs.getString("hilo6"));
                        cbhilo7.setSelectedItem(rs.getString("hilo7"));
                        
                
                        
                        if (tipo.equals("ninguno")  ||  tipo.equals("")) 
                        
                        {
                            cbprenda.setEnabled(true);
                        }
                        else
                          {
                            cbprenda.setEnabled(false);
                        }   
                        
                        
                        txtidentificadordeprenda.setText(nombrebordado);
                       lbnombrebordadoanterior.setText(nombrebordado);
           
            cbubicacion1.setSelectedItem(ubicacion1);          
            cbpuntadas1.setSelectedItem(distinta1);
            txt1.setText(distinta1nombre);
            cbaplicacioncantidad1.setSelectedItem(distinta1aplicacion);
            cbaplicacioncolor1.setSelectedItem(distinta1aplicacioncolor);

             cbubicacion2.setSelectedItem(ubicacion2);
            cbpuntadas2.setSelectedItem(distinta2);
            txt2.setText(distinta2nombre);
            cbaplicacioncantidad2.setSelectedItem(distinta2aplicacion);
            cbaplicacioncolor2.setSelectedItem(distinta2aplicacioncolor);

             cbubicacion3.setSelectedItem(ubicacion3);
            cbpuntadas3.setSelectedItem(distinta3);
            txt3.setText(distinta3nombre);
            cbaplicacioncantidad3.setSelectedItem(distinta3aplicacion);
            cbaplicacioncolor3.setSelectedItem(distinta3aplicacioncolor);
  
             cbubicacion4.setSelectedItem(ubicacion4);
            cbpuntadas4.setSelectedItem(distinta4);
            txt4.setText(distinta4nombre);
            cbaplicacioncantidad4.setSelectedItem(distinta4aplicacion);
            cbaplicacioncolor4.setSelectedItem(distinta4aplicacioncolor);

             cbubicacion5.setSelectedItem(ubicacion5);       
            cbpuntadas5.setSelectedItem(distinta5);
            txt5.setText(distinta5nombre);
            cbaplicacioncantidad5.setSelectedItem(distinta5aplicacion);
            cbaplicacioncolor5.setSelectedItem(distinta5aplicacioncolor);
            
             cbubicacion6.setSelectedItem(ubicacion6);
            cbpuntadas6.setSelectedItem(distinta6);
            txt6.setText(distinta6nombre);
            cbaplicacioncantidad6.setSelectedItem(distinta6aplicacion);
            cbaplicacioncolor6.setSelectedItem(distinta6aplicacioncolor);
              
             cbubicacion7.setSelectedItem(ubicacion7);
            cbpuntadas7.setSelectedItem(distinta7);
            txt7.setText(distinta7nombre);
            cbaplicacioncantidad7.setSelectedItem(distinta7aplicacion);
            cbaplicacioncolor7.setSelectedItem(distinta7aplicacioncolor);
                
            actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            
            
            
          
            
            
            
            
            
            
            
         //   cbubicacion1.getSelectedItem().toString();
            
            
            // AQUI CHECA SI LOS NOBRES DE LA UBICACIONES NO TIENE UN COLOR, PARA QUE LO PONGAN EN EL COMBO
            
         String bordado1 = txt1.getText();
         bordado1 = bordado1.toUpperCase();
       //  String etiqueta1 = cbubicacion1.getSelectedItem().toString();
         
         String bordado2 = txt2.getText();
         bordado2 = bordado2.toUpperCase();
      //   String etiqueta2 = cbubicacion2.getSelectedItem().toString();
         
         String bordado3 = txt3.getText();
         bordado3 = bordado3.toUpperCase();
     //    String etiqueta3 = cbubicacion3.getSelectedItem().toString();
         
         String bordado4 = txt4.getText();
         bordado4 = bordado4.toUpperCase();
     //    String etiqueta4 = cbubicacion4.getSelectedItem().toString();
         
         
         String bordado5 = txt5.getText();
         bordado5 = bordado5.toUpperCase();
     //    String etiqueta5 = cbubicacion5.getSelectedItem().toString();
         
         String bordado6 = txt6.getText();
         bordado6 = bordado6.toUpperCase();
    //     String etiqueta6 = cbubicacion6.getSelectedItem().toString();
         
         String bordado7 = txt7.getText();
         bordado7 = bordado7.toUpperCase();
    //     String etiqueta7 = cbubicacion7.getSelectedItem().toString();
         
         if (bordado1.contains("VERDE") || bordado1.contains("DORADO") || bordado1.contains("ROJO") || bordado1.contains("AMARILO") || bordado1.contains("ANARANJADO") || bordado1.contains("BLANCO") || bordado1.contains("NEGRO") || bordado1.contains("MARINO") || bordado1.contains("AZUL") || bordado1.contains("GRIS") || bordado1.contains("VINO") || bordado1.contains("ROSA") || bordado1.contains("MORADO") || bordado1.contains("CAFE") || bordado1.contains("CREMA") || bordado1.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la ubicacion 1 tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
            
           if (bordado2.contains("VERDE") || bordado2.contains("DORADO") || bordado2.contains("ROJO") || bordado2.contains("AMARILO") || bordado2.contains("ANARANJADO") || bordado2.contains("BLANCO") || bordado2.contains("NEGRO") || bordado2.contains("MARINO") || bordado2.contains("AZUL") || bordado2.contains("GRIS") || bordado2.contains("VINO") || bordado2.contains("ROSA") || bordado2.contains("MORADO") || bordado2.contains("CAFE") || bordado2.contains("CREMA") || bordado2.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la ubicacion 2 tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
           
            if (bordado3.contains("VERDE") || bordado3.contains("DORADO") || bordado3.contains("ROJO") || bordado3.contains("AMARILO") || bordado3.contains("ANARANJADO") || bordado3.contains("BLANCO") || bordado3.contains("NEGRO") || bordado3.contains("MARINO") || bordado3.contains("AZUL") || bordado3.contains("GRIS") || bordado3.contains("VINO") || bordado3.contains("ROSA") || bordado3.contains("MORADO") || bordado3.contains("CAFE") || bordado3.contains("CREMA") || bordado3.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la ubicacion 3 tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
            
             if (bordado1.contains("VERDE") || bordado4.contains("DORADO") || bordado4.contains("ROJO") || bordado4.contains("AMARILO") || bordado4.contains("ANARANJADO") || bordado4.contains("BLANCO") || bordado4.contains("NEGRO") || bordado4.contains("MARINO") || bordado4.contains("AZUL") || bordado4.contains("GRIS") || bordado4.contains("VINO") || bordado4.contains("ROSA") || bordado4.contains("MORADO") || bordado4.contains("CAFE") || bordado4.contains("CREMA") || bordado4.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la ubicacion 4 tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
         
          if (bordado5.contains("VERDE") || bordado5.contains("DORADO") || bordado5.contains("ROJO") || bordado5.contains("AMARILO") || bordado5.contains("ANARANJADO") || bordado5.contains("BLANCO") || bordado5.contains("NEGRO") || bordado5.contains("MARINO") || bordado5.contains("AZUL") || bordado5.contains("GRIS") || bordado5.contains("VINO") || bordado5.contains("ROSA") || bordado5.contains("MORADO") || bordado5.contains("CAFE") || bordado5.contains("CREMA") || bordado5.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la ubicacion 5 tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
         
           if (bordado6.contains("VERDE") || bordado6.contains("DORADO") || bordado6.contains("ROJO") || bordado6.contains("AMARILO") || bordado6.contains("ANARANJADO") || bordado6.contains("BLANCO") || bordado6.contains("NEGRO") || bordado6.contains("MARINO") || bordado6.contains("AZUL") || bordado6.contains("GRIS") || bordado6.contains("VINO") || bordado6.contains("ROSA") || bordado6.contains("MORADO") || bordado6.contains("CAFE") || bordado6.contains("CREMA") || bordado6.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la ubicacion 6 tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
           
            if (bordado7.contains("VERDE") || bordado7.contains("DORADO") || bordado7.contains("ROJO") || bordado7.contains("AMARILO") || bordado7.contains("ANARANJADO") || bordado7.contains("BLANCO") || bordado7.contains("NEGRO") || bordado7.contains("MARINO") || bordado7.contains("AZUL") || bordado7.contains("GRIS") || bordado7.contains("VINO") || bordado7.contains("ROSA") || bordado7.contains("MORADO") || bordado7.contains("CAFE") || bordado7.contains("CREMA") || bordado7.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la ubicacion 7 tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
    }

         
         
    
    void cargarelfotomontaje()
    {
    
        
        BufferedImage img = null;
        String sqlimagen = "Select imagen,extension_imagen from bordados_puntadas where codigo = '" + codigodelcliente + "' and tipo = '"+lbtipo.getText()+"' and numero_consecutivo = '"+txtconsecutivo.getText()+"'   ";

        try {

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlimagen);
            if (rs.next()) {
                Imagen imagen = new Imagen();
                Blob blob = rs.getBlob(1);
                
                Object nombrefotomontaje = rs.getString(2);
                
                if (nombrefotomontaje == null || nombrefotomontaje.equals("")|| nombrefotomontaje.equals("ninguno")) 
                {
                    
                    lbfotomontaje.setText("NO HAY IMAGEN");
                    lbfotomontaje.setHorizontalAlignment(SwingConstants.CENTER);
                    lbfotomontaje.setVerticalAlignment(SwingConstants.CENTER);
                    btnverfotomontaje.setEnabled(false);
                    btneliminarfotomontaje.setEnabled(false);
                    btnagregarfotomontaje.setEnabled(true);

                } 
                
                else
                
                
                {
                    byte[] data = blob.getBytes(1, (int) blob.length());

                    try {
                        img = ImageIO.read(new ByteArrayInputStream(data));
                    } catch (IOException ex) {
                       
                    }

                    imagen.setImagen(img);
                    if(img == null)
                    {
                        btnimportarfotomontaje.doClick();
                    }
                    else
                    {
                    
                    if(lbtipo.getText().equals("PARCHE")) 
                    {
                      lbfotomontaje.setIcon(new ImageIcon(img.getScaledInstance(500, 500, Image.SCALE_SMOOTH))); //lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_SMOOTH  
                    }
                    else
                    {
                      lbfotomontaje.setIcon(new ImageIcon(img.getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT))); //  
                    }
                        
                    
                    repaint();
                    btnverfotomontaje.setEnabled(true);
                    btneliminarfotomontaje.setEnabled(true);
                    btnagregarfotomontaje.setEnabled(false);
                    }
                    
                    

                   
                }

            } //end while
            
            else
            {
                btnverfotomontaje.setEnabled(false);
                btneliminarfotomontaje.setEnabled(false);
            }
            
            
            rs.close();
        } catch (SQLException ex) {
           System.out.println(ex);
        }
        
    }
    
  
     
     
    void actualizarenhistorialventasycotizaciones()
    {
     
        String numeroventa = "";
        String articulo ="";
        String ubicacion = "";
        String nombrearticuloactualizar= "";
        String numerocotizacion = "";
        quevaainsertar();
        
        try {
       
            String sql = "SELECT numero,articulo FROM historial_ventas where codigo_cliente='"+codigodelcliente+"' and nombre_bordado = '"+lbnombrebordadoanterior.getText()+"'  ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                numeroventa = rs.getString("numero");
                articulo = rs.getString("articulo");
                
                
                
                
                
                if(articulo.contains("DISTINTA 1"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta1.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) nombrebordado,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 2"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta2.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) nombrebordado,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 3"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta3.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) nombrebordado,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 4"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta4.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) nombrebordado,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 5"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta5.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) nombrebordado,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 6"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta6.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) nombrebordado,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 7"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta7.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) nombrebordado,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                
                
             
            }
            
         
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

    
    void actualizarlaubicacion(String ubicacion,String numeroventa,String nombrebordado,String nombrearticuloactualizar,String numerocotizacion)
    {
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_VENTAS SET ARTICULO = '"+ubicacion.trim()+ "' ,nombre_bordado = '"+txtidentificadordeprenda.getText()+"' WHERE codigo_cliente='" + codigodelcliente + "' and nombre_bordado = '" +lbnombrebordadoanterior.getText()+ "'  AND numero = '" + numeroventa + "' and articulo = '"+nombrearticuloactualizar+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
         
        
        
        if(numerocotizacion == null || numerocotizacion.equals("")|| numerocotizacion.equals(" "))
        {
            
        }
        else
        {   
        
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_COTIZACIONES SET ARTICULO = '"+ubicacion.trim()+ "' WHERE codigo_cliente='" + codigodelcliente + "' and nombre_bordado = '" + nombrebordado + "'  AND numero = '" + numerocotizacion + "' and articulo = '"+nombrearticuloactualizar+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        
    }
    
    
    void quevaainsertar(){
    
        prenda = cbprenda.getSelectedItem().toString();
        Object nombrebordado = lbnombrebordadoanterior.getText();
        
        String nombre1 = txt1.getText();
        String nombre2 = txt2.getText();
        String nombre3 = txt4.getText();
        String nombre4 = txt3.getText();
        String nombre5 = txt5.getText();
        String nombre6 = txt6.getText();
        String nombre7 = txt7.getText();
        
    
        distinta1 = "BORDADO UBICACION 1 "+nombre1+"";
        distinta2 = "BORDADO UBICACION 2 "+nombre2+"";
        distinta3 = "BORDADO UBICACION 3 "+nombre3+""; 
        distinta4 = "BORDADO UBICACION 4 "+nombre4+"";
        distinta5 = "BORDADO UBICACION 5 "+nombre5+"";
        distinta6 = "BORDADO UBICACION 6 "+nombre6+"";
        distinta7 = "BORDADO UBICACION 7 "+nombre7+""; 
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbcodigocliente = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        cbpuntadas1 = new javax.swing.JComboBox<>();
        lbanuncio = new javax.swing.JLabel();
        cbpuntadas2 = new javax.swing.JComboBox<>();
        cbpuntadas4 = new javax.swing.JComboBox<>();
        cbpuntadas3 = new javax.swing.JComboBox<>();
        cbpuntadas5 = new javax.swing.JComboBox<>();
        cbpuntadas6 = new javax.swing.JComboBox<>();
        jLabel49 = new javax.swing.JLabel();
        txt1 = new javax.swing.JTextField();
        txt2 = new javax.swing.JTextField();
        txt4 = new javax.swing.JTextField();
        txt3 = new javax.swing.JTextField();
        txt5 = new javax.swing.JTextField();
        txt6 = new javax.swing.JTextField();
        cbaplicacioncolor6 = new javax.swing.JComboBox();
        cbaplicacioncolor5 = new javax.swing.JComboBox();
        cbaplicacioncolor3 = new javax.swing.JComboBox();
        cbaplicacioncolor4 = new javax.swing.JComboBox();
        cbaplicacioncolor2 = new javax.swing.JComboBox();
        cbaplicacioncolor1 = new javax.swing.JComboBox();
        btnguardar = new javax.swing.JButton();
        cbaplicacioncantidad1 = new javax.swing.JComboBox<>();
        cbaplicacioncantidad2 = new javax.swing.JComboBox<>();
        cbaplicacioncantidad4 = new javax.swing.JComboBox<>();
        cbaplicacioncantidad3 = new javax.swing.JComboBox<>();
        cbaplicacioncantidad5 = new javax.swing.JComboBox<>();
        cbaplicacioncantidad6 = new javax.swing.JComboBox<>();
        lbtipo = new javax.swing.JLabel();
        cbpuntadas7 = new javax.swing.JComboBox<>();
        txt7 = new javax.swing.JTextField();
        cbaplicacioncantidad7 = new javax.swing.JComboBox<>();
        cbaplicacioncolor7 = new javax.swing.JComboBox();
        btnagregarfotomontaje = new javax.swing.JButton();
        btnverfotomontaje = new javax.swing.JButton();
        btneliminarfotomontaje = new javax.swing.JButton();
        btneliminartodo = new javax.swing.JButton();
        lbfotomontaje = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        btndatos = new javax.swing.JButton();
        btnpuntadas = new javax.swing.JButton();
        lbnombrecomercial = new javax.swing.JLabel();
        txtidentificadordeprenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtconsecutivo = new javax.swing.JLabel();
        btnimportarfotomontaje = new javax.swing.JButton();
        lbnombrebordadoanterior = new javax.swing.JLabel();
        lbconsecutivo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        cbcolor1 = new javax.swing.JComboBox();
        cbcolor2 = new javax.swing.JComboBox();
        cbcolor3 = new javax.swing.JComboBox();
        cbcolor4 = new javax.swing.JComboBox();
        cbcolor5 = new javax.swing.JComboBox();
        cbcolor6 = new javax.swing.JComboBox();
        cbcolor7 = new javax.swing.JComboBox();
        jLabel60 = new javax.swing.JLabel();
        cbhilo1 = new javax.swing.JComboBox();
        cbhilo2 = new javax.swing.JComboBox();
        cbhilo3 = new javax.swing.JComboBox();
        cbhilo5 = new javax.swing.JComboBox();
        cbhilo4 = new javax.swing.JComboBox();
        cbhilo6 = new javax.swing.JComboBox();
        cbhilo7 = new javax.swing.JComboBox();
        cbprenda = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        cbubicacion7 = new javax.swing.JComboBox<>();
        cbubicacion1 = new javax.swing.JComboBox<>();
        cbubicacion2 = new javax.swing.JComboBox<>();
        cbubicacion4 = new javax.swing.JComboBox<>();
        cbubicacion3 = new javax.swing.JComboBox<>();
        cbubicacion5 = new javax.swing.JComboBox<>();
        cbubicacion6 = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        txtagregarprenda = new javax.swing.JTextField();
        btnagregarprenda = new javax.swing.JButton();
        txtagregarubicacion = new javax.swing.JTextField();
        btnagregarubicacion = new javax.swing.JButton();
        btnagregarbordados = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Bordados del cliente editar distinta");
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("CLIENTE");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lbcliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbclienteMouseClicked(evt);
            }
        });

        lbcodigocliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbcodigocliente.setText("00000000");

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        cbpuntadas1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadas1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadas1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        lbanuncio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbanuncio.setText("Anuncio");
        lbanuncio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbpuntadas2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadas2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadas2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbpuntadas4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadas4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadas4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbpuntadas3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadas3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadas3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbpuntadas5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadas5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadas5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbpuntadas6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadas6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadas6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel49.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel49.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel49.setText("Puntadas");
        jLabel49.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txt1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt1FocusLost(evt);
            }
        });
        txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt1ActionPerformed(evt);
            }
        });
        txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt1KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt1KeyReleased(evt);
            }
        });

        txt2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt2FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt2FocusLost(evt);
            }
        });
        txt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt2ActionPerformed(evt);
            }
        });
        txt2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt2KeyReleased(evt);
            }
        });

        txt4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt4FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt4FocusLost(evt);
            }
        });
        txt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt4ActionPerformed(evt);
            }
        });
        txt4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt4KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt4KeyReleased(evt);
            }
        });

        txt3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt3FocusLost(evt);
            }
        });
        txt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt3ActionPerformed(evt);
            }
        });
        txt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt3KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt3KeyReleased(evt);
            }
        });

        txt5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt5FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt5FocusLost(evt);
            }
        });
        txt5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt5ActionPerformed(evt);
            }
        });
        txt5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt5KeyReleased(evt);
            }
        });

        txt6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt6FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt6FocusLost(evt);
            }
        });
        txt6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt6ActionPerformed(evt);
            }
        });
        txt6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt6KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt6KeyReleased(evt);
            }
        });

        cbaplicacioncolor6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncolor6.setToolTipText("");

        cbaplicacioncolor5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncolor5.setToolTipText("");

        cbaplicacioncolor3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncolor3.setToolTipText("");

        cbaplicacioncolor4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncolor4.setToolTipText("");

        cbaplicacioncolor2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        cbaplicacioncolor1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncolor1.setToolTipText("");

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 102, 0));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        cbaplicacioncantidad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncantidad1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));
        cbaplicacioncantidad1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbaplicacioncantidad2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncantidad2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));
        cbaplicacioncantidad2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbaplicacioncantidad4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncantidad4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));
        cbaplicacioncantidad4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad4PopupMenuWillBecomeVisible(evt);
            }
        });

        cbaplicacioncantidad3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncantidad3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));
        cbaplicacioncantidad3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad3PopupMenuWillBecomeVisible(evt);
            }
        });

        cbaplicacioncantidad5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncantidad5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));
        cbaplicacioncantidad5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad5PopupMenuWillBecomeVisible(evt);
            }
        });

        cbaplicacioncantidad6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncantidad6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));
        cbaplicacioncantidad6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad6PopupMenuWillBecomeVisible(evt);
            }
        });

        lbtipo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbtipo.setForeground(new java.awt.Color(153, 0, 0));
        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbpuntadas7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadas7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadas7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        txt7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txt7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt7FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt7FocusLost(evt);
            }
        });
        txt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt7ActionPerformed(evt);
            }
        });
        txt7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt7KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt7KeyReleased(evt);
            }
        });

        cbaplicacioncantidad7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncantidad7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));
        cbaplicacioncantidad7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncantidad7PopupMenuWillBecomeVisible(evt);
            }
        });

        cbaplicacioncolor7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbaplicacioncolor7.setToolTipText("");

        btnagregarfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnagregarfotomontaje.setText("Agregar fotomontaje");
        btnagregarfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarfotomontajeActionPerformed(evt);
            }
        });

        btnverfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnverfotomontaje.setText("Ver fotomontaje");
        btnverfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverfotomontajeActionPerformed(evt);
            }
        });

        btneliminarfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btneliminarfotomontaje.setText("Eliminar fotomontaje");
        btneliminarfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarfotomontajeActionPerformed(evt);
            }
        });

        btneliminartodo.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btneliminartodo.setForeground(new java.awt.Color(153, 0, 0));
        btneliminartodo.setText("Eliminar bordado");
        btneliminartodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminartodoActionPerformed(evt);
            }
        });

        lbfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbfotomontaje.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Nombre de bordado");
        jLabel50.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Cant        Aplicaciones        Color");
        jLabel58.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndatos.setText("datos");
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
            }
        });

        btnpuntadas.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnpuntadas.setText("Ve las puntadas de bordados de Seguridad, Seguridad Privaday Vigilancia");
        btnpuntadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpuntadasActionPerformed(evt);
            }
        });

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtidentificadordeprenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtidentificadordeprenda.setForeground(new java.awt.Color(153, 0, 0));
        txtidentificadordeprenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtidentificadordeprendaFocusGained(evt);
            }
        });
        txtidentificadordeprenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidentificadordeprendaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidentificadordeprendaKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Identificador de prenda");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtconsecutivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtconsecutivo.setText("00000000");
        txtconsecutivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnimportarfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnimportarfotomontaje.setText("importar fotomontaje");
        btnimportarfotomontaje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimportarfotomontajeActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Identificador");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Color");
        jLabel59.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbcolor1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbcolor1.setToolTipText("");
        cbcolor1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor1PopupMenuWillBecomeVisible(evt);
            }
        });

        cbcolor2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbcolor2.setToolTipText("");
        cbcolor2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor2PopupMenuWillBecomeVisible(evt);
            }
        });

        cbcolor3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbcolor3.setToolTipText("");
        cbcolor3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor3PopupMenuWillBecomeVisible(evt);
            }
        });

        cbcolor4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbcolor4.setToolTipText("");
        cbcolor4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor4PopupMenuWillBecomeVisible(evt);
            }
        });

        cbcolor5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbcolor5.setToolTipText("");
        cbcolor5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor5PopupMenuWillBecomeVisible(evt);
            }
        });

        cbcolor6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbcolor6.setToolTipText("");
        cbcolor6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor6PopupMenuWillBecomeVisible(evt);
            }
        });

        cbcolor7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbcolor7.setToolTipText("");
        cbcolor7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbcolor7PopupMenuWillBecomeVisible(evt);
            }
        });

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Cod/Hilo");
        jLabel60.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbhilo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo1.setToolTipText("");
        cbhilo1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo1PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo2.setToolTipText("");
        cbhilo2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo2PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo3.setToolTipText("");
        cbhilo3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo3PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo5.setToolTipText("");
        cbhilo5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo5PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo4.setToolTipText("");
        cbhilo4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo4PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo6.setToolTipText("");
        cbhilo6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo6PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo7.setToolTipText("");
        cbhilo7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo7PopupMenuWillBecomeVisible(evt);
            }
        });

        cbprenda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbprenda.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbprendaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Prenda");
        jLabel51.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbubicacion7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbubicacion7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbubicacion7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbubicacion1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbubicacion1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbubicacion1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbubicacion2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbubicacion2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbubicacion2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbubicacion4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbubicacion4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbubicacion4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbubicacion3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbubicacion3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbubicacion3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbubicacion5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbubicacion5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbubicacion5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbubicacion6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbubicacion6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbubicacion6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Ubicacion");
        jLabel52.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtagregarprenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtagregarprenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtagregarprendaKeyReleased(evt);
            }
        });

        btnagregarprenda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnagregarprenda.setText("Agregar nueva prenda");
        btnagregarprenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarprendaActionPerformed(evt);
            }
        });

        txtagregarubicacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtagregarubicacion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtagregarubicacionKeyReleased(evt);
            }
        });

        btnagregarubicacion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnagregarubicacion.setText("Agregar nueva ubicacion");
        btnagregarubicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarubicacionActionPerformed(evt);
            }
        });

        btnagregarbordados.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnagregarbordados.setForeground(new java.awt.Color(0, 102, 0));
        btnagregarbordados.setText("Agregar bordado");
        btnagregarbordados.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                btnagregarbordadosMouseDragged(evt);
            }
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                btnagregarbordadosMouseMoved(evt);
            }
        });
        btnagregarbordados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnagregarbordadosMouseEntered(evt);
            }
        });
        btnagregarbordados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnagregarbordadosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 1771, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(btnagregarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btneliminarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(btnimportarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 2, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbubicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbubicacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbubicacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbubicacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbubicacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbubicacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(cbpuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbpuntadas2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbpuntadas3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbpuntadas4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbpuntadas5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbpuntadas6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(cbpuntadas7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(105, 105, 105)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(2, 2, 2)
                                                        .addComponent(cbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(420, 420, 420)
                                                .addComponent(cbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(cbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(232, 232, 232)
                                                .addComponent(cbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(cbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(cbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(cbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(12, 12, 12)
                                                        .addComponent(cbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                        .addGap(20, 20, 20))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(12, 12, 12)
                                        .addComponent(btnpuntadas)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbanuncio, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(9, 9, 9)
                                        .addComponent(lbconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(1, 1, 1)
                                        .addComponent(lbnombrebordadoanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btneliminartodo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(txtagregarprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnagregarprenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtagregarubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnagregarubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(cbaplicacioncolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(cbaplicacioncantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbaplicacioncolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(cbaplicacioncantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbaplicacioncolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(cbaplicacioncolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(cbaplicacioncantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cbaplicacioncolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbaplicacioncantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbaplicacioncantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbaplicacioncantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbaplicacioncantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addComponent(cbaplicacioncolor2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(cbaplicacioncolor7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(7, 7, 7)
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel11)
                                .addGap(7, 7, 7)
                                .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnagregarbordados, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnagregarbordados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbpuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbpuntadas2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbpuntadas3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(cbpuntadas4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbpuntadas5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbpuntadas6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbpuntadas7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbubicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(cbubicacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbubicacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(cbubicacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbubicacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbubicacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtagregarprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnagregarprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtagregarubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnagregarubicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btneliminarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnimportarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbanuncio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnagregarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(48, 48, 48)
                                .addComponent(cbaplicacioncantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbaplicacioncantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbaplicacioncolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80)
                                .addComponent(cbaplicacioncantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbaplicacioncantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbaplicacioncolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(cbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(cbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbaplicacioncantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbaplicacioncolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(cbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbaplicacioncantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbaplicacioncolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(lbconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(68, 68, 68)
                                        .addComponent(lbnombrebordadoanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btneliminartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(cbaplicacioncolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbaplicacioncolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbaplicacioncantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(cbaplicacioncolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGap(10, 10, 10)
                .addComponent(lbfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        ventanabordadosdelclienteeditardistinta = false;
        this.dispose();;
    }//GEN-LAST:event_btnsalirActionPerformed

    private void txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt1ActionPerformed

    private void txt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt2ActionPerformed

    private void txt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt4ActionPerformed

    private void txt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt3ActionPerformed

    private void txt5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt5ActionPerformed

    private void txt6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt6ActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed

       
        
        String yahayunbordadosconesenombre = "no";
        
        
        pasa = "si";
       
        prenda = cbprenda.getSelectedItem().toString();
        
        String nombrebordado = txtidentificadordeprenda.getText().trim();
        
        if( (nombrebordado == null || nombrebordado.equals("") ||nombrebordado.equals(" ")  ||nombrebordado.equals("1")  ||nombrebordado.equals("2") ||nombrebordado.equals("3")||nombrebordado.equals("4")) && actualizarbordado.equals("no") )
        {
         
        pasa = "no";    
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar un nombre del bordado");
        txtidentificadordeprenda.requestFocus();
        txtidentificadordeprenda.selectAll();
            
        }
        else
        {
            
            String nombre1 = txt1.getText().trim();
            String nombre2 = txt2.getText().trim();
            String nombre3 = txt4.getText().trim();
            String nombre4 = txt3.getText().trim();
            String nombre5 = txt5.getText().trim();
            String nombre6 = txt6.getText().trim();
            String nombre7 = txt7.getText().trim();
            
            
            
            if (nombre1.equals("") && nombre2.equals("") && nombre3.equals("") && nombre4.equals("") && nombre5.equals("")&& nombre6.equals("")&& nombre7.equals("") )
                
            {
                
                  JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas y nombre a los bordados");
                  pasa = "no";
                
            }
            
                else
                
            {
                
            /// UBICACION 1
              
           String puntadas1 = cbpuntadas1.getSelectedItem().toString();
            
            
           if (puntadas1.startsWith("BORDADO"))
           {
               
             if (nombre1.equals("") ||  nombre1.equals(" ") || nombre1.equals("ninguno")  || nombre1.equals("NINGUNO"))
             {
              JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 1");
              pasa = "no";
             }
               
           }
             if (!nombre1.equals("") && !nombre1.equals(" ") && !nombre1.equals("ninguno")  && !nombre1.equals("NINGUNO"))
                 
             {
                  if (!puntadas1.startsWith("BORDADO"))
                  {
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 1");
                      pasa = "no";
                  }
                 
             }
            
            
            
            String puntadas2 = cbpuntadas2.getSelectedItem().toString();
           
            
             if (puntadas2.startsWith("BORDADO"))
           {
               
             if (nombre2.equals("") ||  nombre2.equals(" ") || nombre2.equals("ninguno")   || nombre2.equals("NINGUNO"))
             {
              JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 2");
              pasa = "no";
             }
               
           }
             if (!nombre2.equals("") && !nombre2.equals(" ") && !nombre2.equals("ninguno") && !nombre2.equals("NINGUNO"))
                 
             {
                  if (!puntadas2.startsWith("BORDADO"))
                  {
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 2");
                      pasa = "no";
                  }
                 
             }
             
             
            
            String puntadas3 = cbpuntadas4.getSelectedItem().toString();
           
            
             if (puntadas3.startsWith("BORDADO"))
           {
               
             if (nombre3.equals("") ||  nombre3.equals(" ") || nombre3.equals("ninguno")   || nombre3.equals("NINGUNO"))
             {
              JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 3");
              pasa = "no";
             }
               
           }
             if (!nombre3.equals("") && !nombre3.equals(" ") && !nombre3.equals("ninguno")  && !nombre3.equals("NINGUNO"))
                 
             {
                  if (!puntadas3.startsWith("BORDADO"))
                  {
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 3");
                      pasa = "no";
                  }
                 
             }
            
            
            String puntadas4 = cbpuntadas3.getSelectedItem().toString();
          
            
            
             if (puntadas4.startsWith("BORDADO"))
           {
               
             if (nombre4.equals("") ||  nombre4.equals(" ") || nombre4.equals("ninguno")  || nombre4.equals("NINGUNO"))
             {
              JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 4");
              pasa = "no";
             }
               
           }
             if (!nombre4.equals("") && !nombre4.equals(" ") && !nombre4.equals("ninguno") && !nombre4.equals("NINGUNO"))
                 
             {
                  if (!puntadas4.startsWith("BORDADO"))
                  {
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 4");
                      pasa = "no";
                  }
                 
             }
            
            
            String puntadas5 = cbpuntadas5.getSelectedItem().toString();
           
            
            
             if (puntadas5.startsWith("BORDADO"))
           {
               
             if (nombre5.equals("") ||  nombre5.equals(" ") || nombre5.equals("ninguno") || nombre5.equals("NINGUNO"))
             {
              JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 5");
              pasa = "no";
             }
               
           }
             if (!nombre5.equals("") && !nombre5.equals(" ") && !nombre5.equals("ninguno") && !nombre5.equals("NINGUNO"))
                 
             {
                  if (!puntadas5.startsWith("BORDADO"))
                  {
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 5");
                      pasa = "no";
                  }
                 
             }
            
            
            String puntadas6 = cbpuntadas6.getSelectedItem().toString();
            nombre6 = txt6.getText();
            
            
             if (puntadas6.startsWith("BORDADO"))
           {
               
             if (nombre6.equals("") ||  nombre6.equals(" ") || nombre6.equals("ninguno")  || nombre6.equals("NINGUNO"))
             {
              JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 6");
              pasa = "no";
             }
               
           }
             if (!nombre6.equals("") && !nombre6.equals(" ") && !nombre6.equals("ninguno") && !nombre6.equals("NINGUNO"))
                 
             {
                  if (!puntadas6.startsWith("BORDADO"))
                  {
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 6");
                      pasa = "no";
                  }
                 
             }
            
            
            String puntadas7 = cbpuntadas7.getSelectedItem().toString();
            nombre7 = txt7.getText();
            
            
             if (puntadas7.startsWith("BORDADO"))
           {
               
             if (nombre7.equals("") ||  nombre7.equals(" ") || nombre7.equals("ninguno")   || nombre7.equals("NINGUNO"))
             {
              JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 7");
              pasa = "no";
             }
               
           }
             
             
             if (!nombre7.equals("") && !nombre7.equals(" ") && !nombre7.equals("ninguno") && !nombre7.equals("NINGUNO"))
                 
             {
                  if (!puntadas7.startsWith("BORDADO"))
                  {
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 7");
                      pasa = "no";
                  }
                 
             }
             
             
            
             
             
             
             
             
            
            
            if (pasa.equals("si"))
                
            {
                
               
            if(actualizarbordado.equals("no"))
            {
     
                
                
                try {
       
                String sql = "SELECT codigo FROM bordados_puntadas where codigo='"+codigodelcliente+"' and nombre_bordado = '"+lbnombrebordadoanterior.getText()+"'  AND tipo = '"+prenda+"'   ";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                
                
                yahayunbordadosconesenombre = "si";
                pasa = "no";
                
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya existe un bordado con este nombre,favor de cambiar el nombre");
                txtidentificadordeprenda.requestFocus();
                txtidentificadordeprenda.selectAll();

             
            }
            else
                
            {
                yahayunbordadosconesenombre = "no";
                
            }

         
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    
        }
                
            
            
            
            
            
            
            
            
                if (yahayunbordadosconesenombre.equals("no"))
                
                
                {     
                
                

                tipodeprenda = "distinta";
            
            
            
                 prenda = cbprenda.getSelectedItem().toString();
            if(prenda==null || tipo.equals("")||tipo.equals(" "))
            {
                prenda = "ninguno";
            }
            
            
            
            
            
            
            
       
                    
              ubicacion1 = cbubicacion1.getSelectedItem();
            if(ubicacion1==null || ubicacion1.equals("")||ubicacion1.equals(" "))
            {
                ubicacion1 = "ninguno";
            }       
                    
                    
             distinta1 = cbpuntadas1.getSelectedItem();
            if(distinta1==null || distinta1.equals("")||distinta1.equals(" "))
            {
                distinta1 = "ninguno";
            }
            distinta1nombre = txt1.getText().trim();
        
            distinta1aplicacion = cbaplicacioncantidad1.getSelectedItem();
            if(distinta1aplicacion==null || distinta1aplicacion.equals("")||distinta1aplicacion.equals(" "))
            {
                distinta1aplicacion = "0";
            }
             distinta1aplicacioncolor = cbaplicacioncolor1.getSelectedItem();
            if(distinta1aplicacioncolor==null || distinta1aplicacioncolor.equals("")||distinta1aplicacioncolor.equals(" "))
            {
                distinta1aplicacioncolor = "ninguno";
            }

            
            
            
            
            
             ubicacion2 = cbubicacion2.getSelectedItem();
            if(ubicacion2==null || ubicacion2.equals("")||ubicacion2.equals(" "))
            {
                ubicacion2 = "ninguno";
            }   
            
            
               distinta2 = cbpuntadas2.getSelectedItem();
            if(distinta2==null || distinta2.equals("")||distinta2.equals(" "))
            {
                distinta2 = "ninguno";
            }
            
            distinta2nombre = txt2.getText().trim();
        
            
            
             distinta2aplicacion = cbaplicacioncantidad2.getSelectedItem();
            if(distinta2aplicacion==null || distinta2aplicacion.equals("")||distinta2aplicacion.equals(" "))
            {
                distinta2aplicacion = "0";
            }
             distinta2aplicacioncolor = cbaplicacioncolor2.getSelectedItem();
            if(distinta2aplicacioncolor==null || distinta2aplicacioncolor.equals("")||distinta2aplicacioncolor.equals(" "))
            {
                distinta2aplicacioncolor = "ninguno";
            }

            
            
            
            
            
             ubicacion3 = cbubicacion3.getSelectedItem();
            if(ubicacion3==null || ubicacion3.equals("")||ubicacion3.equals(" "))
            {
                ubicacion3 = "ninguno";
            }   
            
               distinta3 = cbpuntadas3.getSelectedItem();
            if(distinta3==null || distinta3.equals("")||distinta3.equals(" "))
            {
                distinta3 = "ninguno";
            }
             distinta3nombre = txt3.getText().trim();
        
             distinta3aplicacion = cbaplicacioncantidad3.getSelectedItem();
            if(distinta3aplicacion==null || distinta3aplicacion.equals("")||distinta3aplicacion.equals(" "))
            {
                distinta3aplicacion = "0";
            }
             distinta3aplicacioncolor = cbaplicacioncolor3.getSelectedItem();
            if(distinta3aplicacioncolor==null || distinta3aplicacioncolor.equals("")||distinta3aplicacioncolor.equals(" "))
            {
                distinta3aplicacioncolor = "ninguno";
            }

            
            
            
            
             ubicacion4 = cbubicacion4.getSelectedItem();
            if(ubicacion4==null || ubicacion4.equals("")||ubicacion4.equals(" "))
            {
                ubicacion4 = "ninguno";
            }   
            
               distinta4 = cbpuntadas4.getSelectedItem();
            if(distinta4==null || distinta4.equals("")||distinta4.equals(" "))
            {
                distinta4 = "ninguno";
            }
             distinta4nombre = txt4.getText().trim();
        
             distinta4aplicacion = cbaplicacioncantidad4.getSelectedItem();
            if(distinta4aplicacion==null || distinta4aplicacion.equals("")||distinta4aplicacion.equals(" "))
            {
                distinta4aplicacion = "0";
            }
             distinta4aplicacioncolor = cbaplicacioncolor4.getSelectedItem();
            if(distinta4aplicacioncolor==null || distinta4aplicacioncolor.equals("")||distinta4aplicacioncolor.equals(" "))
            {
                distinta4aplicacioncolor = "ninguno";
            }

            
            
          
             ubicacion5 = cbubicacion5.getSelectedItem();
            if(ubicacion5==null || ubicacion5.equals("")||ubicacion5.equals(" "))
            {
                ubicacion5 = "ninguno";
            }   
            
            
             distinta5 = cbpuntadas5.getSelectedItem();
            if(distinta5==null || distinta5.equals("")||distinta5.equals(" "))
            {
                distinta5 = "ninguno";
            }
             distinta5nombre = txt5.getText().trim();
        
             distinta5aplicacion = cbaplicacioncantidad5.getSelectedItem();
            if(distinta5aplicacion==null || distinta5aplicacion.equals("")||distinta5aplicacion.equals(" "))
            {
                distinta5aplicacion = "0";
            }
             distinta5aplicacioncolor = cbaplicacioncolor5.getSelectedItem();
            if(distinta5aplicacioncolor==null || distinta5aplicacioncolor.equals("")||distinta5aplicacioncolor.equals(" "))
            {
                distinta5aplicacioncolor = "ninguno";
            }

           
            
            
             ubicacion6 = cbubicacion6.getSelectedItem();
            if(ubicacion6==null || ubicacion6.equals("")||ubicacion6.equals(" "))
            {
                ubicacion6 = "ninguno";
            }   
            
            
               distinta6 = cbpuntadas6.getSelectedItem();
            if(distinta6==null || distinta6.equals("")||distinta6.equals(" "))
            {
                distinta6 = "ninguno";
            }
             distinta6nombre = txt6.getText().trim();
        
             distinta6aplicacion = cbaplicacioncantidad6.getSelectedItem();
            if(distinta6aplicacion==null || distinta6aplicacion.equals("")||distinta6aplicacion.equals(" "))
            {
                distinta6aplicacion = "0";
            }
             distinta6aplicacioncolor = cbaplicacioncolor6.getSelectedItem();
            if(distinta6aplicacioncolor==null || distinta6aplicacioncolor.equals("")||distinta6aplicacioncolor.equals(" "))
            {
                distinta6aplicacioncolor = "ninguno";
            }

           
            
             ubicacion7 = cbubicacion7.getSelectedItem();
            if(ubicacion7==null || ubicacion7.equals("")||ubicacion7.equals(" "))
            {
                ubicacion7 = "ninguno";
            }   
            
               distinta7 = cbpuntadas7.getSelectedItem();
            if(distinta7==null || distinta7.equals("")||distinta7.equals(" "))
            {
                distinta7 = "ninguno";
            }
             distinta7nombre = txt7.getText().trim();
        
             distinta7aplicacion = cbaplicacioncantidad7.getSelectedItem();
            if(distinta7aplicacion==null || distinta7aplicacion.equals("")||distinta7aplicacion.equals(" "))
            {
                distinta7aplicacion = "0";
            }
             distinta7aplicacioncolor = cbaplicacioncolor7.getSelectedItem();
            if(distinta7aplicacioncolor==null || distinta7aplicacioncolor.equals("")||distinta7aplicacioncolor.equals(" "))
            {
                distinta7aplicacioncolor = "ninguno";
            }

            
            
            
                
             Object color1 = cbcolor1.getSelectedItem();
              if(color1==null || color1.equals("")||color1.equals(" "))
            {
                color1 = "ninguno";
            }
                Object color2 = cbcolor2.getSelectedItem();
              if(color2==null || color2.equals("")||color2.equals(" "))
            {
                color2 = "ninguno";
            }
                Object color3 = cbcolor3.getSelectedItem();
              if(color3==null || color3.equals("")||color3.equals(" "))
            {
                color3 = "ninguno";
            }
                Object color4 = cbcolor4.getSelectedItem();
              if(color4==null || color4.equals("")||color4.equals(" "))
            {
                color4 = "ninguno";
            }
                Object color5 = cbcolor5.getSelectedItem();
              if(color5==null || color5.equals("")||color5.equals(" "))
            {
                color5 = "ninguno";
            }
                Object color6 = cbcolor6.getSelectedItem();
              if(color6==null || color6.equals("")||color6.equals(" "))
            {
                color6 = "ninguno";
            }
                Object color7 = cbcolor7.getSelectedItem();
              if(color7==null || color7.equals("")||color7.equals(" "))
            {
                color7 = "ninguno";
            }
              
              
              
                Object hilo1 = cbhilo1.getSelectedItem();
              if(hilo1==null || hilo1.equals("")||hilo1.equals(" "))
            {
                hilo1 = "0";
            }
              
                 Object hilo2 = cbhilo2.getSelectedItem();
              if(hilo2==null || hilo2.equals("")||hilo2.equals(" "))
            {
                hilo2 = "0";
            }
              
                 Object hilo3 = cbhilo3.getSelectedItem();
              if(hilo3==null || hilo3.equals("")||hilo3.equals(" "))
            {
                hilo3 = "0";
            }
              
                 Object hilo4 = cbhilo4.getSelectedItem();
              if(hilo4==null || hilo4.equals("")||hilo4.equals(" "))
            {
                hilo4 = "0";
            }
              
                 Object hilo5 = cbhilo5.getSelectedItem();
              if(hilo5==null || hilo5.equals("")||hilo5.equals(" "))
            {
                hilo5 = "0";
            }
              
                 Object hilo6 = cbhilo6.getSelectedItem();
              if(hilo6==null || hilo6.equals("")||hilo6.equals(" "))
            {
                hilo6 = "0";
            }
              
                 Object hilo7 = cbhilo7.getSelectedItem();
              if(hilo7==null || hilo7.equals("")||hilo7.equals(" "))
            {
                hilo7 = "0";
            }
            
         
                
        if(actualizarbordado.equals("si"))
        {
            
            

        ///////
        
         try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET "
                                                               + "distinta1_ubicacion = '" +ubicacion1+ "',"
                                                               + "distinta1 = '" +distinta1+ "',"
                                                               + "distinta1_nombre='" + distinta1nombre + "',"
                                                               + "distinta2_ubicacion = '" +ubicacion2+ "',"        
                                                               + "distinta2='" + distinta2 + "',"
                                                               + "distinta2_nombre='" + distinta2nombre + "',"
                                                               + "distinta3_ubicacion = '" +ubicacion3+ "',"        
                                                               + "distinta3='" + distinta3 + "' ,"
                                                               + "distinta3_nombre='" + distinta3nombre + "' ,"
                                                               + "distinta4_ubicacion = '" +ubicacion4+ "',"        
                                                               + "distinta4='" + distinta4 + "' ,"
                                                               + "distinta4_nombre='" + distinta4nombre + "',"
                                                               + "distinta5_ubicacion = '" +ubicacion5+ "',"        
                                                               + "distinta5 ='" + distinta5 + "' ,"
                                                               + "distinta5_nombre ='" + distinta5nombre + "',"
                                                               + "distinta6_ubicacion = '" +ubicacion6+ "',"        
                                                               + "distinta6 ='" +distinta6+ "',"   
                                                               + "distinta6_nombre ='" +distinta6nombre+"',"  
                                                               + "distinta7_ubicacion = '" +ubicacion7+ "',"        
                                                               + "distinta7 ='" + distinta7 + "' ,"
                                                               + "distinta7_nombre ='" + distinta7nombre + "'  WHERE codigo='"+codigodelcliente+"' and nombre_bordado = '"+nombrebordado+"'  AND tipo = '"+prenda+"' AND numero_consecutivo = '"+txtconsecutivo.getText()+"'   ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

         //// aplicacion
         
                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET "
                                                              + "distinta1_aplicacion= '" + distinta1aplicacion + "',"
                                                              + "distinta1_aplicacion_color ='" + distinta1aplicacioncolor + "',"
                                                                      + "distinta2_aplicacion= '" + distinta2aplicacion + "',"
                                                              + "distinta2_aplicacion_color ='" + distinta2aplicacioncolor + "',"
                                                                      + "distinta3_aplicacion= '" + distinta3aplicacion + "',"
                                                              + "distinta3_aplicacion_color ='" + distinta3aplicacioncolor + "',"
                                                                      + "distinta4_aplicacion= '" + distinta4aplicacion + "',"
                                                              + "distinta4_aplicacion_color ='" + distinta4aplicacioncolor + "',"
                                                                      + "distinta5_aplicacion= '" + distinta5aplicacion + "',"
                                                              + "distinta5_aplicacion_color ='" + distinta5aplicacioncolor + "',"
                                                                      + "distinta6_aplicacion= '" + distinta6aplicacion + "',"
                                                              + "distinta6_aplicacion_color ='" + distinta6aplicacioncolor + "',"
                                                                      + "distinta7_aplicacion= '" + distinta7aplicacion + "',"
                                                              + "distinta7_aplicacion_color ='" + distinta7aplicacioncolor + "' "
                                                               + "WHERE codigo='"+codigodelcliente+"'  and nombre_bordado = '"+nombrebordado+"'   AND tipo = '"+prenda+"' AND numero_consecutivo = '"+txtconsecutivo.getText()+"' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

               
                
                
                  //// Colores e hilos
                
                   try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET "
                                                               + "color1= '" + color1+ "',"
                                                               + "color2='" + color2 + "',"
                                                               + "color3='" + color3 + "',"
                                                               + "color4='" + color4 + "',"
                                                               + "color5='" + color5 + "' ,"
                                                               + "color6='" + color6 + "' ,"
                                                               + "color7='" + color7 + "' ,"
                                                               + "hilo1='" + hilo1 + "',"
                                                               + "hilo2 ='" + hilo2 + "' ,"
                                                               + "hilo3 ='" + hilo3 + "',"
                                                               + "hilo4 ='" +hilo4+ "',"   
                                                               + "hilo5 ='"+hilo5+"',"           
                                                               + "hilo6 ='" + hilo6 + "' ,"
                                                               + "hilo7 ='" + hilo7 + "'  WHERE codigo='"+codigodelcliente+"' and nombre_bordado = '"+nombrebordado+"'  AND tipo = '"+prenda+"' AND numero_consecutivo = '"+txtconsecutivo.getText()+"'   ");
                 
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                
                
                
                
                
                
                
                 try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET nombre_bordado = '"+nombrebordado+"' WHERE codigo='" + codigodelcliente + "' and tipo = '"+prenda+"' and prenda_especial = 'distinta' AND numero_consecutivo = '"+txtconsecutivo.getText()+"'");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                 
                 
                actualizarenhistorialventasycotizaciones(); 
                 
        
        
        }
        else
        {
            
            
            

            String InsertarSQL = "INSERT INTO bordados_puntadas(codigo,nombre,tipo,prenda_especial,nombre_bordado,distinta1_ubicacion,distinta1,distinta1_nombre,distinta1_aplicacion,distinta1_aplicacion_color,distinta2_ubicacion,distinta2,distinta2_nombre,distinta2_aplicacion,distinta2_aplicacion_color,distinta3_ubicacion,distinta3,distinta3_nombre,distinta3_aplicacion,distinta3_aplicacion_color,distinta4_ubicacion,distinta4,distinta4_nombre,distinta4_aplicacion,distinta4_aplicacion_color,distinta5_ubicacion,distinta5,distinta5_nombre,distinta5_aplicacion,distinta5_aplicacion_color,distinta6_ubicacion,distinta6,distinta6_nombre,distinta6_aplicacion,distinta6_aplicacion_color,distinta7_ubicacion,distinta7,distinta7_nombre,distinta7_aplicacion,distinta7_aplicacion_color,numero_consecutivo,color1,color2,color3,color4,color5,color6,color7,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);

                pst.setString(1, lbcodigocliente.getText());
                pst.setString(2, lbcliente.getText());
                pst.setString(3, prenda.toString());
                pst.setString(4, lbtipo.getText());
                pst.setString(5, txtidentificadordeprenda.getText().trim());
                pst.setString(6, ubicacion1.toString());
                pst.setString(7, distinta1.toString());
                pst.setString(8, distinta1nombre);
                pst.setString(9, distinta1aplicacion.toString());
                pst.setString(10, distinta1aplicacioncolor.toString());
                
                pst.setString(11, ubicacion2.toString());
                pst.setString(12,  distinta2.toString());
                pst.setString(13, distinta2nombre);
                pst.setString(14, distinta2aplicacion.toString());
                pst.setString(15, distinta2aplicacioncolor.toString());
                
                pst.setString(16, ubicacion3.toString());
                pst.setString(17, distinta3.toString());
                pst.setString(18, distinta3nombre);
                pst.setString(19, distinta3aplicacion.toString());
                pst.setString(20, distinta3aplicacioncolor.toString());
                
                pst.setString(21, ubicacion4.toString());
                pst.setString(22, distinta4.toString());
                pst.setString(23, distinta4nombre);
                pst.setString(24, distinta4aplicacion.toString());
                pst.setString(25, distinta4aplicacioncolor.toString());
                  
                pst.setString(26, ubicacion5.toString());
                pst.setString(27, distinta5.toString());
                pst.setString(28, distinta5nombre);
                pst.setString(29, distinta5aplicacion.toString());
                pst.setString(30, distinta5aplicacioncolor.toString());
              
                pst.setString(31, ubicacion6.toString());
                pst.setString(32, distinta6.toString());
                pst.setString(33, distinta6nombre);
                pst.setString(34, distinta6aplicacion.toString());
                pst.setString(35, distinta6aplicacioncolor.toString());
      
                pst.setString(36, ubicacion7.toString());
                pst.setString(37, distinta7.toString());
                pst.setString(38, distinta7nombre);
                pst.setString(39, distinta7aplicacion.toString());
                pst.setString(40, distinta7aplicacioncolor.toString());
              
                pst.setString(41, txtconsecutivo.getText());
                
                pst.setString(42, color1.toString());
                pst.setString(43, color2.toString());
                pst.setString(44, color3.toString());
                pst.setString(45, color4.toString());
                pst.setString(46, color5.toString());
                pst.setString(47, color6.toString());
                pst.setString(48, color7.toString());
                
                pst.setString(49, hilo1.toString());
                pst.setString(50, hilo2.toString());
                pst.setString(51, hilo3.toString());
                pst.setString(52, hilo4.toString());
                pst.setString(53, hilo5.toString());
                pst.setString(54, hilo6.toString());
                pst.setString(55, hilo7.toString());
                
               
                
                pst.executeUpdate();
                pst.close();
                
                
          

            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        }    

        
        }
        
        }
        
        }
        

        if(bordadosdelclientecatalogo.ventanabordadosdelclientecatalogonuevo==true)
        {
            
            bordadosdelclientecatalogo.btndatos.doClick();
            
            bordadosdelclientecatalogo.cbprenda.setSelectedItem(cbprenda.getSelectedItem());
            
            
            bordadosdelclientecatalogo.btncombo.doClick();
            
            
        }
        
        
        
        
        if (cerrarinterface.equals("si"))
        
        {
        this.dispose();
        ventanabordadosdelclienteeditardistinta = false;
        
        }
        else
        {
            cerrarinterface = "si";
        }
        
        
         
         
        }
            
        
    }//GEN-LAST:event_btnguardarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
     
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanabordadosdelclienteeditardistinta = false;
        this.dispose();;
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        datos();
        
        Object prendacombo = cbprenda.getSelectedItem();
        
        if (prendacombo == null || prendacombo.equals(""))
        {
            prenda = "ninguno";
        }
        else
        {
            prenda = prendacombo.toString();
        }
      
        cargarelfotomontaje();
        
    }//GEN-LAST:event_formWindowOpened

    private void txt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt7ActionPerformed

    private void txt1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1FocusGained
        txt1.selectAll();
    }//GEN-LAST:event_txt1FocusGained

    private void txt2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2FocusGained
        txt2.selectAll();
    }//GEN-LAST:event_txt2FocusGained

    private void txt4FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4FocusGained
        txt4.selectAll();
    }//GEN-LAST:event_txt4FocusGained

    private void txt3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3FocusGained
        txt3.selectAll();
    }//GEN-LAST:event_txt3FocusGained

    private void txt5FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5FocusGained
        txt5.selectAll();
    }//GEN-LAST:event_txt5FocusGained

    private void txt6FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6FocusGained
        txt6.selectAll();
    }//GEN-LAST:event_txt6FocusGained

    private void txt7FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7FocusGained
        txt7.selectAll();
    }//GEN-LAST:event_txt7FocusGained

    private void btnagregarfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarfotomontajeActionPerformed

        
         cerrarinterface = "no";
    
        nombrebordado = txtidentificadordeprenda.getText();
        
        if (pasa.equals("si"))
            
        {
        
        
        
        JSystemFileChooser elegirImagen = new JSystemFileChooser();
        elegirImagen.setMultiSelectionEnabled(false);
        int o = elegirImagen.showOpenDialog(this);
        if (o == JFileChooser.APPROVE_OPTION) 
        {
            rutaarchivo = elegirImagen.getSelectedFile().getAbsolutePath();
            nombrearchivo = elegirImagen.getSelectedFile().getName();
            codigodelcliente = lbcodigocliente.getText();
            
            PreparedStatement myStmt = null;
            FileInputStream input = null;
            try {

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigodelcliente+"' and nombre_bordado = '"+nombrebordado+"' and tipo = '"+lbtipo.getText()+"' and numero_consecutivo = '"+txtconsecutivo.getText()+"' ";

                myStmt = cn.prepareStatement(sql);
                File theFile = new File(rutaarchivo);
                input = new FileInputStream(theFile);
                myStmt.setBinaryStream(1, input);
                myStmt.executeUpdate();
                myStmt.close();
               
                
                btnverfotomontaje.setEnabled(true);
                btneliminarfotomontaje.setEnabled(true);
                btnagregarfotomontaje.setEnabled(false);        
                
                
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"' where codigo='"+codigodelcliente+"' and nombre_bordado = '"+nombrebordado+"' and tipo = '"+lbtipo.getText()+"' and numero_consecutivo = '"+txtconsecutivo.getText()+"' ");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
            ImageIcon fot = new ImageIcon(rutaarchivo);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT));
            lbfotomontaje.setIcon(icono);
            this.repaint();

        }
        
        }
        
    }//GEN-LAST:event_btnagregarfotomontajeActionPerformed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed

        codigodelcliente = lbcodigocliente.getText();
        String cliente = "";
        String rutadelarchivo = "";
        String existe = "";
        String prenda = lbtipo.getText();
        String nombre = txtidentificadordeprenda.getText().trim();
        
       String SQL = "SELECT imagen,extension_imagen FROM bordados_puntadas where codigo = '"+codigodelcliente+"' and tipo = '"+prenda+"' and nombre_bordado = '"+nombre+"'  ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(SQL);
            if (rs1.next()) 
            {
                Object camisa1 = rs1.getString("imagen");
                if (camisa1 == null||camisa1.equals("")||camisa1.equals(" ")) 
                {
                    existe = "no";
                } else 
                
                {
                    String nombredelarchivo = rs1.getString("extension_imagen");
                    if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                     rutadelarchivo = "C://archivospdf/fotomontaje."+nombredelarchivo+" ";   
                    }
                    else
                    {   
                    rutadelarchivo = "C://archivospdf/"+nombredelarchivo+" ";
                    }
                    existe = "si";
                    File file = new File(rutadelarchivo);
                    FileOutputStream output = null;
                    try {
                        output = new FileOutputStream(file);
                    } catch (FileNotFoundException ex) {
                        System.out.println(ex);
                    }
                    Blob archivo = rs1.getBlob(1);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    try {
                        while ((length = inStream.read(buffer)) != -1) {
                            output.write(buffer, 0, length);
                            // output.flush();
                        }
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                    try {
                        // inStream.close();
                        output.close();
                    } catch (IOException ex) {
                        System.out.println(ex);
                    }
                }
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        if (existe.equals("si")) 
        {
            String fileLocal = new String(rutadelarchivo);
            try {

                File path = new File(fileLocal);
                Desktop.getDesktop().open(path);

            } catch (IOException e2) {
                System.out.println(e2);
            } catch (IllegalArgumentException e3) {

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
                System.out.println(e3);
            }
        
        }
        else
        {
             JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Para ver el fotomontaje, primero debe de guardar puntadas","Error",JOptionPane.ERROR_MESSAGE);
        }    

    }//GEN-LAST:event_btnverfotomontajeActionPerformed

    private void btneliminarfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarfotomontajeActionPerformed

         codigodelcliente = lbcodigocliente.getText();
   
        String existe = "";
        String prenda = lbtipo.getText();
        String nombre = txtidentificadordeprenda.getText().trim();
        
        
        int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea Eliminar esta Imagen permanentemente?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {

            
            
            String SQL = "SELECT imagen FROM bordados_puntadas where codigo = '"+codigodelcliente+"'  and tipo = '"+prenda+"' and nombre_bordado = '"+nombre+"' and numero_consecutivo = '"+txtconsecutivo.getText()+"' ";

            try {
                Statement st1 = cn.createStatement();
                ResultSet rs1 = st1.executeQuery(SQL);
                if (rs1.next()) 
                {
                    Object a = rs1.getString(1);
                    if (a == null) 
                    {
                        existe = "no";
                    } 
                    else 
                    {
                        existe = "si";
                    }

                }
                rs1.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }

            if (existe.equals("si")) 
            {

                try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET imagen=NULL, extension_imagen='' WHERE codigo='"+codigodelcliente+"' and tipo = '"+prenda+"' and nombre_bordado = '"+nombre+"' and numero_consecutivo = '"+txtconsecutivo.getText()+"' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                
                lbfotomontaje.setIcon(null);
                this.repaint();
                
            }
            
        }   
        
        
        btnagregarfotomontaje.setEnabled(true);
        btnverfotomontaje.setEnabled(true);
        btneliminarfotomontaje.setEnabled(false);
       
    }//GEN-LAST:event_btneliminarfotomontajeActionPerformed

    private void btneliminartodoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminartodoActionPerformed
       
        String existe = "";
        String codigodelcliente = lbcodigocliente.getText();
        String conceptoprenda = txtidentificadordeprenda.getText().trim();
        prenda = cbprenda.getSelectedItem().toString();
        String numeroconsecutivo = txtconsecutivo.getText();
        
        int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea Eliminar este bordado?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {

             try {
                Statement st = cn.createStatement();
                PreparedStatement pst = cn.prepareStatement("DELETE FROM bordados_puntadas WHERE  codigo='"+codigodelcliente+"' and nombre_bordado = '"+conceptoprenda+"' AND tipo = '"+prenda+"' and numero_consecutivo = '"+numeroconsecutivo+"' ");
                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println (ex);
            }

           

            if (existe.equals("si")) 
            {

                try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE catalogo_clientes SET "+prendafotomontaje+"=NULL, "+nombreprendafotomontaje+"=NULL WHERE codigo='"+codigodelcliente+"' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                
                lbfotomontaje.setIcon(null);
                this.repaint();
                
            }
            
          
          if(bordadosdelclientecatalogo.ventanabordadosdelclientecatalogonuevo==true)
        {
            
            bordadosdelclientecatalogo.btndatos.doClick();
            bordadosdelclientecatalogo.cbprenda.setSelectedItem("TODOS");
            bordadosdelclientecatalogo.cbprenda.firePopupMenuWillBecomeInvisible();

        }
            
            
            
            
            
            
            
           ventanabordadosdelclienteeditardistinta = false;
            this.dispose();
            
        }       
    }//GEN-LAST:event_btneliminartodoActionPerformed

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed
      datos();
      cargarelfotomontaje();
    }//GEN-LAST:event_btndatosActionPerformed

    private void btnpuntadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpuntadasActionPerformed
      
       
        
        
    }//GEN-LAST:event_btnpuntadasActionPerformed

    private void txtidentificadordeprendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidentificadordeprendaFocusGained
       txtidentificadordeprenda.selectAll();
    }//GEN-LAST:event_txtidentificadordeprendaFocusGained

    private void txtidentificadordeprendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidentificadordeprendaKeyReleased

        
           
         String nombre = txtidentificadordeprenda.getText();
        
      
         if (nombre.contains("  "))
            
        {
            
        
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
                txtidentificadordeprenda.requestFocus();
                txtidentificadordeprenda.selectAll();
                
                
            txtidentificadordeprenda.setText(nombreanterior);    
                
            
           
                
                
        }
         
         else
             
         {
        
        
       String cadena = (txtidentificadordeprenda.getText()).toUpperCase();

        int pos = txtidentificadordeprenda.getCaretPosition();
         txtidentificadordeprenda.setText(txtidentificadordeprenda.getText().toUpperCase());
         txtidentificadordeprenda.setCaretPosition(pos);

        
     
     if(cadena.contains(prenda))
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre del concepto ");
     }
     
     
         }
         
         
         
         
     
    }//GEN-LAST:event_txtidentificadordeprendaKeyReleased

    private void txt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1KeyReleased

         btnagregarbordados.setEnabled(false);
        
        
           String nombre = txt1.getText();
        
      
         if (nombre.contains("  "))
            
        {
            
        
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
                txt1.requestFocus();
                txt1.selectAll();
                
                
            txt1.setText(nombreanterior);    
                
            
           
                
                
        }
         
         else
             
         {
        
        
        
        
        
        
        
        
        
        
     String cadena = (txt1.getText()).toUpperCase();
    
     
       int pos = txt1.getCaretPosition();
         txt1.setText(txt1.getText().toUpperCase());
         txt1.setCaretPosition(pos);
         
        
     
      if(cadena.contains(prenda))
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
     }
     
      
      
      
     
      
      
         }
         
         
         
         
    }//GEN-LAST:event_txt1KeyReleased

    private void txt2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2KeyReleased

        
        
        
         btnagregarbordados.setEnabled(false);
        
        
           String nombre = txt2.getText();
        
      
         if (nombre.contains("  "))
            
        {
            
        
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
                txt2.requestFocus();
                txt2.selectAll();
                
                
            txt2.setText(nombreanterior);    
                
            
           
                
                
        }
         
         else
             
         {
        
        
        
        
        
        String cadena = (txt2.getText()).toUpperCase();
     txt2.setText(cadena);
      if(cadena.contains(prenda))
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
     }
      
      
         }
         
         
         
         
         
    }//GEN-LAST:event_txt2KeyReleased

    private void txt4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4KeyReleased

        
        
         btnagregarbordados.setEnabled(false);
       
        
        
           String nombre = txt4.getText();
        
      
         if (nombre.contains("  "))
            
        {
            
        
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
                txt4.requestFocus();
                txt4.selectAll();
                
                
            txt4.setText(nombreanterior);    
                
            
           
                
                
        }
         
         else
             
         {
         
        
        
        
        
        String cadena = (txt4.getText()).toUpperCase();
    
        
           int pos = txt4.getCaretPosition();
         txt4.setText(txt4.getText().toUpperCase());
         txt4.setCaretPosition(pos);
         
         
        
        
        
        
      if(cadena.contains(prenda))
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
     }
      
      
      
         }
      
      
      
      
      
    }//GEN-LAST:event_txt4KeyReleased

    private void txt3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3KeyReleased

        
         btnagregarbordados.setEnabled(false);
        
         String nombre = txt3.getText();
        
      
         if (nombre.contains("  "))
            
        {
            
        
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
                txt3.requestFocus();
                txt3.selectAll();
                
                
            txt3.setText(nombreanterior);    
                
            
           
                
                
        }
         
         else
             
         {
         
        
        
        
        String cadena = (txt3.getText()).toUpperCase();
     txt3.setText(cadena);
      if(cadena.contains(prenda))
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
     }
      
         }
      
      
      
      
      
    }//GEN-LAST:event_txt3KeyReleased

    private void txt5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5KeyReleased

        
         btnagregarbordados.setEnabled(false);
        
        
         String nombre = txt5.getText();
        
      
         if (nombre.contains("  "))
            
        {
            
        
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
                txt5.requestFocus();
                txt5.selectAll();
                
                
            txt5.setText(nombreanterior);    
                
            
           
                
                
        }
         
         else
             
         {
          
        
        String cadena = (txt5.getText()).toUpperCase();
   
        
           int pos = txt5.getCaretPosition();
         txt5.setText(txt5.getText().toUpperCase());
         txt5.setCaretPosition(pos);
         
         
        
        
        
      if(cadena.contains(prenda))
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
     }
      
         }
         
         
         
    }//GEN-LAST:event_txt5KeyReleased

    private void txt6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6KeyReleased

        
         btnagregarbordados.setEnabled(false);
        
         String nombre = txt6.getText();
        
      
         if (nombre.contains("  "))
            
        {
            
        
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
                txt6.requestFocus();
                txt6.selectAll();
                
                
            txt6.setText(nombreanterior);    
                
            
           
                
                
        }
         
         else
             
         {
          
        
        
        String cadena = (txt6.getText()).toUpperCase();
   
        
           int pos = txt6.getCaretPosition();
         txt6.setText(txt6.getText().toUpperCase());
         txt6.setCaretPosition(pos);
         
         
        
      if(cadena.contains(prenda))
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
     }
      
      
         }
         
         
         
         
    }//GEN-LAST:event_txt6KeyReleased

    private void txt7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7KeyReleased

        
         btnagregarbordados.setEnabled(false);
        
      String nombre = txt3.getText();
        
      
         if (nombre.contains("  "))
            
        {
            
        
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
                txt3.requestFocus();
                txt3.selectAll();
                
                
            txt3.setText(nombreanterior);    
                
            
           
                
                
        }
         
         else
             
         {
             
        
        String cadena = (txt7.getText()).toUpperCase();
    
        
           int pos = txt7.getCaretPosition();
         txt7.setText(txt7.getText().toUpperCase());
         txt7.setCaretPosition(pos);
        
      
        
        
        
      if(cadena.contains(prenda))
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
     }
      
      
      
         }
      
    }//GEN-LAST:event_txt7KeyReleased

    private void btnimportarfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimportarfotomontajeActionPerformed

   String pechoizquierdo = txt1.getText();  
   String pechoderecho = txt2.getText();
   String mangaderecha = txt4.getText();
   String mangaizquierda = txt3.getText();
   String espalda = txt5.getText();
   String otraubicacion = txt6.getText();     
   String otraubicacion2 = txt7.getText();  

   String tipo = lbtipo.getText();
   String codigocliente = lbcodigocliente.getText();
   String sql = "";
   String existe = "no";
   String nombredelarchivo = "";
   String rutadelarchivo = "";
   String fotomontaje = "";
   String fotomontajeextension = "";
   
   String pechoizquierdocamisanombre = "";
   String pechoderechocamisanombre = "";
   String mangaizquierdacamisanombre = "";
   String mangaderechacamisanombre = "";
   String espaldacamisanombre = ""; 
   String otraubicacioncamisanombre = ""; 
   String otraubicacion2camisanombre = ""; 
   
   String pechoizquierdoplayeranombre = "";
   String pechoderechoplayeranombre = "";
   String mangaizquierdaplayeranombre = "";
   String mangaderechaplayeranombre = "";
   String espaldaplayeranombre = ""; 
   String otraubicacionplayeranombre = ""; 
   String otraubicacion2playeranombre = ""; 
   
   
   
   
   
   
   
   
   
   
   ///////////////
   
   if(tipo.equals("CAMISA"))
   {
       
       for(int i = 0; i < 5 ; i++)
       {
       
        if(i == 0)
        {
        sql = "SELECT camisa_pecho_izquierdo_nombre,camisa_pecho_derecho_nombre,camisa_manga_derecha_nombre,camisa_manga_izquierda_nombre,camisa_espalda_nombre,camisa_otra_ubicacion2_nombre,camisa_otra_ubicacion_nombre FROM puntadas_camisa where codigo = '" + codigocliente + "' ";
        }
        else  if (i == 1)
        {

            sql = "SELECT camisa2_pecho_izquierdo_nombre,camisa2_pecho_derecho_nombre,camisa2_manga_derecha_nombre,camisa2_manga_izquierda_nombre,camisa2_espalda_nombre,camisa2_otra_ubicacion_nombre FROM puntadas_camisa where codigo = '" + codigocliente + "' ";

                
        }
        else if (i == 2) 
        {

                sql = "SELECT camisa3_pecho_izquierdo_nombre,camisa3_pecho_derecho_nombre,camisa3_manga_derecha_nombre,camisa3_manga_izquierda_nombre,camisa3_espalda_nombre  FROM puntadas_camisa where codigo = '" + codigocliente + "' ";

               
            } 
            else if (i == 3) 
            {
                sql = "SELECT camisa4_pecho_izquierdo_nombre,camisa4_pecho_derecho_nombre,camisa4_manga_derecha_nombre,camisa4_manga_izquierda_nombre,camisa4_otra_ubicacion_nombre,camisa4_otra_ubicacion2_nombre,camisa4_espalda_nombre  FROM puntadas_camisa where codigo = '" + codigocliente + "' ";

             
            }
            else if (i == 4) {
                sql = "SELECT camisa5_pecho_izquierdo_nombre,camisa5_pecho_derecho_nombre,camisa5_manga_derecha_nombre,camisa5_manga_izquierda_nombre,camisa5_otra_ubicacion_nombre,camisa5_otra_ubicacion2_nombre,camisa5_espalda  FROM puntadas_camisa where codigo = '" +codigocliente+ "' ";

               
            }
       
       
        
        try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                    if (i == 0)
                    {
                       
                        pechoizquierdocamisanombre = rs.getString("camisa_pecho_izquierdo_nombre");
                        pechoderechocamisanombre = rs.getString("camisa_pecho_derecho_nombre");
                        mangaizquierdacamisanombre = rs.getString("camisa_manga_izquierda_nombre");
                        mangaderechacamisanombre = rs.getString("camisa_manga_derecha_nombre");
                        espaldacamisanombre = rs.getString("camisa_espalda_nombre");
                        otraubicacioncamisanombre = rs.getString("camisa_otra_ubicacion_nombre");
                        otraubicacion2camisanombre = rs.getString("camisa_otra_ubicacion2_nombre");
                        
                        
                        if(pechoizquierdocamisanombre.contains(pechoizquierdo) && pechoderechocamisanombre.contains(pechoderecho) && mangaizquierdacamisanombre.contains(mangaizquierda) && mangaderechacamisanombre.contains(mangaderecha) && espaldacamisanombre.contains(espalda) && otraubicacioncamisanombre.contains(otraubicacion) && otraubicacion2camisanombre.contains(otraubicacion2) )
                        { 
                            fotomontaje = "camisa1";
                            fotomontajeextension = "camisa1extension";
                            break;
                            
                        }
                            
                            
                            
                    }
                    else if (i == 1) 
                    {
                       
                        pechoizquierdocamisanombre = rs.getString("camisa2_pecho_izquierdo_nombre");
                        pechoderechocamisanombre = rs.getString("camisa2_pecho_derecho_nombre");
                        mangaizquierdacamisanombre = rs.getString("camisa2_manga_izquierda_nombre");
                        mangaderechacamisanombre = rs.getString("camisa2_manga_derecha_nombre");
                        espaldacamisanombre = rs.getString("camisa2_espalda_nombre");
                        otraubicacioncamisanombre = rs.getString("camisa2_otra_ubicacion_nombre");
                        
                        
                        
                        if(pechoizquierdocamisanombre.contains(pechoizquierdo) && pechoderechocamisanombre.contains(pechoderecho) && mangaizquierdacamisanombre.contains(mangaizquierda) && mangaderechacamisanombre.contains(mangaderecha) && espaldacamisanombre.contains(espalda) && otraubicacioncamisanombre.contains(otraubicacion)  )
                        { 
                            fotomontaje = "camisa2";
                            fotomontajeextension = "camisa2extension";
                            break;
                            
                        }

                       
                    }
                    else if (i == 2) 
                    {
                       
                        pechoizquierdocamisanombre = rs.getString("camisa3_pecho_izquierdo_nombre");
                        pechoderechocamisanombre = rs.getString("camisa3_pecho_derecho_nombre");
                        mangaizquierdacamisanombre = rs.getString("camisa3_manga_izquierda_nombre");
                        mangaderechacamisanombre = rs.getString("camisa3_manga_derecha_nombre");
                        espaldacamisanombre = rs.getString("camisa3_espalda_nombre");
                       
                         if(pechoizquierdocamisanombre.contains(pechoizquierdo) && pechoderechocamisanombre.contains(pechoderecho) && mangaizquierdacamisanombre.contains(mangaizquierda) && mangaderechacamisanombre.contains(mangaderecha) && espaldacamisanombre.contains(espalda) && otraubicacioncamisanombre.contains(otraubicacion) && otraubicacion2camisanombre.contains(otraubicacion2) )
                        { 
                            fotomontaje = "camisa3";
                            fotomontajeextension = "camisa3extension";
                            break;
                            
                        }
                        
                    

                       
                    }
                    else if (i == 3) 
                    
                    {
                       
                        pechoizquierdocamisanombre = rs.getString("camisa4_pecho_izquierdo_nombre");
                        pechoderechocamisanombre = rs.getString("camisa4_pecho_derecho_nombre");
                        mangaizquierdacamisanombre = rs.getString("camisa4_manga_izquierda_nombre");
                        mangaderechacamisanombre = rs.getString("camisa4_manga_derecha_nombre");
                        espaldacamisanombre = rs.getString("camisa4_espalda_nombre");
                        otraubicacioncamisanombre = rs.getString("camisa4_otra_ubicacion_nombre");
                        otraubicacion2camisanombre = rs.getString("camisa4_otra_ubicacion2_nombre");
                                               
                       if(pechoizquierdocamisanombre.contains(pechoizquierdo) && pechoderechocamisanombre.contains(pechoderecho) && mangaizquierdacamisanombre.contains(mangaizquierda) && mangaderechacamisanombre.contains(mangaderecha) && espaldacamisanombre.contains(espalda) && otraubicacioncamisanombre.contains(otraubicacion) && otraubicacion2camisanombre.contains(otraubicacion2) )
                        { 
                            fotomontaje = "camisa4";
                            fotomontajeextension = "camisa4extension";
                            break;
                            
                        }
                         
                    }
                    else if (i == 4) {
                        
                        pechoizquierdocamisanombre = rs.getString("camisa5_pecho_izquierdo_nombre");
                        pechoderechocamisanombre = rs.getString("camisa5_pecho_derecho_nombre");
                        mangaizquierdacamisanombre = rs.getString("camisa5_manga_izquierda_nombre");
                        mangaderechacamisanombre = rs.getString("camisa5_manga_derecha_nombre");
                        espaldacamisanombre = rs.getString("camisa5_espalda_nombre");
                        otraubicacioncamisanombre = rs.getString("camisa5_otra_ubicacion_nombre");
                        otraubicacion2camisanombre = rs.getString("camisa5_otra_ubicacion2_nombre");
                        
                        if(pechoizquierdocamisanombre.contains(pechoizquierdo) && pechoderechocamisanombre.contains(pechoderecho) && mangaizquierdacamisanombre.contains(mangaizquierda) && mangaderechacamisanombre.contains(mangaderecha) && espaldacamisanombre.contains(espalda) && otraubicacioncamisanombre.contains(otraubicacion) && otraubicacion2camisanombre.contains(otraubicacion2) )
                        { 
                            fotomontaje = "camisa5";
                            fotomontajeextension = "camisa5extension";
                            break;
                            
                        }

                    }

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        
        
       
       
       }
   }
   
   
   
   
   
   
   
   
   
   
   
   /////
   String SQL = "SELECT "+fotomontaje+","+fotomontajeextension+" FROM catalogo_clientes where codigo = '"+codigocliente+"' ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(SQL);
            if (rs1.next()) 
            {
                existe = "";
                
                Object fotomontajeobject = rs1.getString(1);
                if (fotomontajeobject == null||fotomontajeobject.equals("")||fotomontajeobject.equals(" ")) 
                {
                    existe = "no";
                } else 
                
                {
                    nombredelarchivo = rs1.getString(2);
                    
                    if(nombredelarchivo ==null || nombredelarchivo.equals(""))
                    {
                        
                    }
                    
                    else
                        
                    {    
                        if(nombredelarchivo.equals("jpg")||nombredelarchivo.equals("png")||nombredelarchivo.equals("jpeg")||nombredelarchivo.equals("JPEG")||nombredelarchivo.equals("PNG")||nombredelarchivo.equals("JPG"))
                    {
                     rutadelarchivo = "C:\\archivospdf\\fotomontaje."+nombredelarchivo+" ";   
                    }
                    else
                    {   
                    rutadelarchivo = "C:\\archivospdf\\"+nombredelarchivo+" ";
                    }
                    existe = "si";
                    File file = new File(rutadelarchivo);
                    FileOutputStream output = new FileOutputStream(file);
                    Blob archivo = rs1.getBlob(1);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    while ((length = inStream.read(buffer)) != -1) {
                        output.write(buffer, 0, length);
                        // output.flush();
                    }
                    // inStream.close();
                    output.close();
                    
                    }
                }
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }    
                
    
        ////// inserta el fotomontake
        
            
           if(existe.equals("si"))
           {
            
            PreparedStatement myStmt = null;
            FileInputStream input = null;
            String nombrebordado = txtidentificadordeprenda.getText();
            
            try {

                String sql3 = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigocliente+"' and nombre_bordado = '"+nombrebordado+"' and tipo = '"+tipo+"'  and numero_consecutivo = '"+txtconsecutivo.getText()+"' ";

                myStmt = cn.prepareStatement(sql3);
                File theFile = new File(rutadelarchivo);
                input = new FileInputStream(theFile);
                myStmt.setBinaryStream(1, input);
                myStmt.executeUpdate();
                myStmt.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombredelarchivo+"' where codigo='"+codigocliente+"' and nombre_bordado = '"+nombrebordado+"' and tipo = '"+tipo+"'  and numero_consecutivo = '"+txtconsecutivo.getText()+"' ");
                pst.executeUpdate();
                System.out.println(pst);
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            
            cargarelfotomontaje();
           
           }
   
   
    }//GEN-LAST:event_btnimportarfotomontajeActionPerformed

    private void txtidentificadordeprendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidentificadordeprendaKeyPressed
      
        
        nombreanterior = txtidentificadordeprenda.getText();
        
        
    }//GEN-LAST:event_txtidentificadordeprendaKeyPressed

    private void txt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1KeyPressed
        
        
        nombreanterior = txt1.getText();
        
        
    }//GEN-LAST:event_txt1KeyPressed

    private void txt2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2KeyPressed
        nombreanterior = txt2.getText();
    }//GEN-LAST:event_txt2KeyPressed

    private void txt4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4KeyPressed
        nombreanterior = txt4.getText();
    }//GEN-LAST:event_txt4KeyPressed

    private void txt3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3KeyPressed
        nombreanterior = txt3.getText();
    }//GEN-LAST:event_txt3KeyPressed

    private void txt5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5KeyPressed
       nombreanterior = txt5.getText();
    }//GEN-LAST:event_txt5KeyPressed

    private void txt6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6KeyPressed
        nombreanterior = txt6.getText();
    }//GEN-LAST:event_txt6KeyPressed

    private void txt7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7KeyPressed
        nombreanterior = txt7.getText();
    }//GEN-LAST:event_txt7KeyPressed

    private void lbclienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbclienteMouseClicked
 
        
    }//GEN-LAST:event_lbclienteMouseClicked

    private void cbhilo1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo1PopupMenuWillBecomeInvisible
       
        
        String hilo = cbhilo1.getSelectedItem().toString();
        
        String hiloconcolor = "";
        String colorsinhilo = "";
         String colorencombo = cbcolor1.getSelectedItem().toString();
         
         
        if (!hilo.equals("0"))
            
        {
            
          for (String valor: lista) {

           hiloconcolor =  valor;
           
           
           
          if (!hiloconcolor.equals("0")) 
           
           
          {
           
           if (hiloconcolor.contains(hilo))
               
           {
          
               colorsinhilo =  hiloconcolor.replace(hilo, "");
               
               
              
               
               if (!colorencombo.equals("ninguno"))
               
               
               {
                   if (!colorencombo.equals(colorsinhilo))
                       
                   {
                      int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor1.setSelectedItem(colorsinhilo);
          
        }
        else
        {
            
            cbhilo1.setSelectedItem(hilo1seleccionado);
            
        }
                   }
                   
               }
               else
               {
                 
                cbcolor1.setSelectedItem(colorsinhilo);
                   
               }
               
            
                
                    
           }
              
               

                }
            
            
            
          }
            
            
            
        }
        
        
        
    }//GEN-LAST:event_cbhilo1PopupMenuWillBecomeInvisible

    private void cbcolor1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor1PopupMenuWillBecomeInvisible

        
         btnagregarbordados.setEnabled(false);
        
        
        String hiloconcolor = "";
        String hilosincolor = "";
        String hiloencombo = cbhilo1.getSelectedItem().toString();
        String colorencombo = cbcolor1.getSelectedItem().toString();
        
        if (!colorencombo.equals("ninguno")) 
        {
            
           for (String valor: lista) {

           hiloconcolor =  valor;
           
             if (hiloconcolor.contains(colorencombo))
               
           {
          
               hilosincolor =  hiloconcolor.replace(colorencombo, "");
               
               
               
               
               if (!hiloencombo.equals("0"))
                   
               {
                    int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el hilo "+hilo1seleccionado+" color "+color1seleccionado+" desea cambiarlo por "+hilosincolor+" color "+colorencombo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbhilo1.setSelectedItem(hilosincolor);
          
        }
        
         else
        {
            
            cbcolor1.setSelectedItem(color1seleccionado);
            
        }
        
        
        
        
               }
               
           
           }
        
        
           }
        
        
        
           }
        
        else
        {
            
            if (!hiloencombo.equals("0"))
                
            {
            
            
                  int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Si elimina el color, tambien se eliminar� el hilo; desea continuar?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor1.setSelectedItem("ninguno");
            cbhilo1.setSelectedItem("0");
          
        }
        
        
        else
            
        {
            
            cbcolor1.setSelectedItem(color1seleccionado);
        }
        
        
        
        
            }
            
        }
        
        
        
    }//GEN-LAST:event_cbcolor1PopupMenuWillBecomeInvisible

    private void cbcolor1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor1PopupMenuWillBecomeVisible
      
        
        color1seleccionado = cbcolor1.getSelectedItem().toString();
        hilo1seleccionado = cbhilo1.getSelectedItem().toString();
        
    }//GEN-LAST:event_cbcolor1PopupMenuWillBecomeVisible

    private void cbhilo1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo1PopupMenuWillBecomeVisible
       
        
        hilo1seleccionado = cbhilo1.getSelectedItem().toString();
         color1seleccionado = cbcolor1.getSelectedItem().toString();
        
    }//GEN-LAST:event_cbhilo1PopupMenuWillBecomeVisible

    private void cbhilo2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo2PopupMenuWillBecomeVisible
       
        hilo2seleccionado = cbhilo2.getSelectedItem().toString();
         color2seleccionado = cbcolor2.getSelectedItem().toString();
        
    }//GEN-LAST:event_cbhilo2PopupMenuWillBecomeVisible

    private void cbhilo3PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo3PopupMenuWillBecomeVisible
       
        
        hilo3seleccionado = cbhilo3.getSelectedItem().toString();
         color3seleccionado = cbcolor3.getSelectedItem().toString();
         
         
    }//GEN-LAST:event_cbhilo3PopupMenuWillBecomeVisible

    private void cbhilo4PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo4PopupMenuWillBecomeVisible
       
        
        hilo4seleccionado = cbhilo4.getSelectedItem().toString();
         color4seleccionado = cbcolor4.getSelectedItem().toString();
         
         
    }//GEN-LAST:event_cbhilo4PopupMenuWillBecomeVisible

    private void cbhilo5PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo5PopupMenuWillBecomeVisible
       
        
        hilo5seleccionado = cbhilo5.getSelectedItem().toString();
         color5seleccionado = cbcolor5.getSelectedItem().toString();
         
         
    }//GEN-LAST:event_cbhilo5PopupMenuWillBecomeVisible

    private void cbhilo6PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo6PopupMenuWillBecomeVisible
      
        
        hilo6seleccionado = cbhilo6.getSelectedItem().toString();
         color6seleccionado = cbcolor6.getSelectedItem().toString();
         
         
    }//GEN-LAST:event_cbhilo6PopupMenuWillBecomeVisible

    private void cbhilo7PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo7PopupMenuWillBecomeVisible
       
        
        hilo7seleccionado = cbhilo7.getSelectedItem().toString();
         color7seleccionado = cbcolor7.getSelectedItem().toString();
         
         
         
    }//GEN-LAST:event_cbhilo7PopupMenuWillBecomeVisible

    private void cbaplicacioncantidad3PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad3PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbaplicacioncantidad3PopupMenuWillBecomeVisible

    private void cbaplicacioncantidad4PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad4PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbaplicacioncantidad4PopupMenuWillBecomeVisible

    private void cbaplicacioncantidad5PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad5PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbaplicacioncantidad5PopupMenuWillBecomeVisible

    private void cbaplicacioncantidad6PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad6PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbaplicacioncantidad6PopupMenuWillBecomeVisible

    private void cbaplicacioncantidad7PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad7PopupMenuWillBecomeVisible
        // TODO add your handling code here:
    }//GEN-LAST:event_cbaplicacioncantidad7PopupMenuWillBecomeVisible

    private void cbcolor3PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor3PopupMenuWillBecomeVisible
       
        
        hilo3seleccionado = cbhilo3.getSelectedItem().toString();
         color3seleccionado = cbcolor3.getSelectedItem().toString();
         
         
         
    }//GEN-LAST:event_cbcolor3PopupMenuWillBecomeVisible

    private void cbcolor4PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor4PopupMenuWillBecomeVisible
       
        
        hilo4seleccionado = cbhilo4.getSelectedItem().toString();
         color4seleccionado = cbcolor4.getSelectedItem().toString();
         
         
    }//GEN-LAST:event_cbcolor4PopupMenuWillBecomeVisible

    private void cbcolor5PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor5PopupMenuWillBecomeVisible
      
        
        hilo5seleccionado = cbhilo5.getSelectedItem().toString();
         color5seleccionado = cbcolor5.getSelectedItem().toString();
         
         
         
    }//GEN-LAST:event_cbcolor5PopupMenuWillBecomeVisible

    private void cbcolor6PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor6PopupMenuWillBecomeVisible
       
        
        hilo6seleccionado = cbhilo6.getSelectedItem().toString();
         color6seleccionado = cbcolor6.getSelectedItem().toString();
         
         
         
    }//GEN-LAST:event_cbcolor6PopupMenuWillBecomeVisible

    private void cbcolor7PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor7PopupMenuWillBecomeVisible
       
        
        
        hilo7seleccionado = cbhilo7.getSelectedItem().toString();
         color7seleccionado = cbcolor7.getSelectedItem().toString();
         
         
         
         
    }//GEN-LAST:event_cbcolor7PopupMenuWillBecomeVisible

    private void cbcolor2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor2PopupMenuWillBecomeVisible
     
        
        hilo2seleccionado = cbhilo2.getSelectedItem().toString();
         color2seleccionado = cbcolor2.getSelectedItem().toString();
        
    }//GEN-LAST:event_cbcolor2PopupMenuWillBecomeVisible

    private void cbcolor2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor2PopupMenuWillBecomeInvisible

        
         btnagregarbordados.setEnabled(false);
        
        
        String hiloconcolor = "";
        String hilosincolor = "";
        String hiloencombo = cbhilo2.getSelectedItem().toString();
        String colorencombo = cbcolor2.getSelectedItem().toString();
        
        if (!colorencombo.equals("ninguno")) 
        {
            
           for (String valor: lista) {

           hiloconcolor =  valor;
           
             if (hiloconcolor.contains(colorencombo))
               
           {
          
               hilosincolor =  hiloconcolor.replace(colorencombo, "");
               
               
               
               
               if (!hiloencombo.equals("0"))
                   
               {
                    int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el hilo "+hilo2seleccionado+" color "+color2seleccionado+" desea cambiarlo por "+hilosincolor+" color "+colorencombo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbhilo2.setSelectedItem(hilosincolor);
          
        }
        
         else
        {
            
            cbcolor2.setSelectedItem(color2seleccionado);
            
        }
        
        
        
        
               }
               
           
           }
        
        
           }
        
        
        
           }
        
        else
        {
            
            if (!hiloencombo.equals("0"))
                
            {
            
            
                  int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Si elimina el color, tambien se eliminar� el hilo; desea continuar?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor2.setSelectedItem("ninguno");
            cbhilo2.setSelectedItem("0");
          
        }
        
        
        else
            
        {
            
            cbcolor2.setSelectedItem(color2seleccionado);
        }
        
        
        
        
            }
            
        }
        
        
        
    }//GEN-LAST:event_cbcolor2PopupMenuWillBecomeInvisible

    private void cbcolor3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor3PopupMenuWillBecomeInvisible

        
         btnagregarbordados.setEnabled(false);
        
        
        
        String hiloconcolor = "";
        String hilosincolor = "";
        String hiloencombo = cbhilo3.getSelectedItem().toString();
        String colorencombo = cbcolor3.getSelectedItem().toString();
        
        if (!colorencombo.equals("ninguno")) 
        {
            
           for (String valor: lista) {

           hiloconcolor =  valor;
           
             if (hiloconcolor.contains(colorencombo))
               
           {
          
               hilosincolor =  hiloconcolor.replace(colorencombo, "");
               
               
               
               
               if (!hiloencombo.equals("0"))
                   
               {
                    int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el hilo "+hilo3seleccionado+" color "+color3seleccionado+" desea cambiarlo por "+hilosincolor+" color "+colorencombo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbhilo3.setSelectedItem(hilosincolor);
          
        }
        
         else
        {
            
            cbcolor3.setSelectedItem(color3seleccionado);
            
        }
        
        
        
        
               }
               
           
           }
        
        
           }
        
        
        
           }
        
        else
        {
            
            if (!hiloencombo.equals("0"))
                
            {
            
            
                  int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Si elimina el color, tambien se eliminar� el hilo; desea continuar?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor3.setSelectedItem("ninguno");
            cbhilo3.setSelectedItem("0");
          
        }
        
        
        else
            
        {
            
            cbcolor3.setSelectedItem(color3seleccionado);
        }
        
        
        
        
            }
            
        }
        
        
        
        
    }//GEN-LAST:event_cbcolor3PopupMenuWillBecomeInvisible

    private void cbcolor4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor4PopupMenuWillBecomeInvisible

        
         btnagregarbordados.setEnabled(false);
        
        
        
        String hiloconcolor = "";
        String hilosincolor = "";
        String hiloencombo = cbhilo4.getSelectedItem().toString();
        String colorencombo = cbcolor4.getSelectedItem().toString();
        
        if (!colorencombo.equals("ninguno")) 
        {
            
           for (String valor: lista) {

           hiloconcolor =  valor;
           
             if (hiloconcolor.contains(colorencombo))
               
           {
          
               hilosincolor =  hiloconcolor.replace(colorencombo, "");
               
               
               
               
               if (!hiloencombo.equals("0"))
                   
               {
                    int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el hilo "+hilo4seleccionado+" color "+color4seleccionado+" desea cambiarlo por "+hilosincolor+" color "+colorencombo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbhilo4.setSelectedItem(hilosincolor);
          
        }
        
         else
        {
            
            cbcolor4.setSelectedItem(color4seleccionado);
            
        }
        
        
        
        
               }
               
           
           }
        
        
           }
        
        
        
           }
        
        else
        {
            
            if (!hiloencombo.equals("0"))
                
            {
            
            
                  int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Si elimina el color, tambien se eliminar� el hilo; desea continuar?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor4.setSelectedItem("ninguno");
            cbhilo4.setSelectedItem("0");
          
        }
        
        
        else
            
        {
            
            cbcolor4.setSelectedItem(color4seleccionado);
        }
        
        
        
        
            }
            
        }
        
        
        
        
    }//GEN-LAST:event_cbcolor4PopupMenuWillBecomeInvisible

    private void cbcolor5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor5PopupMenuWillBecomeInvisible


 btnagregarbordados.setEnabled(false);        
        
        
        
        String hiloconcolor = "";
        String hilosincolor = "";
        String hiloencombo = cbhilo5.getSelectedItem().toString();
        String colorencombo = cbcolor5.getSelectedItem().toString();
        
        if (!colorencombo.equals("ninguno")) 
        {
            
           for (String valor: lista) {

           hiloconcolor =  valor;
           
             if (hiloconcolor.contains(colorencombo))
               
           {
          
               hilosincolor =  hiloconcolor.replace(colorencombo, "");
               
               
               
               
               if (!hiloencombo.equals("0"))
                   
               {
                    int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el hilo "+hilo5seleccionado+" color "+color5seleccionado+" desea cambiarlo por "+hilosincolor+" color "+colorencombo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbhilo5.setSelectedItem(hilosincolor);
          
        }
        
         else
        {
            
            cbcolor5.setSelectedItem(color5seleccionado);
            
        }
        
        
        
        
               }
               
           
           }
        
        
           }
        
        
        
           }
        
        else
        {
            
            if (!hiloencombo.equals("0"))
                
            {
            
            
                  int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Si elimina el color, tambien se eliminar� el hilo; desea continuar?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor5.setSelectedItem("ninguno");
            cbhilo5.setSelectedItem("0");
          
        }
        
        
        else
            
        {
            
            cbcolor5.setSelectedItem(color5seleccionado);
        }
        
        
        
        
            }
            
        }
        
        
        
        
    }//GEN-LAST:event_cbcolor5PopupMenuWillBecomeInvisible

    private void cbcolor6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor6PopupMenuWillBecomeInvisible

        
         btnagregarbordados.setEnabled(false);
        
        
        String hiloconcolor = "";
        String hilosincolor = "";
        String hiloencombo = cbhilo6.getSelectedItem().toString();
        String colorencombo = cbcolor6.getSelectedItem().toString();
        
        if (!colorencombo.equals("ninguno")) 
        {
            
           for (String valor: lista) {

           hiloconcolor =  valor;
           
             if (hiloconcolor.contains(colorencombo))
               
           {
          
               hilosincolor =  hiloconcolor.replace(colorencombo, "");
               
               
               
               
               if (!hiloencombo.equals("0"))
                   
               {
                    int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el hilo "+hilo6seleccionado+" color "+color6seleccionado+" desea cambiarlo por "+hilosincolor+" color "+colorencombo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbhilo6.setSelectedItem(hilosincolor);
          
        }
        
         else
        {
            
            cbcolor6.setSelectedItem(color6seleccionado);
            
        }
        
        
        
        
               }
               
           
           }
        
        
           }
        
        
        
           }
        
        else
        {
            
            if (!hiloencombo.equals("0"))
                
            {
            
            
                  int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Si elimina el color, tambien se eliminar� el hilo; desea continuar?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor6.setSelectedItem("ninguno");
            cbhilo6.setSelectedItem("0");
          
        }
        
        
        else
            
        {
            
            cbcolor6.setSelectedItem(color6seleccionado);
        }
        
        
        
        
            }
            
        }
        
        
        
        
    }//GEN-LAST:event_cbcolor6PopupMenuWillBecomeInvisible

    private void cbcolor7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbcolor7PopupMenuWillBecomeInvisible

        
         btnagregarbordados.setEnabled(false);
        
        
        
        String hiloconcolor = "";
        String hilosincolor = "";
        String hiloencombo = cbhilo7.getSelectedItem().toString();
        String colorencombo = cbcolor7.getSelectedItem().toString();
        
        if (!colorencombo.equals("ninguno")) 
        {
            
           for (String valor: lista) {

           hiloconcolor =  valor;
           
             if (hiloconcolor.contains(colorencombo))
               
           {
          
               hilosincolor =  hiloconcolor.replace(colorencombo, "");
               
               
               
               
               if (!hiloencombo.equals("0"))
                   
               {
                    int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el hilo "+hilo7seleccionado+" color "+color7seleccionado+" desea cambiarlo por "+hilosincolor+" color "+colorencombo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbhilo7.setSelectedItem(hilosincolor);
          
        }
        
         else
        {
            
            cbcolor7.setSelectedItem(color7seleccionado);
            
        }
        
        
        
        
               }
               
           
           }
        
        
           }
        
        
        
           }
        
        else
        {
            
            if (!hiloencombo.equals("0"))
                
            {
            
            
                  int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Si elimina el color, tambien se eliminar� el hilo; desea continuar?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor7.setSelectedItem("ninguno");
            cbhilo7.setSelectedItem("0");
          
        }
        
        
        else
            
        {
            
            cbcolor7.setSelectedItem(color7seleccionado);
        }
        
        
        
        
            }
            
        }
        
        
        
        
    }//GEN-LAST:event_cbcolor7PopupMenuWillBecomeInvisible

    private void cbhilo2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo2PopupMenuWillBecomeInvisible
      
        
        
        
        String hilo = cbhilo2.getSelectedItem().toString();
        
        String hiloconcolor = "";
        String colorsinhilo = "";
         String colorencombo = cbcolor2.getSelectedItem().toString();
         
         
        if (!hilo.equals("0"))
            
        {
            
          for (String valor: lista) {

           hiloconcolor =  valor;
           
           
           
          if (!hiloconcolor.equals("0")) 
           
           
          {
           
           if (hiloconcolor.contains(hilo))
               
           {
          
               colorsinhilo =  hiloconcolor.replace(hilo, "");
               
               
              
               
               if (!colorencombo.equals("ninguno"))
               
               
               {
                   if (!colorencombo.equals(colorsinhilo))
                       
                   {
                      int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor2.setSelectedItem(colorsinhilo);
          
        }
        else
        {
            
            cbhilo2.setSelectedItem(hilo2seleccionado);
            
        }
                   }
                   
               }
               else
               {
                 
                cbcolor2.setSelectedItem(colorsinhilo);
                   
               }
               
            
                
                    
           }
              
               

                }
            
            
            
          }
            
            
            
        }
        
        
        
        
        
    }//GEN-LAST:event_cbhilo2PopupMenuWillBecomeInvisible

    private void cbhilo3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo3PopupMenuWillBecomeInvisible
       
        
        
        
        String hilo = cbhilo3.getSelectedItem().toString();
        
        String hiloconcolor = "";
        String colorsinhilo = "";
         String colorencombo = cbcolor3.getSelectedItem().toString();
         
         
        if (!hilo.equals("0"))
            
        {
            
          for (String valor: lista) {

           hiloconcolor =  valor;
           
           
           
          if (!hiloconcolor.equals("0")) 
           
           
          {
           
           if (hiloconcolor.contains(hilo))
               
           {
          
               colorsinhilo =  hiloconcolor.replace(hilo, "");
               
               
              
               
               if (!colorencombo.equals("ninguno"))
               
               
               {
                   if (!colorencombo.equals(colorsinhilo))
                       
                   {
                      int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor3.setSelectedItem(colorsinhilo);
          
        }
        else
        {
            
            cbhilo3.setSelectedItem(hilo3seleccionado);
            
        }
                   }
                   
               }
               else
               {
                 
                cbcolor3.setSelectedItem(colorsinhilo);
                   
               }
               
            
                
                    
           }
              
               

                }
            
            
            
          }
            
            
            
        }
        
        
        
        
    }//GEN-LAST:event_cbhilo3PopupMenuWillBecomeInvisible

    private void cbhilo4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo4PopupMenuWillBecomeInvisible
    
        
        
        
        String hilo = cbhilo4.getSelectedItem().toString();
        
        String hiloconcolor = "";
        String colorsinhilo = "";
         String colorencombo = cbcolor4.getSelectedItem().toString();
         
         
        if (!hilo.equals("0"))
            
        {
            
          for (String valor: lista) {

           hiloconcolor =  valor;
           
           
           
          if (!hiloconcolor.equals("0")) 
           
           
          {
           
           if (hiloconcolor.contains(hilo))
               
           {
          
               colorsinhilo =  hiloconcolor.replace(hilo, "");
               
               
              
               
               if (!colorencombo.equals("ninguno"))
               
               
               {
                   if (!colorencombo.equals(colorsinhilo))
                       
                   {
                      int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor4.setSelectedItem(colorsinhilo);
          
        }
        else
        {
            
            cbhilo4.setSelectedItem(hilo4seleccionado);
            
        }
                   }
                   
               }
               else
               {
                 
                cbcolor4.setSelectedItem(colorsinhilo);
                   
               }
               
            
                
                    
           }
              
               

                }
            
            
            
          }
            
            
            
        }
        
        
        
        
        
    }//GEN-LAST:event_cbhilo4PopupMenuWillBecomeInvisible

    private void cbhilo5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo5PopupMenuWillBecomeInvisible
       
        
        
        
        String hilo = cbhilo5.getSelectedItem().toString();
        
        String hiloconcolor = "";
        String colorsinhilo = "";
         String colorencombo = cbcolor5.getSelectedItem().toString();
         
         
        if (!hilo.equals("0"))
            
        {
            
          for (String valor: lista) {

           hiloconcolor =  valor;
           
           
           
          if (!hiloconcolor.equals("0")) 
           
           
          {
           
           if (hiloconcolor.contains(hilo))
               
           {
          
               colorsinhilo =  hiloconcolor.replace(hilo, "");
               
               
              
               
               if (!colorencombo.equals("ninguno"))
               
               
               {
                   if (!colorencombo.equals(colorsinhilo))
                       
                   {
                      int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor5.setSelectedItem(colorsinhilo);
          
        }
        else
        {
            
            cbhilo5.setSelectedItem(hilo5seleccionado);
            
        }
                   }
                   
               }
               else
               {
                 
                cbcolor5.setSelectedItem(colorsinhilo);
                   
               }
               
            
                
                    
           }
              
               

                }
            
            
            
          }
            
            
            
        }
        
        
        
        
        
        
    }//GEN-LAST:event_cbhilo5PopupMenuWillBecomeInvisible

    private void cbhilo6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo6PopupMenuWillBecomeInvisible
       
        
        
        
        
        String hilo = cbhilo6.getSelectedItem().toString();
        
        String hiloconcolor = "";
        String colorsinhilo = "";
         String colorencombo = cbcolor6.getSelectedItem().toString();
         
         
        if (!hilo.equals("0"))
            
        {
            
          for (String valor: lista) {

           hiloconcolor =  valor;
           
           
           
          if (!hiloconcolor.equals("0")) 
           
           
          {
           
           if (hiloconcolor.contains(hilo))
               
           {
          
               colorsinhilo =  hiloconcolor.replace(hilo, "");
               
               
              
               
               if (!colorencombo.equals("ninguno"))
               
               
               {
                   if (!colorencombo.equals(colorsinhilo))
                       
                   {
                      int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor6.setSelectedItem(colorsinhilo);
          
        }
        else
        {
            
            cbhilo6.setSelectedItem(hilo6seleccionado);
            
        }
                   }
                   
               }
               else
               {
                 
                cbcolor6.setSelectedItem(colorsinhilo);
                   
               }
               
            
                
                    
           }
              
               

                }
            
            
            
          }
            
            
            
        }
        
        
        
        
        
    }//GEN-LAST:event_cbhilo6PopupMenuWillBecomeInvisible

    private void cbhilo7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo7PopupMenuWillBecomeInvisible
       
        
        
        
        String hilo = cbhilo7.getSelectedItem().toString();
        
        String hiloconcolor = "";
        String colorsinhilo = "";
         String colorencombo = cbcolor7.getSelectedItem().toString();
         
         
        if (!hilo.equals("0"))
            
        {
            
          for (String valor: lista) {

           hiloconcolor =  valor;
           
           
           
          if (!hiloconcolor.equals("0")) 
           
           
          {
           
           if (hiloconcolor.contains(hilo))
               
           {
          
               colorsinhilo =  hiloconcolor.replace(hilo, "");
               
               
              
               
               if (!colorencombo.equals("ninguno"))
               
               
               {
                   if (!colorencombo.equals(colorsinhilo))
                       
                   {
                      int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {
            cbcolor7.setSelectedItem(colorsinhilo);
          
        }
        else
        {
            
            cbhilo7.setSelectedItem(hilo7seleccionado);
            
        }
                   }
                   
               }
               else
               {
                 
                cbcolor7.setSelectedItem(colorsinhilo);
                   
               }
               
            
                
                    
           }
              
               

                }
            
            
            
          }
            
            
            
        }
        
        
        
        
        
        
    }//GEN-LAST:event_cbhilo7PopupMenuWillBecomeInvisible

    private void txt1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt1FocusLost
      
        
         String nombre = txt1.getText();
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
        
        
        
    }//GEN-LAST:event_txt1FocusLost

    private void txt2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2FocusLost
      
        
           String nombre = txt2.getText();
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
    
    
    }//GEN-LAST:event_txt2FocusLost

    private void txt3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3FocusLost
      
        
        
           String nombre = txt3.getText();
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
    
    
    
    }//GEN-LAST:event_txt3FocusLost

    private void txt4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4FocusLost
       
        
        
           String nombre = txt4.getText();
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
    
    
    
    }//GEN-LAST:event_txt4FocusLost

    private void txt5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5FocusLost
     
        
        
           String nombre = txt5.getText();
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
    
    
    
    }//GEN-LAST:event_txt5FocusLost

    private void txt6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6FocusLost
       
        
        
           String nombre = txt6.getText();
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
    
    
    
    }//GEN-LAST:event_txt6FocusLost

    private void txt7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7FocusLost
      
        
        
           String nombre = txt7.getText();
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
    
    
    
    }//GEN-LAST:event_txt7FocusLost

    private void btnagregarprendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarprendaActionPerformed

        Object descripcion = txtagregarprenda.getText();
        String yaexiste = "no";

        try
        {

            String sql = "SELECT descripcion FROM catalogo_prendas_portanombres where descripcion = '"+descripcion+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                yaexiste= "si";
            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        if (yaexiste.equals("si"))
        {

            JOptionPane.showMessageDialog(null, "La prenda que desea dar de alta ya existe");
        }

        else

        {

            String sql="INSERT INTO catalogo_prendas_portanombres (codigo,descripcion) VALUES (?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setString(1,numerocatalogoprendas);
                pst.setString(2,txtagregarprenda.getText());

                pst.executeUpdate();
                pst.close();
            }

            catch (SQLException ex) {
               System.out.println(ex);
            }

            txtagregarprenda.setText("");
            datoscombo();

        }

    }//GEN-LAST:event_btnagregarprendaActionPerformed

    private void btnagregarubicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarubicacionActionPerformed

        Object descripcion = txtagregarubicacion.getText();
        String yaexiste = "no";

        try
        {

            String sql = "SELECT descripcion FROM catalogo_ubicacion_portanombres where descripcion = '"+descripcion+"'";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                yaexiste= "si";
            }

            st.close();
        } catch (SQLException ex) {
             System.out.println(ex);
        }

        if (yaexiste.equals("si"))
        {

            JOptionPane.showMessageDialog(null, "La ubicacion que desea dar de alta ya existe");
        }

        else

        {

            String sql="INSERT INTO catalogo_ubicacion_portanombres (codigo,descripcion) VALUES (?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(sql);

                pst.setString(1,numerocatalogoubicacion);
                pst.setString(2,txtagregarubicacion.getText());

                pst.executeUpdate();
                pst.close();
            }

            catch (SQLException ex) {
                 System.out.println(ex);
            }

            txtagregarubicacion.setText("");
            datoscombo();

        }

    }//GEN-LAST:event_btnagregarubicacionActionPerformed

    private void txtagregarprendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtagregarprendaKeyReleased
       
        
        
         String cadena = (txtagregarprenda.getText()).toUpperCase();
   
     
     
     
     int pos = txtagregarprenda.getCaretPosition();
         txtagregarprenda.setText(txtagregarprenda.getText().toUpperCase());
         txtagregarprenda.setCaretPosition(pos);

     
    }//GEN-LAST:event_txtagregarprendaKeyReleased

    private void txtagregarubicacionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtagregarubicacionKeyReleased
      
        
        
         String cadena = (txtagregarubicacion.getText()).toUpperCase();
   
     
     
     
     int pos = txtagregarubicacion.getCaretPosition();
         txtagregarubicacion.setText(txtagregarubicacion.getText().toUpperCase());
         txtagregarubicacion.setCaretPosition(pos);

         
         
         
         
         
    }//GEN-LAST:event_txtagregarubicacionKeyReleased

    private void btnagregarbordadosMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarbordadosMouseDragged

    }//GEN-LAST:event_btnagregarbordadosMouseDragged

    private void btnagregarbordadosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarbordadosMouseMoved

    }//GEN-LAST:event_btnagregarbordadosMouseMoved

    private void btnagregarbordadosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarbordadosMouseEntered

        // COMENTARIO MOTIVO POR QUE
        
        
        btnagregarbordados.setToolTipText(""

            + "<html><head><style>#contenido{background: #FFFF33;font-size: 18pt;color: black;</style></head><body><div id= 'contenido'>"
            + "<html><center>Este boton se</p><center>deshabilita cuando</p><center>editas los datos<html>"
            + "</div></body></html>");
         

    }//GEN-LAST:event_btnagregarbordadosMouseEntered

    private void btnagregarbordadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarbordadosActionPerformed

      

    }//GEN-LAST:event_btnagregarbordadosActionPerformed

    private void cbprendaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbprendaPopupMenuWillBecomeInvisible

        
        btnagregarbordados.setEnabled(false);
        
        
         Object prendacombo = cbprenda.getSelectedItem();
        
        if (prendacombo == null || prendacombo.equals(""))
        {
            prenda = "ninguno";
        }
        else
        {
            prenda = prendacombo.toString();
            
            txtidentificadordeprenda.setEnabled(true);
        txt1.setEnabled(true);
        txt2.setEnabled(true);
        txt3.setEnabled(true);
        txt4.setEnabled(true);
        txt5.setEnabled(true);
        txt6.setEnabled(true);
        txt7.setEnabled(true);   
        
        
        }
        
     
        
        
        
    }//GEN-LAST:event_cbprendaPopupMenuWillBecomeInvisible

    private void cbubicacion1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion1PopupMenuWillBecomeInvisible
        btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbubicacion1PopupMenuWillBecomeInvisible

    private void cbubicacion2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion2PopupMenuWillBecomeInvisible
       btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbubicacion2PopupMenuWillBecomeInvisible

    private void cbubicacion3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion3PopupMenuWillBecomeInvisible
      btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbubicacion3PopupMenuWillBecomeInvisible

    private void cbubicacion4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion4PopupMenuWillBecomeInvisible
       btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbubicacion4PopupMenuWillBecomeInvisible

    private void cbubicacion5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion5PopupMenuWillBecomeInvisible
       btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbubicacion5PopupMenuWillBecomeInvisible

    private void cbubicacion6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion6PopupMenuWillBecomeInvisible
       btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbubicacion6PopupMenuWillBecomeInvisible

    private void cbubicacion7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion7PopupMenuWillBecomeInvisible
      btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbubicacion7PopupMenuWillBecomeInvisible

    private void cbpuntadas1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas1PopupMenuWillBecomeInvisible
      btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbpuntadas1PopupMenuWillBecomeInvisible

    private void cbpuntadas2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas2PopupMenuWillBecomeInvisible
        btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbpuntadas2PopupMenuWillBecomeInvisible

    private void cbpuntadas3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas3PopupMenuWillBecomeInvisible
        btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbpuntadas3PopupMenuWillBecomeInvisible

    private void cbpuntadas4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas4PopupMenuWillBecomeInvisible
         btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbpuntadas4PopupMenuWillBecomeInvisible

    private void cbpuntadas5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas5PopupMenuWillBecomeInvisible
        btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbpuntadas5PopupMenuWillBecomeInvisible

    private void cbpuntadas6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas6PopupMenuWillBecomeInvisible
       btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbpuntadas6PopupMenuWillBecomeInvisible

    private void cbpuntadas7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas7PopupMenuWillBecomeInvisible
        btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbpuntadas7PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad1PopupMenuWillBecomeInvisible
      btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbaplicacioncantidad1PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad2PopupMenuWillBecomeInvisible
         btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbaplicacioncantidad2PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad3PopupMenuWillBecomeInvisible
        btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbaplicacioncantidad3PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad4PopupMenuWillBecomeInvisible
         btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbaplicacioncantidad4PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad5PopupMenuWillBecomeInvisible
        btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbaplicacioncantidad5PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad6PopupMenuWillBecomeInvisible
       btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbaplicacioncantidad6PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad7PopupMenuWillBecomeInvisible
        btnagregarbordados.setEnabled(false);
    }//GEN-LAST:event_cbaplicacioncantidad7PopupMenuWillBecomeInvisible

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bordadosdelclienteeditarnuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarbordados;
    private javax.swing.JButton btnagregarfotomontaje;
    private javax.swing.JButton btnagregarprenda;
    private javax.swing.JButton btnagregarubicacion;
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneliminarfotomontaje;
    private javax.swing.JButton btneliminartodo;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimportarfotomontaje;
    private javax.swing.JButton btnpuntadas;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnverfotomontaje;
    private javax.swing.JComboBox<String> cbaplicacioncantidad1;
    private javax.swing.JComboBox<String> cbaplicacioncantidad2;
    private javax.swing.JComboBox<String> cbaplicacioncantidad3;
    private javax.swing.JComboBox<String> cbaplicacioncantidad4;
    private javax.swing.JComboBox<String> cbaplicacioncantidad5;
    private javax.swing.JComboBox<String> cbaplicacioncantidad6;
    private javax.swing.JComboBox<String> cbaplicacioncantidad7;
    private javax.swing.JComboBox cbaplicacioncolor1;
    private javax.swing.JComboBox cbaplicacioncolor2;
    private javax.swing.JComboBox cbaplicacioncolor3;
    private javax.swing.JComboBox cbaplicacioncolor4;
    private javax.swing.JComboBox cbaplicacioncolor5;
    private javax.swing.JComboBox cbaplicacioncolor6;
    private javax.swing.JComboBox cbaplicacioncolor7;
    private javax.swing.JComboBox cbcolor1;
    private javax.swing.JComboBox cbcolor2;
    private javax.swing.JComboBox cbcolor3;
    private javax.swing.JComboBox cbcolor4;
    private javax.swing.JComboBox cbcolor5;
    private javax.swing.JComboBox cbcolor6;
    private javax.swing.JComboBox cbcolor7;
    private javax.swing.JComboBox cbhilo1;
    private javax.swing.JComboBox cbhilo2;
    private javax.swing.JComboBox cbhilo3;
    private javax.swing.JComboBox cbhilo4;
    private javax.swing.JComboBox cbhilo5;
    private javax.swing.JComboBox cbhilo6;
    private javax.swing.JComboBox cbhilo7;
    public static javax.swing.JComboBox<String> cbprenda;
    private javax.swing.JComboBox<String> cbpuntadas1;
    private javax.swing.JComboBox<String> cbpuntadas2;
    private javax.swing.JComboBox<String> cbpuntadas3;
    private javax.swing.JComboBox<String> cbpuntadas4;
    private javax.swing.JComboBox<String> cbpuntadas5;
    private javax.swing.JComboBox<String> cbpuntadas6;
    private javax.swing.JComboBox<String> cbpuntadas7;
    private javax.swing.JComboBox<String> cbubicacion1;
    private javax.swing.JComboBox<String> cbubicacion2;
    private javax.swing.JComboBox<String> cbubicacion3;
    private javax.swing.JComboBox<String> cbubicacion4;
    private javax.swing.JComboBox<String> cbubicacion5;
    private javax.swing.JComboBox<String> cbubicacion6;
    private javax.swing.JComboBox<String> cbubicacion7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lbanuncio;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbcodigocliente;
    private javax.swing.JLabel lbconsecutivo;
    private javax.swing.JLabel lbfotomontaje;
    public static javax.swing.JLabel lbidentificador;
    private javax.swing.JLabel lbnombrebordadoanterior;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbtipo;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    private javax.swing.JTextField txtagregarprenda;
    private javax.swing.JTextField txtagregarubicacion;
    public static javax.swing.JLabel txtconsecutivo;
    public static javax.swing.JTextField txtidentificadordeprenda;
    // End of variables declaration//GEN-END:variables
connectar cc = new connectar();
Connection cn = cc.conexion();

}
