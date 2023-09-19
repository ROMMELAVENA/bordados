package sistemabordadores;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

public class ordeninternagorra extends javax.swing.JFrame {

    public static boolean ventanaordeninternagorraanterior = false;

    private PreparedStatement pst;

    String numerocatalogoprendas = "";
    String numerocatalogoubicacion = "";
    String numerocatalogocolores = "";

    String cantidad = "";
    String cantidadentregada = "";
    String cantidadremanente = "";
    String prenda = "";
    String color = "";
    String descripcion = "";
    String nombrecompleto = "";
    String estatusentrega = "";
    String numerodeorden = "";
    String articulo = "";
    String s1 = "GORRA ";
    String s2 = " CON BORDADO ";

    int renglon = 0;
    String fechatermine = "";
    String primero = "";
    String ultimo = "";
    int posicion = 0;
    int primernumero = 0;
    int posiciondelarreglo = 0;
    String bordado = "";

    ArrayList<String> listagorras = new ArrayList<String>();

    public ordeninternagorra() {
        initComponents();
        ventanaordeninternagorraanterior = true;
        btncancelarbordado.setVisible(false);
      
        
        
        btntermine1.setEnabled(false);
        btntermine2.setEnabled(false);
        btntermine3.setEnabled(false);
        btntermine4.setEnabled(false);
        btntermine5.setEnabled(false);
        btntermine6.setEnabled(false);
        btntermine7.setEnabled(false);
        btntermine8.setEnabled(false);
        btntermine9.setEnabled(false);
        btntermine10.setEnabled(false);
        
        
        btncancelar1.setEnabled(false);
        btncancelar2.setEnabled(false);
        btncancelar3.setEnabled(false);
        btncancelar4.setEnabled(false);
        btncancelar5.setEnabled(false);
        btncancelar6.setEnabled(false);
        btncancelar7.setEnabled(false);
        btncancelar8.setEnabled(false);
        btncancelar9.setEnabled(false);
        btncancelar10.setEnabled(false);

    }

  
    
    
    void limpiarlostextfield()
    {
        lbcantidad1.setText("");
        lbcantidad2.setText("");
        lbcantidad3.setText("");
        lbcantidad4.setText("");
        lbcantidad5.setText("");
        lbcantidad6.setText("");
        lbcantidad7.setText("");
        lbcantidad8.setText("");
        lbcantidad9.setText("");
        lbcantidad10.setText("");
        
     
        
        lbcolor1.setText("");
        lbcolor2.setText("");
        lbcolor3.setText("");
        lbcolor4.setText("");
        lbcolor5.setText("");
        lbcolor6.setText("");
        lbcolor7.setText("");
        lbcolor8.setText("");
        lbcolor9.setText("");
        lbcolor10.setText("");

        lbnombre1.setText("");
        lbnombre2.setText("");
        lbnombre3.setText("");
        lbnombre4.setText("");
        lbnombre5.setText("");
        lbnombre6.setText("");
        lbnombre7.setText("");
        lbnombre8.setText("");
        lbnombre9.setText("");
        lbnombre10.setText("");
        
        lbarticulo1.setText("");
        lbarticulo2.setText("");
        lbarticulo3.setText("");
        lbarticulo4.setText("");
        lbarticulo5.setText("");
        lbarticulo6.setText("");
        lbarticulo7.setText("");
        lbarticulo8.setText("");
        lbarticulo9.setText("");
        lbarticulo10.setText("");
      
                
    }

