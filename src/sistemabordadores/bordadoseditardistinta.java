

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


public class bordadoseditardistinta extends javax.swing.JFrame {

    public static boolean ventanabordadosdelclienteeditardistinta = false;
    
    String numerocatalogoprendas = "";
    String numerocatalogoubicacion = "";
    String identificadordeprendaanterior = "";
    String codigodelcliente = "";
    String numerocamisa = "";
  
    String rutaarchivo = "";
    String nombrearchivo = "";
    String consultaborrado ="";
    
    String  prendafotomontaje ="";
    String  nombreprendafotomontaje ="";      
    String actualizarbordado ="no";
    
    String identificador = "";
   
    
    
    String cerrarinterface = "si";
    String numeroconsecutivo = "";
    String pasa = "si";
    
    String nombreanterior = "";

    String identificadordeprenda = "";
    
    String prenda = "";
   
    
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
    
    String puntadasautorizadas = "";
    
    ArrayList<String> lista = new ArrayList<String>();
    
   
    public bordadoseditardistinta() {
        initComponents();
        
        
        

         combopuntadaa();

        
        ventanabordadosdelclienteeditardistinta = true;
        btndatos.setVisible(false);
        lbanuncio.setVisible(false);
        lbcodigocliente.setVisible(false);
        lbidentificadordeprendaanterior.setVisible(false);

        
         btnverfotomontaje.setEnabled(false);
         btneliminarfotomontaje.setEnabled(false);
         btnagregarfotomontaje.setEnabled(false);
        
        lbconsecutivo.setVisible(false);
        
        txtidentificador.setEnabled(false);
        txt1.setEnabled(false);
        txt2.setEnabled(false);
        txt3.setEnabled(false);
        txt4.setEnabled(false);
        txt5.setEnabled(false);
        txt6.setEnabled(false);
        txt7.setEnabled(false);  
        
    }

    

