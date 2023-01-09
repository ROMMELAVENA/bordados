/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemabordadores;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;

/**
 *
 * @author Mouse
 */
public class ordencamisaimagen extends javax.swing.JPanel {

    public ordencamisaimagen(){    
        this.setSize(800,800);
    }
        
    @Override
    public void paint(Graphics g){
        Dimension tamanio = getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/img/camisacontornoframe.jpg"));       
        g.drawImage(imagenFondo.getImage(),0,0,550, 550, null);        
        setOpaque(false);
        super.paintComponent(g);
    }    
}

