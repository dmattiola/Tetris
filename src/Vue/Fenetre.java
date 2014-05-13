/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Modele.Case;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.Border;

/**
 *
 * @author Dylan
 */
public class Fenetre extends JFrame implements Observer{

    /**
     * Creates new form Fenetre
     */
    public Fenetre() {
        super();
        build();
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public void build(){
        JMenuBar jm = new JMenuBar();
        JMenu m1 = new JMenu("Partie");
        JMenu m2 = new JMenu("Help");
        jm.add(m1);
        jm.add(m2);
        this.setJMenuBar(jm);
        
        this.setTitle("Jeu du Tetris");
        this.setSize(450,500);
        JComponent principal = new JPanel(new BorderLayout());
        JComponent plateau = new JPanel(new GridLayout(20,10));
       
        Border whiteline = BorderFactory.createLineBorder(Color.white,1);
        Border blackline = BorderFactory.createLineBorder(Color.black,1);

        for (int i = 0; i<200;i++){
            JComponent ptest = new Case();
            ptest.setBorder(whiteline);
            plateau.add(ptest);
        }       
        JComponent Bouttons = new JPanel(new FlowLayout());
        Button gauche = new Button("Gauche");
        Button droite = new Button("Droite");
        Button bas = new Button("Bas");
        Button tourner = new Button("Tourner");
        Bouttons.add(gauche);
        Bouttons.add(droite);
        Bouttons.add(bas);
        Bouttons.add(tourner);
        
        
        principal.add(Bouttons,"East");
        principal.add(plateau, "Center");
        principal.setBorder(blackline);
        this.add(principal);
    }
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
    }
}
