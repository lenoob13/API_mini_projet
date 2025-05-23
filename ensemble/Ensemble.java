package ensemble;

import java.util.Set;

/**
 * Interface générique représentant un ensemble mathématique.
 * Un ensemble est une collection d'éléments distincts du même type.
 * L'ensemble est immuable, c'est-à-dire que ses éléments ne peuvent pas être modifiés une fois créés.
 *
 * @param <T> Le type des éléments dans l'ensemble
 */
public interface Ensemble<T> {

    /**
     * Retourne le cardinal de l'ensemble (le nombre d'éléments dans l'ensemble).
     * 
     * @return Le cardinal de l'ensemble
     */
    int cardinal();

    /**
     * Vérifie si un élément appartient à l'ensemble.
     * 
     * @param element L'élément à vérifier
     * @return true si l'élément est dans l'ensemble, false sinon
     */
    boolean contient(T element);

    /**
     * Retourne un nouvel ensemble représentant l'union de l'ensemble actuel
     * et de l'ensemble passé en paramètre.
     * 
     * @param autre L'ensemble avec lequel faire l'union
     * @return Un nouvel ensemble représentant l'union des deux ensembles
     */
    Ensemble<T> union(Ensemble<T> autre);

    /**
     * Retourne un nouvel ensemble représentant l'intersection de l'ensemble actuel
     * et de l'ensemble passé en paramètre.
     * 
     * @param autre L'ensemble avec lequel faire l'intersection
     * @return Un nouvel ensemble représentant l'intersection des deux ensembles
     */
    Ensemble<T> intersection(Ensemble<T> autre);

    /**
     * Retourne un nouvel ensemble représentant la différence entre l'ensemble actuel
     * et l'ensemble passé en paramètre (éléments présents dans l'ensemble actuel,
     * mais pas dans l'ensemble passé en paramètre).
     * 
     * @param autre L'ensemble avec lequel faire la différence
     * @return Un nouvel ensemble représentant la différence des deux ensembles
     */
    Ensemble<T> difference(Ensemble<T> autre);

    /**
     * Retourne un nouvel ensemble représentant la différence symétrique entre l'ensemble actuel
     * et l'ensemble passé en paramètre (éléments présents dans l'un ou l'autre des ensembles,
     * mais pas dans les deux).
     * 
     * @param autre L'ensemble avec lequel faire la différence symétrique
     * @return Un nouvel ensemble représentant la différence symétrique des deux ensembles
     */
    Ensemble<T> diffSymetrique(Ensemble<T> autre);

    /**
     * Retourne un ensemble de couples représentant le produit cartésien de l'ensemble actuel
     * et de l'ensemble passé en paramètre.
     * 
     * @param autre L'ensemble avec lequel faire le produit cartésien
     * @return Un ensemble de couples représentant le produit cartésien des deux ensembles
     */
    Ensemble<Couple<T, T>> produitCartesien(Ensemble<T> autre);

    /**
     * Retourne un ensemble représentant tous les éléments de l'ensemble actuel.
     * 
     * @return Un ensemble représentant tous les éléments de l'ensemble actuel
     */
    Set<T> elements();
}