    void combopuntadaa() {

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
    


    void datos() {
       
       
        
        codigodelcliente = lbcodigocliente.getText();
        identificadordeprenda = txtidentificador.getText().trim();
        numeroconsecutivo = lbconsecutivo.getText();
       
       
        
        String sql = "";
        
               

                sql = "SELECT prenda_especial,identificador_prenda,"
                        + "distinta1_ubicacion,distinta1,distinta1_nombre,distinta1_aplicacion,distinta1_aplicacion_color,"
                        + "distinta2_ubicacion,distinta2,distinta2_nombre,distinta2_aplicacion,distinta2_aplicacion_color,"
                        + "distinta3_ubicacion,distinta3,distinta3_nombre,distinta3_aplicacion,distinta3_aplicacion_color,"
                        + "distinta4_ubicacion,distinta4,distinta4_nombre,distinta4_aplicacion,distinta4_aplicacion_color,"
                        + "distinta5_ubicacion,distinta5,distinta5_nombre,distinta5_aplicacion,distinta5_aplicacion_color,"
                        + "distinta6_ubicacion,distinta6,distinta6_nombre,distinta6_aplicacion,distinta6_aplicacion_color,"
                        + "distinta7_ubicacion,distinta7,distinta7_nombre,distinta7_aplicacion,distinta7_aplicacion_color,"
                        + "color1,color2,color3,color4,color5,color6,color7,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,autorizacion_puntadas "
                        + " FROM bordados_puntadas where identificador_prenda = '"+identificadordeprenda+"'  and codigo = '"+codigodelcliente+"' AND tipo = '"+prenda+"' and numero_consecutivo = '"+txtconsecutivo.getText()+"' "; //and numero_consecutivo = '"+numeroconsecutivo+"' 
            

        
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                        tipo = rs.getString("prenda_especial");
                    
                        identificadordeprenda = rs.getString("identificador_prenda");
                           
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
                        
                        
                        
                        
                         puntadasautorizadas = rs.getString("autorizacion_puntadas");
                        
                        if (puntadasautorizadas.equals("si"))
                        {
                            btnautorizarpuntadas.setEnabled(false);
                        }
                        
                
                        
                          
                        
                        
                        txtidentificador.setText(identificadordeprenda);
                       lbidentificadordeprendaanterior.setText(identificadordeprenda);
           
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

         
         
    
    void cargarelfotomontaje()
    {
    
        
        BufferedImage img = null;
        String sqlimagen = "Select imagen,extension_imagen from bordados_puntadas where codigo = '" + codigodelcliente + "' and tipo = '"+prenda+"' and numero_consecutivo = '"+txtconsecutivo.getText()+"'   ";

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
    
     void insertarnumero()
    {
         Object codigo = lbconsecutivo.getText();
         prenda = lbprenda.getText();
                 
        if ( codigo == null || codigo.equals("") || codigo.equals("0")|| codigo.equals("00000000")) 
        {

            int j;
            String codigoprenda = "";
            String SQL = "SELECT MAX(numero_consecutivo) FROM bordados_puntadas where tipo = '"+prenda+"' ";

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                if (rs.next()) 
                {
                    codigoprenda = rs.getString(1);
                } 
                
                if (codigoprenda == null) 
                {
                    lbconsecutivo.setText("00000001");
                }
                else 
                {
                    j = Integer.parseInt(codigoprenda);
                    GenerarNumero gen = new GenerarNumero();
                    gen.generar(j);

                    lbconsecutivo.setText(gen.serie());

                }

            } catch (Exception e) {
               System.out.println(e);
            }
            
          
         

           

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
       
            String sql = "SELECT numero,articulo FROM historial_ventas where codigo_cliente='"+codigodelcliente+"' and identificador_prenda = '"+lbidentificadordeprendaanterior.getText()+"'  ";
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
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 2"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta2.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 3"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta3.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 4"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta4.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 5"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta5.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 6"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta6.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("DISTINTA 7"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = distinta7.toString();
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                
                
             
            }
            
         
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
    
    
    

    
    final void generarnumerocatalogoubicacion() {
     
        int j;
       String c = "";
        String SQL = "select max(numero) from catalogo_ubicacion_portanombres";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            if (rs.next()) {
                c = rs.getString(1);
            } else {

            }

            if (c == null) {
                numerocatalogoubicacion ="00000001";
            } else {
                j = Integer.parseInt(c);
                GenerarNumero gen = new GenerarNumero();
                gen.generar(j);
                numerocatalogoubicacion = gen.serie();

            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    
    
    
    
    
    
    
    void actualizarlaubicacion(String ubicacion,String numeroventa,String nombrebordado,String nombrearticuloactualizar,String numerocotizacion)
    {
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_VENTAS SET ARTICULO = '"+ubicacion.trim()+ "' ,identificador_prenda = '"+txtidentificador.getText()+"' WHERE codigo_cliente='" + codigodelcliente + "' and identificador_prenda = '" +lbidentificadordeprendaanterior.getText()+ "'  AND numero = '" + numeroventa + "' and articulo = '"+nombrearticuloactualizar+"' ");
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
            PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_COTIZACIONES SET ARTICULO = '"+ubicacion.trim()+ "' WHERE codigo_cliente='" + codigodelcliente + "' and identificador_prenda = '" + identificadordeprenda + "'  AND numero = '" + numerocotizacion + "' and articulo = '"+nombrearticuloactualizar+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        
    }
    
    
    void quevaainsertar(){
    
        prenda = lbprenda.getText();
        Object nombrebordado = lbidentificadordeprendaanterior.getText();
        
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
        lbtipo = new javax.swing.JLabel();
        cbpuntadas7 = new javax.swing.JComboBox<>();
        txt7 = new javax.swing.JTextField();
        btnagregarfotomontaje = new javax.swing.JButton();
        btnverfotomontaje = new javax.swing.JButton();
        btneliminarfotomontaje = new javax.swing.JButton();
        btneliminartodo = new javax.swing.JButton();
        lbfotomontaje = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        btndatos = new javax.swing.JButton();
        lbnombrecomercial = new javax.swing.JLabel();
        txtidentificador = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lbidentificadordeprendaanterior = new javax.swing.JLabel();
        lbconsecutivo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbbordacliente = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        cbubicacion7 = new javax.swing.JComboBox<>();
        cbubicacion1 = new javax.swing.JComboBox<>();
        cbubicacion2 = new javax.swing.JComboBox<>();
        cbubicacion4 = new javax.swing.JComboBox<>();
        cbubicacion3 = new javax.swing.JComboBox<>();
        cbubicacion5 = new javax.swing.JComboBox<>();
        cbubicacion6 = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        btnautorizarpuntadas = new javax.swing.JButton();
        lbprenda = new javax.swing.JLabel();
        txtconsecutivo = new javax.swing.JTextField();

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

        btnagregarfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnagregarfotomontaje.setText("Agregar fotomontaje");
        btnagregarfotomontaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnagregarfotomontajeMouseEntered(evt);
            }
        });
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

        btndatos.setText("datos");
        btndatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndatosActionPerformed(evt);
            }
        });

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtidentificador.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtidentificador.setForeground(new java.awt.Color(153, 0, 0));
        txtidentificador.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtidentificadorFocusGained(evt);
            }
        });
        txtidentificador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtidentificadorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtidentificadorKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Identificador de prenda");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificadordeprendaanterior.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbconsecutivo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Bordacliente");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btnautorizarpuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnautorizarpuntadas.setText("Autorizar Puntadas");
        btnautorizarpuntadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnautorizarpuntadasActionPerformed(evt);
            }
        });

        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtconsecutivo.setEditable(false);
        txtconsecutivo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btnagregarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(btneliminarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207)
                .addComponent(btnautorizarpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btneliminartodo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbfotomontaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbpuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas3, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas4, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas6, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas7, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel49, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txt1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(lbidentificadordeprendaanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbanuncio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(7, 7, 7)
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel11)
                                .addGap(7, 7, 7)
                                .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 905, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(39, 39, 39))
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
                    .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1)))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbidentificadordeprendaanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbanuncio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                .addComponent(cbpuntadas7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2))
                    .addGroup(layout.createSequentialGroup()
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
                        .addComponent(cbubicacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneliminarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnautorizarpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btneliminartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnagregarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(lbfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            cargarelfotomontaje();
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

    private void btnagregarfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnagregarfotomontajeActionPerformed

       
    
        identificadordeprenda = txtidentificador.getText();
        
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

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigodelcliente+"' and identificador_prenda = '"+identificadordeprenda+"' and tipo = '"+prenda+"' and numero_consecutivo = '"+lbconsecutivo.getText()+"' ";

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
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"' where codigo='"+codigodelcliente+"' and identificador_prenda = '"+identificadordeprenda+"' and tipo = '"+prenda+"' and numero_consecutivo = '"+lbconsecutivo.getText()+"' ");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
            ImageIcon fot = new ImageIcon(rutaarchivo);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT));
            lbfotomontaje.setIcon(icono);
            this.repaint();
            
            
              JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Fotomontaje agregado correctamente");

        }
        
        }
        
    }//GEN-LAST:event_btnagregarfotomontajeActionPerformed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed

        codigodelcliente = lbcodigocliente.getText();
    
        String rutadelarchivo = "";
        String existe = "";
        prenda = lbprenda.getText();
        identificadordeprenda = txtidentificador.getText().trim();
        
       String SQL = "SELECT imagen,extension_imagen FROM bordados_puntadas where codigo = '"+codigodelcliente+"' and tipo = '"+prenda+"' and identificador_prenda = '"+identificadordeprenda+"'  ";

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
             JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se pudo encontrar el archivo","Error",JOptionPane.ERROR_MESSAGE);
        }    

    }//GEN-LAST:event_btnverfotomontajeActionPerformed

    private void btneliminarfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarfotomontajeActionPerformed

         codigodelcliente = lbcodigocliente.getText();
   
        String existe = "";
        prenda = lbprenda.getText();
        identificadordeprenda = txtidentificador.getText().trim();
        
        
        int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea Eliminar esta Imagen permanentemente?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {

            
            
            String SQL = "SELECT imagen FROM bordados_puntadas where codigo = '"+codigodelcliente+"'  and tipo = '"+prenda+"' and identificador_prenda = '"+identificadordeprenda+"' and numero_consecutivo = '"+txtconsecutivo.getText()+"' ";

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

                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET imagen=NULL, extension_imagen='' WHERE codigo='"+codigodelcliente+"' and tipo = '"+prenda+"' and identificador_prenda = '"+identificadordeprenda+"' and numero_consecutivo = '"+lbconsecutivo.getText()+"' ");
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
        identificadordeprenda= txtidentificador.getText().trim();
        prenda = lbprenda.getText();
        String numeroconsecutivo = lbconsecutivo.getText();
        
        int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea Eliminar este bordado?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {

             try {
                Statement st = cn.createStatement();
                PreparedStatement pst = cn.prepareStatement("DELETE FROM bordados_puntadas WHERE  codigo='"+codigodelcliente+"' and identificador_prenda = '"+identificadordeprenda+"' AND tipo = '"+prenda+"' and numero_consecutivo = '"+numeroconsecutivo+"' ");
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

    private void txtidentificadorFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtidentificadorFocusGained
       txtidentificador.selectAll();
    }//GEN-LAST:event_txtidentificadorFocusGained

    private void txtidentificadorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidentificadorKeyReleased

        
           
         String nombre = txtidentificador.getText();
        
      
         if (nombre.contains("  "))
            
        {
            
        
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
                txtidentificador.requestFocus();
                txtidentificador.selectAll();
                
                
            txtidentificador.setText(nombreanterior);    
                
            
           
                
                
        }
         
         else
             
         {
        
        
       String cadena = (txtidentificador.getText()).toUpperCase();

        int pos = txtidentificador.getCaretPosition();
         txtidentificador.setText(txtidentificador.getText().toUpperCase());
         txtidentificador.setCaretPosition(pos);

        
     
     if(cadena.contains(prenda))
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre del concepto ");
     }
     
     
         }
         
         
         
         
     
    }//GEN-LAST:event_txtidentificadorKeyReleased

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

    private void txtidentificadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtidentificadorKeyPressed
      
        
        nombreanterior = txtidentificador.getText();
        
        
    }//GEN-LAST:event_txtidentificadorKeyPressed

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

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
         ventanabordadosdelclienteeditardistinta = false;
        this.dispose();;
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnagregarfotomontajeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarfotomontajeMouseEntered
      
        
        
        // COMENTARITO 
          
        btnagregarfotomontaje.setToolTipText(""
               
               + "<html><head><style>#contenido{background: #FFFF33;font-size: 18pt;color: black;</style></head><body><div id= 'contenido'>"
           
             + "<html><center>Para agregar fotomontaje</p><center>primero debe guardar</p><center>loa datos<html>"
             
               + "</div></body></html>");
       
       
        
        
        
        
    }//GEN-LAST:event_btnagregarfotomontajeMouseEntered

    private void btnautorizarpuntadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnautorizarpuntadasActionPerformed

        
        identificador = txtidentificador.getText();
        
        
        
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET autorizacion_puntadas = 'si' WHERE codigo='" + lbcodigocliente.getText() + "'  AND identificador_prenda = '" + identificador + "'  ");
            pst.executeUpdate();
            pst.close();

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Las puntadas se autorizaron correctamente");
        } catch (Exception e) {
            System.out.println(e);

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al autorizar puntadas");

        }
    }//GEN-LAST:event_btnautorizarpuntadasActionPerformed

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bordadoseditardistinta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarfotomontaje;
    private javax.swing.JButton btnautorizarpuntadas;
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneliminarfotomontaje;
    private javax.swing.JButton btneliminartodo;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnverfotomontaje;
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
    public static javax.swing.JLabel lbbordacliente;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbcodigocliente;
    public static javax.swing.JLabel lbconsecutivo;
    private javax.swing.JLabel lbfotomontaje;
    private javax.swing.JLabel lbidentificadordeprendaanterior;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbprenda;
    public static javax.swing.JLabel lbtipo;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    public static javax.swing.JTextField txtconsecutivo;
    public static javax.swing.JTextField txtidentificador;
    // End of variables declaration//GEN-END:variables
connectar cc = new connectar();
Connection cn = cc.conexion();

}
