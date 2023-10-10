
package sistemabordadores;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class bordadosreportegeneralColorear extends DefaultTableCellRenderer{

    private int colorear ;
    
    public static final Color rojo = new Color(255, 128, 128);
     public static final Color anaranjado = new Color(255,166,77);


    public bordadosreportegeneralColorear(int colorear)
    {
        this.colorear = colorear;
    
        
    }
    
    
         
    

    @Override
    public Component getTableCellRendererComponent ( JTable table, Object value, boolean selected, boolean focused, int row, int column )
    {        
        
       
        
        
        
        setBackground(Color.white);
        table.setForeground(Color.black);
        
        
        
        Object color =table.getValueAt(row,2);
        
       
       
        //////
       
     
       
        
           if(color.equals("rojo"))
        {
            
             setBackground(rojo);    
         
          
        }
        
       
        

        super.getTableCellRendererComponent(table, value, selected, focused, row, column);
        return this;
 }

}
