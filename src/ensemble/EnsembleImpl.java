package ensemble;

import java.util.HashSet;
import java.util.Set;

/**
 * Implémentation concrète de l'interface Ensemble.
 * Cette classe représente un ensemble mathématique contenant des éléments distincts du même type.
 * L'ensemble est immuable, donc une fois créé, il ne peut pas être modifié.
 *
 * @param <T> Le type des éléments dans l'ensemble
 */
class EnsembleImpl<T> implements Ensemble<T> {

    /**
     * Les éléments de l'ensemble, stockés dans une structure de type Set.
     */
    private final Set<T> elements;

    /**
     * Constructeur pour créer un ensemble à partir d'un Set d'éléments.
     *
     * @param elements Le Set des éléments à mettre dans l'ensemble
     * @throws IllegalArgumentException si le Set est null
     */
    public EnsembleImpl(Set<T> elements) throws IllegalArgumentException {
        if (elements == null) {
            throw new IllegalArgumentException("L'ensemble ne peut pas être null");
        }
        // Copie défensive pour garantir l'immuabilité
        this.elements = new HashSet<>(elements);
    }

    /**
     * Retourne le nombre d'éléments dans l'ensemble.
     *
     * @return le cardinal de l'ensemble
     */
    @Override
    public int cardinal() {
        return elements.size();
    }

    /**
     * Vérifie si un élément donné appartient à l'ensemble.
     *
     * @param element l'élément à rechercher
     * @return {@code true} si l'élément est présent, {@code false} sinon
     */
    @Override
    public boolean contient(T element) {
        return elements.contains(element);
    }

    /**
     * Retourne l'union de cet ensemble avec un autre ensemble.
     *
     * @param autre l'autre ensemble à unir
     * @return un nouvel ensemble représentant l'union des deux
     * @throws IllegalArgumentException si l'autre ensemble n'est pas une instance compatible
     */
    @Override
    public Ensemble<T> union(Ensemble<T> autre) throws IllegalArgumentException {
        if (autre instanceof EnsembleImpl) {
            Set<T> union = new HashSet<>(this.elements);
            union.addAll(((EnsembleImpl<T>) autre).elements);
            return new EnsembleImpl<>(union);
        } else {
            throw new IllegalArgumentException("L'ensemble passé en paramètre n'est pas compatible.");
        }
    }

    /**
     * Retourne l'intersection de cet ensemble avec un autre.
     *
     * @param autre l'autre ensemble avec lequel faire l'intersection
     * @return un nouvel ensemble contenant les éléments communs
     * @throws IllegalArgumentException si l'autre ensemble n'est pas une instance compatible
     */
    @Override
    public Ensemble<T> intersection(Ensemble<T> autre) throws IllegalArgumentException {
        if (autre instanceof EnsembleImpl) {
            Set<T> intersection = new HashSet<>(this.elements);
            intersection.retainAll(((EnsembleImpl<T>) autre).elements);
            return new EnsembleImpl<>(intersection);
        } else {
            throw new IllegalArgumentException("L'ensemble passé en paramètre n'est pas compatible.");
        }
    }

    /**
     * Retourne la différence entre cet ensemble et un autre.
     *
     * @param autre l'autre ensemble à soustraire
     * @return un nouvel ensemble contenant les éléments de cet ensemble qui ne sont pas dans l'autre
     * @throws IllegalArgumentException si l'autre ensemble n'est pas une instance compatible
     */
    @Override
    public Ensemble<T> difference(Ensemble<T> autre) throws IllegalArgumentException {
        if (autre instanceof EnsembleImpl) {
            Set<T> difference = new HashSet<>(this.elements);
            difference.removeAll(((EnsembleImpl<T>) autre).elements);
            return new EnsembleImpl<>(difference);
        } else {
            throw new IllegalArgumentException("L'ensemble passé en paramètre n'est pas compatible.");
        }
    }

    /**
     * Retourne la différence symétrique entre cet ensemble et un autre.
     * Elle contient les éléments présents dans un seul des deux ensembles.
     * (xOr)
     * 
     * @param autre l'autre ensemble à comparer
     * @return un nouvel ensemble représentant la différence symétrique
     * @throws IllegalArgumentException si l'autre ensemble n'est pas une instance compatible
     */
    @Override
    public Ensemble<T> diffSymetrique(Ensemble<T> autre) throws IllegalArgumentException {
        if (autre instanceof EnsembleImpl) {
            Set<T> diff1 = new HashSet<>(this.elements);
            diff1.removeAll(((EnsembleImpl<T>) autre).elements);

            Set<T> diff2 = new HashSet<>(((EnsembleImpl<T>) autre).elements);
            diff2.removeAll(this.elements);

            diff1.addAll(diff2);
            return new EnsembleImpl<>(diff1);
        } else {
            throw new IllegalArgumentException("L'ensemble passé en paramètre n'est pas compatible.");
        }
    }

    /**
     * Calcule le produit cartésien de cet ensemble avec un autre ensemble.
     *
     * @param autre l'autre ensemble à utiliser pour le produit cartésien
     * @return un nouvel ensemble de couples représentant le produit cartésien
     */
    @Override
    public Ensemble<Couple<T, T>> produitCartesien(Ensemble<T> autre) {
        Set<Couple<T, T>> resultat = new HashSet<>();
        for (T a : this.elements) {
            for (T b : autre.elements()) {
                resultat.add(new CoupleImpl<>(a, b));
            }
        }
        return new EnsembleImpl<>(resultat);
    }

    /**
     * Retourne une copie des éléments contenus dans l'ensemble.
     *
     * @return un {@link Set} contenant tous les éléments
     */
    @Override
    public Set<T> elements() {
        return new HashSet<>(this.elements);
    }

    /**
     * Retourne une représentation textuelle de l'ensemble.
     * Les éléments sont affichés entre accolades, séparés par des virgules.
     *
     * @return une chaîne de caractères représentant l'ensemble
     */
    @Override
    public String toString(){
        String str=new String();
        str+="{";
        boolean first = true;
        for (T el:elements){
            if (first){
                first=false;
            }else{
                str+=", ";
            }
            str+=el.toString();
        }
        str+="}";
        return str;
    }
}
