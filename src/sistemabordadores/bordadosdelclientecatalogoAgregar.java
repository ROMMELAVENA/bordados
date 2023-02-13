
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


public class bordadosdelclientecatalogoAgregar extends AbstractCellEditor implements TableCellEditor, ActionListener {
    
    Boolean currentValue;
    JButton button;
    protected static final String EDIT = "edit";
    private JTable jTable1;
    
    String descripcion = "";
    String tipo = "";
    String nombreconcepto ="";
    String tienenumero = "";
    String numero = "";
    
    Object nombreubicacionbordado1 ="";
    Object nombreubicacionbordado2 ="";
    Object nombreubicacionbordado3 ="";
    Object nombreubicacionbordado4 ="";
    Object nombreubicacionbordado5 ="";
    Object nombreubicacionbordado6 ="";
    Object nombreubicacionbordado7 ="";
    

    public bordadosdelclientecatalogoAgregar(JTable jTable1) 
    {
        button = new JButton();
        button.setActionCommand(EDIT);
        button.addActionListener(this);
        button.setBorderPainted(true);
        this.jTable1 = jTable1;
    }

    public void actionPerformed(ActionEvent e) {
        
        
        //// este es el boton agregar
        
       int fila = this.jTable1.getSelectedRow();
       Object tipoobject =bordadosdelclientecatalogo.cbprenda.getSelectedItem();
       Object nombrebordado = "";
       
       if(tipoobject.equals("TODOS"))
       {
         tipoobject =this.jTable1.getValueAt(fila, 0);    
         nombrebordado =this.jTable1.getValueAt(fila, 1);  
         nombreconcepto = nombrebordado.toString();
         tienenumero="no";
       }
       else
       {
         nombrebordado =this.jTable1.getValueAt(fila, 0);   
      
       
      
       nombreubicacionbordado1 =this.jTable1.getValueAt(fila, 4);
        nombreubicacionbordado2 =this.jTable1.getValueAt(fila, 5);
        nombreubicacionbordado3 =this.jTable1.getValueAt(fila, 6);
        nombreubicacionbordado4 =this.jTable1.getValueAt(fila, 7);
        nombreubicacionbordado5 =this.jTable1.getValueAt(fila, 8);
        nombreubicacionbordado6 =this.jTable1.getValueAt(fila, 9);
        nombreubicacionbordado7 =this.jTable1.getValueAt(fila, 10);
       
       
       nombreconcepto = nombrebordado.toString();

           for(int i = 0; i < 8;i ++)
           {
               
               
               if( i == 0)
               {
                   numero = nombrebordado.toString();
               }
               
               else if( i == 4)
               {
                   numero = nombreubicacionbordado1.toString();
               }
               else if( i == 5)
               {
                   numero = nombreubicacionbordado2.toString();
               }
               else if( i == 6)
               {
                   numero = nombreubicacionbordado3.toString();
               }
               else if( i == 7)
               {
                   numero = nombreubicacionbordado4.toString();
               }
                else if( i == 8)
               {
                   numero = nombreubicacionbordado5.toString();
               }
                else if( i == 9)
               {
                   numero = nombreubicacionbordado6.toString();
               }
                else if( i == 10)
               {
                   numero = nombreubicacionbordado7.toString();
               }
               
               
               cadenatienenumero((String) numero);
               
               if(tienenumero.equals("si") && i == 0 )
               {
                 JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Los nombres de la ubicaciones no pueden tener solo n�meros");
                 break;
               }
               
               else if(tienenumero.equals("si"))
               {
                 JOptionPane.showMessageDialog(null, "<HTML><b style=\"Color:red; font-size:20px;\">Los nombres de la ubicaciones no pueden tener solo n�meros");  
                 break;
               
               }
               
               
           }
            
        }
      //////////    
        
       if(tienenumero.equals("no"))
       {
        
       
       if(tipoobject.equals("CAMISA"))
       {
           descripcion = "CAMISA";
           tipo ="CAMISA";
           
       }

       else if(tipoobject.equals("PLAYERA"))
       {
           descripcion = "PLAYERA";
           tipo ="PLAYERA";
       }

       /// CAMISOLA
        else if(tipoobject.equals("CAMISOLA"))
       {
           descripcion = "CAMISOLA";
           tipo ="CAMISOLA";
       }
        
      
       
       /// CHAMARRA DESMONTABLE
        else if(tipoobject.equals("CHAMARRA DESMONTABLE"))
       {
           descripcion = "CHAMARRA DESMONTABLE";
           tipo ="CHAMARRA DESMONTABLE";
       }
      
       /// CHAMARRA DESMONTABLE
       
       else if(tipoobject.equals("CHAMARRA ROMPEVIENTOS"))
       {
           descripcion = "CHAMARRA ROMPEVIENTOS";
           tipo ="CHAMARRA ROMPEVIENTOS";
       }
      
       
       ////////filipina
       else if(tipoobject.equals("FILIPINA"))
       {
           descripcion = "FILIPINA";
           tipo ="FILIPINA";
       }
        else if(tipoobject.equals("SACO"))
       {
           descripcion = "SACO";
           tipo ="SACO";
       }

       else if(tipoobject.equals("GORRA"))
       {
           descripcion = "GORRA";
           tipo ="GORRA";
       }

       else if(tipoobject.equals("PANTALON"))
       {
           descripcion = "PANTALON";
           tipo ="PANTALON";
       }

        else if(tipoobject.equals("CORBATA"))
       {
           descripcion = "CORBATA";
           tipo ="CORBATA";
       }
        
         else if(tipoobject.equals("PARCHE"))
       {
           descripcion = "PARCHE";
           tipo ="PARCHE";
       }
         

        else if(tipoobject.equals("CHALECO"))
       {
           descripcion = "CHALECO";
           tipo ="CHALECO";
       }
      
 else 
       {
           descripcion = tipoobject.toString();
           tipo =tipoobject.toString();
       }
       
       ////////////////////////////////////

       }
        /// 
         
       
        
    }

    //Implement the one CellEditor method that AbstractCellEditor doesn't.
    public Object getCellEditorValue() {
        return currentValue;
    }

    //Implement the one method defined by TableCellEditor.
  //  public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
    
        // Va a mostrar el bot�n solo en la �ltima fila.
        // de otra forma muestra un espacio en blanco.
        if (column == 1) {
           // currentValue = (Boolean) value;
            return button;
        }
        
         if (column == 2) {
           // currentValue = (Boolean) value;
            return button;
        }
         
         
        return new JLabel();
    }
    
    
    public boolean cadenatienenumero(String numero){
    
        try{
        Double.parseDouble(numero);
        tienenumero ="si";
        return true;
        
    }catch(NumberFormatException e){
        tienenumero="no";
        return false;
        
    }
}
    
}
