package sistemabordadores;

import java.awt.Dimension;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import java.io.File;
import javax.swing.JTable;

public class bordadosreportegeneral extends javax.swing.JFrame {

    public static boolean ventanareportedebordadosgeneral = false;

    String fechafinal = "";
    String fechainicial = "";
    String anterior = "";
    String messtring = "";

    int diafinal = 0;
    int mesfinal = -1;
    int añofinal = 0;

    int ultimomes = 0;
    int ultimoaño = 0;
    
    String cantidadpechoizquierdo="0";
    String cantidadpechoderecho="0";
    String cantidadmangaizquierda="0";
    String cantidadmangaderecha="0";
    String cantidadespalda="0";
    String cantidadotraubicacion="0";
    String cantidadotraubicacion2="0";
    
    ///
    String cantidadfrente="0";
    String cantidadladoderecho="0";
    String cantidadladoizquierdo="0";
    String cantidadatras="0";
    
    ///
    String cantidadfrentecorbata = "0";
    
    ///
    String cantidadladoizquierdofrente="0";
    String cantidadladoderechofrente="0";
    String cantidadladoizquierdoatras="0";
    String cantidadladoderechoatras="0";
    
    String cantidadponchado = "0";
    String cantidadparche = "0";
    
    
    
    PreparedStatement pst;

    public bordadosreportegeneral() {

        initComponents();
        ventanareportedebordadosgeneral = true;
        anchocolumnas();
        topes();
        seleccionarfechas();
        anterior = "no";
        agregarfechasalatablafecha();
        btnsiguiente.setEnabled(false);

    }

    void anchocolumnas() {

        tabla.getColumnModel().getColumn(0).setMinWidth(0);
        tabla.getColumnModel().getColumn(1).setMinWidth(0);
        tabla.getColumnModel().getColumn(2).setMinWidth(0);
        tabla.getColumnModel().getColumn(3).setMinWidth(0);
        tabla.getColumnModel().getColumn(4).setMinWidth(0);
        tabla.getColumnModel().getColumn(5).setMinWidth(0);
        tabla.getColumnModel().getColumn(6).setMinWidth(0);
        tabla.getColumnModel().getColumn(7).setMinWidth(0);
        tabla.getColumnModel().getColumn(8).setMinWidth(0);
        tabla.getColumnModel().getColumn(9).setMinWidth(0);
        tabla.getColumnModel().getColumn(10).setMinWidth(0);
        tabla.getColumnModel().getColumn(11).setMinWidth(0);
        tabla.getColumnModel().getColumn(12).setMinWidth(0);
        tabla.getColumnModel().getColumn(13).setMinWidth(0);
        tabla.getColumnModel().getColumn(14).setMinWidth(0);
        tabla.getColumnModel().getColumn(15).setMinWidth(0);
        tabla.getColumnModel().getColumn(16).setMinWidth(0);
        tabla.getColumnModel().getColumn(17).setMinWidth(0);
        tabla.getColumnModel().getColumn(18).setMinWidth(0);
        tabla.getColumnModel().getColumn(19).setMinWidth(0);
        tabla.getColumnModel().getColumn(20).setMinWidth(0);
        tabla.getColumnModel().getColumn(21).setMinWidth(0);
        tabla.getColumnModel().getColumn(22).setMinWidth(0);
        tabla.getColumnModel().getColumn(23).setMinWidth(0);
        tabla.getColumnModel().getColumn(24).setMinWidth(0);
        tabla.getColumnModel().getColumn(25).setMinWidth(0);
        tabla.getColumnModel().getColumn(26).setMinWidth(0);
        tabla.getColumnModel().getColumn(27).setMinWidth(0);
        tabla.getColumnModel().getColumn(28).setMinWidth(0);
        tabla.getColumnModel().getColumn(29).setMinWidth(0);
        tabla.getColumnModel().getColumn(30).setMinWidth(0);
        tabla.getColumnModel().getColumn(31).setMinWidth(0);
        tabla.getColumnModel().getColumn(32).setMinWidth(0);
        tabla.getColumnModel().getColumn(33).setMinWidth(0);
        tabla.getColumnModel().getColumn(34).setMinWidth(0);
        tabla.getColumnModel().getColumn(35).setMinWidth(0);
        tabla.getColumnModel().getColumn(36).setMinWidth(0);
        tabla.getColumnModel().getColumn(37).setMinWidth(0);
        tabla.getColumnModel().getColumn(38).setMinWidth(0);
        tabla.getColumnModel().getColumn(39).setMinWidth(0);
        tabla.getColumnModel().getColumn(40).setMinWidth(0);
        tabla.getColumnModel().getColumn(41).setMinWidth(0);
        tabla.getColumnModel().getColumn(42).setMinWidth(0);
        tabla.getColumnModel().getColumn(43).setMinWidth(0);
        tabla.getColumnModel().getColumn(44).setMinWidth(0);
        tabla.getColumnModel().getColumn(45).setMinWidth(0);
        tabla.getColumnModel().getColumn(46).setMinWidth(0);
        tabla.getColumnModel().getColumn(47).setMinWidth(0);
        tabla.getColumnModel().getColumn(48).setMinWidth(0);
        tabla.getColumnModel().getColumn(49).setMinWidth(0);
        tabla.getColumnModel().getColumn(50).setMinWidth(0);
        tabla.getColumnModel().getColumn(51).setMinWidth(0);
        tabla.getColumnModel().getColumn(52).setMinWidth(0);
        tabla.getColumnModel().getColumn(53).setMinWidth(0);
        tabla.getColumnModel().getColumn(54).setMinWidth(0);
        tabla.getColumnModel().getColumn(55).setMinWidth(0);
        tabla.getColumnModel().getColumn(56).setMinWidth(0);
        tabla.getColumnModel().getColumn(57).setMinWidth(0);
        tabla.getColumnModel().getColumn(58).setMinWidth(0);
        tabla.getColumnModel().getColumn(59).setMinWidth(0);
        tabla.getColumnModel().getColumn(60).setMinWidth(0);

        tabla.getColumnModel().getColumn(0).setMaxWidth(800);
        tabla.getColumnModel().getColumn(1).setMaxWidth(800);
        tabla.getColumnModel().getColumn(2).setMaxWidth(800);
        tabla.getColumnModel().getColumn(3).setMaxWidth(800);
        tabla.getColumnModel().getColumn(4).setMaxWidth(800);
        tabla.getColumnModel().getColumn(5).setMaxWidth(800);
        tabla.getColumnModel().getColumn(6).setMaxWidth(800);
        tabla.getColumnModel().getColumn(7).setMaxWidth(800);
        tabla.getColumnModel().getColumn(8).setMaxWidth(800);
        tabla.getColumnModel().getColumn(9).setMaxWidth(800);
        tabla.getColumnModel().getColumn(10).setMaxWidth(800);
        tabla.getColumnModel().getColumn(11).setMaxWidth(800);
        tabla.getColumnModel().getColumn(12).setMaxWidth(800);
        tabla.getColumnModel().getColumn(13).setMaxWidth(800);
        tabla.getColumnModel().getColumn(14).setMaxWidth(800);
        tabla.getColumnModel().getColumn(15).setMaxWidth(800);
        tabla.getColumnModel().getColumn(16).setMaxWidth(800);
        tabla.getColumnModel().getColumn(17).setMaxWidth(800);
        tabla.getColumnModel().getColumn(18).setMaxWidth(800);
        tabla.getColumnModel().getColumn(19).setMaxWidth(800);
        tabla.getColumnModel().getColumn(20).setMaxWidth(800);
        tabla.getColumnModel().getColumn(21).setMaxWidth(800);
        tabla.getColumnModel().getColumn(22).setMaxWidth(800);
        tabla.getColumnModel().getColumn(23).setMaxWidth(800);
        tabla.getColumnModel().getColumn(24).setMaxWidth(800);
        tabla.getColumnModel().getColumn(25).setMaxWidth(800);
        tabla.getColumnModel().getColumn(26).setMaxWidth(800);
        tabla.getColumnModel().getColumn(27).setMaxWidth(800);
        tabla.getColumnModel().getColumn(28).setMaxWidth(800);
        tabla.getColumnModel().getColumn(29).setMaxWidth(800);
        tabla.getColumnModel().getColumn(30).setMaxWidth(800);
        tabla.getColumnModel().getColumn(31).setMaxWidth(800);
        tabla.getColumnModel().getColumn(32).setMaxWidth(800);
        tabla.getColumnModel().getColumn(33).setMaxWidth(800);
        tabla.getColumnModel().getColumn(34).setMaxWidth(800);
        tabla.getColumnModel().getColumn(35).setMaxWidth(800);
        tabla.getColumnModel().getColumn(36).setMaxWidth(800);
        tabla.getColumnModel().getColumn(37).setMaxWidth(800);
        tabla.getColumnModel().getColumn(38).setMaxWidth(800);
        tabla.getColumnModel().getColumn(39).setMaxWidth(800);
        tabla.getColumnModel().getColumn(40).setMaxWidth(800);
        tabla.getColumnModel().getColumn(41).setMaxWidth(800);
        tabla.getColumnModel().getColumn(42).setMaxWidth(800);
        tabla.getColumnModel().getColumn(43).setMaxWidth(800);
        tabla.getColumnModel().getColumn(44).setMaxWidth(800);
        tabla.getColumnModel().getColumn(45).setMaxWidth(800);
        tabla.getColumnModel().getColumn(46).setMaxWidth(800);
        tabla.getColumnModel().getColumn(47).setMaxWidth(800);
        tabla.getColumnModel().getColumn(48).setMaxWidth(800);
        tabla.getColumnModel().getColumn(49).setMaxWidth(800);
        tabla.getColumnModel().getColumn(50).setMaxWidth(800);
        tabla.getColumnModel().getColumn(51).setMaxWidth(800);
        tabla.getColumnModel().getColumn(52).setMaxWidth(800);
        tabla.getColumnModel().getColumn(53).setMaxWidth(800);
        tabla.getColumnModel().getColumn(54).setMaxWidth(800);
        tabla.getColumnModel().getColumn(55).setMaxWidth(800);
        tabla.getColumnModel().getColumn(56).setMaxWidth(800);
        tabla.getColumnModel().getColumn(57).setMaxWidth(800);
        tabla.getColumnModel().getColumn(58).setMaxWidth(800);
        tabla.getColumnModel().getColumn(59).setMaxWidth(800);
        tabla.getColumnModel().getColumn(60).setMaxWidth(800);

        tabla.getColumnModel().getColumn(0).setPreferredWidth(100);
        tabla.getColumnModel().getColumn(1).setPreferredWidth(350);
        tabla.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(4).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(5).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(6).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(7).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(8).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(9).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(10).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(11).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(12).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(13).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(14).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(15).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(16).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(17).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(18).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(19).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(20).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(21).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(22).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(23).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(24).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(25).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(26).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(27).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(28).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(29).setPreferredWidth(200);
        tabla.getColumnModel().getColumn(30).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(31).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(32).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(33).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(34).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(35).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(36).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(37).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(38).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(39).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(40).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(41).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(42).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(43).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(44).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(45).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(46).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(47).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(48).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(49).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(50).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(51).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(52).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(53).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(54).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(55).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(56).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(57).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(58).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(59).setPreferredWidth(80);
        tabla.getColumnModel().getColumn(60).setPreferredWidth(80);

    }

    public static int numerodediasmes(int mes) {

        int numeroDias = -1;

        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numeroDias = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numeroDias = 30;
                break;
            case 2:

                Date añoactual = new Date();
                if (esBisiesto(1900 + añoactual.getYear())) {
                    numeroDias = 29;
                } else {
                    numeroDias = 28;
                }
                break;

        }

        return numeroDias;
    }

    public static boolean esBisiesto(int anio) {

        GregorianCalendar calendar = new GregorianCalendar();
        boolean esBisiesto = false;
        if (calendar.isLeapYear(anio)) {
            esBisiesto = true;
        }
        return esBisiesto;

    }

    ///// BORDADOS DE CAMISAS,CHAMARRA ETC
    void datostablahistorialordenescamisa(int i) 
    {

         double importepechoizquierdo = 0.0;
        double importepechoderecho = 0.0;
        double importemangaizquierda = 0.0;
        double importemangaderecha = 0.0;
        double importeespalda = 0.0;
        double importeotraubicacion = 0.0;
        double importeotraubicacion2 = 0.0;

        String costostring = "0";
        
        
        DefaultTableModel modelo2 = (DefaultTableModel) tabla.getModel();
        String[] datos = new String[65];
        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select codigo,fecha,cliente,cantidad,prenda,numero_venta,"
                  + "cantidad_pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo,"
                  + "cantidad_pecho_derecho,pecho_derecho_nombre,pecho_derecho,"
                  + "cantidad_manga_izquierda,manga_izquierda_nombre,manga_izquierda,"
                  + "cantidad_manga_derecha,manga_derecha_nombre,manga_derecha,"
                  + "cantidad_espalda,espalda_nombre,espalda,"
                  + "cantidad_otra_ubicacion,otra_ubicacion,otra_ubicacion_nombre,"
                  + "cantidad_otra_ubicacion2,otra_ubicacion2,otra_ubicacion2_nombre,"
                  + "aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2 from historial_ordenes_camisa where (estatus_orden = 'generada' or estatus_orden = 'realizada') and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString("fecha");
                datos[1] = rs.getString("cliente");
                String cliente = rs.getString("cliente");
                datos[2] = rs.getString("cantidad");
                datos[3] = rs.getString("prenda");
                cantidadpechoizquierdo = rs.getString("cantidad_pecho_izquierdo");
                datos[4] = rs.getString("pecho_izquierdo_nombre");
                datos[5] = rs.getString("pecho_izquierdo");
                cantidadpechoderecho = rs.getString("cantidad_pecho_derecho");
                datos[7] = rs.getString("pecho_derecho_nombre");
                datos[8] = rs.getString("pecho_derecho");
                cantidadmangaizquierda = rs.getString("cantidad_manga_izquierda");
                datos[10] = rs.getString("manga_izquierda_nombre");
                datos[11] = rs.getString("manga_izquierda");
                cantidadmangaderecha = rs.getString("cantidad_manga_derecha");
                datos[13] = rs.getString("manga_derecha_nombre");
                datos[14] = rs.getString("manga_derecha");
                cantidadespalda = rs.getString("cantidad_espalda");
                datos[16] = rs.getString("espalda_nombre");
                datos[17] = rs.getString("espalda");
                cantidadotraubicacion = rs.getString("cantidad_otra_ubicacion");
                datos[19] = rs.getString("otra_ubicacion_nombre");
                datos[20] = rs.getString("otra_ubicacion");
                cantidadotraubicacion2 = rs.getString("cantidad_otra_ubicacion2");
                datos[22] = rs.getString("otra_ubicacion2_nombre");
                datos[23] = rs.getString("otra_ubicacion2");
                datos[53] = rs.getString("aplicacion_pecho_izquierdo");
                datos[54] = rs.getString("aplicacion_pecho_derecho");
                datos[55] = rs.getString("aplicacion_manga_izquierda");
                datos[56] = rs.getString("aplicacion_manga_derecha");
                datos[60] = rs.getString("aplicacion_espalda");
               
                datos[63] = rs.getString("numero_venta");
                
                ///
                
                 // Object cantidadobject = tabla.getValueAt(i, 2);
            //Object cliente = tabla.getValueAt(i, 1);
            
            int cantidadpechoizquierdoint = Integer.parseInt(cantidadpechoizquierdo);
            int cantidadpechoderechoint = Integer.parseInt(cantidadpechoderecho);
            int cantidadmangaizquierdaint = Integer.parseInt(cantidadmangaizquierda);
            int cantidadmangaderechaint = Integer.parseInt(cantidadmangaderecha);
            int cantidadespaldaint = Integer.parseInt(cantidadespalda);
            int cantidadotraubicacionint = Integer.parseInt(cantidadotraubicacion);
            int cantidadotraubicacion2int = Integer.parseInt(cantidadotraubicacion2);
 
            
            

            //PECHO IZQUIERDO
            double costopuntadapechoizquierdo = 0.0;
            Object pechoizquierdoobject = rs.getString("pecho_izquierdo");
            String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoizquierdoobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql1);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next())
                {

                    costostring = rs2.getString("costo");
                    costopuntadapechoizquierdo = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadapechoizquierdostring = String.format("%.02f ", costopuntadapechoizquierdo);
            datos[6] = costopuntadapechoizquierdostring;
            importepechoizquierdo = cantidadpechoizquierdoint * costopuntadapechoizquierdo;

            //PECHO DERECHO
            double costopuntadapechoderecho = 0.0;
            Object pechoderechoobject = rs.getString("pecho_derecho");
            String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoderechoobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql2);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadapechoderecho = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadapechoderechostring = String.format("%.02f ", costopuntadapechoderecho);
            datos[9] = costopuntadapechoderechostring;
            importepechoderecho = cantidadpechoderechoint * costopuntadapechoderecho;

//MANGA IZQUIERDA
            double costopuntadamangaizquierda = 0.0;
            Object mangaizquierdaobject = rs.getString("manga_izquierda");
            String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaizquierdaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaizquierda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadamangaizquierda);
            datos[12] = costopuntadamangaizquierdastring;
            importemangaizquierda = cantidadmangaizquierdaint * costopuntadamangaizquierda;

