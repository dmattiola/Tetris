/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controleur;

import Modele.Grille;
import Vue.Fenetre;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Dylan
 */
public class ControleurClavier implements KeyListener {

    Grille grille;
    Fenetre fenetre;
    
    public void keyTyped(KeyEvent ke) {}

    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case (KeyEvent.VK_LEFT) : 
		break;
            case (KeyEvent.VK_RIGHT) : 
                break;
            case (KeyEvent.VK_UP) : 
                break;
            case (KeyEvent.VK_DOWN) : 
                break;
            default : 
                break;
	}
}

    public void keyReleased(KeyEvent ke) {}
    
}
