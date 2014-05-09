/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import Vue.VuePrincipale;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dylan
 */
public class Tetris {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//On crée une nouvelle instance de notre JDialog
				VuePrincipale fenetre = new VuePrincipale();
				fenetre.setVisible(true);//On la rend visible
			}
		});

    }
    
}
