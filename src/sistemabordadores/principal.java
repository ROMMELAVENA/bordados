
package sistemabordadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class principal extends javax.swing.JFrame {

String fechafinal = "";
    String fechainicial = "";
    String anterior = "";
    String messtring = "";

    int diafinal = 0;
    int mesfinal = -1;
    int añofinal = 0;

    int ultimomes = 0;
    int ultimoaño = 0;


    public principal() {
        initComponents();
        
        jScrollPane2.setVisible(false);
        lbsumapuntos.setVisible(false);
        
        this.setLocationRelativeTo(null);
        
        jLabel1.setVisible(false);
        
    }

    public int obtenerUltimoDiaMes(int anio, int mes) {

        Calendar cal = new GregorianCalendar();

        cal.set(anio, mes - 1, 1);
        return cal.getActualMaximum(Calendar.DAY_OF_MONTH);

    }
    
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

        
        año = añofinal;

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
        
        String sql = "Select codigo,fecha,cliente,cantidad,prenda,pecho_izquierdo_nombre,pecho_izquierdo,pecho_derecho_nombre,pecho_derecho,manga_izquierda_nombre,manga_izquierda,manga_derecha_nombre,manga_derecha,espalda_nombre,espalda,aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,otra_ubicacion,otra_ubicacion2 from historial_ordenes_camisa where estatus_orden = 'generada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cantidadbordados = rs.getString("cantidad");
                pechoizquierdo = rs.getString("pecho_izquierdo");
                pechoderecho = rs.getString("pecho_derecho");
                mangaizquierda = rs.getString("manga_izquierda");
                mangaderecha = rs.getString("manga_derecha");
                espalda = rs.getString("espalda");
                otraubicacion = rs.getString("otra_ubicacion");
                otraubicacion2 = rs.getString("otra_ubicacion2");
                aplicacionpechoizquierdo = rs.getString("aplicacion_pecho_izquierdo");
                aplicacionpechoderecho = rs.getString("aplicacion_pecho_derecho");
                aplicacionmangaizquierda = rs.getString("aplicacion_manga_izquierda");
                aplicacionmangaderecha = rs.getString("aplicacion_manga_derecha");
                aplicacionespalda = rs.getString("aplicacion_espalda");

                /////////////////////////////////////////////////////////////////////////////
                if (cantidadbordados == null || cantidadbordados.equals("")) {
                    cantidadbordados = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordados);

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

                importepechoizquierdo = cantidad * costopuntadapechoizquierdo;

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

                importepechoderecho = cantidad * costopuntadapechoderecho;

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

                importemangaizquierda = cantidad * costopuntadamangaizquierda;

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

                importemangaderecha = cantidad * costopuntadamangaderecha;

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

                importeespalda = cantidad * costopuntadaespalda;

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

                importeotraubicacion = cantidad * costopuntadaotraubicacion;

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

                importeotraubicacion2 = cantidad * costopuntadaotraubicacion2;

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
        String sqlcamisasrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,pecho_izquierdo_nombre,pecho_izquierdo,pecho_derecho_nombre,pecho_derecho,manga_izquierda_nombre,manga_izquierda,manga_derecha_nombre,manga_derecha,espalda_nombre,espalda,aplicacion_pecho_izquierdo,aplicacion_pecho_derecho,aplicacion_manga_izquierda,aplicacion_manga_derecha,aplicacion_espalda,otra_ubicacion from historial_ordenes_camisa_recibidas where estatus_orden = 'generada'  and fecha = '" + fechabusqueda + "' order by codigo ";

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

////////////////////// GORRAS
        String sqlgorras = "Select codigo,fecha,cliente,cantidad,prenda,puntadas_lado_izquierdo,puntadas_lado_derecho,puntadas_frente,puntadas_atras,aplicacion_frente from historial_ordenes_gorra where estatus_orden = 'generada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

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
        String sqlgorrasrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,puntadas_lado_izquierdo,puntadas_lado_derecho,puntadas_frente,puntadas_atras,aplicacion_frente from historial_ordenes_gorra_recibidas where estatus_orden = 'generada' and fecha = '" + fechabusqueda + "' order by codigo ";

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

        String sqlgorrasinternas = "Select cantidad,descripcion from historial_ordenes_bordados_interno where (estatus_entrega = 'entregada' or estatus_entrega = 'solicitada') AND fecha = '" + fechabusqueda + "'  AND prenda = 'Gorra' order by numero ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlgorrasinternas);

            while (rs.next()) {

                cantidadbordadosordeninterna = rs.getString("cantidad");
                descripcion = rs.getString("descripcion");

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

            rs.close();
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

        String sqlparchesinternos = "Select cantidad,descripcion from historial_ordenes_bordados_interno where (estatus_entrega = 'entregada' or estatus_entrega = 'solicitada') AND fecha = '" + fechabusqueda + "'  AND prenda = 'Parche' order by numero ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlparchesinternos);

            while (rs.next()) {

                cantidadbordadosordeninterna = rs.getString("cantidad");
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
        String sqlpantalon = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_frente_puntadas,lado_derecho_frente_puntadas,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas from historial_ordenes_pantalon where estatus_orden = 'generada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

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
        String sqlpantalonrecibidas = "Select codigo,fecha,cliente,cantidad,prenda,lado_izquierdo_frente_puntadas,lado_derecho_frente_puntadas,lado_izquierdo_atras_puntadas,lado_derecho_atras_puntadas from historial_ordenes_pantalon_recibidas where estatus_orden = 'generada' and fecha = '" + fechabusqueda + "' order by codigo ";

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

        String sqlparches = "Select codigo,fecha,cliente,cantidad,parche,puntadas from historial_ordenes_parche where estatus_orden = 'generada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

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

        String sqlparchesrecibidos = "Select codigo,fecha,cliente,cantidad,parche from historial_ordenes_parche_recibidos where estatus_orden = 'generada' and fecha = '" + fechabusqueda + "' order by codigo ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sqlparchesrecibidos);

            while (rs.next()) {

                cantidadbordadosrecibidos = rs.getString("cantidad");

                if (cantidadbordadosrecibidos == null || cantidadbordadosrecibidos.equals("")) {
                    cantidadbordadosrecibidos = "0";
                }

                int cantidad = Integer.parseInt(cantidadbordados);

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
        String sqlcorbatas = "Select codigo,fecha,cliente,cantidad_bordados,prenda,frente_puntadas from historial_ordenes_corbata where estatus_orden = 'generada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "' order by codigo ";

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

        String sqlportanombre = "Select fecha,cantidad,prenda from historial_ordenes_portanombres where fecha = '" + fechabusqueda + "'  order by numero   ";

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

        String sqlportanombremultiple = "Select fecha,cantidad_total from historial_ordenes_portanombres_multiple where fecha = '" + fechabusqueda + "'  order by numero   ";

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

        String sqlponchados = "Select numero,fecha,cliente,articulo,cantidad  from historial_ordenes_ponchados where estatus_orden = 'generada' and lugar = 'Esta sucursal' and fecha = '" + fechabusqueda + "'  order by codigo ";

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
        

        String sqlponchadosmodificados = " Select numero,fecha,nombre_cliente,articulo,cantidad,numero  from HISTORIAL_VENTAS where estatus_pago not like ('%cancelada%') and fecha = '" + fechabusqueda + "'  order by numero ";

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
        //suma de los bordados
        /////
        double sumatotaldelosbordadosdouble = sumatotaldelosbordados + sumatotaldelosbordadosrecibidos + sumatotaldelosbordadosgorra + sumatotaldelosbordadosgorrarecibidas + sumatotaldelosbordadospantalon + sumatotaldelosbordadospantalonrecibidas + sumatotaldelosbordadosparche + sumatotaldelosbordadosparcherecibidos + sumatotaldelosbordadoscorbata + sumatotaldelosbordadosgorrainterna + sumatotaldelosbordadosparcheinterna + sumatotaldelosbordadosportanombre + sumatotaldelosbordadosportanombremultiple + sumatotaldelosponchados + sumatotaldelosponchadosmodificados;
        String sumabordadosstring = String.format("%.02f ", sumatotaldelosbordadosdouble);

        tablafecha.setValueAt(sumabordadosstring, i - 1, 1);

    }

   
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnordenesbordadosucursalporrealizar = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablafecha = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        btnordenesbordadosucursalrealizadas = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnordenesbordadosucursalporrealizar1 = new javax.swing.JButton();
        btnordenesbordadosucursalrealizadas1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        btnordenesbordadosucursalporrealizar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnordenesbordadosucursalporrealizar.setText("Ordenes Bordado Sucursal por realizar");
        btnordenesbordadosucursalporrealizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnordenesbordadosucursalporrealizarActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton3.setText("Bordados Reporte General");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("20222410");

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lbsumapuntos.setText("0.00");
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton4.setText("Actualizar Puntos");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        btnordenesbordadosucursalrealizadas.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnordenesbordadosucursalrealizadas.setText("Ordenes Bordado Sucursal realizadas");
        btnordenesbordadosucursalrealizadas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnordenesbordadosucursalrealizadasActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(153, 0, 0));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Ordenes");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 26)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(153, 0, 0));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Reportes");
        jLabel9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnordenesbordadosucursalporrealizar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnordenesbordadosucursalporrealizar1.setText("Ordenes Bordado Otra Sucursal Replicar Ponchados");
        btnordenesbordadosucursalporrealizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnordenesbordadosucursalporrealizar1ActionPerformed(evt);
            }
        });

        btnordenesbordadosucursalrealizadas1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnordenesbordadosucursalrealizadas1.setText("Catalogo de cliente");
        btnordenesbordadosucursalrealizadas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnordenesbordadosucursalrealizadas1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnordenesbordadosucursalrealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnordenesbordadosucursalporrealizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnordenesbordadosucursalporrealizar1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(btnordenesbordadosucursalrealizadas1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(95, 95, 95))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnordenesbordadosucursalporrealizar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnordenesbordadosucursalporrealizar1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(222, 222, 222)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnordenesbordadosucursalrealizadas1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnordenesbordadosucursalrealizadas, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(lbsumapuntos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnordenesbordadosucursalporrealizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnordenesbordadosucursalporrealizarActionPerformed
     if(ordenesporrealizar.ventanaordenesbordadogenerada == true)
    {
     
        
       JOptionPane.showMessageDialog(null, "LA ventana de bordados por realizar ya está abierta");
        ordenesporrealizar.btnfrente.doClick();
        
    }
    else    
    {    
    ordenesporrealizar  ventana = new ordenesporrealizar();
    ordenesporrealizar.localuotrasucursal = "Local";
    ventana.setVisible(true);
    ventana.setLocationRelativeTo(null);
    }
    }//GEN-LAST:event_btnordenesbordadosucursalporrealizarActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (bordadosreportegeneral.ventanareportedebordadosgeneral== true) {

            JOptionPane.showMessageDialog(null, "LA ventana de historial de bordador ya está abierta");
        }
        else
        {

            bordadosreportegeneral  historial = new bordadosreportegeneral();
            historial.setVisible(true);

        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablafechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablafechaMouseClicked

        

    }//GEN-LAST:event_tablafechaMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       
        DefaultTableModel modelotabla = (DefaultTableModel) tablafecha.getModel();
        String[] datos = new String[2];
        
        if (mesfinal == -1) 
        {

            Calendar cal = new GregorianCalendar();

            diafinal = (cal.get(Calendar.DAY_OF_MONTH));

            mesfinal = (cal.get(Calendar.MONTH) + 1);

            añofinal = cal.get(Calendar.YEAR);

        } else {

            if (mesfinal == 0) 
            {
                mesfinal = 12;
                añofinal = añofinal - 1;
            }

            if (mesfinal == 13) {
                mesfinal = 1;
                añofinal = añofinal + 1;
            }

            diafinal = diafinal = obtenerUltimoDiaMes(añofinal, mesfinal);

        }

        
        if(diafinal ==1||diafinal ==1||diafinal ==1||diafinal ==4||diafinal ==5||diafinal ==6||diafinal ==7||diafinal ==8||diafinal ==9||diafinal ==10)
        {
          mesfinal =  mesfinal -1;
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

       
        

        for (int i = 1; i <= diafinal; i++) {

            datos[0] = String.valueOf(i);
            datos[1] = "0.00";
            modelotabla.addRow(datos);

            if (i == 27) 
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

        lbsumapuntos.setText(String.format("%.2f", sumadouble));
        
        
        String mes = messtring;
        String año = String.valueOf(añofinal);
        String suma = lbsumapuntos.getText();
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
        
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Puntos Actualizados con Exito");
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btnordenesbordadosucursalrealizadasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnordenesbordadosucursalrealizadasActionPerformed
        if(ordenesrealizadas.ventanaordenesbordadogenerada == true)
    {
        
        
         JOptionPane.showMessageDialog(null, "LA ventana de bordados realizados ya está abierta");
     
        ordenesrealizadas.btnfrente.doClick();
        
    }
    else    
    {    
    ordenesrealizadas  ventana = new ordenesrealizadas();
    ventana.setVisible(true);
    ventana.setLocationRelativeTo(null);
    }
    }//GEN-LAST:event_btnordenesbordadosucursalrealizadasActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed

        if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cerrar el sistema? Si Oprime Si se cerraran todas las ventanas", "Cuidado",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
        
        
        {

                System.exit(0);
          

        }

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
       
        
        
        
          if (JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Esta seguro que desea cerrar el sistema? Si Oprime Si se cerraran todas las ventanas", "Cuidado",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
        
        
        {

                System.exit(0);
          

        }
          
          
          
          
          
          
          
    }//GEN-LAST:event_formWindowClosing

    private void btnordenesbordadosucursalporrealizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnordenesbordadosucursalporrealizar1ActionPerformed
     if(ordenesporrealizar.ventanaordenesbordadogenerada == true)
    {
     
        
       JOptionPane.showMessageDialog(null, "LA ventana de bordados por realizar ya está abierta");
        ordenesporrealizar.btnfrente.doClick();
        
    }
    else    
    {    
    ordenesporrealizar  ventana = new ordenesporrealizar();
    ordenesporrealizar.localuotrasucursal = "Otra Sucursal";
    ventana.setVisible(true);
    ventana.setLocationRelativeTo(null);
    }
    }//GEN-LAST:event_btnordenesbordadosucursalporrealizar1ActionPerformed

    private void btnordenesbordadosucursalrealizadas1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnordenesbordadosucursalrealizadas1ActionPerformed
     
     if(bordadosdelclientecatalogo.ventanabordadosdelclientecatalogonuevo==true)
     {
         
     }
      else
     {    
        
     bordadosdelclientecatalogo ventana =  new bordadosdelclientecatalogo();
     ventana.setVisible(true);
     ventana.setLocationRelativeTo(null);
     
     }
    }//GEN-LAST:event_btnordenesbordadosucursalrealizadas1ActionPerformed


    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnordenesbordadosucursalporrealizar;
    private javax.swing.JButton btnordenesbordadosucursalporrealizar1;
    private javax.swing.JButton btnordenesbordadosucursalrealizadas;
    private javax.swing.JButton btnordenesbordadosucursalrealizadas1;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JLabel lbsumapuntos;
    private javax.swing.JTable tablafecha;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
Connection cn = cc.conexion();



}
