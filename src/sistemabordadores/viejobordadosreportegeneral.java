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
import java.time.DayOfWeek;
import java.time.LocalDate;
import static java.time.LocalDate.now;
import java.time.Month;
import javax.swing.JTable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


public class viejobordadosreportegeneral extends javax.swing.JFrame {

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

    public viejobordadosreportegeneral() {

        initComponents();
        ventanareportedebordadosgeneral = true;
        anchocolumnas();
        topes();
        seleccionarfechas();
        anterior = "no";
        datostablaizquierda();
        btnsiguiente.setEnabled(false);
        
        lbsumapuntos.setVisible(false);

    }

    void anchocolumnas() {

        tabladerecha.getColumnModel().getColumn(0).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(1).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(2).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(3).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(4).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(5).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(6).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(7).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(8).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(9).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(10).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(11).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(12).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(13).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(14).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(15).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(16).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(17).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(18).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(19).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(20).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(21).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(22).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(23).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(24).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(25).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(26).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(27).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(28).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(29).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(30).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(31).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(32).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(33).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(34).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(35).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(36).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(37).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(38).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(39).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(40).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(41).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(42).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(43).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(44).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(45).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(46).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(47).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(48).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(49).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(50).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(51).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(52).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(53).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(54).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(55).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(56).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(57).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(58).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(59).setMinWidth(0);
        tabladerecha.getColumnModel().getColumn(60).setMinWidth(0);

        tabladerecha.getColumnModel().getColumn(0).setMaxWidth(50);
        tabladerecha.getColumnModel().getColumn(1).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(2).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(3).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(4).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(5).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(6).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(7).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(8).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(9).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(10).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(11).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(12).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(13).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(14).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(15).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(16).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(17).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(18).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(19).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(20).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(21).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(22).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(23).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(24).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(25).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(26).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(27).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(28).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(29).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(30).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(31).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(32).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(33).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(34).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(35).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(36).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(37).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(38).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(39).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(40).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(41).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(42).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(43).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(44).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(45).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(46).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(47).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(48).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(49).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(50).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(51).setMaxWidth(0);
        tabladerecha.getColumnModel().getColumn(52).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(53).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(54).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(55).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(56).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(57).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(58).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(59).setMaxWidth(800);
        tabladerecha.getColumnModel().getColumn(60).setMaxWidth(800);

        tabladerecha.getColumnModel().getColumn(0).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(1).setPreferredWidth(350);
        tabladerecha.getColumnModel().getColumn(2).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(3).setPreferredWidth(200);
        tabladerecha.getColumnModel().getColumn(4).setPreferredWidth(200);
        tabladerecha.getColumnModel().getColumn(5).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(6).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(7).setPreferredWidth(200);
        tabladerecha.getColumnModel().getColumn(8).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(9).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(10).setPreferredWidth(200);
        tabladerecha.getColumnModel().getColumn(11).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(12).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(13).setPreferredWidth(200);
        tabladerecha.getColumnModel().getColumn(14).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(15).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(16).setPreferredWidth(200);
        tabladerecha.getColumnModel().getColumn(17).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(18).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(19).setPreferredWidth(200);
        tabladerecha.getColumnModel().getColumn(20).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(21).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(22).setPreferredWidth(200);
        tabladerecha.getColumnModel().getColumn(23).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(24).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(25).setPreferredWidth(200);
        tabladerecha.getColumnModel().getColumn(26).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(27).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(28).setPreferredWidth(200);
        tabladerecha.getColumnModel().getColumn(29).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(30).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(31).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(32).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(33).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(34).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(35).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(36).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(37).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(38).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(39).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(40).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(41).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(42).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(43).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(44).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(45).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(46).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(47).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(48).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(49).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(50).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(51).setPreferredWidth(0);
        tabladerecha.getColumnModel().getColumn(52).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(53).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(54).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(55).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(56).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(57).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(58).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(59).setPreferredWidth(80);
        tabladerecha.getColumnModel().getColumn(60).setPreferredWidth(80);

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
        
        
        DefaultTableModel modelo2 = (DefaultTableModel) tabladerecha.getModel();
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
        
        //CAMISA LOCAL

        String sql = "Select codigo,fecha,cliente,cantidad,prenda,numero_venta,"
                  + "pecho_izquierdo_cantidad,pecho_izquierdo_nombre,pecho_izquierdo_puntadas,"
                  + "pecho_derecho_cantidad,pecho_derecho_nombre,pecho_derecho_puntadas,"
                  + "manga_izquierda_cantidad,manga_izquierda_nombre,manga_izquierda_puntadas,"
                  + "manga_derecha_cantidad,manga_derecha_nombre,manga_derecha_puntadas,"
                  + "espalda_cantidad,espalda_nombre,espalda_puntadas,"
                  + "otra_ubicacion_cantidad,otra_ubicacion_puntadas,otra_ubicacion_nombre,"
                  + "otra_ubicacion2_cantidad,otra_ubicacion2_puntadas,otra_ubicacion2_nombre,"
                  + "aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,"
                  + "aplicacion_manga_derecha,aplicacion_espalda,aplicacion_otra_ubicacion,aplicacion_otra_ubicacion2"
                  + " from historial_ordenes_camisa"
                  + " where (estatus_orden = 'generada' or estatus_orden = 'realizada') and lugar = 'Esta sucursal'"
                  + "and (pecho_izquierdo_fecha = '" + fechabusqueda + "' or pecho_derecho_fecha = '" + fechabusqueda + "' or manga_izquierda_fecha = '" + fechabusqueda + "'  or manga_derecha_fecha = '" + fechabusqueda + "'  or espalda_fecha = '" + fechabusqueda + "'  or otra_ubicacion_fecha = '" + fechabusqueda + "'  or otra_ubicacion2_fecha = '" + fechabusqueda + "')"
                  + "  order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString("fecha");
                datos[1] = rs.getString("cliente");
                String cliente = rs.getString("cliente");
                datos[2] = rs.getString("cantidad");
                datos[3] = rs.getString("prenda");
                cantidadpechoizquierdo = rs.getString("pecho_izquierdo_cantidad");
                datos[4] = rs.getString("pecho_izquierdo_nombre");
                datos[5] = rs.getString("pecho_izquierdo_puntadas");
                cantidadpechoderecho = rs.getString("pecho_derecho_cantidad");
                datos[7] = rs.getString("pecho_derecho_nombre");
                datos[8] = rs.getString("pecho_derecho_puntadas");
                cantidadmangaizquierda = rs.getString("manga_izquierda_cantidad");
                datos[10] = rs.getString("manga_izquierda_nombre");
                datos[11] = rs.getString("manga_izquierda_puntadas");
                cantidadmangaderecha = rs.getString("manga_derecha_cantidad");
                datos[13] = rs.getString("manga_derecha_nombre");
                datos[14] = rs.getString("manga_derecha_puntadas");
                cantidadespalda = rs.getString("espalda_cantidad");
                datos[16] = rs.getString("espalda_nombre");
                datos[17] = rs.getString("espalda_puntadas");
                cantidadotraubicacion = rs.getString("otra_ubicacion_cantidad");
                datos[19] = rs.getString("otra_ubicacion_nombre");
                datos[20] = rs.getString("otra_ubicacion_puntadas");
                cantidadotraubicacion2 = rs.getString("otra_ubicacion2_cantidad");
                datos[22] = rs.getString("otra_ubicacion2_nombre");
                datos[23] = rs.getString("otra_ubicacion2_puntadas");
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
            Object pechoizquierdoobject = rs.getString("pecho_izquierdo_puntadas");
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
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadapechoizquierdostring = String.format("%.02f ", costopuntadapechoizquierdo);
            datos[6] = costopuntadapechoizquierdostring;
            importepechoizquierdo = cantidadpechoizquierdoint * costopuntadapechoizquierdo;

            //PECHO DERECHO
            double costopuntadapechoderecho = 0.0;
            Object pechoderechoobject = rs.getString("pecho_derecho_puntadas");
            String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoderechoobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql2);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadapechoderecho = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadapechoderechostring = String.format("%.02f ", costopuntadapechoderecho);
            datos[9] = costopuntadapechoderechostring;
            importepechoderecho = cantidadpechoderechoint * costopuntadapechoderecho;

//MANGA IZQUIERDA
            double costopuntadamangaizquierda = 0.0;
            Object mangaizquierdaobject = rs.getString("manga_izquierda_puntadas");
            String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaizquierdaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaizquierda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadamangaizquierda);
            datos[12] = costopuntadamangaizquierdastring;
            importemangaizquierda = cantidadmangaizquierdaint * costopuntadamangaizquierda;

//MANGA DERECHA
            double costopuntadamangaderecha = 0.0;
            Object mangaderechaobject = rs.getString("manga_derecha_puntadas");
            String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaderechaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql4);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaderecha = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadamangaderechastring = String.format("%.02f ", costopuntadamangaderecha);
             datos[15] = costopuntadamangaderechastring;
            importemangaderecha = cantidadmangaderechaint * costopuntadamangaderecha;

            // ESPALDA
            double costopuntadaespalda = 0.0;
            Object espaldaobject = rs.getString("espalda_puntadas");
            String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + espaldaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql5);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaespalda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadaespaldastring = String.format("%.02f ", costopuntadaespalda);
            datos[18] = costopuntadaespaldastring;
            importeespalda = cantidadespaldaint * costopuntadaespalda;

            /// otra ubicacion
            double costopuntadaotraubicacion = 0.0;
            Object otraubicacionobject = rs.getString("otra_ubicacion_puntadas");

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
            Object otraubicacion2object = datos[23] = rs.getString("otra_ubicacion2_puntadas");

            String sql7 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacion2object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql7);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaotraubicacion2 = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

        for (int i = 0; i < tabladerecha.getRowCount(); i++) {
            
             Object cantidadobject = tabladerecha.getValueAt(i, 2);
            Object cliente = tabladerecha.getValueAt(i, 1);
            
            int cantidadpechoizquierdoint = Integer.parseInt(cantidadpechoizquierdo);
            int cantidadpechoderechoint = Integer.parseInt(cantidadpechoderecho);
            int cantidadmangaizquierdaint = Integer.parseInt(cantidadmangaizquierda);
            int cantidadmangaderechaint = Integer.parseInt(cantidadmangaderecha);
            int cantidadespaldaint = Integer.parseInt(cantidadespalda);
            int cantidadotraubicacionint = Integer.parseInt(cantidadotraubicacion);
            int cantidadotraubicacion2int = Integer.parseInt(cantidadotraubicacion2);
 
            
            

            //PECHO IZQUIERDO
            double costopuntadapechoizquierdo = 0.0;
            Object pechoizquierdoobject = tabladerecha.getValueAt(i, 5);
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
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadapechoizquierdostring = String.format("%.02f ", costopuntadapechoizquierdo);
            tabladerecha.setValueAt(costopuntadapechoizquierdostring, i, 6);
            importepechoizquierdo = cantidadpechoizquierdoint * costopuntadapechoizquierdo;

            //PECHO DERECHO
            double costopuntadapechoderecho = 0.0;
            Object pechoderechoobject = tabladerecha.getValueAt(i, 8);
            String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoderechoobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql2);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadapechoderecho = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadapechoderechostring = String.format("%.02f ", costopuntadapechoderecho);
            tabladerecha.setValueAt(costopuntadapechoderechostring, i, 9);
            importepechoderecho = cantidadpechoderechoint * costopuntadapechoderecho;

