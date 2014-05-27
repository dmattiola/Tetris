/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controleur;

import Modele.Partie;
import Tetris.Tetris;
import Vue.Fenetre;
import java.awt.event.*;

/**
 *
 * @author Dylan
 */
public class Controleur extends WindowAdapter implements KeyListener, ActionListener {

    Fenetre fenetre;
    Partie p;

    public Controleur(Fenetre fenetre, Partie p) {
        this.fenetre = fenetre;
        this.p = p;
    }

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
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_P) {
            if (this.p.isMettreEnPause()) {
                this.p.TerminerPause();
            } else {
                this.p.Pause();
            }
        }
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
     *
     * @param ke
     */
    @Override
    public void keyReleased(KeyEvent ke) {
    }

    /**
     *
     * @param ke
     */
    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void windowClosing(WindowEvent we) {
        super.windowClosing(we);
        System.exit(0);
    }

}
