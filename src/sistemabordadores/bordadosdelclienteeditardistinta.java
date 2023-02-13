

package sistemabordadores;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.util.ArrayList;


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

        ventanabordadosdelclienteeditardistinta = true;
        btndatos.setVisible(false);
        lbanuncio.setVisible(false);
        lbcodigocliente.setVisible(false);
       
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
        
        
        datoscombo();

    }
    
    
 
    
    void datoscombo()
    {
        
        
        
        Object prendaprevia1 = lbprenda.getText();
       
        
        Object ubicacionprevia1 = cbubicacion1.getSelectedItem();
        Object ubicacionprevia2 = cbubicacion2.getSelectedItem();
        Object ubicacionprevia3 = cbubicacion3.getSelectedItem();
        Object ubicacionprevia4 = cbubicacion4.getSelectedItem();
        Object ubicacionprevia5 = cbubicacion5.getSelectedItem();
        Object ubicacionprevia6 = cbubicacion6.getSelectedItem();
        Object ubicacionprevia7 = cbubicacion7.getSelectedItem();
        

           
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

           

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }   
         
        
         
         
        //cbprenda.setSelectedItem(prendaprevia1);
       
         
         cbubicacion1.setSelectedItem(ubicacionprevia1);
         cbubicacion2.setSelectedItem(ubicacionprevia2);
         cbubicacion3.setSelectedItem(ubicacionprevia3);
         cbubicacion4.setSelectedItem(ubicacionprevia4);
         cbubicacion5.setSelectedItem(ubicacionprevia5);
         cbubicacion6.setSelectedItem(ubicacionprevia6);
         cbubicacion7.setSelectedItem(ubicacionprevia7);
         

        
    }
    
    
    
    
    
    

    void datos() {
       
        
        codigodelcliente = lbcodigocliente.getText();
        nombrebordado = txtidentificadordeprenda.getText().trim();
        numeroconsecutivo = txtconsecutivo.getText();
        tipobordado();
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

                       txtidentificadordeprenda.setText(nombrebordado);
                    lbnombrebordadoanterior.setText(nombrebordado);

                    cbubicacion1.setSelectedItem(ubicacion1);
                    cbpuntadas1.setSelectedItem(distinta1);
                    txt1.setText(distinta1nombre);

                    cbubicacion2.setSelectedItem(ubicacion2);
                    cbpuntadas2.setSelectedItem(distinta2);
                    txt2.setText(distinta2nombre);

                    cbubicacion3.setSelectedItem(ubicacion3);
                    cbpuntadas3.setSelectedItem(distinta3);
                    txt3.setText(distinta3nombre);

                    cbubicacion4.setSelectedItem(ubicacion4);
                    cbpuntadas4.setSelectedItem(distinta4);
                    txt4.setText(distinta4nombre);

                    cbubicacion5.setSelectedItem(ubicacion5);
                    cbpuntadas5.setSelectedItem(distinta5);
                    txt5.setText(distinta5nombre);

                    cbubicacion6.setSelectedItem(ubicacion6);
                    cbpuntadas6.setSelectedItem(distinta6);
                    txt6.setText(distinta6nombre);

                    cbubicacion7.setSelectedItem(ubicacion7);
                    cbpuntadas7.setSelectedItem(distinta7);
                    txt7.setText(distinta7nombre);

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
    
        prenda = lbprenda.getText();
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
        btnguardar = new javax.swing.JButton();
        lbtipo = new javax.swing.JLabel();
        cbpuntadas7 = new javax.swing.JComboBox<>();
        txt7 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        btndatos = new javax.swing.JButton();
        lbnombrecomercial = new javax.swing.JLabel();
        txtidentificadordeprenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtconsecutivo = new javax.swing.JLabel();
        lbnombrebordadoanterior = new javax.swing.JLabel();
        lbconsecutivo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        cbubicacion7 = new javax.swing.JComboBox<>();
        cbubicacion1 = new javax.swing.JComboBox<>();
        cbubicacion2 = new javax.swing.JComboBox<>();
        cbubicacion4 = new javax.swing.JComboBox<>();
        cbubicacion3 = new javax.swing.JComboBox<>();
        cbubicacion5 = new javax.swing.JComboBox<>();
        cbubicacion6 = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        lbprenda = new javax.swing.JTextField();

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

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 102, 0));
        btnguardar.setText("Autorizar Puntadas");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
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

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Nombre de bordado");
        jLabel50.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btndatos.setText("datos");
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Identificador");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbprenda.setForeground(new java.awt.Color(153, 0, 0));
        lbprenda.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                lbprendaFocusGained(evt);
            }
        });
        lbprenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lbprendaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lbprendaKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                        .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbanuncio, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbubicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbubicacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbubicacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbubicacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbubicacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbubicacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbpuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas3, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas4, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas6, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas7, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(558, 558, 558)
                        .addComponent(lbconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(lbnombrebordadoanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
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
                                .addComponent(cbubicacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(36, 36, 36)
                                        .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                        .addComponent(cbpuntadas7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbanuncio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(350, 350, 350)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnombrebordadoanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
       
        prenda = lbprenda.getText();
        
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
            
            
            
                 prenda = lbprenda.getText();
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

               

                
                
                 try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET nombre_bordado = '"+nombrebordado+"' WHERE codigo='" + codigodelcliente + "' and tipo = '"+prenda+"' and prenda_especial = 'distinta' AND numero_consecutivo = '"+txtconsecutivo.getText()+"'");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                 
                 try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET autorizacion_puntadas = 'si' WHERE codigo='" + codigodelcliente + "' and tipo = '"+prenda+"' and prenda_especial = 'distinta' AND numero_consecutivo = '"+txtconsecutivo.getText()+"'");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                } 

        
        }
                 
        }
        
        }
        
        }
        

        if(bordadosdelclientecatalogo.ventanabordadosdelclientecatalogonuevo==true)
        {
            
            bordadosdelclientecatalogo.btndatos.doClick();
            
            bordadosdelclientecatalogo.cbprenda.setSelectedItem(lbprenda.getText());
            
            
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
        
        
        Object prendacombo = lbprenda.getText();
        
        if (prendacombo == null || prendacombo.equals(""))
        {
            prenda = "ninguno";
        }
        else
        {
            prenda = prendacombo.toString();
            datos();
        }
      
        
        
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

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed
      datos();
      
    }//GEN-LAST:event_btndatosActionPerformed

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

    private void cbubicacion1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion1PopupMenuWillBecomeInvisible
   
    }//GEN-LAST:event_cbubicacion1PopupMenuWillBecomeInvisible

    private void cbubicacion2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion2PopupMenuWillBecomeInvisible
  
    }//GEN-LAST:event_cbubicacion2PopupMenuWillBecomeInvisible

    private void cbubicacion3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion3PopupMenuWillBecomeInvisible
  
    }//GEN-LAST:event_cbubicacion3PopupMenuWillBecomeInvisible

    private void cbubicacion4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion4PopupMenuWillBecomeInvisible
       
    }//GEN-LAST:event_cbubicacion4PopupMenuWillBecomeInvisible

    private void cbubicacion5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion5PopupMenuWillBecomeInvisible

    }//GEN-LAST:event_cbubicacion5PopupMenuWillBecomeInvisible

    private void cbubicacion6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion6PopupMenuWillBecomeInvisible
 
    }//GEN-LAST:event_cbubicacion6PopupMenuWillBecomeInvisible

    private void cbubicacion7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbubicacion7PopupMenuWillBecomeInvisible
     
    }//GEN-LAST:event_cbubicacion7PopupMenuWillBecomeInvisible

    private void cbpuntadas1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas1PopupMenuWillBecomeInvisible
   
    }//GEN-LAST:event_cbpuntadas1PopupMenuWillBecomeInvisible

    private void cbpuntadas2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas2PopupMenuWillBecomeInvisible
       
    }//GEN-LAST:event_cbpuntadas2PopupMenuWillBecomeInvisible

    private void cbpuntadas3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas3PopupMenuWillBecomeInvisible
    
    }//GEN-LAST:event_cbpuntadas3PopupMenuWillBecomeInvisible

    private void cbpuntadas4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas4PopupMenuWillBecomeInvisible
        
    }//GEN-LAST:event_cbpuntadas4PopupMenuWillBecomeInvisible

    private void cbpuntadas5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas5PopupMenuWillBecomeInvisible
       
    }//GEN-LAST:event_cbpuntadas5PopupMenuWillBecomeInvisible

    private void cbpuntadas6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas6PopupMenuWillBecomeInvisible

    }//GEN-LAST:event_cbpuntadas6PopupMenuWillBecomeInvisible

    private void cbpuntadas7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas7PopupMenuWillBecomeInvisible
      
    }//GEN-LAST:event_cbpuntadas7PopupMenuWillBecomeInvisible

    private void lbprendaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_lbprendaFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_lbprendaFocusGained

    private void lbprendaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbprendaKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_lbprendaKeyPressed

    private void lbprendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lbprendaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lbprendaKeyReleased

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bordadosdelclienteeditarnuevo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnsalir;
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
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lbanuncio;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbcodigocliente;
    private javax.swing.JLabel lbconsecutivo;
    public static javax.swing.JLabel lbidentificador;
    private javax.swing.JLabel lbnombrebordadoanterior;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JTextField lbprenda;
    public static javax.swing.JLabel lbtipo;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    public static javax.swing.JLabel txtconsecutivo;
    public static javax.swing.JTextField txtidentificadordeprenda;
    // End of variables declaration//GEN-END:variables
connectar cc = new connectar();
Connection cn = cc.conexion();

}
