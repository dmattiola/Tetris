/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import java.util.Observable;

/**
 *
 * @author Dylan
 */
public class Grille extends Observable{
    
    private Case grille[][];
    private final int hauteur = 23;
    private final int largeur = 10;
    private int level;
    private int score;

    public Grille() {
        initialiserGrille();
        this.score = 0;
        this.level =0;
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
    
    
    public void decale_gauche(Piece p) {
        enlever_piece(p);
        p.setY(p.getY() - 1); // on simule le decalage de la piece d'une case vers la gauche, une colonne en moins
        if (bloque_gauche(p)) {
            p.setY(p.getY() + 1);
        }
        ajoute_piece(p);
    }

    public void decale_droite(Piece p) {
        enlever_piece(p);
        p.setY(p.getY() + 1);
        if (bloque_droite(p)) {
            p.setY(p.getY() - 1);
        }
        ajoute_piece(p);
    }

    public void decale_bas(Piece p) {
        if (!bloquer_bas(p)) {
            p.setX(p.getX() + 1);
            ajoute_piece(p);
        }
    }

    public void tourner(Piece p) {
        enlever_piece(p);
        int ancienne_position = p.getPosition();
        p.setPosition(p.getPosition() + 1);
        if (p.getPosition() == 4) {
            p.setPosition(0);
        }
        if (bloque_tourner(p)) {
            p.setPosition(ancienne_position);
        }
        ajoute_piece(p);
    }

    public boolean bloque_droite(Piece p) {
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (p.getPieceCourante()[p.getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i / 4;
                    if (colonne + p.getY() > 9) {
                        return true;
                    } else {
                        if (this.grille[p.getX()][p.getY() + colonne].getEtat() == 0) {
                            bloquer = false;
                        } else {
                            return true;
                        }
                }
            }
        }
        return bloquer;
    }

    public boolean bloque_gauche(Piece p) {
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (p.getPieceCourante()[p.getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i / 4;
                    if (colonne + p.getY() < 0) {
                        return true;
                    } else {
                        if (this.grille[p.getX()][p.getY() + colonne].getEtat() == 0) {
                            bloquer = false;
                        } else {
                            return true;
                        }
                }
            }
        }
        return bloquer;
    }

    public boolean bloquer_bas(Piece p) {
        enlever_piece(p);
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (p.getPieceCourante()[p.getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i / 4;
                if (p.getX() + ligne + 1 > 22) {
                    return true;
                } else {
                    if (this.grille[p.getX() + ligne + 1][p.getY() + colonne].getEtat() == 0) {
                        bloquer = false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return bloquer;
    }

    public boolean bloque_tourner(Piece p) {
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (p.getPieceCourante()[p.getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i / 4;
                if(p.getY()+colonne > 9){
                    return true;
                }
                else {
                    if (this.grille[p.getX() + ligne][p.getY() + colonne].getEtat() == 0) {
                    bloquer = false;
                } else {
                    return true;
                }
            }
        }
        }
        return bloquer;
    }

    public void ajoute_piece(Piece p) {
        for (int i = 0; i < 16; i++) {
            int colonne = i % 4;
            int ligne = i / 4;
            if (p.getPieceCourante()[p.getPosition()][i] != 0) {
                int nouvEtat = p.getPieceCourante()[p.getPosition()][i];
                this.grille[p.getX()+ligne][p.getY()+colonne].setEtat(nouvEtat);
            }
        }
    }

    public void enlever_piece(Piece p) {
        for (int i = 0; i < 16; i++) {
            int colonne = i % 4;
            int ligne = i / 4;
            if (p.getPieceCourante()[p.getPosition()][i] != 0) {
                this.grille[p.getX()+ligne][p.getY()+colonne].setEtat(0);
            }
        }
    }
    
    public void efface_ligne(Piece p) {
        for (int i=0;i<16;i++){
            int colonne = i % 4;
            int ligne = i / 4;
            if(p.getX()+ligne<23){
                boolean rempli = true; // on part du principe que la ligne est rempli
                int j = 0;
                while(j<10 && rempli){ // des qu'une case n'est pas occupée, la boucle s'arrete 
                    if(this.grille[p.getX()+ligne][j].getEtat() == 0){
                        rempli = false;
                    }
                    j++;
                }
                if(rempli){
                    setScore(getScore()+1);
                    supprimer_ligne(p.getX()+ligne);
                    decaler_lignes(p.getX()+ligne);
                    setLevel(getScore()/2);
                } 
            }   
        }
    }
    
    public void supprimer_ligne(int ligne){
        for(int i=0;i<10;i++){
            this.grille[ligne][i].setEtat(0);
        }
    }
    
    public void decaler_lignes(int ligne){
        for (int i=0;i<ligne-2;i++){
            for(int j = 0;j<10;j++){
                this.grille[ligne-i][j].setEtat(this.grille[ligne-i-1][j].getEtat());
            }
     
        }
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @param level the level to set
     */
    public void setLevel(int level) {
        this.level = level;
    }

}