//MANGA IZQUIERDA
            double costopuntadamangaizquierda = 0.0;
            Object mangaizquierdaobject = tabladerecha.getValueAt(i, 11);
            String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaizquierdaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaizquierda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadamangaizquierda);
            tabladerecha.setValueAt(costopuntadamangaizquierdastring, i, 12);
            importemangaizquierda = cantidadmangaizquierdaint * costopuntadamangaizquierda;

//MANGA DERECHA
            double costopuntadamangaderecha = 0.0;
            Object mangaderechaobject = tabladerecha.getValueAt(i, 14);
            String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaderechaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql4);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaderecha = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadamangaderechastring = String.format("%.02f ", costopuntadamangaderecha);
            tabladerecha.setValueAt(costopuntadamangaderechastring, i, 15);
            importemangaderecha = cantidadmangaderechaint * costopuntadamangaderecha;

            // ESPALDA
            double costopuntadaespalda = 0.0;
            Object espaldaobject = tabladerecha.getValueAt(i, 17);
            String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + espaldaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql5);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaespalda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadaespaldastring = String.format("%.02f ", costopuntadaespalda);
            tabladerecha.setValueAt(costopuntadaespaldastring, i, 18);
            importeespalda = cantidadespaldaint * costopuntadaespalda;

            /// otra ubicacion
            double costopuntadaotraubicacion = 0.0;
            Object otraubicacionobject = tabladerecha.getValueAt(i, 20);

            String sql6 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacionobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql6);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaotraubicacion = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadaotraubicacionstring = String.format("%.02f ", costopuntadaotraubicacion);
            tabladerecha.setValueAt(costopuntadaotraubicacionstring, i, 21);

            importeotraubicacion = cantidadotraubicacionint * costopuntadaotraubicacion;

            /// otra ubicacion2
            double costopuntadaotraubicacion2 = 0.0;
            Object otraubicacion2object = tabladerecha.getValueAt(i, 23);

            String sql7 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacion2object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql7);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs.getString("costo");
                    costopuntadaotraubicacion2 = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadaotraubicacion2string = String.format("%.02f ", costopuntadaotraubicacion2);
            tabladerecha.setValueAt(costopuntadaotraubicacion2string, i, 24);

            importeotraubicacion2 = cantidadotraubicacionint * costopuntadaotraubicacion2;

            double sumabordados = importepechoizquierdo + importepechoderecho + importemangaizquierda + importemangaderecha + importeespalda + importeotraubicacion + importeotraubicacion2;
            String sumabordadosstring = String.format("%.02f ", sumabordados);
            if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
            tabladerecha.setValueAt(sumabordadosstring, i, 62);

          

        }

    }
    
    void datostablahistorialordenesdistinta(int i) 
    {

        
        DefaultTableModel modelo2 = (DefaultTableModel) tabladerecha.getModel();
        String[] datos = new String[65];
        Calendar cal = new GregorianCalendar();
        
        
        double importedistinta1 = 0.0;
        double importedistinta2 = 0.0;
        double importedistinta3 = 0.0;
        double importedistinta4 = 0.0;
        double importedistinta5 = 0.0;
        double importedistinta6 = 0.0;
        double importedistinta7 = 0.0;
        
        String distinta1cantidad = "";
        String distinta2cantidad = "";
        String distinta3cantidad = "";
        String distinta4cantidad = "";
        String distinta5cantidad = "";
        String distinta6cantidad = "";
        String distinta7cantidad = "";
        

        String costostring = "0";
        
        
        

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

        String sql = "Select codigo,fecha,cliente,cantidad,tipo,numero_venta,"
                  + "distinta1_cantidad,distinta1_nombre,distinta1,"
                  + "distinta2_cantidad,distinta2_nombre,distinta2,"
                  + "distinta3_cantidad,distinta3_nombre,distinta3,"
                  + "distinta4_cantidad,distinta4_nombre,distinta4,"
                  + "distinta5_cantidad,distinta5_nombre,distinta5,"
                  + "distinta6_cantidad,distinta6_nombre,distinta6,"
                  + "distinta7_cantidad,distinta7_nombre,distinta7,"
                  + "distinta1_aplicacion,distinta2_aplicacion,distinta3_aplicacion,distinta4_aplicacion,distinta5_aplicacion,distinta6_aplicacion,distinta7_aplicacion from historial_ordenes_distinta where (estatus_orden = 'generada' or estatus_orden = 'realizada') and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString("fecha");
                datos[1] = rs.getString("cliente");
                String cliente = rs.getString("cliente");
                datos[2] = rs.getString("cantidad");
                datos[3] = rs.getString("tipo");
                
                distinta1cantidad = rs.getString("distinta1_cantidad");
                datos[4] = rs.getString("distinta1_nombre");
                datos[5] = rs.getString("distinta1");
               
                distinta1cantidad = rs.getString("distinta2_cantidad");
                datos[7] = rs.getString("distinta2_nombre");
                datos[8] = rs.getString("distinta2");
                
                distinta2cantidad = rs.getString("distinta3_cantidad");
                datos[10] = rs.getString("distinta3_nombre");
                datos[11] = rs.getString("distinta3");
                
                distinta3cantidad = rs.getString("distinta4_cantidad");
                datos[13] = rs.getString("distinta4_nombre");
                datos[14] = rs.getString("distinta4");
                
                distinta4cantidad = rs.getString("distinta5_cantidad");
                datos[16] = rs.getString("distinta5_nombre");
                datos[17] = rs.getString("distinta5");
                
                distinta5cantidad = rs.getString("distinta6_cantidad");
                datos[19] = rs.getString("distinta6_nombre");
                datos[20] = rs.getString("distinta6");
                
                distinta6cantidad = rs.getString("distinta7_cantidad");
                datos[22] = rs.getString("distinta7_nombre");
                datos[23] = rs.getString("distinta7");
                
                datos[53] = rs.getString("distinta1_aplicacion");
                datos[54] = rs.getString("distinta2_aplicacion");
                datos[55] = rs.getString("distinta3_aplicacion");
                datos[56] = rs.getString("distinta4_aplicacion");
                datos[60] = rs.getString("distinta5_aplicacion");
               
                datos[63] = rs.getString("numero_venta");
                
                ///
                
                 // Object cantidadobject = tabla.getValueAt(i, 2);
            //Object cliente = tabla.getValueAt(i, 1);
            
            int cantidaddistinta1int = Integer.parseInt(distinta1cantidad);
            int cantidaddistinta2int = Integer.parseInt(distinta2cantidad);
            int cantidaddistinta3int = Integer.parseInt(distinta3cantidad);
            int cantidaddistinta4int = Integer.parseInt(distinta4cantidad);
            int cantidaddistinta5int = Integer.parseInt(distinta5cantidad);
            int cantidaddistinta6int = Integer.parseInt(distinta6cantidad);
            int cantidaddistinta7int = Integer.parseInt(distinta7cantidad);
 
            
            double costopuntadadistinta1 = 0.0;
            double costopuntadadistinta2 = 0.0;
            double costopuntadadistinta3 = 0.0;
            double costopuntadadistinta4 = 0.0;
            double costopuntadadistinta5 = 0.0;
            double costopuntadadistinta6 = 0.0;
            double costopuntadadistinta7 = 0.0;

            Object distinta1object = rs.getString("distinta1");
            Object distinta2object = rs.getString("distinta2");
            Object distinta3object = rs.getString("distinta3");
            Object distinta4object = rs.getString("distinta4");
            Object distinta5object = rs.getString("distinta5");
            Object distinta6object = rs.getString("distinta6");
            Object distinta7object = rs.getString("distinta7");

            //distinta1
            
            
            String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta1object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql1);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next())
                {

                    costostring = rs2.getString("costo");
                    costopuntadadistinta1 = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            datos[6] = String.format("%.02f ", costopuntadadistinta1);
            importedistinta1 = cantidaddistinta1int * costopuntadadistinta1;

            //DISTINTA 2
            
            
            String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta2object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql2);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadadistinta2 = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            datos[9] = String.format("%.02f ", costopuntadadistinta2);
            importedistinta2 = cantidaddistinta2int * costopuntadadistinta2;

            

            /// distinta 3
            
            String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta3object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadadistinta3 = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            
            datos[12] = String.format("%.02f ", costopuntadadistinta3);
            importedistinta3 = cantidaddistinta3int * costopuntadadistinta3;

            
            
            /// distinta 4
          
            String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta4object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql4);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadadistinta4 = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            
            datos[15] = String.format("%.02f ", costopuntadadistinta4);
            importedistinta4 = cantidaddistinta4int * costopuntadadistinta4;



           /// distinta5
            String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta5object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql5);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadadistinta5 = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            datos[18] = String.format("%.02f ", costopuntadadistinta5);
            importedistinta5 = cantidaddistinta5int * costopuntadadistinta5;

           
             /// distinta6
            String sql6 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta6object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql6);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadadistinta6 = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                JOptionPane.showMessageDialog(null, exx);

            }

            
            datos[21] = String.format("%.02f ", costopuntadadistinta6);
            importedistinta6 = cantidaddistinta6int * costopuntadadistinta6;


            String sql7 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta6object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql7);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadadistinta7 = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            
            datos[24] = String.format("%.02f ", costopuntadadistinta7);
             importedistinta7 = cantidaddistinta7int * costopuntadadistinta7;

                double sumabordados = importedistinta1 + importedistinta2 + importedistinta3 + importedistinta4 + importedistinta5 + importedistinta6 + importedistinta7;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if (sumabordadosstring.equals("3.30")) {
                    int a = 0;
                }
                datos[62] = sumabordadosstring;
                modelo2.addRow(datos);
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
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
        
        DefaultTableModel modelo2 = (DefaultTableModel) tabladerecha.getModel();
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

        String sql = "Select codigo,fecha,cliente,cantidad,prenda,pecho_izquierdo_nombre,pecho_izquierdo_puntadas,pecho_derecho_nombre,"
                + "pecho_derecho_puntadas,manga_izquierda_nombre,manga_izquierda_puntadas,manga_derecha_nombre,manga_derecha_puntadas,"
                + "espalda_nombre,espalda_puntadas,aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,"
                + "aplicacion_manga_derecha,aplicacion_espalda,otra_ubicacion_nombre,otra_ubicacion_puntadas,otra_ubicacion2_nombre,otra_ubicacion2_puntadas"
                + " from historial_ordenes_camisa_recibidas"
                + " where (estatus_orden = 'realizada totalmente' OR estatus_orden = 'realizada parcialmente')"
                + "and (pecho_izquierdo_fecha = '" + fechabusqueda + "' or pecho_derecho_fecha = '" + fechabusqueda + "' or manga_izquierda_fecha = '" + fechabusqueda + "'  or manga_derecha_fecha = '" + fechabusqueda + "'  or espalda_fecha = '" + fechabusqueda + "'  or otra_ubicacion_fecha = '" + fechabusqueda + "'  or otra_ubicacion2_fecha = '" + fechabusqueda + "')"
                + "  order by codigo ";
        
      

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString("fecha");
                datos[1] = rs.getString("cliente");
                datos[2] = rs.getString("cantidad");
                datos[3] = rs.getString("prenda");
                datos[4] = rs.getString("pecho_izquierdo_nombre");
                datos[5] = rs.getString("pecho_izquierdo_puntadas");
                datos[7] = rs.getString("pecho_derecho_nombre");
                datos[8] = rs.getString("pecho_derecho_puntadas");
                datos[10] = rs.getString("manga_izquierda_nombre");
                datos[11] = rs.getString("manga_izquierda_puntadas");
                datos[13] = rs.getString("manga_derecha_nombre");
                datos[14] = rs.getString("manga_derecha_puntadas");
                datos[16] = rs.getString("espalda_nombre");
                datos[17] = rs.getString("espalda_puntadas");
                datos[19] = rs.getString("otra_ubicacion_puntadas");
                datos[20] = rs.getString("otra_ubicacion_nombre");
                datos[22] = rs.getString("otra_ubicacion2_puntadas");
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
            Object pechoizquierdoobject = rs.getString("pecho_izquierdo_puntadas");
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
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadapechoizquierdostring = String.format("%.02f ", costopuntadapechoizquierdo);
            datos[6] = costopuntadapechoizquierdostring;
            importepechoizquierdo = cantidadpechoizquierdoint * costopuntadapechoizquierdo;

            //PECHO DERECHO
            double costopuntadapechoderecho = 0.0;
            Object pechoderechoobject = rs.getString("pecho_derecho_puntadas");
            String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + pechoderechoobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql2);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadapechoderecho = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadapechoderechostring = String.format("%.02f ", costopuntadapechoderecho);
            //tabla.setValueAt(costopuntadapechoderechostring, i, 9);
            datos[9] = costopuntadapechoderechostring;
            importepechoderecho = cantidadpechoderechoint * costopuntadapechoderecho;

