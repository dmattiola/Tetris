/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tetris;

import Modele.Partie;
import Vue.Fenetre;
import java.util.Observable;

/**
 *
 * @author Dylan
 */
public class Tetris extends Observable implements Runnable{

     private Thread process;

    public Tetris() {
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
        Partie p = new Partie();
        Fenetre fenetre = new Fenetre(p);
        tetris.addObserver(fenetre);
        fenetre.setVisible(true);
        p.start();
    }

    @Override
    public void run() {
        while (true) {
            setChanged();
            notifyObservers();
        }
    }

}
