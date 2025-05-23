package ensemble;

/**
 * Classe de test pour la classe CoupleImpl<A, B>.
 * Chaque méthode teste un aspect fonctionnel du couple : constructeur, getters, equals, hashCode et toString.
 */
public class TestCouple {

    /**
     * Méthode principale lançant tous les tests.
     *
     * @param args les arguments de la ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        testConstructeurEtGetters();
        testEquals();
        testHashCode();
        testToString();
    }

    /**
     * Teste le constructeur et les getters de CoupleImpl.
     */
    private static void testConstructeurEtGetters() {
        System.out.println("------------ test Constructeur et Getters ------------");

        testCasConstructeurEtGetters("a", 1, "a", 1);
        testCasConstructeurEtGetters(null, null, null, null);
    }

    /**
     * Vérifie que les getters renvoient bien les éléments passés au constructeur.
     *
     * @param premier1 valeur passée au constructeur pour le premier élément
     * @param deuxieme1 valeur passée au constructeur pour le deuxième élément
     * @param attenduPremier valeur attendue pour getPremier()
     * @param attenduDeuxieme valeur attendue pour getDeuxieme()
     */
    private static void testCasConstructeurEtGetters(Object premier1, Object deuxieme1, Object attenduPremier, Object attenduDeuxieme) {
        try {
            CoupleImpl<Object, Object> couple = new CoupleImpl<>(premier1, deuxieme1);
            if ((couple.getPremier() == attenduPremier || (couple.getPremier() != null && couple.getPremier().equals(attenduPremier))) &&
                (couple.getDeuxieme() == attenduDeuxieme || (couple.getDeuxieme() != null && couple.getDeuxieme().equals(attenduDeuxieme)))) {
                System.out.println("OK");
            } else {
                System.out.println("ECHEC du test");
            }
        } catch (Exception e) {
            System.out.println("ECHEC du test - exception levée : " + e);
        }
    }

    /**
     * Teste qu'une exception est levée lors de la création d'un couple invalide (si applicable).
     */
    private static void testCasConstructeurEtGettersException() {
        try {
            // Par exemple, un couple invalide pourrait être avec un argument interdit, ici juste pour test
            CoupleImpl<Object, Object> couple = new CoupleImpl<>(/* ici un paramètre qui doit lever exception */ null, null);
            // Si pas d'exception levée alors échec si on attend exception
            System.out.println("ECHEC du test - exception attendue non levée");
        } catch (IllegalArgumentException e) {
            System.out.println("OK - exception levée comme attendu");
        } catch (Exception e) {
            System.out.println("ECHEC du test - mauvaise exception levée : " + e);
        }
    }

    /**
     * Teste la méthode equals avec différents cas : égalité vraie, fausse, null et autres types.
     */
    private static void testEquals() {
        System.out.println("------------ test Equals ------------");

        CoupleImpl<String, Integer> c1 = new CoupleImpl<>("a", 1);
        CoupleImpl<String, Integer> c2 = new CoupleImpl<>("a", 1);
        CoupleImpl<String, Integer> c3 = new CoupleImpl<>("a", 2);
        CoupleImpl<String, Integer> c4 = new CoupleImpl<>("b", 1);
        CoupleImpl<String, Integer> c5 = new CoupleImpl<>(null, null);
        CoupleImpl<String, Integer> c6 = new CoupleImpl<>(null, null);

        testCasEquals(c1, c2, true); // mêmes éléments
        testCasEquals(c1, c3, false); // deuxième différent
        testCasEquals(c1, c4, false); // premier différent
        testCasEquals(c1, null, false); // comparaison à null
        testCasEquals(c1, "pas un couple", false); // autre type
        testCasEquals(c5, c6, true); // deux couples nuls
    }

    /**
     * Vérifie si deux couples sont considérés comme égaux selon equals.
     *
     * @param c1 premier couple à comparer
     * @param autre second objet à comparer
     * @param attendu résultat attendu (true si égal, false sinon)
     */
    private static void testCasEquals(CoupleImpl<?, ?> c1, Object autre, boolean attendu) {
        try {
            if (c1.equals(autre) == attendu) {
                System.out.println("OK");
            } else {
                System.out.println("ECHEC du test");
            }
        } catch (Exception e) {
            System.out.println("ECHEC du test - exception levée : " + e);
        }
    }

    /**
     * Teste si la méthode hashCode est cohérente avec equals.
     */
    private static void testHashCode() {
        System.out.println("------------ test HashCode ------------");

        CoupleImpl<String, Integer> c1 = new CoupleImpl<>("a", 1);
        CoupleImpl<String, Integer> c2 = new CoupleImpl<>("a", 1);
        CoupleImpl<String, Integer> c3 = new CoupleImpl<>("b", 2);

        testCasHashCode(c1, c2, true); // mêmes éléments => mêmes hash
        testCasHashCode(c1, c3, false); // éléments différents => pas forcément même hash
    }

    /**
     * Vérifie si deux objets égaux ont le même hashCode.
     *
     * @param c1 premier couple
     * @param c2 second couple
     * @param memeHash attendu : true si on attend le même hash
     */
    private static void testCasHashCode(CoupleImpl<?, ?> c1, CoupleImpl<?, ?> c2, boolean memeHash) {
        try {
            boolean memeValeur = c1.equals(c2);
            boolean hashIdentique = c1.hashCode() == c2.hashCode();
            if ((memeValeur && memeHash && hashIdentique) || (!memeHash)) {
                System.out.println("OK");
            } else {
                System.out.println("ECHEC du test");
            }
        } catch (Exception e) {
            System.out.println("ECHEC du test - exception levée : " + e);
        }
    }

    /**
     * Teste la méthode toString de CoupleImpl.
     */
    private static void testToString() {
        System.out.println("------------ test ToString ------------");

        CoupleImpl<String, Integer> c1 = new CoupleImpl<>("x", 42);
        testCasToString(c1, "( premier : x,  deuxieme : 42)");

        CoupleImpl<String, String> c2 = new CoupleImpl<>(null, "abc");
        testCasToString(c2, "( premier : null,  deuxieme : abc)");
    }

    /**
     * Vérifie que toString retourne bien la chaîne attendue.
     *
     * @param couple le couple à tester
     * @param attendu la chaîne attendue
     */
    private static void testCasToString(CoupleImpl<?, ?> couple, String attendu) {
        try {
            if (couple.toString().equals(attendu)) {
                System.out.println("OK");
            } else {
                System.out.println("ECHEC du test");
            }
        } catch (Exception e) {
            System.out.println("ECHEC du test - exception levée : " + e);
        }
    }
}
