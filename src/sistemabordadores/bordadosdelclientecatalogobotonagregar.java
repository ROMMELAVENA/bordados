/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabordadores;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author sistemas
 */
public class bordadosdelclientecatalogobotonagregar extends JLabel implements TableCellRenderer{
    
    boolean isBordered = true;

    public bordadosdelclientecatalogobotonagregar(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(false);
    }

    public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
        // Va a mostrar el bot�n solo en la �ltima fila.
        // de otra forma muestra un espacio en blanco.
        
        
        
    
         Object tipoobject =bordadosdelclientecatalogo.cbprenda.getSelectedItem();
       
       if(tipoobject.equals("TODOS"))
       {
        
             if (column == 2) {
            return new JButton("Agregar");
        } else {
            
            return this;
        }
           
       }
       else
       {
        
          if (column == 1) {
            return new JButton("Agregar");
        } else {
            
            return this;
        }
        
       }
        
        
      
    }
    
    
}
