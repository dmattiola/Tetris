/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Color;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jérémy
 */
public class Partie extends Thread implements Runnable {

    private Piece piece;
    private Grille grille;

    public Partie() {
        piece = new Piece();
        grille = new Grille();
    }

    public void run() {
        while (true) {
            grille.mettreAJourGrille(this.piece);
            if(!(piece.bloquer_bas(grille.getGrille()))) {
                try {
                    sleep(300);
                    piece.decale_bas(grille.getGrille());
                    grille.mettreAJourGrille(this.piece);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Partie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                this.piece = new Piece();
            }
        }
    }

}
