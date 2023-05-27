
package sistemabordadores;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;


public class bordadosdelclientecatalogoEditar extends AbstractCellEditor implements TableCellEditor, ActionListener {
    
    Boolean currentValue;
    JButton button;
    protected static final String EDIT = "edit";
    private JTable jTable1;

    public bordadosdelclientecatalogoEditar(JTable jTable1) {
        button = new JButton();
        button.setActionCommand(EDIT);
        button.addActionListener(this);
        button.setBorderPainted(true);
        this.jTable1 = jTable1;
    }

    public void actionPerformed(ActionEvent e) {
        
       //// este es el boton editar 
        
        
       int fila = this.jTable1.getSelectedRow();
        
       
       if(fila < 0)
       {
         javax.swing.JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Seleccione una fila");  
       }
       else
       {    
      
           
       Object nombre = this.jTable1.getValueAt(fila, 0);
       Object prenda = bordadosdelclientecatalogo.cbprenda.getSelectedItem();
       
     
        if(prenda == null || prenda.equals("")|| prenda.equals(" "))   
        {
            
        }  
          else
        {    
           
        bordadosdelclienteeditar ventana = new bordadosdelclienteeditar();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
        
        bordadosdelclienteeditar.lbcliente.setText(bordadosdelclientecatalogo.cbcomboclientes.getSelectedItem().toString());
        bordadosdelclienteeditar.lbnombrecomercial.setText(bordadosdelclientecatalogo.cbnombrecomercial.getSelectedItem().toString());
        bordadosdelclienteeditar.lbcodigocliente.setText(bordadosdelclientecatalogo.lbcodigocliente.getText());
        bordadosdelclienteeditar.txtidentificador.setText(nombre.toString());
       
       
       if(prenda.equals("CAMISA"))
       {
       
           bordadosdelclienteeditar.lbprenda.setText("CAMISA");
       }
        
       //// playera
       
       else if(prenda.equals("PLAYERA"))
       {
           bordadosdelclienteeditar.lbprenda.setText("PLAYERA");
        
       }
      
       /// CAMISOLA
        else if(prenda.equals("CAMISOLA"))
       {
           bordadosdelclienteeditar.lbprenda.setText("CAMISOLA");
        
       }
      
       
       /// CHAMARRA DESMONTABLE
        else if(prenda.equals("CHAMARRA DESMONTABLE"))
       {
           bordadosdelclienteeditar.lbprenda.setText("CHAMARRA DESMONTABLE");
        
       }
       
       
       else if(prenda.equals("CHAMARRA ROMPEVIENTOS"))
       {
           bordadosdelclienteeditar.lbprenda.setText("CHAMARRA ROMPEVIENTOS");
         
       }
      
       
       ////////filipina
       else if(prenda.equals("FILIPINA"))
       {
           bordadosdelclienteeditar.lbprenda.setText("FILIPINA");
           
       }
      
    
       /// saco

        else if(prenda.equals("SACO"))
       {
           bordadosdelclienteeditar.lbprenda.setText("SACO");
         
       }
      
       
       //// GORRA

       
       else if(prenda.equals("GORRA"))
       {
           bordadosdelclienteeditar.lbprenda.setText("GORRA");
        
       }
       
       
       
       //// PANTALON

       else if(prenda.equals("PANTALON"))
       {
           bordadosdelclienteeditar.lbprenda.setText("PANTALON");
         
       }
      
       
       //CORBATA
        else if(prenda.equals("CORBATA"))
       {
           bordadosdelclienteeditar.lbprenda.setText("CORBATA");
         
       }
       
        
          //PARCHE
        else if(prenda.equals("PARCHE"))
       {
           bordadosdelclienteeditar.lbprenda.setText("PARCHE");
         
       }
       
       //// CHALECO
       
        else if(prenda.equals("CHALECO"))
       {
           bordadosdelclienteeditar.lbprenda.setText("CHALECO");
        
       }
      
       
         else 
       {
           
           if (!prenda.equals("TODOS"))
               
           {
               
           bordadoseditardistinta.lbtipo.setText("DISTINTA");
           bordadoseditardistinta.lbprenda.setText(nombre.toString());
           bordadoseditardistinta.lbanuncio.setText(nombre.toString());
           
           }
       }
       
       } 
       
   //    }
    
    }
    }   

    //Implement the one CellEditor method that AbstractCellEditor doesn't.
    public Object getCellEditorValue() {
        return currentValue;
    }

    //Implement the one method defined by TableCellEditor.
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // Va a mostrar el bot�n solo en la �ltima fila.
        // de otra forma muestra un espacio en blanco.
        if (column == 2) {
           // currentValue = (Boolean) value;
            return button;
        }
        
         if (column == 3) {
           // currentValue = (Boolean) value;
            return button;
        }
         
         
        return new JLabel();
    }
    
}
