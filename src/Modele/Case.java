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
    
    public Case(int x, int y){
        this.x = x;
        this.y = y;
        this.etat = Color.black;
    }
    
    public Case(){
        super();
        this.setBackground(Color.black);
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the etat
     */
    public Color getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(Color etat) {
        this.etat = etat;
    }
    
    
    
    
}
