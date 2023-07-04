package sistemabordadores;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.*;
import java.sql.PreparedStatement;
import java.awt.event.KeyEvent;
import javax.swing.InputMap;
import javax.swing.KeyStroke;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FilenameUtils;

public class informacionrapidaeditar extends javax.swing.JFrame {

    public static boolean ventanainformacionrapida = false;
    String extension = "";
    String rutadelarchivoadjunto = "";
    public static Object nombrearchivo = "";
    public static Object extensionarchivo = "";

    public informacionrapidaeditar() {
        initComponents();
        setVisible(true);
 
        
        ventanainformacionrapida = true;
        lbrutaarchivo.setVisible(false);
        txtcodigo.setVisible(false);
        
        btnverarchivo.setEnabled(false);
        btneliminararchivo.setEnabled(false);
        
                
    }

    void datos() {

        String nombre = txtdescripcion.getText();

        String sql = "SELECT codigo,area,detalle,archivo,extension_archivo FROM catalogo_informacion_rapida WHERE descripcion = '" + nombre + "' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {

                txtcodigo.setText(rs.getString("codigo"));
                cbarea.setSelectedItem(rs.getString("area"));
                txtareadetalle.setText(rs.getString("detalle"));
                extension = rs.getString("extension_archivo");
                
                if (extension == null || extension.equals("") ||extension.equals(" ")) 
                {
                    btnverarchivo.setEnabled(false);
                    btncargararchivo.setEnabled(true);
                    btneliminararchivo.setEnabled(false);        
                }
                else 
                {
                    btnverarchivo.setEnabled(true);
                    btncargararchivo.setEnabled(false);
                    btneliminararchivo.setEnabled(true);  
                }

            }
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);

        }

    }
    
    void adjuntararchivo()     
    {
        
        String codigo = txtcodigo.getText();
        String SQL = "SELECT archivo,extension_archivo FROM catalogo_informacion_rapida where codigo = '" + codigo + "' ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(SQL);
            while (rs1.next()) {
                nombrearchivo = rs1.getString(1);
                if (nombrearchivo == null) 
                
                {

                } 
                else
                {
                    extensionarchivo = rs1.getString(2);
                    rutadelarchivoadjunto = "C:\\\\archivospdf\\" + codigo + "." + extensionarchivo + " ";
                    File file = new File(rutadelarchivoadjunto);
                    FileOutputStream output = new FileOutputStream(file);
                    Blob archivo = rs1.getBlob(1);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    while ((length = inStream.read(buffer)) != -1) {
                        output.write(buffer, 0, length);
                    }
                    output.close();
                }

            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
        
        
        
        
    }
    
    
   
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbletiquetanombre = new javax.swing.JLabel();
        txtcodigo = new javax.swing.JTextField();
        txtdescripcion = new javax.swing.JTextField();
        btnguardar = new javax.swing.JButton();
        btnsalir = new javax.swing.JButton();
        txtcod = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtareadetalle = new javax.swing.JTextArea();
        btnverarchivo = new javax.swing.JButton();
        btncargararchivo = new javax.swing.JButton();
        lbrutaarchivo = new javax.swing.JLabel();
        btneliminararchivo = new javax.swing.JButton();
        lbletiquetanombre2 = new javax.swing.JLabel();
        cbarea = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Informacion rapida editar");
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

        lbletiquetanombre.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbletiquetanombre.setText("Descripcion");
        lbletiquetanombre.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtcodigo.setEditable(false);
        txtcodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodigoActionPerformed(evt);
            }
        });
        txtcodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcodigoKeyTyped(evt);
            }
        });

        txtdescripcion.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        txtdescripcion.setForeground(new java.awt.Color(153, 0, 0));
        txtdescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdescripcionActionPerformed(evt);
            }
        });
        txtdescripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtdescripcionKeyTyped(evt);
            }
        });

        btnguardar.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        txtcod.setEditable(false);
        txtcod.setEnabled(false);
        txtcod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcodActionPerformed(evt);
            }
        });

        txtareadetalle.setColumns(20);
        txtareadetalle.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtareadetalle.setRows(5);
        jScrollPane2.setViewportView(txtareadetalle);

        btnverarchivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnverarchivo.setText("Ver Archivo");
        btnverarchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnverarchivoActionPerformed(evt);
            }
        });

        btncargararchivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btncargararchivo.setText("Cargar Archivo");
        btncargararchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargararchivoActionPerformed(evt);
            }
        });

        lbrutaarchivo.setText(" ");

        btneliminararchivo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btneliminararchivo.setText("Eliminar Archivo");
        btneliminararchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminararchivoActionPerformed(evt);
            }
        });

        lbletiquetanombre2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        lbletiquetanombre2.setText("Area");
        lbletiquetanombre2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        cbarea.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cbarea.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione area", "Capacitacion", "Formatos", "Información que solicita el cliente", "Información interna", "Labor de venta", "Respuestas rápidas", "Ventas" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbletiquetanombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbletiquetanombre)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbarea, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnverarchivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncargararchivo)
                                .addGap(12, 12, 12)
                                .addComponent(btneliminararchivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbrutaarchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 897, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtdescripcion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnguardar)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbletiquetanombre2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbarea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnverarchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncargararchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btneliminararchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbrutaarchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(txtcod, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtcodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(lbletiquetanombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(864, 864, 864))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodigoActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        ventanainformacionrapida = false;
        this.dispose();

    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed


        
        Object area = cbarea.getSelectedItem();
        
        if (area.equals("Seleccione area"))
            
        {
            
            JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Falta seleccionar el area", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        else
            
        {

       
         String ext = "";
        Object codigo = txtcodigo.getText();
        
        
        
        
        if ((codigo == null) || (codigo.equals("")) || (codigo.equals("0"))) {

            int j;
            String c = "";
            String SQL = "SELECT MAX(codigo) FROM catalogo_informacion_rapida";

            try {
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(SQL);
                if (rs.next()) {
                    c = rs.getString(1);
                }

                if (c == null) {
                    txtcodigo.setText("00000001");
                } else {
                    j = Integer.parseInt(c);
                    GenerarNumero gen = new GenerarNumero();
                    gen.generar(j);

                    txtcodigo.setText(gen.serie());

                }

            } catch (Exception e) {

            }

            FileInputStream input = null;
            Object archivo = lbrutaarchivo.getText();
            if (archivo == null || archivo.equals("") || archivo.equals(" ")) {

            } else {
                String filePath = lbrutaarchivo.getText();
                ext = FilenameUtils.getExtension(lbrutaarchivo.getText());
                try {
                    input = new FileInputStream(new File(filePath));
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(informacionrapidaeditar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            String InsertarSQL = "INSERT INTO catalogo_informacion_rapida(codigo,descripcion,detalle,area,archivo,extension_archivo) VALUES (?,?,?,?,?,?)";

            try {
                PreparedStatement pst = cn.prepareStatement(InsertarSQL);

                pst.setString(1, txtcodigo.getText());
                pst.setString(2, txtdescripcion.getText());
                pst.setString(3, txtareadetalle.getText());
                pst.setString(4, cbarea.getSelectedItem().toString());
                pst.setBinaryStream(5, input);
                pst.setString(6, ext);
                pst.executeUpdate();
                pst.close();
            } catch (SQLException ex) {
                System.out.println(ex);

            }

        } else {

            try {
                PreparedStatement pst = cn.prepareStatement("UPDATE catalogo_informacion_rapida SET descripcion='" + txtdescripcion.getText() + "', area = '" + cbarea.getSelectedItem() + "',detalle='" + txtareadetalle.getText() + "' WHERE codigo='" + codigo + "'");
                pst.executeUpdate();
                pst.close();
            } catch (Exception e) {
                System.out.println(e);
            }

            PreparedStatement myStmt = null;
            FileInputStream input = null;

            ///actualiza los archivos
            Object archivo = lbrutaarchivo.getText();
            if (archivo == null || archivo.equals("") || archivo.equals(" ")) {

            } else {
                try {

                    String sql = "UPDATE catalogo_informacion_rapida set archivo=? where codigo='" + codigo + "' ";

                    myStmt = cn.prepareStatement(sql);
                    String path = lbrutaarchivo.getText();
                    File theFile = new File(path);
                    input = new FileInputStream(theFile);
                    myStmt.setBinaryStream(1, input);
                    myStmt.executeUpdate();
                    //myStmt.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    String extension = FilenameUtils.getExtension(lbrutaarchivo.getText());
                    PreparedStatement pst = cn.prepareStatement("UPDATE catalogo_informacion_rapida SET extension_archivo='" + extension + "' where codigo='" + codigo + "' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

        informacionrapidacatalogo.btndatos.doClick();
        this.dispose();
        
        }


    }//GEN-LAST:event_btnguardarActionPerformed


    private void txtcodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcodActionPerformed

    private void txtcodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcodigoKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnguardar.doClick();
        }
    }//GEN-LAST:event_txtcodigoKeyTyped

    private void txtdescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtdescripcionKeyTyped
        char cTeclaPresionada = evt.getKeyChar();
        if (cTeclaPresionada == KeyEvent.VK_ENTER) {
            btnguardar.doClick();
        }
    }//GEN-LAST:event_txtdescripcionKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        if (informacionrapidacatalogo.ventanainformacionrapidacatalogo == true) {
            informacionrapidacatalogo.btndatos.doClick();
        }

        ventanainformacionrapida = false;
        this.dispose();


    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        ventanainformacionrapida = false;
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void btnverarchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnverarchivoActionPerformed
        String codigo = txtcodigo.getText();
        String pathname = "";
        String existe = "no";
        String SQL = "SELECT archivo,extension_archivo FROM catalogo_informacion_rapida where codigo = '" + codigo + "' ";

        try {
            Statement st1 = cn.createStatement();
            ResultSet rs1 = st1.executeQuery(SQL);
            while (rs1.next()) {
                Object a = rs1.getString(1);
                if (a == null) {

                } else {
                    String ext = rs1.getString(2);
                    pathname = "C://archivospdf/" + codigo + "." + ext + " ";
                    existe = "si";
                    File file = new File(pathname);
                    FileOutputStream output = new FileOutputStream(file);
                    Blob archivo = rs1.getBlob(1);
                    InputStream inStream = archivo.getBinaryStream();
                    int length = -1;
                    int size = (int) archivo.length();
                    byte[] buffer = new byte[size];
                    while ((length = inStream.read(buffer)) != -1) {
                        output.write(buffer, 0, length);
                    }
                    output.close();
                }

            }
            rs1.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }

        if (existe.equals("si")) {
            String fileLocal = new String(pathname);
            try {

                File path = new File(fileLocal);
                Desktop.getDesktop().open(path);

            } catch (IOException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {

                JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">No se pudo encontrar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
                e.printStackTrace();
            }
        }

    }//GEN-LAST:event_btnverarchivoActionPerformed

    private void btncargararchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargararchivoActionPerformed
       
        
        JSystemFileChooser adjuntar = new JSystemFileChooser();
        int respuesta = adjuntar.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivoelegido = adjuntar.getSelectedFile();
            String fl = archivoelegido.toString();

            lbrutaarchivo.setText(fl);

            int a = fl.length();

            if (a > 0) 
            {
                
                btncargararchivo.setEnabled(false);
                btnverarchivo.setEnabled(true);
                btneliminararchivo.setEnabled(true);
                Object codigo = txtcodigo.getText();
                PreparedStatement myStmt = null;
                FileInputStream input = null;
                Object archivo = lbrutaarchivo.getText();
                
                
                
            if (archivo == null || archivo.equals("") || archivo.equals(" ")) 
            {

            } 
            else 
            
            {
                try {

                    String sql = "UPDATE catalogo_informacion_rapida set archivo=? where codigo='" + codigo + "' ";

                    myStmt = cn.prepareStatement(sql);
                    String path = lbrutaarchivo.getText();
                    File theFile = new File(path);
                    input = new FileInputStream(theFile);
                    myStmt.setBinaryStream(1, input);
                    myStmt.executeUpdate();
                    //myStmt.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    String extension = FilenameUtils.getExtension(lbrutaarchivo.getText());
                    PreparedStatement pst = cn.prepareStatement("UPDATE catalogo_informacion_rapida SET extension_archivo='" + extension + "' where codigo='" + codigo + "' ");
                    pst.executeUpdate();
                    pst.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
                
                
            }
            else 
            {
                btnverarchivo.setEnabled(false);
                btncargararchivo.setEnabled(true);
                btneliminararchivo.setEnabled(false);
            }

        }
        
        datos();
        
        
        
        
        
    }//GEN-LAST:event_btncargararchivoActionPerformed

    private void btneliminararchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminararchivoActionPerformed

        int result = JOptionPane.showConfirmDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Desea Eliminar esta Archivo permanentemente?", null, JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) 
        {

            String codigo = txtcodigo.getText();
            String descripcion = txtdescripcion.getText();
        
            String existe = "";
            String SQL = "SELECT codigo,detalle FROM catalogo_informacion_rapida where codigo = '" + codigo + "' and descripcion = '" + descripcion + "' ";

            try {
                Statement st1 = cn.createStatement();
                ResultSet rs1 = st1.executeQuery(SQL);
                if (rs1.next()) 
                {
                    Object codigoobject = rs1.getString(1);
                    
                    if (codigoobject == null || codigoobject.equals("") ||codigoobject.equals(" ")) 
                    {
                        existe = "no";
                    } 
                    else 
                    {
                        existe = "si";
                    }

                }
                rs1.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }

            if (existe.equals("si")) 
            {

                try {

                    PreparedStatement pst = cn.prepareStatement("UPDATE catalogo_informacion_rapida SET archivo=NULL, extension_archivo=NULL WHERE codigo='" + codigo + "' and descripcion = '" + descripcion + "'   ");
                    pst.executeUpdate();
                    pst.close();
                    
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
                
                btnverarchivo.setEnabled(false);

            }
            
            else 
            
            {

                Object archivo = lbrutaarchivo.getText();
                if (archivo == null || archivo.equals("")) {

                } else {
                    lbrutaarchivo.setText("");
                    btnverarchivo.setEnabled(false);

                }

            }

        }

        datos();

    }//GEN-LAST:event_btneliminararchivoActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    
    }//GEN-LAST:event_formWindowOpened

    private void txtdescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdescripcionActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new informacionrapidaeditar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btncargararchivo;
    public static javax.swing.JButton btneliminararchivo;
    public static javax.swing.JButton btnguardar;
    private javax.swing.JButton btnsalir;
    public static javax.swing.JButton btnverarchivo;
    private javax.swing.JComboBox<String> cbarea;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbletiquetanombre;
    private javax.swing.JLabel lbletiquetanombre2;
    private javax.swing.JLabel lbrutaarchivo;
    public static javax.swing.JTextArea txtareadetalle;
    public static javax.swing.JTextField txtcod;
    public static javax.swing.JTextField txtcodigo;
    public static javax.swing.JTextField txtdescripcion;
    // End of variables declaration//GEN-END:variables
    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();

}