//MANGA DERECHA
            double costopuntadamangaderecha = 0.0;
            Object mangaderechaobject = rs.getString("manga_derecha");
            String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaderechaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql4);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaderecha = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadamangaderechastring = String.format("%.02f ", costopuntadamangaderecha);
             datos[15] = costopuntadamangaderechastring;
            importemangaderecha = cantidadmangaderechaint * costopuntadamangaderecha;

            // ESPALDA
            double costopuntadaespalda = 0.0;
            Object espaldaobject = rs.getString("espalda");
            String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + espaldaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql5);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaespalda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadaespaldastring = String.format("%.02f ", costopuntadaespalda);
            datos[18] = costopuntadaespaldastring;
            importeespalda = cantidadespaldaint * costopuntadaespalda;

            /// otra ubicacion
            double costopuntadaotraubicacion = 0.0;
            Object otraubicacionobject = rs.getString("otra_ubicacion");

            String sql6 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacionobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql6);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaotraubicacion = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadaotraubicacionstring = String.format("%.02f ", costopuntadaotraubicacion);
            datos[21] = costopuntadaotraubicacionstring;

            importeotraubicacion = cantidadotraubicacionint * costopuntadaotraubicacion;

            /// otra ubicacion2
            double costopuntadaotraubicacion2 = 0.0;
            Object otraubicacion2object = datos[23] = rs.getString("otra_ubicacion2");

            String sql7 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacion2object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql7);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaotraubicacion2 = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadaotraubicacion2string = String.format("%.02f ", costopuntadaotraubicacion2);
            datos[24] = costopuntadaotraubicacion2string;
            importeotraubicacion2 = cantidadotraubicacionint * costopuntadaotraubicacion2;

            double sumabordados = importepechoizquierdo + importepechoderecho + importemangaizquierda + importemangaderecha + importeespalda + importeotraubicacion + importeotraubicacion2;
            String sumabordadosstring = String.format("%.02f ", sumabordados);
            if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
            datos[62] = sumabordadosstring;
                
                ///
                modelo2.addRow(datos);
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

       

    }

    void calcularcostosdebordadoscamisas() {

        double importepechoizquierdo = 0.0;
        double importepechoderecho = 0.0;
        double importemangaizquierda = 0.0;
        double importemangaderecha = 0.0;
        double importeespalda = 0.0;
        double importeotraubicacion = 0.0;
        double importeotraubicacion2 = 0.0;

        String costostring = "0";

        for (int i = 0; i < tabla.getRowCount(); i++) {
            
             Object cantidadobject = tabla.getValueAt(i, 2);
            Object cliente = tabla.getValueAt(i, 1);
            
            int cantidadpechoizquierdoint = Integer.parseInt(cantidadpechoizquierdo);
            int cantidadpechoderechoint = Integer.parseInt(cantidadpechoderecho);
            int cantidadmangaizquierdaint = Integer.parseInt(cantidadmangaizquierda);
            int cantidadmangaderechaint = Integer.parseInt(cantidadmangaderecha);
            int cantidadespaldaint = Integer.parseInt(cantidadespalda);
            int cantidadotraubicacionint = Integer.parseInt(cantidadotraubicacion);
            int cantidadotraubicacion2int = Integer.parseInt(cantidadotraubicacion2);
 
            
            

            //PECHO IZQUIERDO
            double costopuntadapechoizquierdo = 0.0;
            Object pechoizquierdoobject = tabla.getValueAt(i, 5);
            String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoizquierdoobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql1);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next())
                {

                    costostring = rs2.getString("costo");
                    costopuntadapechoizquierdo = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadapechoizquierdostring = String.format("%.02f ", costopuntadapechoizquierdo);
            tabla.setValueAt(costopuntadapechoizquierdostring, i, 6);
            importepechoizquierdo = cantidadpechoizquierdoint * costopuntadapechoizquierdo;

            //PECHO DERECHO
            double costopuntadapechoderecho = 0.0;
            Object pechoderechoobject = tabla.getValueAt(i, 8);
            String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoderechoobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql2);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadapechoderecho = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadapechoderechostring = String.format("%.02f ", costopuntadapechoderecho);
            tabla.setValueAt(costopuntadapechoderechostring, i, 9);
            importepechoderecho = cantidadpechoderechoint * costopuntadapechoderecho;

//MANGA IZQUIERDA
            double costopuntadamangaizquierda = 0.0;
            Object mangaizquierdaobject = tabla.getValueAt(i, 11);
            String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaizquierdaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaizquierda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadamangaizquierda);
            tabla.setValueAt(costopuntadamangaizquierdastring, i, 12);
            importemangaizquierda = cantidadmangaizquierdaint * costopuntadamangaizquierda;

//MANGA DERECHA
            double costopuntadamangaderecha = 0.0;
            Object mangaderechaobject = tabla.getValueAt(i, 14);
            String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaderechaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql4);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaderecha = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadamangaderechastring = String.format("%.02f ", costopuntadamangaderecha);
            tabla.setValueAt(costopuntadamangaderechastring, i, 15);
            importemangaderecha = cantidadmangaderechaint * costopuntadamangaderecha;

            // ESPALDA
            double costopuntadaespalda = 0.0;
            Object espaldaobject = tabla.getValueAt(i, 17);
            String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + espaldaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql5);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaespalda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadaespaldastring = String.format("%.02f ", costopuntadaespalda);
            tabla.setValueAt(costopuntadaespaldastring, i, 18);
            importeespalda = cantidadespaldaint * costopuntadaespalda;

            /// otra ubicacion
            double costopuntadaotraubicacion = 0.0;
            Object otraubicacionobject = tabla.getValueAt(i, 20);

            String sql6 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacionobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql6);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaotraubicacion = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadaotraubicacionstring = String.format("%.02f ", costopuntadaotraubicacion);
            tabla.setValueAt(costopuntadaotraubicacionstring, i, 21);

            importeotraubicacion = cantidadotraubicacionint * costopuntadaotraubicacion;

            /// otra ubicacion2
            double costopuntadaotraubicacion2 = 0.0;
            Object otraubicacion2object = tabla.getValueAt(i, 23);

            String sql7 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacion2object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql7);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs.getString("costo");
                    costopuntadaotraubicacion2 = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadaotraubicacion2string = String.format("%.02f ", costopuntadaotraubicacion2);
            tabla.setValueAt(costopuntadaotraubicacion2string, i, 24);

            importeotraubicacion2 = cantidadotraubicacionint * costopuntadaotraubicacion2;

            double sumabordados = importepechoizquierdo + importepechoderecho + importemangaizquierda + importemangaderecha + importeespalda + importeotraubicacion + importeotraubicacion2;
            String sumabordadosstring = String.format("%.02f ", sumabordados);
            if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
            tabla.setValueAt(sumabordadosstring, i, 62);

          

        }

    }

    void datostablahistorialordenescamisarecibidas(int i) 
    {

        double importepechoizquierdo = 0.0;
        double importepechoderecho = 0.0;
        double importemangaizquierda = 0.0;
        double importemangaderecha = 0.0;
        double importeespalda = 0.0;
        double importeotraubicacion = 0.0;
        double importeotraubicacion2 = 0.0;

        String costostring = "0";
        
        DefaultTableModel modelo2 = (DefaultTableModel) tabla.getModel();
        String[] datos = new String[65];

        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);
        

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select codigo,fecha,cliente,cantidad,prenda,pecho_izquierdo_nombre,pecho_izquierdo,pecho_derecho_nombre,pecho_derecho,manga_izquierda_nombre,manga_izquierda,manga_derecha_nombre,manga_derecha,espalda_nombre,espalda,aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,otra_ubicacion_nombre,otra_ubicacion,otra_ubicacion2_nombre,otra_ubicacion2 from historial_ordenes_camisa_recibidas where estatus_orden = 'generada' and fecha = '" + fechabusqueda + "'  order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString("fecha");
                datos[1] = rs.getString("cliente");
                datos[2] = rs.getString("cantidad");
                datos[3] = rs.getString("prenda");
                datos[4] = rs.getString("pecho_izquierdo_nombre");
                datos[5] = rs.getString("pecho_izquierdo");
                datos[7] = rs.getString("pecho_derecho_nombre");
                datos[8] = rs.getString("pecho_derecho");
                datos[10] = rs.getString("manga_izquierda_nombre");
                datos[11] = rs.getString("manga_izquierda");
                datos[13] = rs.getString("manga_derecha_nombre");
                datos[14] = rs.getString("manga_derecha");
                datos[16] = rs.getString("espalda_nombre");
                datos[17] = rs.getString("espalda");
                datos[19] = rs.getString("otra_ubicacion");
                datos[20] = rs.getString("otra_ubicacion_nombre");
                datos[22] = rs.getString("otra_ubicacion2");
                datos[23] = rs.getString("otra_ubicacion2_nombre");
                datos[53] = rs.getString("aplicacion_pecho_izquierdo");
                datos[54] = rs.getString("aplicacion_pecho_derecho");
                datos[55] = rs.getString("aplicacion_manga_izquierda");
                datos[56] = rs.getString("aplicacion_manga_derecha");
                datos[60] = rs.getString("aplicacion_espalda");
                
                  ///
                
             Object cantidadobject = rs.getString("cantidad");
            //Object cliente = tabla.getValueAt(i, 1);
            
            int cantidadpechoizquierdoint = Integer.parseInt(cantidadobject.toString());
            int cantidadpechoderechoint = Integer.parseInt(cantidadobject.toString());
            int cantidadmangaizquierdaint = Integer.parseInt(cantidadobject.toString());
            int cantidadmangaderechaint = Integer.parseInt(cantidadobject.toString());
            int cantidadespaldaint = Integer.parseInt(cantidadobject.toString());
            int cantidadotraubicacionint = Integer.parseInt(cantidadobject.toString());
            int cantidadotraubicacion2int = Integer.parseInt(cantidadobject.toString());
 
            
            

            //PECHO IZQUIERDO
            double costopuntadapechoizquierdo = 0.0;
            Object pechoizquierdoobject = rs.getString("pecho_izquierdo");
            String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoizquierdoobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql1);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next())
                {

                    costostring = rs2.getString("costo");
                    costopuntadapechoizquierdo = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadapechoizquierdostring = String.format("%.02f ", costopuntadapechoizquierdo);
            datos[6] = costopuntadapechoizquierdostring;
            importepechoizquierdo = cantidadpechoizquierdoint * costopuntadapechoizquierdo;

            //PECHO DERECHO
            double costopuntadapechoderecho = 0.0;
            Object pechoderechoobject = rs.getString("pecho_derecho");
            String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoderechoobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql2);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadapechoderecho = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadapechoderechostring = String.format("%.02f ", costopuntadapechoderecho);
            //tabla.setValueAt(costopuntadapechoderechostring, i, 9);
            datos[9] = costopuntadapechoderechostring;
            importepechoderecho = cantidadpechoderechoint * costopuntadapechoderecho;

//MANGA IZQUIERDA
            double costopuntadamangaizquierda = 0.0;
            Object mangaizquierdaobject = rs.getString("manga_izquierda");
            String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaizquierdaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaizquierda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadamangaizquierda);
           // tabla.setValueAt(costopuntadamangaizquierdastring, i, 12);
            datos[12] = costopuntadamangaizquierdastring;
            importemangaizquierda = cantidadmangaizquierdaint * costopuntadamangaizquierda;

