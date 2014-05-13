/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import Vue.Fenetre;
import java.util.Observable;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dylan
 */
public class Tetris extends Observable implements Runnable {

    private Thread process;
    
    public Tetris(){
        if (process == null) {
  	process = new Thread(this);
  	process.start();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        Fenetre fenetre = new Fenetre();
        tetris.addObserver(fenetre);
        fenetre.setVisible(true);//On la rend visible	
    }

    @Override
    public void run() {
        	
    }
    
    }
