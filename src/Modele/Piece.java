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
    private int position;
    public int [][] PieceCourante =  new int [4][16];
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getPosition(){
        return position;
    }
    
    public int[][] getPieceCourant(){
        return PieceCourante;
    }

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

    public Piece(){
        this.x = 23;
        this.y = 3;
        this.PieceCourante = tirer_piece();
        this.position = tirer_position();
        
    }
    
    public int[] getPiece(int position){
        return this.PieceCourante[position];
    }
    
    
    public int tirer_position(){
        return monRandom(1,4);
    }
    public int[][] tirer_piece(){
        int numero = monRandom(1,7);        
        switch(numero){
            case(1):
                return Piece1;
            case(2):
                return Piece2;
            case(3):
                return Piece3;
            case(4):
                return Piece4;
            case(5):
                return Piece5;
            case(6):
                return Piece6;
            case(7):
                return Piece7;
            default:
                return Piece1;
        }
    }

    public void decale_gauche(Case[][] grille){
        y--; // on simule le decalage de la piece d'une case vers la gauche, une colonne en moins
        if(bloque_gauche(grille)){
            y++;
        }
        else{
            efface(grille);
            affiche_piece(grille);
        }
    }

    public void decale_droite(Case[][] grille){
        y++;
        if(bloque_droite(grille)){
            y--;
        }
        else{
            efface(grille);
            affiche_piece(grille);
        }
    }

    public void decale_bas(Case[][] grille){
        x--;
        if(bloquer_bas(grille)){
            x++;
        }
        else{
            efface(grille);
            affiche_piece(grille);
        }
    }

    public void tourner(Case[][] grille){
        efface(grille);
        int ancienne_position = position;
        position ++;
        if (position ==4){
            position=0;
        }
        if (bloque_tourner(grille)){
            position = ancienne_position;
        }
        /*if (bloque(grille)){
            position = ancienne_position;
        }*/
        affiche_piece(grille);
    }

    private boolean bloque_droite(Case[][] grille) {
        boolean bloquer = false;
        for (int i = 0;i<16;i++){
            if(PieceCourante[position][i] != 0){
                int colonne = i % 4;
                int ligne = i / 4;
                if (colonne < 10){
                    bloquer = false;
                }
                else{
                    if(colonne + y + 1 > 9){
                        return true;
                    }
                    else{
                        if(grille[x][y+colonne+1].getEtat()==0){
                            bloquer = false;
                        }
                        else {
                            return true;
                        }
                    }
                }
            }
        }
        return bloquer;
    }

    private boolean bloque_gauche(Case[][] grille) {
        boolean bloquer = false;
        for (int i = 0;i<16;i++){
            if(PieceCourante[position][i] != 0){
                int colonne = i % 4;
                int ligne = i / 4;
                if (colonne > 0){
                    bloquer = false;
                }
                else {
                    if (colonne + y - 1 <0){
                        return true;
                    }
                    else {
                        if (grille[x][y+colonne-1].getEtat() ==0){
                            bloquer = false;
                        }
                        else {
                            return true;
                        }
                    }
                }
            }
        }
        return bloquer;
    }

    boolean bloquer_bas(Case[][] grille){
        boolean bloquer = false;
        for(int i=0;i<16;i++){
            if(PieceCourante[position][i] !=0){
                int colonne = i%4;
                int ligne = i/4;
                if (x-ligne >0){
                    bloquer = false;
                }
                else{
                    if(grille[x-ligne-1][y+colonne].getEtat()==0){
                            bloquer = false;
                        }
                        else{
                            return true;
                        }
                }
            }
        }
        return bloquer;
    }

    public boolean bloque_tourner(Case[][] grille){
        boolean bloquer = false;
        for (int i=0;i<16;i++){
            if(PieceCourante[position][i] != 0){
                int colonne = i%4;
                int ligne = i/4;
                if (grille[x-ligne][y+colonne].getEtat()==0){
                    bloquer = false;
                }
                else{
                    return true;
                }
            }
        }
        return bloquer;        
    }


    private void affiche_piece(Case[][] grille) {
        for(int i =0;i<16;i++){
            int colonne = i%4;
            int ligne = i/4;
            
        }
    }

    private void efface(Case[][] grille) {
        
    }


}
