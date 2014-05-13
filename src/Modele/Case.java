package Modele;

import java.awt.*;
import javax.swing.*;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Dylan
 */
public class Case extends JPanel {
    
    private int x;
    private int y;
    private Color etat;
    
    public Case(){
        etat = Color.BLUE;
        this.setBackground(etat);
    }
    public Case(int x, int y){
        this.x = x;
        this.y = y;
        this.etat = Color.WHITE;
    }
    
    public Case(){
        super();
        setBackground(Color.WHITE);
    }
    
    
    
    
}
