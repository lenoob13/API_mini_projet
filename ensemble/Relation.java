package ensemble;

import java.util.Set;

/**
 * Interface générique représentant une relation binaire immuable sur un ensemble de type T.
 * Une relation binaire R sur un ensemble E est une partie du produit cartésien E × E.
 * 
 * Cette interface offre des méthodes pour tester les propriétés classiques des relations binaires :
 * réflexivité, symétrie, anti-symétrie et transitivité.
 * Elle permet également de vérifier l'appartenance d'un couple à la relation
 * et d'accéder à l'ensemble des couples qui constituent la relation.
 *
 * @param <T> Le type des éléments sur lesquels porte la relation
 */
public interface Relation<T> {

    /**
     * Détermine si la relation est réflexive.
     * Une relation est réflexive si pour tout élément x de l'ensemble, le couple (x, x) appartient à la relation.
     * 
     * @return true si la relation est réflexive, false sinon
     */
    boolean estReflexive();

    /**
     * Détermine si la relation est symétrique.
     * Une relation est symétrique si pour tout couple (a, b) dans la relation, le couple (b, a) est aussi dans la relation.
     * 
     * @return true si la relation est symétrique, false sinon
     */
    boolean estSymetrique();

    /**
     * Détermine si la relation est anti-symétrique.
     * Une relation est anti-symétrique si pour tous couples (a, b) et (b, a) dans la relation,
     * on a nécessairement a = b.
     * 
     * @return true si la relation est anti-symétrique, false sinon
     */
    boolean estAntisymetrique();

    /**
     * Détermine si la relation est transitive.
     * Une relation est transitive si pour tous couples (a, b) et (b, c) dans la relation,
     * le couple (a, c) appartient aussi à la relation.
     * 
     * @return true si la relation est transitive, false sinon
     */
    boolean estTransitive();

    /**
     * Vérifie si un couple appartient à la relation.
     * 
     * @param couple Le couple à vérifier
     * @return true si le couple appartient à la relation, false sinon
     */
    boolean contient(Couple<T, T> couple);

    /**
     * Retourne l'ensemble immuable des couples qui composent la relation.
     * 
     * @return Un ensemble de couples représentant la relation binaire
     */
    Set<Couple<T, T>> elements();
}
