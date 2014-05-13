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
    public void keyTyped(KeyEvent ke) {}

}
