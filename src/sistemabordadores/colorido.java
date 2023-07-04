
package sistemabordadores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;




public class colorido extends javax.swing.JFrame {

    
    public static boolean ventanacolorido = false;
    
    String hilo1seleccionado = "";
    String hilo2seleccionado = "";
    String hilo3seleccionado = "";
    String hilo4seleccionado = "";
    String hilo5seleccionado = "";
    String hilo6seleccionado = "";
    String hilo7seleccionado = "";
    String hilo8seleccionado = "";
    String hilo9seleccionado = "";
    String hilo10seleccionado = "";
    String hilo11seleccionado = "";
    String hilo12seleccionado = "";
    String hilo13seleccionado = "";
    String hilo14seleccionado = "";
    String hilo15seleccionado = "";
    
    String color1seleccionado = "";
    String color2seleccionado = "";
    String color3seleccionado = "";
    String color4seleccionado = "";
    String color5seleccionado = "";
    String color6seleccionado = "";
    String color7seleccionado = "";
    String color8seleccionado = "";
    String color9seleccionado = "";
    String color10seleccionado = "";
    String color11seleccionado = "";
    String color12seleccionado = "";
    String color13seleccionado = "";
    String color14seleccionado = "";
    String color15seleccionado = "";
    
    
    String actualizarbordado ="no";
    
    String nombrebordado = "";
    
    
     ArrayList<String> listahilos = new ArrayList<String>();
    
    
    public colorido() 
    {
        initComponents();
        ventanacolorido = true;
       
        combohilo();
        
    }
    
