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
        this.pieceCourante = new Piece();
        this.pieceSuivante = new Piece();
        this.grille = new Grille();
    }

    public void run() {
        while (true) {
            this.grille.ajoute_piece(this.getPieceCourante());
            
            if(!(this.grille.bloquer_bas(this.pieceCourante))) {
                try {
                    this.grille.ajoute_piece(this.getPieceCourante());
                    int temps = 1000-100*this.grille.getLevel();
                    Thread.currentThread().sleep(temps);
                    this.grille.decale_bas(this.getPieceCourante());
                } catch (InterruptedException ex) {
                    Logger.getLogger(Partie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                this.grille.ajoute_piece(this.getPieceCourante());
                this.grille.efface_ligne(this.getPieceCourante());
                this.setPieceCourante(this.getPieceSuivante());
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

    /**
     * @return the pieceCourante
     */
    public Piece getPieceCourante() {
        return pieceCourante;
    }

    /**
     * @param pieceCourante the pieceCourante to set
     */
    public void setPieceCourante(Piece pieceCourante) {
        this.pieceCourante = pieceCourante;
    }

    
}
