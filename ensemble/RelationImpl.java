package ensemble;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import ensemble.Couple;
import ensemble.CoupleImpl;
import ensemble.Relation;

/**
 * Implémentation d'une relation binaire sur un ensemble de type T.
 * Une relation binaire est un sous-ensemble du produit cartésien E × E,
 * où E est un ensemble de type T.
 * La relation est immuable.
 *
 * @param <T> le type des éléments de l'ensemble
 */
class RelationImpl<T> implements Relation<T> {

    /**
     * L'ensemble des couples représentant la relation binaire.
     */
    private final Set<Couple<T, T>> couples;

    /**
     * Construit une relation binaire à partir d'un ensemble de couples.
     * 
     * @param couples les couples représentant les éléments de la relation
     * @throws IllegalArgumentException si l'ensemble est nul
     */
    public RelationImpl(Set<Couple<T, T>> couples) {
        if (couples == null) {
            throw new IllegalArgumentException("L'ensemble de couples ne peut pas être null.");
        }
        this.couples = new HashSet<>(couples);
    }

    /**
     * Vérifie si la relation est réflexive.
     * Une relation est réflexive si pour tout élément {@code e},
     * le couple (e, e) appartient à la relation.
     *
     * @return {@code true} si la relation est réflexive, {@code false} sinon
     */
    @Override
    public boolean estReflexive() {
        Set<T> elements = new HashSet<>();
        for (Couple<T, T> couple : couples) {
            elements.add(couple.getPremier());
            elements.add(couple.getDeuxieme());
        }
        for (T e : elements) {
            if (!couples.contains(new CoupleImpl<>(e, e))) {
                return false;
            }
        }
        return true;
    }

    /**
     * Vérifie si la relation est symétrique.
     * Une relation est symétrique si pour tout couple (a, b),
     * le couple (b, a) appartient aussi à la relation.
     *
     * @return {@code true} si la relation est symétrique, {@code false} sinon
     */
    @Override
    public boolean estSymetrique() {
        for (Couple<T, T> couple : couples) {
            Couple<T, T> inverse = new CoupleImpl<>(couple.getDeuxieme(), couple.getPremier());
            if (!couples.contains(inverse)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Vérifie si la relation est antisymétrique.
     * Une relation est antisymétrique si pour tout couple (a, b),
     * avec a ≠ b, le couple (b, a) n'appartient pas à la relation.
     *
     * @return {@code true} si la relation est antisymétrique, {@code false} sinon
     */
    @Override
    public boolean estAntisymetrique() {
        for (Couple<T, T> couple : couples) {
            T x = couple.getPremier();
            T y = couple.getDeuxieme();
            if (!x.equals(y)) {
                Couple<T, T> inverse = new CoupleImpl<>(y, x);
                if (couples.contains(inverse)) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Vérifie si la relation est transitive.
     * Une relation est transitive si pour tous les couples (a, b) et (b, c),
     * le couple (a, c) appartient aussi à la relation.
     *
     * @return {@code true} si la relation est transitive, {@code false} sinon
     */
    @Override
    public boolean estTransitive() {
        for (Couple<T, T> c1 : couples) {
            for (Couple<T, T> c2 : couples) {
                if (c1.getDeuxieme().equals(c2.getPremier())) {
                    Couple<T, T> attendu = new CoupleImpl<>(c1.getPremier(), c2.getDeuxieme());
                    if (!couples.contains(attendu)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    /**
     * Vérifie si un couple donné appartient à la relation.
     *
     * @param couple le couple à rechercher
     * @return {@code true} si le couple est présent dans la relation, {@code false} sinon
     */
    @Override
    public boolean contient(Couple<T, T> couple) {
        return couples.contains(couple);
    }

    /**
     * Retourne tous les couples de la relation.
     *
     * @return un nouvel ensemble contenant les couples de la relation
     */
    @Override
    public Set<Couple<T, T>> elements() {
        return new HashSet<>(couples);
    }

    /**
     * Vérifie si deux relations sont égales, c’est-à-dire si elles
     * contiennent exactement les mêmes couples.
     *
     * @param o l'objet à comparer
     * @return {@code true} si les relations sont égales, {@code false} sinon
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelationImpl<?> r)) return false;
        return Objects.equals(couples, r.couples);
    }

    /**
     * Calcule le hash code de la relation à partir de ses couples.
     *
     * @return le hash code de la relation
     */
    @Override
    public int hashCode() {
        return Objects.hash(couples);
    }

    /**
     * Retourne une représentation textuelle de la relation,
     * contenant l'ensemble des couples.
     *
     * @return une chaîne de caractères représentant la relation
     */
    @Override
    public String toString() {
        return "Relation{" + couples + '}';
    }
}