    void datos() {

        String sql = "";
        numerodeorden = lbnumerodeorden.getText();
        renglon = 0;

        limpiarlostextfield();
        
        
        int sumaterminadas = 0;
        int sumaporrealizar = 0;
        

            sql = "SELECT numero,fecha,fecha_termine,hora,tipo,cantidad,color,descripcion,estatus_entrega,fecha_entrega FROM historial_ordenes_bordados_interno WHERE numero = '" + numerodeorden + "'";

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                   
                    lbnumerodeorden.setText(numerodeorden);
                    lbfecha.setText(rs.getString("fecha"));
                    
                    fechatermine = rs.getString("fecha_termine");
                    lbhora.setText(rs.getString("hora"));
                    cantidad = rs.getString("cantidad");
                 
                    color = rs.getString("color");
                    descripcion = rs.getString("descripcion");             
                    nombrecompleto = s1 + color + s2 + descripcion;

                    renglon = renglon + 1;
                    
                    
                    
                    mostrarrenglonesgorra();
                
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    if (renglon==1)
                    
                    {   if (fechatermine == null || fechatermine.equals(""))
            {
                 btntermine1.setEnabled(true);
                 btncancelar1.setEnabled(false);
                 
                 sumaporrealizar = sumaporrealizar + 1;
                 
            }
            else
            {
                btntermine1.setEnabled(false);
                btncancelar1.setEnabled(true);
                
                
                sumaterminadas = sumaterminadas + 1;
            }}
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    if (renglon==2){ if (fechatermine == null || fechatermine.equals(""))
            {
                 btntermine2.setEnabled(true);
                 btncancelar2.setEnabled(false);
                 
                 sumaporrealizar = sumaporrealizar + 1;
                 
            }
            else
            {
                btntermine2.setEnabled(false);
                btncancelar2.setEnabled(true);
                
                sumaterminadas = sumaterminadas + 1;
            }}
                    
                    
                    
                    
                    
                    
                    
                    if (renglon==3){ if (fechatermine == null || fechatermine.equals(""))
            {
                 btntermine3.setEnabled(true);
                 btncancelar3.setEnabled(false);
                 
                 sumaporrealizar = sumaporrealizar + 1;
                 
            }
            else
            {
                btntermine3.setEnabled(false);
                btncancelar3.setEnabled(true);
                
                sumaterminadas = sumaterminadas + 1;
            }}
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    if (renglon==4){ if (fechatermine == null || fechatermine.equals(""))
            {
                 btntermine4.setEnabled(true);
                 btncancelar4.setEnabled(false);
                 
                 sumaporrealizar = sumaporrealizar + 1;
                 
            }
            else
            {
                btntermine4.setEnabled(false);
                btncancelar4.setEnabled(true);
                
                sumaterminadas = sumaterminadas + 1;
            }}
                    
                    
                    
                    
                    
                    
                    if (renglon==5){ if (fechatermine == null || fechatermine.equals(""))
            {
                 btntermine5.setEnabled(true);
                 btncancelar5.setEnabled(false);
                 
                 sumaporrealizar = sumaporrealizar + 1;
                 
            }
            else
            {
                btntermine5.setEnabled(false);
                btncancelar5.setEnabled(true);
                
                sumaterminadas = sumaterminadas + 1;
            }}
                    
                    
                    
                    
                    
                    
                    
                    
                    if (renglon==6){ if (fechatermine == null || fechatermine.equals(""))
            {
                 btntermine6.setEnabled(true);
                 btncancelar6.setEnabled(false);
                 
                 sumaporrealizar = sumaporrealizar + 1;
                 
            }
            else
            {
                btntermine6.setEnabled(false);
                btncancelar6.setEnabled(true);
                
                sumaterminadas = sumaterminadas + 1;
            }}
                    
                    
                    
                    
                    
                    
                    
                    if (renglon==7){ if (fechatermine == null || fechatermine.equals(""))
            {
                 btntermine7.setEnabled(true);
                 btncancelar7.setEnabled(false);
                 
                 sumaporrealizar = sumaporrealizar + 1;
                 
            }
            else
            {
                btntermine7.setEnabled(false);
                btncancelar7.setEnabled(true);
                
                sumaterminadas = sumaterminadas + 1;
            }}
                    
                    
                    
                    
                    
                    
                    
                    
                    if (renglon==8){ if (fechatermine == null || fechatermine.equals(""))
            {
                 btntermine8.setEnabled(true);
                 btncancelar8.setEnabled(false);
                 
                 sumaporrealizar = sumaporrealizar + 1;
                 
            }
            else
            {
                btntermine8.setEnabled(false);
                btncancelar8.setEnabled(true);
                
                sumaterminadas = sumaterminadas + 1;
            }}
                    
                    
                    
                    
                    
                    
                    
                    if (renglon==9){ if (fechatermine == null || fechatermine.equals(""))
            {
                 btntermine9.setEnabled(true);
                 btncancelar9.setEnabled(false);
                 
                 sumaporrealizar = sumaporrealizar + 1;
                 
            }
            else
            {
                btntermine9.setEnabled(false);
                btncancelar9.setEnabled(true);
                
                sumaterminadas = sumaterminadas + 1;
            }}
                    
                    
                    
                    
                    
                    
                    
                    
                    if (renglon==10){ if (fechatermine == null || fechatermine.equals(""))
            {
                 btntermine10.setEnabled(true);
                 btncancelar10.setEnabled(false);
                 
                 sumaporrealizar = sumaporrealizar + 1;
                 
            }
            else
            {
                btntermine10.setEnabled(false);
                btncancelar10.setEnabled(true);
                
                sumaterminadas = sumaterminadas + 1;
            }}
                    
                  
                    
                    

                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            
            
            
            
            if (sumaterminadas==0 && sumaporrealizar>0)
                
            {
                estatusentrega = "solicitada";
            }
            else
                
             if (sumaterminadas>0 && sumaporrealizar>0)    
            {
                estatusentrega = "realizada parcialmente";
            }
            
              else
                
             if (sumaterminadas>0 && sumaporrealizar==0)    
            {
                estatusentrega = "realizada totalmente";
            }
            
            

            lbestatusentrega.setText(estatusentrega);
            
            
            
            actualizarestatusentregaenelhistorialbordadosinterno();
            
            
         

    }

