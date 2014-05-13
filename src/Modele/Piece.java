/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modele;

import static Modele.Utilitaire.monRandom;
import java.awt.Color;

/**
 *
 * @author Dylan
 */
public abstract class Piece {
    
    private Case[][] tabCase;
    private int x;
    private int y;
   
    
    public Piece(){
        
    }
    
   /*public Figure(Case[][] tabCase, int , int y){
        
    }
    */
    
    public int[][] Piece1 = { {0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0},
			  {0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0},
			  {0,1,0,0,0,1,1,0,0,0,1,0,0,0,0,0},
			  {0,0,0,0,0,0,1,1,0,1,1,0,0,0,0,0} };
    public int[][] Piece2 = { {0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},
			  {0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},
			  {0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0},
			  {0,2,2,0,0,2,2,0,0,0,0,0,0,0,0,0} };
    public int[][] Piece3 = { {0,3,0,0,0,3,0,0,0,3,0,0,0,3,0,0},
			  {3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0},
			  {0,3,0,0,0,3,0,0,0,3,0,0,0,3,0,0},
			  {3,3,3,3,0,0,0,0,0,0,0,0,0,0,0,0} };
    public int[][] Piece4 = { {0,0,4,0,0,4,4,0,0,4,0,0,0,0,0,0},
			  {0,0,0,0,0,4,4,0,0,0,4,4,0,0,0,0},
			  {0,0,4,0,0,4,4,0,0,4,0,0,0,0,0,0},
			  {0,0,0,0,0,4,4,0,0,0,4,4,0,0,0,0} };
    public int[][] Piece5 = { {0,5,0,0,0,5,5,0,0,5,0,0,0,0,0,0},
			  {0,0,0,0,0,0,5,0,0,5,5,5,0,0,0,0},
			  {0,0,0,5,0,0,5,5,0,0,0,5,0,0,0,0},
			  {0,5,5,5,0,0,5,0,0,0,0,0,0,0,0,0} };                          
    public int[][] Piece6 = { {0,0,6,0,0,0,6,0,0,6,6,0,0,0,0,0},
			  {0,0,0,0,0,6,6,6,0,0,0,6,0,0,0,0},
			  {0,6,6,0,0,6,0,0,0,6,0,0,0,0,0,0},
			  {0,0,0,0,0,6,0,0,0,6,6,6,0,0,0,0} };       
    public int[][] Piece7 = { {0,7,0,0,0,7,0,0,0,7,7,0,0,0,0,0},
			  {0,0,0,0,0,0,0,7,0,7,7,7,0,0,0,0},
			  {0,7,7,0,0,0,7,0,0,0,7,0,0,0,0,0},
			  {0,0,0,0,0,7,7,7,0,7,0,0,0,0,0,0} };  
}
