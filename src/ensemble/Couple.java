package ensemble;
/**
 * Interface représentant un couple d'objets (A, B).
 *
 * @param <A> Le type du premier élément
 * @param <B> Le type du deuxième élément
 */
public interface Couple<A, B> {

    /**
     * Retourne le premier élément du couple.
     * 
     * @return Le premier élément
     */
    A getPremier();

    /**
     * Retourne le deuxième élément du couple.
     * 
     * @return Le deuxième élément
     */
    B getDeuxieme();
}
