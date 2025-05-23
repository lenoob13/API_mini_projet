package ensemble;

/**
 * Fabrique utilitaire permettant de créer des couples d'éléments.
 * Cette classe fournit une méthode statique pour créer une instance de {@link Couple}.
 */
public class FabriqueCouple {

    /**
     * Crée un couple à partir de deux éléments.
     *
     * @param <A> Le type du premier élément du couple
     * @param <B> Le type du deuxième élément du couple
     * @param premier Le premier élément du couple
     * @param deuxieme Le deuxième élément du couple
     * @return Une instance de {@link Couple} contenant les deux éléments fournis
     */
    public static <A,B> Couple<A,B> creerCouple(A premier, B deuxieme) {
        return new CoupleImpl<>(premier, deuxieme);
    }
}
