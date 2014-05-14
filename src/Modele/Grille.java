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
    
    public Case getCase(int ligne, int colonne){
        return grille[ligne][colonne];
    }

    public void setCase(Case c, int x, int y) {
        this.grille[x][y] = c;
    }

    /**
     * @param grille the grille to set
     */
    public void setGrille(Case[][] grille) {
        this.grille = grille;
    }

    public void mettreAJourGrille(Piece piece) {
        int x = piece.getX();
        int y = piece.getY();
        int position = piece.getPosition();
        int[] tabPiece = piece.getPiece(position);
        int ligne = x;
        int colonne = y;
        for (int i = 0; i < 17; i++) {            
            if (tabPiece[i] != 0) {
                this.grille[ligne][colonne] = new Case(ligne, colonne, tabPiece[i]);
            }
            if(i%3 == 0){
                ligne++;
                colonne = y;
            }else{
                colonne++;
            }            
        }

    }
    
    public boolean testLigne(){
        
    }

}
