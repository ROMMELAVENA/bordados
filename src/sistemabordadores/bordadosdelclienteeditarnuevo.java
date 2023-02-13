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

public class bordadosdelclienteeditarnuevo extends javax.swing.JFrame {

    public static boolean ventanabordadosdelclienteeditarnuevo = false;

    String prenda = "";

    String nombrebordadoanterior = "";
    String codigodelcliente = "";
    String numerocamisa = "";
    String identificadordeprenda = "";
    String rutaarchivo = "";
    String nombrearchivo = "";
    String consultaborrado = "";

    String prendafotomontaje = "";
    String nombreprendafotomontaje = "";
    String actualizarbordado = "no";

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

    public bordadosdelclienteeditarnuevo() {
        initComponents();
        ventanabordadosdelclienteeditarnuevo = true;

        btndatos.setVisible(false);
        lbcodigocliente.setVisible(false);
        lbidentificadordeprendaanterior.setVisible(false);

        txtcodigocatalogobordados.setVisible(false);
        lbconsecutivo.setVisible(false);

        String texto = "Este boton hace....";

    }

    void combospuntadasprevias() {

        try {
            DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo3 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo4 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo5 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo6 = new DefaultComboBoxModel();
            DefaultComboBoxModel modelo7 = new DefaultComboBoxModel();

            String sql = "SELECT descripcion, sum(precio) as precio2  FROM catalogo_articulos where descripcion not like  '%PARCHE%'  and ( descripcion like 'SEGURIDAD%' or descripcion like 'VIGILANCIA%' or descripcion like 'BORDADO DE%'   OR descripcion like 'BANDERA DE%'  ) group by precio ORDER BY precio2";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                modelo1.addElement(rs.getObject("descripcion"));
                modelo2.addElement(rs.getObject("descripcion"));
                modelo3.addElement(rs.getObject("descripcion"));
                modelo4.addElement(rs.getObject("descripcion"));
                modelo5.addElement(rs.getObject("descripcion"));
                modelo6.addElement(rs.getObject("descripcion"));
                modelo7.addElement(rs.getObject("descripcion"));

            }

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
                            modelo1.addElement(pechoizquierdo);
                            modelo2.addElement(pechoizquierdo);
                        }

