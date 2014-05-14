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
    }

}
