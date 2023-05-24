

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
import java.util.List;
import java.util.stream.Collectors;


public class bordadosdelclienteeditarVIEJO extends javax.swing.JFrame {

    public static boolean ventanabordadosdelclienteeditar = false;
    
    String prenda = "";
    
    String nombrebordadoanterior = "";
    String codigodelcliente = "";
    String numerocamisa = "";
    String identificadordeprenda = "";
    String rutaarchivo = "";
    String nombrearchivo = "";
    String consultaborrado ="";
    
    String  prendafotomontaje ="";
    String  nombreprendafotomontaje ="";      
    String actualizarbordado ="no";
    
    String pechoizquierdo = "ninguno";
    String pechoizquierdonombre = "";
    String pechoizquierdoaplicacion = "0";
    String pechoizquierdoaplicacioncolor = "";
    String pechoderecho = "ninguno";
    String pechoderechonombre = "";
    String pechoderechoaplicacion = "0";
    String pechoderechoaplicacioncolor = "";
    String mangaizquierda = "ninguno";
    String mangaizquierdanombre = "";
    String mangaizquierdaaplicacion = "0";
    String mangaizquierdaaplicacioncolor = "";
    String mangaderecha = "ninguno";
    String mangaderechanombre = "";
    String mangaderechaaplicacion = "0";
    String mangaderechaaplicacioncolor = "";
    String espalda = "ninguno";
    String espaldanombre = "";
    String espaldaaplicacion = "0";
    String espaldaaplicacioncolor = "";
    String espaldapuntadasaro = "";
    String espaldaaro = "";
    String otraubicacion = "ninguno";
    String otraubicacionnombre = "";
    String otraubicacionaplicacion = "0";
    String otraubicacionaplicacioncolor = "";
    String otraubicacion2 = "ninguno";
    String otraubicacion2nombre = "";
    String otraubicacion2aplicacion = "0";
    String otraubicacion2aplicacioncolor = "";
    
    

    ///playera
    String pechoizquierdoplayera = "ninguno";
    String pechoizquierdoplayeranombre = "";
    String pechoizquierdoplayeraaplicacion = "0";
    String pechoizquierdoplayeraaplicacioncolor = "";
    String pechoderechoplayera = "ninguno";
    String pechoderechoplayeranombre = "";
    String pechoderechoplayeraaplicacion = "0";
    String pechoderechoplayeraaplicacioncolor = "";
    String mangaizquierdaplayera = "ninguno";
    String mangaizquierdaplayeranombre = "";
    String mangaizquierdaplayeraaplicacion = "0";
    String mangaizquierdaplayeraaplicacioncolor = "";
    String mangaderechaplayera = "ninguno";
    String mangaderechaplayeranombre = "";
    String mangaderechaplayeraaplicacion = "0";
    String mangaderechaplayeraaplicacioncolor = "";
    String espaldaplayera = "ninguno";
    String espaldaplayeranombre = "";
    String espaldaplayeraaplicacion = "0";
    String espaldaplayeraaplicacioncolor = "";
    String otraubicacionplayera = "ninguno";
    String otraubicacionplayeranombre = "";
    String otraubicacionplayeraaplicacion = "0";
    String otraubicacionplayeraaplicacioncolor = "";
    String otraubicacion2playera = "ninguno";
    String otraubicacion2playeranombre = "";
    String otraubicacion2playeraaplicacion = "0";
    String otraubicacion2playeraaplicacioncolor = "";

    ///chamarra
    String pechoizquierdochamarra = "ninguno";
    String pechoizquierdochamarranombre = "";
    String pechoizquierdochamarraaplicacion = "0";
    String pechoizquierdochamarraaplicacioncolor = "";
    String pechoderechochamarra = "ninguno";
    String pechoderechochamarranombre = "";
    String pechoderechochamarraaplicacion = "0";
    String pechoderechochamarraaplicacioncolor = "";
    String mangaizquierdachamarra = "ninguno";
    String mangaizquierdachamarranombre = "";
    String mangaizquierdachamarraaplicacion = "0";
    String mangaizquierdachamarraaplicacioncolor = "";
    String mangaderechachamarra = "ninguno";
    String mangaderechachamarranombre = "";
    String mangaderechachamarraaplicacion = "0";
    String mangaderechachamarraaplicacioncolor = "";
    String espaldachamarra = "ninguno";
    String espaldachamarranombre = "";
    String espaldachamarraaplicacion = "0";
    String espaldachamarraaplicacioncolor = "";

    
    //chamarrarompevientos
    String pechoizquierdochamarrarompevientos = "ninguno";
    String pechoizquierdochamarrarompevientosnombre = "";
    String pechoizquierdochamarrarompevientosaplicacion = "0";
    String pechoizquierdochamarrarompevientosaplicacioncolor = "";
    String pechoderechochamarrarompevientos = "ninguno";
    String pechoderechochamarrarompevientosnombre = "";
    String pechoderechochamarrarompevientosaplicacion = "0";
    String pechoderechochamarrarompevientosaplicacioncolor = "";
    String mangaizquierdachamarrarompevientos = "ninguno";
    String mangaizquierdachamarrarompevientosnombre = "";
    String mangaizquierdachamarrarompevientosaplicacion = "0";
    String mangaizquierdachamarrarompevientosaplicacioncolor = "";
    String mangaderechachamarrarompevientos = "ninguno";
    String mangaderechachamarrarompevientosnombre = "";
    String mangaderechachamarrarompevientosaplicacion = "0";
    String mangaderechachamarrarompevientosaplicacioncolor = "";
    String espaldachamarrarompevientos = "ninguno";
    String espaldachamarrarompevientosnombre = "";
    String espaldachamarrarompevientosaplicacion = "0";
    String espaldachamarrarompevientosaplicacioncolor = "";


    // camisola
    String pechoizquierdocamisola = "ninguno";
    String pechoizquierdocamisolanombre = "";
    String pechoizquierdocamisolaaplicacion = "0";
    String pechoizquierdocamisolaaplicacioncolor = "";
    String pechoderechocamisola = "ninguno";
    String pechoderechocamisolanombre = "";
    String pechoderechocamisolaaplicacion = "0";
    String pechoderechocamisolaaplicacioncolor = "";
    String mangaizquierdacamisola = "ninguno";
    String mangaizquierdacamisolanombre = "";
    String mangaizquierdacamisolaaplicacion = "0";
    String mangaizquierdacamisolaaplicacioncolor = "";
    String mangaderechacamisola = "ninguno";
    String mangaderechacamisolanombre = "";
    String mangaderechacamisolaaplicacion = "0";
    String mangaderechacamisolaaplicacioncolor = "";
    String espaldacamisola = "ninguno";
    String espaldacamisolanombre = "";
    String espaldacamisolaaplicacion = "0";
    String espaldacamisolaaplicacioncolor = "";

    String pechoizquierdochaleco = "ninguno";
    String pechoizquierdochaleconombre = "";
    String pechoizquierdochalecoaplicacion = "0";
    String pechoizquierdochalecoaplicacioncolor = "";
    String pechoderechochaleco = "ninguno";
    String pechoderechochaleconombre = "";
    String pechoderechochalecoaplicacion = "0";
    String pechoderechochalecoaplicacioncolor = "";
    String espaldachaleco = "ninguno";
    String espaldachaleconombre = "";
    String espaldachalecoaplicacion = "0";
    String espaldachalecoaplicacioncolor = "";

    //gorra
    String frentegorra = "ninguno";
    String frentegorranombre = "";
    String frentegorraaplicacion = "0";
    String frentegorraaplicacioncolor = "";
    String ladoizquierdogorra = "ninguno";
    String ladoizquierdogorranombre = "";
    String ladoizquierdogorraaplicacion = "0";
    String ladoderechogorra = "ninguno";
    String ladoderechogorranombre = "";
    String ladoderechogorraaplicacion = "0";
    String atrasgorra = "ninguno";
    String atrasgorranombre = "";
    String atrasgorraaplicacion = "0";
    
    
    
     //pantalon
    String ladoizquierdofrentepantalon = "ninguno";
    String ladoizquierdofrentepantalonnombre = "";
    String ladoizquierdofrentepantalonaplicacion = "";
    String ladoizquierdofrentepantalonaplicacioncolor = "";
    
    String ladoderechofrentepantalon = "ninguno";
    String ladoderechofrentepantalonnombre = "";
    String ladoderechofrentepantalonaplicacion = "";
    String ladoderechofrentepantalonaplicacioncolor = "";
    
    String ladoizquierdoatraspantalon = "ninguno";
    String ladoizquierdoatraspantalonnombre = "";
    String ladoizquierdoatraspantalonaplicacion = "";
    String ladoizquierdoatraspantalonaplicacioncolor = "";
    
    String ladoderechoatraspantalon = "ninguno";
    String ladoderechoatraspantalonnombre = "";
    String ladoderechoatraspantalonaplicacion = "";
    String ladoderechoatraspantalonaplicacioncolor = "";

    //corbata
    String frentecorbata = "ninguno";
    String frentecorbatanombre = "";
    
    
    //parche
    String parche = "ninguno";
    String parchenombre = "";
    String parcheaplicacion = "0";
    String parcheaplicacioncolor = "";
   
    

    //saco
    String pechoizquierdosaco = "ninguno";
    String pechoizquierdosaconombre = "";
    String pechoizquierdosacoaplicacion = "";
    String pechoizquierdosacoaplicacioncolor = "";
    String pechoderechosaco = "ninguno";
    String pechoderechosaconombre = "";
    String pechoderechosacoaplicacion = "";
    String pechoderechosacoaplicacioncolor = "";
    String mangaizquierdasaco = "ninguno";
    String mangaizquierdasaconombre = "";
    String mangaizquierdasacoaplicacion = "";
    String mangaizquierdasacoaplicacioncolor = "";
    String mangaderechasaco = "ninguno";
    String mangaderechasaconombre = "";
    String mangaderechasacoaplicacion = "";
    String mangaderechasacoaplicacioncolor = "";
    String espaldasaco = "ninguno";
    String espaldasaconombre = "";
    String espaldasacoaplicacion = "";
    String espaldasacoaplicacioncolor = "";
    

    String pechoizquierdofilipina = "ninguno";
    String pechoizquierdofilipinanombre = "";
    String pechoizquierdofilipinaaplicacion = "";
    String pechoizquierdofilipinaaplicacioncolor = "";
    
    String pechoderechofilipina = "ninguno";
    String pechoderechofilipinanombre = "";
    String pechoderechofilipinaaplicacion = "";
    String pechoderechofilipinaaplicacioncolor = "";
    
   
    String mangaizquierdafilipina = "ninguno";
    String mangaizquierdafilipinanombre = "";
    String mangaizquierdafilipinaaplicacion = "";
    String mangaizquierdafilipinaaplicacioncolor = "";
    
    String mangaderechafilipina = "ninguno";
    String mangaderechafilipinanombre = "";
    String mangaderechafilipinaaplicacion = "";
    String mangaderechafilipinaaplicacioncolor = "";
    
    String espaldafilipina = "ninguno";
    String espaldafilipinanombre = "";
    String espaldafilipinaaplicacion = "";
    String espaldafilipinaaplicacioncolor = "";
    
    //mandil
    String pechoizquierdomandil = "ninguno";
    String pechoizquierdomandilnombre = "";
    String pechoizquierdomandilaplicacion = "";
    String pechoizquierdomandilaplicacioncolor = "";
    String pechoderechomandil = "ninguno";
    String pechoderechomandilnombre = "";
    String pechoderechomandilaplicacion = "";
    String pechoderechomandilaplicacioncolor = "";
    String centro = "ninguno";
    String centronombre = "";
    String centroaplicacion = "";
    String centroaplicacioncolor = "";
    
    String cerrarinterface = "si";
    String consecutivo = "";
    String pasa = "si";
    
    String nombreanterior = "";

    String ubicacion1 = "";
    String ubicacion2 = "";
    String ubicacion3 = "";
    String ubicacion4 = "";
    String ubicacion5 = "";
    String ubicacion6 = "";
    String ubicacion7 = "";
    String ubicacion8 = "";
    
    String distinta1 = "";
    String distinta2 = "";
    String distinta3 = "";
    String distinta4 = "";
    String distinta5 = "";
    String distinta6 = "";
    String distinta7 = "";
    
    
    String distinta1nombre = "";
    String distinta2nombre = "";
    String distinta3nombre = "";
    String distinta4nombre = "";
    String distinta5nombre = "";
    String distinta6nombre = "";
    String distinta7nombre = "";
    
    String distinta1aplicacion = "";
    String distinta2aplicacion = "";
    String distinta3aplicacion = "";
    String distinta4aplicacion = "";
    String distinta5aplicacion = "";
    String distinta6aplicacion = "";
    String distinta7aplicacion = "";
    
    
    String distinta1aplicacioncolor = "";
    String distinta2aplicacioncolor = "";
    String distinta3aplicacioncolor = "";
    String distinta4aplicacioncolor = "";
    String distinta5aplicacioncolor = "";
    String distinta6aplicacioncolor = "";
    String distinta7aplicacioncolor = "";
    
    
    
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
    
