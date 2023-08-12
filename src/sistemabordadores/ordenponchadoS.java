package sistemabordadores;
import java.applet.AudioClip;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;


public class ordenponchadoS extends javax.swing.JFrame {
public static boolean ventanaordenponchado = false;

        private PreparedStatement pst;
        
        String numerocatalogoprendas = "";
        String numerocatalogoubicacion = "";
        String numerocatalogocolores = "";
        
        
        String cantidad = "";
        String parche = "";
        String nombre = "";
        String ubicacion = "";
        String aplicacion = "";
        String observacion = "";
        String cantidadponchado ="";
        String cantidadponchadosactualizar="";
        String nombredelponchado="";
        int renglon = 0;
        
        String primero = "";
        String ultimo = "";
        String tieneunaobservacion = ""; 
        public static String enquesucursalsebordara ="";
        public static String tipotabla ="";
       
        
   
    public ordenponchadoS() {
        initComponents();
        ventanaordenponchado = true;    
        btntermine.setEnabled(false);
        lbtipo.setVisible(false);
        lbcantidad.setVisible(false);
        topes();
           
        
    }

    
     void topes() {

        String sql = "SELECT min(numero) as min_numero, max(numero) as max_numero FROM historial_ordenes_ponchados";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            rs.last();

            primero = rs.getString("min_numero");
            ultimo = rs.getString("max_numero");

        } catch (Exception e) {
           
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+e+"");

        }

    }
    
     
     
     
    void datosOrdenesLocales()
    {
        
        
        limpiar();
        String numero = lbfolio.getText();
        renglon = 0;
       
     String sql = "SELECT numero,numero_venta,tipo,fecha,cliente,nombre_comercial,borda_cliente,estatus_orden,articulo,cantidad,fecha_entrega,hora_entrega,"
             + "lugar,cantidad_ponchado,observaciones,estatus_orden FROM historial_ordenes_ponchados WHERE numero = '" + numero + "'";
     

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                lbfolio.setText(rs.getString("numero"));
                lbnumeroventa.setText(rs.getString("numero_venta"));
                lbfecha.setText(rs.getString("fecha"));
                lbcliente.setText(rs.getString("cliente"));
                lbnombrecomercial.setText(rs.getString("nombre_comercial"));
                lbbordacliente.setText(rs.getString("borda_cliente"));
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));

                nombre = rs.getString("articulo");
                cantidad = rs.getString("cantidad");
                cantidadponchado = rs.getString("cantidad_ponchado");
                
                String observacion = rs.getString("observaciones");
                
                if(observacion == null || observacion.equals("")||observacion.equals(" ") )
                {
                    
                }
                else
                {
                tieneunaobservacion="si";    
                lbobservaciones.setText(observacion);
                
                }

                
                
                renglon = renglon +1 ; 
                mostrarrenglones();
                
                String estatusorden = rs.getString("estatus_orden");
                
                if(estatusorden.equals("realizada totalmente"))
                {
                  btntermine.setEnabled(true); 
                  btntermine.setText("Cancelar");
                  btntermine.setForeground(Color.red.darker());
                  
                }
                else
                {
                   btntermine.setEnabled(true); 
                   btntermine.setText("Hecho");
                   btntermine.setForeground(Color.green.darker());
                }   
                
             
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
   
        sumapuntos();

        
    }
    
    void datos2()
    {
        
        
        limpiar();
        String numero = lbfolio.getText();
        renglon = 0;
       
     String sql = "SELECT numero,numero_sucursal,tipo,fecha,cliente,estatus_orden,articulo,cantidad,fecha_entrega,hora_entrega,"
             + "lugar,cantidad_ponchado,observaciones,estatus_orden FROM historial_ordenes_ponchados_recibidos WHERE numero = '" + numero + "'";
     

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                
                lbfolio.setText(rs.getString("numero"));
                lbnumeroventa.setText(rs.getString("numero_sucursal"));
                lbfecha.setText(rs.getString("fecha"));
                lbcliente.setText(rs.getString("cliente"));
                lbfechaentrega.setText(rs.getString("fecha_entrega"));
                lbhoraentrega.setText(rs.getString("hora_entrega"));

                nombre = rs.getString("articulo");
                cantidad = rs.getString("cantidad");
                cantidadponchado = rs.getString("cantidad_ponchado");
                
                String observacion = rs.getString("observaciones");
                
                if(observacion == null || observacion.equals("")||observacion.equals(" ") )
                {
                    
                }
                else
                {
                tieneunaobservacion="si";    
                lbobservaciones.setText(observacion);
                
                }

                
                
                renglon = renglon +1 ; 
                mostrarrenglones();
                
                String estatusorden = rs.getString("estatus_orden");
                
                if(estatusorden.equals("realizada totalmente"))
                {
                  btntermine.setEnabled(true); 
                  btntermine.setText("Cancelar");
                  btntermine.setForeground(Color.red.darker());
                  
                }
                else
                {
                   btntermine.setEnabled(true); 
                   btntermine.setText("Hecho");
                   btntermine.setForeground(Color.green.darker());
                }   
                
             
            }

        } catch (SQLException ex) {
            System.out.println(ex);
        }
   
        sumapuntos();

        
    }
    
    
    void mostrarrenglones()
    {
        
        if (renglon==1)
        {
            lbcantidad.setText(cantidad);
            lbnombre.setText(nombre);
            
            if(cantidadponchado.equals("0"))
            {
                btntermine.setEnabled(true);
            }
            else
            {
                btntermine.setEnabled(false);
            }    

            
        }
       
        
        
      
      
        
    }

   
     void limpiar()
             
     {
         
         
                lbcantidad.setText("");
                lbnombre.setText("");                
              
                lbfecha.setText("");
                lbfecha.setText("");
                lbtipo.setText("");
                lbfechaentrega.setText("");
                lbhoraentrega.setText("");

     }
    
    
 
    void actualizarlascantidadesbordadasyestatusenelhistorialdebordadoslocal(String cantidadponchadosactualizar,String nombredelponchado)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_ponchados set cantidad_ponchado='" +cantidadponchadosactualizar+ "',fecha='"+dia()+"' where numero = '"+lbfolio.getText()+"' and articulo = '"+nombredelponchado+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_ponchados set estatus_orden='realizada totalmente',fecha='"+dia()+"' where numero='" + lbfolio.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Actualizado correctamente ");

        datosOrdenesLocales();
        
        
    }
    
    void actualizarlascantidadesbordadasotrasucursal(String cantidadponchadosactualizar,String nombredelponchado)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_ponchados_recibidos set cantidad_ponchado='" +cantidadponchadosactualizar+ "',fecha='"+dia()+"' where numero = '"+lbfolio.getText()+"' and articulo = '"+nombredelponchado+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_ponchados_recibidos set estatus_orden='realizada totalmente',fecha='"+dia()+"' where numero='" + lbfolio.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Actualizado correctamente ");

        datosOrdenesLocales();
        
        
    }
    
    void actualizarlascantidadesbordadascancelar(String cantidadponchadosactualizar,String nombredelponchado)
    {
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_ponchados set cantidad_ponchado='0' where numero = '"+lbfolio.getText()+"' and articulo = '"+nombredelponchado+"'  ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE historial_ordenes_ponchados set estatus_orden='generada' where numero='" + lbfolio.getText() + "'   ");
                    pst.executeUpdate();
                    pst.close();

                } catch (Exception ex) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+ex+"");
                }
        
        
        
        String ubicacionsinguiones = ubicacion;
        ubicacionsinguiones = ubicacionsinguiones.replaceAll("_"," ");
        
        JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:green; font-size:20px;\">Actualizado correctamente ");

        datosOrdenesLocales();
        
        
    }
    
    
     
     
    void agregaralsurtidasalhistorialdeventas(String ubicacion, String cantidad) 
      {
      

        String numeroventa =  lbnumeroventa.getText();
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
        String estatusentregaventa = "";
        
        String SQL2 = "select cantidad,estatus_entrega from historial_ventas where numero = '" + numeroventa + "' and articulo = '" + ubicacion + "' ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {

        cantidadstring = rs.getString("cantidad");
        estatusentregaventa= rs.getString("estatus_entrega");

        }
        

        } catch (SQLException ex) {
            System.out.println (ex);
        }
        
        if(estatusentregaventa.equals("surtida totalmente entregada totalmente"))
        {
            
        }
        else
        {
        
      if(cantidadstring ==null || cantidadstring.equals("")||cantidadstring.equals(" "))
      {
          cantidadstring ="0";
      }
       
        
        
        int cantidadstringint = Integer.parseInt(cantidadstring.toString());
        int cantidadint =  Integer.parseInt(cantidad);

        int nuevacantidadint = cantidadint;
        nuevacantidadstring =  String.valueOf(nuevacantidadint);
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '" + nuevacantidadstring + "' WHERE numero='" + numeroventa + "' and articulo = '" + ubicacion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       

        ////Actualiza el estatus

      String cantidadsurtida = "";  
      String cantidadvendida = "";  
      String cantidadentregada = "";  
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(entregadas) as entregadas from historial_ventas where numero = '"+numeroventa+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        cantidadvendida = rs.getString("cantidad");
        cantidadsurtida = rs.getString("surtida");
        cantidadentregada = rs.getString("entregadas");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
      
      /////
      
      double cantidadvendidadouble = Double.parseDouble(cantidadvendida);
      double cantidadsurtidadouble = Double.parseDouble(cantidadsurtida);
      double cantidadentregadadouble = Double.parseDouble(cantidadentregada);
      
        
        if(cantidadvendidadouble == cantidadsurtidadouble && cantidadentregadadouble == 0 )
        {
          estatusentrega ="surtida totalmente no entregada";  
        }
        else  if(cantidadvendidadouble == (cantidadsurtidadouble + cantidadentregadadouble )  &&  cantidadentregadadouble <  cantidadvendidadouble  )
        {
          estatusentrega ="surtida totalmente entregada parcialmente";  
        }
        
        else
        {
          estatusentrega ="surtida parcialmente no entregada";   
        }    
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroventa + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      

        }
      
      
      }
    
     void agregaralsurtidasalhistorialdeventascancelar(String ubicacion, String cantidad) 
      {

        String numeroventa =  lbnumeroventa.getText();
        Object cantidadstring ="";
        String nuevacantidadstring = "";
        String estatusentrega ="";
        String estatusentregaventa = "";
        
        String SQL2 = "select cantidad,estatus_entrega from historial_ventas where numero = '" + numeroventa + "' and articulo = '" + ubicacion + "' ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL2);

        if (rs.next()) 
        {

        cantidadstring = rs.getString("cantidad");
        estatusentregaventa= rs.getString("estatus_entrega");

        }
        

        } catch (SQLException ex) {
            System.out.println (ex);
        }
        
     
        
      if(cantidadstring ==null || cantidadstring.equals("")||cantidadstring.equals(" "))
      {
          cantidadstring ="0";
      }
       
        
        
        int cantidadstringint = Integer.parseInt(cantidadstring.toString());
        int cantidadint =  Integer.parseInt(cantidad);

        int nuevacantidadint = cantidadstringint - cantidadint ;
        nuevacantidadstring =  String.valueOf(nuevacantidadint);
            
            
            
            try{
            
             PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET surtida = '"+nuevacantidadstring+"' WHERE numero='" + numeroventa + "' and articulo = '" + ubicacion + "'      ");
                                pst.executeUpdate();
                                pst.close();
                            } catch (Exception e) {

                                System.out.println(e);
                            }
       

        ////Actualiza el estatus

      String cantidadsurtida = "";  
      String cantidadvendida = "";  
      String cantidadentregada = "";  
       
      String SQL3 = "SELECT SUM(cantidad) AS cantidad,Sum(surtida) as surtida,Sum(entregadas) as entregadas from historial_ventas where numero = '"+numeroventa+"'  ";
        try {
        Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery(SQL3);

        if (rs.next()) 
        {

        cantidadvendida = rs.getString("cantidad");
        cantidadsurtida = rs.getString("surtida");
        cantidadentregada = rs.getString("entregadas");
        

        }
        

        } catch (SQLException ex) {
        System.out.println (ex);
        }
      
        
      
      /////
      
      double cantidadvendidadouble = Double.parseDouble(cantidadvendida);
      double cantidadsurtidadouble = Double.parseDouble(cantidadsurtida);
      double cantidadentregadadouble = Double.parseDouble(cantidadentregada);
      
        
        if(cantidadvendidadouble == cantidadsurtidadouble && cantidadentregadadouble == 0 )
        {
          estatusentrega ="surtida totalmente no entregada";  
        }
        else  if(cantidadvendidadouble == (cantidadsurtidadouble + cantidadentregadadouble )  &&  cantidadentregadadouble <  cantidadvendidadouble  )
        {
          estatusentrega ="surtida totalmente entregada parcialmente";  
        }
        
        else
        {
          estatusentrega ="surtida parcialmente no entregada";   
        }    
        
          try {
              PreparedStatement pst = cn.prepareStatement("UPDATE historial_ventas SET estatus_entrega = '" + estatusentrega + "' WHERE numero='" + numeroventa + "'       ");
              pst.executeUpdate();
              pst.close();
          } catch (Exception e) {

              System.out.println(e);
          }
      

        
      
      
      }  
     
     
     
    public static String dia() {
        Date fecha = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy/MM/dd");
        return formatoFecha.format(fecha);
    }

    public static String hora() {
        Date hora = new Date();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("HH:mm:ss");
        return formatoFecha.format(hora);
    } 
    
     void sumapuntos()
    {
        Object cantidadponchado = "";
        Object articulo = "";
        String articulobuscar = "";
        double costodelponchado = 0.0;
        String costostring = "";
        
        
         String sql = "Select articulo,cantidad_ponchado from historial_ordenes_ponchados where numero = '"+lbfolio.getText()+"' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                cantidadponchado=rs.getString("cantidad_ponchado");
                articulo = rs.getString("articulo");
 
                
               
            }

            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }


           
            int cantidadponchadoint  =Integer.parseInt(cantidadponchado.toString());
            

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

                

                

                String sql1 = "SELECT costo from catalogo_costos_bordado where puntadas = '" + articulobuscar + "'";

                try {
                    PreparedStatement prst = cn.prepareStatement(sql1);
                    ResultSet rs = prst.executeQuery();
                    if (rs.next()) {

                        costostring = rs.getString("costo");
                        costodelponchado = Double.parseDouble(costostring);

                    }
                } catch (Exception exx) {
                    
                    JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:red; font-size:20px;\">"+exx+"");

                }

                String costopuntadaponchadostring = String.format("%.02f ", costodelponchado);
                double importeponchado = cantidadponchadoint * costodelponchado;

                double sumabordados = importeponchado;
                String sumabordadosstring = String.format("%.02f ", sumabordados);
                lbsumapuntos.setText(sumabordadosstring);

            }
    }
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        lbfolio = new javax.swing.JLabel();
        btnsalir = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        lbfecha = new javax.swing.JLabel();
        lbfechaentrega = new javax.swing.JLabel();
        lbtipo = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        lbhoraentrega = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        lbnumeroventa = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbsumapuntos = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbcantidad = new javax.swing.JLabel();
        lbnombre = new javax.swing.JLabel();
        btntermine = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        lbbordacliente = new javax.swing.JLabel();
        lbnombrecomercial = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lbobservaciones = new javax.swing.JTextArea();
        btncancelar = new javax.swing.JButton();
        lbsucursal = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Orden ponchado");
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

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Fecha Entrega:");
        jLabel12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Número de orden");
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

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setText("Fecha de elaboración");
        jLabel17.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfecha.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfecha.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbfechaentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbfechaentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbtipo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbtipo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel30.setText("Hora Entrega:");
        jLabel30.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbhoraentrega.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbhoraentrega.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel28.setText("No. de Venta");
        jLabel28.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnumeroventa.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnumeroventa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel20.setText("Cliente:");
        jLabel20.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbsumapuntos.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbsumapuntos.setText("0.00");
        lbsumapuntos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Puntos");
        jLabel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcantidad.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcantidad.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombre.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lbnombre.setForeground(new java.awt.Color(0, 0, 153));
        lbnombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btntermine.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btntermine.setText("Termine");
        btntermine.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        btntermine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntermineActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setText("Bordacliente");
        jLabel21.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbbordacliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbbordacliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbnombrecomercial.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbnombrecomercial.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel22.setText("Nombre comercial");
        jLabel22.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Observaciones");
        jLabel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbobservaciones.setColumns(20);
        lbobservaciones.setRows(5);
        jScrollPane6.setViewportView(lbobservaciones);

        btncancelar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btncancelar.setText("Cancelar");
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        lbsucursal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbsucursal.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(btntermine, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbcliente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel30)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                                .addGap(20, 20, 20)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbbordacliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbnombrecomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbtipo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbsucursal, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfolio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbnumeroventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfecha, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbfechaentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbhoraentrega, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbnombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btntermine, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbsumapuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52))
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
       
        ventanaordenponchado = false;
        this.dispose();
        
    }//GEN-LAST:event_btnsalirActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanaordenponchado = false;
    }//GEN-LAST:event_formWindowClosing

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        
        if((enquesucursalsebordara.equals("Esta sucursal") ||enquesucursalsebordara.equals("Otra sucursal")) && tipotabla.equals("Local"))    
       {
          datosOrdenesLocales();
       }
        else
        {
            datos2();
        }     

        
        
         AudioClip sonido;
      if(tieneunaobservacion.equals("si"))
        {
            sonido= java.applet.Applet.newAudioClip(getClass().getResource("/sonidos/tienesunaobservacion.wav"));    
            sonido.play();
            
        }
      
      
      
        String observacion = lbobservaciones.getText();
        
        if (observacion.equals(""))
        {
            
        }
        else
        {
         
       
String[] lineas = observacion.split("\n");

String mensaje = "<HTML><span style=\"Color:red;font-size:25px;\">NOTA: " + lineas[0] + "</span><br>";
if (lineas.length > 1) {
    mensaje += "<span style=\"Color:red; font-size:25px;\">" + lineas[1] + "</span>";
}

JOptionPane.showMessageDialog(null, mensaje);
        
        
        
        
        }
        
        
        
        
    }//GEN-LAST:event_formWindowOpened

    private void btntermineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntermineActionPerformed


        
        if(enquesucursalsebordara.equals("Esta sucursal"))
        {
            
            cantidadponchadosactualizar = lbcantidad.getText();
          
            nombredelponchado = lbnombre.getText();
         
            
            actualizarlascantidadesbordadasyestatusenelhistorialdebordadoslocal((String) cantidadponchadosactualizar, (String) nombredelponchado);
            
           
            agregaralsurtidasalhistorialdeventas((String) nombredelponchado, (String) cantidadponchadosactualizar);
    
        }
        else
        {
            cantidadponchadosactualizar = lbcantidad.getText();
            nombredelponchado = lbnombre.getText();
            actualizarlascantidadesbordadasotrasucursal((String) cantidadponchadosactualizar, (String) nombredelponchado);
         
            //agregaralsurtidasalhistorialdeventas((String) nombredelponchado, (String) cantidadponchadosactualizar);
            
        }    
    
    
    
    sumapuntos();
    datosOrdenesLocales();
    
    if (ordenesporrealizar.ventanaordenesbordadogenerada == true)
    {
       ordenesporrealizar.btnactualizar.doClick();
    }

    
       ventanaordenponchado = false;
        this.dispose();
        
        
        
        
    }//GEN-LAST:event_btntermineActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
  
    }//GEN-LAST:event_formWindowClosed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed

      
        
         cantidadponchadosactualizar = lbcantidad.getText();
    nombredelponchado = lbnombre.getText();
    actualizarlascantidadesbordadascancelar((String) cantidadponchadosactualizar,(String)nombredelponchado);
   
    agregaralsurtidasalhistorialdeventas((String) nombredelponchado, (String) cantidadponchadosactualizar) ;
    
    
    sumapuntos();
    datosOrdenesLocales();
    
    if (ordenesporrealizar.ventanaordenesbordadogenerada == true)
    {
       ordenesporrealizar.btnactualizar.doClick();
    }

    
       ventanaordenponchado = false;
        this.dispose();
        
        

    }//GEN-LAST:event_btncancelarActionPerformed

    
    ResultSet rs;
    ResultSet rs2;
    
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ordenponchadoS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    public static javax.swing.JButton btnsalir;
    private javax.swing.JButton btntermine;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane6;
    public static javax.swing.JLabel lbbordacliente;
    private javax.swing.JLabel lbcantidad;
    public static javax.swing.JLabel lbcliente;
    private javax.swing.JLabel lbfecha;
    private javax.swing.JLabel lbfechaentrega;
    public static javax.swing.JLabel lbfolio;
    private javax.swing.JLabel lbhoraentrega;
    private javax.swing.JLabel lbnombre;
    public static javax.swing.JLabel lbnombrecomercial;
    public static javax.swing.JLabel lbnumeroventa;
    public static javax.swing.JTextArea lbobservaciones;
    public static javax.swing.JLabel lbsucursal;
    public javax.swing.JLabel lbsumapuntos;
    private javax.swing.JLabel lbtipo;
    // End of variables declaration//GEN-END:variables

 coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();


}
