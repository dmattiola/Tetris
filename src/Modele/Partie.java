/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import Vue.Fenetre;
import java.util.logging.*;

/**
 *
 * @author Dylan
 */
public class Partie extends Thread implements Runnable {

    private Piece pieceCourante;
    private Piece pieceSuivante;
    private Grille grille;
    private boolean mettreEnPause;
    private boolean fin;

    public Partie() {
        this.pieceCourante = new Piece();
        this.pieceSuivante = new Piece();
        this.grille = new Grille();
        this.mettreEnPause = false;
        this.fin = false;
    }

    public synchronized void run() {
        int temps;
        this.grille.setScore(this.grille.getScore()+1); // des qu'une piece est placée sur le plateau, on augmente le score de 1
        while (!this.isFin()) {
            this.grille.ajoute_piece(this.getPieceCourante());
            if(this.mettreEnPause){
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Partie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (!(this.grille.bloquer_bas(this.pieceCourante))) {
                try {
                    this.grille.ajoute_piece(this.getPieceCourante());
                    this.grille.decale_bas(this.getPieceCourante());
                    // definition level avec level max
                    if(this.grille.getLevel()<19){
                        temps = 1000 - 50 * this.grille.getLevel();
                    }
                    else {
                        temps = 900;
                    }
                    Thread.currentThread().sleep(temps);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Partie.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                if (!this.grille.fin_partie()) {
                    this.grille.setScore(this.grille.getScore()+1);
                    this.grille.ajoute_piece(this.getPieceCourante());
                    this.grille.efface_ligne(this.getPieceCourante());
                    this.setPieceCourante(this.getPieceSuivante());
                    this.setPieceSuivante(new Piece());
                }
                else{
                    this.setFin(this.grille.fin_partie());
                    this.setPieceCourante(null);
                    Thread.currentThread().stop();
                }
            }
        }
    }
    
    public void Pause(){
        this.mettreEnPause = true;
    }
    
    public synchronized void TerminerPause(){
        this.mettreEnPause = false;
        notify();
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

    /**
     * @return the mettreEnPause
     */
    public boolean isMettreEnPause() {
        return mettreEnPause;
    }

    /**
     * @param mettreEnPause the mettreEnPause to set
     */
    public void setMettreEnPause(boolean mettreEnPause) {
        this.mettreEnPause = mettreEnPause;
    }

    /**
     * @return the fin
     */
    public boolean isFin() {
        return fin;
    }

    /**
     * @param fin the fin to set
     */
    public void setFin(boolean fin) {
        this.fin = fin;
    }
}
