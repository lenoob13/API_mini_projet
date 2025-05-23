import ensemble.*;

import java.util.Set;
import java.util.LinkedHashSet;

public class Recette {
    public static void main(String[] args) {
        System.out.println("\n=== 1. Objectif : Créer et afficher des ensembles d'entiers ===\n");
        Set<Integer> entiersA = Set.of(1, 2, 3);
        Set<Integer> entiersB = Set.of(3, 4, 5);
        Ensemble<Integer> ensembleA = FabriqueEnsemble.creerEnsemble(entiersA);
        Ensemble<Integer> ensembleB = FabriqueEnsemble.creerEnsemble(entiersB);

        System.out.println("Ensemble A : " + ensembleA);
        System.out.println("Ensemble B : " + ensembleB);

        System.out.println("\n=== 2. Objectif : Tester les opérations ensemblistes ===\n");
        System.out.println("Union : " + ensembleA.union(ensembleB));
        System.out.println("Intersection : " + ensembleA.intersection(ensembleB));
        System.out.println("Différence A - B : " + ensembleA.difference(ensembleB));
        System.out.println("Différence symétrique : " + ensembleA.diffSymetrique(ensembleB));
        System.out.println("Produit cartésien A × B : " + ensembleA.produitCartesien(ensembleB));

        System.out.println("\n=== 3. Objectif : Créer et afficher un ensemble de chaînes de caractères ===\n");
        Set<String> chaines = Set.of("Alice", "Bob", "Charlie");
        Ensemble<String> ensembleC = FabriqueEnsemble.creerEnsemble(chaines);
        System.out.println("Ensemble de chaînes : " + ensembleC);

        System.out.println("\n=== 4. Objectif : Créer une relation binaire sur l'ensemble d'entiers ===\n");
        Set<Couple<Integer, Integer>> couples = new LinkedHashSet<>();
        
        couples.add(FabriqueCouple.creerCouple(1, 1));
        couples.add(FabriqueCouple.creerCouple(2, 2));
        couples.add(FabriqueCouple.creerCouple(3, 3));
        couples.add(FabriqueCouple.creerCouple(1, 2));
        couples.add(FabriqueCouple.creerCouple(2, 3));
        couples.add(FabriqueCouple.creerCouple(1, 3));

        Relation<Integer> relation = FabriqueRelation.creerRelation(couples);
        System.out.println("Relation : " + relation);

        System.out.println("\n=== 5. Objectif : Étudier les propriétés de la relation ===\n");
        System.out.println("Réflexive ? " + relation.estReflexive());
        System.out.println("Symétrique ? " + relation.estSymetrique());
        System.out.println("Antisymétrique ? " + relation.estAntisymetrique());
        System.out.println("Transitive ? " + relation.estTransitive());

        System.out.println("\n=== 6. Objectif : Afficher tous les éléments de la relation ===\n");
        System.out.println("Couples dans la relation :");
        for (Couple<Integer, Integer> c : relation.elements()) {
            System.out.println(" - (" + c.getPremier() + ", " + c.getDeuxieme()+")");
        }
    }
}
