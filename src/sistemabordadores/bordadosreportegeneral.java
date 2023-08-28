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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import net.coderazzi.filters.gui.AutoChoices;
import net.coderazzi.filters.gui.TableFilterHeader;
import java.time.format.DateTimeFormatter;


public class bordadosreportegeneral extends javax.swing.JFrame {

    public static boolean ventanareportedebordadosgeneral = false;

    String fechafinal = "";
    String fechainicial = "";
    String anterior = "";
    String messtring = "";

    int diainicial = 0;
    int mesinicial = 0;
    int añoinicial = 0;
    int diafinal = 0;
    int mesfinal = 0;
    int añofinal = 0;

    int ultimomes = 0;
    int ultimoaño = 0;
    int diasquevoyasumarorestar = 0;
    
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
    
    String tiendalocal = principal.tiendalocal;
    
    String fechabusqueda = "";
    
    PreparedStatement pst;

    public bordadosreportegeneral() {

        initComponents();
        ventanareportedebordadosgeneral = true;
        
        
        TableFilterHeader filterHeader = new TableFilterHeader(tabladerecha, AutoChoices.ENABLED);
    
        topes();
    //    seleccionarfechas();
        
        fechasemanaactual();
        
        
        anterior = "no";
        datostablaizquierda();
        btnsiguiente.setEnabled(false);
        
        lbsumapuntos.setVisible(false);

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

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void datostablaizquierda() 
    {
        
     
      
        
        
        String diaSemana = "";
        
        
        
          DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate fechastring = LocalDate.parse(fechainicial, dateFormatter);
        
        
        

        DefaultTableModel modelotabla = (DefaultTableModel) tablaizquierda.getModel();
        String[] datos = new String[4];

     
        
        
            
            for (int i = 1; i < 8; i++)
            
            
            {
                
                
              
          
            
                
                
         int diaint = fechastring.getDayOfMonth();

        
        String diaSemanaeningles = fechastring.getDayOfWeek().toString();
        
        if (diaSemanaeningles.equals("MONDAY")) {diaSemana = "Lunes";}else
        if (diaSemanaeningles.equals("TUESDAY")) {diaSemana = "Martes";}else
        if (diaSemanaeningles.equals("WEDNESDAY")) {diaSemana = "Miercoles";}else
        if (diaSemanaeningles.equals("THURSDAY")) {diaSemana = "Jueves";}else
        if (diaSemanaeningles.equals("FRIDAY")) {diaSemana = "Viernes";}else
        if (diaSemanaeningles.equals("SATURDAY")) {diaSemana = "Sabado";}else
        if (diaSemanaeningles.equals("SUNDAY")) {diaSemana = "Domingo";}
        
        
        
                
            
            String color = "blanco";
            
         
          
                 if (diaSemana.equals("sábado") || diaSemana.equals("domingo"))
            {
                color = "rojo";
            }
           
           else
                  {
                    color = "blanco";   
                  }
        
        
            String dia = String.valueOf(diaint);
            

            datos[0] = dia;
            datos[1] = "0.00";
            datos[2] = color;
            datos[3] = diaSemana;
            
            
            modelotabla.addRow(datos);

          
            
            calculodelassumasdelosbordadostablaizquierda((int) i);
           
         
            
            fechastring = fechastring.plusDays(1);
            
            
            

        }

        
        double sumadouble = 0.0;

        for (int i = 0; i < tablaizquierda.getRowCount(); i++) {

            String importepordiastring = tablaizquierda.getValueAt(i, 1).toString();
            double importepordiadouble = Double.parseDouble(importepordiastring);

            sumadouble = sumadouble + importepordiadouble;

        }

        lbsumatablaizquierda.setText(String.format("%.2f", sumadouble));

        
        
        
        
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
        
   //     String messtring = lbmes.getText();
        
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

        fechabusqueda = (+año + "-" + mesfinal + "-" + dia);

        double sumatotaldelosbordados = 0.00;
        double sumatotaldelosbordadosrecibidos = 0.00;

        double sumatotaldelosbordadosgorra = 0.00;
        double sumatotaldelosbordadosgorrarecibidas = 0.00;

        double sumatotaldelosbordadoscorbata = 0.00;
        double sumatotaldelosbordadoscorbatarecibidos = 0.00;
        double sumatotaldelosbordadospantalon = 0.00;
        double sumatotaldelosbordadospantalonrecibidas = 0.00;
        double sumatotaldelosbordadosgorrainterna = 0.00;
        double sumatotaldelosbordadosparcheinterna = 0.00;
        double sumatotaldelosbordadosportanombre = 0.00;
        double sumatotaldelosbordadosportanombremultiple = 0.00;
        double sumatotaldelosponchados = 0.00;

        
          if (fechabusqueda.equals("2023-08-7")||  fechabusqueda.equals("2023-08-7"))
                {
                 int a = 0;   
                }
                
                
                 if (fechabusqueda.equals("2023-8-8"))
                {
                 int a = 0;   
                }
                
        
        
        
        ////////////CAMISA
        
        String sql = "Select codigo,numero,fecha,cliente,pecho_izquierdo_fecha,cantidad,prenda,pecho_izquierdo_cantidad,pecho_izquierdo_nombre,pecho_izquierdo_puntadas,"
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

                String numero =  rs.getString("numero");
                String cliente =   rs.getString("cliente");  
                String fechapecho = rs.getString("pecho_izquierdo_fecha"); 
                
                if (fechabusqueda==null || fechabusqueda.equals(""))
                        {
                            
                        }
                
                else
                    
                {
                
              
                
                        
                }
              
           //     cantidadbordados = rs.getString("cantidad");
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

          //  int cantidad =  Integer.parseInt(cantidadbordados);   
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

                if (aplicacionpechoizquierdo == null || aplicacionpechoizquierdo.equals("") || aplicacionpechoizquierdo.equals(" ") || aplicacionpechoizquierdo.equals("0")) {
                    aplicacionpechoizquierdo = "0";
                }

                double aplicacionpechoizquierdodouble = Double.parseDouble(aplicacionpechoizquierdo);

                if (aplicacionpechoderecho == null || aplicacionpechoderecho.equals("") || aplicacionpechoderecho.equals(" ")  || aplicacionpechoderecho.equals("0")) {
                    aplicacionpechoderecho = "0";
                }

                double aplicacionpechoderechodouble = Double.parseDouble(aplicacionpechoderecho);

                if (aplicacionmangaizquierda == null || aplicacionmangaizquierda.equals("") || aplicacionmangaizquierda.equals(" ") || aplicacionmangaizquierda.equals("0")) {
                    aplicacionmangaizquierda = "0";
                }

                double aplicacionmangaizquierdadouble = Double.parseDouble(aplicacionmangaizquierda);

                if (aplicacionmangaderecha == null || aplicacionmangaderecha.equals("") || aplicacionmangaderecha.equals(" ") || aplicacionmangaderecha.equals("0")) {
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

              //  sumadelasaplicioneschicasdouble = (sumadelasaplicioneschicasdouble * cantidad) * costopuntadaaplicacionchica;

                if (aplicacionespalda == null || aplicacionespalda.equals("") || aplicacionespalda.equals(" ") || aplicacionespalda.equals("0")) {
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

                double sumadelasaplicionesgrandesdouble = 0;
              //  double sumadelasaplicionesgrandesdouble = (aplicacionespaldadouble * cantidad) * costopuntadaaplicaciongrande;

                
                numero =  numero;
                cliente =   cliente;  
                
                
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
                if (aplicacionpechoizquierdorecibidos == null || aplicacionpechoizquierdorecibidos.equals("") || aplicacionpechoizquierdorecibidos.equals(" ") || aplicacionpechoizquierdorecibidos.equals("0")) {
                    aplicacionpechoizquierdorecibidos = "0";
                }

                double aplicacionpechoizquierdodouble = Double.parseDouble(aplicacionpechoizquierdorecibidos);

                if (aplicacionpechoderechorecibidos == null || aplicacionpechoderechorecibidos.equals("") || aplicacionpechoderechorecibidos.equals(" ") || aplicacionpechoderechorecibidos.equals("0")) {
                    aplicacionpechoderechorecibidos = "0";
                }

                double aplicacionpechoderechodouble = Double.parseDouble(aplicacionpechoderechorecibidos);

                if (aplicacionmangaizquierdarecibidos == null || aplicacionmangaizquierdarecibidos.equals("") || aplicacionmangaizquierdarecibidos.equals(" ") || aplicacionmangaizquierdarecibidos.equals("0")) {
                    aplicacionmangaizquierdarecibidos = "0";
                }

                double aplicacionmangaizquierdadouble = Double.parseDouble(aplicacionmangaizquierdarecibidos);

                if (aplicacionmangaderecharecibidos == null || aplicacionmangaderecharecibidos.equals("") || aplicacionmangaderecharecibidos.equals(" ") || aplicacionmangaderecharecibidos.equals("0")) {
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

                if (aplicacionespalda == null || aplicacionespalda.equals("") || aplicacionespalda.equals(" ") || aplicacionespalda.equals("0")) {
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
        String sqlgorras = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_puntadas,lado_derecho_puntadas,frente_puntadas,atras_puntadas,aplicacion_frente from historial_ordenes_gorra where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = 'Esta sucursal' and (frente_fecha = '" + fechabusqueda + "' or atras_fecha = '" + fechabusqueda + "' or lado_izquierdo_fecha = '" + fechabusqueda + "'  or lado_derecho_fecha = '" + fechabusqueda + "') order by codigo ";

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
                
                if (aplicacionfrente == null || aplicacionfrente.equals("") || aplicacionfrente.equals(" ") || aplicacionfrente.equals("0")) {
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
        String sqlgorrasrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_puntadas,lado_derecho_puntadas,frente_puntadas,atras_puntadas,aplicacion_frente from historial_ordenes_gorra_recibidas where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and (frente_fecha = '" + fechabusqueda + "' or atras_fecha = '" + fechabusqueda + "' or lado_izquierdo_fecha = '" + fechabusqueda + "'  or lado_derecho_fecha = '" + fechabusqueda + "')  order by codigo ";

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
                if (aplicacionfrenterecibidas == null || aplicacionfrenterecibidas.equals("") || aplicacionfrenterecibidas.equals(" ") || aplicacionfrenterecibidas.equals("0")) {
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
        String sqlpantalon = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_frente_puntadas,lado_derecho_frente_nombre,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas from historial_ordenes_pantalon where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = 'Esta sucursal' and (lado_izquierdo_frente_fecha = '" + fechabusqueda + "' or lado_derecho_frente_fecha = '" + fechabusqueda + "' or lado_izquierdo_atras_fecha = '" + fechabusqueda + "'  or lado_derecho_atras_fecha = '" + fechabusqueda + "') order by codigo ";

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
        String sqlpantalonrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_frente_puntadas,lado_derecho_frente_nombre,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas from historial_ordenes_pantalon_recibidas where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and (lado_izquierdo_frente_fecha = '" + fechabusqueda + "' or lado_derecho_frente_fecha = '" + fechabusqueda + "' or lado_izquierdo_atras_fecha = '" + fechabusqueda + "'  or lado_derecho_atras_fecha = '" + fechabusqueda + "') order by codigo ";

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

        String sqlparches = "Select codigo,fecha,cliente,cantidad,parche_puntadas,parche_nombre from historial_ordenes_parche where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = 'Esta sucursal' and parche_fecha = '" + fechabusqueda + "' order by codigo ";

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

        String sqlparchesrecibidos = "Select codigo,fecha,cliente,cantidad,parche_puntadas from historial_ordenes_parche_recibidas where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and parche_fecha = '" + fechabusqueda + "' order by codigo ";

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
        String sqlcorbatas = "Select codigo,fecha,cliente,cantidad_bordados,prenda,frente_puntadas from historial_ordenes_corbata where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = 'Esta sucursal' and frente_fecha = '" + fechabusqueda + "' order by codigo ";

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

        
        
        
        
        
        
        
        
        
        
        ///// CORBATA RECIBIDA
        String sqlcorbatas2 = "Select codigo,fecha,cliente,cantidad_bordados,prenda,frente_puntadas from historial_ordenes_corbata_recibidas where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = 'Esta sucursal' and frente_fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlcorbatas2);

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
                sumatotaldelosbordadoscorbatarecibidos = sumatotaldelosbordadoscorbatarecibidos + sumabordadoscorbata;

            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        
        
        
        
        
        
       
       //// DISTINTA
       
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
"distinta1_puntadas,distinta1_ubicacion,distinta1_nombre,distinta1_cantidad,distinta1_aplicacion,distinta1_aplicacion_color,\n" +
"distinta2_puntadas,distinta2_ubicacion,distinta2_nombre,distinta2_cantidad,distinta2_aplicacion,distinta2_aplicacion_color, \n" +
"distinta3_puntadas,distinta3_ubicacion,distinta3_nombre,distinta3_cantidad,distinta3_aplicacion,distinta3_aplicacion_color, \n" +
"distinta4_puntadas,distinta4_ubicacion,distinta4_nombre,distinta4_cantidad,distinta4_aplicacion,distinta4_aplicacion_color, \n" +
"distinta5_puntadas,distinta5_ubicacion,distinta5_nombre,distinta5_cantidad,distinta5_aplicacion,distinta5_aplicacion_color,\n" +
"distinta6_puntadas,distinta6_ubicacion,distinta6_nombre,distinta6_cantidad,distinta6_aplicacion,distinta6_aplicacion_color,\n" +
"distinta7_puntadas,distinta7_ubicacion,distinta7_nombre,distinta7_cantidad,distinta7_aplicacion,distinta7_aplicacion_color,\n" +
"lugar,fotomontaje_autorizado from historial_ordenes_distinta where (estatus_orden = 'realizada totalmente' or estatus_orden = 'realizada parcialmente') and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqldistinta);

            while (rs.next()) {

                
              
                cantidadbordados = rs.getString("cantidad");
                distinta1 = rs.getString("distinta1_puntadas");
                cantidaddistinta1 = rs.getString("distinta1_cantidad");
                distinta2 = rs.getString("distinta2_puntadas");
                cantidaddistinta2 = rs.getString("distinta2_cantidad");
                distinta3 = rs.getString("distinta3_puntadas");
                cantidaddistinta3 = rs.getString("distinta3_cantidad");
                distinta4 = rs.getString("distinta4_puntadas");
                cantidaddistinta4 = rs.getString("distinta4_cantidad");
                distinta5 = rs.getString("distinta5_puntadas_puntadas");
                cantidaddistinta5 = rs.getString("distinta5_cantidad");
                distinta6 = rs.getString("distinta6_puntadas");
                cantidaddistinta6 = rs.getString("distinta6_cantidad");
                distinta7 = rs.getString("distinta7_puntadas");
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

                if (aplicaciondistinta1 == null || aplicaciondistinta1.equals("") || aplicaciondistinta1.equals(" ") || aplicaciondistinta1.equals("0")) {
                    aplicaciondistinta1 = "0";
                }

                double aplicaciondistinta1double = Double.parseDouble(aplicaciondistinta1);

                
                /// distinta 2
                if (aplicaciondistinta2 == null || aplicaciondistinta2.equals("") || aplicaciondistinta2.equals(" ") || aplicaciondistinta2.equals("0")) {
                    aplicaciondistinta2 = "0";
                }

                double aplicaciondistinta2double = Double.parseDouble(aplicaciondistinta2);

                
                /// distinta3
                if (aplicaciondistinta3 == null || aplicaciondistinta3.equals("") || aplicaciondistinta3.equals(" ") || aplicaciondistinta3.equals("0")) {
                    aplicaciondistinta3 = "0";
                }

                double aplicaciondistinta3double = Double.parseDouble(aplicaciondistinta3);

                if (aplicaciondistinta4 == null || aplicaciondistinta4.equals("") || aplicaciondistinta4.equals(" ") || aplicaciondistinta4.equals("0")) {
                    aplicaciondistinta4 = "0";
                }

                double aplicaciondistinta4double = Double.parseDouble(aplicaciondistinta4);

                 if (aplicaciondistinta5 == null || aplicaciondistinta5.equals("") || aplicaciondistinta5.equals(" ") || aplicaciondistinta5.equals("0")) {
                    aplicaciondistinta5 = "0";
                }

                double aplicaciondistinta5double = Double.parseDouble(aplicaciondistinta5);
                
                if (aplicaciondistinta6 == null || aplicaciondistinta6.equals("") || aplicaciondistinta6.equals(" ") || aplicaciondistinta6.equals("0")) {
                    aplicaciondistinta6 = "0";
                }

                double aplicaciondistinta6double = Double.parseDouble(aplicaciondistinta6);
                
                if (aplicaciondistinta7 == null || aplicaciondistinta7.equals("") || aplicaciondistinta7.equals(" ") || aplicaciondistinta7.equals("0")) {
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

        /////
        //suma de los bordados
        /////
        double sumatotaldelosbordadosdouble = sumatotaldelosbordados + sumatotaldelosbordadosrecibidos + sumatotaldelosbordadosgorra + sumatotaldelosbordadosgorrarecibidas + sumatotaldelosbordadospantalon + sumatotaldelosbordadospantalonrecibidas + sumatotaldelosbordadosparche + sumatotaldelosbordadosparcherecibidos + sumatotaldelosbordadoscorbata + sumatotaldelosbordadoscorbatarecibidos + sumatotaldelosbordadosgorrainterna + sumatotaldelosbordadosparcheinterna + sumatotaldelosbordadosportanombre + sumatotaldelosbordadosportanombremultiple + sumatotaldelosponchados + sumatotaldelosponchadosmodificados + sumatotaldelosfotomontajes + sumatotaldelosbordadosdistinta;
        String sumabordadosstring = String.format("%.02f ", sumatotaldelosbordadosdouble);

        tablaizquierda.setValueAt(sumabordadosstring, i - 1, 1);

    }

   
    
    
    
    
    
    
    
    
    
    private void fechasemanaanterior() {
       
        
        try {
           
             
            
           
         //   Date fechaActual = new Date();  // Fecha actual
            Calendar calendar = Calendar.getInstance();
          //  calendar.setTime(fechaActual);

            // Retrocede 7 días para obtener la fecha de hace una semana
            calendar.add(Calendar.DAY_OF_WEEK, + diasquevoyasumarorestar);
            Date fechaSemanaPasada = calendar.getTime();

            // Calcula los días de inicio (lunes) y final (viernes) de la semana pasada
            calendar.setTime(fechaSemanaPasada);
            int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
            int diasHastaLunes = (Calendar.MONDAY - diaSemana + 7) % 7;
            int diasHastaViernes = (Calendar.SUNDAY - diaSemana + 7) % 7;

            calendar.add(Calendar.DAY_OF_WEEK, diasHastaLunes);
            diainicial = calendar.get(Calendar.DAY_OF_MONTH);
            mesinicial = calendar.get(Calendar.MONTH) + 1;
            añoinicial = calendar.get(Calendar.YEAR);

            calendar.add(Calendar.DAY_OF_WEEK, diasHastaViernes - diasHastaLunes);
            diafinal = calendar.get(Calendar.DAY_OF_MONTH);
            mesfinal = calendar.get(Calendar.MONTH) + 1;
            añofinal = calendar.get(Calendar.YEAR);
            
           
            
              fechainicial = (+diainicial +"/" + mesinicial + "/" + añofinal);
        fechafinal = (+diafinal + "/" + mesfinal + "/" + añofinal);
        
        
        
        try {
            SimpleDateFormat sdfSource = new SimpleDateFormat("d/MM/yyyy");

            java.util.Date date2 = sdfSource.parse(fechainicial);

            SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/MM/dd");

            fechainicial = sdfDestination.format(date2);

        } catch (Exception pe) {

        }
        
        
        
        try {
            SimpleDateFormat sdfSource = new SimpleDateFormat("d/MM/yyyy");

            java.util.Date date2 = sdfSource.parse(fechafinal);

            SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/MM/dd");

            fechafinal = sdfDestination.format(date2);

        } catch (Exception pe) {

        }
        
        
        
        
        lbinicio.setText(fechainicial);
        lbfin.setText(fechafinal);
        
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      private void fechasiguiente() {
       
        
        try {
           
             
            
           
         //   Date fechaActual = new Date();  // Fecha actual
            Calendar calendar = Calendar.getInstance();
          //  calendar.setTime(fechaActual);

            // Retrocede 7 días para obtener la fecha de hace una semana
            calendar.add(Calendar.DAY_OF_WEEK, +7);
            Date fechaSemanaPasada = calendar.getTime();

            // Calcula los días de inicio (lunes) y final (viernes) de la semana pasada
            calendar.setTime(fechaSemanaPasada);
            int diaSemana = calendar.get(Calendar.DAY_OF_WEEK);
            int diasHastaLunes = (Calendar.MONDAY - diaSemana + 7) % 7;
            int diasHastaViernes = (Calendar.SUNDAY - diaSemana + 7) % 7;

            calendar.add(Calendar.DAY_OF_WEEK, diasHastaLunes);
            diainicial = calendar.get(Calendar.DAY_OF_MONTH);
            mesinicial = calendar.get(Calendar.MONTH) + 1;
            añoinicial = calendar.get(Calendar.YEAR);

            calendar.add(Calendar.DAY_OF_WEEK, diasHastaViernes - diasHastaLunes);
            diafinal = calendar.get(Calendar.DAY_OF_MONTH);
            mesfinal = calendar.get(Calendar.MONTH) + 1;
            añofinal = calendar.get(Calendar.YEAR);
            
           
            
              fechainicial = (+diainicial +"/" + mesinicial + "/" + añofinal);
        fechafinal = (+diafinal + "/" + mesfinal + "/" + añofinal);
        
        
        
        try {
            SimpleDateFormat sdfSource = new SimpleDateFormat("d/MM/yyyy");

            java.util.Date date2 = sdfSource.parse(fechainicial);

            SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/MM/dd");

            fechainicial = sdfDestination.format(date2);

        } catch (Exception pe) {

        }
        
        
        
        try {
            SimpleDateFormat sdfSource = new SimpleDateFormat("d/MM/yyyy");

            java.util.Date date2 = sdfSource.parse(fechafinal);

            SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/MM/dd");

            fechafinal = sdfDestination.format(date2);

        } catch (Exception pe) {

        }
        
        
        
        
        lbinicio.setText(fechainicial);
        lbfin.setText(fechafinal);
        
           
            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
      
    
    void datoscamisa(int fechabusquedaint) 
    {

        
        
       
        Calendar cal = new GregorianCalendar();

        int dia = fechabusquedaint;
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

        fechabusqueda = (+año + "-" + mesint + "-" + dia);
        
        
        String tabla = "";
        
        
        String ubicacion = "";
        String ubicacionnombre = "";
        String ubicacioncantidad = "";
        String ubicacionpuntadas = "";
        String ubicacionaplicacion = ""; 
        String lugar = "";
        String ubicacionfecha = "";
            
        
         DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();
        String[] datos = new String[18];
        
        
        
        
        //CAMISA
        
        
        
        for (int i=1;i<15;i++)
            
            
        {
            
            
            if (i<8)
            {
                 tabla = "historial_ordenes_camisa";
                 lugar = "Esta sucursal";
                 
            }
            else
            {
                tabla = "historial_ordenes_camisa_recibidas";
                 lugar = "Otra sucursal";
            }
        
            
        if (i==1 || i==8)
            
        {
            
        //PECHO IZQUIERDO
       
         
         ubicacion = "Pecho izquierdo";
         ubicacionnombre = "pecho_izquierdo_nombre";
         ubicacioncantidad = "pecho_izquierdo_cantidad";
         ubicacionpuntadas = "pecho_izquierdo_puntadas";
         ubicacionaplicacion = "aplicacion_pecho_izquierdo"; 
         ubicacionfecha = "pecho_izquierdo_fecha";
         
        }
        
        
         if (i==2 || i==9)
            
        {
            
        //PECHO DERECHO
         
         ubicacion = "Pecho derecho";
         ubicacionnombre = "pecho_derecho_nombre";
         ubicacioncantidad = "pecho_derecho_cantidad";
         ubicacionpuntadas = "pecho_derecho_puntadas";
         ubicacionaplicacion = "aplicacion_pecho_derecho"; 
         ubicacionfecha = "pecho_derecho_fecha";
         
        }
         
         
         
           if (i==3 || i==10)
            
        {
            
        //MANGA IZQUIERDA
         
         ubicacion = "Manga izquierda";
         ubicacionnombre = "manga_izquierda_nombre";
         ubicacioncantidad = "manga_izquierda_cantidad";
         ubicacionpuntadas = "manga_izquierda_puntadas";
         ubicacionaplicacion = "aplicacion_manga_izquierda"; 
         ubicacionfecha = "manga_izquierda_fecha";
         
        }
           
           
            
           if (i==4 || i==11)
            
        {
            
        //MANGA DERECHA
         
         ubicacion = "Manga derecha";
         ubicacionnombre = "manga_derecha_nombre";
         ubicacioncantidad = "manga_derecha_cantidad";
         ubicacionpuntadas = "manga_derecha_puntadas";
         ubicacionaplicacion = "aplicacion_manga_derecha"; 
         ubicacionfecha = "manga_derecha_fecha";
         
        }
           
           
           
            
           if (i==5 || i==12)
            
        {
            
        //ESPALDA
         
         ubicacion = "Espalda";
         ubicacionnombre = "espalda_nombre";
         ubicacioncantidad = "espalda_cantidad";
         ubicacionpuntadas = "espalda_puntadas";
         ubicacionaplicacion = "aplicacion_espalda"; 
         ubicacionfecha = "espalda_fecha";
         
        }
           
           
           
            
           if (i==6 || i==13)
            
        {
            
        //OTRA UBICACION
         
         ubicacion = "Otra ubicacion";
         ubicacionnombre = "otra_ubicacion_nombre";
         ubicacioncantidad = "otra_ubicacion_cantidad";
         ubicacionpuntadas = "otra_ubicacion_puntadas";
         ubicacionaplicacion = "aplicacion_otra_ubicacion"; 
         ubicacionfecha = "otra_ubicacion_fecha";
         
        }
           
           
           
           
           
            
           if (i==7 || i==14)
            
        {
            
        //OTRA UBICACION2
         
         ubicacion = "Otra ubicacion2";
         ubicacionnombre = "otra_ubicacion2_nombre";
         ubicacioncantidad = "otra_ubicacion2_cantidad";
         ubicacionpuntadas = "otra_ubicacion2_puntadas";
         ubicacionaplicacion = "aplicacion_otra_ubicacion2"; 
         ubicacionfecha = "otra_ubicacion2_fecha";
         
        }
        
        

        String sql = "Select numero,borda_cliente,prenda,identificador_prenda,"
                  + ""+ubicacionnombre+","+ubicacioncantidad+","+ubicacionpuntadas+","+ubicacionaplicacion+",tienda"
                  + " from "+tabla+""
                  + " where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = '"+lugar+"'"
                  + "and "+ubicacionfecha+" = '"+fechabusqueda+"' ";
              

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = ubicacion;
                datos[5] = rs.getString(5);
                datos[6] = rs.getString(6);
                datos[7] = rs.getString(7);
                datos[8] = "0"; // Preio por puntadas
                datos[9] = "0"; // PUNTOS BORDADOS
                datos[10] = rs.getString(8);
                datos[11] = "0"; // Precio por puntadas
                datos[12] = "0"; // PUNTOS APLICACIONES
                datos[13] = "0"; // SUMA PUNTOS
                datos[14] = tabla; //TABLA
                datos[15] = rs.getString(9);
              
                modelo.addRow(datos);
                
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

       
    }

    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void datosgorra(int fechabusquedaint) 
    {

        
        
       
        Calendar cal = new GregorianCalendar();

        int dia = fechabusquedaint;
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

        fechabusqueda = (+año + "-" + mesint + "-" + dia);
        
        
        String tabla = "";
        
        
        String ubicacion = "";
        String ubicacionnombre = "";
        String ubicacioncantidad = "";
        String ubicacionpuntadas = "";
        String ubicacionaplicacion = ""; 
        String lugar = "";
        String ubicacionfecha = "";
            
        
         DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();
        String[] datos = new String[18];
        
        
        
        
        
        
        for (int i=1;i<9;i++)
            
            
        {
            
            
            if (i<5)
            {
                 tabla = "historial_ordenes_gorra";
                 lugar = "Esta sucursal";
                 
            }
            else
            {
                tabla = "historial_ordenes_gorra_recibidas";
                 lugar = "Otra sucursal";
            }
        
            
        if (i==1 || i==5)
            
        {
            
        //FRENTE
       
         
         ubicacion = "Frente";
         ubicacionnombre = "frente_nombre";
         ubicacioncantidad = "frente_cantidad";
         ubicacionpuntadas = "frente_puntadas";
         ubicacionaplicacion = "aplicacion_frente"; 
         ubicacionfecha = "frente_fecha";
         
        }
        
        
         if (i==2 || i==6)
            
        {
            
        //ATRAS
         
         ubicacion = "Atras";
         ubicacionnombre = "atras_nombre";
         ubicacioncantidad = "atras_cantidad";
         ubicacionpuntadas = "atras_puntadas";
     //    ubicacionaplicacion = "aplicacion_atras"; 
         ubicacionfecha = "atras_fecha";
         
        }
         
         
         
           if (i==3 || i==7)
            
        {
            
        //LADO IZQUIERDO
         
         ubicacion = "Lado izquierdo";
         ubicacionnombre = "lado_izquierdo_nombre";
         ubicacioncantidad = "lado_izquierdo_cantidad";
         ubicacionpuntadas = "lado_izquierdo_puntadas";
      //   ubicacionaplicacion = "aplicacion_lado_izquierdo"; 
         ubicacionfecha = "lado_izquierdo_fecha";
         
        }
           
           
            
           if (i==4 || i==8)
            
        {
            
        //LADO DERECHO
         
         ubicacion = "Lado derecho";
         ubicacionnombre = "lado_derecho_nombre";
         ubicacioncantidad = "lado_derecho_cantidad";
         ubicacionpuntadas = "lado_derecho_puntadas";
       //  ubicacionaplicacion = "aplicacion_lado_derecho"; 
         ubicacionfecha = "lado_derecho_fecha";
         
        }
          
           
           
         String sql = "";  
         
         if (ubicacion.equals("Frente"))
         {
             sql = "Select numero,borda_cliente,prenda,identificador_prenda,"
                  + ""+ubicacionnombre+","+ubicacioncantidad+","+ubicacionpuntadas+","+ubicacionaplicacion+",tienda"
                  + " from "+tabla+""
                  + " where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = '"+lugar+"'"
                  + "and "+ubicacionfecha+" = '"+fechabusqueda+"' ";
              
         }
         
         else
         {
             
             
             sql = "Select numero,borda_cliente,prenda,identificador_prenda,"
                  + ""+ubicacionnombre+","+ubicacioncantidad+","+ubicacionpuntadas+",tienda"
                  + " from "+tabla+""
                  + " where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = '"+lugar+"'"
                  + "and "+ubicacionfecha+" = '"+fechabusqueda+"' ";
              
                 
                 
                 }
           

         

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = ubicacion;
                datos[5] = rs.getString(5);
                datos[6] = rs.getString(6);
                datos[7] = rs.getString(7);
                datos[8] = "0"; // Preio por puntadas
                datos[9] = "0"; // PUNTOS BORDADOS
                
                
                
                if (ubicacion.equals("Frente"))
                {
                    
                    datos[10] = rs.getString(8);
                }
                else
                {
                    
                    datos[10] = "0";
                }
                
                
                datos[11] = "0"; // Precio por puntadas
                datos[12] = "0"; // PUNTOS APLICACIONES
                datos[13] = "0"; // SUMA PUNTOS
                datos[14] = tabla; //TABLA
                datos[15] = rs.getString(9);
              
                modelo.addRow(datos);
                
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }

    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void datospantalon(int fechabusquedaint) 
    {

        
        
       
        Calendar cal = new GregorianCalendar();

        int dia = fechabusquedaint;
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

        fechabusqueda = (+año + "-" + mesint + "-" + dia);
        
        
        String tabla = "";
        
        
        String ubicacion = "";
        String ubicacionnombre = "";
        String ubicacioncantidad = "";
        String ubicacionpuntadas = "";
        String ubicacionaplicacion = ""; 
        String lugar = "";
        String ubicacionfecha = "";
            
        
         DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();
        String[] datos = new String[18];
        
        
        
        
        
        
        for (int i=1;i<9;i++)
            
            
        {
            
            
            if (i<7)
            {
                 tabla = "historial_ordenes_pantalon";
                 lugar = "Esta sucursal";
                 
            }
            else
            {
                tabla = "historial_ordenes_pantalon_recibidas";
                 lugar = "Otra sucursal";
            }
        
            
        if (i==1 || i==5)
            
        {
            
        //LADO IZQUIERDO FRENTE
       
         
         ubicacion = "Lado izquierdo frente";
         ubicacionnombre = "lado_izquierdo_frente_nombre";
         ubicacioncantidad = "lado_izquierdo_frente_cantidad";
         ubicacionpuntadas = "lado_izquierdo_frente_puntadas";
         
         ubicacionfecha = "lado_izquierdo_frente_fecha";
         
        }
        
        
         if (i==2 || i==6)
            
        {
            
        //LADO DERECHO FRENTE
         
         ubicacion = "Lado derecho frente";
         ubicacionnombre = "lado_derecho_frente_nombre";
         ubicacioncantidad = "lado_derecho_frente_cantidad";
         ubicacionpuntadas = "lado_derecho_frente_puntadas";
       
         ubicacionfecha = "lado_derecho_frente_fecha";
         
        }
         
         
         
           if (i==3 || i==7)
            
        {
            
        //LADO IZQUIERDO ATRAS
         
         ubicacion = "Lado izquierdo atras";
         ubicacionnombre = "lado_izquierdo_atras_nombre";
         ubicacioncantidad = "lado_izquierdo_atras_cantidad";
         ubicacionpuntadas = "lado_izquierdo_atras_puntadas";
        
         ubicacionfecha = "lado_izquierdo_atras_fecha";
         
        }
           
           
            
           if (i==4 || i==8)
            
        {
            
        //LADO DERECHO ATRAS
         
         ubicacion = "Lado derecho atras";
         ubicacionnombre = "lado_derecho_atras_nombre";
         ubicacioncantidad = "lado_derecho_atras_cantidad";
         ubicacionpuntadas = "lado_derecho_atras_puntadas";
        
         ubicacionfecha = "lado_derecho_atras_fecha";
         
        }
           
           

        String sql = "Select numero,borda_cliente,prenda,identificador_prenda,"
                  + ""+ubicacionnombre+","+ubicacioncantidad+","+ubicacionpuntadas+",tienda"
                  + " from "+tabla+""
                  + " where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = '"+lugar+"'"
                  + "and "+ubicacionfecha+" = '"+fechabusqueda+"' ";
              

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = ubicacion;
                datos[5] = rs.getString(5);
                datos[6] = rs.getString(6);
                datos[7] = rs.getString(7);
                datos[8] = "0"; // Preio por puntadas
                datos[9] = "0"; // PUNTOS BORDADOS
                datos[10] = "0";  // APLICACIONES EL PANTALON NO TIENE
                datos[11] = "0"; // Precio por puntadas
                datos[12] = "0"; // PUNTOS APLICACIONES
                datos[13] = "0"; // SUMA PUNTOS
                datos[14] = tabla; //TABLA
                datos[15] = rs.getString(9);
              
                modelo.addRow(datos);
                
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }

    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void datoscorbata(int fechabusquedaint) 
    {

        
        
       
        Calendar cal = new GregorianCalendar();

        int dia = fechabusquedaint;
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

        fechabusqueda = (+año + "-" + mesint + "-" + dia);
        
        
        String tabla = "";
        
        
        String ubicacion = "";
        String ubicacionnombre = "";
        String ubicacioncantidad = "";
        String ubicacionpuntadas = "";
        String ubicacionaplicacion = ""; 
        String lugar = "";
        String ubicacionfecha = "";
            
        
         DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();
        String[] datos = new String[18];
        
        
        
        
        
        
        for (int i=1;i<3;i++)
            
            
        {
            
            
            if (i==1)
            {
                 tabla = "historial_ordenes_corbata";
                 lugar = "Esta sucursal";
                 
            }
            else
            {
                tabla = "historial_ordenes_corbata_recibidas";
                 lugar = "Otra sucursal";
            }
        
            
       
            
        //FRENTE
       
         
         ubicacion = "Frente";
         ubicacionnombre = "frente_nombre";
         ubicacioncantidad = "frente_cantidad";
         ubicacionpuntadas = "frente_puntadas";
         ubicacionfecha = "frente_fecha";
         
      
        
        
         
           

        String sql = "Select numero,borda_cliente,prenda,identificador_prenda,"
                  + ""+ubicacionnombre+","+ubicacioncantidad+","+ubicacionpuntadas+",tienda"
                  + " from "+tabla+""
                  + " where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = '"+lugar+"'"
                  + "and "+ubicacionfecha+" = '"+fechabusqueda+"' ";
              

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = ubicacion;
                datos[5] = rs.getString(5);
                datos[6] = rs.getString(6);
                datos[7] = rs.getString(7);
                datos[8] = "0"; // Preio por puntadas
                datos[9] = "0"; // PUNTOS BORDADOS
                datos[10] = "0"; // APLICACION NO TIENE
                datos[11] = "0"; // Precio por puntadas
                datos[12] = "0"; // PUNTOS APLICACIONES
                datos[13] = "0"; // SUMA PUNTOS
                datos[14] = tabla; //TABLA
                datos[15] = rs.getString(9);
              
                modelo.addRow(datos);
                
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    
    }
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    void datosparche(int fechabusquedaint) 
    {

        
        
       
        Calendar cal = new GregorianCalendar();

        int dia = fechabusquedaint;
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

        fechabusqueda = (+año + "-" + mesint + "-" + dia);
        
        
        String tabla = "";
        
        
        String ubicacion = "";
        String ubicacionnombre = "";
        String ubicacioncantidad = "";
        String ubicacionpuntadas = "";
       
        String lugar = "";
        String ubicacionfecha = "";
            
        
         DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();
        String[] datos = new String[18];
        
        
        
        
        
        
        for (int i=1;i<3;i++)
            
            
        {
            
            
            if (i==1)
            {
                 tabla = "historial_ordenes_parche";
                 lugar = "Esta sucursal";
                 
            }
            else
            {
                tabla = "historial_ordenes_parche_recibidas";
                 lugar = "Otra sucursal";
            }
        
            
       
            
        //PARCHE
       
         
         ubicacion = "Parche";
         ubicacionnombre = "parche_nombre";
         ubicacioncantidad = "parche_cantidad";
         ubicacionpuntadas = "parche_puntadas";
        
         ubicacionfecha = "parche_fecha";
         
      
        
        
         
           

        String sql = "Select numero,borda_cliente,tipo,identificador_prenda,"
                  + ""+ubicacionnombre+","+ubicacioncantidad+","+ubicacionpuntadas+",tienda"
                  + " from "+tabla+""
                  + " where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = '"+lugar+"'"
                  + "and "+ubicacionfecha+" = '"+fechabusqueda+"' ";
              

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = ubicacion;
                datos[5] = rs.getString(5);
                datos[6] = rs.getString(6);
                datos[7] = rs.getString(7);
                datos[8] = "0"; // Preio por puntadas
                datos[9] = "0"; // PUNTOS BORDADOS
                datos[10] = "0"; // APLICACION NO TIENE
                datos[11] = "0"; // Precio por puntadas
                datos[12] = "0"; // PUNTOS APLICACIONES
                datos[13] = "0"; // SUMA PUNTOS
                datos[14] = tabla; //TABLA
                datos[15] = rs.getString(9);
              
                modelo.addRow(datos);
                
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    
    }
    
    
    
    
    }
    
    
    
    
    
    
    void datosdistinta(int fechabusquedaint) 
    {

        
        
       
        Calendar cal = new GregorianCalendar();

        int dia = fechabusquedaint;
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
        
        
        String tabla = "";
        
        
        String ubicacion = "";
        String ubicacionnombre = "";
        String ubicacioncantidad = "";
        String ubicacionpuntadas = "";
        String ubicacionaplicacion = ""; 
        String lugar = "";
        String ubicacionfecha = "";
            
        
         DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();
        String[] datos = new String[18];
        
        
        
        
        
        
        for (int i=1;i<15;i++)
            
            
        {
            
            
            if (i<7)
            {
                 tabla = "historial_ordenes_distinta";
                 lugar = "Esta sucursal";
                 
            }
            else
            {
                tabla = "historial_ordenes_distinta_recibidas";
                 lugar = "Otra sucursal";
                 break;
            }
        
            
        if (i==1 || i==8)
            
        {
            
        //DISTINTA 1
       
         
         ubicacion = "Distinta 1";
         ubicacionnombre = "distinta1_nombre";
         ubicacioncantidad = "distinta1_cantidad";
         ubicacionpuntadas = "distinta1_puntadas";
         ubicacionaplicacion = "distinta1_aplicacion"; 
         ubicacionfecha = "distinta1_fecha";
         
        }
        
        
         if (i==2 || i==9)
            
        {
            
        //DISTINTA 2
         
         ubicacion = "distinta 2";
         ubicacionnombre = "distinta2_nombre";
         ubicacioncantidad = "distinta2_cantidad";
         ubicacionpuntadas = "distinta2_puntadas";
         ubicacionaplicacion = "distinta2_aplicacion"; 
         ubicacionfecha = "distinta2_fecha";
         
        }
         
         
         
           if (i==3 || i==10)
            
        {
            
        //DISTINTA 3
         
         ubicacion = "Distinta 3";
         ubicacionnombre = "distinta3_nombre";
         ubicacioncantidad = "distinta3_cantidad";
         ubicacionpuntadas = "distinta3_puntadas";
         ubicacionaplicacion = "distinta3_aplicacion"; 
         ubicacionfecha = "distinta3_fecha";
         
        }
           
           
            
           if (i==4 || i==11)
            
        {
            
        //DISTINTA 4
         
         ubicacion = "Distinta 4";
         ubicacionnombre = "distinta4_nombre";
         ubicacioncantidad = "distinta4_cantidad";
         ubicacionpuntadas = "distinta4_puntadas";
         ubicacionaplicacion = "distinta4_aplicacion"; 
         ubicacionfecha = "distinta4_fecha";
         
        }
           
           
           
            
           if (i==5 || i==12)
            
        {
            
        //DISTINTA 5
         
         ubicacion = "Distinta 5";
         ubicacionnombre = "distinta5_nombre";
         ubicacioncantidad = "distinta5_cantidad";
         ubicacionpuntadas = "distinta5_puntadas";
         ubicacionaplicacion = "distinta5_aplicacion"; 
         ubicacionfecha = "distinta5_fecha";
         
        }
           
           
           
            
           if (i==6 || i==13)
            
        {
            
        //DISTINTA 6
         
         ubicacion = "Distinta 6";
         ubicacionnombre = "distinta6_nombre";
         ubicacioncantidad = "distinta6_cantidad";
         ubicacionpuntadas = "distinta6_puntadas";
         ubicacionaplicacion = "distinta6_aplicacion"; 
         ubicacionfecha = "distinta6_fecha";
         
        }
           
           
           
           
           
            
           if (i==7 || i==14)
            
        {
            
        //DISTINTA 7
         
         ubicacion = "Distinta 7";
         ubicacionnombre = "distinta7_nombre";
         ubicacioncantidad = "distinta7_cantidad";
         ubicacionpuntadas = "distinta7_puntadas";
         ubicacionaplicacion = "distinta7_aplicacion"; 
         ubicacionfecha = "distinta7_fecha";
         
        }
        
        

        String sql = "Select numero,borda_cliente,prenda,identificador_prenda,"
                  + ""+ubicacionnombre+","+ubicacioncantidad+","+ubicacionpuntadas+","+ubicacionaplicacion+",tienda"
                  + " from "+tabla+""
                  + " where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and lugar = '"+lugar+"'"
                  + "and "+ubicacionfecha+" = '"+fechabusqueda+"' ";
              

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = ubicacion;
                datos[5] = rs.getString(5);
                datos[6] = rs.getString(6);
                datos[7] = rs.getString(7);
                datos[8] = "0"; // Preio por puntadas
                datos[9] = "0"; // PUNTOS BORDADOS
                datos[10] = rs.getString(8);
                datos[11] = "0"; // Precio por puntadas
                datos[12] = "0"; // PUNTOS APLICACIONES
                datos[13] = "0"; // SUMA PUNTOS
                datos[14] = tabla; //TABLA
                datos[15] = rs.getString(9);
              
                modelo.addRow(datos);
                
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    }

    
    }
    
    
    
    
    void datosportanombre(int fechabusquedaint) 
    {

        
        
       
        Calendar cal = new GregorianCalendar();

        int dia = fechabusquedaint;
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
        
        
        String tabla = "";
        
        
        String ubicacion = "";
        String ubicacionnombre = "";
        String ubicacioncantidad = "";
        String ubicacionpuntadas = "";
       
        String lugar = "";
        String ubicacionfecha = "";
            
        
         DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();
        String[] datos = new String[18];
        
        
        
        
          
                 tabla = "historial_ordenes_portanombres";
                 lugar = "Esta sucursal";
          
            
       
         
          ubicacion = "Porta nombre";
          ubicacioncantidad = "cantidad";
          ubicacionfecha = "fecha";
         
      
        
        
         
           

        String sql = "Select numero,cliente,tipo,"+ubicacioncantidad+" from "+tabla+" where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and "+ubicacionfecha+" = '"+fechabusqueda+"'";
                 
        
        

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = "0";
                datos[4] = ubicacion;
                datos[5] = "Porta nombre";
                datos[6] = rs.getString(4);
                datos[7] = "BORDADO DE 12,500 A 15,000 PUNTADAS";
                datos[8] = "0"; // Preio por puntadas
                datos[9] = "0"; // PUNTOS BORDADOS
                datos[10] = "0";// APLICACIONES
                datos[11] = "0"; // Precio por puntadas
                datos[12] = "0"; // PUNTOS APLICACIONES
                datos[13] = "0"; // SUMA PUNTOS
                datos[14] = tabla; //TABLA
                datos[15] = tiendalocal;
              
                modelo.addRow(datos);
                
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    
    
    
    }
    
    
    
 
    
    
     
    
    void datosportanombremultiple(int fechabusquedaint) 
    {

        
        
       
        Calendar cal = new GregorianCalendar();

        int dia = fechabusquedaint;
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

        fechabusqueda = (+año + "-" + mesint + "-" + dia);
        
        
        String tabla = "";
        
        
        String ubicacion = "";
        String ubicacionnombre = "";
        String ubicacioncantidad = "";
        String ubicacionpuntadas = "";
       
        String lugar = "";
        String ubicacionfecha = "";
            
        
         DefaultTableModel modelo = (DefaultTableModel) tabladerecha.getModel();
        String[] datos = new String[18];
        
        
        
        
          
                 tabla = "historial_ordenes_portanombres_multiple";
                 lugar = "Esta sucursal";
          
            
       
         
          ubicacion = "Porta nombre multiple";
          ubicacioncantidad = "cantidad";
          ubicacionfecha = "fecha";
         
      
        
        
         
           

        String sql = "Select numero,cliente,tipo,"+ubicacioncantidad+" from "+tabla+" where (estatus_orden = 'realizada parcialmente' or estatus_orden = 'realizada totalmente') and "+ubicacionfecha+" = '"+fechabusqueda+"'";
                 
        
        

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = "0";
                datos[4] = ubicacion;
                datos[5] = "Porta nombre";
                datos[6] = rs.getString(4);
                datos[7] = "BORDADO DE 10,000 A 12,500 PUNTADAS";
                datos[8] = "0"; // Preio por puntadas
                datos[9] = "0"; // PUNTOS BORDADOS
                datos[10] = "0";// APLICACIONES
                datos[11] = "0"; // Precio por puntadas
                datos[12] = "0"; // PUNTOS APLICACIONES
                datos[13] = "0"; // SUMA PUNTOS
                datos[14] = tabla; //TABLA
                datos[15] = tiendalocal;
              
                modelo.addRow(datos);
                
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }


    
    
    
    }
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void puntos(){
        
        
        
        
        double totalpuntosbordadosdouble = 0.0;
        double totalpuntosaplicaciondouble = 0.0;
        
        
        String sumatotalesstring = "0";
        double sumatotalesdouble = 0.0;
        
        
        for (int i = 0; i<tabladerecha.getRowCount(); i++)

            
        {
            
            String puntosbordadosstring = "0";
            double puntdosbordadosdouble = 0.0;
            
            String puntosaplicacionstring = "0";
            double puntosaplicaciondouble = 0.0;
            
            
            String costobordadostring = "";
            double costobordadodouble = 0.0;
            
            String costoaplicacionstring = "";
            double costoaplicaciondouble = 0.0;
            
            Object cantidadobject = tabladerecha.getValueAt(i, 6);
            Double cantidaddouble = Double.parseDouble(cantidadobject.toString());
            
            Object puntadas = tabladerecha.getValueAt(i, 7);
          
            Object aplicacionesobject = tabladerecha.getValueAt(i, 10);
            Double aplicacionesdouble = Double.parseDouble(aplicacionesobject.toString());
            
            Object ubicacion = tabladerecha.getValueAt(i, 4);
            
            
            //BORDADOS
            String sql = "SELECT costo from catalogo_costos_bordado where puntadas = '" + puntadas + "'";

            try {
                PreparedStatement prst = cn.prepareStatement(sql);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next())
                {

                    costobordadostring = rs2.getString("costo");
                    costobordadodouble = Double.parseDouble(costobordadostring);
                   
                    tabladerecha.setValueAt(costobordadostring, i, 8);
                    
                  

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }
            
            
            //APLICACIONES
            
            String sql2 = "";
            
            if (ubicacion.toString().contains("Espalda"))
            {
                sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION GRANDE'";
            }
            else
            {
              sql2 = "SELECT costo from catalogo_costos_bordado where puntadas = 'APLICACION CHICA'";
              
            }

            try {
                PreparedStatement prst = cn.prepareStatement(sql2);
                ResultSet rs2 = prst.executeQuery();
                if (rs2.next())
                {

                    costoaplicacionstring = rs2.getString("costo");
                    costoaplicaciondouble = Double.parseDouble(costoaplicacionstring);
                    
                    
                      if (aplicacionesobject.equals("0"))
                    {
                        
                    }
                    else
                    {
                    
                    tabladerecha.setValueAt(costoaplicacionstring, i, 11);
                    
                    }
                      
                      

                }
            } catch (Exception exx) {
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:5px;\">"+exx+"");

            }

            
            
            puntdosbordadosdouble = cantidaddouble * costobordadodouble;
            puntosbordadosstring = String.format("%.02f ", puntdosbordadosdouble);
            tabladerecha.setValueAt(puntosbordadosstring, i, 9);
            
            puntosaplicaciondouble = cantidaddouble * costoaplicaciondouble * aplicacionesdouble;
            puntosaplicacionstring = String.format("%.02f ", puntosaplicaciondouble);
            tabladerecha.setValueAt(puntosaplicacionstring, i, 12);
            
            
            
            double sumapuntosdeouble = puntdosbordadosdouble + puntosaplicaciondouble;
            String sumapuntosstring = String.format("%.02f ", sumapuntosdeouble);        
                    
            tabladerecha.setValueAt(sumapuntosstring, i, 13);
            
            
            
            
            
            totalpuntosbordadosdouble = totalpuntosbordadosdouble + puntdosbordadosdouble;
            
            totalpuntosaplicaciondouble = totalpuntosaplicaciondouble + puntosaplicaciondouble;
             
            
            
            
            
            
            
            
            
            
            
            
            
        }
        
            sumatotalesdouble  =  totalpuntosbordadosdouble + totalpuntosaplicaciondouble;
        
        
            sumatotalesstring = String.format("%.02f ", sumatotalesdouble);
            lbsumatrabladerechobordados.setText(sumatotalesstring);
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    
     void datosponchadosmodificados(int i) {

        DefaultTableModel modelo2 = (DefaultTableModel) tablaVIEJA.getModel();
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

        fechabusqueda = (+año + "-" + mesint + "-" + dia);

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
     
     
     
     
     
     */
     
    
    void fechasemanaactual(){
        
        
        {
        
          LocalDate currentDate = LocalDate.now();

        // Calcular la cantidad de días para retroceder al pasado lunes
        int daysToSubtract = (currentDate.getDayOfWeek().getValue() + 6) % 7;
        LocalDate pastMonday = currentDate.minusDays(daysToSubtract);
        diainicial = pastMonday.getDayOfMonth();
        mesinicial = pastMonday.getMonthValue();
        añoinicial =  pastMonday.getYear();

        // Calcular la cantidad de días para avanzar al próximo domingo
        int daysToAdd = (DayOfWeek.SUNDAY.getValue() + 7 - currentDate.getDayOfWeek().getValue()) % 7;
        LocalDate nextSunday = currentDate.plusDays(daysToAdd);
        diafinal = nextSunday.getDayOfMonth();
        mesfinal = nextSunday.getMonthValue();
        añofinal = nextSunday.getYear();

       
    }
        
        
        
        
        fechainicial = (+diainicial +"/" + mesinicial + "/" + añofinal);
        fechafinal = (+diafinal + "/" + mesfinal + "/" + añofinal);
        
        
        
        try {
            SimpleDateFormat sdfSource = new SimpleDateFormat("d/MM/yyyy");

            java.util.Date date2 = sdfSource.parse(fechainicial);

            SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/MM/dd");

            fechainicial = sdfDestination.format(date2);

        } catch (Exception pe) {

        }
        
        
        
        
        try {
            SimpleDateFormat sdfSource = new SimpleDateFormat("d/MM/yyyy");

            java.util.Date date2 = sdfSource.parse(fechafinal);

            SimpleDateFormat sdfDestination = new SimpleDateFormat("yyyy/MM/dd");

            fechafinal = sdfDestination.format(date2);

        } catch (Exception pe) {

        }
        
        
        
        
        lbinicio.setText(fechainicial);
        lbfin.setText(fechafinal);
        
    }
        
        
    
    
    
    
    
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

       // lbmes.setText(messtring);

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
    
    
    
    
    
    
    
    
    

        
        
        
        
        
        
        
        /*
    
    void actualizarlasuma() {
        String mes = lbmes.getText();
        String año = lbaño.getText();
        String suma = lbsumatablaizquierda.getText();
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
    
    
    */
    
    
    
    
    
    
    
    
    
    
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
        fechabusqueda = (+año + "-" + mesint + "-" + dia);
        
        

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
        
        

    //    calcularcostofotomontajes();

    }
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    ////////////////////////////
    //////////////////
    //////////       
     
     
     /*
    void calcularcostofotomontajes() {

        double importedelfotomontaje = 0.0;
        String costostring = "0";

        for (int i = 0; i < tablaVIEJA.getRowCount(); i++) 
        {

            Object cantidadobject = tablaVIEJA.getValueAt(i, 2);
            Object articulo = tablaVIEJA.getValueAt(i, 3);
            int cantidad = Integer.parseInt(cantidadobject.toString());
            String articulobuscar = "";

            if (articulo.toString().equals("FOTOMONTAJE")) 
            {

                
                articulobuscar = articulo.toString();

                tablaVIEJA.setValueAt(articulobuscar, i, 5);

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
                tablaVIEJA.setValueAt(costofotomontajestring, i, 6);

                double importefotomontaje = cantidad * costodelfotomontaje;

                double sumabordados = importefotomontaje;
                String sumafotomontajesstring = String.format("%.02f ", sumabordados);
                tablaVIEJA.setValueAt(sumafotomontajesstring, i, 62);

            }

        }

    }

    
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog = new javax.swing.JDialog();
        txtdialogoubic = new javax.swing.JTextField();
        btndialogoguardar = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        btndialogoaceptar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        btnanterior = new javax.swing.JButton();
        btnsiguiente = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lbaño = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaizquierda = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbsumatablaizquierda = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbdia = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabladerecha = new javax.swing.JTable()
        {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        }

        ;
        jLabel3 = new javax.swing.JLabel();
        lbsumatrabladerechobordados = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbfotomontajes = new javax.swing.JLabel();
        lbsumatrabladerecha2 = new javax.swing.JLabel();
        lbsuma = new javax.swing.JLabel();
        lbinicio = new javax.swing.JLabel();
        lbfin = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

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
        setMinimumSize(new java.awt.Dimension(1400, 800));
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(null);

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnsalir);
        btnsalir.setBounds(1779, 5, 102, 30);

        btnanterior.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnanterior.setText("<");
        btnanterior.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanteriorActionPerformed(evt);
            }
        });
        getContentPane().add(btnanterior);
        btnanterior.setBounds(532, 5, 86, 30);

        btnsiguiente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsiguiente.setText(">");
        btnsiguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsiguienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnsiguiente);
        btnsiguiente.setBounds(628, 5, 88, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Año");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel4);
        jLabel4.setBounds(886, 5, 32, 30);

        lbaño.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbaño.setText("0000");
        lbaño.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbaño);
        lbaño.setBounds(925, 5, 109, 30);

        tablaizquierda.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tablaizquierda.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Fecha", "Importe del día", "Color", "Dia"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
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
            tablaizquierda.getColumnModel().getColumn(0).setMinWidth(20);
            tablaizquierda.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaizquierda.getColumnModel().getColumn(0).setMaxWidth(80);
            tablaizquierda.getColumnModel().getColumn(2).setMinWidth(0);
            tablaizquierda.getColumnModel().getColumn(2).setPreferredWidth(0);
            tablaizquierda.getColumnModel().getColumn(2).setMaxWidth(0);
        }

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(5, 50, 190, 895);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Suma");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel1);
        jLabel1.setBounds(6, 960, 54, 30);

        lbsumatablaizquierda.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbsumatablaizquierda.setForeground(new java.awt.Color(153, 0, 0));
        lbsumatablaizquierda.setText("0.00");
        lbsumatablaizquierda.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbsumatablaizquierda);
        lbsumatablaizquierda.setBounds(67, 960, 92, 30);

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsumapuntos.setText("0.00");
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbsumapuntos);
        lbsumapuntos.setBounds(1768, 959, 113, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Dia:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel6);
        jLabel6.setBounds(728, 5, 30, 30);

        lbdia.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbdia.setText("00");
        lbdia.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbdia);
        lbdia.setBounds(765, 5, 103, 30);

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Historial de horas de ayuda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(1498, 5, 263, 30);

        tabladerecha.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabladerecha.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orden", "Bordacliente", "Prenda", "Identificador", "Ubicacion", "Nombre bordado", "Cant", "Puntadas", "Costo punt", "Puntos", "Aplicac", "Costo aplic", "Puntos ap", "Suma", "Tabla", "sucursal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabladerecha.setAutoscrolls(false);
        tabladerecha.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabladerecha.setRowHeight(22);
        tabladerecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladerechaMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabladerecha);
        if (tabladerecha.getColumnModel().getColumnCount() > 0) {
            tabladerecha.getColumnModel().getColumn(0).setMinWidth(50);
            tabladerecha.getColumnModel().getColumn(0).setPreferredWidth(70);
            tabladerecha.getColumnModel().getColumn(0).setMaxWidth(80);
            tabladerecha.getColumnModel().getColumn(1).setMinWidth(120);
            tabladerecha.getColumnModel().getColumn(1).setPreferredWidth(350);
            tabladerecha.getColumnModel().getColumn(1).setMaxWidth(400);
            tabladerecha.getColumnModel().getColumn(2).setMinWidth(80);
            tabladerecha.getColumnModel().getColumn(2).setPreferredWidth(140);
            tabladerecha.getColumnModel().getColumn(2).setMaxWidth(180);
            tabladerecha.getColumnModel().getColumn(3).setMinWidth(0);
            tabladerecha.getColumnModel().getColumn(3).setPreferredWidth(0);
            tabladerecha.getColumnModel().getColumn(3).setMaxWidth(0);
            tabladerecha.getColumnModel().getColumn(4).setMinWidth(80);
            tabladerecha.getColumnModel().getColumn(4).setPreferredWidth(100);
            tabladerecha.getColumnModel().getColumn(4).setMaxWidth(120);
            tabladerecha.getColumnModel().getColumn(5).setMinWidth(100);
            tabladerecha.getColumnModel().getColumn(5).setPreferredWidth(200);
            tabladerecha.getColumnModel().getColumn(5).setMaxWidth(250);
            tabladerecha.getColumnModel().getColumn(6).setMinWidth(40);
            tabladerecha.getColumnModel().getColumn(6).setPreferredWidth(60);
            tabladerecha.getColumnModel().getColumn(6).setMaxWidth(70);
            tabladerecha.getColumnModel().getColumn(7).setMinWidth(80);
            tabladerecha.getColumnModel().getColumn(7).setPreferredWidth(230);
            tabladerecha.getColumnModel().getColumn(7).setMaxWidth(270);
            tabladerecha.getColumnModel().getColumn(8).setMinWidth(50);
            tabladerecha.getColumnModel().getColumn(8).setPreferredWidth(70);
            tabladerecha.getColumnModel().getColumn(8).setMaxWidth(80);
            tabladerecha.getColumnModel().getColumn(9).setMinWidth(50);
            tabladerecha.getColumnModel().getColumn(9).setPreferredWidth(70);
            tabladerecha.getColumnModel().getColumn(9).setMaxWidth(80);
            tabladerecha.getColumnModel().getColumn(10).setMinWidth(50);
            tabladerecha.getColumnModel().getColumn(10).setPreferredWidth(70);
            tabladerecha.getColumnModel().getColumn(10).setMaxWidth(80);
            tabladerecha.getColumnModel().getColumn(11).setMinWidth(50);
            tabladerecha.getColumnModel().getColumn(11).setPreferredWidth(70);
            tabladerecha.getColumnModel().getColumn(11).setMaxWidth(80);
            tabladerecha.getColumnModel().getColumn(12).setMinWidth(20);
            tabladerecha.getColumnModel().getColumn(12).setPreferredWidth(80);
            tabladerecha.getColumnModel().getColumn(12).setMaxWidth(100);
            tabladerecha.getColumnModel().getColumn(13).setMinWidth(20);
            tabladerecha.getColumnModel().getColumn(13).setPreferredWidth(80);
            tabladerecha.getColumnModel().getColumn(13).setMaxWidth(100);
        }

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(204, 50, 1628, 758);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Bordados");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1575, 821, 121, 30);

        lbsumatrabladerechobordados.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsumatrabladerechobordados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbsumatrabladerechobordados.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbsumatrabladerechobordados);
        lbsumatrabladerechobordados.setBounds(1714, 821, 167, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Fotomontajes");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1575, 858, 126, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Horas de ayuda");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel7);
        jLabel7.setBounds(1575, 895, 126, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Suma");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel8);
        jLabel8.setBounds(1575, 932, 94, 30);

        lbfotomontajes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfotomontajes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbfotomontajes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbfotomontajes);
        lbfotomontajes.setBounds(1713, 858, 167, 30);

        lbsumatrabladerecha2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsumatrabladerecha2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbsumatrabladerecha2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbsumatrabladerecha2);
        lbsumatrabladerecha2.setBounds(1713, 895, 167, 30);

        lbsuma.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsuma.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbsuma.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbsuma);
        lbsuma.setBounds(1713, 922, 167, 30);

        lbinicio.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbinicio.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbinicio);
        lbinicio.setBounds(36, 5, 130, 30);

        lbfin.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbfin.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(lbfin);
        lbfin.setBounds(204, 5, 130, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("al");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel9);
        jLabel9.setBounds(178, 5, 14, 30);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Del");
        jLabel10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jLabel10);
        jLabel10.setBounds(6, 5, 23, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

        mesfinal = -1;
        ventanareportedebordadosgeneral = false;
    //    actualizarlasuma();
        this.dispose();

    }//GEN-LAST:event_formWindowClosing

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed

        mesfinal = -1;
        ventanareportedebordadosgeneral = false;
    //    actualizarlasuma();
        this.dispose();


    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnanteriorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanteriorActionPerformed

       btnsiguiente.setEnabled(true);
      //  mesfinal = mesfinal - 1;}}
      
      
       limpiartablafechas();
      
      
      diasquevoyasumarorestar = diasquevoyasumarorestar - 7;
      
      
      fechasemanaanterior();
      
      
      
        lbdia.setText("0");
       
    //    seleccionarfechas();
        
        
        datostablaizquierda();


    }//GEN-LAST:event_btnanteriorActionPerformed

    private void btnsiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsiguienteActionPerformed

        btnanterior.setEnabled(true);

     //   mesfinal = mesfinal + 1;
      //  lbdia.setText("0");
     //   limpiartablafechas();
     //   seleccionarfechas();
     
     
     limpiartablafechas();
     
    // fechasiguiente();
     
     diasquevoyasumarorestar = diasquevoyasumarorestar  + 7;
      
      
      fechasemanaanterior();
     
     
     
     
      
      
      
    //    lbdia.setText("0");
      //  limpiartablafechas();
    //    seleccionarfechas();
        
        
        datostablaizquierda();

     


    }//GEN-LAST:event_btnsiguienteActionPerformed

    private void tablaizquierdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaizquierdaMouseClicked

        
        
        String sumaladoizquierdo = "";
               double sumaladoizquierdodouble = 0;
        
        
        if (evt.getClickCount() == 1) 
        {

            int fila = tablaizquierda.getSelectedRow();

         

                Object diabusqueda = tablaizquierda.getValueAt(fila, 0);
                lbdia.setText(diabusqueda.toString());
                int fechabusquedaint = Integer.parseInt(diabusqueda.toString());

                limpiartabla();
                
                
                
                
          /*      
                
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

        fechabusqueda = (+año + "-" + mesfinal + "-" + dia);
                
                
             */   
                
                
                
                
                
                
                
                
                
                
                
                
               
                
                
                
                
                
                datoscamisa((int) fechabusquedaint);
                datosgorra((int) fechabusquedaint);
                datospantalon((int) fechabusquedaint);
                datoscorbata((int) fechabusquedaint);
                datosparche((int) fechabusquedaint);
                datosdistinta((int) fechabusquedaint);
                datosportanombre((int) fechabusquedaint);
                datosportanombremultiple((int) fechabusquedaint);
               
            
          //      datosfotomontajes((int) fechabusquedaint);
                
                puntos();
                
                
               
            //   datosponchadosmodificados((int) fechabusquedaint);
                
                
                
                
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
            
             /////
        
        String cantidadfotomontajes = "";
        String nombrefotomontaje = "";
        double importefotomontajes = 0;
        double sumatotaldelosfotomontajes = 0;
        double costofotomontajesdouble = 0.0;
        String costostring = "0";
        
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
                
                

             
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
       
       
            
               importefotomontajes = cantidadfotomontajesint * costofotomontajesdouble;

              
                sumatotaldelosfotomontajes = sumatotaldelosfotomontajes + importefotomontajes;
                
                String fotomontajesstring = String.format("%.02f ", sumatotaldelosfotomontajes);
                
                lbfotomontajes.setText(fotomontajesstring);
                
                
                String sumaladoderechobordadosstring = lbsumatrabladerechobordados.getText();
        
        if (sumaladoderechobordadosstring.equals(""))
        {
            sumaladoderechobordadosstring = "0";
        }
        
        double sumaladodechobordadosdouble = Double.parseDouble(sumaladoderechobordadosstring);
        
        
        double sumaladoderechotodos = sumaladodechobordadosdouble + importefotomontajes;
         String ladoderechotodosstring = String.format("%.02f ", sumaladoderechotodos);
       lbsuma.setText(ladoderechotodosstring);
         
                
                sumaladoizquierdo = tablaizquierda.getValueAt(fila, 1).toString();
               sumaladoizquierdodouble = Double.parseDouble(sumaladoizquierdo);
               
               
               
               
              
                
                
        double diferencia = sumaladoderechotodos - sumaladoizquierdodouble;
        
        if (diferencia>2 || diferencia < -2)
        {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:15px;\">Hay diferencia entre la cantidad del lado izquierdo y la suma de la tabla derecha; por favor llame a sistemas");
        }
               
               
               
                
                
                

            
            
            
            
            
            
                
                
                 
          TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(tabladerecha.getModel());
        tabladerecha.setRowSorter(sorter);

        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.DESCENDING));
      
        
  
        sorter.setSortKeys(sortKeys);
        
        
        
        
        
          
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        historialayudabordador ventana =  new historialayudabordador();
        historialayudabordador.lbaño.setText(lbaño.getText());
   //     historialayudabordador.cbmes.setSelectedItem(lbmes.getText());
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        

    }//GEN-LAST:event_jButton3ActionPerformed

    private void tabladerechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladerechaMouseClicked
      
        
        
          if (evt.getClickCount() == 2)
        
        {
        
        
        
        int renglon = tabladerecha.getSelectedRow();
        
        Object numero = tabladerecha.getValueAt(renglon, 0);
        Object prenda = tabladerecha.getValueAt(renglon, 2);
        Object tabla = tabladerecha.getValueAt(renglon, 14);
        Object sucursal = tabladerecha.getValueAt(renglon, 14);
        
        Object lugar = "";
        
        
        
                // CAMISA
                                                                              
                if (tabla.equals("historial_ordenes_camisa") || tabla.equals("historial_ordenes_camisa_recibidas")) 
                {
                    
                    Object tipo = "Camisa";
                    
                    
                    
                    if (ordencamisaS.ventanaordencamisa == true) 
                    {
                        
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de camisa ya está abierta");

                    }
                    else 
                    {
                        
                      if (tabla.equals("historial_ordenes_camisa") ) 
                { 
                         lugar = "Esta sucursal";   
                }     
                      else
                      {
                          
                          lugar = "Otra sucursal";   
                      }
                      
                      
                      
                      
                        
                        ordencamisaS ventana = new ordencamisaS();
                        ventana.setVisible(true);

                        ordencamisaS.lborden.setText(numero.toString());
                        ordencamisaS.lbprenda.setText(prenda.toString());
                        ordencamisaS.lbtipo.setText(tipo.toString());
                        ordencamisaS.enquesucursalsebordara =(lugar.toString());
                       
                        
                        
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordencamisaS.lbsucursal.setText(sucursal.toString());
                        
                        
                        ordencamisaS.tipotabla=(tabla.toString());
                    
                        
                      
                        
                        
                       
                    }

                
                }
               
                
                
             
                
                
                
                
                
                
        
                // GORRA
                                                                              
                if (tabla.equals("historial_ordenes_camisa") || tabla.equals("historial_ordenes_camisa_recibidas")) 
                {
                    
                    Object tipo = "Camisa";
                    
                    
                    
                    if (ordencamisaS.ventanaordencamisa == true) 
                    {
                        
                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La orden de camisa ya está abierta");

                    }
                    else 
                    {
                        
                      if (tabla.equals("historial_ordenes_camisa") ) 
                { 
                         lugar = "Esta sucursal";   
                }     
                      else
                      {
                          
                          lugar = "Otra sucursal";   
                      }
                      
                      
                      
                      
                        
                        ordencamisaS ventana = new ordencamisaS();
                        ventana.setVisible(true);

                        ordencamisaS.lborden.setText(numero.toString());
                        ordencamisaS.lbprenda.setText(prenda.toString());
                        ordencamisaS.lbtipo.setText(tipo.toString());
                        ordencamisaS.enquesucursalsebordara =(lugar.toString());
                       
                        
                        
                        if (sucursal==null || sucursal.equals(""))
                        {
                            sucursal = tiendalocal;
                        }
                        ordencamisaS.lbsucursal.setText(sucursal.toString());
                        
                        
                        ordencamisaS.tipotabla=(tabla.toString());
                    
                        
                      
                        
                        
                       
                    }

                
                }
               
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
                
        
        
        }
        
        
        
    }//GEN-LAST:event_tabladerechaMouseClicked

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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel lbaño;
    public static javax.swing.JLabel lbdia;
    public static javax.swing.JLabel lbfin;
    private javax.swing.JLabel lbfotomontajes;
    public static javax.swing.JLabel lbinicio;
    private javax.swing.JLabel lbsuma;
    private javax.swing.JLabel lbsumapuntos;
    private javax.swing.JLabel lbsumatablaizquierda;
    private javax.swing.JLabel lbsumatrabladerecha2;
    private javax.swing.JLabel lbsumatrabladerechobordados;
    private javax.swing.JTable tabladerecha;
    private javax.swing.JTable tablaizquierda;
    private javax.swing.JTextField txtdialogoubic;
    // End of variables declaration//GEN-END:variables
coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();

}
