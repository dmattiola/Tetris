/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetris;

import Vue.Fenetre;
import javax.swing.SwingUtilities;

/**
 *
 * @author Dylan
 */
public class Tetris {

    
    public Tetris(){
        //new Thread( this).start();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				//On crée une nouvelle instance de notre JDialog
				Fenetre fenetre = new Fenetre();
				fenetre.setVisible(true);//On la rend visible
			}
		});

    }

   
    }
    
//}
