
package sistemabordadores;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;


public class ordencorbataimagen extends javax.swing.JPanel {

    public ordencorbataimagen(){    
        this.setSize(800,800);
    }
        
    @Override
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/img/corbata.jpg"));       
        g.drawImage(imagenFondo.getImage(),0,0,tamanio.width, tamanio.height, null);        
        setOpaque(false);
        super.paintComponent(g);
    }    
}

