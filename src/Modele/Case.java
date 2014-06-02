package Modele;

import java.awt.Color;
import javax.swing.JPanel;

/**
 * Classe Case
 * @author Dylan Jérémy
 */
public class Case extends JPanel{
    
    private int x; //ligne de la case dans la grille
    private int y; // colonne de la case dans la grille
    private int etat; // donne un entier identifiant la piece présente dans la case ou 0 si la case est inoccupée
    
    /**
     * Constructeur de Case (utilisé dans la vue)
     */
    public Case(){
        super(); // JPanel
        this.setBackground(Color.BLACK); // Couleur de la case par défaut 
    }
    
    /**
     * Constructeur de la Case : avec état à 0
     * @param x ligne
     * @param y colonne
     */
    public Case(int x,int y){
        this.x=x;
        this.y=y;
        this.etat = 0;
    }


    
    /**
     * Méthode qui Colorie une case de la grille (VUE) en fonction de l'etat de la case
     * @param etat int donnant une couleur : etat de la case
     */
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
