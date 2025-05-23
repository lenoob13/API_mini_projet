package ensemble;
import java.util.HashSet;
import java.util.Set;

/**
 * Classe utilitaire permettant de créer des instances de l'interface Ensemble.
 * Cette fabrique offre une méthode statique pour encapsuler un ensemble existant (Set)
 * dans une implémentation immuable de type {@link EnsembleImpl}.
 */
public class FabriqueEnsemble {

    /**
     * Crée un nouvel objet {@link Ensemble} à partir d'un ensemble (Set) existant.
     * L'ensemble passé en paramètre est copié pour garantir l'immuabilité.
     *
     * @param <T>     Le type des éléments dans l'ensemble
     * @param elements Le Set d'éléments à encapsuler
     * @return Une instance immuable de {@link Ensemble}
     */
    public static <T> Ensemble<T> creerEnsemble(Set<T> elements) {
        return new EnsembleImpl<>(elements);
    }
}
