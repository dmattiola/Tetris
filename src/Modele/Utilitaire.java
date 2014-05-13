package Modele;

import java.util.Random;

/**
 *
 * @author Dylan
 */
public class Utilitaire {
        /**
     * Donne un entier entre deux paramètres
     * @param min borne minimale de l'intervalle souhaité
     * @param max borne maximale de l'intervalle souhaité
     * @return int entier aléatoire entre min et max
     */
    public static int monRandom(int min, int max) {
        Random rand = new Random();
        int nombreAleatoire = rand.nextInt(max - min + 1) + min;
        return nombreAleatoire;
    }
}
