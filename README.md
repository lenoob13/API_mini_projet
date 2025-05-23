# 📚 Projet Ensembles, Relations et Couples en Java

Bienvenue dans ce projet Java qui implémente une API pour manipuler des **ensembles mathématiques**, des **relations binaires** et des **couples génériques**.

---

## 🚀 Fonctionnalités principales

- **Couple\<A, B\>** : représentation générique d’un couple de deux éléments (types différents ou identiques)  
- **Ensemble\<T\>** : interface et implémentation d’un ensemble mathématique immuable, avec opérations classiques :  
  - union  
  - intersection  
  - différence  
  - différence symétrique  
  - produit cartésien  
- **Relation\<T\>** : relation binaire immuable sur un ensemble, avec vérification des propriétés :  
  - réflexivité  
  - symétrie  
  - antisymétrie  
  - transitivité  
- **Recette** : classe de démonstration / test principal, montre l’usage des ensembles et relations sur différents types (entiers, chaînes, etc.)

---

## 🗂 Structure du projet

```

src/
├── ensemble/
│   ├── Couple.java
│   ├── CoupleImpl.java
│   ├── Ensemble.java
│   ├── EnsembleImpl.java
│   ├── Relation.java
│   ├── RelationImpl.java
│   ├── FabriqueCouple.java
│   ├── FabriqueEnsemble.java
│   ├── FabriqueRelation.java
│   ├── TestCouple.java
│   ├── TestEnsemble.java
│   └── TestRelation.java
└── Recette.java

````

---

## 💡 Comment utiliser ?

1. **Compilation**

```bash
javac src/ensemble/*.java src/Recette.java
````

2. **Exécution**

```bash
java -cp src Recette
```

---

## 🧪 Tests

* Les classes de tests (`TestCouple`, `TestEnsemble`, `TestRelation`) sont incluses dans le package `ensemble`.
* Les tests sont simples, sans framework (JUnit non utilisé).
* Ils couvrent création, opérations et vérifications des invariants.

---

## 📑 Diagramme de classe

* J'ai mit le diagramme de classe pour aider à mieux visualiser l'ensemble de la structure du programme.

---

## 🛠️ Technologies

* Java 11+ (compatible avec versions récentes)
* Collections Java standard (`Set`, `HashSet`)
* Utilisation des génériques Java

---

## 📄 Licence

Ce projet est libre et open source. N’hésitez pas à l’utiliser, modifier et partager !

---

## 🤝 Contact

Pour toute question ou suggestion, contactez-moi !

---

✨ Merci d’avoir consulté ce projet ! Amusez-vous bien avec les ensembles et relations mathématiques en Java ! ✨

````

