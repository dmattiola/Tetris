/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vue;

import Controleur.ControleurClavier;
import Modele.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
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
        initComponents();
        //build();
        for (int i=0;i<20;i++){
            for(int j =0;i<10;j++){
                plateau.add(new Case());
            }
        }
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    public void build(){
        
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
                                                                gauche.addKeyListener(new ControleurClavier());
        Button droite = new Button("Droite");
                                                                droite.addKeyListener(new ControleurClavier());
        Button bas = new Button("Bas");
                                                                bas.addKeyListener(new ControleurClavier());
        Button tourner = new Button("Tourner");
                                                                tourner.addKeyListener(new ControleurClavier());
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

        principal = new javax.swing.JPanel();
        plateau = new javax.swing.JPanel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jeu du Tetris");
        setPreferredSize(new java.awt.Dimension(450, 500));
        setResizable(false);

        principal.setLayout(new java.awt.BorderLayout());

        plateau.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        plateau.setLayout(new java.awt.GridLayout());
        principal.add(plateau, java.awt.BorderLayout.CENTER);

        jMenu1.setText("Partie");
        jMenu1.setActionCommand("");
        jMenuBar.add(jMenu1);

        jMenu2.setText("Help");
        jMenuBar.add(jMenu2);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(principal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JPanel plateau;
    private javax.swing.JPanel principal;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        
    }
}
