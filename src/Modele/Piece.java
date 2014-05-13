/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import static Modele.Utilitaire.monRandom;

/**
 *
 * @author Dylan
 */
public class Piece {
    
    private Case[][] tabCase;
    private int x;
    private int y;
    public int [][] PieceCourante =  new int [4][16];
    
    // Piece formant un S
    public int[][] Piece1 = { {0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0},
			  {0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0},
			  {0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0},
			  {0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0} };
    // Piece formant un carré
    public int[][] Piece2 = { {0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},
			  {0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},
			  {0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},
			  {0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0} };
    // Piece formant une barre
    public int[][] Piece3 = { {0,3,0,0,0,3,0,0,0,3,0,0,0,3,0,0},
			  {3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0},
			  {0,3,0,0,0,3,0,0,0,3,0,0,0,3,0,0},
			  {3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0} };
    // Piece formant un Z
    public int[][] Piece4 = { {0,0,4,0,0,4,4,0,0,4,0,0,0,0,0,0},
			  {0,0,0,0,0,4,4,0,0,0,4,4,0,0,0,0},
			  {0,0,4,0,0,4,4,0,0,4,0,0,0,0,0,0},
			  {0,0,0,0,0,4,4,0,0,0,4,4,0,0,0,0} };
    // Piece formant un T
    public int[][] Piece5 = { {0,5,0,0,0,5,5,0,0,5,0,0,0,0,0,0},
			  {0,0,0,0,0,0,5,0,0,5,5,5,0,0,0,0},
			  {0,0,0,5,0,0,5,5,0,0,0,5,0,0,0,0},
			  {0,5,5,5,0,0,5,0,0,0,0,0,0,0,0,0} }; 
    // Piece formant un L inversé
    public int[][] Piece6 = { {0,0,6,0,0,0,6,0,0,6,6,0,0,0,0,0},
			  {0,0,0,0,0,6,6,6,0,0,0,6,0,0,0,0},
			  {0,6,6,0,0,6,0,0,0,6,0,0,0,0,0,0},
			  {0,0,0,0,0,6,0,0,0,6,6,6,0,0,0,0} }; 
    // Piece formant un L
    public int[][] Piece7 = { {0,7,0,0,0,7,0,0,0,7,7,0,0,0,0,0},
			  {0,0,0,0,0,0,0,7,0,7,7,7,0,0,0,0},
			  {0,7,7,0,0,0,7,0,0,0,7,0,0,0,0,0},
			  {0,0,0,0,0,7,7,7,0,7,0,0,0,0,0,0} };  
    
    public void tirer_piece(){
        int numero = monRandom(1,7);
        switch(numero){
            case(1):
                PieceCourante = Piece1;
                break;
            case(2):
                PieceCourante = Piece2;
                break;
            case(3):
                PieceCourante = Piece3;
                break;
            case(4):
                PieceCourante = Piece4;
                break;
            case(5):
                PieceCourante = Piece5;
                break;
            case(6):
                PieceCourante = Piece6;
                break;
            case(7):
                PieceCourante = Piece7;
                break;
        }
    }
    
    public void decale_gauche(int[][] grille){
        y--; // on simule le decalage de la piece d'une case vers la gauche, une colonne en moins
        if(bloque_gauche(grille)){
            y++;
        }
        else{
            efface(grille);
            affiche_piece(grille);
        }
    }
    
    public void decale_droite(int[][] grille){
        y++;
        if(bloque_droite(grille)){
            y--;
        }
        else{
            efface(grille);
            affiche_piece(grille);
        }
    }

    private boolean bloque_droite(int[][] grille) {
        return false;
    }

    private boolean bloque_gauche(int[][] grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void affiche_piece(int[][] grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void efface(int[][] grille) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
