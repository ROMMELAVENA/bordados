
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
           
        bordadosdelclienteeditarnuevo ventana = new bordadosdelclienteeditarnuevo();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        
        
        bordadosdelclienteeditarnuevo.lbcliente.setText(bordadosdelclientecatalogo.cbcomboclientes.getSelectedItem().toString());
        bordadosdelclienteeditarnuevo.lbnombrecomercial.setText(bordadosdelclientecatalogo.lbnombrecomercial.getText());
        bordadosdelclienteeditarnuevo.lbcodigocliente.setText(bordadosdelclientecatalogo.lbcodigocliente.getText());
        bordadosdelclienteeditarnuevo.txtidentificadordeprenda.setText(nombre.toString());
       
       
       if(prenda.equals("CAMISA"))
       {
       
           bordadosdelclienteeditarnuevo.lbprenda.setText("CAMISA");
       }
        
       //// playera
       
       else if(prenda.equals("PLAYERA"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("PLAYERA");
        
       }
      
       /// CAMISOLA
        else if(prenda.equals("CAMISOLA"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("CAMISOLA");
        
       }
      
       
       /// CHAMARRA DESMONTABLE
        else if(prenda.equals("CHAMARRA DESMONTABLE"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("CHAMARRA DESMONTABLE");
        
       }
       
       
       else if(prenda.equals("CHAMARRA ROMPEVIENTOS"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("CHAMARRA ROMPEVIENTOS");
         
       }
      
       
       ////////filipina
       else if(prenda.equals("FILIPINA"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("FILIPINA");
           
       }
      
    
       /// saco

        else if(prenda.equals("SACO"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("SACO");
         
       }
      
       
       //// GORRA

       
       else if(prenda.equals("GORRA"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("GORRA");
        
       }
       
       
       
       //// PANTALON

       else if(prenda.equals("PANTALON"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("PANTALON");
         
       }
      
       
       //CORBATA
        else if(prenda.equals("CORBATA"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("CORBATA");
         
       }
       
        
          //PARCHE
        else if(prenda.equals("PARCHE"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("PARCHE");
         
       }
       
       //// CHALECO
       
        else if(prenda.equals("CHALECO"))
       {
           bordadosdelclienteeditarnuevo.lbprenda.setText("CHALECO");
        
       }
      
       
         else 
       {
           
           if (!prenda.equals("TODOS"))
               
           {
               
           bordadosdelclienteeditardistinta.lbtipo.setText("DISTINTA");
           bordadosdelclienteeditardistinta.cbprenda.setSelectedItem(nombre.toString());
           bordadosdelclienteeditardistinta.lbanuncio.setText(nombre.toString());
           
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
