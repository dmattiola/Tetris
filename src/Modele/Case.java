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
    
    private int x; //ligne de la case dans la grille
    private int y; // colonne de la case dans la grille
    private int etat; // donne un entier identifiant la piece présente dans la case ou 0 si la case est inoccupée
    
    public Case(){
        super();
        this.setBackground(Color.BLACK); // Couleur de la case par défaut 
    }
    
    public Case(int x,int y){
        this.x=x;
        this.y=y;
        this.etat = 0;
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
    
    public void ColorierCase(int etat){ // définit le fond d'une case en fonction de son etat
        switch(etat){
            case(0):
                this.setBackground(Color.BLACK);
                break;
            case(1):
                this.setBackground(Color.BLUE);
                break;
            case(2):
                this.setBackground(Color.GREEN);
                break;
            case(3):
                this.setBackground(Color.YELLOW);
                break;
            case(4):
                this.setBackground(Color.ORANGE);
                break;
            case(5):
                this.setBackground(Color.RED);
                break;
            case(6):
                this.setBackground(Color.PINK);
                break;
            case(7):
                this.setBackground(Color.MAGENTA);
                break;
            case(8):
                this.setBackground(Color.GRAY);
                break;
        }
    }

}
