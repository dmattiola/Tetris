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

    private int x;
    private int y;
    private int position;
    private int[][] pieceCourante = new int[4][16];

    // Piece formant un S
    public int[][] Piece1 = {{0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
    {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0}};
    // Piece formant un carré
    public int[][] Piece2 = {{0, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    // Piece formant une barre
    public int[][] Piece3 = {{0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0},
    {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0},
    {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    // Piece formant un Z
    public int[][] Piece4 = {{0, 0, 4, 0, 0, 4, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 4, 4, 0, 0, 0, 0},
    {0, 0, 4, 0, 0, 4, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 4, 4, 0, 0, 0, 0}};
    // Piece formant un T
    public int[][] Piece5 = {{0, 5, 0, 0, 0, 5, 5, 0, 0, 5, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 5, 0, 0, 5, 5, 5, 0, 0, 0, 0},
    {0, 0, 0, 5, 0, 0, 5, 5, 0, 0, 0, 5, 0, 0, 0, 0},
    {0, 5, 5, 5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    // Piece formant un L inversé
    public int[][] Piece6 = {{0, 0, 6, 0, 0, 0, 6, 0, 0, 6, 6, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 6, 6, 6, 0, 0, 0, 6, 0, 0, 0, 0},
    {0, 6, 6, 0, 0, 6, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 6, 0, 0, 0, 6, 6, 6, 0, 0, 0, 0}};
    // Piece formant un L
    public int[][] Piece7 = {{0, 7, 0, 0, 0, 7, 0, 0, 0, 7, 7, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 7, 0, 7, 7, 7, 0, 0, 0, 0},
    {0, 7, 7, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 7, 7, 7, 0, 7, 0, 0, 0, 0, 0, 0}};

    public Piece() {
        this.x = 0;
        this.y = 3;
        this.position = monRandom(0, 3);
        this.pieceCourante = tirerPiece();
    }

    public int[][] tirerPiece() {
        int numero = monRandom(1, 7);
        switch (numero) {
            case (1):
                return Piece1;
            case (2):
                return Piece2;
            case (3):
                return Piece3;
            case (4):
                return Piece4;
            case (5):
                return Piece5;
            case (6):
                return Piece6;
            case (7):
                return Piece7;
            default:
                return Piece1;
        }
    }

    public void decale_gauche(Case[][] grille) {
        efface_piece(grille);
        setY(getY() - 1); // on simule le decalage de la piece d'une case vers la gauche, une colonne en moins
        if (bloque_gauche(grille)) {
            setY(getY() + 1);
        }
        affiche_piece(grille);
    }

    public void decale_droite(Case[][] grille) {
        efface_piece(grille);
        setY(getY() + 1);
        if (bloque_droite(grille)) {
            setY(getY() - 1);
        }
        affiche_piece(grille);
    }

    public void decale_bas(Case[][] grille) {
        System.out.println("Decale bas");
        efface_piece(grille);
        setX(getX() + 1);
        if (bloquer_bas(grille)) {
            setX(getX() - 1);
        }
        System.out.println("Descente de la piece");
        affiche_piece(grille);
    }

    public void tourner(Case[][] grille) {
        efface_piece(grille);
        int ancienne_position = getPosition();
        setPosition(getPosition() + 1);
        if (getPosition() == 4) {
            setPosition(0);
        }
        if (bloque_tourner(grille)) {
            setPosition(ancienne_position);
        }
        affiche_piece(grille);
    }

    public boolean bloque_droite(Case[][] grille) {
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (pieceCourante[getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i / 4;
                if (colonne < 3) {
                    bloquer = false;
                } else {
                    if (colonne + getY() + 1 > 9) {
                        return true;
                    } else {
                        if (grille[getX()][getY() + colonne + 1].getEtat() == 0) {
                            bloquer = false;
                        } else {
                            return true;
                        }
                    }
                }
            }
        }
        return bloquer;
    }

    public boolean bloque_gauche(Case[][] grille) {
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (pieceCourante[getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i / 4;
                if (colonne > 0) {
                    bloquer = false;
                } else {
                    if (colonne + getY() - 1 < 0) {
                        return true;
                    } else {
                        if (grille[getX()][getY() + colonne - 1].getEtat() == 0) {
                            bloquer = false;
                        } else {
                            return true;
                        }
                    }
                }
            }
        }
        return bloquer;
    }

    public boolean bloquer_bas(Case[][] grille) {
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (pieceCourante[getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i / 4;
                if (getX() + ligne + 1 > 22) {
                    return true;
                } else {
                    if (grille[getX() + ligne + 1][getY() + colonne].getEtat() == 0) {
                        bloquer = false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return bloquer;
    }

    public boolean bloque_tourner(Case[][] grille) {
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (pieceCourante[getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i / 4;
                if (grille[getX() + ligne][getY() + colonne].getEtat() == 0) {
                    bloquer = false;
                } else {
                    return true;
                }
            }
        }
        return bloquer;
    }

    public void affiche_piece(Case[][] grille) {
        for (int i = 0; i < 16; i++) {
            int colonne = i % 4;
            int ligne = i / 4;
            if (getPieceCourante()[getPosition()][i] != 0) {
                int nouvEtat = getPieceCourante()[getPosition()][i];
                grille[getX()+ligne][getY()+colonne].setEtat(nouvEtat);
            }
        }
    }

    public void efface_piece(Case[][] grille) {
        for (int i = 0; i < 16; i++) {
            int colonne = i % 4;
            int ligne = i / 4;
            if (getPieceCourante()[getPosition()][i] != 0) {
                grille[getX()+ligne][getY()+colonne].setEtat(0);
            }
        }
    }
    
    public void efface_ligne(Case[][] grille) {
        for (int i=getX();i<getX()+4;i++){
            boolean rempli = true; // on part du principe que la ligne est rempli
            int j = 0;
            while(j<10 && rempli){ // des qu'une case n'est pas occupée, la boucle s'arrete 
                if(grille[i][j].getEtat() == 0){
                    rempli = false;
                }
                j++;
            }
            if(rempli){
                supprimer_ligne(grille,i);
                decaler_ligne(grille,i);
            }           
        }
    }
    
    public void supprimer_ligne(Case[][] grille, int ligne){
        for(int i=0;i<10;i++){
            grille[ligne][i].setEtat(0);
        }
    }
    
    public void decaler_ligne(Case[][] grille,int ligne){
        for (int i=0;i<ligne-2;i++){
            for(int j = 0;j<9;j++){
                grille[ligne-i][j].setEtat(grille[ligne-i-1][j].getEtat());
            }
     
        }
    }

    /**
     * @return the x
     */
    public int getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public int getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * @return the position
     */
    public int getPosition() {
        return position;
    }

    /**
     * @param position the position to set
     */
    public void setPosition(int position) {
        this.position = position;
    }

    /**
     * @return the pieceCourante
     */
    public int[][] getPieceCourante() {
        return pieceCourante;
    }

    /**
     * @param pieceCourante the pieceCourante to set
     */
    public void setPieceCourante(int[][] pieceCourante) {
        this.pieceCourante = pieceCourante;
    }

}