     void combohilo() 
    {

        
        String color = "";
        String hilo = "";
        String hiloconcolor = "";
        
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo1 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo2 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo3 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo4 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo5 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo6 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo7 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo8 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo9 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo10 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo11 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo12 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo13 = new DefaultComboBoxModel();
        DefaultComboBoxModel modelo14 = new DefaultComboBoxModel();
        
        
        try {
           

            String sql = "SELECT distinct hilo,color  FROM catalogo_materiales where descripcion like 'HILO CODIGO%'ORDER BY hilo";

            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {

                modelo.addElement(rs.getObject("hilo"));
                modelo1.addElement(rs.getObject("hilo"));
                modelo2.addElement(rs.getObject("hilo"));
                modelo3.addElement(rs.getObject("hilo"));
                modelo4.addElement(rs.getObject("hilo"));
                modelo5.addElement(rs.getObject("hilo"));
                modelo6.addElement(rs.getObject("hilo"));
                modelo7.addElement(rs.getObject("hilo"));
                modelo8.addElement(rs.getObject("hilo"));
                modelo9.addElement(rs.getObject("hilo"));
                modelo10.addElement(rs.getObject("hilo"));
                modelo11.addElement(rs.getObject("hilo"));
                modelo12.addElement(rs.getObject("hilo"));
                modelo13.addElement(rs.getObject("hilo"));
                modelo14.addElement(rs.getObject("hilo"));
                
                
                
                hilo = rs.getString("hilo");
                color  = rs.getString("color");
                hiloconcolor = hilo.concat(color);
                
                listahilos.add(hiloconcolor);
                
                
                

            }
            
            
          

            cbhilo1.setModel(modelo);
            AutoCompleteDecorator.decorate(cbhilo1);
            cbhilo1.addItem("0");
            cbhilo1.setSelectedItem("0");

            cbhilo2.setModel(modelo1);
            AutoCompleteDecorator.decorate(cbhilo2);
            cbhilo2.addItem("0");
            cbhilo2.setSelectedItem("0");
            
            cbhilo3.setModel(modelo2);
            AutoCompleteDecorator.decorate(cbhilo3);
            cbhilo3.addItem("0");
            cbhilo3.setSelectedItem("0");

            cbhilo4.setModel(modelo3);
            AutoCompleteDecorator.decorate(cbhilo4);
            cbhilo4.addItem("0");
            cbhilo4.setSelectedItem("0");
  

            cbhilo5.setModel(modelo4);
            AutoCompleteDecorator.decorate(cbhilo5);
            cbhilo5.addItem("0");
            cbhilo5.setSelectedItem("0");

            cbhilo6.setModel(modelo5);
            AutoCompleteDecorator.decorate(cbhilo6);
            cbhilo6.addItem("0");
            cbhilo6.setSelectedItem("0");

            cbhilo7.setModel(modelo6);
            AutoCompleteDecorator.decorate(cbhilo7);
            cbhilo7.addItem("0");
            cbhilo7.setSelectedItem("0");
            
             cbhilo8.setModel(modelo7);
            AutoCompleteDecorator.decorate(cbhilo8);
            cbhilo8.addItem("0");
            cbhilo8.setSelectedItem("0");
            
             cbhilo9.setModel(modelo8);
            AutoCompleteDecorator.decorate(cbhilo9);
            cbhilo9.addItem("0");
            cbhilo9.setSelectedItem("0");
            
             cbhilo10.setModel(modelo9);
            AutoCompleteDecorator.decorate(cbhilo10);
            cbhilo10.addItem("0");
            cbhilo10.setSelectedItem("0");
            
             cbhilo11.setModel(modelo10);
            AutoCompleteDecorator.decorate(cbhilo11);
            cbhilo11.addItem("0");
            cbhilo11.setSelectedItem("0");
            
             cbhilo12.setModel(modelo11);
            AutoCompleteDecorator.decorate(cbhilo12);
            cbhilo12.addItem("0");
            cbhilo12.setSelectedItem("0");
            
             cbhilo13.setModel(modelo12);
            AutoCompleteDecorator.decorate(cbhilo13);
            cbhilo13.addItem("0");
            cbhilo13.setSelectedItem("0");
            
             cbhilo14.setModel(modelo13);
            AutoCompleteDecorator.decorate(cbhilo14);
            cbhilo14.addItem("0");
            cbhilo14.setSelectedItem("0");
            
             cbhilo15.setModel(modelo14);
            AutoCompleteDecorator.decorate(cbhilo15);
            cbhilo15.addItem("0");
            cbhilo15.setSelectedItem("0");
            
            
            
            

            st.close();
        } catch (SQLException ex) {
            System.out.println(ex);
        }

    }
    
    
    void datos()
    {
        
        actualizarbordado ="no";
        
        
        String sql = "SELECT color1,color2,color3,color4,color5,color6,color7,color8,color9,color10,color11,color12,color13,color14,color15,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,hilo8,hilo9,hilo10,hilo11,hilo12,hilo13,hilo14,hilo15 FROM colorido_bordados where nombrebordado = '"+lbidentificador.getText()+"' and codigo = '"+lbcodigo.getText()+"' AND nombre = '"+nombrebordado+"' ";


            try {

                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {

                   
                        cbhilo1.setSelectedItem(rs.getString("hilo1"));
                        cbhilo2.setSelectedItem(rs.getString("hilo2"));
                        cbhilo3.setSelectedItem(rs.getString("hilo3"));
                        cbhilo4.setSelectedItem(rs.getString("hilo4"));
                        cbhilo5.setSelectedItem(rs.getString("hilo5"));
                        cbhilo6.setSelectedItem(rs.getString("hilo6"));
                        cbhilo7.setSelectedItem(rs.getString("hilo7"));
                        cbhilo8.setSelectedItem(rs.getString("hilo8"));
                        cbhilo9.setSelectedItem(rs.getString("hilo9"));
                        cbhilo10.setSelectedItem(rs.getString("hilo10"));
                        cbhilo11.setSelectedItem(rs.getString("hilo11"));
                        cbhilo12.setSelectedItem(rs.getString("hilo12"));
                        cbhilo13.setSelectedItem(rs.getString("hilo13"));
                        cbhilo14.setSelectedItem(rs.getString("hilo14"));
                        cbhilo15.setSelectedItem(rs.getString("hilo15"));
                       
                        lbcolor1.setText(rs.getString("color1"));
                        lbcolor2.setText(rs.getString("color2"));
                        lbcolor3.setText(rs.getString("color3"));
                        lbcolor4.setText(rs.getString("color4"));
                        lbcolor5.setText(rs.getString("color5"));
                        lbcolor6.setText(rs.getString("color6"));
                        lbcolor7.setText(rs.getString("color7"));
                        lbcolor8.setText(rs.getString("color8"));
                        lbcolor9.setText(rs.getString("color9"));
                        lbcolor10.setText(rs.getString("color10"));
                        lbcolor11.setText(rs.getString("color11"));
                        lbcolor12.setText(rs.getString("color12"));
                        lbcolor13.setText(rs.getString("color13"));
                        lbcolor14.setText(rs.getString("color14"));
                        lbcolor15.setText(rs.getString("color15"));
                        
                        
                         actualizarbordado = "si";

                }

                st.close();
            } catch (SQLException ex) {
                System.out.println(ex);
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

        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        cbhilo1 = new javax.swing.JComboBox();
        cbhilo2 = new javax.swing.JComboBox();
        cbhilo3 = new javax.swing.JComboBox();
        cbhilo5 = new javax.swing.JComboBox();
        cbhilo4 = new javax.swing.JComboBox();
        cbhilo6 = new javax.swing.JComboBox();
        cbhilo7 = new javax.swing.JComboBox();
        cbhilo8 = new javax.swing.JComboBox();
        cbhilo9 = new javax.swing.JComboBox();
        cbhilo10 = new javax.swing.JComboBox();
        cbhilo11 = new javax.swing.JComboBox();
        cbhilo12 = new javax.swing.JComboBox();
        cbhilo13 = new javax.swing.JComboBox();
        cbhilo14 = new javax.swing.JComboBox();
        cbhilo15 = new javax.swing.JComboBox();
        lbcolor1 = new javax.swing.JLabel();
        lbcolor2 = new javax.swing.JLabel();
        lbcolor3 = new javax.swing.JLabel();
        lbcolor4 = new javax.swing.JLabel();
        lbcolor5 = new javax.swing.JLabel();
        lbcolor6 = new javax.swing.JLabel();
        lbcolor7 = new javax.swing.JLabel();
        lbcolor8 = new javax.swing.JLabel();
        lbcolor9 = new javax.swing.JLabel();
        lbcolor10 = new javax.swing.JLabel();
        lbcolor11 = new javax.swing.JLabel();
        lbcolor12 = new javax.swing.JLabel();
        lbcolor13 = new javax.swing.JLabel();
        lbcolor14 = new javax.swing.JLabel();
        lbcolor15 = new javax.swing.JLabel();
        lbcliente = new javax.swing.JLabel();
        lbcodigo = new javax.swing.JLabel();
        lbidentificador = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Colorido");
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

        jLabel59.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel59.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel59.setText("Color del bordado");
        jLabel59.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel60.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel60.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel60.setText("Cod/Hilo");
        jLabel60.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbhilo1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo1.setToolTipText("");
        cbhilo1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo1PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo2.setToolTipText("");
        cbhilo2.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo2PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo2PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo3.setToolTipText("");
        cbhilo3.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo3PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo3PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo5.setToolTipText("");
        cbhilo5.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo5PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo5PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo4.setToolTipText("");
        cbhilo4.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo4PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo4PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo6.setToolTipText("");
        cbhilo6.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo6PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo6PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo7.setToolTipText("");
        cbhilo7.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo7PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo7PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo8.setToolTipText("");
        cbhilo8.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo8PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo8PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo9.setToolTipText("");
        cbhilo9.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo9PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo9PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo10.setToolTipText("");
        cbhilo10.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo10PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo10PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo11.setToolTipText("");
        cbhilo11.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo11PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo11PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo12.setToolTipText("");
        cbhilo12.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo12PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo12PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo13.setToolTipText("");
        cbhilo13.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo13PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo13PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo14.setToolTipText("");
        cbhilo14.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo14PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo14PopupMenuWillBecomeVisible(evt);
            }
        });

        cbhilo15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbhilo15.setToolTipText("");
        cbhilo15.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo15PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                cbhilo15PopupMenuWillBecomeVisible(evt);
            }
        });

        lbcolor1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor9.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor10.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor11.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor12.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor13.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor14.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcolor15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcolor15.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcliente.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcliente.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbcodigo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbcodigo.setText("lbcodigo");

        lbidentificador.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbidentificador.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Guardar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 311, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lbcodigo, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                    .addComponent(jLabel60, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbhilo1, javax.swing.GroupLayout.Alignment.LEADING, 0, 102, Short.MAX_VALUE)
                                    .addComponent(cbhilo2, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo3, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo4, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo5, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo6, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo7, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo8, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo9, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo10, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo11, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo12, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo13, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo14, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbhilo15, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbcolor1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(lbcolor9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbcolor14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(134, 134, 134)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbidentificador, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                            .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                    .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                            .addGroup(layout.createSequentialGroup()
                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                    .addGroup(layout.createSequentialGroup()
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                            .addGroup(layout.createSequentialGroup()
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                    .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(7, 7, 7)
                                                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                                    .addGroup(layout.createSequentialGroup()
                                                                                                        .addComponent(cbhilo1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addGap(6, 6, 6)
                                                                                                        .addComponent(cbhilo2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                    .addGroup(layout.createSequentialGroup()
                                                                                                        .addComponent(lbcolor1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                        .addComponent(lbcolor2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                                                .addGap(5, 5, 5)
                                                                                                .addComponent(cbhilo3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                            .addComponent(lbcolor3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addGap(4, 4, 4)
                                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                            .addComponent(cbhilo4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                            .addComponent(lbcolor4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                        .addComponent(cbhilo5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                    .addComponent(lbcolor5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                .addComponent(cbhilo6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                            .addComponent(lbcolor6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(4, 4, 4)
                                                                        .addComponent(cbhilo7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                    .addComponent(lbcolor7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(8, 8, 8)
                                                                .addComponent(cbhilo8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                            .addComponent(lbcolor8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(cbhilo9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addComponent(lbcolor9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(cbhilo10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(lbcolor10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cbhilo11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lbcolor11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cbhilo12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbcolor12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbhilo13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbcolor13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbhilo14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbcolor14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cbhilo15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbcolor15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbhilo1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo1PopupMenuWillBecomeInvisible

        String hilo = cbhilo1.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo =lbcolor1.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");

                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }
                        
                        
                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                   lbcolor1.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo1.setSelectedItem(hilo1seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor1.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo1PopupMenuWillBecomeInvisible

    private void cbhilo1PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo1PopupMenuWillBecomeVisible

        hilo1seleccionado = cbhilo1.getSelectedItem().toString();
        color1seleccionado = lbcolor1.getText();

    }//GEN-LAST:event_cbhilo1PopupMenuWillBecomeVisible

    private void cbhilo2PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo2PopupMenuWillBecomeInvisible

        String hilo = cbhilo2.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor2.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor2.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo2.setSelectedItem(hilo2seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor2.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo2PopupMenuWillBecomeInvisible

    private void cbhilo2PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo2PopupMenuWillBecomeVisible

        hilo2seleccionado = cbhilo2.getSelectedItem().toString();
        color2seleccionado = lbcolor2.getText();

    }//GEN-LAST:event_cbhilo2PopupMenuWillBecomeVisible

    private void cbhilo3PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo3PopupMenuWillBecomeInvisible

        String hilo = cbhilo3.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor3.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor3.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo3.setSelectedItem(hilo3seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor3.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo3PopupMenuWillBecomeInvisible

    private void cbhilo3PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo3PopupMenuWillBecomeVisible

        hilo3seleccionado = cbhilo3.getSelectedItem().toString();
        color3seleccionado = lbcolor3.getText();

    }//GEN-LAST:event_cbhilo3PopupMenuWillBecomeVisible

    private void cbhilo5PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo5PopupMenuWillBecomeInvisible

        String hilo = cbhilo5.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor5.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor5.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo5.setSelectedItem(hilo5seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor5.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo5PopupMenuWillBecomeInvisible

    private void cbhilo5PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo5PopupMenuWillBecomeVisible

        hilo5seleccionado = cbhilo5.getSelectedItem().toString();
        color5seleccionado = lbcolor5.getText();

    }//GEN-LAST:event_cbhilo5PopupMenuWillBecomeVisible

    private void cbhilo4PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo4PopupMenuWillBecomeInvisible

        String hilo = cbhilo4.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor4.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor4.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo4.setSelectedItem(hilo4seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor4.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo4PopupMenuWillBecomeInvisible

    private void cbhilo4PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo4PopupMenuWillBecomeVisible

        hilo4seleccionado = cbhilo4.getSelectedItem().toString();
        color4seleccionado = lbcolor4.getText();

    }//GEN-LAST:event_cbhilo4PopupMenuWillBecomeVisible

    private void cbhilo6PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo6PopupMenuWillBecomeInvisible

        String hilo = cbhilo6.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor6.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor6.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo6.setSelectedItem(hilo6seleccionado);

                                }
                            }

                        }
                        else
                        {

                           lbcolor6.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo6PopupMenuWillBecomeInvisible

    private void cbhilo6PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo6PopupMenuWillBecomeVisible

        hilo6seleccionado = cbhilo6.getSelectedItem().toString();
        color6seleccionado = lbcolor6.getText();

    }//GEN-LAST:event_cbhilo6PopupMenuWillBecomeVisible

    private void cbhilo7PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo7PopupMenuWillBecomeInvisible

        String hilo = cbhilo7.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor7.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor7.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo7.setSelectedItem(hilo7seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor7.setText(colorsinhilo);

                        }

                    }

                }

            }

        }

    }//GEN-LAST:event_cbhilo7PopupMenuWillBecomeInvisible

    private void cbhilo7PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo7PopupMenuWillBecomeVisible

        hilo7seleccionado = cbhilo7.getSelectedItem().toString();
        color7seleccionado = lbcolor7.getText();

    }//GEN-LAST:event_cbhilo7PopupMenuWillBecomeVisible

    private void cbhilo8PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo8PopupMenuWillBecomeInvisible
     
        String hilo = cbhilo8.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor8.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor8.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo8.setSelectedItem(hilo8seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor8.setText(colorsinhilo);

                        }

                    }

                }

            }

        }
    }//GEN-LAST:event_cbhilo8PopupMenuWillBecomeInvisible

    private void cbhilo8PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo8PopupMenuWillBecomeVisible
        hilo8seleccionado = cbhilo8.getSelectedItem().toString();
        color8seleccionado = lbcolor8.getText();
    }//GEN-LAST:event_cbhilo8PopupMenuWillBecomeVisible

    private void cbhilo9PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo9PopupMenuWillBecomeInvisible
      String hilo = cbhilo9.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor9.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor9.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo9.setSelectedItem(hilo9seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor9.setText(colorsinhilo);

                        }

                    }

                }

            }

        }
    }//GEN-LAST:event_cbhilo9PopupMenuWillBecomeInvisible

    private void cbhilo9PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo9PopupMenuWillBecomeVisible
       hilo9seleccionado = cbhilo9.getSelectedItem().toString();
        color9seleccionado = lbcolor9.getText();
    }//GEN-LAST:event_cbhilo9PopupMenuWillBecomeVisible

    private void cbhilo10PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo10PopupMenuWillBecomeInvisible
      String hilo = cbhilo10.getSelectedItem().toString();

        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor10.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor10.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo10.setSelectedItem(hilo10seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor10.setText(colorsinhilo);

                        }

                    }

                }

            }

        }
    }//GEN-LAST:event_cbhilo10PopupMenuWillBecomeInvisible

    private void cbhilo10PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo10PopupMenuWillBecomeVisible
      hilo10seleccionado = cbhilo10.getSelectedItem().toString();
        color10seleccionado = lbcolor10.getText();
    }//GEN-LAST:event_cbhilo10PopupMenuWillBecomeVisible

    private void cbhilo11PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo11PopupMenuWillBecomeInvisible
        
        String hilo = cbhilo11.getSelectedItem().toString();
        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor11.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor11.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo11.setSelectedItem(hilo11seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor11.setText(colorsinhilo);

                        }

                    }

                }

            }

        }
    }//GEN-LAST:event_cbhilo11PopupMenuWillBecomeInvisible

    private void cbhilo11PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo11PopupMenuWillBecomeVisible
       hilo11seleccionado = cbhilo11.getSelectedItem().toString();
        color11seleccionado = lbcolor11.getText();
    }//GEN-LAST:event_cbhilo11PopupMenuWillBecomeVisible

    private void cbhilo12PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo12PopupMenuWillBecomeInvisible
      String hilo = cbhilo12.getSelectedItem().toString();
        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor12.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor12.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo12.setSelectedItem(hilo12seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor12.setText(colorsinhilo);

                        }

                    }

                }

            }

        }
    }//GEN-LAST:event_cbhilo12PopupMenuWillBecomeInvisible

    private void cbhilo12PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo12PopupMenuWillBecomeVisible
      hilo12seleccionado = cbhilo12.getSelectedItem().toString();
        color12seleccionado = lbcolor12.getText();
    }//GEN-LAST:event_cbhilo12PopupMenuWillBecomeVisible

    private void cbhilo13PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo13PopupMenuWillBecomeInvisible
       String hilo = cbhilo13.getSelectedItem().toString();
        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor13.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor13.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo13.setSelectedItem(hilo13seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor13.setText(colorsinhilo);

                        }

                    }

                }

            }

        }
    }//GEN-LAST:event_cbhilo13PopupMenuWillBecomeInvisible

    private void cbhilo13PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo13PopupMenuWillBecomeVisible
       hilo13seleccionado = cbhilo13.getSelectedItem().toString();
        color13seleccionado = lbcolor13.getText();
    }//GEN-LAST:event_cbhilo13PopupMenuWillBecomeVisible

    private void cbhilo14PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo14PopupMenuWillBecomeInvisible
      String hilo = cbhilo14.getSelectedItem().toString();
        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor14.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor14.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo14.setSelectedItem(hilo11seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor14.setText(colorsinhilo);

                        }

                    }

                }

            }

        }
    }//GEN-LAST:event_cbhilo14PopupMenuWillBecomeInvisible

    private void cbhilo14PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo14PopupMenuWillBecomeVisible
        hilo14seleccionado = cbhilo14.getSelectedItem().toString();
        color14seleccionado = lbcolor14.getText();
    }//GEN-LAST:event_cbhilo14PopupMenuWillBecomeVisible

    private void cbhilo15PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo15PopupMenuWillBecomeInvisible
       String hilo = cbhilo15.getSelectedItem().toString();
        String hiloconcolor = "";
        String colorsinhilo = "";
        String colorencombo = lbcolor15.getText();

        if (!hilo.equals("0"))

        {

            for (String valor: listahilos) {

                hiloconcolor =  valor;

                if (!hiloconcolor.equals("0"))

                {

                    if (hiloconcolor.contains(hilo))

                    {

                        colorsinhilo =  hiloconcolor.replace(hilo, "");
                        
                        if(colorencombo.isEmpty())
                        {
                            colorencombo = "ninguno";
                        }

                        if (!colorencombo.equals("ninguno"))

                        {
                            if (!colorencombo.equals(colorsinhilo))

                            {
                                int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Ya habia seleccionado el color "+colorencombo+" desea cambiarlo por "+colorsinhilo+"?", null, JOptionPane.YES_NO_OPTION);
                                if (result == JOptionPane.YES_OPTION)
                                {
                                    lbcolor15.setText(colorsinhilo);

                                }
                                else
                                {

                                    cbhilo15.setSelectedItem(hilo15seleccionado);

                                }
                            }

                        }
                        else
                        {

                            lbcolor15.setText(colorsinhilo);

                        }

                    }

                }

            }

        }
    }//GEN-LAST:event_cbhilo15PopupMenuWillBecomeInvisible

    private void cbhilo15PopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_cbhilo15PopupMenuWillBecomeVisible
       hilo15seleccionado = cbhilo15.getSelectedItem().toString();
        color15seleccionado = lbcolor15.getText();
    }//GEN-LAST:event_cbhilo15PopupMenuWillBecomeVisible

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   
        Object color1 = lbcolor1.getText();
        if (color1 == null || color1.equals("") || color1.equals(" ")) {
            color1 = "";
        }
        Object color2 = lbcolor2.getText();
        if (color2 == null || color2.equals("") || color2.equals(" ")) {
            color2 = "";
        }
        Object color3 = lbcolor3.getText();
        if (color3 == null || color3.equals("") || color3.equals(" ")) {
            color3 = "";
        }
        Object color4 = lbcolor4.getText();
        if (color4 == null || color4.equals("") || color4.equals(" ")) {
            color4 = "";
        }
        Object color5 = lbcolor5.getText();
        if (color5 == null || color5.equals("") || color5.equals(" ")) {
            color5 = "";
        }
        Object color6 = lbcolor6.getText();
        if (color6 == null || color6.equals("") || color6.equals(" ")) {
            color6 = "";
        }
        Object color7 = lbcolor7.getText();
        if (color7 == null || color7.equals("") || color7.equals(" ")) {
            color7 = "";
        }
        Object color8 = lbcolor8.getText();
        if (color8 == null || color8.equals("") || color8.equals(" ")) {
            color8 = "";
        }
        
        
         Object color9 = lbcolor9.getText();
        if (color9 == null || color9.equals("") || color9.equals(" ")) {
            color9 = "";
        }
         Object color10 = lbcolor10.getText();
        if (color10 == null || color10.equals("") || color10.equals(" ")) {
            color10 = "";
        }
         Object color11 = lbcolor11.getText();
        if (color11 == null || color11.equals("") || color11.equals(" ")) {
            color11 = "";
        }
         Object color12 = lbcolor12.getText();
        if (color12 == null || color12.equals("") || color12.equals(" ")) {
            color12 = "";
        }
         Object color13 = lbcolor13.getText();
        if (color13 == null || color13.equals("") || color13.equals(" ")) {
            color13 = "";
        }
         Object color14 = lbcolor14.getText();
        if (color14 == null || color14.equals("") || color14.equals(" ")) {
            color14 = "";
        }
         Object color15 = lbcolor15.getText();
        if (color15 == null || color15.equals("") || color15.equals(" ")) {
            color15 = "";
        }
         

        /// hilos
        
        
        Object hilo1 = cbhilo1.getSelectedItem();
        if (hilo1 == null || hilo1.equals("") || hilo1.equals(" ")) {
            hilo1 = "0";
        }

        Object hilo2 = cbhilo2.getSelectedItem();
        if (hilo2 == null || hilo2.equals("") || hilo2.equals(" ")) {
            hilo2 = "0";
        }

        Object hilo3 = cbhilo3.getSelectedItem();
        if (hilo3 == null || hilo3.equals("") || hilo3.equals(" ")) {
            hilo3 = "0";
        }

        Object hilo4 = cbhilo4.getSelectedItem();
        if (hilo4 == null || hilo4.equals("") || hilo4.equals(" ")) {
            hilo4 = "0";
        }

        Object hilo5 = cbhilo5.getSelectedItem();
        if (hilo5 == null || hilo5.equals("") || hilo5.equals(" ")) {
            hilo5 = "0";
        }

        Object hilo6 = cbhilo6.getSelectedItem();
        if (hilo6 == null || hilo6.equals("") || hilo6.equals(" ")) {
            hilo6 = "0";
        }

        Object hilo7 = cbhilo7.getSelectedItem();
        if (hilo7 == null || hilo7.equals("") || hilo7.equals(" ")) {
            hilo7 = "0";
        }
        
        Object hilo8 = cbhilo8.getSelectedItem();
        if (hilo8 == null || hilo8.equals("") || hilo8.equals(" ")) {
            hilo8 = "0";
        }
        
        Object hilo9 = cbhilo9.getSelectedItem();
        if (hilo9 == null || hilo9.equals("") || hilo9.equals(" ")) {
            hilo9 = "0";
        }
        
        Object hilo10 = cbhilo10.getSelectedItem();
        if (hilo10 == null || hilo10.equals("") || hilo10.equals(" ")) {
            hilo10 = "0";
        }
        
        Object hilo11 = cbhilo11.getSelectedItem();
        if (hilo11 == null || hilo11.equals("") || hilo11.equals(" ")) {
            hilo11 = "0";
        }
        
        Object hilo12 = cbhilo12.getSelectedItem();
        if (hilo12 == null || hilo12.equals("") || hilo12.equals(" ")) {
            hilo12 = "0";
        }
        Object hilo13 = cbhilo13.getSelectedItem();
        if (hilo13 == null || hilo13.equals("") || hilo13.equals(" ")) {
            hilo13 = "0";
        }
        Object hilo14 = cbhilo14.getSelectedItem();
        if (hilo14 == null || hilo14.equals("") || hilo14.equals(" ")) {
            hilo14 = "0";
        }
        Object hilo15 = cbhilo15.getSelectedItem();
        if (hilo15 == null || hilo15.equals("") || hilo15.equals(" ")) {
            hilo15 = "0";
        }

        
        
        
        
        
        if(actualizarbordado.equals("si"))
        {
            
            

                  //// Colores e hilos
                
                   try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE colorido_bordados SET color1= '" + color1+ "', color2='" + color2 + "',color3='" + color3 + "',color4='" + color4 + "',color5='" + color5 + "',color6='" + color6 + "' ,color7='" + color7 + "' ,color8='" + color8 + "',color9 ='" + color9 + "',color10 ='" +color10+ "',color11 ='" +color11+ "',color12 ='"+color12+"',color13 ='" +color13+ "' ,color14 ='" +color14+ "',color15 ='" +color15+ "'  WHERE codigo='"+lbcodigo.getText()+"' and  nombre = '"+lbcliente.getText()+"' AND nombrebordado = '"+nombrebordado+"' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                 try {
                    PreparedStatement pst = cn.prepareStatement("UPDATE colorido_bordados SET hilo1= '" + hilo1+ "', hilo2='" + hilo2 + "',hilo3='" + hilo3 + "',hilo4='" + hilo4 + "',hilo5='" + hilo5 + "',hilo6='" + hilo6 + "' ,hilo7='" + hilo7 + "' ,hilo8='" + hilo8 + "',hilo9 ='" + hilo9 + "',hilo10 ='" +hilo10+ "',hilo11 ='" +hilo11+ "',hilo12 ='"+hilo12+"',hilo13 ='" +hilo13+ "' ,hilo14 ='" +hilo14+ "',hilo15 ='" +hilo15+ "'  WHERE codigo='"+lbcodigo.getText()+"' and nombre = '"+lbcliente.getText()+"' AND nombrebordado = '"+nombrebordado+"'   ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    System.out.println(e);
                }
   
                 
                JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:5px;\">Se actualizo correctamente");
                this.dispose();
        
        
        }
        else
        {
            
            
            //insertarnumero();

            String InsertarSQL = "INSERT INTO colorido_bordados(codigo,nombre,nombrebordado,color1,color2,color3,color4,color5,color6,color7,color8,color9,color10,color11,color12,color13,color14,color15,hilo1,hilo2,hilo3,hilo4,hilo5,hilo6,hilo7,hilo8,hilo9,hilo10,hilo11,hilo12,hilo13,hilo14,hilo15) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);

                pst.setString(1, lbcodigo.getText());
                pst.setString(2, lbcliente.getText());
                pst.setString(3, nombrebordado);

                pst.setString(4, color1.toString());
                pst.setString(5, color2.toString());
                pst.setString(6, color3.toString());
                pst.setString(7, color4.toString());
                pst.setString(8, color5.toString());
                pst.setString(9, color6.toString());
                pst.setString(10,color7.toString());
                pst.setString(11,color8.toString());
                pst.setString(12,color9.toString());
                pst.setString(13,color10.toString());
                pst.setString(14,color11.toString());
                pst.setString(15,color12.toString());
                pst.setString(16,color13.toString());
                pst.setString(17,color14.toString());
                pst.setString(18,color15.toString());
                
                pst.setString(19, hilo1.toString());
                pst.setString(20, hilo2.toString());
                pst.setString(21, hilo3.toString());
                pst.setString(22, hilo4.toString());
                pst.setString(23, hilo5.toString());
                pst.setString(24, hilo6.toString());
                pst.setString(25, hilo7.toString());
                pst.setString(26, hilo8.toString());
                pst.setString(27, hilo9.toString());
                pst.setString(28, hilo10.toString());
                pst.setString(29, hilo11.toString());
                pst.setString(30, hilo12.toString());
                pst.setString(31, hilo13.toString());
                pst.setString(32, hilo14.toString());
                pst.setString(33, hilo15.toString());
                
                
                pst.executeUpdate();
                pst.close();
                
                
          

            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            JOptionPane.showMessageDialog(this, "<HTML><b style=\"Color:green; font-size:5px;\">Se inserto correctamente");
            
            this.dispose();
            
        }    
        
        
        
          
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    datos();
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
    ventanacolorido = false;
    this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
    ventanacolorido = false;
    this.dispose();
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(colorido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(colorido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(colorido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(colorido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new colorido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbhilo1;
    private javax.swing.JComboBox cbhilo10;
    private javax.swing.JComboBox cbhilo11;
    private javax.swing.JComboBox cbhilo12;
    private javax.swing.JComboBox cbhilo13;
    private javax.swing.JComboBox cbhilo14;
    private javax.swing.JComboBox cbhilo15;
    private javax.swing.JComboBox cbhilo2;
    private javax.swing.JComboBox cbhilo3;
    private javax.swing.JComboBox cbhilo4;
    private javax.swing.JComboBox cbhilo5;
    private javax.swing.JComboBox cbhilo6;
    private javax.swing.JComboBox cbhilo7;
    private javax.swing.JComboBox cbhilo8;
    private javax.swing.JComboBox cbhilo9;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    public static javax.swing.JLabel lbcliente;
    public static javax.swing.JLabel lbcodigo;
    public javax.swing.JLabel lbcolor1;
    public javax.swing.JLabel lbcolor10;
    public javax.swing.JLabel lbcolor11;
    public javax.swing.JLabel lbcolor12;
    public javax.swing.JLabel lbcolor13;
    public javax.swing.JLabel lbcolor14;
    public javax.swing.JLabel lbcolor15;
    public javax.swing.JLabel lbcolor2;
    public javax.swing.JLabel lbcolor3;
    public javax.swing.JLabel lbcolor4;
    public javax.swing.JLabel lbcolor5;
    public javax.swing.JLabel lbcolor6;
    public javax.swing.JLabel lbcolor7;
    public javax.swing.JLabel lbcolor8;
    public javax.swing.JLabel lbcolor9;
    public static javax.swing.JLabel lbidentificador;
    // End of variables declaration//GEN-END:variables

    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();


}