//MANGA DERECHA
            double costopuntadamangaderecha = 0.0;
            Object mangaderechaobject = rs.getString("manga_derecha");
            String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaderechaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql4);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaderecha = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadamangaderechastring = String.format("%.02f ", costopuntadamangaderecha);
            //tabla.setValueAt(costopuntadamangaderechastring, i, 15);
             datos[15] = costopuntadamangaderechastring;
            importemangaderecha = cantidadmangaderechaint * costopuntadamangaderecha;

            // ESPALDA
            double costopuntadaespalda = 0.0;
            Object espaldaobject = rs.getString("espalda");
            String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + espaldaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql5);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaespalda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadaespaldastring = String.format("%.02f ", costopuntadaespalda);
            //tabla.setValueAt(costopuntadaespaldastring, i, 18);
            datos[18] = costopuntadaespaldastring;
            importeespalda = cantidadespaldaint * costopuntadaespalda;

            /// otra ubicacion
            double costopuntadaotraubicacion = 0.0;
            Object otraubicacionobject = rs.getString("otra_ubicacion");

            String sql6 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacionobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql6);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaotraubicacion = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadaotraubicacionstring = String.format("%.02f ", costopuntadaotraubicacion);
            //tabla.setValueAt(costopuntadaotraubicacionstring, i, 21);
            datos[21] = costopuntadaotraubicacionstring;

            importeotraubicacion = cantidadotraubicacionint * costopuntadaotraubicacion;

            /// otra ubicacion2
            double costopuntadaotraubicacion2 = 0.0;
            Object otraubicacion2object = datos[23] = rs.getString("otra_ubicacion2");

            String sql7 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacion2object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql7);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs.getString("costo");
                    costopuntadaotraubicacion2 = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            String costopuntadaotraubicacion2string = String.format("%.02f ", costopuntadaotraubicacion2);
            datos[24] = costopuntadaotraubicacion2string;
            //tabla.setValueAt(costopuntadaotraubicacion2string, i, 24);

            importeotraubicacion2 = cantidadotraubicacionint * costopuntadaotraubicacion2;

            double sumabordados = importepechoizquierdo + importepechoderecho + importemangaizquierda + importemangaderecha + importeespalda + importeotraubicacion + importeotraubicacion2;
            String sumabordadosstring = String.format("%.02f ", sumabordados);
            if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
            datos[62] = sumabordadosstring;
                
                ///
                

                modelo2.addRow(datos);
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        

    }


    void calcularcostosdebordadospantalon() {

        double importeladoizquierdofrente = 0.0;
        double importeladoizquierdoatras = 0.0;
        double importeladoderechofrente = 0.0;
        double importeladoderechoatras = 0.0;

        String costostring = "0";
        
        
      int cantidadladoizquierdofrenteint=Integer.parseInt(cantidadladoizquierdofrente);   
      int cantidadladoderechofrenteint=Integer.parseInt(cantidadladoderechofrente);
      int cantidadladoizquierdoatrasint=Integer.parseInt(cantidadladoizquierdoatras);
      int cantidadladoderechoatrasint=Integer.parseInt(cantidadladoderechoatras);

        for (int i = 0; i < tabla.getRowCount(); i++) {

            Object cantidadobject = tabla.getValueAt(i, 2);
            Object prenda = tabla.getValueAt(i, 3);
            //int cantidad = Integer.parseInt(cantidadobject.toString());

            if (prenda.equals("Pantalon")) {

//lado IZQUIERDO
                double costopuntadaladoizquierdofrente = 0.0;
                Object ladoizquierdoobject = tabla.getValueAt(i, 39);
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoizquierdofrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaladoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdofrente);
                tabla.setValueAt(costopuntadaladoizquierdostring, i, 40);

                importeladoizquierdofrente = cantidadladoizquierdofrenteint * costopuntadaladoizquierdofrente;

                //LADO DERECHO
                double costopuntadaladoderechofrente = 0.0;
                Object ladoderechoobject = tabla.getValueAt(i, 42);

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoderechofrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaladoderechostring = String.format("%.02f ", costopuntadaladoderechofrente);
                tabla.setValueAt(costopuntadaladoderechostring, i, 43);

                importeladoderechofrente = cantidadladoderechofrenteint * costopuntadaladoderechofrente;

// ldo izquierdo atras
                double costopuntadaladoizquierdoatras = 0.0;

                Object ladoizquierdoatrasobject = tabla.getValueAt(i, 45);

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoatrasobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoizquierdoatras = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadaladoizquierdoatras);
                tabla.setValueAt(costopuntadamangaizquierdastring, i, 46);

                importeladoizquierdoatras = cantidadladoizquierdoatrasint * costopuntadaladoizquierdoatras;

                // lado derecho ATRAS
                double costopuntadaladoderechoatras = 0.0;

                Object ladoderechoatrasobject = tabla.getValueAt(i, 48);

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoatrasobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoderechoatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaespaldastring = String.format("%.02f ", costopuntadaladoderechoatras);
                tabla.setValueAt(costopuntadaespaldastring, i, 49);

                importeladoderechoatras = cantidadladoderechoatrasint * costopuntadaladoderechoatras;

                double sumabordados = importeladoizquierdoatras + importeladoizquierdofrente + importeladoderechoatras + importeladoderechofrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring, i, 62);

            }

        }

    }
    /////

    void datosponchados(int i) {

        DefaultTableModel modelo2 = (DefaultTableModel) tabla.getModel();
        String[] datos = new String[65];
        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select numero,fecha,cliente,articulo,cantidad,numero_venta,cantidad_ponchado from historial_ordenes_ponchados where (estatus_orden = 'generada' or estatus_orden= 'realizada' ) and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cantidadponchado=rs.getString("cantidad_ponchado");
                datos[0] = rs.getString("fecha");
                datos[1] = rs.getString("cliente");
                datos[2] = rs.getString("cantidad");
                Object cantidadobject = rs.getString("cantidad");
                datos[3] = rs.getString("articulo");
                Object articulo = rs.getString("articulo");
                datos[63] = rs.getString("numero_venta");
                
                ///
                
                double importedelponchado = 0.0;
                String costostring = "0";

            
            
            //int cantidad = Integer.parseInt(cantidadobject.toString());
            String articulobuscar = "";
            int cantidadponchadoint  =Integer.parseInt(cantidadponchado);
            

            if (articulo.toString().startsWith("PONCHADO")||articulo.toString().startsWith("MODIFICACION DE PONCHADO")) {

                if (articulo.toString().startsWith("PONCHADO FACIL")||articulo.toString().contains("MODIFICACION DE PONCHADO FACIL")) 
                {
                    articulobuscar = "PONCHADO FACIL";
                } else if (articulo.toString().startsWith("PONCHADO MEDIO")||articulo.toString().contains("MODIFICACION DE PONCHADO MEDIO")) {
                    articulobuscar = "PONCHADO MEDIO";
                } else if (articulo.toString().startsWith("PONCHADO DIFICIL")||articulo.toString().contains("MODIFICACION DE PONCHADO DIFICIL")) {
                    articulobuscar = "PONCHADO DIFICIL";
                }
                else if (articulo.toString().startsWith("PONCHADO EXTRA DIFICIL")||articulo.toString().contains("MODIFICACION DE PONCHADO EXTRA DIFICIL")) {
                        articulobuscar = "PONCHADO EXTRA DIFICIL";
                    }

                datos[5] =articulobuscar;

                double costodelponchado = 0.0;

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + articulobuscar + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costodelponchado = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaponchadostring = String.format("%.02f ", costodelponchado);
        
                datos[6] =costopuntadaponchadostring;

                double importeponchado = cantidadponchadoint * costodelponchado;

                double sumabordados = importeponchado;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                datos[62] =sumabordadosstring;

            }
                
                
               /// 
                modelo2.addRow(datos);
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        //calcularcostoponchados();gfgdfg

    }

    
     void datosponchadosmodificados(int i) {

        DefaultTableModel modelo2 = (DefaultTableModel) tabla.getModel();
        String[] datos = new String[65];
        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select numero,fecha,nombre_cliente,articulo,cantidad,numero  from HISTORIAL_VENTAS where estatus_pago not like ('%cancelada%') and fecha = '" + fechabusqueda + "' AND ARTICULO LIKE '%MODIFICACION DE PONCHADO%'   order by numero ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString("fecha");
                datos[1] = rs.getString("nombre_cliente");
                datos[2] = rs.getString("cantidad");
                 Object cantidadobject = rs.getString("cantidad");
                datos[3] = rs.getString("articulo");
                Object articulo = rs.getString("articulo");
                datos[63] = rs.getString("numero");
                
                //
                
                double importedelponchado = 0.0;
                String costostring = "0";

            
            
            //int cantidad = Integer.parseInt(cantidadobject.toString());
            String articulobuscar = "";
            int cantidadponchadoint  =Integer.parseInt(cantidadponchado);
            

            if (articulo.toString().startsWith("PONCHADO")||articulo.toString().startsWith("MODIFICACION DE PONCHADO")) {

                if (articulo.toString().startsWith("PONCHADO FACIL")||articulo.toString().contains("MODIFICACION DE PONCHADO FACIL")) 
                {
                    articulobuscar = "PONCHADO FACIL";
                } else if (articulo.toString().startsWith("PONCHADO MEDIO")||articulo.toString().contains("MODIFICACION DE PONCHADO MEDIO")) {
                    articulobuscar = "PONCHADO MEDIO";
                } else if (articulo.toString().startsWith("PONCHADO DIFICIL")||articulo.toString().contains("MODIFICACION DE PONCHADO DIFICIL")) {
                    articulobuscar = "PONCHADO DIFICIL";
                }
                else if (articulo.toString().startsWith("PONCHADO EXTRA DIFICIL")||articulo.toString().contains("MODIFICACION DE PONCHADO EXTRA DIFICIL")) {
                        articulobuscar = "PONCHADO EXTRA DIFICIL";
                    }

                datos[5] =articulobuscar;

                double costodelponchado = 0.0;

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + articulobuscar + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costodelponchado = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaponchadostring = String.format("%.02f ", costodelponchado);
        
                datos[6] =costopuntadaponchadostring;

                double importeponchado = cantidadponchadoint * costodelponchado;

                double sumabordados = importeponchado;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                datos[62] =sumabordadosstring;

            }
                
                //
                modelo2.addRow(datos);
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        

    }
    
    ////////////////////////////
    //////////////////
    //////////        
    void calcularcostoponchados() {

        double importedelponchado = 0.0;
        String costostring = "0";

        for (int i = 0; i < tabla.getRowCount(); i++) {

            Object cantidadobject = tabla.getValueAt(i, 2);
            Object articulo = tabla.getValueAt(i, 3);
            //int cantidad = Integer.parseInt(cantidadobject.toString());
            String articulobuscar = "";
            int cantidadponchadoint  =Integer.parseInt(cantidadponchado);
            

            if (articulo.toString().startsWith("PONCHADO")||articulo.toString().startsWith("MODIFICACION DE PONCHADO")) {

                if (articulo.toString().startsWith("PONCHADO FACIL")||articulo.toString().contains("MODIFICACION DE PONCHADO FACIL")) 
                {
                    articulobuscar = "PONCHADO FACIL";
                } else if (articulo.toString().startsWith("PONCHADO MEDIO")||articulo.toString().contains("MODIFICACION DE PONCHADO MEDIO")) {
                    articulobuscar = "PONCHADO MEDIO";
                } else if (articulo.toString().startsWith("PONCHADO DIFICIL")||articulo.toString().contains("MODIFICACION DE PONCHADO DIFICIL")) {
                    articulobuscar = "PONCHADO DIFICIL";
                }
                else if (articulo.toString().startsWith("PONCHADO EXTRA DIFICIL")||articulo.toString().contains("MODIFICACION DE PONCHADO EXTRA DIFICIL")) {
                        articulobuscar = "PONCHADO EXTRA DIFICIL";
                    }

                tabla.setValueAt(articulobuscar, i, 5);

                double costodelponchado = 0.0;

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + articulobuscar + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costodelponchado = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaponchadostring = String.format("%.02f ", costodelponchado);
                tabla.setValueAt(costopuntadaponchadostring, i, 6);

                double importeponchado = cantidadponchadoint * costodelponchado;

                double sumabordados = importeponchado;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring, i, 62);

            }

        }

    }

    void calcularcostosdebordadosgorra() {

        double importeladoizquierdo = 0.0;
        double importeladoderecho = 0.0;
        double importefrente = 0.0;
        double importeatras = 0.0;

        String costostring = "0";

        int cantidadfrenteint = Integer.parseInt(cantidadfrente);
        int cantidadladoderechoint = Integer.parseInt(cantidadladoderecho);
        int cantidadladoizquierdoint = Integer.parseInt(cantidadladoizquierdo);
        int cantidadatrasint = Integer.parseInt(cantidadatras);
        
        
        for (int i = 0; i < tabla.getRowCount(); i++) {

            Object cantidadobject = tabla.getValueAt(i, 2);
            Object prenda = tabla.getValueAt(i, 3);
            int cantidad = Integer.parseInt(cantidadobject.toString());

            if (prenda.equals("Gorra") ) {
                //lado IZQUIERDO

                double costopuntadaladoizquierdo = 0.0;
                Object ladoizquierdoobject = tabla.getValueAt(i, 29);
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoizquierdo = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaladoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdo);
                tabla.setValueAt(costopuntadaladoizquierdostring, i, 30);

                importeladoizquierdo = cantidadladoizquierdoint * costopuntadaladoizquierdo;

                //LADO DERECHO
                double costopuntadaladoderecho = 0.0;
                Object ladoderechoobject = tabla.getValueAt(i, 32);

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoderecho = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaladoderechostring = String.format("%.02f ", costopuntadaladoderecho);
                tabla.setValueAt(costopuntadaladoderechostring, i, 33);

                importeladoderecho = cantidadladoderechoint * costopuntadaladoderecho;

// FRENTE
                double costopuntadafrente = 0.0;

                Object frenteobject = tabla.getValueAt(i, 26);

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
                tabla.setValueAt(costopuntadafrentestring, i, 27);

                importefrente = cantidadfrenteint * costopuntadafrente;

                // ATRAS
                double costopuntadaatras = 0.0;

                Object atrasobject = tabla.getValueAt(i, 35);

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + atrasobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaespaldastring = String.format("%.02f ", costopuntadaatras);
                tabla.setValueAt(costopuntadaespaldastring, i, 36);

                importeatras = cantidadatrasint * costopuntadaatras;

                double sumabordados = importeladoizquierdo + importeladoderecho + importefrente + importeatras;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring, i, 62);

            }

        }

    }

    void calcularcostosdebordadosportanombre() {

        double importefrente = 0.0;
        String costostring = "0";

        for (int i = 0; i < tabla.getRowCount(); i++) {

            Object cantidadobject = tabla.getValueAt(i, 2);
            Object cliente = tabla.getValueAt(i, 1);
            int cantidad = Integer.parseInt(cantidadobject.toString());

            if (cliente.equals("porta nombre multiple") || cliente.equals("porta nombre")) {

                // FRENTE
                double costopuntadafrente = 0.0;
                Object frenteobject = tabla.getValueAt(i, 26);

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
                tabla.setValueAt(costopuntadafrentestring, i, 27);
                importefrente = cantidad * costopuntadafrente;

                double sumabordados = importefrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring, i, 62);

            }

        }

    }

    void calcularcostosdebordadoscorbata() {

        double importeladoizquierdo = 0.0;
        double importeladoderecho = 0.0;
        double importefrente = 0.0;
        double importeatras = 0.0;

        String costostring = "0";

        for (int i = 0; i < tabla.getRowCount(); i++) {

            Object cantidadobject = tabla.getValueAt(i, 2);
            Object prenda = tabla.getValueAt(i, 3);
            int cantidad = Integer.parseInt(cantidadobject.toString());

            if (prenda.equals("Corbata")) {

                // FRENTE
                double costopuntadafrente = 0.0;

                Object frenteobject = tabla.getValueAt(i, 26);

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadafrente);
                tabla.setValueAt(costopuntadamangaizquierdastring, i, 27);

                importefrente = cantidad * costopuntadafrente;
                double sumabordados = importefrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring, i, 62);

            }

        }

    }

    void calcularcostosdebordadosparches() {

        double importebordado = 0.0;

        String costostring = "0";
        String costodelapuntada = "";

        for (int i = 0; i < tabla.getRowCount(); i++) {

            Object cantidadobject = tabla.getValueAt(i, 2);
            Object prenda = tabla.getValueAt(i, 3);
            //int cantidad = Integer.parseInt(cantidadobject.toString());
            int cantidadparcheint = Integer.parseInt(cantidadparche);

            if (prenda.equals("Parche")) {

                double costopuntada = 0.0;
                Object puntadaobject = tabla.getValueAt(i, 51);
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadaobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntada = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                double sumabordados = costopuntada * cantidadparcheint;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                tabla.setValueAt(costostring, i, 52);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring, i, 62);

            }

        }

    }

    //// BORDADOS DE GORRA      
    void datostablahistorialordenesgorra(int i) 
    {
        
        double importeladoizquierdo = 0.0;
        double importeladoderecho = 0.0;
        double importefrente = 0.0;
        double importeatras = 0.0;

        String costostring = "0";

      
        

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;

        if (messtring.equals("Diciembre")) {
            mesint = 12;
        } else {
            mesint = (cal.get(Calendar.MONTH) + 1);
        }

        if (mesint > mesfinal) {

            mesint = mesfinal;
        }

        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select fecha,cliente,cantidad,prenda,frente,puntadas_frente,cantidad_frente,lado_izquierdo,puntadas_lado_izquierdo,cantidad_lado_izquierdo,lado_derecho,puntadas_lado_derecho,cantidad_lado_derecho,atras,puntadas_atras,cantidad_atras,aplicacion_frente,numero_venta from historial_ordenes_gorra where (estatus_orden = 'generada' OR estatus_orden = 'realizada' ) and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

        int ultimafila = 0;

        ultimafila = tabla.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad");
                String prenda = rs.getString("prenda");
                String frente = rs.getString("frente");
                String puntadasfrente = rs.getString("puntadas_frente");
                cantidadfrente = rs.getString("cantidad_frente");
                String ladoizquierdo = rs.getString("lado_izquierdo");
                String puntadasladoizquierdo = rs.getString("puntadas_lado_izquierdo");
                cantidadladoizquierdo = rs.getString("cantidad_lado_izquierdo");
                String ladoderecho = rs.getString("lado_derecho");
                String puntadasladoderecho = rs.getString("puntadas_lado_derecho");
                cantidadladoderecho = rs.getString("cantidad_lado_derecho");
                String atras = rs.getString("atras");
                String puntadasatras = rs.getString("puntadas_atras");
                cantidadatras = rs.getString("cantidad_atras");
                String aplicacionfrente = rs.getString("aplicacion_frente");
                String numeroventa = rs.getString("numero_venta");

                modelo.addRow(new Object[]{});

                tabla.setValueAt(fecha, ultimafila, 0);
                tabla.setValueAt(cliente, ultimafila, 1);
                tabla.setValueAt(cantidad, ultimafila, 2);
                tabla.setValueAt(prenda, ultimafila, 3);
                tabla.setValueAt(frente, ultimafila, 25);
                tabla.setValueAt(puntadasfrente, ultimafila, 26);
                tabla.setValueAt(ladoizquierdo, ultimafila, 28);
                tabla.setValueAt(puntadasladoizquierdo, ultimafila, 29);
                tabla.setValueAt(ladoderecho, ultimafila, 31);
                tabla.setValueAt(puntadasladoderecho, ultimafila, 32);
                tabla.setValueAt(atras, ultimafila, 34);
                tabla.setValueAt(puntadasatras, ultimafila, 35);
                tabla.setValueAt(aplicacionfrente, ultimafila, 57);
                tabla.setValueAt(numeroventa, ultimafila, 63);
                
                
     
                ///Calculo 
                        
                int cantidadfrenteint = Integer.parseInt(cantidadfrente);
                int cantidadladoderechoint = Integer.parseInt(cantidadladoderecho);
                int cantidadladoizquierdoint = Integer.parseInt(cantidadladoizquierdo);
                int cantidadatrasint = Integer.parseInt(cantidadatras);

                int cantidadint = Integer.parseInt(cantidad.toString());

                double costopuntadaladoizquierdo = 0.0;
                Object ladoizquierdoobject = rs.getString("puntadas_lado_izquierdo");
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoizquierdo = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaladoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdo);
                tabla.setValueAt(costopuntadaladoizquierdostring, ultimafila, 30);

                importeladoizquierdo = cantidadladoizquierdoint * costopuntadaladoizquierdo;

                //LADO DERECHO
                double costopuntadaladoderecho = 0.0;
                Object ladoderechoobject = rs.getString("puntadas_lado_derecho");

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoderecho = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaladoderechostring = String.format("%.02f ", costopuntadaladoderecho);
                tabla.setValueAt(costopuntadaladoderechostring, ultimafila, 33);

                importeladoderecho = cantidadladoderechoint * costopuntadaladoderecho;

// FRENTE
                double costopuntadafrente = 0.0;

                Object frenteobject = rs.getString("puntadas_frente");

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
                tabla.setValueAt(costopuntadafrentestring, ultimafila, 27);
                importefrente = cantidadfrenteint * costopuntadafrente;

                // ATRAS
                double costopuntadaatras = 0.0;

                Object atrasobject = rs.getString("puntadas_atras");

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + atrasobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaespaldastring = String.format("%.02f ", costopuntadaatras);
                tabla.setValueAt(costopuntadaespaldastring, ultimafila, 36);

                importeatras = cantidadatrasint * costopuntadaatras;

                double sumabordados = importeladoizquierdo + importeladoderecho + importefrente + importeatras;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring, ultimafila, 62);

                        
                        
                ///        
                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println();
        }

    }

    void datostablahistorialordenesgorrarecibidas(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select fecha,cliente,cantidad,prenda,frente,puntadas_frente,lado_izquierdo,puntadas_lado_izquierdo,lado_derecho,puntadas_lado_derecho,atras,puntadas_atras,aplicacion_frente from historial_ordenes_gorra_recibidas where (estatus_orden = 'generada' OR estatus_orden = 'realizada' ) and fecha = '" + fechabusqueda + "'  order by codigo ";

        int ultimafila = 0;

        ultimafila = tabla.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad");
                String prenda = rs.getString("prenda");
                String frente = rs.getString("frente");
                String puntadasfrente = rs.getString("puntadas_frente");
                String ladoizquierdo = rs.getString("lado_izquierdo");
                String puntadasladoizquierdo = rs.getString("puntadas_lado_izquierdo");
                String ladoderecho = rs.getString("lado_derecho");
                String puntadasladoderecho = rs.getString("puntadas_lado_derecho");
                String atras = rs.getString("atras");
                String puntadasatras = rs.getString("puntadas_atras");
                String aplicacionfrente = rs.getString("aplicacion_frente");

                modelo.addRow(new Object[]{});

                tabla.setValueAt(fecha, ultimafila, 0);
                tabla.setValueAt(cliente, ultimafila, 1);
                tabla.setValueAt(cantidad, ultimafila, 2);
                tabla.setValueAt(prenda, ultimafila, 3);
                tabla.setValueAt(frente, ultimafila, 25);
                tabla.setValueAt(puntadasfrente, ultimafila, 26);
                tabla.setValueAt(ladoizquierdo, ultimafila, 28);
                tabla.setValueAt(puntadasladoizquierdo, ultimafila, 29);
                tabla.setValueAt(ladoderecho, ultimafila, 31);
                tabla.setValueAt(puntadasladoderecho, ultimafila, 32);
                tabla.setValueAt(atras, ultimafila, 34);
                tabla.setValueAt(puntadasatras, ultimafila, 35);
                tabla.setValueAt(aplicacionfrente, ultimafila, 57);
                
                ///
                ///Calculo v
                     
                String costostring = "";
                double importeladoizquierdo = 0.0;
                double importeladoderecho = 0.0;
                double importefrente = 0.0;
                double importeatras = 0.0;
                
                int cantidadfrenteint = Integer.parseInt(cantidad);
                int cantidadladoderechoint = Integer.parseInt(cantidad);
                int cantidadladoizquierdoint = Integer.parseInt(cantidad);
                int cantidadatrasint = Integer.parseInt(cantidad);

                int cantidadint = Integer.parseInt(cantidad.toString());

                double costopuntadaladoizquierdo = 0.0;
                Object ladoizquierdoobject = rs.getString("puntadas_lado_izquierdo");
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoizquierdo = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaladoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdo);
                tabla.setValueAt(costopuntadaladoizquierdostring, ultimafila, 30);

                importeladoizquierdo = cantidadladoizquierdoint * costopuntadaladoizquierdo;

                //LADO DERECHO
                double costopuntadaladoderecho = 0.0;
                Object ladoderechoobject = rs.getString("puntadas_lado_derecho");

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoderecho = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaladoderechostring = String.format("%.02f ", costopuntadaladoderecho);
                tabla.setValueAt(costopuntadaladoderechostring, ultimafila, 33);

                importeladoderecho = cantidadladoderechoint * costopuntadaladoderecho;

