/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

/**
 *
 * @author Dylan
 */
public class Grille {
    
    private Case grille[][];
    private final int hauteur = 20;
    private final int largeur = 10;
    private Piece[][] pieceEnCours;
    private Piece[][] pieceSuivante;

    public Grille() {
        initialiserGrille();
    }

    private void initialiserGrille() {
        setGrille(new Case[hauteur][largeur]);
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                getGrille()[i][j] = new Case(i, j);
            }
        }
    }

    /**
     * @return the grille
     */
    public Case[][] getGrille() {
        return grille;
    }

    /**
     * @param grille the grille to set
     */
    public void setGrille(Case[][] grille) {
        this.grille = grille;
    }

}