    void mostrarrenglonesgorra() {

        if (renglon == 1) {
            lbcantidad1.setText(cantidad);
          
            lbcolor1.setText(color);
            lbnombre1.setText(descripcion);
            lbarticulo1.setText(nombrecompleto);

        } else if (renglon == 2) {
            lbcantidad2.setText(cantidad);
          
            lbcolor2.setText(color);
            lbnombre2.setText(descripcion);
            lbarticulo2.setText(nombrecompleto);

        } else if (renglon == 3) {
            lbcantidad3.setText(cantidad);
          
            lbcolor3.setText(color);
            lbnombre3.setText(descripcion);
            lbarticulo3.setText(nombrecompleto);

        } else if (renglon == 4) {
            lbcantidad4.setText(cantidad);
          
            lbcolor4.setText(color);
            lbnombre4.setText(descripcion);
            lbarticulo4.setText(nombrecompleto);

        } else if (renglon == 5) {
            lbcantidad5.setText(cantidad);
           
            lbcolor5.setText(color);
            lbnombre5.setText(descripcion);
            lbarticulo5.setText(nombrecompleto);

        } else if (renglon == 6) {
            lbcantidad6.setText(cantidad);
           
            lbcolor6.setText(color);
            lbnombre6.setText(descripcion);
            lbarticulo6.setText(nombrecompleto);

        } else if (renglon == 7) {
            lbcantidad7.setText(cantidad);
          
            lbcolor7.setText(color);
            lbnombre7.setText(descripcion);
            lbarticulo7.setText(nombrecompleto);

        } else if (renglon == 8) {
            lbcantidad8.setText(cantidad);
           
            lbcolor8.setText(color);
            lbnombre8.setText(descripcion);
            lbarticulo8.setText(nombrecompleto);

        } else if (renglon == 9) {
            lbcantidad9.setText(cantidad);
          
            lbcolor9.setText(color);
            lbnombre9.setText(descripcion);
            lbarticulo9.setText(nombrecompleto);

        } else {
            if (renglon == 10) {
                lbcantidad10.setText(cantidad);
             
                lbcolor10.setText(color);
                lbnombre10.setText(descripcion);
                lbarticulo10.setText(nombrecompleto);

            }
        }

    }

    void mostrarrenglonesparche() {
/*
        
        
        if (renglon == 1) {
            ordeninternaparche.lbcantidad1.setText(cantidad);
            ordeninternaparche.lbnombre1.setText(descripcion);

        } else if (renglon == 2) {
            ordeninternaparche.lbcantidad2.setText(cantidad);
            ordeninternaparche.lbnombre2.setText(descripcion);

        } else if (renglon == 3) {
            ordeninternaparche.lbcantidad3.setText(cantidad);
            ordeninternaparche.lbnombre3.setText(descripcion);

        } else if (renglon == 4) {
            ordeninternaparche.lbcantidad4.setText(cantidad);
            ordeninternaparche.lbnombre4.setText(descripcion);

        } else if (renglon == 5) {
            ordeninternaparche.lbcantidad5.setText(cantidad);
            ordeninternaparche.lbnombre5.setText(descripcion);

        }
        
        */

    }