// FRENTE
                double costopuntadafrente = 0.0;

                Object frenteobject = rs.getString("puntadas_frente");

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
                tabla.setValueAt(costopuntadafrentestring, ultimafila, 27);
                importefrente = cantidadfrenteint * costopuntadafrente;

                // ATRAS
                double costopuntadaatras = 0.0;

                Object atrasobject = rs.getString("puntadas_atras");

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + atrasobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaespaldastring = String.format("%.02f ", costopuntadaatras);
                tabla.setValueAt(costopuntadaespaldastring, ultimafila, 36);

                importeatras = cantidadatrasint * costopuntadaatras;

                double sumabordados = importeladoizquierdo + importeladoderecho + importefrente + importeatras;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring, ultimafila, 62);

                        
                        
                ///        

                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        

    }

    void datostablahistorialordenespantalon(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select fecha,cliente,cantidad,prenda,cantidad_lado_izquierdo_frente,lado_izquierdo_frente,lado_izquierdo_frente_puntadas,"
                + "cantidad_lado_derecho_frente,lado_derecho_frente,lado_derecho_frente_puntadas,"
                + "cantidad_lado_izquierdo_atras,lado_izquierdo_atras,lado_izquierdo_atras_puntadas,"
                + "cantidad_lado_derecho_atras,lado_derecho_atras,lado_derecho_atras_puntadas,numero_venta from historial_ordenes_pantalon where (estatus_orden = 'generada' OR estatus_orden = 'realizada' ) and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

        int ultimafila = 0;

        ultimafila = tabla.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad");
                String prenda = rs.getString("prenda");

  
    
                
                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente");
                String puntadasladoizquierdofrente = rs.getString("lado_izquierdo_frente_puntadas");
                cantidadladoizquierdofrente= rs.getString("cantidad_lado_izquierdo_frente");
                
                
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras");
                String puntadasladoizquierdoatras = rs.getString("lado_izquierdo_atras_puntadas");
                cantidadladoizquierdoatras= rs.getString("cantidad_lado_izquierdo_atras");

                String ladoderechofrente = rs.getString("lado_derecho_frente");
                String puntadasladoderechofrente = rs.getString("lado_derecho_frente_puntadas");
                cantidadladoderechofrente= rs.getString("cantidad_lado_derecho_frente");
                
                String ladoderechoatras = rs.getString("lado_derecho_atras");
                String puntadasladoderechoatras = rs.getString("lado_derecho_atras_puntadas");
                cantidadladoderechoatras= rs.getString("cantidad_lado_derecho_atras");
                
                String numeroventa = rs.getString("numero_venta");

                modelo.addRow(new Object[]{});

                tabla.setValueAt(fecha, ultimafila, 0);
                tabla.setValueAt(cliente, ultimafila, 1);
                tabla.setValueAt(cantidad, ultimafila, 2);
                tabla.setValueAt(prenda, ultimafila, 3);

                tabla.setValueAt(ladoizquierdofrente, ultimafila, 38);
                tabla.setValueAt(puntadasladoizquierdofrente, ultimafila, 39);
                tabla.setValueAt(ladoderechofrente, ultimafila, 41);
                tabla.setValueAt(puntadasladoderechofrente, ultimafila, 42);

                tabla.setValueAt(ladoizquierdoatras, ultimafila, 44);
                tabla.setValueAt(puntadasladoizquierdoatras, ultimafila, 45);
                tabla.setValueAt(ladoderechoatras, ultimafila, 47);
                tabla.setValueAt(puntadasladoderechoatras, ultimafila, 48);

                tabla.setValueAt(numeroventa, ultimafila, 63);
                
                double importeladoizquierdofrente = 0.0;
                double importeladoizquierdoatras = 0.0;
                double importeladoderechofrente = 0.0;
                double importeladoderechoatras = 0.0;

                String costostring = "0";

                int cantidadladoizquierdofrenteint = Integer.parseInt(cantidadladoizquierdofrente);
                int cantidadladoderechofrenteint = Integer.parseInt(cantidadladoderechofrente);
                int cantidadladoizquierdoatrasint = Integer.parseInt(cantidadladoizquierdoatras);
                int cantidadladoderechoatrasint = Integer.parseInt(cantidadladoderechoatras);


//lado IZQUIERDO
                double costopuntadaladoizquierdofrente = 0.0;
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadasladoizquierdofrente + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoizquierdofrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaladoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdofrente);
                tabla.setValueAt(costopuntadaladoizquierdostring, ultimafila, 40);
                importeladoizquierdofrente = cantidadladoizquierdofrenteint * costopuntadaladoizquierdofrente;

                //LADO DERECHO
                double costopuntadaladoderechofrente = 0.0;
                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '"+puntadasladoderechofrente+"'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoderechofrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaladoderechostring = String.format("%.02f ", costopuntadaladoderechofrente);
                tabla.setValueAt(costopuntadaladoderechostring, ultimafila, 43);
                importeladoderechofrente = cantidadladoderechofrenteint * costopuntadaladoderechofrente;

