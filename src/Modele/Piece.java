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
