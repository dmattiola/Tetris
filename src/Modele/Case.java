package Modele;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author Dylan
 */
public class Case extends JPanel {
    
    private int x;
    private int y;
    private Color etat;
    
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