// ldo izquierdo atras
                double costopuntadaladoizquierdoatras = 0.0;
                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '"+puntadasladoizquierdoatras+"'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoizquierdoatras = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadaladoizquierdoatras);
                tabla.setValueAt(costopuntadamangaizquierdastring, ultimafila, 46);
                importeladoizquierdoatras = cantidadladoizquierdoatrasint * costopuntadaladoizquierdoatras;

                // lado derecho ATRAS
                double costopuntadaladoderechoatras = 0.0;
                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '"+puntadasladoderechoatras+"' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoderechoatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadaespaldastring = String.format("%.02f ", costopuntadaladoderechoatras);
                tabla.setValueAt(costopuntadaespaldastring, ultimafila, 49);
                importeladoderechoatras = cantidadladoderechoatrasint * costopuntadaladoderechoatras;

                double sumabordados = importeladoizquierdoatras + importeladoizquierdofrente + importeladoderechoatras + importeladoderechofrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring, ultimafila, 62);

                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        

    }

    void datostablahistorialordenespantalonrecibidos(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select fecha,cliente,cantidad,prenda,lado_izquierdo_frente,lado_izquierdo_frente_puntadas,lado_derecho_frente,lado_derecho_frente_puntadas,lado_izquierdo_atras,lado_izquierdo_atras_puntadas,lado_derecho_atras,lado_derecho_atras_puntadas from historial_ordenes_pantalon_recibidas where (estatus_orden = 'generada' OR estatus_orden = 'realizada' )  and fecha = '" + fechabusqueda + "'  order by codigo ";

        int ultimafila = 0;

        ultimafila = tabla.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad");
                String prenda = rs.getString("prenda");

                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente");
                String puntadasladoizquierdofrente = rs.getString("lado_izquierdo_frente_puntadas");
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras");
                String puntadasladoizquierdoatras = rs.getString("lado_izquierdo_atras_puntadas");

                String ladoderechofrente = rs.getString("lado_derecho_frente");
                String puntadasladoderechofrente = rs.getString("lado_derecho_frente_puntadas");
                String ladoderechoatras = rs.getString("lado_derecho_atras");
                String puntadasladoderechoatras = rs.getString("lado_derecho_atras_puntadas");

                modelo.addRow(new Object[]{});

                tabla.setValueAt(fecha, ultimafila, 0);
                tabla.setValueAt(cliente, ultimafila, 1);
                tabla.setValueAt(cantidad, ultimafila, 2);
                tabla.setValueAt(prenda, ultimafila, 3);

                tabla.setValueAt(ladoizquierdofrente, ultimafila, 35);
                tabla.setValueAt(puntadasladoizquierdofrente, ultimafila, 39);
                tabla.setValueAt(ladoderechofrente, ultimafila, 41);
                tabla.setValueAt(puntadasladoderechofrente, ultimafila, 42);

                tabla.setValueAt(ladoizquierdoatras, ultimafila, 44);
                tabla.setValueAt(puntadasladoizquierdoatras, ultimafila, 45);
                tabla.setValueAt(ladoderechoatras, ultimafila, 47);
                tabla.setValueAt(puntadasladoderechoatras, ultimafila, 48);

                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        //calcularcostosdebordadospantalon();
    }

    ////////////////////// 
    /////PARCHES
    //////////////////////
    void datostablahistorialparches(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select fecha,cliente,cantidad,parche,articulo,puntadas,aplicacion,numero_venta,cantidad_parche from historial_ordenes_parche where (estatus_orden = 'generada' OR estatus_orden = 'realizada' ) and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

        int ultimafila = 0;

        ultimafila = tabla.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad");
                String prenda = "Parche";

                String parche = rs.getString("parche");
                String puntadas = rs.getString("puntadas");
                String aplicacion = rs.getString("aplicacion");

                String numeroventa = rs.getString("numero_venta");
                cantidadparche =rs.getString("cantidad_parche");

                modelo.addRow(new Object[]{});

                tabla.setValueAt(fecha, ultimafila, 0);
                tabla.setValueAt(cliente, ultimafila, 1);
                tabla.setValueAt(cantidad, ultimafila, 2);
                tabla.setValueAt(prenda, ultimafila, 3);
                tabla.setValueAt(parche, ultimafila, 50);
                tabla.setValueAt(puntadas, ultimafila, 51);
                tabla.setValueAt(numeroventa, ultimafila, 63);
                
                ///Costos
                
                double importebordado = 0.0;
                String costostring = "0";
                String costodelapuntada = "";
                double costopuntada = 0.0;

                int cantidadparcheint = Integer.parseInt(cantidadparche);

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '"+puntadas+"' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntada = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                double sumabordados = costopuntada * cantidadparcheint;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                tabla.setValueAt(costostring, ultimafila, 52);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring,ultimafila, 62);

                ///
                
                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

       

    }

    ////////////////////// 
    /////BORDDOS INTERNOS
    //////////////////////
    void datostablaordeninternagorra(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);
        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select fecha,cantidad_entregada,prenda,descripcion from historial_ordenes_bordados_interno where (estatus_entrega = 'entregada' or estatus_entrega = 'solicitada') AND fecha = '" + fechabusqueda + "'  AND prenda = 'Gorra' order by numero ";

        int ultimafila = 0;

        ultimafila = tabla.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) 
            {

                String fecha = rs.getString("fecha");
                String cliente = "Orden bordado interno gorra";
                String cantidad = rs.getString("cantidad_entregada");
                String prenda = rs.getString("prenda");
                String descripcion = rs.getString("descripcion");
                String frente = "";
                String puntadasfrente = "";

                if (descripcion.startsWith("\"SEGURIDAD\" ")) {
                    frente = "SEGURIDAD";
                    puntadasfrente = "BORDADO DE 5,000 A 7,500 PUNTADAS";
                } else if (descripcion.startsWith("\"SEGURIDAD PRIVADA\" ")) {
                    frente = "\"SEGURIDAD PRIVADA\" ";
                    puntadasfrente = "BORDADO DE 7,500 A 10,000 PUNTADAS";

                } else if (descripcion.startsWith("\"VIGILANCIA\" ")) {
                    frente = "\"VIGILANCIA\" ";
                    puntadasfrente = "BORDADO DE 7,500 A 10,000 PUNTADAS";

                }

                modelo.addRow(new Object[]{});

                tabla.setValueAt(fecha, ultimafila, 0);
                tabla.setValueAt(cliente, ultimafila, 1);
                tabla.setValueAt(cantidad, ultimafila, 2);
                tabla.setValueAt(prenda, ultimafila, 3);
                tabla.setValueAt(frente, ultimafila, 25);
                tabla.setValueAt(puntadasfrente, ultimafila, 26);
                

                double importefrente = 0.0;
                String costostring = "0";
                int cantidadfrenteint = Integer.parseInt(cantidad);
                double costopuntadafrente = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadasfrente + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
                tabla.setValueAt(costopuntadafrentestring, ultimafila, 27);

                importefrente = cantidadfrenteint * costopuntadafrente;

              

                double sumabordados =   importefrente ;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                tabla.setValueAt(sumabordadosstring, ultimafila, 62);

                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println();
        }

    }

    void datostablaordeninternaparche(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select fecha,cantidad_entregada,prenda,descripcion from historial_ordenes_bordados_interno where (estatus_entrega = 'entregada' or estatus_entrega = 'solicitada') AND fecha = '" + fechabusqueda + "'  AND prenda = 'Parche' order by numero ";

        int ultimafila = 0;

        ultimafila = tabla.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = "Orden bordado interno parche";
                String cantidad = rs.getString("cantidad_entregada");
                String prenda = rs.getString("prenda");
                String descripcion = rs.getString("descripcion");
                String frente = "";
                String puntadasfrente = "";

                if (descripcion.startsWith("PARCHE SEGURIDAD")) {
                    frente = "SEGURIDAD";
                    puntadasfrente = "BORDADO DE 5,000 A 7,500 PUNTADAS";
                }
                if (descripcion.startsWith("PARCHE VIGILANCIA")) {
                    frente = "VIGILANCIA";
                    puntadasfrente = "BORDADO DE 5,000 A 7,500 PUNTADAS";
                } else if (descripcion.startsWith("PARCHE SEGURIDAD PRIVADA")) {
                    frente = "SEGURIDAD PRIVADA";
                    puntadasfrente = "BORDADO DE 5,000 A 7,500 PUNTADAS";

                } else if (descripcion.startsWith("PARCHE BANDERA DE MEXICO")) {
                    frente = "PARCHE BANDERA DE MEXICO";
                    puntadasfrente = "BORDADO DE 12,500 A 15,000 PUNTADAS";

                }

                modelo.addRow(new Object[]{});

                tabla.setValueAt(fecha, ultimafila, 0);
                tabla.setValueAt(cliente, ultimafila, 1);
                tabla.setValueAt(cantidad, ultimafila, 2);
                tabla.setValueAt(prenda, ultimafila, 3);
                tabla.setValueAt(frente, ultimafila, 50);
                tabla.setValueAt(puntadasfrente, ultimafila, 51);

                /////Costos
                
                double importebordado = 0.0;
                String costostring = "0";
                String costodelapuntada = "";
                double costopuntada = 0.0;

                int cantidadparcheint = Integer.parseInt(cantidadparche);

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadasfrente + "' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs2.getString("costo");
                        costopuntada = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                double sumabordados = costopuntada * cantidadparcheint;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                tabla.setValueAt(costostring, ultimafila, 52);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring,ultimafila, 62);

                /////
                
                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println();
        }

        

    }

    void datostablaportanombre(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select fecha,cantidad,prenda,numero_venta from historial_ordenes_portanombres where fecha = '" + fechabusqueda + "' and estatus_orden not in ('cancelada')  order by numero ";

        int ultimafila = 0;

        ultimafila = tabla.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = "porta nombre";
                String cantidad = rs.getString("cantidad");
                String prenda = rs.getString("prenda");
                String frente = "PORTA NOMBRE";
                String puntadasfrente = "BORDADO DE MENOS DE 5,000 PUNTADAS";
                String numeroventa = rs.getString("numero_venta");

                modelo.addRow(new Object[]{});

                tabla.setValueAt(fecha, ultimafila, 0);
                tabla.setValueAt(cliente, ultimafila, 1);
                tabla.setValueAt(cantidad, ultimafila, 2);
                tabla.setValueAt(prenda, ultimafila, 3);
                tabla.setValueAt(frente, ultimafila, 25);
                tabla.setValueAt(puntadasfrente, ultimafila, 26);
                tabla.setValueAt(numeroventa, ultimafila, 63);
                
                ///
                

                ///
                
                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        calcularcostosdebordadosportanombre();

    }

    void datostablaportanombremultiple(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);

        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select fecha,cantidad_total,prenda,numero_venta from historial_ordenes_portanombres_multiple where estatus_orden not in ('cancelada') and fecha = '" + fechabusqueda + "'  order by numero ";

        int ultimafila = 0;

        ultimafila = tabla.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = "porta nombre multiple";
                String cantidad = rs.getString("cantidad_total");
                String prenda = rs.getString("prenda");
                String frente = "PORTA NOMBRE MULTIPLE";
                String puntadasfrente = "BORDADO DE MENOS DE 5,000 PUNTADAS";
                String numeroventa = rs.getString("numero_venta");;

                modelo.addRow(new Object[]{});

                tabla.setValueAt(fecha, ultimafila, 0);
                tabla.setValueAt(cliente, ultimafila, 1);
                tabla.setValueAt(cantidad, ultimafila, 2);
                tabla.setValueAt(prenda, ultimafila, 3);
                tabla.setValueAt(frente, ultimafila, 25);
                tabla.setValueAt(puntadasfrente, ultimafila, 26);
                tabla.setValueAt(numeroventa, ultimafila, 63);

                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        calcularcostosdebordadosportanombre();

    }

    ///// historiales corbata
    void datostablahistorialordenescorbata(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();

        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);
        int ultimafila = 0;
        String fechabusqueda = (+año + "-" + mesint + "-" + dia);

        String sql = "Select fecha,cliente,cantidad_frente,articulo,frente,frente_puntadas,numero_venta from historial_ordenes_corbata where (estatus_orden = 'generada' or estatus_orden = 'realizada') and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";
        ultimafila = tabla.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad_frente");
                String prenda = rs.getString("articulo");

                String frente = rs.getString("frente");
                String puntadasfrente = rs.getString("frente_puntadas");
                String numeroventa = rs.getString("numero_venta");

                modelo.addRow(new Object[]{});

                tabla.setValueAt(fecha, ultimafila, 0);
                tabla.setValueAt(cliente, ultimafila, 1);
                tabla.setValueAt(cantidad, ultimafila, 2);
                tabla.setValueAt(prenda, ultimafila, 3);
                tabla.setValueAt(frente, ultimafila, 25);
                tabla.setValueAt(puntadasfrente, ultimafila, 26);
                tabla.setValueAt(numeroventa, ultimafila, 63);
                
                ////Costos
                double importeladoizquierdo = 0.0;
                double importeladoderecho = 0.0;
                double importefrente = 0.0;
                double importeatras = 0.0;
                double costopuntadafrente = 0.0;
                String costostring = "0";
                int cantidadint = Integer.parseInt(cantidad);

                // FRENTE
                

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadasfrente + "' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadafrente);
                tabla.setValueAt(costopuntadamangaizquierdastring, ultimafila, 27);

                importefrente = cantidadint * costopuntadafrente;
                double sumabordados = importefrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabla.setValueAt(sumabordadosstring, ultimafila, 62);

                ///
                
                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        

    }
    //////

    void seleccionarfechas() {

        if (mesfinal == -1) 
        {

            Calendar cal = new GregorianCalendar();

            diafinal = (cal.get(Calendar.DAY_OF_MONTH));

            mesfinal = (cal.get(Calendar.MONTH) + 1);

            añofinal = cal.get(Calendar.YEAR);

        }
        else 
        {

            if (mesfinal == 0) {
                mesfinal = 12;
                añofinal = añofinal - 1;
            }

            if (mesfinal == 13) {
                mesfinal = 1;
                añofinal = añofinal + 1;
            }

            diafinal = diafinal = obtenerUltimoDiaMes(añofinal, mesfinal);

        }

        fechafinal = (+diafinal + "/" + mesfinal + "/" + añofinal);

        if (mesfinal == 1) {
            messtring = "Enero";
        }
        if (mesfinal == 2) {
            messtring = "Febrero";
        }
        if (mesfinal == 3) {
            messtring = "Marzo";
        }
        if (mesfinal == 4) {
            messtring = "Abril";
        }
        if (mesfinal == 5) {
            messtring = "Mayo";
        }
        if (mesfinal == 6) {
            messtring = "Junio";
        }
        if (mesfinal == 7) {
            messtring = "Julio";
        }
        if (mesfinal == 8) {
            messtring = "Agosto";
        }
        if (mesfinal == 9) {
            messtring = "Septiembre";
        }
        if (mesfinal == 10) {
            messtring = "Octubre";
        }
        if (mesfinal == 11) {
            messtring = "Noviembre";
        }
        if (mesfinal == 12) {
            messtring = "Diciembre";
        }

        lbmes.setText(messtring);

        String añofinalstring = String.valueOf(añofinal);
        lbaño.setText(añofinalstring);

        try {
            SimpleDateFormat sdfSource = new SimpleDateFormat("d/MM/yyyy");

            java.util.Date date = sdfSource.parse(fechafinal);

            SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/MM/dd");

            fechafinal = sdfDestination.format(date);

        } catch (Exception pe) {

        }

        fechainicial = ("01/" + mesfinal + "/" + añofinal);

        try {
            SimpleDateFormat sdfSource = new SimpleDateFormat("d/MM/yyyy");

            java.util.Date date2 = sdfSource.parse(fechainicial);

            SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/MM/dd");

            fechainicial = sdfDestination.format(date2);

        } catch (Exception pe) {

        }

        if (mesfinal == ultimomes && añofinal == ultimoaño) {
            btnsiguiente.setEnabled(false);
        }

    }

    public int obtenerUltimoDiaMes(int anio, int mes) {

        Calendar cal = new GregorianCalendar();

        cal.set(anio, mes - 1, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    }

    void topes() {

        if (mesfinal == -1) {

            Calendar cal = new GregorianCalendar();

            ultimomes = (cal.get(Calendar.MONTH) + 1);
            ultimoaño = cal.get(Calendar.YEAR);

        }

    }

    void limpiartabla() {

        try {
            DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
            int totalrenglones = tabla.getRowCount();

            for (int i = 0; totalrenglones > i; i++) {
                modelo.removeRow(0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla.");
        }

    }

    void limpiartablafechas() {

        try {
            DefaultTableModel modelo = (DefaultTableModel) tablafecha.getModel();
            int totalrenglones = tablafecha.getRowCount();

            for (int i = 0; totalrenglones > i; i++) {
                modelo.removeRow(0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al limpiar la tabla fecha.");
        }

    }

    void agregarfechasalatablafecha() 
    {

        DefaultTableModel modelotabla = (DefaultTableModel) tablafecha.getModel();
        String[] datos = new String[2];

        for (int i = 1; i <= diafinal; i++) {

            datos[0] = String.valueOf(i);
            datos[1] = "0.00";
            modelotabla.addRow(datos);

            if (i == 27 || i == 31) 
            {
                int a = 0;
            }

            calculodelassumasdelosbordados((int) i);

        }

        double sumadouble = 0.0;

        for (int i = 0; i < tablafecha.getRowCount(); i++) {

            String importepordiastring = tablafecha.getValueAt(i, 1).toString();
            double importepordiadouble = Double.parseDouble(importepordiastring);

            sumadouble = sumadouble + importepordiadouble;

        }

        lbsuma.setText(String.format("%.2f", sumadouble));

    }

    //////
    void calculodelassumasdelosbordados(int i) {

        String[] datos = new String[65];
        
        int mes = 0;

        String cantidadbordados = "";
        String pechoizquierdo = "";
        String pechoderecho = "";
        String mangaizquierda = "";
        String mangaderecha = "";
        String espalda = "";
        String otraubicacion = "";
        String otraubicacion2 = "";
        String aplicacionpechoizquierdo = "";
        String aplicacionpechoderecho = "";
        String aplicacionmangaizquierda = "";
        String aplicacionmangaderecha = "";
        String aplicacionespalda = "";

        double importepechoizquierdo = 0.0;
        double importepechoderecho = 0.0;
        double importemangaizquierda = 0.0;
        double importemangaderecha = 0.0;
        double importeespalda = 0.0;
        double importeotraubicacion = 0.0;
        double importeotraubicacion2 = 0.0;

        /////////////////////////////////
        /// recibidos
        
        String cantidadbordadosrecibidos = "";
        String pechoizquierdorecibidos = "";
        String pechoderechorecibidos = "";
        String mangaizquierdarecibidos = "";
        String mangaderecharecibidos = "";
        String espaldarecibidos = "";
        String otraubicacionrecibidos = "";
        String otraubicacion2recibidos = "";
        String aplicacionpechoizquierdorecibidos = "";
        String aplicacionpechoderechorecibidos = "";
        String aplicacionmangaizquierdarecibidos = "";
        String aplicacionmangaderecharecibidos = "";
        String aplicacionespaldarecibidos = "";

        double importepechoizquierdorecibidos = 0.0;
        double importepechoderechorecibidos = 0.0;
        double importemangaizquierdarecibidos = 0.0;
        double importemangaderecharecibidos = 0.0;
        double importeespaldarecibidos = 0.0;
        double importeotraubicacionrecibidos = 0.0;

        //////////////////////////////////
        ////GORRAS
        String cantidadbordadosgorra = "";
        String ladoizquierdogorra = "";
        String ladoderechogorra = "";
        String frentegorra = "";
        String atrasgorra = "";

        String aplicacionfrente = "";

        double importeladoizquierdogorra = 0.0;
        double importeladoderechogorra = 0.0;
        double importefrentegorra = 0.0;
        double importeatrasgorra = 0.0;
        double importeaplicaciongorra = 0.0;

        String cantidadbordadosgorrarecibidas = "";
        String ladoizquierdogorrarecibidas = "";
        String ladoderechogorrarecibidas = "";
        String frentegorrarecibidas = "";
        String atrasgorrarecibidas = "";

        String aplicacionfrenterecibidas = "";

        double importeladoizquierdogorrarecibidas = 0.0;
        double importeladoderechogorrarecibidas = 0.0;
        double importefrentegorrarecibidas = 0.0;
        double importeatrasgorrarecibidas = 0.0;
        double importeaplicaciongorrarecibida = 0.0;

        ////PANTALON
        String cantidadbordadospantalon = "";
        String ladoizquierdofrente = "";
        String ladoizquierdoatras = "";
        String ladoderechofrente = "";
        String ladoderechoatras = "";

        double importeladoizquierdofrente = 0.0;
        double importeladoizquierdoatras = 0.0;
        double importeladoderechofrente = 0.0;
        double importeladoderechoatras = 0.0;

        String cantidadbordadospantalonrecibidas = "";
        String ladoizquierdofrenterecibidas = "";
        String ladoizquierdoatrasrecibidas = "";
        String ladoderechofrenterecibidas = "";
        String ladoderechoatrasrecibidas = "";

        double importeladoizquierdofrenterecibidas = 0.0;
        double importeladoizquierdoatrasrecibidas = 0.0;
        double importeladoderechofrenterecibidas = 0.0;
        double importeladoderechoatrasrecibidas = 0.0;

        //// parches
        String cantidadbordadosparche = "";
        double importeparche = 0.0;

        String cantidadparchesrecibidas = "";
        double importeparcherecibido = 0.0;

        ///// Corbata
        String cantidadbordadoscorbata = "";
        String frentecorbata = "";

        double importefrentecorbata = 0.0;

        int año = 0;

        String costostring = "0";

        Calendar cal = new GregorianCalendar();

        int dia = i;
        
        String messtring = lbmes.getText();
        
        if(messtring.equals("Diciembre"))
        {
          mes =12;  
        }
        else
        {    
        mes = (cal.get(Calendar.MONTH) + 1);
        }
        
        if (mes > mesfinal) 
        {
            mes = mesfinal;
        } 

        String labelaño = lbaño.getText();
        año = Integer.parseInt(labelaño);

        String fechabusqueda = (+año + "-" + mesfinal + "-" + dia);

        double sumatotaldelosbordados = 0.00;
        double sumatotaldelosbordadosrecibidos = 0.00;

        double sumatotaldelosbordadosgorra = 0.00;
        double sumatotaldelosbordadosgorrarecibidas = 0.00;

        double sumatotaldelosbordadoscorbata = 0.00;

        double sumatotaldelosbordadospantalon = 0.00;
        double sumatotaldelosbordadospantalonrecibidas = 0.00;
        double sumatotaldelosbordadosgorrainterna = 0.00;
        double sumatotaldelosbordadosparcheinterna = 0.00;
        double sumatotaldelosbordadosportanombre = 0.00;
        double sumatotaldelosbordadosportanombremultiple = 0.00;
        double sumatotaldelosponchados = 0.00;

        ////////////CAMISAS
        
        String sql = "Select codigo,fecha,cliente,cantidad,prenda,cantidad_pecho_izquierdo,pecho_izquierdo_nombre,pecho_izquierdo,"
                + "cantidad_pecho_derecho,pecho_derecho_nombre,pecho_derecho,"
                + "cantidad_manga_izquierda,manga_izquierda_nombre,manga_izquierda,"
                + "cantidad_manga_derecha,manga_derecha_nombre,manga_derecha,"
                + "cantidad_espalda,espalda_nombre,espalda,"
                + "aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,"
                + "otra_ubicacion,cantidad_otra_ubicacion,otra_ubicacion2,cantidad_otra_ubicacion2 from historial_ordenes_camisa where (estatus_orden = 'realizada' or estatus_orden = 'generada') and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                
              
                cantidadbordados = rs.getString("cantidad");
                pechoizquierdo = rs.getString("pecho_izquierdo");
                cantidadpechoizquierdo = rs.getString("cantidad_pecho_izquierdo");
                pechoderecho = rs.getString("pecho_derecho");
                cantidadpechoderecho = rs.getString("cantidad_pecho_derecho");
                mangaizquierda = rs.getString("manga_izquierda");
                cantidadmangaizquierda = rs.getString("cantidad_manga_izquierda");
                mangaderecha = rs.getString("manga_derecha");
                cantidadmangaderecha = rs.getString("cantidad_manga_derecha");
                espalda = rs.getString("espalda");
                cantidadespalda = rs.getString("cantidad_espalda");
                otraubicacion = rs.getString("otra_ubicacion");
                cantidadotraubicacion = rs.getString("cantidad_otra_ubicacion");
                otraubicacion2 = rs.getString("otra_ubicacion2");
                cantidadotraubicacion2 = rs.getString("cantidad_otra_ubicacion2");

                aplicacionpechoizquierdo = rs.getString("aplicacion_pecho_izquierdo");
                aplicacionpechoderecho = rs.getString("aplicacion_pecho_derecho");
                aplicacionmangaizquierda = rs.getString("aplicacion_manga_izquierda");
                aplicacionmangaderecha = rs.getString("aplicacion_manga_derecha");
                aplicacionespalda = rs.getString("aplicacion_espalda");

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordados == null || cantidadbordados.equals("")) {
                    cantidadbordados = "0";
                }

            int cantidad =  Integer.parseInt(cantidadbordados);   
            int cantidadpechoizquierdoint = Integer.parseInt(cantidadpechoizquierdo);
            int cantidadpechoderechoint = Integer.parseInt(cantidadpechoderecho);
            int cantidadmangaizquierdaint = Integer.parseInt(cantidadmangaizquierda);
            int cantidadmangaderechaint = Integer.parseInt(cantidadmangaderecha);
            int cantidadespaldaint = Integer.parseInt(cantidadespalda);
            int cantidadotraubicacionint = Integer.parseInt(cantidadotraubicacion);
            int cantidadotraubicacion2int = Integer.parseInt(cantidadotraubicacion2);

                //PECHO IZQUIERDO
                double costopuntadapechoizquierdo = 0.0;
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoizquierdo + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadapechoizquierdo = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importepechoizquierdo = cantidadpechoizquierdoint * costopuntadapechoizquierdo;

                //PECHO DERECHO
                double costopuntadapechoderecho = 0.0;

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoderecho + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadapechoderecho = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importepechoderecho = cantidadpechoderechoint * costopuntadapechoderecho;

                //MANGA IZQUIERDA
                double costopuntadamangaizquierda = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaizquierda + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costopuntadamangaizquierda = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importemangaizquierda = cantidadmangaizquierdaint * costopuntadamangaizquierda;

                //MANGA DERECHA
                double costopuntadamangaderecha = 0.0;

                String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaderecha + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql4);
                    ResultSet rs4 = prst.executeQuery();
                    if (rs4.next()) {

                        costostring = rs4.getString("costo");
                        costopuntadamangaderecha = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importemangaderecha = cantidadmangaderechaint * costopuntadamangaderecha;

                // ESPALDA
                double costopuntadaespalda = 0.0;

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + espalda + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaespalda = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeespalda = cantidadespaldaint * costopuntadaespalda;

                // OTRA UBICACION
                double costopuntadaotraubicacion = 0.0;

                String sql6 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacion + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql6);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaotraubicacion = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {

                    JOptionPane.showMessageDialog(null, exx);

                }

                importeotraubicacion = cantidadotraubicacionint * costopuntadaotraubicacion;

                // OTRA UBICACION2
                double costopuntadaotraubicacion2 = 0.0;

                String sql7 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacion2 + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql7);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaotraubicacion2 = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {

                    JOptionPane.showMessageDialog(null, exx);

                }

                importeotraubicacion2 = cantidadotraubicacion2int * costopuntadaotraubicacion2;

                if (aplicacionpechoizquierdo == null || aplicacionpechoizquierdo.equals("") || aplicacionpechoizquierdo.equals(" ")) {
                    aplicacionpechoizquierdo = "0";
                }

                double aplicacionpechoizquierdodouble = Double.parseDouble(aplicacionpechoizquierdo);

                if (aplicacionpechoderecho == null || aplicacionpechoderecho.equals("") || aplicacionpechoderecho.equals(" ")) {
                    aplicacionpechoderecho = "0";
                }

                double aplicacionpechoderechodouble = Double.parseDouble(aplicacionpechoderecho);

                if (aplicacionmangaizquierda == null || aplicacionmangaizquierda.equals("") || aplicacionmangaizquierda.equals(" ")) {
                    aplicacionmangaizquierda = "0";
                }

                double aplicacionmangaizquierdadouble = Double.parseDouble(aplicacionmangaizquierda);

                if (aplicacionmangaderecha == null || aplicacionmangaderecha.equals("") || aplicacionmangaderecha.equals(" ")) {
                    aplicacionmangaderecha = "0";
                }

                double aplicacionmangaderechadouble = Double.parseDouble(aplicacionmangaderecha);

                double sumadelasaplicioneschicasdouble = aplicacionpechoizquierdodouble + aplicacionpechoderechodouble + aplicacionmangaderechadouble + aplicacionmangaizquierdadouble;

                double costopuntadaaplicacionchica = 0.0;

                String sql10 = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION CHICA' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql10);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaaplicacionchica = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {

                    JOptionPane.showMessageDialog(null, exx);

                }

                sumadelasaplicioneschicasdouble = (sumadelasaplicioneschicasdouble * cantidad) * costopuntadaaplicacionchica;

                if (aplicacionespalda == null || aplicacionespalda.equals("") || aplicacionespalda.equals(" ")) {
                    aplicacionespalda = "0";
                }

                double aplicacionespaldadouble = Double.parseDouble(aplicacionespalda);
                double costopuntadaaplicaciongrande = 0.0;

                String sql11 = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION GRANDE' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql11);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaaplicaciongrande = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {

                    JOptionPane.showMessageDialog(null, exx);

                }

                double sumadelasaplicionesgrandesdouble = (aplicacionespaldadouble * cantidad) * costopuntadaaplicaciongrande;

                double sumabordados = importepechoizquierdo + importepechoderecho + importemangaizquierda + importemangaderecha + importeespalda + importeotraubicacion + importeotraubicacion2 + sumadelasaplicionesgrandesdouble + sumadelasaplicioneschicasdouble;
                sumatotaldelosbordados = sumatotaldelosbordados + sumabordados;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        ///////// CAMISAS RECIBIDAS
        String sqlcamisasrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,pecho_izquierdo_nombre,pecho_izquierdo,pecho_derecho_nombre,pecho_derecho,manga_izquierda_nombre,manga_izquierda,manga_derecha_nombre,manga_derecha,espalda_nombre,espalda,aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,otra_ubicacion from historial_ordenes_camisa_recibidas where (estatus_orden = 'realizada' or estatus_orden = 'generada') and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcamisasrecibidas);

            while (rs.next()) {

                cantidadbordadosrecibidos = rs.getString("cantidad");
                pechoizquierdorecibidos = rs.getString("pecho_izquierdo");
                pechoderechorecibidos = rs.getString("pecho_derecho");
                mangaizquierdarecibidos = rs.getString("manga_izquierda");
                mangaderecharecibidos = rs.getString("manga_derecha");
                espaldarecibidos = rs.getString("espalda");
                otraubicacionrecibidos = rs.getString("otra_ubicacion");
                aplicacionpechoizquierdorecibidos = rs.getString("aplicacion_pecho_izquierdo");
                aplicacionpechoderechorecibidos = rs.getString("aplicacion_pecho_derecho");
                aplicacionmangaizquierdarecibidos = rs.getString("aplicacion_manga_izquierda");
                aplicacionmangaderecharecibidos = rs.getString("aplicacion_manga_derecha");
                aplicacionespaldarecibidos = rs.getString("aplicacion_espalda");

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordadosrecibidos == null || cantidadbordadosrecibidos.equals("")) {
                    cantidadbordadosrecibidos = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordadosrecibidos);

                //PECHO IZQUIERDO
                double costopuntadapechoizquierdorecibidos = 0.0;

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoizquierdorecibidos + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadapechoizquierdorecibidos = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importepechoizquierdorecibidos = cantidad * costopuntadapechoizquierdorecibidos;

                //PECHO DERECHO
                double costopuntadapechoderechorecibidos = 0.0;

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoderechorecibidos + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadapechoderechorecibidos = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importepechoderechorecibidos = cantidad * costopuntadapechoderechorecibidos;

                //MANGA IZQUIERDA
                double costopuntadamangaizquierdarecibidos = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaizquierdarecibidos + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costopuntadamangaizquierdarecibidos = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importemangaizquierdarecibidos = cantidad * costopuntadamangaizquierdarecibidos;

                //MANGA DERECHA
                double costopuntadamangaderecharecibidos = 0.0;

                String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaderecharecibidos + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql4);
                    ResultSet rs4 = prst.executeQuery();
                    if (rs4.next()) {

                        costostring = rs4.getString("costo");
                        costopuntadamangaderecharecibidos = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importemangaderecharecibidos = cantidad * costopuntadamangaderecharecibidos;

                // ESPALDA
                double costopuntadaespaldarecibidos = 0.0;

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + espaldarecibidos + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaespaldarecibidos = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeespaldarecibidos = cantidad * costopuntadaespaldarecibidos;

                /// otra ubicacion
                double costopuntadaotraubicacionrecibidos = 0.0;

                String sql6 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacionrecibidos + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql6);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaotraubicacionrecibidos = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeotraubicacionrecibidos = cantidad * costopuntadaotraubicacionrecibidos;

                ////
                //APLICACIONES
                if (aplicacionpechoizquierdorecibidos == null || aplicacionpechoizquierdorecibidos.equals("") || aplicacionpechoizquierdorecibidos.equals(" ")) {
                    aplicacionpechoizquierdorecibidos = "0";
                }

                double aplicacionpechoizquierdodouble = Double.parseDouble(aplicacionpechoizquierdorecibidos);

                if (aplicacionpechoderechorecibidos == null || aplicacionpechoderechorecibidos.equals("") || aplicacionpechoderechorecibidos.equals(" ")) {
                    aplicacionpechoderechorecibidos = "0";
                }

                double aplicacionpechoderechodouble = Double.parseDouble(aplicacionpechoderechorecibidos);

                if (aplicacionmangaizquierdarecibidos == null || aplicacionmangaizquierdarecibidos.equals("") || aplicacionmangaizquierdarecibidos.equals(" ")) {
                    aplicacionmangaizquierdarecibidos = "0";
                }

                double aplicacionmangaizquierdadouble = Double.parseDouble(aplicacionmangaizquierdarecibidos);

                if (aplicacionmangaderecharecibidos == null || aplicacionmangaderecharecibidos.equals("") || aplicacionmangaderecharecibidos.equals(" ")) {
                    aplicacionmangaderecharecibidos = "0";
                }

                double aplicacionmangaderechadouble = Double.parseDouble(aplicacionmangaderecharecibidos);
               
                double sumadelasaplicioneschicasdouble = aplicacionpechoizquierdodouble + aplicacionpechoderechodouble + aplicacionmangaderechadouble + aplicacionmangaizquierdadouble;
                double costopuntadaaplicacionchica = 0.0;

                String sql10 = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION CHICA' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql10);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaaplicacionchica = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {

                    JOptionPane.showMessageDialog(null, exx);

                }

                sumadelasaplicioneschicasdouble = (sumadelasaplicioneschicasdouble *cantidad )* costopuntadaaplicacionchica;

                if (aplicacionespalda == null || aplicacionespalda.equals("") || aplicacionespalda.equals(" ")) {
                    aplicacionespalda = "0";
                }

                double aplicacionespaldadouble = Double.parseDouble(aplicacionespalda);
                double costopuntadaaplicaciongrande = 0.0;

                String sql11 = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION GRANDE' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql11);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaaplicaciongrande = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {

                    JOptionPane.showMessageDialog(null, exx);

                }

                double sumadelasaplicionesgrandesdouble = (aplicacionespaldadouble * cantidad )* costopuntadaaplicaciongrande;

                
                ////suma
                double sumabordadosrecibidos = importepechoizquierdorecibidos + importepechoderechorecibidos + importemangaizquierdarecibidos + importemangaderecharecibidos + importeespaldarecibidos + importeotraubicacionrecibidos +  sumadelasaplicionesgrandesdouble + sumadelasaplicioneschicasdouble;
                sumatotaldelosbordadosrecibidos = sumatotaldelosbordadosrecibidos + sumabordadosrecibidos;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
        
