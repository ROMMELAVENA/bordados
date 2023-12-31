
package sistemabordadores;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.JOptionPane;
import java.sql.Connection;



public class bordadosdelclientecatalogoVer extends AbstractCellEditor implements TableCellEditor, ActionListener {
    
    Boolean currentValue;
    JButton button;
    protected static final String EDIT = "edit";
    private JTable jTable1;
    
    String descripcion = "";
    String tipo = "";
    String prendafotomontaje = "";
    String nombreprendafotomontaje = "";
    Object numeroconsecutivo ="";

    public bordadosdelclientecatalogoVer(JTable jTable1) {
        button = new JButton();
        button.setActionCommand(EDIT);
        button.addActionListener(this);
        button.setBorderPainted(true);
        this.jTable1 = jTable1;
    }

    public void actionPerformed(ActionEvent e) {
        
        
        //// este es el boton ver
        
       int filaseleccionada = this.jTable1.getSelectedRow();
       Object prendatabla = this.jTable1.getValueAt(filaseleccionada, 0);
       Object prendacombo = bordadosdelclientecatalogo.cbprenda.getSelectedItem();
       Object nombrebordado ="";
       
       ////////////////////////////////////       
     
        
        if(prendacombo.equals("TODOS"))
    {
        prendatabla = bordadosdelclientecatalogo.tabla.getValueAt(filaseleccionada, 0);   
        nombrebordado = bordadosdelclientecatalogo.tabla.getValueAt(filaseleccionada, 1);
        numeroconsecutivo = bordadosdelclientecatalogo.tabla.getValueAt(filaseleccionada, 18);
        
       
    }
    else if(prendacombo.equals("PARCHE")||prendacombo.equals("CORBATA")||prendacombo.equals("PANTALON")||prendacombo.equals("CAMISA")||prendacombo.equals("PLAYERA")||prendacombo.equals("CAMISOLA")||prendacombo.equals("CHAMARRA DESMONTABLE")||prendacombo.equals("CHAMARRA ROMPEVIENTOS")||prendacombo.equals("FILIPINA")||prendacombo.equals("SACO")   ||prendacombo.equals("MANDIL")  ||prendacombo.equals("CHALECO"))
    {
           prendatabla = prendacombo;//bordadosdelclientecatalogo.tabla.getValueAt(filaseleccionada, 0);
            numeroconsecutivo = bordadosdelclientecatalogo.tabla.getValueAt(filaseleccionada, 11); 
    }
     else if(prendacombo.equals("GORRA"))
    {
             prendatabla = prendacombo;//r
             bordadosdelclientecatalogo.tabla.getValueAt(filaseleccionada, 0);
            numeroconsecutivo = bordadosdelclientecatalogo.tabla.getValueAt(filaseleccionada, 8);
    }    
        
        
         
         
        
         if (prendatabla.equals("BABERO")||prendatabla.equals("BATA")||prendatabla.equals("BLUSA")||prendatabla.equals("BOLSA DE MANO")||prendatabla.equals("BOTA DE NAVIDAD")
            ||prendatabla.equals("BUFANDA")||prendatabla.equals("CINTA")||prendatabla.equals("COBIJA")||prendatabla.equals("FALDA")||prendatabla.equals("FUNDA PARA ALMOHADA")
            ||prendatabla.equals("GORRO DE NATACION")||prendatabla.equals("JUMPER")||prendatabla.equals("KARATEGUI ")||prendatabla.equals("LAPICERA")||prendatabla.equals("LONCHERA")
            ||prendatabla.equals("MANTEL")||prendatabla.equals("MOCHILA")||prendatabla.equals("MO�O")||prendatabla.equals("OVEROL ")||prendatabla.equals("PANTS")
            ||prendatabla.equals("PASAMONTA�AS")||prendatabla.equals("PORTA TRAJE ")||prendatabla.equals("SHORT")||prendatabla.equals("SLEEPING")||prendatabla.equals("SUDADERA")
            ||prendatabla.equals("SU�TER")||prendatabla.equals("TELA")||prendatabla.equals("TOALLA")||prendatabla.equals("TRAJE DE BA�O")) 
        {
            
            bordadoseditardistinta ventana = new bordadoseditardistinta();
        ventana.setVisible(true);
        
        ventana.setLocationRelativeTo(null);
        bordadoseditardistinta.lbcliente.setText(bordadosdelclientecatalogo.cbcomboclientes.getSelectedItem().toString());
        bordadoseditardistinta.lbnombrecomercial.setText(bordadosdelclientecatalogo.cbnombrecomercial.getSelectedItem().toString());
        bordadoseditardistinta.lbcodigocliente.setText(bordadosdelclientecatalogo.lbcodigocliente.getText());
        bordadoseditardistinta.txtidentificador.setText(nombrebordado.toString());
        bordadoseditardistinta.txtconsecutivo.setText(numeroconsecutivo.toString());
        bordadoseditardistinta.lbprenda.setText(prendatabla.toString());
        bordadoseditardistinta.lbanuncio.setText("DISTINTA");
        bordadoseditardistinta.lbtipo.setText(prendatabla.toString());
            
            
            
        }
        else
        {
   
              if (bordadoseditar.ventanabordadosdelclienteeditar) 
              
          {
          JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">La ventana de bordados del cliente editar ya est� abierta");
          }
          else
              
          {
              
              
          
           
        bordadoseditar ventana = new bordadoseditar();
        ventana.setVisible(true);
        ventana.setLocationRelativeTo(null);
        bordadoseditar.lbcliente.setText(bordadoseditar.lbcliente.getText());
        bordadoseditar.lbnombrecomercial.setText(bordadoseditar.lbnombrecomercial.getText());
        bordadoseditar.lbcodigocliente.setText(bordadoseditar.lbcodigocliente.getText());
        bordadoseditar.txtidentificador.setText(nombrebordado.toString());
        bordadoseditar.txtcodigocatalogobordados.setText(numeroconsecutivo.toString());
        
              if (prendacombo.equals("TODOS")) {
                  bordadoseditar.lbprenda.setText(prendatabla.toString());

              }
              else
              {
                  bordadoseditar.lbprenda.setText(prendacombo.toString());
              }   
      
       
       } 
              
              
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
        if (column == 3) {
            //currentValue = (Boolean) value;
            return button;
        }
         if (column == 4) {
            //currentValue = (Boolean) value;
            return button;
        }
        return new JLabel();
    }
    
    coneccionlocal cc = new coneccionlocal();
    Connection cn = cc.conexion();
    
}
