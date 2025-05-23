package ensemble;
import java.util.Objects;

/**
 * Représente un couple immuable de deux éléments.
 *
 * @param <A> le type du premier élément
 * @param <B> le type du deuxième élément
 */
class CoupleImpl<A, B> implements Couple<A, B> {
	
	/** Le premier élément du couple */
	private final A premier;
	/** Le deuxième élément du couple */
	private final B deuxieme;
	
	/**
	 * Construit un couple avec les deux éléments spécifiés.
	 *
	 * @param premier Le premier élément du couple
	 * @param deuxieme Le deuxième élément du couple
	 */
	public CoupleImpl(A premier, B deuxieme) {
		this.premier = premier;
		this.deuxieme = deuxieme;
	}
	
	/**
	 * Retourne le premier élément du couple.
	 *
	 * @return le premier élément
	 */
	public A getPremier(){
		return premier;
	}

	/**
	 * Retourne le deuxième élément du couple.
	 *
	 * @return le deuxième élément
	 */
	public B getDeuxieme(){
		return deuxieme;
	}
	
	/**
	 * Vérifie si ce couple est égal à un autre objet.
	 * Deux couples sont égaux si leurs premiers et deuxièmes éléments
	 * sont respectivement égaux.
	 *
	 * @param o l'objet à comparer
	 * @return true si l'objet est un couple avec des éléments égaux, false sinon
	 */
	@Override
	public boolean equals(Object o) {
		boolean egal = false;
		// verifie que o est pas null et qu'il est de la meme classe que this
		if (o != null && o.getClass() == this.getClass()) {
			
			// ? = type quelqu'il soit car ici on peut pas mettre getPremier pr le moment
 			Couple<?, ?> couple = (Couple<?, ?>) o;

			boolean pEgal;
			if (premier == null) {
				pEgal = (couple.getPremier() == null);
			} else {
				pEgal = premier.equals(couple.getPremier()); // compares les valeurs
			}

			boolean dEgal;
			if (deuxieme == null) {
				dEgal = (couple.getDeuxieme() == null);
			} else {
				dEgal = deuxieme.equals(couple.getDeuxieme()); // idem
			}

			egal = pEgal && dEgal;
		}

		return egal;
	}
	
	/**
	 * Retourne le code de hachage de ce couple, basé sur ses éléments.
	 *
	 * @return le code de hachage
	 */
    @Override
    public int hashCode() {
        return Objects.hash(premier, deuxieme);
    }

	/**
	 * Retourne une représentation textuelle du couple.
	 *
	 * @return une chaîne représentant le couple
	 */
    @Override
    public String toString() {
        return "(" + premier + ", "+ deuxieme + ")";
    }

}