//////////////////////        
////////////////////// GORRAS
        String sqlgorras = "Select codigo,fecha,cliente,cantidad,prenda,puntadas_lado_izquierdo,puntadas_lado_derecho,puntadas_frente,puntadas_atras,aplicacion_frente from historial_ordenes_gorra where estatus_orden = 'realizada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlgorras);

            while (rs.next()) {

                cantidadbordados = rs.getString("cantidad");
                ladoizquierdogorra = rs.getString("puntadas_lado_izquierdo");
                ladoderechogorra = rs.getString("puntadas_lado_derecho");
                frentegorra = rs.getString("puntadas_frente");
                atrasgorra = rs.getString("puntadas_atras");

                aplicacionfrente = rs.getString("aplicacion_frente");

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordados == null || cantidadbordados.equals("")) {
                    cantidadbordados = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordados);

                //PECHO IZQUIERDO
                double costopuntadaladoizquierdo = 0.0;

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdogorra + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadaladoizquierdo = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoizquierdogorra = cantidad * costopuntadaladoizquierdo;

                //PECHO DERECHO
                double costopuntadaladoderecho = 0.0;

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechogorra + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoderecho = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoderechogorra = cantidad * costopuntadaladoderecho;

                //MANGA IZQUIERDA
                double costopuntadafrente = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frentegorra + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importefrentegorra = cantidad * costopuntadafrente;

                //MANGA DERECHA
                double costopuntadaatras = 0.0;

                String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + atrasgorra + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql4);
                    ResultSet rs4 = prst.executeQuery();
                    if (rs4.next()) {

                        costostring = rs4.getString("costo");
                        costopuntadaatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeatrasgorra = cantidad * costopuntadaatras;
                
                if (aplicacionfrente == null || aplicacionfrente.equals("") || aplicacionfrente.equals(" ")) {
                    aplicacionfrente = "0";
                }

                
                double costopuntadaaplicaciongrande = 0.0;

                String sql11 = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION CHICA' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql11);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaaplicaciongrande = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {

                    JOptionPane.showMessageDialog(null, exx);

                }
                
                int aplicacionfrenteint =Integer.parseInt(aplicacionfrente);
                importeaplicaciongorra = (cantidad *aplicacionfrenteint )* costopuntadaaplicaciongrande;

                ///
                double sumabordadosgorra = importeladoizquierdogorra + importeladoderechogorra + importefrentegorra + importeatrasgorra + importeaplicaciongorra;
                

                //double sumabordadosgorra = importeladoizquierdogorra + importeladoderechogorra + importefrentegorra + importeatrasgorra;
                sumatotaldelosbordadosgorra = sumatotaldelosbordadosgorra + sumabordadosgorra;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        ///////// GORRA recibidas
        String sqlgorrasrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,puntadas_lado_izquierdo,puntadas_lado_derecho,puntadas_frente,puntadas_atras,aplicacion_frente from historial_ordenes_gorra_recibidas where estatus_orden = 'realizada' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlgorrasrecibidas);

            while (rs.next()) {

                cantidadbordadosrecibidos = rs.getString("cantidad");
                ladoizquierdogorrarecibidas = rs.getString("puntadas_lado_izquierdo");
                ladoderechogorrarecibidas = rs.getString("puntadas_lado_derecho");
                frentegorrarecibidas = rs.getString("puntadas_frente");
                atrasgorrarecibidas = rs.getString("puntadas_atras");

                aplicacionfrenterecibidas = rs.getString("aplicacion_frente");

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordadosrecibidos == null || cantidadbordadosrecibidos.equals("")) {
                    cantidadbordadosrecibidos = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordadosrecibidos);

                //PECHO IZQUIERDO
                double costopuntadaladoizquierdorecibidas = 0.0;

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdogorrarecibidas + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadaladoizquierdorecibidas = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoizquierdogorrarecibidas = cantidad * costopuntadaladoizquierdorecibidas;

                //PECHO DERECHO
                double costopuntadaladoderechorecibidas = 0.0;

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechogorrarecibidas + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoderechorecibidas = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoderechogorrarecibidas = cantidad * costopuntadaladoderechorecibidas;

                //MANGA IZQUIERDA
                double costopuntadafrenterecibidas = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frentegorrarecibidas + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costopuntadafrenterecibidas = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importefrentegorrarecibidas = cantidad * costopuntadafrenterecibidas;

                //MANGA DERECHA
                double costopuntadaatrasrecibidas = 0.0;

                String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + atrasgorrarecibidas + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql4);
                    ResultSet rs4 = prst.executeQuery();
                    if (rs4.next()) {

                        costostring = rs4.getString("costo");
                        costopuntadaatrasrecibidas = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeatrasgorrarecibidas = cantidad * costopuntadaatrasrecibidas;
                
                ///
                if (aplicacionfrenterecibidas == null || aplicacionfrenterecibidas.equals("") || aplicacionfrenterecibidas.equals(" ")) {
                    aplicacionfrenterecibidas = "0";
                }  
                double costopuntadaaplicaciongrande = 0.0;

                String sql11 = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION CHICA' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql11);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadaaplicaciongrande = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {

                    JOptionPane.showMessageDialog(null, exx);

                }
                
                int aplicacionfrenterecibidasint =Integer.parseInt(aplicacionfrenterecibidas);
                importeaplicaciongorrarecibida = (cantidad *aplicacionfrenterecibidasint )* costopuntadaaplicaciongrande;
                 


                ///
                
                double sumabordadosgorrarecibidas = importeladoizquierdogorrarecibidas + importeladoderechogorrarecibidas + importefrentegorrarecibidas + importeatrasgorrarecibidas+ importeaplicaciongorrarecibida;
                sumatotaldelosbordadosgorrarecibidas = sumatotaldelosbordadosgorrarecibidas + sumabordadosgorrarecibidas;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        ///////////////
        //////////////
        ///////////// ORDENINTERNA GORRA
        String cantidadbordadosordeninterna = "";
        String descripcion = "";
        String frente = "";
        String puntadasfrenteordeninterna = "";

        String sqlgorrasinternas = "Select cantidad_entregada,descripcion from historial_ordenes_bordados_interno where estatus_entrega = 'entregada'  AND fecha = '" + fechabusqueda + "'  AND prenda = 'Gorra' order by numero ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs8 = st.executeQuery(sqlgorrasinternas);

            while (rs8.next()) 
            {

                cantidadbordadosordeninterna = rs8.getString("cantidad_entregada");
                descripcion = rs8.getString("descripcion");

                if (descripcion.startsWith("\"SEGURIDAD\" ")) {
                    frente = "SEGURIDAD";
                    puntadasfrenteordeninterna = "BORDADO DE 5,000 A 7,500 PUNTADAS";
                } else if (descripcion.startsWith("\"SEGURIDAD PRIVADA\" ")) {
                    frente = "\"SEGURIDAD PRIVADA\" ";
                    puntadasfrenteordeninterna = "BORDADO DE 7,500 A 10,000 PUNTADAS";

                } else if (descripcion.startsWith("\"VIGILANCIA\" ")) {
                    frente = "\"VIGILANCIA\" ";
                    puntadasfrenteordeninterna = "BORDADO DE 7,500 A 10,000 PUNTADAS";

                }

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordadosordeninterna == null || cantidadbordadosordeninterna.equals("")) {
                    cantidadbordadosordeninterna = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordadosordeninterna);

                double costopuntadafrenterecibidas = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadasfrenteordeninterna + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costopuntadafrenterecibidas = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importefrentegorrarecibidas = cantidad * costopuntadafrenterecibidas;

                double sumabordadosgorrainterna = importefrentegorrarecibidas;
                sumatotaldelosbordadosgorrainterna = sumatotaldelosbordadosgorrainterna + sumabordadosgorrainterna;

            }

          
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        ///////////////
        //////////////
        ///////////// ORDENINTERNA PARCHES
        String cantidadbordadosordeninterna2 = "";
        String descripcion2 = "";
        String frente2 = "";
        String puntadasfrenteordeninterna2 = "";

        String sqlparchesinternos = "Select cantidad_entregada,descripcion from historial_ordenes_bordados_interno where estatus_entrega = 'entregada' AND fecha = '" + fechabusqueda + "'  AND prenda = 'Parche' order by numero ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlparchesinternos);

            while (rs.next()) {

                cantidadbordadosordeninterna = rs.getString("cantidad_entregada");
                descripcion = rs.getString("descripcion");

                if (descripcion.startsWith("\"PARCHE SEGURIDAD\" ")) {
                    frente2 = "SEGURIDAD";
                    puntadasfrenteordeninterna2 = "BORDADO DE 5,000 A 7,500 PUNTADAS";
                } else if (descripcion.startsWith("\"PARCHE SEGURIDAD PRIVADA\" ")) {
                    frente2 = "\"SEGURIDAD PRIVADA\" ";
                    puntadasfrenteordeninterna2 = "BORDADO DE 5,000 A 7,500 PUNTADAS";

                } else if (descripcion.startsWith("\"PARCHE VIGILANCIA\" ")) {
                    frente2 = "\"VIGILANCIA\" ";
                    puntadasfrenteordeninterna2 = "BORDADO DE 5,000 A 7,500 PUNTADAS";

                } else if (descripcion.startsWith("PARCHE BANDERA DE MEXICO ")) {
                    frente = "PARCHE BANDERA DE MEXICO";
                    puntadasfrenteordeninterna2 = "BORDADO DE 12,500 A 15,000 PUNTADAS";

                }

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordadosordeninterna == null || cantidadbordadosordeninterna.equals("")) {
                    cantidadbordadosordeninterna = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordadosordeninterna);

                double costopuntadafrenterecibidas = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadasfrenteordeninterna2 + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costopuntadafrenterecibidas = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importefrentegorrarecibidas = cantidad * costopuntadafrenterecibidas;

                double sumabordadosparcheinterna = importefrentegorrarecibidas;
                sumatotaldelosbordadosparcheinterna = sumatotaldelosbordadosgorrainterna + sumabordadosparcheinterna;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        /////////////////////////////
        ////////////////////////////
        /////////////////////////// PANTALON
        String sqlpantalon = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_frente_puntadas,lado_derecho_frente_puntadas,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas from historial_ordenes_pantalon where estatus_orden = 'realizada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlpantalon);

            while (rs.next()) {

                cantidadbordados = rs.getString("cantidad");
                ladoizquierdofrente = rs.getString("lado_izquierdo_frente_puntadas");
                ladoderechofrente = rs.getString("lado_derecho_frente_puntadas");
                ladoizquierdoatras = rs.getString("lado_izquierdo_atras_puntadas");
                ladoderechoatras = rs.getString("lado_derecho_atras_puntadas");

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordados == null || cantidadbordados.equals("")) {
                    cantidadbordados = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordados);

                //PECHO IZQUIERDO FRENTE
                double costopuntadaladoizquierdofrente = 0.0;

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdofrente + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadaladoizquierdofrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoizquierdofrente = cantidad * costopuntadaladoizquierdofrente;

                //PECHO DERECHO FRENTE
                double costopuntadaladoderechofrente = 0.0;

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechofrente + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoderechofrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoderechofrente = cantidad * costopuntadaladoderechofrente;

                double costopuntadaladoizquierdoatras = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoatras + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadaladoizquierdoatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoizquierdoatras = cantidad * costopuntadaladoizquierdoatras;

                double costopuntadaladoderechoatras = 0.0;

                String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoatras + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql4);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadaladoderechoatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoderechoatras = cantidad * costopuntadaladoderechoatras;

                double sumabordadospantalon = importeladoizquierdoatras + importeladoderechoatras + importeladoizquierdofrente + importeladoderechofrente;
                sumatotaldelosbordadospantalon = sumatotaldelosbordadospantalon + sumabordadospantalon;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        ///////// PANTALON recibidas
        String sqlpantalonrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_frente_puntadas,lado_derecho_frente_puntadas,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas from historial_ordenes_pantalon_recibidas where estatus_orden = 'realizada' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlpantalonrecibidas);

            while (rs.next()) {

                cantidadbordados = rs.getString("cantidad");
                ladoizquierdofrenterecibidas = rs.getString("lado_izquierdo_frente_puntadas");
                ladoderechofrenterecibidas = rs.getString("lado_derecho_frente_puntadas");
                ladoizquierdoatrasrecibidas = rs.getString("lado_izquierdo_atras_puntadas");
                ladoderechoatrasrecibidas = rs.getString("lado_derecho_atras_puntadas");

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordados == null || cantidadbordados.equals("")) {
                    cantidadbordados = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordados);

                //PECHO IZQUIERDO FRENTE
                double costopuntadaladoizquierdofrenterecibidas = 0.0;

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdofrenterecibidas + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadaladoizquierdofrenterecibidas = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoizquierdofrenterecibidas = cantidad * costopuntadaladoizquierdofrenterecibidas;

                //PECHO DERECHO FRENTE
                double costopuntadaladoderechofrenterecibidas = 0.0;

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechofrenterecibidas + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoderechofrenterecibidas = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoderechofrenterecibidas = cantidad * costopuntadaladoderechofrenterecibidas;

                double costopuntadaladoizquierdoatrasrecibidas = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoatrasrecibidas + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadaladoizquierdoatrasrecibidas = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoizquierdoatrasrecibidas = cantidad * costopuntadaladoizquierdoatrasrecibidas;

                double costopuntadaladoderechoatrasrecibidas = 0.0;

                String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoatrasrecibidas + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql4);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadaladoderechoatrasrecibidas = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeladoderechoatrasrecibidas = cantidad * costopuntadaladoderechoatrasrecibidas;

                double sumabordadospantalonrecibidas = importeladoizquierdoatrasrecibidas + importeladoderechoatrasrecibidas + importeladoizquierdofrenterecibidas + importeladoderechofrenterecibidas;
                sumatotaldelosbordadospantalonrecibidas = sumatotaldelosbordadospantalonrecibidas + sumabordadospantalonrecibidas;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }


        /////////////////////////// Parches
        
        if (fechabusqueda.equals("2020-11-10")) 
        {
            int a = 0;
        }

        double costopuntadaparche = 0.0;
        String puntadasparche = "";
        Double costopuntadasparche = 0.00;
        Double importedelparche = 0.00;
        Double sumatotaldelosbordadosparche = 0.00;

        String sqlparches = "Select codigo,fecha,cliente,cantidad,parche,puntadas from historial_ordenes_parche where estatus_orden = 'realizada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlparches);

            while (rs.next()) {

                cantidadbordados = rs.getString("cantidad");
                puntadasparche = rs.getString("puntadas");

                if (cantidadbordados == null || cantidadbordados.equals("")) {
                    cantidadbordados = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordados);

                //PUNTADAS
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadasparche + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadasparche = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importedelparche = cantidad * costopuntadasparche;

                double sumabordadosparche = importedelparche;
                sumatotaldelosbordadosparche = sumatotaldelosbordadosparche + sumabordadosparche;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        ///////
        ////////PARCHES RECIBIDOS
        ///////         
        double costopuntadaparcherecibidos = 0.0;
        String puntadasparcherecibidos = "";
        Double costopuntadasparcherecibidos = 0.00;
        Double importedelparcherecibido = 0.00;
        Double sumatotaldelosbordadosparcherecibidos = 0.00;

        String sqlparchesrecibidos = "Select codigo,fecha,cliente,cantidad,parche from historial_ordenes_parche_recibidos where estatus_orden = 'realizada' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlparchesrecibidos);
            
            System.out.println(sqlparchesrecibidos);

            while (rs.next()) {

                cantidadbordadosrecibidos = rs.getString("cantidad");

                if (cantidadbordadosrecibidos == null || cantidadbordadosrecibidos.equals("")|| cantidadbordadosrecibidos.equals(" ")) {
                    cantidadbordadosrecibidos = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordadosrecibidos);

                //PUNTADAS
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadasparcherecibidos + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadasparcherecibidos = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importedelparcherecibido = cantidad * costopuntadasparcherecibidos;

                double sumabordadosparcherecibido = importedelparcherecibido;
                sumatotaldelosbordadosparcherecibidos = sumatotaldelosbordadosparcherecibidos + sumabordadosparcherecibido;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        ///// corbata
        String sqlcorbatas = "Select codigo,fecha,cliente,cantidad_bordados,prenda,frente_puntadas from historial_ordenes_corbata where estatus_orden = 'realizada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcorbatas);

            while (rs.next()) {

                cantidadbordados = rs.getString("cantidad_bordados");
                frentecorbata = rs.getString("frente_puntadas");

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordados == null || cantidadbordados.equals("")) {
                    cantidadbordados = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordados);

                //frente gorra
                double costopuntadafrente = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frentecorbata + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importefrentecorbata = cantidad * costopuntadafrente;

                double sumabordadoscorbata = importefrentecorbata;
                sumatotaldelosbordadoscorbata = sumatotaldelosbordadoscorbata + sumabordadoscorbata;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        ///////////////
        //////////////
        ///////////// PORTANOMBRE
        String cantidadbordadosordenportanombre = "";
        String frenteportanombre = "";
        String puntadasfrenteportanombre = "";
        double importeportanombres = 0;
        double costopuntadaportanombre = 0;

        String sqlportanombre = "Select fecha,cantidad,prenda from historial_ordenes_portanombres where fecha = '" + fechabusqueda + "' and estatus_orden not in ('cancelada')  order by numero   ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlportanombre);

            while (rs.next()) {

                cantidadbordadosordeninterna = rs.getString("cantidad");
                puntadasfrenteportanombre = "BORDADO DE MENOS DE 5,000 PUNTADAS";

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordadosordeninterna == null || cantidadbordadosordeninterna.equals("")) {
                    cantidadbordadosordeninterna = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordadosordeninterna);

                double costopuntadafrenterecibidas = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadasfrenteportanombre + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costopuntadaportanombre = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeportanombres = cantidad * costopuntadaportanombre;

                double sumabordadosportanombre = importeportanombres;
                sumatotaldelosbordadosportanombre = sumatotaldelosbordadosportanombre + sumabordadosportanombre;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        ///////////////
        //////////////
        ///////////// PORTANOMBREMULTIPLE
        String cantidadbordadosordenportanombremultiple = "";
        String frenteportanombremultiple = "";
        String puntadasfrenteportanombremultiple = "";
        double importeportanombresmultiple = 0;
        double costopuntadaportanombremultiple = 0;

        String sqlportanombremultiple = "Select fecha,cantidad_total from historial_ordenes_portanombres_multiple where fecha = '" + fechabusqueda + "' and estatus_orden not in ('cancelada')   order by numero   ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlportanombremultiple);

            while (rs.next()) {

                cantidadbordadosordeninterna = rs.getString("cantidad_total");
                puntadasfrenteportanombremultiple = "BORDADO DE MENOS DE 5,000 PUNTADAS";

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordadosordeninterna == null || cantidadbordadosordeninterna.equals("")) {
                    cantidadbordadosordeninterna = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordadosordeninterna);

                double costopuntadafrenterecibidas = 0.0;

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadasfrenteportanombremultiple + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costopuntadaportanombremultiple = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeportanombresmultiple = cantidad * costopuntadaportanombremultiple;

                double sumabordadosportanombremultiple = importeportanombresmultiple;
                sumatotaldelosbordadosportanombremultiple = sumatotaldelosbordadosportanombremultiple + sumabordadosportanombremultiple;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        //// ponchados
        String cantidadponchados = "";
        String nombrearticulo = "";
        String articulobuscar = "";
        double importeponchadis = 0;
        double costoponchados = 0;
        double importeponchado = 0;

        String sqlponchados = "Select numero,fecha,cliente,articulo,cantidad  from historial_ordenes_ponchados where estatus_orden = 'realizada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlponchados);

            while (rs.next()) {

                cantidadponchados = rs.getString("cantidad");
                nombrearticulo = rs.getString("articulo");

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadponchados == null || cantidadponchados.equals("")) {
                    cantidadponchados = "0";
                }

                if (nombrearticulo.toString().startsWith("PONCHADO")) {

                    if (nombrearticulo.toString().startsWith("PONCHADO FACIL")) {
                        articulobuscar = "PONCHADO FACIL";
                    } else if (nombrearticulo.toString().startsWith("PONCHADO MEDIO")) {
                        articulobuscar = "PONCHADO MEDIO";
                    } else if (nombrearticulo.toString().startsWith("PONCHADO DIFICIL")) {
                        articulobuscar = "PONCHADO DIFICIL";
                    }
                    else if (nombrearticulo.toString().startsWith("PONCHADO EXTRA DIFICIL")) {
                        articulobuscar = "PONCHADO EXTRA DIFICIL";
                    }
                }

                int cantidadponchadosint = Integer.parseInt(cantidadponchados);

                double costoponchadosdouble = 0.0;

                String sqlponchadoscosto = "SELECT costo from catalogo_costos_bordado where puntadas = '" + articulobuscar + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sqlponchadoscosto);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costoponchados = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeponchado = cantidadponchadosint * costoponchados;

                double sumaponchados = importeponchado;
                sumatotaldelosponchados = sumatotaldelosponchados + sumaponchados;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
         //// ponchados MODIFICADOS
        String cantidadponchadosmodificados = "";
        String nombrearticuloponchadosmodificados = "";
        String articulobuscarponchadosmodificados = "";
        double importeponchadosmodificados = 0;
        double costoponchadosmodificados = 0;
        double sumatotaldelosponchadosmodificados = 0;
        

        String sqlponchadosmodificados = " Select numero,fecha,nombre_cliente,articulo,cantidad,numero  from HISTORIAL_VENTAS where estatus_pago not like ('%cancelada%') and fecha = '" + fechabusqueda + "' AND ARTICULO LIKE '%MODIFICACION DE PONCHADO%'  order by numero ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlponchadosmodificados);

            while (rs.next()) {

                cantidadponchadosmodificados = rs.getString("cantidad");
                nombrearticuloponchadosmodificados = rs.getString("articulo");

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadponchadosmodificados == null || cantidadponchadosmodificados.equals("")) {
                    cantidadponchados = "0";
                }

                if (nombrearticuloponchadosmodificados.toString().startsWith("MODIFICACION DE PONCHADO")) {

                    if (nombrearticuloponchadosmodificados.toString().startsWith("MODIFICACION DE PONCHADO FACIL")) {
                        articulobuscar = "PONCHADO FACIL";
                    } else if (nombrearticuloponchadosmodificados.toString().startsWith("MODIFICACION DE PONCHADO MEDIO")) {
                        articulobuscar = "PONCHADO MEDIO";
                    } else if (nombrearticuloponchadosmodificados.toString().startsWith("MODIFICACION DE PONCHADO DIFICIL")) {
                        articulobuscar = "PONCHADO DIFICIL";
                    }
                    else if (nombrearticulo.toString().startsWith("PONCHADO EXTRA DIFICIL")) {
                        articulobuscar = "PONCHADO EXTRA DIFICIL";
                    }
                }

                int cantidadponchadosmodificadosint = Integer.parseInt(cantidadponchadosmodificados);

                double costoponchadosdouble = 0.0;

                String sqlponchadoscosto = "SELECT costo from catalogo_costos_bordado where puntadas = '" + articulobuscar + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sqlponchadoscosto);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costoponchados = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                importeponchadosmodificados = cantidadponchadosmodificadosint * costoponchados;

                double sumaponchadosmodificados = importeponchadosmodificados;
                sumatotaldelosponchadosmodificados = sumatotaldelosponchadosmodificados + sumaponchadosmodificados;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        /////
        
        String cantidadfotomontajes = "";
        String nombrefotomontaje = "";
        double importefotomontajes = 0;
        double sumatotaldelosfotomontajes = 0;
        double costofotomontajesdouble = 0.0;
        
        int cantidadfotomontajesint = 0;
        

        
        
       for (int z = 0; z < 3 ; z++)
       {

                    if (z == 0) 
                    {
                        nombrefotomontaje = "Fotomontaje 1 a 2 logos";
                    } else if (z == 1) 
                    {
                        nombrefotomontaje = "Fotomontaje 3 a 4 logos";
                    } else if (z == 2) 
                    {
                        nombrefotomontaje = "Fotomontaje con espalda";
                    }
       
        
        cantidadfotomontajesint = 0;
        costofotomontajesdouble = 0.0;
        
        String sqlfotomontajes = "SELECT COUNT(*) AS cantidad \n" +
                                 "FROM historial_fotomontajes \n" +
                                  "WHERE fotomontaje  like '%"+nombrefotomontaje+"%' and fecha = '" + fechabusqueda + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlfotomontajes);

            while (rs.next())
            {

                cantidadfotomontajes = rs.getString("cantidad");
                
                if (cantidadfotomontajes == null || cantidadfotomontajes.equals(""))
                {
                    cantidadfotomontajes = "0";
                }

                cantidadfotomontajesint = Integer.parseInt(cantidadfotomontajes);

               

                String sqlponchadoscosto = "SELECT costo from catalogo_costos_bordado where puntadas = '"+nombrefotomontaje+ "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sqlponchadoscosto);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) 
                    {

                        costostring = rs3.getString("costo");
                        costofotomontajesdouble = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }
                
                

                importefotomontajes = cantidadfotomontajesint * costofotomontajesdouble;

                double sumafotomontajes = importefotomontajes;
                sumatotaldelosfotomontajes = sumatotaldelosfotomontajes + importefotomontajes;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
       }
        
        

        /////
        //suma de los bordados
        /////
        double sumatotaldelosbordadosdouble = sumatotaldelosbordados + sumatotaldelosbordadosrecibidos + sumatotaldelosbordadosgorra + sumatotaldelosbordadosgorrarecibidas + sumatotaldelosbordadospantalon + sumatotaldelosbordadospantalonrecibidas + sumatotaldelosbordadosparche + sumatotaldelosbordadosparcherecibidos + sumatotaldelosbordadoscorbata + sumatotaldelosbordadosgorrainterna + sumatotaldelosbordadosparcheinterna + sumatotaldelosbordadosportanombre + sumatotaldelosbordadosportanombremultiple + sumatotaldelosponchados + sumatotaldelosponchadosmodificados + sumatotaldelosfotomontajes;
        String sumabordadosstring = String.format("%.02f ", sumatotaldelosbordadosdouble);

        tablafecha.setValueAt(sumabordadosstring, i - 1, 1);

    }

    
   
   
    void sumadelasaplicaciones() 
    {
        String costostring = "";
        double costopuntadasaplicacioneschicas = 0.00;
        double totalpuntosaplicacioneschicas = 0.00;

        for (int i = 0; i < tabla.getRowCount(); i++) 
        {

            Object cantidadaplicacion = tabla.getValueAt(i, 2);
            if (cantidadaplicacion == null || cantidadaplicacion.equals("") || cantidadaplicacion.equals(" ")) {
                cantidadaplicacion = "0";
            }

            int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion.toString());

            Object aplicacionpechoizquierdo = tabla.getValueAt(i, 53);
            if (aplicacionpechoizquierdo == null || aplicacionpechoizquierdo.equals("") || aplicacionpechoizquierdo.equals(" ")) {
                aplicacionpechoizquierdo = "0";
            }
            int aplicacionpechoizquierdoint = Integer.parseInt(aplicacionpechoizquierdo.toString());

            Object aplicacionpechoderecho = tabla.getValueAt(i, 54);
            if (aplicacionpechoderecho == null || aplicacionpechoderecho.equals("") || aplicacionpechoderecho.equals(" ")) {
                aplicacionpechoderecho = "0";
            }

            int aplicacionpechoderechoint = Integer.parseInt(aplicacionpechoderecho.toString());

            Object aplicacionmangaizquierda = tabla.getValueAt(i, 55);
            if (aplicacionmangaizquierda == null || aplicacionmangaizquierda.equals("") || aplicacionmangaizquierda.equals(" ")) {
                aplicacionmangaizquierda = "0";
            }
            int aplicacionmangaizquierdaint = Integer.parseInt(aplicacionmangaizquierda.toString());

            Object aplicacionmangaderecha = tabla.getValueAt(i, 56);
            if (aplicacionmangaderecha == null || aplicacionmangaderecha.equals("") || aplicacionmangaderecha.equals(" ")) {
                aplicacionmangaderecha = "0";
            }
            int aplicacionmangaderechaint = Integer.parseInt(aplicacionmangaderecha.toString());

            Object aplicacionfrente = tabla.getValueAt(i, 57);
            if (aplicacionfrente == null || aplicacionfrente.equals("") || aplicacionfrente.equals(" ")) {
                aplicacionfrente = "0";
            }
            int aplicacionfrenteint = Integer.parseInt(aplicacionfrente.toString());

            int sumadelasaplicaciones = aplicacionpechoizquierdoint + aplicacionpechoderechoint + aplicacionmangaizquierdaint + aplicacionmangaderechaint + aplicacionfrenteint;

            String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION CHICA' ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql1);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {

                    costostring = rs.getString("costo");
                    costopuntadasaplicacioneschicas = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            totalpuntosaplicacioneschicas = costopuntadasaplicacioneschicas * (sumadelasaplicaciones * cantidadaplicacionint);

            tabla.setValueAt(String.format("%.02f ", totalpuntosaplicacioneschicas), i, 59);

       

        //// aplicaciones grandes
        String costoaplicacionesgrandesstring = "";
        double costopuntadasaplicacionesgrandes = 0.00;
        double totalpuntosaplicacionesgrandes = 0.00;

       
            
            
            
            Object aplicacionespalda = tabla.getValueAt(i, 60);
            if (aplicacionespalda == null || aplicacionespalda.equals("") || aplicacionespalda.equals(" ")) {
                aplicacionespalda = "0";
            }
            int aplicacionespaldaint = Integer.parseInt(aplicacionespalda.toString());

            int sumadelasaplicacionesgrandes = aplicacionespaldaint;

            String sql1a = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION GRANDE' ";

            try {
                PreparedStatement prst = cn.prepareStatement(sql1a);
                ResultSet rs = prst.executeQuery();
                if (rs.next()) {

                    costoaplicacionesgrandesstring = rs.getString("costo");
                    costopuntadasaplicacionesgrandes = Double.parseDouble(costoaplicacionesgrandesstring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            totalpuntosaplicacionesgrandes = costopuntadasaplicacionesgrandes * (sumadelasaplicacionesgrandes* cantidadaplicacionint);

            tabla.setValueAt(String.format("%.02f ", totalpuntosaplicacionesgrandes), i, 61);

        }

        /// suma con los puntos
        for (int i = 0; i < tabla.getRowCount(); i++) 
        {
            Object puntosaplicacioneschicas = tabla.getValueAt(i, 59);
            if (puntosaplicacioneschicas == null || puntosaplicacioneschicas.equals("") || puntosaplicacioneschicas.equals(" ")) {
                puntosaplicacioneschicas = "0";
            }

            Object puntosaplicacionesgrandes = tabla.getValueAt(i, 61);
            if (puntosaplicacionesgrandes == null || puntosaplicacionesgrandes.equals("") || puntosaplicacionesgrandes.equals(" ")) {
                puntosaplicacionesgrandes = "0";
            }

            Object puntostotales = tabla.getValueAt(i, 62);
            if (puntostotales == null || puntostotales.equals("") || puntostotales.equals(" ")) {
                puntostotales = "0";
            }

            double puntosaplicacioneschicasdouble = Double.parseDouble(puntosaplicacioneschicas.toString());
            double puntosaplicacionesgrandesdouble = Double.parseDouble(puntosaplicacionesgrandes.toString());
            double puntostotalesdouble = Double.parseDouble(puntostotales.toString());

            double sumatotaldepuntos = puntostotalesdouble + puntosaplicacioneschicasdouble + puntosaplicacionesgrandesdouble  ;

            tabla.setValueAt(String.format("%.02f ", sumatotaldepuntos), i, 62);

        }

    }
    
    void suma()
    {
         
        int filas = tabla.getRowCount();
        double sumatotal = 0;

        for (int j = 0; j < filas; j++) 
        {

       
            Object cantidadobject = tabla.getValueAt(j, 62);
            if(cantidadobject == null || cantidadobject.equals("") || cantidadobject.equals(" "))
            {
                cantidadobject = "0";
            }

            double cantidaddouble = Double.parseDouble(cantidadobject.toString());

            sumatotal = sumatotal + cantidaddouble;
           
        }
        
        String sumatotalstring = String.format("%.02f ", sumatotal); 

        lbsumapuntos.setText(sumatotalstring);
        
        
    }

    void actualizarlasuma() {
        String mes = lbmes.getText();
        String año = lbaño.getText();
        String suma = lbsuma.getText();
        String existe = "";

        String sql1 = "SELECT mes,año from puntos_bordadores where mes='" + mes + "' and año = '" + año + "'  ";

        try {
            PreparedStatement prst = cn.prepareStatement(sql1);
            ResultSet rs = prst.executeQuery();
            if (rs.next()) {

                existe = "si";

            } else {
                existe = "no";
            }

        } catch (Exception exx) {
            JOptionPane.showMessageDialog(null, exx);

        }

        if (existe.equals("si")) {

            try {

                PreparedStatement pst = cn.prepareStatement("UPDATE puntos_bordadores SET puntos = '" + suma + "' WHERE mes='" + mes + "' and año = '" + año + "'    ");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

        } else {

            String sqlinsertar = "INSERT INTO puntos_bordadores(mes,año,puntos) VALUES (?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(sqlinsertar);
                pst.setString(1, mes);
                pst.setString(2, año);
                pst.setString(3, suma);

                pst.executeUpdate();
                pst.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }

    }
    
    
     void datosfotomontajes(int i) {

        DefaultTableModel modelo2 = (DefaultTableModel) tabla.getModel();
        String[] datos = new String[65];
        Calendar cal = new GregorianCalendar();

        int dia = i;
        int mesint = 0;
        
        
        if(messtring.equals("Diciembre"))
        {
          mesint =12;    
        }
        else
        {    
        mesint = (cal.get(Calendar.MONTH) + 1);
        }
        
        
        if (mesint > mesfinal) 
        {
            
            mesint = mesfinal;
        }
        
        String añostring = lbaño.getText();
        int año = Integer.parseInt(añostring);
        String fechabusqueda = (+año + "-" + mesint + "-" + dia);
        
        
        for(int z = 0;  z < 3; z++)
        {
        
            Object nombrefotomontaje = "";
            
            if (z == 0) 
                    {
                        nombrefotomontaje = "Fotomontaje 1 a 2 logos";
                    } else if (z == 1) 
                    {
                        nombrefotomontaje = "Fotomontaje 3 a 4 logos";
                    } else if (z == 2) 
                    {
                        nombrefotomontaje = "Fotomontaje con espalda";
                    }
        

        String sql = "Select fecha, COUNT(*) AS cantidad   from historial_fotomontajes where fecha = '" + fechabusqueda + "' AND FOTOMONTAJE LIKE '%"+nombrefotomontaje+"%'   order by numero ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) 
            {
                
                
                Object cantidadobject = rs.getString("cantidad");
                if(cantidadobject == null || cantidadobject.equals("")|| cantidadobject.equals(" "))
                {
                    cantidadobject = "0";
                    
                }
                
                int cantidadint = Integer.parseInt(cantidadobject.toString());
                
                
                if(cantidadint > 0)
                {

                datos[0] = rs.getString("fecha");
                datos[1] = "NINGUNO";
                datos[2] = cantidadobject.toString();
                datos[3] = nombrefotomontaje.toString().toUpperCase();
                
                modelo2.addRow(datos);
                
                }
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        }

        calcularcostofotomontajes();

    }
    
    ////////////////////////////
    //////////////////
    //////////        
    void calcularcostofotomontajes() {

        double importedelfotomontaje = 0.0;
        String costostring = "0";

        for (int i = 0; i < tabla.getRowCount(); i++) {

            Object cantidadobject = tabla.getValueAt(i, 2);
            Object articulo = tabla.getValueAt(i, 3);
            int cantidad = Integer.parseInt(cantidadobject.toString());
            String articulobuscar = "";

            if (articulo.toString().startsWith("FOTOMONTAJE")) 
            {

                
               articulobuscar = articulo.toString();

                tabla.setValueAt(articulobuscar, i, 5);

                double costodelfotomontaje = 0.0;

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + articulobuscar + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costodelfotomontaje = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(null, exx);

                }

                String costofotomontajestring = String.format("%.02f ", costodelfotomontaje);
                tabla.setValueAt(costofotomontajestring, i, 6);

                double importefotomontaje = cantidad * costodelfotomontaje;

                double sumabordados = importefotomontaje;
                String sumafotomontajesstring = String.format("%.02f ", sumabordados);
                tabla.setValueAt(sumafotomontajesstring, i, 62);

            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog = new javax.swing.JDialog();
        txtdialogoubic = new javax.swing.JTextField();
        btndialogoguardar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btndialogoaceptar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lbmes = new javax.swing.JLabel();
        btnanterior = new javax.swing.JButton();
        btnsiguiente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbaño = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablafecha = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable()
        {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        }

        ;
        jLabel1 = new javax.swing.JLabel();
        lbsuma = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbdia = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        txtdialogoubic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdialogoubicActionPerformed(evt);
            }
        });

        btndialogoguardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btndialogoguardar.setText("Guardar");
        btndialogoguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndialogoguardarActionPerformed(evt);
            }
        });

        btndialogoaceptar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btndialogoaceptar.setForeground(new java.awt.Color(204, 0, 0));
        btndialogoaceptar.setText("Aceptar");
        btndialogoaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndialogoaceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialogLayout = new javax.swing.GroupLayout(jDialog.getContentPane());
        jDialog.getContentPane().setLayout(jDialogLayout);
        jDialogLayout.setHorizontalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(txtdialogoubic, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btndialogoguardar, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                .addGap(19, 19, 19))
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGap(230, 230, 230)
                        .addComponent(jLabel16))
                    .addGroup(jDialogLayout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(btndialogoaceptar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jDialogLayout.setVerticalGroup(
            jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialogLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtdialogoubic, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btndialogoguardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btndialogoaceptar)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Bordados Reporte General");
        setMaximumSize(new java.awt.Dimension(1400, 800));
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setPreferredSize(new java.awt.Dimension(1400, 800));
        setSize(new java.awt.Dimension(1400, 800));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Mes:");

        lbmes.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbmes.setText("Mesdelaño");

        btnanterior.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnanterior.setText("<");
        btnanterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanteriorActionPerformed(evt);
            }
        });

        btnsiguiente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsiguiente.setText(">");
        btnsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguienteActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("Año");

        lbaño.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbaño.setText("0000");

        tablafecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablafecha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Importe del día"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablafecha.setRowHeight(28);
        tablafecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablafechaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablafecha);
        if (tablafecha.getColumnModel().getColumnCount() > 0) {
            tablafecha.getColumnModel().getColumn(0).setResizable(false);
            tablafecha.getColumnModel().getColumn(1).setResizable(false);
        }

        tabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "fecha", "cliente", "cantidad", "prenda", "pecho izquierdo", "puntadas", "puntos", "pecho derecho", "puntadas", "puntos", "manga izquierda", "puntadas", "puntos", "manga derecha", "puntadas", "puntos", "espalda", "puntadas", "puntos", "otra ubicacion", "puntadas", "puntos", "ptra ubicacion2", "puntadas", "puntos", "frente", "puntadas", "puntos", "lado izquerdo", "puntadas", "puntos", "lado derecho", "puntadas", "puntos", "atras", "puntadas", "puntos", "puntos bordados", "lado izquierdo frente", "puntadas", "puntos", "lado derecho frente", "puntadas", "puntos", "lado izquierdo atras", "puntadas", "puntos", "lado derecho atras", "puntadas", "puntos", "Parche", "Puntadas", "Puntos", "aplic pecho izq", "aplic pecho der", "aplic manga izq", "aplic manga der", "aplic frente", "aplic chicas", "Puntos aplic chicas", "aplic espalda", "puntos aplic espalda", "Suma", "venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabla.setRowHeight(22);
        tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabla);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Suma:");

        lbsuma.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsuma.setText("0.00");
        lbsuma.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Mes anterior");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Mes siguiente");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos.setText("0.00");
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText("Suma");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("Dia:");

        lbdia.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbdia.setText("00");

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Horas Bordador mes actual");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(lbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbdia, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbaño, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(btnsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbsuma, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(392, 392, 392)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(45, 45, 45))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbaño, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbdia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsuma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btnanterior))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)
                                .addComponent(btnsiguiente)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        mesfinal = -1;
        ventanareportedebordadosgeneral = false;
        actualizarlasuma();
        this.dispose();

    }//GEN-LAST:event_formWindowClosing

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed

        mesfinal = -1;
        ventanareportedebordadosgeneral = false;
        actualizarlasuma();
        this.dispose();


    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanteriorActionPerformed

        btnsiguiente.setEnabled(true);
        mesfinal = mesfinal - 1;
        lbdia.setText("0");
        limpiartablafechas();
        seleccionarfechas();
        agregarfechasalatablafecha();


    }//GEN-LAST:event_btnanteriorActionPerformed

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed

        btnanterior.setEnabled(true);

        mesfinal = mesfinal + 1;
        lbdia.setText("0");
        limpiartablafechas();
        seleccionarfechas();
        agregarfechasalatablafecha();


    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void tablafechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablafechaMouseClicked

        if (evt.getClickCount() == 1) 
        {

            int fila = tablafecha.getSelectedRow();

            if (fila >= 0) 
            {

                Object fechabusqueda = tablafecha.getValueAt(fila, 0);
                lbdia.setText(fechabusqueda.toString());
                int fechabusquedaint = Integer.parseInt(fechabusqueda.toString());

                limpiartabla();
                datostablahistorialordenescamisa((int) fechabusquedaint);
                datostablahistorialordenescamisarecibidas((int) fechabusquedaint);
                datostablahistorialordenesgorra((int) fechabusquedaint);
                datostablahistorialordenesgorrarecibidas((int) fechabusquedaint);
                datostablahistorialordenespantalon((int) fechabusquedaint);
                //datostablahistorialordenespantalonrecibidos((int) fechabusquedaint);
                datostablahistorialparches((int) fechabusquedaint);
                datostablahistorialordenescorbata((int) fechabusquedaint);
                datostablaordeninternagorra((int) fechabusquedaint);
                datostablaordeninternaparche((int) fechabusquedaint);
                datostablaportanombre((int) fechabusquedaint);
                datostablaportanombremultiple((int) fechabusquedaint);
                datosponchados((int) fechabusquedaint);
                datosponchadosmodificados((int) fechabusquedaint);
                datosfotomontajes((int) fechabusquedaint);
                

            }
            
            sumadelasaplicaciones();
            suma();

        }

        

    }//GEN-LAST:event_tablafechaMouseClicked

    private void txtdialogoubicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdialogoubicActionPerformed

    }//GEN-LAST:event_txtdialogoubicActionPerformed

    private void btndialogoguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndialogoguardarActionPerformed
        JSystemFileChooser dialog = new JSystemFileChooser();
        int opcion = dialog.showSaveDialog(this);

        if (opcion == JSystemFileChooser.APPROVE_OPTION) {

            File dir = dialog.getSelectedFile();
            String fl = dir.toString();

            txtdialogoubic.setText(fl);
            btndialogoaceptar.doClick();
        } else {

        }
    }//GEN-LAST:event_btndialogoguardarActionPerformed

    private void btndialogoaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndialogoaceptarActionPerformed


    }//GEN-LAST:event_btndialogoaceptarActionPerformed

    private void tablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaMouseClicked

        if (evt.getClickCount() == 2) {
            int fila = tabla.getSelectedRow();
            Object numeroventa = tabla.getValueAt(fila, 63);

            if (numeroventa == null || numeroventa.equals("")) {
                JOptionPane.showMessageDialog(null, "No tiene numero de venta");
            } else {

            }

        }


    }//GEN-LAST:event_tablaMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        historialayudabordador ventana =  new historialayudabordador();
        historialayudabordador.lbaño.setText(lbaño.getText());
        historialayudabordador.cbmes.setSelectedItem(lbmes.getText());
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        

    }//GEN-LAST:event_jButton3ActionPerformed

    ResultSet rs;

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bordadosreportegeneral().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnanterior;
    private javax.swing.JButton btndialogoaceptar;
    private javax.swing.JButton btndialogoguardar;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnsiguiente;
    private javax.swing.JButton jButton3;
    private javax.swing.JDialog jDialog;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lbaño;
    public static javax.swing.JLabel lbdia;
    public static javax.swing.JLabel lbmes;
    private javax.swing.JLabel lbsuma;
    private javax.swing.JLabel lbsumapuntos;
    private javax.swing.JTable tabla;
    private javax.swing.JTable tablafecha;
    private javax.swing.JTextField txtdialogoubic;
    // End of variables declaration//GEN-END:variables
connectar cc = new connectar();
    Connection cn = cc.conexion();

}
