
package sistemabordadores;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class Colorear extends DefaultTableCellRenderer{

    private int realizado ;
    private int fila ;

    public Colorear()
    {
       
    }
    
    
    
    

    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {        
        setBackground(Color.white);
        table.setForeground(Color.black);
       
        Object tablanombre =table.getValueAt(row,10);
        Object lugar =table.getValueAt(row,4);
               
        
        if( tablanombre.equals("Recibida") && lugar.equals("Otra sucursal") )
        {
            setBackground(Color.yellow.brighter());
            
        }
        
        
        

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
 }

}
