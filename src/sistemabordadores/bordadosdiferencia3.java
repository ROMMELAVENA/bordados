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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sistemas
 */
public class bordadosdiferencia3 extends javax.swing.JFrame {

    /**
     * Creates new form bordadosdiferencia
     */
    public bordadosdiferencia3() {
        initComponents();
        datos();
    }
    
    void datos()
    {
        
        DefaultTableModel modelo = (DefaultTableModel) tabla.getModel();
        String[] datos = new String[10];
        String[] datos2 = new String[10];
        String[] datos3 = new String[10];
        String[] datos4 = new String[10];
        String[] datos5 = new String[10];
        String[] datos6 = new String[10];
        String[] datos7 = new String[10];
        String[] datos8 = new String[10];
        String[] datos9 = new String[10];
        String[] datos10 = new String[10];

        
        /// pecho izquierdo
        String sql = "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,pecho_izquierdo_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "PECHO_IZQUIERDO_NOMBRE LIKE '%VERDE%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%DORADO%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%ROJO%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%AMARILLO%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%ANARANJADO%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%BLANCO%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%NEGRO%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%MARINO%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%AZUL%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%GRIS%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%VINO%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%ROSA%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%MORADO%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%CREMA%'\n"
                + "OR PECHO_IZQUIERDO_NOMBRE LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("pecho_izquierdo_nombre");
                datos[3] = "Pecho izquierdo";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        /// pecho derecho
  
        String sql2 = "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,pecho_derecho_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "PECHO_DERECHO_NOMBRE LIKE '%VERDE%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%DORADO%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%ROJO%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%AMARILLO%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%ANARANJADO%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%BLANCO%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%NEGRO%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%MARINO%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%AZUL%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%GRIS%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%VINO%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%ROSA%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%MORADO%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%CREMA%'\n"
                + "OR PECHO_DERECHO_NOMBRE LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql2);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("pecho_derecho_nombre");
                datos[3] = "Pecho derecho";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        
        
         /// manga_derecha
  
        String sql3 = "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,manga_derecha_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "MANGA_DERECHA_NOMBRE LIKE '%VERDE%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%DORADO%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%ROJO%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%AMARILLO%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%ANARANJADO%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%BLANCO%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%NEGRO%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%MARINO%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%AZUL%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%GRIS%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%VINO%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%ROSA%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%MORADO%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%CREMA%'\n"
                + "OR MANGA_DERECHA_NOMBRE LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql3);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("manga_derecha_nombre");
                datos[3] = "Manga derecha";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        
        
        /// manga izquierda
        
         String sql4 = "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,manga_izquierda_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "MANGA_IZQUIERDA_NOMBRE LIKE '%VERDE%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%DORADO%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%ROJO%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%AMARILLO%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%ANARANJADO%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%BLANCO%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%NEGRO%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%MARINO%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%AZUL%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%GRIS%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%VINO%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%ROSA%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%MORADO%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%CREMA%'\n"
                + "OR MANGA_IZQUIERDA_NOMBRE LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql4);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("manga_izquierda_nombre");
                datos[3] = "Manga izquierda";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
          ///espalda
        
         String sql5= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,espalda_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "ESPALDA_NOMBRE LIKE '%VERDE%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%DORADO%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%ROJO%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%AMARILLO%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%ANARANJADO%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%BLANCO%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%NEGRO%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%MARINO%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%AZUL%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%GRIS%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%VINO%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%ROSA%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%MORADO%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%CREMA%'\n"
                + "OR ESPALDA_NOMBRE LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql5);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("espalda_nombre");
                datos[3] = "espalda_puntadas";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        ///otra ubicacion
        
         String sql6= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,otra_ubicacion_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "otra_ubicacion_nombre LIKE '%VERDE%'\n"
                + "OR otra_ubicacion_nombre LIKE '%DORADO%'\n"
                + "OR otra_ubicacion_nombre LIKE '%ROJO%'\n"
                + "OR otra_ubicacion_nombre LIKE '%AMARILLO%'\n"
                + "OR otra_ubicacion_nombre LIKE '%ANARANJADO%'\n"
                + "OR otra_ubicacion_nombre LIKE '%BLANCO%'\n"
                + "OR otra_ubicacion_nombre LIKE '%NEGRO%'\n"
                + "OR otra_ubicacion_nombre LIKE '%MARINO%'\n"
                + "OR otra_ubicacion_nombre LIKE '%AZUL%'\n"
                + "OR otra_ubicacion_nombre LIKE '%GRIS%'\n"
                + "OR otra_ubicacion_nombre LIKE '%VINO%'\n"
                + "OR otra_ubicacion_nombre LIKE '%ROSA%'\n"
                + "OR otra_ubicacion_nombre LIKE '%MORADO%'\n"
                + "OR otra_ubicacion_nombre LIKE '%CREMA%'\n"
                + "OR otra_ubicacion_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql6);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("otra_ubicacion_nombre");
                datos[3] = "Otra ubicacion";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        ///otra ubicacion2
        
         String sql7= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,otra_ubicacion2_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "otra_ubicacion2_nombre LIKE '%VERDE%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%DORADO%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%ROJO%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%AMARILLO%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%ANARANJADO%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%BLANCO%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%NEGRO%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%MARINO%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%AZUL%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%GRIS%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%VINO%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%ROSA%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%MORADO%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%CREMA%'\n"
                + "OR otra_ubicacion2_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql7);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("otra_ubicacion2_nombre");
                datos[3] = "Otra ubicacion2";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        ////gorra
        ///frente
        
        
         String sql8= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,frente_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "frente_nombre LIKE '%VERDE%'\n"
                + "OR frente_nombre LIKE '%DORADO%'\n"
                + "OR frente_nombre LIKE '%ROJO%'\n"
                + "OR frente_nombre LIKE '%AMARILLO%'\n"
                + "OR frente_nombre LIKE '%ANARANJADO%'\n"
                + "OR frente_nombre LIKE '%BLANCO%'\n"
                + "OR frente_nombre LIKE '%NEGRO%'\n"
                + "OR frente_nombre LIKE '%MARINO%'\n"
                + "OR frente_nombre LIKE '%AZUL%'\n"
                + "OR frente_nombre LIKE '%GRIS%'\n"
                + "OR frente_nombre LIKE '%VINO%'\n"
                + "OR frente_nombre LIKE '%ROSA%'\n"
                + "OR frente_nombre LIKE '%MORADO%'\n"
                + "OR frente_nombre LIKE '%CREMA%'\n"
                + "OR frente_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql8);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("frente_nombre");
                datos[3] = "Frente Gorra";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
         ///lado izquierdo
        
        
         String sql9= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,lado_izquierdo_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "lado_izquierdo_nombre LIKE '%VERDE%'\n"
                + "OR lado_izquierdo_nombre LIKE '%DORADO%'\n"
                + "OR lado_izquierdo_nombre LIKE '%ROJO%'\n"
                + "OR lado_izquierdo_nombre LIKE '%AMARILLO%'\n"
                + "OR lado_izquierdo_nombre LIKE '%ANARANJADO%'\n"
                + "OR lado_izquierdo_nombre LIKE '%BLANCO%'\n"
                + "OR lado_izquierdo_nombre LIKE '%NEGRO%'\n"
                + "OR lado_izquierdo_nombre LIKE '%MARINO%'\n"
                + "OR lado_izquierdo_nombre LIKE '%AZUL%'\n"
                + "OR lado_izquierdo_nombre LIKE '%GRIS%'\n"
                + "OR lado_izquierdo_nombre LIKE '%VINO%'\n"
                + "OR lado_izquierdo_nombre LIKE '%ROSA%'\n"
                + "OR lado_izquierdo_nombre LIKE '%MORADO%'\n"
                + "OR lado_izquierdo_nombre LIKE '%CREMA%'\n"
                + "OR lado_izquierdo_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql9);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("lado_izquierdo_nombre");
                datos[3] = "Lado izquierdo Gorra";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        ///lado derecho
        
        
         String sql10= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,lado_derecho_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "lado_derecho_nombre LIKE '%VERDE%'\n"
                + "OR lado_derecho_nombre LIKE '%DORADO%'\n"
                + "OR lado_derecho_nombre LIKE '%ROJO%'\n"
                + "OR lado_derecho_nombre LIKE '%AMARILLO%'\n"
                + "OR lado_derecho_nombre LIKE '%ANARANJADO%'\n"
                + "OR lado_derecho_nombre LIKE '%BLANCO%'\n"
                + "OR lado_derecho_nombre LIKE '%NEGRO%'\n"
                + "OR lado_derecho_nombre LIKE '%MARINO%'\n"
                + "OR lado_derecho_nombre LIKE '%AZUL%'\n"
                + "OR lado_derecho_nombre LIKE '%GRIS%'\n"
                + "OR lado_derecho_nombre LIKE '%VINO%'\n"
                + "OR lado_derecho_nombre LIKE '%ROSA%'\n"
                + "OR lado_derecho_nombre LIKE '%MORADO%'\n"
                + "OR lado_derecho_nombre LIKE '%CREMA%'\n"
                + "OR lado_derecho_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE  ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql10);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("lado_derecho_nombre");
                datos[3] = "Lado derecho Gorra";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
         ///atras
        
        
         String sql11= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,atras_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "atras_nombre LIKE '%VERDE%'\n"
                + "OR atras_nombre LIKE '%DORADO%'\n"
                + "OR atras_nombre LIKE '%ROJO%'\n"
                + "OR atras_nombre LIKE '%AMARILLO%'\n"
                + "OR atras_nombre LIKE '%ANARANJADO%'\n"
                + "OR atras_nombre LIKE '%BLANCO%'\n"
                + "OR atras_nombre LIKE '%NEGRO%'\n"
                + "OR atras_nombre LIKE '%MARINO%'\n"
                + "OR atras_nombre LIKE '%AZUL%'\n"
                + "OR atras_nombre LIKE '%GRIS%'\n"
                + "OR atras_nombre LIKE '%VINO%'\n"
                + "OR atras_nombre LIKE '%ROSA%'\n"
                + "OR atras_nombre LIKE '%MORADO%'\n"
                + "OR atras_nombre LIKE '%CREMA%'\n"
                + "OR atras_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE  ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql11);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("atras_nombre");
                datos[3] = "Atras Gorra";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        ///pantalon
         ///pantalon_lado_izquierdo_frente_puntadas
        
        
         String sql12= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,pantalon_lado_izquierdo_frente_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "pantalon_lado_izquierdo_frente_nombre LIKE '%VERDE%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%DORADO%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%ROJO%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%AMARILLO%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%ANARANJADO%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%BLANCO%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%NEGRO%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%MARINO%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%AZUL%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%GRIS%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%VINO%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%ROSA%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%MORADO%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%CREMA%'\n"
                + "OR pantalon_lado_izquierdo_frente_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql12);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("pantalon_lado_izquierdo_frente_nombre");
                datos[3] = "Pantalon lado izquierdo frente";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        
         ///pantalon_lado_derecho_frente_puntadas
        
        
         String sql13= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,pantalon_lado_derecho_frente_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "pantalon_lado_derecho_frente_nombre LIKE '%VERDE%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%DORADO%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%ROJO%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%AMARILLO%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%ANARANJADO%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%BLANCO%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%NEGRO%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%MARINO%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%AZUL%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%GRIS%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%VINO%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%ROSA%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%MORADO%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%CREMA%'\n"
                + "OR pantalon_lado_derecho_frente_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql13);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("pantalon_lado_derecho_frente_nombre");
                datos[3] = "Pantalon lado derecho frente";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        
        
        ///pantalon_lado_izquierdo_atras_puntadas
        
        
         String sql14= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,pantalon_lado_izquierdo_atras_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "pantalon_lado_izquierdo_atras_nombre LIKE '%VERDE%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%DORADO%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%ROJO%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%AMARILLO%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%ANARANJADO%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%BLANCO%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%NEGRO%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%MARINO%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%AZUL%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%GRIS%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%VINO%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%ROSA%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%MORADO%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%CREMA%'\n"
                + "OR pantalon_lado_izquierdo_atras_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql14);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("pantalon_lado_izquierdo_atras_nombre");
                datos[3] = "Pantalon lado izquierdo atras";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
         ///pantalon_lado_derecho_atras_puntadas
        
        
         String sql15= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,pantalon_lado_derecho_atras_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "pantalon_lado_derecho_atras_nombre LIKE '%VERDE%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%DORADO%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%ROJO%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%AMARILLO%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%ANARANJADO%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%BLANCO%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%NEGRO%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%MARINO%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%AZUL%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%GRIS%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%VINO%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%ROSA%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%MORADO%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%CREMA%'\n"
                + "OR pantalon_lado_derecho_atras_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql15);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("pantalon_lado_derecho_atras_nombre");
                datos[3] = "Pantalon lado derecho atras";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        
        
        ///corbata frente
        
        
         String sql16= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,corbata_frente_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "corbata_frente_nombre LIKE '%VERDE%'\n"
                + "OR corbata_frente_nombre LIKE '%DORADO%'\n"
                + "OR corbata_frente_nombre LIKE '%ROJO%'\n"
                + "OR corbata_frente_nombre LIKE '%AMARILLO%'\n"
                + "OR corbata_frente_nombre LIKE '%ANARANJADO%'\n"
                + "OR corbata_frente_nombre LIKE '%BLANCO%'\n"
                + "OR corbata_frente_nombre LIKE '%NEGRO%'\n"
                + "OR corbata_frente_nombre LIKE '%MARINO%'\n"
                + "OR corbata_frente_nombre LIKE '%AZUL%'\n"
                + "OR corbata_frente_nombre LIKE '%GRIS%'\n"
                + "OR corbata_frente_nombre LIKE '%VINO%'\n"
                + "OR corbata_frente_nombre LIKE '%ROSA%'\n"
                + "OR corbata_frente_nombre LIKE '%MORADO%'\n"
                + "OR corbata_frente_nombre LIKE '%CREMA%'\n"
                + "OR corbata_frente_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql16);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("corbata_frente_nombre");
                datos[3] = "Corbata";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
        } catch (SQLException ex) {
             System.out.println(ex);
        }
        
        
       
        
        ///parche
        
        
         String sql18= "SELECT codigo,numero_consecutivo,nombre,identificador_prenda,tipo,parche_nombre\n"
                + "FROM bordados_puntadas\n"
                + "WHERE \n"
                + "parche_nombre LIKE '%VERDE%'\n"
                + "OR parche_nombre LIKE '%DORADO%'\n"
                + "OR parche_nombre LIKE '%ROJO%'\n"
                + "OR parche_nombre LIKE '%AMARILLO%'\n"
                + "OR parche_nombre LIKE '%ANARANJADO%'\n"
                + "OR parche_nombre LIKE '%BLANCO%'\n"
                + "OR parche_nombre LIKE '%NEGRO%'\n"
                + "OR parche_nombre LIKE '%MARINO%'\n"
                + "OR parche_nombre LIKE '%AZUL%'\n"
                + "OR parche_nombre LIKE '%GRIS%'\n"
                + "OR parche_nombre LIKE '%VINO%'\n"
                + "OR parche_nombre LIKE '%ROSA%'\n"
                + "OR parche_nombre LIKE '%MORADO%'\n"
                + "OR parche_nombre LIKE '%CREMA%'\n"
                + "OR parche_nombre LIKE '%KAKI%'\n"
                + "ORDER BY NOMBRE ";
            
        
        
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql18);
            while (rs.next()) 
            {
                datos[0] = rs.getString("numero_consecutivo");
                datos[1] = rs.getString("nombre");
                datos[2] = rs.getString("parche_nombre");
                datos[3] = "Parche";
                datos[4] = rs.getString("identificador_prenda");
                datos[5] = rs.getString("tipo");

                modelo.addRow(datos);
                
            }
            
            
            
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        btnsalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bordados puntadas color");

        tabla.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Nombre bordado", "ubicacion", "Identificador", "Prenda"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setRowHeight(28);
        jScrollPane1.setViewportView(tabla);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setMinWidth(0);
            tabla.getColumnModel().getColumn(0).setPreferredWidth(0);
            tabla.getColumnModel().getColumn(0).setMaxWidth(0);
        }

        btnsalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnsalir.setText("Salir");
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(1128, 1128, 1128)
                .addComponent(btnsalir, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(127, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnsalir, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 676, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
      this.dispose();
    }//GEN-LAST:event_btnsalirActionPerformed

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
            java.util.logging.Logger.getLogger(bordadosdiferencia3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bordadosdiferencia3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bordadosdiferencia3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bordadosdiferencia3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bordadosdiferencia3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables

coneccionlocal cc = new coneccionlocal();
Connection cn = cc.conexion();

}
