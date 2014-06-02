package Modele;

import Vue.Fenetre;
import java.util.logging.*;

/**
 * Classe partie : gère la partie de Tétris - utilisation du Thread
 * @author Dylan Jérémy
 */
public class Partie extends Thread implements Runnable {

    private Piece pieceCourante;
    private Piece pieceSuivante;
    private Grille grille;
    private boolean mettreEnPause;
    private boolean fin;
    private int cheat = 0;

    /**
     * Constructeur de partie
     */
    public Partie() {
        this.pieceCourante = new Piece();
        this.pieceSuivante = new Piece();
        this.grille = new Grille();
        this.mettreEnPause = false;
        this.fin = false;
    }

    /**
     * Methode lancée par le thread, gère la partie
     */
    public synchronized void run() {
        int temps;
        this.grille.setScore(this.grille.getScore() + 1);   // des qu'une piece est placée sur le plateau, on augmente le score de 1
        // tant que la partie n'est pas finie
        while (!this.isFin()) { 
            // est ce qu'on triche ???
            if (this.cheat != 0) { 
                this.setPieceSuivante(new Piece(cheat));
            }
            // on ajoute la piece à la grille
            this.grille.ajoute_piece(this.getPieceCourante());
            // est ce qu'on est en pause ??
            if (this.mettreEnPause) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Partie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            // si la piece peut descendre d'un coup (cette methode supprime la piece de la grille sans la remettre)
            if (!(this.grille.bloquer_bas(this.pieceCourante))) {
                try {
                    // on rajoute donc la piece et on la décale
                    this.grille.ajoute_piece(this.getPieceCourante());
                    this.grille.decale_bas(this.getPieceCourante());
                    // definition level avec level max
                    if (this.grille.getLevel() < 19) {
                        temps = 1000 - 50 * this.grille.getLevel();
                    } else {
                        temps = 100;
                    }
                    // on fait patienter le thread
                    Thread.currentThread().sleep(temps);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Partie.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                // si la piece ne peut pas descendre alors on teste la fin de partie
                if (!this.grille.fin_partie()) {
                    // si c'est pas la fin, le score augmente, on rajoute la piece, et on teste si des lignes ont été faites
                    this.grille.setScore(this.grille.getScore() + 1);
                    this.grille.ajoute_piece(this.getPieceCourante());
                    this.grille.efface_ligne(this.getPieceCourante());
                    this.setPieceCourante(this.getPieceSuivante());
                    if (this.cheat != 0) {
                        this.setPieceSuivante(new Piece(cheat));
                    } else {
                        this.setPieceSuivante(new Piece());
                    }

                } else {
                    // si c'est la fin de la partie, on arrete tout !
                    this.setFin(true);
                    this.setPieceCourante(null);
                    Thread.currentThread().stop();
                }
            }
        }
    }

    /**
     * Methode qui met l'attribut mettreEnPause à true
     */
    public void Pause() {
        this.mettreEnPause = true;
    }

    /**
     * Methode synchronized apellée pour terminer la pause et notifier au thread qu'il faut repartir
     */
    public synchronized void TerminerPause() {
        this.mettreEnPause = false;
        notify();
    }

    /**
     *
     * @param cheat
     */
    public void setCheat(int cheat) {
        this.cheat = cheat;
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
