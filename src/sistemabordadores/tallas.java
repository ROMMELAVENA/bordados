/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabordadores;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.print.PrintServiceLookup;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author denniscanizo
 */
public class tallas extends javax.swing.JFrame {

    /**
     * Creates new form tallas
     */
    String titulo1 = "";
    String titulo2 = "";
    String titulo3 = "";
    String titulo4 = "";
    String titulo5 = "";
    String titulo6 = "";

    String talla1 = "";
    String talla2 = "";
    String talla3 = "";
    String talla4 = "";
    String talla5 = "";
    String talla6 = "";
    String talla7 = "";

    String cantidad1 = "";
    String cantidad2 = "";
    String cantidad3 = "";
    String cantidad4 = "";
    String cantidad5 = "";
    String cantidad6 = "";
    String cantidad7 = "";
   

    String tallatitulo11 = "";
    String tallatitulo12 = "";
    String tallatitulo13 = "";
    String tallatitulo14 = "";
    String tallatitulo15 = "";
    String tallatitulo16 = "";
    String tallatitulo17 = "";

    String tallacantidad11 = "";
    String tallacantidad12 = "";
    String tallacantidad13 = "";
    String tallacantidad14 = "";
    String tallacantidad15 = "";
    String tallacantidad16 = "";
    String tallacantidad17 = "";

    int cantidadtalla11 = 0;
    int cantidadtalla12 = 0;
    int cantidadtalla13 = 0;
    int cantidadtalla14 = 0;
    int cantidadtalla15 = 0;
    int cantidadtalla16 = 0;
    int cantidadtalla17 = 0;

    String tallatitulo21 = "";
    String tallatitulo22 = "";
    String tallatitulo23 = "";
    String tallatitulo24 = "";
    String tallatitulo25 = "";
    String tallatitulo26 = "";
    String tallatitulo27 = "";

    String tallacantidad21 = "";
    String tallacantidad22 = "";
    String tallacantidad23 = "";
    String tallacantidad24 = "";
    String tallacantidad25 = "";
    String tallacantidad26 = "";
    String tallacantidad27 = "";

    int cantidadtalla21 = 0;
    int cantidadtalla22 = 0;
    int cantidadtalla23 = 0;
    int cantidadtalla24 = 0;
    int cantidadtalla25 = 0;
    int cantidadtalla26 = 0;
    int cantidadtalla27 = 0;

    String tallatitulo31 = "";
    String tallatitulo32 = "";
    String tallatitulo33 = "";
    String tallatitulo34 = "";
    String tallatitulo35 = "";
    String tallatitulo36 = "";
    String tallatitulo37 = "";

    String tallacantidad31 = "";
    String tallacantidad32 = "";
    String tallacantidad33 = "";
    String tallacantidad34 = "";
    String tallacantidad35 = "";
    String tallacantidad36 = "";
    String tallacantidad37 = "";

    int cantidadtalla31 = 0;
    int cantidadtalla32 = 0;
    int cantidadtalla33 = 0;
    int cantidadtalla34 = 0;
    int cantidadtalla35 = 0;
    int cantidadtalla36 = 0;
    int cantidadtalla37 = 0;

    String tallatitulo41 = "";
    String tallatitulo42 = "";
    String tallatitulo43 = "";
    String tallatitulo44 = "";
    String tallatitulo45 = "";
    String tallatitulo46 = "";
    String tallatitulo47 = "";

    String tallacantidad41 = "";
    String tallacantidad42 = "";
    String tallacantidad43 = "";
    String tallacantidad44 = "";
    String tallacantidad45 = "";
    String tallacantidad46 = "";
    String tallacantidad47 = "";

    int cantidadtalla41 = 0;
    int cantidadtalla42 = 0;
    int cantidadtalla43 = 0;
    int cantidadtalla44 = 0;
    int cantidadtalla45 = 0;
    int cantidadtalla46 = 0;
    int cantidadtalla47 = 0;

    String tallatitulo51 = "";
    String tallatitulo52 = "";
    String tallatitulo53 = "";
    String tallatitulo54 = "";
    String tallatitulo55 = "";
    String tallatitulo56 = "";
    String tallatitulo57 = "";

    String tallacantidad51 = "";
    String tallacantidad52 = "";
    String tallacantidad53 = "";
    String tallacantidad54 = "";
    String tallacantidad55 = "";
    String tallacantidad56 = "";
    String tallacantidad57 = "";

    int cantidadtalla51 = 0;
    int cantidadtalla52 = 0;
    int cantidadtalla53 = 0;
    int cantidadtalla54 = 0;
    int cantidadtalla55 = 0;
    int cantidadtalla56 = 0;
    int cantidadtalla57 = 0;

    String tallatitulo61 = "";
    String tallatitulo62 = "";
    String tallatitulo63 = "";
    String tallatitulo64 = "";
    String tallatitulo65 = "";
    String tallatitulo66 = "";
    String tallatitulo67 = "";

    String tallacantidad61 = "";
    String tallacantidad62 = "";
    String tallacantidad63 = "";
    String tallacantidad64 = "";
    String tallacantidad65 = "";
    String tallacantidad66 = "";
    String tallacantidad67 = "";

    int cantidadtalla61 = 0;
    int cantidadtalla62 = 0;
    int cantidadtalla63 = 0;
    int cantidadtalla64 = 0;
    int cantidadtalla65 = 0;
    int cantidadtalla66 = 0;
    int cantidadtalla67 = 0;
    
    String titulo = "";
    String talla = "talla";
    String cantidad = "cantidad";
    
    
    
    
    

    public tallas() {
        initComponents();
        datosprendas();
        
        
        
        
    }

