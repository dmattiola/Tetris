package Vue;

import Controleur.*;
import Modele.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.*;

/**
 * Classe Fenetre : vue de notre application
 * @author Dylan Jérémy
 */
public class Fenetre extends JFrame implements Observer {

    private final JPanel PieceSuivante = new JPanel();
    private final JMenu jMenu1 = new JMenu();
    private final JMenuItem jMenu2 = new JMenuItem();
    private final JMenuItem jMenu3 = new JMenuItem();
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
     * @param p partie de Tetris
     */
    public Fenetre(final Partie p) {
        
        super();
        this.p = p;
        // Controleur de la fenetre
        Controleur cp = new Controleur(this,p);
        this.addWindowListener(cp);

        // Mise en place de la fenetre principal
        this.setTitle("Jeu du Tetris");
        this.setSize(430, 500);

        // Mise en place du menu
        jMenu1.setText("Jeu");
        JMenuItem item1 = new JMenuItem("Nouveau Jeu");
        item1.addActionListener(cp);
        jMenu1.add(item1);
        jMenu2.setText("Pause");
        jMenu2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (p.isMettreEnPause()){
                p.TerminerPause();
                jMenu2.setSelected(false);
                }
                else {
                    jMenu2.setSelected(true);
                    p.Pause();
                }          
            }
        });
        jMenu3.setText("Règles du jeu");
        menuBar.add(jMenu1);
        menuBar.add(jMenu2);
        menuBar.add(jMenu3);
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

    /**
     * Methode apellé pour mettre à jour la vue en fonction du modele et des actions de l'utilisateur
     * @param o observable
     * @param o1 object
     */
    @Override
    public void update(Observable o, Object o1) {
        while(!p.isFin()) {
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
        
        score.setText(Integer.toString(p.getGrille().getScore()));
        level.setText(Integer.toString(p.getGrille().getLevel() + 1));
        nbligne.setText(Integer.toString(p.getGrille().getNbligne()));
        }
        
        // fin de partie
        for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    ((Case) PieceSuivante.getComponent(i * 4 + j)).ColorierCase(0);
                }
            }
            for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Grille.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                ((Case) plateau.getComponent(i * 10 + j)).ColorierCase(8);
                
            }
        }
        JOptionPane.showMessageDialog(this, "Fin de partie \nScore : "+p.getGrille().getScore(), "GAME OVER", JOptionPane.ERROR_MESSAGE);
        Thread.currentThread().stop();
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
