package Modele;

import java.util.Observable;

/**
 * Classe grille : "plateau de jeu"
 * @author Dylan Jérémy
 */
public class Grille extends Observable{
    
    private Case grille[][];
    private final int hauteur = 24;
    private final int largeur = 10;
    private int level;
    private int score;
    private int nbligne;

    /**
     * Constructeur de grille à vide avec level, score et nbligne à 0
     */
    public Grille() {
        initialiserGrille();
        this.score = 0;
        this.level =0;
        this.nbligne = 0;
    }

    /**
     * Methode initialisant la grille comme une matrice de Case vide
     */
    private void initialiserGrille() {
        setGrille(new Case[hauteur][largeur]);
        for (int i = 0; i < hauteur; i++) {
            for (int j = 0; j < largeur; j++) {
                getGrille()[i][j] = new Case(i, j);
            }
        }
    }

    /**
     * Methode qui décale la pièce à gauche si possible
     * @param p Pièce à décaler
     */
        public void decale_gauche(Piece p) {
        enlever_piece(p);
        p.setY(p.getY() - 1); 
        if (bloque_gauche(p)) {
            p.setY(p.getY() + 1);
        }
        ajoute_piece(p);
    }

    /**
     * Metode qui décale la pièce à droite si possible
     * @param p Pièce à décaler
     */
    public void decale_droite(Piece p) {
        enlever_piece(p);
        p.setY(p.getY() + 1);
        if (bloque_droite(p)) {
            p.setY(p.getY() - 1);
        }
        ajoute_piece(p);
    }

    /**
     * Methode qui fait descendre la pièce si possible
     * @param p Pièce à descendre
     */
    public void decale_bas(Piece p) {
        enlever_piece(p);
        if (!bloquer_bas(p)) {
            p.setX(p.getX() + 1);  
        }
        ajoute_piece(p);
    }

    /**
     * Methode qui fait tourner la pièce si possible
     * @param p Pièce à tourner
     */
    public void tourner(Piece p) {
        enlever_piece(p);
        int ancienne_position = p.getPosition();
        p.setPosition(p.getPosition() + 1);
        // on a seulement 4 positions, on repart donc à la première
        if (p.getPosition() == 4) {
            p.setPosition(0);
        }
        if (bloque_tourner(p)) {
            p.setPosition(ancienne_position);
        }
        ajoute_piece(p);
    }

    /**
     * Methode qui teste s'il est possible de décaler la pièce à droite
     * @param p Pièce à tester
     * @return true si la pièce est bloquée / false si on peut la déplacer vers la droite
     */
    public boolean bloque_droite(Piece p) {
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (p.getPieceCourante()[p.getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i/4;
                    if (colonne + p.getY() > 9) {
                        return true;
                    } else {
                        if (this.grille[p.getX()+ligne][p.getY() + colonne].getEtat() == 0) {
                            bloquer = false;
                        } else {
                            return true;
                        }
                }
            }
        }
        return bloquer;
    }

    /**
     * Methode qui teste s'il est possible de décaler la piece à gauche
     * @param p Pièce à tester
     * @return true si la pièce est bloquée / false si on peut la déplacer vers la gauche
     */
    public boolean bloque_gauche(Piece p) {
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (p.getPieceCourante()[p.getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i/4;
                    if (colonne + p.getY() < 0) {
                        return true;
                    } else {
                        if (this.grille[p.getX()+ligne][p.getY() + colonne].getEtat() == 0) {
                            bloquer = false;
                        } else {
                            return true;
                        }
                }
            }
        }
        return bloquer;
    }

    /**
     * Methode qui teste s'il est possible de descendre la piece
     * @param p Pièce à tester
     * @return true si la pièce est bloquée / false si on peut la descendre
     */
    public boolean bloquer_bas(Piece p) {
        enlever_piece(p);
        boolean bloquer = false;
        for (int i = 0; i < 16; i++) {
            if (p.getPieceCourante()[p.getPosition()][i] != 0) {
                int colonne = i % 4;
                int ligne = i / 4;
                if (p.getX() + ligne + 1 > 23) {
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

    /**
     * Methode qui teste s'il est possible de tourner la piece
     * @param p Pièce à tester
     * @return true si la pièce est bloquée / false si on peut la tourner
     */
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

    /**
     * Methode qui ajoute la pièce a la grille
     * @param p Pièce à ajouter
     */
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

    /**
     * Methode qui enleve la pièce de la grille
     * @param p Pièce à enlever
     */
    public void enlever_piece(Piece p) {
        for (int i = 0; i < 16; i++) {
            int colonne = i % 4;
            int ligne = i / 4;
            if (p.getPieceCourante()[p.getPosition()][i] != 0) {
                this.grille[p.getX()+ligne][p.getY()+colonne].setEtat(0);
            }
        }
    }
    
    /**
     * Methode qui teste les lignes par rapport à la pièce qui vient d'être bloquée
     * @param p Pièce qui vient d'être bloquée
     */
    public void efface_ligne(Piece p) {
        for (int i=0;i<16;i++){
            int ligne = i / 4;
            if(p.getX()+ligne<24){
                boolean rempli = true; // on part du principe que la ligne est remplie
                int j = 0;
                while(j<10 && rempli){ // des qu'une case n'est pas occupée, la boucle s'arrête 
                    if(this.grille[p.getX()+ligne][j].getEtat() == 0){
                        rempli = false;
                    }
                    j++;
                }
                // si on a traversé toute la ligne sans case vide alors on entre dans le cas suivant
                if(rempli){
                    setNbligne(getNbligne()+1); // on augmente le nombre de lignes effectuées de 1
                    setScore(getScore()+5*(getLevel()+1)); // on fait evoluer le score en fonction du level
                    supprimer_ligne(p.getX()+ligne); // on supprime la ligne 
                    decaler_lignes(p.getX()+ligne); // on décale les lignes du dessus
                    setLevel(getNbligne()/15); // le level augmente toutes les 15 lignes effectuées
                } 
            }   
        }
    }
    
    /**
     * Methode qui supprime la ligne donnée en paramètre
     * @param ligne int donnant la ligne à supprimer
     */
    public void supprimer_ligne(int ligne){
        for(int i=0;i<10;i++){
            this.grille[ligne][i].setEtat(0);
        }
    }
    
    /**
     *  Methode qui décale les lignes à partir de celle qui a été supprimer
     * @param ligne int donnant la ligne à partir de laquelle décaler les autres
     */
    public void decaler_lignes(int ligne){
        for (int i=0;i<ligne-2;i++){
            for(int j = 0;j<10;j++){
                this.grille[ligne-i][j].setEtat(this.grille[ligne-i-1][j].getEtat());
            }
        }
    }
    
    /**
     * Methode qui teste la fin d'une partie
     * @return true si la partie est terminée / false sinon
     */
    public boolean fin_partie(){
        for(int i = 0;i<3;i++){ // on vérifie seulement si dans les 2 premieres lignes "invisibles" un morceau de piece est présente
            for(int j = 0;j<10;j++){
                if (this.grille[i][j].getEtat() != 0){
                    return true;
                }
            }
        }
        return false;
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

    /**
     * @return the nbligne
     */
    public int getNbligne() {
        return nbligne;
    }

    /**
     * @param nbligne the nbligne to set
     */
    public void setNbligne(int nbligne) {
        this.nbligne = nbligne;
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