    void datosprendas() {

        titulo1 = "";
        titulo2 = "";
        titulo3 = "";
        titulo4 = "";
        titulo5 = "";
        titulo6 = "";

        tallatitulo11 = "";
        tallatitulo12 = "";
        tallatitulo13 = "";
        tallatitulo14 = "";
        tallatitulo15 = "";
        tallatitulo16 = "";
        tallatitulo17 = "";

        tallacantidad11 = "";
        tallacantidad12 = "";
        tallacantidad13 = "";
        tallacantidad14 = "";
        tallacantidad15 = "";
        tallacantidad16 = "";
        tallacantidad17 = "";

       

        tallatitulo11 = "";
        tallatitulo12 = "";
        tallatitulo13 = "";
        tallatitulo14 = "";
        tallatitulo15 = "";
        tallatitulo16 = "";
        tallatitulo17 = "";

        tallacantidad11 = "";
        tallacantidad12 = "";
        tallacantidad13 = "";
        tallacantidad14 = "";
        tallacantidad15 = "";
        tallacantidad16 = "";
        tallacantidad17 = "";

        cantidadtalla11 = 0;
        cantidadtalla12 = 0;
        cantidadtalla13 = 0;
        cantidadtalla14 = 0;
        cantidadtalla15 = 0;
        cantidadtalla16 = 0;
        cantidadtalla17 = 0;

        tallatitulo21 = "";
        tallatitulo22 = "";
        tallatitulo23 = "";
        tallatitulo24 = "";
        tallatitulo25 = "";
        tallatitulo26 = "";
        tallatitulo27 = "";

        tallacantidad21 = "";
        tallacantidad22 = "";
        tallacantidad23 = "";
        tallacantidad24 = "";
        tallacantidad25 = "";
        tallacantidad26 = "";
        tallacantidad27 = "";

        cantidadtalla21 = 0;
        cantidadtalla22 = 0;
        cantidadtalla23 = 0;
        cantidadtalla24 = 0;
        cantidadtalla25 = 0;
        cantidadtalla26 = 0;
        cantidadtalla27 = 0;

        tallatitulo31 = "";
        tallatitulo32 = "";
        tallatitulo33 = "";
        tallatitulo34 = "";
        tallatitulo35 = "";
        tallatitulo36 = "";
        tallatitulo37 = "";

        tallacantidad31 = "";
        tallacantidad32 = "";
        tallacantidad33 = "";
        tallacantidad34 = "";
        tallacantidad35 = "";
        tallacantidad36 = "";
        tallacantidad37 = "";

        cantidadtalla31 = 0;
        cantidadtalla32 = 0;
        cantidadtalla33 = 0;
        cantidadtalla34 = 0;
        cantidadtalla35 = 0;
        cantidadtalla36 = 0;
        cantidadtalla37 = 0;

        tallatitulo41 = "";
        tallatitulo42 = "";
        tallatitulo43 = "";
        tallatitulo44 = "";
        tallatitulo45 = "";
        tallatitulo46 = "";
        tallatitulo47 = "";

        tallacantidad41 = "";
        tallacantidad42 = "";
        tallacantidad43 = "";
        tallacantidad44 = "";
        tallacantidad45 = "";
        tallacantidad46 = "";
        tallacantidad47 = "";

        cantidadtalla41 = 0;
        cantidadtalla42 = 0;
        cantidadtalla43 = 0;
        cantidadtalla44 = 0;
        cantidadtalla45 = 0;
        cantidadtalla46 = 0;
        cantidadtalla47 = 0;

        tallatitulo51 = "";
        tallatitulo52 = "";
        tallatitulo53 = "";
        tallatitulo54 = "";
        tallatitulo55 = "";
        tallatitulo56 = "";
        tallatitulo57 = "";

        tallacantidad51 = "";
        tallacantidad52 = "";
        tallacantidad53 = "";
        tallacantidad54 = "";
        tallacantidad55 = "";
        tallacantidad56 = "";
        tallacantidad57 = "";

        cantidadtalla51 = 0;
        cantidadtalla52 = 0;
        cantidadtalla53 = 0;
        cantidadtalla54 = 0;
        cantidadtalla55 = 0;
        cantidadtalla56 = 0;
        cantidadtalla57 = 0;

        tallatitulo61 = "";
        tallatitulo62 = "";
        tallatitulo63 = "";
        tallatitulo64 = "";
        tallatitulo65 = "";
        tallatitulo66 = "";
        tallatitulo67 = "";

        tallacantidad61 = "";
        tallacantidad62 = "";
        tallacantidad63 = "";
        tallacantidad64 = "";
        tallacantidad65 = "";
        tallacantidad66 = "";
        tallacantidad67 = "";

        cantidadtalla61 = 0;
        cantidadtalla62 = 0;
        cantidadtalla63 = 0;
        cantidadtalla64 = 0;
        cantidadtalla65 = 0;
        cantidadtalla66 = 0;
        cantidadtalla67 = 0;

        String sql = "";
        String prendadelaprenda = ordencamisa.lbprenda.getText();
        String continuar = "no";

        if (ordencamisa.lbprenda.getText().equals("Camisa")) {
            sql = "SELECT articulo,cantidad FROM historial_ventas where numero = '" + ordencamisa.lbnumeroventa.getText() + "' AND articulo LIKE 'CAMISA%' ORDER BY ARTICULO ";
            continuar = "si";
        } else if (ordencamisa.lbprenda.getText().equals("Chamarra desmontable")) {
            sql = "SELECT articulo,cantidad FROM historial_ventas where numero = '" + ordencamisa.lbnumeroventa.getText() + "' AND articulo LIKE 'CHAMARRA DE MANGAS DESMONTABLES%' ORDER BY ARTICULO ";
            continuar = "si";
        } else if (ordencamisa.lbprenda.getText().equals("Playera")) {
            sql = "SELECT articulo,cantidad FROM historial_ventas where numero = '" + ordencamisa.lbnumeroventa.getText() + "' AND articulo LIKE 'PLAYERA%' ORDER BY ARTICULO ";
            continuar = "si";
        } else if (ordencamisa.lbprenda.getText().equals("Camisola")) {
            sql = "SELECT articulo,cantidad FROM historial_ventas where numero = '" + ordencamisa.lbnumeroventa.getText() + "' AND articulo LIKE 'CAMISOLA%' ORDER BY ARTICULO ";
            continuar = "si";
        } else {
            continuar = "no";
        }

        if (continuar.equals("si")) {
            try {

                Statement st = cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery(sql);

                while (rs.next()) {

                    String articulo = rs.getString("articulo");
                    String cantidad = rs.getString("cantidad");

                    try {

                        String sql2 = "SELECT talla,prenda_corte,descripcion_sintalla FROM catalogo_articulos WHERE descripcion = '" + articulo + "' ";
                        Statement st2 = cn.prepareStatement(sql2);
                        ResultSet rs2 = st2.executeQuery(sql2);

                        while (rs2.next()) {

                            String talla = rs2.getString("talla");
                            String prenda = rs2.getString("prenda_corte");
                            String descripcionsintalla = rs2.getString("descripcion_sintalla").toLowerCase();

                            if (titulo1.equals("") || titulo1.equals(descripcionsintalla)) {
                                titulo1 = descripcionsintalla;
                                lbtitulo1.setText("<html>"+ titulo1.toUpperCase() +"</html>");
                                

                                if (tallatitulo11.equals("") || tallatitulo11.equals(talla)) {
                                    tallatitulo11 = talla;
                                    cantidadtalla11 = cantidadtalla11 + Integer.parseInt(cantidad);
                                    lbtalla11.setText(tallatitulo11);
                                    lbcantidad11.setText(String.valueOf(cantidadtalla11));
                                    
                                    

                                } else if (tallatitulo12.equals("") || tallatitulo12.equals(talla)) {
                                    tallatitulo12 = talla;
                                    cantidadtalla12 = cantidadtalla12 + Integer.parseInt(cantidad);
                                    lbtalla12.setText(tallatitulo12);
                                    lbcantidad12.setText(String.valueOf(cantidadtalla12));
                                    

                                } else if (tallatitulo13.equals("") || tallatitulo13.equals(talla)) {
                                    tallatitulo13 = talla;
                                    cantidadtalla13 = cantidadtalla13 + Integer.parseInt(cantidad);
                                    lbtalla13.setText(tallatitulo13);
                                    lbcantidad13.setText(String.valueOf(cantidadtalla13));
                                     
                                    

                                } else if (tallatitulo14.equals("") || tallatitulo14.equals(talla)) {
                                    tallatitulo14 = talla;
                                    cantidadtalla14 = cantidadtalla14 + Integer.parseInt(cantidad);
                                    lbtalla14.setText(tallatitulo14);
                                    lbcantidad14.setText(String.valueOf(cantidadtalla14));
                                    

                                } else if (tallatitulo15.equals("") || tallatitulo15.equals(talla)) {
                                    tallatitulo15 = talla;
                                    cantidadtalla15 = cantidadtalla15 + Integer.parseInt(cantidad);
                                    lbtalla15.setText(tallatitulo15);
                                    lbcantidad15.setText(String.valueOf(cantidadtalla15));
                                     

                                } else if (tallatitulo16.equals("") || tallatitulo16.equals(talla)) {
                                    tallatitulo16 = talla;
                                    cantidadtalla16 = cantidadtalla16 + Integer.parseInt(cantidad);
                                    lbtalla16.setText(tallatitulo16);
                                    lbcantidad16.setText(String.valueOf(cantidadtalla16));
                                    

                                } else if (tallatitulo17.equals("") || tallatitulo17.equals(talla)) {
                                    tallatitulo17 = talla;
                                    cantidadtalla17 = cantidadtalla17 + Integer.parseInt(cantidad);
                                    lbtalla17.setText(tallatitulo17);
                                    lbcantidad17.setText(String.valueOf(cantidadtalla17));
                                     

                                }

                            } else if (titulo2.equals("") || titulo2.equals(descripcionsintalla)) {
                                titulo2 = descripcionsintalla;
                                lbtitulo2.setText("<html>"+ titulo1.toUpperCase() +"</html>");
                                
                                if (tallatitulo21.equals("") || tallatitulo21.equals(talla)) {
                                    tallatitulo21 = talla;
                                    cantidadtalla21 = cantidadtalla21 + Integer.parseInt(cantidad);
                                    lbtalla21.setText(tallatitulo21);
                                    lbcantidad21.setText(String.valueOf(cantidadtalla21));
                                     

                                } else if (tallatitulo22.equals("") || tallatitulo22.equals(talla)) {
                                    tallatitulo22 = talla;
                                    cantidadtalla22 = cantidadtalla22 + Integer.parseInt(cantidad);
                                    lbtalla22.setText(tallatitulo22);
                                    lbcantidad22.setText(String.valueOf(cantidadtalla22));
                                     

                                } else if (tallatitulo23.equals("") || tallatitulo23.equals(talla)) {
                                    tallatitulo23 = talla;
                                    cantidadtalla23 = cantidadtalla23 + Integer.parseInt(cantidad);
                                    lbtalla23.setText(tallatitulo23);
                                    lbcantidad23.setText(String.valueOf(cantidadtalla23));
                                     

                                } else if (tallatitulo24.equals("") || tallatitulo24.equals(talla)) {
                                    tallatitulo24 = talla;
                                    cantidadtalla24 = cantidadtalla24 + Integer.parseInt(cantidad);
                                    lbtalla24.setText(tallatitulo24);
                                    lbcantidad24.setText(String.valueOf(cantidadtalla24));
                                    

                                } else if (tallatitulo25.equals("") || tallatitulo25.equals(talla)) {
                                    tallatitulo25 = talla;
                                    cantidadtalla25 = cantidadtalla25 + Integer.parseInt(cantidad);
                                    lbtalla25.setText(tallatitulo25);
                                    lbcantidad25.setText(String.valueOf(cantidadtalla25));
                                     

                                } else if (tallatitulo26.equals("") || tallatitulo26.equals(talla)) {
                                    tallatitulo26 = talla;
                                    cantidadtalla26 = cantidadtalla26 + Integer.parseInt(cantidad);
                                    lbtalla26.setText(tallatitulo26);
                                    lbcantidad26.setText(String.valueOf(cantidadtalla26));
                                    

                                } else if (tallatitulo27.equals("") || tallatitulo27.equals(talla)) {
                                    tallatitulo27 = talla;
                                    cantidadtalla27 = cantidadtalla27 + Integer.parseInt(cantidad);
                                    lbtalla27.setText(tallatitulo27);
                                    lbcantidad27.setText(String.valueOf(cantidadtalla27));
                                    

                                }

                            } else if (titulo3.equals("") || titulo3.equals(descripcionsintalla)) {
                                titulo3 = descripcionsintalla;
                                lbtitulo3.setText("<html>"+ titulo3.toUpperCase() +"</html>");
                                

                                if (tallatitulo31.equals("") || tallatitulo31.equals(talla)) {
                                    tallatitulo31 = talla;
                                    cantidadtalla31 = cantidadtalla31 + Integer.parseInt(cantidad);
                                    lbtalla31.setText(tallatitulo31);
                                    lbcantidad31.setText(String.valueOf(cantidadtalla31));

                                } else if (tallatitulo32.equals("") || tallatitulo32.equals(talla)) {
                                    tallatitulo32 = talla;
                                    cantidadtalla32 = cantidadtalla32 + Integer.parseInt(cantidad);
                                    lbtalla32.setText(tallatitulo31);
                                    lbcantidad32.setText(String.valueOf(cantidadtalla31));

                                } else if (tallatitulo33.equals("") || tallatitulo33.equals(talla)) {
                                    tallatitulo33 = talla;
                                    cantidadtalla33 = cantidadtalla33 + Integer.parseInt(cantidad);
                                    lbtalla33.setText(tallatitulo33);
                                    lbcantidad33.setText(String.valueOf(cantidadtalla33));

                                } else if (tallatitulo34.equals("") || tallatitulo34.equals(talla)) {
                                    tallatitulo34 = talla;
                                    cantidadtalla34 = cantidadtalla34 + Integer.parseInt(cantidad);
                                    lbtalla34.setText(tallatitulo34);
                                    lbcantidad34.setText(String.valueOf(cantidadtalla34));

                                } else if (tallatitulo35.equals("") || tallatitulo35.equals(talla)) {
                                    tallatitulo35 = talla;
                                    cantidadtalla35 = cantidadtalla35 + Integer.parseInt(cantidad);
                                    lbtalla35.setText(tallatitulo35);
                                    lbcantidad35.setText(String.valueOf(cantidadtalla35));

                                } else if (tallatitulo36.equals("") || tallatitulo36.equals(talla)) {
                                    tallatitulo36 = talla;
                                    cantidadtalla36 = cantidadtalla36 + Integer.parseInt(cantidad);
                                    lbtalla36.setText(tallatitulo36);
                                    lbcantidad36.setText(String.valueOf(cantidadtalla36));

                                } else if (tallatitulo37.equals("") || tallatitulo37.equals(talla)) {
                                    tallatitulo37 = talla;
                                    cantidadtalla37 = cantidadtalla37 + Integer.parseInt(cantidad);
                                    lbtalla37.setText(tallatitulo37);
                                    lbcantidad37.setText(String.valueOf(cantidadtalla37));
                                }

                            } else if (titulo4.equals("") || titulo4.equals(descripcionsintalla)) {
                                titulo4 = descripcionsintalla;
                                lbtitulo4.setText("<html>"+ titulo4.toUpperCase() +"</html>");

                                if (tallatitulo41.equals("") || tallatitulo41.equals(talla)) {
                                    tallatitulo41 = talla;
                                    cantidadtalla41 = cantidadtalla41 + Integer.parseInt(cantidad);
                                    lbtalla41.setText(tallatitulo41);
                                    lbcantidad41.setText(String.valueOf(cantidadtalla41));

                                } else if (tallatitulo42.equals("") || tallatitulo42.equals(talla)) {
                                    tallatitulo42 = talla;
                                    cantidadtalla42 = cantidadtalla42 + Integer.parseInt(cantidad);
                                    lbtalla42.setText(tallatitulo42);
                                    lbcantidad42.setText(String.valueOf(cantidadtalla42));


                                } else if (tallatitulo43.equals("") || tallatitulo43.equals(talla)) {
                                    tallatitulo43 = talla;
                                    cantidadtalla43 = cantidadtalla43 + Integer.parseInt(cantidad);
                                    lbtalla43.setText(tallatitulo43);
                                    lbcantidad43.setText(String.valueOf(cantidadtalla43));


                                } else if (tallatitulo44.equals("") || tallatitulo44.equals(talla)) {
                                    tallatitulo44 = talla;
                                    cantidadtalla44 = cantidadtalla44 + Integer.parseInt(cantidad);
                                    lbtalla44.setText(tallatitulo44);
                                    lbcantidad44.setText(String.valueOf(cantidadtalla44));


                                } else if (tallatitulo45.equals("") || tallatitulo45.equals(talla)) {
                                    tallatitulo45 = talla;
                                    cantidadtalla45 = cantidadtalla45 + Integer.parseInt(cantidad);
                                    lbtalla45.setText(tallatitulo45);
                                    lbcantidad45.setText(String.valueOf(cantidadtalla45));

                                } else if (tallatitulo46.equals("") || tallatitulo46.equals(talla)) {
                                    tallatitulo46 = talla;
                                    cantidadtalla46 = cantidadtalla46 + Integer.parseInt(cantidad);
                                    lbtalla46.setText(tallatitulo46);
                                    lbcantidad46.setText(String.valueOf(cantidadtalla46));

                                } else if (tallatitulo47.equals("") || tallatitulo47.equals(talla)) {
                                    tallatitulo47 = talla;
                                    cantidadtalla47 = cantidadtalla47 + Integer.parseInt(cantidad);
                                    lbtalla47.setText(tallatitulo47);
                                    lbcantidad47.setText(String.valueOf(cantidadtalla47));

                                }

                            } else if (titulo5.equals("") || titulo5.equals(descripcionsintalla)) {
                                titulo5 = descripcionsintalla;
                                lbtitulo5.setText("<html>"+ titulo5.toUpperCase() +"</html>");

                                if (tallatitulo51.equals("") || tallatitulo51.equals(talla)) {
                                    tallatitulo51 = talla;
                                    cantidadtalla51 = cantidadtalla51 + Integer.parseInt(cantidad);
                                    lbtalla51.setText(tallatitulo51);
                                    lbcantidad51.setText(String.valueOf(cantidadtalla51));

                                } else if (tallatitulo52.equals("") || tallatitulo52.equals(talla)) {
                                    tallatitulo52 = talla;
                                    cantidadtalla52 = cantidadtalla52 + Integer.parseInt(cantidad);
                                    lbtalla52.setText(tallatitulo52);
                                    lbcantidad52.setText(String.valueOf(cantidadtalla52));

                                } else if (tallatitulo53.equals("") || tallatitulo53.equals(talla)) {
                                    tallatitulo53 = talla;
                                    cantidadtalla53 = cantidadtalla53 + Integer.parseInt(cantidad);
                                    lbtalla53.setText(tallatitulo53);
                                    lbcantidad53.setText(String.valueOf(cantidadtalla53));

                                } else if (tallatitulo54.equals("") || tallatitulo54.equals(talla)) {
                                    tallatitulo54 = talla;
                                    cantidadtalla54 = cantidadtalla54 + Integer.parseInt(cantidad);
                                    lbtalla54.setText(tallatitulo54);
                                    lbcantidad54.setText(String.valueOf(cantidadtalla54));

                                } else if (tallatitulo55.equals("") || tallatitulo55.equals(talla)) {
                                    tallatitulo55 = talla;
                                    cantidadtalla55 = cantidadtalla55 + Integer.parseInt(cantidad);
                                    lbtalla55.setText(tallatitulo55);
                                    lbcantidad55.setText(String.valueOf(cantidadtalla55));

                                } else if (tallatitulo56.equals("") || tallatitulo56.equals(talla)) {
                                    tallatitulo56 = talla;
                                    cantidadtalla56 = cantidadtalla56 + Integer.parseInt(cantidad);
                                    lbtalla56.setText(tallatitulo56);
                                    lbcantidad56.setText(String.valueOf(cantidadtalla56));

                                } else if (tallatitulo57.equals("") || tallatitulo57.equals(talla)) {
                                    tallatitulo57 = talla;
                                    cantidadtalla57 = cantidadtalla57 + Integer.parseInt(cantidad);
                                    lbtalla57.setText(tallatitulo57);
                                    lbcantidad57.setText(String.valueOf(cantidadtalla57));

                                }

                            } else if (titulo6.equals("") || titulo6.equals(descripcionsintalla)) {
                                titulo6 = descripcionsintalla;
                                lbtitulo6.setText("<html>"+ titulo6.toUpperCase() +"</html>");

                                if (tallatitulo61.equals("") || tallatitulo61.equals(talla)) {
                                    tallatitulo61 = talla;
                                    cantidadtalla61 = cantidadtalla61 + Integer.parseInt(cantidad);
                                    lbtalla61.setText(tallatitulo61);
                                    lbcantidad61.setText(String.valueOf(cantidadtalla61));

                                } else if (tallatitulo62.equals("") || tallatitulo62.equals(talla)) {
                                    tallatitulo62 = talla;
                                    cantidadtalla62 = cantidadtalla62 + Integer.parseInt(cantidad);
                                    lbtalla62.setText(tallatitulo62);
                                    lbcantidad62.setText(String.valueOf(cantidadtalla62));
                                    

                                } else if (tallatitulo63.equals("") || tallatitulo63.equals(talla)) {
                                    tallatitulo63 = talla;
                                    cantidadtalla63 = cantidadtalla63 + Integer.parseInt(cantidad);
                                    lbtalla63.setText(tallatitulo63);
                                    lbcantidad63.setText(String.valueOf(cantidadtalla63));

                                } else if (tallatitulo64.equals("") || tallatitulo64.equals(talla)) {
                                    tallatitulo64 = talla;
                                    cantidadtalla64 = cantidadtalla64 + Integer.parseInt(cantidad);
                                    lbtalla64.setText(tallatitulo64);
                                    lbcantidad64.setText(String.valueOf(cantidadtalla64));

                                } else if (tallatitulo65.equals("") || tallatitulo65.equals(talla)) {
                                    tallatitulo65 = talla;
                                    cantidadtalla65 = cantidadtalla65 + Integer.parseInt(cantidad);
                                    lbtalla65.setText(tallatitulo65);
                                    lbcantidad65.setText(String.valueOf(cantidadtalla65));

                                } else if (tallatitulo66.equals("") || tallatitulo66.equals(talla)) {
                                    tallatitulo66 = talla;
                                    cantidadtalla66 = cantidadtalla66 + Integer.parseInt(cantidad);
                                    lbtalla66.setText(tallatitulo66);
                                    lbcantidad66.setText(String.valueOf(cantidadtalla66));

                                } else if (tallatitulo67.equals("") || tallatitulo67.equals(talla)) {
                                    tallatitulo67 = talla;
                                    cantidadtalla67 = cantidadtalla67 + Integer.parseInt(cantidad);
                                    lbtalla67.setText(tallatitulo67);
                                    lbcantidad67.setText(String.valueOf(cantidadtalla67));

                                }

                            }

                        }/// 

                        st2.close();
                    } catch (SQLException ex) {

                        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">" + ex + "");
                    }

                }/// 

                st.close();
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">" + ex + "");
            }

        }
        else 
        {
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">No existen datos");
            this.dispose();
            
        }

    }
    
    void imprimir()
    {
        try {
                JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/img/ticketnumeroaleatorio.jasper"));
                Map parametro = new HashMap();
                parametro.put("prenda", ordencamisa.lbprenda.getText());
                parametro.put("numerodeventa", ordencamisa.lbnumeroventa.getText());
                parametro.put("nombrecliente", ordencamisa.lbcliente.getText());
                parametro.put("identificador", ordencamisa.lbidentificador.getText());
                
                parametro.put("titulo", titulo);
                parametro.put("talla", talla);
                parametro.put("talla1", talla1); 
                parametro.put("talla2", talla2); 
                parametro.put("talla3", talla3); 
                parametro.put("talla4", talla4);
                parametro.put("talla5", talla5);
                parametro.put("talla6", talla6);
                parametro.put("talla7", talla7);
                
                parametro.put("cantidad", cantidad); 
                parametro.put("cantidad1", cantidad1); 
                parametro.put("cantidad2", cantidad2); 
                parametro.put("cantidad3", cantidad3); 
                parametro.put("cantidad4", cantidad4);
                parametro.put("cantidad5", cantidad5);
                parametro.put("cantidad6", cantidad6);
                parametro.put("cantidad7", cantidad7);
               
                JasperPrint jprint = JasperFillManager.fillReport(reporte, parametro, new JREmptyDataSource());
                JRExporter exporter = new JRPdfExporter();
                exporter.setParameter(JRExporterParameter.JASPER_PRINT, jprint);

                
               JasperExportManager.exportReportToPdfFile(jprint, "C:\\ticketsbanco\\ticketnumeroaleatorio"+ordencamisa.lbnumeroventa.getText()+".pdf");
               javax.print.PrintService services = PrintServiceLookup.lookupDefaultPrintService();
      
        
         JRPrintServiceExporter exporter2 = new JRPrintServiceExporter();
        exporter2.setParameter(JRExporterParameter.JASPER_PRINT, jprint);
         
        //se selecciona servicio y se pasa atributos de impresion        
        exporter2.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE, services);
        exporter2.setParameter(JRPrintServiceExporterParameter.PRINT_SERVICE_ATTRIBUTE_SET, services.getAttributes());
        exporter2.setParameter(JRPrintServiceExporterParameter.DISPLAY_PAGE_DIALOG, Boolean.FALSE);
        exporter2.setParameter(JRPrintServiceExporterParameter.DISPLAY_PRINT_DIALOG, Boolean.FALSE);      
        exporter2.exportReport();

            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">" + ex + "");

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

        lbtitulo1 = new javax.swing.JLabel();
        lbtitulotalla = new javax.swing.JLabel();
        lbtitulocantidad = new javax.swing.JLabel();
        lbtalla11 = new javax.swing.JLabel();
        lbtalla12 = new javax.swing.JLabel();
        lbtalla13 = new javax.swing.JLabel();
        lbtalla14 = new javax.swing.JLabel();
        lbtalla15 = new javax.swing.JLabel();
        lbtalla16 = new javax.swing.JLabel();
        lbtalla17 = new javax.swing.JLabel();
        lbcantidad11 = new javax.swing.JLabel();
        lbcantidad12 = new javax.swing.JLabel();
        lbcantidad13 = new javax.swing.JLabel();
        lbcantidad14 = new javax.swing.JLabel();
        lbcantidad15 = new javax.swing.JLabel();
        lbcantidad16 = new javax.swing.JLabel();
        lbcantidad17 = new javax.swing.JLabel();
        lbtalla24 = new javax.swing.JLabel();
        lbtalla23 = new javax.swing.JLabel();
        lbtalla21 = new javax.swing.JLabel();
        lbcantidad25 = new javax.swing.JLabel();
        lbtitulocantidad2 = new javax.swing.JLabel();
        lbcantidad24 = new javax.swing.JLabel();
        lbtitulotalla2 = new javax.swing.JLabel();
        lbcantidad23 = new javax.swing.JLabel();
        lbtitulo2 = new javax.swing.JLabel();
        lbcantidad21 = new javax.swing.JLabel();
        lbcantidad22 = new javax.swing.JLabel();
        lbtalla27 = new javax.swing.JLabel();
        lbtalla26 = new javax.swing.JLabel();
        lbtalla25 = new javax.swing.JLabel();
        lbcantidad27 = new javax.swing.JLabel();
        lbtalla22 = new javax.swing.JLabel();
        lbcantidad26 = new javax.swing.JLabel();
        lbtitulo3 = new javax.swing.JLabel();
        lbcantidad34 = new javax.swing.JLabel();
        lbtitulocantidad3 = new javax.swing.JLabel();
        lbcantidad35 = new javax.swing.JLabel();
        lbtalla31 = new javax.swing.JLabel();
        lbtalla33 = new javax.swing.JLabel();
        lbtalla34 = new javax.swing.JLabel();
        lbcantidad33 = new javax.swing.JLabel();
        lbtitulotalla3 = new javax.swing.JLabel();
        lbcantidad36 = new javax.swing.JLabel();
        lbtalla32 = new javax.swing.JLabel();
        lbcantidad37 = new javax.swing.JLabel();
        lbtalla35 = new javax.swing.JLabel();
        lbtalla36 = new javax.swing.JLabel();
        lbtalla37 = new javax.swing.JLabel();
        lbcantidad32 = new javax.swing.JLabel();
        lbcantidad31 = new javax.swing.JLabel();
        lbcantidad46 = new javax.swing.JLabel();
        lbtitulotalla4 = new javax.swing.JLabel();
        lbcantidad43 = new javax.swing.JLabel();
        lbtalla44 = new javax.swing.JLabel();
        lbtalla43 = new javax.swing.JLabel();
        lbtalla41 = new javax.swing.JLabel();
        lbcantidad45 = new javax.swing.JLabel();
        lbtitulocantidad4 = new javax.swing.JLabel();
        lbcantidad44 = new javax.swing.JLabel();
        lbtitulo4 = new javax.swing.JLabel();
        lbcantidad41 = new javax.swing.JLabel();
        lbcantidad42 = new javax.swing.JLabel();
        lbtalla47 = new javax.swing.JLabel();
        lbtalla46 = new javax.swing.JLabel();
        lbtalla45 = new javax.swing.JLabel();
        lbcantidad47 = new javax.swing.JLabel();
        lbtalla42 = new javax.swing.JLabel();
        lbtalla54 = new javax.swing.JLabel();
        lbcantidad53 = new javax.swing.JLabel();
        lbtitulotalla5 = new javax.swing.JLabel();
        lbcantidad56 = new javax.swing.JLabel();
        lbtalla55 = new javax.swing.JLabel();
        lbtalla56 = new javax.swing.JLabel();
        lbtalla57 = new javax.swing.JLabel();
        lbcantidad52 = new javax.swing.JLabel();
        lbcantidad51 = new javax.swing.JLabel();
        lbtitulo5 = new javax.swing.JLabel();
        lbcantidad54 = new javax.swing.JLabel();
        lbtitulocantidad5 = new javax.swing.JLabel();
        lbcantidad55 = new javax.swing.JLabel();
        lbtalla51 = new javax.swing.JLabel();
        lbtalla53 = new javax.swing.JLabel();
        lbtalla52 = new javax.swing.JLabel();
        lbcantidad57 = new javax.swing.JLabel();
        lbtalla66 = new javax.swing.JLabel();
        lbtalla65 = new javax.swing.JLabel();
        lbcantidad66 = new javax.swing.JLabel();
        lbtitulotalla6 = new javax.swing.JLabel();
        lbcantidad63 = new javax.swing.JLabel();
        lbcantidad64 = new javax.swing.JLabel();
        lbtitulo6 = new javax.swing.JLabel();
        lbcantidad61 = new javax.swing.JLabel();
        lbcantidad62 = new javax.swing.JLabel();
        lbtalla67 = new javax.swing.JLabel();
        lbcantidad67 = new javax.swing.JLabel();
        lbtalla62 = new javax.swing.JLabel();
        lbtalla63 = new javax.swing.JLabel();
        lbtalla61 = new javax.swing.JLabel();
        lbcantidad65 = new javax.swing.JLabel();
        lbtitulocantidad6 = new javax.swing.JLabel();
        lbtalla64 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tallas");

        lbtitulo1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        lbtitulo1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtitulotalla.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulotalla.setText("Talla");
        lbtitulotalla.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtitulotalla.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtitulotalla.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulocantidad.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulocantidad.setText("Cant.");
        lbtitulocantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtalla11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla11.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla11.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla12.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla12.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla13.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla13.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla14.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla14.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla15.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla15.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla16.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla16.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla17.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla17.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad11.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad11.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad11.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad12.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad12.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad12.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad13.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad13.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad13.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad14.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad14.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad14.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad15.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad15.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad15.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad16.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad16.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad16.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad17.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad17.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad17.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla24.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla24.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla23.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla23.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla23.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla21.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla21.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad25.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad25.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad25.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulocantidad2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulocantidad2.setText("Cant.");
        lbtitulocantidad2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad24.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad24.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad24.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad24.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulotalla2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulotalla2.setText("Talla");
        lbtitulotalla2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtitulotalla2.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtitulotalla2.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad23.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad23.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad23.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad23.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulo2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbtitulo2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad21.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad21.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad21.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad22.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad22.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla27.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla27.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla27.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla26.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla26.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla26.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla25.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla25.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla25.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla25.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad27.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad27.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad27.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad27.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla22.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla22.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla22.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla22.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad26.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad26.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad26.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad26.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulo3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbtitulo3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad34.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad34.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad34.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad34.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulocantidad3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulocantidad3.setText("Cant.");
        lbtitulocantidad3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad35.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad35.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad35.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad35.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla31.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla31.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla31.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla33.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla33.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla33.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla33.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla34.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla34.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla34.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla34.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad33.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad33.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad33.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad33.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulotalla3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulotalla3.setText("Talla");
        lbtitulotalla3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtitulotalla3.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtitulotalla3.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad36.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad36.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad36.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad36.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla32.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla32.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla32.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla32.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad37.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad37.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad37.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad37.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla35.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla35.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla35.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla35.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla36.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla36.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla36.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla36.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla37.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla37.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla37.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla37.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad32.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad32.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad32.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad32.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad31.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad31.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad31.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad31.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad46.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad46.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad46.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad46.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulotalla4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulotalla4.setText("Talla");
        lbtitulotalla4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtitulotalla4.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtitulotalla4.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad43.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad43.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad43.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad43.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla44.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla44.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla44.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla44.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla43.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla43.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla43.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla43.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla41.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla41.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla41.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla41.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad45.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad45.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad45.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad45.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulocantidad4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulocantidad4.setText("Cant.");
        lbtitulocantidad4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad44.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad44.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad44.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad44.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulo4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbtitulo4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad41.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad41.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad41.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad41.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad42.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad42.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad42.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad42.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla47.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla47.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla47.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla47.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla46.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla46.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla46.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla46.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla45.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla45.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla45.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla45.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad47.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad47.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad47.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad47.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla42.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla42.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla42.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla42.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla54.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla54.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla54.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla54.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad53.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad53.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad53.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad53.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulotalla5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulotalla5.setText("Talla");
        lbtitulotalla5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtitulotalla5.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtitulotalla5.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad56.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad56.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad56.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad56.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla55.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla55.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla55.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla55.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla56.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla56.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla56.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla56.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla57.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla57.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla57.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla57.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad52.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad52.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad52.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad52.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad51.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad51.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad51.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad51.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulo5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbtitulo5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad54.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad54.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad54.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad54.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulocantidad5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulocantidad5.setText("Cant.");
        lbtitulocantidad5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad55.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad55.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad55.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad55.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla51.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla51.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla51.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla51.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla53.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla53.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla53.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla53.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla52.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla52.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla52.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla52.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad57.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad57.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad57.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad57.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla66.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla66.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla66.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla66.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla65.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla65.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla65.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla65.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad66.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad66.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad66.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad66.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulotalla6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulotalla6.setText("Talla");
        lbtitulotalla6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtitulotalla6.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtitulotalla6.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad63.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad63.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad63.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad63.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad64.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad64.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad64.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad64.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulo6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbtitulo6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad61.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad61.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad61.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad61.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad62.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad62.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad62.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad62.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla67.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla67.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla67.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla67.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad67.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad67.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad67.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad67.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla62.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla62.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla62.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla62.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla63.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla63.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla63.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla63.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtalla61.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla61.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla61.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla61.setPreferredSize(new java.awt.Dimension(24, 18));

        lbcantidad65.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbcantidad65.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidad65.setMaximumSize(new java.awt.Dimension(24, 18));
        lbcantidad65.setPreferredSize(new java.awt.Dimension(24, 18));

        lbtitulocantidad6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtitulocantidad6.setText("Cant.");
        lbtitulocantidad6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtalla64.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbtalla64.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbtalla64.setMaximumSize(new java.awt.Dimension(24, 18));
        lbtalla64.setPreferredSize(new java.awt.Dimension(24, 18));

        jButton1.setText("Imprimir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Imprimir");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Imprimir");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Imprimir");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Imprimir");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Imprimir");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtitulotalla, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbtitulocantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtalla17, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbcantidad17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtalla16, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbcantidad16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtalla15, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbcantidad15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtalla14, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbcantidad14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtalla13, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbcantidad13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtalla12, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbcantidad12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbtalla11, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(lbcantidad11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbtitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbtalla27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbtalla26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbtalla25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbtalla24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbtalla23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbtalla22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbtalla21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lbtitulotalla2, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbtitulocantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad26, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad27, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbtitulotalla3, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbtitulocantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla31, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla32, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad32, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla33, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad33, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla34, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad34, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla35, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad35, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla36, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla37, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad37, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbtitulotalla4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbtitulocantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla41, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad41, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla42, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad42, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla43, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad43, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla44, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad44, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla45, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad45, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla46, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad46, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla47, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad47, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lbtitulotalla5, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbtitulocantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla51, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad51, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla52, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad52, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla53, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad53, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla54, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad54, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla55, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad55, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla56, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad56, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(lbtalla57, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10)
                            .addComponent(lbcantidad57, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtitulo6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lbtitulotalla6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10)
                                                        .addComponent(lbtitulocantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(lbtalla61, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(10, 10, 10)
                                                        .addComponent(lbcantidad61, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                    .addComponent(lbtalla62, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(10, 10, 10)
                                                    .addComponent(lbcantidad62, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lbtalla63, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(10, 10, 10)
                                                .addComponent(lbcantidad63, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(lbtalla64, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(10, 10, 10)
                                            .addComponent(lbcantidad64, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbtalla65, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)
                                        .addComponent(lbcantidad65, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(lbtalla66, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)
                                    .addComponent(lbcantidad66, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(lbtalla67, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(lbcantidad67, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(2, 2, 2)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtitulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtitulotalla, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulocantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulotalla2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulocantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulotalla3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulocantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulotalla4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulocantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulotalla5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulocantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulotalla6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulocantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtalla11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad21, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad31, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad41, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad51, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad61, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtalla12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad22, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad32, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad42, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad52, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad62, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtalla13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad13, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad23, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad33, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad43, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad53, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad63, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtalla14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad24, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad34, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad44, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad54, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad64, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtalla15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad25, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad35, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad45, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad55, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla65, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad65, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtalla16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad16, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad26, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad36, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad46, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad56, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla66, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad66, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbtalla17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad17, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad27, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad37, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad47, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad57, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtalla67, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidad67, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButton6)
                    .addComponent(jButton1))
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

     titulo = titulo1.toUpperCase();
     talla1 = lbtalla11.getText();
     talla2 = lbtalla12.getText();
     talla3 = lbtalla13.getText();
     talla4 = lbtalla14.getText();
     talla5 = lbtalla15.getText();
     talla6 = lbtalla16.getText();
     talla7 = lbtalla17.getText();

     cantidad1 = lbcantidad11.getText();
     cantidad2 = lbcantidad12.getText();
     cantidad3 = lbcantidad13.getText();
     cantidad4 = lbcantidad14.getText();
     cantidad5 = lbcantidad15.getText();
     cantidad6 = lbcantidad16.getText();
     cantidad7 = lbcantidad17.getText();
     
     imprimir();
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     titulo = titulo2.toUpperCase();
     talla1 = lbtalla21.getText();
     talla2 = lbtalla22.getText();
     talla3 = lbtalla23.getText();
     talla4 = lbtalla24.getText();
     talla5 = lbtalla25.getText();
     talla6 = lbtalla26.getText();
     talla7 = lbtalla27.getText();

     cantidad1 = lbcantidad21.getText();
     cantidad2 = lbcantidad22.getText();
     cantidad3 = lbcantidad23.getText();
     cantidad4 = lbcantidad24.getText();
     cantidad5 = lbcantidad25.getText();
     cantidad6 = lbcantidad26.getText();
     cantidad7 = lbcantidad27.getText();
     
     imprimir();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     titulo = titulo3.toUpperCase();
     talla1 = lbtalla31.getText();
     talla2 = lbtalla32.getText();
     talla3 = lbtalla33.getText();
     talla4 = lbtalla34.getText();
     talla5 = lbtalla35.getText();
     talla6 = lbtalla36.getText();
     talla7 = lbtalla37.getText();

     cantidad1 = lbcantidad31.getText();
     cantidad2 = lbcantidad32.getText();
     cantidad3 = lbcantidad33.getText();
     cantidad4 = lbcantidad34.getText();
     cantidad5 = lbcantidad35.getText();
     cantidad6 = lbcantidad36.getText();
     cantidad7 = lbcantidad37.getText();
     
     imprimir();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
     titulo = titulo4.toUpperCase();
     talla1 = lbtalla41.getText();
     talla2 = lbtalla42.getText();
     talla3 = lbtalla43.getText();
     talla4 = lbtalla44.getText();
     talla5 = lbtalla45.getText();
     talla6 = lbtalla46.getText();
     talla7 = lbtalla47.getText();

     cantidad1 = lbcantidad41.getText();
     cantidad2 = lbcantidad42.getText();
     cantidad3 = lbcantidad43.getText();
     cantidad4 = lbcantidad44.getText();
     cantidad5 = lbcantidad45.getText();
     cantidad6 = lbcantidad46.getText();
     cantidad7 = lbcantidad47.getText();
     
     imprimir();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
     titulo = titulo5.toUpperCase();
     talla1 = lbtalla51.getText();
     talla2 = lbtalla52.getText();
     talla3 = lbtalla53.getText();
     talla4 = lbtalla54.getText();
     talla5 = lbtalla55.getText();
     talla6 = lbtalla56.getText();
     talla7 = lbtalla57.getText();

     cantidad1 = lbcantidad51.getText();
     cantidad2 = lbcantidad52.getText();
     cantidad3 = lbcantidad53.getText();
     cantidad4 = lbcantidad54.getText();
     cantidad5 = lbcantidad55.getText();
     cantidad6 = lbcantidad56.getText();
     cantidad7 = lbcantidad57.getText();
     
     imprimir();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
     titulo = titulo6.toUpperCase();
     talla1 = lbtalla61.getText();
     talla2 = lbtalla62.getText();
     talla3 = lbtalla63.getText();
     talla4 = lbtalla64.getText();
     talla5 = lbtalla65.getText();
     talla6 = lbtalla66.getText();
     talla7 = lbtalla67.getText();

     cantidad1 = lbcantidad61.getText();
     cantidad2 = lbcantidad62.getText();
     cantidad3 = lbcantidad63.getText();
     cantidad4 = lbcantidad64.getText();
     cantidad5 = lbcantidad65.getText();
     cantidad6 = lbcantidad66.getText();
     cantidad7 = lbcantidad67.getText();
     
     imprimir();
    }//GEN-LAST:event_jButton6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(tallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tallas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tallas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel lbcantidad11;
    private javax.swing.JLabel lbcantidad12;
    private javax.swing.JLabel lbcantidad13;
    private javax.swing.JLabel lbcantidad14;
    private javax.swing.JLabel lbcantidad15;
    private javax.swing.JLabel lbcantidad16;
    private javax.swing.JLabel lbcantidad17;
    private javax.swing.JLabel lbcantidad21;
    private javax.swing.JLabel lbcantidad22;
    private javax.swing.JLabel lbcantidad23;
    private javax.swing.JLabel lbcantidad24;
    private javax.swing.JLabel lbcantidad25;
    private javax.swing.JLabel lbcantidad26;
    private javax.swing.JLabel lbcantidad27;
    private javax.swing.JLabel lbcantidad31;
    private javax.swing.JLabel lbcantidad32;
    private javax.swing.JLabel lbcantidad33;
    private javax.swing.JLabel lbcantidad34;
    private javax.swing.JLabel lbcantidad35;
    private javax.swing.JLabel lbcantidad36;
    private javax.swing.JLabel lbcantidad37;
    private javax.swing.JLabel lbcantidad41;
    private javax.swing.JLabel lbcantidad42;
    private javax.swing.JLabel lbcantidad43;
    private javax.swing.JLabel lbcantidad44;
    private javax.swing.JLabel lbcantidad45;
    private javax.swing.JLabel lbcantidad46;
    private javax.swing.JLabel lbcantidad47;
    private javax.swing.JLabel lbcantidad51;
    private javax.swing.JLabel lbcantidad52;
    private javax.swing.JLabel lbcantidad53;
    private javax.swing.JLabel lbcantidad54;
    private javax.swing.JLabel lbcantidad55;
    private javax.swing.JLabel lbcantidad56;
    private javax.swing.JLabel lbcantidad57;
    private javax.swing.JLabel lbcantidad61;
    private javax.swing.JLabel lbcantidad62;
    private javax.swing.JLabel lbcantidad63;
    private javax.swing.JLabel lbcantidad64;
    private javax.swing.JLabel lbcantidad65;
    private javax.swing.JLabel lbcantidad66;
    private javax.swing.JLabel lbcantidad67;
    private javax.swing.JLabel lbtalla11;
    private javax.swing.JLabel lbtalla12;
    private javax.swing.JLabel lbtalla13;
    private javax.swing.JLabel lbtalla14;
    private javax.swing.JLabel lbtalla15;
    private javax.swing.JLabel lbtalla16;
    private javax.swing.JLabel lbtalla17;
    private javax.swing.JLabel lbtalla21;
    private javax.swing.JLabel lbtalla22;
    private javax.swing.JLabel lbtalla23;
    private javax.swing.JLabel lbtalla24;
    private javax.swing.JLabel lbtalla25;
    private javax.swing.JLabel lbtalla26;
    private javax.swing.JLabel lbtalla27;
    private javax.swing.JLabel lbtalla31;
    private javax.swing.JLabel lbtalla32;
    private javax.swing.JLabel lbtalla33;
    private javax.swing.JLabel lbtalla34;
    private javax.swing.JLabel lbtalla35;
    private javax.swing.JLabel lbtalla36;
    private javax.swing.JLabel lbtalla37;
    private javax.swing.JLabel lbtalla41;
    private javax.swing.JLabel lbtalla42;
    private javax.swing.JLabel lbtalla43;
    private javax.swing.JLabel lbtalla44;
    private javax.swing.JLabel lbtalla45;
    private javax.swing.JLabel lbtalla46;
    private javax.swing.JLabel lbtalla47;
    private javax.swing.JLabel lbtalla51;
    private javax.swing.JLabel lbtalla52;
    private javax.swing.JLabel lbtalla53;
    private javax.swing.JLabel lbtalla54;
    private javax.swing.JLabel lbtalla55;
    private javax.swing.JLabel lbtalla56;
    private javax.swing.JLabel lbtalla57;
    private javax.swing.JLabel lbtalla61;
    private javax.swing.JLabel lbtalla62;
    private javax.swing.JLabel lbtalla63;
    private javax.swing.JLabel lbtalla64;
    private javax.swing.JLabel lbtalla65;
    private javax.swing.JLabel lbtalla66;
    private javax.swing.JLabel lbtalla67;
    private javax.swing.JLabel lbtitulo1;
    private javax.swing.JLabel lbtitulo2;
    private javax.swing.JLabel lbtitulo3;
    private javax.swing.JLabel lbtitulo4;
    private javax.swing.JLabel lbtitulo5;
    private javax.swing.JLabel lbtitulo6;
    private javax.swing.JLabel lbtitulocantidad;
    private javax.swing.JLabel lbtitulocantidad2;
    private javax.swing.JLabel lbtitulocantidad3;
    private javax.swing.JLabel lbtitulocantidad4;
    private javax.swing.JLabel lbtitulocantidad5;
    private javax.swing.JLabel lbtitulocantidad6;
    private javax.swing.JLabel lbtitulotalla;
    private javax.swing.JLabel lbtitulotalla2;
    private javax.swing.JLabel lbtitulotalla3;
    private javax.swing.JLabel lbtitulotalla4;
    private javax.swing.JLabel lbtitulotalla5;
    private javax.swing.JLabel lbtitulotalla6;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
