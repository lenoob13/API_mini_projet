package ensemble;

import java.util.Set;

/**
 * Fabrique utilitaire permettant de créer des relations binaires immuables.
 * Cette classe fournit une méthode statique pour encapsuler un ensemble de couples 
 * dans une implémentation de l'interface {@link Relation}.
 */
public class FabriqueRelation {

    /**
     * Crée une relation binaire immuable à partir d'un ensemble de couples.
     *
     * @param <T> Le type des éléments contenus dans les couples
     * @param couples L'ensemble des couples représentant la relation
     * @return Une instance de {@link Relation} représentant la relation binaire
     */
    public static <T> Relation<T> creerRelation(Set<Couple<T, T>> couples) {
        return new RelationImpl<>(couples);
    }
}