//MANGA IZQUIERDA
            double costopuntadamangaizquierda = 0.0;
            Object mangaizquierdaobject = rs.getString("manga_izquierda_puntadas");
            String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaizquierdaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql3);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaizquierda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadamangaizquierda);
           // tabla.setValueAt(costopuntadamangaizquierdastring, i, 12);
            datos[12] = costopuntadamangaizquierdastring;
            importemangaizquierda = cantidadmangaizquierdaint * costopuntadamangaizquierda;

//MANGA DERECHA
            double costopuntadamangaderecha = 0.0;
            Object mangaderechaobject = rs.getString("manga_derecha_puntadas");
            String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + mangaderechaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql4);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadamangaderecha = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadamangaderechastring = String.format("%.02f ", costopuntadamangaderecha);
            //tabla.setValueAt(costopuntadamangaderechastring, i, 15);
             datos[15] = costopuntadamangaderechastring;
            importemangaderecha = cantidadmangaderechaint * costopuntadamangaderecha;

            // ESPALDA
            double costopuntadaespalda = 0.0;
            Object espaldaobject = rs.getString("espalda_puntadas");
            String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + espaldaobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql5);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaespalda = Double.parseDouble(costostring);

                }
            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadaespaldastring = String.format("%.02f ", costopuntadaespalda);
            //tabla.setValueAt(costopuntadaespaldastring, i, 18);
            datos[18] = costopuntadaespaldastring;
            importeespalda = cantidadespaldaint * costopuntadaespalda;

            /// otra ubicacion
            double costopuntadaotraubicacion = 0.0;
            Object otraubicacionobject = rs.getString("otra_ubicacion_puntadas");

            String sql6 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacionobject + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql6);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs2.getString("costo");
                    costopuntadaotraubicacion = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            String costopuntadaotraubicacionstring = String.format("%.02f ", costopuntadaotraubicacion);
            //tabla.setValueAt(costopuntadaotraubicacionstring, i, 21);
            datos[21] = costopuntadaotraubicacionstring;

            importeotraubicacion = cantidadotraubicacionint * costopuntadaotraubicacion;

            /// otra ubicacion2
            double costopuntadaotraubicacion2 = 0.0;
            Object otraubicacion2object = datos[23] = rs.getString("otra_ubicacion2_puntadas");

            String sql7 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + otraubicacion2object + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql7);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next()) {

                    costostring = rs.getString("costo");
                    costopuntadaotraubicacion2 = Double.parseDouble(costostring);

                }

            } catch (Exception exx) {
                 JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

        for (int i = 0; i < tabladerecha.getRowCount(); i++) {

            Object cantidadobject = tabladerecha.getValueAt(i, 2);
            Object prenda = tabladerecha.getValueAt(i, 3);
            //int cantidad = Integer.parseInt(cantidadobject.toString());

            if (prenda.equals("Pantalon")) {

//lado IZQUIERDO
                double costopuntadaladoizquierdofrente = 0.0;
                Object ladoizquierdoobject = tabladerecha.getValueAt(i, 39);
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoizquierdofrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaladoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdofrente);
                tabladerecha.setValueAt(costopuntadaladoizquierdostring, i, 40);

                importeladoizquierdofrente = cantidadladoizquierdofrenteint * costopuntadaladoizquierdofrente;

                //LADO DERECHO
                double costopuntadaladoderechofrente = 0.0;
                Object ladoderechoobject = tabladerecha.getValueAt(i, 42);

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoderechofrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaladoderechostring = String.format("%.02f ", costopuntadaladoderechofrente);
                tabladerecha.setValueAt(costopuntadaladoderechostring, i, 43);

                importeladoderechofrente = cantidadladoderechofrenteint * costopuntadaladoderechofrente;

// ldo izquierdo atras
                double costopuntadaladoizquierdoatras = 0.0;

                Object ladoizquierdoatrasobject = tabladerecha.getValueAt(i, 45);

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoatrasobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoizquierdoatras = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadaladoizquierdoatras);
                tabladerecha.setValueAt(costopuntadamangaizquierdastring, i, 46);

                importeladoizquierdoatras = cantidadladoizquierdoatrasint * costopuntadaladoizquierdoatras;

                // lado derecho ATRAS
                double costopuntadaladoderechoatras = 0.0;

                Object ladoderechoatrasobject = tabladerecha.getValueAt(i, 48);

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoatrasobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoderechoatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaespaldastring = String.format("%.02f ", costopuntadaladoderechoatras);
                tabladerecha.setValueAt(costopuntadaespaldastring, i, 49);

                importeladoderechoatras = cantidadladoderechoatrasint * costopuntadaladoderechoatras;

                double sumabordados = importeladoizquierdoatras + importeladoizquierdofrente + importeladoderechoatras + importeladoderechofrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring, i, 62);

            }

        }

    }
    /////

    void datosponchados(int i) {

        DefaultTableModel modelo2 = (DefaultTableModel) tabladerecha.getModel();
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

                if (articulo.toString().startsWith("PONCHADO FACIL") || articulo.toString().contains("MODIFICACION DE PONCHADO FACIL")) {
                    articulobuscar = "PONCHADO FACIL";
                } else if (articulo.toString().startsWith("PONCHADO MEDIO") || articulo.toString().contains("MODIFICACION DE PONCHADO MEDIO")) {
                    articulobuscar = "PONCHADO MEDIO";
                } else if (articulo.toString().startsWith("PONCHADO DIFICIL") || articulo.toString().contains("MODIFICACION DE PONCHADO DIFICIL")) {
                    articulobuscar = "PONCHADO DIFICIL";
                } else if (articulo.toString().startsWith("PONCHADO EXTRA DIFICIL") || articulo.toString().contains("MODIFICACION DE PONCHADO EXTRA DIFICIL")) {
                    articulobuscar = "PONCHADO EXTRA DIFICIL";
                }
                else
                {
                    articulobuscar= articulo.toString();
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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

        DefaultTableModel modelo2 = (DefaultTableModel) tabladerecha.getModel();
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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

        for (int i = 0; i < tabladerecha.getRowCount(); i++) {

            Object cantidadobject = tabladerecha.getValueAt(i, 2);
            Object articulo = tabladerecha.getValueAt(i, 3);
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

                tabladerecha.setValueAt(articulobuscar, i, 5);

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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaponchadostring = String.format("%.02f ", costodelponchado);
                tabladerecha.setValueAt(costopuntadaponchadostring, i, 6);

                double importeponchado = cantidadponchadoint * costodelponchado;

                double sumabordados = importeponchado;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring, i, 62);

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
        
        
        for (int i = 0; i < tabladerecha.getRowCount(); i++) {

            Object cantidadobject = tabladerecha.getValueAt(i, 2);
            Object prenda = tabladerecha.getValueAt(i, 3);
            int cantidad = Integer.parseInt(cantidadobject.toString());

            if (prenda.equals("Gorra") ) {
                //lado IZQUIERDO

                double costopuntadaladoizquierdo = 0.0;
                Object ladoizquierdoobject = tabladerecha.getValueAt(i, 29);
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoizquierdo = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaladoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdo);
                tabladerecha.setValueAt(costopuntadaladoizquierdostring, i, 30);

                importeladoizquierdo = cantidadladoizquierdoint * costopuntadaladoizquierdo;

                //LADO DERECHO
                double costopuntadaladoderecho = 0.0;
                Object ladoderechoobject = tabladerecha.getValueAt(i, 32);

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaladoderecho = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaladoderechostring = String.format("%.02f ", costopuntadaladoderecho);
                tabladerecha.setValueAt(costopuntadaladoderechostring, i, 33);

                importeladoderecho = cantidadladoderechoint * costopuntadaladoderecho;

// FRENTE
                double costopuntadafrente = 0.0;

                Object frenteobject = tabladerecha.getValueAt(i, 26);

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
                tabladerecha.setValueAt(costopuntadafrentestring, i, 27);

                importefrente = cantidadfrenteint * costopuntadafrente;

                // ATRAS
                double costopuntadaatras = 0.0;

                Object atrasobject = tabladerecha.getValueAt(i, 35);

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + atrasobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadaatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaespaldastring = String.format("%.02f ", costopuntadaatras);
                tabladerecha.setValueAt(costopuntadaespaldastring, i, 36);

                importeatras = cantidadatrasint * costopuntadaatras;

                double sumabordados = importeladoizquierdo + importeladoderecho + importefrente + importeatras;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring, i, 62);

            }

        }

    }

    void calcularcostosdebordadosportanombre() {

        double importefrente = 0.0;
        String costostring = "0";

        for (int i = 0; i < tabladerecha.getRowCount(); i++) {

            Object cantidadobject = tabladerecha.getValueAt(i, 2);
            Object cliente = tabladerecha.getValueAt(i, 1);
            int cantidad = Integer.parseInt(cantidadobject.toString());

            if (cliente.equals("porta nombre multiple") || cliente.equals("porta nombre")) {

                // FRENTE
                double costopuntadafrente = 0.0;
                Object frenteobject = tabladerecha.getValueAt(i, 26);

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
                tabladerecha.setValueAt(costopuntadafrentestring, i, 27);
                importefrente = cantidad * costopuntadafrente;

                double sumabordados = importefrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring, i, 62);

            }

        }

    }

    void calcularcostosdebordadoscorbata() {

        double importeladoizquierdo = 0.0;
        double importeladoderecho = 0.0;
        double importefrente = 0.0;
        double importeatras = 0.0;

        String costostring = "0";

        for (int i = 0; i < tabladerecha.getRowCount(); i++) {

            Object cantidadobject = tabladerecha.getValueAt(i, 2);
            Object prenda = tabladerecha.getValueAt(i, 3);
            int cantidad = Integer.parseInt(cantidadobject.toString());

            if (prenda.equals("Corbata")) {

                // FRENTE
                double costopuntadafrente = 0.0;

                Object frenteobject = tabladerecha.getValueAt(i, 26);

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadafrente);
                tabladerecha.setValueAt(costopuntadamangaizquierdastring, i, 27);

                importefrente = cantidad * costopuntadafrente;
                double sumabordados = importefrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring, i, 62);

            }

        }

    }

    void calcularcostosdebordadosparches() {

        double importebordado = 0.0;

        String costostring = "0";
        String costodelapuntada = "";

        for (int i = 0; i < tabladerecha.getRowCount(); i++) {

            Object cantidadobject = tabladerecha.getValueAt(i, 2);
            Object prenda = tabladerecha.getValueAt(i, 3);
            //int cantidad = Integer.parseInt(cantidadobject.toString());
            int cantidadparcheint = Integer.parseInt(cantidadparche);

            if (prenda.equals("Parche")) {

                double costopuntada = 0.0;
                Object puntadaobject = tabladerecha.getValueAt(i, 51);
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadaobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costopuntada = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                double sumabordados = costopuntada * cantidadparcheint;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                tabladerecha.setValueAt(costostring, i, 52);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring, i, 62);

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

      
        

        DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();

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

        String sql = "Select fecha,cliente,cantidad,prenda,frente_nombre,frente_puntadas,frente_cantidad,lado_izquierdo_nombre,lado_izquierdo_puntadas,lado_izquierdo_cantidad,lado_derecho_nombre,lado_derecho_puntadas,lado_derecho_cantidad,atras_nombre,atras_puntadas,atras_cantidad,aplicacion_frente,numero_venta from historial_ordenes_gorra where (estatus_orden = 'generada' OR estatus_orden = 'realizada' ) and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

        int ultimafila = 0;

        ultimafila = tabladerecha.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad");
                String prenda = rs.getString("prenda");
                String frente = rs.getString("frente_puntadas");
                String puntadasfrente = rs.getString("frente_puntadas");
                cantidadfrente = rs.getString("frente_cantidad");
                String ladoizquierdo = rs.getString("lado_izquierdo_puntadas");
                String puntadasladoizquierdo = rs.getString("lado_izquierdo_puntadas");
                cantidadladoizquierdo = rs.getString("lado_izquierdo_cantidad");
                String ladoderecho = rs.getString("lado_derecho_puntadas");
                String puntadasladoderecho = rs.getString("lado_derecho_puntadas");
                cantidadladoderecho = rs.getString("lado_derecho_cantidad");
                String atras = rs.getString("atras_puntadas");
                String puntadasatras = rs.getString("atras_puntadas");
                cantidadatras = rs.getString("atras_cantidad");
                String aplicacionfrente = rs.getString("aplicacion_frente");
                String numeroventa = rs.getString("numero_venta");

                modelo.addRow(new Object[]{});

                tabladerecha.setValueAt(fecha, ultimafila, 0);
                tabladerecha.setValueAt(cliente, ultimafila, 1);
                tabladerecha.setValueAt(cantidad, ultimafila, 2);
                tabladerecha.setValueAt(prenda, ultimafila, 3);
                tabladerecha.setValueAt(frente, ultimafila, 25);
                tabladerecha.setValueAt(puntadasfrente, ultimafila, 26);
                tabladerecha.setValueAt(ladoizquierdo, ultimafila, 28);
                tabladerecha.setValueAt(puntadasladoizquierdo, ultimafila, 29);
                tabladerecha.setValueAt(ladoderecho, ultimafila, 31);
                tabladerecha.setValueAt(puntadasladoderecho, ultimafila, 32);
                tabladerecha.setValueAt(atras, ultimafila, 34);
                tabladerecha.setValueAt(puntadasatras, ultimafila, 35);
                tabladerecha.setValueAt(aplicacionfrente, ultimafila, 57);
                tabladerecha.setValueAt(numeroventa, ultimafila, 63);
                
                
     
                ///Calculo 
                        
                int cantidadfrenteint = Integer.parseInt(cantidadfrente);
                int cantidadladoderechoint = Integer.parseInt(cantidadladoderecho);
                int cantidadladoizquierdoint = Integer.parseInt(cantidadladoizquierdo);
                int cantidadatrasint = Integer.parseInt(cantidadatras);

                int cantidadint = Integer.parseInt(cantidad.toString());

                double costopuntadaladoizquierdo = 0.0;
                Object ladoizquierdoobject = rs.getString("lado_izquierdo_puntadas");
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoizquierdo = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaladoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdo);
                tabladerecha.setValueAt(costopuntadaladoizquierdostring, ultimafila, 30);

                importeladoizquierdo = cantidadladoizquierdoint * costopuntadaladoizquierdo;

                //LADO DERECHO
                double costopuntadaladoderecho = 0.0;
                Object ladoderechoobject = rs.getString("lado_derecho_puntadas");

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoderecho = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaladoderechostring = String.format("%.02f ", costopuntadaladoderecho);
                tabladerecha.setValueAt(costopuntadaladoderechostring, ultimafila, 33);

                importeladoderecho = cantidadladoderechoint * costopuntadaladoderecho;

// FRENTE
                double costopuntadafrente = 0.0;

                Object frenteobject = rs.getString("frente_puntadas");

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
                tabladerecha.setValueAt(costopuntadafrentestring, ultimafila, 27);
                importefrente = cantidadfrenteint * costopuntadafrente;

                // ATRAS
                double costopuntadaatras = 0.0;

                Object atrasobject = rs.getString("atras_puntadas");

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + atrasobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaespaldastring = String.format("%.02f ", costopuntadaatras);
                tabladerecha.setValueAt(costopuntadaespaldastring, ultimafila, 36);

                importeatras = cantidadatrasint * costopuntadaatras;

                double sumabordados = importeladoizquierdo + importeladoderecho + importefrente + importeatras;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring, ultimafila, 62);

                        
                        
                ///        
                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println();
        }

    }

    void datostablahistorialordenesgorrarecibidas(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();

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

        String sql = "Select fecha,cliente,cantidad,prenda,frente_nombre,frente_puntadas,lado_izquierdo_nombre,lado_izquierdo_puntadas,lado_derecho_nombre,lado_derecho_puntadas,atras_nombre,atras_puntadas,aplicacion_frente from historial_ordenes_gorra_recibidas where (estatus_orden = 'generada' OR estatus_orden = 'realizada' ) and fecha = '" + fechabusqueda + "'  order by codigo ";

        int ultimafila = 0;

        ultimafila = tabladerecha.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad");
                String prenda = rs.getString("prenda");
                String frente = rs.getString("frente_puntadas");
                String puntadasfrente = rs.getString("frente_puntadas");
                String ladoizquierdo = rs.getString("lado_izquierdo_puntadas");
                String puntadasladoizquierdo = rs.getString("lado_izquierdo_puntadas");
                String ladoderecho = rs.getString("lado_derecho_puntadas");
                String puntadasladoderecho = rs.getString("lado_derecho_puntadas");
                String atras = rs.getString("atras_puntadas");
                String puntadasatras = rs.getString("atras_puntadas");
                String aplicacionfrente = rs.getString("aplicacion_frente");

                modelo.addRow(new Object[]{});

                tabladerecha.setValueAt(fecha, ultimafila, 0);
                tabladerecha.setValueAt(cliente, ultimafila, 1);
                tabladerecha.setValueAt(cantidad, ultimafila, 2);
                tabladerecha.setValueAt(prenda, ultimafila, 3);
                tabladerecha.setValueAt(frente, ultimafila, 25);
                tabladerecha.setValueAt(puntadasfrente, ultimafila, 26);
                tabladerecha.setValueAt(ladoizquierdo, ultimafila, 28);
                tabladerecha.setValueAt(puntadasladoizquierdo, ultimafila, 29);
                tabladerecha.setValueAt(ladoderecho, ultimafila, 31);
                tabladerecha.setValueAt(puntadasladoderecho, ultimafila, 32);
                tabladerecha.setValueAt(atras, ultimafila, 34);
                tabladerecha.setValueAt(puntadasatras, ultimafila, 35);
                tabladerecha.setValueAt(aplicacionfrente, ultimafila, 57);
                
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
                Object ladoizquierdoobject = rs.getString("lado_izquierdo_puntadas");
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoizquierdoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoizquierdo = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaladoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdo);
                tabladerecha.setValueAt(costopuntadaladoizquierdostring, ultimafila, 30);

                importeladoizquierdo = cantidadladoizquierdoint * costopuntadaladoizquierdo;

                //LADO DERECHO
                double costopuntadaladoderecho = 0.0;
                Object ladoderechoobject = rs.getString("lado_derecho_puntadas");

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + ladoderechoobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaladoderecho = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaladoderechostring = String.format("%.02f ", costopuntadaladoderecho);
                tabladerecha.setValueAt(costopuntadaladoderechostring, ultimafila, 33);

                importeladoderecho = cantidadladoderechoint * costopuntadaladoderecho;

