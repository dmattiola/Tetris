/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author Dylan
 */
public class Case extends JPanel{
    
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
    }
    
    
}
