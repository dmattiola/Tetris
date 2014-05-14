package Controleur;

import Modele.Case;
import Modele.Grille;
import Modele.Piece;
import Vue.Fenetre;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Dylan
 */
public class ControleurClavier implements KeyListener {

    Case[][] grille;
    Fenetre fenetre;
    Piece PieceCourante;

    public void keyPressed(KeyEvent ke) {
        switch(ke.getKeyCode()){
            case (KeyEvent.VK_LEFT) : 
                if (PieceCourante != null){
                    PieceCourante.decale_gauche(grille);
                }
		break;
            case (KeyEvent.VK_RIGHT) : 
                if (PieceCourante != null){
                    PieceCourante.decale_droite(grille);
                }
                break;
            case (KeyEvent.VK_UP) :
                if (PieceCourante != null){
                    PieceCourante.tourner(grille);
                }
                break;
            case (KeyEvent.VK_DOWN) :
                if (PieceCourante != null){
                    PieceCourante.decale_bas(grille);
                }
                break;
            default : 
                break;
	}
    }

    public void keyReleased(KeyEvent ke) {}
    public void keyTyped(KeyEvent ke) {}

}
