/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Modele.Partie;
import Vue.Fenetre;
import java.awt.event.*;

/**
 *
 * @author Dylan
 */
public class ControleurClavier implements KeyListener{
    
    Fenetre fenetre;
    Partie p;

    public ControleurClavier(Fenetre fenetre,Partie p) {
        this.fenetre = fenetre;
        this.p=p;
    }

    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()){
            case (KeyEvent.VK_LEFT) :
                if (p.getPieceCourante() != null){
                    this.p.getGrille().decale_gauche(p.getPieceCourante());
                }
		break;
            case (KeyEvent.VK_RIGHT) : 
                if (p.getPieceCourante() != null){
                    this.p.getGrille().decale_droite(p.getPieceCourante());
                }
                break;
            case (KeyEvent.VK_UP) :
                if (p.getPieceCourante() != null){
                    this.p.getGrille().tourner(p.getPieceCourante());
                }
                break;
            case (KeyEvent.VK_DOWN) :
                if (p.getPieceCourante() != null){
                    this.p.getGrille().decale_bas(p.getPieceCourante());
                }
                break;
            default : 
                break;
	}
    }

    public void keyReleased(KeyEvent ke) {}
    public void keyTyped(KeyEvent ke) {}


}

