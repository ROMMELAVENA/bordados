
package sistemabordadores;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;


public class bordadosdelclientecatalogobotonver extends JLabel implements TableCellRenderer{
    
    boolean isBordered = true;

    public bordadosdelclientecatalogobotonver(boolean isBordered) {
        this.isBordered = isBordered;
        setOpaque(false);
    }

    public Component getTableCellRendererComponent(JTable table, Object color, boolean isSelected, boolean hasFocus, int row, int column) {
        // Va a mostrar el bot�n solo en la �ltima fila.
        // de otra forma muestra un espacio en blanco.
    
        
        
        Object tipoobject =bordadosdelclientecatalogo.cbprenda.getSelectedItem();
       
       if(tipoobject.equals("TODOS"))
       {
        
          if (column == 4) {
            return new JButton("Ver");
        } else {
            
            return this;
        }
        
           
       }
       else
       {
        
          if (column == 3) {
            return new JButton("Ver");
        } else {
            
            return this;
        }
        
         
        
       }
        
        
        
        
      
    }
    
    
}
