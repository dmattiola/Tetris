/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Controleur.ControleurClavier;
import Modele.Case;
import Modele.Partie;
import Tetris.Tetris;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author Dylan
 */
public class Fenetre extends JFrame implements Observer {

    private final JPanel PieceSuivante = new JPanel();
    private final JMenu jMenu1 = new JMenu();
    private final JMenu jMenu2 = new JMenu();
    private final JMenuBar menuBar = new JMenuBar();
    private final JPanel plateau = new JPanel();
    private final JPanel menu = new JPanel();
    private final JPanel principal = new JPanel();
    private final JLabel score = new JLabel();
    private final JLabel level = new JLabel();
    private final JLabel nbligne = new JLabel();

    private final Partie p;

    /**
     * Creates new form Fenetre
     *
     * @param p
     */
    public Fenetre(Partie p) {
        super();
        build();
        this.p = p;
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
    }

    private void build() {

        // Mise en place de la fenetre principal
        this.setTitle("Jeu du Tetris");
        this.setSize(430, 500);

        // Mise en place du menu
        jMenu1.setText("Jeu");
        JMenuItem item1 = new JMenuItem("Nouveau Jeu");
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Thread.currentThread().interrupt();
                Tetris tetris = new Tetris();
                Partie p = new Partie();
                Fenetre fenetre = new Fenetre(p);
                ControleurClavier controleur = new ControleurClavier(fenetre, p);
                fenetre.addKeyListener(controleur);
                tetris.addObserver(fenetre);
                fenetre.setVisible(true);
                p.start();
            }
        });
        jMenu1.add(item1);
        jMenu2.setText("Pause");
        menuBar.add(jMenu1);
        menuBar.add(jMenu2);
        this.setJMenuBar(menuBar);

        // Creation des lignes de séparation
        Border whiteline = BorderFactory.createLineBorder(Color.white, 1);
        Border blackline = BorderFactory.createLineBorder(Color.black, 1);

        // Mise en place des Panels
        principal.setLayout(new BorderLayout());
        plateau.setLayout(new GridLayout(20, 10));
        menu.setLayout(new GridLayout(4, 1));
        PieceSuivante.setLayout(new GridLayout(4, 4));

        // Positionnement des Panels dans le Panel principal
        principal.add(menu, "East");
        principal.add(plateau, "Center");
        principal.setBorder(blackline);

        // Positionnement dans le Panel "menu"
        menu.add(new JLabel("Piece Suivante"));
        menu.add(PieceSuivante);

        // Mise en place de la grille affichant la pièce suivante
        for (int i = 0; i < 16; i++) {
            JComponent ptest = new Case();
            ptest.setBorder(whiteline);
            PieceSuivante.add(ptest);
        }

        // Mise en place du score et du level
        score.setText("0");
        level.setText("1");
        nbligne.setText("0");
        JLabel lb_score = new JLabel("Score : ");
        JLabel lb_level = new JLabel("Level : ");
        JLabel lb_ligne = new JLabel("Lignes : ");
        menu.add(lb_level);
        menu.add(level);
        menu.add(lb_score);
        menu.add(score);
        menu.add(lb_ligne);
        menu.add(nbligne);

        // Mise en place du plateau / grille de jeu
        for (int i = 0; i < 200; i++) {
            JComponent ptest = new Case();
            ptest.setBorder(whiteline);
            plateau.add(ptest);
        }

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.add(principal);
    }

    @Override
    public void update(Observable o, Object o1) {
        if (!p.isFin()) {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 10; j++) {
                    ((Case) plateau.getComponent(i * 10 + j)).ColorierCase(p.getGrille().getGrille()[i + 4][j].getEtat());
                }
            }
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    ((Case) PieceSuivante.getComponent(i * 4 + j)).ColorierCase(p.getPieceSuivante().getPieceCourante()[p.getPieceSuivante().getPosition()][i * 4 + j]);
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    ((Case) PieceSuivante.getComponent(i * 4 + j)).ColorierCase(0);
                }
            }
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 10; j++) {
                    if ((i == 4 && j == 1) || (i == 4 && j == 2)) {
                        ((Case) plateau.getComponent(i * 10 + j)).ColorierCase(2);
                    }
                    ((Case) plateau.getComponent(i * 10 + j)).ColorierCase(p.getGrille().getGrille()[i + 4][j].getEtat());
                }
            }
            //JOptionPane.showMessageDialog(null, "Fin de partie \nScore : "+p.getGrille().getScore(), "GAME OVER", JOptionPane.ERROR_MESSAGE);
        }

        score.setText(Integer.toString(p.getGrille().getScore()));
        level.setText(Integer.toString(p.getGrille().getLevel() + 1));
        nbligne.setText(Integer.toString(p.getGrille().getNbligne()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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

}