    String dejoespacioalfinal = "no";
    
    
    ArrayList<String> lista = new ArrayList<String>();
    public static String bordadosdelclienteeditarnuevoautorizacion = "no";
    
   
    public bordadosdelclienteeditarVIEJO() {
        initComponents();
        ventanabordadosdelclienteeditar = true;
        

        btndatos.setVisible(false);
        lbcodigocliente.setVisible(false);
        btnimportarfotomontaje.setVisible(false);
        lbidentificadordeprendaanterior.setVisible(false);

       
        lbconsecutivo.setVisible(false);
        
        btnverfotomontaje.setEnabled(false);
         btneliminarfotomontaje.setEnabled(false);
         btnagregarfotomontaje.setEnabled(false);
         
         txtcodigocatalogobordados.setVisible(false);
         
    
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

    
    void combospuntadasprevias() 
      {
          
          
          
          
            DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo3 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo4 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo5 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo6 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo7 = new DefaultComboBoxModel();
            
             List<String> listabordados = new ArrayList<String>();
            

        try {
           

            String sql = "SELECT distinct descripcion, sum(precio) as precio2  FROM catalogo_articulos where descripcion not like  '%PARCHE%'  and ( descripcion like 'SEGURIDAD%' or descripcion like 'VIGILANCIA%'  OR descripcion like 'BANDERA DE%'  ) group by precio ORDER BY precio2";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {

                modelo1.addElement(rs.getObject("descripcion"));
                modelo2.addElement(rs.getObject("descripcion"));
                modelo3.addElement(rs.getObject("descripcion"));
                modelo4.addElement(rs.getObject("descripcion"));
                modelo5.addElement(rs.getObject("descripcion"));
                modelo6.addElement(rs.getObject("descripcion"));
                modelo7.addElement(rs.getObject("descripcion"));

            }
            
            
            
            
            // CAMISA

            if (prenda.equals("CAMISA") || prenda.equals("PLAYERA") || prenda.equals("CHAMARRA DESMONTABLE") || prenda.equals("CHAMARRA ROMPEVIENTOS") || prenda.equals("CAMISOLA") || prenda.equals("FILIPINA") || prenda.equals("SACO") || prenda.equals("CHALECO") || prenda.equals("MANDIL")) {

                // SE AGREGAN LOS LOGOS QUE YA TIENE EL CLIENTE
                // PECHOS
                sql = "SELECT distinct pecho_izquierdo_nombre,pecho_derecho_nombre FROM bordados_puntadas where codigo = '" + codigodelcliente + "' "
                        + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) {

                        String pechoizquierdo = rs2.getString("pecho_izquierdo_nombre");
                        String pechoderecho = rs2.getString("pecho_derecho_nombre");

                        if (pechoizquierdo.equals("") || pechoizquierdo.equals("SEGURIDAD") || pechoizquierdo.equals("SEGURIDAD ") || pechoizquierdo.equals("SEGURIDAD PRIVADA") || pechoizquierdo.equals("SEGURIDAD PRIVADA ") || pechoizquierdo.equals("VIGILANCIA") || pechoizquierdo.equals("ninguno")) {

                        } else {
                            
                            
                            //modelo1.addElement(pechoizquierdo);
                            //modelo2.addElement(pechoizquierdo);
                            listabordados.add(pechoizquierdo);
                            
                        }

                        if (pechoderecho.equals("") || pechoderecho.equals("SEGURIDAD") || pechoderecho.equals("SEGURIDAD ") || pechoderecho.equals("SEGURIDAD PRIVADA") || pechoderecho.equals("SEGURIDAD PRIVADA ") || pechoderecho.equals("VIGILANCIA") || pechoderecho.equals("ninguno")) {

                        } else {
                            //modelo1.addElement(pechoderecho);
                            //modelo2.addElement(pechoderecho);
                            listabordados.add(pechoderecho);
                            
                        }

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
                
              listabordados = listabordados.stream().distinct().collect(Collectors.toList());
                
              for(int i = 0; i < listabordados.size();i ++)
              {
               
               Object nombrebordado = listabordados.get(i);                  
               modelo1.addElement(nombrebordado);
               modelo2.addElement(nombrebordado);
                  
                  
              }
              

                cbbordados1.setModel(modelo1);
                AutoCompleteDecorator.decorate(cbbordados1);

                cbbordados2.setModel(modelo2);
                AutoCompleteDecorator.decorate(cbbordados2);
                
                listabordados.clear();
                

                // MAGAS
                sql = "SELECT distinct manga_izquierda_nombre,manga_derecha_nombre FROM bordados_puntadas where codigo = '" + codigodelcliente + "' "
                        + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) {

                        String mangaizquierda = rs2.getString("manga_izquierda_nombre");
                        String mangaderecha = rs2.getString("manga_derecha_nombre");

                        if (mangaizquierda.equals("") || mangaizquierda.equals("SEGURIDAD") || mangaizquierda.equals("SEGURIDAD ") || mangaizquierda.equals("SEGURIDAD PRIVADA") || mangaizquierda.equals("SEGURIDAD PRIVADA ") || mangaizquierda.equals("VIGILANCIA") || mangaizquierda.equals("ninguno")) {

                        } else {
                            //modelo3.addElement(mangaizquierda);
                            //modelo4.addElement(mangaizquierda);
                            listabordados.add(mangaizquierda);
                            
                        }

                        if (mangaderecha.equals("") || mangaderecha.equals("SEGURIDAD") || mangaderecha.equals("SEGURIDAD ") || mangaderecha.equals("SEGURIDAD PRIVADA") || mangaderecha.equals("SEGURIDAD PRIVADA ") || mangaderecha.equals("VIGILANCIA") || mangaderecha.equals("ninguno")) {

                        } else {
                            //modelo3.addElement(mangaderecha);
                            //modelo4.addElement(mangaderecha);
                            listabordados.add(mangaderecha);
                        }

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                
                listabordados = listabordados.stream().distinct().collect(Collectors.toList());
                
              for(int i = 0; i < listabordados.size();i ++)
              {
               
               Object nombrebordado = listabordados.get(i);                  
               modelo3.addElement(nombrebordado);
               modelo4.addElement(nombrebordado);
                  
                  
              }
                
                
                cbbordados3.setModel(modelo3);
                AutoCompleteDecorator.decorate(cbbordados3);

                cbbordados4.setModel(modelo4);
                AutoCompleteDecorator.decorate(cbbordados4);
                
                listabordados.clear();
                

                // ESPALDA
                sql = "SELECT distinct espalda_nombre FROM bordados_puntadas where codigo = '" + codigodelcliente + "' "
                        + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) {

                        String espalda = rs2.getString("espalda_nombre");

                        if (espalda.equals("") || espalda.equals("SEGURIDAD") || espalda.equals("SEGURIDAD ") || espalda.equals("SEGURIDAD PRIVADA") || espalda.equals("SEGURIDAD PRIVADA ") || espalda.equals("VIGILANCIA") || espalda.equals("ninguno") || espalda.equals("SEGURIDAD #1") || espalda.equals("SEGURIDAD #2") || espalda.equals("SEGURIDAD PRIVADA #1") || espalda.equals("SEGURIDAD PRIVADA #2") || espalda.equals("SEGURIDAD PRIVADA #3")) {

                        } else {
                           // modelo5.addElement(espalda);
                              listabordados.add(espalda);
                        }

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
                listabordados = listabordados.stream().distinct().collect(Collectors.toList());
                
              for(int i = 0; i < listabordados.size();i ++)
              {
               
               Object nombrebordado = listabordados.get(i);                  
               modelo3.addElement(nombrebordado);
               modelo4.addElement(nombrebordado);
               modelo5.addElement(nombrebordado);
               modelo6.addElement(nombrebordado);
               modelo7.addElement(nombrebordado);
                  
                  
              }

               

                cbbordados3.setModel(modelo3);
                AutoCompleteDecorator.decorate(cbbordados3);

                cbbordados4.setModel(modelo4);
                AutoCompleteDecorator.decorate(cbbordados4);

                cbbordados5.setModel(modelo5);
                AutoCompleteDecorator.decorate(cbbordados5);

                cbbordados6.setModel(modelo6);
                AutoCompleteDecorator.decorate(cbbordados6);

                cbbordados7.setModel(modelo7);
                AutoCompleteDecorator.decorate(cbbordados7);
                
                listabordados.clear();
                
                 /// COLORIDOS BORDADOS
                
                sql = "SELECT distinct identificador_prenda from colorido_bordados where codigo = '"+codigodelcliente+"' ";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) 
                    {
                        String puntadas = rs2.getString("identificador_prenda");
                        cbbordados1.addItem(puntadas);
                        cbbordados2.addItem(puntadas);
                        cbbordados3.addItem(puntadas);
                        cbbordados4.addItem(puntadas);
                        cbbordados5.addItem(puntadas);
                        cbbordados6.addItem(puntadas);
                        cbbordados7.addItem(puntadas);

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                 
                 
                

                // SE PONEN LAS PUNTADAS DE SEGURIDAD Y SEGURIDAD PRIVADA
                // 
                cbbordados1.addItem("SEGURIDAD");
                cbbordados1.addItem("SEGURIDAD PRIVADA");
                cbbordados1.addItem("VIGILANCIA");
                cbbordados1.addItem("PORTA NOMBRE");
                cbbordados1.addItem("ninguno");
                cbbordados1.setSelectedItem("ninguno");

                cbbordados2.addItem("SEGURIDAD");
                cbbordados2.addItem("SEGURIDAD PRIVADA");
                cbbordados2.addItem("VIGILANCIA");
                cbbordados2.addItem("PORTA NOMBRE");
                cbbordados2.addItem("ninguno");
                cbbordados2.setSelectedItem("ninguno");

                cbbordados3.addItem("SEGURIDAD");
                cbbordados3.addItem("SEGURIDAD PRIVADA");
                cbbordados3.addItem("VIGILANCIA");
                cbbordados3.addItem("ninguno");
                cbbordados3.setSelectedItem("ninguno");

                cbbordados4.addItem("SEGURIDAD");
                cbbordados4.addItem("SEGURIDAD PRIVADA");
                cbbordados4.addItem("VIGILANCIA");
                cbbordados4.addItem("ninguno");
                cbbordados4.setSelectedItem("ninguno");

                cbbordados5.addItem("SEGURIDAD #1");
                cbbordados5.addItem("SEGURIDAD #2");
                cbbordados5.addItem("SEGURIDAD PRIVADA #1");
                cbbordados5.addItem("SEGURIDAD PRIVADA #2");
                cbbordados5.addItem("SEGURIDAD PRIVADA #3");
                cbbordados5.addItem("ninguno");
                cbbordados5.setSelectedItem("ninguno");

                cbbordados6.addItem("ninguno");
                cbbordados6.setSelectedItem("ninguno");

                cbbordados7.addItem("ninguno");
                cbbordados7.setSelectedItem("ninguno");

            } 
            
            
            
            
            
            
            
            
            
            
            
            // GORRA
            
            
             else if (prenda.equals("GORRA")) 
            {

                // SE AGREGAN LOS LOGOS QUE YA TIENE EL CLIENTE
                // LADO DERECHO E IZQUEIRDO
                
                sql = "SELECT distinct lado_izquierdo_nombre,lado_derecho_nombre FROM bordados_puntadas where codigo = '" + codigodelcliente + "' and (tipo = 'GORRA')";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) {

                        String ladoizquierdo = rs2.getString("lado_izquierdo_nombre");
                        String ladoderecho = rs2.getString("lado_derecho_nombre");

                        if (ladoizquierdo.equals("") || ladoizquierdo.equals("SEGURIDAD") || ladoizquierdo.equals("SEGURIDAD ") || ladoizquierdo.equals("SEGURIDAD PRIVADA") || ladoizquierdo.equals("SEGURIDAD PRIVADA ") || ladoizquierdo.equals("VIGILANCIA") || ladoizquierdo.equals("ninguno")) {

                        } else {
                           // modelo1.addElement(ladoizquierdo);
                           // modelo2.addElement(ladoizquierdo);
                            listabordados.add(ladoizquierdo);
                        }

                        if (ladoderecho.equals("") || ladoderecho.equals("SEGURIDAD") || ladoderecho.equals("SEGURIDAD ") || ladoderecho.equals("SEGURIDAD PRIVADA") || ladoderecho.equals("SEGURIDAD PRIVADA ") || ladoderecho.equals("VIGILANCIA") || ladoderecho.equals("ninguno")) {

                        } else {
                            //modelo1.addElement(ladoderecho);
                            //modelo2.addElement(ladoderecho);
                            listabordados.add(ladoderecho);
                        }

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
                
               
                listabordados = listabordados.stream().distinct().collect(Collectors.toList());
                
              for(int i = 0; i < listabordados.size();i ++)
              {
               
               Object nombrebordado = listabordados.get(i);                  
               modelo1.addElement(nombrebordado);
               modelo2.addElement(nombrebordado);
                  
                  
              }
                

                cbbordados2.setModel(modelo1);
                AutoCompleteDecorator.decorate(cbbordados2);

                cbbordados4.setModel(modelo2);
                AutoCompleteDecorator.decorate(cbbordados4);
                
                 listabordados.clear();
                

                // frente y atras
                sql = "SELECT distinct frente_nombre,atras_nombre FROM bordados_puntadas where codigo = '" + codigodelcliente + "' and (tipo = 'GORRA')";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) {

                        String frente = rs2.getString("frente_nombre");
                        String atras = rs2.getString("atras_nombre");

                        if (frente.equals("") || frente.equals("SEGURIDAD") || frente.equals("SEGURIDAD ") || frente.equals("SEGURIDAD PRIVADA") || frente.equals("SEGURIDAD PRIVADA ") || frente.equals("VIGILANCIA") || frente.equals("ninguno")) {

                        } else {
                            //modelo3.addElement(frente);
                            //modelo4.addElement(frente);
                             listabordados.add(frente);
                        }

                        if (atras.equals("") || atras.equals("SEGURIDAD") || atras.equals("SEGURIDAD ") || atras.equals("SEGURIDAD PRIVADA") || atras.equals("SEGURIDAD PRIVADA ") || atras.equals("VIGILANCIA") || atras.equals("ninguno")) {

                        } else {
                            //modelo3.addElement(atras);
                            //modelo4.addElement(atras);
                             listabordados.add(atras);
                            
                        }

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                 listabordados = listabordados.stream().distinct().collect(Collectors.toList());
                
              for(int i = 0; i < listabordados.size();i ++)
              {
               
               Object nombrebordado = listabordados.get(i);                  
               modelo3.addElement(nombrebordado);
               modelo4.addElement(nombrebordado);
                  
                  
              }
                
                
                cbbordados1.setModel(modelo3);
                AutoCompleteDecorator.decorate(cbbordados1);

                cbbordados3.setModel(modelo4);
                AutoCompleteDecorator.decorate(cbbordados3);

               
                listabordados.clear();
              
                
                cbbordados1.setModel(modelo3);
                AutoCompleteDecorator.decorate(cbbordados1);
                cbbordados1.addItem("ninguno");
                cbbordados1.setSelectedItem("ninguno");

                cbbordados2.setModel(modelo1);
                AutoCompleteDecorator.decorate(cbbordados2);
                cbbordados2.addItem("ninguno");
                cbbordados2.setSelectedItem("ninguno");

                cbbordados3.setModel(modelo4);
                AutoCompleteDecorator.decorate(cbbordados3);
                cbbordados3.addItem("ninguno");
                cbbordados3.setSelectedItem("ninguno");

                cbbordados4.setModel(modelo2);
                AutoCompleteDecorator.decorate(cbbordados4);
                cbbordados4.addItem("ninguno");
                cbbordados4.setSelectedItem("ninguno");

                
                
                 /// COLORIDOS BORDADOS
                
                
                 sql = "SELECT distinct identificador_prenda from colorido_bordados where codigo = '"+codigodelcliente+"' ";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) 
                    {
                        String puntadas = rs2.getString("identificador_prenda");
                        cbbordados1.addItem(puntadas);
                        cbbordados2.addItem(puntadas);
                        cbbordados3.addItem(puntadas);
                        cbbordados4.addItem(puntadas);
                       

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
                
                

            }
             
             
             
             
             
             
             
             
             
            // PANTALON
            
            
             else if (prenda.equals("PANTALON")) 
            {

                // SE AGREGAN LOS LOGOS QUE YA TIENE EL CLIENTE
                // LADO DERECHO E IZQUEIRDO
                
                sql = "SELECT distinct pantalon_lado_izquierdo_frente_nombre,pantalon_lado_derecho_frente_nombre,pantalon_lado_izquierdo_atras_nombre,pantalon_lado_derecho_atras_nombre FROM bordados_puntadas where codigo = '" + codigodelcliente + "' and (tipo = 'PANTALON')";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) {

                        String ladoizquierdofrente = rs2.getString("pantalon_lado_izquierdo_frente_nombre");
                        String ladoderechofrente = rs2.getString("pantalon_lado_derecho_frente_nombre");
                        String ladoizquierdoatras = rs2.getString("pantalon_lado_izquierdo_atras_nombre");
                        String ladoderechoatras = rs2.getString("pantalon_lado_derecho_atras_nombre");
                        

                        if (ladoizquierdofrente.equals("") || ladoizquierdofrente.equals("SEGURIDAD") || ladoizquierdofrente.equals("SEGURIDAD ") || ladoizquierdofrente.equals("SEGURIDAD PRIVADA") || ladoizquierdofrente.equals("SEGURIDAD PRIVADA ") || ladoizquierdofrente.equals("VIGILANCIA") || ladoizquierdofrente.equals("ninguno")) {

                        } else {
                       
                            listabordados.add(ladoizquierdofrente);
                        }

                        if (ladoderechofrente.equals("") || ladoderechofrente.equals("SEGURIDAD") || ladoderechofrente.equals("SEGURIDAD ") || ladoderechofrente.equals("SEGURIDAD PRIVADA") || ladoderechofrente.equals("SEGURIDAD PRIVADA ") || ladoderechofrente.equals("VIGILANCIA") || ladoderechofrente.equals("ninguno")) {

                        } else {
                   
                            listabordados.add(ladoderechofrente);
                        }

                        
                        if (ladoizquierdoatras.equals("") || ladoizquierdoatras.equals("SEGURIDAD") || ladoizquierdoatras.equals("SEGURIDAD ") || ladoizquierdoatras.equals("SEGURIDAD PRIVADA") || ladoizquierdoatras.equals("SEGURIDAD PRIVADA ") || ladoizquierdoatras.equals("VIGILANCIA") || ladoizquierdoatras.equals("ninguno")) {

                        } else {
                         
                            listabordados.add(ladoizquierdoatras);
                        }
                        
                        
                        
                        if (ladoderechoatras.equals("") || ladoderechoatras.equals("SEGURIDAD") || ladoderechoatras.equals("SEGURIDAD ") || ladoderechoatras.equals("SEGURIDAD PRIVADA") || ladoderechoatras.equals("SEGURIDAD PRIVADA ") || ladoderechoatras.equals("VIGILANCIA") || ladoderechoatras.equals("ninguno")) {

                        } else {
                           
                            listabordados.add(ladoderechoatras);
                        }
                        
                        
                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
                
               
                listabordados = listabordados.stream().distinct().collect(Collectors.toList());
                
              for(int i = 0; i < listabordados.size();i ++)
              {
               
               Object nombrebordado = listabordados.get(i);                  
               modelo1.addElement(nombrebordado);
               modelo2.addElement(nombrebordado);
               modelo3.addElement(nombrebordado);
               modelo4.addElement(nombrebordado);
                  
                  
              }
                

                
                
                 
                
                cbbordados1.setModel(modelo1);
                AutoCompleteDecorator.decorate(cbbordados1);
                cbbordados1.addItem("ninguno");
                cbbordados1.setSelectedItem("ninguno");

                cbbordados2.setModel(modelo2);
                AutoCompleteDecorator.decorate(cbbordados2);
                cbbordados2.addItem("ninguno");
                cbbordados2.setSelectedItem("ninguno");

                cbbordados3.setModel(modelo3);
                AutoCompleteDecorator.decorate(cbbordados3);
                cbbordados3.addItem("ninguno");
                cbbordados3.setSelectedItem("ninguno");

                cbbordados4.setModel(modelo4);
                AutoCompleteDecorator.decorate(cbbordados4);
                cbbordados4.addItem("ninguno");
                cbbordados4.setSelectedItem("ninguno");

                
                
                 listabordados.clear();
                 
                 
                 
                 
                
                 /// COLORIDOS BORDADOS
                
                
                 sql = "SELECT distinct identificador_prenda from colorido_bordados where codigo = '"+codigodelcliente+"' ";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) 
                    {
                        String puntadas = rs2.getString("identificador_prenda");
                        cbbordados1.addItem(puntadas);
                        cbbordados2.addItem(puntadas);
                        cbbordados3.addItem(puntadas);
                        cbbordados4.addItem(puntadas);
                       

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
                
                

            }
             // CORBATA
             else if (prenda.equals("CORBATA")) 
            {

                // SE AGREGAN LOS LOGOS QUE YA TIENE EL CLIENTE
                // LADO DERECHO E IZQUEIRDO
                
                sql = "SELECT distinct corbata_frente,corbata_frente_nombre FROM bordados_puntadas where codigo = '" + codigodelcliente + "' and (tipo = 'CORBATA')";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) {

                        String frentenombre = rs2.getString("corbata_frente_nombre");
                       
                        

                        if (frentenombre.equals("") || frentenombre.equals("SEGURIDAD") || frentenombre.equals("SEGURIDAD ") || frentenombre.equals("SEGURIDAD PRIVADA") || frentenombre.equals("SEGURIDAD PRIVADA ") || frentenombre.equals("VIGILANCIA") || frentenombre.equals("ninguno")) {

                        } 
                        else
                        {
                       
                            listabordados.add(frentenombre);
                        }

                       
                        
                        
                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
                
               
                listabordados = listabordados.stream().distinct().collect(Collectors.toList());
                
              for(int i = 0; i < listabordados.size();i ++)
              {
               
               Object nombrebordado = listabordados.get(i);                  
               modelo1.addElement(nombrebordado);
               
                  
                  
              }
                

                
                
                 
                
                cbbordados1.setModel(modelo1);
                AutoCompleteDecorator.decorate(cbbordados1);
                cbbordados1.addItem("ninguno");
                cbbordados1.setSelectedItem("ninguno");

      
                
                 listabordados.clear();
                 
                 
                 
                 
                
                 /// COLORIDOS BORDADOS
                
                
                 sql = "SELECT distinct identificador_prenda from colorido_bordados where codigo = '"+codigodelcliente+"' ";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) 
                    {
                        String puntadas = rs2.getString("identificador_prenda");
                        cbbordados1.addItem(puntadas);
                        cbbordados2.addItem(puntadas);
                        cbbordados3.addItem(puntadas);
                        cbbordados4.addItem(puntadas);
                       

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
                
                                

            }
              
             
             
             
             
             
             

            
            else {

                cbbordados1.setModel(modelo1);
                AutoCompleteDecorator.decorate(cbbordados1);
                cbbordados1.addItem("ninguno");
                cbbordados1.setSelectedItem("ninguno");

                cbbordados2.setModel(modelo2);
                AutoCompleteDecorator.decorate(cbbordados2);
                cbbordados2.addItem("ninguno");
                cbbordados2.setSelectedItem("ninguno");

                cbbordados3.setModel(modelo3);
                AutoCompleteDecorator.decorate(cbbordados3);
                cbbordados3.addItem("ninguno");
                cbbordados3.setSelectedItem("ninguno");

                cbbordados4.setModel(modelo4);
                AutoCompleteDecorator.decorate(cbbordados4);
                cbbordados4.addItem("ninguno");
                cbbordados4.setSelectedItem("ninguno");

                cbbordados5.setModel(modelo5);
                AutoCompleteDecorator.decorate(cbbordados5);
                cbbordados5.addItem("ninguno");
                cbbordados5.setSelectedItem("ninguno");

                cbbordados6.setModel(modelo6);
                AutoCompleteDecorator.decorate(cbbordados6);
                cbbordados6.addItem("ninguno");
                cbbordados6.setSelectedItem("ninguno");

                cbbordados7.setModel(modelo7);
                AutoCompleteDecorator.decorate(cbbordados7);
                cbbordados7.addItem("ninguno");
                cbbordados7.setSelectedItem("ninguno");

            }

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    } 
    
    
   
    
    
    void combospuntadas() {

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
            
            cbpuntadas3.setModel(modelo2);
            AutoCompleteDecorator.decorate(cbpuntadas3);
            cbpuntadas3.addItem("ninguno");
            cbpuntadas3.setSelectedItem("ninguno");

            cbpuntadas4.setModel(modelo3);
            AutoCompleteDecorator.decorate(cbpuntadas4);
            cbpuntadas4.addItem("ninguno");
            cbpuntadas4.setSelectedItem("ninguno");

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
            
            cbhilo3.setModel(modelo2);
            AutoCompleteDecorator.decorate(cbhilo3);
            cbhilo3.addItem("0");
            cbhilo3.setSelectedItem("0");

            cbhilo4.setModel(modelo3);
            AutoCompleteDecorator.decorate(cbhilo4);
            cbhilo4.addItem("0");
            cbhilo4.setSelectedItem("0");
  

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
            
            cbcolor3.setModel(modelo2);
            AutoCompleteDecorator.decorate(cbcolor3);
            cbcolor3.addItem("ninguno");
            cbcolor3.setSelectedItem("ninguno");

            cbcolor4.setModel(modelo3);
            AutoCompleteDecorator.decorate(cbcolor4);
            cbcolor4.addItem("ninguno");
            cbcolor4.setSelectedItem("ninguno");

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
    
    
    

    void datos() {
       
        
        codigodelcliente = lbcodigocliente.getText();
        identificadordeprenda = txtidentificadordeprenda.getText().trim();
        consecutivo = lbconsecutivo.getText();
        
        prenda = lbprenda.getText();
        
        
        combospuntadas();
        combocolor();
        combohilo();
        agregarcoloresaloscombos();
        String sql = "";
        String lbtipostring = lbprenda.getText();
        
       
        
        
        
        
        
        
        
        
        
        ///CAMISA
        if (prenda.equals("CAMISA")||prenda.equals("PLAYERA")||prenda.equals("CHAMARRA DESMONTABLE")||prenda.equals("CHAMARRA ROMPEVIENTOS")||prenda.equals("CAMISOLA")||prenda.equals("FILIPINA")||prenda.equals("SACO")||prenda.equals("CHALECO")   ||prenda.equals("MANDIL")) 
        
        {

            

                sql = "SELECT identificador_prenda,pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo_aplicacion,pecho_izquierdo_aplicacion_color,"
                        + "pecho_derecho,pecho_derecho_nombre,pecho_derecho_aplicacion,pecho_derecho_aplicacion_color,"
                        + "manga_derecha,manga_derecha_nombre,manga_derecha_aplicacion,manga_derecha_aplicacion_color,"
                        + "manga_izquierda,manga_izquierda_nombre,manga_izquierda_aplicacion,manga_izquierda_aplicacion_color,"
                        + "espalda,espalda_nombre,espalda_aplicacion,espalda_aplicacion_color,espalda_puntadas_aro,espalda_aro,"
                        + "otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion_aplicacion,otra_ubicacion_aplicacion_color,"
                        + "otra_ubicacion2,otra_ubicacion2_nombre,otra_ubicacion2_aplicacion,otra_ubicacion2_aplicacion_color,"
                        + "color1,color2,color3,color4,color5,color6,color7,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7 "
                        + " FROM bordados_puntadas where identificador_prenda = '"+identificadordeprenda+"'  and codigo = '"+codigodelcliente+"' AND tipo = '"+lbtipostring+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'"; 
            

        
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                        identificadordeprenda = rs.getString("identificador_prenda");
                        pechoizquierdo = rs.getString("pecho_izquierdo");
                        pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre");
                        pechoizquierdoaplicacion = rs.getString("pecho_izquierdo_aplicacion");
                        pechoizquierdoaplicacioncolor = rs.getString("pecho_izquierdo_aplicacion_color");

                        pechoderecho = rs.getString("pecho_derecho");
                        pechoderechonombre = rs.getString("pecho_derecho_nombre");
                        pechoderechoaplicacion = rs.getString("pecho_derecho_aplicacion");
                        pechoderechoaplicacioncolor = rs.getString("pecho_derecho_aplicacion_color");

                        mangaizquierda = rs.getString("manga_izquierda");
                        mangaizquierdanombre = rs.getString("manga_izquierda_nombre");
                        mangaizquierdaaplicacion = rs.getString("manga_izquierda_aplicacion");
                        mangaizquierdaaplicacioncolor = rs.getString("manga_izquierda_aplicacion_color");

                        mangaderecha = rs.getString("manga_derecha");
                        mangaderechanombre = rs.getString("manga_derecha_nombre");
                        mangaderechaaplicacion = rs.getString("manga_derecha_aplicacion");
                        mangaderechaaplicacioncolor = rs.getString("manga_derecha_aplicacion_color");

                        espalda = rs.getString("espalda");
                        espaldanombre = rs.getString("espalda_nombre");
                        espaldaaplicacion = rs.getString("espalda_aplicacion");
                        espaldaaplicacioncolor = rs.getString("espalda_aplicacion_color");
                        
                        espaldapuntadasaro = rs.getString("espalda_puntadas_aro");
                        espaldaaro = rs.getString("espalda_aro");
                        
                      
                        otraubicacion = rs.getString("otra_ubicacion");
                        otraubicacionnombre = rs.getString("otra_ubicacion_nombre");
                        otraubicacionaplicacion = rs.getString("otra_ubicacion_aplicacion");
                        otraubicacionaplicacioncolor = rs.getString("otra_ubicacion_aplicacion_color");
                    
                        otraubicacion2 = rs.getString("otra_ubicacion2");
                        otraubicacion2nombre = rs.getString("otra_ubicacion2_nombre");
                        otraubicacion2aplicacion = rs.getString("otra_ubicacion2_aplicacion");
                        otraubicacion2aplicacioncolor = rs.getString("otra_ubicacion2_aplicacion_color");
                        
                         
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
                        
                        
                        txtidentificadordeprenda.setText(identificadordeprenda);
                       lbidentificadordeprendaanterior.setText(identificadordeprenda);
                        cbpuntadas1.setSelectedItem(pechoizquierdo);
            txt1.setText(pechoizquierdonombre);
            cbaplicacioncantidad1.setSelectedItem(pechoizquierdoaplicacion);
            cbaplicacioncolor1.setSelectedItem(pechoizquierdoaplicacioncolor);

            cbpuntadas2.setSelectedItem(pechoderecho);
            txt2.setText(pechoderechonombre);
            cbaplicacioncantidad2.setSelectedItem(pechoderechoaplicacion);
            cbaplicacioncolor2.setSelectedItem(pechoderechoaplicacioncolor);

            cbpuntadas4.setSelectedItem(mangaderecha);
            txt4.setText(mangaderechanombre);
            cbaplicacioncantidad4.setSelectedItem(mangaderechaaplicacion);
            cbaplicacioncolor4.setSelectedItem(mangaderechaaplicacioncolor);

            cbpuntadas3.setSelectedItem(mangaizquierda);
            txt3.setText(mangaizquierdanombre);
            cbaplicacioncantidad3.setSelectedItem(mangaizquierdaaplicacion);
            cbaplicacioncolor3.setSelectedItem(mangaizquierdaaplicacioncolor);

            cbpuntadas5.setSelectedItem(espalda);
            txt5.setText(espaldanombre);
            cbaplicacioncantidad5.setSelectedItem(espaldaaplicacion);
            cbaplicacioncolor5.setSelectedItem(espaldaaplicacioncolor);
            
            lbpuntadas5.setText(espaldapuntadasaro); 
            cbaroespalda.setSelectedItem(espaldaaro);        
            
            
            if (lbtipostring.startsWith("CHAMARRA DESMONTABLE"))
            {
             lbpuntadas5.setText(espalda);
             cbaroespalda.setSelectedItem("no");     
                
            }
            
            
            
            
            cbpuntadas6.setSelectedItem(otraubicacion);
            txt6.setText(otraubicacionnombre);
            cbaplicacioncantidad6.setSelectedItem(otraubicacionaplicacion);
            cbaplicacioncolor6.setSelectedItem(otraubicacionaplicacioncolor);
                
            cbpuntadas7.setSelectedItem(otraubicacion2);
            txt7.setText(otraubicacion2nombre);
            cbaplicacioncantidad7.setSelectedItem(otraubicacion2aplicacion);
            cbaplicacioncolor7.setSelectedItem(otraubicacion2aplicacioncolor);
                
            actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            
            

           

        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //CHALECO
        
        if (prenda.equals("CHALECO")) 
        
        {


                sql = "SELECT identificador_prenda,pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo_aplicacion,pecho_izquierdo_aplicacion_color,"
                        + "pecho_derecho,pecho_derecho_nombre,pecho_derecho_aplicacion,pecho_derecho_aplicacion_color,"
                        + "manga_derecha,manga_derecha_nombre,manga_derecha_aplicacion,manga_derecha_aplicacion_color,"
                        + "manga_izquierda,manga_izquierda_nombre,manga_izquierda_aplicacion,manga_izquierda_aplicacion_color,"
                        + "espalda,espalda_nombre,espalda_aplicacion,espalda_aplicacion_color,"
                        + "otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion_aplicacion,otra_ubicacion_aplicacion_color,"
                        + "otra_ubicacion2,otra_ubicacion2_nombre,otra_ubicacion2_aplicacion,otra_ubicacion2_aplicacion_color,"
                        + "color1,color2,color3,hilo1,hilo2,hilo3 "
                        + "FROM bordados_puntadas where identificador_prenda = '"+identificadordeprenda+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' and codigo = '"+codigodelcliente+"' AND tipo = '"+lbtipostring+"' ";


            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                        identificadordeprenda = rs.getString("identificador_prenda");
                        pechoizquierdo = rs.getString("pecho_izquierdo");
                        pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre");
                        pechoizquierdoaplicacion = rs.getString("pecho_izquierdo_aplicacion");
                        pechoizquierdoaplicacioncolor = rs.getString("pecho_izquierdo_aplicacion_color");

                        pechoderecho = rs.getString("pecho_derecho");
                        pechoderechonombre = rs.getString("pecho_derecho_nombre");
                        pechoderechoaplicacion = rs.getString("pecho_derecho_aplicacion");
                        pechoderechoaplicacioncolor = rs.getString("pecho_derecho_aplicacion_color");

                        espalda = rs.getString("espalda");
                        espaldanombre = rs.getString("espalda_nombre");
                        espaldaaplicacion = rs.getString("espalda_aplicacion");
                        espaldaaplicacioncolor = rs.getString("espalda_aplicacion_color");

                        otraubicacion = rs.getString("otra_ubicacion");
                        otraubicacionnombre = rs.getString("otra_ubicacion_nombre");
                        otraubicacionaplicacion = rs.getString("otra_ubicacion_aplicacion");
                        otraubicacionaplicacioncolor = rs.getString("otra_ubicacion_aplicacion_color");
                    
                        otraubicacion2 = rs.getString("otra_ubicacion2");
                        otraubicacion2nombre = rs.getString("otra_ubicacion2_nombre");
                        otraubicacion2aplicacion = rs.getString("otra_ubicacion2_aplicacion");
                        otraubicacion2aplicacioncolor = rs.getString("otra_ubicacion2_aplicacion_color");
                       
                        cbcolor1.setSelectedItem(rs.getString("color1"));
                        cbcolor2.setSelectedItem(rs.getString("color2"));
                        cbcolor3.setSelectedItem(rs.getString("color3"));
                        
                        
                        cbhilo1.setSelectedItem(rs.getString("hilo1"));
                        cbhilo2.setSelectedItem(rs.getString("hilo2"));
                        cbhilo3.setSelectedItem(rs.getString("hilo3"));
                      
                        
                        
                        txtidentificadordeprenda.setText(identificadordeprenda);
                        lbidentificadordeprendaanterior.setText(identificadordeprenda);
                    
                        
            cbpuntadas1.setSelectedItem(pechoizquierdo);
            txt1.setText(pechoizquierdonombre);
            cbaplicacioncantidad1.setSelectedItem(pechoizquierdoaplicacion);
            cbaplicacioncolor1.setSelectedItem(pechoizquierdoaplicacioncolor);

            cbpuntadas2.setSelectedItem(pechoderecho);
            txt2.setText(pechoderechonombre);
            cbaplicacioncantidad2.setSelectedItem(pechoderechoaplicacion);
            cbaplicacioncolor2.setSelectedItem(pechoderechoaplicacioncolor);

            lbetiqueta3.setText("otra_ubicacion");
            cbpuntadas3.setSelectedItem(otraubicacion);
            txt3.setText(otraubicacionnombre);
            cbaplicacioncantidad3.setSelectedItem(otraubicacionaplicacion);
            cbaplicacioncolor3.setSelectedItem(otraubicacionaplicacioncolor);
            
            lbetiqueta4.setText("Espalda");
            cbpuntadas4.setSelectedItem(espalda);
            txt4.setText(espaldanombre);
            cbaplicacioncantidad4.setSelectedItem(espaldaaplicacion);
            cbaplicacioncolor4.setSelectedItem(espaldaaplicacioncolor);
            
            
            lbetiqueta5.setText("otra_ubicacion2");
            cbpuntadas5.setSelectedItem(otraubicacion2);
            txt5.setText(otraubicacion2nombre);
            cbaplicacioncantidad5.setSelectedItem(otraubicacion2aplicacion);
            cbaplicacioncolor5.setSelectedItem(otraubicacion2aplicacioncolor);
            
            cbpuntadas6.setSelectedItem(otraubicacion);
            txt6.setText(otraubicacionnombre);
            cbaplicacioncantidad6.setSelectedItem(otraubicacionaplicacion);
            cbaplicacioncolor6.setSelectedItem(otraubicacionaplicacioncolor);
                
            cbpuntadas7.setSelectedItem(otraubicacion2);
            txt7.setText(otraubicacion2nombre);
            cbaplicacioncantidad7.setSelectedItem(otraubicacion2aplicacion);
            cbaplicacioncolor7.setSelectedItem(otraubicacion2aplicacioncolor);
            
            
             lbetiqueta6.setText("");
            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);
            cbaplicacioncantidad6.setEnabled(false);
            cbaplicacioncolor6.setEnabled(false);

            lbetiqueta7.setText("");
            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);
            cbaplicacioncantidad7.setEnabled(false);
            cbaplicacioncolor7.setEnabled(false);
                
            actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            
            
           

        }
        
        
        else 
            
            
            
            
            
            
            
            
            
            
            
            
        //MANDIL
        
        if (prenda.equals("MANDIL")) 
        
        {


                sql = "SELECT identificador_prenda,pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo_aplicacion,pecho_izquierdo_aplicacion_color,"
                        + "pecho_derecho,pecho_derecho_nombre,pecho_derecho_aplicacion,pecho_derecho_aplicacion_color,"
                        + "centro,centro_nombre,centro_aplicacion,centro_aplicacion_color,"
                         + "otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion_aplicacion,otra_ubicacion_aplicacion_color,"
                        + "otra_ubicacion2,otra_ubicacion2_nombre,otra_ubicacion2_aplicacion,otra_ubicacion2_aplicacion_color,"
                        + "color1,color2,color3,hilo1,hilo2,hilo3 "
                        + "FROM bordados_puntadas where identificador_prenda = '"+identificadordeprenda+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' and codigo = '"+codigodelcliente+"' AND tipo = '"+lbtipostring+"' ";


            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                        identificadordeprenda = rs.getString("identificador_prenda");
                        pechoizquierdo = rs.getString("pecho_izquierdo");
                        pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre");
                        pechoizquierdoaplicacion = rs.getString("pecho_izquierdo_aplicacion");
                        pechoizquierdoaplicacioncolor = rs.getString("pecho_izquierdo_aplicacion_color");

                        pechoderecho = rs.getString("pecho_derecho");
                        pechoderechonombre = rs.getString("pecho_derecho_nombre");
                        pechoderechoaplicacion = rs.getString("pecho_derecho_aplicacion");
                        pechoderechoaplicacioncolor = rs.getString("pecho_derecho_aplicacion_color");

                        centro = rs.getString("centro");
                        centronombre = rs.getString("centro_nombre");
                        centroaplicacion = rs.getString("centro_aplicacion");
                        centroaplicacioncolor = rs.getString("centro_aplicacion_color");

                  
                        cbcolor1.setSelectedItem(rs.getString("color1"));
                        cbcolor2.setSelectedItem(rs.getString("color2"));
                        cbcolor3.setSelectedItem(rs.getString("color3"));
                        
                        
                        cbhilo1.setSelectedItem(rs.getString("hilo1"));
                        cbhilo2.setSelectedItem(rs.getString("hilo2"));
                        cbhilo3.setSelectedItem(rs.getString("hilo3"));
                      
                        
                        
           txtidentificadordeprenda.setText(identificadordeprenda);
           lbidentificadordeprendaanterior.setText(identificadordeprenda);
           cbpuntadas1.setSelectedItem(pechoizquierdo);
                        
            txt1.setText(pechoizquierdonombre);
            cbaplicacioncantidad1.setSelectedItem(pechoizquierdoaplicacion);
            cbaplicacioncolor1.setSelectedItem(pechoizquierdoaplicacioncolor);

            cbpuntadas2.setSelectedItem(pechoderecho);
            txt2.setText(pechoderechonombre);
            cbaplicacioncantidad2.setSelectedItem(pechoderechoaplicacion);
            cbaplicacioncolor2.setSelectedItem(pechoderechoaplicacioncolor);

         
            cbpuntadas3.setSelectedItem(centro);
            txt3.setText(centronombre);
            cbaplicacioncantidad3.setSelectedItem(centroaplicacion);
            cbaplicacioncolor3.setSelectedItem(centroaplicacioncolor);
            
           
                
            actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            cbpuntadas1.setSelectedItem(pechoizquierdo);
            txt1.setText(pechoizquierdonombre);
            cbaplicacioncantidad1.setSelectedItem(pechoizquierdoaplicacion);
            cbaplicacioncolor1.setSelectedItem(pechoizquierdoaplicacioncolor);

            cbpuntadas2.setSelectedItem(pechoderecho);
            txt2.setText(pechoderechonombre);
            cbaplicacioncantidad2.setSelectedItem(pechoderechoaplicacion);
            cbaplicacioncolor2.setSelectedItem(pechoderechoaplicacioncolor);
         
            lbetiqueta3.setText("Centro");
            cbpuntadas3.setSelectedItem(centro);
            txt3.setText(centronombre);
            cbaplicacioncantidad3.setSelectedItem(centroaplicacion);
            cbaplicacioncolor3.setSelectedItem(centroaplicacioncolor);
           
            lbetiqueta4.setText("otra_ubicacion");
            cbpuntadas4.setSelectedItem(otraubicacion);
            txt4.setText(otraubicacionnombre);
            cbaplicacioncantidad4.setSelectedItem(otraubicacionaplicacion);
            cbaplicacioncolor4.setSelectedItem(otraubicacionaplicacioncolor);

            lbetiqueta5.setText("otra_ubicacion2");
            cbpuntadas5.setSelectedItem(otraubicacion2);
            txt5.setText(otraubicacion2nombre);
            cbaplicacioncantidad5.setSelectedItem(otraubicacion2aplicacion);
            cbaplicacioncolor5.setSelectedItem(otraubicacion2aplicacioncolor);

            lbetiqueta6.setText("");
            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);
            cbaplicacioncantidad6.setEnabled(false);
            cbaplicacioncolor6.setEnabled(false);

            lbetiqueta7.setText("");
            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);
            cbaplicacioncantidad7.setEnabled(false);
            cbaplicacioncolor7.setEnabled(false);
            

           

        }
        
        
        else 
            
            
            
            
            
            
            
            
            
            
            
            
            //GORRA
            if (prenda.equals("GORRA"))
        
        
        
        {
            
                sql = "SELECT identificador_prenda,frente,frente_nombre,frente_aplicacion,frente_aplicacion_color,"
                        + "lado_izquierdo,lado_izquierdo_nombre,"
                        + "lado_derecho,lado_derecho_nombre,"
                        + "atras,atras_nombre,"
                        + "color1,color2,color3,color4,hilo1,hilo2,hilo3,hilo4 "
                        + " FROM bordados_puntadas where identificador_prenda = '"+identificadordeprenda+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' and codigo = '"+codigodelcliente+"' AND tipo = '"+lbtipostring+"' ";

            
            

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) 
                {

                        
                        identificadordeprenda = rs.getString("identificador_prenda");
                        lbidentificadordeprendaanterior.setText(identificadordeprenda);
                        frentegorra = rs.getString("frente");
                        frentegorranombre = rs.getString("frente_nombre");
                        frentegorraaplicacion = rs.getString("frente_aplicacion");
                        frentegorraaplicacioncolor = rs.getString("frente_aplicacion_color");

                        ladoizquierdogorra = rs.getString("lado_izquierdo");
                        ladoizquierdogorranombre = rs.getString("lado_izquierdo_nombre");

                        ladoderechogorra = rs.getString("lado_derecho");
                        ladoderechogorranombre = rs.getString("lado_derecho_nombre");

                        atrasgorra = rs.getString("atras");
                        atrasgorranombre = rs.getString("atras_nombre");

                         
                         cbcolor1.setSelectedItem(rs.getString("color1"));
                        cbcolor2.setSelectedItem(rs.getString("color2"));
                        cbcolor3.setSelectedItem(rs.getString("color3"));
                        cbcolor4.setSelectedItem(rs.getString("color4"));
                      
                        
                        cbhilo1.setSelectedItem(rs.getString("hilo1"));
                        cbhilo2.setSelectedItem(rs.getString("hilo2"));
                        cbhilo3.setSelectedItem(rs.getString("hilo3"));
                        cbhilo4.setSelectedItem(rs.getString("hilo4"));
                       
                        

                        actualizarbordado = "si";
                  

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            lbetiqueta1.setText("Frente Gorra");
            lbetiqueta2.setText("Lado izquierdo Gorra");
            lbetiqueta4.setText("Lado derecho Gorra");
            lbetiqueta3.setText("Atras Gorra");
            lbetiqueta5.setText("");
            lbetiqueta6.setText("");
            lbetiqueta7.setText("");

            cbaplicacioncantidad2.setEnabled(false);
            cbaplicacioncolor2.setEnabled(false);
            cbaplicacioncantidad4.setEnabled(false);
            cbaplicacioncolor4.setEnabled(false);
            cbaplicacioncantidad3.setEnabled(false);
            cbaplicacioncolor3.setEnabled(false);

            lbpuntadas5.setEnabled(false);
            txt5.setEnabled(false);
            cbaplicacioncantidad5.setEnabled(false);
            cbaplicacioncolor5.setEnabled(false);

            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);
            cbaplicacioncantidad6.setEnabled(false);
            cbaplicacioncolor6.setEnabled(false);

            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);
            cbaplicacioncantidad7.setEnabled(false);
            cbaplicacioncolor7.setEnabled(false);
            
            
            cbpuntadas1.setSelectedItem(frentegorra);
            txt1.setText(frentegorranombre);
            cbaplicacioncantidad1.setSelectedItem(frentegorraaplicacion);
            cbaplicacioncolor1.setSelectedItem(frentegorraaplicacioncolor);

