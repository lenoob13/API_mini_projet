package ensemble;

import java.util.HashSet;
import java.util.Set;

/**
 * Classe de test pour la classe RelationImpl<T>.
 * Elle vérifie les propriétés des relations binaires : réflexivité, symétrie, antisymétrie, transitivité,
 * ainsi que le contenu et les éléments de la relation.
 */
public class TestRelation {

    public static void main(String[] args) {
        testEstReflexive();
        testEstSymetrique();
        testEstAntisymetrique();
        testEstTransitive();
        testContient();
        testElements();
    }

    private static void testEstReflexive() {
        System.out.println("------------ test estReflexive ------------");

        Set<Couple<String, String>> couples = new HashSet<>();
        couples.add(new CoupleImpl<>("a", "a"));
        couples.add(new CoupleImpl<>("b", "b"));
        couples.add(new CoupleImpl<>("a", "b"));
        testCasEstReflexive(couples, true);

        Set<Couple<String, String>> couples2 = new HashSet<>();
        couples2.add(new CoupleImpl<>("a", "b"));
        couples2.add(new CoupleImpl<>("b", "a"));
        testCasEstReflexive(couples2, false);

        // Cas erreur
        testCasEstReflexive(null, null);
    }

    private static void testCasEstReflexive(Set<Couple<String, String>> couples, Boolean attendu) {
        try {
            Relation<String> r = new RelationImpl<>(couples);
            boolean result = r.estReflexive();
            if (attendu != null && result == attendu) {
                System.out.println("OK");
            } else if (attendu == null) {
                System.out.println("ECHEC du test - exception attendue non levée");
            } else {
                System.out.println("ECHEC du test");
            }
        } catch (IllegalArgumentException e) {
            if (attendu == null) {
                System.out.println("OK - exception levée comme attendu");
            } else {
                System.out.println("ECHEC du test - exception inattendue : " + e);
            }
        } catch (Exception e) {
            System.out.println("ECHEC du test - mauvaise exception levée : " + e);
        }
    }

    private static void testEstSymetrique() {
        System.out.println("------------ test estSymetrique ------------");

        Set<Couple<String, String>> sym = new HashSet<>();
        sym.add(new CoupleImpl<>("a", "b"));
        sym.add(new CoupleImpl<>("b", "a"));
        testCasEstSymetrique(sym, true);

        Set<Couple<String, String>> nonSym = new HashSet<>();
        nonSym.add(new CoupleImpl<>("a", "b"));
        testCasEstSymetrique(nonSym, false);

        // Cas erreur
        testCasEstSymetrique(null, null);
    }

    private static void testCasEstSymetrique(Set<Couple<String, String>> couples, Boolean attendu) {
        try {
            Relation<String> r = new RelationImpl<>(couples);
            boolean result = r.estSymetrique();
            if (attendu != null && result == attendu) {
                System.out.println("OK");
            } else if (attendu == null) {
                System.out.println("ECHEC du test - exception attendue non levée");
            } else {
                System.out.println("ECHEC du test");
            }
        } catch (IllegalArgumentException e) {
            if (attendu == null) {
                System.out.println("OK - exception levée comme attendu");
            } else {
                System.out.println("ECHEC du test - exception inattendue : " + e);
            }
        } catch (Exception e) {
            System.out.println("ECHEC du test - mauvaise exception levée : " + e);
        }
    }

    private static void testEstAntisymetrique() {
        System.out.println("------------ test estAntisymetrique ------------");

        Set<Couple<String, String>> antisym = new HashSet<>();
        antisym.add(new CoupleImpl<>("a", "a"));
        antisym.add(new CoupleImpl<>("b", "b"));
        antisym.add(new CoupleImpl<>("a", "b"));
        testCasEstAntisymetrique(antisym, true);

        Set<Couple<String, String>> nonAntisym = new HashSet<>();
        nonAntisym.add(new CoupleImpl<>("a", "b"));
        nonAntisym.add(new CoupleImpl<>("b", "a"));
        testCasEstAntisymetrique(nonAntisym, false);

        // Cas erreur
        testCasEstAntisymetrique(null, null);
    }

