package Controleur;

import Modele.Partie;
import Tetris.Tetris;
import Vue.Fenetre;
import java.awt.event.*;

/**
 * Controleur : synchronization entre le modèle et la vue
 * 
 * @author Dylan Jérémy
 */
public class Controleur extends WindowAdapter implements KeyListener, ActionListener {

    Fenetre fenetre;
    Partie p;

    /**
     * Constructeur du controleur
     * @param fenetre vue : fenetre principale
     * @param p modele : partie en cours
     */
    public Controleur(Fenetre fenetre, Partie p) {
        this.fenetre = fenetre;
        this.p = p;
    }

    /**
     * Methode actionnée lors du clic sur l'item nouvelle partie : lance une nouvelle partie
     * @param ae ActionEvent
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        Tetris tetris = new Tetris();
        Partie p = new Partie();
        this.fenetre.setVisible(false);
        Fenetre f = new Fenetre(p);
        Controleur controleur = new Controleur(f, p);
        f.addKeyListener(controleur);
        tetris.addObserver(f);
        f.setVisible(true);
        p.start();
    }

    /**
     * Methode actionnée lors de l'appui sur un touche
     * @param e KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // lors de l'appui sur la touche P, mise en pause du jeu ou alors reprise du jeu
        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (this.p.isMettreEnPause()) {
                this.p.TerminerPause();
            } else {
                this.p.Pause();
            }
        }
        // si le jeu de n'est pas en pause ou que la partie n'est pas fini, on peut utiliser les touches
        if (!this.p.getGrille().fin_partie() && !this.p.isMettreEnPause()) {
            switch (e.getKeyCode()) {
                case (KeyEvent.VK_LEFT):
                    if (p.getPieceCourante() != null) {
                        this.p.getGrille().decale_gauche(p.getPieceCourante());
                    }
                    break;
                case (KeyEvent.VK_RIGHT):
                    if (p.getPieceCourante() != null) {
                        this.p.getGrille().decale_droite(p.getPieceCourante());
                    }
                    break;
                case (KeyEvent.VK_UP):
                    if (p.getPieceCourante() != null) {
                        this.p.getGrille().tourner(p.getPieceCourante());
                    }
                    break;
                case (KeyEvent.VK_DOWN):
                    if (p.getPieceCourante() != null) {
                        this.p.getGrille().decale_bas(p.getPieceCourante());
                    }
                    break;
                case (KeyEvent.VK_0):
                    if (p.getPieceCourante() != null) {
                        p.setCheat(0);
                    }
                    break;
                case (KeyEvent.VK_1):
                    if (p.getPieceCourante() != null) {
                        p.setCheat(1);
                    }
                    break;
                case (KeyEvent.VK_2):
                    if (p.getPieceCourante() != null) {
                        p.setCheat(2);
                    }
                    break;
                case (KeyEvent.VK_3):
                    if (p.getPieceCourante() != null) {
                        p.setCheat(3);
                    }
                    break;
                case (KeyEvent.VK_4):
                    if (p.getPieceCourante() != null) {
                        p.setCheat(4);
                    }
                    break;
                case (KeyEvent.VK_5):
                    if (p.getPieceCourante() != null) {
                        p.setCheat(5);
                    }
                    break;
                case (KeyEvent.VK_6):
                    if (p.getPieceCourante() != null) {
                        p.setCheat(6);
                    }
                    break;
                case (KeyEvent.VK_7):
                    if (p.getPieceCourante() != null) {
                        p.setCheat(7);
                    }
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Methode KeyReleased inutilisée
     * @param ke KeyEvent
     */
    @Override
    public void keyReleased(KeyEvent ke) {
    }

    /**
     * Methode KeyTyped inutilisée
     * @param ke KeyEvent
     */
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    /**
     * Methode qui permet la fermeture de l'application Tetris
     * @param we WindowEvent
     */
    @Override
    public void windowClosing(WindowEvent we) {
        super.windowClosing(we);
        System.exit(0);
    }

}