    public static String dia() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        return formatoFecha.format(fecha);
    }

    public static String hora() {
        Date hora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat(" HH:mm:ss  ");
        return formatoFecha.format(hora);
    }
    
    
    
    
    
    
    void actualizarinterfaceordenesporrealizaryordenesterminadas(){
        
        
        
        
            if(ordenesporrealizar.ventanaordenesporrealizar==true)
         {
             ordenesporrealizar.btndatos.doClick();
         }
         
       
                
                       if(ordenesterminadas.ventanaordenesterminadas==true)
         {
             ordenesterminadas.btndatos.doClick();
         }
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void agregarlafechaenquetermineenelhistorialordenesinterna(){
        
       
        
      
        String modi = "UPDATE historial_ordenes_bordados_interno SET fecha_termine='" + dia() + "' WHERE descripcion = '" + bordado + "' and numero = '"+numerodeorden+"' ";
            try {
                PreparedStatement pst = cn.prepareStatement(modi);
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    void modificarexistenciaykardex(String nombre, String cantidad) {

        String numero = lbnumerodeorden.getText();
        String cantidadactual = "0";
        String nuevaexistencia = "";
        String codigoarticulo = "";

        String sql = "SELECT existencia FROM catalogo_articulos WHERE  descripcion='" + nombre + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                cantidadactual = rs.getString("existencia");
             
            }

        } catch (Exception e) {
        }

        int cantidadactualint = Integer.parseInt(cantidadactual);
        int cantidadsurtidaint = Integer.parseInt(cantidad);
        int nuevaexistenciaint = cantidadactualint + cantidadsurtidaint;
        nuevaexistencia = String.valueOf(nuevaexistenciaint);

        if (cantidad.equals("0")) 
        
        {

        } 
        
        else
        
        {

            String modi = "UPDATE catalogo_articulos SET existencia='" + nuevaexistencia + "' WHERE descripcion = '" + nombre + "'";
            try {
                PreparedStatement pst = cn.prepareStatement(modi);
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

           

            String InsertarSQL = "INSERT INTO kardex(descripcion,fecha,hora,tipo,numero,cantidad_anterior,cantidad,cantidad_nueva,codigo) VALUES (?,?,?,?,?,?,?,?,?)";

            String tipo = "Orden bordado interno gorra";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, nombre);
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, tipo);
                pst.setString(5, numero);
                pst.setString(6, cantidadactual);
                pst.setString(7, cantidad);
                pst.setString(8, nuevaexistencia);
                pst.setString(9, codigoarticulo);

                pst.executeUpdate();
                pst.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }

    }

    
    
    
    
    
    void actualizarestatusentregaenelhistorialbordadosinterno(){
        
        
        
        
       String modi2 = "UPDATE historial_ordenes_bordados_interno SET estatus_entrega='"+estatusentrega+"' WHERE numero = '" + numerodeorden + "'";
            try {
                PreparedStatement pst = cn.prepareStatement(modi2);
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    void modificarexistenciaykardexgorrascancelada(String nombre, String cantidad) {

        String numero = lbnumerodeorden.getText();
        String cantidadactual = "0";
        String nuevaexistencia = "";
        String codigoarticulo = "";

        String sql = "SELECT existencia,codigo FROM catalogo_articulos WHERE  descripcion='" + nombre + "'";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                cantidadactual = rs.getString(1);
                codigoarticulo = rs.getString(2);

            }

        } catch (Exception e) {
        }

        int cantidadactualint = Integer.parseInt(cantidadactual);
        int cantidadsurtidaint = Integer.parseInt(cantidad);
        int nuevaexistenciaint = cantidadactualint + cantidadsurtidaint;
        nuevaexistencia = String.valueOf(nuevaexistenciaint);

        if (cantidad.equals("0")) {

        } else {

            String modi = "UPDATE catalogo_articulos SET existencia='" + nuevaexistencia + "' WHERE descripcion = '" + nombre + "'";
            try {
                PreparedStatement pst = cn.prepareStatement(modi);
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            String modi2 = "UPDATE historial_ordenes_bordados_interno SET estatus_entrega='cancelada' WHERE numero = '" + numero + "'";
            try {
                PreparedStatement pst = cn.prepareStatement(modi2);
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            String InsertarSQL = "INSERT INTO kardex(descripcion,fecha,hora,tipo,numero,cantidad_anterior,cantidad,cantidad_nueva,codigo) VALUES (?,?,?,?,?,?,?,?,?)";

            String tipo = "Orden bordado interno gorra cancelada";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);
                pst.setString(1, nombre);
                pst.setString(2, dia());
                pst.setString(3, hora());
                pst.setString(4, tipo);
                pst.setString(5, numero);
                pst.setString(6, cantidadactual);
                pst.setString(7, cantidad);
                pst.setString(8, nuevaexistencia);
                pst.setString(9, codigoarticulo);

                pst.executeUpdate();
                pst.close();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }

    }
    
    
    
    
    
    
    
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lbnumerodeorden = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        lbtipo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbhora = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbestatusentrega = new javax.swing.JLabel();
        btncancelarbordado = new javax.swing.JButton();
        lbcantidad10 = new javax.swing.JLabel();
        lbcantidad9 = new javax.swing.JLabel();
        lbcantidad8 = new javax.swing.JLabel();
        lbcolor8 = new javax.swing.JLabel();
        lbcolor9 = new javax.swing.JLabel();
        lbcolor10 = new javax.swing.JLabel();
        lbnombre10 = new javax.swing.JLabel();
        lbnombre9 = new javax.swing.JLabel();
        lbnombre8 = new javax.swing.JLabel();
        lbarticulo10 = new javax.swing.JLabel();
        lbarticulo9 = new javax.swing.JLabel();
        lbarticulo8 = new javax.swing.JLabel();
        lbcantidad7 = new javax.swing.JLabel();
        lbcantidad6 = new javax.swing.JLabel();
        lbcantidad5 = new javax.swing.JLabel();
        lbcolor7 = new javax.swing.JLabel();
        lbcolor5 = new javax.swing.JLabel();
        lbcolor6 = new javax.swing.JLabel();
        lbnombre7 = new javax.swing.JLabel();
        lbnombre6 = new javax.swing.JLabel();
        lbnombre5 = new javax.swing.JLabel();
        lbarticulo5 = new javax.swing.JLabel();
        lbarticulo6 = new javax.swing.JLabel();
        lbarticulo7 = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbcolor4 = new javax.swing.JLabel();
        lbcolor3 = new javax.swing.JLabel();
        lbcolor2 = new javax.swing.JLabel();
        lbcolor1 = new javax.swing.JLabel();
        lbnombre1 = new javax.swing.JLabel();
        lbnombre2 = new javax.swing.JLabel();
        lbnombre3 = new javax.swing.JLabel();
        lbnombre4 = new javax.swing.JLabel();
        lbarticulo4 = new javax.swing.JLabel();
        lbarticulo3 = new javax.swing.JLabel();
        lbarticulo2 = new javax.swing.JLabel();
        lbarticulo1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lbtitulo2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbtitulo3 = new javax.swing.JLabel();
        btntermine1 = new javax.swing.JButton();
        btncancelar1 = new javax.swing.JButton();
        btntermine2 = new javax.swing.JButton();
        btncancelar2 = new javax.swing.JButton();
        btntermine3 = new javax.swing.JButton();
        btncancelar3 = new javax.swing.JButton();
        btntermine4 = new javax.swing.JButton();
        btncancelar4 = new javax.swing.JButton();
        btntermine5 = new javax.swing.JButton();
        btncancelar5 = new javax.swing.JButton();
        btntermine6 = new javax.swing.JButton();
        btncancelar6 = new javax.swing.JButton();
        btntermine7 = new javax.swing.JButton();
        btncancelar7 = new javax.swing.JButton();
        btntermine8 = new javax.swing.JButton();
        btncancelar8 = new javax.swing.JButton();
        btntermine9 = new javax.swing.JButton();
        btncancelar9 = new javax.swing.JButton();
        btntermine10 = new javax.swing.JButton();
        btncancelar10 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Orden interna gorra");
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

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("No. de orden");
        jLabel13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumerodeorden.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnumerodeorden.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        lbtipo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbtipo.setForeground(new java.awt.Color(204, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Fecha");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfecha.setText(" ");
        lbfecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Hora");
        jLabel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhora.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhora.setText(" ");
        lbhora.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Estatus Entrega");
        jLabel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbestatusentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbestatusentrega.setText(" ");
        lbestatusentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btncancelarbordado.setText("Cancelar");
        btncancelarbordado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarbordadoActionPerformed(evt);
            }
        });

        lbcantidad10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbarticulo10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbarticulo9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbarticulo8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbarticulo5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbarticulo6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbarticulo7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbarticulo4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbarticulo3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbarticulo2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbarticulo1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Cantidad");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtitulo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbtitulo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtitulo2.setText("Color Gorra");
        lbtitulo2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Nombre");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtitulo3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbtitulo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbtitulo3.setText("Bordado");
        lbtitulo3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btntermine1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine1.setText("Termine");
        btntermine1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermine1ActionPerformed(evt);
            }
        });

        btncancelar1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar1.setText("Cancelar");

        btntermine2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine2.setText("Termine");
        btntermine2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermine2ActionPerformed(evt);
            }
        });

        btncancelar2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar2.setText("Cancelar");

        btntermine3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine3.setText("Termine");
        btntermine3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermine3ActionPerformed(evt);
            }
        });

        btncancelar3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar3.setText("Cancelar");

        btntermine4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine4.setText("Termine");
        btntermine4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermine4ActionPerformed(evt);
            }
        });

        btncancelar4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar4.setText("Cancelar");

        btntermine5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine5.setText("Termine");
        btntermine5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermine5ActionPerformed(evt);
            }
        });

        btncancelar5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar5.setText("Cancelar");

        btntermine6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine6.setText("Termine");
        btntermine6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermine6ActionPerformed(evt);
            }
        });

        btncancelar6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar6.setText("Cancelar");

        btntermine7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine7.setText("Termine");
        btntermine7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermine7ActionPerformed(evt);
            }
        });

        btncancelar7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar7.setText("Cancelar");

        btntermine8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine8.setText("Termine");
        btntermine8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermine8ActionPerformed(evt);
            }
        });

        btncancelar8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar8.setText("Cancelar");

        btntermine9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine9.setText("Termine");
        btntermine9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermine9ActionPerformed(evt);
            }
        });

        btncancelar9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar9.setText("Cancelar");

        btntermine10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btntermine10.setText("Termine");
        btntermine10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermine10ActionPerformed(evt);
            }
        });

        btncancelar10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btncancelar10.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbnumerodeorden, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbestatusentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancelarbordado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(6, 6, 6)
                        .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel7)
                        .addGap(6, 6, 6))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbcantidad8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbcolor8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor9, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor10, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(lbtitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbtitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbarticulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbarticulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbarticulo1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbarticulo4, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbarticulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbnombre4, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbnombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbnombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbnombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbarticulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbarticulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbnombre10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbnombre9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbnombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbarticulo10, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbarticulo9, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbarticulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btntermine2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btncancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btntermine1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btncancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btntermine4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btncancelar4, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btntermine3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btncancelar3, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btntermine5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btncancelar5, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btntermine7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btncancelar7, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btntermine6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btncancelar6, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btntermine8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncancelar8, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btntermine9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncancelar9, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btntermine10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncancelar10, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbarticulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btntermine1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btncancelar1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbarticulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btntermine2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btncancelar2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbarticulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btntermine3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btncancelar3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(9, 9, 9)
                                                .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(13, 13, 13)
                                        .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbarticulo4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbnombre4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(btntermine4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btncancelar4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbnombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbarticulo5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btntermine5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btncancelar5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbarticulo6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbarticulo7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbnombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbnombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btntermine6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btncancelar6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btntermine7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btncancelar7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbarticulo8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbarticulo9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbarticulo10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbnombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbnombre9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(lbnombre10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btntermine8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btncancelar8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btntermine9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btncancelar9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(btntermine10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(btncancelar10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbcolor8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbcolor9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbcolor10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(111, 111, 111))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(lbcantidad8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbcantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbcantidad10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbnumerodeorden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbestatusentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncancelarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
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

        ventanaordeninternagorraanterior = false;
        this.dispose();

    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordeninternagorraanterior = false;
    }//GEN-LAST:event_formWindowClosing
    void cancelarbordado() {
        String numero = lbnumerodeorden.getText();
        String cantidad = "";
        String nombre = ""; 
        
        for(int i = 0; i < 10 ; i++ )
        {
            
            
            if(i==0)
            {
            
            cantidad = lbcantidad1.getText();
            nombre = lbcolor1.getText(); 
            
            }
           else if(i==1)
            {
            
            cantidad = lbcantidad2.getText();
            nombre = lbcolor2.getText(); 
            
            }
            else if(i==2)
            {
            
            cantidad = lbcantidad3.getText();
            nombre = lbcolor3.getText(); 
            
            }
            else if(i==3)
            {
            
            cantidad = lbcantidad4.getText();
            nombre = lbcolor4.getText(); 
            
            }
            else if(i==4)
            {
            
            cantidad = lbcantidad5.getText();
            nombre = lbcolor5.getText(); 
            
            }
            else if(i==5)
            {
            
            cantidad = lbcantidad6.getText();
            nombre = lbcolor6.getText(); 
            
            }
            else if(i==6)
            {
            
            cantidad = lbcantidad7.getText();
            nombre = lbcolor7.getText(); 
            
            }
            else if(i==7)
            {
            
            cantidad = lbcantidad8.getText();
            nombre = lbcolor8.getText(); 
            
            }
            else if(i==8)
            {
            
            cantidad = lbcantidad9.getText();
            nombre = lbcolor9.getText(); 
            
            }
            else if(i==9)
            {
            
            cantidad = lbcantidad10.getText();
            nombre = lbcolor10.getText(); 
            
            }
            
            
            if(nombre == null || nombre.equals("")||cantidad ==null ||cantidad.equals(""))
            {
                
            }
            else
            {
                
            if(nombre.contains("AZUL MARINO"))
            {
                nombre = "GORRA BEISBOLERA AZUL MARINO";
            }
            else if(nombre.contains("NEGRA"))
            {
                nombre = "GORRA BEISBOLERA NEGRA";
            }
            

            
             modificarexistenciaykardexgorrascancelada((String)nombre,(String) cantidad);
            
            }
        }
        

        
        String modi2 = "UPDATE historial_ordenes_bordados_interno SET estatus_entrega='cancelada' WHERE numero = '" + numero + "'";
        try {
            PreparedStatement pst = cn.prepareStatement(modi2);
            pst.executeUpdate();
            pst.close();
        } catch (Exception e) {
            System.out.println(e);
        }

       
    }
    
     
    

    private void btncancelarbordadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarbordadoActionPerformed
      cancelarbordado();
    }//GEN-LAST:event_btncancelarbordadoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      datos();
    }//GEN-LAST:event_formWindowOpened

    private void btntermine1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermine1ActionPerformed
       
        
        articulo = lbarticulo1.getText();
        cantidad = lbcantidad1.getText();
        bordado = lbnombre1.getText();
        
        agregarlafechaenquetermineenelhistorialordenesinterna();
        
        
      
        modificarexistenciaykardex((String)articulo,(String) cantidad);
                
        
        
        datos();
        
        
        
        
        
        
    }//GEN-LAST:event_btntermine1ActionPerformed

    private void btntermine2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermine2ActionPerformed
     
        
        
        articulo = lbarticulo2.getText();
        cantidad = lbcantidad2.getText();
        bordado = lbnombre2.getText();
        
         agregarlafechaenquetermineenelhistorialordenesinterna();
        
        
      
        modificarexistenciaykardex((String)articulo,(String) cantidad);
        
        
        
         datos();
         
         
         
         actualizarinterfaceordenesporrealizaryordenesterminadas();
       
         
         
         
         
         
        
    }//GEN-LAST:event_btntermine2ActionPerformed

    private void btntermine3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermine3ActionPerformed
      
        
        
         articulo = lbarticulo3.getText();
        cantidad = lbcantidad3.getText();
        bordado = lbnombre3.getText();
        
         agregarlafechaenquetermineenelhistorialordenesinterna();
        
        
      
        modificarexistenciaykardex((String)articulo,(String) cantidad);
        
        
        
         datos();
         
         
         actualizarinterfaceordenesporrealizaryordenesterminadas();
         
         
    }//GEN-LAST:event_btntermine3ActionPerformed

    private void btntermine4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermine4ActionPerformed
       
        
         articulo = lbarticulo4.getText();
        cantidad = lbcantidad4.getText();
        bordado = lbnombre4.getText();
        
         agregarlafechaenquetermineenelhistorialordenesinterna();
        
        
      
        modificarexistenciaykardex((String)articulo,(String) cantidad);
        
        
         datos();
         
         
         actualizarinterfaceordenesporrealizaryordenesterminadas();
        
        
        
    }//GEN-LAST:event_btntermine4ActionPerformed

    private void btntermine5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermine5ActionPerformed
      
        
         articulo = lbarticulo5.getText();
        cantidad = lbcantidad5.getText();
        bordado = lbnombre5.getText();
        
         agregarlafechaenquetermineenelhistorialordenesinterna();
        
        
      
        modificarexistenciaykardex((String)articulo,(String) cantidad);
        
        
         datos();
         
         
         actualizarinterfaceordenesporrealizaryordenesterminadas();
        
    }//GEN-LAST:event_btntermine5ActionPerformed

    private void btntermine6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermine6ActionPerformed
     
        
         articulo = lbarticulo6.getText();
        cantidad = lbcantidad6.getText();
        bordado = lbnombre6.getText();
        
         agregarlafechaenquetermineenelhistorialordenesinterna();
        
        
      
        modificarexistenciaykardex((String)articulo,(String) cantidad);
        
        
         datos();
         
         
         actualizarinterfaceordenesporrealizaryordenesterminadas();
        
        
        
    }//GEN-LAST:event_btntermine6ActionPerformed

    private void btntermine7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermine7ActionPerformed
       
        
         articulo = lbarticulo7.getText();
        cantidad = lbcantidad7.getText();
        bordado = lbnombre7.getText();
        
         agregarlafechaenquetermineenelhistorialordenesinterna();
        
        
      
        modificarexistenciaykardex((String)articulo,(String) cantidad);
        
        
         datos();
        
         
         actualizarinterfaceordenesporrealizaryordenesterminadas();
        
        
        
    }//GEN-LAST:event_btntermine7ActionPerformed

    private void btntermine8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermine8ActionPerformed
        
         articulo = lbarticulo8.getText();
        cantidad = lbcantidad8.getText();
        bordado = lbnombre8.getText();
        
         agregarlafechaenquetermineenelhistorialordenesinterna();
        
        
      
        modificarexistenciaykardex((String)articulo,(String) cantidad);
        
        
         datos();
        
        
         
         actualizarinterfaceordenesporrealizaryordenesterminadas();
        
        
    }//GEN-LAST:event_btntermine8ActionPerformed

    private void btntermine9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermine9ActionPerformed
       
        
         articulo = lbarticulo9.getText();
        cantidad = lbcantidad9.getText();
        bordado = lbnombre9.getText();
        
         agregarlafechaenquetermineenelhistorialordenesinterna();
        
        
      
        modificarexistenciaykardex((String)articulo,(String) cantidad);
        
        
         datos();
        
        
         actualizarinterfaceordenesporrealizaryordenesterminadas();
        
        
    }//GEN-LAST:event_btntermine9ActionPerformed

    private void btntermine10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermine10ActionPerformed
      
        
         articulo = lbarticulo10.getText();
        cantidad = lbcantidad10.getText();
        bordado = lbnombre10.getText();
        
         agregarlafechaenquetermineenelhistorialordenesinterna();
        
        
      
        modificarexistenciaykardex((String)articulo,(String) cantidad);
        
        
         datos();
         
         
         actualizarinterfaceordenesporrealizaryordenesterminadas();
        
        
    }//GEN-LAST:event_btntermine10ActionPerformed

    ResultSet rs;
    ResultSet rs2;

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordeninternagorra().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar1;
    private javax.swing.JButton btncancelar10;
    private javax.swing.JButton btncancelar2;
    private javax.swing.JButton btncancelar3;
    private javax.swing.JButton btncancelar4;
    private javax.swing.JButton btncancelar5;
    private javax.swing.JButton btncancelar6;
    private javax.swing.JButton btncancelar7;
    private javax.swing.JButton btncancelar8;
    private javax.swing.JButton btncancelar9;
    public static javax.swing.JButton btncancelarbordado;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btntermine1;
    private javax.swing.JButton btntermine10;
    private javax.swing.JButton btntermine2;
    private javax.swing.JButton btntermine3;
    private javax.swing.JButton btntermine4;
    private javax.swing.JButton btntermine5;
    private javax.swing.JButton btntermine6;
    private javax.swing.JButton btntermine7;
    private javax.swing.JButton btntermine8;
    private javax.swing.JButton btntermine9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    public static javax.swing.JLabel lbarticulo1;
    public static javax.swing.JLabel lbarticulo10;
    public static javax.swing.JLabel lbarticulo2;
    public static javax.swing.JLabel lbarticulo3;
    public static javax.swing.JLabel lbarticulo4;
    public static javax.swing.JLabel lbarticulo5;
    public static javax.swing.JLabel lbarticulo6;
    public static javax.swing.JLabel lbarticulo7;
    public static javax.swing.JLabel lbarticulo8;
    public static javax.swing.JLabel lbarticulo9;
    public static javax.swing.JLabel lbcantidad1;
    public static javax.swing.JLabel lbcantidad10;
    public static javax.swing.JLabel lbcantidad2;
    public static javax.swing.JLabel lbcantidad3;
    public static javax.swing.JLabel lbcantidad4;
    public static javax.swing.JLabel lbcantidad5;
    public static javax.swing.JLabel lbcantidad6;
    public static javax.swing.JLabel lbcantidad7;
    public static javax.swing.JLabel lbcantidad8;
    public static javax.swing.JLabel lbcantidad9;
    public static javax.swing.JLabel lbcolor1;
    public static javax.swing.JLabel lbcolor10;
    public static javax.swing.JLabel lbcolor2;
    public static javax.swing.JLabel lbcolor3;
    public static javax.swing.JLabel lbcolor4;
    public static javax.swing.JLabel lbcolor5;
    public static javax.swing.JLabel lbcolor6;
    public static javax.swing.JLabel lbcolor7;
    public static javax.swing.JLabel lbcolor8;
    public static javax.swing.JLabel lbcolor9;
    public static javax.swing.JLabel lbestatusentrega;
    public static javax.swing.JLabel lbfecha;
    public static javax.swing.JLabel lbhora;
    public static javax.swing.JLabel lbnombre1;
    public static javax.swing.JLabel lbnombre10;
    public static javax.swing.JLabel lbnombre2;
    public static javax.swing.JLabel lbnombre3;
    public static javax.swing.JLabel lbnombre4;
    public static javax.swing.JLabel lbnombre5;
    public static javax.swing.JLabel lbnombre6;
    public static javax.swing.JLabel lbnombre7;
    public static javax.swing.JLabel lbnombre8;
    public static javax.swing.JLabel lbnombre9;
    public static javax.swing.JLabel lbnumerodeorden;
    private javax.swing.JLabel lbtipo;
    private javax.swing.JLabel lbtitulo2;
    private javax.swing.JLabel lbtitulo3;
    // End of variables declaration//GEN-END:variables

    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();

}