            cbpuntadas2.setSelectedItem(ladoizquierdogorra);
            txt2.setText(ladoizquierdogorranombre);
            

            cbpuntadas4.setSelectedItem(ladoderechogorra);
            txt4.setText(ladoderechogorranombre);
            

            cbpuntadas3.setSelectedItem(atrasgorra);
            txt3.setText(atrasgorranombre);
           
            
            

        } 
            
            
            
            
            
            
            
                 //PARCHE
            if (prenda.equals("PARCHE"))
        
        
        
        {
            
                sql = "SELECT identificador_prenda,parche,parche_nombre,parche_aplicacion,parche_aplicacion_color,numero_consecutivo,"
                        + "color1,hilo1"
                        + " FROM bordados_puntadas where identificador_prenda = '"+identificadordeprenda+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' and codigo = '"+codigodelcliente+"' AND tipo = '"+lbtipostring+"' ";

            
            

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) 
                {

                        
                        identificadordeprenda = rs.getString("identificador_prenda");
                        lbidentificadordeprendaanterior.setText(identificadordeprenda);
                        
                        parche = rs.getString("parche");
                        parchenombre = rs.getString("parche_nombre");
                        parcheaplicacion = rs.getString("parche_aplicacion");
                        parcheaplicacioncolor = rs.getString("parche_aplicacion_color");

                        lbconsecutivo.setText(rs.getString("numero_consecutivo"));
                        
                        
                         cbcolor1.setSelectedItem(rs.getString("color1"));
                    
                        
                        cbhilo1.setSelectedItem(rs.getString("hilo1"));
                    

                        actualizarbordado = "si";
                  

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            lbetiqueta1.setText("Parche");
           
            lbetiqueta2.setText("");
            lbetiqueta3.setText("");
            lbetiqueta4.setText("");
            lbetiqueta5.setText("");
            lbetiqueta6.setText("");
            lbetiqueta7.setText("");
            
            
            cbpuntadas1.setSelectedItem(parche);
            txt1.setText(parchenombre);
            cbaplicacioncantidad1.setSelectedItem(parcheaplicacion);
            cbaplicacioncolor1.setSelectedItem(parcheaplicacioncolor);
            
            cbpuntadas2.setEnabled(false);
            txt2.setEnabled(false);
            cbaplicacioncantidad2.setEnabled(false);
            cbaplicacioncolor2.setEnabled(false);
                        
            cbpuntadas3.setEnabled(false);
            txt3.setEnabled(false);
            cbaplicacioncantidad3.setEnabled(false);
            cbaplicacioncolor3.setEnabled(false);
            
            cbpuntadas4.setEnabled(false);
            txt4.setEnabled(false);
            cbaplicacioncantidad4.setEnabled(false);
            cbaplicacioncolor4.setEnabled(false);
           
            lbpuntadas5.setEnabled(false);
            txt5.setEnabled(false);
            cbaplicacioncantidad5.setEnabled(false);
            cbaplicacioncolor5.setEnabled(false);

            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);
            cbaplicacioncantidad6.setEnabled(false);
            cbaplicacioncolor6.setEnabled(false);

            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);
            cbaplicacioncantidad7.setEnabled(false);
            cbaplicacioncolor7.setEnabled(false);
            
            
            

            
            

        } 
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        else
                 //PANTALON
                
                if (prenda.equals("PANTALON"))
                
                
                {

           
            

                sql = "SELECT identificador_prenda,pantalon_lado_izquierdo_frente,pantalon_lado_izquierdo_frente_nombre,pantalon_lado_izquierdo_frente_aplicacion,pantalon_lado_izquierdo_frente_aplicacion_color"
                           + ",pantalon_lado_derecho_frente,pantalon_lado_derecho_frente_nombre,pantalon_lado_derecho_frente_aplicacion,pantalon_lado_derecho_frente_aplicacion_color,"
                           + "pantalon_lado_izquierdo_atras,pantalon_lado_izquierdo_atras_nombre,pantalon_lado_izquierdo_atras_aplicacion,pantalon_lado_izquierdo_atras_aplicacion_color,"
                           + "pantalon_lado_derecho_atras,pantalon_lado_derecho_atras_nombre,pantalon_lado_derecho_atras_aplicacion,pantalon_lado_derecho_atras_aplicacion_color,"
                       + "color1,color2,color3,color4,color5,hilo1,hilo2,hilo3,hilo4,hilo5"
                        + "  FROM bordados_puntadas where identificador_prenda = '"+identificadordeprenda+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' and codigo = '"+codigodelcliente+"' AND tipo = '"+lbtipostring+"' ";

            

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                        identificadordeprenda = rs.getString("identificador_prenda");
                        lbidentificadordeprendaanterior.setText(identificadordeprenda);
                        ladoizquierdofrentepantalon = rs.getString("pantalon_lado_izquierdo_frente");
                        ladoizquierdofrentepantalonnombre = rs.getString("pantalon_lado_izquierdo_frente_nombre");
                        ladoizquierdofrentepantalonaplicacion = rs.getString("pantalon_lado_izquierdo_frente_aplicacion");
                        ladoizquierdofrentepantalonaplicacioncolor = rs.getString("pantalon_lado_izquierdo_frente_aplicacion_color");
                        
                        
                        ladoderechofrentepantalon = rs.getString("pantalon_lado_derecho_frente");
                        ladoderechofrentepantalonnombre = rs.getString("pantalon_lado_derecho_frente_nombre");
                        ladoderechofrentepantalonaplicacion = rs.getString("pantalon_lado_derecho_frente_aplicacion");
                        ladoderechofrentepantalonaplicacioncolor = rs.getString("pantalon_lado_derecho_frente_aplicacion_color");

                        ladoizquierdoatraspantalon = rs.getString("pantalon_lado_izquierdo_atras");
                        ladoizquierdoatraspantalonnombre = rs.getString("pantalon_lado_izquierdo_atras_nombre");
                        ladoizquierdoatraspantalonaplicacion = rs.getString("pantalon_lado_izquierdo_atras_aplicacion");
                        ladoizquierdoatraspantalonaplicacioncolor = rs.getString("pantalon_lado_izquierdo_atras_aplicacion_color");
                        
                        ladoderechoatraspantalon = rs.getString("pantalon_lado_derecho_atras");
                        ladoderechoatraspantalonnombre = rs.getString("pantalon_lado_derecho_atras_nombre");
                        ladoderechoatraspantalonaplicacion = rs.getString("pantalon_lado_derecho_atras_aplicacion");
                        ladoderechoatraspantalonaplicacioncolor = rs.getString("pantalon_lado_derecho_atras_aplicacion_color");
  
                        
                         cbcolor1.setSelectedItem(rs.getString("color1"));
                        cbcolor2.setSelectedItem(rs.getString("color2"));
                        cbcolor3.setSelectedItem(rs.getString("color3"));
                        cbcolor4.setSelectedItem(rs.getString("color4"));
                        cbcolor5.setSelectedItem(rs.getString("color5"));
                       
                        
                        cbhilo1.setSelectedItem(rs.getString("hilo1"));
                        cbhilo2.setSelectedItem(rs.getString("hilo2"));
                        cbhilo3.setSelectedItem(rs.getString("hilo3"));
                        cbhilo4.setSelectedItem(rs.getString("hilo4"));
                        cbhilo5.setSelectedItem(rs.getString("hilo5"));
                       
                        
                        
                        
                        actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
  
            lbetiqueta1.setText("Lado izquierdo frente");
            cbpuntadas1.setSelectedItem(ladoizquierdofrentepantalon);
            txt1.setText(ladoizquierdofrentepantalonnombre);
            cbaplicacioncantidad1.setEnabled(true);
            cbaplicacioncantidad1.setSelectedItem(ladoizquierdofrentepantalonaplicacion);
            cbaplicacioncolor1.setEnabled(true);
            cbaplicacioncolor1.setSelectedItem(ladoizquierdofrentepantalonaplicacioncolor);

            lbetiqueta2.setText("Lado derecho frente");
            cbpuntadas2.setSelectedItem(ladoderechofrentepantalon);
            txt2.setText(ladoderechofrentepantalonnombre);
            cbaplicacioncantidad2.setEnabled(true);
            cbaplicacioncantidad2.setSelectedItem(ladoderechofrentepantalonaplicacion);
            cbaplicacioncolor2.setEnabled(true);
            cbaplicacioncolor2.setSelectedItem(ladoderechofrentepantalonaplicacioncolor);

            lbetiqueta4.setText("Lado izquierdo atras");
            cbpuntadas4.setSelectedItem(ladoizquierdoatraspantalon);
            txt4.setText(ladoizquierdoatraspantalonnombre);
            cbaplicacioncantidad4.setEnabled(true);
            cbaplicacioncantidad4.setSelectedItem(ladoizquierdoatraspantalonaplicacion);
            cbaplicacioncolor4.setEnabled(true);
            cbaplicacioncolor4.setSelectedItem(ladoizquierdoatraspantalonaplicacioncolor);

            lbetiqueta3.setText("Lado derecho atras");
            cbpuntadas3.setSelectedItem(ladoderechoatraspantalon);
            txt3.setText(ladoderechoatraspantalonnombre);
            cbaplicacioncantidad3.setEnabled(true);
            cbaplicacioncantidad3.setSelectedItem(ladoderechoatraspantalonaplicacion);
            cbaplicacioncolor3.setEnabled(true);
            cbaplicacioncolor3.setSelectedItem(ladoderechoatraspantalonaplicacioncolor);

            lbpuntadas5.setEnabled(false);
            txt5.setEnabled(false);
            cbaplicacioncantidad5.setEnabled(false);
            cbaplicacioncolor5.setEnabled(false);

            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);
            cbaplicacioncantidad6.setEnabled(false);
            cbaplicacioncolor6.setEnabled(false);

            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);
            cbaplicacioncantidad7.setEnabled(false);
            cbaplicacioncolor7.setEnabled(false);

        }
                
                
                
                
                
                
                
                
                
                
                
                
                
                
        /// corbata
        
        else if (prenda.equals("CORBATA")) 
        {

            

                sql = "SELECT identificador_prenda,corbata_frente,corbata_frente_nombre,"
                       + "color1,hilo1"
                        + "  FROM bordados_puntadas where numero_consecutivo = '"+consecutivo+"' and codigo = '"+codigodelcliente+"' AND tipo = '"+lbtipostring+"' ";

            

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                        identificadordeprenda = rs.getString("identificador_prenda");
                        lbidentificadordeprendaanterior.setText(identificadordeprenda);
                        frentecorbata = rs.getString("corbata_frente");
                        frentecorbatanombre = rs.getString("corbata_frente_nombre");
                  
                        
                         cbcolor1.setSelectedItem(rs.getString("color1"));
                    
                        cbhilo1.setSelectedItem(rs.getString("hilo1"));
                    
                        
                        
                        actualizarbordado = "si";
                   

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
  
            
            lbetiqueta1.setText("frente corbata");
            cbpuntadas1.setSelectedItem(frentecorbata);
            txt1.setText(frentecorbatanombre);

            cbaplicacioncantidad1.setEnabled(false);
            cbaplicacioncolor1.setEnabled(false);

            lbetiqueta2.setText("");
            cbpuntadas2.setEnabled(false);
            txt2.setEnabled(false);
            cbaplicacioncantidad2.setEnabled(false);
            cbaplicacioncolor2.setEnabled(false);

            lbetiqueta4.setText("");
            cbpuntadas4.setEnabled(false);
            txt4.setEnabled(false);
            cbaplicacioncantidad4.setEnabled(false);
            cbaplicacioncolor4.setEnabled(false);

            lbetiqueta3.setText("");
            cbpuntadas3.setEnabled(false);
            txt3.setEnabled(false);
            cbaplicacioncantidad3.setEnabled(false);
            cbaplicacioncolor3.setEnabled(false);

            lbetiqueta5.setText("");
            lbpuntadas5.setEnabled(false);
            txt5.setEnabled(false);
            cbaplicacioncantidad5.setEnabled(false);
            cbaplicacioncolor5.setEnabled(false);

            lbetiqueta6.setText("");
            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);
            cbaplicacioncantidad6.setEnabled(false);
            cbaplicacioncolor6.setEnabled(false);

            lbetiqueta7.setText("");
            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);
            cbaplicacioncantidad7.setEnabled(false);
            cbaplicacioncolor7.setEnabled(false);

        }
        
            
          
            
            
            
            
            ///DISTINTA
        if (prenda.equals("DISTINTA")) 
        
        {

            

                sql = "SELECT identificador_prenda,pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo_aplicacion,pecho_izquierdo_aplicacion_color,"
                        + "pecho_derecho,pecho_derecho_nombre,pecho_derecho_aplicacion,pecho_derecho_aplicacion_color,"
                        + "manga_derecha,manga_derecha_nombre,manga_derecha_aplicacion,manga_derecha_aplicacion_color,"
                        + "manga_izquierda,manga_izquierda_nombre,manga_izquierda_aplicacion,manga_izquierda_aplicacion_color,"
                        + "espalda,espalda_nombre,espalda_aplicacion,espalda_aplicacion_color,espalda_puntadas_aro,espalda_aro,"
                        + "otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion_aplicacion,otra_ubicacion_aplicacion_color,"
                        + "otra_ubicacion2,otra_ubicacion2_nombre,otra_ubicacion2_aplicacion,otra_ubicacion2_aplicacion_color,"
                        + "color1,color2,color3,color4,color5,color6,color7,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7 "
                        + " FROM bordados_puntadas where identificador_prenda = '"+identificadordeprenda+"'  and codigo = '"+codigodelcliente+"' AND tipo = '"+lbtipostring+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'"; 
            

        
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                        identificadordeprenda = rs.getString("identificador_prenda");
                        pechoizquierdo = rs.getString("pecho_izquierdo");
                        pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre");
                        pechoizquierdoaplicacion = rs.getString("pecho_izquierdo_aplicacion");
                        pechoizquierdoaplicacioncolor = rs.getString("pecho_izquierdo_aplicacion_color");

                        pechoderecho = rs.getString("pecho_derecho");
                        pechoderechonombre = rs.getString("pecho_derecho_nombre");
                        pechoderechoaplicacion = rs.getString("pecho_derecho_aplicacion");
                        pechoderechoaplicacioncolor = rs.getString("pecho_derecho_aplicacion_color");

                        mangaizquierda = rs.getString("manga_izquierda");
                        mangaizquierdanombre = rs.getString("manga_izquierda_nombre");
                        mangaizquierdaaplicacion = rs.getString("manga_izquierda_aplicacion");
                        mangaizquierdaaplicacioncolor = rs.getString("manga_izquierda_aplicacion_color");

                        mangaderecha = rs.getString("manga_derecha");
                        mangaderechanombre = rs.getString("manga_derecha_nombre");
                        mangaderechaaplicacion = rs.getString("manga_derecha_aplicacion");
                        mangaderechaaplicacioncolor = rs.getString("manga_derecha_aplicacion_color");

                        espalda = rs.getString("espalda");
                        espaldanombre = rs.getString("espalda_nombre");
                        espaldaaplicacion = rs.getString("espalda_aplicacion");
                        espaldaaplicacioncolor = rs.getString("espalda_aplicacion_color");
                        
                        espaldapuntadasaro = rs.getString("espalda_puntadas_aro");
                        espaldaaro = rs.getString("espalda_aro");
                        
                      
                        otraubicacion = rs.getString("otra_ubicacion");
                        otraubicacionnombre = rs.getString("otra_ubicacion_nombre");
                        otraubicacionaplicacion = rs.getString("otra_ubicacion_aplicacion");
                        otraubicacionaplicacioncolor = rs.getString("otra_ubicacion_aplicacion_color");
                    
                        otraubicacion2 = rs.getString("otra_ubicacion2");
                        otraubicacion2nombre = rs.getString("otra_ubicacion2_nombre");
                        otraubicacion2aplicacion = rs.getString("otra_ubicacion2_aplicacion");
                        otraubicacion2aplicacioncolor = rs.getString("otra_ubicacion2_aplicacion_color");
                        
                        
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
                        
                        
                        txtidentificadordeprenda.setText(identificadordeprenda);
                       lbidentificadordeprendaanterior.setText(identificadordeprenda);
                        cbpuntadas1.setSelectedItem(pechoizquierdo);
            txt1.setText(pechoizquierdonombre);
            cbaplicacioncantidad1.setSelectedItem(pechoizquierdoaplicacion);
            cbaplicacioncolor1.setSelectedItem(pechoizquierdoaplicacioncolor);

            cbpuntadas2.setSelectedItem(pechoderecho);
            txt2.setText(pechoderechonombre);
            cbaplicacioncantidad2.setSelectedItem(pechoderechoaplicacion);
            cbaplicacioncolor2.setSelectedItem(pechoderechoaplicacioncolor);

            cbpuntadas4.setSelectedItem(mangaderecha);
            txt4.setText(mangaderechanombre);
            cbaplicacioncantidad4.setSelectedItem(mangaderechaaplicacion);
            cbaplicacioncolor4.setSelectedItem(mangaderechaaplicacioncolor);

            cbpuntadas3.setSelectedItem(mangaizquierda);
            txt3.setText(mangaizquierdanombre);
            cbaplicacioncantidad3.setSelectedItem(mangaizquierdaaplicacion);
            cbaplicacioncolor3.setSelectedItem(mangaizquierdaaplicacioncolor);

            cbpuntadas5.setSelectedItem(espalda);
            txt5.setText(espaldanombre);
            cbaplicacioncantidad5.setSelectedItem(espaldaaplicacion);
            cbaplicacioncolor5.setSelectedItem(espaldaaplicacioncolor);
            
            lbpuntadas5.setText(espaldapuntadasaro); 
            cbaroespalda.setSelectedItem(espaldaaro);        
            
            cbpuntadas6.setSelectedItem(otraubicacion);
            txt6.setText(otraubicacionnombre);
            cbaplicacioncantidad6.setSelectedItem(otraubicacionaplicacion);
            cbaplicacioncolor6.setSelectedItem(otraubicacionaplicacioncolor);
                
            cbpuntadas7.setSelectedItem(otraubicacion2);
            txt7.setText(otraubicacion2nombre);
            cbaplicacioncantidad7.setSelectedItem(otraubicacion2aplicacion);
            cbaplicacioncolor7.setSelectedItem(otraubicacion2aplicacioncolor);
                
            actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            
            

           

        }
        
        
            
            
            
            
            
            
            
            
            
            
            
            // AQUI CHECA SI LOS NOBRES DE LA UBICACIONES NO TIENE UN COLOR, PARA QUE LO PONGAN EN EL COMBO
            
         String bordado1 = txt1.getText();
         bordado1 = bordado1.toUpperCase();
         String etiqueta1 = lbetiqueta1.getText();
         
         String bordado2 = txt2.getText();
         bordado2 = bordado2.toUpperCase();
         String etiqueta2 = lbetiqueta2.getText();
         
         String bordado3 = txt3.getText();
         bordado3 = bordado3.toUpperCase();
         String etiqueta3 = lbetiqueta3.getText();
         
         String bordado4 = txt4.getText();
         bordado4 = bordado4.toUpperCase();
         String etiqueta4 = lbetiqueta4.getText();
         
         
         String bordado5 = txt5.getText();
         bordado5 = bordado5.toUpperCase();
         String etiqueta5 = lbetiqueta5.getText();
         
         String bordado6 = txt6.getText();
         bordado6 = bordado6.toUpperCase();
         String etiqueta6 = lbetiqueta6.getText();
         
         String bordado7 = txt7.getText();
         bordado7 = bordado7.toUpperCase();
         String etiqueta7 = lbetiqueta7.getText();
         
         if (bordado1.contains("VERDE") || bordado1.contains("DORADO") || bordado1.contains("ROJO") || bordado1.contains("AMARILO") || bordado1.contains("ANARANJADO") || bordado1.contains("BLANCO") || bordado1.contains("NEGRO") || bordado1.contains("MARINO") || bordado1.contains("AZUL") || bordado1.contains("GRIS") || bordado1.contains("VINO") || bordado1.contains("ROSA") || bordado1.contains("MORADO") || bordado1.contains("CAFE") || bordado1.contains("CREMA") || bordado1.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la "+etiqueta1+" tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
            
           if (bordado2.contains("VERDE") || bordado2.contains("DORADO") || bordado2.contains("ROJO") || bordado2.contains("AMARILO") || bordado2.contains("ANARANJADO") || bordado2.contains("BLANCO") || bordado2.contains("NEGRO") || bordado2.contains("MARINO") || bordado2.contains("AZUL") || bordado2.contains("GRIS") || bordado2.contains("VINO") || bordado2.contains("ROSA") || bordado2.contains("MORADO") || bordado2.contains("CAFE") || bordado2.contains("CREMA") || bordado2.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la "+etiqueta2+" tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
           
            if (bordado3.contains("VERDE") || bordado3.contains("DORADO") || bordado3.contains("ROJO") || bordado3.contains("AMARILO") || bordado3.contains("ANARANJADO") || bordado3.contains("BLANCO") || bordado3.contains("NEGRO") || bordado3.contains("MARINO") || bordado3.contains("AZUL") || bordado3.contains("GRIS") || bordado3.contains("VINO") || bordado3.contains("ROSA") || bordado3.contains("MORADO") || bordado3.contains("CAFE") || bordado3.contains("CREMA") || bordado3.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la "+etiqueta3+" tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
            
             if (bordado1.contains("VERDE") || bordado4.contains("DORADO") || bordado4.contains("ROJO") || bordado4.contains("AMARILO") || bordado4.contains("ANARANJADO") || bordado4.contains("BLANCO") || bordado4.contains("NEGRO") || bordado4.contains("MARINO") || bordado4.contains("AZUL") || bordado4.contains("GRIS") || bordado4.contains("VINO") || bordado4.contains("ROSA") || bordado4.contains("MORADO") || bordado4.contains("CAFE") || bordado4.contains("CREMA") || bordado4.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la "+etiqueta4+" tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
         
          if (bordado5.contains("VERDE") || bordado5.contains("DORADO") || bordado5.contains("ROJO") || bordado5.contains("AMARILO") || bordado5.contains("ANARANJADO") || bordado5.contains("BLANCO") || bordado5.contains("NEGRO") || bordado5.contains("MARINO") || bordado5.contains("AZUL") || bordado5.contains("GRIS") || bordado5.contains("VINO") || bordado5.contains("ROSA") || bordado5.contains("MORADO") || bordado5.contains("CAFE") || bordado5.contains("CREMA") || bordado5.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la "+etiqueta5+" tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
         
           if (bordado6.contains("VERDE") || bordado6.contains("DORADO") || bordado6.contains("ROJO") || bordado6.contains("AMARILO") || bordado6.contains("ANARANJADO") || bordado6.contains("BLANCO") || bordado6.contains("NEGRO") || bordado6.contains("MARINO") || bordado6.contains("AZUL") || bordado6.contains("GRIS") || bordado6.contains("VINO") || bordado6.contains("ROSA") || bordado6.contains("MORADO") || bordado6.contains("CAFE") || bordado6.contains("CREMA") || bordado6.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la "+etiqueta6+" tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
           
            if (bordado7.contains("VERDE") || bordado7.contains("DORADO") || bordado7.contains("ROJO") || bordado7.contains("AMARILO") || bordado7.contains("ANARANJADO") || bordado7.contains("BLANCO") || bordado7.contains("NEGRO") || bordado7.contains("MARINO") || bordado7.contains("AZUL") || bordado7.contains("GRIS") || bordado7.contains("VINO") || bordado7.contains("ROSA") || bordado7.contains("MORADO") || bordado7.contains("CAFE") || bordado7.contains("CREMA") || bordado7.contains("KAKI") )
         {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la "+etiqueta7+" tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
         }
            
            
            
            
            
            
            
            
            
            
            
            combospuntadasprevias();
            
            
            
            
            
            
            // TERMINA VOID DATOS
            
    }

    
    void identificador()
    {
        
       String SQL = "SELECT borda_cliente FROM catalogo_clientes where codigo = '"+codigodelcliente+"' ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(SQL);
            if (rs1.next()) 
            {
                                
                lbidentificador.setText(rs1.getString("borda_cliente")); 
               
            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }    
        
    }
    
    
    
    void autorizar()
    {
        
         String autorizacionpuntadas = "";
         String sql = "SELECT autorizacion_puntadas FROM bordados_puntadas where identificador_prenda = '"+identificadordeprenda+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' and codigo = '"+codigodelcliente+"'  ";


            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) 
                {

                   
                        autorizacionpuntadas = rs.getString("autorizacion_puntadas");
                       

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            if(autorizacionpuntadas.equals("no"))
            {
                btnautorizarpuntadas.setEnabled(true);
            }
            else
            {
                 btnautorizarpuntadas.setEnabled(false);
            }    
            
        
    }
         
         
    
    void cargarelfotomontaje()
    {
    
        
        BufferedImage img = null;
        String sqlimagen = "Select imagen,extension_imagen from bordados_puntadas where codigo = '" + codigodelcliente + "' and tipo = '"+prenda+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'   ";

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
                    
                    if(prenda.equals("PARCHE")) 
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
        
        /*
         Object codigo = lbconsecutivo.getText();
                 
        if ( codigo == null || codigo.equals("") || codigo.equals("0")|| codigo.equals("00000000")) 
        {

            int j;
            String codigoprenda = "";
            String SQL = "SELECT MAX(numero_consecutivo) FROM bordados_puntadas ";

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
        */
        
    }
     
     
    void actualizarenhistorialventasycotizacionescamisa()
    {
     
        String numeroventa = "";
        String articulo ="";
        String ubicacion = "";
        String nombrearticuloactualizar= "";
        String numerocotizacion = "";
        quevaainsertar();
        
        
        /// historial_ventas
        
        try {
       
            String sql = "SELECT numero,articulo FROM historial_ventas where codigo_cliente='"+codigodelcliente+"' and identificador_prenda = '"+lbidentificadordeprendaanterior.getText()+"'  ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                numeroventa = rs.getString("numero");
                articulo = rs.getString("articulo");
                
                
                
                
                
                if(articulo.contains("PECHO IZQUIERDO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion1 ;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("PECHO DERECHO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion2;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("MANGA IZQUIERDA"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion3;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("MANGA DERECHA"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion4;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("ESPALDA"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion5;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("OTRA UBICACION"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion6;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("OTRA UBICACION2"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion7;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                
                
             
            }
            
         
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        try {
       
            String sql = "SELECT numero,articulo FROM historial_cotizaciones where codigo_cliente='"+codigodelcliente+"' and identificador_prenda = '"+lbidentificadordeprendaanterior.getText()+"'  ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                numerocotizacion = rs.getString("numero");
                articulo = rs.getString("articulo");
                
                
                
                
                
                if(articulo.contains("PECHO IZQUIERDO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion1.concat("").concat(txt1.getText()) ;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("PECHO DERECHO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion2.concat("").concat(txt2.getText()) ;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("MANGA IZQUIERDA"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion3.concat("").concat(txt3.getText()) ;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("MANGA DERECHA"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion4.concat("").concat(txt4.getText()) ;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("ESPALDA"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion5.concat("").concat(txt5.getText()) ;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("OTRA UBICACION"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion6.concat("").concat(txt6.getText()) ;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("OTRA UBICACION2"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion7.concat("").concat(txt7.getText()) ;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                
                
             
            }
            
         
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        

        
        actualizarlaordendebordadocamisa();
        
        
        
    }
    
     void actualizarenhistorialventasycotizacionesgorra()
    {
     
        String numeroventa = "";
        String numerocotizacion = "";
        String articulo ="";
        String ubicacion = "";
        String nombrearticuloactualizar= "";
        quevaainsertar();
        
        try {
       
            String sql = "SELECT numero,numero_cotizacion,articulo FROM historial_ventas where codigo_cliente='"+codigodelcliente+"' and identificador_prenda = '"+lbidentificadordeprendaanterior.getText()+"'  ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                numeroventa = rs.getString("numero");
                articulo = rs.getString("articulo");
                numerocotizacion = rs.getString("numero_cotizacion");
                
                if(articulo.contains("FRENTE"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion1;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("ATRAS"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion2;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("LADO IZQUIERDO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion3;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("LADO DERECHO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion4;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                
                
                
             
            }
            
         
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        actualizarlaordendebordadogorra();

    }
     
    void actualizarenhistorialventasycotizacionespantalon()
    {
     
        String numeroventa = "";
        String numerocotizacion = "";
        String articulo ="";
        String ubicacion = "";
        String nombrearticuloactualizar= "";
        quevaainsertar();
        
        try {
       
            String sql = "SELECT numero,numero_cotizacion,articulo FROM historial_ventas where codigo_cliente='"+codigodelcliente+"' and identificador_prenda = '"+lbidentificadordeprendaanterior.getText()+"'  ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                numeroventa = rs.getString("numero");
                articulo = rs.getString("articulo");
                numerocotizacion = rs.getString("numero_cotizacion");
                
                if(articulo.contains("FRENTE LADO IZQUIERDO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion1;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("FRENTE LADO DERECHO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion2;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("ATRAS LADO IZQUIERDO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion3;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("ATRAS LADO DERECHOO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion4;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                
                
                
             
            }
            
         
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
        actualizarlaordendebordadopantalon();
    }
    
     void actualizarenhistorialventasycotizacioneschaleco()
    {
     
        String numeroventa = "";
        String numerocotizacion = "";
        String articulo ="";
        String ubicacion = "";
        String nombrearticuloactualizar= "";
        quevaainsertar();
        
        try {
       
            String sql = "SELECT numero,numero_cotizacion,articulo FROM historial_ventas where codigo_cliente='"+codigodelcliente+"' and identificador_prenda = '"+lbidentificadordeprendaanterior.getText()+"'  ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                numeroventa = rs.getString("numero");
                articulo = rs.getString("articulo");
                numerocotizacion = rs.getString("numero_cotizacion");
                
                if(articulo.contains("PECHO IZQUIERDO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion1;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("PECHO DERECHO"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion2;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("ESPALDA"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion3;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("OTRA UBICACION2"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion5;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                else if(articulo.contains("OTRA UBICACION"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion4;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                
                
                
                
             
            }
            
         
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        actualizarlaordendebordadocamisa();

    }
     
    void actualizarenhistorialventasycotizacionescorbata()
    {
     
        String numeroventa = "";
        String numerocotizacion = "";
        String articulo ="";
        String ubicacion = "";
        String nombrearticuloactualizar= "";
        quevaainsertar();
        
        try {
       
            String sql = "SELECT numero,numero_cotizacion,articulo FROM historial_ventas where codigo_cliente='"+codigodelcliente+"' and identificador_prenda = '"+lbidentificadordeprendaanterior.getText()+"'  ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                numeroventa = rs.getString("numero");
                articulo = rs.getString("articulo");
                numerocotizacion = rs.getString("numero_cotizacion");
                
                if(articulo.contains("FRENTE"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion1;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                
                
                
                
             
            }
            
         
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        actualizarlaordendebordadocorbata();

    } 
    

      void insertarconsecutivo()
    {/*
     
         Object tipoobject = "PARCHE";
                 
     

            int j;
            String codigoprenda = "";
            String SQL = "SELECT MAX(numero_consecutivo) FROM bordados_puntadas  ";//where tipo = '"+tipoobject+"'

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                if (rs.next()) 
                {
                    codigoprenda = rs.getString(1);
                } 
                
                if (codigoprenda == null) 
                {
                    consecutivo = "00000001";
                }
                else 
                {
                    j = Integer.parseInt(codigoprenda);
                    GenerarNumero gen = new GenerarNumero();
                    gen.generar(j);

                    consecutivo = gen.serie();

                }

            } catch (Exception e) {
               System.out.println(e);
            }
            */
          
         
    }
    
    
    
    
    
    
    
    
    
      void actualizarenhistorialventasycotizacionesparche()
    {
     
        String numeroventa = "";
        String numerocotizacion = "";
        String articulo ="";
        String ubicacion = "";
        String nombrearticuloactualizar= "";
        quevaainsertar();
        
        try {
       
            String sql = "SELECT numero,numero_cotizacion,articulo FROM historial_ventas where codigo_cliente='"+codigodelcliente+"' and identificador_prenda = '"+lbidentificadordeprendaanterior.getText()+"'  ";
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                
                numeroventa = rs.getString("numero");
                articulo = rs.getString("articulo");
                numerocotizacion = rs.getString("numero_cotizacion");
                
                if(articulo.contains("PARCHE"))
                {
                    
                    nombrearticuloactualizar = articulo;
                    ubicacion = ubicacion1;
                    
                    actualizarlaubicacion((String) ubicacion,(String) numeroventa,(String) identificadordeprenda,(String) nombrearticuloactualizar,(String)numerocotizacion);
                }
                
                
                
                
             
            }
            
         
            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    } 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void actualizarlaubicacion(String ubicacion,String numeroventa,String nombrebordado,String nombrearticuloactualizar,String numerocotizacion)
    {
        
        if(numeroventa == null || numeroventa.equals("") || numeroventa.equals(" "))
        {
            
        }
        else 
        {    
            if(nombrearticuloactualizar.startsWith("APLICACION"))
        {
             try {
            PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_VENTAS SET identificador_prenda = '"+txtidentificadordeprenda.getText()+"' WHERE codigo_cliente='" + codigodelcliente + "' and identificador_prenda = '" +lbidentificadordeprendaanterior.getText()+ "'  AND numero = '" + numeroventa + "' and articulo = '"+nombrearticuloactualizar+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
            
        }
        else
        {    
        
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_VENTAS SET ARTICULO = '"+ubicacion.trim()+ "' WHERE codigo_cliente='" + codigodelcliente + "' and identificador_prenda = '" +lbidentificadordeprendaanterior.getText()+ "'  AND numero = '" + numeroventa + "' and articulo = '"+nombrearticuloactualizar+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
       
        
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_VENTAS SET identificador_prenda = '"+txtidentificadordeprenda.getText()+"' WHERE codigo_cliente='" + codigodelcliente + "' and identificador_prenda = '" +lbidentificadordeprendaanterior.getText()+ "'  AND numero = '" + numeroventa + "' and articulo = '"+ubicacion.trim()+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        } 
        
        }
        
        
        
        if(numerocotizacion == null || numerocotizacion.equals("")|| numerocotizacion.equals(" "))
        {
            
        }
        else
        {    
        
         if(nombrearticuloactualizar.startsWith("APLICACION"))
        {
            try {
            PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_COTIZACIONES SET identificador_prenda = '" + txtidentificadordeprenda.getText() + "'  where numero = '" + numerocotizacion + "' and articulo = '"+nombrearticuloactualizar+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
            
        }
        else
        {   
        
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_COTIZACIONES SET ARTICULO = '"+ubicacion.trim()+ "' WHERE codigo_cliente='" + codigodelcliente + "' and identificador_prenda = '" + nombrebordado + "'  AND numero = '" + numerocotizacion + "' and articulo = '"+nombrearticuloactualizar+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_COTIZACIONES SET identificador_prenda = '" + txtidentificadordeprenda.getText() + "'  where numero = '" + numerocotizacion + "' and articulo = '"+ubicacion.trim()+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
        
        }
        
        }
    
    
    }
    
    
    void quevaainsertar()
    {
      
        Object nombrebordado = lbidentificadordeprendaanterior.getText();
        
        String nombre1 = txt1.getText();
        String nombre2 = txt2.getText();
        String nombre3 = txt4.getText();
        String nombre4 = txt3.getText();
        String nombre5 = txt5.getText();
        String nombre6 = txt6.getText();
        String nombre7 = txt7.getText();
        
        if(prenda.equals("CAMISA"))
        {
            
        ubicacion1 = "BORDADO CAMISA PECHO IZQUIERDO "+nombre1+"";
        ubicacion2 = "BORDADO CAMISA PECHO DERECHO "+nombre2+"";
        ubicacion3 = "BORDADO CAMISA MANGA IZQUIERDA "+nombre3+""; 
        ubicacion4 = "BORDADO CAMISA MANGA DERECHA "+nombre4+"";
        ubicacion5 = "BORDADO CAMISA ESPALDA "+nombre5+"";
        ubicacion6 = "BORDADO CAMISA OTRA UBICACION "+nombre6+"";
        ubicacion7 = "BORDADO CAMISA OTRA UBICACION2 "+nombre7+""; 
        
        
       
       
            
        }  

        //// playera
        
          if(prenda.equals("PLAYERA"))
        {
            
        ubicacion1 = "BORDADO PLAYERA PECHO IZQUIERDO "+nombre1+"";
        ubicacion2 = "BORDADO PLAYERA PECHO DERECHO "+nombre2+"";
        ubicacion3 = "BORDADO PLAYERA MANGA IZQUIERDA "+nombre3+""; 
        ubicacion4 = "BORDADO PLAYERA MANGA DERECHA "+nombre4+"";
        ubicacion5 = "BORDADO PLAYERA ESPALDA "+nombre5+"";
        ubicacion6 = "BORDADO PLAYERA OTRA UBICACION "+nombre6+"";
        ubicacion7 = "BORDADO PLAYERA OTRA UBICACION2 "+nombre7+""; 
        
        
        
       
            
        } 
         
         //// chamarra desmontable
        
          if(prenda.startsWith("CHAMARRA DESMONTABLE"))
        {
        
        ubicacion1 = "BORDADO CHAMARRA DESMONTABLE PECHO IZQUIERDO "+nombre1+"";
        ubicacion2 = "BORDADO CHAMARRA DESMONTABLE PECHO DERECHO "+nombre2+"";
        ubicacion3 = "BORDADO CHAMARRA DESMONTABLE MANGA IZQUIERDA "+nombre3+""; 
        ubicacion4 = "BORDADO CHAMARRA DESMONTABLE MANGA DERECHA "+nombre4+"";
        ubicacion5 = "BORDADO CHAMARRA DESMONTABLE ESPALDA "+nombre5+"";
        ubicacion6 = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION "+nombre6+"";
        ubicacion7 = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION2 "+nombre7+""; 
        
        
       
            
        } 
       
        
          /// chamarra rompevientos
          
        if (prenda.startsWith("CHAMARRA ROMPEVIENTOS")) 
        {
        ubicacion1 = "BORDADO CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO "+nombre1+"";
        ubicacion2 = "BORDADO CHAMARRA ROMPEVIENTOS PECHO DERECHO "+nombre2+"";
        ubicacion3 = "BORDADO CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA "+nombre3+""; 
        ubicacion4 = "BORDADO CHAMARRA ROMPEVIENTOS MANGA DERECHA "+nombre4+"";
        ubicacion5 = "BORDADO CHAMARRA ROMPEVIENTOS ESPALDA "+nombre5+"";
        ubicacion6 = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION "+nombre6+"";
        ubicacion7 = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION2 "+nombre7+""; 
        
        
       
            
            
        }
       
        
        ///camisola
        if (prenda.startsWith("CAMISOLA"))
        {
        ubicacion1 = "BORDADO CAMISOLA PECHO IZQUIERDO "+nombre1+"";
        ubicacion2 = "BORDADO CAMISOLA PECHO DERECHO "+nombre2+"";
        ubicacion3 = "BORDADO CAMISOLA MANGA IZQUIERDA "+nombre3+""; 
        ubicacion4 = "BORDADO CAMISOLA MANGA DERECHA "+nombre4+"";
        ubicacion5 = "BORDADO CAMISOLA ESPALDA "+nombre5+"";
        ubicacion6 = "BORDADO CAMISOLA OTRA UBICACION "+nombre6+"";
        ubicacion7 = "BORDADO CAMISOLA OTRA UBICACION2 "+nombre7+""; 
        
        
        
            
        }
        
        else if (prenda.startsWith("GORRA")) 
        {
        ubicacion1 = "BORDADO GORRA FRENTE "+nombre1+"";
        ubicacion2 = "BORDADO GORRA ATRAS "+nombre2+"";
        ubicacion3 = "BORDADO GORRA LADO IZQUIERDO "+nombre3+""; 
        ubicacion4 = "BORDADO GORRA LADO DERECHO "+nombre4+"";
          
        
        
        }
        
      else if (prenda.startsWith("PANTALON")) 
       {
        
        ubicacion1 = "BORDADO PANTALON FRENTE LADO IZQUIERDO "+nombre1+"";
        ubicacion2 = "BORDADO PANTALON FRENTE LADO DERECHO "+nombre2+"";
        ubicacion3 = "BORDADO PANTALON ATRAS LADO IZQUIERDO "+nombre3+""; 
        ubicacion4 = "BORDADO PANTALON ATRAS LADO DERECHO "+nombre4+"";
        
       
        
           
       }
       
        /// corbata
        else if (prenda.equals("CORBATA")) 
       {
           ubicacion1 = "BORDADO CORBATA FRENTE "+nombre1+"";
       }
       
        ///FILIPINA
         
        else if (prenda.equals("FILIPINA")) 
       {
           
        ubicacion1 = "BORDADO FILIPINA PECHO IZQUIERDO "+nombre1+"";
        ubicacion2 = "BORDADO FILIPINA PECHO DERECHO "+nombre2+"";
        ubicacion3 = "BORDADO FILIPINA MANGA IZQUIERDA "+nombre3+""; 
        ubicacion4 = "BORDADO FILIPINA MANGA DERECHA "+nombre4+"";
        ubicacion5 = "BORDADO FILIPINA ESPALDA "+nombre5+"";
        ubicacion6 = "BORDADO FILIPINA OTRA UBICACION "+nombre6+"";
        ubicacion7 = "BORDADO FILIPINA OTRA UBICACION2 "+nombre7+""; 
        
        
        
        
       }
        
      
        
        ///SACO
        else if (prenda.equals("SACO")) 
       {
           
        ubicacion1 = "BORDADO SACO PECHO IZQUIERDO "+nombre1+"";
        ubicacion2 = "BORDADO SACO PECHO DERECHO "+nombre2+"";
        ubicacion3 = "BORDADO SACO MANGA IZQUIERDA "+nombre3+""; 
        ubicacion4 = "BORDADO SACO MANGA DERECHA "+nombre4+"";
        ubicacion5 = "BORDADO SACO ESPALDA "+nombre5+"";

        

        
       }
        
        else if (prenda.equals("CHALECO")) 
       { 
           
        ubicacion1 = "BORDADO CHALECO PECHO IZQUIERDO "+nombre1+"";
        ubicacion2 = "BORDADO CHALECO PECHO DERECHO "+nombre2+"";
        ubicacion3 = "BORDADO CHALECO ESPALDA "+nombre3+""; 
        ubicacion4 = "BORDADO CHALECO OTRA UBICACION "+nombre6+"";
        ubicacion5 = "BORDADO CHALECO OTRA UBICACION2 "+nombre5+""; 
        
        
           
       }
         else if (prenda.equals("PARCHE")) 
       { 
           
        ubicacion1 = "BORDADO PARCHE "+nombre1+"";
        
        
        
           
       }
      
                
        
        
        
        
    }
    
    
    void actualizarlaordendebordadocamisa()
    {
        
        String numero = "";
        String existeenelhistorial ="";
        String sql = "Select numero from historial_ordenes_camisa  where  identificador_prenda='"+identificadordeprenda+"' and cliente = '"+lbcliente.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
               numero = rs.getString(1);
               existeenelhistorial = "si";

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        if(existeenelhistorial.equals("si"))
        {
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_camisa SET identificador_prenda = '" + txtidentificadordeprenda.getText().trim() + "' WHERE numero='" +numero+ "' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        
    }
    
     void actualizarlaordendebordadogorra()
    {
        
         String numero = "";
        String existeenelhistorial ="";
        String sql = "Select numero from historial_ordenes_gorra  where  identificador_prenda='"+identificadordeprenda+"' and cliente = '"+lbcliente.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
               numero = rs.getString(1);
               existeenelhistorial = "si";

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        if(existeenelhistorial.equals("si"))
        {
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_gorra SET identificador_prenda = '" + txtidentificadordeprenda.getText().trim() + "' WHERE numero='" +numero+ "' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        
    }
     
    void actualizarlaordendebordadopantalon()
    {
        
         String numero = "";
        String existeenelhistorial ="";
        String sql = "Select numero from historial_ordenes_pantalon  where  identificador_prenda='"+identificadordeprenda+"' and cliente = '"+lbcliente.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
               numero = rs.getString(1);
               existeenelhistorial = "si";

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        if(existeenelhistorial.equals("si"))
        {
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_pantalon SET identificador_prenda = '" + txtidentificadordeprenda.getText().trim() + "' WHERE numero='" +numero+ "' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        
    } 
    

    void actualizarlaordendebordadocorbata()
    {
        
         String numero = "";
        String existeenelhistorial ="";
        String sql = "Select numero from historial_ordenes_corbata  where  identificador_prenda='"+identificadordeprenda+"' and cliente = '"+lbcliente.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
               numero = rs.getString(1);
               existeenelhistorial = "si";

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        if(existeenelhistorial.equals("si"))
        {
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_corbata SET identificador_prenda = '" + txtidentificadordeprenda.getText().trim() + "' WHERE numero='" +numero+ "' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        
    } 
    
   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbcodigocliente = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        lbetiqueta1 = new javax.swing.JLabel();
        lbetiqueta2 = new javax.swing.JLabel();
        lbetiqueta4 = new javax.swing.JLabel();
        lbetiqueta3 = new javax.swing.JLabel();
        lbetiqueta5 = new javax.swing.JLabel();
        lbetiqueta6 = new javax.swing.JLabel();
        cbpuntadas1 = new javax.swing.JComboBox<>();
        cbpuntadas2 = new javax.swing.JComboBox<>();
        cbpuntadas4 = new javax.swing.JComboBox<>();
        cbpuntadas3 = new javax.swing.JComboBox<>();
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
        lbprenda = new javax.swing.JLabel();
        lbetiqueta7 = new javax.swing.JLabel();
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
        lbnombrecomercial = new javax.swing.JLabel();
        txtidentificadordeprenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcodigocatalogobordados = new javax.swing.JLabel();
        btnimportarfotomontaje = new javax.swing.JButton();
        lbidentificadordeprendaanterior = new javax.swing.JLabel();
        lbconsecutivo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
        cbaroespalda = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        lbpuntadas5 = new javax.swing.JLabel();
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
        cbpuntadas5 = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        cbbordados7 = new javax.swing.JComboBox<>();
        cbbordados2 = new javax.swing.JComboBox<>();
        cbbordados1 = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        cbbordados6 = new javax.swing.JComboBox<>();
        cbbordados3 = new javax.swing.JComboBox<>();
        cbbordados4 = new javax.swing.JComboBox<>();
        cbbordados5 = new javax.swing.JComboBox<>();
        btnautorizarpuntadas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bordados del cliente editar");
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

        lbetiqueta1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbetiqueta1.setText("Pecho izquierdo");
        lbetiqueta1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbetiqueta2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbetiqueta2.setText("Pecho derecho");
        lbetiqueta2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbetiqueta4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbetiqueta4.setText("Manga derecha");
        lbetiqueta4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbetiqueta3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbetiqueta3.setText("Manga izquierda");
        lbetiqueta3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbetiqueta5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbetiqueta5.setText("Espalda");
        lbetiqueta5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbetiqueta6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbetiqueta6.setText("Otra ubicacion");
        lbetiqueta6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        txt1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        txt2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        txt4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        txt3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        txt5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        txt6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        cbaplicacioncolor6.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbaplicacioncolor6.setToolTipText("");
        cbaplicacioncolor6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncolor6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbaplicacioncolor5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbaplicacioncolor5.setToolTipText("");
        cbaplicacioncolor5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncolor5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbaplicacioncolor3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbaplicacioncolor3.setToolTipText("");
        cbaplicacioncolor3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncolor3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbaplicacioncolor4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbaplicacioncolor4.setToolTipText("");
        cbaplicacioncolor4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncolor4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbaplicacioncolor2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbaplicacioncolor2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncolor2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbaplicacioncolor1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbaplicacioncolor1.setToolTipText("");
        cbaplicacioncolor1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncolor1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

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
                cbaplicacioncantidad2PopupMenuCanceled(evt);
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
                cbaplicacioncantidad3PopupMenuCanceled(evt);
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

        lbprenda.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbprenda.setForeground(new java.awt.Color(153, 0, 0));
        lbprenda.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbetiqueta7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbetiqueta7.setText("Otra ubicacion2");
        lbetiqueta7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        txt7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
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

        cbaplicacioncolor7.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        cbaplicacioncolor7.setToolTipText("");
        cbaplicacioncolor7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaplicacioncolor7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
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
        jLabel50.setText("Nombre deL bordado");
        jLabel50.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel58.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel58.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel58.setText("Cant    Aplicaciones   Color");
        jLabel58.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        txtcodigocatalogobordados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcodigocatalogobordados.setText("00000000");
        txtcodigocatalogobordados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnimportarfotomontaje.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnimportarfotomontaje.setText("importar foto");
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

        cbaroespalda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbaroespalda.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "no", "si" }));
        cbaroespalda.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbaroespaldaPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("aro grande");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbpuntadas5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbpuntadas5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbpuntadas5.setOpaque(true);

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Color del bordado");
        jLabel59.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbcolor1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        cbcolor2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        cbcolor3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        cbcolor4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        cbcolor5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        cbcolor6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        cbcolor7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
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

        cbpuntadas5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadas5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadas5PopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadas5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel51.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Ubicación");
        jLabel51.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbbordados7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbordados7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbbordados7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbbordados2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbordados2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbbordados2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbbordados1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbordados1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbbordados1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 0));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Seleccione puntadas");
        jLabel52.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbbordados6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbordados6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbbordados6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbbordados3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbordados3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbbordados3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbbordados4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbordados4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbbordados4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbbordados5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbbordados5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                cbbordados5PopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbbordados5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        btnautorizarpuntadas.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnautorizarpuntadas.setText("Autorizar Puntadas permanentemente");
        btnautorizarpuntadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnautorizarpuntadasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 1857, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbidentificadordeprendaanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbetiqueta7, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbetiqueta4, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbetiqueta5, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(21, 21, 21)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbetiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbetiqueta2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbetiqueta3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbetiqueta6, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbordados1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbordados2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbordados3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbbordados7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbbordados6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(cbbordados5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cbbordados4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(124, 124, 124)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel58))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbpuntadas5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadas4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbpuntadas7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadas6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(cbpuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadas2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadas3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(7, 7, 7)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbaplicacioncantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbaplicacioncantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(7, 7, 7)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbaplicacioncolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbaplicacioncolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(7, 7, 7)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(12, 12, 12)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbaplicacioncantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbaplicacioncantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(7, 7, 7)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbaplicacioncolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbaplicacioncolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(124, 124, 124)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(cbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(cbaplicacioncantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(cbaplicacioncolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(cbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(cbaplicacioncantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(cbaplicacioncolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(cbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(cbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(cbaplicacioncantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(7, 7, 7)
                                                .addComponent(cbaplicacioncolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(7, 7, 7)
                                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(jLabel11)
                                .addGap(7, 7, 7)
                                .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txtidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lbconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62)
                                .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(txtcodigocatalogobordados, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(btnagregarfotomontaje)
                        .addGap(7, 7, 7)
                        .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(btneliminarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbaroespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbpuntadas5, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(170, 170, 170)
                        .addComponent(btnimportarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnautorizarpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminartodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(txtidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(lbconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtcodigocatalogobordados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel58, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbetiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbaplicacioncantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbaplicacioncolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbetiqueta2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(cbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cbaplicacioncantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cbaplicacioncolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbetiqueta3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(cbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(cbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(cbaplicacioncantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbaplicacioncolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lbetiqueta4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(lbetiqueta6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbidentificadordeprendaanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbetiqueta7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(cbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(cbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(cbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(cbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(cbaplicacioncantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(8, 8, 8)
                                        .addComponent(cbaplicacioncantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbaplicacioncolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(7, 7, 7)
                                        .addComponent(cbaplicacioncolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(cbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(cbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(cbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(cbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(cbaplicacioncantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)
                                        .addComponent(cbaplicacioncantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cbaplicacioncolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(5, 5, 5)
                                        .addComponent(cbaplicacioncolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(cbbordados1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(cbbordados2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cbbordados3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(cbbordados4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbordados5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbetiqueta5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbordados6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbordados7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(cbpuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(cbpuntadas2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cbpuntadas3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(cbpuntadas4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbpuntadas5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(cbpuntadas6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbpuntadas7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnagregarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnverfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btneliminarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbpuntadas5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbaroespalda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btneliminartodo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnimportarfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnautorizarpuntadas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)))
                .addComponent(lbfotomontaje, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        ventanabordadosdelclienteeditar = false;
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


        if (dejoespacioalfinal.equals("no"))
            
        {
        
     
        
        String yahayunbordadosconesenombre = "no";
        
        
        pasa = "si";
       
       
        String nombrebordado = txtidentificadordeprenda.getText().trim();
        
        if( (nombrebordado == null || nombrebordado.equals("") ||nombrebordado.equals(" ")  ||nombrebordado.equals("1")  ||nombrebordado.equals("2") ||nombrebordado.equals("3")||nombrebordado.equals("4")) && actualizarbordado.equals("no") )
        {
         
        pasa = "no";    
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar el IDENTIFICAR DE PRENDA");
        txtidentificadordeprenda.requestFocus();
        txtidentificadordeprenda.selectAll();
            
        }
        else
        {
            
            String nombre1 = txt1.getText().trim();
            String nombre2 = txt2.getText().trim();
            String nombre3 = txt3.getText().trim();
            String nombre4 = txt4.getText().trim();
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
             
            
            String puntadas3 = cbpuntadas3.getSelectedItem().toString();
           
            
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
            
            
            String puntadas4 = cbpuntadas4.getSelectedItem().toString();
          
            
            
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
           
           
             
               String puntadas5 = lbpuntadas5.getText();
           
            
            
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
                  if (!puntadas5.startsWith("BORDADO") && prenda.equals("CHAMARRA DESMONTABLE"))
                  {
                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 5; recuerde que si es chamarra debe indicar si utiliza el aro grande");
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
       
                String sql = "SELECT codigo FROM bordados_puntadas where codigo='"+codigodelcliente+"' and identificador_prenda = '"+lbidentificadordeprendaanterior.getText()+"'  AND tipo = '"+prenda+"'   ";

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
                
                
            
            
        
        if (prenda.equals("CAMISA") || prenda.equals("PLAYERA") ||prenda.equals("CHAMARRA DESMONTABLE") ||prenda.equals("CHAMARRA ROMPEVIENTOS")||prenda.equals("CAMISOLA")||prenda.equals("FILIPINA")||prenda.equals("SACO")) 
       
        {
            Object pechoizquierdo = cbpuntadas1.getSelectedItem();
            if(pechoizquierdo==null || pechoizquierdo.equals("")||pechoizquierdo.equals(" "))
            {
                pechoizquierdo = "ninguno";
            }
            Object pechoizquierdonombre = txt1.getText().trim();
            Object pechoizquierdoaplicacion = cbaplicacioncantidad1.getSelectedItem();
            if(pechoizquierdoaplicacion==null || pechoizquierdoaplicacion.equals("")||pechoizquierdoaplicacion.equals(" "))
            {
                pechoizquierdoaplicacion = "0";
            }
            Object pechoizquierdoaplicacioncolor = cbaplicacioncolor1.getSelectedItem();
            if(pechoizquierdoaplicacioncolor==null || pechoizquierdoaplicacioncolor.equals("")||pechoizquierdoaplicacioncolor.equals(" "))
            {
                pechoizquierdoaplicacioncolor = "";
            }

            int pechoizquierdoaplicacionint = Integer.parseInt(pechoizquierdoaplicacion.toString());

            
            
            
            Object pechoderecho = cbpuntadas2.getSelectedItem();
            if(pechoderecho==null || pechoderecho.equals("")||pechoderecho.equals(" "))
            {
                pechoderecho = "ninguno";
            }
            Object pechoderechonombre = txt2.getText().trim();
            Object pechoderechoaplicacion = cbaplicacioncantidad2.getSelectedItem();
            if(pechoderechoaplicacion==null || pechoderechoaplicacion.equals("")||pechoderechoaplicacion.equals(" "))
            {
                pechoderechoaplicacion = "0";
            }
            Object pechoderechoaplicacioncolor = cbaplicacioncolor2.getSelectedItem();
            if(pechoderechoaplicacioncolor==null || pechoderechoaplicacioncolor.equals("")||pechoderechoaplicacioncolor.equals(" "))
            {
                pechoderechoaplicacioncolor = "0";
            }

            int pechoderechoaplicacionint = Integer.parseInt(pechoderechoaplicacion.toString());

            
            
               Object mangaizquierda = cbpuntadas3.getSelectedItem();
            if(mangaizquierda==null || mangaizquierda.equals("")||mangaizquierda.equals(" "))
            {
                mangaizquierda = "0";
            }
            Object mangaizquierdanombre = txt3.getText().trim();
            Object mangaizquierdaaplicacion = cbaplicacioncantidad3.getSelectedItem();
            if(mangaizquierdaaplicacion==null || mangaizquierdaaplicacion.equals("")||mangaizquierdaaplicacion.equals(" "))
            {
                mangaizquierdaaplicacion = "0";
            }
            Object mangaizquierdaaplicacioncolor = cbaplicacioncolor3.getSelectedItem();
            if(mangaizquierdaaplicacioncolor==null || mangaizquierdaaplicacioncolor.equals("")||mangaizquierdaaplicacioncolor.equals(" "))
            {
                mangaizquierdaaplicacioncolor = "0";
            }

            int mangaizquierdaaplicacionint = Integer.parseInt(mangaizquierdaaplicacion.toString());

            
            
            
            Object mangaderecha = cbpuntadas4.getSelectedItem();
            if(mangaderecha==null || mangaderecha.equals("")||mangaderecha.equals(" "))
            {
                mangaderecha = "0";
            }
            Object mangaderechanombre = txt4.getText().trim();
            Object mangaderechaaplicacion = cbaplicacioncantidad4.getSelectedItem();
            if(mangaderechaaplicacion==null || mangaderechaaplicacion.equals("")||mangaderechaaplicacion.equals(" "))
            {
                mangaderechaaplicacion = "0";
            }
            Object mangaderechaaplicacioncolor = cbaplicacioncolor4.getSelectedItem();
            if(mangaderechaaplicacioncolor==null || mangaderechaaplicacioncolor.equals("")||mangaderechaaplicacioncolor.equals(" "))
            {
                mangaderechaaplicacioncolor = "0";
            }

            int mangaderechaaplicacionint = Integer.parseInt(mangaderechaaplicacion.toString());

            
            
            
            
         
            Object espalda = lbpuntadas5.getText();
            if(espalda==null || espalda.equals("")||espalda.equals(" "))
            {
                espalda = "ninguno";
            }
            Object espaldanombre = txt5.getText().trim();
            Object espaldaaplicacion = cbaplicacioncantidad5.getSelectedItem();
            if(espaldaaplicacion==null || espaldaaplicacion.equals("")||espaldaaplicacion.equals(" "))
            {
                espaldaaplicacion = "0";
            }
            Object espaldaaplicacioncolor = cbaplicacioncolor5.getSelectedItem();
            if(espaldaaplicacioncolor==null || espaldaaplicacioncolor.equals("")||espaldaaplicacioncolor.equals(" "))
            {
                espaldaaplicacioncolor = "0";
            }
      
             Object espaldapuntadasaro = lbpuntadas5.getText();
            if(espaldapuntadasaro==null || espaldapuntadasaro.equals("")||espaldapuntadasaro.equals(" "))
            {
                espaldapuntadasaro = "0";
            }
            
            Object espaldaaro = cbaroespalda.getSelectedItem();
            if(espaldaaro==null || espaldaaro.equals("")||espaldaaro.equals(" "))
            {
                espaldaaro = "no";
            }
             
            int espaldaaplicacionint = Integer.parseInt(espaldaaplicacion.toString());
            
            
          
            
            

            Object otraubicacion = cbpuntadas6.getSelectedItem();
            if(otraubicacion==null || otraubicacion.equals("")||otraubicacion.equals(" "))
            {
                otraubicacion = "ninguno";
            }
            Object otraubicacionnombre = txt6.getText().trim();
            Object otraubicacionaplicacion = cbaplicacioncantidad6.getSelectedItem();
            if(otraubicacionaplicacion==null || otraubicacionaplicacion.equals("")||otraubicacionaplicacion.equals(" "))
            {
                otraubicacionaplicacion = "0";
            }
            Object otraubicacionaplicacioncolor = cbaplicacioncolor6.getSelectedItem();
            if(otraubicacionaplicacioncolor==null || otraubicacionaplicacioncolor.equals("")||otraubicacionaplicacioncolor.equals(" "))
            {
                otraubicacionaplicacioncolor = "0";
            }

            int otraubicacionaplicacionint = Integer.parseInt(otraubicacionaplicacion.toString());
            
            
            
            
            Object otraubicacion2 = cbpuntadas7.getSelectedItem();
            if(otraubicacion2==null || otraubicacion2.equals("")||otraubicacion2.equals(" "))
            {
                otraubicacion2 = "ninguno";
            }
            Object otraubicacionnombre2 = txt7.getText().trim();
            Object otraubicacionaplicacion2 = cbaplicacioncantidad7.getSelectedItem();
            if(otraubicacionaplicacion2==null || otraubicacionaplicacion2.equals("")||otraubicacionaplicacion2.equals(" "))
            {
                otraubicacionaplicacion2 = "0";
            }
            Object otraubicacionaplicacioncolor2 = cbaplicacioncolor7.getSelectedItem();
            if(otraubicacionaplicacioncolor2==null || otraubicacionaplicacioncolor2.equals("")||otraubicacionaplicacioncolor2.equals(" "))
            {
                otraubicacionaplicacioncolor2 = "0";
            }

            int otraubicacionaplicacionint2 = Integer.parseInt(otraubicacionaplicacion2.toString());

                
            
            
            
             Object color1 = cbcolor1.getSelectedItem();
              if(color1==null || color1.equals("")||color1.equals(" "))
            {
                color1 = "";
            }
                Object color2 = cbcolor2.getSelectedItem();
              if(color2==null || color2.equals("")||color2.equals(" "))
            {
                color2 = "";
            }
                Object color3 = cbcolor3.getSelectedItem();
              if(color3==null || color3.equals("")||color3.equals(" "))
            {
                color3 = "";
            }
                Object color4 = cbcolor4.getSelectedItem();
              if(color4==null || color4.equals("")||color4.equals(" "))
            {
                color4 = "";
            }
                Object color5 = cbcolor5.getSelectedItem();
              if(color5==null || color5.equals("")||color5.equals(" "))
            {
                color5 = "";
            }
                Object color6 = cbcolor6.getSelectedItem();
              if(color6==null || color6.equals("")||color6.equals(" "))
            {
                color6 = "";
            }
                Object color7 = cbcolor7.getSelectedItem();
              if(color7==null || color7.equals("")||color7.equals(" "))
            {
                color7 = "";
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
                                                               + "identificador_prenda = '" + nombrebordado+ "',"
                                                               + "pecho_izquierdo = '" + pechoizquierdo+ "',"
                                                               + "pecho_izquierdo_nombre='" + pechoizquierdonombre + "',"
                                                               + "pecho_derecho='" + pechoderecho + "',"
                                                               + "pecho_derecho_nombre='" + pechoderechonombre + "',"
                                                               + "manga_derecha='" + mangaderecha + "' ,"
                                                               + "manga_derecha_nombre='" + mangaderechanombre + "' ,"
                                                               + "manga_izquierda='" + mangaizquierda + "' ,"
                                                               + "manga_izquierda_nombre='" + mangaizquierdanombre + "',"
                                                               + "espalda ='" + espalda + "' ,"
                                                               + "espalda_nombre ='" + espaldanombre + "',"
                                                               + "espalda_puntadas_aro ='" +espaldapuntadasaro+ "',"   
                                                               + "espalda_aro ='"+espaldaaro+"',"           
                                                               + "otra_ubicacion ='" + otraubicacion + "' ,"
                                                               + "otra_ubicacion_nombre ='" + otraubicacionnombre + "',"
                                                               + "otra_ubicacion2 ='" + otraubicacion2 + "' ,"
                                                               + "otra_ubicacion2_nombre ='" + otraubicacionnombre2 + "'  WHERE codigo='"+codigodelcliente+"' and tipo = '"+prenda+"' and numero_consecutivo = '"+lbconsecutivo.getText()+"'   ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

         //// aplicacion


         
                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET "
                                                               + "pecho_izquierdo_aplicacion ='" + pechoizquierdoaplicacion + "',"
                                                               + "pecho_derecho_aplicacion='" + pechoderechoaplicacion + "',"
                                                               + "manga_derecha_aplicacion='" + mangaderechaaplicacion + "' ,"
                                                               + "manga_izquierda_aplicacion='" + mangaizquierdaaplicacion + "',"
                                                               + "espalda_aplicacion ='" + espaldaaplicacion + "',"
                                                               + "otra_ubicacion_aplicacion ='" + otraubicacionaplicacion + "',"
                                                               + "otra_ubicacion2_aplicacion ='" + otraubicacionaplicacion2 + "'  WHERE codigo='"+codigodelcliente+"'  and tipo = '"+prenda+"' AND numero_consecutivo = '"+lbconsecutivo.getText()+"' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

                
                 //// aplicacion_color
                
                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET "
                                                                + "pecho_izquierdo_aplicacion_color ='" + pechoizquierdoaplicacioncolor + "',"
                                                                + "pecho_derecho_aplicacion_color='" + pechoderechoaplicacioncolor + "',"
                                                                + "manga_derecha_aplicacion_color='" + mangaderechaaplicacioncolor + "' ,"
                                                                + "manga_izquierda_aplicacion_color='" + mangaizquierdaaplicacioncolor + "',"
                                                                + "espalda_aplicacion_color ='" + espaldaaplicacioncolor + "',"
                                                                + "otra_ubicacion_aplicacion_color ='" + otraubicacionaplicacioncolor + "',"
                                                                + "otra_ubicacion2_aplicacion_color ='" + otraubicacionaplicacioncolor2 + "'  WHERE codigo='" + codigodelcliente + "' and tipo = '"+prenda+"' AND numero_consecutivo = '"+lbconsecutivo.getText()+"'");
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
                                                               + "hilo7 ='" + hilo7 + "'  WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'   ");
                 
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                
                
                
                
                
                
                
                 try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET identificador_prenda = '"+txtidentificadordeprenda.getText().trim()+"' WHERE codigo='" + codigodelcliente + "' and AND tipo = '"+prenda+"' AND numero_consecutivo = '"+lbconsecutivo.getText()+"'");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                 
                 
                actualizarenhistorialventasycotizacionescamisa(); 
                 
        
        
        }
        else
        {
            
            
            insertarnumero();

            String InsertarSQL = "INSERT INTO bordados_puntadas(codigo,nombre,identificador_prenda,tipo,pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo_aplicacion,pecho_izquierdo_aplicacion_color,pecho_derecho,pecho_derecho_nombre,pecho_derecho_aplicacion,pecho_derecho_aplicacion_color,manga_derecha,manga_derecha_nombre,manga_derecha_aplicacion,manga_derecha_aplicacion_color,manga_izquierda,manga_izquierda_nombre,manga_izquierda_aplicacion,manga_izquierda_aplicacion_color,espalda,espalda_nombre,espalda_aplicacion,espalda_aplicacion_color,espalda_puntadas_aro,espalda_aro,otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion_aplicacion,otra_ubicacion_aplicacion_color,otra_ubicacion2,otra_ubicacion2_nombre,otra_ubicacion2_aplicacion,otra_ubicacion2_aplicacion_color,numero_consecutivo,color1,color2,color3,color4,color5,color6,color7,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);

                pst.setString(1, lbcodigocliente.getText());
                pst.setString(2, lbcliente.getText());
                pst.setString(3, txtidentificadordeprenda.getText().trim());
                pst.setString(4, lbprenda.getText());
                
                pst.setString(5, pechoizquierdo.toString());
                pst.setString(6, pechoizquierdonombre.toString());
                pst.setString(7, pechoizquierdoaplicacion.toString());
                pst.setString(8, pechoizquierdoaplicacioncolor.toString());

                pst.setString(9, pechoderecho.toString());
                pst.setString(10, pechoderechonombre.toString());
                pst.setString(11, pechoderechoaplicacion.toString());
                pst.setString(12, pechoderechoaplicacioncolor.toString());
                
                pst.setString(13, mangaderecha.toString());
                pst.setString(14, mangaderechanombre.toString());
                pst.setString(15, mangaderechaaplicacion.toString());
                pst.setString(16, mangaderechaaplicacioncolor.toString());
                
                pst.setString(17, mangaizquierda.toString());
                pst.setString(18, mangaizquierdanombre.toString());
                pst.setString(19, mangaderechaaplicacion.toString());
                pst.setString(20, mangaderechaaplicacioncolor.toString());
                                 
                pst.setString(21, espalda.toString());
                pst.setString(22, espaldanombre.toString());
                pst.setString(23, espaldaaplicacion.toString());
                pst.setString(24, espaldaaplicacioncolor.toString());
                pst.setString(25, espaldapuntadasaro.toString());
                pst.setString(26, espaldaaro.toString());
                
                
                pst.setString(27, otraubicacion.toString());
                pst.setString(28, otraubicacionnombre.toString());
                pst.setString(29, otraubicacionaplicacion.toString());
                pst.setString(30, otraubicacionaplicacioncolor.toString());
                
                pst.setString(31, otraubicacion2.toString());
                pst.setString(32, otraubicacionnombre2.toString());
                pst.setString(33, otraubicacionaplicacion2.toString());
                pst.setString(34, otraubicacionaplicacioncolor2.toString());
                pst.setString(35, lbconsecutivo.getText());
                
                pst.setString(36, color1.toString());
                pst.setString(37, color2.toString());
                pst.setString(38, color3.toString());
                pst.setString(39, color4.toString());
                pst.setString(40, color5.toString());
                pst.setString(41, color6.toString());
                pst.setString(42, color7.toString());
                
                pst.setString(43, hilo1.toString());
                pst.setString(44, hilo2.toString());
                pst.setString(45, hilo3.toString());
                pst.setString(46, hilo4.toString());
                pst.setString(47, hilo5.toString());
                pst.setString(48, hilo6.toString());
                pst.setString(49, hilo7.toString());
                
                
                
                pst.executeUpdate();
                pst.close();
                
                
          

            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        }    
        
        
        
        }  
        
        
        // GORRA
        
        else if (lbprenda.getText().equals("GORRA")) 
        {
            
            
            
          
            
            
            
        Object frentegorra = cbpuntadas1.getSelectedItem();
        Object frentegorranombre = txt1.getText();
        Object frentegorraaplicacion =cbaplicacioncantidad1.getSelectedItem();
        Object frentegorraaplicacioncolor =cbaplicacioncolor1.getSelectedItem();
    
        
        Object ladoizquierdogorra = cbpuntadas2.getSelectedItem();
        Object ladoizquierdogorranombre = txt2.getText();
        

        Object ladoderechogorra = cbpuntadas4.getSelectedItem();
        Object ladoderechogorranombre = txt4.getText();
    

        Object atrasgorra = cbpuntadas3.getSelectedItem();
        Object atrasgorranombre = txt3.getText();
        
        
        
        
        
         Object color1 = cbcolor1.getSelectedItem();
              if(color1==null || color1.equals("")||color1.equals(" "))
            {
                color1 = "";
            }
                Object color2 = cbcolor2.getSelectedItem();
              if(color2==null || color2.equals("")||color2.equals(" "))
            {
                color2 = "";
            }
                Object color3 = cbcolor3.getSelectedItem();
              if(color3==null || color3.equals("")||color3.equals(" "))
            {
                color3 = "";
            }
                Object color4 = cbcolor4.getSelectedItem();
              if(color4==null || color4.equals("")||color4.equals(" "))
            {
                color4 = "";
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
            
       
        if(actualizarbordado.equals("si"))
        {
        
         try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET frente = '" + frentegorra + "',frente_nombre='" + frentegorranombre + "',lado_izquierdo='" + ladoizquierdogorra + "',lado_izquierdo_nombre='" + ladoizquierdogorranombre + "',lado_derecho ='" + ladoderechogorra + "' ,lado_derecho_nombre ='" + ladoderechogorranombre + "',atras ='" + atrasgorra + "' ,atras_nombre ='" + atrasgorranombre + "'  WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'   ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
          try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET frente_aplicacion = '" + frentegorraaplicacion + "',frente_aplicacion_color = '" + frentegorraaplicacioncolor + "'  WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'  ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
          
         try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET identificador_prenda = '"+txtidentificadordeprenda.getText().trim()+"'  WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'  ");
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
                                                              
                                                               + "hilo1='" + hilo1 + "',"
                                                               + "hilo2 ='" + hilo2 + "' ,"
                                                               + "hilo3 ='" + hilo3 + "',"
                                                               + "hilo4 ='" +hilo4+ "'  WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'  ");   
                                                           
                 
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                
         
         actualizarenhistorialventasycotizacionesgorra();
         
        }
        else
        {
            insertarnumero();
             String InsertarSQL = "INSERT INTO bordados_puntadas(codigo,nombre,identificador_prenda,tipo,frente,frente_nombre,lado_izquierdo,lado_izquierdo_nombre,lado_derecho,lado_derecho_nombre ,atras,atras_nombre,frente_aplicacion ,frente_aplicacion_color,numero_consecutivo,color1,color2,color3,color4,hilo1,hilo2,hilo3,hilo4) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);

                pst.setString(1, lbcodigocliente.getText());
                pst.setString(2, lbcliente.getText());
                pst.setString(3, txtidentificadordeprenda.getText().trim());
                pst.setString(4, lbprenda.getText());
                
                pst.setString(5, frentegorra.toString());
                pst.setString(6, frentegorranombre.toString());
                pst.setString(7, ladoizquierdogorra.toString());
                pst.setString(8, ladoizquierdogorranombre.toString());

                pst.setString(9, ladoderechogorra.toString());
                pst.setString(10,ladoderechogorranombre.toString());
                pst.setString(11, atrasgorra.toString());
                pst.setString(12, atrasgorranombre.toString());
                
                pst.setString(13,frentegorraaplicacion.toString());
                pst.setString(14,frentegorraaplicacioncolor.toString());
                pst.setString(15,lbconsecutivo.getText());
                
                 pst.setString(16, color1.toString());
                pst.setString(17, color2.toString());
                pst.setString(18, color3.toString());
                pst.setString(19, color4.toString());
               
                
                pst.setString(20, hilo1.toString());
                pst.setString(21, hilo2.toString());
                pst.setString(22, hilo3.toString());
                pst.setString(23, hilo4.toString());
             

                pst.executeUpdate();
                pst.close();


            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        }    
          
          
        }
        

        /// pantalon
         else if (lbprenda.getText().equals("PANTALON"))
        {
        
        Object ladoizquierdofrentepantalon = cbpuntadas1.getSelectedItem();
        Object ladoizquierdofrentepantalonnombre = txt1.getText();
        Object ladoizquierdofrentepantalonaplicacion = cbaplicacioncantidad1.getSelectedItem();
        Object ladoizquierdofrentepantalonaplicacioncolor = cbaplicacioncolor1.getSelectedItem();
        

        Object ladoderechofrentepantalon = cbpuntadas2.getSelectedItem();
        Object ladoderechofrentepantalonnombre = txt2.getText();
        Object ladoderechofrentepantalonaplicacion = cbaplicacioncantidad2.getSelectedItem();
        Object ladoderechofrentepantalonaplicacioncolor = cbaplicacioncolor2.getSelectedItem();

        Object ladoizquierdoatraspantalon = cbpuntadas4.getSelectedItem();
        Object ladoizquierdoatraspantalonnombre = txt4.getText();
        Object ladoizquierdoatraspantalonaplicacion = cbaplicacioncantidad4.getSelectedItem();
        Object ladoizquierdoatraspantalonaplicacioncolor = cbaplicacioncolor4.getSelectedItem();

        Object ladoderechoatraspantalon = cbpuntadas3.getSelectedItem();
        Object ladoderechoatraspantalonnombre = txt3.getText();
        Object ladoderechoatraspantalonaplicacion = cbaplicacioncantidad3.getSelectedItem();
        Object ladoderechoatraspantalonaplicacioncolor = cbaplicacioncolor3.getSelectedItem();
        
        
        
        Object color1 = cbcolor1.getSelectedItem();
              if(color1==null || color1.equals("")||color1.equals(" "))
            {
                color1 = "";
            }
                Object color2 = cbcolor2.getSelectedItem();
              if(color2==null || color2.equals("")||color2.equals(" "))
            {
                color2 = "";
            }
                Object color3 = cbcolor3.getSelectedItem();
              if(color3==null || color3.equals("")||color3.equals(" "))
            {
                color3 = "";
            }
                Object color4 = cbcolor4.getSelectedItem();
              if(color4==null || color4.equals("")||color4.equals(" "))
            {
                color4 = "";
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
            

        if(actualizarbordado.equals("si"))
        {
          
            
            
            try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pantalon_lado_izquierdo_frente='" + ladoizquierdofrentepantalon + "',pantalon_lado_izquierdo_frente_nombre='" + ladoizquierdofrentepantalonnombre + "',pantalon_lado_izquierdo_frente_aplicacion='" + ladoizquierdofrentepantalonaplicacion + "',pantalon_lado_izquierdo_frente_aplicacion_color='" + ladoizquierdofrentepantalonaplicacioncolor + "',"
                                                                                   + "pantalon_lado_derecho_frente ='" + ladoderechofrentepantalon + "' ,pantalon_lado_derecho_frente_nombre ='" + ladoderechofrentepantalonnombre + "',pantalon_lado_derecho_frente_aplicacion ='" + ladoderechofrentepantalonaplicacion + "',pantalon_lado_derecho_frente_aplicacion_color ='" + ladoderechofrentepantalonaplicacioncolor + "',"
                                                                                   + "pantalon_lado_izquierdo_atras='" + ladoizquierdoatraspantalon + "',pantalon_lado_izquierdo_atras_nombre='" + ladoizquierdoatraspantalonnombre + "',pantalon_lado_izquierdo_atras_aplicacion='" + ladoizquierdoatraspantalonaplicacion + "',pantalon_lado_izquierdo_atras_aplicacion_color='" + ladoizquierdoatraspantalonaplicacioncolor + "',"
                                                                                   + "pantalon_lado_derecho_atras ='" + ladoderechoatraspantalon + "' ,pantalon_lado_derecho_atras_nombre ='" + ladoderechoatraspantalonnombre + "',pantalon_lado_derecho_atras_aplicacion ='" + ladoderechoatraspantalonaplicacion + "',pantalon_lado_derecho_atras_aplicacion_color ='" + ladoderechoatraspantalonaplicacioncolor + "'   WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
            
            
             try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pantalon_lado_izquierdo_frente_aplicacion = '" + ladoizquierdofrentepantalonaplicacion + "',pantalon_lado_izquierdo_frente_aplicacion_color = '" + ladoizquierdofrentepantalonaplicacioncolor + "',"
                    + "pantalon_lado_derecho_frente_aplicacion = '" + ladoderechofrentepantalonaplicacion + "',pantalon_lado_derecho_frente_aplicacion_color = '" + ladoizquierdofrentepantalonaplicacioncolor + "',"
                    + "pantalon_lado_izquierdo_atras_aplicacion = '" + ladoizquierdoatraspantalonaplicacion + "',pantalon_lado_izquierdo_atras_aplicacion_color = '" + ladoizquierdoatraspantalonaplicacioncolor + "',"
                    + "pantalon_lado_derecho_atras_aplicacion = '" + ladoderechoatraspantalonaplicacion + "',pantalon_lado_derecho_atras_aplicacion_color = '" + ladoderechoatraspantalonaplicacioncolor + "'  WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'  ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
             
             
            
         try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET identificador_prenda = '"+txtidentificadordeprenda.getText().trim()+"'WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' ");
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
                                                             
                                                               + "hilo1='" + hilo1 + "',"
                                                               + "hilo2 ='" + hilo2 + "' ,"
                                                               + "hilo3 ='" + hilo3 + "',"
                                                               + "hilo4 ='" +hilo4+ "'WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'  ");   
                                                            
         
         
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
         
         actualizarenhistorialventasycotizacionespantalon();
            
        }
        else
        {
            insertarnumero();

            String InsertarSQL = "INSERT INTO bordados_puntadas(codigo,nombre,identificador_prenda,tipo,pantalon_lado_izquierdo_frente,pantalon_lado_izquierdo_frente_nombre,pantalon_lado_derecho_frente,pantalon_lado_derecho_frente_nombre,pantalon_lado_izquierdo_atras,pantalon_lado_izquierdo_atras_nombre,pantalon_lado_derecho_atras,pantalon_lado_derecho_atras_nombre,numero_consecutivo,color1,color2,color3,color4,hilo1,hilo2,hilo3,hilo4) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);

                pst.setString(1, lbcodigocliente.getText());
                pst.setString(2, lbcliente.getText());
                pst.setString(3, txtidentificadordeprenda.getText().trim());
                pst.setString(4, lbprenda.getText());
                
                pst.setString(5, ladoizquierdofrentepantalon.toString());
                pst.setString(6, ladoizquierdofrentepantalonnombre.toString());
                pst.setString(7, ladoderechofrentepantalon.toString());
                pst.setString(8, ladoderechofrentepantalonnombre.toString());

                pst.setString(9, ladoizquierdoatraspantalon.toString());
                pst.setString(10,ladoizquierdoatraspantalonnombre.toString());
                pst.setString(11,ladoderechoatraspantalon.toString());
                pst.setString(12,ladoderechoatraspantalonnombre.toString());
                pst.setString(13,lbconsecutivo.getText());
                
                
                
                 pst.setString(14, color1.toString());
                pst.setString(15, color2.toString());
                pst.setString(16, color3.toString());
                pst.setString(17, color4.toString());
              
                
                pst.setString(18, hilo1.toString());
                pst.setString(19, hilo2.toString());
                pst.setString(20, hilo3.toString());
                pst.setString(21, hilo4.toString());
               

                pst.executeUpdate();
                pst.close();


            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } 
  

        }
               
                
                
         // CORBATA
         
         
        else if (lbprenda.getText().equals("CORBATA"))
        {
        
        Object frentecorbata = cbpuntadas1.getSelectedItem();
        Object frentecorbatanombre = txt1.getText();
        
        
        
        Object color1 = cbcolor1.getSelectedItem();
              if(color1==null || color1.equals("")||color1.equals(" "))
            {
                color1 = "";
            }
            
              
                Object hilo1 = cbhilo1.getSelectedItem();
              if(hilo1==null || hilo1.equals("")||hilo1.equals(" "))
            {
                hilo1 = "0";
            }
              
        
        if(actualizarbordado.equals("si"))
        {
        
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET corbata_frente='" + frentecorbata + "',corbata_frente_nombre='" + frentecorbatanombre + "' WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'  ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
         try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET identificador_prenda = '"+txtidentificadordeprenda.getText().trim()+"' WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
         
         
          //// Colores e hilos
                
                   try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET "
                                                               + "color1= '" + color1+ "',"
                                                               + "hilo1='" + hilo1 + "'WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'  ");
                            
           pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
         
         
         actualizarenhistorialventasycotizacionescorbata();
        
        }
         else
        {
            insertarnumero();
             String InsertarSQL = "INSERT INTO bordados_puntadas(codigo,nombre,identificador_prenda,tipo,corbata_frente,corbata_frente_nombre,numero_consecutivo,color1,hilo1) VALUES (?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);

                pst.setString(1, lbcodigocliente.getText());
                pst.setString(2, lbcliente.getText());
                pst.setString(3, txtidentificadordeprenda.getText().trim());
                pst.setString(4, lbprenda.getText());
                
                pst.setString(5, frentecorbata.toString());
                pst.setString(6, frentecorbatanombre.toString());
                pst.setString(7, lbconsecutivo.getText());
                
                 pst.setString(8, color1.toString());
               
                
                pst.setString(9, hilo1.toString());
              
                

                pst.executeUpdate();
                pst.close();


            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } 

        }
        
         
         // PARCHE
         
      
        else if (lbprenda.getText().equals("PARCHE"))
        {
        
        Object parche = cbpuntadas1.getSelectedItem();
        Object parchenombre = txt1.getText();
        Object parcheaplicacion = cbaplicacioncantidad1.getSelectedItem();
        Object parcheaplicacioncolor = cbaplicacioncolor1.getSelectedItem();
        
        
        
        Object color1 = cbcolor1.getSelectedItem();
              if(color1==null || color1.equals("")||color1.equals(" "))
            {
                color1 = "";
            }
           
              
               
              
                Object hilo1 = cbhilo1.getSelectedItem();
              if(hilo1==null || hilo1.equals("")||hilo1.equals(" "))
            {
                hilo1 = "0";
            }
        
        if(actualizarbordado.equals("si"))
        {
        
        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET parche='" + parche + "',parche_nombre='" + parchenombre + "',parche_aplicacion='" + parcheaplicacion + "',parche_aplicacion_color='" + parcheaplicacioncolor + "' WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+consecutivo+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
         try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET identificador_prenda = '"+txtidentificadordeprenda.getText().trim()+"'WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"'  ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
        
          //// Colores e hilos
                
                   try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET "
                                                               + "color1= '" + color1+ "',"
                                                               + "hilo1='" + hilo1 + "'WHERE codigo='"+codigodelcliente+"' and  tipo = '"+prenda+"' AND numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' ");
                                                          
         
                         pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
         
         
         actualizarenhistorialventasycotizacionesparche();
        
        }
         else
        {
            insertarnumero();
            
            
             String InsertarSQL = "INSERT INTO bordados_puntadas(codigo,nombre,identificador_prenda,tipo,parche,parche_nombre,parche_aplicacion,parche_aplicacion_color,numero_consecutivo,color1,hilo1) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);

                pst.setString(1, lbcodigocliente.getText());
                pst.setString(2, lbcliente.getText());
                pst.setString(3, txtidentificadordeprenda.getText().trim());
                pst.setString(4, lbprenda.getText());
                
                pst.setString(5, parche.toString());
                pst.setString(6, parchenombre.toString());
                pst.setString(7, parcheaplicacion.toString());
                pst.setString(8, parcheaplicacioncolor.toString());
                pst.setString(9, lbconsecutivo.getText());
            
                pst.setString(10, color1.toString());
                
                pst.setString(11, hilo1.toString());
                
                pst.executeUpdate();
                pst.close();


            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } 

        
        }
        
        //CHALECO
        
        
         else if (lbprenda.getText().equals("CHALECO"))
        {
            
       Object pechoizquierdochaleco = cbpuntadas1.getSelectedItem();
        Object pechoizquierdochaleconombre = txt1.getText();
        Object pechoizquierdochalecoaplicacion = cbaplicacioncantidad1.getSelectedItem();
        Object pechoizquierdochalecoaplicacioncolor =cbaplicacioncolor1.getSelectedItem();
        
         int pechoizquierdochalecoaplicacionint = Integer.parseInt(pechoizquierdochalecoaplicacion.toString()); 
        
        Object pechoderechochaleco = cbpuntadas2.getSelectedItem();
        Object pechoderechochaleconombre = txt2.getText();
        Object pechoderechochalecoaplicacion = cbaplicacioncantidad2.getSelectedItem();
        Object pechoderechochalecoaplicacioncolor =cbaplicacioncolor2.getSelectedItem();
        
         Object espaldachaleco = cbpuntadas4.getSelectedItem();
        Object espaldachaleconombre = txt4.getText();
        Object espaldachalecoaplicacion = cbaplicacioncantidad4.getSelectedItem();
        Object espaldachalecoaplicacioncolor =cbaplicacioncolor4.getSelectedItem();
        
        int espaldachalecoaplicacionint = Integer.parseInt(espaldachalecoaplicacion.toString()); 
        
        
            Object otraubicacionchaleco = cbpuntadas3.getSelectedItem();
            Object otraubicacionchaleconombre = txt3.getText();
            Object otraubicacionchalecoaplicacion = cbaplicacioncantidad3.getSelectedItem();
            Object otraubicacionchalecoaplicacioncolor = cbaplicacioncolor3.getSelectedItem();

            int otraubicacionchalecochalecoaplicacionint = Integer.parseInt(otraubicacionchalecoaplicacion.toString());
            
            
            Object otraubicacion2chaleco = lbpuntadas5.getText();
            Object otraubicacion2chaleconombre = txt5.getText();
            Object otraubicacion2chalecoaplicacion = cbaplicacioncantidad5.getSelectedItem();
            Object otraubicacion2chalecoaplicacioncolor = cbaplicacioncolor5.getSelectedItem();

            int otraubicacion2chalecochalecoaplicacionint = Integer.parseInt(otraubicacion2chalecoaplicacion.toString());
            
            
              Object color1 = cbcolor1.getSelectedItem();
              if(color1==null || color1.equals("")||color1.equals(" "))
            {
                color1 = "";
            }
                Object color2 = cbcolor2.getSelectedItem();
              if(color2==null || color2.equals("")||color2.equals(" "))
            {
                color2 = "";
            }
                Object color3 = cbcolor3.getSelectedItem();
              if(color3==null || color3.equals("")||color3.equals(" "))
            {
                color3 = "";
            }
                Object color4 = cbcolor4.getSelectedItem();
              if(color4==null || color4.equals("")||color4.equals(" "))
            {
                color4 = "";
            }
                Object color5 = cbcolor5.getSelectedItem();
              if(color5==null || color5.equals("")||color5.equals(" "))
            {
                color5 = "";
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
              

        if(actualizarbordado.equals("si"))
        {
             try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pecho_izquierdo = '" + pechoizquierdochaleco + "',pecho_izquierdo_nombre='" + pechoizquierdochaleconombre + "',pecho_derecho='" + pechoderechochaleco + "',pecho_derecho_nombre='" + pechoderechochaleconombre + "',espalda ='" + espaldachaleco + "' ,espalda_nombre ='" + espaldachaleconombre + "' ,otra_ubicacion ='" + otraubicacionchaleco + "', otra_ubicacion_nombre ='" + otraubicacionchaleconombre + "', otra_ubicacion2 ='" + otraubicacion2chaleco + "',otra_ubicacion2_nombre ='" + otraubicacion2chaleconombre + "'   WHERE codigo='" + codigodelcliente + "'  and identificador_prenda = '"+nombrebordado+"'  ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
         try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pecho_izquierdo_aplicacion = '" + pechoizquierdochalecoaplicacion + "',pecho_derecho_aplicacion='" + pechoderechochalecoaplicacion + "',espalda_aplicacion ='" + espaldachalecoaplicacion + "',otra_ubicacion_aplicacion ='" +otraubicacionchalecoaplicacion + "',otra_ubicacion2_aplicacion ='" +otraubicacion2chalecoaplicacion + "'    WHERE codigo='" + codigodelcliente + "' and identificador_prenda = '"+nombrebordado+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
         
         try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pecho_izquierdo_aplicacion_color = '" + pechoizquierdochalecoaplicacioncolor + "',pecho_derecho_aplicacion_color='" + pechoderechochalecoaplicacioncolor + "',espalda_aplicacion_color ='" + espaldachalecoaplicacioncolor + "',otra_ubicacion_aplicacion_color ='" + otraubicacionchalecoaplicacioncolor + "',otra_ubicacion2_aplicacion_color ='" + otraubicacion2chalecoaplicacioncolor + "'   WHERE codigo='" + codigodelcliente + "' and identificador_prenda = '"+nombrebordado+"' ");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
         
        
         try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET identificador_prenda = '"+txtidentificadordeprenda.getText().trim()+"' WHERE codigo='" + codigodelcliente + "' and identificador_prenda = '"+nombrebordado+"'  AND tipo = '"+prenda+"' ");
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
                                                              
                                                               + "hilo1='" + hilo1 + "',"
                                                               + "hilo2 ='" + hilo2 + "' ,"
                                                               + "hilo3 ='" + hilo3 + "',"
                                                               + "hilo4 ='" +hilo4+ "',"   
                                                               + "hilo5 ='"+hilo5+"'  WHERE codigo='" + codigodelcliente + "' and identificador_prenda = '"+nombrebordado+"'  AND tipo = '"+prenda+"' ");          
                                                             
              pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
         
         actualizarenhistorialventasycotizacioneschaleco();
            
        }
       
        else
        {
            insertarnumero();
            String InsertarSQL = "INSERT INTO bordados_puntadas(codigo,nombre,identificador_prenda,tipo,pecho_izquierdo,pecho_izquierdo_nombre,pecho_derecho,pecho_derecho_nombre,espalda,espalda_nombre,otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion2,otra_ubicacion2_nombre,"
                                                                + "pecho_izquierdo_aplicacion,pecho_derecho_aplicacion,espalda_aplicacion,otra_ubicacion_aplicacion,otra_ubicacion2_aplicacion,"
                                                                + "pecho_izquierdo_aplicacion_color,pecho_derecho_aplicacion_color,espalda_aplicacion_color,otra_ubicacion_aplicacion_color,otra_ubicacion2_aplicacion_color,numero_consecutivo,"
                                                                + "color1,color2,color3,color4,color5,hilo1,hilo2,hilo3,hilo4,hilo5) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            
            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);

                pst.setString(1, lbcodigocliente.getText());
                pst.setString(2, lbcliente.getText());
                pst.setString(3, txtidentificadordeprenda.getText().trim());
                pst.setString(4, lbprenda.getText());
                
                pst.setString(5, pechoizquierdochaleco.toString());
                pst.setString(6, pechoizquierdochaleconombre.toString());
                pst.setString(7, pechoderechochaleco.toString());
                pst.setString(8, pechoderechochaleconombre.toString());
                pst.setString(9, espaldachaleco.toString());
                pst.setString(10, espaldachaleconombre.toString());
                pst.setString(11, otraubicacionchaleco.toString());
                pst.setString(12, otraubicacionchaleconombre.toString());
                pst.setString(13, otraubicacion2chaleco.toString());
                pst.setString(14, otraubicacion2chaleconombre.toString());
                
                pst.setString(15, pechoizquierdochalecoaplicacion.toString());
                pst.setString(16, pechoderechochalecoaplicacion.toString());
                pst.setString(17, espaldachalecoaplicacion.toString());
                pst.setString(18, otraubicacionchalecoaplicacion.toString());
                pst.setString(19, otraubicacion2chalecoaplicacion.toString());
                
                
                pst.setString(20, pechoizquierdochalecoaplicacioncolor.toString());
                pst.setString(21, pechoderechochalecoaplicacioncolor.toString());
                pst.setString(22, espaldachalecoaplicacioncolor.toString());
                pst.setString(23, otraubicacionchalecoaplicacioncolor.toString());
                pst.setString(24, otraubicacion2chalecoaplicacioncolor.toString()); 
                pst.setString(25, lbconsecutivo.getText()); 
                
                
                pst.setString(26, color1.toString());
                pst.setString(27, color2.toString());
                pst.setString(28, color3.toString());
                pst.setString(29, color4.toString());
                pst.setString(30, color5.toString());
                 
                pst.setString(31, hilo1.toString());
                pst.setString(32, hilo2.toString());
                pst.setString(33, hilo3.toString());
                pst.setString(34, hilo4.toString());
                pst.setString(35, hilo5.toString());
                                
                pst.executeUpdate();
                pst.close();


            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
        } 
           
        }

         
         // MANDIL
        
        else if (lbprenda.getText().equals("MANDIL"))
        {
            
         Object pechoizquierdomandil = cbpuntadas1.getSelectedItem();
        Object pechoizquierdomandilnombre = txt1.getText();
        Object pechoizquierdomandilaplicacion = cbaplicacioncantidad1.getSelectedItem();
        Object pechoizquierdomandilaplicacioncolor =cbaplicacioncolor1.getSelectedItem();
        
         int pechoizquierdomandilaplicacionint = Integer.parseInt(pechoizquierdochalecoaplicacion.toString()); 
        
        Object pechoderechomandil = cbpuntadas2.getSelectedItem();
        Object pechoderechomandilnombre = txt2.getText();
        Object pechoderechomandilaplicacion = cbaplicacioncantidad2.getSelectedItem();
        Object pechoderechomandilaplicacioncolor =cbaplicacioncolor2.getSelectedItem();
        
        Object centromandil = cbpuntadas3.getSelectedItem();
        Object centromandilnombre = txt3.getText();
        Object centromandilaplicacion = cbaplicacioncantidad3.getSelectedItem();
        Object centromandilaplicacioncolor =cbaplicacioncolor3.getSelectedItem();
        
      //  int espaldamandilaplicacionint = Integer.parseInt(espaldamandilaplicacion.toString()); 
        
        
        
           Object color1 = cbcolor1.getSelectedItem();
              if(color1==null || color1.equals("")||color1.equals(" "))
            {
                color1 = "";
            }
                Object color2 = cbcolor2.getSelectedItem();
              if(color2==null || color2.equals("")||color2.equals(" "))
            {
                color2 = "";
            }
                Object color3 = cbcolor3.getSelectedItem();
              if(color3==null || color3.equals("")||color3.equals(" "))
            {
                color3 = "";
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
             
              
              
              
              
              
              
        if(actualizarbordado.equals("si"))
        {
        
            
             try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pecho_izquierdo = '" + pechoizquierdomandil + "',pecho_izquierdo_nombre='" + pechoizquierdomandilnombre + "',pecho_derecho='" + pechoderechomandil + "',pecho_derecho_nombre='" + pechoderechomandilnombre + "',centro ='" + centromandil + "' ,centro_nombre ='" + centromandilnombre + "'  WHERE codigo='" + codigodelcliente + "'");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        
         try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pecho_izquierdo_aplicacion = '" + pechoizquierdomandilaplicacion + "',pecho_derecho_aplicacion='" + pechoderechomandilaplicacion + "',centro_aplicacion ='" + centromandilaplicacion + "'   WHERE codigo='" + codigodelcliente + "'");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
         
         try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pecho_izquierdo_aplicacion_color = '" + pechoizquierdomandilaplicacioncolor + "',pecho_derecho_aplicacion_color='" + pechoderechomandilaplicacioncolor + "',centro_aplicacion_color ='" + centromandilaplicacioncolor + "'   WHERE codigo='" + codigodelcliente + "'");
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }
          //// Colores e hilos
                
                   try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET "
                                                               + "color1= '" + color1+ "',"
                                                               + "color2= '" + color2+ "',"         
                                                                + "color3= '" + color3+ "',"
                                                              + "hilo1='" + hilo1 + "'," 
                                                              + "hilo2='" + hilo2 + "'," 
                                                               + "hilo3='" + hilo3 + "'  WHERE codigo='" + codigodelcliente + "'");   
                                                             
         
          pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
         
       
        }
        
        else
        {
         
                        insertarnumero();
            
            
            
             String InsertarSQL = "INSERT INTO bordados_puntadas(codigo,nombre,identificador_prenda,tipo,pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo_aplicacion,pecho_izquierdo_aplicacion_color,pecho_derecho,pecho_derecho_nombre,pecho_derecho_aplicacion,pecho_derecho_aplicacion_color,centro,centro_nombre,centro_aplicacion,centro_aplicacion_color,numero_consecutivo,color1,color2,color3,hilo1,hilo2,hilo3) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);

                pst.setString(1, lbcodigocliente.getText());
                pst.setString(2, lbcliente.getText());
                pst.setString(3, txtidentificadordeprenda.getText().trim());
                pst.setString(4, lbprenda.getText());
                
                pst.setString(5, pechoizquierdomandil.toString());
                pst.setString(6, pechoizquierdomandilnombre.toString());
                pst.setString(7, pechoizquierdomandilaplicacion.toString());
                pst.setString(8, pechoizquierdomandilaplicacioncolor.toString());
                
                pst.setString(9, pechoderechomandil.toString());
                pst.setString(10, pechoderechomandilnombre.toString());
                pst.setString(11, pechoderechomandilaplicacion.toString());
                pst.setString(12, pechoderechomandilaplicacioncolor.toString());
                
                pst.setString(13, centromandil.toString());
                pst.setString(14, centromandilnombre.toString());
                pst.setString(15, centromandilaplicacion.toString());
                pst.setString(16, centromandilaplicacioncolor.toString());
                
                
                
                pst.setString(17, lbconsecutivo.getText());
                
                pst.setString(18, color1.toString());
                pst.setString(19, color1.toString());
                pst.setString(20, color1.toString());
                
                pst.setString(21, hilo1.toString());
                pst.setString(22, hilo1.toString());
                pst.setString(23, hilo1.toString());
               

                pst.executeUpdate();
                pst.close();


            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }     
        }
        
        }
        

   
        this.dispose();
        ventanabordadosdelclienteeditar = false;
        
                
                
                
                
        }
        
        }
        
        }
        
        
        
        
        }
        
        dejoespacioalfinal = "no";
         //termina guardar 
         
         
    
      
    }//GEN-LAST:event_btnguardarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventanabordadosdelclienteeditar = false;
        this.dispose();;
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanabordadosdelclienteeditar = false;
        this.dispose();;
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        datos();
        identificador();
        cargarelfotomontaje();
        autorizar();
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

        
    
        identificadordeprenda = txtidentificadordeprenda.getText();
        
        if (pasa.equals("si"))
            
        {
        
        
        
        JFileChooser elegirImagen = new JFileChooser();
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

                String sql = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigodelcliente+"' and identificador_prenda = '"+identificadordeprenda+"' and tipo = '"+lbprenda.getText()+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' ";

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
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombrearchivo+"' where codigo='"+codigodelcliente+"' and identificador_prenda = '"+identificadordeprenda+"' and tipo = '"+lbprenda.getText()+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' ");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            
            
            ImageIcon fot = new ImageIcon(rutaarchivo);
            Icon icono = new ImageIcon(fot.getImage().getScaledInstance(lbfotomontaje.getWidth(), lbfotomontaje.getHeight(), Image.SCALE_DEFAULT));
            lbfotomontaje.setIcon(icono);
            cerrarinterface = "si";
            this.repaint();
            
            
            
               JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Fotomontaje agregado correctamente");
            

        }
        
        }
        
    }//GEN-LAST:event_btnagregarfotomontajeActionPerformed

    private void btnverfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverfotomontajeActionPerformed

        codigodelcliente = lbcodigocliente.getText();
        String cliente = "";
        String rutadelarchivo = "";
        String existe = "";
        String prenda = lbprenda.getText();
        String nombre = txtidentificadordeprenda.getText().trim();
        
       String SQL = "SELECT imagen,extension_imagen FROM bordados_puntadas where codigo = '"+codigodelcliente+"' and tipo = '"+prenda+"' and identificador_prenda = '"+nombre+"'  ";

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
        String prenda = lbprenda.getText();
        String nombre = txtidentificadordeprenda.getText().trim();
        
        
        int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea Eliminar esta Imagen permanentemente?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {

            
            
            String SQL = "SELECT imagen FROM bordados_puntadas where codigo = '"+codigodelcliente+"'  and tipo = '"+prenda+"' and identificador_prenda = '"+nombre+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' ";

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

                    PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET imagen=NULL, extension_imagen='' WHERE codigo='"+codigodelcliente+"' and tipo = '"+prenda+"' and identificador_prenda = '"+nombre+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' ");
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
        String tipo = lbprenda.getText();
          
        int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea Eliminar este bordado?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {

             try {
                Statement st = cn.createStatement();
                PreparedStatement pst = cn.prepareStatement("DELETE FROM bordados_puntadas WHERE  codigo='"+codigodelcliente+"' and identificador_prenda = '"+conceptoprenda+"' AND tipo = '"+tipo+"' and numero_consecutivo = '"+txtcodigocatalogobordados.getText()+"' ");
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
            }
            this.dispose();
            
        }       
    }//GEN-LAST:event_btneliminartodoActionPerformed

    private void btndatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndatosActionPerformed
      datos();
      cargarelfotomontaje();
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
               
               
               
               
               if (!hiloencombo.equals("0")  && (!hiloencombo.equals(hilosincolor)))
                   
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
               
               
               
               
               if (!hiloencombo.equals("0") && (!hiloencombo.equals(hilosincolor)))
                   
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
            
            if (!hiloencombo.equals("0") )
                
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
               
               
               
               
               if (!hiloencombo.equals("0")  && (!hiloencombo.equals(hilosincolor)))
                   
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
               
               
               
               
               if (!hiloencombo.equals("0")  && (!hiloencombo.equals(hilosincolor)))
                   
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
               
               
               
               
               if (!hiloencombo.equals("0") && (!hiloencombo.equals(hilosincolor)))
                   
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
               
               
               
               
               if (!hiloencombo.equals("0")  && (!hiloencombo.equals(hilosincolor)))
                   
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
               
               
               
               
               if (!hiloencombo.equals("0")  && (!hiloencombo.equals(hilosincolor)))
                   
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
       
        
            String cadena[] = nombre.split("");
             
        char ultimocaracter = nombre.charAt(cadena.length-1);
        
        
        String ultimocararterstring = String.valueOf(ultimocaracter);
        
        if (ultimocararterstring.equals(" "))
            
        {
           
            dejoespacioalfinal = "si";
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
                txt1.requestFocus();
                txt1.selectAll();
             
        }       
                
        
        
        else
            
            
        {
        
        
        
         
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
    
    
    
    
        }
    
     
        
        
        
    }//GEN-LAST:event_txt1FocusLost

    private void txt2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2FocusLost

        
        
        
        
            String nombre = txt2.getText();
       
        
            String cadena[] = nombre.split("");
             
        char ultimocaracter = nombre.charAt(cadena.length-1);
        
        
        String ultimocararterstring = String.valueOf(ultimocaracter);
        
        if (ultimocararterstring.equals(" "))
            
        {
           
            dejoespacioalfinal = "si";
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
                txt2.requestFocus();
                txt2.selectAll();
             
        }       
                
        
        
        else
            
            
        {
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
        }
        
        
        
    
    }//GEN-LAST:event_txt2FocusLost

    private void txt3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3FocusLost
      
        
        
            String nombre = txt3.getText();
       
        
            String cadena[] = nombre.split("");
             
        char ultimocaracter = nombre.charAt(cadena.length-1);
        
        
        String ultimocararterstring = String.valueOf(ultimocaracter);
        
        if (ultimocararterstring.equals(" "))
            
        {
           
            dejoespacioalfinal = "si";
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
                txt3.requestFocus();
                txt3.selectAll();
             
        }       
                
        
        
        else
            
            
        {
        
       ;
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
        }
    
    
    }//GEN-LAST:event_txt3FocusLost

    private void txt4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4FocusLost
       
        
        
            String nombre = txt4.getText();
       
        
            String cadena[] = nombre.split("");
             
        char ultimocaracter = nombre.charAt(cadena.length-1);
        
        
        String ultimocararterstring = String.valueOf(ultimocaracter);
        
        if (ultimocararterstring.equals(" "))
            
        {
           
            dejoespacioalfinal = "si";
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
                txt4.requestFocus();
                txt4.selectAll();
             
        }       
                
        
        
        else
            
            
        {
        
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
    
    
        }
    
    
    
    }//GEN-LAST:event_txt4FocusLost

    private void txt5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5FocusLost
     
        
        
            String nombre = txt5.getText();
       
        
            String cadena[] = nombre.split("");
             
        char ultimocaracter = nombre.charAt(cadena.length-1);
        
        
        String ultimocararterstring = String.valueOf(ultimocaracter);
        
        if (ultimocararterstring.equals(" "))
            
        {
           
            dejoespacioalfinal = "si";
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
                txt5.requestFocus();
                txt5.selectAll();
             
        }       
                
        
        
        else
            
            
        {
        
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
    
    
        }
    
    
    }//GEN-LAST:event_txt5FocusLost

    private void txt6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6FocusLost
       
        
        
        
        
            String nombre = txt6.getText();
       
        
            String cadena[] = nombre.split("");
             
        char ultimocaracter = nombre.charAt(cadena.length-1);
        
        
        String ultimocararterstring = String.valueOf(ultimocaracter);
        
        if (ultimocararterstring.equals(" "))
            
        {
           
            dejoespacioalfinal = "si";
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
                txt6.requestFocus();
                txt6.selectAll();
             
        }       
                
        
        
        else
            
            
        {
        
          
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
    
    
        }
    
    
    
    }//GEN-LAST:event_txt6FocusLost

    private void txt7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7FocusLost
      
        
        
        
            String nombre = txt7.getText();
       
        
            String cadena[] = nombre.split("");
             
        char ultimocaracter = nombre.charAt(cadena.length-1);
        
        
        String ultimocararterstring = String.valueOf(ultimocaracter);
        
        if (ultimocararterstring.equals(" "))
            
        {
           
            dejoespacioalfinal = "si";
            
           JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
                txt7.requestFocus();
                txt7.selectAll();
             
        }       
                
        
        
        else
            
            
        {
        
        
    
     
    if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI") )
     {
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
     }
     
    
    
        }
    
    
    }//GEN-LAST:event_txt7FocusLost

    private void cbpuntadas5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas5PopupMenuWillBecomeInvisible

        
        
        
        String tipo = lbprenda.getText();
        
       if (!tipo.startsWith("CHAMARRA DESMONTABLE"))
           
       {
        
        String puntadas = cbpuntadas5.getSelectedItem().toString();

        if (puntadas.equals("ninguno"))
        {
              cbaroespalda.setSelectedItem("no");
            lbpuntadas5.setText("");
        }
        else
        { cbaroespalda.setSelectedItem("no");
            lbpuntadas5.setText(puntadas);
          
        }
        
        
       }
        
        
        
        
    }//GEN-LAST:event_cbpuntadas5PopupMenuWillBecomeInvisible

    private void cbpuntadas1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas1PopupMenuWillBecomeInvisible
       
        
        
    }//GEN-LAST:event_cbpuntadas1PopupMenuWillBecomeInvisible

    private void cbpuntadas2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas2PopupMenuWillBecomeInvisible
        
        
        
        
    }//GEN-LAST:event_cbpuntadas2PopupMenuWillBecomeInvisible

    private void cbpuntadas3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas3PopupMenuWillBecomeInvisible
      
        
        
        
    }//GEN-LAST:event_cbpuntadas3PopupMenuWillBecomeInvisible

    private void cbpuntadas4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas4PopupMenuWillBecomeInvisible
       
        
        
        
        
    }//GEN-LAST:event_cbpuntadas4PopupMenuWillBecomeInvisible

    private void cbpuntadas5PopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas5PopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_cbpuntadas5PopupMenuCanceled

    private void cbpuntadas6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas6PopupMenuWillBecomeInvisible
       
        
        
        
        
    }//GEN-LAST:event_cbpuntadas6PopupMenuWillBecomeInvisible

    private void cbpuntadas7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas7PopupMenuWillBecomeInvisible
      
        
        
        
        
    }//GEN-LAST:event_cbpuntadas7PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad1PopupMenuWillBecomeInvisible
       
        
        
        
        
    }//GEN-LAST:event_cbaplicacioncantidad1PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad2PopupMenuWillBecomeInvisible
       
        
        
        
        
    }//GEN-LAST:event_cbaplicacioncantidad2PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad3PopupMenuWillBecomeInvisible
       
        
        
        
        
        
    }//GEN-LAST:event_cbaplicacioncantidad3PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad4PopupMenuWillBecomeInvisible
       
        
        
        
        
    }//GEN-LAST:event_cbaplicacioncantidad4PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad5PopupMenuWillBecomeInvisible
      
        
        
        
        
    }//GEN-LAST:event_cbaplicacioncantidad5PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad6PopupMenuWillBecomeInvisible
       
        
        
        
        
    }//GEN-LAST:event_cbaplicacioncantidad6PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad7PopupMenuWillBecomeInvisible
       
        
        
        
        
        
    }//GEN-LAST:event_cbaplicacioncantidad7PopupMenuWillBecomeInvisible

    private void cbaplicacioncantidad2PopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad2PopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_cbaplicacioncantidad2PopupMenuCanceled

    private void cbaplicacioncantidad3PopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncantidad3PopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_cbaplicacioncantidad3PopupMenuCanceled

    private void cbaplicacioncolor1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncolor1PopupMenuWillBecomeInvisible
       
    }//GEN-LAST:event_cbaplicacioncolor1PopupMenuWillBecomeInvisible

    private void cbaplicacioncolor2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncolor2PopupMenuWillBecomeInvisible
        
    }//GEN-LAST:event_cbaplicacioncolor2PopupMenuWillBecomeInvisible

    private void cbaplicacioncolor3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncolor3PopupMenuWillBecomeInvisible
        
    }//GEN-LAST:event_cbaplicacioncolor3PopupMenuWillBecomeInvisible

    private void cbaplicacioncolor4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncolor4PopupMenuWillBecomeInvisible
        
    }//GEN-LAST:event_cbaplicacioncolor4PopupMenuWillBecomeInvisible

    private void cbaplicacioncolor5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncolor5PopupMenuWillBecomeInvisible
        
    }//GEN-LAST:event_cbaplicacioncolor5PopupMenuWillBecomeInvisible

    private void cbaplicacioncolor6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncolor6PopupMenuWillBecomeInvisible
        
    }//GEN-LAST:event_cbaplicacioncolor6PopupMenuWillBecomeInvisible

    private void cbaplicacioncolor7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaplicacioncolor7PopupMenuWillBecomeInvisible
       
    }//GEN-LAST:event_cbaplicacioncolor7PopupMenuWillBecomeInvisible

    private void cbbordados7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbordados7PopupMenuWillBecomeInvisible
       
         String puntadas = cbbordados7.getSelectedItem().toString();
       String bordado = cbbordados7.getSelectedItem().toString();
        
        
         if (puntadas.equals("SEGURIDAD #1"))
         {
             puntadas = "BORDADO DE 10,000 A 12,500 PUNTADAS";
             txt7.setText(bordado);
         }
        else if (puntadas.equals("SEGURIDAD #2"))
         {
             puntadas = "BORDADO DE 20,000 A 22,500 PUNTADAS";
             txt7.setText(bordado);
         }
        else if (puntadas.equals("SEGURIDAD PRIVADA #1"))
         {
             puntadas = "BORDADO DE 10,000 A 12,500 PUNTADAS";
             txt7.setText(bordado);
         }
        else  if (puntadas.equals("SEGURIDAD PRIVADA #2"))
         {
             puntadas = "BORDADO DE 15,000 A 17,500 PUNTADAS";
             txt7.setText(bordado);
         }
        else   if (puntadas.equals("SEGURIDAD PRIVADA #3"))
         {
             puntadas = "BORDADO DE 37,500,000 A 40,000 PUNTADAS";
             txt7.setText(bordado);
         }
        
         else
        {   
        
        if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno"))
            
        {
          
            
            String encontrado = "no";
            String sql = "SELECT distinct espalda_nombre,espalda FROM bordados_puntadas where codigo = '"+codigodelcliente+"' "
                       + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                       + "and espalda_nombre = '"+puntadas+"'";
                      
            
                      String pechoizquierdonombre = "";
                      String pechoizquierdo = "";
                      
                    
                      
                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                   pechoizquierdonombre = rs.getString("espalda_nombre"); 
                   pechoizquierdo = rs.getString("espalda"); 
                   encontrado = "si";
                
                   
                   if (pechoizquierdonombre.startsWith(puntadas))
                   {
                     puntadas =  pechoizquierdo; 
                   }
                   
                  
                  
                   
                   
                   cbpuntadas7.setSelectedItem(puntadas);
                   txt7.setText(bordado);
                   
                   
                   
                }
                
               
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            /////Colorido bordados

            if(encontrado.equals("no"))
            {
                
            
            String sql2 = "SELECT distinct puntadas FROM colorido_bordados where codigo = '"+codigodelcliente+"' and identificador_prenda = '"+puntadas+"' ";

                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                if (rs.next()) {

                   
                   String numeropuntadas = rs.getString("puntadas"); 
 
                   cbpuntadas7.setSelectedItem(numeropuntadas);
                   txt7.setText(puntadas);
                   encontrado ="si";
                   
                   
                }
                
                
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            }
        
            
            if(encontrado.equals("no"))
            {
              
                 JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                
                
            }
            else
            {
               
            } 
            

        }
         
        else
            
        {
        cbpuntadas7.setSelectedItem(puntadas); 
        txt7.setText(bordado);
        
        
        }

        }
        
        
    }//GEN-LAST:event_cbbordados7PopupMenuWillBecomeInvisible

    private void cbbordados2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbordados2PopupMenuWillBecomeInvisible
        
        String puntadas = cbbordados2.getSelectedItem().toString();
         String bordado = cbbordados2.getSelectedItem().toString();
        
         if (puntadas.equals("SEGURIDAD"))
         {
             puntadas = "BORDADO DE MENOS DE 5,000 PUNTADAS";
              txt2.setText(bordado);
         }
         if (puntadas.equals("SEGURIDAD PRIVADA"))
         {
             puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
             txt2.setText(bordado);
         }
          if (puntadas.equals("VIGILANCIA"))
         {
             puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
             txt2.setText(bordado);
         }
          if (puntadas.equals("PORTA NOMBRE"))
         {
             puntadas = "BORDADO DE 5,000 A 7,500 PUNTADAS";
              txt1.setText(bordado);
         }
          
          
        
        if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno"))
            
        {
          
            String encontrado = "no";
            
            String sql = "SELECT distinct pecho_izquierdo_nombre,pecho_izquierdo,pecho_derecho_nombre,pecho_derecho FROM bordados_puntadas where codigo = '"+codigodelcliente+"' "
                       + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                       + "and pecho_izquierdo_nombre = '"+puntadas+"' or pecho_derecho_nombre = '"+puntadas+"' ";
                      
            
                      String pechoizquierdonombre = "";
                      String pechoizquierdo = "";
                      
                      String pechoderechonombre = "";
                      String pechoderecho = "";
                      
                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                   pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre"); 
                   pechoizquierdo = rs.getString("pecho_izquierdo"); 
                   
                   pechoderechonombre = rs.getString("pecho_derecho_nombre"); 
                   pechoderecho = rs.getString("pecho_derecho"); 
                    
                   encontrado = "si";
                   
                   
                   if (pechoizquierdonombre.startsWith(puntadas))
                   {
                     puntadas =  pechoizquierdo; 
                   }
                   
                   if (pechoderechonombre.startsWith(puntadas))
                   {
                       puntadas =  pechoderecho; 
                   }
                   
                  
                   
                   
                   cbpuntadas2.setSelectedItem(puntadas);
                   txt2.setText(bordado);
                   encontrado = "si";
                   
                   
                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            /////Colorido bordados

            if(encontrado.equals("no"))
            {
                
            
            String sql2 = "SELECT distinct puntadas FROM colorido_bordados where codigo = '"+codigodelcliente+"' and identificador_prenda = '"+puntadas+"' ";

                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                if (rs.next()) {

                   
                   String numeropuntadas = rs.getString("puntadas"); 
 
                   cbpuntadas2.setSelectedItem(numeropuntadas);
                   txt2.setText(numeropuntadas);
                   encontrado ="si";
                   
                   
                }
                
                
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            }
        
            
            if(encontrado.equals("no"))
            {
              
                 JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                
                
            }
            else
            {
                
            } 
            

        }
         
        else
            
        {
        cbpuntadas2.setSelectedItem(puntadas);
        
        }
        
        
        
    }//GEN-LAST:event_cbbordados2PopupMenuWillBecomeInvisible

    private void cbbordados1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbordados1PopupMenuWillBecomeInvisible
       
        String puntadas = cbbordados1.getSelectedItem().toString();
          String bordado = cbbordados1.getSelectedItem().toString();
        
         if (puntadas.equals("SEGURIDAD"))
         {
             puntadas = "BORDADO DE MENOS DE 5,000 PUNTADAS";
              txt1.setText(bordado);
         }
         if (puntadas.equals("SEGURIDAD PRIVADA"))
         {
             puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
              txt1.setText(bordado);
         }
          if (puntadas.equals("VIGILANCIA"))
         {
             puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
              txt1.setText(bordado);
         }
          
          if (puntadas.equals("PORTA NOMBRE"))
         {
             puntadas = "BORDADO DE 5,000 A 7,500 PUNTADAS";
              txt1.setText(bordado);
         }
         
          
          
          
          
          
        if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno"))
            
        {
          
            String encontrado = "no";
            String sql = "";
            
            /// bordados puntadas
            
            String pechoizquierdonombre = "";
            String pechoizquierdo = "";

            String pechoderechonombre = "";
            String pechoderecho = "";
            
            String frente = "";
            String frentenombre="";
            
            
            
            
            
            
            
            
            
            
           if(prenda.equals("GORRA"))
           {
                sql = "SELECT distinct frente_nombre,frente FROM bordados_puntadas where codigo = '"+codigodelcliente+"' "
                       + "and tipo = 'GORRA' and frente_nombre = '"+puntadas+"' ";
               
           }
           else
           {
                sql = "SELECT distinct pecho_izquierdo_nombre,pecho_izquierdo,pecho_derecho_nombre,pecho_derecho FROM bordados_puntadas where codigo = '"+codigodelcliente+"' "
                       + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                       + "and pecho_izquierdo_nombre = '"+puntadas+"' or pecho_derecho_nombre = '"+puntadas+"' ";
               
           }
           
            
                      
            
                     
                      
                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) 
                {

                if(prenda.equals("GORRA"))
                {
                   frentenombre = rs.getString("frente_nombre"); 
                   frente = rs.getString("frente"); 
                   
                   puntadas =  frente; 
                   bordado = frentenombre;
                   
                   encontrado = "si";
                    
                }
                    
                else   
                {    
                   pechoizquierdonombre = rs.getString("pecho_izquierdo_nombre"); 
                   pechoizquierdo = rs.getString("pecho_izquierdo"); 
                   
                   pechoderechonombre = rs.getString("pecho_derecho_nombre"); 
                   pechoderecho = rs.getString("pecho_derecho"); 
                    
                   
                   if (pechoizquierdonombre.startsWith(puntadas))
                   {
                     puntadas =  pechoizquierdo; 
                   }
                   
                   if (pechoderechonombre.startsWith(puntadas))
                   {
                       puntadas =  pechoderecho; 
                   }
                   
                }
                   
                  
                   
                   
                   cbpuntadas1.setSelectedItem(puntadas);
                   txt1.setText(bordado);
                   encontrado = "si";
                   
                   
                }
                
               
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            
            
            
            
            
            /////Colorido bordados

            if(encontrado.equals("no"))
            {
                
            
            String sql2 = "SELECT distinct puntadas FROM colorido_bordados where codigo = '"+codigodelcliente+"' and identificador_prenda = '"+puntadas+"' ";

                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                if (rs.next()) {

                   
                   String numeropuntadas = rs.getString("puntadas"); 
 
                   cbpuntadas1.setSelectedItem(numeropuntadas);
                   txt1.setText(numeropuntadas);
                   encontrado ="si";
                   
                   
                }
                
                
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            }
        
            
            if(encontrado.equals("no"))
            {
              
                 JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                
                
            }
            else
            {
                
            }    
            
        
        }
         
        else
            
        {
        cbpuntadas1.setSelectedItem(puntadas);
        
        }
       
    }//GEN-LAST:event_cbbordados1PopupMenuWillBecomeInvisible

    private void cbbordados6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbordados6PopupMenuWillBecomeInvisible
      
        String puntadas = cbbordados6.getSelectedItem().toString();
       String bordado = cbbordados6.getSelectedItem().toString();
        
        
         if (puntadas.equals("SEGURIDAD #1"))
         {
             puntadas = "BORDADO DE 10,000 A 12,500 PUNTADAS";
             txt6.setText(bordado);
         }
         else if (puntadas.equals("SEGURIDAD #2"))
         {
             puntadas = "BORDADO DE 20,000 A 22,500 PUNTADAS";
             txt6.setText(bordado);
         }
         else if (puntadas.equals("SEGURIDAD PRIVADA #1"))
         {
             puntadas = "BORDADO DE 10,000 A 12,500 PUNTADAS";
             txt6.setText(bordado);
         }
         else if (puntadas.equals("SEGURIDAD PRIVADA #2"))
         {
             puntadas = "BORDADO DE 15,000 A 17,500 PUNTADAS";
             txt6.setText(bordado);
         }
         else  if (puntadas.equals("SEGURIDAD PRIVADA #3"))
         {
             puntadas = "BORDADO DE 37,500,000 A 40,000 PUNTADAS";
             txt6.setText(bordado);
         }
        else
         {   
         
        
        if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno"))
            
        {
          
            
            String encontrado = "no";
            String sql = "SELECT distinct espalda_nombre,espalda FROM bordados_puntadas where codigo = '"+codigodelcliente+"' "
                       + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                       + "and espalda_nombre = '"+puntadas+"'";
                      
            
                      String pechoizquierdonombre = "";
                      String pechoizquierdo = "";
                      
                    
                      
                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                   pechoizquierdonombre = rs.getString("espalda_nombre"); 
                   pechoizquierdo = rs.getString("espalda"); 
                   encontrado = "si";
                
                   
                   if (pechoizquierdonombre.startsWith(puntadas))
                   {
                     puntadas =  pechoizquierdo; 
                   }
                   
                  
                  
                   
                   
                   cbpuntadas6.setSelectedItem(puntadas);
                   txt6.setText(bordado);
                   
                   
                   
                }
                
               
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            /////Colorido bordados

            if(encontrado.equals("no"))
            {
                
            
            String sql2 = "SELECT distinct puntadas FROM colorido_bordados where codigo = '"+codigodelcliente+"' and identificador_prenda = '"+puntadas+"' ";

                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                if (rs.next()) {

                   
                   String numeropuntadas = rs.getString("puntadas"); 
 
                   cbpuntadas6.setSelectedItem(numeropuntadas);
                   txt6.setText(bordado);
                   encontrado ="si";
                   
                   
                }
                
                
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            }
        
            
            if(encontrado.equals("no"))
            {
              
                 JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                
                
            }
            else
            {
               
            } 
            

        }
         
        else
            
        {
        cbpuntadas6.setSelectedItem(puntadas); 
        txt6.setText(bordado);
        
        
        }

        
         }
        
        
    }//GEN-LAST:event_cbbordados6PopupMenuWillBecomeInvisible

    private void cbbordados3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbordados3PopupMenuWillBecomeInvisible
      
       String puntadas = cbbordados3.getSelectedItem().toString();
        String bordado = cbbordados3.getSelectedItem().toString();
        
         if (puntadas.equals("SEGURIDAD"))
         {
             puntadas = "BORDADO DE MENOS DE 5,000 PUNTADAS";
             txt3.setText(bordado);
         }
         if (puntadas.equals("SEGURIDAD PRIVADA"))
         {
             puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
             txt3.setText(bordado);
         }
          if (puntadas.equals("VIGILANCIA"))
         {
             puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
             txt3.setText(bordado);
         }
    
       
          
          
        if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno"))
            
        {
          
            String encontrado = "no";
            
            String sql = "SELECT distinct manga_izquierda_nombre,manga_izquierda,manga_derecha_nombre,manga_derecha FROM bordados_puntadas where codigo = '"+codigodelcliente+"' "
                       + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                       + "and manga_izquierda_nombre = '"+puntadas+"' or manga_derecha_nombre = '"+puntadas+"' ";
                      
            
                      String pechoizquierdonombre = "";
                      String pechoizquierdo = "";
                      
                      String pechoderechonombre = "";
                      String pechoderecho = "";
                      
                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                   pechoizquierdonombre = rs.getString("manga_izquierda_nombre"); 
                   pechoizquierdo = rs.getString("manga_izquierda"); 
                   
                   pechoderechonombre = rs.getString("manga_derecha_nombre"); 
                   pechoderecho = rs.getString("manga_derecha"); 
                    
                   
                   if (pechoizquierdonombre.startsWith(puntadas))
                   {
                     puntadas =  pechoizquierdo; 
                   }
                   
                   if (pechoderechonombre.startsWith(puntadas))
                   {
                       puntadas =  pechoderecho; 
                   }
                   
                  
                   
                   
                   cbpuntadas3.setSelectedItem(puntadas);
                   txt3.setText(bordado);
                   encontrado = "si";
                   
                   
                }
                
               
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
             /////Colorido bordados

            if(encontrado.equals("no"))
            {
                
            
            String sql2 = "SELECT distinct puntadas FROM colorido_bordados where codigo = '"+codigodelcliente+"' and identificador_prenda = '"+puntadas+"' ";

                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                if (rs.next()) {

                   
                   String numeropuntadas = rs.getString("puntadas"); 
 
                   cbpuntadas3.setSelectedItem(numeropuntadas);
                   txt3.setText(numeropuntadas);
                   encontrado ="si";
                   
                   
                }
                
                
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            }
        
            
            if(encontrado.equals("no"))
            {
              
                 JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                
                
            }
            else
            {
                
            } 
            

        }
         
        else
            
        {
        cbpuntadas3.setSelectedItem(puntadas);
        
        }
        
    }//GEN-LAST:event_cbbordados3PopupMenuWillBecomeInvisible

    private void cbbordados4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbordados4PopupMenuWillBecomeInvisible
       
          String puntadas = cbbordados4.getSelectedItem().toString();
         String bordado = cbbordados4.getSelectedItem().toString();
        
         if (puntadas.equals("SEGURIDAD"))
         {
             puntadas = "BORDADO DE MENOS DE 5,000 PUNTADAS";
             txt4.setText(bordado);
         }
         if (puntadas.equals("SEGURIDAD PRIVADA"))
         {
             puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
             txt4.setText(bordado);
         }
          if (puntadas.equals("VIGILANCIA"))
         {
             puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
             txt4.setText(bordado);
         }
        
          
          
          
          if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno"))
            
        {
          
            String encontrado = "no";
            
            String sql = "SELECT distinct manga_izquierda_nombre,manga_izquierda,manga_derecha_nombre,manga_derecha FROM bordados_puntadas where codigo = '"+codigodelcliente+"' "
                       + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                       + "and manga_izquierda_nombre = '"+puntadas+"' or manga_derecha_nombre = '"+puntadas+"' ";
                      
            
                      String pechoizquierdonombre = "";
                      String pechoizquierdo = "";
                      
                      String pechoderechonombre = "";
                      String pechoderecho = "";
                      
                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                   pechoizquierdonombre = rs.getString("manga_izquierda_nombre"); 
                   pechoizquierdo = rs.getString("manga_izquierda"); 
                   
                   pechoderechonombre = rs.getString("manga_derecha_nombre"); 
                   pechoderecho = rs.getString("manga_derecha"); 
                   
                   encontrado = "si";
                   
                   if (pechoizquierdonombre.startsWith(puntadas))
                   {
                     puntadas =  pechoizquierdo; 
                   }
                   
                   if (pechoderechonombre.startsWith(puntadas))
                   {
                       puntadas =  pechoderecho; 
                   }
                   
                  
                   
                   
                   cbpuntadas4.setSelectedItem(puntadas);
                   txt4.setText(bordado);
                   
                   
                   
                }

                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            /////Colorido bordados

            if(encontrado.equals("no"))
            {
                
            
            String sql2 = "SELECT distinct puntadas FROM colorido_bordados where codigo = '"+codigodelcliente+"' and identificador_prenda = '"+puntadas+"' ";

                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                if (rs.next()) {

                   
                   String numeropuntadas = rs.getString("puntadas"); 
 
                   cbpuntadas4.setSelectedItem(numeropuntadas);
                   txt4.setText(numeropuntadas);
                   encontrado ="si";
                   
                   
                }
                
                
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            }
        
            
            if(encontrado.equals("no"))
            {
              
                 JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                
                
            }
            else
            {
                
            } 
            

        }
         
        else
            
        {
        cbpuntadas4.setSelectedItem(puntadas);
        
        }
        
    }//GEN-LAST:event_cbbordados4PopupMenuWillBecomeInvisible

    private void cbbordados5PopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbordados5PopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbordados5PopupMenuCanceled

    private void cbbordados5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbbordados5PopupMenuWillBecomeInvisible
       
       String puntadas = cbbordados5.getSelectedItem().toString();
       String bordado = cbbordados5.getSelectedItem().toString();
       String buscarbordado = "";
        
        
         if (bordado.equals("SEGURIDAD #1"))
         {
             puntadas = "BORDADO DE 10,000 A 12,500 PUNTADAS";
             txt5.setText(bordado);
             buscarbordado = "no";
         }
        
         if (bordado.equals("SEGURIDAD #2"))
         {
             puntadas = "BORDADO DE 20,000 A 22,500 PUNTADAS";
             txt5.setText(bordado);
             buscarbordado = "no";
         }
         if (bordado.equals("SEGURIDAD PRIVADA #1"))
         {
             puntadas = "BORDADO DE 10,000 A 12,500 PUNTADAS";
             txt5.setText(bordado);
             buscarbordado = "no";
         }
          if (bordado.equals("SEGURIDAD PRIVADA #2"))
         {
             puntadas = "BORDADO DE 15,000 A 17,500 PUNTADAS";
             txt5.setText(bordado);
             buscarbordado = "no";
         }
           if (bordado.equals("SEGURIDAD PRIVADA #3"))
         {
             puntadas = "BORDADO DE 37,500,000 A 40,000 PUNTADAS";
             txt5.setText(bordado);
             buscarbordado = "no";
         }
        
         
        
        if (buscarbordado.equals("") )  ///if (!bordado.startsWith("BORDADO") && !bordado.equals("ninguno"))
            
        {
          
            
            String encontrado = "no";
            String sql = "SELECT distinct espalda_nombre,espalda FROM bordados_puntadas where codigo = '"+codigodelcliente+"' "
                       + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                       + "and espalda_nombre = '"+puntadas+"'";
                      
            
                      String pechoizquierdonombre = "";
                      String pechoizquierdo = "";
                      
                    
                      
                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                   pechoizquierdonombre = rs.getString("espalda_nombre"); 
                   pechoizquierdo = rs.getString("espalda"); 
                   encontrado = "si";
                
                   
                   if (pechoizquierdonombre.startsWith(puntadas))
                   {
                     puntadas =  pechoizquierdo; 
                   }
                   
                  
                  
                   
                   
                   cbpuntadas5.setSelectedItem(puntadas);
                   txt5.setText(bordado);
                   
                   
                   
                }
                
               
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            /////Colorido bordados

            if(encontrado.equals("no"))
            {
                
            
            String sql2 = "SELECT distinct puntadas FROM colorido_bordados where codigo = '"+codigodelcliente+"' and identificador_prenda = '"+puntadas+"' ";

                      
            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql2);
                if (rs.next()) {

                   
                   String numeropuntadas = rs.getString("puntadas"); 
 
                   cbpuntadas5.setSelectedItem(numeropuntadas);
                   txt5.setText(puntadas);
                   encontrado ="si";
                   
                   
                }
                
                
                

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            }
        
            
            if(encontrado.equals("no"))
            {
              
                 JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                
                
            }
            else
            {
               
            } 
            

        }
         
        else
            
        {
        cbpuntadas5.setSelectedItem(puntadas); 
        txt5.setText(bordado);
        
        
        }
    }//GEN-LAST:event_cbbordados5PopupMenuWillBecomeInvisible

    private void btnagregarfotomontajeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnagregarfotomontajeMouseEntered
      
        
        
        
        // COMENTARITO 
          
        btnagregarfotomontaje.setToolTipText(""
               
               + "<html><head><style>#contenido{background: #FFFF33;font-size: 18pt;color: black;</style></head><body><div id= 'contenido'>"
           
            + "<html><center>Para agregar fotomontaje</p><center>primero debe guardar</p><center>loa datos<html>"
             
               + "</div></body></html>");
       
        
        
        
        
        
        
        
    }//GEN-LAST:event_btnagregarfotomontajeMouseEntered

    private void cbaroespaldaPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbaroespaldaPopupMenuWillBecomeInvisible

        Object respuestaobject = cbaroespalda.getSelectedItem();

        Object puntadasespalda = cbpuntadas5.getSelectedItem();

        Object prenda = lbprenda.getText();

        String nuevaspuntadas = "";

        if (respuestaobject.equals("no"))
        {

            lbpuntadas5.setText(puntadasespalda.toString());

        }
        else
        {

            if (prenda.equals("CHAMARRA DESMONTABLE"))

            {

                if (puntadasespalda.equals("BORDADO DE 5,000 A 7,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 7,500 A 10,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 7,500 A 10,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 10,000 A 12,500 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 10,000 A 12,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 12,500 A 15,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 12,500 A 15,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 15,000 A 17,500 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 15,000 A 17,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 17,500 A 20,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 17,500 A 20,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 20,000 A 22,500 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 20,000 A 22,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 22,500 A 25,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 22,500 A 25,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 25,000 A 27,500 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 25,000 A 27,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 27,500 A 30,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 27,500 A 30,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 30,000 A 32,500 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 30,000 A 32,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 32,500 A 35,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 32,500 A 35,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 35,000 A 37,500 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 35,000 A 37,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 37,500 A 40,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 37,500 A 40,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 40,000 A 42,500 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 40,000 A 42,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 42,500 A 45,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 42,500 A 45,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 45,000 A 47,500 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 45,000 A 47,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 47,500 A 50,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 47,500 A 50,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 50,000 A 52,500 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 50,000 A 52,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 52,500 A 55,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 52,500 A 55,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 55,000 A 57,500 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 55,000 A 57,500 PUNTADAS")){nuevaspuntadas = "BORDADO DE 57,500 A 60,000 PUNTADAS";}
                if (puntadasespalda.equals("BORDADO DE 57,500 A 60,000 PUNTADAS")){nuevaspuntadas = "BORDADO DE 60,000 A 62,500 PUNTADAS";}

                lbpuntadas5.setText(nuevaspuntadas);

            }
            
            else
            {
                lbpuntadas5.setText(puntadasespalda.toString());
            }

        }
    }//GEN-LAST:event_cbaroespaldaPopupMenuWillBecomeInvisible

    private void btnimportarfotomontajeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimportarfotomontajeActionPerformed

        String pechoizquierdo = txt1.getText();
        String pechoderecho = txt2.getText();
        String mangaderecha = txt4.getText();
        String mangaizquierda = txt3.getText();
        String espalda = txt5.getText();
        String otraubicacion = txt6.getText();
        String otraubicacion2 = txt7.getText();

        String tipo = lbprenda.getText();
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

        ////
        else if(tipo.equals("PLAYERA"))
        {

            for(int i = 0; i < 5 ; i++)
            {

                if (i == 0)
                {

                    sql = "SELECT playera_pecho_izquierdo_nombre,playera_pecho_derecho_nombre,playera_manga_derecha_nombre,playera_manga_izquierda_nombre,playera_espalda_nombre FROM puntadas_playera where codigo = '" + codigocliente + "' ";
                }
                else  if (i == 1)
                {

                    sql = "SELECT playera2_pecho_izquierdo_nombre,playera2_pecho_derecho_nombre,playera2_manga_derecha_nombre,playera2_manga_izquierda_nombre,playera2_espalda_nombre  FROM puntadas_playera where codigo = '" + codigocliente + "' ";

                } else if (i == 2) {

                    sql = "SELECT playera3_pecho_izquierdo_nombre,playera3_pecho_derecho_nombre,playera3_manga_derecha_nombre,playera3_manga_izquierda_nombre,playera3_espalda_nombre  FROM puntadas_playera where codigo = '" + codigocliente + "' ";

                }
                else if (i == 3) {

                    sql = "SELECT playera4_pecho_izquierdo_nombre,playera4_pecho_derecho_nombre,playera4_manga_derecha_nombre,playera4_manga_izquierda_nombre,playera4_otra_ubicacion_nombre,playera4_otra_ubicacion2_nombre,playera4_espalda_nombre FROM puntadas_playera where codigo = '" + codigocliente + "' ";

                }
                else if (i == 4) {

                    sql = "SELECT playera5_pecho_izquierdo_nombre,playera5_pecho_derecho_nombre,playera5_manga_derecha_nombre,playera5_manga_izquierda_nombre,playera5_espalda_nombre,playera5_otra_ubicacion_nombre,playera5_otra_ubicacion2_nombre  FROM puntadas_playera where codigo = '" + codigocliente+ "' ";

                }

                try {

                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {

                        if (i == 0)
                        {

                            pechoizquierdoplayeranombre = rs.getString("playera_pecho_izquierdo_nombre");
                            pechoderechoplayeranombre = rs.getString("playera_pecho_derecho_nombre");
                            mangaizquierdaplayeranombre = rs.getString("playera_manga_izquierda_nombre");
                            mangaderechaplayeranombre = rs.getString("playera_manga_derecha_nombre");
                            espaldaplayeranombre = rs.getString("playera_espalda_nombre");

                            if(pechoizquierdoplayeranombre.contains(pechoizquierdo) && pechoderechoplayeranombre.contains(pechoderecho) && mangaizquierdaplayeranombre.contains(mangaizquierda) && mangaderechaplayeranombre.contains(mangaderecha) && espaldaplayeranombre.contains(espalda) )
                            {
                                fotomontaje = "playera";
                                fotomontajeextension = "playeraextension";
                                break;

                            }

                        }
                        else if (i == 1)
                        {

                            pechoizquierdoplayeranombre = rs.getString("playera2_pecho_izquierdo_nombre");
                            pechoderechoplayeranombre = rs.getString("playera2_pecho_derecho_nombre");
                            mangaizquierdaplayeranombre = rs.getString("playera2_manga_izquierda_nombre");
                            mangaderechaplayeranombre = rs.getString("playera2_manga_derecha_nombre");
                            espaldaplayeranombre = rs.getString("playera2_espalda_nombre");

                            if(pechoizquierdoplayeranombre.contains(pechoizquierdo) && pechoderechoplayeranombre.contains(pechoderecho) && mangaizquierdaplayeranombre.contains(mangaizquierda) && mangaderechaplayeranombre.contains(mangaderecha) && espaldaplayeranombre.contains(espalda)  )
                            {
                                fotomontaje = "playera2";
                                fotomontajeextension = "playera2extension";
                                break;

                            }

                        }
                        else if (i == 2)
                        {

                            pechoizquierdoplayeranombre = rs.getString("playera3_pecho_izquierdo_nombre");
                            pechoderechoplayeranombre = rs.getString("playera3_pecho_derecho_nombre");
                            mangaizquierdaplayeranombre = rs.getString("playera3_manga_izquierda_nombre");
                            mangaderechaplayeranombre = rs.getString("playera3_manga_derecha_nombre");
                            espaldaplayeranombre = rs.getString("playera3_espalda_nombre");

                            if(pechoizquierdoplayeranombre.contains(pechoizquierdo) && pechoderechoplayeranombre.contains(pechoderecho) && mangaizquierdaplayeranombre.contains(mangaizquierda) && mangaderechaplayeranombre.contains(mangaderecha) && espaldaplayeranombre.contains(espalda) && otraubicacionplayeranombre.contains(otraubicacion) && otraubicacion2playeranombre.contains(otraubicacion2) )
                            {
                                fotomontaje = "playera3";
                                fotomontajeextension = "playera3extension";
                                break;

                            }

                        }
                        else if (i == 3)

                        {

                            pechoizquierdoplayeranombre = rs.getString("playera4_pecho_izquierdo_nombre");
                            pechoderechoplayeranombre = rs.getString("playera4_pecho_derecho_nombre");
                            mangaizquierdaplayeranombre = rs.getString("playera4_manga_izquierda_nombre");
                            mangaderechaplayeranombre = rs.getString("playera4_manga_derecha_nombre");
                            espaldaplayeranombre = rs.getString("playera4_espalda_nombre");
                            otraubicacionplayeranombre = rs.getString("playera4_otra_ubicacion_nombre");
                            otraubicacion2playeranombre = rs.getString("playera4_otra_ubicacion2_nombre");

                            if(pechoizquierdoplayeranombre.contains(pechoizquierdo) && pechoderechoplayeranombre.contains(pechoderecho) && mangaizquierdaplayeranombre.contains(mangaizquierda) && mangaderechaplayeranombre.contains(mangaderecha) && espaldaplayeranombre.contains(espalda) && otraubicacionplayeranombre.contains(otraubicacion) && otraubicacion2playeranombre.contains(otraubicacion2) )
                            {
                                fotomontaje = "playera4";
                                fotomontajeextension = "playera4extension";
                                break;
                            }

                        }
                        else if (i == 4) {

                            pechoizquierdoplayeranombre = rs.getString("playera5_pecho_izquierdo_nombre");
                            pechoderechoplayeranombre = rs.getString("playera5_pecho_derecho_nombre");
                            mangaizquierdaplayeranombre = rs.getString("playera5_manga_izquierda_nombre");
                            mangaderechaplayeranombre = rs.getString("playera5_manga_derecha_nombre");
                            espaldaplayeranombre = rs.getString("playera5_espalda_nombre");
                            otraubicacionplayeranombre = rs.getString("playera5_otra_ubicacion_nombre");
                            otraubicacion2playeranombre = rs.getString("playera5_otra_ubicacion2_nombre");

                            if(pechoizquierdoplayeranombre.contains(pechoizquierdo) && pechoderechoplayeranombre.contains(pechoderecho) && mangaizquierdaplayeranombre.contains(mangaizquierda) && mangaderechaplayeranombre.contains(mangaderecha) && espaldaplayeranombre.contains(espalda) && otraubicacionplayeranombre.contains(otraubicacion) && otraubicacion2playeranombre.contains(otraubicacion2) )
                            {
                                fotomontaje = "playera5";
                                fotomontajeextension = "playera5extension";
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

        /// chamarra desmontable

        else if(tipo.equals("CHAMARRA DESMONTABLE"))
        {

            for(int i =0 ; i < 3; i++)
            {

                if (i == 0)
                {

                    sql = "SELECT chamarra_pecho_izquierdo_nombre,chamarra_pecho_derecho_nombre,chamarra_manga_derecha_nombre,chamarra_manga_izquierda_nombre,chamarra_espalda_nombre  FROM puntadas_prendas where codigo = '" + codigocliente + "' ";
                }

                else if (i == 1)

                {

                    sql = "SELECT chamarra2_pecho_izquierdo_nombre,chamarra2_pecho_derecho_nombre,chamarra2_manga_derecha_nombre,chamarra2_manga_izquierda_nombre,chamarra2_espalda_nombre  FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

                }

                else if (i == 2) {

                    sql = "SELECT chamarra3_pecho_izquierdo_nombre,chamarra3_pecho_derecho_nombre,chamarra3_manga_derecha_nombre,chamarra3_manga_izquierda_nombre,chamarra3_espalda_nombre FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

                }

                try {

                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {

                        if (i == 0)
                        {

                            pechoizquierdochamarranombre = rs.getString("chamarra_pecho_izquierdo_nombre");
                            pechoderechochamarranombre = rs.getString("chamarra_pecho_derecho_nombre");
                            mangaizquierdachamarranombre = rs.getString("chamarra_manga_izquierda_nombre");
                            mangaderechachamarranombre = rs.getString("chamarra_manga_derecha_nombre");
                            espaldachamarranombre = rs.getString("chamarra_espalda_nombre");

                            if(pechoizquierdochamarranombre.contains(pechoizquierdo) && pechoderechochamarranombre.contains(pechoderecho) && mangaizquierdachamarranombre.contains(mangaizquierda) && mangaderechachamarranombre.contains(mangaderecha) && espaldachamarranombre.contains(espalda) )
                            {
                                fotomontaje = "chamarra";
                                fotomontajeextension = "chamarraextension";
                                break;

                            }

                        } else if (i == 1) {

                            pechoizquierdochamarranombre = rs.getString("chamarra2_pecho_izquierdo_nombre");
                            pechoderechochamarranombre = rs.getString("chamarra2_pecho_derecho_nombre");
                            mangaizquierdachamarranombre = rs.getString("chamarra2_manga_izquierda_nombre");
                            mangaderechachamarranombre = rs.getString("chamarra2_manga_derecha_nombre");
                            espaldachamarranombre = rs.getString("chamarra2_espalda_nombre");

                            if(pechoizquierdochamarranombre.contains(pechoizquierdo) && pechoderechochamarranombre.contains(pechoderecho) && mangaizquierdachamarranombre.contains(mangaizquierda) && mangaderechachamarranombre.contains(mangaderecha) && espaldachamarranombre.contains(espalda) )
                            {
                                fotomontaje = "chamarra2";
                                fotomontajeextension = "chamarra2extension";
                                break;

                            }

                        }

                        else if (i == 2) {

                            pechoizquierdochamarranombre = rs.getString("chamarra3_pecho_izquierdo_nombre");
                            pechoderechochamarranombre = rs.getString("chamarra3_pecho_derecho_nombre");
                            mangaizquierdachamarranombre = rs.getString("chamarra3_manga_izquierda_nombre");
                            mangaderechachamarranombre = rs.getString("chamarra3_manga_derecha_nombre");
                            espaldachamarranombre = rs.getString("chamarra3_espalda_nombre");

                            if(pechoizquierdochamarranombre.contains(pechoizquierdo) && pechoderechochamarranombre.contains(pechoderecho) && mangaizquierdachamarranombre.contains(mangaizquierda) && mangaderechachamarranombre.contains(mangaderecha) && espaldachamarranombre.contains(espalda) )
                            {
                                fotomontaje = "chamarra3";
                                fotomontajeextension = "chamarra3extension";
                                break;

                            }

                        }

                    }/// while

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }

        }

        /// chamarra rompevientos

        else if(tipo.equals("CHAMARRA ROMPEVIENTOS"))
        {
            for(int i =0 ; i < 2; i++)
            {

                if (i == 0)
                {

                    sql = "SELECT chamarra_rompevientos_pecho_izquierdo_nombre,chamarra_rompevientos_pecho_derecho_nombre,chamarra_rompevientos_manga_derecha_nombre,chamarra_rompevientos_manga_izquierda_nombre,chamarra_rompevientos_espalda_nombre FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

                }

                else if (i == 1)

                {

                    sql = "SELECT chamarra_rompevientos2_pecho_izquierdo_nombre,chamarra_rompevientos2_pecho_derecho_nombre,chamarra_rompevientos2_manga_derecha_nombre,chamarra_rompevientos2_manga_izquierda_nombre,chamarra_rompevientos2_espalda_nombre FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

                }

                try {

                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {

                        if (i == 0)
                        {

                            pechoizquierdochamarrarompevientosnombre = rs.getString("chamarra_rompevientos_pecho_izquierdo_nombre");
                            pechoderechochamarrarompevientosnombre = rs.getString("chamarra_rompevientos_pecho_derecho_nombre");
                            mangaizquierdachamarrarompevientosnombre = rs.getString("chamarra_rompevientos_manga_izquierda_nombre");
                            mangaderechachamarrarompevientosnombre = rs.getString("chamarra_rompevientos_manga_derecha_nombre");
                            espaldachamarrarompevientosnombre = rs.getString("chamarra_rompevientos_espalda_nombre");

                            if(pechoizquierdochamarrarompevientosnombre.contains(pechoizquierdo) && pechoderechochamarrarompevientosnombre.contains(pechoderecho) && mangaizquierdachamarrarompevientosnombre.contains(mangaizquierda) && mangaderechachamarrarompevientosnombre.contains(mangaderecha) &&  espaldachamarrarompevientosnombre.contains(espalda)  )
                            {
                                fotomontaje = "chamarra_rompevientos";
                                fotomontajeextension = "chamarrarompevientosextension";
                                break;
                            }

                        } else if (i == 1) {

                            pechoizquierdochamarrarompevientosnombre = rs.getString("chamarra_rompevientos2_pecho_izquierdo_nombre");
                            pechoderechochamarrarompevientosnombre = rs.getString("chamarra_rompevientos2_pecho_derecho_nombre");
                            mangaizquierdachamarrarompevientosnombre = rs.getString("chamarra_rompevientos2_manga_izquierda_nombre");
                            mangaderechachamarrarompevientosnombre = rs.getString("chamarra_rompevientos2_manga_derecha_nombre");
                            espaldachamarrarompevientosnombre = rs.getString("chamarra_rompevientos2_espalda_nombre");

                            if(pechoizquierdochamarrarompevientosnombre.contains(pechoizquierdo) && pechoderechochamarrarompevientosnombre.contains(pechoderecho) && mangaizquierdachamarrarompevientosnombre.contains(mangaizquierda) && mangaderechachamarrarompevientosnombre.contains(mangaderecha) &&  espaldachamarrarompevientosnombre.contains(espalda)  )
                            {
                                fotomontaje = "chamarra_rompevientos2";
                                fotomontajeextension = "chamarrarompevientos2extension";
                                break;
                            }

                        }

                    }/// while

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }

        }
        else if(tipo.equals("GORRA"))
        {
            for(int i =0 ; i < 3; i++)
            {

                frentegorranombre = "";
                ladoizquierdogorranombre = "";
                ladoderechogorranombre = "";
                atrasgorranombre = "";

                if (i == 0)
                {

                    sql = "SELECT gorra_frente_nombre,gorra_lado_izquierdo_nombre,gorra_lado_derecho_nombre,gorra_atras_nombre  FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

                }

                else if (i == 1)

                {

                    sql = "SELECT gorra2_frente_nombre,gorra2_lado_izquierdo_nombre,gorra2_lado_derecho_nombre,gorra2_atras_nombre FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

                }
                else if (i == 2)

                {

                    sql = "SELECT gorra3_frente_nombre,gorra3_lado_izquierdo_nombre,gorra3_lado_derecho_nombre,gorra3_atras_nombre FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

                }

                try {

                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {

                        if (i == 0)
                        {

                            frentegorranombre = rs.getString("gorra_frente_nombre");
                            ladoizquierdogorranombre = rs.getString("gorra_lado_izquierdo_nombre");
                            ladoderechogorranombre = rs.getString("gorra_lado_derecho_nombre");
                            atrasgorranombre = rs.getString("gorra_atras_nombre");

                            if(frentegorranombre.contains(pechoizquierdo) && ladoizquierdogorranombre.contains(pechoderecho) && ladoderechogorranombre.contains(mangaderecha) && atrasgorranombre.contains(mangaizquierda)  )
                            {
                                fotomontaje = "gorra";
                                fotomontajeextension = "gorraextension";
                                break;

                            }

                        } else if (i == 1) {

                            frentegorranombre = rs.getString("gorra2_frente_nombre");
                            ladoizquierdogorranombre = rs.getString("gorra2_lado_izquierdo_nombre");
                            ladoderechogorranombre = rs.getString("gorra2_lado_derecho_nombre");
                            atrasgorranombre = rs.getString("gorra2_atras_nombre");

                            if(frentegorranombre.contains(pechoizquierdo) && ladoizquierdogorranombre.contains(pechoderecho) && ladoderechogorranombre.contains(mangaderecha) && atrasgorranombre.contains(mangaizquierda)  )
                            {
                                fotomontaje = "gorra2";
                                fotomontajeextension = "gorra2extension";
                                break;

                            }

                        }
                        else if (i == 2)
                        {

                            frentegorranombre = rs.getString("gorra3_frente_nombre");
                            ladoizquierdogorranombre = rs.getString("gorra3_lado_izquierdo_nombre");
                            ladoderechogorranombre = rs.getString("gorra3_lado_derecho_nombre");
                            atrasgorranombre = rs.getString("gorra3_atras_nombre");

                            if(frentegorranombre.contains(pechoizquierdo) && ladoizquierdogorranombre.contains(pechoderecho) && ladoderechogorranombre.contains(mangaderecha) && atrasgorranombre.contains(mangaizquierda)  )
                            {
                                fotomontaje = "gorra3";
                                fotomontajeextension = "gorra3extension";
                                break;

                            }

                        }

                    }/// while

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }

        }
        else if(tipo.contains("CHALECO"))
        {
            for(int i =0 ; i < 3; i++)
            {

                if (i == 0)
                {

                    sql = "SELECT chaleco_pecho_izquierdo_nombre,chaleco_pecho_derecho_nombre,chaleco_espalda_nombre  FROM puntadas_prendas where codigo = '" + codigocliente + "' ";
                }

                else if (i == 1)

                {

                    sql = "SELECT chaleco2_pecho_izquierdo_nombre,chaleco2_pecho_derecho_nombre,chaleco2_espalda_nombre  FROM puntadas_prendas where codigo = '" + codigocliente + "' ";
                }

                try {

                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {

                        if (i == 0)
                        {

                            pechoizquierdochaleconombre = rs.getString("chaleco_pecho_izquierdo_nombre");
                            pechoderechochaleconombre = rs.getString("chaleco_pecho_derecho_nombre");
                            espaldachaleconombre = rs.getString("chaleco_espalda_nombre");

                            if(pechoizquierdochaleconombre.contains(pechoizquierdo) && pechoderechochaleconombre.contains(pechoderecho) && espaldachaleconombre.contains(mangaderecha)   )
                            {
                                fotomontaje = "chaleco";
                                fotomontajeextension = "chalecoextension";
                                break;
                            }

                        } else if (i == 1) {

                            pechoizquierdochaleconombre = rs.getString("chaleco2_pecho_izquierdo_nombre");
                            pechoderechochaleconombre = rs.getString("chaleco2_pecho_derecho_nombre");
                            espaldachaleconombre = rs.getString("chaleco2_espalda_nombre");

                            if(pechoizquierdochaleconombre.contains(pechoizquierdo) && pechoderechochaleconombre.contains(pechoderecho) && espaldachaleconombre.contains(mangaderecha)   )
                            {
                                fotomontaje = "chaleco2";
                                fotomontajeextension = "chaleco2extension";
                                break;

                            }

                        }

                    }/// while

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }
        }
        else if(tipo.contains("SACO"))
        {

            sql = "SELECT saco_pecho_izquierdo_nombre,saco_pecho_derecho_nombre,saco_manga_derecha_nombre,saco_manga_izquierda_nombre,saco_espalda_nombre FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                    pechoizquierdosaconombre = rs.getString("saco_pecho_izquierdo_nombre");
                    pechoderechosaconombre = rs.getString("saco_pecho_derecho_nombre");
                    mangaizquierdasaconombre = rs.getString("saco_manga_izquierda_nombre");
                    mangaderechasaconombre = rs.getString("saco_manga_derecha_nombre");
                    espaldasaconombre = rs.getString("saco_espalda_nombre");

                    if(pechoizquierdosaconombre.contains(pechoizquierdo) && pechoderechosaconombre.contains(pechoderecho) && mangaizquierdasaconombre.contains(mangaizquierda) && mangaderechasaconombre.contains(mangaderecha) &&  espaldasaconombre.contains(espalda)  )
                    {
                        fotomontaje = "saco";
                        fotomontajeextension = "sacoextension";
                        break;

                    }

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
        else if(tipo.equals("FILIPINA"))
        {

            sql = "SELECT filipina_pecho_izquierdo_nombre,filipina_pecho_derecho_nombre,filipina_manga_derecha_nombre,filipina_manga_izquierda_nombre,filipina_espalda_nombre  FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                    pechoizquierdofilipinanombre = rs.getString("filipina_pecho_izquierdo_nombre");
                    pechoderechofilipinanombre = rs.getString("filipina_pecho_derecho_nombre");
                    mangaderechafilipinanombre = rs.getString("filipina_manga_derecha_nombre");
                    mangaizquierdafilipinanombre = rs.getString("filipina_manga_izquierda_nombre");
                    espaldafilipinanombre = rs.getString("filipina_espalda_nombre");

                    if(pechoizquierdofilipinanombre.contains(pechoizquierdo) && pechoderechofilipinanombre.contains(pechoderecho) && mangaderechafilipinanombre.contains(mangaderecha) && mangaizquierdafilipinanombre.contains(mangaizquierda) &&  espaldafilipinanombre.contains(espalda)  )
                    {
                        fotomontaje = "filipina";
                        fotomontajeextension = "filipinaextension";
                        break;

                    }

                }/// while

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
        else if(tipo.equals("CORBATA"))
        {

            for(int i =0 ; i < 2; i++)
            {

                if (i == 0)
                {

                    sql = "SELECT corbata_frente,corbata_frente_nombre  FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

                }

                else if (i == 1)

                {

                    sql = "SELECT corbata2_frente,corbata2_frente_nombre  FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

                }

                try {

                    Statement st = cn.createStatement();
                    ResultSet rs = st.executeQuery(sql);
                    while (rs.next()) {

                        if (i == 0)
                        {

                            frentecorbatanombre = rs.getString("corbata_frente_nombre");

                            if(frentecorbatanombre.equals(pechoizquierdo)   )
                            {
                                fotomontaje = "corbata";
                                fotomontajeextension = "corbataextension";
                                break;

                            }

                        } else if (i == 1) {

                            frentecorbatanombre = rs.getString("corbata2_frente_nombre");

                            if(frentecorbatanombre.contains(pechoizquierdo)   )
                            {
                                fotomontaje = "corbata";
                                fotomontajeextension = "corbata2extension";
                                break;

                            }

                        }

                    }/// while

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

            }

        }
        else if(tipo.equals("CAMISOLA"))
        {
            sql = "SELECT camisola_pecho_izquierdo_nombre,camisola_pecho_derecho_nombre,camisola_manga_derecha_nombre,camisola_manga_izquierda_nombre,camisola_espalda_nombre  FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                    pechoizquierdocamisolanombre = rs.getString("camisola_pecho_izquierdo_nombre");
                    pechoderechocamisolanombre = rs.getString("camisola_pecho_derecho_nombre");
                    mangaizquierdacamisolanombre = rs.getString("camisola_manga_izquierda_nombre");
                    mangaderechacamisolanombre = rs.getString("camisola_manga_derecha_nombre");
                    espaldacamisolanombre = rs.getString("camisola_espalda_nombre");

                    if(pechoizquierdocamisolanombre.contains(pechoizquierdo) && pechoderechocamisolanombre.contains(pechoderecho) && mangaizquierdacamisolanombre.contains(mangaizquierda) && mangaderechacamisolanombre.contains(mangaderecha) &&  espaldacamisolanombre.contains(espalda)  )
                    {
                        fotomontaje = "camisola";
                        fotomontajeextension = "camisolaextension";
                        break;

                    }

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }
        else if(tipo.equals("PANTALON"))
        {
            sql = "SELECT pantalon_lado_izquierdo_frente_nombre,pantalon_lado_derecho_frente_nombre,pantalon_lado_izquierdo_atras_nombre,pantalon_lado_derecho_atras_nombre  FROM puntadas_prendas where codigo = '" + codigocliente + "' ";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                    ladoizquierdofrentepantalonnombre = rs.getString("pantalon_lado_izquierdo_frente_nombre");
                    ladoderechofrentepantalonnombre = rs.getString("pantalon_lado_derecho_frente_nombre");
                    ladoizquierdoatraspantalonnombre = rs.getString("pantalon_lado_izquierdo_atras_nombre");
                    ladoderechoatraspantalonnombre = rs.getString("pantalon_lado_derecho_atras_nombre");

                    if(ladoizquierdofrentepantalonnombre.contains(pechoizquierdo) && ladoderechofrentepantalonnombre.contains(pechoderecho) && ladoizquierdoatraspantalonnombre.contains(mangaizquierda) && ladoderechoatraspantalonnombre.contains(mangaderecha)   )
                    {
                        fotomontaje = "pantalon";
                        fotomontajeextension = "pantalonextension";
                        break;
                    }

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
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
            identificadordeprenda = txtidentificadordeprenda.getText();

            try {

                String sql3 = "UPDATE bordados_puntadas set imagen=? where codigo='"+codigocliente+"' and identificador_prenda = '"+identificadordeprenda+"' and tipo = '"+tipo+"'  and numero_consecutivo = '"+lbconsecutivo.getText()+"' ";

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
                PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET extension_imagen='"+nombredelarchivo+"' where codigo='"+codigocliente+"' and identificador_prenda = '"+identificadordeprenda+"' and tipo = '"+tipo+"'  and numero_consecutivo = '"+lbconsecutivo.getText()+"' ");
                pst.executeUpdate();
                System.out.println(pst);
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            cargarelfotomontaje();

        }

    }//GEN-LAST:event_btnimportarfotomontajeActionPerformed

    private void btnautorizarpuntadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnautorizarpuntadasActionPerformed

        try {
            PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET autorizacion_puntadas = 'si' WHERE codigo='" + lbcodigocliente.getText() + "'  AND numero_consecutivo = '"+lbconsecutivo.getText()+"'  ");
            pst.executeUpdate();
            pst.close();

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Las puntadas se autorizaron correctamente");
        } catch (Exception e) {
            System.out.println(e);

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error al autorizar puntadas");

        }

        //  btnautorizarpuntadas.setEnabled(false);
    }//GEN-LAST:event_btnautorizarpuntadasActionPerformed

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnagregarfotomontaje;
    private javax.swing.JButton btnautorizarpuntadas;
    private javax.swing.JButton btndatos;
    private javax.swing.JButton btneliminarfotomontaje;
    private javax.swing.JButton btneliminartodo;
    public static javax.swing.JButton btnguardar;
    private javax.swing.JButton btnimportarfotomontaje;
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
    private javax.swing.JComboBox<String> cbaroespalda;
    private javax.swing.JComboBox<String> cbbordados1;
    private javax.swing.JComboBox<String> cbbordados2;
    private javax.swing.JComboBox<String> cbbordados3;
    private javax.swing.JComboBox<String> cbbordados4;
    private javax.swing.JComboBox<String> cbbordados5;
    private javax.swing.JComboBox<String> cbbordados6;
    private javax.swing.JComboBox<String> cbbordados7;
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
    private javax.swing.JComboBox<String> cbpuntadas1;
    private javax.swing.JComboBox<String> cbpuntadas2;
    private javax.swing.JComboBox<String> cbpuntadas3;
    private javax.swing.JComboBox<String> cbpuntadas4;
    private javax.swing.JComboBox<String> cbpuntadas5;
    private javax.swing.JComboBox<String> cbpuntadas6;
    private javax.swing.JComboBox<String> cbpuntadas7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbcodigocliente;
    public static javax.swing.JLabel lbconsecutivo;
    private javax.swing.JLabel lbetiqueta1;
    private javax.swing.JLabel lbetiqueta2;
    private javax.swing.JLabel lbetiqueta3;
    private javax.swing.JLabel lbetiqueta4;
    private javax.swing.JLabel lbetiqueta5;
    private javax.swing.JLabel lbetiqueta6;
    private javax.swing.JLabel lbetiqueta7;
    private javax.swing.JLabel lbfotomontaje;
    public static javax.swing.JLabel lbidentificador;
    private javax.swing.JLabel lbidentificadordeprendaanterior;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbprenda;
    private javax.swing.JLabel lbpuntadas5;
    private javax.swing.JTextField txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    private javax.swing.JTextField txt4;
    private javax.swing.JTextField txt5;
    private javax.swing.JTextField txt6;
    private javax.swing.JTextField txt7;
    public static javax.swing.JLabel txtcodigocatalogobordados;
    public static javax.swing.JTextField txtidentificadordeprenda;
    // End of variables declaration//GEN-END:variables
connectar cc = new connectar();
Connection cn = cc.conexion();

}