                        if (pechoderecho.equals("") || pechoderecho.equals("SEGURIDAD") || pechoderecho.equals("SEGURIDAD ") || pechoderecho.equals("SEGURIDAD PRIVADA") || pechoderecho.equals("SEGURIDAD PRIVADA ") || pechoderecho.equals("VIGILANCIA") || pechoderecho.equals("ninguno")) {

                        } else {
                            modelo1.addElement(pechoderecho);
                            modelo2.addElement(pechoderecho);
                        }

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                cbpuntadasPrevia1.setModel(modelo1);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia1);

                cbpuntadasPrevia2.setModel(modelo2);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia2);

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
                            modelo3.addElement(mangaizquierda);
                            modelo4.addElement(mangaizquierda);
                        }

                        if (mangaderecha.equals("") || mangaderecha.equals("SEGURIDAD") || mangaderecha.equals("SEGURIDAD ") || mangaderecha.equals("SEGURIDAD PRIVADA") || mangaderecha.equals("SEGURIDAD PRIVADA ") || mangaderecha.equals("VIGILANCIA") || mangaderecha.equals("ninguno")) {

                        } else {
                            modelo3.addElement(mangaderecha);
                            modelo4.addElement(mangaderecha);
                        }

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                cbpuntadasPrevia3.setModel(modelo3);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia3);

                cbpuntadasPrevia4.setModel(modelo4);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia4);

                // ESPALDA
                sql = "SELECT distinct espalda_nombre FROM bordados_puntadas where codigo = '" + codigodelcliente + "' "
                        + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')";

                try {

                    Statement st2 = cn.createStatement();
                    ResultSet rs2 = st2.executeQuery(sql);
                    while (rs2.next()) {

                        String espalda = rs2.getString("espalda_nombre");

                        if (espalda.equals("") || espalda.equals("SEGURIDAD") || espalda.equals("SEGURIDAD ") || espalda.equals("SEGURIDAD PRIVADA") || espalda.equals("SEGURIDAD PRIVADA ") || espalda.equals("VIGILANCIA") || espalda.equals("ninguno")) {

                        } else {
                            modelo5.addElement(espalda);

                        }

                    }

                    st.close();
                } catch (SQLException ex) {
                    System.out.println(ex);
                }

                cbpuntadasPrevia5.setModel(modelo5);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia5);

                cbpuntadasPrevia3.setModel(modelo3);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia3);

                cbpuntadasPrevia4.setModel(modelo4);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia4);

                cbpuntadasPrevia5.setModel(modelo5);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia5);

                cbpuntadasPrevia6.setModel(modelo6);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia6);

                cbpuntadasPrevia7.setModel(modelo7);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia7);

                // SE PONEN LAS PUNTADAS DE SEGURIDAD Y SEGURIDAD PRIVADA
                // 
                cbpuntadasPrevia1.addItem("SEGURIDAD");
                cbpuntadasPrevia1.addItem("SEGURIDAD PRIVADA");
                cbpuntadasPrevia1.addItem("VIGILANCIA");
                cbpuntadasPrevia1.addItem("ninguno");
                cbpuntadasPrevia1.setSelectedItem("ninguno");

                cbpuntadasPrevia2.addItem("SEGURIDAD");
                cbpuntadasPrevia2.addItem("SEGURIDAD PRIVADA");
                cbpuntadasPrevia2.addItem("VIGILANCIA");
                cbpuntadasPrevia2.addItem("ninguno");
                cbpuntadasPrevia2.setSelectedItem("ninguno");

                cbpuntadasPrevia3.addItem("SEGURIDAD");
                cbpuntadasPrevia3.addItem("SEGURIDAD PRIVADA");
                cbpuntadasPrevia3.addItem("VIGILANCIA");
                cbpuntadasPrevia3.addItem("ninguno");
                cbpuntadasPrevia3.setSelectedItem("ninguno");

                cbpuntadasPrevia4.addItem("SEGURIDAD");
                cbpuntadasPrevia4.addItem("SEGURIDAD PRIVADA");
                cbpuntadasPrevia4.addItem("VIGILANCIA");
                cbpuntadasPrevia4.addItem("ninguno");
                cbpuntadasPrevia4.setSelectedItem("ninguno");

                cbpuntadasPrevia5.addItem("SEGURIDAD #1");
                cbpuntadasPrevia5.addItem("SEGURIDAD #2");
                cbpuntadasPrevia5.addItem("SEGURIDAD PRIVADA #1");
                cbpuntadasPrevia5.addItem("SEGURIDAD PRIVADA #2");
                cbpuntadasPrevia5.addItem("SEGURIDAD PRIVADA #3");
                cbpuntadasPrevia5.addItem("ninguno");
                cbpuntadasPrevia5.setSelectedItem("ninguno");

                cbpuntadasPrevia6.addItem("ninguno");
                cbpuntadasPrevia6.setSelectedItem("ninguno");

                cbpuntadasPrevia7.addItem("ninguno");
                cbpuntadasPrevia7.setSelectedItem("ninguno");

            } else {

                cbpuntadasPrevia1.setModel(modelo1);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia1);
                cbpuntadasPrevia1.addItem("ninguno");
                cbpuntadasPrevia1.setSelectedItem("ninguno");

                cbpuntadasPrevia2.setModel(modelo2);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia2);
                cbpuntadasPrevia2.addItem("ninguno");
                cbpuntadasPrevia2.setSelectedItem("ninguno");

                cbpuntadasPrevia3.setModel(modelo3);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia3);
                cbpuntadasPrevia3.addItem("ninguno");
                cbpuntadasPrevia3.setSelectedItem("ninguno");

                cbpuntadasPrevia4.setModel(modelo4);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia4);
                cbpuntadasPrevia4.addItem("ninguno");
                cbpuntadasPrevia4.setSelectedItem("ninguno");

                cbpuntadasPrevia5.setModel(modelo5);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia5);
                cbpuntadasPrevia5.addItem("ninguno");
                cbpuntadasPrevia5.setSelectedItem("ninguno");

                cbpuntadasPrevia6.setModel(modelo6);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia6);
                cbpuntadasPrevia6.addItem("ninguno");
                cbpuntadasPrevia6.setSelectedItem("ninguno");

                cbpuntadasPrevia7.setModel(modelo7);
                AutoCompleteDecorator.decorate(cbpuntadasPrevia7);
                cbpuntadasPrevia7.addItem("ninguno");
                cbpuntadasPrevia7.setSelectedItem("ninguno");

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

    void datos() {

        codigodelcliente = lbcodigocliente.getText();
        identificadordeprenda = txtidentificadordeprenda.getText().trim();
        consecutivo = txtcodigocatalogobordados.getText();

        prenda = lbprenda.getText();

        combospuntadas();
        String sql = "";
        String lbtipostring = lbprenda.getText();

        ///CAMISA
        if (prenda.equals("CAMISA") || prenda.equals("PLAYERA") || prenda.equals("CHAMARRA DESMONTABLE") || prenda.equals("CHAMARRA ROMPEVIENTOS") || prenda.equals("CAMISOLA") || prenda.equals("FILIPINA") || prenda.equals("SACO") || prenda.equals("CHALECO") || prenda.equals("MANDIL")) {

            sql = "SELECT nombre_bordado,pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo_aplicacion,pecho_izquierdo_aplicacion_color,"
                    + "pecho_derecho,pecho_derecho_nombre,pecho_derecho_aplicacion,pecho_derecho_aplicacion_color,"
                    + "manga_derecha,manga_derecha_nombre,manga_derecha_aplicacion,manga_derecha_aplicacion_color,"
                    + "manga_izquierda,manga_izquierda_nombre,manga_izquierda_aplicacion,manga_izquierda_aplicacion_color,"
                    + "espalda,espalda_nombre,espalda_aplicacion,espalda_aplicacion_color,espalda_puntadas_aro,espalda_aro,"
                    + "otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion_aplicacion,otra_ubicacion_aplicacion_color,"
                    + "otra_ubicacion2,otra_ubicacion2_nombre,otra_ubicacion2_aplicacion,otra_ubicacion2_aplicacion_color,"
                    + "color1,color2,color3,color4,color5,color6,color7,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7 "
                    + " FROM bordados_puntadas where nombre_bordado = '" + identificadordeprenda + "'  and codigo = '" + codigodelcliente + "' AND tipo = '" + lbtipostring + "' and numero_consecutivo = '" + consecutivo + "'";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                    identificadordeprenda = rs.getString("nombre_bordado");
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

                    txtidentificadordeprenda.setText(identificadordeprenda);
                    lbidentificadordeprendaanterior.setText(identificadordeprenda);
                    cbpuntadas1.setSelectedItem(pechoizquierdo);
                    txt1.setText(pechoizquierdonombre);

                    cbpuntadas2.setSelectedItem(pechoderecho);
                    txt2.setText(pechoderechonombre);

                    cbpuntadas4.setSelectedItem(mangaderecha);
                    txt4.setText(mangaderechanombre);

                    cbpuntadas3.setSelectedItem(mangaizquierda);
                    txt3.setText(mangaizquierdanombre);

                    cbpuntadas5.setSelectedItem(espalda);
                    txt5.setText(espaldanombre);

                    cbpuntadas6.setSelectedItem(otraubicacion);
                    txt6.setText(otraubicacionnombre);

                    cbpuntadas7.setSelectedItem(otraubicacion2);
                    txt7.setText(otraubicacion2nombre);

                    actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }

        //CHALECO
        if (prenda.equals("CHALECO")) {

            sql = "SELECT nombre_bordado,pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo_aplicacion,pecho_izquierdo_aplicacion_color,"
                    + "pecho_derecho,pecho_derecho_nombre,pecho_derecho_aplicacion,pecho_derecho_aplicacion_color,"
                    + "manga_derecha,manga_derecha_nombre,manga_derecha_aplicacion,manga_derecha_aplicacion_color,"
                    + "manga_izquierda,manga_izquierda_nombre,manga_izquierda_aplicacion,manga_izquierda_aplicacion_color,"
                    + "espalda,espalda_nombre,espalda_aplicacion,espalda_aplicacion_color,"
                    + "otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion_aplicacion,otra_ubicacion_aplicacion_color,"
                    + "otra_ubicacion2,otra_ubicacion2_nombre,otra_ubicacion2_aplicacion,otra_ubicacion2_aplicacion_color,"
                    + "color1,color2,color3,hilo1,hilo2,hilo3 "
                    + "FROM bordados_puntadas where nombre_bordado = '" + identificadordeprenda + "' and numero_consecutivo = '" + consecutivo + "' and codigo = '" + codigodelcliente + "' AND tipo = '" + lbtipostring + "' ";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                    identificadordeprenda = rs.getString("nombre_bordado");
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

                    txtidentificadordeprenda.setText(identificadordeprenda);
                    lbidentificadordeprendaanterior.setText(identificadordeprenda);

                    cbpuntadas1.setSelectedItem(pechoizquierdo);
                    txt1.setText(pechoizquierdonombre);

                    cbpuntadas2.setSelectedItem(pechoderecho);
                    txt2.setText(pechoderechonombre);

                    lbetiqueta3.setText("otra_ubicacion");
                    cbpuntadas3.setSelectedItem(otraubicacion);
                    txt3.setText(otraubicacionnombre);

                    lbetiqueta4.setText("Espalda");
                    cbpuntadas4.setSelectedItem(espalda);
                    txt4.setText(espaldanombre);

                    lbetiqueta5.setText("otra_ubicacion2");
                    cbpuntadas5.setSelectedItem(otraubicacion2);
                    txt5.setText(otraubicacion2nombre);

                    cbpuntadas6.setSelectedItem(otraubicacion);
                    txt6.setText(otraubicacionnombre);

                    cbpuntadas7.setSelectedItem(otraubicacion2);
                    txt7.setText(otraubicacion2nombre);

                    lbetiqueta6.setText("");
                    cbpuntadas6.setEnabled(false);
                    txt6.setEnabled(false);

                    lbetiqueta7.setText("");
                    cbpuntadas7.setEnabled(false);
                    txt7.setEnabled(false);

                    actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } else if (prenda.equals("MANDIL")) //MANDIL
        {

            sql = "SELECT nombre_bordado,pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo_aplicacion,pecho_izquierdo_aplicacion_color,"
                    + "pecho_derecho,pecho_derecho_nombre,pecho_derecho_aplicacion,pecho_derecho_aplicacion_color,"
                    + "centro,centro_nombre,centro_aplicacion,centro_aplicacion_color,"
                    + "otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion_aplicacion,otra_ubicacion_aplicacion_color,"
                    + "otra_ubicacion2,otra_ubicacion2_nombre,otra_ubicacion2_aplicacion,otra_ubicacion2_aplicacion_color,"
                    + "color1,color2,color3,hilo1,hilo2,hilo3 "
                    + "FROM bordados_puntadas where nombre_bordado = '" + identificadordeprenda + "' and numero_consecutivo = '" + consecutivo + "' and codigo = '" + codigodelcliente + "' AND tipo = '" + lbtipostring + "' ";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                    identificadordeprenda = rs.getString("nombre_bordado");
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

                    txtidentificadordeprenda.setText(identificadordeprenda);
                    lbidentificadordeprendaanterior.setText(identificadordeprenda);
                    cbpuntadas1.setSelectedItem(pechoizquierdo);

                    txt1.setText(pechoizquierdonombre);
                   

                    cbpuntadas2.setSelectedItem(pechoderecho);
                    txt2.setText(pechoderechonombre);
                   

                    cbpuntadas3.setSelectedItem(centro);
                    txt3.setText(centronombre);
                   

                    actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            cbpuntadas1.setSelectedItem(pechoizquierdo);
            txt1.setText(pechoizquierdonombre);
           

            cbpuntadas2.setSelectedItem(pechoderecho);
            txt2.setText(pechoderechonombre);
          

            lbetiqueta3.setText("Centro");
            cbpuntadas3.setSelectedItem(centro);
            txt3.setText(centronombre);
           

            lbetiqueta4.setText("otra_ubicacion");
            cbpuntadas4.setSelectedItem(otraubicacion);
            txt4.setText(otraubicacionnombre);
           

            lbetiqueta5.setText("otra_ubicacion2");
            cbpuntadas5.setSelectedItem(otraubicacion2);
            txt5.setText(otraubicacion2nombre);
           
            lbetiqueta6.setText("");
            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);


            lbetiqueta7.setText("");
            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);


        } else //GORRA
        if (prenda.equals("GORRA")) {

            sql = "SELECT nombre_bordado,frente,frente_nombre,frente_aplicacion,frente_aplicacion_color,"
                    + "lado_izquierdo,lado_izquierdo_nombre,"
                    + "lado_derecho,lado_derecho_nombre,"
                    + "atras,atras_nombre,"
                    + "color1,color2,color3,color4,hilo1,hilo2,hilo3,hilo4 "
                    + " FROM bordados_puntadas where nombre_bordado = '" + identificadordeprenda + "' and numero_consecutivo = '" + consecutivo + "' and codigo = '" + codigodelcliente + "' AND tipo = '" + lbtipostring + "' ";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                    identificadordeprenda = rs.getString("nombre_bordado");
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


            cbpuntadas5.setEnabled(false);
            txt5.setEnabled(false);
           

            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);

            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);
            

            cbpuntadas1.setSelectedItem(frentegorra);
            txt1.setText(frentegorranombre);
          

            cbpuntadas2.setSelectedItem(ladoizquierdogorra);
            txt2.setText(ladoizquierdogorranombre);

            cbpuntadas4.setSelectedItem(ladoderechogorra);
            txt4.setText(ladoderechogorranombre);

            cbpuntadas3.setSelectedItem(atrasgorra);
            txt3.setText(atrasgorranombre);

        }

        //PARCHE
        if (prenda.equals("PARCHE")) {

            sql = "SELECT nombre_bordado,parche,parche_nombre,parche_aplicacion,parche_aplicacion_color,numero_consecutivo,"
                    + "color1,hilo1"
                    + " FROM bordados_puntadas where nombre_bordado = '" + identificadordeprenda + "' and numero_consecutivo = '" + consecutivo + "' and codigo = '" + codigodelcliente + "' AND tipo = '" + lbtipostring + "' ";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                    identificadordeprenda = rs.getString("nombre_bordado");
                    lbidentificadordeprendaanterior.setText(identificadordeprenda);

                    parche = rs.getString("parche");
                    parchenombre = rs.getString("parche_nombre");
                    parcheaplicacion = rs.getString("parche_aplicacion");
                    parcheaplicacioncolor = rs.getString("parche_aplicacion_color");

                    txtcodigocatalogobordados.setText(rs.getString("numero_consecutivo"));

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
            

            cbpuntadas2.setEnabled(false);
            txt2.setEnabled(false);
          

            cbpuntadas3.setEnabled(false);
            txt3.setEnabled(false);
         

            cbpuntadas4.setEnabled(false);
            txt4.setEnabled(false);
     

            cbpuntadas5.setEnabled(false);
            txt5.setEnabled(false);
           

            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);


            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);
          

        } else //PANTALON
        if (prenda.equals("PANTALON")) {

            sql = "SELECT nombre_bordado,pantalon_lado_izquierdo_frente,pantalon_lado_izquierdo_frente_nombre,pantalon_lado_izquierdo_frente_aplicacion,pantalon_lado_izquierdo_frente_aplicacion_color"
                    + ",pantalon_lado_derecho_frente,pantalon_lado_derecho_frente_nombre,pantalon_lado_derecho_frente_aplicacion,pantalon_lado_derecho_frente_aplicacion_color,"
                    + "pantalon_lado_izquierdo_atras,pantalon_lado_izquierdo_atras_nombre,pantalon_lado_izquierdo_atras_aplicacion,pantalon_lado_izquierdo_atras_aplicacion_color,"
                    + "pantalon_lado_derecho_atras,pantalon_lado_derecho_atras_nombre,pantalon_lado_derecho_atras_aplicacion,pantalon_lado_derecho_atras_aplicacion_color,"
                    + "color1,color2,color3,color4,color5,hilo1,hilo2,hilo3,hilo4,hilo5"
                    + "  FROM bordados_puntadas where nombre_bordado = '" + identificadordeprenda + "' and numero_consecutivo = '" + consecutivo + "' and codigo = '" + codigodelcliente + "' AND tipo = '" + lbtipostring + "' ";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                    identificadordeprenda = rs.getString("nombre_bordado");
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

                    

                    actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            lbetiqueta1.setText("Lado izquierdo frente");
            cbpuntadas1.setSelectedItem(ladoizquierdofrentepantalon);
            txt1.setText(ladoizquierdofrentepantalonnombre);

            lbetiqueta2.setText("Lado derecho frente");
            cbpuntadas2.setSelectedItem(ladoderechofrentepantalon);
            txt2.setText(ladoderechofrentepantalonnombre);

            lbetiqueta4.setText("Lado izquierdo atras");
            cbpuntadas4.setSelectedItem(ladoizquierdoatraspantalon);
            txt4.setText(ladoizquierdoatraspantalonnombre);

            lbetiqueta3.setText("Lado derecho atras");
            cbpuntadas3.setSelectedItem(ladoderechoatraspantalon);
            txt3.setText(ladoderechoatraspantalonnombre);

            cbpuntadas5.setEnabled(false);
            txt5.setEnabled(false);

            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);

            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);

        } /// corbata
        else if (prenda.equals("CORBATA")) {

            sql = "SELECT nombre_bordado,corbata_frente,corbata_frente_nombre,"
                    + "color1,hilo1"
                    + "  FROM bordados_puntadas where numero_consecutivo = '" + consecutivo + "' and codigo = '" + codigodelcliente + "' AND tipo = '" + lbtipostring + "' ";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                    identificadordeprenda = rs.getString("nombre_bordado");
                    lbidentificadordeprendaanterior.setText(identificadordeprenda);
                    frentecorbata = rs.getString("corbata_frente");
                    frentecorbatanombre = rs.getString("corbata_frente_nombre");

                   

                    actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

            lbetiqueta1.setText("frente corbata");
            cbpuntadas1.setSelectedItem(frentecorbata);
            txt1.setText(frentecorbatanombre);

           

            lbetiqueta2.setText("");
            cbpuntadas2.setEnabled(false);
            txt2.setEnabled(false);
           

            lbetiqueta4.setText("");
            cbpuntadas4.setEnabled(false);
            txt4.setEnabled(false);
           

            lbetiqueta3.setText("");
            cbpuntadas3.setEnabled(false);
            txt3.setEnabled(false);
           

            lbetiqueta5.setText("");
            cbpuntadas6.setEnabled(false);
            txt5.setEnabled(false);
           

            lbetiqueta6.setText("");
            cbpuntadas6.setEnabled(false);
            txt6.setEnabled(false);
           

            lbetiqueta7.setText("");
            cbpuntadas7.setEnabled(false);
            txt7.setEnabled(false);
           

        }

        ///DISTINTA
        if (prenda.equals("DISTINTA")) {

            sql = "SELECT nombre_bordado,pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo_aplicacion,pecho_izquierdo_aplicacion_color,"
                    + "pecho_derecho,pecho_derecho_nombre,pecho_derecho_aplicacion,pecho_derecho_aplicacion_color,"
                    + "manga_derecha,manga_derecha_nombre,manga_derecha_aplicacion,manga_derecha_aplicacion_color,"
                    + "manga_izquierda,manga_izquierda_nombre,manga_izquierda_aplicacion,manga_izquierda_aplicacion_color,"
                    + "espalda,espalda_nombre,espalda_aplicacion,espalda_aplicacion_color,espalda_puntadas_aro,espalda_aro,"
                    + "otra_ubicacion,otra_ubicacion_nombre,otra_ubicacion_aplicacion,otra_ubicacion_aplicacion_color,"
                    + "otra_ubicacion2,otra_ubicacion2_nombre,otra_ubicacion2_aplicacion,otra_ubicacion2_aplicacion_color,"
                    + "color1,color2,color3,color4,color5,color6,color7,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7 "
                    + " FROM bordados_puntadas where nombre_bordado = '" + identificadordeprenda + "'  and codigo = '" + codigodelcliente + "' AND tipo = '" + lbtipostring + "' and numero_consecutivo = '" + consecutivo + "'";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                    identificadordeprenda = rs.getString("nombre_bordado");
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

                  

                    txtidentificadordeprenda.setText(identificadordeprenda);
                    lbidentificadordeprendaanterior.setText(identificadordeprenda);
                    cbpuntadas1.setSelectedItem(pechoizquierdo);
                    txt1.setText(pechoizquierdonombre);
                   

                    cbpuntadas2.setSelectedItem(pechoderecho);
                    txt2.setText(pechoderechonombre);
                   

                    cbpuntadas4.setSelectedItem(mangaderecha);
                    txt4.setText(mangaderechanombre);
                  

                    cbpuntadas3.setSelectedItem(mangaizquierda);
                    txt3.setText(mangaizquierdanombre);
                   

                    cbpuntadas5.setSelectedItem(espalda);
                    txt5.setText(espaldanombre);
                  


                    cbpuntadas6.setSelectedItem(otraubicacion);
                    txt6.setText(otraubicacionnombre);
                   

                    cbpuntadas7.setSelectedItem(otraubicacion2);
                    txt7.setText(otraubicacion2nombre);
                 

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

        if (bordado1.contains("VERDE") || bordado1.contains("DORADO") || bordado1.contains("ROJO") || bordado1.contains("AMARILO") || bordado1.contains("ANARANJADO") || bordado1.contains("BLANCO") || bordado1.contains("NEGRO") || bordado1.contains("MARINO") || bordado1.contains("AZUL") || bordado1.contains("GRIS") || bordado1.contains("VINO") || bordado1.contains("ROSA") || bordado1.contains("MORADO") || bordado1.contains("CAFE") || bordado1.contains("CREMA") || bordado1.contains("KAKI")) {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la " + etiqueta1 + " tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
        }

        if (bordado2.contains("VERDE") || bordado2.contains("DORADO") || bordado2.contains("ROJO") || bordado2.contains("AMARILO") || bordado2.contains("ANARANJADO") || bordado2.contains("BLANCO") || bordado2.contains("NEGRO") || bordado2.contains("MARINO") || bordado2.contains("AZUL") || bordado2.contains("GRIS") || bordado2.contains("VINO") || bordado2.contains("ROSA") || bordado2.contains("MORADO") || bordado2.contains("CAFE") || bordado2.contains("CREMA") || bordado2.contains("KAKI")) {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la " + etiqueta2 + " tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
        }

        if (bordado3.contains("VERDE") || bordado3.contains("DORADO") || bordado3.contains("ROJO") || bordado3.contains("AMARILO") || bordado3.contains("ANARANJADO") || bordado3.contains("BLANCO") || bordado3.contains("NEGRO") || bordado3.contains("MARINO") || bordado3.contains("AZUL") || bordado3.contains("GRIS") || bordado3.contains("VINO") || bordado3.contains("ROSA") || bordado3.contains("MORADO") || bordado3.contains("CAFE") || bordado3.contains("CREMA") || bordado3.contains("KAKI")) {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la " + etiqueta3 + " tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
        }

        if (bordado1.contains("VERDE") || bordado4.contains("DORADO") || bordado4.contains("ROJO") || bordado4.contains("AMARILO") || bordado4.contains("ANARANJADO") || bordado4.contains("BLANCO") || bordado4.contains("NEGRO") || bordado4.contains("MARINO") || bordado4.contains("AZUL") || bordado4.contains("GRIS") || bordado4.contains("VINO") || bordado4.contains("ROSA") || bordado4.contains("MORADO") || bordado4.contains("CAFE") || bordado4.contains("CREMA") || bordado4.contains("KAKI")) {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la " + etiqueta4 + " tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
        }

        if (bordado5.contains("VERDE") || bordado5.contains("DORADO") || bordado5.contains("ROJO") || bordado5.contains("AMARILO") || bordado5.contains("ANARANJADO") || bordado5.contains("BLANCO") || bordado5.contains("NEGRO") || bordado5.contains("MARINO") || bordado5.contains("AZUL") || bordado5.contains("GRIS") || bordado5.contains("VINO") || bordado5.contains("ROSA") || bordado5.contains("MORADO") || bordado5.contains("CAFE") || bordado5.contains("CREMA") || bordado5.contains("KAKI")) {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la " + etiqueta5 + " tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
        }

        if (bordado6.contains("VERDE") || bordado6.contains("DORADO") || bordado6.contains("ROJO") || bordado6.contains("AMARILO") || bordado6.contains("ANARANJADO") || bordado6.contains("BLANCO") || bordado6.contains("NEGRO") || bordado6.contains("MARINO") || bordado6.contains("AZUL") || bordado6.contains("GRIS") || bordado6.contains("VINO") || bordado6.contains("ROSA") || bordado6.contains("MORADO") || bordado6.contains("CAFE") || bordado6.contains("CREMA") || bordado6.contains("KAKI")) {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la " + etiqueta6 + " tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
        }

        if (bordado7.contains("VERDE") || bordado7.contains("DORADO") || bordado7.contains("ROJO") || bordado7.contains("AMARILO") || bordado7.contains("ANARANJADO") || bordado7.contains("BLANCO") || bordado7.contains("NEGRO") || bordado7.contains("MARINO") || bordado7.contains("AZUL") || bordado7.contains("GRIS") || bordado7.contains("VINO") || bordado7.contains("ROSA") || bordado7.contains("MORADO") || bordado7.contains("CAFE") || bordado7.contains("CREMA") || bordado7.contains("KAKI")) {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">En el Bordado de la " + etiqueta7 + " tienes incluido un COLOR, te sugiero ponerlo en el COMBO DE COLORES");
        }

        combospuntadasprevias();

        // TERMINA VOID DATOS
    }

    void identificador() {

        String SQL = "SELECT identificador FROM catalogo_clientes where codigo = '" + codigodelcliente + "' ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(SQL);
            if (rs1.next()) {

                lbidentificador.setText(rs1.getString("identificador"));

            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }

 

    

    void actualizarlaubicacion(String ubicacion, String numeroventa, String nombrebordado, String nombrearticuloactualizar, String numerocotizacion) {

        if (numeroventa == null || numeroventa.equals("") || numeroventa.equals(" ")) {

        } else {
            if (nombrearticuloactualizar.startsWith("APLICACION")) {
                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_VENTAS SET nombre_bordado = '" + txtidentificadordeprenda.getText() + "' WHERE codigo_cliente='" + codigodelcliente + "' and nombre_bordado = '" + lbidentificadordeprendaanterior.getText() + "'  AND numero = '" + numeroventa + "' and articulo = '" + nombrearticuloactualizar + "' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {

                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_VENTAS SET ARTICULO = '" + ubicacion.trim() + "' WHERE codigo_cliente='" + codigodelcliente + "' and nombre_bordado = '" + lbidentificadordeprendaanterior.getText() + "'  AND numero = '" + numeroventa + "' and articulo = '" + nombrearticuloactualizar + "' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_VENTAS SET nombre_bordado = '" + txtidentificadordeprenda.getText() + "' WHERE codigo_cliente='" + codigodelcliente + "' and nombre_bordado = '" + lbidentificadordeprendaanterior.getText() + "'  AND numero = '" + numeroventa + "' and articulo = '" + ubicacion.trim() + "' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        }

        if (numerocotizacion == null || numerocotizacion.equals("") || numerocotizacion.equals(" ")) {

        } else {

            if (nombrearticuloactualizar.startsWith("APLICACION")) {
                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_COTIZACIONES SET nombre_bordado = '" + txtidentificadordeprenda.getText() + "'  where numero = '" + numerocotizacion + "' and articulo = '" + nombrearticuloactualizar + "' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

            } else {

                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_COTIZACIONES SET ARTICULO = '" + ubicacion.trim() + "' WHERE codigo_cliente='" + codigodelcliente + "' and nombre_bordado = '" + nombrebordado + "'  AND numero = '" + numerocotizacion + "' and articulo = '" + nombrearticuloactualizar + "' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

                try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE HISTORIAL_COTIZACIONES SET nombre_bordado = '" + txtidentificadordeprenda.getText() + "'  where numero = '" + numerocotizacion + "' and articulo = '" + ubicacion.trim() + "' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        }

    }

    void quevaainsertar() {

        Object nombrebordado = lbidentificadordeprendaanterior.getText();

        String nombre1 = txt1.getText();
        String nombre2 = txt2.getText();
        String nombre3 = txt4.getText();
        String nombre4 = txt3.getText();
        String nombre5 = txt5.getText();
        String nombre6 = txt6.getText();
        String nombre7 = txt7.getText();

        if (prenda.equals("CAMISA")) {

            ubicacion1 = "BORDADO CAMISA PECHO IZQUIERDO " + nombre1 + "";
            ubicacion2 = "BORDADO CAMISA PECHO DERECHO " + nombre2 + "";
            ubicacion3 = "BORDADO CAMISA MANGA IZQUIERDA " + nombre3 + "";
            ubicacion4 = "BORDADO CAMISA MANGA DERECHA " + nombre4 + "";
            ubicacion5 = "BORDADO CAMISA ESPALDA " + nombre5 + "";
            ubicacion6 = "BORDADO CAMISA OTRA UBICACION " + nombre6 + "";
            ubicacion7 = "BORDADO CAMISA OTRA UBICACION2 " + nombre7 + "";

        }

        //// playera
        if (prenda.equals("PLAYERA")) {

            ubicacion1 = "BORDADO PLAYERA PECHO IZQUIERDO " + nombre1 + "";
            ubicacion2 = "BORDADO PLAYERA PECHO DERECHO " + nombre2 + "";
            ubicacion3 = "BORDADO PLAYERA MANGA IZQUIERDA " + nombre3 + "";
            ubicacion4 = "BORDADO PLAYERA MANGA DERECHA " + nombre4 + "";
            ubicacion5 = "BORDADO PLAYERA ESPALDA " + nombre5 + "";
            ubicacion6 = "BORDADO PLAYERA OTRA UBICACION " + nombre6 + "";
            ubicacion7 = "BORDADO PLAYERA OTRA UBICACION2 " + nombre7 + "";

        }

        //// chamarra desmontable
        if (prenda.startsWith("CHAMARRA DESMONTABLE")) {

            ubicacion1 = "BORDADO CHAMARRA DESMONTABLE PECHO IZQUIERDO " + nombre1 + "";
            ubicacion2 = "BORDADO CHAMARRA DESMONTABLE PECHO DERECHO " + nombre2 + "";
            ubicacion3 = "BORDADO CHAMARRA DESMONTABLE MANGA IZQUIERDA " + nombre3 + "";
            ubicacion4 = "BORDADO CHAMARRA DESMONTABLE MANGA DERECHA " + nombre4 + "";
            ubicacion5 = "BORDADO CHAMARRA DESMONTABLE ESPALDA " + nombre5 + "";
            ubicacion6 = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION " + nombre6 + "";
            ubicacion7 = "BORDADO CHAMARRA DESMONTABLE OTRA UBICACION2 " + nombre7 + "";

        }

        /// chamarra rompevientos
        if (prenda.startsWith("CHAMARRA ROMPEVIENTOS")) {
            ubicacion1 = "BORDADO CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO " + nombre1 + "";
            ubicacion2 = "BORDADO CHAMARRA ROMPEVIENTOS PECHO DERECHO " + nombre2 + "";
            ubicacion3 = "BORDADO CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA " + nombre3 + "";
            ubicacion4 = "BORDADO CHAMARRA ROMPEVIENTOS MANGA DERECHA " + nombre4 + "";
            ubicacion5 = "BORDADO CHAMARRA ROMPEVIENTOS ESPALDA " + nombre5 + "";
            ubicacion6 = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION " + nombre6 + "";
            ubicacion7 = "BORDADO CHAMARRA ROMPEVIENTOS OTRA UBICACION2 " + nombre7 + "";

        }

        ///camisola
        if (prenda.startsWith("CAMISOLA")) {
            ubicacion1 = "BORDADO CAMISOLA PECHO IZQUIERDO " + nombre1 + "";
            ubicacion2 = "BORDADO CAMISOLA PECHO DERECHO " + nombre2 + "";
            ubicacion3 = "BORDADO CAMISOLA MANGA IZQUIERDA " + nombre3 + "";
            ubicacion4 = "BORDADO CAMISOLA MANGA DERECHA " + nombre4 + "";
            ubicacion5 = "BORDADO CAMISOLA ESPALDA " + nombre5 + "";
            ubicacion6 = "BORDADO CAMISOLA OTRA UBICACION " + nombre6 + "";
            ubicacion7 = "BORDADO CAMISOLA OTRA UBICACION2 " + nombre7 + "";

        } else if (prenda.startsWith("GORRA")) {
            ubicacion1 = "BORDADO GORRA FRENTE " + nombre1 + "";
            ubicacion2 = "BORDADO GORRA ATRAS " + nombre2 + "";
            ubicacion3 = "BORDADO GORRA LADO IZQUIERDO " + nombre3 + "";
            ubicacion4 = "BORDADO GORRA LADO DERECHO " + nombre4 + "";

        } else if (prenda.startsWith("PANTALON")) {

            ubicacion1 = "BORDADO PANTALON FRENTE LADO IZQUIERDO " + nombre1 + "";
            ubicacion2 = "BORDADO PANTALON FRENTE LADO DERECHO " + nombre2 + "";
            ubicacion3 = "BORDADO PANTALON ATRAS LADO IZQUIERDO " + nombre3 + "";
            ubicacion4 = "BORDADO PANTALON ATRAS LADO DERECHO " + nombre4 + "";

        } /// corbata
        else if (prenda.equals("CORBATA")) {
            ubicacion1 = "BORDADO CORBATA FRENTE " + nombre1 + "";
        } ///FILIPINA
        else if (prenda.equals("FILIPINA")) {

            ubicacion1 = "BORDADO FILIPINA PECHO IZQUIERDO " + nombre1 + "";
            ubicacion2 = "BORDADO FILIPINA PECHO DERECHO " + nombre2 + "";
            ubicacion3 = "BORDADO FILIPINA MANGA IZQUIERDA " + nombre3 + "";
            ubicacion4 = "BORDADO FILIPINA MANGA DERECHA " + nombre4 + "";
            ubicacion5 = "BORDADO FILIPINA ESPALDA " + nombre5 + "";
            ubicacion6 = "BORDADO FILIPINA OTRA UBICACION " + nombre6 + "";
            ubicacion7 = "BORDADO FILIPINA OTRA UBICACION2 " + nombre7 + "";

        } ///SACO
        else if (prenda.equals("SACO")) {

            ubicacion1 = "BORDADO SACO PECHO IZQUIERDO " + nombre1 + "";
            ubicacion2 = "BORDADO SACO PECHO DERECHO " + nombre2 + "";
            ubicacion3 = "BORDADO SACO MANGA IZQUIERDA " + nombre3 + "";
            ubicacion4 = "BORDADO SACO MANGA DERECHA " + nombre4 + "";
            ubicacion5 = "BORDADO SACO ESPALDA " + nombre5 + "";

        } else if (prenda.equals("CHALECO")) {

            ubicacion1 = "BORDADO CHALECO PECHO IZQUIERDO " + nombre1 + "";
            ubicacion2 = "BORDADO CHALECO PECHO DERECHO " + nombre2 + "";
            ubicacion3 = "BORDADO CHALECO ESPALDA " + nombre3 + "";
            ubicacion4 = "BORDADO CHALECO OTRA UBICACION " + nombre6 + "";
            ubicacion5 = "BORDADO CHALECO OTRA UBICACION2 " + nombre5 + "";

        } else if (prenda.equals("PARCHE")) {

            ubicacion1 = "BORDADO PARCHE " + nombre1 + "";

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
        btnguardar = new javax.swing.JButton();
        lbprenda = new javax.swing.JLabel();
        lbetiqueta7 = new javax.swing.JLabel();
        cbpuntadas7 = new javax.swing.JComboBox<>();
        txt7 = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        btndatos = new javax.swing.JButton();
        lbnombrecomercial = new javax.swing.JLabel();
        txtidentificadordeprenda = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtcodigocatalogobordados = new javax.swing.JLabel();
        lbidentificadordeprendaanterior = new javax.swing.JLabel();
        lbconsecutivo = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
        cbpuntadas5 = new javax.swing.JComboBox<>();
        jLabel51 = new javax.swing.JLabel();
        cbpuntadasPrevia7 = new javax.swing.JComboBox<>();
        cbpuntadasPrevia2 = new javax.swing.JComboBox<>();
        cbpuntadasPrevia1 = new javax.swing.JComboBox<>();
        jLabel52 = new javax.swing.JLabel();
        cbpuntadasPrevia6 = new javax.swing.JComboBox<>();
        cbpuntadasPrevia3 = new javax.swing.JComboBox<>();
        cbpuntadasPrevia4 = new javax.swing.JComboBox<>();
        cbpuntadasPrevia5 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bordados del cliente editar nuevo");
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

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(0, 102, 0));
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
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

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel50.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel50.setText("Nombre deL bordado");
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

        txtcodigocatalogobordados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtcodigocatalogobordados.setText("00000000");
        txtcodigocatalogobordados.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Identificador");
        jLabel11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        cbpuntadasPrevia7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadasPrevia7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadasPrevia7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbpuntadasPrevia2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadasPrevia2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadasPrevia2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbpuntadasPrevia1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadasPrevia1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadasPrevia1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jLabel52.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(0, 102, 0));
        jLabel52.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel52.setText("Seleccione puntadas");
        jLabel52.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbpuntadasPrevia6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadasPrevia6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadasPrevia6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbpuntadasPrevia3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadasPrevia3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadasPrevia3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbpuntadasPrevia4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadasPrevia4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadasPrevia4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        cbpuntadasPrevia5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        cbpuntadasPrevia5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadasPrevia5PopupMenuCanceled(evt);
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbpuntadasPrevia5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
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
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1514, 1514, 1514)
                                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadasPrevia1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadasPrevia2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadasPrevia3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(cbpuntadasPrevia7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbpuntadasPrevia6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cbpuntadasPrevia5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbpuntadasPrevia4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(cbpuntadas5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbpuntadas4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbpuntadas7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbpuntadas6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(414, 414, 414))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbpuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbpuntadas2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbpuntadas3, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(414, 414, 414))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcodigocatalogobordados, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(233, 233, 233)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(txtidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 978, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addComponent(lbconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(14, 14, 14))
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
                        .addGap(7, 7, 7)
                        .addComponent(lbprenda, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtidentificadordeprenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbconsecutivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbetiqueta1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbetiqueta2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadas2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbetiqueta3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadas3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lbetiqueta4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadas4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbpuntadas5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbetiqueta6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbidentificadordeprendaanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbetiqueta7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(txt6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(txt7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbpuntadas6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbpuntadas7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(cbpuntadasPrevia1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(cbpuntadasPrevia2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(cbpuntadasPrevia3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(cbpuntadasPrevia4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbpuntadasPrevia5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbetiqueta5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbpuntadasPrevia6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbpuntadasPrevia7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndatos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigocatalogobordados, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcodigocliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        ventanabordadosdelclienteeditarnuevo = false;
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

        if (dejoespacioalfinal.equals("no")) {

            String yahayunbordadosconesenombre = "no";

            pasa = "si";

            String nombrebordado = txtidentificadordeprenda.getText().trim();

            if ((nombrebordado == null || nombrebordado.equals("") || nombrebordado.equals(" ") || nombrebordado.equals("1") || nombrebordado.equals("2") || nombrebordado.equals("3") || nombrebordado.equals("4")) && actualizarbordado.equals("no")) {

                pasa = "no";
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de agregar el IDENTIFICAR DE PRENDA");
                txtidentificadordeprenda.requestFocus();
                txtidentificadordeprenda.selectAll();

            } else {

                String nombre1 = txt1.getText().trim();
                String nombre2 = txt2.getText().trim();
                String nombre3 = txt4.getText().trim();
                String nombre4 = txt3.getText().trim();
                String nombre5 = txt5.getText().trim();
                String nombre6 = txt6.getText().trim();
                String nombre7 = txt7.getText().trim();

                if (nombre1.equals("") && nombre2.equals("") && nombre3.equals("") && nombre4.equals("") && nombre5.equals("") && nombre6.equals("") && nombre7.equals("")) {

                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas y nombre a los bordados");
                    pasa = "no";

                } else {

                    String puntadas1 = cbpuntadas1.getSelectedItem().toString();

                    if (puntadas1.startsWith("BORDADO")) {

                        if (nombre1.equals("") || nombre1.equals(" ") || nombre1.equals("ninguno") || nombre1.equals("NINGUNO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 1");
                            pasa = "no";
                        }

                    }
                    if (!nombre1.equals("") && !nombre1.equals(" ") && !nombre1.equals("ninguno") && !nombre1.equals("NINGUNO")) {
                        if (!puntadas1.startsWith("BORDADO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 1");
                            pasa = "no";
                        }

                    }

                    String puntadas2 = cbpuntadas2.getSelectedItem().toString();

                    if (puntadas2.startsWith("BORDADO")) {

                        if (nombre2.equals("") || nombre2.equals(" ") || nombre2.equals("ninguno") || nombre2.equals("NINGUNO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 2");
                            pasa = "no";
                        }

                    }
                    if (!nombre2.equals("") && !nombre2.equals(" ") && !nombre2.equals("ninguno") && !nombre2.equals("NINGUNO")) {
                        if (!puntadas2.startsWith("BORDADO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 2");
                            pasa = "no";
                        }

                    }

                    String puntadas3 = cbpuntadas4.getSelectedItem().toString();

                    if (puntadas3.startsWith("BORDADO")) {

                        if (nombre3.equals("") || nombre3.equals(" ") || nombre3.equals("ninguno") || nombre3.equals("NINGUNO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 3");
                            pasa = "no";
                        }

                    }
                    if (!nombre3.equals("") && !nombre3.equals(" ") && !nombre3.equals("ninguno") && !nombre3.equals("NINGUNO")) {
                        if (!puntadas3.startsWith("BORDADO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 3");
                            pasa = "no";
                        }

                    }

                    String puntadas4 = cbpuntadas3.getSelectedItem().toString();

                    if (puntadas4.startsWith("BORDADO")) {

                        if (nombre4.equals("") || nombre4.equals(" ") || nombre4.equals("ninguno") || nombre4.equals("NINGUNO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 4");
                            pasa = "no";
                        }

                    }
                    if (!nombre4.equals("") && !nombre4.equals(" ") && !nombre4.equals("ninguno") && !nombre4.equals("NINGUNO")) {
                        if (!puntadas4.startsWith("BORDADO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 4");
                            pasa = "no";
                        }

                    }

                    String puntadas5 = cbpuntadas5.getSelectedItem().toString();

                    if (puntadas5.startsWith("BORDADO")) {

                        if (nombre5.equals("") || nombre5.equals(" ") || nombre5.equals("ninguno") || nombre5.equals("NINGUNO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 5");
                            pasa = "no";
                        }

                    }
                    if (!nombre5.equals("") && !nombre5.equals(" ") && !nombre5.equals("ninguno") && !nombre5.equals("NINGUNO")) {
                        if (!puntadas5.startsWith("BORDADO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 5; recuerde que si es chamarra debe indicar si utiliza el aro grande");
                            pasa = "no";
                        }

                    }

                    String puntadas6 = cbpuntadas6.getSelectedItem().toString();
                    nombre6 = txt6.getText();

                    if (puntadas6.startsWith("BORDADO")) {

                        if (nombre6.equals("") || nombre6.equals(" ") || nombre6.equals("ninguno") || nombre6.equals("NINGUNO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 6");
                            pasa = "no";
                        }

                    }
                    if (!nombre6.equals("") && !nombre6.equals(" ") && !nombre6.equals("ninguno") && !nombre6.equals("NINGUNO")) {
                        if (!puntadas6.startsWith("BORDADO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 6");
                            pasa = "no";
                        }

                    }

                    String puntadas7 = cbpuntadas7.getSelectedItem().toString();
                    nombre7 = txt7.getText();

                    if (puntadas7.startsWith("BORDADO")) {

                        if (nombre7.equals("") || nombre7.equals(" ") || nombre7.equals("ninguno") || nombre7.equals("NINGUNO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar un nombre a las puntadas 7");
                            pasa = "no";
                        }

                    }

                    if (!nombre7.equals("") && !nombre7.equals(" ") && !nombre7.equals("ninguno") && !nombre7.equals("NINGUNO")) {
                        if (!puntadas7.startsWith("BORDADO")) {
                            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Debe asignar puntadas al concepto 7");
                            pasa = "no";
                        }

                    }

                    if (pasa.equals("si")) {

                        if (yahayunbordadosconesenombre.equals("no")) {

                            if (prenda.equals("CAMISA") || prenda.equals("PLAYERA") || prenda.equals("CHAMARRA DESMONTABLE") || prenda.equals("CHAMARRA ROMPEVIENTOS") || prenda.equals("CAMISOLA") || prenda.equals("FILIPINA") || prenda.equals("SACO")) {
                                Object pechoizquierdo = cbpuntadas1.getSelectedItem();
                                if (pechoizquierdo == null || pechoizquierdo.equals("") || pechoizquierdo.equals(" ")) {
                                    pechoizquierdo = "ninguno";
                                }
                                Object pechoizquierdonombre = txt1.getText().trim();
                               
                               

                               

                                Object pechoderecho = cbpuntadas2.getSelectedItem();
                                if (pechoderecho == null || pechoderecho.equals("") || pechoderecho.equals(" ")) {
                                    pechoderecho = "ninguno";
                                }
                                Object pechoderechonombre = txt2.getText().trim();
                               
                                Object mangaizquierda = cbpuntadas3.getSelectedItem();
                                if (mangaizquierda == null || mangaizquierda.equals("") || mangaizquierda.equals(" ")) {
                                    mangaizquierda = "0";
                                }
                                Object mangaizquierdanombre = txt3.getText().trim();
                                

                                Object mangaderecha = cbpuntadas4.getSelectedItem();
                                if (mangaderecha == null || mangaderecha.equals("") || mangaderecha.equals(" ")) {
                                    mangaderecha = "0";
                                }
                                Object mangaderechanombre = txt4.getText().trim();
                              
                                Object espalda = cbpuntadas5.getSelectedItem();
                                if (espalda == null || espalda.equals("") || espalda.equals(" ")) {
                                    espalda = "ninguno";
                                }
                                Object espaldanombre = txt5.getText().trim();
                                

                                Object otraubicacion = cbpuntadas6.getSelectedItem();
                                if (otraubicacion == null || otraubicacion.equals("") || otraubicacion.equals(" ")) {
                                    otraubicacion = "ninguno";
                                }
                                Object otraubicacionnombre = txt6.getText().trim();
                               

                                Object otraubicacion2 = cbpuntadas7.getSelectedItem();
                                if (otraubicacion2 == null || otraubicacion2.equals("") || otraubicacion2.equals(" ")) {
                                    otraubicacion2 = "ninguno";
                                }
                                Object otraubicacionnombre2 = txt7.getText().trim();
                               

                               

                                if (actualizarbordado.equals("si")) 
                                {

                                    ///////
                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET "
                                                + "nombre_bordado = '" + nombrebordado + "',"
                                                + "pecho_izquierdo = '" + pechoizquierdo + "',"
                                                + "pecho_izquierdo_nombre='" + pechoizquierdonombre + "',"
                                                + "pecho_derecho='" + pechoderecho + "',"
                                                + "pecho_derecho_nombre='" + pechoderechonombre + "',"
                                                + "manga_derecha='" + mangaderecha + "' ,"
                                                + "manga_derecha_nombre='" + mangaderechanombre + "' ,"
                                                + "manga_izquierda='" + mangaizquierda + "' ,"
                                                + "manga_izquierda_nombre='" + mangaizquierdanombre + "',"
                                                + "espalda ='" + espalda + "' ,"
                                                + "espalda_nombre ='" + espaldanombre + "',"
                                                + "espalda_puntadas_aro ='" + espaldapuntadasaro + "',"
                                                + "espalda_aro ='" + espaldaaro + "',"
                                                + "otra_ubicacion ='" + otraubicacion + "' ,"
                                                + "otra_ubicacion_nombre ='" + otraubicacionnombre + "',"
                                                + "otra_ubicacion2 ='" + otraubicacion2 + "' ,"
                                                + "otra_ubicacion2_nombre ='" + otraubicacionnombre2 + "'  WHERE codigo='" + codigodelcliente + "' and tipo = '" + prenda + "' and numero_consecutivo = '" + txtcodigocatalogobordados.getText() + "'   ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                   

                                 

                                  

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET nombre_bordado = '" + txtidentificadordeprenda.getText().trim() + "' WHERE codigo='" + codigodelcliente + "' and AND tipo = '" + prenda + "' AND numero_consecutivo = '" + txtcodigocatalogobordados.getText() + "'");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }



                                }

                            } // GORRA
                            else if (lbprenda.getText().equals("GORRA")) {

                                Object frentegorra = cbpuntadas1.getSelectedItem();
                                Object frentegorranombre = txt1.getText();

                                Object ladoizquierdogorra = cbpuntadas2.getSelectedItem();
                                Object ladoizquierdogorranombre = txt2.getText();

                                Object ladoderechogorra = cbpuntadas4.getSelectedItem();
                                Object ladoderechogorranombre = txt4.getText();

                                Object atrasgorra = cbpuntadas3.getSelectedItem();
                                Object atrasgorranombre = txt3.getText();

                               

                                if (actualizarbordado.equals("si")) 
                                {

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET frente = '" + frentegorra + "',frente_nombre='" + frentegorranombre + "',lado_izquierdo='" + ladoizquierdogorra + "',lado_izquierdo_nombre='" + ladoizquierdogorranombre + "',lado_derecho ='" + ladoderechogorra + "' ,lado_derecho_nombre ='" + ladoderechogorranombre + "',atras ='" + atrasgorra + "' ,atras_nombre ='" + atrasgorranombre + "'  WHERE codigo='" + codigodelcliente + "' and  tipo = '" + prenda + "' AND numero_consecutivo = '" + consecutivo + "'   ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                 

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET nombre_bordado = '" + txtidentificadordeprenda.getText().trim() + "' WHERE  WHERE codigo='" + codigodelcliente + "' and  tipo = '" + prenda + "' AND numero_consecutivo = '" + consecutivo + "'  ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);

                                    }

                                 
                                }

                            } /// pantalon
                            else if (lbprenda.getText().equals("PANTALON")) {

                                Object ladoizquierdofrentepantalon = cbpuntadas1.getSelectedItem();
                                Object ladoizquierdofrentepantalonnombre = txt1.getText();


                                Object ladoderechofrentepantalon = cbpuntadas2.getSelectedItem();
                                Object ladoderechofrentepantalonnombre = txt2.getText();
                               

                                Object ladoizquierdoatraspantalon = cbpuntadas4.getSelectedItem();
                                Object ladoizquierdoatraspantalonnombre = txt4.getText();
                             

                                Object ladoderechoatraspantalon = cbpuntadas3.getSelectedItem();
                                Object ladoderechoatraspantalonnombre = txt3.getText();
                    

                               

                                if (actualizarbordado.equals("si")) {

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pantalon_lado_izquierdo_frente='" + ladoizquierdofrentepantalon + "',pantalon_lado_izquierdo_frente_nombre='" + ladoizquierdofrentepantalonnombre + "',pantalon_lado_izquierdo_frente_aplicacion='" + ladoizquierdofrentepantalonaplicacion + "',pantalon_lado_izquierdo_frente_aplicacion_color='" + ladoizquierdofrentepantalonaplicacioncolor + "',"
                                                + "pantalon_lado_derecho_frente ='" + ladoderechofrentepantalon + "' ,pantalon_lado_derecho_frente_nombre ='" + ladoderechofrentepantalonnombre + "',pantalon_lado_derecho_frente_aplicacion ='" + ladoderechofrentepantalonaplicacion + "',pantalon_lado_derecho_frente_aplicacion_color ='" + ladoderechofrentepantalonaplicacioncolor + "',"
                                                + "pantalon_lado_izquierdo_atras='" + ladoizquierdoatraspantalon + "',pantalon_lado_izquierdo_atras_nombre='" + ladoizquierdoatraspantalonnombre + "',pantalon_lado_izquierdo_atras_aplicacion='" + ladoizquierdoatraspantalonaplicacion + "',pantalon_lado_izquierdo_atras_aplicacion_color='" + ladoizquierdoatraspantalonaplicacioncolor + "',"
                                                + "pantalon_lado_derecho_atras ='" + ladoderechoatraspantalon + "' ,pantalon_lado_derecho_atras_nombre ='" + ladoderechoatraspantalonnombre + "',pantalon_lado_derecho_atras_aplicacion ='" + ladoderechoatraspantalonaplicacion + "',pantalon_lado_derecho_atras_aplicacion_color ='" + ladoderechoatraspantalonaplicacioncolor + "'   WHERE codigo='" + codigodelcliente + "' and  tipo = '" + prenda + "' AND numero_consecutivo = '" + consecutivo + "' ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                   

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET nombre_bordado = '" + txtidentificadordeprenda.getText().trim() + "'WHERE codigo='" + codigodelcliente + "' and  tipo = '" + prenda + "' AND numero_consecutivo = '" + consecutivo + "' ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                }

                            } // CORBATA
                            else if (lbprenda.getText().equals("CORBATA")) {

                                Object frentecorbata = cbpuntadas1.getSelectedItem();
                                Object frentecorbatanombre = txt1.getText();

                                if (actualizarbordado.equals("si")) {

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET corbata_frente='" + frentecorbata + "',corbata_frente_nombre='" + frentecorbatanombre + "' WHERE codigo='" + codigodelcliente + "' and  tipo = '" + prenda + "' AND numero_consecutivo = '" + consecutivo + "'  ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET nombre_bordado = '" + txtidentificadordeprenda.getText().trim() + "' WHERE codigo='" + codigodelcliente + "' and  tipo = '" + prenda + "' AND numero_consecutivo = '" + consecutivo + "'  ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                }

                            } // PARCHE
                            else if (lbprenda.getText().equals("PARCHE")) {

                                Object parche = cbpuntadas1.getSelectedItem();
                                Object parchenombre = txt1.getText();

                                if (actualizarbordado.equals("si")) {

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET parche='" + parche + "',parche_nombre='" + parchenombre + "',parche_aplicacion='" + parcheaplicacion + "',parche_aplicacion_color='" + parcheaplicacioncolor + "' WHERE codigo='" + codigodelcliente + "' and  tipo = '" + prenda + "' AND numero_consecutivo = '" + consecutivo + "' ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET nombre_bordado = '" + txtidentificadordeprenda.getText().trim() + "'WHERE codigo='" + codigodelcliente + "' and  tipo = '" + prenda + "' AND numero_consecutivo = '" + consecutivo + "'  ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                }

                            } //CHALECO
                            else if (lbprenda.getText().equals("CHALECO")) {

                                Object pechoizquierdochaleco = cbpuntadas1.getSelectedItem();
                                Object pechoizquierdochaleconombre = txt1.getText();

                                Object pechoderechochaleco = cbpuntadas2.getSelectedItem();
                                Object pechoderechochaleconombre = txt2.getText();

                                Object espaldachaleco = cbpuntadas4.getSelectedItem();
                                Object espaldachaleconombre = txt4.getText();

                                Object otraubicacionchaleco = cbpuntadas3.getSelectedItem();
                                Object otraubicacionchaleconombre = txt3.getText();

                                Object otraubicacion2chaleco = cbpuntadas5.getSelectedItem();
                                Object otraubicacion2chaleconombre = txt5.getText();

                                if (actualizarbordado.equals("si")) {
                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pecho_izquierdo = '" + pechoizquierdochaleco + "',pecho_izquierdo_nombre='" + pechoizquierdochaleconombre + "',pecho_derecho='" + pechoderechochaleco + "',pecho_derecho_nombre='" + pechoderechochaleconombre + "',espalda ='" + espaldachaleco + "' ,espalda_nombre ='" + espaldachaleconombre + "' ,otra_ubicacion ='" + otraubicacionchaleco + "', otra_ubicacion_nombre ='" + otraubicacionchaleconombre + "', otra_ubicacion2 ='" + otraubicacion2chaleco + "',otra_ubicacion2_nombre ='" + otraubicacion2chaleconombre + "'   WHERE codigo='" + codigodelcliente + "'  and nombre_bordado = '" + nombrebordado + "'  ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                   

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET nombre_bordado = '" + txtidentificadordeprenda.getText().trim() + "' WHERE codigo='" + codigodelcliente + "' and nombre_bordado = '" + nombrebordado + "'  AND tipo = '" + prenda + "' ");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                }

                            } // MANDIL
                            else if (lbprenda.getText().equals("MANDIL")) {

                                Object pechoizquierdomandil = cbpuntadas1.getSelectedItem();
                                Object pechoizquierdomandilnombre = txt1.getText();


                                Object pechoderechomandil = cbpuntadas2.getSelectedItem();
                                Object pechoderechomandilnombre = txt2.getText();


                                Object centromandil = cbpuntadas3.getSelectedItem();
                                Object centromandilnombre = txt3.getText();

                             

                                if (actualizarbordado.equals("si")) {

                                    try {
                                        PreparedStatement pst = cn.prepareStatement("UPDATE bordados_puntadas SET pecho_izquierdo = '" + pechoizquierdomandil + "',pecho_izquierdo_nombre='" + pechoizquierdomandilnombre + "',pecho_derecho='" + pechoderechomandil + "',pecho_derecho_nombre='" + pechoderechomandilnombre + "',centro ='" + centromandil + "' ,centro_nombre ='" + centromandilnombre + "'  WHERE codigo='" + codigodelcliente + "'");
                                        pst.executeUpdate();
                                        pst.close();
                                    } catch (Exception e) {
                                        System.out.println(e);
                                    }

                                   
                                  

                                }

                            }

                        }

                    }

                }

            }

            if (cerrarinterface.equals("si") && pasa.equals("si")) {
                this.dispose();
                ventanabordadosdelclienteeditarnuevo = false;

            } else {
                cerrarinterface = "si";
            }

        }

        dejoespacioalfinal = "no";
        //termina guardar 

    }//GEN-LAST:event_btnguardarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        ventanabordadosdelclienteeditarnuevo = false;
        this.dispose();;
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanabordadosdelclienteeditarnuevo = false;
        this.dispose();;
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        datos();
        identificador();


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

        if (nombre.contains("  ")) {

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
            txtidentificadordeprenda.requestFocus();
            txtidentificadordeprenda.selectAll();

            txtidentificadordeprenda.setText(nombreanterior);

        } else {

            String cadena = (txtidentificadordeprenda.getText()).toUpperCase();

            int pos = txtidentificadordeprenda.getCaretPosition();
            txtidentificadordeprenda.setText(txtidentificadordeprenda.getText().toUpperCase());
            txtidentificadordeprenda.setCaretPosition(pos);

            if (cadena.contains(prenda)) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre del concepto ");
            }

        }


    }//GEN-LAST:event_txtidentificadordeprendaKeyReleased

    private void txt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt1KeyReleased



        String nombre = txt1.getText();

        if (nombre.contains("  ")) {

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
            txt1.requestFocus();
            txt1.selectAll();

            txt1.setText(nombreanterior);

        } else {

            String cadena = (txt1.getText()).toUpperCase();

            int pos = txt1.getCaretPosition();
            txt1.setText(txt1.getText().toUpperCase());
            txt1.setCaretPosition(pos);

            if (cadena.contains(prenda)) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
            }

        }


    }//GEN-LAST:event_txt1KeyReleased

    private void txt2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt2KeyReleased



        String nombre = txt2.getText();

        if (nombre.contains("  ")) {

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
            txt2.requestFocus();
            txt2.selectAll();

            txt2.setText(nombreanterior);

        } else {

            String cadena = (txt2.getText()).toUpperCase();
            txt2.setText(cadena);
            if (cadena.contains(prenda)) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
            }

        }


    }//GEN-LAST:event_txt2KeyReleased

    private void txt4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt4KeyReleased



        String nombre = txt4.getText();

        if (nombre.contains("  ")) {

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
            txt4.requestFocus();
            txt4.selectAll();

            txt4.setText(nombreanterior);

        } else {

            String cadena = (txt4.getText()).toUpperCase();

            int pos = txt4.getCaretPosition();
            txt4.setText(txt4.getText().toUpperCase());
            txt4.setCaretPosition(pos);

            if (cadena.contains(prenda)) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
            }

        }


    }//GEN-LAST:event_txt4KeyReleased

    private void txt3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt3KeyReleased



        String nombre = txt3.getText();

        if (nombre.contains("  ")) {

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
            txt3.requestFocus();
            txt3.selectAll();

            txt3.setText(nombreanterior);

        } else {

            String cadena = (txt3.getText()).toUpperCase();
            txt3.setText(cadena);
            if (cadena.contains(prenda)) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
            }

        }


    }//GEN-LAST:event_txt3KeyReleased

    private void txt5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt5KeyReleased

      

        String nombre = txt5.getText();

        if (nombre.contains("  ")) {

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
            txt5.requestFocus();
            txt5.selectAll();

            txt5.setText(nombreanterior);

        } else {

            String cadena = (txt5.getText()).toUpperCase();

            int pos = txt5.getCaretPosition();
            txt5.setText(txt5.getText().toUpperCase());
            txt5.setCaretPosition(pos);

            if (cadena.contains(prenda)) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
            }

        }


    }//GEN-LAST:event_txt5KeyReleased

    private void txt6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt6KeyReleased

        String nombre = txt6.getText();

        if (nombre.contains("  ")) {

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
            txt6.requestFocus();
            txt6.selectAll();

            txt6.setText(nombreanterior);

        } else {

            String cadena = (txt6.getText()).toUpperCase();

            int pos = txt6.getCaretPosition();
            txt6.setText(txt6.getText().toUpperCase());
            txt6.setCaretPosition(pos);

            if (cadena.contains(prenda)) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no poner el nombre de la prenda en el nombre ");
            }

        }


    }//GEN-LAST:event_txt6KeyReleased

    private void txt7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt7KeyReleased

     

        String nombre = txt3.getText();

        if (nombre.contains("  ")) {

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar 2 espacios entre las palabras");
            txt3.requestFocus();
            txt3.selectAll();

            txt3.setText(nombreanterior);

        } else {

            String cadena = (txt7.getText()).toUpperCase();

            int pos = txt7.getCaretPosition();
            txt7.setText(txt7.getText().toUpperCase());
            txt7.setCaretPosition(pos);

            if (cadena.contains(prenda)) {
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

        String cadena[] = nombre.split("");

        char ultimocaracter = nombre.charAt(cadena.length - 1);

        String ultimocararterstring = String.valueOf(ultimocaracter);

        if (ultimocararterstring.equals(" ")) {

            dejoespacioalfinal = "si";

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
            txt1.requestFocus();
            txt1.selectAll();

        } else {

            if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI")) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
            }

        }


    }//GEN-LAST:event_txt1FocusLost

    private void txt2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt2FocusLost

        String nombre = txt2.getText();

        String cadena[] = nombre.split("");

        char ultimocaracter = nombre.charAt(cadena.length - 1);

        String ultimocararterstring = String.valueOf(ultimocaracter);

        if (ultimocararterstring.equals(" ")) {

            dejoespacioalfinal = "si";

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
            txt2.requestFocus();
            txt2.selectAll();

        } else {

            if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI")) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
            }

        }


    }//GEN-LAST:event_txt2FocusLost

    private void txt3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt3FocusLost

        String nombre = txt3.getText();

        String cadena[] = nombre.split("");

        char ultimocaracter = nombre.charAt(cadena.length - 1);

        String ultimocararterstring = String.valueOf(ultimocaracter);

        if (ultimocararterstring.equals(" ")) {

            dejoespacioalfinal = "si";

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
            txt3.requestFocus();
            txt3.selectAll();

        } else {
            ;

            if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI")) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
            }

        }


    }//GEN-LAST:event_txt3FocusLost

    private void txt4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt4FocusLost

        String nombre = txt4.getText();

        String cadena[] = nombre.split("");

        char ultimocaracter = nombre.charAt(cadena.length - 1);

        String ultimocararterstring = String.valueOf(ultimocaracter);

        if (ultimocararterstring.equals(" ")) {

            dejoespacioalfinal = "si";

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
            txt4.requestFocus();
            txt4.selectAll();

        } else {

            if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI")) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
            }

        }


    }//GEN-LAST:event_txt4FocusLost

    private void txt5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt5FocusLost

        String nombre = txt5.getText();

        String cadena[] = nombre.split("");

        char ultimocaracter = nombre.charAt(cadena.length - 1);

        String ultimocararterstring = String.valueOf(ultimocaracter);

        if (ultimocararterstring.equals(" ")) {

            dejoespacioalfinal = "si";

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
            txt5.requestFocus();
            txt5.selectAll();

        } else {

            if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI")) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
            }

        }


    }//GEN-LAST:event_txt5FocusLost

    private void txt6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt6FocusLost

        String nombre = txt6.getText();

        String cadena[] = nombre.split("");

        char ultimocaracter = nombre.charAt(cadena.length - 1);

        String ultimocararterstring = String.valueOf(ultimocaracter);

        if (ultimocararterstring.equals(" ")) {

            dejoespacioalfinal = "si";

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
            txt6.requestFocus();
            txt6.selectAll();

        } else {

            if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI")) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
            }

        }


    }//GEN-LAST:event_txt6FocusLost

    private void txt7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt7FocusLost

        String nombre = txt7.getText();

        String cadena[] = nombre.split("");

        char ultimocaracter = nombre.charAt(cadena.length - 1);

        String ultimocararterstring = String.valueOf(ultimocaracter);

        if (ultimocararterstring.equals(" ")) {

            dejoespacioalfinal = "si";

            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de no dejar un espacio al final del nombre");
            txt7.requestFocus();
            txt7.selectAll();

        } else {

            if (nombre.contains("VERDE") || nombre.contains("DORADO") || nombre.contains("ROJO") || nombre.contains("AMARILO") || nombre.contains("ANARANJADO") || nombre.contains("BLANCO") || nombre.contains("NEGRO") || nombre.contains("MARINO") || nombre.contains("AZUL") || nombre.contains("GRIS") || nombre.contains("VINO") || nombre.contains("ROSA") || nombre.contains("MORADO") || nombre.contains("CAFE") || nombre.contains("CREMA") || nombre.contains("KAKI")) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Sugerimos no incluir colores en los NOMBRES DE LA UBICACIONES");
            }

        }


    }//GEN-LAST:event_txt7FocusLost

    private void cbpuntadas5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadas5PopupMenuWillBecomeInvisible

        


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

    private void cbpuntadasPrevia7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadasPrevia7PopupMenuWillBecomeInvisible

        String puntadas = cbpuntadasPrevia7.getSelectedItem().toString();
        String bordado = cbpuntadasPrevia7.getSelectedItem().toString();

        cbpuntadas7.setSelectedItem(puntadas);


    }//GEN-LAST:event_cbpuntadasPrevia7PopupMenuWillBecomeInvisible

    private void cbpuntadasPrevia2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadasPrevia2PopupMenuWillBecomeInvisible

        String puntadas = cbpuntadasPrevia2.getSelectedItem().toString();
        String bordado = cbpuntadasPrevia2.getSelectedItem().toString();

        if (puntadas.equals("SEGURIDAD")) {
            puntadas = "BORDADO DE MENOS DE 5,000 PUNTADAS";
            txt2.setText(bordado);
        }
        if (puntadas.equals("SEGURIDAD PRIVADA")) {
            puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
            txt2.setText(bordado);
        }
        if (puntadas.equals("VIGILANCIA")) {
            puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
            txt2.setText(bordado);
        }

        if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno")) {

            String sql = "SELECT distinct pecho_izquierdo_nombre,pecho_izquierdo,pecho_derecho_nombre,pecho_derecho FROM bordados_puntadas where codigo = '" + codigodelcliente + "' "
                    + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                    + "and pecho_izquierdo_nombre = '" + puntadas + "' or pecho_derecho_nombre = '" + puntadas + "' ";

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

                    if (pechoizquierdonombre.startsWith(puntadas)) {
                        puntadas = pechoizquierdo;
                    }

                    if (pechoderechonombre.startsWith(puntadas)) {
                        puntadas = pechoderecho;
                    }

                    cbpuntadas2.setSelectedItem(puntadas);
                    txt2.setText(bordado);

                } else {

                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } else {
            cbpuntadas2.setSelectedItem(puntadas);

        }


    }//GEN-LAST:event_cbpuntadasPrevia2PopupMenuWillBecomeInvisible

    private void cbpuntadasPrevia1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadasPrevia1PopupMenuWillBecomeInvisible

        String puntadas = cbpuntadasPrevia1.getSelectedItem().toString();
        String bordado = cbpuntadasPrevia1.getSelectedItem().toString();

        if (puntadas.equals("SEGURIDAD")) {
            puntadas = "BORDADO DE MENOS DE 5,000 PUNTADAS";
            txt1.setText(bordado);
        }
        if (puntadas.equals("SEGURIDAD PRIVADA")) {
            puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
            txt1.setText(bordado);
        }
        if (puntadas.equals("VIGILANCIA")) {
            puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
            txt1.setText(bordado);
        }

        if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno")) {

            String sql = "SELECT distinct pecho_izquierdo_nombre,pecho_izquierdo,pecho_derecho_nombre,pecho_derecho FROM bordados_puntadas where codigo = '" + codigodelcliente + "' "
                    + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                    + "and pecho_izquierdo_nombre = '" + puntadas + "' or pecho_derecho_nombre = '" + puntadas + "' ";

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

                    if (pechoizquierdonombre.startsWith(puntadas)) {
                        puntadas = pechoizquierdo;
                    }

                    if (pechoderechonombre.startsWith(puntadas)) {
                        puntadas = pechoderecho;
                    }

                    cbpuntadas1.setSelectedItem(puntadas);
                    txt1.setText(bordado);

                } else {

                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } else {
            cbpuntadas1.setSelectedItem(puntadas);

        }


    }//GEN-LAST:event_cbpuntadasPrevia1PopupMenuWillBecomeInvisible

    private void cbpuntadasPrevia6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadasPrevia6PopupMenuWillBecomeInvisible

        String puntadas = cbpuntadasPrevia6.getSelectedItem().toString();
        String bordado = cbpuntadasPrevia6.getSelectedItem().toString();

        cbpuntadas6.setSelectedItem(puntadas);


    }//GEN-LAST:event_cbpuntadasPrevia6PopupMenuWillBecomeInvisible

    private void cbpuntadasPrevia3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadasPrevia3PopupMenuWillBecomeInvisible

        String puntadas = cbpuntadasPrevia3.getSelectedItem().toString();
        String bordado = cbpuntadasPrevia3.getSelectedItem().toString();

        if (puntadas.equals("SEGURIDAD")) {
            puntadas = "BORDADO DE MENOS DE 5,000 PUNTADAS";
            txt3.setText(bordado);
        }
        if (puntadas.equals("SEGURIDAD PRIVADA")) {
            puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
            txt3.setText(bordado);
        }
        if (puntadas.equals("VIGILANCIA")) {
            puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
            txt3.setText(bordado);
        }

        if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno")) {

            String sql = "SELECT distinct manga_izquierda_nombre,manga_izquierda,manga_derecha_nombre,manga_derecha FROM bordados_puntadas where codigo = '" + codigodelcliente + "' "
                    + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                    + "and manga_izquierda_nombre = '" + puntadas + "' or manga_derecha_nombre = '" + puntadas + "' ";

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

                    if (pechoizquierdonombre.startsWith(puntadas)) {
                        puntadas = pechoizquierdo;
                    }

                    if (pechoderechonombre.startsWith(puntadas)) {
                        puntadas = pechoderecho;
                    }

                    cbpuntadas3.setSelectedItem(puntadas);
                    txt3.setText(bordado);

                } else {

                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } else {
            cbpuntadas3.setSelectedItem(puntadas);

        }

    }//GEN-LAST:event_cbpuntadasPrevia3PopupMenuWillBecomeInvisible

    private void cbpuntadasPrevia4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadasPrevia4PopupMenuWillBecomeInvisible

        String puntadas = cbpuntadasPrevia4.getSelectedItem().toString();
        String bordado = cbpuntadasPrevia4.getSelectedItem().toString();

        if (puntadas.equals("SEGURIDAD")) {
            puntadas = "BORDADO DE MENOS DE 5,000 PUNTADAS";
            txt4.setText(bordado);
        }
        if (puntadas.equals("SEGURIDAD PRIVADA")) {
            puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
            txt4.setText(bordado);
        }
        if (puntadas.equals("VIGILANCIA")) {
            puntadas = "BORDADO DE 5,000 A 7,500 PUNTADASS";
            txt4.setText(bordado);
        }

        if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno")) {

            String sql = "SELECT distinct manga_izquierda_nombre,manga_izquierda,manga_derecha_nombre,manga_derecha FROM bordados_puntadas where codigo = '" + codigodelcliente + "' "
                    + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                    + "and manga_izquierda_nombre = '" + puntadas + "' or manga_derecha_nombre = '" + puntadas + "' ";

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

                    if (pechoizquierdonombre.startsWith(puntadas)) {
                        puntadas = pechoizquierdo;
                    }

                    if (pechoderechonombre.startsWith(puntadas)) {
                        puntadas = pechoderecho;
                    }

                    cbpuntadas4.setSelectedItem(puntadas);
                    txt4.setText(bordado);

                } else {

                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } else {
            cbpuntadas4.setSelectedItem(puntadas);

        }

    }//GEN-LAST:event_cbpuntadasPrevia4PopupMenuWillBecomeInvisible

    private void cbpuntadasPrevia5PopupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadasPrevia5PopupMenuCanceled
        // TODO add your handling code here:
    }//GEN-LAST:event_cbpuntadasPrevia5PopupMenuCanceled

    private void cbpuntadasPrevia5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbpuntadasPrevia5PopupMenuWillBecomeInvisible

        String puntadas = cbpuntadasPrevia5.getSelectedItem().toString();
        String bordado = cbpuntadasPrevia5.getSelectedItem().toString();

        if (puntadas.equals("SEGURIDAD #1")) {
            puntadas = "BORDADO DE 10,000 A 12,500 PUNTADAS";
            txt5.setText(bordado);
        }
        if (puntadas.equals("SEGURIDAD #2")) {
            puntadas = "BORDADO DE 20,000 A 25,000 PUNTADAS";
            txt5.setText(bordado);
        }
        if (puntadas.equals("SEGURIDAD PRIVADA #1")) {
            puntadas = "BORDADO DE 10,000 A 12,500 PUNTADAS";
            txt5.setText(bordado);
        }
        if (puntadas.equals("SEGURIDAD PRIVADA #2")) {
            puntadas = "BORDADO DE 22,500 A 25,000 PUNTADAS";
            txt5.setText(bordado);
        }
        if (puntadas.equals("SEGURIDAD PRIVADA #3")) {
            puntadas = "BORDADO DE 37,500,000 A 40,000 PUNTADAS";
            txt5.setText(bordado);
        }

        if (!puntadas.startsWith("BORDADO") && !puntadas.equals("ninguno")) {

            String sql = "SELECT distinct espalda_nombre,espalda FROM bordados_puntadas where codigo = '" + codigodelcliente + "' "
                    + "and (tipo = 'CAMISA' or tipo = 'PLAYERA' or tipo = 'CHAMARRA DESMONTABLE' or tipo = 'CHAMARRA ROMPEVIENTO' or tipo = 'CAMISOLA' or tipo = 'FILIPINA' or tipo = 'SACO' or tipo = 'CHALECO' or tipo = 'MANDIL')"
                    + "and espalda_nombre = '" + puntadas + "'";

            String pechoizquierdonombre = "";
            String pechoizquierdo = "";

            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                    pechoizquierdonombre = rs.getString("espalda_nombre");
                    pechoizquierdo = rs.getString("espalda");

                    if (pechoizquierdonombre.startsWith(puntadas)) {
                        puntadas = pechoizquierdo;
                    }

                    cbpuntadas5.setSelectedItem(puntadas);
                    txt5.setText(bordado);

                } else {

                    JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se encotraron puntadas para este logo, llame a sistemas");
                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        } else {
            cbpuntadas5.setSelectedItem(puntadas);

        }


    }//GEN-LAST:event_cbpuntadasPrevia5PopupMenuWillBecomeInvisible

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
    private javax.swing.JComboBox<String> cbpuntadasPrevia1;
    private javax.swing.JComboBox<String> cbpuntadasPrevia2;
    private javax.swing.JComboBox<String> cbpuntadasPrevia3;
    private javax.swing.JComboBox<String> cbpuntadasPrevia4;
    private javax.swing.JComboBox<String> cbpuntadasPrevia5;
    private javax.swing.JComboBox<String> cbpuntadasPrevia6;
    private javax.swing.JComboBox<String> cbpuntadasPrevia7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbcodigocliente;
    private javax.swing.JLabel lbconsecutivo;
    private javax.swing.JLabel lbetiqueta1;
    private javax.swing.JLabel lbetiqueta2;
    private javax.swing.JLabel lbetiqueta3;
    private javax.swing.JLabel lbetiqueta4;
    private javax.swing.JLabel lbetiqueta5;
    private javax.swing.JLabel lbetiqueta6;
    private javax.swing.JLabel lbetiqueta7;
    public static javax.swing.JLabel lbidentificador;
    private javax.swing.JLabel lbidentificadordeprendaanterior;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbprenda;
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
