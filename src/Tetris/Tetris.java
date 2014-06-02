package Tetris;

import Controleur.Controleur;
import Modele.Partie;
import Vue.Fenetre;
import java.util.Observable;

/**
 * Classe Tetris
 * @author Dylan Jérémy
 */
public class Tetris extends Observable implements Runnable {

    private Thread process;
    private Partie P;

    /**
     * Constructeur du Tetris
     */
    public Tetris() {
        if (process == null) {
            process = new Thread(this);
            process.start();
        }
    }

    /**
     * Methode principale : main du Tetris : lance la partie de Tetris
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tetris tetris = new Tetris();
        Partie p = new Partie();
        Fenetre fenetre = new Fenetre(p);
        Controleur controleur = new Controleur(fenetre,p);
        fenetre.addKeyListener(controleur);
        tetris.addObserver(fenetre);
        fenetre.setVisible(true);
        p.start();  
    }

    /**
     * Methode run du thread du Tetris
     */
    @Override
    public void run() {
        while (true) {
            setChanged();
            notifyObservers();
        }
    }
    
}
