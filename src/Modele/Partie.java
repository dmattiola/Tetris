/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dylan
 */
public class Partie extends Thread implements Runnable {

    private Piece pieceCourante;
    private Piece pieceSuivante;
    private Grille grille;

    public Partie() {
        pieceCourante = new Piece();
        pieceSuivante = new Piece();
        grille = new Grille();
    }

    public void run() {
        while (true) {
            if(!(pieceCourante.bloquer_bas(getGrille().getGrille()))) {
                try {
                    sleep(1000);
                    pieceCourante.decale_bas(getGrille().getGrille());
                    pieceCourante.efface_ligne(getGrille().getGrille());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Partie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                pieceCourante.efface_ligne(getGrille().getGrille());
                this.pieceCourante = getPieceSuivante();
                this.setPieceSuivante(new Piece());
            }
        }
    }

    /**
     * @return the grille
     */
    public Grille getGrille() {
        return grille;
    }

    /**
     * @param grille the grille to set
     */
    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    /**
     * @return the pieceSuivante
     */
    public Piece getPieceSuivante() {
        return pieceSuivante;
    }

    /**
     * @param pieceSuivante the pieceSuivante to set
     */
    public void setPieceSuivante(Piece pieceSuivante) {
        this.pieceSuivante = pieceSuivante;
    }
    
}
