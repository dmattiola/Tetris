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

        MenuTouche = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();

        MenuTouche.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout MenuToucheLayout = new javax.swing.GroupLayout(MenuTouche);
        MenuTouche.setLayout(MenuToucheLayout);
        MenuToucheLayout.setHorizontalGroup(
            MenuToucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 428, Short.MAX_VALUE)
        );
        MenuToucheLayout.setVerticalGroup(
            MenuToucheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 455, Short.MAX_VALUE)
        );

        MenuTouche.getAccessibleContext().setAccessibleName("");
        MenuTouche.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Jeu du Tetris");
        setPreferredSize(new java.awt.Dimension(450, 500));
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 414, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 478, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MenuTouche;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object o1) {
        
    }
}