    private static void testCasEstAntisymetrique(Set<Couple<String, String>> couples, Boolean attendu) {
        try {
            Relation<String> r = new RelationImpl<>(couples);
            boolean result = r.estAntisymetrique();
            if (attendu != null && result == attendu) {
                System.out.println("OK");
            } else if (attendu == null) {
                System.out.println("ECHEC du test - exception attendue non levée");
            } else {
                System.out.println("ECHEC du test");
            }
        } catch (IllegalArgumentException e) {
            if (attendu == null) {
                System.out.println("OK - exception levée comme attendu");
            } else {
                System.out.println("ECHEC du test - exception inattendue : " + e);
            }
        } catch (Exception e) {
            System.out.println("ECHEC du test - mauvaise exception levée : " + e);
        }
    }

    private static void testEstTransitive() {
        System.out.println("------------ test estTransitive ------------");

        Set<Couple<String, String>> transitive = new HashSet<>();
        transitive.add(new CoupleImpl<>("a", "b"));
        transitive.add(new CoupleImpl<>("b", "c"));
        transitive.add(new CoupleImpl<>("a", "c"));
        testCasEstTransitive(transitive, true);

        Set<Couple<String, String>> nonTransitive = new HashSet<>();
        nonTransitive.add(new CoupleImpl<>("a", "b"));
        nonTransitive.add(new CoupleImpl<>("b", "c"));
        testCasEstTransitive(nonTransitive, false);

        // Cas erreur
        testCasEstTransitive(null, null);
    }

    private static void testCasEstTransitive(Set<Couple<String, String>> couples, Boolean attendu) {
        try {
            Relation<String> r = new RelationImpl<>(couples);
            boolean result = r.estTransitive();
            if (attendu != null && result == attendu) {
                System.out.println("OK");
            } else if (attendu == null) {
                System.out.println("ECHEC du test - exception attendue non levée");
            } else {
                System.out.println("ECHEC du test");
            }
        } catch (IllegalArgumentException e) {
            if (attendu == null) {
                System.out.println("OK - exception levée comme attendu");
            } else {
                System.out.println("ECHEC du test - exception inattendue : " + e);
            }
        } catch (Exception e) {
            System.out.println("ECHEC du test - mauvaise exception levée : " + e);
        }
    }

    private static void testContient() {
        System.out.println("------------ test contient ------------");

        Set<Couple<String, String>> couples = new HashSet<>();
        Couple<String, String> c = new CoupleImpl<>("a", "b");
        couples.add(c);
        Relation<String> r = new RelationImpl<>(couples);

        testCasContient(r, c, true);
        testCasContient(r, new CoupleImpl<>("b", "a"), false);

        // Pas de test d'exception ici car contient() ne lance pas d'exception selon l'implémentation
    }

    private static void testCasContient(Relation<String> r, Couple<String, String> couple, boolean attendu) {
        if (r.contient(couple) == attendu) {
            System.out.println("OK");
        } else {
            System.out.println("ECHEC du test");
        }
    }

    private static void testElements() {
        System.out.println("------------ test elements ------------");

        Set<Couple<String, String>> couples = new HashSet<>();
        couples.add(new CoupleImpl<>("x", "x"));
        couples.add(new CoupleImpl<>("x", "y"));
        Relation<String> r = new RelationImpl<>(couples);

        testCasElements(r, couples);

        // Pas de test d'exception ici car elements() ne lance pas d'exception selon l'implémentation
    }

    private static void testCasElements(Relation<String> r, Set<Couple<String, String>> attendu) {
        if (r.elements().equals(attendu)) {
            System.out.println("OK");
        } else {
            System.out.println("ECHEC du test");
        }
    }
}
