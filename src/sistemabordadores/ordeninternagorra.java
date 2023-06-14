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

    String s1 = "GORRA ";
    String s2 = " CON BORDADO ";

    int renglon = 0;

    String primero = "";
    String ultimo = "";
    int posicion = 0;
    int primernumero = 0;
    int posiciondelarreglo = 0;

    ArrayList<String> listagorras = new ArrayList<String>();

    public ordeninternagorra() {
        initComponents();
        ventanaordeninternagorraanterior = true;
        btncancelarbordado.setVisible(false);
        

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
        
        lbcantidadrecibidas1.setText("");
        lbcantidadrecibidas2.setText("");        
        lbcantidadrecibidas3.setText("");
        lbcantidadrecibidas4.setText("");        
        lbcantidadrecibidas5.setText("");
        lbcantidadrecibidas6.setText("");
        lbcantidadrecibidas7.setText("");
        lbcantidadrecibidas8.setText("");
        lbcantidadrecibidas9.setText("");        
        lbcantidadrecibidas10.setText("");    
        
        lbcantidadremanente1.setText("");
        lbcantidadremanente2.setText("");
        lbcantidadremanente3.setText("");
        lbcantidadremanente4.setText("");
        lbcantidadremanente5.setText("");
        lbcantidadremanente6.setText("");
        lbcantidadremanente7.setText("");
        lbcantidadremanente8.setText("");
        lbcantidadremanente9.setText("");
        lbcantidadremanente10.setText("");
        
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
        
        lbobservacion1.setText("");
        lbobservacion2.setText("");
        lbobservacion3.setText("");
        lbobservacion4.setText("");
        lbobservacion5.setText("");
        lbobservacion6.setText("");
        lbobservacion7.setText("");
        lbobservacion8.setText("");
        lbobservacion9.setText("");
        lbobservacion10.setText("");
        
        btnprocesar1.setVisible(true);
        btncancelar.setVisible(false);
        
                
    }

    void datos() {

        String sql = "";
        String numero = lbfolio.getText();
        renglon = 0;

        limpiarlostextfield();
        
        
        

            sql = "SELECT numero,fecha,hora,tipo,cantidad,cantidad_entregada,cantidad_remanente,color,descripcion,estatus_entrega,fecha_entrega FROM historial_ordenes_bordados_interno WHERE numero = '" + numero + "'";

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                    lbfolio.setText(rs.getString("numero"));
                    lbfecha.setText(rs.getString("fecha"));
                    lbhora.setText(rs.getString("hora"));
                    cantidad = rs.getString("cantidad");
                    cantidadentregada = rs.getString("cantidad_entregada");
                    if(cantidadentregada==null||cantidadentregada.equals(""))
                    {
                        cantidadentregada = "0";
                    }
                    cantidadremanente = rs.getString("cantidad_remanente");
                    if(cantidadremanente==null||cantidadremanente.equals(""))
                    {
                        cantidadremanente = "0";
                    }
                    color = rs.getString("color");
                    descripcion = rs.getString("descripcion");             
                    nombrecompleto = s1 + color + s2 + descripcion;

                    renglon = renglon + 1;
                    mostrarrenglonesgorra();
                    habilitarbotonprocesar();

                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }

         

    }
    
    void habilitarbotonprocesar()
    {
        
        String numero = lbfolio.getText();
        String sql = "SELECT distinct estatus_entrega FROM historial_ordenes_bordados_interno WHERE numero = '" + numero + "' ORDER BY estatus_entrega " ;

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {

                  String  estatusentrega = rs.getString("estatus_entrega");
                  
                  if (estatusentrega.equals("cancelada") || estatusentrega.equals("entregada")) {

                        btncancelar.setEnabled(false);
                        btnprocesar1.setEnabled(false);
                        lbestatusentrega.setText(estatusentrega);

                    } else {
                        btncancelar.setEnabled(true);
                        btnprocesar1.setEnabled(true);
                        lbestatusentrega.setText(estatusentrega);
                    }
                   
                    

                }

            } catch (SQLException ex) {
                System.out.println(ex);
            }

        
    }

    void mostrarrenglonesgorra() {

        if (renglon == 1) {
            lbcantidad1.setText(cantidad);
            lbcantidadrecibidas1.setText(cantidadentregada);
            lbcantidadremanente1.setText(cantidadremanente);
            lbcolor1.setText(color);
            lbnombre1.setText(descripcion);
            lbobservacion1.setText(nombrecompleto);

        } else if (renglon == 2) {
            lbcantidad2.setText(cantidad);
            lbcantidadrecibidas2.setText(cantidadentregada);
            lbcantidadremanente2.setText(cantidadremanente);
            lbcolor2.setText(color);
            lbnombre2.setText(descripcion);
            lbobservacion2.setText(nombrecompleto);

        } else if (renglon == 3) {
            lbcantidad3.setText(cantidad);
            lbcantidadrecibidas3.setText(cantidadentregada);
            lbcantidadremanente3.setText(cantidadremanente);
            lbcolor3.setText(color);
            lbnombre3.setText(descripcion);
            lbobservacion3.setText(nombrecompleto);

        } else if (renglon == 4) {
            lbcantidad4.setText(cantidad);
            lbcantidadrecibidas4.setText(cantidadentregada);
            lbcantidadremanente4.setText(cantidadremanente);
            lbcolor4.setText(color);
            lbnombre4.setText(descripcion);
            lbobservacion4.setText(nombrecompleto);

        } else if (renglon == 5) {
            lbcantidad5.setText(cantidad);
            lbcantidadrecibidas5.setText(cantidadentregada);
            lbcantidadremanente5.setText(cantidadremanente);
            lbcolor5.setText(color);
            lbnombre5.setText(descripcion);
            lbobservacion5.setText(nombrecompleto);

        } else if (renglon == 6) {
            lbcantidad6.setText(cantidad);
            lbcantidadrecibidas6.setText(cantidadentregada);
            lbcantidadremanente6.setText(cantidadremanente);
            lbcolor6.setText(color);
            lbnombre6.setText(descripcion);
            lbobservacion6.setText(nombrecompleto);

        } else if (renglon == 7) {
            lbcantidad7.setText(cantidad);
            lbcantidadrecibidas7.setText(cantidadentregada);
            lbcantidadremanente7.setText(cantidadremanente);
            lbcolor7.setText(color);
            lbnombre7.setText(descripcion);
            lbobservacion7.setText(nombrecompleto);

        } else if (renglon == 8) {
            lbcantidad8.setText(cantidad);
            lbcantidadrecibidas8.setText(cantidadentregada);
            lbcantidadremanente8.setText(cantidadremanente);
            lbcolor8.setText(color);
            lbnombre8.setText(descripcion);
            lbobservacion8.setText(nombrecompleto);

        } else if (renglon == 9) {
            lbcantidad9.setText(cantidad);
            lbcantidadrecibidas9.setText(cantidadentregada);
            lbcantidadremanente9.setText(cantidadremanente);
            lbcolor9.setText(color);
            lbnombre9.setText(descripcion);
            lbobservacion9.setText(nombrecompleto);

        } else {
            if (renglon == 10) {
                lbcantidad10.setText(cantidad);
                lbcantidadrecibidas10.setText(cantidadentregada);
                lbcantidadremanente10.setText(cantidadremanente);
                lbcolor10.setText(color);
                lbnombre10.setText(descripcion);
                lbobservacion10.setText(nombrecompleto);

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

    void modificarexistenciaykardexgorras(String nombre, String cantidad) {

        String numero = lbfolio.getText();
        String cantidadactual = "0";
        String nuevaexistencia = "";
        String codigoarticulo = "";

        String sql = "SELECT existencia FROM catalogo_articulos WHERE  descripcion='" + nombre + "'";

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

    void modificarexistenciaykardexgorrascancelada(String nombre, String cantidad) {

        String numero = lbfolio.getText();
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
        lbfolio = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        lbtipo = new javax.swing.JLabel();
        lbarticulo = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbhora = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbestatusentrega = new javax.swing.JLabel();
        btnprocesar1 = new javax.swing.JButton();
        btncancelarbordado = new javax.swing.JButton();
        lbcantidad10 = new javax.swing.JLabel();
        lbcantidad9 = new javax.swing.JLabel();
        lbcantidad8 = new javax.swing.JLabel();
        lbcantidadrecibidas8 = new javax.swing.JLabel();
        lbcantidadrecibidas9 = new javax.swing.JLabel();
        lbcantidadrecibidas10 = new javax.swing.JLabel();
        lbcantidadremanente10 = new javax.swing.JLabel();
        lbcantidadremanente9 = new javax.swing.JLabel();
        lbcantidadremanente8 = new javax.swing.JLabel();
        lbcolor8 = new javax.swing.JLabel();
        lbcolor9 = new javax.swing.JLabel();
        lbcolor10 = new javax.swing.JLabel();
        lbnombre10 = new javax.swing.JLabel();
        lbnombre9 = new javax.swing.JLabel();
        lbnombre8 = new javax.swing.JLabel();
        lbobservacion10 = new javax.swing.JLabel();
        lbobservacion9 = new javax.swing.JLabel();
        lbobservacion8 = new javax.swing.JLabel();
        lbcantidad7 = new javax.swing.JLabel();
        lbcantidad6 = new javax.swing.JLabel();
        lbcantidad5 = new javax.swing.JLabel();
        lbcantidadrecibidas5 = new javax.swing.JLabel();
        lbcantidadrecibidas6 = new javax.swing.JLabel();
        lbcantidadrecibidas7 = new javax.swing.JLabel();
        lbcantidadremanente5 = new javax.swing.JLabel();
        lbcantidadremanente6 = new javax.swing.JLabel();
        lbcantidadremanente7 = new javax.swing.JLabel();
        lbcolor7 = new javax.swing.JLabel();
        lbcolor5 = new javax.swing.JLabel();
        lbcolor6 = new javax.swing.JLabel();
        lbnombre7 = new javax.swing.JLabel();
        lbnombre6 = new javax.swing.JLabel();
        lbnombre5 = new javax.swing.JLabel();
        lbobservacion5 = new javax.swing.JLabel();
        lbobservacion6 = new javax.swing.JLabel();
        lbobservacion7 = new javax.swing.JLabel();
        lbcantidad1 = new javax.swing.JLabel();
        lbcantidad2 = new javax.swing.JLabel();
        lbcantidad3 = new javax.swing.JLabel();
        lbcantidad4 = new javax.swing.JLabel();
        lbcantidadrecibidas4 = new javax.swing.JLabel();
        lbcantidadrecibidas3 = new javax.swing.JLabel();
        lbcantidadrecibidas2 = new javax.swing.JLabel();
        lbcantidadrecibidas1 = new javax.swing.JLabel();
        lbcantidadremanente4 = new javax.swing.JLabel();
        lbcantidadremanente3 = new javax.swing.JLabel();
        lbcantidadremanente2 = new javax.swing.JLabel();
        lbcantidadremanente1 = new javax.swing.JLabel();
        lbcolor4 = new javax.swing.JLabel();
        lbcolor3 = new javax.swing.JLabel();
        lbcolor2 = new javax.swing.JLabel();
        lbcolor1 = new javax.swing.JLabel();
        lbnombre1 = new javax.swing.JLabel();
        lbnombre2 = new javax.swing.JLabel();
        lbnombre3 = new javax.swing.JLabel();
        lbnombre4 = new javax.swing.JLabel();
        lbobservacion4 = new javax.swing.JLabel();
        lbobservacion3 = new javax.swing.JLabel();
        lbobservacion2 = new javax.swing.JLabel();
        lbobservacion1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbtitulo2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbtitulo3 = new javax.swing.JLabel();

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

        lbfolio.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfolio.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        lbtipo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbtipo.setForeground(new java.awt.Color(204, 0, 0));

        lbarticulo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lbarticulo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnprocesar1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnprocesar1.setText("Recibir");
        btnprocesar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnprocesar1ActionPerformed(evt);
            }
        });

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

        lbcantidadrecibidas8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadrecibidas8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibidas8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibidas9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadrecibidas9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibidas9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibidas10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadrecibidas10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibidas10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadremanente10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadremanente9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadremanente8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidad5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidad5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidad5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibidas5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadrecibidas5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibidas5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibidas6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadrecibidas6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibidas6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibidas7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadrecibidas7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibidas7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadremanente5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadremanente6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadremanente7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

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

        lbcantidadrecibidas4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadrecibidas4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibidas4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibidas3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadrecibidas3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibidas3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibidas2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadrecibidas2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibidas2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadrecibidas1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadrecibidas1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadrecibidas1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadremanente4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadremanente3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadremanente2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcantidadremanente1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbcantidadremanente1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbcantidadremanente1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbcolor1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbnombre4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lbobservacion1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Cantidad Pedida");
        jLabel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Remanente");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Recibidas");
        jLabel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8)
                .addGap(29, 29, 29)
                .addComponent(lbestatusentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelarbordado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(6, 6, 6)
                .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(184, 184, 184)
                .addComponent(btnprocesar1)
                .addGap(133, 133, 133))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcantidadrecibidas1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidadrecibidas2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidadrecibidas3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidadrecibidas4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbcantidad8, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(lbcantidad9, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(lbcantidad10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcantidadrecibidas8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidadrecibidas9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidadrecibidas10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcantidadrecibidas5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidadrecibidas6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidadrecibidas7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbtitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbtitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbobservacion3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbobservacion2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbobservacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbobservacion4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(lbobservacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbcantidadremanente1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcantidadremanente2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbcantidadremanente3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbcantidadremanente8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidadremanente9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcantidadremanente10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcantidadremanente5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcantidadremanente6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcantidadremanente7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbcantidadremanente4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcolor8, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor9, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor10, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lbnombre3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbnombre2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbnombre10, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbnombre9, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbnombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(33, 33, 33)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbobservacion10, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbobservacion9, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbobservacion8, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lbnombre4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbnombre7, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(lbnombre6, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                            .addComponent(lbnombre5, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                                        .addGap(30, 30, 30)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbobservacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lbobservacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1014, 1014, 1014)
                        .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbtitulo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(lbcantidadrecibidas1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbcantidadrecibidas2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(lbcantidadrecibidas3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(13, 13, 13)
                                .addComponent(lbcantidadrecibidas4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(lbcantidad1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbcantidad2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(lbcantidad3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(lbcantidad4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbcantidad5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lbcantidadrecibidas5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(lbcantidadrecibidas6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lbcantidadrecibidas7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcantidad6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcantidad8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidad10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbcantidadrecibidas8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidadrecibidas9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbcantidadrecibidas10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lbobservacion1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbobservacion2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbobservacion3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lbnombre3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbnombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(lbcantidadremanente1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbnombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(9, 9, 9)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbcantidadremanente2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(13, 13, 13)
                                                .addComponent(lbcantidadremanente3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lbcantidadremanente4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(11, 11, 11)
                                        .addComponent(lbcantidadremanente5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbcantidadremanente6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbcantidadremanente7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbcantidadremanente8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbcantidadremanente9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbcantidadremanente10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbobservacion4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbnombre4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbnombre5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(lbobservacion5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lbobservacion6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbobservacion7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lbnombre6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbnombre7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lbobservacion8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbobservacion9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbobservacion10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addComponent(lbnombre8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbnombre9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(lbnombre10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                                                .addComponent(lbcolor10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGap(0, 0, Short.MAX_VALUE)))))))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbhora, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbarticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbestatusentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btncancelarbordado, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnprocesar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(63, Short.MAX_VALUE))
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
        String numero = lbfolio.getText();
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

        btncancelar.setEnabled(false);
    }
    
     
    private void btnprocesar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnprocesar1ActionPerformed
     
        /*
        
        ordeninternagorrarecibir entregar = new ordeninternagorrarecibir();
        entregar.setVisible(true);

        ordeninternagorrarecibir.lbfolio.setText(lbfolio.getText());

        int gorra1 = lbobservacion1.getText().length();
        if (gorra1 > 0) {

            String cantidadgorra1 = lbcantidad1.getText();
            String cantidadgorra11 = lbcantidadrecibidas1.getText();

            int ccantidadgorra1int = Integer.parseInt(cantidadgorra1);
            int ccantidadgorra11int = Integer.parseInt(cantidadgorra11);

            int cantidadremantenteint = ccantidadgorra1int - ccantidadgorra11int;
            String cantidadremanentestring = String.valueOf(cantidadremantenteint);

            ordeninternagorrarecibir.txtgorra1.setText(lbobservacion1.getText());
            ordeninternagorrarecibir.txtgorra1cantidad.setText(cantidadremanentestring);
            ordeninternagorrarecibir.lbdescripcion1.setText(lbnombre1.getText());
            ordeninternagorrarecibir.lbcolor1.setText(lbcolor1.getText());
            ordeninternagorrarecibir.txtgorra1.setEditable(false);

        } else {

            ordeninternagorrarecibir.txtgorra1.setEnabled(false);
            ordeninternagorrarecibir.txtgorra1cantidad.setEnabled(false);
        }

        ///gorra2
        int gorra2 = lbobservacion2.getText().length();
        if (gorra2 > 0) {

            String cantidadgorra2 = lbcantidad2.getText();
            String cantidadgorra21 = lbcantidadrecibidas2.getText();

            int ccantidadgorra2int = Integer.parseInt(cantidadgorra2);
            int ccantidadgorra21int = Integer.parseInt(cantidadgorra21);

            int cantidadremantente2int = ccantidadgorra2int - ccantidadgorra21int;
            String cantidadremanente2string = String.valueOf(cantidadremantente2int);

            ordeninternagorrarecibir.txtgorra2.setText(lbobservacion2.getText());
            ordeninternagorrarecibir.txtgorra2cantidad.setText(cantidadremanente2string);
            ordeninternagorrarecibir.lbdescripcion2.setText(lbnombre2.getText());
            ordeninternagorrarecibir.lbcolor2.setText(lbcolor2.getText());
            ordeninternagorrarecibir.txtgorra2.setEditable(false);
        } else {
            ordeninternagorrarecibir.txtgorra2.setEnabled(false);
            ordeninternagorrarecibir.txtgorra2cantidad.setEnabled(false);

        }

        ///gorra 3
        int gorra3 = lbobservacion3.getText().length();
        if (gorra3 > 0) {

            String cantidadgorra3 = lbcantidad3.getText();
            String cantidadgorra31 = lbcantidadrecibidas3.getText();

            int ccantidadgorra3int = Integer.parseInt(cantidadgorra3);
            int ccantidadgorra31int = Integer.parseInt(cantidadgorra31);

            int cantidadremantente3int = ccantidadgorra3int - ccantidadgorra31int;
            String cantidadremanente3string = String.valueOf(cantidadremantente3int);

            ordeninternagorrarecibir.txtgorra3.setText(lbobservacion3.getText());
            ordeninternagorrarecibir.txtgorra3cantidad.setText(cantidadremanente3string);
            ordeninternagorrarecibir.lbdescripcion3.setText(lbnombre3.getText());
            ordeninternagorrarecibir.lbcolor3.setText(lbcolor3.getText());
            ordeninternagorrarecibir.txtgorra3.setEditable(false);
        } else {
            ordeninternagorrarecibir.txtgorra3.setEnabled(false);
            ordeninternagorrarecibir.txtgorra3cantidad.setEnabled(false);
        }

        /// gorra 4
        int gorra4 = lbobservacion4.getText().length();
        if (gorra4 > 0) {

            String cantidadgorra4 = lbcantidad4.getText();
            String cantidadgorra41 = lbcantidadrecibidas4.getText();

            int ccantidadgorra4int = Integer.parseInt(cantidadgorra4);
            int ccantidadgorra41int = Integer.parseInt(cantidadgorra41);

            int cantidadremantente4int = ccantidadgorra4int - ccantidadgorra41int;
            String cantidadremanente4string = String.valueOf(cantidadremantente4int);

            ordeninternagorrarecibir.txtgorra4.setText(lbobservacion4.getText());
            ordeninternagorrarecibir.txtgorra4cantidad.setText(cantidadremanente4string);
            ordeninternagorrarecibir.lbdescripcion4.setText(lbnombre4.getText());
            ordeninternagorrarecibir.lbcolor4.setText(lbcolor4.getText());
            ordeninternagorrarecibir.txtgorra4.setEditable(false);
        } else {
            ordeninternagorrarecibir.txtgorra4.setEnabled(false);
            ordeninternagorrarecibir.txtgorra4cantidad.setEnabled(false);
        }

        ///gorra5
        int gorra5 = lbobservacion5.getText().length();
        if (gorra5 > 0) {

            String cantidadgorra5 = lbcantidad5.getText();
            String cantidadgorra51 = lbcantidadrecibidas5.getText();

            int ccantidadgorra5int = Integer.parseInt(cantidadgorra5);
            int ccantidadgorra51int = Integer.parseInt(cantidadgorra51);

            int cantidadremantente5int = ccantidadgorra5int - ccantidadgorra51int;
            String cantidadremanente5string = String.valueOf(cantidadremantente5int);

            ordeninternagorrarecibir.txtgorra5.setText(lbobservacion5.getText());
            ordeninternagorrarecibir.txtgorra5cantidad.setText(cantidadremanente5string);
            ordeninternagorrarecibir.lbdescripcion5.setText(lbnombre5.getText());
            ordeninternagorrarecibir.lbcolor5.setText(lbcolor5.getText());
            ordeninternagorrarecibir.txtgorra5.setEditable(false);
        } else {
            ordeninternagorrarecibir.txtgorra5.setEnabled(false);
            ordeninternagorrarecibir.txtgorra5cantidad.setEnabled(false);
        }

        int gorra6 = lbobservacion6.getText().length();
        if (gorra6 > 0) {

            String cantidadgorra6 = lbcantidad6.getText();
            String cantidadgorra61 = lbcantidadrecibidas6.getText();

            int ccantidadgorra6int = Integer.parseInt(cantidadgorra6);
            int ccantidadgorra61int = Integer.parseInt(cantidadgorra61);

            int cantidadremantente6int = ccantidadgorra6int - ccantidadgorra61int;
            String cantidadremanente6string = String.valueOf(cantidadremantente6int);

            ordeninternagorrarecibir.txtgorra6.setText(lbobservacion6.getText());
            ordeninternagorrarecibir.txtgorra6cantidad.setText(cantidadremanente6string);
            ordeninternagorrarecibir.lbdescripcion6.setText(lbnombre6.getText());
            ordeninternagorrarecibir.lbcolor6.setText(lbcolor6.getText());
            ordeninternagorrarecibir.txtgorra6.setEditable(false);
        } else {
            ordeninternagorrarecibir.txtgorra6.setEnabled(false);
            ordeninternagorrarecibir.txtgorra6cantidad.setEnabled(false);
        }

        int gorra7 = lbobservacion7.getText().length();
        if (gorra7 > 0) {

            String cantidadgorra7 = lbcantidad7.getText();
            String cantidadgorra71 = lbcantidadrecibidas7.getText();

            int ccantidadgorra7int = Integer.parseInt(cantidadgorra7);
            int ccantidadgorra71int = Integer.parseInt(cantidadgorra71);

            int cantidadremantente7int = ccantidadgorra7int - ccantidadgorra71int;
            String cantidadremanente7string = String.valueOf(cantidadremantente7int);

            ordeninternagorrarecibir.txtgorra7.setText(lbobservacion7.getText());
            ordeninternagorrarecibir.txtgorra7cantidad.setText(cantidadremanente7string);
            ordeninternagorrarecibir.lbdescripcion7.setText(lbnombre7.getText());
            ordeninternagorrarecibir.lbcolor7.setText(lbcolor7.getText());
            ordeninternagorrarecibir.txtgorra7.setEditable(false);
        } else {
            ordeninternagorrarecibir.txtgorra7.setEnabled(false);
            ordeninternagorrarecibir.txtgorra7cantidad.setEnabled(false);
        }

        int gorra8 = lbobservacion8.getText().length();
        if (gorra8 > 0) {

            String cantidadgorra8 = lbcantidad8.getText();
            String cantidadgorra81 = lbcantidadrecibidas8.getText();

            int ccantidadgorra8int = Integer.parseInt(cantidadgorra8);
            int ccantidadgorra81int = Integer.parseInt(cantidadgorra81);

            int cantidadremantente8int = ccantidadgorra8int - ccantidadgorra81int;
            String cantidadremanente8string = String.valueOf(cantidadremantente8int);

            ordeninternagorrarecibir.txtgorra8.setText(lbobservacion7.getText());
            ordeninternagorrarecibir.txtgorra8cantidad.setText(cantidadremanente8string);
            ordeninternagorrarecibir.lbdescripcion8.setText(lbnombre8.getText());
            ordeninternagorrarecibir.lbcolor8.setText(lbcolor8.getText());
            ordeninternagorrarecibir.txtgorra8.setEditable(false);
        } else {
            ordeninternagorrarecibir.txtgorra8.setEnabled(false);
            ordeninternagorrarecibir.txtgorra8cantidad.setEnabled(false);
        }

        int gorra9 = lbobservacion9.getText().length();
        if (gorra9 > 0) {

            String cantidadgorra9 = lbcantidad9.getText();
            String cantidadgorra91 = lbcantidadrecibidas9.getText();

            int ccantidadgorra9int = Integer.parseInt(cantidadgorra9);
            int ccantidadgorra91int = Integer.parseInt(cantidadgorra91);

            int cantidadremantente9int = ccantidadgorra9int - ccantidadgorra91int;
            String cantidadremanente9string = String.valueOf(cantidadremantente9int);

            ordeninternagorrarecibir.txtgorra9.setText(lbobservacion9.getText());
            ordeninternagorrarecibir.txtgorra9cantidad.setText(cantidadremanente9string);
            ordeninternagorrarecibir.lbdescripcion9.setText(lbnombre9.getText());
            ordeninternagorrarecibir.lbcolor9.setText(lbcolor9.getText());
            ordeninternagorrarecibir.txtgorra9.setEditable(false);
        } else {
            ordeninternagorrarecibir.txtgorra9.setEnabled(false);
            ordeninternagorrarecibir.txtgorra9cantidad.setEnabled(false);
        }

        int gorra10 = lbobservacion10.getText().length();
        if (gorra10 > 0) {

            String cantidadgorra10 = lbcantidad10.getText();
            String cantidadgorra101 = lbcantidadrecibidas10.getText();

            int ccantidadgorra10int = Integer.parseInt(cantidadgorra10);
            int ccantidadgorra101int = Integer.parseInt(cantidadgorra101);

            int cantidadremantente10int = ccantidadgorra10int - ccantidadgorra101int;
            String cantidadremanente10string = String.valueOf(cantidadremantente10int);

            ordeninternagorrarecibir.txtgorra10.setText(lbobservacion10.getText());
            ordeninternagorrarecibir.txtgorra10cantidad.setText(cantidadremanente10string);
            ordeninternagorrarecibir.lbdescripcion10.setText(lbnombre10.getText());
            ordeninternagorrarecibir.lbcolor10.setText(lbcolor10.getText());
            ordeninternagorrarecibir.txtgorra10.setEditable(false);
        } else {
            ordeninternagorrarecibir.txtgorra10.setEnabled(false);
            ordeninternagorrarecibir.txtgorra10cantidad.setEnabled(false);
        }


     */
    }//GEN-LAST:event_btnprocesar1ActionPerformed

    

    private void btncancelarbordadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarbordadoActionPerformed
      cancelarbordado();
    }//GEN-LAST:event_btncancelarbordadoActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
      datos();
    }//GEN-LAST:event_formWindowOpened

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed

        if (autorizacion.ventanaautorizacion == true)
        {
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Favor de cerrar la ventana de autorizaci�n");
        }
        else
        {
            autorizacion ventana = new autorizacion();
            ventana.setVisible(true);
            ventana.setLocationRelativeTo(null);

            autorizacion.lbinterfaz.setText("ordenanteriorbordadointernogorra");
            autorizacion.lbnivel.setText("1");

        }

    }//GEN-LAST:event_btncancelarActionPerformed

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
    private javax.swing.JButton btncancelar;
    public static javax.swing.JButton btncancelarbordado;
    private javax.swing.JButton btnprocesar1;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbarticulo;
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
    public static javax.swing.JLabel lbcantidadrecibidas1;
    public static javax.swing.JLabel lbcantidadrecibidas10;
    public static javax.swing.JLabel lbcantidadrecibidas2;
    public static javax.swing.JLabel lbcantidadrecibidas3;
    public static javax.swing.JLabel lbcantidadrecibidas4;
    public static javax.swing.JLabel lbcantidadrecibidas5;
    public static javax.swing.JLabel lbcantidadrecibidas6;
    public static javax.swing.JLabel lbcantidadrecibidas7;
    public static javax.swing.JLabel lbcantidadrecibidas8;
    public static javax.swing.JLabel lbcantidadrecibidas9;
    public static javax.swing.JLabel lbcantidadremanente1;
    public static javax.swing.JLabel lbcantidadremanente10;
    public static javax.swing.JLabel lbcantidadremanente2;
    public static javax.swing.JLabel lbcantidadremanente3;
    public static javax.swing.JLabel lbcantidadremanente4;
    public static javax.swing.JLabel lbcantidadremanente5;
    public static javax.swing.JLabel lbcantidadremanente6;
    public static javax.swing.JLabel lbcantidadremanente7;
    public static javax.swing.JLabel lbcantidadremanente8;
    public static javax.swing.JLabel lbcantidadremanente9;
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
    public static javax.swing.JLabel lbfolio;
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
    public static javax.swing.JLabel lbobservacion1;
    public static javax.swing.JLabel lbobservacion10;
    public static javax.swing.JLabel lbobservacion2;
    public static javax.swing.JLabel lbobservacion3;
    public static javax.swing.JLabel lbobservacion4;
    public static javax.swing.JLabel lbobservacion5;
    public static javax.swing.JLabel lbobservacion6;
    public static javax.swing.JLabel lbobservacion7;
    public static javax.swing.JLabel lbobservacion8;
    public static javax.swing.JLabel lbobservacion9;
    private javax.swing.JLabel lbtipo;
    private javax.swing.JLabel lbtitulo2;
    private javax.swing.JLabel lbtitulo3;
    // End of variables declaration//GEN-END:variables

    connectar cc = new connectar();
    Connection cn = cc.conexion();

}
