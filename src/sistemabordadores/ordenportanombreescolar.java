package sistemabordadores;

import java.awt.AWTException;
import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.AttributeSet;
import javax.print.attribute.HashAttributeSet;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.ColorSupported;
import javax.print.attribute.standard.PrinterName;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;

public class ordenportanombreescolar extends javax.swing.JFrame {

    public static boolean ventanaordenportanombreanterior = false;

    private PreparedStatement pst;

    String numerocatalogoprendas = "";
    String numerocatalogoubicacion = "";
    String numerocatalogocolores = "";

    String cantidad = "";
    String prenda = "";
    String ubicacion = "";
    String color = "";
    int renglon = 0;

    String primero = "";
    String ultimo = "";
    
    String soloesportanombres = "";
    

    public ordenportanombreescolar() {
        initComponents();
        ventanaordenportanombreanterior = true;
        
        lbnumero.setVisible(false);
        
        lbarticulo.setVisible(false);
        lbtipo.setVisible(false);      
        
       
                
        topes();

    }

    void topes() {

        String sql = "SELECT min(numero) as min_numero, max(numero) as max_numero FROM historial_ordenes_portanombres";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            rs.last();

            primero = rs.getString("min_numero");
            ultimo = rs.getString("max_numero");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }

    }

    void datos() {

    

        String numero = lbnumero.getText();

        renglon = 0;

        String sql = "SELECT cantidad,prenda,ubicacion,color FROM historial_ordenes_portanombres WHERE numero = '" + numero + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                cantidad = rs.getString("cantidad");
                prenda = rs.getString("prenda");
                ubicacion = rs.getString("ubicacion");
                color = rs.getString("color");

                renglon = renglon + 1;

                mostrarrenglones();

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        datosfueratabla();

    }

    void datosporventa() {

       

        String numero = lbnumerodeventa.getText();

        renglon = 0;

        String sql = "SELECT cantidad,prenda,ubicacion,color,numero FROM historial_ordenes_portanombres WHERE numero_venta = '" + numero + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                cantidad = rs.getString("cantidad");
                prenda = rs.getString("prenda");
                ubicacion = rs.getString("ubicacion");
                color = rs.getString("color");
                lbnumero.setText(rs.getString("numero"));

                renglon = renglon + 1;

                mostrarrenglones();

            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        datosfueratabla();

    }

    void mostrarrenglones() {

        if (renglon == 1) {
            lbcantidad1.setText(cantidad);
            lbprenda1.setText(prenda);
            lbubicacion1.setText(ubicacion);
            lbcolor1.setText(color);

        }

        if (renglon == 2) {
            lbcantidad2.setText(cantidad);
            lbprenda2.setText(prenda);
            lbubicacion2.setText(ubicacion);
            lbcolor2.setText(color);

        }

        if (renglon == 3) {
            lbcantidad3.setText(cantidad);
            lbprenda3.setText(prenda);
            lbubicacion3.setText(ubicacion);
            lbcolor3.setText(color);

        }

        if (renglon == 4) {
            lbcantidad4.setText(cantidad);
            lbprenda4.setText(prenda);
            lbubicacion4.setText(ubicacion);
            lbcolor4.setText(color);

        }

        if (renglon == 5) {
            lbcantidad5.setText(cantidad);
            lbprenda5.setText(prenda);
            lbubicacion5.setText(ubicacion);
            lbcolor5.setText(color);

        }

    }

    void datosfueratabla() {

        String numero = lbnumero.getText();

        String sql = "SELECT fecha,hora,tipo,articulo,nombre_renglon1,nombre_renglon2,nombre_renglon3,tipo_letra,cantidad_total,nombre_persona_solicita,telefono,fecha_entrega,hora_entrega,observacion FROM historial_ordenes_portanombres WHERE numero = '" + numero + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {

                lbfecha.setText(rs.getString("fecha"));
                lbhora.setText(rs.getString("hora"));
                lbtipo.setText(rs.getString("tipo"));
             
               

                lbarticulo.setText(rs.getString("articulo"));
                lbnombrerenglon1.setText(rs.getString("nombre_renglon1"));
                lbnombrerenglon2.setText(rs.getString("nombre_renglon2"));
                lbnombrerenglon3.setText(rs.getString("nombre_renglon3"));

                lbletra.setText(rs.getString("tipo_letra"));
                lbcantidadtotal.setText(rs.getString("cantidad_total"));
             
                lbsolicita.setText(rs.getString("nombre_persona_solicita"));
                lbtelefono.setText(rs.getString("telefono"));
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));
                lbobservacion.setText(rs.getString("observacion"));
               
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        String sql2 = "SELECT distinct numero_venta FROM historial_ordenes_portanombres WHERE numero = '" + numero + "'";

        try {
            Statement st2 = cn.createStatement();
            ResultSet rs2 = st2.executeQuery(sql2);
            if (rs2.next()) {

                
                lbnumerodeventa.setText(rs2.getString("numero_venta"));
            }
            else
            {
               lbnumerodeventa.setText("00000000");
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }


    
    void essoloportanombres()
    {
        
        Object articuloobject = "";
        
        String sql = "SELECT articulo  FROM historial_ventas WHERE numero = '"+lbnumerodeventa.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {

                articuloobject = rs.getString("articulo");
                
                
                if(articuloobject.toString().contains("PORTA NOMBRE"))
                {
                    soloesportanombres = "si";
                }
                else
                {
                    soloesportanombres = "no";
                    break;
                }   
               
            }

        } catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
    }
    



