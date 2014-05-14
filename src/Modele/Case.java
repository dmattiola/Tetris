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
    private int etat;
    
    public Case(){
        super();
        this.setBackground(Color.black);
    }

    public Case(int x, int y) {
        super();
        this.x=x;
        this.y=y;
        this.etat=0;    
    }
    
    public Case(int x, int y, int color) {
        super();
        this.x=x;
        this.y=y;
        this.etat=color;        
    }

    /**
     * @return the etat
     */
    public int getEtat() {
        return etat;
    }

    /**
     * @param etat the etat to set
     */
    public void setEtat(int etat) {
        this.etat = etat;
        setBackground(attributCouleur(etat));
    }
    
    public Color attributCouleur(int valeur){
        switch(valeur){
            case 0:
                return Color.BLACK;
            case 1 : 
                return Color.BLUE;
            case 2 :
                return Color.GREEN;
            case 3 :
                return Color.RED;
            case 4 :
                return Color.YELLOW;
            default :
                return Color.BLACK;
        }
    }

}
