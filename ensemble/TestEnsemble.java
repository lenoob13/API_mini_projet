package ensemble;

import java.util.Set;
import java.util.HashSet;

/**
 * Classe de test pour l'interface Ensemble<T> et son implémentation EnsembleImpl<T>.
 * Chaque méthode principale est testée en cas normal et en cas d'erreur si pertinent.
 */
public class TestEnsemble {

    public static void main(String[] args) {
        testConstructeur();
        testCardinal();
        testContient();
        testUnion();
        testIntersection();
        testDifference();
        testDiffSymetrique();
        testProduitCartesien();
        testElements();
    }

    private static void testConstructeur() {
        System.out.println("---- test Constructeur ----");
        System.out.println("Cas normal:");
        Set<String> data = new HashSet<>();
        data.add("a");
        data.add("b");
        testConstructeurCas(data, false);

        System.out.println("Cas erreur (null):");
        testConstructeurCas(null, true);
    }

    private static void testConstructeurCas(Set<String> data, boolean shouldFail) {
        try {
            Ensemble<String> ens = new EnsembleImpl<>(data);
            if (!shouldFail) {
                System.out.println("OK");
            } else {
                System.out.println("ECHEC du test (exception attendue)");
            }
        } catch (IllegalArgumentException e) {
            if (shouldFail) {
                System.out.println("OK");
            } else {
                System.out.println("ECHEC du test (exception non attendue)");
            }
        }
    }

    private static void testCardinal() {
        System.out.println("---- test Cardinal ----");
        Set<String> data = new HashSet<>();
        data.add("a");
        data.add("b");
        Ensemble<String> ens = new EnsembleImpl<>(data);
        if (ens.cardinal() == 2) {
            System.out.println("OK");
        } else {
            System.out.println("ECHEC du test");
        }
    }

    private static void testContient() {
        System.out.println("---- test Contient ----");
        Set<String> data = new HashSet<>();
        data.add("a");
        data.add("b");
        Ensemble<String> ens = new EnsembleImpl<>(data);
        testContientCas(ens, "a", true);
        testContientCas(ens, "c", false);
    }

    private static void testContientCas(Ensemble<String> ens, String elt, boolean expected) {
        if (ens.contient(elt) == expected) {
            System.out.println("OK");
        } else {
            System.out.println("ECHEC du test");
        }
    }

    private static void testUnion() {
        System.out.println("---- test Union ----");
        Set<Integer> s1 = Set.of(1, 2);
        Set<Integer> s2 = Set.of(2, 3);
        Ensemble<Integer> e1 = new EnsembleImpl<>(s1);
        Ensemble<Integer> e2 = new EnsembleImpl<>(s2);

        Set<Integer> attendu = Set.of(1, 2, 3);
        testUnionCas(e1, e2, attendu, false);

        System.out.println("Cas erreur (null):");
        testUnionCas(e1, null, attendu, true);
    }

    private static void testUnionCas(Ensemble<Integer> e1, Ensemble<Integer> e2, Set<Integer> attendu, boolean shouldFail) {
        try {
            Ensemble<Integer> res = e1.union(e2);
            boolean ok = res.cardinal() == attendu.size();
            for (int i : attendu) {
                if (!res.contient(i)) {
                    ok = false;
                    break;
                }
            }
            if (ok && !shouldFail) {
                System.out.println("OK");
            } else if (shouldFail) {
                System.out.println("ECHEC du test (exception attendue)");
            } else {
                System.out.println("ECHEC du test (résultat incorrect)");
            }
        } catch (IllegalArgumentException e) {
            if (shouldFail) {
                System.out.println("OK");
            } else {
                System.out.println("ECHEC du test (exception non attendue)");
            }
        }
    }

    private static void testIntersection() {
        System.out.println("---- test Intersection ----");
        Set<Integer> s1 = Set.of(1, 2);
        Set<Integer> s2 = Set.of(2, 3);
        Ensemble<Integer> e1 = new EnsembleImpl<>(s1);
        Ensemble<Integer> e2 = new EnsembleImpl<>(s2);

        Set<Integer> attendu = Set.of(2);
        testIntersectionCas(e1, e2, attendu, false);

        System.out.println("Cas erreur (null):");
        testIntersectionCas(e1, null, attendu, true);
    }

    private static void testIntersectionCas(Ensemble<Integer> e1, Ensemble<Integer> e2, Set<Integer> attendu, boolean shouldFail) {
        try {
            Ensemble<Integer> res = e1.intersection(e2);
            boolean ok = res.cardinal() == attendu.size();
            for (int i : attendu) {
                if (!res.contient(i)) {
                    ok = false;
                    break;
                }
            }
            if (ok && !shouldFail) {
                System.out.println("OK");
            } else if (shouldFail) {
                System.out.println("ECHEC du test (exception attendue)");
            } else {
                System.out.println("ECHEC du test (résultat incorrect)");
            }
        } catch (IllegalArgumentException e) {
            if (shouldFail) {
                System.out.println("OK");
            } else {
                System.out.println("ECHEC du test (exception non attendue)");
            }
        }
    }

