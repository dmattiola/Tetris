/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package realtetris;

import Vue.Fenetre;
import java.util.Observable;

/**
 *
 * @author Dylan
 */
public class RealTetris extends Observable implements Runnable {

    private Thread process;
    
    public RealTetris(){
        if (process == null) {
  	process = new Thread(this);
  	process.start();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       RealTetris tetris = new RealTetris();
        Fenetre fenetre = new Fenetre();
        tetris.addObserver(fenetre);
        fenetre.setVisible(true);
    }

    @Override
    public void run() {
        
    }
    
}
