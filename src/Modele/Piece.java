package Modele;

import static Modele.Utilitaire.monRandom;

/**
 * Classe Piece : regroupe toutes les pieces et les constructeurs
 * @author Dylan Jérémy
 */
public class Piece {

    private int x;
    private int y;
    private int position;
    private int[][] pieceCourante = new int[4][16];

    /**
     * Piece formant un S
     */
        public int[][] Piece1 = {{0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0},
    {0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0}};

    /**
     *  Piece formant un carré
     */
        public int[][] Piece2 = {{0, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    /**
     * Piece formant une barre
     */
        public int[][] Piece3 = {{0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0},
    {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
    {0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0, 0, 3, 0, 0},
    {3, 3, 3, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

    /**
     * Piece formant un Z
     */
        public int[][] Piece4 = {{0, 0, 4, 0, 0, 4, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 4, 4, 0, 0, 0, 0},
    {0, 0, 4, 0, 0, 4, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 4, 4, 0, 0, 0, 4, 4, 0, 0, 0, 0}};

    /**
     * Piece formant un T
     */
        public int[][] Piece5 = {{0, 5, 0, 0, 0, 5, 5, 0, 0, 5, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 5, 0, 0, 5, 5, 5, 0, 0, 0, 0},
    {0, 0, 0, 5, 0, 0, 5, 5, 0, 0, 0, 5, 0, 0, 0, 0},
    {0, 5, 5, 5, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0}}; 

    /**
     * Piece formant un L inversé
     */
        public int[][] Piece6 = {{0, 0, 6, 0, 0, 0, 6, 0, 0, 6, 6, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 6, 6, 6, 0, 0, 0, 6, 0, 0, 0, 0},
    {0, 6, 6, 0, 0, 6, 0, 0, 0, 6, 0, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 6, 0, 0, 0, 6, 6, 6, 0, 0, 0, 0}};

    /**
     * Piece formant un L
     */
        public int[][] Piece7 = {{0, 7, 0, 0, 0, 7, 0, 0, 0, 7, 7, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 0, 0, 7, 0, 7, 7, 7, 0, 0, 0, 0},
    {0, 7, 7, 0, 0, 0, 7, 0, 0, 0, 7, 0, 0, 0, 0, 0},
    {0, 0, 0, 0, 0, 7, 7, 7, 0, 7, 0, 0, 0, 0, 0, 0}};
    
    /**
     * Piece BOMBE
     */
    public int[][] Bombe = {{1,0,1,0,0,2,0,2,3,0,3,0,0,4,0,4},
        {1,0,1,0,0,2,0,2,3,0,3,0,0,4,0,4},
        {1,0,1,0,0,2,0,2,3,0,3,0,0,4,0,4},
        {1,0,1,0,0,2,0,2,3,0,3,0,0,4,0,4}};

    /**
     * Constructeur de Piece
     */
    public Piece() {
        this.x = 0; // initialisation de la position en (0,3), c'est à dire centré et en haut de la grille
        this.y = 3;
        this.position = monRandom(0, 3); // correspond au sens de la pièce
        this.pieceCourante = tirerPiece();
    }

    /**
     * Constructeur de la piece CHEAT
     * @param cheat int donnant la piece souhaitée
     */
    Piece(int cheat) {
        this.x = 0;
        this.y = 3;
        this.position = 1;
        this.pieceCourante = getPiece(cheat);
    }

    /**
     * Methode qui donne la matrice de la piece en fonction de l'int rentré
     * @param cheat int rentré donnant une piece
     * @return la matrice de la piece
     */
    public int[][] getPiece(int cheat) {
        switch (cheat) {
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
           // case (8) :
             //   return Bombe;
            default:
                return Piece1;
        }
    }
    
    /**
     * Methode qui donne une pièce au hasard
     * @return la matrice de la piece prise au hasard
     */
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
           // case (8) :
             //   return Bombe;
            default:
                return Piece1;
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