/*


         void cancelarbordado() {

    
        String prenda = lbprenda.getText();
        String cantidadprendas = lbcantidad.getText();
        int cantidadprendasint = Integer.parseInt(cantidadprendas);
        String lugar = lblugar.getText();
       
        
      
    
        String estatusorden = lbestatus.getText();
        String ubicacion = "";
        String aplicacion = "";
        String cantidad = "";

        String ubicacion1 = "";
        String ubicacion2 = "";
        String ubicacion3 = "";
        String ubicacion4 = "";
        String ubicacion5 = "";

        String aplicacion1 = "";
        String aplicacion2 = "";
        String aplicacion3 = "";
        String aplicacion4 = "";
        String aplicacion5 = "";
        
        
        
       
       
        if (prenda.equals("Camisa")) {
            
            
            
            ubicacion1 = "BORDADO CAMISA "+concepto+" MANGA DERECHA";
            ubicacion2 = "BORDADO CAMISA "+concepto+" MANGA IZQUIERDA";
            ubicacion3 = "BORDADO CAMISA "+concepto+" PECHO DERECHO";
            ubicacion4 = "BORDADO CAMISA "+concepto+" PECHO IZQUIERDO";
            ubicacion5 = "BORDADO CAMISA "+concepto+" ESPALDA";

            aplicacion1 = "APLICACION CAMISA MANGA DERECHA";
            aplicacion2 = "APLICACION CAMISA MANGA IZQUIERDA";
            aplicacion3 = "APLICACION CAMISA PECHO DERECHO";
            aplicacion4 = "APLICACION CAMISA PECHO IZQUIERDO";
            aplicacion5 = "APLICACION CAMISA ESPALDA";

        } 
        else if (prenda.equals("Camisola")) {
            ubicacion1 = "BORDADO CAMISOLA "+concepto+" MANGA DERECHA";
            ubicacion2 = "BORDADO CAMISOLA "+concepto+" MANGA IZQUIERDA";
            ubicacion3 = "BORDADO CAMISOLA "+concepto+" PECHO DERECHO";
            ubicacion4 = "BORDADO CAMISOLA "+concepto+" PECHO IZQUIERDO";
            ubicacion5 = "BORDADO CAMISOLA "+concepto+" ESPALDA";

            aplicacion1 = "APLICACION CAMISOLA MANGA DERECHA";
            aplicacion2 = "APLICACION CAMISOLA MANGA IZQUIERDA";
            aplicacion3 = "APLICACION CAMISOLA PECHO DERECHO";
            aplicacion4 = "APLICACION CAMISOLA PECHO IZQUIERDO";
            aplicacion5 = "APLICACION CAMISOLA ESPALDA";

        } else if (prenda.equals("Chamarra desmontable")) {
            ubicacion1 = "BORDADO CHAMARRA DESMONTABLE "+concepto+" MANGA DERECHA ";
            ubicacion2 = "BORDADO CHAMARRA DESMONTABLE "+concepto+" MANGA IZQUIERDA";
            ubicacion3 = "BORDADO CHAMARRA DESMONTABLE "+concepto+" PECHO DERECHO";
            ubicacion4 = "BORDADO CHAMARRA DESMONTABLE "+concepto+" PECHO IZQUIERDO";
            ubicacion5 = "BORDADO CHAMARRA DESMONTABLE "+concepto+" ESPALDA";

            aplicacion1 = "APLICACION CHAMARRA DESMONTABLE MANGA DERECHA";
            aplicacion2 = "APLICACION CHAMARRA DESMONTABLE MANGA IZQUIERDA";
            aplicacion3 = "APLICACION CHAMARRA DESMONTABLE PECHO DERECHO";
            aplicacion4 = "APLICACION CHAMARRA DESMONTABLE PECHO IZQUIERDO";
            aplicacion5 = "APLICACION CHAMARRA DESMONTABLE ESPALDA";

        }

        if (prenda.equals("Chamarra rompevientos")) {
            ubicacion1 = "BORDADO CHAMARRA ROMPEVIENTOS "+concepto+" MANGA DERECHA ";
            ubicacion2 = "BORDADO CHAMARRA ROMPEVIENTOS "+concepto+" MANGA IZQUIERDA";
            ubicacion3 = "BORDADO CHAMARRA ROMPEVIENTOS "+concepto+" PECHO DERECHO";
            ubicacion4 = "BORDADO CHAMARRA ROMPEVIENTOS "+concepto+" PECHO IZQUIERDO";
            ubicacion5 = "BORDADO CHAMARRA ROMPEVIENTOS "+concepto+" ESPALDA";

            aplicacion1 = "APLICACION CHAMARRA ROMPEVIENTOS MANGA DERECHA";
            aplicacion2 = "APLICACION CHAMARRA ROMPEVIENTOS MANGA IZQUIERDA";
            aplicacion3 = "APLICACION CHAMARRA ROMPEVIENTOS PECHO DERECHO";
            aplicacion4 = "APLICACION CHAMARRA ROMPEVIENTOS PECHO IZQUIERDO";
            aplicacion5 = "APLICACION CHAMARRA ROMPEVIENTOS ESPALDA";

        } else if (prenda.equals("Chaleco")) {

            ubicacion3 = "BORDADO CHALECO "+concepto+" PECHO DERECHO";
            ubicacion4 = "BORDADO CHALECO "+concepto+" PECHO IZQUIERDO";
            ubicacion5 = "BORDADO CHALECO "+concepto+" ESPALDA";

            aplicacion3 = "APLICACION CHALECO PECHO DERECHO";
            aplicacion4 = "APLICACION CHALECO PECHO IZQUIERDO";
            aplicacion5 = "APLICACION CHALECO ESPALDA";

        } else if (prenda.equals("Playera")) {
            ubicacion1 = "BORDADO PLAYERA "+concepto+" MANGA DERECHA";
            ubicacion2 = "BORDADO PLAYERA "+concepto+" MANGA IZQUIERDA";
            ubicacion3 = "BORDADO PLAYERA "+concepto+" PECHO DERECHO";
            ubicacion4 = "BORDADO PLAYERA "+concepto+" PECHO IZQUIERDO";
            ubicacion5 = "BORDADO PLAYERA "+concepto+" ESPALDA";

            aplicacion1 = "APLICACION PLAYERA MANGA DERECHA";
            aplicacion2 = "APLICACION PLAYERA MANGA IZQUIERDA";
            aplicacion3 = "APLICACION PLAYERA PECHO DERECHO";
            aplicacion4 = "APLICACION PLAYERA PECHO IZQUIERDO";
            aplicacion5 = "APLICACION PLAYERA ESPALDA";

        }
         else  if (prenda.equals("Saco")) {
            ubicacion1 = "BORDADO SACO "+concepto+" MANGA DERECHA";
            ubicacion2 = "BORDADO SACO "+concepto+" MANGA IZQUIERDA";
            ubicacion3 = "BORDADO SACO "+concepto+" PECHO DERECHO";
            ubicacion4 = "BORDADO SACO "+concepto+" PECHO IZQUIERDO";

            aplicacion1 = "APLICACION SACO MANGA DERECHA";
            aplicacion2 = "APLICACION SACO MANGA IZQUIERDA";
            aplicacion3 = "APLICACION SACO PECHO DERECHO";
            aplicacion4 = "APLICACION SACO PECHO IZQUIERDO";

        } else if (prenda.equals("Filipina")) {
            ubicacion1 = "BORDADO FILIPINA "+concepto+" PECHO DERECHO";
            ubicacion2 = "BORDADO FILIPINA "+concepto+" PECHO IZQUIERDO";

            aplicacion1 = "APLICACION FILIPINA MANGA DERECHA";
            aplicacion2 = "APLICACION FILIPINA MANGA IZQUIERDA";
        }

        for (int i = 1; i <= 5; i++) {
            cantidad = "0";

            String mangaderecha = lbmangaderecha.getText();
            String mangaizquierda = lbmangaizquierdanombre.getText();
            String pechoderecho = lbpechoderecho.getText();
            String pechoizquierdo = lbpechoizquierdo.getText();
            String espalda = lbespalda.getText();

            if (i == 1) {
                ubicacion = ubicacion1;
                if (mangaderecha.equals("")) {
                } else {
                    cantidad = cantidadprendas;
                }
            } else if (i == 2) {
                ubicacion = ubicacion2;
                if (mangaizquierda.equals("")) {
                } else {
                    cantidad = cantidadprendas;
                }
            } else if (i == 3) {
                ubicacion = ubicacion3;
                if (pechoderecho.equals("")) {
                } else {
                    cantidad = cantidadprendas;
                }
            } else if (i == 4) {
                ubicacion = ubicacion4;
                if (pechoizquierdo.equals("")) {
                } else {
                    cantidad = cantidadprendas;
                }
            } else if (i == 5) {
                ubicacion = ubicacion5;
                if (espalda.equals("")) {
                } else {
                    cantidad = cantidadprendas;
                }
            }

            if (estatusorden.equals("Por solicitar")) {

            } else {

                modificarexistenciaykardexcancelar((String) ubicacion, (String) cantidad);

            }

        }

        for (int i = 1; i <= 5; i++) {

            cantidad = "0";

            String mangaderechaaplicacion = lbaplicacionmangaderechacolor.getText();
            String mangaizquierdaaplicacion = lbaplicacionmangaizquierdacolor.getText();
            String pechoderechoaplicacion = lbaplicacionpechoderechocolor.getText();
            String pechoizquierdoaplicacion = lbaplicacionpechoizquierdocolor.getText();
            String espaldaaplicacion = lbaplicacionespaldacolor.getText();

            if (i == 1) {
                aplicacion = aplicacion1;
                if (mangaderechaaplicacion.equals("")) {
                } else {
                    cantidad = lbaplicacionmangaderecha.getText();
                    
                    
                    
                    
                    
                }
            } else if (i == 2) {
                aplicacion = aplicacion2;
                if (mangaizquierdaaplicacion.equals("")) {
                } else {
                    cantidad = lbaplicacionmangaizquierda.getText();
                  
                    
                    
                    
                }
            } else if (i == 3) {
                aplicacion = aplicacion3;
                if (pechoderechoaplicacion.equals("")) {
                } else {
                    cantidad = lbaplicacionpechoderecho.getText();
                }
            } else if (i == 4) {
                aplicacion = aplicacion4;
                if (pechoizquierdoaplicacion.equals("")) {
                } else {
                    cantidad = lbaplicacionpechoizquierdo.getText();
                }
            } else if (i == 5) {
                aplicacion = aplicacion5;
                if (espaldaaplicacion.equals("")) {
                } else {
                    cantidad = lbaplicacionespalda.getText();
                }
            }
            
            int cantidadint = Integer.parseInt(cantidad);
               int cantidadaplicaciones =  cantidadint * cantidadprendasint;  
               cantidad = String.valueOf(cantidadaplicaciones);
            
            
            
            
            

            if (lugar.equals("Esta sucursal")) 
            
            
            {
                modificarexistenciaykardexcancelar((String) aplicacion, (String) cantidad);

            }

        }

        String modi = "UPDATE historial_ordenes_camisa SET estatus_orden='cancelada' WHERE numero = '" + lbfolio.getText() + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
        } catch (Exception e) {
        }

        btncancelar.setEnabled(false);

        if (venderanterior.ventanavenderanterior == true) {

            venderanterior.txtbusqueda.setText(lbnumeroventa.getText());
            venderanterior.btndatos2.doClick();

        }
    }
        
        
        
        */
        
        
            
    
    
    
    
    
    /*
    
    
     
    void sonsolobordadosenlaventa()
    {   
         
         String numeroventa = lbnumeroventa.getText();
         String estatusentrega ="";
         sonsolobordados ="";
         
         String sql = "select articulo  from historial_ventas where numero = '"+numeroventa+"'  ";

                    try {
                        Statement st1 = cn.createStatement();
                        ResultSet rs1 = st1.executeQuery(sql);
                        while (rs1.next()) 
                        {

                            String articulo = rs1.getString("articulo");
                            if(articulo.startsWith("CAMISA")||articulo.startsWith("CAMISOLA")||articulo.startsWith("CHALECO DE GABARDINA")||articulo.startsWith("CHAMARRA ROMPEVIENTOS")||articulo.startsWith("CHAMARRA DE MANGAS"))
                            {
                                sonsolobordados ="no";
                                break;
                            }
                            
   

                        }

                    } catch (SQLException ex) 
                    
                    {
                        System.out.println(ex);
                    }
        
                    
                    
        if(sonsolobordados.equals("no"))
        {
            
        }            
        else
        {
            
            
            String articuloconbordado = lbprenda.getText().toUpperCase();
            String nombrebordado ="";
            
            if (articuloconbordado.contains("CAMISA")) 
                {
                    nombrebordado = "BORDADO CAMISA";
                    
                } 
                else if (articuloconbordado.contains("CAMISA2"))
                {
                    nombrebordado = "BORDADO CAMISA2";
                    
                } 
                else if (articuloconbordado.contains("CAMISA3")) 
                {
                    nombrebordado = "BORDADO CAMISA3";
                    
                } 
                 else if (articuloconbordado.contains("CAMISA4")) 
                {
                    nombrebordado = "BORDADO CAMISA4";
                    
                } 
                 
                 else if (articuloconbordado.contains("CAMISA5")) 
                {
                    nombrebordado = "BORDADO CAMISA5";
                   
                }  
                 
                else if (articuloconbordado.contains("CHAMARRA DESMONTABLE")) 
                {
                    nombrebordado = "BORDADO CHAMARRA DESMONTABLE";
                    
                } 
                else if (articuloconbordado.contains("CHAMARRA2 DESMONTABLE")) 
                {
                    nombrebordado = "BORDADO CHAMARRA2 DESMONTABLE";
                    
                } 
                else if (articuloconbordado.contains("CHAMARRA ROMPEVIENTOS2"))
                {
                    nombrebordado = "BORDADO CHAMARRA ROMPEVIENTOS2";
                   
                } 
                else if (articuloconbordado.contains("CHAMARRA ROMPEVIENTOS"))
                {
                    nombrebordado = "BORDADO CHAMARRA ROMPEVIENTOS";
                    
                } 
                else if (articuloconbordado.contains("CAMISOLA")) 
                {
                    nombrebordado = "BORDADO CAMISOLA";
                    
                } 
                else if (articuloconbordado.contains("PLAYERA"))
                {
                    nombrebordado = "BORDADO PLAYERA ";
                    
                } 
                else if (articuloconbordado.contains("PLAYERA2"))
                {
                    nombrebordado = "BORDADO PLAYERA2";
                    
                } 
                else if (articuloconbordado.contains("PLAYERA3"))
                {
                    nombrebordado = "BORDADO PLAYERA3";
                    
                } 
                else if (articuloconbordado.contains("PLAYERA4"))
                {
                    nombrebordado = "BORDADO PLAYERA4";
                    
                }
                else if (articuloconbordado.contains("PLAYERA5"))
                {
                    nombrebordado = "BORDADO PLAYERA5";
                   
                } 
                else if (articuloconbordado.contains("SACO")) 
                {
                    nombrebordado = "BORDADO SACO";
                   
                }
                else if (articuloconbordado.contains("CHALECO2")) 
                {
                    nombrebordado = "BORDADO CHALECO2";
                    
                }
                 else if (articuloconbordado.contains("CHALECO")) 
                {
                    nombrebordado = "BORDADO CHALECO";
                    
                }
                else if (articuloconbordado.contains("FILIPINA")) {
                    nombrebordado = "BORDADO FILIPINA";
                   
                }
            

            String modi = "UPDATE historial_ventas SET surtida='0'  WHERE numero = '"+lbnumeroventa.getText()+"' and articulo like '"+nombrebordado+"%'  ";
        try {
            PreparedStatement pst = cn.prepareStatement(modi);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) 
        {
          System.out.println(e);  
        }
        
        //// cambia el estatus
        
        int totalvendidasint = 0;
        int totalsolicitadaint = 0;
        int totalordenint = 0;
        int totalcambiadaint = 0;
        int totalcantidadvirtualint = 0;
        int totalsurtidaint = 0;
        int totalentregadasint = 0;
        
        String totalvendidas = "";
        String totalsolicitada = "";
        String totalorden = "";
        String totalcambiada ="";
        String totalcantidadvirtual ="";
        String totalsurtida = "";
        String totalentregadas ="";
        
        try {
                
                String sql2 = "SELECT sum(cantidad)as cantidad,sum(solicitada)as solicitada,sum(orden)as orden,sum(cambiada) as cambiada,sum(cantidad_virtual) as cantidadvirtual,sum(surtida)as surtida,sum(entregadas) as entregadas FROM historial_ventas where numero = '" +numeroventa+"' ";
                Statement st = cn.prepareStatement(sql2);
                ResultSet rs = st.executeQuery(sql2);

                if (rs.next()) 
                {

                   totalvendidas = rs.getString("cantidad");
                   totalsolicitada = rs.getString("solicitada");
                   totalorden = rs.getString("orden");
                   totalcambiada = rs.getString("cambiada");
                   totalcantidadvirtual = rs.getString("cantidadvirtual");
                   totalsurtida = rs.getString("surtida");
                   totalentregadas = rs.getString("entregadas");
                    

                } 

                st.close();
            } catch (SQLException ex) {

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Error "+ex+" ");
            }
        
        
        totalvendidasint = Integer.parseInt(totalvendidas);
        totalsurtidaint = Integer.parseInt(totalsurtida);
        
 
         if (totalvendidasint == totalsurtidaint ) 
        {

            estatusentrega = "surtida totalmente no entregada";
        } 
         else  if ( totalsurtidaint > 0 && totalsurtidaint < totalvendidasint   ) 
        {

           estatusentrega = "surtida parcialmente no entregada";
        }  

        else 
        {

           estatusentrega = "no surtida no entregada";
        }
        
        
        
        try 
        {
            PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET estatus_entrega='" + estatusentrega + "' WHERE numero='"+numeroventa+"' ");
            pst.executeUpdate();
            pst.close();

        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        
        
        }    
        
        if(venderanterior.ventanavenderanterior==true)
        {
            venderanterior.btndatos2.doClick();
        }
        
        
    }
    
    
    
    */
    
    
    
    
    
    
    
    
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbnumero = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbprenda1 = new javax.swing.JLabel();
        lbubicacion1 = new javax.swing.JLabel();
        lbcolor1 = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbprenda2 = new javax.swing.JLabel();
        lbubicacion2 = new javax.swing.JLabel();
        lbcolor2 = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbprenda3 = new javax.swing.JLabel();
        lbubicacion3 = new javax.swing.JLabel();
        lbcolor3 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbprenda4 = new javax.swing.JLabel();
        lbubicacion4 = new javax.swing.JLabel();
        lbcolor4 = new javax.swing.JLabel();
        lbcantidad5 = new javax.swing.JLabel();
        lbprenda5 = new javax.swing.JLabel();
        lbubicacion5 = new javax.swing.JLabel();
        lbcolor5 = new javax.swing.JLabel();
        lbfechaentrega = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbtelefono = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbhoraentrega = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        lbsolicita = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbobservacion = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        lbarticulo = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbnombrerenglon1 = new javax.swing.JLabel();
        lbnombrerenglon2 = new javax.swing.JLabel();
        lbnombrerenglon3 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbletra = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbcantidadtotal = new javax.swing.JLabel();
        lbnumerodeventa = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtbusqueda = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        lbhora = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden portanombre anterior");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
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

        lbnumero.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbnumero.setForeground(new java.awt.Color(204, 0, 0));
        lbnumero.setText("0000000");

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Cant.");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Prenda");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Ubicación");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Color");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 0));
        jLabel5.setText("1.-");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(153, 0, 0));
        jLabel16.setText("2.-");
        jLabel16.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(153, 0, 0));
        jLabel22.setText("3.-");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(153, 0, 0));
        jLabel23.setText("4.-");
        jLabel23.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(153, 0, 0));
        jLabel24.setText("5.-");
        jLabel24.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbubicacion1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbubicacion1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbubicacion2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbubicacion2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbubicacion3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbubicacion3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbubicacion4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbubicacion4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbprenda5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbprenda5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbubicacion5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbubicacion5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfechaentrega.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbfechaentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Celular:");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtelefono.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbtelefono.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Solicitó:");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbhoraentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel30.setText("Hora Entrega:");
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Fecha Entrega:");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsolicita.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbsolicita.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Notas:");
        jLabel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservacion.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbobservacion.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                            .addComponent(lbcantidad1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(lbprenda1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                            .addComponent(lbubicacion1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbcolor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(lbprenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(lbubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbprenda3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbubicacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbprenda4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbubicacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addComponent(lbprenda5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbubicacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lbtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbsolicita, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lbprenda1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(9, 9, 9)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                    .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                    .addComponent(lbprenda2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(lbubicacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lbubicacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(13, 13, 13)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbprenda3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbubicacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(lbcantidad3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbprenda4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbubicacion4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbcantidad4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbprenda5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbubicacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(lbcolor5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbsolicita, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbtelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbobservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );

        lbtipo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbtipo.setForeground(new java.awt.Color(153, 0, 0));
        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbarticulo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbarticulo.setForeground(new java.awt.Color(204, 0, 0));
        lbarticulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Nombre a Bordar:");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrerenglon1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbnombrerenglon1.setForeground(new java.awt.Color(153, 0, 0));
        lbnombrerenglon1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbnombrerenglon1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrerenglon2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrerenglon2.setForeground(new java.awt.Color(153, 0, 0));
        lbnombrerenglon2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbnombrerenglon2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrerenglon3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrerenglon3.setForeground(new java.awt.Color(153, 0, 0));
        lbnombrerenglon3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbnombrerenglon3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Tipo de Letra:");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbletra.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbletra.setForeground(new java.awt.Color(153, 0, 0));
        lbletra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbletra.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Total de Prendas:");
        jLabel15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidadtotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbcantidadtotal.setForeground(new java.awt.Color(153, 0, 0));
        lbcantidadtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadtotal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        lbcantidadtotal.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        lbnumerodeventa.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbnumerodeventa.setText("0000000");
        lbnumerodeventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Venta");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtbusqueda.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtbusqueda.setForeground(new java.awt.Color(153, 0, 0));
        txtbusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbusquedaActionPerformed(evt);
            }
        });
        txtbusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtbusquedaKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Primer renglon");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Segundo renglon");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel19.setText("Tercer renglon");

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Fecha:");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfecha.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbfecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Hora:");
        jLabel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhora.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbhora.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbnombrerenglon3, javax.swing.GroupLayout.DEFAULT_SIZE, 328, Short.MAX_VALUE)
                            .addComponent(lbnombrerenglon2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbnombrerenglon1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(68, 68, 68)
                        .addComponent(jLabel28)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbletra, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbcantidadtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(344, 344, 344)
                        .addComponent(btnsalir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lbnumero, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcantidadtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbletra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnombrerenglon1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbnombrerenglon2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbnombrerenglon3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtbusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(2, 2, 2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbnumerodeventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(10, 10, 10))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(10, 10, 10)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbfecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbarticulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumero, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(16, 16, 16))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

    }//GEN-LAST:event_formWindowActivated

    private void rbextrachicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbextrachicaActionPerformed


    }//GEN-LAST:event_rbextrachicaActionPerformed

    private void rbchicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbchicaActionPerformed


    }//GEN-LAST:event_rbchicaActionPerformed

    private void rbmedianaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbmedianaActionPerformed

    }//GEN-LAST:event_rbmedianaActionPerformed

    private void rbgrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbgrandeActionPerformed

    }//GEN-LAST:event_rbgrandeActionPerformed

    private void rbextragrandeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbextragrandeActionPerformed


    }//GEN-LAST:event_rbextragrandeActionPerformed

    private void rbtalla34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla34ActionPerformed


    }//GEN-LAST:event_rbtalla34ActionPerformed

    private void rbtalla36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla36ActionPerformed

    }//GEN-LAST:event_rbtalla36ActionPerformed

    private void rbtalla38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla38ActionPerformed


    }//GEN-LAST:event_rbtalla38ActionPerformed

    private void rbtalla40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla40ActionPerformed


    }//GEN-LAST:event_rbtalla40ActionPerformed

    private void rbtalla42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla42ActionPerformed


    }//GEN-LAST:event_rbtalla42ActionPerformed

    private void rbtalla44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla44ActionPerformed


    }//GEN-LAST:event_rbtalla44ActionPerformed

    private void rbtalla46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtalla46ActionPerformed


    }//GEN-LAST:event_rbtalla46ActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed

        ventanaordenportanombreanterior = false;
        this.dispose();

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
     
        
        ventanaordenportanombreanterior = false;
        this.dispose();
        
        
    }//GEN-LAST:event_formWindowClosing

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
     
    }//GEN-LAST:event_formWindowClosed

    private void txtbusquedaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbusquedaKeyTyped
      
    }//GEN-LAST:event_txtbusquedaKeyTyped

    private void txtbusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbusquedaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbusquedaActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      datos();
    }//GEN-LAST:event_formWindowOpened

    ResultSet rs;
    ResultSet rs2;

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordenportanombreescolar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnsalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbarticulo;
    private javax.swing.JLabel lbcantidad1;
    private javax.swing.JLabel lbcantidad2;
    private javax.swing.JLabel lbcantidad3;
    private javax.swing.JLabel lbcantidad4;
    private javax.swing.JLabel lbcantidad5;
    public static javax.swing.JLabel lbcantidadtotal;
    private javax.swing.JLabel lbcolor1;
    private javax.swing.JLabel lbcolor2;
    private javax.swing.JLabel lbcolor3;
    private javax.swing.JLabel lbcolor4;
    private javax.swing.JLabel lbcolor5;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbfechaentrega;
    private javax.swing.JLabel lbhora;
    private javax.swing.JLabel lbhoraentrega;
    private javax.swing.JLabel lbletra;
    private javax.swing.JLabel lbnombrerenglon1;
    private javax.swing.JLabel lbnombrerenglon2;
    private javax.swing.JLabel lbnombrerenglon3;
    public static javax.swing.JLabel lbnumero;
    public static javax.swing.JLabel lbnumerodeventa;
    private javax.swing.JLabel lbobservacion;
    private javax.swing.JLabel lbprenda1;
    private javax.swing.JLabel lbprenda2;
    private javax.swing.JLabel lbprenda3;
    private javax.swing.JLabel lbprenda4;
    private javax.swing.JLabel lbprenda5;
    private javax.swing.JLabel lbsolicita;
    private javax.swing.JLabel lbtelefono;
    private javax.swing.JLabel lbtipo;
    private javax.swing.JLabel lbubicacion1;
    private javax.swing.JLabel lbubicacion2;
    private javax.swing.JLabel lbubicacion3;
    private javax.swing.JLabel lbubicacion4;
    private javax.swing.JLabel lbubicacion5;
    public static javax.swing.JTextField txtbusqueda;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();


}