// FRENTE
                double costopuntadafrente = 0.0;

                Object frenteobject = rs.getString("frente_puntadas");

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + frenteobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadafrente = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
                tabladerecha.setValueAt(costopuntadafrentestring, ultimafila, 27);
                importefrente = cantidadfrenteint * costopuntadafrente;

                // ATRAS
                double costopuntadaatras = 0.0;

                Object atrasobject = rs.getString("atras_puntadas");

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + atrasobject + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadaatras = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaespaldastring = String.format("%.02f ", costopuntadaatras);
                tabladerecha.setValueAt(costopuntadaespaldastring, ultimafila, 36);

                importeatras = cantidadatrasint * costopuntadaatras;

                double sumabordados = importeladoizquierdo + importeladoderecho + importefrente + importeatras;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring, ultimafila, 62);

                        
                        
                ///        

                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        

    }

    void datostablahistorialordenespantalon(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();

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

        String sql = "Select fecha,cliente,cantidad,prenda,lado_izquierdo_frente_nombre,lado_izquierdo_frente_nombre,lado_izquierdo_frente_puntadas,"
                + "lado_derecho_frente_cantidad,lado_derecho_frente_nombre,lado_derecho_frente_nombre,"
                + "lado_izquierdo_atras_cantidad,lado_izquierdo_atras_nombre,lado_izquierdo_atras_puntadas,"
                + "lado_derecho_atras_cantidad,lado_derecho_atras_nombre,lado_derecho_atras_puntadas,numero_venta from historial_ordenes_pantalon where (estatus_orden = 'generada' OR estatus_orden = 'realizada' ) and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

        int ultimafila = 0;

        ultimafila = tabladerecha.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad");
                String prenda = rs.getString("prenda");

  
    
                
                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente_puntadas");
                String puntadasladoizquierdofrente = rs.getString("lado_izquierdo_frente_puntadas");
                cantidadladoizquierdofrente= rs.getString("lado_izquierdo_frente_cantidad");
                
                
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras_puntadas");
                String puntadasladoizquierdoatras = rs.getString("lado_izquierdo_atras_puntadas");
                cantidadladoizquierdoatras= rs.getString("lado_izquierdo_atras_cantidad");

                String ladoderechofrente = rs.getString("lado_derecho_frente_puntadas");
                String puntadasladoderechofrente = rs.getString("lado_derecho_frente_nombre");
                cantidadladoderechofrente= rs.getString("lado_derecho_frente_cantidad");
                
                String ladoderechoatras = rs.getString("lado_derecho_atras_puntadas");
                String puntadasladoderechoatras = rs.getString("lado_derecho_atras_puntadas");
                cantidadladoderechoatras= rs.getString("lado_derecho_atras_cantidad");
                
                String numeroventa = rs.getString("numero_venta");

                modelo.addRow(new Object[]{});

                tabladerecha.setValueAt(fecha, ultimafila, 0);
                tabladerecha.setValueAt(cliente, ultimafila, 1);
                tabladerecha.setValueAt(cantidad, ultimafila, 2);
                tabladerecha.setValueAt(prenda, ultimafila, 3);

                tabladerecha.setValueAt(ladoizquierdofrente, ultimafila, 38);
                tabladerecha.setValueAt(puntadasladoizquierdofrente, ultimafila, 39);
                tabladerecha.setValueAt(ladoderechofrente, ultimafila, 41);
                tabladerecha.setValueAt(puntadasladoderechofrente, ultimafila, 42);

                tabladerecha.setValueAt(ladoizquierdoatras, ultimafila, 44);
                tabladerecha.setValueAt(puntadasladoizquierdoatras, ultimafila, 45);
                tabladerecha.setValueAt(ladoderechoatras, ultimafila, 47);
                tabladerecha.setValueAt(puntadasladoderechoatras, ultimafila, 48);

                tabladerecha.setValueAt(numeroventa, ultimafila, 63);
                
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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaladoizquierdostring = String.format("%.02f ", costopuntadaladoizquierdofrente);
                tabladerecha.setValueAt(costopuntadaladoizquierdostring, ultimafila, 40);
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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaladoderechostring = String.format("%.02f ", costopuntadaladoderechofrente);
                tabladerecha.setValueAt(costopuntadaladoderechostring, ultimafila, 43);
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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadaladoizquierdoatras);
                tabladerecha.setValueAt(costopuntadamangaizquierdastring, ultimafila, 46);
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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadaespaldastring = String.format("%.02f ", costopuntadaladoderechoatras);
                tabladerecha.setValueAt(costopuntadaespaldastring, ultimafila, 49);
                importeladoderechoatras = cantidadladoderechoatrasint * costopuntadaladoderechoatras;

                double sumabordados = importeladoizquierdoatras + importeladoizquierdofrente + importeladoderechoatras + importeladoderechofrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring, ultimafila, 62);

                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        

    }

    void datostablahistorialordenespantalonrecibidos(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();

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

        String sql = "Select fecha,cliente,cantidad,prenda,lado_izquierdo_frente_nombre,lado_izquierdo_frente_puntadas,lado_derecho_frente_nombre,lado_derecho_frente_nombre,lado_izquierdo_atras_nombre,lado_izquierdo_atras_puntadas,lado_derecho_atras_nombre,lado_derecho_atras_puntadas from historial_ordenes_pantalon_recibidas where (estatus_orden = 'generada' OR estatus_orden = 'realizada' )  and fecha = '" + fechabusqueda + "'  order by codigo ";

        int ultimafila = 0;

        ultimafila = tabladerecha.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad");
                String prenda = rs.getString("prenda");

                String ladoizquierdofrente = rs.getString("lado_izquierdo_frente_puntadas");
                String puntadasladoizquierdofrente = rs.getString("lado_izquierdo_frente_puntadas");
                String ladoizquierdoatras = rs.getString("lado_izquierdo_atras_puntadas");
                String puntadasladoizquierdoatras = rs.getString("lado_izquierdo_atras_puntadas");

                String ladoderechofrente = rs.getString("lado_derecho_frente_puntadas");
                String puntadasladoderechofrente = rs.getString("lado_derecho_frente_nombre");
                String ladoderechoatras = rs.getString("lado_derecho_atras_puntadas");
                String puntadasladoderechoatras = rs.getString("lado_derecho_atras_puntadas");

                modelo.addRow(new Object[]{});

                tabladerecha.setValueAt(fecha, ultimafila, 0);
                tabladerecha.setValueAt(cliente, ultimafila, 1);
                tabladerecha.setValueAt(cantidad, ultimafila, 2);
                tabladerecha.setValueAt(prenda, ultimafila, 3);

                tabladerecha.setValueAt(ladoizquierdofrente, ultimafila, 35);
                tabladerecha.setValueAt(puntadasladoizquierdofrente, ultimafila, 39);
                tabladerecha.setValueAt(ladoderechofrente, ultimafila, 41);
                tabladerecha.setValueAt(puntadasladoderechofrente, ultimafila, 42);

                tabladerecha.setValueAt(ladoizquierdoatras, ultimafila, 44);
                tabladerecha.setValueAt(puntadasladoizquierdoatras, ultimafila, 45);
                tabladerecha.setValueAt(ladoderechoatras, ultimafila, 47);
                tabladerecha.setValueAt(puntadasladoderechoatras, ultimafila, 48);

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

        DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();

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

        String sql = "Select fecha,cliente,cantidad,parche_puntadas,articulo,parche_nombre,aplicacion,numero_venta,parche_cantidad from historial_ordenes_parche where (estatus_orden = 'generada' OR estatus_orden = 'realizada' ) and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

        int ultimafila = 0;

        ultimafila = tabladerecha.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("cantidad");
                String prenda = "Parche";

                String parche = rs.getString("parche_nombre");
                String puntadas = rs.getString("parche_puntadas");
                String aplicacion = rs.getString("aplicacion");

                String numeroventa = rs.getString("numero_venta");
                cantidadparche =rs.getString("parche_cantidad");

                modelo.addRow(new Object[]{});

                tabladerecha.setValueAt(fecha, ultimafila, 0);
                tabladerecha.setValueAt(cliente, ultimafila, 1);
                tabladerecha.setValueAt(cantidad, ultimafila, 2);
                tabladerecha.setValueAt(prenda, ultimafila, 3);
                tabladerecha.setValueAt(parche, ultimafila, 50);
                tabladerecha.setValueAt(puntadas, ultimafila, 51);
                tabladerecha.setValueAt(numeroventa, ultimafila, 63);
                
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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                double sumabordados = costopuntada * cantidadparcheint;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                tabladerecha.setValueAt(costostring, ultimafila, 52);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring,ultimafila, 62);

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

        DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();

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

        ultimafila = tabladerecha.getRowCount();

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

                tabladerecha.setValueAt(fecha, ultimafila, 0);
                tabladerecha.setValueAt(cliente, ultimafila, 1);
                tabladerecha.setValueAt(cantidad, ultimafila, 2);
                tabladerecha.setValueAt(prenda, ultimafila, 3);
                tabladerecha.setValueAt(frente, ultimafila, 25);
                tabladerecha.setValueAt(puntadasfrente, ultimafila, 26);
                

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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadafrentestring = String.format("%.02f ", costopuntadafrente);
                tabladerecha.setValueAt(costopuntadafrentestring, ultimafila, 27);

                importefrente = cantidadfrenteint * costopuntadafrente;

              

                double sumabordados =   importefrente ;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                tabladerecha.setValueAt(sumabordadosstring, ultimafila, 62);

                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println();
        }

    }

    void datostablaordeninternaparche(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();

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

        ultimafila = tabladerecha.getRowCount();

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

                tabladerecha.setValueAt(fecha, ultimafila, 0);
                tabladerecha.setValueAt(cliente, ultimafila, 1);
                tabladerecha.setValueAt(cantidad, ultimafila, 2);
                tabladerecha.setValueAt(prenda, ultimafila, 3);
                tabladerecha.setValueAt(frente, ultimafila, 50);
                tabladerecha.setValueAt(puntadasfrente, ultimafila, 51);

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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                double sumabordados = costopuntada * cantidadparcheint;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                tabladerecha.setValueAt(costostring, ultimafila, 52);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring,ultimafila, 62);

                /////
                
                ultimafila = ultimafila + 1;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println();
        }

        

    }

    void datostablaportanombre(int i) {

        DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();
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

        ultimafila = tabladerecha.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = "porta nombre";
                String cantidad = rs.getString("cantidad");
                String prenda = rs.getString("prenda");
                String frente = "PORTA NOMBRE";
                String puntadasfrente = "BORDADO DE 7,500 A 10,000 PUNTADAS";
                String numeroventa = rs.getString("numero_venta");

                modelo.addRow(new Object[]{});

                tabladerecha.setValueAt(fecha, ultimafila, 0);
                tabladerecha.setValueAt(cliente, ultimafila, 1);
                tabladerecha.setValueAt(cantidad, ultimafila, 2);
                tabladerecha.setValueAt(prenda, ultimafila, 3);
                tabladerecha.setValueAt(frente, ultimafila, 25);
                tabladerecha.setValueAt(puntadasfrente, ultimafila, 26);
                tabladerecha.setValueAt(numeroventa, ultimafila, 63);
                
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

        DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();

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

        ultimafila = tabladerecha.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = "porta nombre multiple";
                String cantidad = rs.getString("cantidad_total");
                String prenda = rs.getString("prenda");
                String frente = "PORTA NOMBRE MULTIPLE";
                String puntadasfrente = "BORDADO DE 7,500 A 10,000 PUNTADAS";
                String numeroventa = rs.getString("numero_venta");;

                modelo.addRow(new Object[]{});

                tabladerecha.setValueAt(fecha, ultimafila, 0);
                tabladerecha.setValueAt(cliente, ultimafila, 1);
                tabladerecha.setValueAt(cantidad, ultimafila, 2);
                tabladerecha.setValueAt(prenda, ultimafila, 3);
                tabladerecha.setValueAt(frente, ultimafila, 25);
                tabladerecha.setValueAt(puntadasfrente, ultimafila, 26);
                tabladerecha.setValueAt(numeroventa, ultimafila, 63);

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

        DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();

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

        String sql = "Select fecha,cliente,frente_cantidad,articulo,frente_puntadas,frente_puntadas,numero_venta from historial_ordenes_corbata where (estatus_orden = 'generada' or estatus_orden = 'realizada') and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";
        ultimafila = tabladerecha.getRowCount();

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String fecha = rs.getString("fecha");
                String cliente = rs.getString("cliente");
                String cantidad = rs.getString("frente_cantidad");
                String prenda = rs.getString("articulo");

                String frente = rs.getString("frente_puntadas");
                String puntadasfrente = rs.getString("frente_puntadas");
                String numeroventa = rs.getString("numero_venta");

                modelo.addRow(new Object[]{});

                tabladerecha.setValueAt(fecha, ultimafila, 0);
                tabladerecha.setValueAt(cliente, ultimafila, 1);
                tabladerecha.setValueAt(cantidad, ultimafila, 2);
                tabladerecha.setValueAt(prenda, ultimafila, 3);
                tabladerecha.setValueAt(frente, ultimafila, 25);
                tabladerecha.setValueAt(puntadasfrente, ultimafila, 26);
                tabladerecha.setValueAt(numeroventa, ultimafila, 63);
                
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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costopuntadamangaizquierdastring = String.format("%.02f ", costopuntadafrente);
                tabladerecha.setValueAt(costopuntadamangaizquierdastring, ultimafila, 27);

                importefrente = cantidadint * costopuntadafrente;
                double sumabordados = importefrente;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                if(sumabordadosstring.equals("3.30"))
                {
                    int a = 0;
                }
                tabladerecha.setValueAt(sumabordadosstring, ultimafila, 62);

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
            DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();
            int totalrenglones = tabladerecha.getRowCount();

            for (int i = 0; totalrenglones > i; i++) {
                modelo.removeRow(0);
            }

        } catch (Exception e) {
             JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">Error al limpiar la tabla.");
        }

    }

    void limpiartablafechas() {

        try {
            DefaultTableModel modelo = (DefaultTableModel) tablaizquierda.getModel();
            int totalrenglones = tablaizquierda.getRowCount();

            for (int i = 0; totalrenglones > i; i++) {
                modelo.removeRow(0);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">Error al limpiar la tabla.");
        }

    }
    
    
    
    
    
    
    
    
    

    void datostablaizquierda() 
    {

        DefaultTableModel modelotabla = (DefaultTableModel) tablaizquierda.getModel();
        String[] datos = new String[3];

        for (int i = 1; i <= diafinal; i++) {
            
            
            
            String color = "blanco";
            
            Calendar now = Calendar.getInstance();
      
        int mesdelaño = now.get(Calendar.MONTH)+1;
        String messtring = String.valueOf(mesdelaño);
        
        int añoactual = now.get(Calendar.YEAR);
        String añoactualstring = String.valueOf(añoactual);
        
        String dia = String.valueOf(i);
        
       Date fechadate = null;
            
           String fechastring =  añoactualstring.concat("-").concat(messtring).concat("-").concat(dia);
       
           
           
        String formato = "yyyy-MM-dd";

        DateFormat dateFormat = new SimpleDateFormat(formato);

        try {
            fechadate = dateFormat.parse(fechastring);
            System.out.println(fechadate);
        } catch (ParseException e) {
            System.out.println("Error al convertir la cadena a fecha");
            e.printStackTrace();
           
           
        }
          
      
       
          DateFormat diaSemanaFormat = new SimpleDateFormat("EEEE");
            String diaSemana = diaSemanaFormat.format(fechadate);
    
          
                 if (diaSemana.equals("sábado") || diaSemana.equals("domingo"))
            {
                color = "rojo";
            }
           
           else
                  {
                    color = "blanco";   
                  }
        
        
            
            

            datos[0] = String.valueOf(i);
            datos[1] = "0.00";
            datos[2] = color;
            
            
            modelotabla.addRow(datos);

            if (i == 1 || i == 31) 
            {
                int a = 0;
            }

            
            
            
            
            calculodelassumasdelosbordadostablaizquierda((int) i);

        }

        
        
        
        
        
        
        double sumadouble = 0.0;

        for (int i = 0; i < tablaizquierda.getRowCount(); i++) {

            String importepordiastring = tablaizquierda.getValueAt(i, 1).toString();
            double importepordiadouble = Double.parseDouble(importepordiastring);

            sumadouble = sumadouble + importepordiadouble;

        }

        lbsuma.setText(String.format("%.2f", sumadouble));

        
        
        
        
         bordadosreportegeneralColorear ventana = new bordadosreportegeneralColorear(5);
        tablaizquierda.setDefaultRenderer(Object.class, ventana);
        
      
        
    }

        
        
        
        
        
        
        
        
        
    //////
    void calculodelassumasdelosbordadostablaizquierda(int i) {

         
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
        
        double sumatotaldelosbordadosdistinta = 0;

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

        
        
        
        ////////////CAMISA LOCAL
        
        String sql = "Select codigo,fecha,cliente,cantidad,prenda,pecho_izquierdo_cantidad,pecho_izquierdo_nombre,pecho_izquierdo_puntadas,"
                + "pecho_derecho_cantidad,pecho_derecho_nombre,pecho_derecho_puntadas,"
                + "manga_izquierda_cantidad,manga_izquierda_nombre,manga_izquierda_puntadas,"
                + "manga_derecha_cantidad,manga_derecha_nombre,manga_derecha_puntadas,"
                + "espalda_cantidad,espalda_nombre,espalda_puntadas,"
                + "aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,"
                + "otra_ubicacion_puntadas,otra_ubicacion_cantidad,otra_ubicacion2_puntadas,otra_ubicacion2_cantidad from historial_ordenes_camisa where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = 'Esta sucursal' and (pecho_izquierdo_fecha = '" + fechabusqueda + "' or pecho_derecho_fecha = '" + fechabusqueda + "' or manga_izquierda_fecha = '" + fechabusqueda + "'  or manga_derecha_fecha = '" + fechabusqueda + "'  or espalda_fecha = '" + fechabusqueda + "'  or otra_ubicacion_fecha = '" + fechabusqueda + "'  or otra_ubicacion2_fecha = '" + fechabusqueda + "') order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                
              
                cantidadbordados = rs.getString("cantidad");
                pechoizquierdo = rs.getString("pecho_izquierdo_puntadas");
                cantidadpechoizquierdo = rs.getString("pecho_izquierdo_cantidad");
                pechoderecho = rs.getString("pecho_derecho_puntadas");
                cantidadpechoderecho = rs.getString("pecho_derecho_cantidad");
                mangaizquierda = rs.getString("manga_izquierda_puntadas");
                cantidadmangaizquierda = rs.getString("manga_izquierda_cantidad");
                mangaderecha = rs.getString("manga_derecha_puntadas");
                cantidadmangaderecha = rs.getString("manga_derecha_cantidad");
                espalda = rs.getString("espalda_puntadas");
                cantidadespalda = rs.getString("espalda_cantidad");
                otraubicacion = rs.getString("otra_ubicacion_puntadas");
                cantidadotraubicacion = rs.getString("otra_ubicacion_cantidad");
                otraubicacion2 = rs.getString("otra_ubicacion2_puntadas");
                cantidadotraubicacion2 = rs.getString("otra_ubicacion2_cantidad");

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
                     JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
        String sqlcamisasrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,pecho_izquierdo_nombre,pecho_izquierdo_puntadas,pecho_derecho_nombre,pecho_derecho_puntadas,manga_izquierda_nombre,manga_izquierda_puntadas,manga_derecha_nombre,manga_derecha_puntadas,espalda_nombre,espalda_puntadas,aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,otra_ubicacion_puntadas from historial_ordenes_camisa_recibidas where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and (pecho_izquierdo_fecha = '" + fechabusqueda + "' or pecho_derecho_fecha = '" + fechabusqueda + "' or manga_izquierda_fecha = '" + fechabusqueda + "'  or manga_derecha_fecha = '" + fechabusqueda + "'  or espalda_fecha = '" + fechabusqueda + "'  or otra_ubicacion_fecha = '" + fechabusqueda + "'  or otra_ubicacion2_fecha = '" + fechabusqueda + "') order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcamisasrecibidas);

            while (rs.next()) {

                cantidadbordadosrecibidos = rs.getString("cantidad");
                pechoizquierdorecibidos = rs.getString("pecho_izquierdo_puntadas");
                pechoderechorecibidos = rs.getString("pecho_derecho_puntadas");
                mangaizquierdarecibidos = rs.getString("manga_izquierda_puntadas");
                mangaderecharecibidos = rs.getString("manga_derecha_puntadas");
                espaldarecibidos = rs.getString("espalda_puntadas");
                otraubicacionrecibidos = rs.getString("otra_ubicacion_puntadas");
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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
        String sqlgorras = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_puntadas,lado_derecho_puntadas,frente_puntadas,atras_puntadas,aplicacion_frente from historial_ordenes_gorra where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlgorras);

            while (rs.next()) {

                cantidadbordados = rs.getString("cantidad");
                ladoizquierdogorra = rs.getString("lado_izquierdo_puntadas");
                ladoderechogorra = rs.getString("lado_derecho_puntadas");
                frentegorra = rs.getString("frente_puntadas");
                atrasgorra = rs.getString("atras_puntadas");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
        String sqlgorrasrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_puntadas,lado_derecho_puntadas,frente_puntadas,atras_puntadas,aplicacion_frente from historial_ordenes_gorra_recibidas where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlgorrasrecibidas);

            while (rs.next()) {

                cantidadbordadosrecibidos = rs.getString("cantidad");
                ladoizquierdogorrarecibidas = rs.getString("lado_izquierdo_puntadas");
                ladoderechogorrarecibidas = rs.getString("lado_derecho_puntadas");
                frentegorrarecibidas = rs.getString("frente_puntadas");
                atrasgorrarecibidas = rs.getString("atras_puntadas");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
        String sqlpantalon = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_frente_puntadas,lado_derecho_frente_nombre,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas from historial_ordenes_pantalon where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlpantalon);

            while (rs.next()) {

                cantidadbordados = rs.getString("cantidad");
                ladoizquierdofrente = rs.getString("lado_izquierdo_frente_puntadas");
                ladoderechofrente = rs.getString("lado_derecho_frente_nombre");
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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
        String sqlpantalonrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_frente_puntadas,lado_derecho_frente_nombre,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas from historial_ordenes_pantalon_recibidas where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlpantalonrecibidas);

            while (rs.next()) {

                cantidadbordados = rs.getString("cantidad");
                ladoizquierdofrenterecibidas = rs.getString("lado_izquierdo_frente_puntadas");
                ladoderechofrenterecibidas = rs.getString("lado_derecho_frente_nombre");
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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

        String sqlparches = "Select codigo,fecha,cliente,cantidad,parche_puntadas,parche_nombre from historial_ordenes_parche where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlparches);

            while (rs.next()) {

                cantidadbordados = rs.getString("cantidad");
                puntadasparche = rs.getString("parche_puntadas");

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

        String sqlparchesrecibidos = "Select codigo,fecha,cliente,cantidad,parche_puntadas from historial_ordenes_parche_recibidas where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and fecha = '" + fechabusqueda + "' order by codigo ";

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
        String sqlcorbatas = "Select codigo,fecha,cliente,cantidad_bordados,prenda,frente_puntadas from historial_ordenes_corbata where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                puntadasfrenteportanombre = "BORDADO DE 7,500 A 10,000 PUNTADAS";

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                puntadasfrenteportanombremultiple = "BORDADO DE 7,500 A 10,000 PUNTADAS";

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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

        String sqlponchados = "Select numero,fecha,cliente,articulo,cantidad  from historial_ordenes_ponchados where estatus_orden = 'realizada totalmente' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

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
                     else 
                    {
                        articulobuscar = nombrearticulo.toString();
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
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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
  
        
        cantidadfotomontajesint = 0;
        costofotomontajesdouble = 0.0;
        
        String sqlfotomontajes = "SELECT fotomontaje \n" +
                                 "FROM historial_fotomontajes \n" +
                                  "WHERE fecha = '" + fechabusqueda + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlfotomontajes);

            while (rs.next())
            {

                cantidadfotomontajes = rs.getString("fotomontaje");
                
                if (cantidadfotomontajes == null || cantidadfotomontajes.equals(""))
                {
                    cantidadfotomontajes = "0";
                }

                cantidadfotomontajesint = Integer.parseInt(cantidadfotomontajes);

               

                String sqlponchadoscosto = "SELECT costo from catalogo_costos_bordado where puntadas = 'FOTOMONTAJE'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sqlponchadoscosto);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) 
                    {

                        costostring = rs3.getString("costo");
                        costofotomontajesdouble = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }
                
                

                importefotomontajes = cantidadfotomontajesint * costofotomontajesdouble;

                double sumafotomontajes = importefotomontajes;
                sumatotaldelosfotomontajes = sumatotaldelosfotomontajes + importefotomontajes;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
       
        
       
       
       ////
       
        String distinta1 = "";
        String distinta2 = "";
        String distinta3 = "";
        String distinta4 = "";
        String distinta5 = "";
        String distinta6 = "";
        String distinta7 = "";

        String cantidaddistinta1 = "";
        String cantidaddistinta2 = "";
        String cantidaddistinta3 = "";
        String cantidaddistinta4 = "";
        String cantidaddistinta5 = "";
        String cantidaddistinta6 = "";
        String cantidaddistinta7 = "";
        
        String aplicaciondistinta1 ="";
        String aplicaciondistinta2 ="";
        String aplicaciondistinta3 ="";
        String aplicaciondistinta4 ="";
        String aplicaciondistinta5 ="";
        String aplicaciondistinta6 ="";
        String aplicaciondistinta7 ="";
        
        
        
       
        
        String sqldistinta = "Select codigo,tipo,estatus_orden,numero,numero_venta,fecha,hora,cliente,tipo,identificador_prenda,estatus_orden,estatus_entrega,articulo,cantidad,prenda,cantidad_bordados,nombre_persona_solicita,celular,fecha_entrega,hora_entrega,observacion,\n" +
"distinta1,distinta1_ubicacion,distinta1_nombre,distinta1_cantidad,distinta1_aplicacion,distinta1_aplicacion_color,\n" +
"distinta2,distinta2_ubicacion,distinta2_nombre,distinta2_cantidad,distinta2_aplicacion,distinta2_aplicacion_color, \n" +
"distinta3,distinta3_ubicacion,distinta3_nombre,distinta3_cantidad,distinta3_aplicacion,distinta3_aplicacion_color, \n" +
"distinta4,distinta4_ubicacion,distinta4_nombre,distinta4_cantidad,distinta4_aplicacion,distinta4_aplicacion_color, \n" +
"distinta5,distinta5_ubicacion,distinta5_nombre,distinta5_cantidad,distinta5_aplicacion,distinta5_aplicacion_color,\n" +
"distinta6,distinta6_ubicacion,distinta6_nombre,distinta6_cantidad,distinta6_aplicacion,distinta6_aplicacion_color,\n" +
"distinta7,distinta7_ubicacion,distinta7_nombre,distinta7_cantidad,distinta7_aplicacion,distinta7_aplicacion_color,\n" +
"lugar,fotomontaje_autorizado from historial_ordenes_distinta where estatus_orden = 'realizada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqldistinta);

            while (rs.next()) {

                
              
                cantidadbordados = rs.getString("cantidad");
                distinta1 = rs.getString("distinta1");
                cantidaddistinta1 = rs.getString("distinta1_cantidad");
                distinta2 = rs.getString("distinta2");
                cantidaddistinta2 = rs.getString("distinta2_cantidad");
                distinta3 = rs.getString("distinta3");
                cantidaddistinta3 = rs.getString("distinta3_cantidad");
                distinta4 = rs.getString("distinta4");
                cantidaddistinta4 = rs.getString("distinta4_cantidad");
                distinta5 = rs.getString("distinta5");
                cantidaddistinta5 = rs.getString("distinta5_cantidad");
                distinta6 = rs.getString("distinta6");
                cantidaddistinta6 = rs.getString("distinta6_cantidad");
                distinta7 = rs.getString("distinta7");
                cantidaddistinta7 = rs.getString("distinta7_cantidad");

                aplicaciondistinta1 = rs.getString("distinta1_aplicacion");
                aplicaciondistinta2 = rs.getString("distinta2_aplicacion");
                aplicaciondistinta3 = rs.getString("distinta3_aplicacion");
                aplicaciondistinta4 = rs.getString("distinta4_aplicacion");
                aplicaciondistinta5 = rs.getString("distinta5_aplicacion"); 
                aplicaciondistinta6 = rs.getString("distinta6_aplicacion");
                aplicaciondistinta7 = rs.getString("distinta7_aplicacion");
                

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordados == null || cantidadbordados.equals("")) {
                    cantidadbordados = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordados);
                int cantidaddistinta1int = Integer.parseInt(cantidaddistinta1);
                int cantidaddistinta2int = Integer.parseInt(cantidaddistinta2);
                int cantidaddistinta3int = Integer.parseInt(cantidaddistinta3);
                int cantidaddistinta4int = Integer.parseInt(cantidaddistinta4);
                int cantidaddistinta5int = Integer.parseInt(cantidaddistinta5);
                int cantidaddistinta6int = Integer.parseInt(cantidaddistinta6);
                int cantidaddistinta7int = Integer.parseInt(cantidaddistinta7);

                double costopuntadadistinta1 = 0.0;
                double costopuntadadistinta2 = 0.0;
                double costopuntadadistinta3 = 0.0;
                double costopuntadadistinta4 = 0.0;
                double costopuntadadistinta5 = 0.0;
                double costopuntadadistinta6 = 0.0;
                double costopuntadadistinta7 = 0.0;

                double importedistinta1 = 0.0;
                double importedistinta2 = 0.0;
                double importedistinta3 = 0.0;
                double importedistinta4 = 0.0;
                double importedistinta5 = 0.0;
                double importedistinta6 = 0.0;
                double importedistinta7 = 0.0;
            
             
            

                //PECHO IZQUIERDO
                
                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta1 + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs1 = prst.executeQuery();
                    if (rs1.next()) {

                        costostring = rs1.getString("costo");
                        costopuntadadistinta1 = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                importedistinta1 = cantidaddistinta1int * costopuntadadistinta1;

              
               

                String sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta2 + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql2);
                    ResultSet rs2 = prst.executeQuery();
                    if (rs2.next()) {

                        costostring = rs2.getString("costo");
                        costopuntadadistinta2 = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                importedistinta2 = cantidaddistinta2int * costopuntadadistinta2;

                

                String sql3 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta3 + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql3);
                    ResultSet rs3 = prst.executeQuery();
                    if (rs3.next()) {

                        costostring = rs3.getString("costo");
                        costopuntadadistinta3 = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                importedistinta3 = cantidaddistinta3int * costopuntadadistinta3;

              

                String sql4 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta4 + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql4);
                    ResultSet rs4 = prst.executeQuery();
                    if (rs4.next()) {

                        costostring = rs4.getString("costo");
                        costopuntadadistinta4 = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                importedistinta4 = cantidaddistinta4int * costopuntadadistinta4;

              

                String sql5 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta5 + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql5);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadadistinta5 = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                   JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                importedistinta5 = cantidaddistinta5int * costopuntadadistinta5;

              

                String sql6 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta6 + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql6);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadadistinta6 = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {

                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                importedistinta6 = cantidaddistinta6int * costopuntadadistinta6;

               

                String sql7 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + distinta7 + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql7);
                    ResultSet rs5 = prst.executeQuery();
                    if (rs5.next()) {

                        costostring = rs5.getString("costo");
                        costopuntadadistinta7 = Double.parseDouble(costostring);

                    }

                } catch (Exception exx) {

                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                importedistinta7 = cantidaddistinta7int * costopuntadadistinta7;

                if (aplicaciondistinta1 == null || aplicaciondistinta1.equals("") || aplicaciondistinta1.equals(" ")) {
                    aplicaciondistinta1 = "0";
                }

                double aplicaciondistinta1double = Double.parseDouble(aplicaciondistinta1);

                
                /// distinta 2
                if (aplicaciondistinta2 == null || aplicaciondistinta2.equals("") || aplicaciondistinta2.equals(" ")) {
                    aplicaciondistinta2 = "0";
                }

                double aplicaciondistinta2double = Double.parseDouble(aplicaciondistinta2);

                
                /// distinta3
                if (aplicaciondistinta3 == null || aplicaciondistinta3.equals("") || aplicaciondistinta3.equals(" ")) {
                    aplicaciondistinta3 = "0";
                }

                double aplicaciondistinta3double = Double.parseDouble(aplicaciondistinta3);

                if (aplicaciondistinta4 == null || aplicaciondistinta4.equals("") || aplicaciondistinta4.equals(" ")) {
                    aplicaciondistinta4 = "0";
                }

                double aplicaciondistinta4double = Double.parseDouble(aplicaciondistinta4);

                 if (aplicaciondistinta5 == null || aplicaciondistinta5.equals("") || aplicaciondistinta5.equals(" ")) {
                    aplicaciondistinta5 = "0";
                }

                double aplicaciondistinta5double = Double.parseDouble(aplicaciondistinta5);
                
                if (aplicaciondistinta6 == null || aplicaciondistinta6.equals("") || aplicaciondistinta6.equals(" ")) {
                    aplicaciondistinta6 = "0";
                }

                double aplicaciondistinta6double = Double.parseDouble(aplicaciondistinta6);
                
                if (aplicaciondistinta7 == null || aplicaciondistinta7.equals("") || aplicaciondistinta7.equals(" ")) {
                    aplicaciondistinta7 = "0";
                }

                double aplicaciondistinta7double = Double.parseDouble(aplicaciondistinta7);
               
                
                
                double sumadelasaplicioneschicasdouble = aplicaciondistinta1double + aplicaciondistinta2double + aplicaciondistinta3double + aplicaciondistinta4double + aplicaciondistinta5double +aplicaciondistinta6double + aplicaciondistinta7double;

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

                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                sumadelasaplicioneschicasdouble = (sumadelasaplicioneschicasdouble * cantidad) * costopuntadaaplicacionchica;


                sumatotaldelosbordadosdistinta = importedistinta1 + importedistinta2 + importedistinta3 + importedistinta4 + importedistinta5 + importedistinta6 + importedistinta7 + sumadelasaplicioneschicasdouble;
                

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
       
       
       
       
       ////

        /////
        //suma de los bordados
        /////
        double sumatotaldelosbordadosdouble = sumatotaldelosbordados + sumatotaldelosbordadosrecibidos + sumatotaldelosbordadosgorra + sumatotaldelosbordadosgorrarecibidas + sumatotaldelosbordadospantalon + sumatotaldelosbordadospantalonrecibidas + sumatotaldelosbordadosparche + sumatotaldelosbordadosparcherecibidos + sumatotaldelosbordadoscorbata + sumatotaldelosbordadosgorrainterna + sumatotaldelosbordadosparcheinterna + sumatotaldelosbordadosportanombre + sumatotaldelosbordadosportanombremultiple + sumatotaldelosponchados + sumatotaldelosponchadosmodificados + sumatotaldelosfotomontajes + sumatotaldelosbordadosdistinta;
        String sumabordadosstring = String.format("%.02f ", sumatotaldelosbordadosdouble);

        tablaizquierda.setValueAt(sumabordadosstring, i - 1, 1);

    }

   
   
    void sumadelasaplicaciones() 
    {
        String costostring = "";
        double costopuntadasaplicacioneschicas = 0.00;
        double totalpuntosaplicacioneschicas = 0.00;

        for (int i = 0; i < tabladerecha.getRowCount(); i++) 
        {

            Object cantidadaplicacion = tabladerecha.getValueAt(i, 2);
            if (cantidadaplicacion == null || cantidadaplicacion.equals("") || cantidadaplicacion.equals(" ")) {
                cantidadaplicacion = "0";
            }

            int cantidadaplicacionint = Integer.parseInt(cantidadaplicacion.toString());

            Object aplicacionpechoizquierdo = tabladerecha.getValueAt(i, 53);
            if (aplicacionpechoizquierdo == null || aplicacionpechoizquierdo.equals("") || aplicacionpechoizquierdo.equals(" ")) {
                aplicacionpechoizquierdo = "0";
            }
            int aplicacionpechoizquierdoint = Integer.parseInt(aplicacionpechoizquierdo.toString());

            Object aplicacionpechoderecho = tabladerecha.getValueAt(i, 54);
            if (aplicacionpechoderecho == null || aplicacionpechoderecho.equals("") || aplicacionpechoderecho.equals(" ")) {
                aplicacionpechoderecho = "0";
            }

            int aplicacionpechoderechoint = Integer.parseInt(aplicacionpechoderecho.toString());

            Object aplicacionmangaizquierda = tabladerecha.getValueAt(i, 55);
            if (aplicacionmangaizquierda == null || aplicacionmangaizquierda.equals("") || aplicacionmangaizquierda.equals(" ")) {
                aplicacionmangaizquierda = "0";
            }
            int aplicacionmangaizquierdaint = Integer.parseInt(aplicacionmangaizquierda.toString());

            Object aplicacionmangaderecha = tabladerecha.getValueAt(i, 56);
            if (aplicacionmangaderecha == null || aplicacionmangaderecha.equals("") || aplicacionmangaderecha.equals(" ")) {
                aplicacionmangaderecha = "0";
            }
            int aplicacionmangaderechaint = Integer.parseInt(aplicacionmangaderecha.toString());

            Object aplicacionfrente = tabladerecha.getValueAt(i, 57);
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
               JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            totalpuntosaplicacioneschicas = costopuntadasaplicacioneschicas * (sumadelasaplicaciones * cantidadaplicacionint);

            tabladerecha.setValueAt(String.format("%.02f ", totalpuntosaplicacioneschicas), i, 59);

       

        //// aplicaciones grandes
        String costoaplicacionesgrandesstring = "";
        double costopuntadasaplicacionesgrandes = 0.00;
        double totalpuntosaplicacionesgrandes = 0.00;

       
            
            
            
            Object aplicacionespalda = tabladerecha.getValueAt(i, 60);
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
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            totalpuntosaplicacionesgrandes = costopuntadasaplicacionesgrandes * (sumadelasaplicacionesgrandes* cantidadaplicacionint);
            String totalpuntosaplicacionesgrandesstring =  String.format("%.02f ", totalpuntosaplicacionesgrandes);
                    
                    if (totalpuntosaplicacionesgrandes<1)
                    {
                        totalpuntosaplicacionesgrandesstring = "0";
                    }
         

            tabladerecha.setValueAt(totalpuntosaplicacionesgrandesstring, i, 61);

        }

        /// suma con los puntos
        for (int i = 0; i < tabladerecha.getRowCount(); i++) 
        {
            Object puntosaplicacioneschicas = tabladerecha.getValueAt(i, 59);
            if (puntosaplicacioneschicas == null || puntosaplicacioneschicas.equals("") || puntosaplicacioneschicas.equals(" ")) {
                puntosaplicacioneschicas = "0";
            }

            Object puntosaplicacionesgrandes = tabladerecha.getValueAt(i, 61);
            if (puntosaplicacionesgrandes == null || puntosaplicacionesgrandes.equals("") || puntosaplicacionesgrandes.equals(" ")) {
                puntosaplicacionesgrandes = "0";
            }

            Object puntostotales = tabladerecha.getValueAt(i, 62);
            if (puntostotales == null || puntostotales.equals("") || puntostotales.equals(" ")) {
                puntostotales = "0";
            }

            double puntosaplicacioneschicasdouble = Double.parseDouble(puntosaplicacioneschicas.toString());
            double puntosaplicacionesgrandesdouble = Double.parseDouble(puntosaplicacionesgrandes.toString());
            double puntostotalesdouble = Double.parseDouble(puntostotales.toString());

            double sumatotaldepuntos = puntostotalesdouble + puntosaplicacioneschicasdouble + puntosaplicacionesgrandesdouble  ;

            tabladerecha.setValueAt(String.format("%.02f ", sumatotaldepuntos), i, 62);

        }

    }
    
    void suma()
    {
         
        int filas = tabladerecha.getRowCount();
        double sumatotal = 0;

        for (int j = 0; j < filas; j++) 
        {

       
            Object cantidadobject = tabladerecha.getValueAt(j, 62);
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
           JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

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

        DefaultTableModel modelo2 = (DefaultTableModel) tabladerecha.getModel();
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
        
        

        String sql = "Select fecha,fotomontaje from historial_fotomontajes where fecha = '"+fechabusqueda+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) 
            {

                Object cantidadobject = rs.getString("fotomontaje");
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
                datos[3] = "FOTOMONTAJE";
                
                modelo2.addRow(datos);
                
                }
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        

        calcularcostofotomontajes();

    }
    
    ////////////////////////////
    //////////////////
    //////////        
    void calcularcostofotomontajes() {

        double importedelfotomontaje = 0.0;
        String costostring = "0";

        for (int i = 0; i < tabladerecha.getRowCount(); i++) 
        {

            Object cantidadobject = tabladerecha.getValueAt(i, 2);
            Object articulo = tabladerecha.getValueAt(i, 3);
            int cantidad = Integer.parseInt(cantidadobject.toString());
            String articulobuscar = "";

            if (articulo.toString().equals("FOTOMONTAJE")) 
            {

                
                articulobuscar = articulo.toString();

                tabladerecha.setValueAt(articulobuscar, i, 5);

                double costodelfotomontaje = 0.0;

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = 'FOTOMONTAJE' ";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costodelfotomontaje = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

                }

                String costofotomontajestring = String.format("%.02f ", costodelfotomontaje);
                tabladerecha.setValueAt(costofotomontajestring, i, 6);

                double importefotomontaje = cantidad * costodelfotomontaje;

                double sumabordados = importefotomontaje;
                String sumafotomontajesstring = String.format("%.02f ", sumabordados);
                tabladerecha.setValueAt(sumafotomontajesstring, i, 62);

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
        tablaizquierda = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabladerecha = new javax.swing.JTable()
        {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        }

        ;
        jLabel1 = new javax.swing.JLabel();
        lbsuma = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
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
        setPreferredSize(new java.awt.Dimension(1900, 1050));
        setSize(new java.awt.Dimension(0, 0));
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

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Mes:");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbmes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbmes.setText("Mesdelaño");
        lbmes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Año");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbaño.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbaño.setText("0000");
        lbaño.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tablaizquierda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaizquierda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Importe del día", "Color"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaizquierda.setRowHeight(28);
        tablaizquierda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaizquierdaMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaizquierda);
        if (tablaizquierda.getColumnModel().getColumnCount() > 0) {
            tablaizquierda.getColumnModel().getColumn(0).setMinWidth(50);
            tablaizquierda.getColumnModel().getColumn(0).setPreferredWidth(80);
            tablaizquierda.getColumnModel().getColumn(0).setMaxWidth(120);
            tablaizquierda.getColumnModel().getColumn(2).setMinWidth(0);
            tablaizquierda.getColumnModel().getColumn(2).setPreferredWidth(0);
            tablaizquierda.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        tabladerecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabladerecha.setModel(new javax.swing.table.DefaultTableModel(
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
        tabladerecha.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        tabladerecha.setRowHeight(22);
        tabladerecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladerechaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabladerecha);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Suma");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsuma.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbsuma.setForeground(new java.awt.Color(153, 0, 0));
        lbsuma.setText("0.00");
        lbsuma.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsumapuntos.setText("0.00");
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Dia:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbdia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbdia.setText("00");
        lbdia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Historial de horas de ayuda");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbsuma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1632, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel2)
                        .addGap(6, 6, 6)
                        .addComponent(lbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(5, 5, 5)
                        .addComponent(btnanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(btnsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel6)
                        .addGap(7, 7, 7)
                        .addComponent(lbdia, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(lbaño, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(463, 463, 463)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(277, 277, 277)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbmes, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnanterior, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsiguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbdia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbaño, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 895, Short.MAX_VALUE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbsuma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
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
        datostablaizquierda();


    }//GEN-LAST:event_btnanteriorActionPerformed

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed

        btnanterior.setEnabled(true);

        mesfinal = mesfinal + 1;
        lbdia.setText("0");
        limpiartablafechas();
        seleccionarfechas();
        datostablaizquierda();


    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void tablaizquierdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaizquierdaMouseClicked

        
        
        
        
        
        if (evt.getClickCount() == 1) 
        {

            int fila = tablaizquierda.getSelectedRow();

            if (fila >= 0) 
            {

                Object fechabusqueda = tablaizquierda.getValueAt(fila, 0);
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
                datostablahistorialordenesdistinta((int) fechabusquedaint);
                

            }
            
            sumadelasaplicaciones();
            suma();

        }

        

    }//GEN-LAST:event_tablaizquierdaMouseClicked

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

    private void tabladerechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladerechaMouseClicked

        if (evt.getClickCount() == 2) 
        {
            int fila = tabladerecha.getSelectedRow();
            Object numeroventa = tabladerecha.getValueAt(fila, 63);

            if (numeroventa == null || numeroventa.equals(""))
            {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">No tiene numero de venta");
            } 

        }


    }//GEN-LAST:event_tabladerechaMouseClicked

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
                new viejobordadosreportegeneral().setVisible(true);
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JLabel lbaño;
    public static javax.swing.JLabel lbdia;
    public static javax.swing.JLabel lbmes;
    private javax.swing.JLabel lbsuma;
    private javax.swing.JLabel lbsumapuntos;
    private javax.swing.JTable tabladerecha;
    private javax.swing.JTable tablaizquierda;
    private javax.swing.JTextField txtdialogoubic;
    // End of variables declaration//GEN-END:variables
coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();

}