    private static void testDifference() {
        System.out.println("---- test Difference ----");
        Set<Integer> s1 = Set.of(1, 2);
        Set<Integer> s2 = Set.of(2, 3);
        Ensemble<Integer> e1 = new EnsembleImpl<>(s1);
        Ensemble<Integer> e2 = new EnsembleImpl<>(s2);

        Set<Integer> attendu = Set.of(1);
        testDifferenceCas(e1, e2, attendu, false);

        System.out.println("Cas erreur (null):");
        testDifferenceCas(e1, null, attendu, true);
    }

    private static void testDifferenceCas(Ensemble<Integer> e1, Ensemble<Integer> e2, Set<Integer> attendu, boolean shouldFail) {
        try {
            Ensemble<Integer> res = e1.difference(e2);
            boolean ok = res.cardinal() == attendu.size();
            for (int i : attendu) {
                if (!res.contient(i)) {
                    ok = false;
                    break;
                }
            }
            if (ok && !shouldFail) {
                System.out.println("OK");
            } else if (shouldFail) {
                System.out.println("ECHEC du test (exception attendue)");
            } else {
                System.out.println("ECHEC du test (résultat incorrect)");
            }
        } catch (IllegalArgumentException e) {
            if (shouldFail) {
                System.out.println("OK");
            } else {
                System.out.println("ECHEC du test (exception non attendue)");
            }
        }
    }

    private static void testDiffSymetrique() {
        System.out.println("---- test Différence Symétrique ----");
        Set<Integer> s1 = Set.of(1, 2);
        Set<Integer> s2 = Set.of(2, 3);
        Ensemble<Integer> e1 = new EnsembleImpl<>(s1);
        Ensemble<Integer> e2 = new EnsembleImpl<>(s2);

        Set<Integer> attendu = Set.of(1, 3);
        testDiffSymetriqueCas(e1, e2, attendu, false);

        System.out.println("Cas erreur (null):");
        testDiffSymetriqueCas(e1, null, attendu, true);
    }

    private static void testDiffSymetriqueCas(Ensemble<Integer> e1, Ensemble<Integer> e2, Set<Integer> attendu, boolean shouldFail) {
        try {
            Ensemble<Integer> res = e1.diffSymetrique(e2);
            boolean ok = res.cardinal() == attendu.size();
            for (int i : attendu) {
                if (!res.contient(i)) {
                    ok = false;
                    break;
                }
            }
            if (ok && !shouldFail) {
                System.out.println("OK");
            } else if (shouldFail) {
                System.out.println("ECHEC du test (exception attendue)");
            } else {
                System.out.println("ECHEC du test (résultat incorrect)");
            }
        } catch (IllegalArgumentException e) {
            if (shouldFail) {
                System.out.println("OK");
            } else {
                System.out.println("ECHEC du test (exception non attendue)");
            }
        }
    }

    private static void testProduitCartesien() {
        System.out.println("---- test Produit Cartesien ----");
        Set<Integer> s1 = Set.of(1, 2);
        Set<Integer> s2 = Set.of(3, 4);
        Ensemble<Integer> e1 = new EnsembleImpl<>(s1);
        Ensemble<Integer> e2 = new EnsembleImpl<>(s2);

        Set<Couple<Integer, Integer>> attendu = new HashSet<>();
        attendu.add(new CoupleImpl<>(1, 3));
        attendu.add(new CoupleImpl<>(1, 4));
        attendu.add(new CoupleImpl<>(2, 3));
        attendu.add(new CoupleImpl<>(2, 4));

        Ensemble<Couple<Integer, Integer>> res = e1.produitCartesien(e2);
        boolean ok = res.cardinal() == attendu.size();
        for (Couple<Integer, Integer> c : attendu) {
            if (!res.contient(c)) {
                ok = false;
                break;
            }
        }
        if (ok) {
            System.out.println("OK");
        } else {
            System.out.println("ECHEC du test");
        }
    }

    private static void testElements() {
        System.out.println("---- test Elements (copie défensive) ----");
        Set<String> s = Set.of("x", "y");
        Ensemble<String> e = new EnsembleImpl<>(s);

        Set<String> res = e.elements();
        if (res.size() == s.size() && res.containsAll(s)) {
            System.out.println("OK");
        } else {
            System.out.println("ECHEC du test");
        }

        // Test copie défensive : modification de res ne doit pas affecter e
        res.clear();
        if (e.cardinal() == s.size()) {
            System.out.println("OK (copie défensive)");
        } else {
            System.out.println("ECHEC (copie non défensive)");
        }
    }
}
