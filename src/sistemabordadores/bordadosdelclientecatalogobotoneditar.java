
package sistemabordadores;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class bordadosdelclientecatalogobotoneditar extends JLabel implements TableCellRenderer{
    
    boolean isBordered = true;

    public bordadosdelclientecatalogobotoneditar(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(false);
    }

    public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
        // Va a mostrar el bot�n solo en la �ltima fila.
        // de otra forma muestra un espacio en blanco.
    
        
        
        
        
         Object tipoobject =bordadosdelclientecatalogo.cbprenda.getSelectedItem();
       
       if(tipoobject.equals("TODOS"))
       {
        
            if (column == 3) {
            return new JButton("Editar");
        } else {
            
            return this;
        }
        
           
       }
       else
       {
        
          if (column == 2) {
            return new JButton("Editar");
        } else {
            
            return this;
        }
        
        
       }
        
        
        
        
        
        
        
        
        
        
        
        
        
      
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
}
